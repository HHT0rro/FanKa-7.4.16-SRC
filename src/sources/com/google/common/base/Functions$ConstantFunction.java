package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$ConstantFunction<E> implements g<Object, E>, Serializable {
    private static final long serialVersionUID = 0;
    private final E value;

    public Functions$ConstantFunction(E e2) {
        this.value = e2;
    }

    @Override // com.google.common.base.g
    public E apply(Object obj) {
        return this.value;
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$ConstantFunction) {
            return l.a(this.value, ((Functions$ConstantFunction) obj).value);
        }
        return false;
    }

    public int hashCode() {
        E e2 = this.value;
        if (e2 == null) {
            return 0;
        }
        return e2.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.value);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
        sb2.append("Functions.constant(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
