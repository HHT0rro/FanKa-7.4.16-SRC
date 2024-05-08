package com.google.android.exoplayer2.source;

/* compiled from: CompositeSequenceableLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements m0 {

    /* renamed from: b, reason: collision with root package name */
    public final m0[] f21380b;

    public f(m0[] m0VarArr) {
        this.f21380b = m0VarArr;
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        boolean z10;
        boolean z11 = false;
        do {
            long f10 = f();
            if (f10 == Long.MIN_VALUE) {
                break;
            }
            z10 = false;
            for (m0 m0Var : this.f21380b) {
                long f11 = m0Var.f();
                boolean z12 = f11 != Long.MIN_VALUE && f11 <= j10;
                if (f11 == f10 || z12) {
                    z10 |= m0Var.b(j10);
                }
            }
            z11 |= z10;
        } while (z10);
        return z11;
    }

    @Override // com.google.android.exoplayer2.source.m0
    public final long d() {
        long j10 = Long.MAX_VALUE;
        for (m0 m0Var : this.f21380b) {
            long d10 = m0Var.d();
            if (d10 != Long.MIN_VALUE) {
                j10 = Math.min(j10, d10);
            }
        }
        if (j10 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.m0
    public final void e(long j10) {
        for (m0 m0Var : this.f21380b) {
            m0Var.e(j10);
        }
    }

    @Override // com.google.android.exoplayer2.source.m0
    public final long f() {
        long j10 = Long.MAX_VALUE;
        for (m0 m0Var : this.f21380b) {
            long f10 = m0Var.f();
            if (f10 != Long.MIN_VALUE) {
                j10 = Math.min(j10, f10);
            }
        }
        if (j10 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        for (m0 m0Var : this.f21380b) {
            if (m0Var.isLoading()) {
                return true;
            }
        }
        return false;
    }
}
