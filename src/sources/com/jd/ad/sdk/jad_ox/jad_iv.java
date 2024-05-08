package com.jd.ad.sdk.jad_ox;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_js.jad_zm;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_iv<T> {

    @Nullable
    public T jad_an;

    @Nullable
    public T jad_bo;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f10 = pair.first;
        Object obj2 = this.jad_an;
        if (!(f10 == obj2 || (f10 != 0 && f10.equals(obj2)))) {
            return false;
        }
        S s2 = pair.second;
        Object obj3 = this.jad_bo;
        return s2 == obj3 || (s2 != 0 && s2.equals(obj3));
    }

    public int hashCode() {
        T t2 = this.jad_an;
        int hashCode = t2 == null ? 0 : t2.hashCode();
        T t10 = this.jad_bo;
        return hashCode ^ (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("Pair{");
        jad_an.append((Object) this.jad_an);
        jad_an.append(" ");
        jad_an.append((Object) this.jad_bo);
        jad_an.append(i.f4738d);
        return jad_an.toString();
    }
}
