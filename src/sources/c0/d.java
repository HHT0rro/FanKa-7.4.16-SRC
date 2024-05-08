package c0;

import android.content.Context;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!z.a.d(str)) {
                if (!z.a.d(str2) && context != null) {
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
    }
}
