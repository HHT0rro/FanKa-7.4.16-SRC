package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.gms.internal.clearcut.x0;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j3 {

    /* renamed from: f, reason: collision with root package name */
    public static final j3 f23924f = new j3(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f23925a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f23926b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f23927c;

    /* renamed from: d, reason: collision with root package name */
    public int f23928d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23929e;

    public j3() {
        this(0, new int[8], new Object[8], true);
    }

    public j3(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f23928d = -1;
        this.f23925a = i10;
        this.f23926b = iArr;
        this.f23927c = objArr;
        this.f23929e = z10;
    }

    public static j3 a(j3 j3Var, j3 j3Var2) {
        int i10 = j3Var.f23925a + j3Var2.f23925a;
        int[] copyOf = Arrays.copyOf(j3Var.f23926b, i10);
        System.arraycopy((Object) j3Var2.f23926b, 0, (Object) copyOf, j3Var.f23925a, j3Var2.f23925a);
        Object[] copyOf2 = Arrays.copyOf(j3Var.f23927c, i10);
        System.arraycopy(j3Var2.f23927c, 0, copyOf2, j3Var.f23925a, j3Var2.f23925a);
        return new j3(i10, copyOf, copyOf2, true);
    }

    public static void f(int i10, Object obj, w3 w3Var) throws IOException {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            w3Var.F(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 1) {
            w3Var.e(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 2) {
            w3Var.M(i11, (zzbb) obj);
            return;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new RuntimeException(zzco.zzbn());
            }
            w3Var.m(i11, ((Integer) obj).intValue());
        } else if (w3Var.P() == x0.e.f24092l) {
            w3Var.H(i11);
            ((j3) obj).g(w3Var);
            w3Var.L(i11);
        } else {
            w3Var.L(i11);
            ((j3) obj).g(w3Var);
            w3Var.H(i11);
        }
    }

    public static j3 h() {
        return f23924f;
    }

    public static j3 i() {
        return new j3();
    }

    public final void b(w3 w3Var) throws IOException {
        if (w3Var.P() == x0.e.f24093m) {
            for (int i10 = this.f23925a - 1; i10 >= 0; i10--) {
                w3Var.f(this.f23926b[i10] >>> 3, this.f23927c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f23925a; i11++) {
            w3Var.f(this.f23926b[i11] >>> 3, this.f23927c[i11]);
        }
    }

    public final void c(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f23925a; i11++) {
            d2.c(sb2, i10, String.valueOf(this.f23926b[i11] >>> 3), this.f23927c[i11]);
        }
    }

    public final int d() {
        int d02;
        int i10 = this.f23928d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f23925a; i12++) {
            int i13 = this.f23926b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 == 0) {
                d02 = zzbn.d0(i14, ((Long) this.f23927c[i12]).longValue());
            } else if (i15 == 1) {
                d02 = zzbn.k0(i14, ((Long) this.f23927c[i12]).longValue());
            } else if (i15 == 2) {
                d02 = zzbn.N(i14, (zzbb) this.f23927c[i12]);
            } else if (i15 == 3) {
                d02 = (zzbn.B0(i14) << 1) + ((j3) this.f23927c[i12]).d();
            } else {
                if (i15 != 5) {
                    throw new IllegalStateException(zzco.zzbn());
                }
                d02 = zzbn.t0(i14, ((Integer) this.f23927c[i12]).intValue());
            }
            i11 += d02;
        }
        this.f23928d = i11;
        return i11;
    }

    public final void e(int i10, Object obj) {
        if (!this.f23929e) {
            throw new UnsupportedOperationException();
        }
        int i11 = this.f23925a;
        int[] iArr = this.f23926b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f23926b = Arrays.copyOf(iArr, i12);
            this.f23927c = Arrays.copyOf(this.f23927c, i12);
        }
        int[] iArr2 = this.f23926b;
        int i13 = this.f23925a;
        iArr2[i13] = i10;
        this.f23927c[i13] = obj;
        this.f23925a = i13 + 1;
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        int i10 = this.f23925a;
        if (i10 == j3Var.f23925a) {
            int[] iArr = this.f23926b;
            int[] iArr2 = j3Var.f23926b;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    z10 = true;
                    break;
                }
                if (iArr[i11] != iArr2[i11]) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                Object[] objArr = this.f23927c;
                Object[] objArr2 = j3Var.f23927c;
                int i12 = this.f23925a;
                int i13 = 0;
                while (true) {
                    if (i13 >= i12) {
                        z11 = true;
                        break;
                    }
                    if (!objArr[i13].equals(objArr2[i13])) {
                        z11 = false;
                        break;
                    }
                    i13++;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void g(w3 w3Var) throws IOException {
        if (this.f23925a == 0) {
            return;
        }
        if (w3Var.P() == x0.e.f24092l) {
            for (int i10 = 0; i10 < this.f23925a; i10++) {
                f(this.f23926b[i10], this.f23927c[i10], w3Var);
            }
            return;
        }
        for (int i11 = this.f23925a - 1; i11 >= 0; i11--) {
            f(this.f23926b[i11], this.f23927c[i11], w3Var);
        }
    }

    public final int hashCode() {
        int i10 = this.f23925a;
        int i11 = (i10 + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31;
        int[] iArr = this.f23926b;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 + i13) * 31;
        Object[] objArr = this.f23927c;
        int i16 = this.f23925a;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final int j() {
        int i10 = this.f23928d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f23925a; i12++) {
            i11 += zzbn.X(this.f23926b[i12] >>> 3, (zzbb) this.f23927c[i12]);
        }
        this.f23928d = i11;
        return i11;
    }

    public final void k() {
        this.f23929e = false;
    }
}
