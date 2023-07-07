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

public class magicalTadpoleBucketRecipe {

    private final MagicalBucket plugin;

    public magicalTadpoleBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalTadpoleRecipe(){
        if (!plugin.getConfig().getBoolean("tadpole_bucket.active")){
            return null;
        }
        NamespacedKey TadpoleBucketKey = new NamespacedKey(plugin, "magical_tadpole_bucket");
        ItemStack magicalTadpole = new ItemStack(Material.TADPOLE_BUCKET, 1);
        ItemMeta magicalTadpoleMeta = magicalTadpole.getItemMeta();
        if (magicalTadpoleMeta == null){
            return null;
        }
        magicalTadpoleMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("tadpole_bucket.displayName")));
        magicalTadpoleMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("tadpole_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("tadpole_bucket.enchantment_ignore_restriction"));
        magicalTadpoleMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("tadpole_bucket.displayLore")));
        ShapedRecipe magicalTadpoleRecipe = new ShapedRecipe(TadpoleBucketKey, magicalTadpole);
        magicalTadpoleRecipe.shape("AAA", "ABA", "AAA");
        magicalTadpoleRecipe.setIngredient('A', Material.TADPOLE_BUCKET);
        magicalTadpoleRecipe.setIngredient('B', Material.WATER_BUCKET);
        Bukkit.addRecipe(magicalTadpoleRecipe);
        magicalTadpoleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalTadpoleMeta.getPersistentDataContainer().set(TadpoleBucketKey, PersistentDataType.INTEGER, 0);
        magicalTadpole.setItemMeta(magicalTadpoleMeta);
        return magicalTadpole;
    }
}
