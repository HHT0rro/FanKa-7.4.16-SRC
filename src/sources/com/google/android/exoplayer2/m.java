package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;

/* compiled from: DefaultMediaClock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m implements com.google.android.exoplayer2.util.o {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f20762b;

    /* renamed from: c, reason: collision with root package name */
    public final a f20763c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public l1 f20764d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.util.o f20765e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20766f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20767g;

    /* compiled from: DefaultMediaClock.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void onPlaybackParametersChanged(f1 f1Var);
    }

    public m(a aVar, Clock clock) {
        this.f20763c = aVar;
        this.f20762b = new com.google.android.exoplayer2.util.c0(clock);
    }

    public void a(l1 l1Var) {
        if (l1Var == this.f20764d) {
            this.f20765e = null;
            this.f20764d = null;
            this.f20766f = true;
        }
    }

    public void b(l1 l1Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.o oVar;
        com.google.android.exoplayer2.util.o o10 = l1Var.o();
        if (o10 == null || o10 == (oVar = this.f20765e)) {
            return;
        }
        if (oVar == null) {
            this.f20765e = o10;
            this.f20764d = l1Var;
            o10.c(this.f20762b.d());
            return;
        }
        throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
    }

    @Override // com.google.android.exoplayer2.util.o
    public void c(f1 f1Var) {
        com.google.android.exoplayer2.util.o oVar = this.f20765e;
        if (oVar != null) {
            oVar.c(f1Var);
            f1Var = this.f20765e.d();
        }
        this.f20762b.c(f1Var);
    }

    @Override // com.google.android.exoplayer2.util.o
    public f1 d() {
        com.google.android.exoplayer2.util.o oVar = this.f20765e;
        if (oVar != null) {
            return oVar.d();
        }
        return this.f20762b.d();
    }

    public void e(long j10) {
        this.f20762b.a(j10);
    }

    public final boolean f(boolean z10) {
        l1 l1Var = this.f20764d;
        return l1Var == null || l1Var.b() || (!this.f20764d.isReady() && (z10 || this.f20764d.h()));
    }

    public void g() {
        this.f20767g = true;
        this.f20762b.b();
    }

    public void h() {
        this.f20767g = false;
        this.f20762b.e();
    }

    public long i(boolean z10) {
        j(z10);
        return t();
    }

    public final void j(boolean z10) {
        if (f(z10)) {
            this.f20766f = true;
            if (this.f20767g) {
                this.f20762b.b();
                return;
            }
            return;
        }
        com.google.android.exoplayer2.util.o oVar = (com.google.android.exoplayer2.util.o) com.google.android.exoplayer2.util.a.e(this.f20765e);
        long t2 = oVar.t();
        if (this.f20766f) {
            if (t2 < this.f20762b.t()) {
                this.f20762b.e();
                return;
            } else {
                this.f20766f = false;
                if (this.f20767g) {
                    this.f20762b.b();
                }
            }
        }
        this.f20762b.a(t2);
        f1 d10 = oVar.d();
        if (d10.equals(this.f20762b.d())) {
            return;
        }
        this.f20762b.c(d10);
        this.f20763c.onPlaybackParametersChanged(d10);
    }

    @Override // com.google.android.exoplayer2.util.o
    public long t() {
        if (this.f20766f) {
            return this.f20762b.t();
        }
        return ((com.google.android.exoplayer2.util.o) com.google.android.exoplayer2.util.a.e(this.f20765e)).t();
    }
}
