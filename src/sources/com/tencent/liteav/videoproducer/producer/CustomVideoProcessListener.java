package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface CustomVideoProcessListener {
    void onGLContextCreated();

    void onGLContextDestroy();

    void onProcessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2);
}
