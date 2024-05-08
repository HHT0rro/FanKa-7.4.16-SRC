package com.qq.e.ads.nativ;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j10, int i10, int i11);

    void reportVideoPause(long j10);

    void reportVideoPreload();

    void reportVideoResume(long j10);

    void reportVideoStart();
}
