package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicalSalmonBucketRecipe;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalSamonBucketSummoner implements CommandExecutor {
    private final MagicalBucket plugin;

    public magicalSamonBucketSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("salmon_bucket.active")){
                if (player.hasPermission("salmon_bucket.player_permission")){
                    if (command.getName().equalsIgnoreCase("msb") || command.getName().equalsIgnoreCase("magicalsalmonbucket")){
                        switch(strings.length) {
                            case 2:
                                if (strings[0].equalsIgnoreCase("reload")) {
                                    if (player.hasPermission("salmon_bucket.config_reload")) {
                                        plugin.reloadConfig();
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalsalmonbucket give <player>"));
                                    break;
                                }
                                break;
                            case 3:
                                if (strings[0].equalsIgnoreCase("give")){
                                    if (player.hasPermission("salmon_bucket.give_bucket")){
                                        Player targetPlayer = Bukkit.getPlayer(strings[1]);
                                        if (targetPlayer == null){
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7That player is not online!"));
                                            break;
                                        }else {
                                            Inventory targetInventory = targetPlayer.getInventory();
                                            ItemStack salmonBucket = new magicalSalmonBucketRecipe(plugin).magicalSalmonRecipe();
                                            targetInventory.addItem(salmonBucket);
                                            targetPlayer.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + targetPlayer.getName() + " §7a Magical Salmon bucket!"));
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a Magical Salmon bucket!"));
                                            break;
                                        }
                                    } else {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                        break;
                                    }
                                }else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalsalmonbucket give <player>"));
                                }
                                break;
                            default:
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalsalmonbucket give <player>"));
                                break;
                        }
                    }else{
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalsalmonbucket give <player>"));
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
