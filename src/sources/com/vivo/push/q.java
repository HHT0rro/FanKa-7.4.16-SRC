package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f46281a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46282b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f46283c;

    public q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f46283c = mVar;
        this.f46281a = bVar;
        this.f46282b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f46283c.a(this.f46281a);
        this.f46283c.c(this.f46282b);
    }
}
