package thecaptaincook.magicalbucket.recipe;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import thecaptaincook.magicalbucket.MagicalBucket;

import java.util.ArrayList;

public class magicBucketRecipe {

    private final MagicalBucket plugin;
    private final magicBucketRecipe recipeMagicalBucket;

    public magicBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
        this.recipeMagicalBucket = new magicBucketRecipe(plugin);
    }

    public static ItemStack magicalWaterBucketRecipe(){

        ItemStack magicalWaterBucket = new ItemStack(Material.WATER_BUCKET);
        ItemMeta magicalWaterBucketMeta = magicalWaterBucket.getItemMeta();
        magicalWaterBucketMeta.setDisplayName("Infinity Bucket");
        magicalWaterBucketMeta.addEnchant(Enchantment.DURABILITY, 5, true);

        ArrayList<String> magicalWaterBucketLore = new ArrayList<>();

        magicalWaterBucketLore.add("This Magical bucket");
        magicalWaterBucketLore.add("has special properties");
        magicalWaterBucketLore.add("i.e - it never runs out");

        magicalWaterBucketMeta.setLore(magicalWaterBucketLore);

        magicalWaterBucket.setItemMeta(magicalWaterBucketMeta);

        return magicalWaterBucket;
    }

}
