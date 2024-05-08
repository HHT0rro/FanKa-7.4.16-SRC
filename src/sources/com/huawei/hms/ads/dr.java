package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.template.dtimageview.DTImageView;
import com.huawei.hms.ads.template.view.DTAppDownloadButton;
import com.huawei.hms.ads.template.view.DTFrameLayout;
import com.huawei.hms.ads.template.view.DTLinearLayout;
import com.huawei.hms.ads.template.view.DTNativeVideoView;
import com.huawei.hms.ads.template.view.DTRelativeLayout;
import com.huawei.hms.ads.template.view.DTTextView;
import com.huawei.quickcard.base.Attributes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dr extends dq {
    private static final Map<String, String> V;

    static {
        HashMap hashMap = new HashMap();
        V = hashMap;
        hashMap.put("fl", DTFrameLayout.class.getName());
        hashMap.put("rl", DTRelativeLayout.class.getName());
        hashMap.put("ll", DTLinearLayout.class.getName());
        hashMap.put("text", DTTextView.class.getName());
        hashMap.put(Attributes.Component.IMAGE, DTImageView.class.getName());
        hashMap.put("native_pps_video", DTNativeVideoView.class.getName());
        hashMap.put("native_pps_button", DTAppDownloadButton.class.getName());
    }

    public dr(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.dq
    public String V(String str) {
        return V.get(str);
    }
}
