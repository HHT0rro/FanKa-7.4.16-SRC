package com.zego.zegoavkit2.videorender;

import com.zego.zegoavkit2.entities.VideoFrame;
import com.zego.zegoavkit2.enums.VideoPixelFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoVideoRenderCallback {
    void onVideoRenderCallback(VideoFrame videoFrame, VideoPixelFormat videoPixelFormat, String str);

    void setFlipMode(String str, int i10);

    void setRotation(String str, int i10);
}
