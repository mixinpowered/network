package com.mixinpowered.network.lib.board;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Group {
    private final Team team;
    private final GroupLabel label;

    public Group(GroupLabel label, Scoreboard scoreboard) {
        this.label = label;
        this.team = scoreboard.registerNewTeam(label.getName());
        team.color(NamedTextColor.GRAY);
        team.prefix(label.prefix());
    }

    public Team getTeam() {
        return team;
    }

    public GroupLabel getLabel() {
        return label;
    }
}
