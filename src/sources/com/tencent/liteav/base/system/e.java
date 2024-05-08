package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final e f42847a = new e();

    private e() {
    }

    public static Callable a() {
        return f42847a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.c();
    }
}
