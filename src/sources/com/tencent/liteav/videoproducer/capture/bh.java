package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VirtualDisplayManager f44383a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f44384b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44385c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44386d;

    /* renamed from: e, reason: collision with root package name */
    private final MediaProjection f44387e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44388f;

    /* renamed from: g, reason: collision with root package name */
    private final VirtualDisplayManager.VirtualDisplayListener f44389g;

    private bh(VirtualDisplayManager virtualDisplayManager, Surface surface, int i10, int i11, MediaProjection mediaProjection, boolean z10, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        this.f44383a = virtualDisplayManager;
        this.f44384b = surface;
        this.f44385c = i10;
        this.f44386d = i11;
        this.f44387e = mediaProjection;
        this.f44388f = z10;
        this.f44389g = virtualDisplayListener;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, Surface surface, int i10, int i11, MediaProjection mediaProjection, boolean z10, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        return new bh(virtualDisplayManager, surface, i10, i11, mediaProjection, z10, virtualDisplayListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayManager.a(this.f44383a, this.f44384b, this.f44385c, this.f44386d, this.f44387e, this.f44388f, this.f44389g);
    }
}
