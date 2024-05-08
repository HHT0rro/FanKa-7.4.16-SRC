package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class i implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final i f42851a = new i();

    private i() {
    }

    public static Callable a() {
        return f42851a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.MANUFACTURER;
        return str;
    }
}
