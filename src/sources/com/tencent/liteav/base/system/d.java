package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final d f42846a = new d();

    private d() {
    }

    public static Callable a() {
        return f42846a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.b();
    }
}
