package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final h f42850a = new h();

    private h() {
    }

    public static Callable a() {
        return f42850a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.BRAND;
        return str;
    }
}
