package thecaptaincook.magicalbucket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicBucketRecipe;

public class magicBucketCommand implements CommandExecutor {

    private final MagicalBucket plugin;
    private final magicBucketRecipe magicRecipe;

    public magicBucketCommand(MagicalBucket plugin) {
        this.plugin = plugin;
        this.magicRecipe = new magicBucketRecipe(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (commandSender.hasPermission("magical.plugin")){
                ItemStack MWB = magicBucketRecipe.magicalWaterBucketRecipe();
                Inventory inventory = player.getInventory();
                if(strings == null){
                    return true;
                } else if (strings.length == 0) {
                    inventory.addItem(MWB);
                } else{
                    Player target = Bukkit.getPlayerExact(strings[0]);
                    if (target == null || !target.isOnline()){
                        player.sendMessage("Player is not online");
                    }
                    else{
                        Inventory targetInventory = target.getInventory();
                        targetInventory.addItem(MWB);
                        player.sendMessage("Item added to "+ target.getDisplayName() + "'s inventory") ;
                    }
                }
            }else {
                player.sendMessage("Player does not have permission to execute this command");
            }
        }
        return true;
    }
}
