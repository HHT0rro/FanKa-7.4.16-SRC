package cc;

import android.content.Context;
import ec.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static c f1593a;

    public static synchronized boolean a() {
        synchronized (a.class) {
            return f1593a != null;
        }
    }

    public static void b(Context context, b bVar) {
        try {
            c a10 = f.a(context);
            f1593a = a10;
            if (a10 == null) {
                return;
            }
            a10.a(bVar);
        } catch (Exception unused) {
        }
    }
}
