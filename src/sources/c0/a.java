package c0;

import android.content.Context;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a10;
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                if (!z.a.d(str) && !z.a.d(str2)) {
                    try {
                        a10 = e.a(context, str, str2, "");
                    } catch (Throwable unused) {
                    }
                    if (z.a.d(a10)) {
                        return null;
                    }
                    str3 = a0.c.f(a0.c.a(), a10);
                    return str3;
                }
            }
            return null;
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (z.a.d(str) || z.a.d(str2) || context == null) {
                return;
            }
            try {
                String b4 = a0.c.b(a0.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, b4);
                e.b(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }
}
