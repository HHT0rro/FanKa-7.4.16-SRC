package com.kwad.components.offline.api.core.video;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IKsMediaPlayerView {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i10, int i11);

    void fixWidth(boolean z10);

    int getTextureViewGravity();

    void setAd(boolean z10);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z10);

    void setHorizontalVideo(boolean z10);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f10);

    void updateTextureViewGravity(int i10);
}
