package com.mixinpowered.network.lib.api.data;

import com.mixinpowered.network.lib.board.GroupLabel;

import java.util.Date;
import java.util.UUID;

public record PlayerData(
        UUID uuid,
        GroupLabel groupLabel,
        Date groupExpiresAt,
        Date joinedAt,
        Date lastSeenAt
) {}
