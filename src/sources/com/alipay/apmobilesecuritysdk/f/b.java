package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f4324a = new b();

    /* renamed from: b, reason: collision with root package name */
    private Thread f4325b = null;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<Runnable> f4326c = new LinkedList<>();

    public static b a() {
        return f4324a;
    }

    public static /* synthetic */ Thread b(b bVar) {
        bVar.f4325b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.f4326c.add(runnable);
        if (this.f4325b == null) {
            Thread thread = new Thread(new c(this));
            this.f4325b = thread;
            thread.start();
        }
    }
}
