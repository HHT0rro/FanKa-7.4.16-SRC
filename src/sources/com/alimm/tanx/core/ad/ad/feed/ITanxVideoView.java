package com.alimm.tanx.core.ad.ad.feed;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxVideoView {
    void destroy();

    View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener);

    boolean isMute();

    void mute();

    void pause();

    void play();

    void resumeVolume();

    void setVolume(int i10);
}
