package com.amap.api.col.p0003l;

import android.content.Context;

/* compiled from: AdiuManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class gk {

    /* renamed from: a, reason: collision with root package name */
    private static gk f6101a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6102b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6103c = gr.a(fv.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private gk(Context context) {
        this.f6102b = context.getApplicationContext();
    }

    public static gk a(Context context) {
        if (f6101a == null) {
            synchronized (gk.class) {
                if (f6101a == null) {
                    f6101a = new gk(context);
                }
            }
        }
        return f6101a;
    }

    public final synchronized void a() {
        try {
            if (fm.c() == null) {
                fm.a(go.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        gl.a(this.f6102b).a(this.f6103c);
        gl.a(this.f6102b).b(str);
    }
}
