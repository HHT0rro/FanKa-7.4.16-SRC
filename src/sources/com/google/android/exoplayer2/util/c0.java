package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.f1;

/* compiled from: StandaloneMediaClock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c0 implements o {

    /* renamed from: b, reason: collision with root package name */
    public final Clock f22961b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22962c;

    /* renamed from: d, reason: collision with root package name */
    public long f22963d;

    /* renamed from: e, reason: collision with root package name */
    public long f22964e;

    /* renamed from: f, reason: collision with root package name */
    public f1 f22965f = f1.f20696d;

    public c0(Clock clock) {
        this.f22961b = clock;
    }

    public void a(long j10) {
        this.f22963d = j10;
        if (this.f22962c) {
            this.f22964e = this.f22961b.a();
        }
    }

    public void b() {
        if (this.f22962c) {
            return;
        }
        this.f22964e = this.f22961b.a();
        this.f22962c = true;
    }

    @Override // com.google.android.exoplayer2.util.o
    public void c(f1 f1Var) {
        if (this.f22962c) {
            a(t());
        }
        this.f22965f = f1Var;
    }

    @Override // com.google.android.exoplayer2.util.o
    public f1 d() {
        return this.f22965f;
    }

    public void e() {
        if (this.f22962c) {
            a(t());
            this.f22962c = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.o
    public long t() {
        long a10;
        long j10 = this.f22963d;
        if (!this.f22962c) {
            return j10;
        }
        long a11 = this.f22961b.a() - this.f22964e;
        f1 f1Var = this.f22965f;
        if (f1Var.f20698a == 1.0f) {
            a10 = com.google.android.exoplayer2.h.d(a11);
        } else {
            a10 = f1Var.a(a11);
        }
        return j10 + a10;
    }
}
