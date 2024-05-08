package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class es extends er {
    private fr Code;

    public es(Context context) {
        this.Code = fr.Code(context);
    }

    @Override // com.huawei.hms.ads.er
    public boolean Code() {
        if (this.Code.h() >= com.huawei.openalliance.ad.utils.v.Code()) {
            return true;
        }
        return V();
    }
}
