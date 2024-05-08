package com.kwad.components.core.playable;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bn;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements n {
    private final KsAdWebView QM;
    private long QN;
    private int QO;
    private PlayableSource QP = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<aq.b> QQ = new CopyOnWriteArrayList();
    private List<KsAdWebView.d> QR = new CopyOnWriteArrayList();

    @Nullable
    private com.kwad.components.core.webview.a cN;
    private aw cQ;

    @Nullable
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0476a implements be.b {
        private final WeakReference<a> QT;

        public C0476a(a aVar) {
            this.QT = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i10) {
            a aVar = this.QT.get();
            if (aVar != null) {
                aVar.aC(i10);
            }
        }
    }

    public a(KsAdWebView ksAdWebView) {
        this.QM = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.QN = SystemClock.elapsedRealtime();
                a.this.QM.getClientConfig().bu(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ei(this.mAdTemplate).b(ij()));
        a(ksAdWebView);
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i10) {
        if (getAdTemplate() == null) {
            return;
        }
        long Cq = d.Cq();
        if (Cq <= 0 || SystemClock.elapsedRealtime() - this.QN <= Cq) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(this.mContext).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).am(i10).d(this.mRootContainer.getTouchCoords()).aq(true));
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bN(e.dQ(adTemplate));
    }

    private KsAdWebView.d ij() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                Iterator iterator2 = a.this.QR.iterator2();
                while (iterator2.hasNext()) {
                    ((KsAdWebView.d) iterator2.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                Iterator iterator2 = a.this.QR.iterator2();
                while (iterator2.hasNext()) {
                    ((KsAdWebView.d) iterator2.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str, String str2) {
                Iterator iterator2 = a.this.QR.iterator2();
                while (iterator2.hasNext()) {
                    ((KsAdWebView.d) iterator2.next()).onReceivedHttpError(i10, str, str2);
                }
            }
        };
    }

    private void pE() {
        if (com.kwad.sdk.core.response.b.a.bJ(e.dQ(this.mAdTemplate)) > 0) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.QM.getClientConfig().bu(true);
                }
            }, com.kwad.sdk.core.response.b.a.bJ(e.dQ(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bJ(e.dQ(this.mAdTemplate)) == 0) {
            this.QM.getClientConfig().bu(true);
        }
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.QP = playableSource;
        }
        if (this.QM == null) {
            return;
        }
        pE();
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sr();
        }
        this.QM.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.ss();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.QM;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hz() {
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        if (this.QM == null) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.st();
        }
        this.QM.setVisibility(8);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.su();
        }
        this.QM.reload();
    }

    public final void qd() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    public final void qe() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.QM) == null) {
            return;
        }
        ksAdWebView.getClientConfig().bu(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.QM.loadUrl(url);
        }
        com.kwad.sdk.core.adlog.c.bQ(this.mAdTemplate);
    }

    public final boolean qf() {
        return this.QM != null && this.QO == 1;
    }

    public final void b(@Nullable aq.b bVar) {
        this.QQ.remove(bVar);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (d.Cp()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.QM == null) {
            com.kwad.sdk.core.e.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.QO = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aDJ = adBaseFrameLayout2;
        bVar.OE = adBaseFrameLayout2;
        bVar.NY = this.QM;
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.QM);
        this.cN = aVar;
        a(bVar, aVar, cVar);
        this.QM.addJavascriptInterface(this.cN, "KwaiAd");
    }

    public final void a(@Nullable aq.b bVar) {
        this.QQ.add(bVar);
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        this.QR.add(dVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new be(bVar, cVar, new C0476a(this)));
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                a.this.QO = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.bP(a.this.mAdTemplate);
                }
                Iterator iterator2 = a.this.QQ.iterator2();
                while (iterator2.hasNext()) {
                    ((aq.b) iterator2.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new ak(bVar));
        aVar.b(new m(bVar));
        aVar.b(new l(bVar));
        this.cQ = new aw();
        aVar.a(new af());
        aVar.a(new ae(bVar));
        aVar.a(new f());
        aVar.a(this.cQ);
        aVar.a(new h(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.n
    public final void a(h hVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            hVar.f(this.QP);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        hVar.aO(adTemplate.adStyle);
    }
}
