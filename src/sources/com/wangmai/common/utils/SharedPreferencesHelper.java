package com.wangmai.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SharedPreferencesHelper {
    public static final String PREFERENCE_KEY = "wm.preferences";
    public static final String TAG = "SharedPreferencesHelper";
    public static SharedPreferencesHelper instance;
    public final SharedPreferences preference;

    public SharedPreferencesHelper(Context context) {
        this.preference = context.getSharedPreferences(PREFERENCE_KEY, 0);
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesHelper(context);
        }
        return instance;
    }

    public void clearAllPreferences() {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.clear();
        edit.apply();
    }

    public boolean getPreferencesBoolean(String str, boolean z10) {
        return this.preference.getBoolean(str, z10);
    }

    public float getPreferencesFloat(String str, float f10) {
        return this.preference.getFloat(str, f10);
    }

    public int getPreferencesInteger(String str, int i10) {
        return this.preference.getInt(str, i10);
    }

    public long getPreferencesLong(String str, long j10) {
        return this.preference.getLong(str, j10);
    }

    public String getPreferencesString(String str) {
        return this.preference.getString(str, null);
    }

    public void savePreferencesBoolean(String str, boolean z10) {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.putBoolean(str, z10);
        edit.apply();
    }

    public void savePreferencesFloat(String str, float f10) {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.putFloat(str, f10);
        edit.apply();
    }

    public void savePreferencesInteger(String str, int i10) {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.putInt(str, i10);
        edit.apply();
    }

    public void savePreferencesLong(String str, long j10) {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.putLong(str, j10);
        edit.apply();
    }

    public void savePreferencesMap(Map<String, Object> map) {
        SharedPreferences.Editor edit = this.preference.edit();
        for (String str : map.h()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj != null) {
                edit.putString(str, obj.toString());
            } else {
                edit.putString(str, "");
            }
        }
        edit.apply();
    }

    public void savePreferencesString(String str, String str2) {
        SharedPreferences.Editor edit = this.preference.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getPreferencesString(String str, String str2) {
        return this.preference.getString(str, str2);
    }
}
