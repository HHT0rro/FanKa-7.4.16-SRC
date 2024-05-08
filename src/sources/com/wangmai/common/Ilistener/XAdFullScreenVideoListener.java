package com.wangmai.common.Ilistener;

import com.wangmai.common.Ibase.XAdBaseListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface XAdFullScreenVideoListener extends XAdBaseListener {
    void onAdClose();

    void onAdLoad();

    void onSkippedVideo();

    void onVideoComplete();
}
