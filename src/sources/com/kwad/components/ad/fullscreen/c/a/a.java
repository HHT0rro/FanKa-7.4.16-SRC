package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.br;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements br.a {
    private l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.hi) {
                return;
            }
            a.this.hh.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (!a.this.qo.oJ.jM()) {
                a.this.a(j10, j11);
                a.this.hj = j11;
            } else if (j11 > 800) {
                a.this.hj = j11;
                if (a.this.hj > j10) {
                    a.this.hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.hg.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(a.this.getContext(), 0.0f);
                    a.this.hg.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j10, j11);
                a.a(a.this, true);
            }
        }
    };
    private TextView hf;
    private View hg;
    private br hh;
    private boolean hi;
    private long hj;
    private AdInfo mAdInfo;

    private void ca() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        this.mAdInfo = dQ;
        this.hf.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(dQ)));
        this.hf.setVisibility(0);
        this.qo.oJ.a(this.gO);
    }

    private void x(int i10) {
        this.hf.setText(String.valueOf(i10));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.hh = new br(this);
        ca();
        if (this.qo.oJ.jM()) {
            x(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hf = (TextView) findViewById(R.id.ksad_video_count_down);
        this.hg = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        this.hi = false;
        this.hh.removeCallbacksAndMessages(null);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.hi = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j10, long j11) {
        x(Math.max((int) ((((float) (j10 - j11)) / 1000.0f) + 0.5f), 0));
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.qo.fM() && !this.qo.fL()) {
                long j10 = this.hj + 500;
                this.hj = j10;
                if (j10 > 30000) {
                    this.hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hg.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(getContext(), 0.0f);
                    this.hg.setLayoutParams(marginLayoutParams);
                    return;
                }
                a(30000L, j10);
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
