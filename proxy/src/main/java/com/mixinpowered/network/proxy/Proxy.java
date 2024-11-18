package com.mixinpowered.network.proxy;

import com.google.inject.Inject;
import com.mixinpowered.network.lib.I18n.I18n;
import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.mixinpowered.network.proxy.commands.BanCommand;
import com.mixinpowered.network.proxy.commands.KickCommand;
import com.mixinpowered.network.proxy.commands.TempBanCommand;
import com.mixinpowered.network.proxy.commands.UnbanCommand;
import org.slf4j.Logger;

@Plugin(
        id = "proxy",
        name = "Proxy",
        version = "0.0.0-SNAPSHOT",
        description = "A simple velocity plugin to manage the proxy",
        authors = {"Hyro32"}
)
public class Proxy {
    private final ProxyServer proxy;
    private final Logger logger;

    @Inject
    public Proxy(ProxyServer proxy, Logger logger) {
        this.proxy = proxy;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        registerCommands();
        I18n.setupInternationalization();
        logger.info("Proxy has been initialized!");
    }

    private void registerCommands() {
        // Register /ban command
        BrigadierCommand banCommand = BanCommand.createBrigadierCommand(proxy);
        proxy.getCommandManager().register(banCommand);

        // Register /tempban command
        BrigadierCommand tempBanCommand = TempBanCommand.createBrigadierCommand(proxy);
        proxy.getCommandManager().register(tempBanCommand);

        // Register /kick command
        BrigadierCommand kickCommand = KickCommand.createBrigadierCommand(proxy);
        proxy.getCommandManager().register(kickCommand);

        // Register /unban command
        BrigadierCommand unbanCommand = UnbanCommand.createBrigadierCommand(proxy);
        proxy.getCommandManager().register(unbanCommand);

        logger.info("All commands have been registered.");
    }

}
