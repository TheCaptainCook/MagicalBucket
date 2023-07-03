package thecaptaincook.magicalbucket.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.utils.colorTranslate;
import thecaptaincook.magicalbucket.recipe.magicalCodBucketRecipe;

public class magicalCodBucketSummoner implements CommandExecutor {

    private final MagicalBucket plugin;

    public magicalCodBucketSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (plugin.getConfig().getBoolean("cod_bucket.active")){
                if (player.hasPermission("magical_cod_bucket.admin")){
                    if (command.getName().equalsIgnoreCase("mcb")|| command.getName().equalsIgnoreCase("magicalcodbucket")){
                        switch (strings.length){
                            case 2:
                                if (strings[0].equalsIgnoreCase("reload")){
                                    if (player.hasPermission("magical_cod_bucket.reloadConfig")){
                                        plugin.reloadConfig();
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                    }else{
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                    }
                                }else{
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                                    break;
                                }
                                break;
                            case 3:
                                if (strings[0].equalsIgnoreCase("give")){
                                    if (player.hasPermission("give")){
                                        Player target = player.getServer().getPlayer(strings[1]);
                                        if (target == null){
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Player not found!"));
                                        }else{
                                            Inventory targetInventory = target.getInventory();
                                            ItemStack magicalCod = new magicalCodBucketRecipe(plugin).magicalCodRecipe();
                                            targetInventory.addItem(magicalCod);
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + target.getName() + " §7a magical cod bucket!"));
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a magical cod bucket!"));
                                            break;
                                        }
                                    }else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else{
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                                }
                                break;
                            default:
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                                break;
                        }
                    }else {
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                        return true;
                    }
                }else{
                    player.sendMessage(colorTranslate.translateStringColor("&c§6§lMagical Bucket §8» &cYou do not have permission to use this command!"));
                    return true;
                }
            }else {
                player.sendMessage(colorTranslate.translateStringColor("&c§6§lMagical Bucket §8» &cThis feature is disabled in the config!"));
                return true;
            }
        } else {
            commandSender.sendMessage(colorTranslate.translateStringColor("&c§6§lMagical Bucket §8» You must be a player to use this command"));
            return true;
        }
        return true;
    }
}
