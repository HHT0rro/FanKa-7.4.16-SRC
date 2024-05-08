package com.zego.zegoavkit2.videorender;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoExternalVideoRender {
    public static boolean enableVideoPreview(boolean z10, int i10) {
        return ZegoExternalVideoRenderJNI.enableVideoPreview(z10, i10);
    }

    public static boolean enableVideoRender(boolean z10, String str) {
        return ZegoExternalVideoRenderJNI.enableVideoRender(z10, str);
    }

    public static void setVideoDecodeCallback(IZegoVideoDecodeCallback iZegoVideoDecodeCallback) {
        ZegoExternalVideoRenderJNI.setVideoDecodeCallback(iZegoVideoDecodeCallback);
    }

    public static void setVideoRenderCallback(IZegoVideoRenderCallback iZegoVideoRenderCallback) {
        ZegoExternalVideoRenderJNI.setVideoRenderCallback(iZegoVideoRenderCallback);
    }

    public static void setVideoRenderType(VideoRenderType videoRenderType) {
        ZegoExternalVideoRenderJNI.setVideoRenderType(videoRenderType.value());
    }
}
