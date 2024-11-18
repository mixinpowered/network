package com.mixinpowered.network.lib.board;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

@Getter
public enum GroupLabel {
    OWNER("OWNER", NamedTextColor.GOLD, true),
    ADMIN("ADMIN", NamedTextColor.DARK_RED, true),
    MODERATOR("MODERATOR", NamedTextColor.DARK_GREEN, true),
    RED("R", NamedTextColor.RED),
    BLUE("B", NamedTextColor.BLUE),
    GREEN("G", NamedTextColor.GREEN),
    YELLOW("Y", NamedTextColor.YELLOW),
    ORANGE("O", NamedTextColor.GOLD),
    AQUA("A", NamedTextColor.AQUA),
    PURPLE("P", NamedTextColor.LIGHT_PURPLE),
    WHITE("W", NamedTextColor.WHITE),
    GRAY("G", NamedTextColor.GRAY);

    private final String name;
    private final NamedTextColor color;
    private final boolean permanent;

    GroupLabel(String name, NamedTextColor color) {
        this.name = name;
        this.color = color;
        this.permanent = false;
    }

    GroupLabel(String name, NamedTextColor color, boolean permanent) {
        this.name = name;
        this.color = color;
        this.permanent = permanent;
    }

    public Component prefix() {
        return Component.text("[", NamedTextColor.DARK_GRAY)
                .append(Component.text(name, color))
                .append(Component.text("]", NamedTextColor.DARK_GRAY))
                .appendSpace();
    }
}
