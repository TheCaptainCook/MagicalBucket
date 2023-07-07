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

public class magicalLavaBucketRecipe {

    private final MagicalBucket plugin;


    public magicalLavaBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalLavaRecipe(){
        if (!plugin.getConfig().getBoolean("lava_bucket.active")){
            return null;
        }
        NamespacedKey LavaBucketKey = new NamespacedKey(plugin, "magical_lava_bucket");
        ItemStack lavaBucketRecipe = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta lavaBucketMeta = lavaBucketRecipe.getItemMeta();
        if (lavaBucketMeta == null){
            return null;
        }
        lavaBucketMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("cod_bucket.displayName")));
        lavaBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("lava_bucket.enchantment_number"),
                plugin.getConfig().getBoolean("lava_bucket.enchantment_ignore_restriction"));
        lavaBucketMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("lava_bucket.displayLore")));
        ShapedRecipe lavaBucketRecipes = new ShapedRecipe(LavaBucketKey, lavaBucketRecipe);
        lavaBucketRecipes.shape("AAA", "ABA", "AAA");
        lavaBucketRecipes.setIngredient('A', Material.LAVA_BUCKET);
        lavaBucketRecipes.setIngredient('B', Material.BUCKET);
        Bukkit.addRecipe(lavaBucketRecipes);
        lavaBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lavaBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_lava_bucket"), PersistentDataType.INTEGER, 0);
        lavaBucketRecipe.setItemMeta(lavaBucketMeta);
        return lavaBucketRecipe;
    }
}
