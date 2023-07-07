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

import java.util.jar.Attributes;

public class magicalTropicalFishBucketRecipe {

    private final MagicalBucket plugin;

    public magicalTropicalFishBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }
    public ItemStack magicalTropicalFishRecipe(){
        if (!plugin.getConfig().getBoolean("tropical_fish_bucket.active")){
            return null;
        }
        NamespacedKey magicalTropicalFishKey = new NamespacedKey(plugin, "magical_tropical_fish_bucket");
        ItemStack magicalTropicalFish = new ItemStack(Material.TROPICAL_FISH_BUCKET, 1);
        ItemMeta magicalTropicalFishMeta = magicalTropicalFish.getItemMeta();
        if (magicalTropicalFishMeta == null){
            return null;
        }
        magicalTropicalFishMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("tropical_fish_bucket.displayName")));
        magicalTropicalFishMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("tropical_fish_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("tropical_fish_bucket.enchantment_ignore_restriction"));
        magicalTropicalFishMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("tropical_fish_bucket.displayLore")));
        ShapedRecipe magicalTropicalFishRecipe = new ShapedRecipe(magicalTropicalFishKey, magicalTropicalFish);
        magicalTropicalFishRecipe.shape("AAA", "ABA", "AAA");
        magicalTropicalFishRecipe.setIngredient('A', Material.TROPICAL_FISH_BUCKET);
        magicalTropicalFishRecipe.setIngredient('B', Material.WATER_BUCKET);
        Bukkit.addRecipe(magicalTropicalFishRecipe);
        magicalTropicalFishMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalTropicalFishMeta.getPersistentDataContainer().set(magicalTropicalFishKey, PersistentDataType.INTEGER, 0);
        magicalTropicalFish.setItemMeta(magicalTropicalFishMeta);
        return magicalTropicalFish;
    }
}
