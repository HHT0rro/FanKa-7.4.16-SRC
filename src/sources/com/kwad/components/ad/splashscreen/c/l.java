package com.kwad.components.ad.splashscreen.c;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private com.kwad.sdk.core.g.c DA;
    private com.kwad.components.ad.splashscreen.d DB;
    private View Dw;
    private KsRotateView Dx;
    private TextView Dy;
    private TextView Dz;
    private long mStartTime;

    @Override // com.kwad.sdk.core.g.a
    public final void U(final String str) {
        boolean tz = this.Dg.Cs.tz();
        boolean nr = com.kwad.components.core.e.c.b.nr();
        if (!tz || nr) {
            return;
        }
        this.Dx.lU();
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            hVar.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.l.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dg(str);
                }
            });
        }
        lq();
        ln();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i10) {
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getRootView().post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.l.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.ad.splashscreen.h hVar = l.this.Dg;
                if (hVar != null) {
                    hVar.CI = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.Dw = viewStub.inflate();
        } else {
            this.Dw = findViewById(R.id.ksad_rotate_root);
        }
        this.Dy = (TextView) findViewById(R.id.ksad_rotate_text);
        this.Dz = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.Dx = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void j(int i10, String str) {
        TextView textView = this.Dz;
        if (textView != null) {
            if (i10 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kA() {
        com.kwad.sdk.core.g.c cVar = this.DA;
        if (cVar != null) {
            cVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lj() {
        AdTemplate adTemplate = this.Dg.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.DB = com.kwad.components.ad.splashscreen.d.a(adTemplate, dQ, this.Dg.mApkDownloadHelper, 1);
        TextView textView = this.Dy;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dk(dQ));
        }
        TextView textView2 = this.Dz;
        if (textView2 != null) {
            textView2.setText("或点击" + this.DB.ku());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lk() {
        View view = this.Dw;
        if (view == null || this.Dg == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, 184, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.d.a.sY().aW(184);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ll() {
        AdMatrixInfo.RotateInfo cU = com.kwad.sdk.core.response.b.b.cU(this.Dg.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.DA;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(cU);
            this.DA = cVar2;
            cVar2.a(this);
            return;
        }
        cVar.a(cU);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lm() {
        com.kwad.sdk.core.g.c cVar = this.DA;
        if (cVar != null) {
            cVar.bi(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ln() {
        com.kwad.sdk.core.g.c cVar = this.DA;
        if (cVar != null) {
            cVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lo() {
        this.Dx.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                l.this.Dx.lo();
            }
        });
    }

    @Override // com.kwad.sdk.core.g.a
    public final void lr() {
        com.kwad.sdk.core.adlog.c.bN(this.Dg.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Dg.c(1, getContext(), 162, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashRotatePresenter", CardContext.ON_UNBIND_FUNC);
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}
