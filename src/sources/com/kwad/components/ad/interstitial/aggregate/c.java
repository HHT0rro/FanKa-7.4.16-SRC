package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c {
    private volatile boolean iI;
    private l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 extends j {
        public final /* synthetic */ SceneImpl em;
        public final /* synthetic */ b iK;
        public final /* synthetic */ long ij;

        public AnonymousClass1(SceneImpl sceneImpl, b bVar, long j10) {
            this.em = sceneImpl;
            this.iK = bVar;
            this.ij = j10;
        }

        @Override // com.kwad.components.core.request.k
        public final void a(@NonNull final AdResultData adResultData) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.em;
                            }
                            arrayList.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                        }
                    }
                    bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            AnonymousClass1.this.iK.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.ij);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(final int i10, final String str) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.core.e.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static c iQ = new c(0);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    public /* synthetic */ c(byte b4) {
        this();
    }

    public static c cx() {
        return a.iQ;
    }

    public final void release() {
        l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private c() {
        this.iI = false;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.iI = false;
        return false;
    }

    public final void a(int i10, int i11, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.iI) {
            return;
        }
        SceneImpl m2868clone = sceneImpl.m2868clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m2868clone.setAdStyle(16);
        m2868clone.setAdNum(i11);
        a(new ImpInfo(m2868clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    private void a(ImpInfo impInfo, @NonNull final j jVar) {
        com.kwad.components.core.m.a aVar = new com.kwad.components.core.m.a(impInfo);
        this.iJ = aVar;
        aVar.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void c(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    jVar.onError(e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.avy.msg : adResultData.testErrorMsg);
                } else {
                    jVar.a(adResultData);
                }
            }

            private void h(int i10, String str) {
                c.a(c.this, false);
                jVar.onError(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                h(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j10) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.qi().g(adTemplate, elapsedRealtime - j10);
    }
}
