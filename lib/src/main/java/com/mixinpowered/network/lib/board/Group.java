package com.mixinpowered.network.lib.board;

import lombok.Getter;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

@Getter
public class Group {
    private final Team team;
    private final GroupLabel label;

    public Group(GroupLabel label, Scoreboard scoreboard) {
        this.label = label;
        this.team = scoreboard.registerNewTeam(label.getName());
        team.color(NamedTextColor.GRAY);
        team.prefix(label.prefix());
    }
}
