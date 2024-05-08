package com.huawei.hms.ads;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cz extends cx<TextView> {
    public cz(TextView textView) {
        super(textView);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return IQuickText.Attrs.TEXT_COLOR;
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ((TextView) this.Code).setTextColor(Color.parseColor(str2));
        } catch (IllegalArgumentException unused) {
            gl.I("TextColorHandler", "processAttribute - parse color error");
        }
    }
}
