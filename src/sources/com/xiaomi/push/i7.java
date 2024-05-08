package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class i7 {
    public static void a(Context context) {
    }

    public static void b(Context context, String str, boolean z10) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z10).commit();
    }

    public static void c(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }

    public static boolean d(Context context, String str, boolean z10) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z10);
    }
}
