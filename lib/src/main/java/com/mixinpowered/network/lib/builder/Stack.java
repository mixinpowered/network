package com.mixinpowered.network.lib.builder;

import com.mixinpowered.network.lib.registry.StackRegistry;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Getter
@Setter
public class Stack {
    private final Material material;
    private final ItemStack stack;
    private ItemMeta meta;
    private Consumer<Player> clickConsumer;
    private Consumer<Player> interactConsumer;

    public Stack(Material material) {
        this.material = material;
        this.stack = new ItemStack(material);
        this.meta = stack.getItemMeta();
    }

    public Stack setAmount(int amount) {
        if (amount <= 0 || amount > 64) stack.setAmount(1);
        else stack.setAmount(amount);
        return this;
    }

    public Stack setDisplayName(Component component) {
        meta.displayName(component.decoration(TextDecoration.ITALIC, false));
        return this;
    }

    public Stack setLore(Component... components) {
        List<Component> componentList = Arrays.stream(components)
                .map(component -> component.decoration(TextDecoration.ITALIC, false).color(NamedTextColor.GRAY))
                .toList();

        meta.lore(componentList);
        return this;
    }

    public Stack onClick(Consumer<Player> consumer) {
        this.clickConsumer = consumer;
        return this;
    }

    public Stack onInteract(Consumer<Player> consumer) {
        this.interactConsumer = consumer;
        return this;
    }

    public Stack build() {
        stack.setItemMeta(meta);
        StackRegistry.getInstance().register(this);
        return this;
    }
}

