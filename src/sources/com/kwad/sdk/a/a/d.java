package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.Cz().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String zS() {
        String CA = com.kwad.sdk.core.config.d.CA();
        return TextUtils.isEmpty(CA) ? "安装" : CA;
    }

    public static String zT() {
        String CB = com.kwad.sdk.core.config.d.CB();
        return TextUtils.isEmpty(CB) ? "取消" : CB;
    }
}
