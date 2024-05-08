package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class VideoRenderListener {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        RENDER_FAILED,
        RENDER_ON_VIEW,
        RENDER_WITHOUT_VIEW,
        RENDER_WITH_HDR
    }

    public void onRenderFrame(@Nullable PixelFrame pixelFrame, a aVar) {
    }

    public void onRenderSurfaceChanged(Surface surface) {
    }

    public void onRenderTargetSizeChanged(int i10, int i11) {
    }
}
