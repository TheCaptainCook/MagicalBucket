package thecaptaincook.magicalbucket.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicBucketRecipe;

public class magicBucketRefill implements Listener {

    private final MagicalBucket plugin;
    private final magicBucketRecipe magicalRecipe;

    public magicBucketRefill(MagicalBucket plugin) {
        this.plugin = plugin;
        this.magicalRecipe = new magicBucketRecipe(plugin);

    }

    @EventHandler
    public void onPlayerBucketDeleter(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        int indexSlot = player.getInventory().getHeldItemSlot();
        if (event.getClickedBlock()!=null && itemInHand.getItemMeta()!=null){
            if (itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase("Infinity Bucket")){
                if(action == Action.RIGHT_CLICK_BLOCK && itemInHand.getType() == Material.WATER_BUCKET){
                    player.getInventory().setItem(indexSlot, new ItemStack(Material.AIR));
                    player.sendMessage("Inventory Item -" + player.getInventory().getItem(indexSlot));
                }
            }
        }
    }
}
