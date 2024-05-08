package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bm extends bf {
    private static final String Z = "JsbReportShowEvent";

    public bm() {
        super(ai.f29034j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bm.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i10;
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    if (adEventReport2.I()) {
                        kv.Code(context, adContentData, adEventReport.Z().longValue(), adEventReport.B().intValue());
                    } else if (adContentData == null) {
                        i10 = 3002;
                    } else if (bm.this.Code(adContentData)) {
                        kv.Code(context, adContentData, adEventReport.Z(), adEventReport.B(), adEventReport.C(), adEventReport.m());
                    } else {
                        gl.V(bm.Z, "ad is not in whitelist");
                        i10 = 3004;
                    }
                    i10 = 1000;
                } else {
                    i10 = 3001;
                }
                af.Code(remoteCallResultCallback, bm.this.Code, i10, null, true);
            }
        });
    }
}
