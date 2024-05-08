package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class n implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final n f42856a = new n();

    private n() {
    }

    public static Callable a() {
        return f42856a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.a();
    }
}
