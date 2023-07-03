package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicalLavaBucketRecipe;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalLavaBucketSummoner implements CommandExecutor {

    private final MagicalBucket plugin;

    public magicalLavaBucketSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("lava_bucket.active")){
                if (player.hasPermission("magical_lava_bucket.admin")){
                    if (command.getName().equalsIgnoreCase("mlb") || command.getName().equalsIgnoreCase("magicallavabucket")){
                        switch(strings.length) {
                            case 2:
                                if (strings[0].equalsIgnoreCase("reload")) {
                                    if (player.hasPermission("magical_lava_bucket.reloadConfig")) {
                                        plugin.reloadConfig();
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                                    break;
                                }
                                break;
                            case 3:
                                if (strings[0].equalsIgnoreCase("give")){
                                    if (player.hasPermission("give.allow")){
                                        Player targetPlayer = Bukkit.getPlayer(strings[1]);
                                        if (targetPlayer == null){
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7That player is not online!"));
                                            break;
                                        }else {
                                            Inventory targetInventory = targetPlayer.getInventory();
                                            ItemStack magicalLavaBucket = new magicalLavaBucketRecipe(plugin).magicalLavaRecipe();
                                            targetInventory.addItem(magicalLavaBucket);
                                            targetPlayer.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + targetPlayer.getName() + " §7a magical lava bucket!"));
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a magical lava bucket!"));
                                            break;
                                        }
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                                }
                                break;
                            default:
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                                break;
                        }
                    }else{
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                        return true;
                    }
                }else {
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                    return true;
                }
            }else {
                commandSender.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7This recipe is disabled!"));
                return true;
            }
        }else{
            commandSender.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You must be a player to use this command!"));
            return true;
        }
        return true;
    }
}
