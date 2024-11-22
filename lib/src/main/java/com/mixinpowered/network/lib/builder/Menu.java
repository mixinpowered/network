package com.mixinpowered.network.lib.builder;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Menu implements InventoryHolder {
    private Inventory inventory;
    private Component title;
    private int rows;
    private final Map<Integer, Stack> items;

    public Menu() {
        this.title = Component.text("Menu");
        this.rows = 3;
        this.items = new HashMap<>();
        this.inventory = Bukkit.createInventory(this, rows * 9, title);
    }

    public Menu setTitle(Component title) {
        this.title = title;
        return this;
    }

    public Menu setRows(int rows) {
        this.rows = rows;
        this.inventory = Bukkit.createInventory(this, rows * 9, title);
        return this;
    }

    public Menu setItem(int slot, Stack item) {
        items.put(slot, item);
        return this;
    }

    public Menu fillColumn(int column, Material material) {
        for (int i = 0; i < rows; i++) {
            int slot = i * 9 + column;
            if (inventory.getItem(slot) != null) continue;
            Stack item = new Stack(material);
            setItem(i * 9 + column, item);
        }
        return this;
    }

    public Menu fillRow(int row, Material material) {
        for (int i = 0; i < 9; i++) {
            int slot = row * 9 + i;
            if (inventory.getItem(slot) != null) continue;
            Stack item = new Stack(material);
            setItem(row * 9 + i, item);
        }
        return this;
    }

    public Menu build() {
        items.forEach((slot, item) -> inventory.setItem(slot, item.getStack()));
        return this;
    }

    public int getRows() {
        return rows;
    }

    public Map<Integer, Stack> getItems() {
        return items;
    }

    public Component getTitle() {
        return title;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
