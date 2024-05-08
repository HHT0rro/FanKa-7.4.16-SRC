package com.tencent.liteav.base;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    private PathService() {
    }

    private static native void nativeOverride(int i10, String str);

    public static void override(int i10, String str) {
        nativeOverride(i10, str);
    }
}
