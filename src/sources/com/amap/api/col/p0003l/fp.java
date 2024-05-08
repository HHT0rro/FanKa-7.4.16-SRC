package com.amap.api.col.p0003l;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IPV6Request.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class fp extends id {
    @Override // com.amap.api.col.p0003l.id
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.col.p0003l.id
    public boolean isSupportIPV6() {
        return true;
    }
}
