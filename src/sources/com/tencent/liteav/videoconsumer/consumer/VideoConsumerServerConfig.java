package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoConsumerServerConfig {
    public boolean enableVui = true;
    public int hwDecoderMaxCacheForHighRes = 8;
    public int hwDecoderMaxCacheForLowRes = 6;

    @CalledByNative
    public VideoConsumerServerConfig() {
    }

    public static boolean isHWHevcDecodeAllowed() {
        return nativeIsHardwareHevcDecodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcDecodeAllowed();

    @CalledByNative
    public void setEnableVui(boolean z10) {
        this.enableVui = z10;
    }

    @CalledByNative
    public void setHardwareDecoderMaxCache(int i10, int i11) {
        this.hwDecoderMaxCacheForHighRes = i10;
        this.hwDecoderMaxCacheForLowRes = i11;
    }

    public String toString() {
        return "VideoConsumerServerConfig(" + ("enableVui=" + this.enableVui + ",hwDecoderMaxCacheForHighRes=" + this.hwDecoderMaxCacheForHighRes + ",hwDecoderMaxCacheForLowRes=" + this.hwDecoderMaxCacheForLowRes) + ")";
    }
}
