package com.vivo.push.restructure.request;

/* compiled from: RequestManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f46358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f46359b;

    public f(e eVar, b bVar) {
        this.f46359b = eVar;
        this.f46358a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f46358a;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f46358a.b().a(1003);
    }
}
