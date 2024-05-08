package com.google.common.primitives;

import com.google.common.base.o;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class UnsignedInts {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                if (iArr[i10] != iArr2[i10]) {
                    return UnsignedInts.a(iArr[i10], iArr2[i10]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int a(int i10, int i11) {
        return Ints.d(c(i10), c(i11));
    }

    public static int b(int i10, int i11) {
        return (int) (f(i10) / f(i11));
    }

    public static int c(int i10) {
        return i10 ^ Integer.MIN_VALUE;
    }

    public static int d(String str, int i10) {
        o.r(str);
        long parseLong = Long.parseLong(str, i10);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 69);
        sb2.append("Input ");
        sb2.append(str);
        sb2.append(" in base ");
        sb2.append(i10);
        sb2.append(" is not in the range of an unsigned integer");
        throw new NumberFormatException(sb2.toString());
    }

    public static int e(int i10, int i11) {
        return (int) (f(i10) % f(i11));
    }

    public static long f(int i10) {
        return i10 & 4294967295L;
    }

    public static String g(int i10, int i11) {
        return Long.toString(i10 & 4294967295L, i11);
    }
}
