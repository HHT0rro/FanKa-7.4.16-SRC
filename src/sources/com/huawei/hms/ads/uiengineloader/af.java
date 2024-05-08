package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class af implements ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29428a = "dl_PreferDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.ah
    public final q a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        try {
            if (o.b(context, string).f29485d > 0) {
                aa.b(f29428a, "Choose the decompressedModuleVersion");
                return new o();
            }
            if (p.b(context, string) > 0) {
                aa.b(f29428a, "Choose the HMSLoadStrategy");
                return new p();
            }
            aa.c(f29428a, "No available module version.");
            return null;
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception e10) {
            aa.c(f29428a, "getLoadingStrategy other exception." + e10.getClass().getSimpleName());
            return null;
        }
    }
}
