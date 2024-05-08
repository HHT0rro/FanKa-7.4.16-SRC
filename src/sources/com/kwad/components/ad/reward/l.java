package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l {
    public static void a(final int i10, final g gVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.1
            @NonNull
            private static RewardCallBackRespInfo C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gl, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.e createRequest() {
                return new com.kwad.components.core.request.e(i10, gVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return C(str);
            }
        };
        if (i10 == 1) {
            lVar.request(i(gVar));
        } else if (i10 == 2) {
            lVar.request(j(gVar));
        }
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> i(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.Rr = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.Rr, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.Rr, i10, str);
            }
        };
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> j(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.Rr = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.l.3.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            g.this.pg = 1;
                        } else {
                            g.this.pg = 2;
                        }
                        g.this.oI.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.Rr, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.l.3.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        g.this.pg = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.Rr, i10, str);
            }
        };
    }

    private static boolean k(g gVar) {
        return !gVar.ph && com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate));
    }

    public static void a(g gVar, long j10, long j11, long j12) {
        boolean k10 = k(gVar);
        long cY = k10 ? com.kwad.sdk.core.response.b.a.cY(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate)) : 0L;
        if (gVar.ph || !k10 || !gVar.mCheckExposureResult || j10 <= ((j11 - 800) - j12) - cY || cY <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cZ(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate))) {
            gVar.pg = 1;
            a(2, gVar);
        } else {
            gVar.oI.onRewardVerify();
        }
        gVar.ph = true;
    }
}
