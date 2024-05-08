package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cv extends cx<ProgressButton> {
    public cv(ProgressButton progressButton) {
        super(progressButton);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return Attributes.Style.MIN_WIDTH;
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((ProgressButton) this.Code).setMinWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((ProgressButton) this.Code).getContext()));
    }
}
