package com.mixinpowered.net.lib

import org.bukkit.plugin.java.JavaPlugin

object Lib {
    lateinit var plugin: JavaPlugin

    fun initialize(plugin: JavaPlugin) {
        plugin.logger.info("Lib - Initialized!")
        this.plugin = plugin
    }
}