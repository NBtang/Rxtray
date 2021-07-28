package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class IntegerAdapter implements RealPreference.Adapter<Integer> {
    static final IntegerAdapter INSTANCE = new IntegerAdapter();

    static final ExpireAdapterDelegate<Integer> DELEGATE = new ExpireAdapterDelegate<Integer>() {
        @Override
        Integer getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull Integer defaultValue) {
            return preferences.getInt(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull Integer value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    @NonNull
    @Override
    public Integer get(@NonNull String key, @NonNull TrayPreferences preferences,
                       @NonNull Integer defaultValue) {
        return DELEGATE.get(key, preferences, defaultValue);
    }

    @Override
    public void set(@NonNull String key, @NonNull Integer value,
                    @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull Integer value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, saveTime, preferences);
    }
}
