package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cu extends cx<ProgressButton> {
    public cu(ProgressButton progressButton) {
        super(progressButton);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "maxWidth";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((ProgressButton) this.Code).setMaxWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((ProgressButton) this.Code).getContext()));
    }
}
