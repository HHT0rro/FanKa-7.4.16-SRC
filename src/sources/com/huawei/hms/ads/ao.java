package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ao extends af {
    private static final int B = 1;
    private static final int Z = 0;

    public ao() {
        super(ai.f29045u);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setUnderAgeOfPromise(new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.as.Q, 0) == 1);
        V(remoteCallResultCallback, true);
    }
}
