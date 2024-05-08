package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Tuples.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a10, B b4, C c4) {
        this.first = a10;
        this.second = b4;
        this.third = c4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i10, Object obj4) {
        if ((i10 & 1) != 0) {
            obj = triple.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i10 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @NotNull
    public final Triple<A, B, C> copy(A a10, B b4, C c4) {
        return new Triple<>(a10, b4, c4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return s.d(this.first, triple.first) && s.d(this.second, triple.second) && s.d(this.third, triple.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a10 = this.first;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b4 = this.second;
        int hashCode2 = (hashCode + (b4 == null ? 0 : b4.hashCode())) * 31;
        C c4 = this.third;
        return hashCode2 + (c4 != null ? c4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + ((Object) this.first) + ", " + ((Object) this.second) + ", " + ((Object) this.third) + ')';
    }
}
