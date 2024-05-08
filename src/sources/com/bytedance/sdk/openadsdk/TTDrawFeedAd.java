package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTDrawFeedAd extends TTFeedAd {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z10);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i10);
}
