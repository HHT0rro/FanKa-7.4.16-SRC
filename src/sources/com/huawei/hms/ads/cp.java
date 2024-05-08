package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cp extends cx<TextView> {
    public cp(TextView textView) {
        super(textView);
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
        ((TextView) this.Code).setMinWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((TextView) this.Code).getContext()));
    }
}
