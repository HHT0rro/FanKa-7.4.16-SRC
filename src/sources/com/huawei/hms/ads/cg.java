package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cg extends cx {
    public cg(View view) {
        super(view);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "clickEvent";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.Code.setTag(R.id.hiad_pps_view_store_click_event, str2);
    }
}
