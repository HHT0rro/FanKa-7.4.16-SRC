package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cb extends cx<com.huawei.openalliance.ad.views.AppDownloadButton> {
    public cb(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(appDownloadButton);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "textSize";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int Code = com.huawei.hms.ads.template.util.a.Code(str2, ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getContext());
        com.huawei.openalliance.ad.views.a style = ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getStyle();
        a.C0341a Code2 = style.Code();
        a.C0341a V = style.V();
        Code2.V(Code);
        V.V(Code);
        ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).setTextSize(Code);
    }
}
