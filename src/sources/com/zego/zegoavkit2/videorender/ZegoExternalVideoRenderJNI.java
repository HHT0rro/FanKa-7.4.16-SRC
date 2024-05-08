package com.zego.zegoavkit2.videorender;

import com.zego.zegoavkit2.entities.EncodedVideoFrame;
import com.zego.zegoavkit2.entities.VideoFrame;
import com.zego.zegoavkit2.enums.VideoCodecType;
import com.zego.zegoavkit2.enums.VideoPixelFormat;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoExternalVideoRenderJNI {
    private static volatile IZegoVideoDecodeCallback s_ZegoVideoDecodeCallback;
    private static volatile IZegoVideoRenderCallback s_ZegoVideoRenderCallback;

    public static native boolean enableVideoPreview(boolean z10, int i10);

    public static native boolean enableVideoRender(boolean z10, String str);

    public static void onVideoDecodeCallback(ByteBuffer byteBuffer, int i10, boolean z10, double d10, int i11, String str) {
        if (s_ZegoVideoDecodeCallback != null) {
            EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
            encodedVideoFrame.data = byteBuffer;
            encodedVideoFrame.codecType = VideoCodecType.valueOf(i10);
            encodedVideoFrame.isKeyFrame = z10;
            encodedVideoFrame.reference_time_ms = d10;
            encodedVideoFrame.rotation = i11;
            s_ZegoVideoDecodeCallback.onVideoDecodeCallback(encodedVideoFrame, str);
        }
    }

    public static void onVideoRenderCallback(ByteBuffer[] byteBufferArr, int[] iArr, int i10, int i11, int i12, String str) {
        if (s_ZegoVideoRenderCallback == null) {
            return;
        }
        VideoFrame videoFrame = new VideoFrame();
        int i13 = 0;
        while (true) {
            ByteBuffer[] byteBufferArr2 = videoFrame.byteBuffers;
            if (i13 < byteBufferArr2.length) {
                byteBufferArr2[i13] = byteBufferArr[i13];
                videoFrame.strides[i13] = iArr[i13];
                i13++;
            } else {
                videoFrame.width = i10;
                videoFrame.height = i11;
                s_ZegoVideoRenderCallback.onVideoRenderCallback(videoFrame, VideoPixelFormat.valueOf(i12), str);
                return;
            }
        }
    }

    public static void setFlipMode(String str, int i10) {
        if (s_ZegoVideoRenderCallback != null) {
            s_ZegoVideoRenderCallback.setFlipMode(str, i10);
        }
    }

    private static native void setNativeVideoDecodeCallback(boolean z10);

    private static native void setNativeVideoRenderCallback(boolean z10);

    public static void setRotation(String str, int i10) {
        if (s_ZegoVideoRenderCallback != null) {
            s_ZegoVideoRenderCallback.setRotation(str, i10);
        }
    }

    public static void setVideoDecodeCallback(IZegoVideoDecodeCallback iZegoVideoDecodeCallback) {
        s_ZegoVideoDecodeCallback = iZegoVideoDecodeCallback;
        setNativeVideoDecodeCallback(iZegoVideoDecodeCallback != null);
    }

    public static void setVideoRenderCallback(IZegoVideoRenderCallback iZegoVideoRenderCallback) {
        s_ZegoVideoRenderCallback = iZegoVideoRenderCallback;
        setNativeVideoRenderCallback(iZegoVideoRenderCallback != null);
    }

    public static native void setVideoRenderType(int i10);
}
