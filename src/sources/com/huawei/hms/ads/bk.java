package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bk extends bf {
    private static final String Z = "JsbReportPlayResumeEvent";

    public bk() {
        super(ai.f29034j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bk.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                kv.Code(context, adContentData, com.huawei.openalliance.ad.constant.ae.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
                bk.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
