package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43255a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43256b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f43257c;

    private f(b bVar, int i10, float[] fArr) {
        this.f43255a = bVar;
        this.f43256b = i10;
        this.f43257c = fArr;
    }

    public static Runnable a(b bVar, int i10, float[] fArr) {
        return new f(bVar, i10, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$setFloatVec4OnDraw$3(this.f43255a, this.f43256b, this.f43257c);
    }
}
