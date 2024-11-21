package com.mixinpowered.network.lib.registry;

import com.mixinpowered.network.lib.builder.Stack;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class StackRegistry implements Registry<Stack> {
    private static StackRegistry instance;
    private final List<Stack> items;

    public StackRegistry() {
        instance = this;
        items = new ArrayList<>();
    }

    @Override
    public void register(Stack record) {
        items.add(record);
    }

    @Override
    public void unregister(Stack record) {
        items.remove(record);
    }

    public Stack getStack(ItemStack stack) {
        return items.stream()
                .filter(item -> item.getStack().equals(stack))
                .findFirst()
                .orElse(null);
    }

    public List<Stack> getItems() {
        return items;
    }

    public static StackRegistry getInstance() {
        if (instance == null) {
            instance = new StackRegistry();
        }
        return instance;
    }
}
