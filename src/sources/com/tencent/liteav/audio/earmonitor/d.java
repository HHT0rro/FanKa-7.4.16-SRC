package com.tencent.liteav.audio.earmonitor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f42650a;

    private d(a aVar) {
        this.f42650a = aVar;
    }

    public static Runnable a(a aVar) {
        return new d(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f42650a);
    }
}
