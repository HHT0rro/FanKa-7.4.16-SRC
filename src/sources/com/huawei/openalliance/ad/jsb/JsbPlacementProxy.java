package com.huawei.openalliance.ad.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.fv;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsbPlacementProxy extends af {
    @AllApi
    public JsbPlacementProxy() {
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ah.V(str);
        if (context != null && !TextUtils.isEmpty(str)) {
            f.Code(new ah.a(context, fv.Code().Code(V), V, str, remoteCallResultCallback));
        } else {
            gl.Z("JsbPlacementProxy", "param is invalid, please check it!");
            af.Code(remoteCallResultCallback, V, -1, null, true);
        }
    }
}
