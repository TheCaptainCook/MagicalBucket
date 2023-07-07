package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
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
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("cod_bucket.active")) {
                if (player.hasPermission("cod_bucket.player_permission")) {
                    if (command.getName().equalsIgnoreCase("mcb") || command.getName().equalsIgnoreCase("magicalcodbucket")) {
                        if (strings.length == 0) {
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                        } else if (strings.length == 1) {
                            if (strings[0].equalsIgnoreCase("reload")) {
                                if (player.hasPermission("cod_bucket.config_reload")) {
                                    plugin.reloadConfig();
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                } else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                    return true;
                                }
                            } else {
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                                return true;
                            }
                        } else if (strings.length == 2) {
                            if (strings[0].equalsIgnoreCase("give")) {
                                if (player.hasPermission("cod_bucket.give_bucket")) {
                                    Player target = Bukkit.getServer().getPlayerExact(strings[1]);
                                    if (target == null) {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Player not found!"));
                                        return true;
                                    } else {
                                        Inventory targetInventory = target.getInventory();
                                        ItemStack magicalCod = new magicalCodBucketRecipe(plugin).magicalCodRecipe();
                                        targetInventory.addItem(magicalCod);
                                        if (target != player) {
                                            target.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + target.getName() + " §7a magical cod bucket by §6" + player.getName() + "§7!"));
                                        }else {
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a magical cod bucket!"));
                                        }
                                        return true;
                                    }
                                } else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                    return true;
                                }
                            } else {
                                player.sendMessage("§6§lMagical Bucket §8» §6The command you entered is invalid!");
                                return true;
                            }
                        } else {
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                        }
                    } else {
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                    }
                } else {
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalcodbucket give <player>"));
                    return true;
                }
            } else {
                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7This recipe is disabled!"));
                return true;
            }
        } else {
            commandSender.sendMessage(colorTranslate.translateStringColor("&c§6§lMagical Bucket §8» You must be a player to use this command"));
            return true;
        }
        return true;
    }
}
