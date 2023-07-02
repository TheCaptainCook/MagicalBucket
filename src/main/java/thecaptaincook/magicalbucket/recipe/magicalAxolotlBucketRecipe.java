package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalAxolotlBucketRecipe {
    private final MagicalBucket plugin;
    public magicalAxolotlBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }
    public ItemStack AxolotlRecipe(){
        if (!plugin.getConfig().getBoolean("axolotl_bucket.active")) {
            return null;
        }
        ItemStack AxolotlBucket = new ItemStack(Material.AXOLOTL_BUCKET, 1);
        ItemMeta AxolotlBucketMeta = AxolotlBucket.getItemMeta();
        if (AxolotlBucketMeta == null) {
            return null;
        }
        AxolotlBucketMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("axolotl_bucket.displayName")));
        AxolotlBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("axolotl_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("Axolotl_Bucket.enchantment_ignore_restriction"));
        AxolotlBucketMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("axolotl_bucket.displayLore")));
        AxolotlBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        AxolotlBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_axolotl_bucket"), PersistentDataType.INTEGER, 0);
        AxolotlBucket.setItemMeta(AxolotlBucketMeta);
        return (AxolotlBucket);
    }
}
