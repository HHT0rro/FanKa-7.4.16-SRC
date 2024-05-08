package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* compiled from: ForwardingSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b0<E> extends s<E> implements Set<E> {
    @Override // com.google.common.collect.s, com.google.common.collect.z
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Sets.a(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(this);
    }

    @Override // com.google.common.collect.s
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.h(this, (Collection) com.google.common.base.o.r(collection));
    }
}
