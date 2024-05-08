package com.tencent.liteav.base.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final t<PackageInfo> f42843a = new t<>(b.a());

    public static String a() {
        PackageInfo a10 = f42843a.a();
        return a10 == null ? "" : a10.packageName;
    }

    public static String b() {
        PackageInfo a10;
        Context applicationContext = ContextUtils.getApplicationContext();
        return (applicationContext == null || (a10 = f42843a.a()) == null) ? "" : applicationContext.getPackageManager().getApplicationLabel(a10.applicationInfo).toString();
    }

    public static String c() {
        PackageInfo a10 = f42843a.a();
        return a10 == null ? "" : a10.versionName;
    }

    public static /* synthetic */ PackageInfo d() throws Exception {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
    }
}
