package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ck extends cx {
    public ck(View view) {
        super(view);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "id";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.Code.setId(com.huawei.hms.ads.template.util.a.Code(str2.hashCode()));
    }
}
