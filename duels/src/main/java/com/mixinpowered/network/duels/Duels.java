package com.mixinpowered.network.duels;

import com.mixinpowered.network.duels.commands.JoinCommand;
import com.mixinpowered.network.duels.commands.LeaveCommand;
import com.mixinpowered.network.lib.I18n.I18n;
import com.mixinpowered.network.lib.Lib;
import com.mixinpowered.network.lib.board.Board;
import com.mixinpowered.network.lib.session.Minigame;
import com.mixinpowered.network.lib.session.Session;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Duels extends JavaPlugin implements Minigame {
    private static Duels instance;

    @Override
    public void onEnable() {
        instance = this;
        Lib.init(this);
        I18n.setupInternationalization();
        Board.registerGroups();

        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register(JoinCommand.brigadier(), "Join the queue or duels match.");
            commands.register(LeaveCommand.brigadier(), "Leave the queue or duels match.");
        });

        getLogger().info("Duels has been enabled!");
    }

    @Override
    public void onDisable() {
        Board.unregisterGroups();
        getLogger().info("Duels has been disabled!");
    }

    @Override
    public void waiting(Session session) {

    }

    @Override
    public void playing(Session session) {

    }

    @Override
    public void ending(Session session) {

    }

    public static Duels getInstance() {
        return instance;
    }
}