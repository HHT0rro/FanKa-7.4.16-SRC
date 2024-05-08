package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EqualPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T iValue;

    public EqualPredicate(T t2) {
        this(t2, null);
    }

    public static <T> Predicate<T> equalPredicate(T t2) {
        if (t2 == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t2);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t2) {
        Equator<T> equator = this.equator;
        if (equator != null) {
            return equator.equate(this.iValue, t2);
        }
        return this.iValue.equals(t2);
    }

    public Object getValue() {
        return this.iValue;
    }

    public EqualPredicate(T t2, Equator<T> equator) {
        this.iValue = t2;
        this.equator = equator;
    }

    public static <T> Predicate<T> equalPredicate(T t2, Equator<T> equator) {
        if (t2 == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t2, equator);
    }
}
