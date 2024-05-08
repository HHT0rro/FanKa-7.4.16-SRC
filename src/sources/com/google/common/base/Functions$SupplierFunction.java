package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$SupplierFunction<F, T> implements g<F, T>, Serializable {
    private static final long serialVersionUID = 0;
    private final t<T> supplier;

    @Override // com.google.common.base.g
    public T apply(F f10) {
        return this.supplier.get();
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$SupplierFunction) {
            return this.supplier.equals(((Functions$SupplierFunction) obj).supplier);
        }
        return false;
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.supplier);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
        sb2.append("Functions.forSupplier(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    private Functions$SupplierFunction(t<T> tVar) {
        this.supplier = (t) o.r(tVar);
    }
}
