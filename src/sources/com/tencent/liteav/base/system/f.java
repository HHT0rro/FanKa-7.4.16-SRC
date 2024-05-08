package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final f f42848a = new f();

    private f() {
    }

    public static Callable a() {
        return f42848a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String a10;
        a10 = o.a(LiteavSystemInfo.sAppPackageName.a());
        return a10;
    }
}
