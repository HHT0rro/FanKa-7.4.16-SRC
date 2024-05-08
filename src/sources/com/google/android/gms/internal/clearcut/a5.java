package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a5 extends y3<a5> implements Cloneable {
    public zzge$zzs A;
    public boolean B;

    /* renamed from: d, reason: collision with root package name */
    public long f23789d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f23790e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f23791f = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f23792g = "";

    /* renamed from: h, reason: collision with root package name */
    public int f23793h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String f23794i = "";

    /* renamed from: j, reason: collision with root package name */
    public int f23795j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23796k = false;

    /* renamed from: l, reason: collision with root package name */
    public b5[] f23797l = b5.i();

    /* renamed from: m, reason: collision with root package name */
    public byte[] f23798m;

    /* renamed from: n, reason: collision with root package name */
    public f4 f23799n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f23800o;

    /* renamed from: p, reason: collision with root package name */
    public String f23801p;

    /* renamed from: q, reason: collision with root package name */
    public String f23802q;

    /* renamed from: r, reason: collision with root package name */
    public x4 f23803r;

    /* renamed from: s, reason: collision with root package name */
    public String f23804s;

    /* renamed from: t, reason: collision with root package name */
    public long f23805t;

    /* renamed from: u, reason: collision with root package name */
    public y4 f23806u;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f23807v;

    /* renamed from: w, reason: collision with root package name */
    public String f23808w;

    /* renamed from: x, reason: collision with root package name */
    public int f23809x;

    /* renamed from: y, reason: collision with root package name */
    public int[] f23810y;

    /* renamed from: z, reason: collision with root package name */
    public long f23811z;

    public a5() {
        byte[] bArr = e4.f23880h;
        this.f23798m = bArr;
        this.f23799n = null;
        this.f23800o = bArr;
        this.f23801p = "";
        this.f23802q = "";
        this.f23803r = null;
        this.f23804s = "";
        this.f23805t = 180000L;
        this.f23806u = null;
        this.f23807v = bArr;
        this.f23808w = "";
        this.f23809x = 0;
        this.f23810y = e4.f23873a;
        this.f23811z = 0L;
        this.A = null;
        this.B = false;
        this.f24111c = null;
        this.f23837b = -1;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final void a(x3 x3Var) throws IOException {
        long j10 = this.f23789d;
        if (j10 != 0) {
            x3Var.u(1, j10);
        }
        String str = this.f23792g;
        if (str != null && !str.equals("")) {
            x3Var.c(2, this.f23792g);
        }
        b5[] b5VarArr = this.f23797l;
        int i10 = 0;
        if (b5VarArr != null && b5VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                b5[] b5VarArr2 = this.f23797l;
                if (i11 >= b5VarArr2.length) {
                    break;
                }
                b5 b5Var = b5VarArr2[i11];
                if (b5Var != null) {
                    x3Var.b(3, b5Var);
                }
                i11++;
            }
        }
        byte[] bArr = this.f23798m;
        byte[] bArr2 = e4.f23880h;
        if (!Arrays.equals(bArr, bArr2)) {
            x3Var.d(4, this.f23798m);
        }
        if (!Arrays.equals(this.f23800o, bArr2)) {
            x3Var.d(6, this.f23800o);
        }
        x4 x4Var = this.f23803r;
        if (x4Var != null) {
            x3Var.b(7, x4Var);
        }
        String str2 = this.f23801p;
        if (str2 != null && !str2.equals("")) {
            x3Var.c(8, this.f23801p);
        }
        f4 f4Var = this.f23799n;
        if (f4Var != null) {
            x3Var.o(9, f4Var);
        }
        int i12 = this.f23793h;
        if (i12 != 0) {
            x3Var.l(11, i12);
        }
        String str3 = this.f23802q;
        if (str3 != null && !str3.equals("")) {
            x3Var.c(13, this.f23802q);
        }
        String str4 = this.f23804s;
        if (str4 != null && !str4.equals("")) {
            x3Var.c(14, this.f23804s);
        }
        long j11 = this.f23805t;
        if (j11 != 180000) {
            x3Var.j(15, 0);
            x3Var.w(x3.v(j11));
        }
        y4 y4Var = this.f23806u;
        if (y4Var != null) {
            x3Var.b(16, y4Var);
        }
        long j12 = this.f23790e;
        if (j12 != 0) {
            x3Var.u(17, j12);
        }
        if (!Arrays.equals(this.f23807v, bArr2)) {
            x3Var.d(18, this.f23807v);
        }
        int[] iArr = this.f23810y;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.f23810y;
                if (i10 >= iArr2.length) {
                    break;
                }
                x3Var.l(20, iArr2[i10]);
                i10++;
            }
        }
        zzge$zzs zzge_zzs = this.A;
        if (zzge_zzs != null) {
            x3Var.o(23, zzge_zzs);
        }
        String str5 = this.f23808w;
        if (str5 != null && !str5.equals("")) {
            x3Var.c(24, this.f23808w);
        }
        boolean z10 = this.B;
        if (z10) {
            x3Var.k(25, z10);
        }
        String str6 = this.f23794i;
        if (str6 != null && !str6.equals("")) {
            x3Var.c(26, this.f23794i);
        }
        super.a(x3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final int e() {
        int[] iArr;
        int e2 = super.e();
        long j10 = this.f23789d;
        if (j10 != 0) {
            e2 += x3.m(1, j10);
        }
        String str = this.f23792g;
        if (str != null && !str.equals("")) {
            e2 += x3.h(2, this.f23792g);
        }
        b5[] b5VarArr = this.f23797l;
        int i10 = 0;
        if (b5VarArr != null && b5VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                b5[] b5VarArr2 = this.f23797l;
                if (i11 >= b5VarArr2.length) {
                    break;
                }
                b5 b5Var = b5VarArr2[i11];
                if (b5Var != null) {
                    e2 += x3.g(3, b5Var);
                }
                i11++;
            }
        }
        byte[] bArr = this.f23798m;
        byte[] bArr2 = e4.f23880h;
        if (!Arrays.equals(bArr, bArr2)) {
            e2 += x3.i(4, this.f23798m);
        }
        if (!Arrays.equals(this.f23800o, bArr2)) {
            e2 += x3.i(6, this.f23800o);
        }
        x4 x4Var = this.f23803r;
        if (x4Var != null) {
            e2 += x3.g(7, x4Var);
        }
        String str2 = this.f23801p;
        if (str2 != null && !str2.equals("")) {
            e2 += x3.h(8, this.f23801p);
        }
        f4 f4Var = this.f23799n;
        if (f4Var != null) {
            e2 += zzbn.O(9, f4Var);
        }
        int i12 = this.f23793h;
        if (i12 != 0) {
            e2 += x3.y(11) + x3.z(i12);
        }
        String str3 = this.f23802q;
        if (str3 != null && !str3.equals("")) {
            e2 += x3.h(13, this.f23802q);
        }
        String str4 = this.f23804s;
        if (str4 != null && !str4.equals("")) {
            e2 += x3.h(14, this.f23804s);
        }
        long j11 = this.f23805t;
        if (j11 != 180000) {
            e2 += x3.y(15) + x3.x(x3.v(j11));
        }
        y4 y4Var = this.f23806u;
        if (y4Var != null) {
            e2 += x3.g(16, y4Var);
        }
        long j12 = this.f23790e;
        if (j12 != 0) {
            e2 += x3.m(17, j12);
        }
        if (!Arrays.equals(this.f23807v, bArr2)) {
            e2 += x3.i(18, this.f23807v);
        }
        int[] iArr2 = this.f23810y;
        if (iArr2 != null && iArr2.length > 0) {
            int i13 = 0;
            while (true) {
                iArr = this.f23810y;
                if (i10 >= iArr.length) {
                    break;
                }
                i13 += x3.z(iArr[i10]);
                i10++;
            }
            e2 = e2 + i13 + (iArr.length * 2);
        }
        zzge$zzs zzge_zzs = this.A;
        if (zzge_zzs != null) {
            e2 += zzbn.O(23, zzge_zzs);
        }
        String str5 = this.f23808w;
        if (str5 != null && !str5.equals("")) {
            e2 += x3.h(24, this.f23808w);
        }
        if (this.B) {
            e2 += x3.y(25) + 1;
        }
        String str6 = this.f23794i;
        return (str6 == null || str6.equals("")) ? e2 : e2 + x3.h(26, this.f23794i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a5)) {
            return false;
        }
        a5 a5Var = (a5) obj;
        if (this.f23789d != a5Var.f23789d || this.f23790e != a5Var.f23790e) {
            return false;
        }
        String str = this.f23792g;
        if (str == null) {
            if (a5Var.f23792g != null) {
                return false;
            }
        } else if (!str.equals(a5Var.f23792g)) {
            return false;
        }
        if (this.f23793h != a5Var.f23793h) {
            return false;
        }
        String str2 = this.f23794i;
        if (str2 == null) {
            if (a5Var.f23794i != null) {
                return false;
            }
        } else if (!str2.equals(a5Var.f23794i)) {
            return false;
        }
        if (!b4.c(this.f23797l, a5Var.f23797l) || !Arrays.equals(this.f23798m, a5Var.f23798m)) {
            return false;
        }
        f4 f4Var = this.f23799n;
        if (f4Var == null) {
            if (a5Var.f23799n != null) {
                return false;
            }
        } else if (!f4Var.equals(a5Var.f23799n)) {
            return false;
        }
        if (!Arrays.equals(this.f23800o, a5Var.f23800o)) {
            return false;
        }
        String str3 = this.f23801p;
        if (str3 == null) {
            if (a5Var.f23801p != null) {
                return false;
            }
        } else if (!str3.equals(a5Var.f23801p)) {
            return false;
        }
        String str4 = this.f23802q;
        if (str4 == null) {
            if (a5Var.f23802q != null) {
                return false;
            }
        } else if (!str4.equals(a5Var.f23802q)) {
            return false;
        }
        x4 x4Var = this.f23803r;
        if (x4Var == null) {
            if (a5Var.f23803r != null) {
                return false;
            }
        } else if (!x4Var.equals(a5Var.f23803r)) {
            return false;
        }
        String str5 = this.f23804s;
        if (str5 == null) {
            if (a5Var.f23804s != null) {
                return false;
            }
        } else if (!str5.equals(a5Var.f23804s)) {
            return false;
        }
        if (this.f23805t != a5Var.f23805t) {
            return false;
        }
        y4 y4Var = this.f23806u;
        if (y4Var == null) {
            if (a5Var.f23806u != null) {
                return false;
            }
        } else if (!y4Var.equals(a5Var.f23806u)) {
            return false;
        }
        if (!Arrays.equals(this.f23807v, a5Var.f23807v)) {
            return false;
        }
        String str6 = this.f23808w;
        if (str6 == null) {
            if (a5Var.f23808w != null) {
                return false;
            }
        } else if (!str6.equals(a5Var.f23808w)) {
            return false;
        }
        if (!b4.a(this.f23810y, a5Var.f23810y)) {
            return false;
        }
        zzge$zzs zzge_zzs = this.A;
        if (zzge_zzs == null) {
            if (a5Var.A != null) {
                return false;
            }
        } else if (!zzge_zzs.equals(a5Var.A)) {
            return false;
        }
        if (this.B != a5Var.B) {
            return false;
        }
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            return this.f24111c.equals(a5Var.f24111c);
        }
        z3 z3Var2 = a5Var.f24111c;
        return z3Var2 == null || z3Var2.a();
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: g */
    public final /* synthetic */ c4 clone() throws CloneNotSupportedException {
        return (a5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.y3
    /* renamed from: h */
    public final /* synthetic */ a5 clone() throws CloneNotSupportedException {
        return (a5) clone();
    }

    public final int hashCode() {
        int hashCode = (a5.class.getName().hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31;
        long j10 = this.f23789d;
        int i10 = (hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f23790e;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31 * 31;
        String str = this.f23792g;
        int i12 = 0;
        int hashCode2 = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f23793h) * 31;
        String str2 = this.f23794i;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31 * 31;
        int i13 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        int f10 = ((((hashCode3 + MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) * 31) + b4.f(this.f23797l)) * 31) + Arrays.hashCode(this.f23798m);
        f4 f4Var = this.f23799n;
        int hashCode4 = ((((f10 * 31) + (f4Var == null ? 0 : f4Var.hashCode())) * 31) + Arrays.hashCode(this.f23800o)) * 31;
        String str3 = this.f23801p;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f23802q;
        int hashCode6 = hashCode5 + (str4 == null ? 0 : str4.hashCode());
        x4 x4Var = this.f23803r;
        int hashCode7 = ((hashCode6 * 31) + (x4Var == null ? 0 : x4Var.hashCode())) * 31;
        String str5 = this.f23804s;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        long j12 = this.f23805t;
        y4 y4Var = this.f23806u;
        int hashCode9 = (((((hashCode8 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (y4Var == null ? 0 : y4Var.hashCode())) * 31) + Arrays.hashCode(this.f23807v)) * 31;
        String str6 = this.f23808w;
        int hashCode10 = (((hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31 * 31) + b4.d(this.f23810y)) * 31;
        zzge$zzs zzge_zzs = this.A;
        int hashCode11 = ((hashCode10 * 31) + (zzge_zzs == null ? 0 : zzge_zzs.hashCode())) * 31;
        if (this.B) {
            i13 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        }
        int i14 = (hashCode11 + i13) * 31;
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            i12 = this.f24111c.hashCode();
        }
        return i14 + i12;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final a5 clone() {
        try {
            a5 a5Var = (a5) super.clone();
            b5[] b5VarArr = this.f23797l;
            if (b5VarArr != null && b5VarArr.length > 0) {
                a5Var.f23797l = new b5[b5VarArr.length];
                int i10 = 0;
                while (true) {
                    b5[] b5VarArr2 = this.f23797l;
                    if (i10 >= b5VarArr2.length) {
                        break;
                    }
                    if (b5VarArr2[i10] != null) {
                        a5Var.f23797l[i10] = (b5) b5VarArr2[i10].clone();
                    }
                    i10++;
                }
            }
            f4 f4Var = this.f23799n;
            if (f4Var != null) {
                a5Var.f23799n = f4Var;
            }
            x4 x4Var = this.f23803r;
            if (x4Var != null) {
                a5Var.f23803r = (x4) x4Var.clone();
            }
            y4 y4Var = this.f23806u;
            if (y4Var != null) {
                a5Var.f23806u = (y4) y4Var.clone();
            }
            int[] iArr = this.f23810y;
            if (iArr != null && iArr.length > 0) {
                a5Var.f23810y = (int[]) iArr.clone();
            }
            zzge$zzs zzge_zzs = this.A;
            if (zzge_zzs != null) {
                a5Var.A = zzge_zzs;
            }
            return a5Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
