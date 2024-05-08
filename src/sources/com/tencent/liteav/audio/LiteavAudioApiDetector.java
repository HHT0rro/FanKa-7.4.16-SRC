package com.tencent.liteav.audio;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class LiteavAudioApiDetector {
    private static final boolean DEBUG = true;
    private static final String TAG = "LiteavAudioApiDetector";
    private boolean mIsAAudioSupported;
    private boolean mIsFastJavaSupported;
    private boolean mIsOboeSupported;
    private boolean mIsOpenSLSupported;

    @CalledByNative
    public LiteavAudioApiDetector(long j10) {
        storeAudioParameters();
        nativeCacheAudioParameters(j10, this.mIsOpenSLSupported, this.mIsAAudioSupported, this.mIsFastJavaSupported);
    }

    private boolean isAAudioSupported() {
        return LiteavSystemInfo.getSystemOSVersionInt() >= 27;
    }

    private boolean isFastJavaSupported() {
        return LiteavSystemInfo.getSystemOSVersionInt() >= 29;
    }

    private boolean isOboeSupported() {
        return isOpenSLSupported() || isAAudioSupported();
    }

    private boolean isOpenSLSupported() {
        return LiteavSystemInfo.getSystemOSVersionInt() >= 24;
    }

    private static native void nativeCacheAudioParameters(long j10, boolean z10, boolean z11, boolean z12);

    private void storeAudioParameters() {
        this.mIsOboeSupported = isOboeSupported();
        this.mIsOpenSLSupported = isOpenSLSupported();
        this.mIsAAudioSupported = isAAudioSupported();
        this.mIsFastJavaSupported = isFastJavaSupported();
    }
}
