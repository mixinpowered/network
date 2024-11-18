package com.mixinpowered.network.lib.board;

import com.mixinpowered.network.lib.registry.GroupRegistry;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Board {
    public static Scoreboard MAIN_SCOREBOARD = Bukkit.getScoreboardManager().getMainScoreboard();

    public static Scoreboard createNewScoreboard() {
        return Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public static void registerGroups() {
        for (GroupLabel group : GroupLabel.values()) {
            if (!group.isPermanent()) return;
            Team team = MAIN_SCOREBOARD.getTeam(group.getName());
            if (team == null) new Group(group, MAIN_SCOREBOARD);
        }
    }

    public static void unregisterGroups() {
        GroupRegistry.getInstance()
                .getGroups()
                .forEach(group -> group.getTeam().unregister());
    }
}
