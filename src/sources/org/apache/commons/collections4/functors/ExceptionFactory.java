package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ExceptionFactory<T> implements Factory<T>, Serializable {
    public static final Factory INSTANCE = new ExceptionFactory();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionFactory() {
    }

    public static <T> Factory<T> exceptionFactory() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        throw new FunctorException("ExceptionFactory invoked");
    }
}
