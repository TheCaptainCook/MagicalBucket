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

import java.util.ArrayList;

public class magicWaterBucketRecipe {

    private final MagicalBucket plugin;


    public magicWaterBucketRecipe(MagicalBucket plugin) {

        this.plugin = plugin;
    }

    public ItemStack magicalWaterBucketRecipe(){

        if (!plugin.getConfig().getBoolean("Water_Bucket.active")){
            return null;
        }
        NamespacedKey waterBucketKey = new NamespacedKey(plugin, "magical_water_bucket");
        ItemStack magicalWaterBucket = new ItemStack(Material.WATER_BUCKET, 1);
        ItemMeta magicalWaterBucketMeta = magicalWaterBucket.getItemMeta();
        if (magicalWaterBucketMeta == null){
            return null;
        }
        magicalWaterBucketMeta.setDisplayName(plugin.getConfig().getString("Water_Bucket.displayName"));
        magicalWaterBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("Water_Bucket.enchantment_number"),
                plugin.getConfig().getBoolean("Water_Bucket.enchantment_ignore_restriction"));
        magicalWaterBucketMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("Water_Bucket.displayLore")));
        ShapedRecipe magicalWaterBucketRecipe = new ShapedRecipe(waterBucketKey, magicalWaterBucket);
        magicalWaterBucketRecipe.shape("AAA", "ABA", "AAA");
        magicalWaterBucketRecipe.setIngredient('A', Material.WATER_BUCKET);
        magicalWaterBucketRecipe.setIngredient('B', Material.BUCKET);
        Bukkit.addRecipe(magicalWaterBucketRecipe);
        magicalWaterBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalWaterBucketMeta.getPersistentDataContainer().set(waterBucketKey, PersistentDataType.INTEGER, 0);
        magicalWaterBucket.setItemMeta(magicalWaterBucketMeta);
        return magicalWaterBucket;
    }

}
