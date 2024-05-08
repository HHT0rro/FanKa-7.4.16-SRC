package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.u;
import java.lang.reflect.Method;

/* compiled from: ConfigManagerFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f46139a;

    /* renamed from: b, reason: collision with root package name */
    private d f46140b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f46139a == null) {
                f46139a = new b();
            }
            bVar = f46139a;
        }
        return bVar;
    }

    public final d a(Context context) {
        d dVar = this.f46140b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = ClientConfigManagerImpl.class.getMethod("getInstance", Context.class);
            u.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            d dVar2 = (d) method.invoke(null, context);
            this.f46140b = dVar2;
            return dVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
