package com.kwad.components.core.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo Mv;

    public a(ImpInfo impInfo) {
        this.Mv = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        l(adResultData);
    }

    private static void l(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo dQ = e.dQ(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bd(dQ)) {
                if (com.kwad.sdk.core.response.b.a.ba(dQ).size() == 0) {
                    com.kwad.components.core.o.a.qi().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bh(dQ) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dQ))) {
                com.kwad.components.core.o.a.qi().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.l
    @NonNull
    /* renamed from: Z */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Mv.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: mO */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Mv);
    }
}
