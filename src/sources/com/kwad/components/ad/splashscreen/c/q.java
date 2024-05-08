package com.kwad.components.ad.splashscreen.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q extends e implements com.kwad.sdk.core.h.c {
    private SkipView Ei;
    private ImageView hp;
    private AdInfo mAdInfo;
    private volatile boolean Ef = false;
    private boolean Eg = false;
    private boolean Eh = false;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.splashscreen.c.q.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            q.this.Ef = false;
            if (q.this.hp != null) {
                q.this.hp.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.q.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        q qVar = q.this;
                        com.kwad.components.ad.splashscreen.e.a aVar = qVar.Dg.Cq;
                        if (aVar != null) {
                            aVar.setAudioEnabled(qVar.Ef, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = q.this.Dg;
                        if (hVar != null) {
                            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(hVar.mAdTemplate);
                            boolean z10 = q.this.Ef;
                            AdInfo.AdSplashInfo adSplashInfo = dQ.adSplashInfo;
                            String str = z10 ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(q.this.hp, str, q.this.Dg.mAdTemplate);
                            } else {
                                q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            }
                            q.this.hp.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.k Ej = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.c.q.2
        private boolean Em = false;
        private String En = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CN);

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (this.Em) {
                return;
            }
            q.this.Dg.kM();
            this.Em = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            if (q.this.Eh) {
                return;
            }
            q.this.Dg.i(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, final long j11) {
            q.this.Dg.X(((int) j11) / 1000);
            final int min = Math.min(q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j10) / 1000);
            final String str = this.En;
            q qVar = q.this;
            if (q.a(qVar, qVar.mAdInfo)) {
                q.this.Ei.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.q.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i10 = (int) (((min * 1000) - j11) / 1000);
                        if (i10 <= 0) {
                            i10 = 1;
                        }
                        q.this.Ei.W(str + i10);
                    }
                });
            }
            float f10 = ((float) j11) / 1000.0f;
            if (min <= 0 || f10 + 0.5d <= min - 1 || this.Em) {
                return;
            }
            q qVar2 = q.this;
            if (q.a(qVar2, qVar2.mAdInfo)) {
                q.this.Dg.kM();
                this.Em = true;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            q qVar = q.this;
            com.kwad.components.ad.splashscreen.e.a aVar = qVar.Dg.Cq;
            if (aVar != null) {
                aVar.setAudioEnabled(qVar.Ef, false);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (q.this.Eg) {
                return;
            }
            q.this.Dg.kC();
            com.kwad.components.ad.splashscreen.e.a aVar = q.this.Dg.Cq;
            if (aVar != null) {
                aVar.ae(true);
                q qVar = q.this;
                qVar.Dg.Cq.setAudioEnabled(qVar.Ef, true);
            }
            q.b(q.this, true);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
        }
    };

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cv(adInfo);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        ((DetailVideoView) this.Dg.mRootContainer.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.b(this.Ej);
        }
        this.Dg.Cs.a(this);
        this.Ei = (SkipView) this.Dg.mRootContainer.findViewById(com.kwad.components.ad.splashscreen.f.c.z(this.mAdInfo) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        if (u(this.mAdInfo)) {
            a(this.Ei, this.mAdInfo);
        }
        int i10 = this.mAdInfo.adSplashInfo.mute;
        if (i10 == 2) {
            this.Ef = true;
        } else if (i10 != 3) {
            this.Ef = false;
        } else {
            this.Ef = com.kwad.sdk.utils.k.bS(this.Dg.mRootContainer.getContext()) > 0;
        }
        if (com.kwad.components.core.s.a.ah(getContext()).qW()) {
            this.Ef = false;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = this.Dg.Cq;
        if (aVar2 != null) {
            aVar2.setAudioEnabled(this.Ef, false);
            this.Dg.Cq.a(this.hq);
        }
        this.hp = (ImageView) this.Dg.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.f.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hp.getLayoutParams();
            layoutParams.gravity = 51;
            this.hp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hp.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.d.a.a.a(this.hp.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(this.hp.getContext(), 16.0f);
            }
        }
        this.hp.setVisibility(0);
        String str = this.Ef ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.hp, str, this.Dg.mAdTemplate);
        } else {
            this.hp.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.hp.setSelected(this.Ef);
        this.hp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.q.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                q.this.Ef = !r4.Ef;
                if (q.this.Ef) {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerIconUrl;
                } else {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(q.this.hp, str2, q.this.Dg.mAdTemplate);
                } else {
                    q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                q.this.hp.setSelected(q.this.Ef);
                q qVar = q.this;
                qVar.Dg.Cq.setAudioEnabled(qVar.Ef, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Eh = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.a(this.Ej);
            this.Dg.Cq.b(this.hq);
        }
        if (this.Ei.getHandler() != null) {
            this.Ei.getHandler().removeCallbacksAndMessages(null);
        }
        this.Dg.Cs.b(this);
    }

    public static /* synthetic */ boolean a(q qVar, AdInfo adInfo) {
        return u(adInfo);
    }

    public static /* synthetic */ boolean b(q qVar, boolean z10) {
        qVar.Eg = true;
        return true;
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cy(adInfo));
    }
}
