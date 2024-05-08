package com.taobao.wireless.security.adapter.datacollection;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.datacollection.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0600 {

    /* renamed from: а, reason: contains not printable characters */
    private static Context f228;

    @TargetApi(3)
    /* renamed from: а, reason: contains not printable characters */
    public static String m2897() {
        try {
            String string = Settings.Secure.getString(f228.getContentResolver(), "android_id");
            return string != null ? string.trim() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m2898(File file) {
        if (file == null) {
            return null;
        }
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Long l10 = (Long) statFs.getClass().getDeclaredMethod("getAvailableBytes", new Class[0]).invoke(statFs, new Object[0]);
                if (l10 != null) {
                    return l10.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        long availableBlocks = statFs.getAvailableBlocks();
        return (statFs.getBlockCount() * availableBlocks) + "";
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m2899(Context context) {
        if (context == null || f228 != null) {
            return;
        }
        f228 = context;
    }

    /* renamed from: б, reason: contains not printable characters */
    public static String m2900() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null && dataDirectory.getAbsolutePath().length() != 0) {
                return m2898(dataDirectory);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
