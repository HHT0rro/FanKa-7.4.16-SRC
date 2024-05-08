package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f4 {

    /* renamed from: a, reason: collision with root package name */
    public int f25462a;

    /* renamed from: b, reason: collision with root package name */
    public int f25463b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25464c;

    public f4() {
        this.f25462a = 100;
        this.f25463b = Integer.MAX_VALUE;
        this.f25464c = false;
    }

    public static long a(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static f4 b(byte[] bArr, int i10, int i11, boolean z10) {
        g4 g4Var = new g4(bArr, i11);
        try {
            g4Var.c(i11);
            return g4Var;
        } catch (zzjk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int d(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract int c(int i10) throws zzjk;

    public abstract int e();
}
