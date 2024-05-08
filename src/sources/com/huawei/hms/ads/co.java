package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class co extends cx<TextView> {
    public co(TextView textView) {
        super(textView);
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
        ((TextView) this.Code).setMaxWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((TextView) this.Code).getContext()));
    }
}
