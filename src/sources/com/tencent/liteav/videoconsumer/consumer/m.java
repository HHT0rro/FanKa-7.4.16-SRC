package com.tencent.liteav.videoconsumer.consumer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43750a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f43751b;

    private m(b bVar, Object obj) {
        this.f43750a = bVar;
        this.f43751b = obj;
    }

    public static Runnable a(b bVar, Object obj) {
        return new m(bVar, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43750a.f43715x = this.f43751b;
    }
}
