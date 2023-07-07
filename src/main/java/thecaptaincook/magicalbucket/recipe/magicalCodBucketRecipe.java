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

public class magicalCodBucketRecipe {

    private final MagicalBucket plugin;

    public magicalCodBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalCodRecipe(){
        if (!plugin.getConfig().getBoolean("cod_bucket.active")){
            return null;
        }
        NamespacedKey codBucketKey = new NamespacedKey(plugin, "magical_cod_bucket");
        ItemStack codBucketRecipe = new ItemStack(Material.COD_BUCKET);
        ItemMeta codBucketRecipeMeta = codBucketRecipe.getItemMeta();
        if (codBucketRecipeMeta == null){
            return null;
        }
        codBucketRecipeMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("cod_bucket.displayName")));
        codBucketRecipeMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("cod_bucket.enchantment_number"),
                plugin.getConfig().getBoolean("cod_bucket.enchantment_ignore_restriction"));
        codBucketRecipeMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("cod_bucket.displayLore")));
        ShapedRecipe codedBucketRecipe = new ShapedRecipe(codBucketKey, codBucketRecipe);
        codedBucketRecipe.shape("AAA", "ABA", "AAA");
        codedBucketRecipe.setIngredient('A', Material.COD_BUCKET);
        codedBucketRecipe.setIngredient('B', Material.WATER_BUCKET);
        Bukkit.addRecipe(codedBucketRecipe);
        codBucketRecipeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        codBucketRecipeMeta.getPersistentDataContainer().set(codBucketKey, PersistentDataType.INTEGER, 0);
        codBucketRecipe.setItemMeta(codBucketRecipeMeta);
        return codBucketRecipe;
    }
}
