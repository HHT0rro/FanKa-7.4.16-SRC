package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: TopKSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e1<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f26573a;

    /* renamed from: b, reason: collision with root package name */
    public final Comparator<? super T> f26574b;

    /* renamed from: c, reason: collision with root package name */
    public final T[] f26575c;

    /* renamed from: d, reason: collision with root package name */
    public int f26576d;

    /* renamed from: e, reason: collision with root package name */
    public T f26577e;

    public e1(Comparator<? super T> comparator, int i10) {
        this.f26574b = (Comparator) com.google.common.base.o.s(comparator, "comparator");
        this.f26573a = i10;
        com.google.common.base.o.h(i10 >= 0, "k (%s) must be >= 0", i10);
        com.google.common.base.o.h(i10 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i10);
        this.f26575c = (T[]) new Object[com.google.common.math.d.b(i10, 2)];
        this.f26576d = 0;
        this.f26577e = null;
    }

    public static <T> e1<T> a(int i10, Comparator<? super T> comparator) {
        return new e1<>(comparator, i10);
    }

    public void b(T t2) {
        int i10 = this.f26573a;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f26576d;
        if (i11 == 0) {
            this.f26575c[0] = t2;
            this.f26577e = t2;
            this.f26576d = 1;
            return;
        }
        if (i11 < i10) {
            T[] tArr = this.f26575c;
            this.f26576d = i11 + 1;
            tArr[i11] = t2;
            if (this.f26574b.compare(t2, (Object) l0.a(this.f26577e)) > 0) {
                this.f26577e = t2;
                return;
            }
            return;
        }
        if (this.f26574b.compare(t2, (Object) l0.a(this.f26577e)) < 0) {
            T[] tArr2 = this.f26575c;
            int i12 = this.f26576d;
            int i13 = i12 + 1;
            this.f26576d = i13;
            tArr2[i12] = t2;
            if (i13 == this.f26573a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final int d(int i10, int i11, int i12) {
        Object a10 = l0.a(this.f26575c[i12]);
        T[] tArr = this.f26575c;
        tArr[i12] = tArr[i11];
        int i13 = i10;
        while (i10 < i11) {
            if (this.f26574b.compare((Object) l0.a(this.f26575c[i10]), a10) < 0) {
                e(i13, i10);
                i13++;
            }
            i10++;
        }
        T[] tArr2 = this.f26575c;
        tArr2[i11] = tArr2[i13];
        tArr2[i13] = a10;
        return i13;
    }

    public final void e(int i10, int i11) {
        T[] tArr = this.f26575c;
        T t2 = tArr[i10];
        tArr[i10] = tArr[i11];
        tArr[i11] = t2;
    }

    public List<T> f() {
        Arrays.sort(this.f26575c, 0, this.f26576d, this.f26574b);
        int i10 = this.f26576d;
        int i11 = this.f26573a;
        if (i10 > i11) {
            T[] tArr = this.f26575c;
            Arrays.fill(tArr, i11, tArr.length, (Object) null);
            int i12 = this.f26573a;
            this.f26576d = i12;
            this.f26577e = this.f26575c[i12 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f26575c, this.f26576d)));
    }

    public final void g() {
        int i10 = (this.f26573a * 2) - 1;
        int f10 = com.google.common.math.d.f(i10 + 0, RoundingMode.CEILING) * 3;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            int d10 = d(i11, i10, ((i11 + i10) + 1) >>> 1);
            int i14 = this.f26573a;
            if (d10 <= i14) {
                if (d10 >= i14) {
                    break;
                }
                i11 = Math.max(d10, i11 + 1);
                i13 = d10;
            } else {
                i10 = d10 - 1;
            }
            i12++;
            if (i12 >= f10) {
                Arrays.sort(this.f26575c, i11, i10 + 1, this.f26574b);
                break;
            }
        }
        this.f26576d = this.f26573a;
        this.f26577e = (T) l0.a(this.f26575c[i13]);
        while (true) {
            i13++;
            if (i13 >= this.f26573a) {
                return;
            }
            if (this.f26574b.compare((Object) l0.a(this.f26575c[i13]), (Object) l0.a(this.f26577e)) > 0) {
                this.f26577e = this.f26575c[i13];
            }
        }
    }
}
