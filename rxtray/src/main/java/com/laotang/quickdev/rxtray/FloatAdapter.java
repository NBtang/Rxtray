package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class FloatAdapter implements RealPreference.Adapter<Float> {
    static final FloatAdapter INSTANCE = new FloatAdapter();

    static final ExpireAdapterDelegate<Float> DELEGATE = new ExpireAdapterDelegate<Float>() {

        @Override
        Float getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull Float defaultValue) {
            return preferences.getFloat(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull Float value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    @NonNull
    @Override
    public Float get(@NonNull String key, @NonNull TrayPreferences preferences,
                     @NonNull Float defaultValue) {
        return DELEGATE.get(key, preferences, defaultValue);
    }

    @Override
    public void set(@NonNull String key, @NonNull Float value,
                    @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull Float value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value, saveTime, preferences);
    }
}
