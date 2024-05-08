package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UniquePredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -3319417438027438040L;
    private final Set<T> iSet = new HashSet();

    public static <T> Predicate<T> uniquePredicate() {
        return new UniquePredicate();
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t2) {
        return this.iSet.add(t2);
    }
}
