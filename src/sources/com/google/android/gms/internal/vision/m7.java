package com.google.android.gms.internal.vision;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m7 {

    /* renamed from: f, reason: collision with root package name */
    public static final m7 f25555f = new m7(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f25556a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f25557b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f25558c;

    /* renamed from: d, reason: collision with root package name */
    public int f25559d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25560e;

    public m7() {
        this(0, new int[8], new Object[8], true);
    }

    public static m7 a() {
        return f25555f;
    }

    public static m7 b(m7 m7Var, m7 m7Var2) {
        int i10 = m7Var.f25556a + m7Var2.f25556a;
        int[] copyOf = Arrays.copyOf(m7Var.f25557b, i10);
        System.arraycopy((Object) m7Var2.f25557b, 0, (Object) copyOf, m7Var.f25556a, m7Var2.f25556a);
        Object[] copyOf2 = Arrays.copyOf(m7Var.f25558c, i10);
        System.arraycopy(m7Var2.f25558c, 0, copyOf2, m7Var.f25556a, m7Var2.f25556a);
        return new m7(i10, copyOf, copyOf2, true);
    }

    public static void d(int i10, Object obj, z7 z7Var) throws IOException {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            z7Var.j(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 1) {
            z7Var.F(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 2) {
            z7Var.H(i11, (zzht) obj);
            return;
        }
        if (i12 != 3) {
            if (i12 == 5) {
                z7Var.n(i11, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzjk.zzf());
        }
        if (z7Var.zza() == y7.f25707a) {
            z7Var.zza(i11);
            ((m7) obj).h(z7Var);
            z7Var.a(i11);
        } else {
            z7Var.a(i11);
            ((m7) obj).h(z7Var);
            z7Var.zza(i11);
        }
    }

    public static m7 g() {
        return new m7();
    }

    public final void c(int i10, Object obj) {
        if (this.f25560e) {
            int i11 = this.f25556a;
            int[] iArr = this.f25557b;
            if (i11 == iArr.length) {
                int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
                this.f25557b = Arrays.copyOf(iArr, i12);
                this.f25558c = Arrays.copyOf(this.f25558c, i12);
            }
            int[] iArr2 = this.f25557b;
            int i13 = this.f25556a;
            iArr2[i13] = i10;
            this.f25558c[i13] = obj;
            this.f25556a = i13 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void e(z7 z7Var) throws IOException {
        if (z7Var.zza() == y7.f25708b) {
            for (int i10 = this.f25556a - 1; i10 >= 0; i10--) {
                z7Var.f(this.f25557b[i10] >>> 3, this.f25558c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f25556a; i11++) {
            z7Var.f(this.f25557b[i11] >>> 3, this.f25558c[i11]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m7)) {
            return false;
        }
        m7 m7Var = (m7) obj;
        int i10 = this.f25556a;
        if (i10 == m7Var.f25556a) {
            int[] iArr = this.f25557b;
            int[] iArr2 = m7Var.f25557b;
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
                Object[] objArr = this.f25558c;
                Object[] objArr2 = m7Var.f25558c;
                int i12 = this.f25556a;
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

    public final void f(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f25556a; i11++) {
            h6.d(sb2, i10, String.valueOf(this.f25557b[i11] >>> 3), this.f25558c[i11]);
        }
    }

    public final void h(z7 z7Var) throws IOException {
        if (this.f25556a == 0) {
            return;
        }
        if (z7Var.zza() == y7.f25707a) {
            for (int i10 = 0; i10 < this.f25556a; i10++) {
                d(this.f25557b[i10], this.f25558c[i10], z7Var);
            }
            return;
        }
        for (int i11 = this.f25556a - 1; i11 >= 0; i11--) {
            d(this.f25557b[i11], this.f25558c[i11], z7Var);
        }
    }

    public final int hashCode() {
        int i10 = this.f25556a;
        int i11 = (i10 + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31;
        int[] iArr = this.f25557b;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 + i13) * 31;
        Object[] objArr = this.f25558c;
        int i16 = this.f25556a;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final void i() {
        this.f25560e = false;
    }

    public final int j() {
        int i10 = this.f25559d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f25556a; i12++) {
            i11 += zzii.c0(this.f25557b[i12] >>> 3, (zzht) this.f25558c[i12]);
        }
        this.f25559d = i11;
        return i11;
    }

    public final int k() {
        int h02;
        int i10 = this.f25559d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f25556a; i12++) {
            int i13 = this.f25557b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 == 0) {
                h02 = zzii.h0(i14, ((Long) this.f25558c[i12]).longValue());
            } else if (i15 == 1) {
                h02 = zzii.q0(i14, ((Long) this.f25558c[i12]).longValue());
            } else if (i15 == 2) {
                h02 = zzii.T(i14, (zzht) this.f25558c[i12]);
            } else if (i15 == 3) {
                h02 = (zzii.g0(i14) << 1) + ((m7) this.f25558c[i12]).k();
            } else if (i15 == 5) {
                h02 = zzii.x0(i14, ((Integer) this.f25558c[i12]).intValue());
            } else {
                throw new IllegalStateException(zzjk.zzf());
            }
            i11 += h02;
        }
        this.f25559d = i11;
        return i11;
    }

    public m7(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f25559d = -1;
        this.f25556a = i10;
        this.f25557b = iArr;
        this.f25558c = objArr;
        this.f25560e = z10;
    }
}
