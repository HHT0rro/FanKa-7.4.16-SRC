package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IPV6Request.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class cd extends dz {
    @Override // com.amap.api.col.s.dz
    public String a() {
        if (TextUtils.isEmpty(b())) {
            return b();
        }
        String b4 = b();
        Uri parse = Uri.parse(b4);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return b4;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
