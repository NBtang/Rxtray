package com.laotang.quickdev.rxtray;

import androidx.annotation.NonNull;

import net.grandcentrix.tray.TrayPreferences;

abstract public class ExpireAdapterDelegate<T> implements RealPreference.Adapter<T> {

    @NonNull
    @Override
    public T get(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull T defaultValue) {
        String expireKey = "expire" + key;
        String expireValue = preferences.getString(expireKey, "");
        assert expireValue != null;
        if (expireValue.isEmpty()) {
            //未设置过期时间
            return getValue(key, preferences, defaultValue);
        }
        String[] time = expireValue.split("-");
        if (isDue(Long.parseLong(time[0]), Integer.parseInt(time[1]))) {
            //已过期，删除缓存，返回默认值
            preferences.remove(expireKey);
            preferences.remove(key);
            return defaultValue;
        }
        //未过期
        return getValue(key, preferences, defaultValue);
    }

    @Override
    final public void set(@NonNull String key, @NonNull T value, @NonNull TrayPreferences preferences) {
        setValue(key, value, preferences);
    }

    @Override
    final public void set(@NonNull String key, @NonNull T value, int saveTime, @NonNull TrayPreferences preferences) {
        //缓存有过期时间，保存缓存时间
        String expireValue = System.currentTimeMillis() + "-" + saveTime;
        preferences.put("expire" + key, expireValue);
        //保存缓存
        set(key, value, preferences);
    }

    private boolean isDue(long saveTime, int deleteAfter) {
        return System.currentTimeMillis() > saveTime + deleteAfter * 1000;
    }

    abstract T getValue(@NonNull String key, @NonNull TrayPreferences preferences, @NonNull T defaultValue);

    abstract void setValue(@NonNull String key, @NonNull T value, @NonNull TrayPreferences preferences);
}
