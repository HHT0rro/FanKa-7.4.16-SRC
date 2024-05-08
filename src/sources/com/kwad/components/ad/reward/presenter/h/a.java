package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.l.a.b;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends g implements j {
    private AdInfo mAdInfo;
    private boolean tJ;
    private boolean tK;
    private boolean wX;
    private f wY;
    private long wZ;
    private d wk;
    private g.b tL = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.wD != null && a.this.wD.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.l.a.a sn = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.wX = false;
            if (a.this.wY == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.qH().qN()) {
                com.kwad.components.core.q.a.qH().aM(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    vVar.aau = 1;
                    a.this.wY.b(vVar);
                    return;
                } else if (com.kwad.components.core.q.a.qH().qJ()) {
                    vVar.aau = 1;
                    a.this.wY.b(vVar);
                    return;
                } else {
                    vVar.aau = 0;
                    a.this.wY.b(vVar);
                    return;
                }
            }
            if (com.kwad.components.core.q.a.qH().qL() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.qH().qM() == 1) {
                    if (ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                        vVar.aau = 2;
                        com.kwad.components.core.q.a.qH().aI(2);
                        a.this.wY.b(vVar);
                        return;
                    } else {
                        vVar.aau = 0;
                        a.this.wY.b(vVar);
                        return;
                    }
                }
                if (com.kwad.components.core.q.a.qH().qM() == 3) {
                    vVar.aau = 1;
                    com.kwad.components.core.q.a.qH().aI(0);
                    a.this.wY.b(vVar);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            super.d(cVar);
            a.this.wX = true;
        }
    };
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            long a10 = com.kwad.components.ad.reward.g.a(j10, a.this.mAdInfo);
            long aM = com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) * 1000;
            if (j11 <= a.this.wZ || a10 - j11 <= aM || a.this.tJ) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qo.fP) {
                return;
            }
            a.b(a.this, true);
            a.this.wk.a(a.this.qo.getActivity(), a.this.qo.mAdResultData, a.this);
            a.this.je();
        }
    };

    private void hw() {
        boolean x10 = i.x(this.qo);
        com.kwad.sdk.core.e.c.d("jky", "onPlayCompleted: " + x10);
        if (x10) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.qo.oI != null) {
                        a.this.qo.oI.onRewardVerify();
                    }
                    a.this.qo.oJ.pause();
                    a.this.qo.fB();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.qo.oI;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qo.oJ.pause();
        this.qo.fB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        this.wD.setVisibility(0);
        e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.pause();
        }
        this.tK = true;
    }

    private f jf() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getContext();
        if (ai.LZ()) {
            this.wX = false;
            com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onBind: ");
            if (this.wk == null) {
                this.wk = new d(this.qo, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.wY == null) {
                            return;
                        }
                        v vVar = new v();
                        if (com.kwad.components.core.q.a.qH().qN()) {
                            com.kwad.components.core.q.a.qH().aM(false);
                            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                                vVar.aau = 1;
                                a.this.wY.b(vVar);
                                return;
                            } else if (com.kwad.components.core.q.a.qH().qJ()) {
                                vVar.aau = 1;
                                a.this.wY.b(vVar);
                                return;
                            } else {
                                vVar.aau = 0;
                                a.this.wY.b(vVar);
                                return;
                            }
                        }
                        if (com.kwad.components.core.q.a.qH().qL() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                            if (com.kwad.components.core.q.a.qH().qM() == 1) {
                                if (ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                                    return;
                                }
                                vVar.aau = 0;
                                a.this.wY.b(vVar);
                                return;
                            }
                            if (com.kwad.components.core.q.a.qH().qM() == 3) {
                                vVar.aau = 1;
                                com.kwad.components.core.q.a.qH().aI(0);
                                a.this.wY.b(vVar);
                            }
                        }
                    }
                });
            }
            this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
            this.wZ = com.kwad.sdk.core.response.b.a.aL(r0) * 1000;
            e eVar = this.qo.oJ;
            if (eVar != null) {
                eVar.a(this.gO);
            }
            this.qo.a(this.tL);
            this.qo.Ms.add(this.sn);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dq(this.qo.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qo.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hM() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.b(this.gO);
        }
        this.qo.b(this.tL);
        this.qo.Ms.remove(this.sn);
        d dVar = this.wk;
        if (dVar != null) {
            dVar.jp();
            this.wk = null;
        }
        this.wD.setVisibility(8);
        com.kwad.components.core.q.a.qH().clear();
        this.tJ = false;
        this.tK = false;
        this.wX = false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.tJ = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.wD.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        f jf = jf();
        this.wY = jf;
        qVar.c(jf);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qo.oI.bJ();
        com.kwad.sdk.core.e.c.d("jky", "onAdClicked convertPageType: " + aVar.aEL);
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo)) {
            com.kwad.components.core.q.a.qH().aH(aVar.aEL);
            if (aVar.aEL == -1) {
                com.kwad.components.core.q.a.qH().aM(false);
                com.kwad.components.core.q.a.qH().aI(0);
            } else {
                if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                    if (com.kwad.components.core.q.a.qH().qM() == 2) {
                        com.kwad.components.core.q.a.qH().aI(3);
                        return;
                    } else {
                        com.kwad.components.core.q.a.qH().aI(1);
                        return;
                    }
                }
                com.kwad.components.core.q.a.qH().aM(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z10 = false;
        this.qo.f36544pb = webCloseStatus != null && webCloseStatus.interactSuccess;
        int qI = com.kwad.components.core.q.a.qH().qI();
        com.kwad.components.ad.reward.g gVar = this.qo;
        e eVar = gVar.oJ;
        if (eVar != null) {
            if (gVar.f36544pb) {
                eVar.jJ();
                if (qI == 1) {
                    hw();
                    z10 = true;
                }
            }
            if (this.tK && !this.wX && !z10) {
                this.qo.oJ.resume();
            }
        }
        this.wD.setVisibility(8);
    }
}
