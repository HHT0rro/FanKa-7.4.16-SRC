package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class YogaConfig {

    /* renamed from: a, reason: collision with root package name */
    public long f19189a;

    static {
        SoLoader.loadLibrary("yoga");
    }

    public YogaConfig() {
        long jni_YGConfigNew = jni_YGConfigNew();
        this.f19189a = jni_YGConfigNew;
        if (jni_YGConfigNew == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    private native void jni_YGConfigFree(long j10);

    private native long jni_YGConfigNew();

    private native void jni_YGConfigSetExperimentalFeatureEnabled(long j10, int i10, boolean z10);

    private native void jni_YGConfigSetLogger(long j10, Object obj);

    private native void jni_YGConfigSetPointScaleFactor(long j10, float f10);

    private native void jni_YGConfigSetUseLegacyStretchBehaviour(long j10, boolean z10);

    private native void jni_YGConfigSetUseWebDefaults(long j10, boolean z10);

    public void finalize() throws Throwable {
        try {
            jni_YGConfigFree(this.f19189a);
        } finally {
            super.finalize();
        }
    }
}
