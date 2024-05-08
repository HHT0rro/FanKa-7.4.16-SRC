package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static e oF = new e(0);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> oG = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.o.a.qi().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.e.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i10, String str) {
                super.onError(fVar, i10, str);
                com.kwad.components.core.o.a.qi().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.e.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: fs, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void fr() {
            request(this.oG);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    private e() {
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    private static void D(AdTemplate adTemplate) {
        new b(adTemplate).fr();
    }

    public static e fp() {
        return a.oF;
    }

    public final void C(AdTemplate adTemplate) {
        com.kwad.sdk.core.e.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bP(dQ))) {
            D(adTemplate);
        } else {
            o.b(adTemplate, dQ);
        }
    }
}
