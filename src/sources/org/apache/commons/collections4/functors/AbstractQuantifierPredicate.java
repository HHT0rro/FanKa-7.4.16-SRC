package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractQuantifierPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -3094696765038308799L;
    public final Predicate<? super T>[] iPredicates;

    public AbstractQuantifierPredicate(Predicate<? super T>... predicateArr) {
        this.iPredicates = predicateArr;
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }
}
