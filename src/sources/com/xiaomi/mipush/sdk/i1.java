package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f47023b;

    public i1(Context context) {
        this.f47023b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f47023b.getPackageManager().getPackageInfo(this.f47023b.getPackageName(), 4612);
            x.j(this.f47023b);
            x.l(this.f47023b, packageInfo);
            x.k(this.f47023b, packageInfo);
        } catch (Throwable unused) {
        }
    }
}
