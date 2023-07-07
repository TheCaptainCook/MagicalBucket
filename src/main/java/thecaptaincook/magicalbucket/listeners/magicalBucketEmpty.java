package thecaptaincook.magicalbucket.listeners;

import org.bukkit.ChatColor;
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
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalBucketEmpty implements Listener {

    private final MagicalBucket plugin;

    public magicalBucketEmpty(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBucketTransition(PlayerBucketEmptyEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();

        int x = event.getBlock().getX();
        int y = event.getBlock().getY();
        int z = event.getBlock().getZ();

        ItemStack magicalBucket = player.getInventory().getItemInMainHand();

        if (!magicalBucket.hasItemMeta()) {
            return;
        }

        NamespacedKey magicalBucketKey = new NamespacedKey(plugin, "magical_bucket");
        System.out.println("PART 1 Triggered");
        if (magicalBucket.getItemMeta() != null) {
            System.out.println("PART 2 Triggered");
            PersistentDataContainer dataContainer = magicalBucket.getItemMeta().getPersistentDataContainer();
            System.out.println("condition Testing" + dataContainer.has(magicalBucketKey, PersistentDataType.INTEGER));
            if (!dataContainer.has(magicalBucketKey, PersistentDataType.INTEGER)){
                System.out.println("MagicalBucket Key: " + magicalBucketKey);
                System.out.println("Persistent integer: " + PersistentDataType.INTEGER);
                System.out.println("PART 3 Triggered");
                return;
            }
            if (dataContainer.get(magicalBucketKey, PersistentDataType.INTEGER) == 0){
                System.out.println("PART 4 Triggered");
                event.setCancelled(true);
            }
        }
    /*    if (magicalBucketMeta != null){
            System.out.println("PART 1 Triggered");

            PersistentDataContainer magicalBucketData = magicalBucket.getPersistentDataContainer();
            System.out.println("PART 2 Triggered");
            if (!magicalBucketData.has(magicalBucketKey, PersistentDataType.INTEGER)){
                System.out.println("Lost in translation????");
                System.out.println("Translating :" + magicalBucketData.get(magicalBucketKey, PersistentDataType.INTEGER));
                return;
            }
            System.out.println("PART 3 Triggered");
            if (magicalBucketData.get(magicalBucketKey, PersistentDataType.INTEGER) > 0){
                System.out.println("PART 4 Triggered");
                if (block.getBlockData() instanceof Waterlogged waterLogged) {
                    waterLogged.setWaterlogged(true);
                    block.setBlockData(waterLogged);
                }if( magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("axolotl_bucket.displayName")))){
                    player.sendMessage("This triggered???");
                    player.getWorld().getBlockAt(x, y, z).setType(Material.AXOLOTL_BUCKET);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                    event.setCancelled(true);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("cod_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.COD_BUCKET);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("Lava_Bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.LAVA);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("milk_bucket.displayName")))) {
                    for (PotionEffect effect : player.getActivePotionEffects())
                        player.removePotionEffect(effect.getType());
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("powder_snow_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.POWDER_SNOW);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("puffer_fish_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.PUFFERFISH);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("salmon_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.SALMON_BUCKET);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("tadpole_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.TADPOLE_BUCKET);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("tropical_fish_bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.TROPICAL_FISH_BUCKET);
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }if (magicalBucket.getItemMeta().getDisplayName().equalsIgnoreCase(colorTranslate.translateStringColor(plugin.getConfig().getString("Water_Bucket.displayName")))) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
                }
                //player.getWorld().getBlockAt(x, y, z).setType(Material.WATER);
            }
        } event.setCancelled(true);
    }
}*/
    }
}