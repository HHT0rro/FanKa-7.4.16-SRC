package sun.util.calendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CalendarUtils {
    public static final boolean isGregorianLeapYear(int gregorianYear) {
        return gregorianYear % 4 == 0 && (gregorianYear % 100 != 0 || gregorianYear % 400 == 0);
    }

    public static final boolean isJulianLeapYear(int normalizedJulianYear) {
        return normalizedJulianYear % 4 == 0;
    }

    public static final long floorDivide(long n10, long d10) {
        return n10 >= 0 ? n10 / d10 : ((n10 + 1) / d10) - 1;
    }

    public static final int floorDivide(int n10, int d10) {
        return n10 >= 0 ? n10 / d10 : ((n10 + 1) / d10) - 1;
    }

    public static final int floorDivide(int n10, int d10, int[] r10) {
        if (n10 >= 0) {
            r10[0] = n10 % d10;
            return n10 / d10;
        }
        int q10 = ((n10 + 1) / d10) - 1;
        r10[0] = n10 - (q10 * d10);
        return q10;
    }

    public static final int floorDivide(long n10, int d10, int[] r10) {
        if (n10 >= 0) {
            r10[0] = (int) (n10 % d10);
            return (int) (n10 / d10);
        }
        int q10 = (int) (((n10 + 1) / d10) - 1);
        r10[0] = (int) (n10 - (q10 * d10));
        return q10;
    }

    public static final long mod(long x10, long y10) {
        return x10 - (floorDivide(x10, y10) * y10);
    }

    public static final int mod(int x10, int y10) {
        return x10 - (floorDivide(x10, y10) * y10);
    }

    public static final int amod(int x10, int y10) {
        int z10 = mod(x10, y10);
        return z10 == 0 ? y10 : z10;
    }

    public static final long amod(long x10, long y10) {
        long z10 = mod(x10, y10);
        return z10 == 0 ? y10 : z10;
    }

    public static final StringBuilder sprintf0d(StringBuilder sb2, int value, int width) {
        long d10 = value;
        if (d10 < 0) {
            sb2.append('-');
            d10 = -d10;
            width--;
        }
        int n10 = 10;
        for (int i10 = 2; i10 < width; i10++) {
            n10 *= 10;
        }
        for (int i11 = 1; i11 < width && d10 < n10; i11++) {
            sb2.append('0');
            n10 /= 10;
        }
        sb2.append(d10);
        return sb2;
    }

    public static final StringBuffer sprintf0d(StringBuffer sb2, int value, int width) {
        long d10 = value;
        if (d10 < 0) {
            sb2.append('-');
            d10 = -d10;
            width--;
        }
        int n10 = 10;
        for (int i10 = 2; i10 < width; i10++) {
            n10 *= 10;
        }
        for (int i11 = 1; i11 < width && d10 < n10; i11++) {
            sb2.append('0');
            n10 /= 10;
        }
        sb2.append(d10);
        return sb2;
    }
}
