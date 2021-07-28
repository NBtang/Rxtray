package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

final class EnumAdapter<T extends Enum<T>> implements RealPreference.Adapter<T> {
    private final Class<T> enumClass;

    private final ExpireAdapterDelegate<String> DELEGATE = new ExpireAdapterDelegate<String>() {
        @Override
        String getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull String defaultValue) {
            return preferences.getString(key, defaultValue);
        }

        @Override
        void setValue(@NonNull String key, @NonNull String value, @NonNull TrayPreferences preferences) {
            preferences.put(key, value);
        }
    };

    EnumAdapter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @NonNull
    @Override
    public T get(@NonNull String key, @NonNull TrayPreferences preferences,
                 @NonNull T defaultValue) {
        String value = DELEGATE.get(key, preferences, "");
        if (value.isEmpty()) return defaultValue;
        return Enum.valueOf(enumClass, value);
    }

    @Override
    public void set(@NonNull String key, @NonNull T value, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value.name(), preferences);
    }

    @Override
    public void set(@NonNull String key, @NonNull T value, int saveTime, @NonNull TrayPreferences preferences) {
        DELEGATE.set(key, value.name(), saveTime, preferences);
    }
}
