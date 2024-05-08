package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ar extends aq {
    public ar() {
        super(ai.f29025a);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.ar.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    af.Code(remoteCallResultCallback, ar.this.Code, 3002, null, true);
                    return;
                }
                ar.this.V(context, str).C(context, new com.huawei.openalliance.ad.inter.data.u(adContentData));
                ar.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
            }
        });
    }
}
