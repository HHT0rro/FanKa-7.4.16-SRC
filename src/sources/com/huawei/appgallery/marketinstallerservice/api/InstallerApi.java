package com.huawei.appgallery.marketinstallerservice.api;

import aa.b;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import fa.a;
import y9.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InstallerApi {
    public static void getMarketInfo(@NonNull Context context, @NonNull BaseParamSpec baseParamSpec, InstallCallback installCallback) {
        c cVar = (c) b.a(c.class);
        if (cVar != null) {
            cVar.b(context, baseParamSpec, installCallback);
        } else {
            a.c("InstallerApi", "getMarketInfo impl error!");
        }
    }

    public static void installMarket(@NonNull Activity activity, @NonNull InstallParamSpec installParamSpec, InstallCallback installCallback) {
        c cVar = (c) b.a(c.class);
        if (cVar != null) {
            cVar.a(activity, installParamSpec, installCallback);
        } else {
            a.c("InstallerApi", "installMarket impl error!");
        }
    }
}
