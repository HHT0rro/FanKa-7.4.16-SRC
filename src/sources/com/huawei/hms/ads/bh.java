package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bh extends bf {
    private static final String Z = "JsbReportCloseEvent";

    public bh() {
        super(ai.f29037m);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, Z);
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bh.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    AdEventReport adEventReport2 = adEventReport;
                    kv.Code(context, adContentData, 0, 0, adEventReport2 != null ? adEventReport2.f() : null);
                    bh.this.V(remoteCallResultCallback, true);
                }
            }
        });
    }
}
