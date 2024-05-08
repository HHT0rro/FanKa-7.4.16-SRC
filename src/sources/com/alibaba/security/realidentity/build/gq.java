package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.RPCall;

/* compiled from: CancellationHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gq {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f3754a;

    /* renamed from: b, reason: collision with root package name */
    public volatile RPCall f3755b;

    private boolean b() {
        return this.f3754a;
    }

    public final void a() {
        if (this.f3755b != null) {
            this.f3755b.cancel();
        }
        this.f3754a = true;
    }

    private void a(RPCall rPCall) {
        this.f3755b = rPCall;
    }
}
