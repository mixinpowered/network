package com.mixinpowered.network.lib;

import com.mixinpowered.network.lib.listeners.CommonInventoryListener;
import com.mixinpowered.network.lib.listeners.CommonItemInteractListener;
import com.mixinpowered.network.lib.session.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Lib {
    private static JavaPlugin plugin;

    public static void init(JavaPlugin plugin) {
        Lib.plugin = plugin;
        setup();
    }

    private static void setup() {
        if (plugin instanceof Minigame) {
            plugin.saveResource("maps.yml", false);
            File mapsFolder = new File(Bukkit.getWorldContainer(), "maps");
            if (!mapsFolder.exists()) mapsFolder.mkdirs();
        }

        plugin.getServer().getPluginManager().registerEvents(new CommonInventoryListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CommonItemInteractListener(), plugin);
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}