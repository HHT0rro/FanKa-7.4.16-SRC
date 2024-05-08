package h;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.alipay.sdk.util.i;

/* compiled from: MutablePair.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public T f49486a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public T f49487b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t2, T t10) {
        this.f49486a = t2;
        this.f49487b = t10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.first, this.f49486a) && a(pair.second, this.f49487b);
    }

    public int hashCode() {
        T t2 = this.f49486a;
        int hashCode = t2 == null ? 0 : t2.hashCode();
        T t10 = this.f49487b;
        return hashCode ^ (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + ((Object) this.f49486a) + " " + ((Object) this.f49487b) + i.f4738d;
    }
}
