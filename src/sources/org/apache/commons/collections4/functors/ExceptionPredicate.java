package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ExceptionPredicate<T> implements Predicate<T>, Serializable {
    public static final Predicate INSTANCE = new ExceptionPredicate();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionPredicate() {
    }

    public static <T> Predicate<T> exceptionPredicate() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t2) {
        throw new FunctorException("ExceptionPredicate invoked");
    }
}
