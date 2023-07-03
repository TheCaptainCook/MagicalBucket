package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicalMilkBucketRecipe;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalMilkBucketSummoner implements CommandExecutor {

    private final MagicalBucket plugin;
    public magicalMilkBucketSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("milk_bucket.active")){
                if (player.hasPermission("milk_bucket.player_permission")){
                    if (command.getName().equalsIgnoreCase("mmb") || command.getName().equalsIgnoreCase("magicalmilkbucket")){
                        switch(strings.length) {
                            case 2:
                                if (strings[0].equalsIgnoreCase("reload")) {
                                    if (player.hasPermission("milk_bucket.config_reload")) {
                                        plugin.reloadConfig();
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalmilkbucket give <player>"));
                                    break;
                                }
                                break;
                            case 3:
                                if (strings[0].equalsIgnoreCase("give")){
                                    if (player.hasPermission("milk_bucket.give_bucket")){
                                        Player targetPlayer = Bukkit.getPlayer(strings[1]);
                                        if (targetPlayer == null){
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7That player is not online!"));
                                            break;
                                        }else {
                                            Inventory targetInventory = targetPlayer.getInventory();
                                            ItemStack magicalMilk = new magicalMilkBucketRecipe(plugin).magicalMilkRecipe();
                                            targetInventory.addItem(magicalMilk);
                                            targetPlayer.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + targetPlayer.getName() + " §7a magical milk bucket!"));
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a magical milk bucket!"));
                                            break;
                                        }
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalmilkbucket give <player>"));
                                }
                                break;
                            default:
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalmilkbucket give <player>"));
                                break;
                        }
                    }else{
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalmilkbucket give <player>"));
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
