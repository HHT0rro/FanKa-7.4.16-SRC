package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f42907a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f42908b;

    private p(l.a aVar, Runnable runnable) {
        this.f42907a = aVar;
        this.f42908b = runnable;
    }

    public static Runnable a(l.a aVar, Runnable runnable) {
        return new p(aVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.f42907a;
        this.f42908b.run();
        synchronized (l.this) {
            l.this.f42896c.remove(aVar);
        }
    }
}
