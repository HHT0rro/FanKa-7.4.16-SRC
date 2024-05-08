package com.tencent.liteav.base.storage;

import android.content.SharedPreferences;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.Map;
import java.util.Set;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PersistStorage {
    public static final String GLOBAL_DOMAIN = "com.liteav.storage.global";
    private final SharedPreferences.Editor mEditor;
    private final SharedPreferences mSharedPreferences;

    @CalledByNative
    public PersistStorage(String str) {
        SharedPreferences sharedPreferences = ContextUtils.getApplicationContext().getSharedPreferences(str, 0);
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    @CalledByNative
    public static int integerToBase(Integer num) {
        return num.intValue();
    }

    @CalledByNative
    public static long longToBase(Long l10) {
        return l10.longValue();
    }

    @CalledByNative
    public void clear(String str) {
        this.mEditor.remove(str);
    }

    @CalledByNative
    public void commit() {
        this.mEditor.commit();
    }

    @CalledByNative
    public String[] getAllKeys() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        if (all == null || all.isEmpty()) {
            return new String[0];
        }
        Set<String> h10 = all.h();
        return (String[]) h10.toArray(new String[h10.size()]);
    }

    @CalledByNative
    public Integer getInt(String str) {
        if (!this.mSharedPreferences.contains(str)) {
            return null;
        }
        try {
            return Integer.valueOf(this.mSharedPreferences.getInt(str, -1));
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @CalledByNative
    public Long getLong(String str) {
        if (!this.mSharedPreferences.contains(str)) {
            return null;
        }
        try {
            return Long.valueOf(this.mSharedPreferences.getLong(str, -1L));
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @CalledByNative
    public String getString(String str) {
        if (!this.mSharedPreferences.contains(str)) {
            return null;
        }
        try {
            return this.mSharedPreferences.getString(str, null);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @CalledByNative
    public void put(String str, int i10) {
        this.mEditor.putInt(str, i10);
    }

    @CalledByNative
    public void put(String str, long j10) {
        this.mEditor.putLong(str, j10);
    }

    @CalledByNative
    public void put(String str, String str2) {
        this.mEditor.putString(str, str2);
    }
}
