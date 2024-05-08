package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final g<? super F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(g<? super F, ? extends T> gVar, Equivalence<T> equivalence) {
        this.function = (g) o.r(gVar);
        this.resultEquivalence = (Equivalence) o.r(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f10, F f11) {
        return this.resultEquivalence.equivalent(this.function.apply(f10), this.function.apply(f11));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F f10) {
        return this.resultEquivalence.hash(this.function.apply(f10));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return l.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        String valueOf = String.valueOf(this.resultEquivalence);
        String valueOf2 = String.valueOf(this.function);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(".onResultOf(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
