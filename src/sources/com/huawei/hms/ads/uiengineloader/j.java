package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j implements f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29451a = "PathClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.f
    public final ClassLoader a(Context context, String str, int i10, PackageInfo packageInfo) {
        aa.b(f29451a, "begin to new classloader, armeabiType:".concat(String.valueOf(i10)));
        return new com.huawei.hms.ads.dynamicloader.d(e.a(context, str, packageInfo), e.b(context, str, packageInfo), context.getClassLoader());
    }
}
