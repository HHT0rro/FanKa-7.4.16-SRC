package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bn extends bf {
    private static final String Z = "JsbReportShowStartEvent";

    public bn() {
        super(ai.f29035k);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bn.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                kv.Code(context, adContentData);
                bn.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
