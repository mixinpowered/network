package com.mixinpowered.network.lib.api.json;

public record PlayerJson(
        String uuid,
        String groupLabel,
        String groupExpiresAt,
        String joinedAt,
        String lastSeenAt
) {}
