package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43252a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43253b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f43254c;

    private e(b bVar, int i10, float[] fArr) {
        this.f43252a = bVar;
        this.f43253b = i10;
        this.f43254c = fArr;
    }

    public static Runnable a(b bVar, int i10, float[] fArr) {
        return new e(bVar, i10, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$setFloatVec2OnDraw$2(this.f43252a, this.f43253b, this.f43254c);
    }
}
