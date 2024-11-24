package com.mixinpowered.network.lib.api.adapters;

import com.mixinpowered.network.lib.api.data.PlayerData;
import com.mixinpowered.network.lib.api.json.PlayerJson;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class PlayerAdapter {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    @ToJson
    PlayerJson toJson(PlayerData data) {
        return new PlayerJson(
                data.uuid().toString(),
                data.group(),
                data.groupExpiresAt() != null ? dateFormat.format(data.groupExpiresAt()) : null,
                dateFormat.format(data.joinedAt()),
                dateFormat.format(data.lastSeenAt())
        );
    }

    @FromJson
    PlayerData fromJson(PlayerJson data) throws ParseException {
        return new PlayerData(
                UUID.fromString(data.uuid()),
                data.group(),
                data.groupExpiresAt() != null ? dateFormat.parse(data.groupExpiresAt()) : null,
                dateFormat.parse(data.joinedAt()),
                dateFormat.parse(data.lastSeenAt())
        );
    }
}