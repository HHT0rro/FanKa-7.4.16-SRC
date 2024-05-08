package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$PredicateFunction<T> implements g<T, Boolean>, Serializable {
    private static final long serialVersionUID = 0;
    private final p<T> predicate;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.g
    public /* bridge */ /* synthetic */ Boolean apply(Object obj) {
        return apply((Functions$PredicateFunction<T>) obj);
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$PredicateFunction) {
            return this.predicate.equals(((Functions$PredicateFunction) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.predicate);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
        sb2.append("Functions.forPredicate(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    private Functions$PredicateFunction(p<T> pVar) {
        this.predicate = (p) o.r(pVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.common.base.g
    public Boolean apply(T t2) {
        return Boolean.valueOf(this.predicate.apply(t2));
    }
}
