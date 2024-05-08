package com.google.common.primitives;

import com.google.common.base.o;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SignedBytes {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int b4 = SignedBytes.b(bArr[i10], bArr2[i10]);
                if (b4 != 0) {
                    return b4;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j10) {
        byte b4 = (byte) j10;
        o.j(((long) b4) == j10, "Out of range: %s", j10);
        return b4;
    }

    public static int b(byte b4, byte b10) {
        return b4 - b10;
    }
}
