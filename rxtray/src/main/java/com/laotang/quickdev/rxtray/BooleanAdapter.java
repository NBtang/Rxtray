package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class BooleanAdapter implements RealPreference.Adapter<Boolean> {
    static final BooleanAdapter INSTANCE = new BooleanAdapter();

    static final ExpireAdapterDelegate<Boolean> DELEGATE = new ExpireAdapterDelegate<Boolean>() {
        @Override
        Boolean getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull Boolean defaultValue) {
            return preferences.getBoolean(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull Boolean value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    @NonNull
    @Override
    public Boolean get(@NonNull String key, @NonNull TrayPreferences preferences,
                       @NonNull Boolean defaultValue) {
        return DELEGATE.get(key, preferences, defaultValue);
    }

    @Override
    public void set(@NonNull String key, @NonNull Boolean value,
                    @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull Boolean value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, saveTime, preferences);
    }

}
