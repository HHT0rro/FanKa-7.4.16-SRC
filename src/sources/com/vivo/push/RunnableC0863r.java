package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.r, reason: case insensitive filesystem */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RunnableC0863r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46284a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f46285b;

    public RunnableC0863r(m mVar, String str) {
        this.f46285b = mVar;
        this.f46284a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a b4;
        b4 = this.f46285b.b(this.f46284a);
        if (b4 != null) {
            b4.a(1003, new Object[0]);
        }
    }
}
