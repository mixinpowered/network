package com.mixinpowered.network.lib.api.data;

import java.util.Date;
import java.util.UUID;

public record PlayerData(
        UUID uuid,
        String group,
        Date groupExpiresAt,
        Date joinedAt,
        Date lastSeenAt
) {}
