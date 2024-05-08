package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44826a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44827b;

    private l(h hVar, float f10) {
        this.f44826a = hVar;
        this.f44827b = f10;
    }

    public static Runnable a(h hVar, float f10) {
        return new l(hVar, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44826a;
        float f10 = this.f44827b;
        if (f10 < 0.0f) {
            hVar.c(h.b.f44806b);
            return;
        }
        com.tencent.liteav.beauty.b.f fVar = (com.tencent.liteav.beauty.b.f) hVar.a(h.b.f44806b);
        if (fVar != null) {
            fVar.f43022a.a(f10, 0.0f);
            fVar.f43023b.a(0.0f, f10);
        }
    }
}
