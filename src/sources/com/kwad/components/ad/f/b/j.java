package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j extends com.kwad.components.ad.f.a.a {
    private View nk;

    /* JADX INFO: Access modifiers changed from: private */
    public void eA() {
        if (this.nk.getVisibility() == 0) {
            return;
        }
        this.nk.setVisibility(0);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.nk.setVisibility(8);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.j.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                j.this.eA();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nk = findViewById(R.id.ksad_video_error_container);
    }
}
