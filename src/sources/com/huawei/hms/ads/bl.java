package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bl extends bf {
    private static final String Z = "JsbReportPlayStartEvent";

    public bl() {
        super(ai.f29034j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bl.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                kv.Code(context, adContentData, com.huawei.openalliance.ad.constant.ae.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
                bl.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
