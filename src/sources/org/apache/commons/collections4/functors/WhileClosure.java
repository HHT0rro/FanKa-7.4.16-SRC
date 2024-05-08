package org.apache.commons.collections4.functors;

import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class WhileClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final boolean iDoLoop;
    private final Predicate<? super E> iPredicate;

    public WhileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z10) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z10;
    }

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z10) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        Objects.requireNonNull(closure, "Closure must not be null");
        return new WhileClosure(predicate, closure, z10);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        if (this.iDoLoop) {
            this.iClosure.execute(e2);
        }
        while (this.iPredicate.evaluate(e2)) {
            this.iClosure.execute(e2);
        }
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public Predicate<? super E> getPredicate() {
        return this.iPredicate;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
