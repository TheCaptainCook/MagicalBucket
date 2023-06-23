package thecaptaincook.magicalbucket.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicBucketRecipe;

import javax.swing.*;

public class magicBucketRefill implements Listener {

    private final MagicalBucket plugin;
    private final magicBucketRecipe magicalRecipe;

    public magicBucketRefill(MagicalBucket plugin) {
        this.plugin = plugin;
        this.magicalRecipe = new magicBucketRecipe(plugin);

    }

    @EventHandler
    public void onPlayerMagicalBucketUse(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if(action == Action.RIGHT_CLICK_BLOCK && itemInHand.getType() == Material.WATER_BUCKET){
            if (itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase("Infinity Bucket") && ){

            }
        }
    }

}
