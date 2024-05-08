package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public int f23851a;

    /* renamed from: b, reason: collision with root package name */
    public int f23852b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23853c;

    public e0() {
        this.f23851a = 100;
        this.f23852b = Integer.MAX_VALUE;
        this.f23853c = false;
    }

    public static long a(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static e0 b(byte[] bArr, int i10, int i11, boolean z10) {
        g0 g0Var = new g0(bArr, 0, i11, false);
        try {
            g0Var.d(i11);
            return g0Var;
        } catch (zzco e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int e(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract int c();

    public abstract int d(int i10) throws zzco;
}
