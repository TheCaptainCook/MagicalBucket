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

public class magicalCodBucketRecipe {

    private final MagicalBucket plugin;

    public magicalCodBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalCodRecipe(){
        if (!plugin.getConfig().getBoolean("cod_bucket.active")){
            return null;
        }
        ItemStack codBucketRecipe = new ItemStack(Material.COD_BUCKET);
        ItemMeta codBucketRecipeMeta = codBucketRecipe.getItemMeta();
        if (codBucketRecipeMeta == null){
            return null;
        }
        codBucketRecipeMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("cod_bucket.displayName")));
        codBucketRecipeMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("cod_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("cod_bucket.enchantment_ignore_restriction"));
        codBucketRecipeMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("cod_bucket.displayLore")));
        codBucketRecipeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        codBucketRecipeMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_cod_bucket"), PersistentDataType.INTEGER, 0);
        codBucketRecipe.setItemMeta(codBucketRecipeMeta);
        return codBucketRecipe;
    }
}
