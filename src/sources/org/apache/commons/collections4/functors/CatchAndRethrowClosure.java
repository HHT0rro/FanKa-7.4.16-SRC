package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class CatchAndRethrowClosure<E> implements Closure<E> {
    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        try {
            executeAndThrow(e2);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }

    public abstract void executeAndThrow(E e2) throws Throwable;
}
