package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f46175c;

    /* renamed from: a, reason: collision with root package name */
    private a f46176a;

    /* renamed from: b, reason: collision with root package name */
    private Context f46177b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f46175c == null) {
                f46175c = new b();
            }
            bVar = f46175c;
        }
        return bVar;
    }

    public final synchronized a a(Context context) {
        a aVar = this.f46176a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            Context context2 = ContextDelegate.getContext(context.getApplicationContext());
            this.f46177b = context2;
            this.f46176a = new c(context2);
        }
        return this.f46176a;
    }
}
