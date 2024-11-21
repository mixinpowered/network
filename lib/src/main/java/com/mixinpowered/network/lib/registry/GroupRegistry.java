package com.mixinpowered.network.lib.registry;

import com.mixinpowered.network.lib.board.Group;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class GroupRegistry implements Registry<Group> {
    private static GroupRegistry instance;
    private final List<Group> groups;

    public GroupRegistry() {
        instance = this;
        groups = new ArrayList<>();
    }

    @Override
    public void register(Group value) {
        groups.add(value);
    }

    @Override
    public void unregister(Group value) {
        groups.remove(value);
    }

    public Group getGroup(Team team) {
        return groups.stream()
                .filter(group -> group.getTeam() == team)
                .findFirst()
                .orElse(null);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public static GroupRegistry getInstance() {
        if (instance == null) {
            instance = new GroupRegistry();
        }
        return instance;
    }
}
