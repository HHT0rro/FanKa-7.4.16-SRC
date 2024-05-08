package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class an extends af {
    public an() {
        super(ai.f29043s);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).requestConsentUpdate(new ConsentUpdateListener() { // from class: com.huawei.hms.ads.an.1
            public void onFail(String str2) {
                af.Code(remoteCallResultCallback, an.this.Code, 3006, str2, true);
            }

            public void onSuccess(ConsentStatus consentStatus, boolean z10, List<AdProvider> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.huawei.openalliance.ad.constant.as.P, consentStatus.getValue());
                    jSONObject.put(com.huawei.openalliance.ad.constant.as.R, z10);
                    JSONArray jSONArray = new JSONArray();
                    if (!aa.Code(list)) {
                        for (AdProvider adProvider : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (adProvider != null) {
                                jSONObject2.put("id", adProvider.getId());
                                jSONObject2.put("name", adProvider.getName());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.as.f32222ab, adProvider.getServiceArea());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.as.f32223ac, adProvider.getPrivacyPolicyUrl());
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put(com.huawei.openalliance.ad.constant.as.T, jSONArray);
                    af.Code(remoteCallResultCallback, an.this.Code, 1000, jSONObject.toString(), true);
                } catch (Throwable unused) {
                    af.Code(remoteCallResultCallback, an.this.Code, 3006, "consent info is null", true);
                }
            }
        });
    }
}
