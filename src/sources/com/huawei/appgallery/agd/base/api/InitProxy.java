package com.huawei.appgallery.agd.base.api;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class InitProxy {
    public static boolean a(@NonNull Context context, String str) throws ReflectiveOperationException {
        try {
            return ((InitProxy) Class.forName(str).newInstance()).init(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            j9.a.f50348d.e("InitProxy", e2.getClass().getSimpleName() + e2.getMessage());
            throw e2;
        }
    }

    public static Pair<Boolean, String> initDynamicModule(@NonNull Context context) {
        boolean z10;
        boolean z11 = true;
        try {
        } catch (ReflectiveOperationException unused) {
            z10 = true;
        }
        if (!a(context, "com.huawei.appgallery.agd.nativead.impl.NativeInitImpl")) {
            j9.a.f50348d.e("InitProxy", "initDynamicModule failed for nativead");
            return new Pair<>(Boolean.FALSE, AgdManager.SOURCE_NATIVE);
        }
        z10 = false;
        if (!a(context, "com.huawei.appgallery.agd.agdpro.impl.InitImpl")) {
            j9.a.f50348d.e("InitProxy", "initDynamicModule failed for agdpro");
            return new Pair<>(Boolean.FALSE, AgdManager.SOURCE_AGD_PRO);
        }
        z11 = false;
        if (z11 & z10) {
            return new Pair<>(Boolean.FALSE, "none");
        }
        return new Pair<>(Boolean.TRUE, null);
    }

    public abstract boolean init(@NonNull Context context);
}
