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
            if (plugin.getConfig().getBoolean("lava_bucket.active")) {
                if (player.hasPermission("lava_bucket.player_permission")) {
                    if (command.getName().equalsIgnoreCase("mlb") || command.getName().equalsIgnoreCase("magicallavabucket")) {
                        if (strings.length == 0) {
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                        } else if (strings.length == 1) {
                            if (strings[0].equalsIgnoreCase("reload")) {
                                if (player.hasPermission("lava_bucket.config_reload")) {
                                    plugin.reloadConfig();
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                } else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                    return true;
                                }
                            } else {
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                                return true;
                            }
                        } else if (strings.length == 2) {
                            if (strings[0].equalsIgnoreCase("give")) {
                                if (player.hasPermission("lava_bucket.give_bucket")) {
                                    Player target = Bukkit.getServer().getPlayerExact(strings[1]);
                                    if (target == null) {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Player not found!"));
                                        return true;
                                    } else {
                                        Inventory targetInventory = target.getInventory();
                                        ItemStack magicalLava = new magicalLavaBucketRecipe(plugin).magicalLavaRecipe();
                                        targetInventory.addItem(magicalLava);
                                        if (target != player) {
                                            target.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + target.getName() + " §7a Magical Lava Bucket by §6" + player.getName() + "§7!"));
                                        }else {
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a Magical Lava Bucket!"));
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
                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                        }
                    } else {
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
                    }
                } else {
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicallavabucket give <player>"));
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
