package com.mixinpowered.net.proxy

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger

@Plugin(
    id = "proxy",
    name = "Proxy",
    version = "0.0.0",
    description = "A proxy plugin",
    authors = ["MixinPowered"]
)
class Proxy @Inject constructor(private val proxy: ProxyServer, private val logger: Logger) {

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        logger.info("Proxy plugin initialized")
    }
}