package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ak extends af {
    private static final int B = -1;
    private static final int Z = 0;

    public ak() {
        super(ai.f29043s);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (ea.Code(context).V()) {
            af.Code(remoteCallResultCallback, this.Code, 3005, null, true);
        } else {
            Code(context, str, new ab() { // from class: com.huawei.hms.ads.ak.1
                @Override // com.huawei.hms.ads.ab
                public void Code(AdContentData adContentData) {
                    if (adContentData == null) {
                        af.Code(remoteCallResultCallback, ak.this.Code, 3002, null, true);
                        return;
                    }
                    String X = adContentData.X();
                    if (TextUtils.isEmpty(X)) {
                        X = adContentData.W();
                    } else if (TextUtils.isEmpty(X)) {
                        X = com.huawei.openalliance.ad.constant.u.al;
                    }
                    af.Code(remoteCallResultCallback, ak.this.Code, 1000, Integer.valueOf(com.huawei.openalliance.ad.utils.v.Code(context, X) ? 0 : -1), true);
                }
            });
        }
    }
}
