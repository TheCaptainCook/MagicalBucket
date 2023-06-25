package thecaptaincook.magicalbucket;

import org.bukkit.plugin.java.JavaPlugin;
import thecaptaincook.magicalbucket.commands.magicBucketCommand;
import thecaptaincook.magicalbucket.listeners.magicBucketRefill;
import thecaptaincook.magicalbucket.listeners.inventoryManipulate;

public final class MagicalBucket extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Plugin Starting");

        //getServer().getPluginManager().registerEvents(new magicBucketRefill(this), this);
        getServer().getPluginManager().registerEvents(new inventoryManipulate(), this);
        getCommand("mwb").setExecutor(new magicBucketCommand(this));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The Plugin is shutting down");
    }
}
