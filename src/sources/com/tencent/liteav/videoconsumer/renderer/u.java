package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44153a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoRenderListener f44154b;

    private u(t tVar, VideoRenderListener videoRenderListener) {
        this.f44153a = tVar;
        this.f44154b = videoRenderListener;
    }

    public static Runnable a(t tVar, VideoRenderListener videoRenderListener) {
        return new u(tVar, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44153a, this.f44154b);
    }
}
