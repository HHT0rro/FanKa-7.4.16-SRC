package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f46277a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46278b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f46279c;

    public o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f46279c = mVar;
        this.f46277a = bVar;
        this.f46278b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f46279c.a(this.f46277a);
        this.f46279c.c(this.f46278b);
    }
}
