package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43249a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43250b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f43251c;

    private d(b bVar, int i10, float[] fArr) {
        this.f43249a = bVar;
        this.f43250b = i10;
        this.f43251c = fArr;
    }

    public static Runnable a(b bVar, int i10, float[] fArr) {
        return new d(bVar, i10, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$setFloatVec3OnDraw$1(this.f43249a, this.f43250b, this.f43251c);
    }
}
