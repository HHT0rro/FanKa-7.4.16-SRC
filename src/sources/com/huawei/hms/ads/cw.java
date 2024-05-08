package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.view.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cw extends cx<View> {
    public cw(View view) {
        super(view);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "rectRadius";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.Code instanceof b) {
            ((b) this.Code).setRectRoundCornerRadius(com.huawei.hms.ads.template.util.a.Code(str2, r2.getContext()));
        }
    }
}
