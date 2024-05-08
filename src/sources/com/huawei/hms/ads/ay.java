package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ay extends aq {
    public ay() {
        super(ai.f29026b);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.ay.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i10;
                if (adContentData != null) {
                    i10 = com.huawei.hms.ads.jsb.a.Code(context).Code().F(context, new com.huawei.openalliance.ad.inter.data.u(adContentData));
                } else {
                    i10 = 0;
                }
                af.Code(remoteCallResultCallback, ay.this.Code, 1000, Integer.valueOf(i10), true);
            }
        });
    }
}
