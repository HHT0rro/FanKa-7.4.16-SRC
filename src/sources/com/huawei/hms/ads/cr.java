package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.LinearLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cr extends cx<LinearLayout> {
    public cr(LinearLayout linearLayout) {
        super(linearLayout);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "orientation";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        LinearLayout linearLayout;
        int i10;
        if (TextUtils.equals(str2, "vertical")) {
            linearLayout = (LinearLayout) this.Code;
            i10 = 1;
        } else {
            linearLayout = (LinearLayout) this.Code;
            i10 = 0;
        }
        linearLayout.setOrientation(i10);
    }
}
