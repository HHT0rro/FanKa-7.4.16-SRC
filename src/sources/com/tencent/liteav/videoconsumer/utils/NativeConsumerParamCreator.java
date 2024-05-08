package com.tencent.liteav.videoconsumer.utils;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeConsumerParamCreator {
    @CalledByNative
    public static VideoDecoderDef.ConsumerScene createConsumerScene(int i10) {
        return VideoDecoderDef.ConsumerScene.a(i10);
    }

    @CalledByNative
    private static VideoDecodeController.DecodeStrategy createDecodeStrategy(int i10) {
        return VideoDecodeController.DecodeStrategy.a(i10);
    }

    @CalledByNative
    public static GLConstants.PixelBufferType createPixelBufferType(int i10) {
        return GLConstants.PixelBufferType.a(i10);
    }

    @CalledByNative
    public static GLConstants.PixelFormatType createPixelFormatType(int i10) {
        return GLConstants.PixelFormatType.a(i10);
    }

    @CalledByNative
    private static GLConstants.GLScaleType createScaleType(int i10) {
        return GLConstants.GLScaleType.a(i10);
    }

    @CalledByNative
    public static SnapshotSourceType createSnapshotSourceType(int i10) {
        return SnapshotSourceType.a(i10);
    }

    @CalledByNative
    public static Rotation fromInt(int i10) {
        for (Rotation rotation : Rotation.values()) {
            if (rotation.mValue == i10) {
                return rotation;
            }
        }
        return Rotation.NORMAL;
    }
}
