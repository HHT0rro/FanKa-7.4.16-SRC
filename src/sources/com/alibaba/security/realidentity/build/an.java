package com.alibaba.security.realidentity.build;

import android.content.Context;
import java.lang.Thread;

/* compiled from: CrashManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f3085a;

    /* renamed from: b, reason: collision with root package name */
    public ao f3086b;

    private void a(Context context) {
        this.f3086b = new ao(this.f3085a, context);
    }

    private void b() {
        Thread.setDefaultUncaughtExceptionHandler(this.f3085a);
    }

    public final void a() {
        this.f3085a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this.f3086b);
    }
}
