package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoConsumerReporter extends com.tencent.liteav.videobase.videobase.e {
    @CalledByNative
    public VideoConsumerReporter(long j10) {
        this.mNativeVideoReporter = j10;
    }

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeNotifyError(long j10, int i10, String str);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeNotifyEvent(long j10, int i10, Object obj, String str);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeNotifyKeyEvent(long j10, int i10, int i11, String str);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeNotifyKeyWarning(long j10, int i10, int i11, String str);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeNotifyWarning(long j10, int i10, String str);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeUpdateKeyStatus(long j10, int i10, int i11, double d10);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeUpdateKeyStatusObject(long j10, int i10, int i11, Object obj);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeUpdateStatus(long j10, int i10, double d10);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeUpdateStatusObject(long j10, int i10, Object obj);

    @Override // com.tencent.liteav.videobase.videobase.e
    public native void nativeUpdateStatusString(long j10, int i10, String str);

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeVideoReporter = 0L;
    }
}
