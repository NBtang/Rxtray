package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class StringAdapter implements RealPreference.Adapter<String> {
    static final StringAdapter INSTANCE = new StringAdapter();

    static final ExpireAdapterDelegate<String> DELEGATE = new ExpireAdapterDelegate<String>() {
        @Override
        String getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull String defaultValue) {
            return preferences.getString(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull String value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    @NonNull
    @Override
    public String get(@NonNull String key, @NonNull TrayPreferences preferences,
                      @NonNull String defaultValue) {
        //noinspection ConstantConditions
        return DELEGATE.get(key, preferences, defaultValue);
    }

    @Override
    public void set(@NonNull String key, @NonNull String value,
                    @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull String value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, saveTime, preferences);
    }
}
