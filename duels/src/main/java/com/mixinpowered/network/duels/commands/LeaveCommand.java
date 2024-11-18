package com.mixinpowered.network.duels.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public class LeaveCommand {
    public static LiteralCommandNode<CommandSourceStack> brigadier() {
        return Commands.literal("leave")
                .requires(context -> context.getSender().hasPermission("duels.leave"))
                .executes(context -> {
                    // TODO: handle the player leave
                    return Command.SINGLE_SUCCESS;
                })
                .build();
    }
}
