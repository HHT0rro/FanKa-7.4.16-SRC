package za;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f55045a;

    public static long a(String str, long j10, Context context) {
        return c(context).getLong(str, j10);
    }

    public static String b(String str, String str2, Context context) {
        return c(context).getString(str, str2);
    }

    public static synchronized SharedPreferences c(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (h.class) {
            if (f55045a == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f55045a = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
                } else {
                    f55045a = context.getApplicationContext().getSharedPreferences("aegis", 0);
                }
            }
            sharedPreferences = f55045a;
        }
        return sharedPreferences;
    }

    public static void d(String str, long j10, Context context) {
        c(context).edit().putLong(str, j10).apply();
    }

    public static void e(String str, String str2, Context context) {
        c(context).edit().putString(str, str2).apply();
    }
}
