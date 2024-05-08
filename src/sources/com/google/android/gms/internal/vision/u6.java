package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f25654a = F();

    /* renamed from: b, reason: collision with root package name */
    public static final k7<?, ?> f25655b = g(false);

    /* renamed from: c, reason: collision with root package name */
    public static final k7<?, ?> f25656c = g(true);

    /* renamed from: d, reason: collision with root package name */
    public static final k7<?, ?> f25657d = new l7();

    public static int A(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.n0(r5Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.n0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static k7<?, ?> B() {
        return f25657d;
    }

    public static void C(int i10, List<Long> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.g(i10, list, z10);
    }

    public static int D(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzii.g0(i10));
    }

    public static int E(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z4) {
            z4 z4Var = (z4) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.B0(z4Var.c(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.B0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static Class<?> F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i10, List<Long> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.w(i10, list, z10);
    }

    public static int H(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * zzii.g0(i10));
    }

    public static int I(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z4) {
            z4 z4Var = (z4) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.k0(z4Var.c(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.k0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static Class<?> J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i10, List<Long> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.z(i10, list, z10);
    }

    public static int L(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * zzii.g0(i10));
    }

    public static int M(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z4) {
            z4 z4Var = (z4) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.o0(z4Var.c(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.o0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void N(int i10, List<Long> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.v(i10, list, z10);
    }

    public static int O(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzii.g0(i10));
    }

    public static int P(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z4) {
            z4 z4Var = (z4) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.s0(z4Var.c(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.s0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void Q(int i10, List<Long> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.r(i10, list, z10);
    }

    public static int R(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.x0(i10, 0);
    }

    public static int S(List<?> list) {
        return list.size() << 2;
    }

    public static void T(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.c(i10, list, z10);
    }

    public static int U(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.q0(i10, 0L);
    }

    public static int V(List<?> list) {
        return list.size() << 3;
    }

    public static void W(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.t(i10, list, z10);
    }

    public static int X(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.H(i10, true);
    }

    public static int Y(List<?> list) {
        return list.size();
    }

    public static void Z(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.A(i10, list, z10);
    }

    public static int a(int i10, Object obj, t6 t6Var) {
        if (obj instanceof m5) {
            return zzii.c(i10, (m5) obj);
        }
        return zzii.F(i10, (c6) obj, t6Var);
    }

    public static void a0(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.h(i10, list, z10);
    }

    public static int b(int i10, List<?> list) {
        int K;
        int K2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int g02 = zzii.g0(i10) * size;
        if (list instanceof o5) {
            o5 o5Var = (o5) list;
            while (i11 < size) {
                Object a10 = o5Var.a(i11);
                if (a10 instanceof zzht) {
                    K2 = zzii.I((zzht) a10);
                } else {
                    K2 = zzii.K((String) a10);
                }
                g02 += K2;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzht) {
                    K = zzii.I((zzht) obj);
                } else {
                    K = zzii.K((String) obj);
                }
                g02 += K;
                i11++;
            }
        }
        return g02;
    }

    public static void b0(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.u(i10, list, z10);
    }

    public static int c(int i10, List<?> list, t6 t6Var) {
        int e2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g02 = zzii.g0(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof m5) {
                e2 = zzii.d((m5) obj);
            } else {
                e2 = zzii.e((c6) obj, t6Var);
            }
            g02 += e2;
        }
        return g02;
    }

    public static void c0(int i10, List<Integer> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.q(i10, list, z10);
    }

    public static int d(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzii.g0(i10));
    }

    public static void d0(int i10, List<Boolean> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.p(i10, list, z10);
    }

    public static int e(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.d0(r5Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.d0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static k7<?, ?> f() {
        return f25655b;
    }

    public static k7<?, ?> g(boolean z10) {
        try {
            Class<?> J = J();
            if (J == null) {
                return null;
            }
            return (k7) J.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <UT, UB> UB h(int i10, int i11, UB ub2, k7<UT, UB> k7Var) {
        if (ub2 == null) {
            ub2 = k7Var.a();
        }
        k7Var.b(ub2, i10, i11);
        return ub2;
    }

    public static <UT, UB> UB i(int i10, List<Integer> list, c5 c5Var, UB ub2, k7<UT, UB> k7Var) {
        if (c5Var == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (c5Var.zza(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = (UB) h(i10, intValue, ub2, k7Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                int intValue2 = iterator2.next().intValue();
                if (!c5Var.zza(intValue2)) {
                    ub2 = (UB) h(i10, intValue2, ub2, k7Var);
                    iterator2.remove();
                }
            }
        }
        return ub2;
    }

    public static void j(int i10, List<String> list, z7 z7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.C(i10, list);
    }

    public static void k(int i10, List<?> list, z7 z7Var, t6 t6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.M(i10, list, t6Var);
    }

    public static void l(int i10, List<Double> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.x(i10, list, z10);
    }

    public static <T, FT extends s4<FT>> void m(n4<FT> n4Var, T t2, T t10) {
        r4<FT> b4 = n4Var.b(t10);
        if (b4.f25620a.isEmpty()) {
            return;
        }
        n4Var.f(t2).f(b4);
    }

    public static <T> void n(z5 z5Var, T t2, T t10, long j10) {
        p7.j(t2, j10, z5Var.d(p7.F(t2, j10), p7.F(t10, j10)));
    }

    public static <T, UT, UB> void o(k7<UT, UB> k7Var, T t2, T t10) {
        k7Var.e(t2, k7Var.i(k7Var.f(t2), k7Var.f(t10)));
    }

    public static void p(Class<?> cls) {
        Class<?> cls2;
        if (!x4.class.isAssignableFrom(cls) && (cls2 = f25654a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int r(int i10, List<zzht> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g02 = size * zzii.g0(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            g02 += zzii.I(list.get(i11));
        }
        return g02;
    }

    public static int s(int i10, List<c6> list, t6 t6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzii.U(i10, list.get(i12), t6Var);
        }
        return i11;
    }

    public static int t(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * zzii.g0(i10));
    }

    public static int u(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.i0(r5Var.f(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzii.i0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static k7<?, ?> v() {
        return f25656c;
    }

    public static void w(int i10, List<zzht> list, z7 z7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.B(i10, list);
    }

    public static void x(int i10, List<?> list, z7 z7Var, t6 t6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.L(i10, list, t6Var);
    }

    public static void y(int i10, List<Float> list, z7 z7Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        z7Var.y(i10, list, z10);
    }

    public static int z(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzii.g0(i10));
    }
}
