package com.mixinpowered.network.lib.session;

public interface Minigame {
    void waiting(Session session);
    void playing(Session session);
    void ending(Session session);
}
