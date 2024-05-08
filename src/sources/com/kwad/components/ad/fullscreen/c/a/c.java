package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView hp;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.hp == null || com.kwad.components.ad.reward.a.b.gs()) {
                return;
            }
            c.this.hp.post(new ay() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    c.this.hp.setSelected(false);
                    c.this.qo.oJ.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };

    private void ca() {
        this.hp.setVisibility(0);
        g gVar = this.qo;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        if (!gVar.oH && com.kwad.components.core.s.a.ah(getContext()).qW()) {
            this.hp.setSelected(false);
            this.qo.d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.hp.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qo.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.hp.setSelected(true);
            this.qo.d(true, true);
        }
        this.qo.oJ.a(this.hq);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hp) {
            this.qo.oJ.setAudioEnabled(!r0.isSelected(), true);
            this.hp.setSelected(!r3.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.hp = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.hq);
    }
}
