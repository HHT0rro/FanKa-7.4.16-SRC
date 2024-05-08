package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DefaultEquator<T> implements Equator<T>, Serializable {
    public static final int HASHCODE_NULL = -1;
    public static final DefaultEquator INSTANCE = new DefaultEquator();
    private static final long serialVersionUID = 825802648423525485L;

    private DefaultEquator() {
    }

    public static <T> DefaultEquator<T> defaultEquator() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Equator
    public boolean equate(T t2, T t10) {
        return t2 == t10 || (t2 != null && t2.equals(t10));
    }

    @Override // org.apache.commons.collections4.Equator
    public int hash(T t2) {
        if (t2 == null) {
            return -1;
        }
        return t2.hashCode();
    }
}
