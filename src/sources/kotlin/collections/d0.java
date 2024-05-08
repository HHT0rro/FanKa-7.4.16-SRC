package kotlin.collections;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IndexedValue.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d0<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f50924a;

    /* renamed from: b, reason: collision with root package name */
    public final T f50925b;

    public d0(int i10, T t2) {
        this.f50924a = i10;
        this.f50925b = t2;
    }

    public final int a() {
        return this.f50924a;
    }

    public final T b() {
        return this.f50925b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f50924a == d0Var.f50924a && kotlin.jvm.internal.s.d(this.f50925b, d0Var.f50925b);
    }

    public int hashCode() {
        int i10 = this.f50924a * 31;
        T t2 = this.f50925b;
        return i10 + (t2 == null ? 0 : t2.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f50924a + ", value=" + ((Object) this.f50925b) + ')';
    }
}
