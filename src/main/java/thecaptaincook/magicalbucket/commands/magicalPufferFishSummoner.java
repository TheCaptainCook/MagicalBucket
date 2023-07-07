package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicalPowderSnowBucketRecipe;
import thecaptaincook.magicalbucket.utils.colorTranslate;
import thecaptaincook.magicalbucket.recipe.magicalPufferFishBucketRecipe;

public class magicalPufferFishSummoner implements CommandExecutor {

private final MagicalBucket plugin;

    public magicalPufferFishSummoner(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (plugin.getConfig().getBoolean("puffer_fish_bucket.active")){
                if (player.hasPermission("puffer_fish_bucket.player_permission")){
                    if (command.getName().equalsIgnoreCase("mpfb") || command.getName().equalsIgnoreCase("magicalpufferfishbucket")){
                        if (strings.length == 1) {
                            if (strings[0].equalsIgnoreCase("reload")) {
                                if (player.hasPermission("puffer_fish_bucket.config_reload")) {
                                    plugin.reloadConfig();
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Config reloaded!"));
                                } else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                } return true;
                            } else {
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalpufferfishbucket reload"));
                            } return true;
                        } else if (strings.length == 2) {
                            if (strings[0].equalsIgnoreCase("give")){
                                if (player.hasPermission("puffer_fish_bucket.give_bucket")) {
                                    Player targetPlayer = Bukkit.getPlayer(strings[1]);
                                    if (targetPlayer == null) {
                                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7That player is not online!"));
                                    } else {
                                        Inventory targetInventory = targetPlayer.getInventory();
                                        ItemStack pufferFishBucket = new magicalPufferFishBucketRecipe(plugin).magicalPufferFishRecipe();
                                        targetInventory.addItem(pufferFishBucket);
                                        if (targetPlayer != player) {
                                            targetPlayer.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given §6" + targetPlayer.getName() + " §7a Magical PufferFish Bucket by §6" + player.getName() + "§7!"));
                                        } else {
                                            player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You have given yourself a Magical PufferFish Bucket!"));
                                        } return true;
                                    } return true;
                                } else {
                                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                                } return true;
                            }else {
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalpufferfishbucket give <player>"));
                            } return true;
                        }
                    }else{
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §6§HHey there! §7You can use the following commands:"));
                        player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7Use /magicalpufferfishbucket give <player>"));
                    } return true;
                }else {
                    player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You do not have permission to use this command!"));
                }return true;
            }else {
                player.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7This recipe is disabled!"));
            } return true;
        }else{
            commandSender.sendMessage(colorTranslate.translateStringColor("§6§lMagical Bucket §8» §7You must be a player to use this command!"));
        } return true;
    }
}