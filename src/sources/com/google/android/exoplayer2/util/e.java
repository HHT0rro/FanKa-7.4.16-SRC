package com.google.android.exoplayer2.util;

/* compiled from: ConditionVariable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f22970a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22971b;

    public e() {
        this(Clock.f22902a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f22971b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z10 = false;
        while (!this.f22971b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z10;
        z10 = this.f22971b;
        this.f22971b = false;
        return z10;
    }

    public synchronized boolean d() {
        return this.f22971b;
    }

    public synchronized boolean e() {
        if (this.f22971b) {
            return false;
        }
        this.f22971b = true;
        notifyAll();
        return true;
    }

    public e(Clock clock) {
        this.f22970a = clock;
    }
}
