package com.mixinpowered.network.lib.spawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class SpawnPoint {
    private World world;
    private final int x;
    private final int y;
    private final int z;
    private int yaw;
    private int pitch;

    public SpawnPoint(World world, int x, int y, int z, int yaw, int pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public SpawnPoint(int x, int y, int z, int yaw, int pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public SpawnPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location getSpawnPoint() {
        return new Location(world, x, y, z, yaw, pitch);
    }

    public void spawnPlayer(Player player) {
        player.teleport(getSpawnPoint());
    }

    public void spawnEntity(Entity entity) {
        entity.spawnAt(getSpawnPoint());
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getPitch() {
        return pitch;
    }

    public int getYaw() {
        return yaw;
    }

    public int getZ() {
        return z;
    }

    public int getY() {
        return y;
    }
}
