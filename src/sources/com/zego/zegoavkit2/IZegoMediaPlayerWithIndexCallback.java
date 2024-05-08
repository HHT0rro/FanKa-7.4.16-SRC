package com.zego.zegoavkit2;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoMediaPlayerWithIndexCallback {
    void onAudioBegin(int i10);

    void onBufferBegin(int i10);

    void onBufferEnd(int i10);

    void onLoadComplete(int i10);

    void onMediaPlayerVideoSizeChanged(int i10, int i11, int i12);

    void onPlayEnd(int i10);

    void onPlayError(int i10, int i11);

    void onPlayPause(int i10);

    void onPlayResume(int i10);

    void onPlayStart(int i10);

    void onPlayStop(int i10);

    void onProcessInterval(long j10, int i10);

    void onReadEOF(int i10);

    void onRenderingProcessInterval(long j10, int i10);

    void onSeekComplete(int i10, long j10, int i11);

    void onSnapshot(Bitmap bitmap, int i10);

    void onVideoBegin(int i10);
}
