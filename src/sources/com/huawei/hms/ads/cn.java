package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cn extends cx<TextView> {
    public cn(TextView textView) {
        super(textView);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "maxLines";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ((TextView) this.Code).setMaxLines(Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            gl.I("MaxLineHandler", "parse NumberFormatException");
        }
    }
}
