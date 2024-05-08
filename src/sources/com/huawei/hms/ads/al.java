package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.jsb.inner.data.DeviceInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class al extends af {
    public static final String Z = "JsbReqSettings";

    public al() {
        super(ai.Code);
    }

    private String V(Context context) {
        Resources resources = context.getResources();
        return com.huawei.openalliance.ad.constant.as.f32224ad + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_ad_label) + ",download" + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_download_download) + ",resume" + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_download_resume) + "," + com.huawei.openalliance.ad.constant.as.ah + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_download_installing) + ",install" + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_download_install) + ",open" + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_download_open) + "," + com.huawei.openalliance.ad.constant.as.aj + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_choices_whythisad) + "," + com.huawei.openalliance.ad.constant.as.ak + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_choices_hide) + "," + com.huawei.openalliance.ad.constant.as.al + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_choices_ad_no_interest) + "," + com.huawei.openalliance.ad.constant.as.am + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_app_preorder) + "," + com.huawei.openalliance.ad.constant.as.an + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_app_preordered) + "," + com.huawei.openalliance.ad.constant.as.ao + com.huawei.openalliance.ad.constant.u.bD + resources.getString(R.string.hiad_feedback_think_of_this_ad);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.Code(ea.Code(context).V());
        deviceInfo.Code(c.Code());
        deviceInfo.V(V(context));
        af.Code(remoteCallResultCallback, this.Code, 1000, com.huawei.openalliance.ad.utils.z.Code(deviceInfo), true);
    }
}
