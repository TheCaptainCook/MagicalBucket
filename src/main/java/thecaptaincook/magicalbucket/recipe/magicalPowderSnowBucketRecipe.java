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

public class magicalPowderSnowBucketRecipe {
    private final MagicalBucket plugin;

    public magicalPowderSnowBucketRecipe(MagicalBucket plugin) {

        this.plugin = plugin;
    }
    public ItemStack magicalPowerSnowRecipe(){
        if (!plugin.getConfig().getBoolean("powder_snow_bucket.active")){
            return null;
        }
        ItemStack magicalPowerSnowBucket = new ItemStack(Material.POWDER_SNOW_BUCKET, 1);
        ItemMeta magicalPowerSnowBucketMeta = magicalPowerSnowBucket.getItemMeta();
        if (magicalPowerSnowBucketMeta == null){
            return null;
        }
        NamespacedKey magicalPowerSnowBucketKey = new NamespacedKey(plugin, "magical_powder_snow_bucket");
        magicalPowerSnowBucketMeta.setDisplayName(plugin.getConfig().getString("powder_snow_bucket.displayName"));
        magicalPowerSnowBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("powder_snow_bucket.enchantment_number"),
                plugin.getConfig().getBoolean("powder_snow_bucket.enchantment_ignore_restriction"));
        magicalPowerSnowBucketMeta.setLore(plugin.getConfig().getStringList("powder_snow_bucket.displayLore"));
        ShapedRecipe snowBucketRecipe = new ShapedRecipe(magicalPowerSnowBucketKey, magicalPowerSnowBucket);
        snowBucketRecipe.shape("AAA", "ABA", "AAA");
        snowBucketRecipe.setIngredient('A', Material.POWDER_SNOW_BUCKET);
        snowBucketRecipe.setIngredient('B', Material.BUCKET);
        Bukkit.addRecipe(snowBucketRecipe);
        magicalPowerSnowBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalPowerSnowBucketMeta.getPersistentDataContainer().set(magicalPowerSnowBucketKey, PersistentDataType.INTEGER, 0);
        magicalPowerSnowBucket.setItemMeta(magicalPowerSnowBucketMeta);
        return magicalPowerSnowBucket;
    }
}
