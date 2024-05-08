package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.k0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadSafeHeap.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j0<T extends k0 & Comparable<? super T>> {

    @NotNull
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public T[] f51394a;

    public final void a(@NotNull T t2) {
        t2.a(this);
        T[] f10 = f();
        int c4 = c();
        j(c4 + 1);
        f10[c4] = t2;
        t2.f(c4);
        l(c4);
    }

    @Nullable
    public final T b() {
        T[] tArr = this.f51394a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    @Nullable
    public final T e() {
        T b4;
        synchronized (this) {
            b4 = b();
        }
        return b4;
    }

    public final T[] f() {
        T[] tArr = this.f51394a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new k0[4];
            this.f51394a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.s.h(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((k0[]) copyOf);
        this.f51394a = tArr3;
        return tArr3;
    }

    public final boolean g(@NotNull T t2) {
        boolean z10;
        synchronized (this) {
            if (t2.c() == null) {
                z10 = false;
            } else {
                h(t2.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    @NotNull
    public final T h(int i10) {
        T[] tArr = this.f51394a;
        kotlin.jvm.internal.s.f(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t2 = tArr[i10];
                kotlin.jvm.internal.s.f(t2);
                T t10 = tArr[i11];
                kotlin.jvm.internal.s.f(t10);
                if (((Comparable) t2).compareTo(t10) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        T t11 = tArr[c()];
        kotlin.jvm.internal.s.f(t11);
        t11.a(null);
        t11.f(-1);
        tArr[c()] = null;
        return t11;
    }

    @Nullable
    public final T i() {
        T h10;
        synchronized (this) {
            h10 = c() > 0 ? h(0) : null;
        }
        return h10;
    }

    public final void j(int i10) {
        this._size = i10;
    }

    public final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 >= c()) {
                return;
            }
            T[] tArr = this.f51394a;
            kotlin.jvm.internal.s.f(tArr);
            int i12 = i11 + 1;
            if (i12 < c()) {
                T t2 = tArr[i12];
                kotlin.jvm.internal.s.f(t2);
                T t10 = tArr[i11];
                kotlin.jvm.internal.s.f(t10);
                if (((Comparable) t2).compareTo(t10) < 0) {
                    i11 = i12;
                }
            }
            T t11 = tArr[i10];
            kotlin.jvm.internal.s.f(t11);
            T t12 = tArr[i11];
            kotlin.jvm.internal.s.f(t12);
            if (((Comparable) t11).compareTo(t12) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    public final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f51394a;
            kotlin.jvm.internal.s.f(tArr);
            int i11 = (i10 - 1) / 2;
            T t2 = tArr[i11];
            kotlin.jvm.internal.s.f(t2);
            T t10 = tArr[i10];
            kotlin.jvm.internal.s.f(t10);
            if (((Comparable) t2).compareTo(t10) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    public final void m(int i10, int i11) {
        T[] tArr = this.f51394a;
        kotlin.jvm.internal.s.f(tArr);
        T t2 = tArr[i11];
        kotlin.jvm.internal.s.f(t2);
        T t10 = tArr[i10];
        kotlin.jvm.internal.s.f(t10);
        tArr[i10] = t2;
        tArr[i11] = t10;
        t2.f(i10);
        t10.f(i11);
    }
}
