package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bg extends bf {
    private static final String Z = "JsbReportClickEvent";

    public bg() {
        super(ai.f29036l);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bg.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i10;
                String str2;
                String str3;
                int i11;
                int i12;
                if (adContentData == null) {
                    gl.V(bg.Z, "ad not exist");
                    i10 = 3002;
                } else if (bg.this.Code(adContentData)) {
                    String str4 = com.huawei.openalliance.ad.constant.t.f32349a;
                    AdEventReport adEventReport2 = adEventReport;
                    int i13 = 0;
                    if (adEventReport2 != null) {
                        i11 = adEventReport2.c();
                        i13 = adEventReport.d();
                        if (!TextUtils.isEmpty(adEventReport.e())) {
                            str4 = adEventReport.e();
                        }
                        i12 = adEventReport.C() != null ? adEventReport.C().intValue() : 13;
                        str3 = adEventReport.k();
                        str2 = str4;
                    } else {
                        str2 = com.huawei.openalliance.ad.constant.t.f32349a;
                        str3 = null;
                        i11 = 0;
                        i12 = 13;
                    }
                    Context context2 = context;
                    kv.Code(context2, adContentData, str3, i11, i13, str2, i12, b.Code(context2), bg.this.C(str));
                    i10 = 1000;
                } else {
                    gl.V(bg.Z, "ad is not in whitelist");
                    i10 = 3004;
                }
                af.Code(remoteCallResultCallback, bg.this.Code, i10, null, true);
            }
        });
    }
}
