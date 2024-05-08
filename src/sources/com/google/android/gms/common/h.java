package com.google.android.gms.common;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f23547a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static Context f23548b;

    public static synchronized void a(Context context) {
        synchronized (h.class) {
            if (f23548b != null || context == null) {
                return;
            }
            f23548b = context.getApplicationContext();
        }
    }
}
