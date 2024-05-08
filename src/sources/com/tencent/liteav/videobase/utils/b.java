package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingDeque<PixelFrame> f43488a = new LinkedBlockingDeque(2);

    @Override // com.tencent.liteav.videobase.utils.k
    public final PixelFrame a() {
        return this.f43488a.poll();
    }

    @Override // com.tencent.liteav.videobase.utils.k
    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f43488a.drainTo(arrayList);
        PixelFrame.releasePixelFrames(arrayList);
    }

    @Override // com.tencent.liteav.videobase.utils.k
    public final void a(PixelFrame pixelFrame) {
        pixelFrame.retain();
        try {
            this.f43488a.put(pixelFrame);
        } catch (InterruptedException e2) {
            LiteavLog.e("BlockingFrameQueue", "push frame failed with exception", e2);
        }
    }
}
