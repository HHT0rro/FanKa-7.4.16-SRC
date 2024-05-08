package com.amap.api.col.s;

import android.content.Context;

/* compiled from: AdiuManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private static cs f7589a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7590b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7591c = cz.a(ci.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private cs(Context context) {
        this.f7590b = context.getApplicationContext();
    }

    public static cs a(Context context) {
        if (f7589a == null) {
            synchronized (cs.class) {
                if (f7589a == null) {
                    f7589a = new cs(context);
                }
            }
        }
        return f7589a;
    }

    public final synchronized void a() {
        try {
            if (ca.c() == null) {
                ca.a(cw.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        ct.a(this.f7590b).a(this.f7591c);
        ct.a(this.f7590b).b(str);
    }
}
