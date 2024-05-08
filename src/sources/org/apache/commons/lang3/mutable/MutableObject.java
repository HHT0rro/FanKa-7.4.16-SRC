package org.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.value.equals(((MutableObject) obj).value);
        }
        return false;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public T getValue2() {
        return this.value;
    }

    public int hashCode() {
        T t2 = this.value;
        if (t2 == null) {
            return 0;
        }
        return t2.hashCode();
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(T t2) {
        this.value = t2;
    }

    public String toString() {
        T t2 = this.value;
        return t2 == null ? "null" : t2.toString();
    }

    public MutableObject(T t2) {
        this.value = t2;
    }
}
