package bc;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f1463a;

    /* renamed from: b, reason: collision with root package name */
    public static c f1464b;

    /* renamed from: c, reason: collision with root package name */
    public static SharedPreferences.Editor f1465c;

    public c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sso_oaid_save.txt", 0);
        f1463a = sharedPreferences;
        f1465c = sharedPreferences.edit();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = f1464b;
            if (cVar == null) {
                throw new RuntimeException("please init first!");
            }
        }
        return cVar;
    }

    public static synchronized void c(Context context) {
        synchronized (c.class) {
            if (f1464b == null) {
                f1464b = new c(context);
            }
        }
    }

    public final synchronized String b(String str, String str2) {
        return f1463a.getString(str, str2);
    }

    public final synchronized void d(String str, String str2) {
        f1465c.putString(str, str2).commit();
    }
}
