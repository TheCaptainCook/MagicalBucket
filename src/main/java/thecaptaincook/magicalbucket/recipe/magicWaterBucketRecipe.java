package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import thecaptaincook.magicalbucket.MagicalBucket;

import java.util.ArrayList;

public class magicWaterBucketRecipe {

    private final MagicalBucket plugin;


    public magicWaterBucketRecipe(MagicalBucket plugin) {

        this.plugin = plugin;
    }

    public ItemStack magicalWaterBucketRecipe(){

        ItemStack magicalWaterBucket = new ItemStack(Material.WATER_BUCKET, 1);
        ItemMeta magicalWaterBucketMeta = magicalWaterBucket.getItemMeta();

        magicalWaterBucketMeta.setDisplayName(plugin.getConfig().getString("Water_Bucket.displayName"));
        magicalWaterBucketMeta.addEnchant(Enchantment.DURABILITY, 1, true);

        ArrayList<String> magicalWaterBucketLore = new ArrayList<>();
        magicalWaterBucketLore.add(plugin.getConfig().getString("Water_Bucket.displayLore"));
        magicalWaterBucketMeta.setLore(magicalWaterBucketLore);

        magicalWaterBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalWaterBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_bucket"), PersistentDataType.INTEGER, 0);

        magicalWaterBucket.setItemMeta(magicalWaterBucketMeta);

        return magicalWaterBucket;
    }

}
