package thecaptaincook.magicalbucket;

import org.bukkit.plugin.java.JavaPlugin;
import thecaptaincook.magicalbucket.commands.*;
import thecaptaincook.magicalbucket.listeners.magicalBucketEmpty;

public final class MagicalBucket extends JavaPlugin {

    private final MagicalBucket plugin;

    public MagicalBucket(MagicalBucket plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin Starting");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new magicalBucketEmpty(this), this);

        if (plugin.getConfig().getBoolean("axolotl_bucket.command_active")) {
            getCommand("maxb").setExecutor(new magicalAxolotlBucketSummoner(this));
        }
        if (plugin.getConfig().getBoolean("cod_bucket.command_active")) {
            getCommand("mcb").setExecutor(new magicalCodBucketSummoner(this));
        }
        getCommand("mlb").setExecutor(new magicalLavaBucketSummoner(this));
        getCommand("mmb").setExecutor(new magicalMilkBucketSummoner(this));
        getCommand("mpsb").setExecutor(new magicalPowerSnowBucketSummoner(this));
        getCommand("mpfb").setExecutor(new magicalPufferFishSummoner(this));
        getCommand("msb").setExecutor(new magicalSamonBucketSummoner(this));
        getCommand("mtb").setExecutor(new magicalTadpoleBucketSummoner(this));
        getCommand("mtfb").setExecutor(new magicalTropicalFishSummoner(this));
        getCommand("mwb").setExecutor(new magicalWaterBucketSummoner(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The Plugin is shutting down");
    }
}
