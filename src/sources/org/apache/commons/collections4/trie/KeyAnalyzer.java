package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class KeyAnalyzer<K> implements Comparator<K>, Serializable {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    public static boolean isEqualBitKey(int i10) {
        return i10 == -2;
    }

    public static boolean isNullBitKey(int i10) {
        return i10 == -1;
    }

    public static boolean isOutOfBoundsIndex(int i10) {
        return i10 == -3;
    }

    public static boolean isValidBitIndex(int i10) {
        return i10 >= 0;
    }

    public abstract int bitIndex(K k10, int i10, int i11, K k11, int i12, int i13);

    public abstract int bitsPerElement();

    @Override // java.util.Comparator
    public int compare(K k10, K k11) {
        if (k10 == null) {
            return k11 == null ? 0 : -1;
        }
        if (k11 == null) {
            return 1;
        }
        return ((Comparable) k10).compareTo(k11);
    }

    public abstract boolean isBitSet(K k10, int i10, int i11);

    public abstract boolean isPrefix(K k10, int i10, int i11, K k11);

    public abstract int lengthInBits(K k10);
}
