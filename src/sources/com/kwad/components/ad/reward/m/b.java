package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.j.a<h> implements g.a {
    private com.kwad.components.core.g.c xK;

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c();
        this.xK = cVar;
        cVar.z(M);
    }

    public final FrameLayout O(Context context) {
        FrameLayout imagePlayerView = this.xK.getImagePlayerView(context);
        this.xK.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.j.a
    public final void a(h hVar) {
        this.xK.d(hVar);
    }

    @Override // com.kwad.components.ad.j.a
    public final void b(h hVar) {
        this.xK.c(hVar);
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        this.xK.destroy();
    }

    @Override // com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        return this.xK.getPlayDuration();
    }

    public final void jI() {
        this.xK.setURLs(com.kwad.sdk.core.response.b.a.ba(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)));
        this.xK.play();
    }

    @Override // com.kwad.components.ad.j.a
    public final void pause() {
        this.xK.pause();
    }

    @Override // com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        this.xK.destroy();
    }

    @Override // com.kwad.components.ad.j.a
    public final void resume() {
        this.xK.resume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void skipToEnd() {
        this.xK.skipToEnd();
    }
}
