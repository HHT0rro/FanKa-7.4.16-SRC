package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final K[] keys;

    public MultiKey(K k10, K k11) {
        this(new Object[]{k10, k11}, false);
    }

    private void calculateHashCode(Object[] objArr) {
        int i10 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i10 ^= obj.hashCode();
            }
        }
        this.hashCode = i10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public K getKey(int i10) {
        return this.keys[i10];
    }

    public K[] getKeys() {
        return (K[]) ((Object[]) this.keys.clone());
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.keys);
    }

    public MultiKey(K k10, K k11, K k12) {
        this(new Object[]{k10, k11, k12}, false);
    }

    public MultiKey(K k10, K k11, K k12, K k13) {
        this(new Object[]{k10, k11, k12, k13}, false);
    }

    public MultiKey(K k10, K k11, K k12, K k13, K k14) {
        this(new Object[]{k10, k11, k12, k13, k14}, false);
    }

    public MultiKey(K[] kArr) {
        this((Object[]) kArr, true);
    }

    public MultiKey(K[] kArr, boolean z10) {
        if (kArr != null) {
            if (z10) {
                this.keys = (K[]) ((Object[]) kArr.clone());
            } else {
                this.keys = kArr;
            }
            calculateHashCode(kArr);
            return;
        }
        throw new IllegalArgumentException("The array of keys must not be null");
    }
}
