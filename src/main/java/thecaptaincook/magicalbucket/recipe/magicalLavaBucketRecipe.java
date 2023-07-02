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

public class magicalLavaBucketRecipe {

    private final MagicalBucket plugin;


    public magicalLavaBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalLavaRecipe(){
        if (!plugin.getConfig().getBoolean("lava_bucket.active")) {
            return null;
        }
        ItemStack magicalLavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta magicalLavaBucketMeta = magicalLavaBucket.getItemMeta();
        if (magicalLavaBucketMeta == null) {
            return null;
        }
        magicalLavaBucketMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("Lava_Bucket.displayName")));
        magicalLavaBucketMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("lava_bucket.enchantment_number"),
                plugin.getConfig().getBoolean("lava_bucket.enchantment_ignore_restriction"));
        magicalLavaBucketMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("lava_bucket.displayLore")));
        magicalLavaBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalLavaBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_bucket"), PersistentDataType.INTEGER, 0);
        magicalLavaBucket.setItemMeta(magicalLavaBucketMeta);
        return magicalLavaBucket;
    }
}
