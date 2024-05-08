package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final b f42844a = new b();

    private b() {
    }

    public static Callable a() {
        return f42844a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.d();
    }
}
