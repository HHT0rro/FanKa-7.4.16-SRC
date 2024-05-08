package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43246a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43247b;

    /* renamed from: c, reason: collision with root package name */
    private final float f43248c;

    private c(b bVar, int i10, float f10) {
        this.f43246a = bVar;
        this.f43247b = i10;
        this.f43248c = f10;
    }

    public static Runnable a(b bVar, int i10, float f10) {
        return new c(bVar, i10, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$setFloatOnDraw$0(this.f43246a, this.f43247b, this.f43248c);
    }
}
