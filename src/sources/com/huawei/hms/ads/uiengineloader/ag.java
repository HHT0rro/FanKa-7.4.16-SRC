package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ag implements ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29429a = "PreHiOrDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.ah
    public final q a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        aa.b(f29429a, "getLoadingStrategy");
        try {
            int b4 = p.b(context, string);
            int i10 = o.b(context, string).f29485d;
            aa.b(f29429a, "3 module_name:" + string + ", hmsModuleVersion:" + b4 + ", assetModuleVersion:0, decompressedModuleVersion:" + i10);
            if (b4 > 0 && b4 > i10) {
                aa.b(f29429a, "Choose the HMSLoadStrategy");
                return new p();
            }
            if (i10 > 0) {
                aa.b(f29429a, "Choose the DecompressLoadStrategy");
                return new o();
            }
            aa.d(f29429a, "PreferHighestOrRemote: Cannot find a valid module version.");
            return null;
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Throwable th) {
            "getLoadingStrategy other exception.".concat(String.valueOf(th));
            return null;
        }
    }
}
