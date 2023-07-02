package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import thecaptaincook.magicalbucket.MagicalBucket;

public class magicalPufferFishBucketRecipe {

    private final MagicalBucket plugin;

    public magicalPufferFishBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }
    public ItemStack magicalPufferFishRecipe(){
        if (!plugin.getConfig().getBoolean("puffer_fish_bucket.active")){
            return null;
        }
        ItemStack magicalPufferFishBucket = new ItemStack(Material.PUFFERFISH_BUCKET, 1);
        ItemMeta magicalPufferFishMeta = magicalPufferFishBucket.getItemMeta();
        if (magicalPufferFishMeta == null){
            return null;
        }
        magicalPufferFishMeta.setDisplayName(plugin.getConfig().getString("puffer_fish_bucket.displayName"));
        magicalPufferFishMeta.addEnchant(
                Enchantment.DURABILITY,
                plugin.getConfig().getInt("puffer_fish_bucket.enchantment_number"),
                plugin.getConfig().getBoolean("puffer_fish_bucket.enchantment_ignore_restriction"));
        magicalPufferFishMeta.setLore(plugin.getConfig().getStringList("puffer_fish_bucket.displayLore"));
        magicalPufferFishMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_puffer_fish_bucket"), PersistentDataType.INTEGER, 0);
        magicalPufferFishMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalPufferFishBucket.setItemMeta(magicalPufferFishMeta);
        return magicalPufferFishBucket;
    }
}
