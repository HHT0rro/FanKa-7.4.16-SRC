package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class AnonymousClass2 extends com.kwad.components.core.request.d {
        public final /* synthetic */ KsLoadManager.FeedAdListener el;
        public final /* synthetic */ SceneImpl em;
        public final /* synthetic */ boolean en;
        public final /* synthetic */ long eo;

        public AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z10, long j10) {
            this.el = feedAdListener;
            this.em = sceneImpl;
            this.en = z10;
            this.eo = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.aY();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                    if (!FeedType.checkTypeValid(adTemplate)) {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.be(dQ)), FeedType.fromInt(adTemplate.type));
                        com.kwad.components.ad.feed.monitor.b.a(com.kwad.sdk.core.response.b.a.be(dQ), adTemplate.type, adTemplate);
                    } else {
                        adTemplate.mAdScene = this.em;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dQ))) {
                            Pair<Integer, String> d10 = com.kwad.components.ad.feed.monitor.a.d(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.e(((Integer) d10.first).intValue(), (String) d10.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.en));
                    }
                }
            }
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.t(arrayList.size());
            if (arrayList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.d(com.kwad.sdk.core.network.e.avy.errorCode, com.kwad.sdk.core.network.e.avy.msg + str);
                onError(com.kwad.sdk.core.network.e.avy.errorCode, com.kwad.sdk.core.network.e.avy.msg + str);
                com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
                return;
            }
            com.kwad.sdk.commercial.d.d.a(this.em, arrayList.size());
            if (com.kwad.sdk.core.config.d.By() && (!k.zd().yp() || (k.zd().yp() && com.kwad.sdk.core.config.d.Bz() == 1))) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                        KsAdLoadManager.M().b(arrayList);
                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), (List<KsFeedAd>) arrayList);
                    }
                });
            } else {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.3
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        final int size = arrayList.size();
                        final int[] iArr = {0};
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd " + ((Object) ksFeedAd));
                            final int i10 = com.kwad.sdk.core.response.b.b.cO(cVar.getAdTemplate()) ? 3 : 2;
                            final long elapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                @Override // com.kwad.components.ad.feed.c.a
                                public final void c(int i11, String str2) {
                                    com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + ((Object) cVar));
                                    com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i11, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    int[] iArr2 = iArr;
                                    int i12 = iArr2[0] + 1;
                                    iArr2[0] = i12;
                                    int i13 = size;
                                    if (i12 == i13) {
                                        com.kwad.components.ad.feed.monitor.b.a(i13, SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                                        KsAdLoadManager.M().b(arrayList);
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), (List<KsFeedAd>) arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(final int i10, final String str) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    AnonymousClass2.this.el.onError(i10, str);
                }
            });
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
            com.kwad.components.ad.feed.monitor.b.d(i10, str);
            if (i10 == com.kwad.sdk.core.network.e.avt.errorCode || i10 == com.kwad.sdk.core.network.e.avy.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.f(i10, str);
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z10) {
        if (!k.zd().ys()) {
            com.kwad.sdk.core.e.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.e.avy.errorCode, com.kwad.sdk.core.network.e.avy.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.s(covert.getAdNum());
        boolean a10 = m.re().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0478a().e(new ImpInfo(covert)).aJ(a10).a(new AnonymousClass2(feedAdListener, covert, z10, elapsedRealtime)).qy());
    }
}
