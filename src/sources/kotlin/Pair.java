package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Tuples.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a10, B b4) {
        this.first = a10;
        this.second = b4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = pair.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @NotNull
    public final Pair<A, B> copy(A a10, B b4) {
        return new Pair<>(a10, b4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return s.d(this.first, pair.first) && s.d(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a10 = this.first;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b4 = this.second;
        return hashCode + (b4 != null ? b4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + ((Object) this.first) + ", " + ((Object) this.second) + ')';
    }
}
