package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class aw extends au {
    public aw() {
        super(ai.f29028d);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        V().Code(remoteCallResultCallback, this.Code, this.I);
    }
}
