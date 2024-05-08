package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator<byte[]> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }

    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i10 = 0; i10 < min; i10++) {
            int b4 = f.b(bArr[i10], bArr2[i10]);
            if (b4 != 0) {
                return b4;
            }
        }
        return bArr.length - bArr2.length;
    }
}
