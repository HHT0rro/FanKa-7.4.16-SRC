package com.alimm.tanx.core.view.player;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxPlayerListener {
    void onVideoCached();

    void onVideoComplete();

    void onVideoError();

    void onVideoInit();

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady(int i10);

    void onVideoStart();
}
