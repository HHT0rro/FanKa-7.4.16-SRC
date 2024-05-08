package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzii extends t3 {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f25769b = Logger.getLogger(zzii.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f25770c = p7.m();

    /* renamed from: a, reason: collision with root package name */
    public i4 f25771a;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a extends zzii {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f25772d;

        /* renamed from: e, reason: collision with root package name */
        public final int f25773e;

        /* renamed from: f, reason: collision with root package name */
        public final int f25774f;

        /* renamed from: g, reason: collision with root package name */
        public int f25775g;

        public a(byte[] bArr, int i10, int i11) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            if ((i11 | 0 | (bArr.length - i11)) >= 0) {
                this.f25772d = bArr;
                this.f25773e = 0;
                this.f25775g = 0;
                this.f25774f = i11;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
        }

        public final void F0(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy((Object) bArr, i10, (Object) this.f25772d, this.f25775g, i11);
                this.f25775g += i11;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), Integer.valueOf(i11)), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void O(int i10) throws IOException {
            if (!zzii.f25770c || o3.b() || b() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f25772d;
                        int i11 = this.f25775g;
                        this.f25775g = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), 1), e2);
                    }
                }
                byte[] bArr2 = this.f25772d;
                int i12 = this.f25775g;
                this.f25775g = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                byte[] bArr3 = this.f25772d;
                int i13 = this.f25775g;
                this.f25775g = i13 + 1;
                p7.l(bArr3, i13, (byte) i10);
                return;
            }
            byte[] bArr4 = this.f25772d;
            int i14 = this.f25775g;
            this.f25775g = i14 + 1;
            p7.l(bArr4, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                byte[] bArr5 = this.f25772d;
                int i16 = this.f25775g;
                this.f25775g = i16 + 1;
                p7.l(bArr5, i16, (byte) i15);
                return;
            }
            byte[] bArr6 = this.f25772d;
            int i17 = this.f25775g;
            this.f25775g = i17 + 1;
            p7.l(bArr6, i17, (byte) (i15 | 128));
            int i18 = i15 >>> 7;
            if ((i18 & (-128)) == 0) {
                byte[] bArr7 = this.f25772d;
                int i19 = this.f25775g;
                this.f25775g = i19 + 1;
                p7.l(bArr7, i19, (byte) i18);
                return;
            }
            byte[] bArr8 = this.f25772d;
            int i20 = this.f25775g;
            this.f25775g = i20 + 1;
            p7.l(bArr8, i20, (byte) (i18 | 128));
            int i21 = i18 >>> 7;
            if ((i21 & (-128)) == 0) {
                byte[] bArr9 = this.f25772d;
                int i22 = this.f25775g;
                this.f25775g = i22 + 1;
                p7.l(bArr9, i22, (byte) i21);
                return;
            }
            byte[] bArr10 = this.f25772d;
            int i23 = this.f25775g;
            this.f25775g = i23 + 1;
            p7.l(bArr10, i23, (byte) (i21 | 128));
            byte[] bArr11 = this.f25772d;
            int i24 = this.f25775g;
            this.f25775g = i24 + 1;
            p7.l(bArr11, i24, (byte) (i21 >>> 7));
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void P(int i10, int i11) throws IOException {
            m(i10, 0);
            j(i11);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void R(int i10, zzht zzhtVar) throws IOException {
            m(1, 3);
            X(2, i10);
            o(3, zzhtVar);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void X(int i10, int i11) throws IOException {
            m(i10, 0);
            O(i11);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void Y(int i10, long j10) throws IOException {
            m(i10, 1);
            Z(j10);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void Z(long j10) throws IOException {
            try {
                byte[] bArr = this.f25772d;
                int i10 = this.f25775g;
                int i11 = i10 + 1;
                this.f25775g = i11;
                bArr[i10] = (byte) j10;
                int i12 = i11 + 1;
                this.f25775g = i12;
                bArr[i11] = (byte) (j10 >> 8);
                int i13 = i12 + 1;
                this.f25775g = i13;
                bArr[i12] = (byte) (j10 >> 16);
                int i14 = i13 + 1;
                this.f25775g = i14;
                bArr[i13] = (byte) (j10 >> 24);
                int i15 = i14 + 1;
                this.f25775g = i15;
                bArr[i14] = (byte) (j10 >> 32);
                int i16 = i15 + 1;
                this.f25775g = i16;
                bArr[i15] = (byte) (j10 >> 40);
                int i17 = i16 + 1;
                this.f25775g = i17;
                bArr[i16] = (byte) (j10 >> 48);
                this.f25775g = i17 + 1;
                bArr[i17] = (byte) (j10 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.t3
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            F0(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final int b() {
            return this.f25774f - this.f25775g;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void e0(int i10) throws IOException {
            try {
                byte[] bArr = this.f25772d;
                int i11 = this.f25775g;
                int i12 = i11 + 1;
                this.f25775g = i12;
                bArr[i11] = (byte) i10;
                int i13 = i12 + 1;
                this.f25775g = i13;
                bArr[i12] = (byte) (i10 >> 8);
                int i14 = i13 + 1;
                this.f25775g = i14;
                bArr[i13] = (byte) (i10 >> 16);
                this.f25775g = i14 + 1;
                bArr[i14] = (byte) (i10 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void g(byte b4) throws IOException {
            try {
                byte[] bArr = this.f25772d;
                int i10 = this.f25775g;
                this.f25775g = i10 + 1;
                bArr[i10] = b4;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void j(int i10) throws IOException {
            if (i10 >= 0) {
                O(i10);
            } else {
                t(i10);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void j0(int i10, int i11) throws IOException {
            m(i10, 5);
            e0(i11);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void m(int i10, int i11) throws IOException {
            O((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void n(int i10, long j10) throws IOException {
            m(i10, 0);
            t(j10);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void o(int i10, zzht zzhtVar) throws IOException {
            m(i10, 2);
            u(zzhtVar);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void p(int i10, c6 c6Var) throws IOException {
            m(1, 3);
            X(2, i10);
            m(3, 2);
            v(c6Var);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void q(int i10, c6 c6Var, t6 t6Var) throws IOException {
            m(i10, 2);
            l3 l3Var = (l3) c6Var;
            int e2 = l3Var.e();
            if (e2 == -1) {
                e2 = t6Var.zzb(l3Var);
                l3Var.c(e2);
            }
            O(e2);
            t6Var.f(c6Var, this.f25771a);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void r(int i10, String str) throws IOException {
            m(i10, 2);
            w(str);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void s(int i10, boolean z10) throws IOException {
            m(i10, 0);
            g(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void t(long j10) throws IOException {
            if (zzii.f25770c && b() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f25772d;
                    int i10 = this.f25775g;
                    this.f25775g = i10 + 1;
                    p7.l(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f25772d;
                int i11 = this.f25775g;
                this.f25775g = i11 + 1;
                p7.l(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f25772d;
                    int i12 = this.f25775g;
                    this.f25775g = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f25775g), Integer.valueOf(this.f25774f), 1), e2);
                }
            }
            byte[] bArr4 = this.f25772d;
            int i13 = this.f25775g;
            this.f25775g = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void u(zzht zzhtVar) throws IOException {
            O(zzhtVar.zza());
            zzhtVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void v(c6 c6Var) throws IOException {
            O(c6Var.zzm());
            c6Var.a(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void w(String str) throws IOException {
            int i10 = this.f25775g;
            try {
                int o02 = zzii.o0(str.length() * 3);
                int o03 = zzii.o0(str.length());
                if (o03 == o02) {
                    int i11 = i10 + o03;
                    this.f25775g = i11;
                    int e2 = s7.e(str, this.f25772d, i11, b());
                    this.f25775g = i10;
                    O((e2 - i10) - o03);
                    this.f25775g = e2;
                    return;
                }
                O(s7.d(str));
                this.f25775g = s7.e(str, this.f25772d, this.f25775g, b());
            } catch (zzmg e10) {
                this.f25775g = i10;
                x(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzb(e11);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzii.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public zzii() {
    }

    public static int A(float f10) {
        return 4;
    }

    public static int A0(int i10, int i11) {
        return o0(i10 << 3) + 4;
    }

    public static int B(int i10, double d10) {
        return o0(i10 << 3) + 8;
    }

    public static int B0(int i10) {
        return k0(i10);
    }

    public static int C(int i10, float f10) {
        return o0(i10 << 3) + 4;
    }

    public static int C0(int i10, int i11) {
        return o0(i10 << 3) + k0(i11);
    }

    public static int D(int i10, m5 m5Var) {
        return (o0(8) << 1) + p0(2, i10) + c(3, m5Var);
    }

    @Deprecated
    public static int D0(int i10) {
        return o0(i10);
    }

    public static int E(int i10, c6 c6Var) {
        return (o0(8) << 1) + p0(2, i10) + o0(24) + J(c6Var);
    }

    public static int E0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static int F(int i10, c6 c6Var, t6 t6Var) {
        return o0(i10 << 3) + e(c6Var, t6Var);
    }

    public static int G(int i10, String str) {
        return o0(i10 << 3) + K(str);
    }

    public static int H(int i10, boolean z10) {
        return o0(i10 << 3) + 1;
    }

    public static int I(zzht zzhtVar) {
        int zza = zzhtVar.zza();
        return o0(zza) + zza;
    }

    public static int J(c6 c6Var) {
        int zzm = c6Var.zzm();
        return o0(zzm) + zzm;
    }

    public static int K(String str) {
        int length;
        try {
            length = s7.d(str);
        } catch (zzmg unused) {
            length = str.getBytes(b5.f25436a).length;
        }
        return o0(length) + length;
    }

    public static int L(boolean z10) {
        return 1;
    }

    public static int M(byte[] bArr) {
        int length = bArr.length;
        return o0(length) + length;
    }

    public static int T(int i10, zzht zzhtVar) {
        int o02 = o0(i10 << 3);
        int zza = zzhtVar.zza();
        return o02 + o0(zza) + zza;
    }

    @Deprecated
    public static int U(int i10, c6 c6Var, t6 t6Var) {
        int o02 = o0(i10 << 3) << 1;
        l3 l3Var = (l3) c6Var;
        int e2 = l3Var.e();
        if (e2 == -1) {
            e2 = t6Var.zzb(l3Var);
            l3Var.c(e2);
        }
        return o02 + e2;
    }

    @Deprecated
    public static int V(c6 c6Var) {
        return c6Var.zzm();
    }

    public static int b0(int i10, long j10) {
        return o0(i10 << 3) + i0(j10);
    }

    public static int c(int i10, m5 m5Var) {
        int o02 = o0(i10 << 3);
        int b4 = m5Var.b();
        return o02 + o0(b4) + b4;
    }

    public static int c0(int i10, zzht zzhtVar) {
        return (o0(8) << 1) + p0(2, i10) + T(3, zzhtVar);
    }

    public static int d(m5 m5Var) {
        int b4 = m5Var.b();
        return o0(b4) + b4;
    }

    public static int d0(long j10) {
        return i0(j10);
    }

    public static int e(c6 c6Var, t6 t6Var) {
        l3 l3Var = (l3) c6Var;
        int e2 = l3Var.e();
        if (e2 == -1) {
            e2 = t6Var.zzb(l3Var);
            l3Var.c(e2);
        }
        return o0(e2) + e2;
    }

    public static zzii f(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int g0(int i10) {
        return o0(i10 << 3);
    }

    public static int h0(int i10, long j10) {
        return o0(i10 << 3) + i0(j10);
    }

    public static int i0(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int k0(int i10) {
        if (i10 >= 0) {
            return o0(i10);
        }
        return 10;
    }

    public static int l0(int i10, int i11) {
        return o0(i10 << 3) + k0(i11);
    }

    public static int m0(int i10, long j10) {
        return o0(i10 << 3) + i0(y0(j10));
    }

    public static int n0(long j10) {
        return i0(y0(j10));
    }

    public static int o0(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int p0(int i10, int i11) {
        return o0(i10 << 3) + o0(i11);
    }

    public static int q0(int i10, long j10) {
        return o0(i10 << 3) + 8;
    }

    public static int r0(long j10) {
        return 8;
    }

    public static int s0(int i10) {
        return o0(E0(i10));
    }

    public static int t0(int i10, int i11) {
        return o0(i10 << 3) + o0(E0(i11));
    }

    public static int u0(int i10, long j10) {
        return o0(i10 << 3) + 8;
    }

    public static int v0(long j10) {
        return 8;
    }

    public static int w0(int i10) {
        return 4;
    }

    public static int x0(int i10, int i11) {
        return o0(i10 << 3) + 4;
    }

    public static long y0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int z(double d10) {
        return 8;
    }

    public static int z0(int i10) {
        return 4;
    }

    public final void N() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void O(int i10) throws IOException;

    public abstract void P(int i10, int i11) throws IOException;

    public final void Q(int i10, long j10) throws IOException {
        n(i10, y0(j10));
    }

    public abstract void R(int i10, zzht zzhtVar) throws IOException;

    public final void S(long j10) throws IOException {
        t(y0(j10));
    }

    public final void W(int i10) throws IOException {
        O(E0(i10));
    }

    public abstract void X(int i10, int i11) throws IOException;

    public abstract void Y(int i10, long j10) throws IOException;

    public abstract void Z(long j10) throws IOException;

    public abstract int b();

    public abstract void e0(int i10) throws IOException;

    public final void f0(int i10, int i11) throws IOException {
        X(i10, E0(i11));
    }

    public abstract void g(byte b4) throws IOException;

    public final void h(double d10) throws IOException {
        Z(Double.doubleToRawLongBits(d10));
    }

    public final void i(float f10) throws IOException {
        e0(Float.floatToRawIntBits(f10));
    }

    public abstract void j(int i10) throws IOException;

    public abstract void j0(int i10, int i11) throws IOException;

    public final void k(int i10, double d10) throws IOException {
        Y(i10, Double.doubleToRawLongBits(d10));
    }

    public final void l(int i10, float f10) throws IOException {
        j0(i10, Float.floatToRawIntBits(f10));
    }

    public abstract void m(int i10, int i11) throws IOException;

    public abstract void n(int i10, long j10) throws IOException;

    public abstract void o(int i10, zzht zzhtVar) throws IOException;

    public abstract void p(int i10, c6 c6Var) throws IOException;

    public abstract void q(int i10, c6 c6Var, t6 t6Var) throws IOException;

    public abstract void r(int i10, String str) throws IOException;

    public abstract void s(int i10, boolean z10) throws IOException;

    public abstract void t(long j10) throws IOException;

    public abstract void u(zzht zzhtVar) throws IOException;

    public abstract void v(c6 c6Var) throws IOException;

    public abstract void w(String str) throws IOException;

    public final void x(String str, zzmg zzmgVar) throws IOException {
        f25769b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzmgVar);
        byte[] bytes = str.getBytes(b5.f25436a);
        try {
            O(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzb e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzb(e10);
        }
    }

    public final void y(boolean z10) throws IOException {
        g(z10 ? (byte) 1 : (byte) 0);
    }
}
