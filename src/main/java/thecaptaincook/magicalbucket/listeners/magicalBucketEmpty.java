package thecaptaincook.magicalbucket.listeners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.recipe.magicBucketRecipe;

public class magicalBucketEmpty implements Listener {

    private final MagicalBucket plugin;

    public magicalBucketEmpty(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBucketTransition(PlayerBucketEmptyEvent event){

        Player player = event.getPlayer();
        Block block = event.getBlock();

        int x = event.getBlock().getX();
        int y = event.getBlock().getY();
        int z = event.getBlock().getZ();

        ItemStack magicalBucket = player.getInventory().getItemInMainHand();

        if (!magicalBucket.hasItemMeta())
            return;

        NamespacedKey magicalBucketKey = new NamespacedKey(plugin, "magical_bucket");

        ItemMeta magicalBucketMeta = magicalBucket.getItemMeta();

        if (magicalBucketMeta != null){
            PersistentDataContainer magicalBucketData = magicalBucketMeta.getPersistentDataContainer();
            if (!magicalBucketData.has(magicalBucketKey, PersistentDataType.INTEGER)) return;
            if (magicalBucketData.get(magicalBucketKey, PersistentDataType.INTEGER) == 0){
                if (block.getBlockData() instanceof Waterlogged waterLogged) {
                    waterLogged.setWaterlogged(true);
                    block.setBlockData(waterLogged);
                }
                else {
                    if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("Water_Bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    }
                    else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("Lava_Bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.LAVA);
                    }
                    //player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }
                event.setCancelled(true);
            }
        }
    }
}
