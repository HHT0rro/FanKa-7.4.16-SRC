package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a implements c {
    public View BC;
    public ImageView BD;
    private com.kwad.components.ad.widget.tailframe.appbar.a BE;
    private TailFrameBarH5View BF;
    private b BG;
    private TextProgressBar BH;
    private View BI;
    private int BJ;
    private TextView dM;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g qo;

    public a(int i10) {
        this.BJ = i10;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.bY(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.dn(i10), i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                a.this.BE.D(a.this.mAdInfo);
                a.this.BH.e(com.kwad.sdk.core.response.b.a.dm(i10), i10);
            }
        });
    }

    private void ki() {
        this.BC.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void kk() {
        if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo) && !e.F(this.mAdTemplate)) {
            this.BF.b(this.mAdTemplate);
            TextView h5OpenBtn = this.BF.getH5OpenBtn();
            this.dM = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.BF.setVisibility(0);
            new f(this.dM, this);
            return;
        }
        this.BE.b(this.mAdTemplate);
        this.BE.setVisibility(0);
        this.BH = this.BE.getTextProgressBar();
        if (!e.F(this.mAdTemplate)) {
            this.BH.setClickable(true);
            new f(this.BH, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.BE.getBtnInstallContainer();
            this.BI = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.BI, this);
        }
    }

    public void B(Context context) {
        View a10 = l.a(context, this.BJ, null, false);
        this.BC = a10;
        this.BD = (ImageView) a10.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.BC.findViewById(R.id.ksad_video_tf_logo);
        this.BE = (com.kwad.components.ad.widget.tailframe.appbar.a) this.BC.findViewById(R.id.ksad_video_app_tail_frame);
        this.BF = (TailFrameBarH5View) this.BC.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BE;
        if (aVar != null) {
            aVar.km();
            this.BE.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.BF;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.km();
            this.BF.setVisibility(8);
        }
        ki();
    }

    public final void f(boolean z10, boolean z11) {
        this.BF.g(z10, z11);
    }

    public final void jQ() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BE;
        if (aVar != null) {
            aVar.km();
        }
        TailFrameBarH5View tailFrameBarH5View = this.BF;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.km();
        }
    }

    public final View kj() {
        return this.BC;
    }

    public final void setCallerContext(g gVar) {
        this.qo = gVar;
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
        this.mReportExtData = jSONObject;
        this.BG = bVar;
        this.mLogoView.aD(this.mAdTemplate);
        kk();
        this.BC.setClickable(true);
        new f(this.BC, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dF(this.mAdTemplate)) {
            b(view, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.b.e.F(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.qo
            android.view.View r3 = r5.BC
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.BI
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.aF(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.BH
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.dM
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.aq(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.am(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.al(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.BH
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.ao(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.an(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.a(r0)
            com.kwad.components.core.e.d.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
