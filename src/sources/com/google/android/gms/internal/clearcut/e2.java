package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e2<T> implements r2<T> {

    /* renamed from: s, reason: collision with root package name */
    public static final Unsafe f23854s = p3.z();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f23855a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f23856b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23857c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23858d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23859e;

    /* renamed from: f, reason: collision with root package name */
    public final a2 f23860f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23861g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23862h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23863i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23864j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f23865k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f23866l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f23867m;

    /* renamed from: n, reason: collision with root package name */
    public final h2 f23868n;

    /* renamed from: o, reason: collision with root package name */
    public final k1 f23869o;

    /* renamed from: p, reason: collision with root package name */
    public final i3<?, ?> f23870p;

    /* renamed from: q, reason: collision with root package name */
    public final m0<?> f23871q;

    /* renamed from: r, reason: collision with root package name */
    public final v1 f23872r;

    public e2(int[] iArr, Object[] objArr, int i10, int i11, int i12, a2 a2Var, boolean z10, boolean z11, int[] iArr2, int[] iArr3, int[] iArr4, h2 h2Var, k1 k1Var, i3<?, ?> i3Var, m0<?> m0Var, v1 v1Var) {
        this.f23855a = iArr;
        this.f23856b = objArr;
        this.f23857c = i10;
        this.f23858d = i11;
        this.f23859e = i12;
        this.f23862h = a2Var instanceof x0;
        this.f23863i = z10;
        this.f23861g = m0Var != null && m0Var.g(a2Var);
        this.f23864j = false;
        this.f23865k = iArr2;
        this.f23866l = iArr3;
        this.f23867m = iArr4;
        this.f23868n = h2Var;
        this.f23869o = k1Var;
        this.f23870p = i3Var;
        this.f23871q = m0Var;
        this.f23860f = a2Var;
        this.f23872r = v1Var;
    }

    public static <E> List<E> K(Object obj, long j10) {
        return (List) p3.M(obj, j10);
    }

    public static <T> double L(T t2, long j10) {
        return ((Double) p3.M(t2, j10)).doubleValue();
    }

    public static <T> float M(T t2, long j10) {
        return ((Float) p3.M(t2, j10)).floatValue();
    }

    public static <T> int N(T t2, long j10) {
        return ((Integer) p3.M(t2, j10)).intValue();
    }

    public static <T> long O(T t2, long j10) {
        return ((Long) p3.M(t2, j10)).longValue();
    }

    public static <T> boolean P(T t2, long j10) {
        return ((Boolean) p3.M(t2, j10)).booleanValue();
    }

    public static j3 Q(Object obj) {
        x0 x0Var = (x0) obj;
        j3 j3Var = x0Var.zzjp;
        if (j3Var != j3.h()) {
            return j3Var;
        }
        j3 i10 = j3.i();
        x0Var.zzjp = i10;
        return i10;
    }

    public static int g(int i10, byte[] bArr, int i11, int i12, Object obj, w wVar) throws IOException {
        return v.c(i10, bArr, i11, i12, Q(obj), wVar);
    }

    public static int h(r2<?> r2Var, int i10, byte[] bArr, int i11, int i12, c1<?> c1Var, w wVar) throws IOException {
        int j10 = j(r2Var, bArr, i11, i12, wVar);
        while (true) {
            c1Var.add(wVar.f24066c);
            if (j10 >= i12) {
                break;
            }
            int e2 = v.e(bArr, j10, wVar);
            if (i10 != wVar.f24064a) {
                break;
            }
            j10 = j(r2Var, bArr, e2, i12, wVar);
        }
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int i(r2 r2Var, byte[] bArr, int i10, int i11, int i12, w wVar) throws IOException {
        e2 e2Var = (e2) r2Var;
        Object newInstance = e2Var.newInstance();
        int o10 = e2Var.o(newInstance, bArr, i10, i11, i12, wVar);
        e2Var.a(newInstance);
        wVar.f24066c = newInstance;
        return o10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int j(r2 r2Var, byte[] bArr, int i10, int i11, w wVar) throws IOException {
        int i12 = i10 + 1;
        int i13 = bArr[i10];
        if (i13 < 0) {
            i12 = v.d(i13, bArr, i12, wVar);
            i13 = wVar.f24064a;
        }
        int i14 = i12;
        if (i13 < 0 || i13 > i11 - i14) {
            throw zzco.zzbl();
        }
        Object newInstance = r2Var.newInstance();
        int i15 = i13 + i14;
        r2Var.c(newInstance, bArr, i14, i15, wVar);
        r2Var.a(newInstance);
        wVar.f24066c = newInstance;
        return i15;
    }

    public static <UT, UB> int k(i3<UT, UB> i3Var, T t2) {
        return i3Var.j(i3Var.k(t2));
    }

    public static <T> e2<T> p(Class<T> cls, y1 y1Var, h2 h2Var, k1 k1Var, i3<?, ?> i3Var, m0<?> m0Var, v1 v1Var) {
        int k10;
        int i10;
        int i11;
        int b4;
        int i12;
        int i13;
        if (!(y1Var instanceof o2)) {
            ((e3) y1Var).a();
            throw new NoSuchMethodError();
        }
        o2 o2Var = (o2) y1Var;
        boolean z10 = o2Var.a() == x0.e.f24090j;
        if (o2Var.d() == 0) {
            k10 = 0;
            i10 = 0;
            i11 = 0;
        } else {
            int f10 = o2Var.f();
            int g3 = o2Var.g();
            k10 = o2Var.k();
            i10 = f10;
            i11 = g3;
        }
        int[] iArr = new int[k10 << 2];
        Object[] objArr = new Object[k10 << 1];
        int[] iArr2 = o2Var.h() > 0 ? new int[o2Var.h()] : null;
        int[] iArr3 = o2Var.i() > 0 ? new int[o2Var.i()] : null;
        p2 e2 = o2Var.e();
        if (e2.a()) {
            int g10 = e2.g();
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                if (g10 >= o2Var.l() || i14 >= ((g10 - i10) << 2)) {
                    if (e2.k()) {
                        b4 = (int) p3.b(e2.l());
                        i13 = (int) p3.b(e2.m());
                        i12 = 0;
                    } else {
                        b4 = (int) p3.b(e2.n());
                        if (e2.o()) {
                            i13 = (int) p3.b(e2.p());
                            i12 = e2.q();
                        } else {
                            i12 = 0;
                            i13 = 0;
                        }
                    }
                    iArr[i14] = e2.g();
                    int i17 = i14 + 1;
                    iArr[i17] = (e2.s() ? 536870912 : 0) | (e2.r() ? 268435456 : 0) | (e2.h() << 20) | b4;
                    iArr[i14 + 2] = (i12 << 20) | i13;
                    if (e2.v() != null) {
                        int i18 = (i14 / 4) << 1;
                        objArr[i18] = e2.v();
                        if (e2.t() != null) {
                            objArr[i18 + 1] = e2.t();
                        } else if (e2.u() != null) {
                            objArr[i18 + 1] = e2.u();
                        }
                    } else if (e2.t() != null) {
                        objArr[((i14 / 4) << 1) + 1] = e2.t();
                    } else if (e2.u() != null) {
                        objArr[((i14 / 4) << 1) + 1] = e2.u();
                    }
                    int h10 = e2.h();
                    if (h10 == zzcb.zziw.ordinal()) {
                        iArr2[i15] = i14;
                        i15++;
                    } else if (h10 >= 18 && h10 <= 49) {
                        iArr3[i16] = iArr[i17] & 1048575;
                        i16++;
                    }
                    if (!e2.a()) {
                        break;
                    }
                    g10 = e2.g();
                } else {
                    for (int i19 = 0; i19 < 4; i19++) {
                        iArr[i14 + i19] = -1;
                    }
                }
                i14 += 4;
            }
        }
        return new e2<>(iArr, objArr, i10, i11, o2Var.l(), o2Var.c(), z10, false, o2Var.j(), iArr2, iArr3, h2Var, k1Var, i3Var, m0Var, v1Var);
    }

    public static void r(int i10, Object obj, w3 w3Var) throws IOException {
        if (obj instanceof String) {
            w3Var.s(i10, (String) obj);
        } else {
            w3Var.M(i10, (zzbb) obj);
        }
    }

    public static <UT, UB> void s(i3<UT, UB> i3Var, T t2, w3 w3Var) throws IOException {
        i3Var.c(i3Var.k(t2), w3Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean y(Object obj, int i10, r2 r2Var) {
        return r2Var.d(p3.M(obj, i10 & 1048575));
    }

    public final Object A(int i10) {
        return this.f23856b[(i10 / 4) << 1];
    }

    public final b1<?> B(int i10) {
        return (b1) this.f23856b[((i10 / 4) << 1) + 1];
    }

    public final int C(int i10) {
        return this.f23855a[i10 + 1];
    }

    public final int D(int i10) {
        return this.f23855a[i10 + 2];
    }

    public final int E(int i10) {
        int i11 = this.f23857c;
        if (i10 >= i11) {
            int i12 = this.f23859e;
            if (i10 < i12) {
                int i13 = (i10 - i11) << 2;
                if (this.f23855a[i13] == i10) {
                    return i13;
                }
                return -1;
            }
            if (i10 <= this.f23858d) {
                int i14 = i12 - i11;
                int length = (this.f23855a.length / 4) - 1;
                while (i14 <= length) {
                    int i15 = (length + i14) >>> 1;
                    int i16 = i15 << 2;
                    int i17 = this.f23855a[i16];
                    if (i10 == i17) {
                        return i16;
                    }
                    if (i10 < i17) {
                        length = i15 - 1;
                    } else {
                        i14 = i15 + 1;
                    }
                }
            }
        }
        return -1;
    }

    public final void F(T t2, int i10) {
        if (this.f23863i) {
            return;
        }
        int D = D(i10);
        long j10 = D & 1048575;
        p3.g(t2, j10, p3.H(t2, j10) | (1 << (D >>> 20)));
    }

    public final void G(T t2, int i10, int i11) {
        p3.g(t2, D(i11) & 1048575, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H(T r19, com.google.android.gms.internal.clearcut.w3 r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.H(java.lang.Object, com.google.android.gms.internal.clearcut.w3):void");
    }

    public final void I(T t2, T t10, int i10) {
        int C = C(i10);
        int i11 = this.f23855a[i10];
        long j10 = C & 1048575;
        if (w(t10, i11, i10)) {
            Object M = p3.M(t2, j10);
            Object M2 = p3.M(t10, j10);
            if (M != null && M2 != null) {
                p3.i(t2, j10, z0.d(M, M2));
                G(t2, i11, i10);
            } else if (M2 != null) {
                p3.i(t2, j10, M2);
                G(t2, i11, i10);
            }
        }
    }

    public final boolean J(T t2, T t10, int i10) {
        return v(t2, i10) == v(t10, i10);
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final void a(T t2) {
        int[] iArr = this.f23866l;
        if (iArr != null) {
            for (int i10 : iArr) {
                long C = C(i10) & 1048575;
                Object M = p3.M(t2, C);
                if (M != null) {
                    p3.i(t2, C, this.f23872r.i(M));
                }
            }
        }
        int[] iArr2 = this.f23867m;
        if (iArr2 != null) {
            for (int i11 : iArr2) {
                this.f23869o.a(t2, i11);
            }
        }
        this.f23870p.d(t2);
        if (this.f23861g) {
            this.f23871q.f(t2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0063. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:306:0x0520. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0976  */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(T r14, com.google.android.gms.internal.clearcut.w3 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.b(java.lang.Object, com.google.android.gms.internal.clearcut.w3):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0164, code lost:
    
        if (r0 == r15) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01a3, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0188, code lost:
    
        if (r0 == r15) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a1, code lost:
    
        if (r0 == r15) goto L83;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:48:0x0048. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.w r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.c(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.w):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.r2
    public final boolean d(T t2) {
        int i10;
        int i11;
        boolean z10;
        int[] iArr = this.f23865k;
        if (iArr != null && iArr.length != 0) {
            int i12 = -1;
            int length = iArr.length;
            int i13 = 0;
            for (int i14 = 0; i14 < length; i14 = i10 + 1) {
                int i15 = iArr[i14];
                int E = E(i15);
                int C = C(E);
                if (this.f23863i) {
                    i10 = i14;
                    i11 = 0;
                } else {
                    int i16 = this.f23855a[E + 2];
                    int i17 = i16 & 1048575;
                    i11 = 1 << (i16 >>> 20);
                    if (i17 != i12) {
                        i10 = i14;
                        i13 = f23854s.getInt(t2, i17);
                        i12 = i17;
                    } else {
                        i10 = i14;
                    }
                }
                if (((268435456 & C) != 0) && !x(t2, E, i13, i11)) {
                    return false;
                }
                int i18 = (267386880 & C) >>> 20;
                if (i18 != 9 && i18 != 17) {
                    if (i18 != 27) {
                        if (i18 == 60 || i18 == 68) {
                            if (w(t2, i15, E) && !y(t2, C, z(E))) {
                                return false;
                            }
                        } else if (i18 != 49) {
                            if (i18 == 50 && !this.f23872r.k(p3.M(t2, C & 1048575)).isEmpty()) {
                                this.f23872r.g(A(E));
                                throw null;
                            }
                        }
                    }
                    List list = (List) p3.M(t2, C & 1048575);
                    if (!list.isEmpty()) {
                        r2 z11 = z(E);
                        for (int i19 = 0; i19 < list.size(); i19++) {
                            if (!z11.d(list.get(i19))) {
                                z10 = false;
                                break;
                            }
                        }
                    }
                    z10 = true;
                    if (!z10) {
                        return false;
                    }
                } else if (x(t2, E, i13, i11) && !y(t2, C, z(E))) {
                    return false;
                }
            }
            if (this.f23861g && !this.f23871q.b(t2).d()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.r2
    public final void e(T t2, T t10) {
        Objects.requireNonNull(t10);
        for (int i10 = 0; i10 < this.f23855a.length; i10 += 4) {
            int C = C(i10);
            long j10 = 1048575 & C;
            int i11 = this.f23855a[i10];
            switch ((C & 267386880) >>> 20) {
                case 0:
                    if (v(t10, i10)) {
                        p3.e(t2, j10, p3.L(t10, j10));
                        F(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (v(t10, i10)) {
                        p3.f(t2, j10, p3.K(t10, j10));
                        F(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.h(t2, j10, p3.I(t10, j10));
                    F(t2, i10);
                    break;
                case 3:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.h(t2, j10, p3.I(t10, j10));
                    F(t2, i10);
                    break;
                case 4:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 5:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.h(t2, j10, p3.I(t10, j10));
                    F(t2, i10);
                    break;
                case 6:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 7:
                    if (v(t10, i10)) {
                        p3.j(t2, j10, p3.J(t10, j10));
                        F(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.i(t2, j10, p3.M(t10, j10));
                    F(t2, i10);
                    break;
                case 9:
                case 17:
                    u(t2, t10, i10);
                    break;
                case 10:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.i(t2, j10, p3.M(t10, j10));
                    F(t2, i10);
                    break;
                case 11:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 12:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 13:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 14:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.h(t2, j10, p3.I(t10, j10));
                    F(t2, i10);
                    break;
                case 15:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.g(t2, j10, p3.H(t10, j10));
                    F(t2, i10);
                    break;
                case 16:
                    if (!v(t10, i10)) {
                        break;
                    }
                    p3.h(t2, j10, p3.I(t10, j10));
                    F(t2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f23869o.b(t2, t10, j10);
                    break;
                case 50:
                    t2.h(this.f23872r, t2, t10, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!w(t10, i11, i10)) {
                        break;
                    }
                    p3.i(t2, j10, p3.M(t10, j10));
                    G(t2, i11, i10);
                    break;
                case 60:
                case 68:
                    I(t2, t10, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!w(t10, i11, i10)) {
                        break;
                    }
                    p3.i(t2, j10, p3.M(t10, j10));
                    G(t2, i11, i10);
                    break;
            }
        }
        if (this.f23863i) {
            return;
        }
        t2.i(this.f23870p, t2, t10);
        if (this.f23861g) {
            t2.g(this.f23871q, t2, t10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        if (com.google.android.gms.internal.clearcut.t2.y(com.google.android.gms.internal.clearcut.p3.M(r10, r6), com.google.android.gms.internal.clearcut.p3.M(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if (com.google.android.gms.internal.clearcut.t2.y(com.google.android.gms.internal.clearcut.p3.M(r10, r6), com.google.android.gms.internal.clearcut.p3.M(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (com.google.android.gms.internal.clearcut.t2.y(com.google.android.gms.internal.clearcut.p3.M(r10, r6), com.google.android.gms.internal.clearcut.p3.M(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:
    
        if (com.google.android.gms.internal.clearcut.t2.y(com.google.android.gms.internal.clearcut.p3.M(r10, r6), com.google.android.gms.internal.clearcut.p3.M(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.J(r10, r6) == com.google.android.gms.internal.clearcut.p3.J(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0169, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018d, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.H(r10, r6) == com.google.android.gms.internal.clearcut.p3.H(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a0, code lost:
    
        if (com.google.android.gms.internal.clearcut.p3.I(r10, r6) == com.google.android.gms.internal.clearcut.p3.I(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.clearcut.t2.y(com.google.android.gms.internal.clearcut.p3.M(r10, r6), com.google.android.gms.internal.clearcut.p3.M(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a6 A[LOOP:0: B:2:0x0005->B:85:0x01a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a5 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0127, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:
    
        r3 = (com.google.android.gms.internal.clearcut.zzbn.B0(r3) + com.google.android.gms.internal.clearcut.zzbn.D0(r5)) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020d, code lost:
    
        r2.putInt(r20, r14, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0139, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x014b, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x015d, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x016f, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0181, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0193, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01a5, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01b6, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c7, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d8, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e9, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fa, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x020b, code lost:
    
        if (r19.f23864j != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0331, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0414, code lost:
    
        if (w(r20, r15, r5) != false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06b6, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.P(r15, (com.google.android.gms.internal.clearcut.a2) r2.getObject(r20, r10), z(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0434, code lost:
    
        if (w(r20, r15, r5) != false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06e3, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.o0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x043c, code lost:
    
        if (w(r20, r15, r5) != false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06ee, code lost:
    
        r9 = com.google.android.gms.internal.clearcut.zzbn.v0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x045c, code lost:
    
        if (w(r20, r15, r5) != false) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0713, code lost:
    
        r4 = r2.getObject(r20, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0717, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.N(r15, (com.google.android.gms.internal.clearcut.zzbb) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0464, code lost:
    
        if (w(r20, r15, r5) != false) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0722, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.t2.n(r15, r2.getObject(r20, r10), z(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0474, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x073d, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.C(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x047c, code lost:
    
        if (w(r20, r15, r5) != false) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0749, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.Q(r15, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0514, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x05fe, code lost:
    
        r9 = (com.google.android.gms.internal.clearcut.zzbn.B0(r15) + com.google.android.gms.internal.clearcut.zzbn.D0(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x05fa, code lost:
    
        r2.putInt(r20, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0526, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0538, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x054a, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x055c, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x056e, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0580, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0592, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x05a3, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x05b4, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x05c5, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x05d6, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x05e7, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x05f8, code lost:
    
        if (r19.f23864j != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x06b4, code lost:
    
        if ((r12 & r18) != 0) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x06e1, code lost:
    
        if ((r12 & r18) != 0) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x06ec, code lost:
    
        if ((r12 & r18) != 0) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0711, code lost:
    
        if ((r12 & r18) != 0) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0720, code lost:
    
        if ((r12 & r18) != 0) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x073a, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0747, code lost:
    
        if ((r12 & r18) != 0) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0334, code lost:
    
        r3 = com.google.android.gms.internal.clearcut.zzbn.C(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:263:0x040b. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int f(T r20) {
        /*
            Method dump skipped, instructions count: 2290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.f(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ce, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
    
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e2, code lost:
    
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.hashCode(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    public final int l(T t2, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, w wVar) throws IOException {
        Object valueOf;
        Object valueOf2;
        int g3;
        long j11;
        int i18;
        Object valueOf3;
        int i19;
        Unsafe unsafe = f23854s;
        long j12 = this.f23855a[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 == 1) {
                    valueOf = Double.valueOf(v.l(bArr, i10));
                    unsafe.putObject(t2, j10, valueOf);
                    g3 = i10 + 8;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 52:
                if (i14 == 5) {
                    valueOf2 = Float.valueOf(v.n(bArr, i10));
                    unsafe.putObject(t2, j10, valueOf2);
                    g3 = i10 + 4;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 53:
            case 54:
                if (i14 == 0) {
                    g3 = v.g(bArr, i10, wVar);
                    j11 = wVar.f24065b;
                    valueOf3 = Long.valueOf(j11);
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 55:
            case 62:
                if (i14 == 0) {
                    g3 = v.e(bArr, i10, wVar);
                    i18 = wVar.f24064a;
                    valueOf3 = Integer.valueOf(i18);
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 56:
            case 65:
                if (i14 == 1) {
                    valueOf = Long.valueOf(v.k(bArr, i10));
                    unsafe.putObject(t2, j10, valueOf);
                    g3 = i10 + 8;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 57:
            case 64:
                if (i14 == 5) {
                    valueOf2 = Integer.valueOf(v.h(bArr, i10));
                    unsafe.putObject(t2, j10, valueOf2);
                    g3 = i10 + 4;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 58:
                if (i14 == 0) {
                    g3 = v.g(bArr, i10, wVar);
                    valueOf3 = Boolean.valueOf(wVar.f24065b != 0);
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 59:
                if (i14 == 2) {
                    g3 = v.e(bArr, i10, wVar);
                    i19 = wVar.f24064a;
                    if (i19 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t2, j10, valueOf3);
                        unsafe.putInt(t2, j12, i13);
                        return g3;
                    }
                    if ((i15 & 536870912) != 0 && !r3.i(bArr, g3, g3 + i19)) {
                        throw zzco.zzbp();
                    }
                    unsafe.putObject(t2, j10, new String(bArr, g3, i19, z0.f24119a));
                    g3 += i19;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 60:
                if (i14 == 2) {
                    g3 = j(z(i17), bArr, i10, i11, wVar);
                    Object object = unsafe.getInt(t2, j12) == i13 ? unsafe.getObject(t2, j10) : null;
                    valueOf3 = wVar.f24066c;
                    if (object != null) {
                        valueOf3 = z0.d(object, valueOf3);
                    }
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 61:
                if (i14 == 2) {
                    g3 = v.e(bArr, i10, wVar);
                    i19 = wVar.f24064a;
                    if (i19 == 0) {
                        valueOf3 = zzbb.zzfi;
                        unsafe.putObject(t2, j10, valueOf3);
                        unsafe.putInt(t2, j12, i13);
                        return g3;
                    }
                    unsafe.putObject(t2, j10, zzbb.zzb(bArr, g3, i19));
                    g3 += i19;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 63:
                if (i14 == 0) {
                    int e2 = v.e(bArr, i10, wVar);
                    int i20 = wVar.f24064a;
                    b1<?> B = B(i17);
                    if (B != null && B.a(i20) == null) {
                        Q(t2).e(i12, Long.valueOf(i20));
                        return e2;
                    }
                    unsafe.putObject(t2, j10, Integer.valueOf(i20));
                    g3 = e2;
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 66:
                if (i14 == 0) {
                    g3 = v.e(bArr, i10, wVar);
                    i18 = e0.e(wVar.f24064a);
                    valueOf3 = Integer.valueOf(i18);
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 67:
                if (i14 == 0) {
                    g3 = v.g(bArr, i10, wVar);
                    j11 = e0.a(wVar.f24065b);
                    valueOf3 = Long.valueOf(j11);
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            case 68:
                if (i14 == 3) {
                    g3 = i(z(i17), bArr, i10, i11, (i12 & (-8)) | 4, wVar);
                    Object object2 = unsafe.getInt(t2, j12) == i13 ? unsafe.getObject(t2, j10) : null;
                    valueOf3 = wVar.f24066c;
                    if (object2 != null) {
                        valueOf3 = z0.d(object2, valueOf3);
                    }
                    unsafe.putObject(t2, j10, valueOf3);
                    unsafe.putInt(t2, j12, i13);
                    return g3;
                }
                return i10;
            default:
                return i10;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x022f, code lost:
    
        if (r29.f24065b != 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0231, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0234, code lost:
    
        r12.addBoolean(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0237, code lost:
    
        if (r4 >= r19) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0239, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.v.e(r17, r4, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x023f, code lost:
    
        if (r20 != r29.f24064a) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0241, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.v.g(r17, r6, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0249, code lost:
    
        if (r29.f24065b == 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0233, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0234, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0137, code lost:
    
        if (r4 == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0139, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0147, code lost:
    
        if (r1 >= r19) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0149, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.v.e(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x014f, code lost:
    
        if (r20 != r29.f24064a) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0151, code lost:
    
        r1 = com.google.android.gms.internal.clearcut.v.e(r17, r4, r29);
        r4 = r29.f24064a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0157, code lost:
    
        if (r4 != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013f, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0147, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0249 -> B:117:0x0231). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0157 -> B:60:0x0139). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01a8 -> B:74:0x0189). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01de -> B:85:0x01b7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.clearcut.w r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 990
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.m(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.w):int");
    }

    public final <K, V> int n(T t2, byte[] bArr, int i10, int i11, int i12, int i13, long j10, w wVar) throws IOException {
        Unsafe unsafe = f23854s;
        Object A = A(i12);
        Object object = unsafe.getObject(t2, j10);
        if (this.f23872r.j(object)) {
            Object h10 = this.f23872r.h(A);
            this.f23872r.e(h10, object);
            unsafe.putObject(t2, j10, h10);
            object = h10;
        }
        this.f23872r.g(A);
        this.f23872r.l(object);
        int e2 = v.e(bArr, i10, wVar);
        int i14 = wVar.f24064a;
        if (i14 < 0 || i14 > i11 - e2) {
            throw zzco.zzbl();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final T newInstance() {
        return (T) this.f23868n.newInstance(this.f23860f);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:96:0x0068. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0370 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int o(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.w r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.e2.o(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.w):int");
    }

    public final <K, V, UT, UB> UB q(int i10, int i11, Map<K, V> map, b1<?> b1Var, UB ub2, i3<UT, UB> i3Var) {
        this.f23872r.g(A(i10));
        Iterator<Map.Entry<K, V>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<K, V> next = iterator2.next();
            if (b1Var.a(((Integer) next.getValue()).intValue()) == null) {
                if (ub2 == null) {
                    ub2 = i3Var.f();
                }
                c0 zzk = zzbb.zzk(t1.a(null, next.getKey(), next.getValue()));
                try {
                    t1.b(zzk.b(), null, next.getKey(), next.getValue());
                    i3Var.b(ub2, i11, zzk.a());
                    iterator2.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub2;
    }

    public final <K, V> void t(w3 w3Var, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            this.f23872r.g(A(i11));
            w3Var.Q(i10, null, this.f23872r.k(obj));
        }
    }

    public final void u(T t2, T t10, int i10) {
        long C = C(i10) & 1048575;
        if (v(t10, i10)) {
            Object M = p3.M(t2, C);
            Object M2 = p3.M(t10, C);
            if (M != null && M2 != null) {
                p3.i(t2, C, z0.d(M, M2));
                F(t2, i10);
            } else if (M2 != null) {
                p3.i(t2, C, M2);
                F(t2, i10);
            }
        }
    }

    public final boolean v(T t2, int i10) {
        if (!this.f23863i) {
            int D = D(i10);
            return (p3.H(t2, (long) (D & 1048575)) & (1 << (D >>> 20))) != 0;
        }
        int C = C(i10);
        long j10 = C & 1048575;
        switch ((C & 267386880) >>> 20) {
            case 0:
                return p3.L(t2, j10) != ShadowDrawableWrapper.COS_45;
            case 1:
                return p3.K(t2, j10) != 0.0f;
            case 2:
                return p3.I(t2, j10) != 0;
            case 3:
                return p3.I(t2, j10) != 0;
            case 4:
                return p3.H(t2, j10) != 0;
            case 5:
                return p3.I(t2, j10) != 0;
            case 6:
                return p3.H(t2, j10) != 0;
            case 7:
                return p3.J(t2, j10);
            case 8:
                Object M = p3.M(t2, j10);
                if (M instanceof String) {
                    return !((String) M).isEmpty();
                }
                if (M instanceof zzbb) {
                    return !zzbb.zzfi.equals(M);
                }
                throw new IllegalArgumentException();
            case 9:
                return p3.M(t2, j10) != null;
            case 10:
                return !zzbb.zzfi.equals(p3.M(t2, j10));
            case 11:
                return p3.H(t2, j10) != 0;
            case 12:
                return p3.H(t2, j10) != 0;
            case 13:
                return p3.H(t2, j10) != 0;
            case 14:
                return p3.I(t2, j10) != 0;
            case 15:
                return p3.H(t2, j10) != 0;
            case 16:
                return p3.I(t2, j10) != 0;
            case 17:
                return p3.M(t2, j10) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean w(T t2, int i10, int i11) {
        return p3.H(t2, (long) (D(i11) & 1048575)) == i10;
    }

    public final boolean x(T t2, int i10, int i11, int i12) {
        return this.f23863i ? v(t2, i10) : (i11 & i12) != 0;
    }

    public final r2 z(int i10) {
        int i11 = (i10 / 4) << 1;
        r2 r2Var = (r2) this.f23856b[i11];
        if (r2Var != null) {
            return r2Var;
        }
        r2<T> b4 = m2.a().b((Class) this.f23856b[i11 + 1]);
        this.f23856b[i11] = b4;
        return b4;
    }
}
