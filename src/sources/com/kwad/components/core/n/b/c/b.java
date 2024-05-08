package com.kwad.components.core.n.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView Ny;

    public b(Context context) {
        super(context);
    }

    public final b a(@NonNull DetailVideoView detailVideoView) {
        ap.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.Ny = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i10, int i11) {
        this.Ny.adaptVideoSize(i10, i11);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z10) {
        this.Ny.fixWidth(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.Ny.getTextureViewGravity();
    }

    public final DetailVideoView oX() {
        return this.Ny;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z10) {
        this.Ny.setAd(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.Ny.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.n.b.c.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z10) {
        this.Ny.setForce(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z10) {
        this.Ny.setHorizontalVideo(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (iKsMediaPlayer instanceof a) {
            this.Ny.setMediaPlayer(((a) iKsMediaPlayer).oV());
            return;
        }
        throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f10) {
        this.Ny.setRadius(f10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i10) {
        this.Ny.updateTextureViewGravity(i10);
    }
}
