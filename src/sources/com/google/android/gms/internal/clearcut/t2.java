package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f24046a = C();

    /* renamed from: b, reason: collision with root package name */
    public static final i3<?, ?> f24047b = w(false);

    /* renamed from: c, reason: collision with root package name */
    public static final i3<?, ?> f24048c = w(true);

    /* renamed from: d, reason: collision with root package name */
    public static final i3<?, ?> f24049d = new k3();

    public static i3<?, ?> A() {
        return f24048c;
    }

    public static i3<?, ?> B() {
        return f24049d;
    }

    public static Class<?> C() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int E(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y0) {
            y0 y0Var = (y0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.C0(y0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.C0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void F(int i10, List<Long> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.z(i10, list, z10);
    }

    public static int G(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y0) {
            y0 y0Var = (y0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.D0(y0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.D0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void H(int i10, List<Long> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.v(i10, list, z10);
    }

    public static void I(Class<?> cls) {
        Class<?> cls2;
        if (!x0.class.isAssignableFrom(cls) && (cls2 = f24046a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int J(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y0) {
            y0 y0Var = (y0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.E0(y0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.E0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void K(int i10, List<Long> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.r(i10, list, z10);
    }

    public static int L(List<?> list) {
        return list.size() << 2;
    }

    public static void M(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.c(i10, list, z10);
    }

    public static int N(List<?> list) {
        return list.size() << 3;
    }

    public static void O(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.t(i10, list, z10);
    }

    public static int P(List<?> list) {
        return list.size();
    }

    public static void Q(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.A(i10, list, z10);
    }

    public static void R(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.h(i10, list, z10);
    }

    public static void S(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.u(i10, list, z10);
    }

    public static void T(int i10, List<Integer> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.q(i10, list, z10);
    }

    public static void U(int i10, List<Boolean> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.p(i10, list, z10);
    }

    public static int V(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbn.B0(i10));
    }

    public static int W(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzbn.B0(i10));
    }

    public static int X(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return q(list) + (size * zzbn.B0(i10));
    }

    public static int Y(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return v(list) + (size * zzbn.B0(i10));
    }

    public static int Z(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzbn.B0(i10));
    }

    public static int a(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p1) {
            p1 p1Var = (p1) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.e0(p1Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.e0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int a0(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * zzbn.B0(i10));
    }

    public static <UT, UB> UB b(int i10, int i11, UB ub2, i3<UT, UB> i3Var) {
        if (ub2 == null) {
            ub2 = i3Var.f();
        }
        i3Var.a(ub2, i10, i11);
        return ub2;
    }

    public static int b0(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return J(list) + (size * zzbn.B0(i10));
    }

    public static <UT, UB> UB c(int i10, List<Integer> list, b1<?> b1Var, UB ub2, i3<UT, UB> i3Var) {
        if (b1Var == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (b1Var.a(intValue) != null) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = (UB) b(i10, intValue, ub2, i3Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                int intValue2 = iterator2.next().intValue();
                if (b1Var.a(intValue2) == null) {
                    ub2 = (UB) b(i10, intValue2, ub2, i3Var);
                    iterator2.remove();
                }
            }
        }
        return ub2;
    }

    public static int c0(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.t0(i10, 0);
    }

    public static void d(int i10, List<String> list, w3 w3Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.C(i10, list);
    }

    public static int d0(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.k0(i10, 0L);
    }

    public static void e(int i10, List<?> list, w3 w3Var, r2 r2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.K(i10, list, r2Var);
    }

    public static int e0(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.Q(i10, true);
    }

    public static void f(int i10, List<Double> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.x(i10, list, z10);
    }

    public static <T, FT extends t0<FT>> void g(m0<FT> m0Var, T t2, T t10) {
        q0<FT> b4 = m0Var.b(t10);
        if (b4.b()) {
            return;
        }
        m0Var.e(t2).h(b4);
    }

    public static <T> void h(v1 v1Var, T t2, T t10, long j10) {
        p3.i(t2, j10, v1Var.e(p3.M(t2, j10), p3.M(t10, j10)));
    }

    public static <T, UT, UB> void i(i3<UT, UB> i3Var, T t2, T t10) {
        i3Var.g(t2, i3Var.i(i3Var.k(t2), i3Var.k(t10)));
    }

    public static int j(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p1) {
            p1 p1Var = (p1) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.h0(p1Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.h0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static void k(int i10, List<zzbb> list, w3 w3Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.B(i10, list);
    }

    public static void l(int i10, List<?> list, w3 w3Var, r2 r2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.J(i10, list, r2Var);
    }

    public static void m(int i10, List<Float> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.y(i10, list, z10);
    }

    public static int n(int i10, Object obj, r2 r2Var) {
        return obj instanceof h1 ? zzbn.d(i10, (h1) obj) : zzbn.B(i10, (a2) obj, r2Var);
    }

    public static int o(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int B0 = zzbn.B0(i10) * size;
        if (list instanceof j1) {
            j1 j1Var = (j1) list;
            while (i11 < size) {
                Object raw = j1Var.getRaw(i11);
                B0 += raw instanceof zzbb ? zzbn.D((zzbb) raw) : zzbn.q0((String) raw);
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                B0 += obj instanceof zzbb ? zzbn.D((zzbb) obj) : zzbn.q0((String) obj);
                i11++;
            }
        }
        return B0;
    }

    public static int p(int i10, List<?> list, r2 r2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B0 = zzbn.B0(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            B0 += obj instanceof h1 ? zzbn.e((h1) obj) : zzbn.E((a2) obj, r2Var);
        }
        return B0;
    }

    public static int q(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof p1) {
            p1 p1Var = (p1) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.l0(p1Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.l0(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static void r(int i10, List<Long> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.g(i10, list, z10);
    }

    public static boolean s(int i10, int i11, int i12) {
        if (i11 < 40) {
            return true;
        }
        long j10 = i12;
        return ((((long) i11) - ((long) i10)) + 1) + 9 <= ((2 * j10) + 3) + ((j10 + 3) * 3);
    }

    public static int t(int i10, List<zzbb> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B0 = size * zzbn.B0(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            B0 += zzbn.D(list.get(i11));
        }
        return B0;
    }

    public static int u(int i10, List<a2> list, r2 r2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzbn.P(i10, list.get(i12), r2Var);
        }
        return i11;
    }

    public static int v(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y0) {
            y0 y0Var = (y0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.H0(y0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzbn.H0(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static i3<?, ?> w(boolean z10) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (i3) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void x(int i10, List<Long> list, w3 w3Var, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w3Var.w(i10, list, z10);
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static i3<?, ?> z() {
        return f24047b;
    }
}
