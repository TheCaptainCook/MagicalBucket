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

public class magicalTadpoleBucketRecipe {

    private final MagicalBucket plugin;

    public magicalTadpoleBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalTadpoleRecipe(){
        if (!plugin.getConfig().getBoolean("tadpole_bucket.active")){
            return null;
        }
        ItemStack magicalTadpole = new ItemStack(Material.TADPOLE_BUCKET, 1);
        ItemMeta magicalTadpoleMeta = magicalTadpole.getItemMeta();
        if (magicalTadpoleMeta == null){
            return null;
        }
        magicalTadpoleMeta.setDisplayName(colorTranslate.translateStringColor(plugin.getConfig().getString("tadpole_bucket.displayName")));
        magicalTadpoleMeta.setLore(colorTranslate.colorArrayTranslate(plugin.getConfig().getStringList("tadpole_bucket.displayLore")));
        magicalTadpoleMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("tadpole_bucket.enchantmentLevel"),
                plugin.getConfig().getBoolean("tadpole_bucket.enchantment_ignore_restriction"));
        magicalTadpoleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalTadpoleMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_tadpole_bucket" ), PersistentDataType.INTEGER, 0);
        magicalTadpole.setItemMeta(magicalTadpoleMeta);
        return magicalTadpole;
    }
}
