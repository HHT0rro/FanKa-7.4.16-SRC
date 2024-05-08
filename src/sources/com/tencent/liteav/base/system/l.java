package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final l f42854a = new l();

    private l() {
    }

    public static Callable a() {
        return f42854a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Integer valueOf;
        valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        return valueOf;
    }
}
