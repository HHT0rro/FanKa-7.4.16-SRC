package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.ay;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    /* renamed from: ga, reason: collision with root package name */
    private IAdLiveEndRequest f36575ga;
    private long hj;

    @Nullable
    private p pi;

    @Nullable
    private View tP;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @NonNull
        private static AdLiveEndResultData P(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bC, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.f36575ga);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return P(str);
        }
    };
    private final com.kwad.components.core.video.l sv = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.hO();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.hP();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            b.this.hj = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.hP();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hO() {
        if (this.f36575ga == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.qo.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        if (b.this.pi == null) {
                            b bVar = b.this;
                            bVar.pi = new p(bVar.qo);
                        }
                        b.this.pi.h(b.this.qo.mRootContainer);
                        b.this.pi.b(r.R(b.this.qo.mAdTemplate));
                        b.this.pi.a(b.this.qo, adLiveEndResultData.mQLivePushEndInfo, b.this.hj);
                        b.this.qo.pi = b.this.pi;
                        b bVar2 = b.this;
                        bVar2.tP = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                        b.this.tP.setVisibility(0);
                        b.this.hx();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i10, String str) {
                super.onError(aVar, i10, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP() {
        View view = this.tP;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0516a c0516a = new a.C0516a();
        bVar.cT(24);
        bVar.b(c0516a);
        com.kwad.components.ad.reward.j.b.a(true, this.qo.mAdTemplate, null, bVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        com.kwad.components.core.n.a.a.a aVar;
        super.aj();
        if (this.qo.oJ.jM()) {
            this.qo.oJ.a(this.sv);
            String bg = com.kwad.sdk.core.response.b.a.bg(e.dQ(this.qo.mAdTemplate));
            if (TextUtils.isEmpty(bg) || (aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class)) == null) {
                return;
            }
            this.f36575ga = aVar.getAdLiveEndRequest(bg);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.qo.oJ.jM()) {
            this.qo.oJ.b(this.sv);
        }
    }
}
