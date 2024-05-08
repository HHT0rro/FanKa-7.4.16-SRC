package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x4 extends y3<x4> implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public String[] f24101d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f24102e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f24103f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f24104g;

    /* renamed from: h, reason: collision with root package name */
    public long[] f24105h;

    public x4() {
        String[] strArr = e4.f23878f;
        this.f24101d = strArr;
        this.f24102e = strArr;
        this.f24103f = e4.f23873a;
        long[] jArr = e4.f23874b;
        this.f24104g = jArr;
        this.f24105h = jArr;
        this.f24111c = null;
        this.f23837b = -1;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final void a(x3 x3Var) throws IOException {
        String[] strArr = this.f24101d;
        int i10 = 0;
        if (strArr != null && strArr.length > 0) {
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.f24101d;
                if (i11 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i11];
                if (str != null) {
                    x3Var.c(1, str);
                }
                i11++;
            }
        }
        String[] strArr3 = this.f24102e;
        if (strArr3 != null && strArr3.length > 0) {
            int i12 = 0;
            while (true) {
                String[] strArr4 = this.f24102e;
                if (i12 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i12];
                if (str2 != null) {
                    x3Var.c(2, str2);
                }
                i12++;
            }
        }
        int[] iArr = this.f24103f;
        if (iArr != null && iArr.length > 0) {
            int i13 = 0;
            while (true) {
                int[] iArr2 = this.f24103f;
                if (i13 >= iArr2.length) {
                    break;
                }
                x3Var.l(3, iArr2[i13]);
                i13++;
            }
        }
        long[] jArr = this.f24104g;
        if (jArr != null && jArr.length > 0) {
            int i14 = 0;
            while (true) {
                long[] jArr2 = this.f24104g;
                if (i14 >= jArr2.length) {
                    break;
                }
                x3Var.u(4, jArr2[i14]);
                i14++;
            }
        }
        long[] jArr3 = this.f24105h;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.f24105h;
                if (i10 >= jArr4.length) {
                    break;
                }
                x3Var.u(5, jArr4[i10]);
                i10++;
            }
        }
        super.a(x3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final int e() {
        long[] jArr;
        int[] iArr;
        int e2 = super.e();
        String[] strArr = this.f24101d;
        int i10 = 0;
        if (strArr != null && strArr.length > 0) {
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                String[] strArr2 = this.f24101d;
                if (i11 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i11];
                if (str != null) {
                    i13++;
                    i12 += x3.r(str);
                }
                i11++;
            }
            e2 = e2 + i12 + (i13 * 1);
        }
        String[] strArr3 = this.f24102e;
        if (strArr3 != null && strArr3.length > 0) {
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                String[] strArr4 = this.f24102e;
                if (i14 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i14];
                if (str2 != null) {
                    i16++;
                    i15 += x3.r(str2);
                }
                i14++;
            }
            e2 = e2 + i15 + (i16 * 1);
        }
        int[] iArr2 = this.f24103f;
        if (iArr2 != null && iArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr = this.f24103f;
                if (i17 >= iArr.length) {
                    break;
                }
                i18 += x3.z(iArr[i17]);
                i17++;
            }
            e2 = e2 + i18 + (iArr.length * 1);
        }
        long[] jArr2 = this.f24104g;
        if (jArr2 != null && jArr2.length > 0) {
            int i19 = 0;
            int i20 = 0;
            while (true) {
                jArr = this.f24104g;
                if (i19 >= jArr.length) {
                    break;
                }
                i20 += x3.x(jArr[i19]);
                i19++;
            }
            e2 = e2 + i20 + (jArr.length * 1);
        }
        long[] jArr3 = this.f24105h;
        if (jArr3 == null || jArr3.length <= 0) {
            return e2;
        }
        int i21 = 0;
        while (true) {
            long[] jArr4 = this.f24105h;
            if (i10 >= jArr4.length) {
                return e2 + i21 + (jArr4.length * 1);
            }
            i21 += x3.x(jArr4[i10]);
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        if (!b4.c(this.f24101d, x4Var.f24101d) || !b4.c(this.f24102e, x4Var.f24102e) || !b4.a(this.f24103f, x4Var.f24103f) || !b4.b(this.f24104g, x4Var.f24104g) || !b4.b(this.f24105h, x4Var.f24105h)) {
            return false;
        }
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            return this.f24111c.equals(x4Var.f24111c);
        }
        z3 z3Var2 = x4Var.f24111c;
        return z3Var2 == null || z3Var2.a();
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: g */
    public final /* synthetic */ c4 clone() throws CloneNotSupportedException {
        return (x4) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.y3
    /* renamed from: h */
    public final /* synthetic */ x4 clone() throws CloneNotSupportedException {
        return (x4) clone();
    }

    public final int hashCode() {
        int hashCode = (((((((((((x4.class.getName().hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31) + b4.f(this.f24101d)) * 31) + b4.f(this.f24102e)) * 31) + b4.d(this.f24103f)) * 31) + b4.e(this.f24104g)) * 31) + b4.e(this.f24105h)) * 31;
        z3 z3Var = this.f24111c;
        return hashCode + ((z3Var == null || z3Var.a()) ? 0 : this.f24111c.hashCode());
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final x4 clone() {
        try {
            x4 x4Var = (x4) super.clone();
            String[] strArr = this.f24101d;
            if (strArr != null && strArr.length > 0) {
                x4Var.f24101d = (String[]) strArr.clone();
            }
            String[] strArr2 = this.f24102e;
            if (strArr2 != null && strArr2.length > 0) {
                x4Var.f24102e = (String[]) strArr2.clone();
            }
            int[] iArr = this.f24103f;
            if (iArr != null && iArr.length > 0) {
                x4Var.f24103f = (int[]) iArr.clone();
            }
            long[] jArr = this.f24104g;
            if (jArr != null && jArr.length > 0) {
                x4Var.f24104g = (long[]) jArr.clone();
            }
            long[] jArr2 = this.f24105h;
            if (jArr2 != null && jArr2.length > 0) {
                x4Var.f24105h = (long[]) jArr2.clone();
            }
            return x4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
