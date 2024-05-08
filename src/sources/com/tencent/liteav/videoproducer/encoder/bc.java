package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44604a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoEncodeParams f44605b;

    private bc(ax axVar, VideoEncodeParams videoEncodeParams) {
        this.f44604a = axVar;
        this.f44605b = videoEncodeParams;
    }

    public static Runnable a(ax axVar, VideoEncodeParams videoEncodeParams) {
        return new bc(axVar, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44604a, this.f44605b);
    }
}
