package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44828a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44829b;

    private m(h hVar, float f10) {
        this.f44828a = hVar;
        this.f44829b = f10;
    }

    public static Runnable a(h hVar, float f10) {
        return new m(hVar, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44828a;
        final float f10 = this.f44829b;
        final com.tencent.liteav.beauty.b.i iVar = (com.tencent.liteav.beauty.b.i) hVar.b(h.b.f44807c);
        if (iVar != null) {
            iVar.runOnDraw(new Runnable(iVar, f10) { // from class: com.tencent.liteav.beauty.b.k

                /* renamed from: a, reason: collision with root package name */
                private final i f43056a;

                /* renamed from: b, reason: collision with root package name */
                private final float f43057b;

                {
                    this.f43056a = iVar;
                    this.f43057b = f10;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i iVar2 = this.f43056a;
                    iVar2.f43044e.put(1, this.f43057b);
                    iVar2.f43044e.put(2, 0.0f);
                }
            });
        }
    }
}
