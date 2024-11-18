package com.mixinpowered.network.lib.listeners;

import com.mixinpowered.network.lib.Lib;
import com.mixinpowered.network.lib.builder.Menu;
import com.mixinpowered.network.lib.builder.Stack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.net.http.WebSocket;

public class CommonInventoryListener implements Listener {
    private BukkitTask updateTask;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        if (inventory.getHolder(false) instanceof Menu menu) {
            if (!menu.getItems().containsKey(slot)) return;
            Stack item = menu.getItems().get(slot);

            event.setCancelled(true);
            if (item.getClickConsumer() != null) item.getClickConsumer().accept(player);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof Menu) {
            if (updateTask != null && !updateTask.isCancelled()) {
                updateTask.cancel();
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();
        BukkitScheduler scheduler = Lib.getPlugin().getServer().getScheduler();

        if (inventory.getHolder(false) instanceof Menu menu) {
            updateTask = new BukkitRunnable() {
                @Override
                public void run() {
                    menu.build();
                }
            }.runTaskTimer(Lib.getPlugin(), 0L, 20L);
        }
    }
}
