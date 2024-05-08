package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ht extends hs {
    private static final String Z = "AppNotificationDelete";

    @Override // com.huawei.hms.ads.hs
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i10) {
        if (adContentData == null) {
            gl.V(Z, "contentRecord is empty");
        } else {
            hu.Code(context, adContentData);
        }
    }
}
