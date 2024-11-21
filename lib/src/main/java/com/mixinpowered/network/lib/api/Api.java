package com.mixinpowered.network.lib.api;

import com.mixinpowered.network.lib.api.adapters.PlayerAdapter;
import com.mixinpowered.network.lib.api.data.PlayerData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.UUID;

public class Api {
    private static final Moshi moshi = new Moshi.Builder()
            .add(new PlayerAdapter())
            .build();

    private static final String BASE_API_URL = "http://localhost:3000";
    private static final JsonAdapter<PlayerData> playerAdapter = moshi.adapter(PlayerData.class);

    public static PlayerData createPlayerData(PlayerData data) {
        try {
            String json = playerAdapter.toJson(data);
            HttpRequest.POST(BASE_API_URL + "/players", json);
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    public static PlayerData getPlayerData(UUID uuid) {
        try {
            String response = HttpRequest.GET(BASE_API_URL + "/players/" + uuid);
            return playerAdapter.fromJson(response);
        } catch (Exception e) {
            return null;
        }
    }
}
