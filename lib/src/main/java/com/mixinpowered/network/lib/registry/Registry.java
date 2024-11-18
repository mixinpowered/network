package com.mixinpowered.network.lib.registry;

public interface Registry<T> {
    void register(T value);
    void unregister(T value);
}
