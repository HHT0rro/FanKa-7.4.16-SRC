package com.tencent.open.log;

import com.tencent.open.log.d;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class Tracer {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f45224a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f45225b;

    /* renamed from: c, reason: collision with root package name */
    private g f45226c;

    public Tracer() {
        this(c.f45250a, true, g.f45271a);
    }

    public void a(int i10, Thread thread, long j10, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f45224a, i10)) {
            doTrace(i10, thread, j10, str, str2, th);
        }
    }

    public boolean d() {
        return this.f45225b;
    }

    public abstract void doTrace(int i10, Thread thread, long j10, String str, String str2, Throwable th);

    public g e() {
        return this.f45226c;
    }

    public Tracer(int i10, boolean z10, g gVar) {
        this.f45224a = c.f45250a;
        this.f45225b = true;
        this.f45226c = g.f45271a;
        a(i10);
        a(z10);
        a(gVar);
    }

    public void a(int i10) {
        this.f45224a = i10;
    }

    public void a(boolean z10) {
        this.f45225b = z10;
    }

    public void a(g gVar) {
        this.f45226c = gVar;
    }
}
