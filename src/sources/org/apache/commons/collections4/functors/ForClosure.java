package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ForClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final int iCount;

    public ForClosure(int i10, Closure<? super E> closure) {
        this.iCount = i10;
        this.iClosure = closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i10, Closure<? super E> closure) {
        if (i10 <= 0 || closure == 0) {
            return NOPClosure.nopClosure();
        }
        return i10 == 1 ? closure : new ForClosure(i10, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        for (int i10 = 0; i10 < this.iCount; i10++) {
            this.iClosure.execute(e2);
        }
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
