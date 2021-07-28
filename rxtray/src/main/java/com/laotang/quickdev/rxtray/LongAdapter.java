package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class LongAdapter implements RealPreference.Adapter<Long> {
    static final LongAdapter INSTANCE = new LongAdapter();

    static final ExpireAdapterDelegate<Long> DELEGATE = new ExpireAdapterDelegate<Long>() {
        @Override
        Long getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull Long defaultValue) {
            return preferences.getLong(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull Long value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    @NonNull
    @Override
    public Long get(@NonNull String key, @NonNull TrayPreferences preferences,
                    @NonNull Long defaultValue) {
        return DELEGATE.get(key, preferences, defaultValue);
    }

    @Override
    public void set(@NonNull String key, @NonNull Long value,
                    @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull Long value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, saveTime, preferences);
    }
}
