package tb;

import org.jetbrains.annotations.Nullable;

/* compiled from: Pools.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f53792a;

    /* renamed from: b, reason: collision with root package name */
    public int f53793b;

    public a(int i10) {
        if (i10 > 0) {
            this.f53792a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    }

    @Nullable
    public T a() {
        int i10 = this.f53793b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f53792a;
        T t2 = (T) objArr[i11];
        objArr[i11] = null;
        this.f53793b = i10 - 1;
        return t2;
    }

    public final boolean b(T t2) {
        int i10 = this.f53793b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f53792a[i11] == t2) {
                return true;
            }
        }
        return false;
    }

    public boolean c(T t2) {
        if (!b(t2)) {
            int i10 = this.f53793b;
            Object[] objArr = this.f53792a;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t2;
            this.f53793b = i10 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!".toString());
    }
}
