package com.huawei.hms.ads;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hs implements hw {
    public static final String Code = "appInfo";
    public static final String I = "downloadSource";
    public static final String V = "contentRecord";
    private static final String Z = "AppNotificationBaseAction";

    @Override // com.huawei.hms.ads.hw
    public void Code(Context context, Intent intent) {
        StringBuilder sb2;
        String str;
        try {
            com.huawei.openalliance.ad.inter.data.AppInfo appInfo = (com.huawei.openalliance.ad.inter.data.AppInfo) intent.getSerializableExtra("appInfo");
            AdContentData adContentData = (AdContentData) intent.getSerializableExtra("contentRecord");
            int intExtra = intent.getIntExtra(I, 1);
            if (appInfo != null && adContentData != null) {
                if (hx.Code(context).I(appInfo.Code())) {
                    Code(context, appInfo, adContentData, intExtra);
                    hx.Code(context).V(appInfo.Code());
                } else {
                    gl.V(Z, "packageName may be illegal:" + appInfo.Code());
                }
            }
        } catch (IllegalStateException e2) {
            e = e2;
            sb2 = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive IllegalStateException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            gl.I(Z, sb2.toString());
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            gl.I(Z, sb2.toString());
        }
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i10) {
        gl.V(Z, "do nothing at base action!");
    }
}
