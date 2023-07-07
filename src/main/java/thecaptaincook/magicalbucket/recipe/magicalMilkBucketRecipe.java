package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
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
        NamespacedKey MilkBucketKey = new NamespacedKey(plugin, "magical_milk_bucket");
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
        ShapedRecipe magicalMilkBucketRecipe = new ShapedRecipe(MilkBucketKey, magicalMilkBucket);
        magicalMilkBucketRecipe.shape("AAA", "ABA", "AAA");
        magicalMilkBucketRecipe.setIngredient('A', Material.MILK_BUCKET);
        magicalMilkBucketRecipe.setIngredient('B', Material.BUCKET);
        Bukkit.addRecipe(magicalMilkBucketRecipe);
        magicalMilkBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalMilkBucketMeta.getPersistentDataContainer().set(MilkBucketKey, PersistentDataType.INTEGER, 0);
        magicalMilkBucket.setItemMeta(magicalMilkBucketMeta);
        return magicalMilkBucket;
    }
}
