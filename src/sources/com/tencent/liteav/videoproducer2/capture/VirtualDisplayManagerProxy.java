package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VirtualDisplayManagerProxy {
    private final VirtualDisplayManager mManager = VirtualDisplayManager.a(ContextUtils.getApplicationContext());

    @CalledByNative
    public VirtualDisplayManagerProxy() {
    }

    @CalledByNative
    public void startVirtualDisplaySync(Surface surface, int i10, int i11, MediaProjection mediaProjection, boolean z10, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        this.mManager.a(surface, i10, i11, mediaProjection, z10, virtualDisplayListener);
    }

    @CalledByNative
    public void stopVirtualDisplaySync(Surface surface) {
        this.mManager.a(surface);
    }
}
