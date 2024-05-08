package com.huawei.hms.ads;

import android.graphics.Color;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.a;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ca extends cx<com.huawei.openalliance.ad.views.AppDownloadButton> {
    public ca(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(appDownloadButton);
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
            int parseColor = Color.parseColor(str2);
            com.huawei.openalliance.ad.views.a style = ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getStyle();
            a.C0341a Code = style.Code();
            a.C0341a V = style.V();
            Code.Code(parseColor);
            V.Code(parseColor);
        } catch (IllegalArgumentException e2) {
            gl.I("AppDownloadButtonTextColorHandler", "processAttribute - parse color error", e2);
        }
    }
}
