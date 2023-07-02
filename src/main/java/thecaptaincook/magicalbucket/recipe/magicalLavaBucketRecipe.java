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

public class magicalLavaBucketRecipe {

    private final MagicalBucket plugin;


    public magicalLavaBucketRecipe(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    public ItemStack magicalLavaBucket(){

        ItemStack magicalLavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta magicalLavaBucketMeta = magicalLavaBucket.getItemMeta();

        magicalLavaBucketMeta.setDisplayName(plugin.getConfig().getString("Lava_Bucket.displayName"));
        magicalLavaBucketMeta.addEnchant(Enchantment.DURABILITY, 1, true);

        ArrayList<String> magicalLavaBucketLore = new ArrayList<>();
        magicalLavaBucketLore.add(plugin.getConfig().getString("Lava_Bucket.displayLore"));
        magicalLavaBucketMeta.setLore(magicalLavaBucketLore);

        magicalLavaBucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicalLavaBucketMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "magical_bucket"), PersistentDataType.INTEGER, 1);

        magicalLavaBucket.setItemMeta(magicalLavaBucketMeta);

        return magicalLavaBucket;
    }
}
