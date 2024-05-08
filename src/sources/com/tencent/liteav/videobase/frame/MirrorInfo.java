package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MirrorInfo {
    public boolean isHorizontal;
    public boolean isVertical;

    public MirrorInfo() {
        this.isHorizontal = false;
        this.isVertical = false;
    }

    @CalledByNative
    public MirrorInfo(boolean z10, boolean z11) {
        this.isHorizontal = z10;
        this.isVertical = z11;
    }
}
