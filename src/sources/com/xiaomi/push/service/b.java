package com.xiaomi.push.service;

import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f48255b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kc.h f48256c;

    public b(int i10, kc.h hVar) {
        this.f48255b = i10;
        this.f48256c = hVar;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return this.f48255b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f48256c.j(this.f48255b);
    }
}
