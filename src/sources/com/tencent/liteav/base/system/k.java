package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final k f42853a = new k();

    private k() {
    }

    public static Callable a() {
        return f42853a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.VERSION.RELEASE;
        return str;
    }
}
