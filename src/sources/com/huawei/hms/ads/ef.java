package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ef extends ec {
    private static el I;
    private static final byte[] Z = new byte[0];
    private com.huawei.openalliance.ad.utils.j B;

    private ef(Context context) {
        super(context);
        this.B = new com.huawei.openalliance.ad.utils.j(context);
    }

    private static el I(Context context) {
        el elVar;
        synchronized (Z) {
            if (I == null) {
                I = new ef(context);
            }
            elVar = I;
        }
        return elVar;
    }

    public static el V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean Code() {
        return "CN".equalsIgnoreCase(this.B.Code());
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean I() {
        return false;
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean V() {
        return Code();
    }
}
