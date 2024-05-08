package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ExceptionTransformer<I, O> implements Transformer<I, O>, Serializable {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionTransformer() {
    }

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i10) {
        throw new FunctorException("ExceptionTransformer invoked");
    }
}
