package com.mixinpowered.network.lib.api.adapters;

import com.mixinpowered.network.lib.api.data.PlayerData;
import com.mixinpowered.network.lib.api.json.PlayerJson;
import com.mixinpowered.network.lib.board.GroupLabel;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.Date;
import java.util.UUID;

public class PlayerAdapter {
    @ToJson
    PlayerJson toJson(PlayerData data) {
        return new PlayerJson(
                data.uuid().toString(),
                data.groupLabel().toString(),
                data.groupExpiresAt().toString(),
                data.joinedAt().toString(),
                data.lastSeenAt().toString()
        );
    }

    @FromJson
    PlayerData fromJson(PlayerJson data) {
        return new PlayerData(
                UUID.fromString(data.uuid()),
                GroupLabel.valueOf(data.groupLabel()),
                new Date(data.groupExpiresAt()),
                new Date(data.joinedAt()),
                new Date(data.lastSeenAt())
        );
    }
}
