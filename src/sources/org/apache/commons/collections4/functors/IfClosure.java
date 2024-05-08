package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IfClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E> iFalseClosure;
    private final Predicate<? super E> iPredicate;
    private final Closure<? super E> iTrueClosure;

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        this(predicate, closure, NOPClosure.nopClosure());
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return ifClosure(predicate, closure, NOPClosure.nopClosure());
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        if (this.iPredicate.evaluate(e2)) {
            this.iTrueClosure.execute(e2);
        } else {
            this.iFalseClosure.execute(e2);
        }
    }

    public Closure<? super E> getFalseClosure() {
        return this.iFalseClosure;
    }

    public Predicate<? super E> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super E> getTrueClosure() {
        return this.iTrueClosure;
    }

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        this.iPredicate = predicate;
        this.iTrueClosure = closure;
        this.iFalseClosure = closure2;
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        if (closure != null && closure2 != null) {
            return new IfClosure(predicate, closure, closure2);
        }
        throw new NullPointerException("Closures must not be null");
    }
}
