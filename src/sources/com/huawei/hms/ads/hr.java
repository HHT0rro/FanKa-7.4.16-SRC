package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hr extends hs {
    private static final String Z = "AppNotificationActivate";

    @Override // com.huawei.hms.ads.hs
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i10) {
        if (adContentData == null || appInfo == null) {
            gl.V(Z, "contentRecord is empty");
        } else {
            new com.huawei.openalliance.ad.download.app.h().Code(context, appInfo, adContentData, Integer.valueOf(i10), false);
            hu.V(context, adContentData);
        }
    }
}
