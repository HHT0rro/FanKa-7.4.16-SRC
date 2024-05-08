package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bd extends aq {
    public bd() {
        super(ai.S);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bd.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i10;
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.u uVar = new com.huawei.openalliance.ad.inter.data.u(adContentData);
                    if (bd.this.Code(adContentData)) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.bd.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                int Code = bd.this.V(context, str).Code(context, uVar);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                af.Code(remoteCallResultCallback, bd.this.Code, 1000, Integer.valueOf(Code), true);
                            }
                        });
                        return;
                    } else {
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bd.this.Code;
                        i10 = 3004;
                    }
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bd.this.Code;
                    i10 = 3002;
                }
                af.Code(remoteCallResultCallback2, str2, i10, null, true);
            }
        });
    }
}
