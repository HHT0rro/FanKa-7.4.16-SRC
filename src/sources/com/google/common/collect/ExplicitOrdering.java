package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> list) {
        this(Maps.k(list));
    }

    private int rank(T t2) {
        Integer num = this.rankMap.get(t2);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t2);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t2, T t10) {
        return rank(t2) - rank(t10);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.rankMap.h());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
        sb2.append("Ordering.explicit(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }
}
