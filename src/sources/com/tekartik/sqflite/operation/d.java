package com.tekartik.sqflite.operation;

/* compiled from: QueuedOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final c f38997a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f38998b;

    public d(c cVar, Runnable runnable) {
        this.f38997a = cVar;
        this.f38998b = runnable;
    }

    public void a() {
        this.f38998b.run();
    }
}
