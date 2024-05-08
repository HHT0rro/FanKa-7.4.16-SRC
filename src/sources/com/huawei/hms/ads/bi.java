package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bi extends bf {
    private static final String Z = "JsbReportPlayEndEvent";

    public bi() {
        super(ai.f29034j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bi.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    kv.Code(context, adContentData, com.huawei.openalliance.ad.constant.ae.Z, Long.valueOf(adEventReport2.D() == null ? 0L : adEventReport.D().longValue()), Long.valueOf(adEventReport.L() != null ? adEventReport.L().longValue() : 0L), Integer.valueOf(adEventReport.a() == null ? 0 : adEventReport.a().intValue()), Integer.valueOf(adEventReport.b() != null ? adEventReport.b().intValue() : 0));
                }
                bi.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
