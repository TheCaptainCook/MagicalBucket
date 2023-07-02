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

public class magicalLavaBucketSummoner implements CommandExecutor {

    private final MagicalBucket plugin;

    public magicalLavaBucketSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (commandSender.hasPermission("magical_lava_bucket.admin")) {
                if (command.getName().equalsIgnoreCase("mlb") || command.getName().equalsIgnoreCase("magicallavabucket")) {
                    if (strings.length == 0) {
                        player.sendMessage("§6§HHey there! §7You can use the following commands:");
                        player.sendMessage("§6§lMagical Bucket §8» §7/magicallavabucket give <player>");
                        return true;
                    } else if (strings.length == 1) {
                        if (strings[0].equalsIgnoreCase("reload")) {
                            if (player.hasPermission("magical_lava_bucket.reload")) {
                                plugin.reloadConfig();
                                player.sendMessage("§6§lMagical Bucket §8» §7Config reloaded!");
                            } else {
                                player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                                return true;
                            }
                        } else {
                            player.sendMessage("§6§HHey there! §7You can use the following commands:");
                            player.sendMessage("§6§lMagical Bucket §8» §7/magicallavabucket give <player>");
                            return true;
                        }
                    } else if (strings.length == 2) {
                        if (strings[0].equalsIgnoreCase("give")) {
                            if (player.hasPermission("magical_lava_bucket.give")) {
                                Player target = Bukkit.getPlayerExact(strings[1]);
                                if (target == null) {
                                    player.sendMessage("§6§lMagical Bucket §8» §7That player is not online!");
                                    return true;
                                } else {
                                    Inventory targetInventory = target.getInventory();
                                    ItemStack magicalLavaBucket = new magicalLavaBucketRecipe(plugin).magicalLavaBucket();
                                    targetInventory.addItem(magicalLavaBucket);
                                    player.sendMessage("§6§lMagical Bucket §8» §7You have given §6" + target.getName() + " §7a §6Magical Water Bucket§7!");
                                    target.sendMessage("§6§lMagical Bucket §8» §7You have been given a §6Magical Water Bucket§7!");
                                    return true;
                                }
                            } else {
                                player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                                return true;
                            }
                        } else {
                            player.sendMessage("§6§HHey there! §7You can use the following commands:");
                            player.sendMessage("§6§lMagical Bucket §8» §7/magicallavabucket give <player>");
                            return true;
                        }
                    } else {
                        player.sendMessage("§6§HHey there! §7You can use the following commands:");
                        player.sendMessage("§6§lMagical Bucket §8» §7/magicallavabucket give <player>");
                        return true;
                    }
                }
            } else {
                player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                return true;
            }
        } else{
            commandSender.sendMessage("§6§lMagical Bucket §8» §7You must be a player to use this command!");
            return true;
        }
        return true;
    }
}
