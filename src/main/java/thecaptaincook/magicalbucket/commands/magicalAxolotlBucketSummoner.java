package thecaptaincook.magicalbucket.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicalAxolotlBucketRecipe;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalAxolotlBucketSummoner implements CommandExecutor {

    private final MagicalBucket plugin;

    public magicalAxolotlBucketSummoner(MagicalBucket plugin) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("axolotl_bucket.active")) {
                if (player.hasPermission("magical_axolotl_bucket.admin")) {
                    if (command.getName().equalsIgnoreCase("maxb") || command.getName().equalsIgnoreCase("magicalaxolotlbucket")) {
                        if (strings.length == 0) {
                            player.sendMessage("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:");
                            player.sendMessage("§6§lMagical Bucket §8» §7Use /magicalaxolotlbucket give <player>");
                            return true;
                        } else if (strings.length == 1) {
                            if (strings[0].equalsIgnoreCase("reload")) {
                                if (player.hasPermission("magical_axolotl_bucket.reloadConfig")) {
                                    plugin.reloadConfig();
                                    player.sendMessage("§6§lMagical Bucket §8» §7Config reloaded!");
                                } else {
                                    player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                                    return true;
                                }
                            } else {
                                player.sendMessage("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:");
                                player.sendMessage("§6§lMagical Bucket §8» §7Use /magicalaxolotlbucket reload");
                                return true;
                            }
                        } else if (strings.length == 2) {
                            if (strings[0].equalsIgnoreCase("give")) {
                                if (player.hasPermission("magical_axolotl_bucket.give")) {
                                    Player target = player.getServer().getPlayerExact(strings[1]);
                                    if (target == null) {
                                        player.sendMessage("§6§lMagical Bucket §8» §7That player is not online!");
                                        return true;
                                    } else {
                                        Inventory targetInventory = target.getInventory();
                                        ItemStack magicalAxolotlBucket = new magicalAxolotlBucketRecipe(plugin).AxolotlRecipe();
                                        targetInventory.addItem(magicalAxolotlBucket);
                                        player.sendMessage("§6§lMagical Bucket §8» §7You have given §6" + target.getName() + " §7a §6Magical Axolotl Bucket§7!");
                                        target.sendMessage("§6§lMagical Bucket §8» §7You have been given a §6Magical Axolotl Bucket§7!");
                                        return true;
                                    }
                                } else {
                                    player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                                    return true;
                                }
                            } else {
                                player.sendMessage("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:");
                                player.sendMessage("§6§lMagical Bucket §8» §7/magicalaxolotlbucket give <player>");
                                return true;
                            }
                        } else {
                            player.sendMessage("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:");
                            player.sendMessage("§6§lMagical Bucket §8» §7/magicalaxolotlbucket give <player>");
                            return true;
                        }
                    } else {
                        player.sendMessage("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:");
                        player.sendMessage("§6§lMagical Bucket §8» §7/magicalaxolotlbucket give <player>");
                        return true;
                    }
                }else {
                    player.sendMessage("§6§lMagical Bucket §8» §7You do not have permission to use this command!");
                    return true;
                }
            } else {
                player.sendMessage("&c§6§lMagical Bucket §8» &cThis feature is disabled in the config!");
                return true;
            }
        }else {
            commandSender.sendMessage(colorTranslate.translateStringColor("&6&lMagical Bucket &8» &7This command can only be used by players!"));
            return true;
        }
        return true;
    }
}
