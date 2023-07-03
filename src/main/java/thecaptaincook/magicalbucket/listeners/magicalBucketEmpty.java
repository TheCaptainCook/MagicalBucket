package thecaptaincook.magicalbucket.listeners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import thecaptaincook.magicalbucket.MagicalBucket;

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
                    if(magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("axolotl_bucket.displayName"))){
                       player.getWorld().getBlockAt(x, y, z).setType(Material.AXOLOTL_BUCKET);
                       player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("cod_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.COD_BUCKET);
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("Lava_Bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.LAVA);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("milk_bucket.displayName"))) {
                        for (PotionEffect effect : player.getActivePotionEffects())
                            player.removePotionEffect(effect.getType());
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("powder_snow_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.POWDER_SNOW);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("puffer_fish_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.PUFFERFISH);
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("salmon_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.SALMON_BUCKET);
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("tadpole_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.TADPOLE_BUCKET);
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("tropical_fish_bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.TROPICAL_FISH_BUCKET);
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    } else if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("Water_Bucket.displayName"))) {
                        player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    }
                    //player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }
                event.setCancelled(true);
            }
        }
    }
}
