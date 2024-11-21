package com.mixinpowered.network.lib.session;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Session {
    private final Minigame minigame;
    private final List<UUID> playersUuids;
    private SessionState state;
    private final SessionMap map;
    private final int minPlayers;
    private final int maxPlayers;

    public Session(Minigame minigame, int maxPlayers, int minPlayers) {
        this.minigame = minigame;
        this.playersUuids = new ArrayList<>();
        this.state = SessionState.WAITING;
        this.map = new SessionMap();
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        init();
    }

    private void init() {
        if (minPlayers > maxPlayers) throw new IllegalArgumentException("Minimum players cannot be greater than maximum players");
        minigame.waiting(this);
    }

    public void setState(SessionState state) {
        this.state = state;
        switch (state) {
            case WAITING -> minigame.waiting(this);
            case PLAYING -> minigame.playing(this);
            case ENDING -> minigame.ending(this);
        }
    }

    public void addPlayer(UUID uuid, Component component) {
        playersUuids.add(uuid);
        // TODO: Teleport player to session
        broadcast(component);
    }

    public void removePlayer(UUID uuid, Component component) {
        playersUuids.remove(uuid);
        // TODO: Teleport player to the lobby
        broadcast(component);
    }

    public void rejoinPlayer(UUID uuid, Component component) {
        // TODO: see if player can rejoin and add to the game
        broadcast(component);
    }

    public void broadcast(Component component) {
        playersUuids.forEach(uuid -> {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) return;
            player.sendMessage(component);
        });
    }
}
