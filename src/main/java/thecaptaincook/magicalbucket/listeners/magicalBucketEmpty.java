package thecaptaincook.magicalbucket.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicBucketRecipe;

public class magicalBucketEmpty implements Listener {

    private final MagicalBucket plugin;
    private final magicBucketRecipe magicalRecipe;
    private final magicBucketRefill refill;

    public magicalBucketEmpty(MagicalBucket plugin) {
        this.plugin = plugin;
        this.magicalRecipe = new magicBucketRecipe(plugin);
        this.refill = new magicBucketRefill(plugin);
    }

    @EventHandler
    public void onPlayerBucketTransition(InventoryEvent event){

        Player player = (Player) event.getInventory().getHolder();

        ItemStack magicRecipe = magicalRecipe.magicalWaterBucketRecipe();

        player.getInventory().setItem(5, magicRecipe);

    }
}
