package com.kwad.components.ad.f.a;

import com.kwad.components.core.video.k;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Presenter {
    public b mN;
    public k mVideoPlayStateListener;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.mN = (b) Jx();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.mN.mO.a(this.mVideoPlayStateListener);
    }
}
