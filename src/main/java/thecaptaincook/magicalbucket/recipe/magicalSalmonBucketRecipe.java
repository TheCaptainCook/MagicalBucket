package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import thecaptaincook.magicalbucket.MagicalBucket;
import thecaptaincook.magicalbucket.utils.colorTranslate;

public class magicalSalmonBucketRecipe {

    private final MagicalBucket plugin;

    public magicalSalmonBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }
    public ItemStack magicalSalmonRecipe(){
        if (!plugin.getConfig().getBoolean("salmon_bucket.active")){
            return null;
        }
        NamespacedKey SalmonBucketKey = new NamespacedKey(plugin, "magical_salmon_bucket");
        ItemStack magicalSalmon = new ItemStack(Material.SALMON_BUCKET, 1);
        ItemMeta magicalSalmonMeta = magicalSalmon.getItemMeta();
        if (magicalSalmonMeta == null){
            return null;
        }
        magicalSalmonMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("salmon_bucket.displayName")));
        magicalSalmonMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("salmon_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("salmon_bucket.enchantment_ignore_restriction"));
        magicalSalmonMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("salmon_bucket.displayLore")));
        ShapedRecipe magicalSalmonRecipe = new ShapedRecipe(SalmonBucketKey, magicalSalmon);
        magicalSalmonRecipe.shape("AAA", "ABA", "AAA");
        magicalSalmonRecipe.setIngredient('A', Material.SALMON_BUCKET);
        magicalSalmonRecipe.setIngredient('B', Material.WATER_BUCKET);
        Bukkit.addRecipe(magicalSalmonRecipe);
        magicalSalmonMeta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);
        magicalSalmonMeta.getPersistentDataContainer().set(SalmonBucketKey, PersistentDataType.INTEGER, 0);
        magicalSalmon.setItemMeta(magicalSalmonMeta);
        return magicalSalmon;
    }
}
