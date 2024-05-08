package com.tencent.liteav.base.util;

import com.tencent.liteav.base.ContextUtils;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final k f42893a = new k();

    private k() {
    }

    public static Callable a() {
        return f42893a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Boolean valueOf;
        valueOf = Boolean.valueOf(j.a(ContextUtils.getApplicationContext()));
        return valueOf;
    }
}
