package com.mixinpowered.network.lib.api.json;

public record PlayerJson(
        String uuid,
        String group,
        String groupExpiresAt,
        String joinedAt,
        String lastSeenAt
) {}
