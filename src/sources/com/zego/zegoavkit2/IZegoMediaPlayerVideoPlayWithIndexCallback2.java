package com.zego.zegoavkit2;

import com.zego.zegoavkit2.entities.VideoFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoMediaPlayerVideoPlayWithIndexCallback2 {
    int dequeueInputBuffer(int i10, int i11, int[] iArr, int[] iArr2, int i12);

    VideoFrame getInputBuffer(int i10, int i11);

    void queueInputBuffer(int i10, ZegoVideoDataFormat zegoVideoDataFormat, int i11);
}
