package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.PointF;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class r {
    public abstract void a(Rotation rotation);

    public abstract void a(GLConstants.GLScaleType gLScaleType);

    public abstract void a(TakeSnapshotListener takeSnapshotListener);

    public abstract void a(PixelFrame pixelFrame);

    public abstract void a(DisplayTarget displayTarget, boolean z10);

    public abstract void a(VideoRenderListener videoRenderListener);

    public abstract void a(List<PointF> list, List<PointF> list2);

    public abstract void a(boolean z10);

    public abstract void b(boolean z10);
}
