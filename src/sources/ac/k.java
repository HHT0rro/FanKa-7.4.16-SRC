package ac;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("cuAuthCacheName", 0).getString(str, "");
        } catch (Exception e2) {
            h.h(e2.getMessage());
            return "";
        }
    }

    public static void b(Context context, String str, Long l10) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            edit.putLong(str, l10.longValue());
            edit.commit();
        } catch (Exception e2) {
            h.h(e2.getMessage());
        }
    }

    public static boolean c(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            edit.putString(str, str2);
            return edit.commit();
        } catch (Exception e2) {
            h.h(e2.getMessage());
            return false;
        }
    }

    public static Long d(Context context, String str) {
        long j10 = 0;
        try {
            j10 = context.getSharedPreferences("cuAuthCacheName", 0).getLong(str, 0L);
        } catch (Exception e2) {
            h.h(e2.getMessage());
        }
        return Long.valueOf(j10);
    }
}
