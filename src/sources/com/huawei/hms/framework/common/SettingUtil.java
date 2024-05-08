package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i10) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i10);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e2);
            return i10;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i10) {
        try {
            return Settings.System.getInt(contentResolver, str, i10);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e2);
            return i10;
        }
    }
}
