package com.mixinpowered.network.duels.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public class JoinCommand {
    public static LiteralCommandNode<CommandSourceStack> brigadier() {
        return Commands.literal("join")
                .requires(context -> context.getSender().hasPermission("duels.join"))
                .executes(context -> {
                    // TODO: handle the player join
                    return Command.SINGLE_SUCCESS;
                })
                .build();
    }
}
