package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class az extends aq {
    public az() {
        super(ai.f29027c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(com.huawei.openalliance.ad.download.app.k kVar) {
        return kVar == null ? com.huawei.openalliance.ad.download.app.k.DOWNLOAD.toString() : kVar.toString();
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.az.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                com.huawei.openalliance.ad.download.app.k kVar = com.huawei.openalliance.ad.download.app.k.DOWNLOAD;
                if (adContentData != null) {
                    kVar = com.huawei.hms.ads.jsb.a.Code(context).Code().S(context, new com.huawei.openalliance.ad.inter.data.u(adContentData));
                }
                af.Code(remoteCallResultCallback, az.this.Code, 1000, az.this.Code(kVar), true);
            }
        });
    }
}
