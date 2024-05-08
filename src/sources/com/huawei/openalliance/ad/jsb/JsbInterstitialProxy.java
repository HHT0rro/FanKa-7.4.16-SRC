package com.huawei.openalliance.ad.jsb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ac;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsbInterstitialProxy extends af {
    @AllApi
    public JsbInterstitialProxy() {
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ah.V(str);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(V)) {
            gl.Z("JsbInterstitialProxy", "param is invalid, please check it!");
            af.Code(remoteCallResultCallback, V, -1, null, true);
            return;
        }
        ac Code = ft.Code().Code(V);
        if (Code != null) {
            if (ah.Code().Code(V, Code(context))) {
                Code.Code((Activity) Code(context));
            }
            Code.Code(this.V);
        }
        f.Code(new ah.a(context, Code, V, str, remoteCallResultCallback));
    }
}
