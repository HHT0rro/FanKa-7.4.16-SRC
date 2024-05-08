package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44824a;

    /* renamed from: b, reason: collision with root package name */
    private final List f44825b;

    private k(h hVar, List list) {
        this.f44824a = hVar;
        this.f44825b = list;
    }

    public static Runnable a(h hVar, List list) {
        return new k(hVar, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44824a;
        List<com.tencent.liteav.beauty.b.o> list = this.f44825b;
        if (list != null && !list.isEmpty()) {
            com.tencent.liteav.beauty.b.n nVar = (com.tencent.liteav.beauty.b.n) hVar.a(h.b.f44809e);
            nVar.a();
            nVar.a(list);
            com.tencent.liteav.beauty.a.h(hVar.f44782b);
            return;
        }
        hVar.c(h.b.f44809e);
    }
}
