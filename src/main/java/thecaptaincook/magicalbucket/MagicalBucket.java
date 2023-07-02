package thecaptaincook.magicalbucket;

import org.bukkit.plugin.java.JavaPlugin;
import thecaptaincook.magicalbucket.commands.magicalLavaBucketSummoner;
import thecaptaincook.magicalbucket.commands.magicalWaterBucketSummoner;
import thecaptaincook.magicalbucket.listeners.magicalBucketEmpty;

public final class MagicalBucket extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic



        System.out.println("Plugin Starting");


        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new magicalBucketEmpty(this), this);

        getCommand("mwb").setExecutor(new magicalWaterBucketSummoner(this));
        getCommand("mlb").setExecutor(new magicalLavaBucketSummoner(this));



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The Plugin is shutting down");
    }
}
