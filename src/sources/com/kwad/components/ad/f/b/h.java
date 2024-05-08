package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private ViewGroup ng;
    private TextView nh;

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        this.nh.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(this.mN.mAdTemplate)));
        this.ng.setOnClickListener(this);
        this.ng.setVisibility(0);
    }

    private void ez() {
        com.kwad.components.core.e.d.a.a(new a.C0461a(this.ng.getContext()).aq(this.mN.mAdTemplate).an(2).a(new a.b() { // from class: com.kwad.components.ad.f.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.mN.mAdTemplate, 2, h.this.mN.mI.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.mN.mw.l(this.ng);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.h.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                h.this.ex();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
        this.ng.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ez();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ng = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.nh = (TextView) findViewById(R.id.ksad_h5_open);
    }
}
