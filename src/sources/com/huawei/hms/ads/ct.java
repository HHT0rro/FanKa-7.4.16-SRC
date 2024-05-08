package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ct extends cx<ProgressButton> {
    public ct(ProgressButton progressButton) {
        super(progressButton);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "fixedWidth";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ((ProgressButton) this.Code).setFixedWidth(Boolean.parseBoolean(str2));
        } catch (IllegalArgumentException e2) {
            gl.I("ProgressButtonFixedWithHandler", "processAttribute - parse fixedWidth error", e2);
        }
    }
}
