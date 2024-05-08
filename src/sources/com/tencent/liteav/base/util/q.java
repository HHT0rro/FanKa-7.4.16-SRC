package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f42909a;

    private q(l.a aVar) {
        this.f42909a = aVar;
    }

    public static Runnable a(l.a aVar) {
        return new q(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.f42909a;
        l.this.f42894a.execute(aVar.f42898b);
    }
}
