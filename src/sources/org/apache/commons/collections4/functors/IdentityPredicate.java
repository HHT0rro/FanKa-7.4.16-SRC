package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class IdentityPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T t2) {
        this.iValue = t2;
    }

    public static <T> Predicate<T> identityPredicate(T t2) {
        if (t2 == null) {
            return NullPredicate.nullPredicate();
        }
        return new IdentityPredicate(t2);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t2) {
        return this.iValue == t2;
    }

    public T getValue() {
        return this.iValue;
    }
}
