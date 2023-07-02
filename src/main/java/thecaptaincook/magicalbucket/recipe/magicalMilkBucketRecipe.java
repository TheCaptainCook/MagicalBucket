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

public class magicalMilkBucketRecipe {
    private final MagicalBucket plugin;
    public magicalMilkBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }
    public ItemStack magicalMilkRecipe() {
        if (!plugin.getConfig().getBoolean("milk_bucket.active")) {
            return null;
        }
        ItemStack magicalMilkBucket = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta magicalMilkBucketMeta = magicalMilkBucket.getItemMeta();
        if (magicalMilkBucketMeta == null) {
            return null;
        }
        magicalMilkBucketMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("milk_bucket.displayName")));
        magicalMilkBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("milk_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("milk_bucket.enchantment_ignore_restriction"));
        magicalMilkBucketMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("milk_bucket.displayLore")));
        magicalMilkBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalMilkBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"magical_milk_Bucket"), PersistentDataType.INTEGER, 0);
        magicalMilkBucket.setItemMeta(magicalMilkBucketMeta);
        return magicalMilkBucket;
    }
}
