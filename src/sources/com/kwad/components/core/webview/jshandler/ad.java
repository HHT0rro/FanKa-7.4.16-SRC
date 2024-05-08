package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private final boolean WL = false;
    private final com.kwad.sdk.core.webview.b Wf;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public AdResultData mAdResultData;

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                        jSONArray.put(adTemplate.toJson());
                    }
                } else {
                    jSONArray.put(adTemplate.toJson());
                }
            }
            com.kwad.sdk.utils.t.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public ad(com.kwad.sdk.core.webview.b bVar) {
        this.Wf = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.WL) {
            AdTemplate adTemplate = this.Wf.getAdTemplate();
            ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
            if (adTemplate.mAdScene != null) {
                impInfo.pageScene = r1.getPageScene();
            }
            impInfo.subPageScene = 106L;
            impInfo.adScene.setAdNum(12);
            impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
            a(impInfo, cVar);
            return;
        }
        if (this.Wf.GN()) {
            cVar.onError(-1, "native adTemplate is null");
        } else {
            cVar.a(new a(this.Wf.hk()));
        }
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: Z, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mO, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.iJ = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.2
            private void c(@NonNull final AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb2 = new StringBuilder("onError:");
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.e.avy.errorCode);
                    objArr[1] = TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg;
                    sb2.append(String.format("code:%s__msg:%s", objArr));
                    com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", sb2.toString());
                    bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ad.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ad.2.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
            }

            private void h(int i10, String str) {
                com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i10 + " msg: " + str);
                ad.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i10, String str) {
                h(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ad.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }
}
