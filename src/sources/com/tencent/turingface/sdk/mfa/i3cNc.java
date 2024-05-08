package com.tencent.turingface.sdk.mfa;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i3cNc {

    /* renamed from: a, reason: collision with root package name */
    public static Context f45809a;

    public static synchronized boolean a(Context context) {
        synchronized (i3cNc.class) {
            if (f45809a != null) {
                return true;
            }
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            f45809a = applicationContext;
            return true;
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (i3cNc.class) {
            context = f45809a;
        }
        return context;
    }
}
