package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f extends b implements com.kwad.sdk.widget.c {
    private List<Integer> cB;

    @NonNull
    private KsAdVideoPlayConfig dU;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private c jK;
    private KSFrameLayout kK;
    private KSFrameLayout kL;
    private com.kwad.components.core.video.f kM;
    public AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    public Context mContext;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0479a eS = new a.InterfaceC0479a() { // from class: com.kwad.components.ad.interstitial.e.f.3
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC0479a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r11, com.kwad.sdk.utils.ac.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L15
                if (r11 == r0) goto L12
                r3 = 3
                if (r11 == r3) goto Ld
                r11 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L18
            L12:
                r11 = 82
                goto L17
            L15:
                r11 = 13
            L17:
                r3 = 2
            L18:
                com.kwad.components.ad.interstitial.e.f r4 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.components.ad.interstitial.e.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.ai.LZ()
                if (r4 == 0) goto L24
                goto L25
            L24:
                r0 = 1
            L25:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.dM()
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.e.f.b(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.e.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.e.f.b(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.aq(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.e.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.an(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.ao(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.aq(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.am(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.ao(r0)
                com.kwad.components.ad.interstitial.e.f$3$1 r0 = new com.kwad.components.ad.interstitial.e.f$3$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.e.f.AnonymousClass3.a(int, com.kwad.sdk.utils.ac$a):void");
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void dv() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.e.f.dv():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j10) {
        c cVar = this.jK;
        cVar.jM = true;
        cVar.b(1L, j10);
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Jx();
        this.jK = cVar;
        this.dU = cVar.dU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.mAdInfo = dQ;
        List<Integer> bm = com.kwad.sdk.core.response.b.a.bm(dQ);
        this.cB = bm;
        com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
        this.eN = aVar;
        aVar.setTag(bm);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eN);
        this.kM = fVar;
        fVar.setDataFlowAutoStart(this.dU.isDataFlowAutoStart());
        this.kM.setAdClickListener(this.eS);
        this.kM.rr();
        this.mApkDownloadHelper = this.jK.mApkDownloadHelper;
        dv();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.kL.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kK = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kL = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kL.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jK.jT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j10) {
        int ceil = (int) Math.ceil(((float) j10) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> iterator2 = this.cB.iterator2();
        while (iterator2.hasNext()) {
            if (ceil >= iterator2.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                iterator2.remove();
                return;
            }
        }
    }

    private c.b a(View view, boolean z10) {
        return new c.b(view.getContext()).k(z10).a(this.kK.getTouchCoords()).z(3).A(85);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.jK.a(a(view, false));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.jK.a(a(view, true));
    }
}
