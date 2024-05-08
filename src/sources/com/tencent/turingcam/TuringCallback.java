package com.tencent.turingcam;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TuringCallback {
    void onException(Throwable th);

    void onFinish(long j10, byte[] bArr);

    void onFinishFrameCheck(long j10, byte[] bArr);

    void onPreviewAvailable();

    void onPreviewDestroyed();
}
