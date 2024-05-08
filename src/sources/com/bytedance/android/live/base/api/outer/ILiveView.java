package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILiveView {
    View getView();

    void onDislike();

    void openLive();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z10);

    void show();

    void stream();
}
