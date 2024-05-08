package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cy extends cx<TextView> {
    public cy(TextView textView) {
        super(textView);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "singleLine";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((TextView) this.Code).setSingleLine(Boolean.parseBoolean(str2));
    }
}
