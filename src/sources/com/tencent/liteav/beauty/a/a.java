package com.tencent.liteav.beauty.a;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public Thread f42930a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f42931b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0638a f42932c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f42933d;

    /* renamed from: com.tencent.liteav.beauty.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0638a {
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f42933d = true;
    }
}
