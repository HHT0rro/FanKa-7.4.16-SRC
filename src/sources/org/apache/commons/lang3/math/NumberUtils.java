package org.apache.commons.lang3.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(ShadowDrawableWrapper.COS_45);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int compare(byte b4, byte b10) {
        return b4 - b10;
    }

    public static int compare(int i10, int i11) {
        if (i10 == i11) {
            return 0;
        }
        return i10 < i11 ? -1 : 1;
    }

    public static int compare(long j10, long j11) {
        if (j10 == j11) {
            return 0;
        }
        return j10 < j11 ? -1 : 1;
    }

    public static int compare(short s2, short s10) {
        if (s2 == s10) {
            return 0;
        }
        return s2 < s10 ? -1 : 1;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            if (!str.trim().startsWith("--")) {
                return new BigDecimal(str);
            }
            throw new NumberFormatException(str + " is not a valid number.");
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static BigInteger createBigInteger(String str) {
        int i10;
        if (str == null) {
            return null;
        }
        boolean startsWith = str.startsWith("-");
        int i11 = 16;
        if (str.startsWith("0x", startsWith ? 1 : 0) || str.startsWith("0X", startsWith ? 1 : 0)) {
            i10 = (startsWith ? 1 : 0) + 2;
        } else if (str.startsWith("#", startsWith ? 1 : 0)) {
            i10 = (startsWith ? 1 : 0) + 1;
        } else {
            if (str.startsWith("0", startsWith ? 1 : 0)) {
                int length = str.length();
                int i12 = (startsWith ? 1 : 0) + 1;
                if (length > i12) {
                    i10 = i12;
                    i11 = 8;
                }
            }
            i10 = startsWith ? 1 : 0;
            i11 = 10;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i10), i11);
        return startsWith ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0136, code lost:
    
        if (r1 == 'l') goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Number createNumber(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00e7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00e8, code lost:
    
        if (r13 == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00ea, code lost:
    
        if (r14 != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00ec, code lost:
    
        if (r15 != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ee, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00f0, code lost:
    
        if (r7 != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00f2, code lost:
    
        if (r13 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00f4, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0114, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0130, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r3 >= r0.length) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a6, code lost:
    
        if (r0[r3] < '0') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00aa, code lost:
    
        if (r0[r3] > '9') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ac, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00af, code lost:
    
        if (r0[r3] == 'e') goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00b3, code lost:
    
        if (r0[r3] != 'E') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b8, code lost:
    
        if (r0[r3] != '.') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ba, code lost:
    
        if (r15 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bc, code lost:
    
        if (r14 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00bf, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c0, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c1, code lost:
    
        if (r7 != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c7, code lost:
    
        if (r0[r3] == 'd') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00cd, code lost:
    
        if (r0[r3] == 'D') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00d1, code lost:
    
        if (r0[r3] == 'f') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00d7, code lost:
    
        if (r0[r3] != 'F') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00d9, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00de, code lost:
    
        if (r0[r3] == 'l') goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00e4, code lost:
    
        if (r0[r3] != 'L') goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCreatable(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isCreatable(java.lang.String):boolean");
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    public static byte max(byte b4, byte b10, byte b11) {
        if (b10 > b4) {
            b4 = b10;
        }
        return b11 > b4 ? b11 : b4;
    }

    public static int max(int i10, int i11, int i12) {
        if (i11 > i10) {
            i10 = i11;
        }
        return i12 > i10 ? i12 : i10;
    }

    public static long max(long j10, long j11, long j12) {
        if (j11 > j10) {
            j10 = j11;
        }
        return j12 > j10 ? j12 : j10;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            if (jArr[i10] > j10) {
                j10 = jArr[i10];
            }
        }
        return j10;
    }

    public static short max(short s2, short s10, short s11) {
        if (s10 > s2) {
            s2 = s10;
        }
        return s11 > s2 ? s11 : s2;
    }

    public static byte min(byte b4, byte b10, byte b11) {
        if (b10 < b4) {
            b4 = b10;
        }
        return b11 < b4 ? b11 : b4;
    }

    public static int min(int i10, int i11, int i12) {
        if (i11 < i10) {
            i10 = i11;
        }
        return i12 < i10 ? i12 : i10;
    }

    public static long min(long j10, long j11, long j12) {
        if (j11 < j10) {
            j10 = j11;
        }
        return j12 < j10 ? j12 : j10;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            if (jArr[i10] < j10) {
                j10 = jArr[i10];
            }
        }
        return j10;
    }

    public static short min(short s2, short s10, short s11) {
        if (s10 < s2) {
            s2 = s10;
        }
        return s11 < s2 ? s11 : s2;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, ShadowDrawableWrapper.COS_45);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    private static void validateArray(Object obj) {
        Validate.isTrue(obj != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i10) {
        int i11 = 0;
        while (i10 < str.length()) {
            boolean z10 = str.charAt(i10) == '.';
            if (z10) {
                i11++;
            }
            if (i11 > 1) {
                return false;
            }
            if (!z10 && !Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    private static String getMantissa(String str, int i10) {
        char charAt = str.charAt(0);
        return charAt == '-' || charAt == '+' ? str.substring(1, i10) : str.substring(0, i10);
    }

    public static byte toByte(String str, byte b4) {
        if (str == null) {
            return b4;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b4;
        }
    }

    public static double toDouble(String str, double d10) {
        if (str == null) {
            return d10;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    public static float toFloat(String str, float f10) {
        if (str == null) {
            return f10;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    public static int toInt(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static long toLong(String str, long j10) {
        if (str == null) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i10, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i10, roundingMode);
    }

    public static short toShort(String str, short s2) {
        if (str == null) {
            return s2;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s2;
        }
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, ShadowDrawableWrapper.COS_45);
    }

    public static double toDouble(BigDecimal bigDecimal, double d10) {
        return bigDecimal == null ? d10 : bigDecimal.doubleValue();
    }

    public static BigDecimal toScaledBigDecimal(Float f10) {
        return toScaledBigDecimal(f10, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i10 = iArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (iArr[i11] > i10) {
                i10 = iArr[i11];
            }
        }
        return i10;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i10 = iArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (iArr[i11] < i10) {
                i10 = iArr[i11];
            }
        }
        return i10;
    }

    public static BigDecimal toScaledBigDecimal(Float f10, int i10, RoundingMode roundingMode) {
        if (f10 == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f10.floatValue()), i10, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d10) {
        return toScaledBigDecimal(d10, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d10, int i10, RoundingMode roundingMode) {
        if (d10 == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d10.doubleValue()), i10, roundingMode);
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s2 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            if (sArr[i10] > s2) {
                s2 = sArr[i10];
            }
        }
        return s2;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s2 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            if (sArr[i10] < s2) {
                s2 = sArr[i10];
            }
        }
        return s2;
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String str, int i10, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i10, roundingMode);
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b4 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            if (bArr[i10] > b4) {
                b4 = bArr[i10];
            }
        }
        return b4;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b4 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            if (bArr[i10] < b4) {
                b4 = bArr[i10];
            }
        }
        return b4;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            if (Double.isNaN(dArr[i10])) {
                return Double.NaN;
            }
            if (dArr[i10] > d10) {
                d10 = dArr[i10];
            }
        }
        return d10;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            if (Double.isNaN(dArr[i10])) {
                return Double.NaN;
            }
            if (dArr[i10] < d10) {
                d10 = dArr[i10];
            }
        }
        return d10;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (Float.isNaN(fArr[i10])) {
                return Float.NaN;
            }
            if (fArr[i10] > f10) {
                f10 = fArr[i10];
            }
        }
        return f10;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (Float.isNaN(fArr[i10])) {
                return Float.NaN;
            }
            if (fArr[i10] < f10) {
                f10 = fArr[i10];
            }
        }
        return f10;
    }

    public static double max(double d10, double d11, double d12) {
        return Math.max(Math.max(d10, d11), d12);
    }

    public static double min(double d10, double d11, double d12) {
        return Math.min(Math.min(d10, d11), d12);
    }

    public static float max(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    public static float min(float f10, float f11, float f12) {
        return Math.min(Math.min(f10, f11), f12);
    }
}
