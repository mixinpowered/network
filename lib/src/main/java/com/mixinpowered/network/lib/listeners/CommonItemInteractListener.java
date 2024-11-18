package com.mixinpowered.network.lib.listeners;

import com.mixinpowered.network.lib.builder.Stack;
import com.mixinpowered.network.lib.registry.StackRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CommonItemInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        Stack stack = StackRegistry.getInstance().getStack(item);

        if (event.getAction().isRightClick() && stack != null) {
            event.setCancelled(true);

            if (stack.getInteractConsumer() != null) {
                stack.getInteractConsumer().accept(player);
            }
        }
    }
}
