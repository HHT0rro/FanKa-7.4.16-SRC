package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {
    private static final String Code = "AppLauncher";

    private static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            gl.V(Code, "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    public boolean Code(Context context, AppInfo appInfo, AdContentData adContentData, Integer num, boolean z10) {
        if (context == null || appInfo == null) {
            gl.V(Code, "parameters occur error");
            return false;
        }
        String Code2 = appInfo.Code();
        if (com.huawei.openalliance.ad.utils.e.Code(context, Code2, appInfo.D())) {
            Code(context, appInfo);
            kv.Code(context, adContentData, "intentSuccess", (Integer) 1, (Integer) null);
            if (z10) {
                kv.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
            }
            return true;
        }
        gl.V(Code, "handClick, openAppIntent fail");
        kv.Code(context, adContentData, ae.D, (Integer) 1, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(context, Code2) ? 2 : 1));
        if (!com.huawei.openalliance.ad.utils.e.I(context, Code2)) {
            gl.V(Code, "handClick, openAppMainPage fail");
            return false;
        }
        kv.Code(context, adContentData, (Integer) 1);
        Code(context, appInfo);
        if (z10) {
            kv.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
        }
        return true;
    }
}
