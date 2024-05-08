package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class NOPClosure<E> implements Closure<E>, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    private NOPClosure() {
    }

    public static <E> Closure<E> nopClosure() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
    }
}
