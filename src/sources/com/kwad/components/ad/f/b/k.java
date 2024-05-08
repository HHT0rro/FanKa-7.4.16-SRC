package com.kwad.components.ad.f.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k extends com.kwad.components.ad.f.a.a {
    private ProgressBar nm;

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i10) {
        this.nm.setProgress(i10);
        if (this.nm.getVisibility() == 0) {
            return;
        }
        this.nm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB() {
        if (this.nm.getVisibility() != 0) {
            return;
        }
        this.nm.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.nm.setProgress(0);
        this.nm.setVisibility(8);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.k.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                k.this.eB();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                k.this.eB();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                k.this.H(j10 != 0 ? (int) ((((float) j11) * 100.0f) / ((float) j10)) : 0);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nm = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
