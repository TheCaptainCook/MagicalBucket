package thecaptaincook.magicalbucket.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

public class inventoryManipulate implements Listener {


    @EventHandler
    public void onPlayerClickedEvent(PlayerBucketEmptyEvent event){

        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

        if (event.getBucket() == Material.WATER_BUCKET && itemInMainHand.getItemMeta()!=null){
            if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase("Infinity Bucket")){
                player.getInventory().remove(Material.BUCKET);


            }
        }
    }
}
