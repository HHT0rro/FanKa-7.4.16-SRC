package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class be extends af {
    private static final String Z = "JsbUnregisterAppStatusProxy";

    public be() {
        super(ai.f29047w);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ab() { // from class: com.huawei.hms.ads.be.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null || adContentData.u() == null) {
                    return;
                }
                com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.S());
            }
        });
    }
}
