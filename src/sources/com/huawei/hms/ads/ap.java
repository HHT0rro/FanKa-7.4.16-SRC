package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ap extends af {
    public ap() {
        super(ai.f29044t);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        ConsentStatus consentStatus = ConsentStatus.UNKNOWN;
        Consent.getInstance(context).setConsentStatus(ConsentStatus.forValue(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.P, ConsentStatus.UNKNOWN.getValue())));
        V(remoteCallResultCallback, true);
    }
}
