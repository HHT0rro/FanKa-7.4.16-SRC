package jdk.internal.math;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FloatingDecimal {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BIG_DECIMAL_EXPONENT = 324;
    static final long EXP_ONE = 4607182418800017408L;
    static final int EXP_SHIFT = 52;
    static final long FRACT_HOB = 4503599627370496L;
    static final int INT_DECIMAL_DIGITS = 9;
    static final int MAX_DECIMAL_DIGITS = 15;
    static final int MAX_DECIMAL_EXPONENT = 308;
    static final int MAX_NDIGITS = 1100;
    static final int MAX_SMALL_BIN_EXP = 62;
    static final int MIN_DECIMAL_EXPONENT = -324;
    static final int MIN_SMALL_BIN_EXP = -21;
    static final int SINGLE_EXP_SHIFT = 23;
    static final int SINGLE_FRACT_HOB = 8388608;
    static final int SINGLE_MAX_DECIMAL_DIGITS = 7;
    static final int SINGLE_MAX_DECIMAL_EXPONENT = 38;
    static final int SINGLE_MAX_NDIGITS = 200;
    static final int SINGLE_MIN_DECIMAL_EXPONENT = -45;
    private static final String INFINITY_REP = "Infinity";
    private static final int INFINITY_LENGTH = INFINITY_REP.length();
    private static final String NAN_REP = "NaN";
    private static final int NAN_LENGTH = NAN_REP.length();
    private static final BinaryToASCIIConverter B2AC_POSITIVE_INFINITY = new ExceptionalBinaryToASCIIBuffer(INFINITY_REP, false);
    private static final BinaryToASCIIConverter B2AC_NEGATIVE_INFINITY = new ExceptionalBinaryToASCIIBuffer("-Infinity", true);
    private static final BinaryToASCIIConverter B2AC_NOT_A_NUMBER = new ExceptionalBinaryToASCIIBuffer(NAN_REP, false);
    private static final BinaryToASCIIConverter B2AC_POSITIVE_ZERO = new BinaryToASCIIBuffer(false, new char[]{'0'});
    private static final BinaryToASCIIConverter B2AC_NEGATIVE_ZERO = new BinaryToASCIIBuffer(true, new char[]{'0'});
    private static final ThreadLocal<BinaryToASCIIBuffer> threadLocalBinaryToASCIIBuffer = new ThreadLocal<BinaryToASCIIBuffer>() { // from class: jdk.internal.math.FloatingDecimal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public BinaryToASCIIBuffer initialValue() {
            return new BinaryToASCIIBuffer();
        }
    };
    static final ASCIIToBinaryConverter A2BC_POSITIVE_INFINITY = new PreparedASCIIToBinaryBuffer(Double.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    static final ASCIIToBinaryConverter A2BC_NEGATIVE_INFINITY = new PreparedASCIIToBinaryBuffer(Double.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    static final ASCIIToBinaryConverter A2BC_NOT_A_NUMBER = new PreparedASCIIToBinaryBuffer(Double.NaN, Float.NaN);
    static final ASCIIToBinaryConverter A2BC_POSITIVE_ZERO = new PreparedASCIIToBinaryBuffer(ShadowDrawableWrapper.COS_45, 0.0f);
    static final ASCIIToBinaryConverter A2BC_NEGATIVE_ZERO = new PreparedASCIIToBinaryBuffer(-0.0d, -0.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface ASCIIToBinaryConverter {
        double doubleValue();

        float floatValue();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface BinaryToASCIIConverter {
        void appendTo(Appendable appendable);

        boolean decimalDigitsExact();

        boolean digitsRoundedUp();

        int getDecimalExponent();

        int getDigits(char[] cArr);

        boolean isExceptional();

        boolean isNegative();

        String toJavaFormatString();
    }

    public static String toJavaFormatString(double d10) {
        return getBinaryToASCIIConverter(d10).toJavaFormatString();
    }

    public static String toJavaFormatString(float f10) {
        return getBinaryToASCIIConverter(f10).toJavaFormatString();
    }

    public static void appendTo(double d10, Appendable buf) {
        getBinaryToASCIIConverter(d10).appendTo(buf);
    }

    public static void appendTo(float f10, Appendable buf) {
        getBinaryToASCIIConverter(f10).appendTo(buf);
    }

    public static double parseDouble(String s2) throws NumberFormatException {
        return readJavaFormatString(s2).doubleValue();
    }

    public static float parseFloat(String s2) throws NumberFormatException {
        return readJavaFormatString(s2).floatValue();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class ExceptionalBinaryToASCIIBuffer implements BinaryToASCIIConverter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String image;
        private boolean isNegative;

        public ExceptionalBinaryToASCIIBuffer(String image, boolean isNegative) {
            this.image = image;
            this.isNegative = isNegative;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public String toJavaFormatString() {
            return this.image;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public void appendTo(Appendable buf) {
            if (buf instanceof StringBuilder) {
                ((StringBuilder) buf).append(this.image);
            } else if (buf instanceof StringBuffer) {
                ((StringBuffer) buf).append(this.image);
            }
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public int getDecimalExponent() {
            throw new IllegalArgumentException("Exceptional value does not have an exponent");
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public int getDigits(char[] digits) {
            throw new IllegalArgumentException("Exceptional value does not have digits");
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean isNegative() {
            return this.isNegative;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean isExceptional() {
            return true;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean digitsRoundedUp() {
            throw new IllegalArgumentException("Exceptional value is not rounded");
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean decimalDigitsExact() {
            throw new IllegalArgumentException("Exceptional value is not exact");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BinaryToASCIIBuffer implements BinaryToASCIIConverter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] buffer;
        private int decExponent;
        private boolean decimalDigitsRoundedUp;
        private final char[] digits;
        private boolean exactDecimalConversion;
        private int firstDigitIndex;
        private boolean isNegative;
        private int nDigits;
        private static int[] insignificantDigitsNumber = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19};
        private static final int[] N_5_BITS = {0, 3, 5, 7, 10, 12, 14, 17, 19, 21, 24, 26, 28, 31, 33, 35, 38, 40, 42, 45, 47, 49, 52, 54, 56, 59, 61};

        BinaryToASCIIBuffer() {
            this.buffer = new char[26];
            this.exactDecimalConversion = false;
            this.decimalDigitsRoundedUp = false;
            this.digits = new char[20];
        }

        BinaryToASCIIBuffer(boolean isNegative, char[] digits) {
            this.buffer = new char[26];
            this.exactDecimalConversion = false;
            this.decimalDigitsRoundedUp = false;
            this.isNegative = isNegative;
            this.decExponent = 0;
            this.digits = digits;
            this.firstDigitIndex = 0;
            this.nDigits = digits.length;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public String toJavaFormatString() {
            int len = getChars(this.buffer);
            return new String(this.buffer, 0, len);
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public void appendTo(Appendable buf) {
            int len = getChars(this.buffer);
            if (buf instanceof StringBuilder) {
                ((StringBuilder) buf).append(this.buffer, 0, len);
            } else if (buf instanceof StringBuffer) {
                ((StringBuffer) buf).append(this.buffer, 0, len);
            }
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public int getDecimalExponent() {
            return this.decExponent;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public int getDigits(char[] digits) {
            System.arraycopy((Object) this.digits, this.firstDigitIndex, (Object) digits, 0, this.nDigits);
            return this.nDigits;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean isNegative() {
            return this.isNegative;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean isExceptional() {
            return false;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean digitsRoundedUp() {
            return this.decimalDigitsRoundedUp;
        }

        @Override // jdk.internal.math.FloatingDecimal.BinaryToASCIIConverter
        public boolean decimalDigitsExact() {
            return this.exactDecimalConversion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSign(boolean isNegative) {
            this.isNegative = isNegative;
        }

        private void developLongDigits(int decExponent, long lvalue, int insignificantDigits) {
            if (insignificantDigits != 0) {
                long pow10 = FDBigInteger.LONG_5_POW[insignificantDigits] << insignificantDigits;
                long residue = lvalue % pow10;
                lvalue /= pow10;
                decExponent += insignificantDigits;
                if (residue >= (pow10 >> 1)) {
                    lvalue++;
                }
            }
            int digitno = this.digits.length - 1;
            if (lvalue <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                int ivalue = (int) lvalue;
                int c4 = ivalue % 10;
                int ivalue2 = ivalue / 10;
                while (c4 == 0) {
                    decExponent++;
                    c4 = ivalue2 % 10;
                    ivalue2 /= 10;
                }
                while (ivalue2 != 0) {
                    this.digits[digitno] = (char) (c4 + 48);
                    decExponent++;
                    c4 = ivalue2 % 10;
                    ivalue2 /= 10;
                    digitno--;
                }
                this.digits[digitno] = (char) (c4 + 48);
            } else {
                int c10 = (int) (lvalue % 10);
                long lvalue2 = lvalue / 10;
                while (c10 == 0) {
                    decExponent++;
                    c10 = (int) (lvalue2 % 10);
                    lvalue2 /= 10;
                }
                while (lvalue2 != 0) {
                    this.digits[digitno] = (char) (c10 + 48);
                    decExponent++;
                    c10 = (int) (lvalue2 % 10);
                    lvalue2 /= 10;
                    digitno--;
                }
                this.digits[digitno] = (char) (c10 + 48);
            }
            int c11 = decExponent + 1;
            this.decExponent = c11;
            this.firstDigitIndex = digitno;
            this.nDigits = this.digits.length - digitno;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dtoa(int binExp, long fractBits, int nSignificantBits, boolean isCompatibleFormat) {
            FDBigInteger Mval;
            boolean high;
            int ndigit;
            boolean low;
            FDBigInteger Mval2;
            long lowDigitDifference;
            boolean low2;
            int ndigit2;
            boolean low3;
            boolean low4;
            boolean high2;
            int m10;
            boolean high3;
            boolean high4;
            int m11;
            boolean low5;
            boolean z10;
            int insignificant;
            long fractBits2;
            int tailZeros = Long.numberOfTrailingZeros(fractBits);
            int nFractBits = 53 - tailZeros;
            this.decimalDigitsRoundedUp = false;
            this.exactDecimalConversion = false;
            int nTinyBits = Math.max(0, (nFractBits - binExp) - 1);
            if (binExp <= 62 && binExp >= FloatingDecimal.MIN_SMALL_BIN_EXP && nTinyBits < FDBigInteger.LONG_5_POW.length && N_5_BITS[nTinyBits] + nFractBits < 64 && nTinyBits == 0) {
                if (binExp > nSignificantBits) {
                    insignificant = insignificantDigitsForPow2((binExp - nSignificantBits) - 1);
                } else {
                    insignificant = 0;
                }
                if (binExp >= 52) {
                    fractBits2 = fractBits << (binExp - 52);
                } else {
                    fractBits2 = fractBits >>> (52 - binExp);
                }
                developLongDigits(0, fractBits2, insignificant);
                return;
            }
            int decExp = estimateDecExp(fractBits, binExp);
            int B5 = Math.max(0, -decExp);
            int B2 = B5 + nTinyBits + binExp;
            int S5 = Math.max(0, decExp);
            int S2 = S5 + nTinyBits;
            int M2 = B2 - nSignificantBits;
            long fractBits3 = fractBits >>> tailZeros;
            int B22 = B2 - (nFractBits - 1);
            int common2factor = Math.min(B22, S2);
            int B23 = B22 - common2factor;
            int S22 = S2 - common2factor;
            int M22 = M2 - common2factor;
            if (nFractBits == 1) {
                M22--;
            }
            if (M22 < 0) {
                B23 -= M22;
                S22 -= M22;
                M22 = 0;
            }
            int i10 = nFractBits + B23;
            int[] iArr = N_5_BITS;
            int Bbits = i10 + (B5 < iArr.length ? iArr[B5] : B5 * 3);
            int tenSbits = S22 + 1 + (S5 + 1 < iArr.length ? iArr[S5 + 1] : (S5 + 1) * 3);
            if (Bbits < 64 && tenSbits < 64) {
                if (Bbits < 32 && tenSbits < 32) {
                    int b4 = (((int) fractBits3) * FDBigInteger.SMALL_5_POW[B5]) << B23;
                    int s2 = FDBigInteger.SMALL_5_POW[S5] << S22;
                    int tens = s2 * 10;
                    int ndigit3 = 0;
                    int q10 = b4 / s2;
                    int b10 = (b4 % s2) * 10;
                    int tenSbits2 = (FDBigInteger.SMALL_5_POW[B5] << M22) * 10;
                    low2 = b10 < tenSbits2;
                    boolean high5 = b10 + tenSbits2 > tens;
                    if (q10 == 0 && !high5) {
                        decExp--;
                        m10 = tenSbits2;
                        high3 = high5;
                    } else {
                        m10 = tenSbits2;
                        int ndigit4 = 0 + 1;
                        high3 = high5;
                        this.digits[0] = (char) (q10 + 48);
                        ndigit3 = ndigit4;
                    }
                    if (!isCompatibleFormat || decExp < -3 || decExp >= 8) {
                        low2 = false;
                        high4 = false;
                        m11 = m10;
                    } else {
                        m11 = m10;
                        high4 = high3;
                    }
                    while (!low2 && !high4) {
                        int q11 = b10 / s2;
                        b10 = (b10 % s2) * 10;
                        int m12 = m11 * 10;
                        int tailZeros2 = tailZeros;
                        if (m12 > 0) {
                            low5 = b10 < m12;
                            z10 = b10 + m12 > tens;
                        } else {
                            low5 = true;
                            z10 = true;
                        }
                        low2 = low5;
                        high4 = z10;
                        this.digits[ndigit3] = (char) (q11 + 48);
                        m11 = m12;
                        tailZeros = tailZeros2;
                        ndigit3++;
                    }
                    boolean high6 = high4;
                    long lowDigitDifference2 = (b10 << 1) - tens;
                    this.exactDecimalConversion = b10 == 0;
                    lowDigitDifference = lowDigitDifference2;
                    ndigit2 = ndigit3;
                    high = high6;
                } else {
                    long b11 = (FDBigInteger.LONG_5_POW[B5] * fractBits3) << B23;
                    long s10 = FDBigInteger.LONG_5_POW[S5] << S22;
                    long tens2 = s10 * 10;
                    int ndigit5 = 0;
                    int q12 = (int) (b11 / s10);
                    long b12 = (b11 % s10) * 10;
                    long m13 = (FDBigInteger.LONG_5_POW[B5] << M22) * 10;
                    boolean low6 = b12 < m13;
                    boolean high7 = b12 + m13 > tens2;
                    if (q12 != 0 || high7) {
                        int ndigit6 = 0 + 1;
                        low3 = low6;
                        this.digits[0] = (char) (q12 + 48);
                        ndigit5 = ndigit6;
                    } else {
                        decExp--;
                        low3 = low6;
                    }
                    if (!isCompatibleFormat || decExp < -3 || decExp >= 8) {
                        high = false;
                        low2 = false;
                    } else {
                        high = high7;
                        low2 = low3;
                    }
                    while (!low2 && !high) {
                        int q13 = (int) (b12 / s10);
                        b12 = (b12 % s10) * 10;
                        m13 *= 10;
                        if (m13 > 0) {
                            low4 = b12 < m13;
                            high2 = b12 + m13 > tens2;
                        } else {
                            low4 = true;
                            high2 = true;
                        }
                        low2 = low4;
                        this.digits[ndigit5] = (char) (q13 + 48);
                        high = high2;
                        ndigit5++;
                    }
                    long lowDigitDifference3 = (b12 << 1) - tens2;
                    this.exactDecimalConversion = b12 == 0;
                    ndigit2 = ndigit5;
                    lowDigitDifference = lowDigitDifference3;
                }
            } else {
                FDBigInteger Sval = FDBigInteger.valueOfPow52(S5, S22);
                int shiftBias = Sval.getNormalizationBias();
                FDBigInteger Sval2 = Sval.leftShift(shiftBias);
                FDBigInteger Bval = FDBigInteger.valueOfMulPow52(fractBits3, B5, B23 + shiftBias);
                FDBigInteger Mval3 = FDBigInteger.valueOfPow52(B5 + 1, M22 + shiftBias + 1);
                FDBigInteger tenSval = FDBigInteger.valueOfPow52(S5 + 1, S22 + shiftBias + 1);
                int ndigit7 = 0;
                int q14 = Bval.quoRemIteration(Sval2);
                boolean low7 = Bval.cmp(Mval3) < 0;
                boolean high8 = tenSval.addAndCmp(Bval, Mval3) <= 0;
                if (q14 != 0 || high8) {
                    int ndigit8 = 0 + 1;
                    Mval = Mval3;
                    this.digits[0] = (char) (q14 + 48);
                    ndigit7 = ndigit8;
                } else {
                    decExp--;
                    Mval = Mval3;
                }
                if (!isCompatibleFormat || decExp < -3 || decExp >= 8) {
                    high = false;
                    ndigit = ndigit7;
                    low = false;
                    Mval2 = Mval;
                } else {
                    high = high8;
                    Mval2 = Mval;
                    boolean z11 = low7;
                    ndigit = ndigit7;
                    low = z11;
                }
                while (!low && !high) {
                    int q15 = Bval.quoRemIteration(Sval2);
                    Mval2 = Mval2.multBy10();
                    low = Bval.cmp(Mval2) < 0;
                    high = tenSval.addAndCmp(Bval, Mval2) <= 0;
                    this.digits[ndigit] = (char) (q15 + 48);
                    Sval2 = Sval2;
                    ndigit++;
                }
                if (high && low) {
                    Bval = Bval.leftShift(1);
                    lowDigitDifference = Bval.cmp(tenSval);
                } else {
                    lowDigitDifference = 0;
                }
                this.exactDecimalConversion = Bval.cmp(FDBigInteger.ZERO) == 0;
                low2 = low;
                ndigit2 = ndigit;
            }
            this.decExponent = decExp + 1;
            this.firstDigitIndex = 0;
            this.nDigits = ndigit2;
            if (high) {
                if (!low2) {
                    roundup();
                    return;
                }
                if (lowDigitDifference == 0) {
                    if ((this.digits[(0 + ndigit2) - 1] & 1) != 0) {
                        roundup();
                    }
                } else if (lowDigitDifference > 0) {
                    roundup();
                }
            }
        }

        private void roundup() {
            int i10 = (this.firstDigitIndex + this.nDigits) - 1;
            char c4 = this.digits[i10];
            if (c4 == '9') {
                while (c4 == '9' && i10 > this.firstDigitIndex) {
                    char[] cArr = this.digits;
                    cArr[i10] = '0';
                    i10--;
                    c4 = cArr[i10];
                }
                if (c4 == '9') {
                    this.decExponent++;
                    this.digits[this.firstDigitIndex] = '1';
                    return;
                }
            }
            this.digits[i10] = (char) (c4 + 1);
            this.decimalDigitsRoundedUp = true;
        }

        static int estimateDecExp(long fractBits, int binExp) {
            double d22 = Double.longBitsToDouble((fractBits & DoubleConsts.SIGNIF_BIT_MASK) | FloatingDecimal.EXP_ONE);
            double d10 = ((d22 - 1.5d) * 0.289529654d) + 0.176091259d + (binExp * 0.301029995663981d);
            long dBits = Double.doubleToRawLongBits(d10);
            int exponent = ((int) ((DoubleConsts.EXP_BIT_MASK & dBits) >> 52)) - 1023;
            boolean isNegative = (Long.MIN_VALUE & dBits) != 0;
            if (exponent >= 0 && exponent < 52) {
                long mask = DoubleConsts.SIGNIF_BIT_MASK >> exponent;
                int r10 = (int) (((DoubleConsts.SIGNIF_BIT_MASK & dBits) | FloatingDecimal.FRACT_HOB) >> (52 - exponent));
                return isNegative ? (mask & dBits) == 0 ? -r10 : (-r10) - 1 : r10;
            }
            if (exponent < 0) {
                return ((Long.MAX_VALUE & dBits) != 0 && isNegative) ? -1 : 0;
            }
            return (int) d10;
        }

        private static int insignificantDigits(int insignificant) {
            int i10 = 0;
            while (insignificant >= 10) {
                insignificant = (int) (insignificant / 10);
                i10++;
            }
            return i10;
        }

        private static int insignificantDigitsForPow2(int p22) {
            if (p22 <= 1) {
                return 0;
            }
            int[] iArr = insignificantDigitsNumber;
            if (p22 < iArr.length) {
                return iArr[p22];
            }
            return 0;
        }

        private int getChars(char[] result) {
            int i10;
            int e2;
            int i11 = 0;
            if (this.isNegative) {
                result[0] = '-';
                i11 = 1;
            }
            int i12 = this.decExponent;
            if (i12 > 0 && i12 < 8) {
                int charLength = Math.min(this.nDigits, i12);
                System.arraycopy((Object) this.digits, this.firstDigitIndex, (Object) result, i11, charLength);
                int i13 = i11 + charLength;
                int i14 = this.decExponent;
                if (charLength < i14) {
                    int charLength2 = i14 - charLength;
                    Arrays.fill(result, i13, i13 + charLength2, '0');
                    int i15 = i13 + charLength2;
                    int i16 = i15 + 1;
                    result[i15] = '.';
                    int i17 = i16 + 1;
                    result[i16] = '0';
                    return i17;
                }
                int charLength3 = i13 + 1;
                result[i13] = '.';
                int i18 = this.nDigits;
                if (charLength < i18) {
                    int t2 = i18 - charLength;
                    System.arraycopy((Object) this.digits, this.firstDigitIndex + charLength, (Object) result, charLength3, t2);
                    int i19 = t2 + charLength3;
                    return i19;
                }
                int i20 = charLength3 + 1;
                result[charLength3] = '0';
                return i20;
            }
            if (i12 <= 0 && i12 > -3) {
                int i21 = i11 + 1;
                result[i11] = '0';
                int i22 = i21 + 1;
                result[i21] = '.';
                if (i12 != 0) {
                    Arrays.fill(result, i22, i22 - i12, '0');
                    i22 -= this.decExponent;
                }
                System.arraycopy((Object) this.digits, this.firstDigitIndex, (Object) result, i22, this.nDigits);
                return i22 + this.nDigits;
            }
            int i23 = i11 + 1;
            char[] cArr = this.digits;
            int i24 = this.firstDigitIndex;
            result[i11] = cArr[i24];
            int i25 = i23 + 1;
            result[i23] = '.';
            int i26 = this.nDigits;
            if (i26 > 1) {
                System.arraycopy((Object) cArr, i24 + 1, (Object) result, i25, i26 - 1);
                i10 = i25 + (this.nDigits - 1);
            } else {
                result[i25] = '0';
                i10 = i25 + 1;
            }
            int i27 = i10 + 1;
            result[i10] = 'E';
            int e10 = this.decExponent;
            if (e10 <= 0) {
                result[i27] = '-';
                e2 = (-e10) + 1;
                i27++;
            } else {
                e2 = e10 - 1;
            }
            if (e2 <= 9) {
                int i28 = i27 + 1;
                result[i27] = (char) (e2 + 48);
                return i28;
            }
            if (e2 <= 99) {
                int i29 = i27 + 1;
                result[i27] = (char) ((e2 / 10) + 48);
                int i30 = i29 + 1;
                result[i29] = (char) ((e2 % 10) + 48);
                return i30;
            }
            int i31 = i27 + 1;
            result[i27] = (char) ((e2 / 100) + 48);
            int e11 = e2 % 100;
            int i32 = i31 + 1;
            result[i31] = (char) ((e11 / 10) + 48);
            int i33 = i32 + 1;
            result[i32] = (char) ((e11 % 10) + 48);
            return i33;
        }
    }

    private static BinaryToASCIIBuffer getBinaryToASCIIBuffer() {
        return threadLocalBinaryToASCIIBuffer.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PreparedASCIIToBinaryBuffer implements ASCIIToBinaryConverter {
        private final double doubleVal;
        private final float floatVal;

        public PreparedASCIIToBinaryBuffer(double doubleVal, float floatVal) {
            this.doubleVal = doubleVal;
            this.floatVal = floatVal;
        }

        @Override // jdk.internal.math.FloatingDecimal.ASCIIToBinaryConverter
        public double doubleValue() {
            return this.doubleVal;
        }

        @Override // jdk.internal.math.FloatingDecimal.ASCIIToBinaryConverter
        public float floatValue() {
            return this.floatVal;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ASCIIToBinaryBuffer implements ASCIIToBinaryConverter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MAX_SMALL_TEN;
        private static final int SINGLE_MAX_SMALL_TEN;
        int decExponent;
        char[] digits;
        boolean isNegative;
        int nDigits;
        private static final double[] SMALL_10_POW = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
        private static final float[] SINGLE_SMALL_10_POW = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
        private static final double[] BIG_10_POW = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
        private static final double[] TINY_10_POW = {1.0E-16d, 1.0E-32d, 1.0E-64d, 1.0E-128d, 1.0E-256d};

        static {
            MAX_SMALL_TEN = r0.length - 1;
            SINGLE_MAX_SMALL_TEN = r1.length - 1;
        }

        ASCIIToBinaryBuffer(boolean negSign, int decExponent, char[] digits, int n10) {
            this.isNegative = negSign;
            this.decExponent = decExponent;
            this.digits = digits;
            this.nDigits = n10;
        }

        @Override // jdk.internal.math.FloatingDecimal.ASCIIToBinaryConverter
        public double doubleValue() {
            double dValue;
            long bigBbits;
            int hulpbias;
            int prevD2;
            FDBigInteger bigD0;
            boolean overvalue;
            FDBigInteger diff;
            int Ulp2;
            int bigIntExp = Math.min(this.nDigits, 16);
            int iValue = this.digits[0] - '0';
            int B2 = Math.min(bigIntExp, 9);
            for (int i10 = 1; i10 < B2; i10++) {
                iValue = ((iValue * 10) + this.digits[i10]) - 48;
            }
            long lValue = iValue;
            long lValue2 = lValue;
            for (int i11 = B2; i11 < bigIntExp; i11++) {
                lValue2 = (10 * lValue2) + (this.digits[i11] - '0');
            }
            double dValue2 = lValue2;
            int i12 = this.decExponent;
            int exp = i12 - bigIntExp;
            if (this.nDigits <= 15) {
                if (exp != 0 && dValue2 != ShadowDrawableWrapper.COS_45) {
                    if (exp >= 0) {
                        int i13 = MAX_SMALL_TEN;
                        if (exp <= i13) {
                            double rValue = SMALL_10_POW[exp] * dValue2;
                            return this.isNegative ? -rValue : rValue;
                        }
                        int slop = 15 - bigIntExp;
                        if (exp <= i13 + slop) {
                            double[] dArr = SMALL_10_POW;
                            double rValue2 = dArr[exp - slop] * dValue2 * dArr[slop];
                            return this.isNegative ? -rValue2 : rValue2;
                        }
                    } else {
                        int iValue2 = MAX_SMALL_TEN;
                        if (exp >= (-iValue2)) {
                            double rValue3 = dValue2 / SMALL_10_POW[-exp];
                            return this.isNegative ? -rValue3 : rValue3;
                        }
                    }
                }
                return this.isNegative ? -dValue2 : dValue2;
            }
            if (exp > 0) {
                if (i12 > 309) {
                    return this.isNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                }
                if ((exp & 15) != 0) {
                    dValue2 *= SMALL_10_POW[exp & 15];
                }
                int i14 = exp >> 4;
                if (i14 == 0) {
                    dValue = dValue2;
                } else {
                    int j10 = 0;
                    for (int exp2 = i14; exp2 > 1; exp2 >>= 1) {
                        if ((exp2 & 1) != 0) {
                            dValue2 *= BIG_10_POW[j10];
                        }
                        j10++;
                    }
                    double[] dArr2 = BIG_10_POW;
                    double t2 = dArr2[j10] * dValue2;
                    if (Double.isInfinite(t2)) {
                        if (Double.isInfinite((dValue2 / 2.0d) * dArr2[j10])) {
                            return this.isNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                        }
                        t2 = Double.MAX_VALUE;
                    }
                    dValue = t2;
                }
            } else if (exp >= 0) {
                dValue = dValue2;
            } else {
                int exp3 = -exp;
                if (i12 < -325) {
                    if (this.isNegative) {
                        return -0.0d;
                    }
                    return ShadowDrawableWrapper.COS_45;
                }
                if ((exp3 & 15) != 0) {
                    dValue2 /= SMALL_10_POW[exp3 & 15];
                }
                int i15 = exp3 >> 4;
                if (i15 == 0) {
                    dValue = dValue2;
                } else {
                    int j11 = 0;
                    for (int exp4 = i15; exp4 > 1; exp4 >>= 1) {
                        if ((exp4 & 1) != 0) {
                            dValue2 *= TINY_10_POW[j11];
                        }
                        j11++;
                    }
                    double d10 = TINY_10_POW[j11];
                    double t10 = dValue2 * d10;
                    if (t10 == ShadowDrawableWrapper.COS_45) {
                        if (2.0d * dValue2 * d10 == ShadowDrawableWrapper.COS_45) {
                            if (this.isNegative) {
                                return -0.0d;
                            }
                            return ShadowDrawableWrapper.COS_45;
                        }
                        t10 = Double.MIN_VALUE;
                    }
                    dValue = t10;
                }
            }
            if (this.nDigits > 1100) {
                this.nDigits = 1101;
                this.digits[1100] = '1';
            }
            FDBigInteger bigD02 = new FDBigInteger(lValue2, this.digits, bigIntExp, this.nDigits);
            int bigIntNBits = this.decExponent - this.nDigits;
            long ieeeBits = Double.doubleToRawLongBits(dValue);
            int B5 = Math.max(0, -bigIntNBits);
            int common2 = Math.max(0, bigIntNBits);
            FDBigInteger bigD03 = bigD02.multByPow52(common2, 0);
            bigD03.makeImmutable();
            FDBigInteger bigD = null;
            int prevD22 = 0;
            while (true) {
                int iDigits = B2;
                long lValue3 = lValue2;
                int binexp = (int) (ieeeBits >>> 52);
                long bigBbits2 = DoubleConsts.SIGNIF_BIT_MASK & ieeeBits;
                if (binexp > 0) {
                    bigBbits = bigBbits2 | FloatingDecimal.FRACT_HOB;
                } else {
                    int leadingZeros = Long.numberOfLeadingZeros(bigBbits2);
                    int shift = leadingZeros - 11;
                    bigBbits = bigBbits2 << shift;
                    binexp = 1 - shift;
                }
                int leadingZeros2 = bigIntExp;
                int binexp2 = binexp - 1023;
                int lowOrderZeros = Long.numberOfTrailingZeros(bigBbits);
                long bigBbits3 = bigBbits >>> lowOrderZeros;
                int bigIntExp2 = (binexp2 - 52) + lowOrderZeros;
                int exp5 = bigIntNBits;
                int exp6 = 53 - lowOrderZeros;
                int B22 = B5;
                int D2 = common2;
                if (bigIntExp2 >= 0) {
                    B22 += bigIntExp2;
                } else {
                    D2 -= bigIntExp2;
                }
                int Ulp22 = B22;
                int D5 = common2;
                if (binexp2 <= -1023) {
                    hulpbias = binexp2 + lowOrderZeros + 1023;
                } else {
                    hulpbias = lowOrderZeros + 1;
                }
                int binexp3 = B22 + hulpbias;
                double dValue3 = dValue;
                int D22 = D2 + hulpbias;
                int hulpbias2 = Math.min(D22, Ulp22);
                int common22 = Math.min(binexp3, hulpbias2);
                int D23 = D22 - common22;
                int Ulp23 = Ulp22 - common22;
                FDBigInteger bigB = FDBigInteger.valueOfMulPow52(bigBbits3, B5, binexp3 - common22);
                if (bigD == null || prevD22 != D23) {
                    bigD = bigD03.leftShift(D23);
                    prevD22 = D23;
                }
                int cmpResult = bigB.cmp(bigD);
                if (cmpResult > 0) {
                    overvalue = true;
                    prevD2 = prevD22;
                    diff = bigB.leftInplaceSub(bigD);
                    bigD0 = bigD03;
                    if (exp6 == 1 && bigIntExp2 > -1022) {
                        int Ulp24 = Ulp23 - 1;
                        if (Ulp24 < 0) {
                            diff = diff.leftShift(1);
                            Ulp2 = 0;
                        } else {
                            Ulp2 = Ulp24;
                        }
                    }
                    Ulp2 = Ulp23;
                } else {
                    prevD2 = prevD22;
                    bigD0 = bigD03;
                    if (cmpResult >= 0) {
                        break;
                    }
                    overvalue = false;
                    diff = bigD.rightInplaceSub(bigB);
                    Ulp2 = Ulp23;
                }
                int cmpResult2 = diff.cmpPow52(B5, Ulp2);
                if (cmpResult2 < 0) {
                    break;
                }
                if (cmpResult2 != 0) {
                    ieeeBits += overvalue ? -1L : 1L;
                    if (ieeeBits == 0 || ieeeBits == DoubleConsts.EXP_BIT_MASK) {
                        break;
                    }
                    bigIntExp = leadingZeros2;
                    B2 = iDigits;
                    lValue2 = lValue3;
                    bigIntNBits = exp5;
                    common2 = D5;
                    dValue = dValue3;
                    prevD22 = prevD2;
                    bigD03 = bigD0;
                } else if ((ieeeBits & 1) != 0) {
                    ieeeBits += overvalue ? -1L : 1L;
                }
            }
            if (this.isNegative) {
                ieeeBits |= Long.MIN_VALUE;
            }
            return Double.longBitsToDouble(ieeeBits);
        }

        @Override // jdk.internal.math.FloatingDecimal.ASCIIToBinaryConverter
        public float floatValue() {
            int i10;
            double dValue;
            int bigBbits;
            int hulpbias;
            boolean overvalue;
            FDBigInteger diff;
            int bigIntNBits = Math.min(this.nDigits, 8);
            int iValue = this.digits[0] - '0';
            for (int i11 = 1; i11 < bigIntNBits; i11++) {
                iValue = ((iValue * 10) + this.digits[i11]) - 48;
            }
            float fValue = iValue;
            int i12 = this.decExponent;
            int exp = i12 - bigIntNBits;
            int i13 = this.nDigits;
            if (i13 <= 7) {
                if (exp == 0 || fValue == 0.0f) {
                    return this.isNegative ? -fValue : fValue;
                }
                if (exp >= 0) {
                    int i14 = SINGLE_MAX_SMALL_TEN;
                    if (exp <= i14) {
                        float fValue2 = fValue * SINGLE_SMALL_10_POW[exp];
                        return this.isNegative ? -fValue2 : fValue2;
                    }
                    int slop = 7 - bigIntNBits;
                    if (exp <= i14 + slop) {
                        float[] fArr = SINGLE_SMALL_10_POW;
                        float fValue3 = fValue * fArr[slop] * fArr[exp - slop];
                        return this.isNegative ? -fValue3 : fValue3;
                    }
                } else if (exp >= (-SINGLE_MAX_SMALL_TEN)) {
                    float fValue4 = fValue / SINGLE_SMALL_10_POW[-exp];
                    return this.isNegative ? -fValue4 : fValue4;
                }
            } else if (i12 >= i13 && i13 + i12 <= 15) {
                long lValue = iValue;
                int i15 = bigIntNBits;
                while (true) {
                    i10 = this.nDigits;
                    if (i15 >= i10) {
                        break;
                    }
                    lValue = (10 * lValue) + (this.digits[i15] - '0');
                    i15++;
                }
                float fValue5 = (float) (lValue * SMALL_10_POW[this.decExponent - i10]);
                return this.isNegative ? -fValue5 : fValue5;
            }
            double dValue2 = fValue;
            if (exp > 0) {
                if (i12 > 39) {
                    return this.isNegative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
                }
                if ((exp & 15) != 0) {
                    dValue2 *= SMALL_10_POW[exp & 15];
                }
                int i16 = exp >> 4;
                if (i16 == 0) {
                    dValue = dValue2;
                } else {
                    int j10 = 0;
                    for (int exp2 = i16; exp2 > 0; exp2 >>= 1) {
                        if ((exp2 & 1) != 0) {
                            dValue2 *= BIG_10_POW[j10];
                        }
                        j10++;
                    }
                    dValue = dValue2;
                }
            } else if (exp >= 0) {
                dValue = dValue2;
            } else {
                int exp3 = -exp;
                if (i12 < -46) {
                    return this.isNegative ? -0.0f : 0.0f;
                }
                if ((exp3 & 15) != 0) {
                    dValue2 /= SMALL_10_POW[exp3 & 15];
                }
                int i17 = exp3 >> 4;
                if (i17 == 0) {
                    dValue = dValue2;
                } else {
                    int j11 = 0;
                    for (int exp4 = i17; exp4 > 0; exp4 >>= 1) {
                        if ((exp4 & 1) != 0) {
                            dValue2 *= TINY_10_POW[j11];
                        }
                        j11++;
                    }
                    dValue = dValue2;
                }
            }
            float fValue6 = Math.max(Float.MIN_VALUE, Math.min(Float.MAX_VALUE, (float) dValue));
            if (this.nDigits > 200) {
                this.nDigits = 201;
                this.digits[200] = '1';
            }
            FDBigInteger bigD0 = new FDBigInteger(iValue, this.digits, bigIntNBits, this.nDigits);
            int exp5 = this.decExponent - this.nDigits;
            int ieeeBits = Float.floatToRawIntBits(fValue6);
            int B5 = Math.max(0, -exp5);
            int D2 = Math.max(0, exp5);
            FDBigInteger bigD02 = bigD0.multByPow52(D2, 0);
            bigD02.makeImmutable();
            FDBigInteger bigD = null;
            int prevD2 = 0;
            while (true) {
                int binexp = ieeeBits >>> 23;
                int bigBbits2 = 8388607 & ieeeBits;
                if (binexp > 0) {
                    bigBbits = bigBbits2 | 8388608;
                } else {
                    int leadingZeros = Integer.numberOfLeadingZeros(bigBbits2);
                    int shift = leadingZeros - 8;
                    bigBbits = bigBbits2 << shift;
                    binexp = 1 - shift;
                }
                int binexp2 = binexp - 127;
                int lowOrderZeros = Integer.numberOfTrailingZeros(bigBbits);
                int bigBbits3 = bigBbits >>> lowOrderZeros;
                int bigIntExp = (binexp2 - 23) + lowOrderZeros;
                int kDigits = bigIntNBits;
                int kDigits2 = 24 - lowOrderZeros;
                int B2 = B5;
                int D22 = D2;
                if (bigIntExp >= 0) {
                    B2 += bigIntExp;
                } else {
                    D22 -= bigIntExp;
                }
                int Ulp2 = B2;
                int iValue2 = iValue;
                if (binexp2 <= -127) {
                    hulpbias = binexp2 + lowOrderZeros + 127;
                } else {
                    hulpbias = lowOrderZeros + 1;
                }
                int exp6 = exp5;
                int exp7 = B2 + hulpbias;
                int B22 = D2;
                int D5 = D22 + hulpbias;
                int common2 = Math.min(exp7, Math.min(D5, Ulp2));
                int D23 = D5 - common2;
                int Ulp22 = Ulp2 - common2;
                double dValue3 = dValue;
                FDBigInteger bigB = FDBigInteger.valueOfMulPow52(bigBbits3, B5, exp7 - common2);
                if (bigD == null || prevD2 != D23) {
                    bigD = bigD02.leftShift(D23);
                    prevD2 = D23;
                }
                int cmpResult = bigB.cmp(bigD);
                FDBigInteger bigD03 = bigD02;
                int i18 = 1;
                if (cmpResult > 0) {
                    overvalue = true;
                    diff = bigB.leftInplaceSub(bigD);
                    if (kDigits2 == 1) {
                        if (bigIntExp <= -126) {
                            i18 = 1;
                        } else {
                            Ulp22--;
                            if (Ulp22 >= 0) {
                                i18 = 1;
                            } else {
                                Ulp22 = 0;
                                i18 = 1;
                                diff = diff.leftShift(1);
                            }
                        }
                    }
                } else {
                    if (cmpResult >= 0) {
                        break;
                    }
                    overvalue = false;
                    diff = bigD.rightInplaceSub(bigB);
                }
                int cmpResult2 = diff.cmpPow52(B5, Ulp22);
                if (cmpResult2 < 0) {
                    break;
                }
                if (cmpResult2 == 0) {
                    if ((ieeeBits & 1) != 0) {
                        if (overvalue) {
                            i18 = -1;
                        }
                        ieeeBits += i18;
                    }
                } else {
                    if (overvalue) {
                        i18 = -1;
                    }
                    ieeeBits += i18;
                    if (ieeeBits == 0 || ieeeBits == 2139095040) {
                        break;
                    }
                    bigIntNBits = kDigits;
                    exp5 = exp6;
                    D2 = B22;
                    iValue = iValue2;
                    dValue = dValue3;
                    bigD02 = bigD03;
                }
            }
            if (this.isNegative) {
                ieeeBits |= Integer.MIN_VALUE;
            }
            return Float.intBitsToFloat(ieeeBits);
        }
    }

    public static BinaryToASCIIConverter getBinaryToASCIIConverter(double d10) {
        return getBinaryToASCIIConverter(d10, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BinaryToASCIIConverter getBinaryToASCIIConverter(double d10, boolean isCompatibleFormat) {
        int nSignificantBits;
        long fractBits;
        long dBits = Double.doubleToRawLongBits(d10);
        boolean isNegative = (Long.MIN_VALUE & dBits) != 0;
        long fractBits2 = DoubleConsts.SIGNIF_BIT_MASK & dBits;
        int binExp = (int) ((DoubleConsts.EXP_BIT_MASK & dBits) >> 52);
        if (binExp == 2047) {
            if (fractBits2 == 0) {
                return isNegative ? B2AC_NEGATIVE_INFINITY : B2AC_POSITIVE_INFINITY;
            }
            return B2AC_NOT_A_NUMBER;
        }
        if (binExp != 0) {
            nSignificantBits = 53;
            fractBits = fractBits2 | FRACT_HOB;
        } else {
            if (fractBits2 == 0) {
                return isNegative ? B2AC_NEGATIVE_ZERO : B2AC_POSITIVE_ZERO;
            }
            int leadingZeros = Long.numberOfLeadingZeros(fractBits2);
            int shift = leadingZeros - 11;
            binExp = 1 - shift;
            int nSignificantBits2 = 64 - leadingZeros;
            nSignificantBits = nSignificantBits2;
            fractBits = fractBits2 << shift;
        }
        BinaryToASCIIBuffer buf = getBinaryToASCIIBuffer();
        buf.setSign(isNegative);
        buf.dtoa(binExp - 1023, fractBits, nSignificantBits, isCompatibleFormat);
        return buf;
    }

    private static BinaryToASCIIConverter getBinaryToASCIIConverter(float f10) {
        int fractBits;
        int nSignificantBits;
        int fBits = Float.floatToRawIntBits(f10);
        boolean isNegative = (Integer.MIN_VALUE & fBits) != 0;
        int fractBits2 = 8388607 & fBits;
        int binExp = (2139095040 & fBits) >> 23;
        if (binExp == 255) {
            if (fractBits2 == 0) {
                return isNegative ? B2AC_NEGATIVE_INFINITY : B2AC_POSITIVE_INFINITY;
            }
            return B2AC_NOT_A_NUMBER;
        }
        if (binExp == 0) {
            if (fractBits2 == 0) {
                return isNegative ? B2AC_NEGATIVE_ZERO : B2AC_POSITIVE_ZERO;
            }
            int leadingZeros = Integer.numberOfLeadingZeros(fractBits2);
            int shift = leadingZeros - 8;
            fractBits = fractBits2 << shift;
            binExp = 1 - shift;
            int nSignificantBits2 = 32 - leadingZeros;
            nSignificantBits = nSignificantBits2;
        } else {
            fractBits = fractBits2 | 8388608;
            nSignificantBits = 24;
        }
        BinaryToASCIIBuffer buf = getBinaryToASCIIBuffer();
        buf.setSign(isNegative);
        buf.dtoa(binExp - 127, fractBits << 29, nSignificantBits, true);
        return buf;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ed A[Catch: StringIndexOutOfBoundsException -> 0x01ad, TRY_ENTER, TryCatch #3 {StringIndexOutOfBoundsException -> 0x01ad, blocks: (B:13:0x001a, B:50:0x0070, B:103:0x00ed, B:132:0x0101), top: B:12:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a3 A[Catch: StringIndexOutOfBoundsException -> 0x01a9, TRY_LEAVE, TryCatch #0 {StringIndexOutOfBoundsException -> 0x01a9, blocks: (B:113:0x0174, B:115:0x017c, B:117:0x0184, B:119:0x018c, B:126:0x019d, B:128:0x01a0, B:130:0x01a3), top: B:112:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x009e A[Catch: StringIndexOutOfBoundsException -> 0x01b9, TryCatch #1 {StringIndexOutOfBoundsException -> 0x01b9, blocks: (B:6:0x0007, B:8:0x000d, B:17:0x0024, B:19:0x0028, B:21:0x0030, B:30:0x003b, B:32:0x0041, B:35:0x004b, B:37:0x004e, B:42:0x0059, B:44:0x005d, B:48:0x006b, B:54:0x007d, B:56:0x0084, B:58:0x0091, B:63:0x008e, B:67:0x0094, B:68:0x0099, B:73:0x009e, B:76:0x00aa, B:78:0x00cc, B:80:0x00b6, B:87:0x00c9, B:91:0x00cf, B:92:0x00d4, B:141:0x011f, B:175:0x01b1, B:176:0x01b8), top: B:5:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00dd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static jdk.internal.math.FloatingDecimal.ASCIIToBinaryConverter readJavaFormatString(java.lang.String r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: jdk.internal.math.FloatingDecimal.readJavaFormatString(java.lang.String):jdk.internal.math.FloatingDecimal$ASCIIToBinaryConverter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HexFloatPattern {
        private static final Pattern VALUE = Pattern.compile("([-+])?0[xX](((\\p{XDigit}+)\\.?)|((\\p{XDigit}*)\\.(\\p{XDigit}+)))[pP]([-+])?(\\p{Digit}+)[fFdD]?");

        private HexFloatPattern() {
        }
    }

    static ASCIIToBinaryConverter parseHexString(String s2) {
        int leftDigits;
        String significandString;
        int exponentAdjust;
        long significand;
        int nextShift;
        long significand2;
        boolean sticky;
        long significand3;
        double longBitsToDouble;
        Matcher m10 = HexFloatPattern.VALUE.matcher(s2);
        boolean validInput = m10.matches();
        if (!validInput) {
            throw new NumberFormatException("For input string: \"" + s2 + "\"");
        }
        String group1 = m10.group(1);
        boolean isNegative = group1 != null && group1.equals("-");
        int rightDigits = 0;
        String group4 = m10.group(4);
        if (group4 != null) {
            significandString = stripLeadingZeros(group4);
            leftDigits = significandString.length();
        } else {
            String group6 = stripLeadingZeros(m10.group(6));
            leftDigits = group6.length();
            String group7 = m10.group(7);
            rightDigits = group7.length();
            significandString = (group6 == null ? "" : group6) + group7;
        }
        String significandString2 = stripLeadingZeros(significandString);
        int signifLength = significandString2.length();
        if (leftDigits >= 1) {
            exponentAdjust = (leftDigits - 1) * 4;
        } else {
            int exponentAdjust2 = rightDigits - signifLength;
            exponentAdjust = (exponentAdjust2 + 1) * (-4);
        }
        if (signifLength == 0) {
            return isNegative ? A2BC_NEGATIVE_ZERO : A2BC_POSITIVE_ZERO;
        }
        String group8 = m10.group(8);
        boolean positiveExponent = group8 == null || group8.equals(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        try {
            long unsignedRawExponent = Integer.parseInt(m10.group(9));
            long rawExponent = (positiveExponent ? 1L : -1L) * unsignedRawExponent;
            long exponent = rawExponent + exponentAdjust;
            boolean round = false;
            boolean sticky2 = false;
            long leadingDigit = getHexDigit(significandString2, 0);
            if (leadingDigit == 1) {
                significand = 0 | (leadingDigit << 52);
                nextShift = 48;
            } else if (leadingDigit <= 3) {
                significand = 0 | (leadingDigit << 51);
                nextShift = 47;
                exponent++;
            } else if (leadingDigit <= 7) {
                significand = 0 | (leadingDigit << 50);
                nextShift = 46;
                exponent += 2;
            } else {
                if (leadingDigit > 15) {
                    throw new AssertionError((Object) "Result from digit conversion too large!");
                }
                significand = 0 | (leadingDigit << 49);
                nextShift = 45;
                exponent += 3;
            }
            int i10 = 1;
            while (i10 < signifLength && nextShift >= 0) {
                significand |= getHexDigit(significandString2, i10) << nextShift;
                nextShift -= 4;
                i10++;
                validInput = validInput;
                group1 = group1;
            }
            if (i10 < signifLength) {
                long currentDigit = getHexDigit(significandString2, i10);
                switch (nextShift) {
                    case -4:
                        boolean round2 = (currentDigit & 8) != 0;
                        sticky2 = (currentDigit & 7) != 0;
                        round = round2;
                        break;
                    case -3:
                        long significand4 = significand | ((currentDigit & 8) >> 3);
                        boolean round3 = (currentDigit & 4) != 0;
                        sticky2 = (currentDigit & 3) != 0;
                        round = round3;
                        significand = significand4;
                        break;
                    case -2:
                        long significand5 = significand | ((currentDigit & 12) >> 2);
                        boolean round4 = (currentDigit & 2) != 0;
                        sticky2 = (currentDigit & 1) != 0;
                        round = round4;
                        significand = significand5;
                        break;
                    case -1:
                        long significand6 = significand | ((currentDigit & 14) >> 1);
                        boolean round5 = (currentDigit & 1) != 0;
                        round = round5;
                        significand = significand6;
                        break;
                    default:
                        throw new AssertionError((Object) "Unexpected shift distance remainder.");
                }
                i10++;
                while (i10 < signifLength && !sticky2) {
                    sticky2 = sticky2 || ((long) getHexDigit(significandString2, i10)) != 0;
                    i10++;
                }
            }
            int floatBits = isNegative ? Integer.MIN_VALUE : 0;
            if (exponent >= -126) {
                if (exponent > 127) {
                    floatBits |= FloatConsts.EXP_BIT_MASK;
                } else {
                    boolean floatSticky = (significand & ((1 << 28) - 1)) != 0 || round || sticky2;
                    int iValue = (int) (significand >>> 28);
                    if ((iValue & 3) != 1 || floatSticky) {
                        iValue++;
                    }
                    floatBits |= ((((int) exponent) + 126) << 23) + (iValue >> 1);
                }
            } else if (exponent >= -150) {
                int threshShift = (int) ((-98) - exponent);
                boolean floatSticky2 = (significand & ((1 << threshShift) - 1)) != 0 || round || sticky2;
                int iValue2 = (int) (significand >>> threshShift);
                if ((iValue2 & 3) != 1 || floatSticky2) {
                    iValue2++;
                }
                floatBits |= iValue2 >> 1;
            }
            float fValue = Float.intBitsToFloat(floatBits);
            if (exponent > 1023) {
                return isNegative ? A2BC_NEGATIVE_INFINITY : A2BC_POSITIVE_INFINITY;
            }
            if (exponent <= 1023 && exponent >= -1022) {
                significand3 = (((1023 + exponent) << 52) & DoubleConsts.EXP_BIT_MASK) | (significand & DoubleConsts.SIGNIF_BIT_MASK);
                sticky = sticky2;
                significand2 = 0;
            } else {
                if (exponent < -1075) {
                    return isNegative ? A2BC_NEGATIVE_ZERO : A2BC_POSITIVE_ZERO;
                }
                boolean sticky3 = sticky2 || round;
                int bitsDiscarded = 53 - ((((int) exponent) + DownloadErrorCode.ERROR_BAD_URL) + 1);
                round = (significand & (1 << (bitsDiscarded + (-1)))) != 0;
                if (bitsDiscarded > 1) {
                    long mask = ~((-1) << (bitsDiscarded - 1));
                    sticky3 = sticky3 || (significand & mask) != 0;
                }
                long j10 = (significand >> bitsDiscarded) & DoubleConsts.SIGNIF_BIT_MASK;
                significand2 = 0;
                long significand7 = j10 | 0;
                sticky = sticky3;
                significand3 = significand7;
            }
            boolean leastZero = (significand3 & 1) == significand2;
            if ((leastZero && round && sticky) || (!leastZero && round)) {
                significand3++;
            }
            if (isNegative) {
                longBitsToDouble = Double.longBitsToDouble(significand3 | Long.MIN_VALUE);
            } else {
                longBitsToDouble = Double.longBitsToDouble(significand3);
            }
            double value = longBitsToDouble;
            return new PreparedASCIIToBinaryBuffer(value, fValue);
        } catch (NumberFormatException e2) {
            return isNegative ? positiveExponent ? A2BC_NEGATIVE_INFINITY : A2BC_NEGATIVE_ZERO : positiveExponent ? A2BC_POSITIVE_INFINITY : A2BC_POSITIVE_ZERO;
        }
    }

    static String stripLeadingZeros(String s2) {
        if (!s2.isEmpty() && s2.charAt(0) == '0') {
            for (int i10 = 1; i10 < s2.length(); i10++) {
                if (s2.charAt(i10) != '0') {
                    return s2.substring(i10);
                }
            }
            return "";
        }
        return s2;
    }

    static int getHexDigit(String s2, int position) {
        int value = Character.digit(s2.charAt(position), 16);
        if (value <= -1 || value >= 16) {
            throw new AssertionError((Object) ("Unexpected failure of digit conversion of " + s2.charAt(position)));
        }
        return value;
    }
}
