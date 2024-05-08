package androidx.core.util;

import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f10, S s2) {
        this.first = f10;
        this.second = s2;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a10, B b4) {
        return new Pair<>(a10, b4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f10 = this.first;
        int hashCode = f10 == null ? 0 : f10.hashCode();
        S s2 = this.second;
        return hashCode ^ (s2 != null ? s2.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + ((Object) this.first) + " " + ((Object) this.second) + i.f4738d;
    }
}
