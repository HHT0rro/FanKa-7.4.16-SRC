package com.kwad.components.ad.feed.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.c {
    private KsAdVideoPlayConfig dU;
    private a.b eY;
    private long ey;
    private com.kwad.components.core.widget.b fM;
    private float fN;
    private float fO;
    private boolean fP;
    private b.a fZ;
    private com.kwad.components.core.webview.tachikoma.i gj;
    private KSFrameLayout gk;
    private boolean gl;
    private aw gm;
    private com.kwad.sdk.core.webview.c.c gn;
    private o go;
    private a gp;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mHeight;
    private int mWidth;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void c(int i10, String str);
    }

    public n(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD() {
        if (this.gn == null) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.n.3
            private boolean a(boolean z10, boolean z11, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i10) {
                if (i10 == 1) {
                    return z10;
                }
                if (i10 == 2) {
                    return z11;
                }
                if (i10 == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z10 : z11;
                }
                return a(z10, z11);
            }

            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                boolean isNetworkConnected = ag.isNetworkConnected(((com.kwad.components.core.widget.b) n.this).mContext);
                boolean isWifiConnected = ag.isWifiConnected(((com.kwad.components.core.widget.b) n.this).mContext);
                if (n.this.dU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) n.this.dU;
                    dVar.aah = a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.aah = a(isNetworkConnected, isWifiConnected);
                }
                n.this.gn.a(dVar);
            }

            private boolean a(boolean z10, boolean z11) {
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(n.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.bU(dQ)) {
                    return z10;
                }
                if (com.kwad.sdk.core.response.b.a.bV(dQ)) {
                    return z11;
                }
                if (com.kwad.sdk.core.response.b.a.bW(dQ)) {
                    return false;
                }
                return com.kwad.sdk.core.config.d.Ce() ? z10 : z11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE() {
        if (this.fM == null) {
            this.gl = true;
            com.kwad.components.core.widget.b a10 = com.kwad.components.ad.feed.b.a(((com.kwad.components.core.widget.b) this).mContext, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
            this.fM = a10;
            if (a10 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(((com.kwad.components.core.widget.b) this).mContext, 16.0f));
                this.gk.removeAllViews();
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.gk.addView(this.fM);
                this.gp.c(1, "");
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.n.5
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                }
            });
        }
        return this.eY;
    }

    private void init(final Context context) {
        int a10 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asE);
        this.gj = new com.kwad.components.core.webview.tachikoma.i(context, a10, a10);
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.b.n.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Context context2 = context;
                if ((context2 instanceof Activity) && context2.equals(activity)) {
                    if (n.this.gj != null) {
                        n.this.gj.jp();
                    }
                    if (n.this.gm != null) {
                        n.this.gm.onDestroy();
                    }
                    com.kwad.sdk.core.c.b.DD();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                }
            }
        });
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sv();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sw();
            com.kwad.components.core.j.a.oG().c(this.eY);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.gk = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sr();
            this.gm.ss();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 3, 3);
        }
        b.a aVar = this.abm;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.d.Co() && com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.cf(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            a(motionEvent);
            if ((action == 2 || action == 3) && this.gk != null && !this.gl && Math.abs(motionEvent.getX() - this.fN) > 0.0f) {
                this.gk.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.fN);
                double abs2 = Math.abs(motionEvent.getY() - this.fO);
                if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                    this.gk.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.gp;
        if (aVar2 != null) {
            aVar2.c(this.gl ? 1 : 3, "");
        }
        this.gp = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
        bD();
    }

    public final void setWidth(int i10) {
        if (i10 <= 0) {
            i10 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i10;
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((n) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.ey = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate) > ShadowDrawableWrapper.COS_45) {
            this.mHeight = (int) (this.mWidth * com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate));
        } else {
            this.mHeight = this.gk.getHeight();
        }
        this.gj.a(com.kwad.sdk.n.l.dn(((com.kwad.components.core.widget.b) this).mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.b.n.2
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                n.this.bE();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void b(ac.a aVar) {
                aVar.width = com.kwad.sdk.d.a.a.px2dip(((com.kwad.components.core.widget.b) n.this).mContext, n.this.mWidth);
                aVar.height = com.kwad.sdk.d.a.a.px2dip(((com.kwad.components.core.widget.b) n.this).mContext, n.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bF() {
                if (n.this.gp != null) {
                    n.this.gp.c(3, "");
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return n.this.gk;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.dA(n.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
                qVar.c(new x(bVar, n.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) n.this.gj, true));
                qVar.c(new com.kwad.components.core.webview.tachikoma.a.n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        n.this.gn = cVar2;
                        n.this.bD();
                    }
                });
                qVar.c(new v() { // from class: com.kwad.components.ad.feed.b.n.2.2
                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.a(xVar);
                        if (com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) n.this).mContext).qW() && n.this.go != null) {
                            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                            mVar.aao = true;
                            n.this.go.c(mVar);
                        }
                        com.kwad.components.core.j.a.oG().a(n.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.ey);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.b(xVar);
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.ey);
                        com.kwad.components.core.o.a.qi().c(n.this.mAdTemplate, xVar.errorCode, xVar.sU());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.c(xVar);
                        com.kwad.components.core.j.a.oG().c(n.this.eY);
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (n.this.abm != null) {
                    n.this.abm.onAdClicked();
                }
                n.this.bw();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
                n.this.go = oVar;
                n.this.go.a(new o.a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
                    
                        if (com.kwad.components.core.j.a.b(r3.gs.gr.eY) == false) goto L21;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x007b  */
                    @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final boolean isMuted() {
                        /*
                            r3 = this;
                            boolean r0 = com.kwad.sdk.core.config.d.gs()
                            r1 = 1
                            if (r0 != 0) goto L1a
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            android.content.Context r0 = com.kwad.components.ad.feed.b.n.z(r0)
                            com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.ah(r0)
                            boolean r0 = r0.qW()
                            if (r0 == 0) goto L1a
                            goto L70
                        L1a:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            if (r0 == 0) goto L36
                            com.kwad.components.core.j.a.oG()
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            boolean r0 = com.kwad.components.core.j.a.b(r0)
                            if (r0 != 0) goto L36
                            goto L70
                        L36:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                            int r0 = r0.getVideoSoundValue()
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            boolean r0 = r0.isVideoSoundEnable()
                            r0 = r0 ^ r1
                            goto L71
                        L60:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.B(r0)
                            boolean r0 = com.kwad.sdk.core.response.b.a.bT(r0)
                            if (r0 != 0) goto L6f
                            goto L70
                        L6f:
                            r1 = 0
                        L70:
                            r0 = r1
                        L71:
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.C(r1)
                            if (r1 == 0) goto L87
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                            r2 = r0 ^ 1
                            r1.mIsAudioEnable = r2
                        L87:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass3.isMuted():boolean");
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (n.this.gm != null) {
                    n.this.gm.st();
                    n.this.gm.su();
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.n.2.4
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        n.this.tk();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(aw awVar) {
                n.this.gm = awVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0481a c0481a) {
                if (n.this.abm != null) {
                    String str = c0481a.VR;
                    str.hashCode();
                    char c4 = 65535;
                    switch (str.hashCode()) {
                        case -1929947611:
                            if (str.equals("adShowCallback")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1291763712:
                            if (str.equals("adDownloadConfirmTipCancel")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case -1228923142:
                            if (str.equals("adCloseCallback")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case -532703741:
                            if (str.equals("adDownloadConfirmTipShow")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case -268512828:
                            if (str.equals("adDownloadConfirmTipDismiss")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 1852274314:
                            if (str.equals("adClickCallback")) {
                                c4 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            n.this.abm.onAdShow();
                            return;
                        case 1:
                        case 4:
                            n.this.abm.onDownloadTipsDialogDismiss();
                            return;
                        case 2:
                            n.this.abm.onDislikeClicked();
                            return;
                        case 3:
                            n.this.abm.onDownloadTipsDialogShow();
                            return;
                        case 5:
                            n.this.abm.onAdClicked();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.gl = false;
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.n.4
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (n.this.abm != null) {
                    n.this.abm.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, n.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (n.this.gl) {
                    if (n.this.abm != null) {
                        n.this.abm.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0516a c0516a = new a.C0516a();
                    FeedType fromInt = FeedType.fromInt(n.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0516a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0516a);
                    bVar.v(n.this.getHeight(), n.this.mWidth);
                    com.kwad.components.core.s.b.qY().a(n.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (n.this.abm != null) {
                    n.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (n.this.abm != null) {
                    n.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (n.this.abm != null) {
                    n.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.fN = motionEvent.getX();
            this.fO = motionEvent.getY();
        }
    }
}
