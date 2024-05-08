package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import java.util.Arrays;

/* compiled from: ObjectCountHashMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n0<K> {

    /* renamed from: a, reason: collision with root package name */
    public transient Object[] f26593a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f26594b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f26595c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f26596d;

    /* renamed from: e, reason: collision with root package name */
    public transient int[] f26597e;

    /* renamed from: f, reason: collision with root package name */
    public transient long[] f26598f;

    /* renamed from: g, reason: collision with root package name */
    public transient float f26599g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f26600h;

    /* compiled from: ObjectCountHashMap.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends Multisets.b<K> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26601b;

        /* renamed from: c, reason: collision with root package name */
        public int f26602c;

        public a(int i10) {
            this.f26601b = (K) n0.this.f26593a[i10];
            this.f26602c = i10;
        }

        @Override // com.google.common.collect.k0.a
        public int getCount() {
            j();
            int i10 = this.f26602c;
            if (i10 == -1) {
                return 0;
            }
            return n0.this.f26594b[i10];
        }

        @Override // com.google.common.collect.k0.a
        public K getElement() {
            return this.f26601b;
        }

        public void j() {
            int i10 = this.f26602c;
            if (i10 == -1 || i10 >= n0.this.C() || !com.google.common.base.l.a(this.f26601b, n0.this.f26593a[this.f26602c])) {
                this.f26602c = n0.this.m(this.f26601b);
            }
        }
    }

    public n0() {
        n(3, 1.0f);
    }

    public static long D(long j10, int i10) {
        return (j10 & (-4294967296L)) | (i10 & 4294967295L);
    }

    public static <K> n0<K> b() {
        return new n0<>();
    }

    public static <K> n0<K> c(int i10) {
        return new n0<>(i10);
    }

    public static int h(long j10) {
        return (int) (j10 >>> 32);
    }

    public static int j(long j10) {
        return (int) j10;
    }

    public static long[] q(int i10) {
        long[] jArr = new long[i10];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i10) {
        if (this.f26597e.length >= 1073741824) {
            this.f26600h = Integer.MAX_VALUE;
            return;
        }
        int i11 = ((int) (i10 * this.f26599g)) + 1;
        int[] r10 = r(i10);
        long[] jArr = this.f26598f;
        int length = r10.length - 1;
        for (int i12 = 0; i12 < this.f26595c; i12++) {
            int h10 = h(jArr[i12]);
            int i13 = h10 & length;
            int i14 = r10[i13];
            r10[i13] = i12;
            jArr[i12] = (h10 << 32) | (i14 & 4294967295L);
        }
        this.f26600h = i11;
        this.f26597e = r10;
    }

    public void B(int i10, int i11) {
        com.google.common.base.o.p(i10, this.f26595c);
        this.f26594b[i10] = i11;
    }

    public int C() {
        return this.f26595c;
    }

    public void a() {
        this.f26596d++;
        Arrays.fill(this.f26593a, 0, this.f26595c, (Object) null);
        Arrays.fill(this.f26594b, 0, this.f26595c, 0);
        Arrays.fill(this.f26597e, -1);
        Arrays.fill(this.f26598f, -1L);
        this.f26595c = 0;
    }

    public void d(int i10) {
        if (i10 > this.f26598f.length) {
            y(i10);
        }
        if (i10 >= this.f26600h) {
            A(Math.max(2, Integer.highestOneBit(i10 - 1) << 1));
        }
    }

    public int e() {
        return this.f26595c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m10 = m(obj);
        if (m10 == -1) {
            return 0;
        }
        return this.f26594b[m10];
    }

    public k0.a<K> g(int i10) {
        com.google.common.base.o.p(i10, this.f26595c);
        return new a(i10);
    }

    public K i(int i10) {
        com.google.common.base.o.p(i10, this.f26595c);
        return (K) this.f26593a[i10];
    }

    public int k(int i10) {
        com.google.common.base.o.p(i10, this.f26595c);
        return this.f26594b[i10];
    }

    public final int l() {
        return this.f26597e.length - 1;
    }

    public int m(Object obj) {
        int d10 = f0.d(obj);
        int i10 = this.f26597e[l() & d10];
        while (i10 != -1) {
            long j10 = this.f26598f[i10];
            if (h(j10) == d10 && com.google.common.base.l.a(obj, this.f26593a[i10])) {
                return i10;
            }
            i10 = j(j10);
        }
        return -1;
    }

    public void n(int i10, float f10) {
        com.google.common.base.o.e(i10 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.o.e(f10 > 0.0f, "Illegal load factor");
        int a10 = f0.a(i10, f10);
        this.f26597e = r(a10);
        this.f26599g = f10;
        this.f26593a = new Object[i10];
        this.f26594b = new int[i10];
        this.f26598f = q(i10);
        this.f26600h = Math.max(1, (int) (a10 * f10));
    }

    public void o(int i10, K k10, int i11, int i12) {
        this.f26598f[i10] = (i12 << 32) | 4294967295L;
        this.f26593a[i10] = k10;
        this.f26594b[i10] = i11;
    }

    public void p(int i10) {
        int C = C() - 1;
        if (i10 < C) {
            Object[] objArr = this.f26593a;
            objArr[i10] = objArr[C];
            int[] iArr = this.f26594b;
            iArr[i10] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f26598f;
            long j10 = jArr[C];
            jArr[i10] = j10;
            jArr[C] = -1;
            int h10 = h(j10) & l();
            int[] iArr2 = this.f26597e;
            int i11 = iArr2[h10];
            if (i11 == C) {
                iArr2[h10] = i10;
                return;
            }
            while (true) {
                long j11 = this.f26598f[i11];
                int j12 = j(j11);
                if (j12 == C) {
                    this.f26598f[i11] = D(j11, i10);
                    return;
                }
                i11 = j12;
            }
        } else {
            this.f26593a[i10] = null;
            this.f26594b[i10] = 0;
            this.f26598f[i10] = -1;
        }
    }

    public int s(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f26595c) {
            return i11;
        }
        return -1;
    }

    public int t(int i10, int i11) {
        return i10 - 1;
    }

    public int u(K k10, int i10) {
        m.d(i10, "count");
        long[] jArr = this.f26598f;
        Object[] objArr = this.f26593a;
        int[] iArr = this.f26594b;
        int d10 = f0.d(k10);
        int l10 = l() & d10;
        int i11 = this.f26595c;
        int[] iArr2 = this.f26597e;
        int i12 = iArr2[l10];
        if (i12 == -1) {
            iArr2[l10] = i11;
        } else {
            while (true) {
                long j10 = jArr[i12];
                if (h(j10) == d10 && com.google.common.base.l.a(k10, objArr[i12])) {
                    int i13 = iArr[i12];
                    iArr[i12] = i10;
                    return i13;
                }
                int j11 = j(j10);
                if (j11 == -1) {
                    jArr[i12] = D(j10, i11);
                    break;
                }
                i12 = j11;
            }
        }
        if (i11 != Integer.MAX_VALUE) {
            int i14 = i11 + 1;
            z(i14);
            o(i11, k10, i10, d10);
            this.f26595c = i14;
            if (i11 >= this.f26600h) {
                A(this.f26597e.length * 2);
            }
            this.f26596d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int v(Object obj) {
        return w(obj, f0.d(obj));
    }

    public final int w(Object obj, int i10) {
        int l10 = l() & i10;
        int i11 = this.f26597e[l10];
        if (i11 == -1) {
            return 0;
        }
        int i12 = -1;
        while (true) {
            if (h(this.f26598f[i11]) == i10 && com.google.common.base.l.a(obj, this.f26593a[i11])) {
                int i13 = this.f26594b[i11];
                if (i12 == -1) {
                    this.f26597e[l10] = j(this.f26598f[i11]);
                } else {
                    long[] jArr = this.f26598f;
                    jArr[i12] = D(jArr[i12], j(jArr[i11]));
                }
                p(i11);
                this.f26595c--;
                this.f26596d++;
                return i13;
            }
            int j10 = j(this.f26598f[i11]);
            if (j10 == -1) {
                return 0;
            }
            i12 = i11;
            i11 = j10;
        }
    }

    public int x(int i10) {
        return w(this.f26593a[i10], h(this.f26598f[i10]));
    }

    public void y(int i10) {
        this.f26593a = Arrays.copyOf(this.f26593a, i10);
        this.f26594b = Arrays.copyOf(this.f26594b, i10);
        long[] jArr = this.f26598f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        if (i10 > length) {
            Arrays.fill(copyOf, length, i10, -1L);
        }
        this.f26598f = copyOf;
    }

    public final void z(int i10) {
        int length = this.f26598f.length;
        if (i10 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    public n0(n0<? extends K> n0Var) {
        n(n0Var.C(), 1.0f);
        int e2 = n0Var.e();
        while (e2 != -1) {
            u(n0Var.i(e2), n0Var.k(e2));
            e2 = n0Var.s(e2);
        }
    }

    public n0(int i10) {
        this(i10, 1.0f);
    }

    public n0(int i10, float f10) {
        n(i10, f10);
    }
}
