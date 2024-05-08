package com.tencent.liteav.videoconsumer.renderer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    private final IVideoReporter f44123b;

    /* renamed from: a, reason: collision with root package name */
    private final String f44122a = "VideoRenderStatistic_" + hashCode();

    /* renamed from: c, reason: collision with root package name */
    private boolean f44124c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f44125d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f44126e = false;

    public s(@NonNull IVideoReporter iVideoReporter) {
        this.f44123b = iVideoReporter;
    }

    public final void a(boolean z10) {
        if (!this.f44125d) {
            this.f44125d = true;
            this.f44126e = false;
        }
        LiteavLog.i(this.f44122a, "notify renderer started, isCustomRenderer: ".concat(String.valueOf(z10)));
    }

    public final void b(boolean z10) {
        this.f44125d = false;
        LiteavLog.i(this.f44122a, "notify renderer stopped, isCustomRenderer: ".concat(String.valueOf(z10)));
    }

    public final void c(boolean z10) {
        if (z10 != this.f44124c) {
            LiteavLog.i(this.f44122a, "custom render enabled: ".concat(String.valueOf(z10)));
        }
        this.f44124c = z10;
    }

    private void b(boolean z10, VideoRenderListener.a aVar, @Nullable PixelFrame pixelFrame) {
        if (this.f44126e) {
            return;
        }
        if ((z10 || aVar != VideoRenderListener.a.RENDER_ON_VIEW) && !((z10 && aVar == VideoRenderListener.a.RENDER_WITHOUT_VIEW) || aVar == VideoRenderListener.a.RENDER_WITH_HDR)) {
            return;
        }
        LiteavLog.i(this.f44122a, "rendered first frame!");
        this.f44123b.notifyEvent(h.b.EVT_VIDEO_RENDER_FIRST_FRAME, pixelFrame, "rendered first frame");
        this.f44126e = true;
    }

    public final void a(boolean z10, VideoRenderListener.a aVar, @Nullable PixelFrame pixelFrame) {
        b(z10, aVar, pixelFrame);
        boolean z11 = this.f44124c;
        if ((z11 && z10) || !(z11 || z10)) {
            if (aVar == VideoRenderListener.a.RENDER_ON_VIEW || aVar == VideoRenderListener.a.RENDER_WITHOUT_VIEW || aVar == VideoRenderListener.a.RENDER_WITH_HDR) {
                this.f44123b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME, pixelFrame);
            }
        }
    }
}
