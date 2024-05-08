package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.DislikeAdReason;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class br implements DislikeAdReason {
    private String Code;

    public br(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.nativead.DislikeAdReason
    public String getDescription() {
        return this.Code;
    }
}
