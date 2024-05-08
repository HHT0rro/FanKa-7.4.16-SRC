package java.math;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.logging.nano.MetricsProto;
import com.baidu.mobads.sdk.internal.ck;
import com.huawei.flexiblelayout.n;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.zip.ZipUtils;
import jdk.internal.math.DoubleConsts;
import okhttp3.internal.connection.RealConnection;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BigDecimal extends Number implements Comparable<BigDecimal> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile BigInteger[] BIG_TEN_POWERS_TABLE = null;
    private static final int BIG_TEN_POWERS_TABLE_INITLEN;
    private static final int BIG_TEN_POWERS_TABLE_MAX;
    private static final long DIV_NUM_BASE = 4294967296L;
    private static final double[] DOUBLE_10_POW;
    private static final float[] FLOAT_10_POW;
    private static final long HALF_LONG_MAX_VALUE = 4611686018427387903L;
    private static final long HALF_LONG_MIN_VALUE = -4611686018427387904L;
    static final long INFLATED = Long.MIN_VALUE;
    private static final long[][] LONGLONG_TEN_POWERS_TABLE;
    private static final long[] LONG_TEN_POWERS_TABLE;
    private static final int MAX_COMPACT_DIGITS = 18;
    public static final BigDecimal ONE;
    private static final BigDecimal ONE_HALF;
    private static final BigDecimal ONE_TENTH;

    @Deprecated(since = "9")
    public static final int ROUND_CEILING = 2;

    @Deprecated(since = "9")
    public static final int ROUND_DOWN = 1;

    @Deprecated(since = "9")
    public static final int ROUND_FLOOR = 3;

    @Deprecated(since = "9")
    public static final int ROUND_HALF_DOWN = 5;

    @Deprecated(since = "9")
    public static final int ROUND_HALF_EVEN = 6;

    @Deprecated(since = "9")
    public static final int ROUND_HALF_UP = 4;

    @Deprecated(since = "9")
    public static final int ROUND_UNNECESSARY = 7;

    @Deprecated(since = "9")
    public static final int ROUND_UP = 0;
    public static final BigDecimal TEN;
    private static final long[] THRESHOLDS_TABLE;
    public static final BigDecimal ZERO;
    private static final BigDecimal[] ZERO_SCALED_BY;
    private static final BigDecimal[] ZERO_THROUGH_TEN;
    private static final long serialVersionUID = 6108874887143696463L;
    private final transient long intCompact;
    private final BigInteger intVal;
    private transient int precision;
    private final int scale;
    private transient String stringCache;
    private static final BigInteger INFLATED_BIGINT = BigInteger.valueOf(Long.MIN_VALUE);
    private static final ThreadLocal<StringBuilderHelper> threadLocalStringBuilderHelper = new ThreadLocal<StringBuilderHelper>() { // from class: java.math.BigDecimal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilderHelper initialValue() {
            return new StringBuilderHelper();
        }
    };

    static {
        BigDecimal[] bigDecimalArr = {new BigDecimal(BigInteger.ZERO, 0L, 0, 1), new BigDecimal(BigInteger.ONE, 1L, 0, 1), new BigDecimal(BigInteger.TWO, 2L, 0, 1), new BigDecimal(BigInteger.valueOf(3L), 3L, 0, 1), new BigDecimal(BigInteger.valueOf(4L), 4L, 0, 1), new BigDecimal(BigInteger.valueOf(5L), 5L, 0, 1), new BigDecimal(BigInteger.valueOf(6L), 6L, 0, 1), new BigDecimal(BigInteger.valueOf(7L), 7L, 0, 1), new BigDecimal(BigInteger.valueOf(8L), 8L, 0, 1), new BigDecimal(BigInteger.valueOf(9L), 9L, 0, 1), new BigDecimal(BigInteger.TEN, 10L, 0, 2)};
        ZERO_THROUGH_TEN = bigDecimalArr;
        ZERO_SCALED_BY = new BigDecimal[]{bigDecimalArr[0], new BigDecimal(BigInteger.ZERO, 0L, 1, 1), new BigDecimal(BigInteger.ZERO, 0L, 2, 1), new BigDecimal(BigInteger.ZERO, 0L, 3, 1), new BigDecimal(BigInteger.ZERO, 0L, 4, 1), new BigDecimal(BigInteger.ZERO, 0L, 5, 1), new BigDecimal(BigInteger.ZERO, 0L, 6, 1), new BigDecimal(BigInteger.ZERO, 0L, 7, 1), new BigDecimal(BigInteger.ZERO, 0L, 8, 1), new BigDecimal(BigInteger.ZERO, 0L, 9, 1), new BigDecimal(BigInteger.ZERO, 0L, 10, 1), new BigDecimal(BigInteger.ZERO, 0L, 11, 1), new BigDecimal(BigInteger.ZERO, 0L, 12, 1), new BigDecimal(BigInteger.ZERO, 0L, 13, 1), new BigDecimal(BigInteger.ZERO, 0L, 14, 1), new BigDecimal(BigInteger.ZERO, 0L, 15, 1)};
        ZERO = bigDecimalArr[0];
        ONE = bigDecimalArr[1];
        TEN = bigDecimalArr[10];
        ONE_TENTH = valueOf(1L, 1);
        ONE_HALF = valueOf(5L, 1);
        DOUBLE_10_POW = new double[]{1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
        FLOAT_10_POW = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
        LONG_TEN_POWERS_TABLE = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        BIG_TEN_POWERS_TABLE = new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(10L), BigInteger.valueOf(100L), BigInteger.valueOf(1000L), BigInteger.valueOf(10000L), BigInteger.valueOf(100000L), BigInteger.valueOf(1000000L), BigInteger.valueOf(10000000L), BigInteger.valueOf(100000000L), BigInteger.valueOf(1000000000L), BigInteger.valueOf(RealConnection.IDLE_CONNECTION_HEALTHY_NS), BigInteger.valueOf(100000000000L), BigInteger.valueOf(1000000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L), BigInteger.valueOf(10000000000000000L), BigInteger.valueOf(100000000000000000L), BigInteger.valueOf(1000000000000000000L)};
        int length = BIG_TEN_POWERS_TABLE.length;
        BIG_TEN_POWERS_TABLE_INITLEN = length;
        BIG_TEN_POWERS_TABLE_MAX = length * 16;
        THRESHOLDS_TABLE = new long[]{Long.MAX_VALUE, 922337203685477580L, 92233720368547758L, 9223372036854775L, 922337203685477L, 92233720368547L, 9223372036854L, 922337203685L, 92233720368L, 9223372036L, 922337203, 92233720, 9223372, 922337, 92233, 9223, 922, 92, 9};
        long[] jArr = new long[2];
        // fill-array-data instruction
        jArr[0] = 54210108624275L;
        jArr[1] = 4089650035136921600L;
        LONGLONG_TEN_POWERS_TABLE = new long[][]{new long[]{0, -8446744073709551616L}, new long[]{5, 7766279631452241920L}, new long[]{54, 3875820019684212736L}, new long[]{542, 1864712049423024128L}, new long[]{5421, 200376420520689664L}, new long[]{54210, 2003764205206896640L}, new long[]{542101, 1590897978359414784L}, new long[]{5421010, -2537764290115403776L}, new long[]{54210108, -6930898827444486144L}, new long[]{542101086, 4477988020393345024L}, new long[]{5421010862L, 7886392056514347008L}, new long[]{54210108624L, 5076944270305263616L}, new long[]{542101086242L, -4570789518076018688L}, new long[]{5421010862427L, -8814407033341083648L}, jArr, new long[]{542101086242752L, 4003012203950112768L}, new long[]{5421010862427522L, 3136633892082024448L}, new long[]{54210108624275221L, -5527149226598858752L}, new long[]{542101086242752217L, 68739955140067328L}, new long[]{5421010862427522170L, 687399551400673280L}};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigDecimal(BigInteger intVal, long val, int scale, int prec) {
        this.scale = scale;
        this.precision = prec;
        this.intCompact = val;
        this.intVal = intVal;
    }

    public BigDecimal(char[] in, int offset, int len) {
        this(in, offset, len, MathContext.UNLIMITED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x01e7, code lost:
    
        if (r14 <= '9') goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x026f, code lost:
    
        if (r11 == 0) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0273, code lost:
    
        if (r8 == 0) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0279, code lost:
    
        r12 = adjustScale(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0283, code lost:
    
        if (r0 == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0285, code lost:
    
        r15 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0288, code lost:
    
        r2 = new java.math.BigInteger(r6, r15, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x028b, code lost:
    
        r14 = compactValFor(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x028f, code lost:
    
        r3 = r34.precision;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0291, code lost:
    
        if (r3 <= 0) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0293, code lost:
    
        if (r11 <= r3) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0299, code lost:
    
        if (r14 != Long.MIN_VALUE) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x029b, code lost:
    
        r5 = r11 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x029d, code lost:
    
        if (r5 <= 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x029f, code lost:
    
        r32 = r6;
        r33 = r7;
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x02a8, code lost:
    
        r12 = checkScaleNonZero(r12 - r5);
        r2 = divideAndRoundByTenPow(r2, r5, r34.roundingMode.oldMode);
        r14 = compactValFor(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02bd, code lost:
    
        if (r14 == Long.MIN_VALUE) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02ca, code lost:
    
        r11 = bigDigitLength(r2);
        r5 = r11 - r3;
        r6 = r32;
        r7 = r33;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02bf, code lost:
    
        r9 = longDigitLength(r14);
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02f2, code lost:
    
        if (r14 == Long.MIN_VALUE) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02f4, code lost:
    
        r5 = r9 - r3;
        r6 = r9;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02f8, code lost:
    
        if (r5 <= 0) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02fd, code lost:
    
        r7 = checkScaleNonZero(r7 - r5);
        r8 = divideAndRound(r8, java.math.BigDecimal.LONG_TEN_POWERS_TABLE[r5], r34.roundingMode.oldMode);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0313, code lost:
    
        r6 = longDigitLength(r8);
        r5 = r6 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0317, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0320, code lost:
    
        r2 = null;
        r3 = r8;
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0327, code lost:
    
        r3 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x02d4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x02df, code lost:
    
        r33 = r7;
        r9 = r11;
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x02e8, code lost:
    
        r33 = r7;
        r9 = r11;
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x032c, code lost:
    
        r9 = r11;
        r7 = r12;
        r3 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0342, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x034e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0287, code lost:
    
        r15 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0358, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x036b, code lost:
    
        throw new java.lang.NumberFormatException("No digits found.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x036c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fe, code lost:
    
        if (r33 == 'e') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0102, code lost:
    
        if (r33 != 'E') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0123, code lost:
    
        throw new java.lang.NumberFormatException("Character " + r33 + " is neither a decimal digit number, decimal point, nor \"e\" notation exponential mark.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0124, code lost:
    
        r5 = parseExp(r31, r4, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0128, code lost:
    
        r33 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x012e, code lost:
    
        if (((int) r5) != r5) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0136, code lost:
    
        throw new java.lang.NumberFormatException("Exponent overflow.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0221 A[Catch: ArrayIndexOutOfBoundsException | NegativeArraySizeException -> 0x027b, TryCatch #1 {ArrayIndexOutOfBoundsException | NegativeArraySizeException -> 0x027b, blocks: (B:162:0x01f6, B:152:0x0211, B:154:0x0221, B:156:0x0234, B:160:0x0217, B:168:0x0207, B:169:0x0205, B:172:0x01ec, B:180:0x023b, B:181:0x0240, B:188:0x024a, B:189:0x0251, B:190:0x0252, B:196:0x0275, B:259:0x025d, B:260:0x0262), top: B:161:0x01f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0226  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BigDecimal(char[] r31, int r32, int r33, java.math.MathContext r34) {
        /*
            Method dump skipped, instructions count: 924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.<init>(char[], int, int, java.math.MathContext):void");
    }

    private int adjustScale(int scl, long exp) {
        long adjustedScale = scl - exp;
        if (adjustedScale > ZipUtils.UPPER_UNIXTIME_BOUND || adjustedScale < -2147483648L) {
            throw new NumberFormatException("Scale out of range.");
        }
        int scl2 = (int) adjustedScale;
        return scl2;
    }

    private static long parseExp(char[] in, int offset, int len) {
        int v2;
        long exp = 0;
        int offset2 = offset + 1;
        char c4 = in[offset2];
        int len2 = len - 1;
        boolean negexp = c4 == '-';
        if (negexp || c4 == '+') {
            offset2++;
            c4 = in[offset2];
            len2--;
        }
        if (len2 <= 0) {
            throw new NumberFormatException("No exponent digits.");
        }
        while (len2 > 10 && (c4 == '0' || Character.digit(c4, 10) == 0)) {
            offset2++;
            c4 = in[offset2];
            len2--;
        }
        if (len2 > 10) {
            throw new NumberFormatException("Too many nonzero exponent digits.");
        }
        while (true) {
            if (c4 >= '0' && c4 <= '9') {
                v2 = c4 - '0';
            } else {
                v2 = Character.digit(c4, 10);
                if (v2 < 0) {
                    throw new NumberFormatException("Not a digit.");
                }
            }
            exp = (10 * exp) + v2;
            if (len2 != 1) {
                offset2++;
                c4 = in[offset2];
                len2--;
            } else {
                if (negexp) {
                    return -exp;
                }
                return exp;
            }
        }
    }

    public BigDecimal(char[] in) {
        this(in, 0, in.length);
    }

    public BigDecimal(char[] in, MathContext mc2) {
        this(in, 0, in.length, mc2);
    }

    public BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
    }

    public BigDecimal(String val, MathContext mc2) {
        this(val.toCharArray(), 0, val.length(), mc2);
    }

    public BigDecimal(double val) {
        this(val, MathContext.UNLIMITED);
    }

    public BigDecimal(double val, MathContext mc2) {
        long significand;
        BigInteger rb2;
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinite or NaN");
        }
        long valBits = Double.doubleToLongBits(val);
        int sign = (valBits >> 63) == 0 ? 1 : -1;
        int exponent = (int) ((valBits >> 52) & 2047);
        if (exponent == 0) {
            significand = (DoubleConsts.SIGNIF_BIT_MASK & valBits) << 1;
        } else {
            significand = (DoubleConsts.SIGNIF_BIT_MASK & valBits) | 4503599627370496L;
        }
        int exponent2 = exponent - 1075;
        if (significand == 0) {
            this.intVal = BigInteger.ZERO;
            this.scale = 0;
            this.intCompact = 0L;
            this.precision = 1;
            return;
        }
        while ((1 & significand) == 0) {
            significand >>= 1;
            exponent2++;
        }
        int scl = 0;
        long compactVal = sign * significand;
        if (exponent2 == 0) {
            rb2 = compactVal == Long.MIN_VALUE ? INFLATED_BIGINT : null;
        } else {
            if (exponent2 < 0) {
                rb2 = BigInteger.valueOf(5L).pow(-exponent2).multiply(compactVal);
                scl = -exponent2;
            } else {
                BigInteger rb3 = BigInteger.TWO;
                rb2 = rb3.pow(exponent2).multiply(compactVal);
            }
            compactVal = compactValFor(rb2);
        }
        int drop = 0;
        int mcp = mc2.precision;
        if (mcp > 0) {
            int mode = mc2.roundingMode.oldMode;
            if (compactVal == Long.MIN_VALUE) {
                int prec = bigDigitLength(rb2);
                int drop2 = prec - mcp;
                while (true) {
                    if (drop2 <= 0) {
                        drop = prec;
                        break;
                    }
                    long valBits2 = valBits;
                    int sign2 = sign;
                    scl = checkScaleNonZero(scl - drop2);
                    rb2 = divideAndRoundByTenPow(rb2, drop2, mode);
                    compactVal = compactValFor(rb2);
                    if (compactVal != Long.MIN_VALUE) {
                        drop = prec;
                        break;
                    }
                    prec = bigDigitLength(rb2);
                    drop2 = prec - mcp;
                    valBits = valBits2;
                    sign = sign2;
                }
            }
            if (compactVal != Long.MIN_VALUE) {
                int prec2 = longDigitLength(compactVal);
                int drop3 = prec2 - mcp;
                drop = prec2;
                while (drop3 > 0) {
                    scl = checkScaleNonZero(scl - drop3);
                    compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop3], mc2.roundingMode.oldMode);
                    drop = longDigitLength(compactVal);
                    drop3 = drop - mcp;
                    exponent2 = exponent2;
                    significand = significand;
                }
                rb2 = null;
            }
        }
        this.intVal = rb2;
        this.intCompact = compactVal;
        this.scale = scl;
        this.precision = drop;
    }

    private static BigInteger toStrictBigInteger(BigInteger val) {
        if (val.getClass() == BigInteger.class) {
            return val;
        }
        return new BigInteger((byte[]) val.toByteArray().clone());
    }

    public BigDecimal(BigInteger val) {
        this.scale = 0;
        BigInteger strictBigInteger = toStrictBigInteger(val);
        this.intVal = strictBigInteger;
        this.intCompact = compactValFor(strictBigInteger);
    }

    public BigDecimal(BigInteger val, MathContext mc2) {
        this(toStrictBigInteger(val), 0, mc2);
    }

    public BigDecimal(BigInteger unscaledVal, int scale) {
        BigInteger strictBigInteger = toStrictBigInteger(unscaledVal);
        this.intVal = strictBigInteger;
        this.intCompact = compactValFor(strictBigInteger);
        this.scale = scale;
    }

    public BigDecimal(BigInteger unscaledVal, int scale, MathContext mc2) {
        BigInteger unscaledVal2 = toStrictBigInteger(unscaledVal);
        long compactVal = compactValFor(unscaledVal2);
        int mcp = mc2.precision;
        int prec = 0;
        if (mcp > 0) {
            int mode = mc2.roundingMode.oldMode;
            if (compactVal == Long.MIN_VALUE) {
                prec = bigDigitLength(unscaledVal2);
                int drop = prec - mcp;
                while (drop > 0) {
                    scale = checkScaleNonZero(scale - drop);
                    unscaledVal2 = divideAndRoundByTenPow(unscaledVal2, drop, mode);
                    compactVal = compactValFor(unscaledVal2);
                    if (compactVal != Long.MIN_VALUE) {
                        break;
                    }
                    prec = bigDigitLength(unscaledVal2);
                    drop = prec - mcp;
                }
            }
            if (compactVal != Long.MIN_VALUE) {
                prec = longDigitLength(compactVal);
                int drop2 = prec - mcp;
                while (drop2 > 0) {
                    scale = checkScaleNonZero(scale - drop2);
                    compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop2], mode);
                    prec = longDigitLength(compactVal);
                    drop2 = prec - mcp;
                }
                unscaledVal2 = null;
            }
        }
        this.intVal = unscaledVal2;
        this.intCompact = compactVal;
        this.scale = scale;
        this.precision = prec;
    }

    public BigDecimal(int val) {
        this.intCompact = val;
        this.scale = 0;
        this.intVal = null;
    }

    public BigDecimal(int val, MathContext mc2) {
        int mcp = mc2.precision;
        long compactVal = val;
        int scl = 0;
        int prec = 0;
        if (mcp > 0) {
            prec = longDigitLength(compactVal);
            int drop = prec - mcp;
            while (drop > 0) {
                scl = checkScaleNonZero(scl - drop);
                compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop], mc2.roundingMode.oldMode);
                prec = longDigitLength(compactVal);
                drop = prec - mcp;
            }
        }
        this.intVal = null;
        this.intCompact = compactVal;
        this.scale = scl;
        this.precision = prec;
    }

    public BigDecimal(long val) {
        this.intCompact = val;
        this.intVal = val == Long.MIN_VALUE ? INFLATED_BIGINT : null;
        this.scale = 0;
    }

    public BigDecimal(long val, MathContext mc2) {
        int mcp = mc2.precision;
        int mode = mc2.roundingMode.oldMode;
        int prec = 0;
        int scl = 0;
        BigInteger rb2 = val == Long.MIN_VALUE ? INFLATED_BIGINT : null;
        if (mcp > 0) {
            if (val == Long.MIN_VALUE) {
                prec = 19;
                int drop = 19 - mcp;
                while (drop > 0) {
                    scl = checkScaleNonZero(scl - drop);
                    rb2 = divideAndRoundByTenPow(rb2, drop, mode);
                    val = compactValFor(rb2);
                    if (val != Long.MIN_VALUE) {
                        break;
                    }
                    prec = bigDigitLength(rb2);
                    drop = prec - mcp;
                }
            }
            if (val != Long.MIN_VALUE) {
                prec = longDigitLength(val);
                int drop2 = prec - mcp;
                while (drop2 > 0) {
                    scl = checkScaleNonZero(scl - drop2);
                    val = divideAndRound(val, LONG_TEN_POWERS_TABLE[drop2], mc2.roundingMode.oldMode);
                    prec = longDigitLength(val);
                    drop2 = prec - mcp;
                }
                rb2 = null;
            }
        }
        this.intVal = rb2;
        this.intCompact = val;
        this.scale = scl;
        this.precision = prec;
    }

    public static BigDecimal valueOf(long unscaledVal, int scale) {
        if (scale == 0) {
            return valueOf(unscaledVal);
        }
        if (unscaledVal == 0) {
            return zeroValueOf(scale);
        }
        return new BigDecimal(unscaledVal == Long.MIN_VALUE ? INFLATED_BIGINT : null, unscaledVal, scale, 0);
    }

    public static BigDecimal valueOf(long val) {
        if (val >= 0) {
            BigDecimal[] bigDecimalArr = ZERO_THROUGH_TEN;
            if (val < bigDecimalArr.length) {
                return bigDecimalArr[(int) val];
            }
        }
        if (val != Long.MIN_VALUE) {
            return new BigDecimal((BigInteger) null, val, 0, 0);
        }
        return new BigDecimal(INFLATED_BIGINT, val, 0, 0);
    }

    static BigDecimal valueOf(long unscaledVal, int scale, int prec) {
        if (scale == 0 && unscaledVal >= 0) {
            BigDecimal[] bigDecimalArr = ZERO_THROUGH_TEN;
            if (unscaledVal < bigDecimalArr.length) {
                return bigDecimalArr[(int) unscaledVal];
            }
        }
        if (unscaledVal == 0) {
            return zeroValueOf(scale);
        }
        return new BigDecimal(unscaledVal == Long.MIN_VALUE ? INFLATED_BIGINT : null, unscaledVal, scale, prec);
    }

    static BigDecimal valueOf(BigInteger intVal, int scale, int prec) {
        long val = compactValFor(intVal);
        if (val == 0) {
            return zeroValueOf(scale);
        }
        if (scale == 0 && val >= 0) {
            BigDecimal[] bigDecimalArr = ZERO_THROUGH_TEN;
            if (val < bigDecimalArr.length) {
                return bigDecimalArr[(int) val];
            }
        }
        return new BigDecimal(intVal, val, scale, prec);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigDecimal zeroValueOf(int scale) {
        if (scale >= 0) {
            BigDecimal[] bigDecimalArr = ZERO_SCALED_BY;
            if (scale < bigDecimalArr.length) {
                return bigDecimalArr[scale];
            }
        }
        return new BigDecimal(BigInteger.ZERO, 0L, scale, 1);
    }

    public static BigDecimal valueOf(double val) {
        return new BigDecimal(Double.toString(val));
    }

    public BigDecimal add(BigDecimal augend) {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long j11 = augend.intCompact;
            if (j11 != Long.MIN_VALUE) {
                return add(j10, this.scale, j11, augend.scale);
            }
            return add(j10, this.scale, augend.intVal, augend.scale);
        }
        long j12 = augend.intCompact;
        if (j12 != Long.MIN_VALUE) {
            return add(j12, augend.scale, this.intVal, this.scale);
        }
        return add(this.intVal, this.scale, augend.intVal, augend.scale);
    }

    public BigDecimal add(BigDecimal augend, MathContext mc2) {
        if (mc2.precision == 0) {
            return add(augend);
        }
        BigDecimal lhs = this;
        boolean lhsIsZero = lhs.signum() == 0;
        boolean augendIsZero = augend.signum() == 0;
        if (lhsIsZero || augendIsZero) {
            int preferredScale = Math.max(lhs.scale(), augend.scale());
            if (lhsIsZero && augendIsZero) {
                return zeroValueOf(preferredScale);
            }
            BigDecimal result = lhsIsZero ? doRound(augend, mc2) : doRound(lhs, mc2);
            if (result.scale() == preferredScale) {
                return result;
            }
            if (result.scale() > preferredScale) {
                return stripZerosToMatchScale(result.intVal, result.intCompact, result.scale, preferredScale);
            }
            int precisionDiff = mc2.precision - result.precision();
            int scaleDiff = preferredScale - result.scale();
            if (precisionDiff >= scaleDiff) {
                return result.setScale(preferredScale);
            }
            return result.setScale(result.scale() + precisionDiff);
        }
        long padding = lhs.scale - augend.scale;
        if (padding != 0) {
            BigDecimal[] arg = preAlign(lhs, augend, padding, mc2);
            matchScale(arg);
            lhs = arg[0];
            augend = arg[1];
        }
        return doRound(lhs.inflated().add(augend.inflated()), lhs.scale, mc2);
    }

    private BigDecimal[] preAlign(BigDecimal lhs, BigDecimal augend, long padding, MathContext mc2) {
        BigDecimal big;
        BigDecimal small;
        if (padding < 0) {
            big = lhs;
            small = augend;
        } else {
            big = augend;
            small = lhs;
        }
        long estResultUlpScale = (big.scale - big.precision()) + mc2.precision;
        long smallHighDigitPos = (small.scale - small.precision()) + 1;
        if (smallHighDigitPos > big.scale + 2 && smallHighDigitPos > 2 + estResultUlpScale) {
            small = valueOf(small.signum(), checkScale(Math.max(big.scale, estResultUlpScale) + 3));
        }
        BigDecimal[] result = {big, small};
        return result;
    }

    public BigDecimal subtract(BigDecimal subtrahend) {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long j11 = subtrahend.intCompact;
            if (j11 != Long.MIN_VALUE) {
                return add(j10, this.scale, -j11, subtrahend.scale);
            }
            return add(j10, this.scale, subtrahend.intVal.negate(), subtrahend.scale);
        }
        long j12 = subtrahend.intCompact;
        if (j12 != Long.MIN_VALUE) {
            return add(-j12, subtrahend.scale, this.intVal, this.scale);
        }
        return add(this.intVal, this.scale, subtrahend.intVal.negate(), subtrahend.scale);
    }

    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc2) {
        if (mc2.precision == 0) {
            return subtract(subtrahend);
        }
        return add(subtrahend.negate(), mc2);
    }

    public BigDecimal multiply(BigDecimal multiplicand) {
        int productScale = checkScale(this.scale + multiplicand.scale);
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long j11 = multiplicand.intCompact;
            if (j11 != Long.MIN_VALUE) {
                return multiply(j10, j11, productScale);
            }
            return multiply(j10, multiplicand.intVal, productScale);
        }
        long j12 = multiplicand.intCompact;
        if (j12 != Long.MIN_VALUE) {
            return multiply(j12, this.intVal, productScale);
        }
        return multiply(this.intVal, multiplicand.intVal, productScale);
    }

    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc2) {
        if (mc2.precision == 0) {
            return multiply(multiplicand);
        }
        int productScale = checkScale(this.scale + multiplicand.scale);
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long j11 = multiplicand.intCompact;
            if (j11 != Long.MIN_VALUE) {
                return multiplyAndRound(j10, j11, productScale, mc2);
            }
            return multiplyAndRound(j10, multiplicand.intVal, productScale, mc2);
        }
        long j12 = multiplicand.intCompact;
        if (j12 != Long.MIN_VALUE) {
            return multiplyAndRound(j12, this.intVal, productScale, mc2);
        }
        return multiplyAndRound(this.intVal, multiplicand.intVal, productScale, mc2);
    }

    @Deprecated(since = "9")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        if (roundingMode < 0 || roundingMode > 7) {
            throw new IllegalArgumentException("Invalid rounding mode");
        }
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long j11 = divisor.intCompact;
            if (j11 != Long.MIN_VALUE) {
                return divide(j10, this.scale, j11, divisor.scale, scale, roundingMode);
            }
            return divide(j10, this.scale, divisor.intVal, divisor.scale, scale, roundingMode);
        }
        long j12 = divisor.intCompact;
        if (j12 != Long.MIN_VALUE) {
            return divide(this.intVal, this.scale, j12, divisor.scale, scale, roundingMode);
        }
        return divide(this.intVal, this.scale, divisor.intVal, divisor.scale, scale, roundingMode);
    }

    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        return divide(divisor, scale, roundingMode.oldMode);
    }

    @Deprecated(since = "9")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        return divide(divisor, this.scale, roundingMode);
    }

    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        return divide(divisor, this.scale, roundingMode.oldMode);
    }

    public BigDecimal divide(BigDecimal divisor) {
        if (divisor.signum() == 0) {
            if (signum() == 0) {
                throw new ArithmeticException("Division undefined");
            }
            throw new ArithmeticException("Division by zero");
        }
        int preferredScale = saturateLong(this.scale - divisor.scale);
        if (signum() == 0) {
            return zeroValueOf(preferredScale);
        }
        MathContext mc2 = new MathContext((int) Math.min(precision() + ((long) Math.ceil((divisor.precision() * 10.0d) / 3.0d)), ZipUtils.UPPER_UNIXTIME_BOUND), RoundingMode.UNNECESSARY);
        try {
            BigDecimal quotient = divide(divisor, mc2);
            int quotientScale = quotient.scale();
            if (preferredScale > quotientScale) {
                return quotient.setScale(preferredScale, 7);
            }
            return quotient;
        } catch (ArithmeticException e2) {
            throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result.");
        }
    }

    public BigDecimal divide(BigDecimal divisor, MathContext mc2) {
        int mcp = mc2.precision;
        if (mcp != 0) {
            long preferredScale = this.scale - divisor.scale;
            if (divisor.signum() == 0) {
                if (signum() == 0) {
                    throw new ArithmeticException("Division undefined");
                }
                throw new ArithmeticException("Division by zero");
            }
            if (signum() == 0) {
                return zeroValueOf(saturateLong(preferredScale));
            }
            int xscale = precision();
            int yscale = divisor.precision();
            long j10 = this.intCompact;
            if (j10 != Long.MIN_VALUE) {
                long j11 = divisor.intCompact;
                if (j11 != Long.MIN_VALUE) {
                    return divide(j10, xscale, j11, yscale, preferredScale, mc2);
                }
                return divide(j10, xscale, divisor.intVal, yscale, preferredScale, mc2);
            }
            long j12 = divisor.intCompact;
            if (j12 == Long.MIN_VALUE) {
                return divide(this.intVal, xscale, divisor.intVal, yscale, preferredScale, mc2);
            }
            return divide(this.intVal, xscale, j12, yscale, preferredScale, mc2);
        }
        return divide(divisor);
    }

    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        int preferredScale = saturateLong(this.scale - divisor.scale);
        if (compareMagnitude(divisor) < 0) {
            return zeroValueOf(preferredScale);
        }
        if (signum() == 0 && divisor.signum() != 0) {
            return setScale(preferredScale, 7);
        }
        int maxDigits = (int) Math.min(precision() + ((long) Math.ceil((divisor.precision() * 10.0d) / 3.0d)) + Math.abs(scale() - divisor.scale()) + 2, ZipUtils.UPPER_UNIXTIME_BOUND);
        BigDecimal quotient = divide(divisor, new MathContext(maxDigits, RoundingMode.DOWN));
        if (quotient.scale > 0) {
            BigDecimal quotient2 = quotient.setScale(0, RoundingMode.DOWN);
            quotient = stripZerosToMatchScale(quotient2.intVal, quotient2.intCompact, quotient2.scale, preferredScale);
        }
        if (quotient.scale < preferredScale) {
            return quotient.setScale(preferredScale, 7);
        }
        return quotient;
    }

    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc2) {
        int precisionDiff;
        if (mc2.precision == 0 || compareMagnitude(divisor) < 0) {
            return divideToIntegralValue(divisor);
        }
        int preferredScale = saturateLong(this.scale - divisor.scale);
        BigDecimal result = divide(divisor, new MathContext(mc2.precision, RoundingMode.DOWN));
        if (result.scale() < 0) {
            BigDecimal product = result.multiply(divisor);
            if (subtract(product).compareMagnitude(divisor) >= 0) {
                throw new ArithmeticException("Division impossible");
            }
        } else if (result.scale() > 0) {
            result = result.setScale(0, RoundingMode.DOWN);
        }
        if (preferredScale > result.scale() && (precisionDiff = mc2.precision - result.precision()) > 0) {
            return result.setScale(result.scale() + Math.min(precisionDiff, preferredScale - result.scale));
        }
        return stripZerosToMatchScale(result.intVal, result.intCompact, result.scale, preferredScale);
    }

    public BigDecimal remainder(BigDecimal divisor) {
        BigDecimal[] divrem = divideAndRemainder(divisor);
        return divrem[1];
    }

    public BigDecimal remainder(BigDecimal divisor, MathContext mc2) {
        BigDecimal[] divrem = divideAndRemainder(divisor, mc2);
        return divrem[1];
    }

    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        BigDecimal[] result = {divideToIntegralValue(divisor), subtract(result[0].multiply(divisor))};
        return result;
    }

    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc2) {
        if (mc2.precision == 0) {
            return divideAndRemainder(divisor);
        }
        BigDecimal[] result = {divideToIntegralValue(divisor, mc2), subtract(result[0].multiply(divisor))};
        return result;
    }

    public BigDecimal sqrt(MathContext mc2) {
        int scaleAdjust;
        int targetPrecision;
        BigDecimal result;
        BigDecimal bigDecimal = this;
        MathContext mathContext = mc2;
        int signum = signum();
        if (signum == 1) {
            int preferredScale = scale() / 2;
            BigDecimal zeroWithFinalPreferredScale = valueOf(0L, preferredScale);
            BigDecimal stripped = stripTrailingZeros();
            int strippedScale = stripped.scale();
            if (stripped.isPowerOfTen() && strippedScale % 2 == 0) {
                BigDecimal result2 = valueOf(1L, strippedScale / 2);
                if (result2.scale() != preferredScale) {
                    return result2.add(zeroWithFinalPreferredScale, mathContext);
                }
                return result2;
            }
            int scale = (stripped.scale() - stripped.precision()) + 1;
            if (scale % 2 == 0) {
                scaleAdjust = scale;
            } else {
                int scaleAdjust2 = scale - 1;
                scaleAdjust = scaleAdjust2;
            }
            BigDecimal working = stripped.scaleByPowerOfTen(scaleAdjust);
            BigDecimal guess = new BigDecimal(Math.sqrt(working.doubleValue()));
            int guessPrecision = 15;
            int originalPrecision = mc2.getPrecision();
            if (originalPrecision == 0) {
                targetPrecision = (stripped.precision() / 2) + 1;
            } else {
                switch (AnonymousClass2.$SwitchMap$java$math$RoundingMode[mc2.getRoundingMode().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        int targetPrecision2 = originalPrecision * 2;
                        if (targetPrecision2 >= 0) {
                            targetPrecision = targetPrecision2;
                            break;
                        } else {
                            targetPrecision = 2147483645;
                            break;
                        }
                    default:
                        targetPrecision = originalPrecision;
                        break;
                }
            }
            BigDecimal approx = guess;
            int workingPrecision = working.precision();
            while (true) {
                BigDecimal stripped2 = stripped;
                int tmpPrecision = Math.max(Math.max(guessPrecision, targetPrecision + 2), workingPrecision);
                int strippedScale2 = strippedScale;
                int scale2 = scale;
                MathContext mcTmp = new MathContext(tmpPrecision, RoundingMode.HALF_EVEN);
                approx = ONE_HALF.multiply(approx.add(working.divide(approx, mcTmp), mcTmp));
                guessPrecision *= 2;
                if (guessPrecision < targetPrecision + 2) {
                    bigDecimal = this;
                    mathContext = mc2;
                    stripped = stripped2;
                    strippedScale = strippedScale2;
                    scale = scale2;
                } else {
                    RoundingMode targetRm = mc2.getRoundingMode();
                    if (targetRm == RoundingMode.UNNECESSARY || originalPrecision == 0) {
                        RoundingMode tmpRm = targetRm == RoundingMode.UNNECESSARY ? RoundingMode.DOWN : targetRm;
                        BigDecimal result3 = approx.scaleByPowerOfTen((-scaleAdjust) / 2).round(new MathContext(targetPrecision, tmpRm));
                        if (bigDecimal.subtract(result3.square()).compareTo(ZERO) != 0) {
                            throw new ArithmeticException("Computed square root not exact.");
                        }
                        result = result3;
                    } else {
                        result = approx.scaleByPowerOfTen((-scaleAdjust) / 2).round(mathContext);
                        switch (targetRm) {
                            case DOWN:
                            case FLOOR:
                                if (result.square().compareTo(bigDecimal) > 0) {
                                    BigDecimal ulp = result.ulp();
                                    if (approx.compareTo(ONE) == 0) {
                                        ulp = ulp.multiply(ONE_TENTH);
                                    }
                                    result = result.subtract(ulp);
                                    break;
                                }
                                break;
                            case UP:
                            case CEILING:
                                if (result.square().compareTo(bigDecimal) < 0) {
                                    result = result.add(result.ulp());
                                    break;
                                }
                                break;
                        }
                    }
                    if (result.scale() != preferredScale) {
                        return result.stripTrailingZeros().add(zeroWithFinalPreferredScale, new MathContext(originalPrecision, RoundingMode.UNNECESSARY));
                    }
                    return result;
                }
            }
        } else {
            switch (signum) {
                case -1:
                    throw new ArithmeticException("Attempted square root of negative BigDecimal");
                case 0:
                    return valueOf(0L, scale() / 2);
                default:
                    throw new AssertionError((Object) "Bad value from signum");
            }
        }
    }

    private BigDecimal square() {
        return multiply(this);
    }

    private boolean isPowerOfTen() {
        return BigInteger.ONE.equals(unscaledValue());
    }

    private boolean squareRootResultAssertions(BigDecimal result, MathContext mc2) {
        if (result.signum() == 0) {
            return squareRootZeroResultAssertions(result, mc2);
        }
        RoundingMode rm = mc2.getRoundingMode();
        BigDecimal ulp = result.ulp();
        BigDecimal neighborUp = result.add(ulp);
        if (result.isPowerOfTen()) {
            ulp = ulp.divide(TEN);
        }
        BigDecimal neighborDown = result.subtract(ulp);
        switch (AnonymousClass2.$SwitchMap$java$math$RoundingMode[rm.ordinal()]) {
            case 1:
            case 2:
            case 3:
                BigDecimal err = result.square().subtract(this).abs();
                BigDecimal errUp = neighborUp.square().subtract(this);
                BigDecimal errDown = subtract(neighborDown.square());
                err.compareTo(errUp);
                err.compareTo(errDown);
                return true;
            case 4:
            case 5:
                return true;
            case 6:
            case 7:
                return true;
            default:
                return true;
        }
    }

    private boolean squareRootZeroResultAssertions(BigDecimal result, MathContext mc2) {
        return compareTo(ZERO) == 0;
    }

    public BigDecimal pow(int n10) {
        if (n10 < 0 || n10 > 999999999) {
            throw new ArithmeticException("Invalid operation");
        }
        int newScale = checkScale(this.scale * n10);
        return new BigDecimal(inflated().pow(n10), newScale);
    }

    public BigDecimal pow(int n10, MathContext mc2) {
        if (mc2.precision == 0) {
            return pow(n10);
        }
        if (n10 < -999999999 || n10 > 999999999) {
            throw new ArithmeticException("Invalid operation");
        }
        if (n10 == 0) {
            return ONE;
        }
        MathContext workmc = mc2;
        int mag = Math.abs(n10);
        if (mc2.precision > 0) {
            int elength = longDigitLength(mag);
            if (elength > mc2.precision) {
                throw new ArithmeticException("Invalid operation");
            }
            workmc = new MathContext(mc2.precision + elength + 1, mc2.roundingMode);
        }
        BigDecimal acc = ONE;
        boolean seenbit = false;
        int i10 = 1;
        while (true) {
            mag += mag;
            if (mag < 0) {
                seenbit = true;
                acc = acc.multiply(this, workmc);
            }
            if (i10 == 31) {
                break;
            }
            if (seenbit) {
                acc = acc.multiply(acc, workmc);
            }
            i10++;
        }
        if (n10 < 0) {
            acc = ONE.divide(acc, workmc);
        }
        return doRound(acc, mc2);
    }

    public BigDecimal abs() {
        return signum() < 0 ? negate() : this;
    }

    public BigDecimal abs(MathContext mc2) {
        return signum() < 0 ? negate(mc2) : plus(mc2);
    }

    public BigDecimal negate() {
        long j10 = this.intCompact;
        if (j10 == Long.MIN_VALUE) {
            return new BigDecimal(this.intVal.negate(), Long.MIN_VALUE, this.scale, this.precision);
        }
        return valueOf(-j10, this.scale, this.precision);
    }

    public BigDecimal negate(MathContext mc2) {
        return negate().plus(mc2);
    }

    public BigDecimal plus() {
        return this;
    }

    public BigDecimal plus(MathContext mc2) {
        if (mc2.precision == 0) {
            return this;
        }
        return doRound(this, mc2);
    }

    public int signum() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            return Long.signum(j10);
        }
        return this.intVal.signum();
    }

    public int scale() {
        return this.scale;
    }

    public int precision() {
        int result = this.precision;
        if (result == 0) {
            long s2 = this.intCompact;
            if (s2 != Long.MIN_VALUE) {
                result = longDigitLength(s2);
            } else {
                result = bigDigitLength(this.intVal);
            }
            this.precision = result;
        }
        return result;
    }

    public BigInteger unscaledValue() {
        return inflated();
    }

    public BigDecimal round(MathContext mc2) {
        return plus(mc2);
    }

    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        return setScale(newScale, roundingMode.oldMode);
    }

    @Deprecated(since = "9")
    public BigDecimal setScale(int newScale, int roundingMode) {
        if (roundingMode < 0 || roundingMode > 7) {
            throw new IllegalArgumentException("Invalid rounding mode");
        }
        int oldScale = this.scale;
        if (newScale == oldScale) {
            return this;
        }
        if (signum() == 0) {
            return zeroValueOf(newScale);
        }
        if (this.intCompact != Long.MIN_VALUE) {
            long rs = this.intCompact;
            if (newScale > oldScale) {
                int raise = checkScale(newScale - oldScale);
                long rs2 = longMultiplyPowerTen(rs, raise);
                if (rs2 != Long.MIN_VALUE) {
                    return valueOf(rs2, newScale);
                }
                BigInteger rb2 = bigMultiplyPowerTen(raise);
                int i10 = this.precision;
                return new BigDecimal(rb2, Long.MIN_VALUE, newScale, i10 > 0 ? i10 + raise : 0);
            }
            int drop = checkScale(oldScale - newScale);
            long[] jArr = LONG_TEN_POWERS_TABLE;
            if (drop < jArr.length) {
                return divideAndRound(rs, jArr[drop], newScale, roundingMode, newScale);
            }
            return divideAndRound(inflated(), bigTenToThe(drop), newScale, roundingMode, newScale);
        }
        if (newScale > oldScale) {
            int raise2 = checkScale(newScale - oldScale);
            BigInteger rb3 = bigMultiplyPowerTen(this.intVal, raise2);
            int i11 = this.precision;
            return new BigDecimal(rb3, Long.MIN_VALUE, newScale, i11 > 0 ? i11 + raise2 : 0);
        }
        int drop2 = checkScale(oldScale - newScale);
        long[] jArr2 = LONG_TEN_POWERS_TABLE;
        if (drop2 < jArr2.length) {
            return divideAndRound(this.intVal, jArr2[drop2], newScale, roundingMode, newScale);
        }
        return divideAndRound(this.intVal, bigTenToThe(drop2), newScale, roundingMode, newScale);
    }

    public BigDecimal setScale(int newScale) {
        return setScale(newScale, 7);
    }

    public BigDecimal movePointLeft(int n10) {
        if (n10 == 0) {
            return this;
        }
        int newScale = checkScale(this.scale + n10);
        BigDecimal num = new BigDecimal(this.intVal, this.intCompact, newScale, 0);
        return num.scale < 0 ? num.setScale(0, 7) : num;
    }

    public BigDecimal movePointRight(int n10) {
        if (n10 == 0) {
            return this;
        }
        int newScale = checkScale(this.scale - n10);
        BigDecimal num = new BigDecimal(this.intVal, this.intCompact, newScale, 0);
        return num.scale < 0 ? num.setScale(0, 7) : num;
    }

    public BigDecimal scaleByPowerOfTen(int n10) {
        return new BigDecimal(this.intVal, this.intCompact, checkScale(this.scale - n10), this.precision);
    }

    public BigDecimal stripTrailingZeros() {
        BigInteger bigInteger;
        if (this.intCompact == 0 || ((bigInteger = this.intVal) != null && bigInteger.signum() == 0)) {
            return ZERO;
        }
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            return createAndStripZerosToMatchScale(j10, this.scale, Long.MIN_VALUE);
        }
        return createAndStripZerosToMatchScale(this.intVal, this.scale, Long.MIN_VALUE);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigDecimal val) {
        if (this.scale == val.scale) {
            long xs = this.intCompact;
            long ys = val.intCompact;
            if (xs != Long.MIN_VALUE && ys != Long.MIN_VALUE) {
                if (xs != ys) {
                    return xs > ys ? 1 : -1;
                }
                return 0;
            }
        }
        int xsign = signum();
        int ysign = val.signum();
        if (xsign != ysign) {
            return xsign > ysign ? 1 : -1;
        }
        if (xsign == 0) {
            return 0;
        }
        int cmp = compareMagnitude(val);
        return xsign > 0 ? cmp : -cmp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        if (r11 == Long.MIN_VALUE) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
    
        if (r15 == Long.MIN_VALUE) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int compareMagnitude(java.math.BigDecimal r21) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.compareMagnitude(java.math.BigDecimal):int");
    }

    public boolean equals(Object x10) {
        if (!(x10 instanceof BigDecimal)) {
            return false;
        }
        BigDecimal xDec = (BigDecimal) x10;
        if (x10 == this) {
            return true;
        }
        if (this.scale != xDec.scale) {
            return false;
        }
        long s2 = this.intCompact;
        long xs = xDec.intCompact;
        if (s2 != Long.MIN_VALUE) {
            if (xs == Long.MIN_VALUE) {
                xs = compactValFor(xDec.intVal);
            }
            return xs == s2;
        }
        if (xs != Long.MIN_VALUE) {
            return xs == compactValFor(this.intVal);
        }
        return inflated().equals(xDec.inflated());
    }

    public BigDecimal min(BigDecimal val) {
        return compareTo(val) <= 0 ? this : val;
    }

    public BigDecimal max(BigDecimal val) {
        return compareTo(val) >= 0 ? this : val;
    }

    public int hashCode() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            long val2 = j10 < 0 ? -j10 : j10;
            int temp = (int) ((((int) (val2 >>> 32)) * 31) + (4294967295L & val2));
            return ((j10 < 0 ? -temp : temp) * 31) + this.scale;
        }
        return (this.intVal.hashCode() * 31) + this.scale;
    }

    public String toString() {
        String sc2 = this.stringCache;
        if (sc2 == null) {
            String sc3 = layoutChars(true);
            this.stringCache = sc3;
            return sc3;
        }
        return sc2;
    }

    public String toEngineeringString() {
        return layoutChars(false);
    }

    public String toPlainString() {
        String str;
        StringBuilder buf;
        int i10 = this.scale;
        if (i10 == 0) {
            long j10 = this.intCompact;
            if (j10 != Long.MIN_VALUE) {
                return Long.toString(j10);
            }
            return this.intVal.toString();
        }
        if (i10 < 0) {
            if (signum() == 0) {
                return "0";
            }
            int trailingZeros = checkScaleNonZero(-this.scale);
            if (this.intCompact != Long.MIN_VALUE) {
                buf = new StringBuilder(trailingZeros + 20);
                buf.append(this.intCompact);
            } else {
                String str2 = this.intVal.toString();
                StringBuilder buf2 = new StringBuilder(str2.length() + trailingZeros);
                buf2.append(str2);
                buf = buf2;
            }
            for (int i11 = 0; i11 < trailingZeros; i11++) {
                buf.append('0');
            }
            return buf.toString();
        }
        long j11 = this.intCompact;
        if (j11 != Long.MIN_VALUE) {
            str = Long.toString(Math.abs(j11));
        } else {
            str = this.intVal.abs().toString();
        }
        return getValueString(signum(), str, this.scale);
    }

    private String getValueString(int signum, String intString, int scale) {
        StringBuilder buf;
        int insertionPoint = intString.length() - scale;
        if (insertionPoint == 0) {
            return (signum >= 0 ? "0." : "-0.") + intString;
        }
        if (insertionPoint > 0) {
            buf = new StringBuilder(intString);
            buf.insert(insertionPoint, '.');
            if (signum < 0) {
                buf.insert(0, '-');
            }
        } else {
            StringBuilder buf2 = new StringBuilder((3 - insertionPoint) + intString.length());
            buf2.append(signum >= 0 ? "0." : "-0.");
            for (int i10 = 0; i10 < (-insertionPoint); i10++) {
                buf2.append('0');
            }
            buf2.append(intString);
            buf = buf2;
        }
        return buf.toString();
    }

    public BigInteger toBigInteger() {
        return setScale(0, 1).inflated();
    }

    public BigInteger toBigIntegerExact() {
        return setScale(0, 7).inflated();
    }

    @Override // java.lang.Number
    public long longValue() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE && this.scale == 0) {
            return j10;
        }
        if (signum() == 0 || fractionOnly() || this.scale <= -64) {
            return 0L;
        }
        return toBigInteger().longValue();
    }

    private boolean fractionOnly() {
        return precision() - this.scale <= 0;
    }

    public long longValueExact() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE && this.scale == 0) {
            return j10;
        }
        if (signum() == 0) {
            return 0L;
        }
        if (fractionOnly()) {
            throw new ArithmeticException("Rounding necessary");
        }
        if (precision() - this.scale > 19) {
            throw new ArithmeticException("Overflow");
        }
        BigDecimal num = setScale(0, 7);
        if (num.precision() >= 19) {
            LongOverflow.check(num);
        }
        return num.inflated().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LongOverflow {
        private static final BigInteger LONGMIN = BigInteger.valueOf(Long.MIN_VALUE);
        private static final BigInteger LONGMAX = BigInteger.valueOf(Long.MAX_VALUE);

        private LongOverflow() {
        }

        public static void check(BigDecimal num) {
            BigInteger intVal = num.inflated();
            if (intVal.compareTo(LONGMIN) < 0 || intVal.compareTo(LONGMAX) > 0) {
                throw new ArithmeticException("Overflow");
            }
        }
    }

    @Override // java.lang.Number
    public int intValue() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE && this.scale == 0) {
            return (int) j10;
        }
        return (int) longValue();
    }

    public int intValueExact() {
        long num = longValueExact();
        if (((int) num) != num) {
            throw new ArithmeticException("Overflow");
        }
        return (int) num;
    }

    public short shortValueExact() {
        long num = longValueExact();
        if (((short) num) != num) {
            throw new ArithmeticException("Overflow");
        }
        return (short) num;
    }

    public byte byteValueExact() {
        long num = longValueExact();
        if (((byte) num) != num) {
            throw new ArithmeticException("Overflow");
        }
        return (byte) num;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            if (this.scale == 0) {
                return (float) j10;
            }
            if (Math.abs(j10) < PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) {
                int i10 = this.scale;
                if (i10 > 0) {
                    float[] fArr = FLOAT_10_POW;
                    if (i10 < fArr.length) {
                        return ((float) this.intCompact) / fArr[i10];
                    }
                }
                if (i10 < 0) {
                    float[] fArr2 = FLOAT_10_POW;
                    if (i10 > (-fArr2.length)) {
                        return ((float) this.intCompact) * fArr2[-i10];
                    }
                }
            }
        }
        return Float.parseFloat(toString());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j10 = this.intCompact;
        if (j10 != Long.MIN_VALUE) {
            if (this.scale == 0) {
                return j10;
            }
            if (Math.abs(j10) < 4503599627370496L) {
                int i10 = this.scale;
                if (i10 > 0) {
                    double[] dArr = DOUBLE_10_POW;
                    if (i10 < dArr.length) {
                        return this.intCompact / dArr[i10];
                    }
                }
                if (i10 < 0) {
                    double[] dArr2 = DOUBLE_10_POW;
                    if (i10 > (-dArr2.length)) {
                        return this.intCompact * dArr2[-i10];
                    }
                }
            }
        }
        return Double.parseDouble(toString());
    }

    public BigDecimal ulp() {
        return valueOf(1L, scale(), 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class StringBuilderHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final char[] DIGIT_TENS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        static final char[] DIGIT_ONES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        /* renamed from: sb, reason: collision with root package name */
        final StringBuilder f50366sb = new StringBuilder();
        final char[] cmpCharArray = new char[19];

        StringBuilderHelper() {
        }

        StringBuilder getStringBuilder() {
            this.f50366sb.setLength(0);
            return this.f50366sb;
        }

        char[] getCompactCharArray() {
            return this.cmpCharArray;
        }

        int putIntCompact(long intCompact) {
            int charPos = this.cmpCharArray.length;
            while (intCompact > ZipUtils.UPPER_UNIXTIME_BOUND) {
                long q10 = intCompact / 100;
                int r10 = (int) (intCompact - (100 * q10));
                intCompact = q10;
                char[] cArr = this.cmpCharArray;
                int charPos2 = charPos - 1;
                cArr[charPos2] = DIGIT_ONES[r10];
                charPos = charPos2 - 1;
                cArr[charPos] = DIGIT_TENS[r10];
            }
            int i22 = (int) intCompact;
            while (i22 >= 100) {
                int q22 = i22 / 100;
                int r11 = i22 - (q22 * 100);
                i22 = q22;
                char[] cArr2 = this.cmpCharArray;
                int charPos3 = charPos - 1;
                cArr2[charPos3] = DIGIT_ONES[r11];
                charPos = charPos3 - 1;
                cArr2[charPos] = DIGIT_TENS[r11];
            }
            char[] cArr3 = this.cmpCharArray;
            int charPos4 = charPos - 1;
            cArr3[charPos4] = DIGIT_ONES[i22];
            if (i22 >= 10) {
                int charPos5 = charPos4 - 1;
                cArr3[charPos5] = DIGIT_TENS[i22];
                return charPos5;
            }
            return charPos4;
        }
    }

    private String layoutChars(boolean sci) {
        int offset;
        char[] coeff;
        int i10 = this.scale;
        if (i10 == 0) {
            long j10 = this.intCompact;
            if (j10 != Long.MIN_VALUE) {
                return Long.toString(j10);
            }
            return this.intVal.toString();
        }
        if (i10 == 2) {
            long j11 = this.intCompact;
            if (j11 >= 0 && j11 < ZipUtils.UPPER_UNIXTIME_BOUND) {
                int lowInt = ((int) j11) % 100;
                int highInt = ((int) j11) / 100;
                return Integer.toString(highInt) + '.' + StringBuilderHelper.DIGIT_TENS[lowInt] + StringBuilderHelper.DIGIT_ONES[lowInt];
            }
        }
        StringBuilderHelper sbHelper = threadLocalStringBuilderHelper.get();
        long j12 = this.intCompact;
        if (j12 != Long.MIN_VALUE) {
            offset = sbHelper.putIntCompact(Math.abs(j12));
            coeff = sbHelper.getCompactCharArray();
        } else {
            offset = 0;
            coeff = this.intVal.abs().toString().toCharArray();
        }
        StringBuilder buf = sbHelper.getStringBuilder();
        if (signum() < 0) {
            buf.append('-');
        }
        int coeffLen = coeff.length - offset;
        int i11 = this.scale;
        long adjusted = (-i11) + (coeffLen - 1);
        if (i11 < 0 || adjusted < -6) {
            if (sci) {
                buf.append(coeff[offset]);
                if (coeffLen > 1) {
                    buf.append('.');
                    buf.append(coeff, offset + 1, coeffLen - 1);
                }
            } else {
                int sig = (int) (adjusted % 3);
                if (sig < 0) {
                    sig += 3;
                }
                adjusted -= sig;
                int sig2 = sig + 1;
                if (signum() == 0) {
                    switch (sig2) {
                        case 1:
                            buf.append('0');
                            break;
                        case 2:
                            buf.append("0.00");
                            adjusted += 3;
                            break;
                        case 3:
                            buf.append(ck.f10046d);
                            adjusted += 3;
                            break;
                        default:
                            throw new AssertionError((Object) ("Unexpected sig value " + sig2));
                    }
                } else if (sig2 >= coeffLen) {
                    buf.append(coeff, offset, coeffLen);
                    for (int i12 = sig2 - coeffLen; i12 > 0; i12--) {
                        buf.append('0');
                    }
                } else {
                    buf.append(coeff, offset, sig2);
                    buf.append('.');
                    buf.append(coeff, offset + sig2, coeffLen - sig2);
                }
            }
            if (adjusted != 0) {
                buf.append('E');
                if (adjusted > 0) {
                    buf.append('+');
                }
                buf.append(adjusted);
            }
        } else {
            int pad = i11 - coeffLen;
            if (pad >= 0) {
                buf.append('0');
                buf.append('.');
                while (pad > 0) {
                    buf.append('0');
                    pad--;
                }
                buf.append(coeff, offset, coeffLen);
            } else {
                buf.append(coeff, offset, -pad);
                buf.append('.');
                buf.append(coeff, (-pad) + offset, this.scale);
            }
        }
        return buf.toString();
    }

    private static BigInteger bigTenToThe(int n10) {
        if (n10 < 0) {
            return BigInteger.ZERO;
        }
        if (n10 < BIG_TEN_POWERS_TABLE_MAX) {
            BigInteger[] pows = BIG_TEN_POWERS_TABLE;
            if (n10 < pows.length) {
                return pows[n10];
            }
            return expandBigIntegerTenPowers(n10);
        }
        return BigInteger.TEN.pow(n10);
    }

    private static BigInteger expandBigIntegerTenPowers(int n10) {
        BigInteger bigInteger;
        synchronized (BigDecimal.class) {
            BigInteger[] pows = BIG_TEN_POWERS_TABLE;
            int curLen = pows.length;
            if (curLen <= n10) {
                int newLen = curLen << 1;
                while (newLen <= n10) {
                    newLen <<= 1;
                }
                pows = (BigInteger[]) Arrays.copyOf(pows, newLen);
                for (int i10 = curLen; i10 < newLen; i10++) {
                    pows[i10] = pows[i10 - 1].multiply(BigInteger.TEN);
                }
                BIG_TEN_POWERS_TABLE = pows;
            }
            bigInteger = pows[n10];
        }
        return bigInteger;
    }

    private static long longMultiplyPowerTen(long val, int n10) {
        if (val == 0 || n10 <= 0) {
            return val;
        }
        long[] tab = LONG_TEN_POWERS_TABLE;
        long[] bounds = THRESHOLDS_TABLE;
        if (n10 < tab.length && n10 < bounds.length) {
            long tenpower = tab[n10];
            if (val == 1) {
                return tenpower;
            }
            if (Math.abs(val) <= bounds[n10]) {
                return val * tenpower;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    private BigInteger bigMultiplyPowerTen(int n10) {
        if (n10 <= 0) {
            return inflated();
        }
        if (this.intCompact != Long.MIN_VALUE) {
            return bigTenToThe(n10).multiply(this.intCompact);
        }
        return this.intVal.multiply(bigTenToThe(n10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BigInteger inflated() {
        BigInteger bigInteger = this.intVal;
        if (bigInteger == null) {
            return BigInteger.valueOf(this.intCompact);
        }
        return bigInteger;
    }

    private static void matchScale(BigDecimal[] val) {
        if (val[0].scale < val[1].scale) {
            val[0] = val[0].setScale(val[1].scale, 7);
        } else if (val[1].scale < val[0].scale) {
            val[1] = val[1].setScale(val[0].scale, 7);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class UnsafeHolder {
        private static final long intCompactOffset;
        private static final long intValOffset;
        private static final long scaleOffset;
        private static final Unsafe unsafe;

        private UnsafeHolder() {
        }

        static {
            try {
                Unsafe unsafe2 = Unsafe.getUnsafe();
                unsafe = unsafe2;
                intCompactOffset = unsafe2.objectFieldOffset(BigDecimal.class.getDeclaredField("intCompact"));
                intValOffset = unsafe2.objectFieldOffset(BigDecimal.class.getDeclaredField("intVal"));
                scaleOffset = unsafe2.objectFieldOffset(BigDecimal.class.getDeclaredField(n.f28264e));
            } catch (Exception ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        static void setIntValAndScale(BigDecimal bd2, BigInteger intVal, int scale) {
            Unsafe unsafe2 = unsafe;
            unsafe2.putObjectVolatile(bd2, intValOffset, intVal);
            unsafe2.putIntVolatile(bd2, scaleOffset, scale);
            unsafe2.putLongVolatile(bd2, intCompactOffset, BigDecimal.compactValFor(intVal));
        }

        static void setIntValVolatile(BigDecimal bd2, BigInteger val) {
            unsafe.putObjectVolatile(bd2, intValOffset, val);
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        BigInteger serialIntVal = (BigInteger) fields.get("intVal", (Object) null);
        if (serialIntVal == null) {
            throw new StreamCorruptedException("Null or missing intVal in BigDecimal stream");
        }
        BigInteger serialIntVal2 = toStrictBigInteger(serialIntVal);
        int serialScale = fields.get(n.f28264e, 0);
        UnsafeHolder.setIntValAndScale(this, serialIntVal2, serialScale);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialized BigDecimal objects need data");
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        if (this.intVal == null) {
            UnsafeHolder.setIntValVolatile(this, BigInteger.valueOf(this.intCompact));
        }
        s2.defaultWriteObject();
    }

    static int longDigitLength(long x10) {
        if (x10 < 0) {
            x10 = -x10;
        }
        if (x10 < 10) {
            return 1;
        }
        int r10 = (((64 - Long.numberOfLeadingZeros(x10)) + 1) * MetricsProto.MetricsEvent.ACTION_APP_STOP_AND_BACKGROUND_CHECK) >>> 12;
        long[] tab = LONG_TEN_POWERS_TABLE;
        return (r10 >= tab.length || x10 < tab[r10]) ? r10 : r10 + 1;
    }

    private static int bigDigitLength(BigInteger b4) {
        if (b4.signum == 0) {
            return 1;
        }
        int r10 = (int) (((b4.bitLength() + 1) * 646456993) >>> 31);
        return b4.compareMagnitude(bigTenToThe(r10)) < 0 ? r10 : r10 + 1;
    }

    private int checkScale(long val) {
        BigInteger b4;
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (this.intCompact != 0 && ((b4 = this.intVal) == null || b4.signum() != 0)) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long compactValFor(BigInteger b4) {
        int[] m10 = b4.mag;
        int len = m10.length;
        if (len == 0) {
            return 0L;
        }
        int d10 = m10[0];
        if (len <= 2) {
            if (len == 2 && d10 < 0) {
                return Long.MIN_VALUE;
            }
            long u10 = len == 2 ? (m10[1] & 4294967295L) + (d10 << 32) : d10 & 4294967295L;
            return b4.signum < 0 ? -u10 : u10;
        }
        return Long.MIN_VALUE;
    }

    private static int longCompareMagnitude(long x10, long y10) {
        if (x10 < 0) {
            x10 = -x10;
        }
        if (y10 < 0) {
            y10 = -y10;
        }
        if (x10 < y10) {
            return -1;
        }
        return x10 == y10 ? 0 : 1;
    }

    private static int saturateLong(long s2) {
        int i10 = (int) s2;
        return s2 == ((long) i10) ? i10 : s2 < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    private static void print(String name, BigDecimal bd2) {
        System.err.format("%s:\tintCompact %d\tintVal %d\tscale %d\tprecision %d%n", name, Long.valueOf(bd2.intCompact), bd2.intVal, Integer.valueOf(bd2.scale), Integer.valueOf(bd2.precision));
    }

    private BigDecimal audit() {
        if (this.intCompact == Long.MIN_VALUE) {
            BigInteger bigInteger = this.intVal;
            if (bigInteger == null) {
                print("audit", this);
                throw new AssertionError((Object) "null intVal");
            }
            int i10 = this.precision;
            if (i10 > 0 && i10 != bigDigitLength(bigInteger)) {
                print("audit", this);
                throw new AssertionError((Object) "precision mismatch");
            }
        } else {
            BigInteger bigInteger2 = this.intVal;
            if (bigInteger2 != null) {
                long val = bigInteger2.longValue();
                if (val != this.intCompact) {
                    print("audit", this);
                    throw new AssertionError((Object) ("Inconsistent state, intCompact=" + this.intCompact + "\t intVal=" + val));
                }
            }
            int i11 = this.precision;
            if (i11 > 0 && i11 != longDigitLength(this.intCompact)) {
                print("audit", this);
                throw new AssertionError((Object) "precision mismatch");
            }
        }
        return this;
    }

    private static int checkScaleNonZero(long val) {
        int asInt = (int) val;
        if (asInt != val) {
            throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
        }
        return asInt;
    }

    private static int checkScale(long intCompact, long val) {
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (intCompact != 0) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    private static int checkScale(BigInteger intVal, long val) {
        int asInt = (int) val;
        if (asInt != val) {
            asInt = val > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (intVal.signum() != 0) {
                throw new ArithmeticException(asInt > 0 ? "Underflow" : "Overflow");
            }
        }
        return asInt;
    }

    private static BigDecimal doRound(BigDecimal val, MathContext mc2) {
        int mcp = mc2.precision;
        boolean wasDivided = false;
        if (mcp <= 0) {
            return val;
        }
        BigInteger intVal = val.intVal;
        long compactVal = val.intCompact;
        int scale = val.scale;
        int prec = val.precision();
        int mode = mc2.roundingMode.oldMode;
        if (compactVal == Long.MIN_VALUE) {
            int drop = prec - mcp;
            while (true) {
                if (drop <= 0) {
                    break;
                }
                scale = checkScaleNonZero(scale - drop);
                intVal = divideAndRoundByTenPow(intVal, drop, mode);
                wasDivided = true;
                compactVal = compactValFor(intVal);
                if (compactVal != Long.MIN_VALUE) {
                    prec = longDigitLength(compactVal);
                    break;
                }
                prec = bigDigitLength(intVal);
                drop = prec - mcp;
            }
        }
        if (compactVal != Long.MIN_VALUE) {
            int drop2 = prec - mcp;
            while (drop2 > 0) {
                scale = checkScaleNonZero(scale - drop2);
                compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop2], mc2.roundingMode.oldMode);
                wasDivided = true;
                prec = longDigitLength(compactVal);
                drop2 = prec - mcp;
                intVal = null;
            }
        }
        return wasDivided ? new BigDecimal(intVal, compactVal, scale, prec) : val;
    }

    private static BigDecimal doRound(long compactVal, int scale, MathContext mc2) {
        int mcp = mc2.precision;
        if (mcp > 0 && mcp < 19) {
            int prec = longDigitLength(compactVal);
            int drop = prec - mcp;
            while (drop > 0) {
                scale = checkScaleNonZero(scale - drop);
                compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop], mc2.roundingMode.oldMode);
                prec = longDigitLength(compactVal);
                drop = prec - mcp;
            }
            return valueOf(compactVal, scale, prec);
        }
        return valueOf(compactVal, scale);
    }

    private static BigDecimal doRound(BigInteger intVal, int scale, MathContext mc2) {
        int mcp = mc2.precision;
        int prec = 0;
        if (mcp > 0) {
            long compactVal = compactValFor(intVal);
            int mode = mc2.roundingMode.oldMode;
            if (compactVal == Long.MIN_VALUE) {
                prec = bigDigitLength(intVal);
                int drop = prec - mcp;
                while (drop > 0) {
                    scale = checkScaleNonZero(scale - drop);
                    intVal = divideAndRoundByTenPow(intVal, drop, mode);
                    compactVal = compactValFor(intVal);
                    if (compactVal != Long.MIN_VALUE) {
                        break;
                    }
                    prec = bigDigitLength(intVal);
                    drop = prec - mcp;
                }
            }
            if (compactVal != Long.MIN_VALUE) {
                int prec2 = longDigitLength(compactVal);
                int drop2 = prec2 - mcp;
                while (drop2 > 0) {
                    scale = checkScaleNonZero(scale - drop2);
                    compactVal = divideAndRound(compactVal, LONG_TEN_POWERS_TABLE[drop2], mc2.roundingMode.oldMode);
                    prec2 = longDigitLength(compactVal);
                    drop2 = prec2 - mcp;
                }
                return valueOf(compactVal, scale, prec2);
            }
        }
        return new BigDecimal(intVal, Long.MIN_VALUE, scale, prec);
    }

    private static BigInteger divideAndRoundByTenPow(BigInteger intVal, int tenPow, int roundingMode) {
        long[] jArr = LONG_TEN_POWERS_TABLE;
        if (tenPow < jArr.length) {
            return divideAndRound(intVal, jArr[tenPow], roundingMode);
        }
        return divideAndRound(intVal, bigTenToThe(tenPow), roundingMode);
    }

    private static BigDecimal divideAndRound(long ldividend, long ldivisor, int scale, int roundingMode, int preferredScale) {
        long q10 = ldividend / ldivisor;
        if (roundingMode == 1 && scale == preferredScale) {
            return valueOf(q10, scale);
        }
        long r10 = ldividend % ldivisor;
        int qsign = ((ldividend > 0L ? 1 : (ldividend == 0L ? 0 : -1)) < 0) != (ldivisor < 0) ? -1 : 1;
        if (r10 != 0) {
            boolean increment = needIncrement(ldivisor, roundingMode, qsign, q10, r10);
            return valueOf(increment ? qsign + q10 : q10, scale);
        }
        if (preferredScale != scale) {
            return createAndStripZerosToMatchScale(q10, scale, preferredScale);
        }
        return valueOf(q10, scale);
    }

    private static long divideAndRound(long ldividend, long ldivisor, int roundingMode) {
        long q10 = ldividend / ldivisor;
        if (roundingMode == 1) {
            return q10;
        }
        long r10 = ldividend % ldivisor;
        int qsign = ((ldividend > 0L ? 1 : (ldividend == 0L ? 0 : -1)) < 0) != (ldivisor < 0) ? -1 : 1;
        if (r10 != 0) {
            boolean increment = needIncrement(ldivisor, roundingMode, qsign, q10, r10);
            return increment ? qsign + q10 : q10;
        }
        return q10;
    }

    private static boolean commonNeedIncrement(int roundingMode, int qsign, int cmpFracHalf, boolean oddQuot) {
        switch (roundingMode) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return qsign > 0;
            case 3:
                return qsign < 0;
            case 4:
            case 5:
            case 6:
            default:
                if (cmpFracHalf < 0) {
                    return false;
                }
                if (cmpFracHalf > 0) {
                    return true;
                }
                switch (roundingMode) {
                    case 4:
                        return true;
                    case 5:
                        return false;
                    case 6:
                        return oddQuot;
                    default:
                        throw new AssertionError((Object) ("Unexpected rounding mode" + roundingMode));
                }
            case 7:
                throw new ArithmeticException("Rounding necessary");
        }
    }

    private static boolean needIncrement(long ldivisor, int roundingMode, int qsign, long q10, long r10) {
        int cmpFracHalf;
        if (r10 <= HALF_LONG_MIN_VALUE || r10 > HALF_LONG_MAX_VALUE) {
            cmpFracHalf = 1;
        } else {
            cmpFracHalf = longCompareMagnitude(2 * r10, ldivisor);
        }
        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, (1 & q10) != 0);
    }

    private static BigInteger divideAndRound(BigInteger bdividend, long ldivisor, int roundingMode) {
        MutableBigInteger mdividend = new MutableBigInteger(bdividend.mag);
        MutableBigInteger mq = new MutableBigInteger();
        long r10 = mdividend.divide(ldivisor, mq);
        boolean isRemainderZero = r10 == 0;
        int qsign = ldivisor < 0 ? -bdividend.signum : bdividend.signum;
        if (!isRemainderZero && needIncrement(ldivisor, roundingMode, qsign, mq, r10)) {
            mq.add(MutableBigInteger.ONE);
        }
        return mq.toBigInteger(qsign);
    }

    private static BigDecimal divideAndRound(BigInteger bdividend, long ldivisor, int scale, int roundingMode, int preferredScale) {
        MutableBigInteger mdividend = new MutableBigInteger(bdividend.mag);
        MutableBigInteger mq = new MutableBigInteger();
        long r10 = mdividend.divide(ldivisor, mq);
        boolean isRemainderZero = r10 == 0;
        int qsign = ldivisor < 0 ? -bdividend.signum : bdividend.signum;
        if (!isRemainderZero) {
            if (needIncrement(ldivisor, roundingMode, qsign, mq, r10)) {
                mq.add(MutableBigInteger.ONE);
            }
            return mq.toBigDecimal(qsign, scale);
        }
        if (preferredScale != scale) {
            long compactVal = mq.toCompactValue(qsign);
            if (compactVal != Long.MIN_VALUE) {
                return createAndStripZerosToMatchScale(compactVal, scale, preferredScale);
            }
            BigInteger intVal = mq.toBigInteger(qsign);
            return createAndStripZerosToMatchScale(intVal, scale, preferredScale);
        }
        return mq.toBigDecimal(qsign, scale);
    }

    private static boolean needIncrement(long ldivisor, int roundingMode, int qsign, MutableBigInteger mq, long r10) {
        int cmpFracHalf;
        if (r10 <= HALF_LONG_MIN_VALUE || r10 > HALF_LONG_MAX_VALUE) {
            cmpFracHalf = 1;
        } else {
            cmpFracHalf = longCompareMagnitude(2 * r10, ldivisor);
        }
        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, mq.isOdd());
    }

    private static BigInteger divideAndRound(BigInteger bdividend, BigInteger bdivisor, int roundingMode) {
        MutableBigInteger mdividend = new MutableBigInteger(bdividend.mag);
        MutableBigInteger mq = new MutableBigInteger();
        MutableBigInteger mdivisor = new MutableBigInteger(bdivisor.mag);
        MutableBigInteger mr = mdividend.divide(mdivisor, mq);
        boolean isRemainderZero = mr.isZero();
        int qsign = bdividend.signum != bdivisor.signum ? -1 : 1;
        if (!isRemainderZero && needIncrement(mdivisor, roundingMode, qsign, mq, mr)) {
            mq.add(MutableBigInteger.ONE);
        }
        return mq.toBigInteger(qsign);
    }

    private static BigDecimal divideAndRound(BigInteger bdividend, BigInteger bdivisor, int scale, int roundingMode, int preferredScale) {
        MutableBigInteger mdividend = new MutableBigInteger(bdividend.mag);
        MutableBigInteger mq = new MutableBigInteger();
        MutableBigInteger mdivisor = new MutableBigInteger(bdivisor.mag);
        MutableBigInteger mr = mdividend.divide(mdivisor, mq);
        boolean isRemainderZero = mr.isZero();
        int qsign = bdividend.signum != bdivisor.signum ? -1 : 1;
        if (!isRemainderZero) {
            if (needIncrement(mdivisor, roundingMode, qsign, mq, mr)) {
                mq.add(MutableBigInteger.ONE);
            }
            return mq.toBigDecimal(qsign, scale);
        }
        if (preferredScale != scale) {
            long compactVal = mq.toCompactValue(qsign);
            if (compactVal != Long.MIN_VALUE) {
                return createAndStripZerosToMatchScale(compactVal, scale, preferredScale);
            }
            BigInteger intVal = mq.toBigInteger(qsign);
            return createAndStripZerosToMatchScale(intVal, scale, preferredScale);
        }
        return mq.toBigDecimal(qsign, scale);
    }

    private static boolean needIncrement(MutableBigInteger mdivisor, int roundingMode, int qsign, MutableBigInteger mq, MutableBigInteger mr) {
        int cmpFracHalf = mr.compareHalf(mdivisor);
        return commonNeedIncrement(roundingMode, qsign, cmpFracHalf, mq.isOdd());
    }

    private static BigDecimal createAndStripZerosToMatchScale(BigInteger intVal, int scale, long preferredScale) {
        while (intVal.compareMagnitude(BigInteger.TEN) >= 0 && scale > preferredScale && !intVal.testBit(0)) {
            BigInteger[] qr = intVal.divideAndRemainder(BigInteger.TEN);
            if (qr[1].signum() != 0) {
                break;
            }
            intVal = qr[0];
            scale = checkScale(intVal, scale - 1);
        }
        return valueOf(intVal, scale, 0);
    }

    private static BigDecimal createAndStripZerosToMatchScale(long compactVal, int scale, long preferredScale) {
        while (Math.abs(compactVal) >= 10 && scale > preferredScale && (compactVal & 1) == 0) {
            long r10 = compactVal % 10;
            if (r10 != 0) {
                break;
            }
            compactVal /= 10;
            scale = checkScale(compactVal, scale - 1);
        }
        return valueOf(compactVal, scale);
    }

    private static BigDecimal stripZerosToMatchScale(BigInteger intVal, long intCompact, int scale, int preferredScale) {
        if (intCompact != Long.MIN_VALUE) {
            return createAndStripZerosToMatchScale(intCompact, scale, preferredScale);
        }
        return createAndStripZerosToMatchScale(intVal == null ? INFLATED_BIGINT : intVal, scale, preferredScale);
    }

    private static long add(long xs, long ys) {
        long sum = xs + ys;
        if (((sum ^ xs) & (sum ^ ys)) >= 0) {
            return sum;
        }
        return Long.MIN_VALUE;
    }

    private static BigDecimal add(long xs, long ys, int scale) {
        long sum = add(xs, ys);
        if (sum != Long.MIN_VALUE) {
            return valueOf(sum, scale);
        }
        return new BigDecimal(BigInteger.valueOf(xs).add(ys), scale);
    }

    private static BigDecimal add(long xs, int scale1, long ys, int scale2) {
        long sdiff = scale1 - scale2;
        if (sdiff == 0) {
            return add(xs, ys, scale1);
        }
        if (sdiff < 0) {
            int raise = checkScale(xs, -sdiff);
            long scaledX = longMultiplyPowerTen(xs, raise);
            if (scaledX != Long.MIN_VALUE) {
                return add(scaledX, ys, scale2);
            }
            BigInteger bigsum = bigMultiplyPowerTen(xs, raise).add(ys);
            return (xs ^ ys) >= 0 ? new BigDecimal(bigsum, Long.MIN_VALUE, scale2, 0) : valueOf(bigsum, scale2, 0);
        }
        int raise2 = checkScale(ys, sdiff);
        long scaledY = longMultiplyPowerTen(ys, raise2);
        if (scaledY == Long.MIN_VALUE) {
            BigInteger bigsum2 = bigMultiplyPowerTen(ys, raise2).add(xs);
            return (xs ^ ys) >= 0 ? new BigDecimal(bigsum2, Long.MIN_VALUE, scale1, 0) : valueOf(bigsum2, scale1, 0);
        }
        return add(xs, scaledY, scale1);
    }

    private static BigDecimal add(long xs, int scale1, BigInteger snd, int scale2) {
        BigInteger sum;
        BigInteger sum2;
        int rscale = scale1;
        long sdiff = rscale - scale2;
        boolean sameSigns = Long.signum(xs) == snd.signum;
        if (sdiff < 0) {
            int raise = checkScale(xs, -sdiff);
            rscale = scale2;
            long scaledX = longMultiplyPowerTen(xs, raise);
            if (scaledX == Long.MIN_VALUE) {
                sum2 = snd.add(bigMultiplyPowerTen(xs, raise));
            } else {
                sum2 = snd.add(scaledX);
            }
            sum = sum2;
        } else {
            sum = bigMultiplyPowerTen(snd, checkScale(snd, sdiff)).add(xs);
        }
        if (sameSigns) {
            return new BigDecimal(sum, Long.MIN_VALUE, rscale, 0);
        }
        return valueOf(sum, rscale, 0);
    }

    private static BigDecimal add(BigInteger fst, int scale1, BigInteger snd, int scale2) {
        int rscale = scale1;
        long sdiff = rscale - scale2;
        if (sdiff != 0) {
            if (sdiff < 0) {
                int raise = checkScale(fst, -sdiff);
                rscale = scale2;
                fst = bigMultiplyPowerTen(fst, raise);
            } else {
                int raise2 = checkScale(snd, sdiff);
                snd = bigMultiplyPowerTen(snd, raise2);
            }
        }
        BigInteger sum = fst.add(snd);
        if (fst.signum == snd.signum) {
            return new BigDecimal(sum, Long.MIN_VALUE, rscale, 0);
        }
        return valueOf(sum, rscale, 0);
    }

    private static BigInteger bigMultiplyPowerTen(long value, int n10) {
        if (n10 <= 0) {
            return BigInteger.valueOf(value);
        }
        return bigTenToThe(n10).multiply(value);
    }

    private static BigInteger bigMultiplyPowerTen(BigInteger value, int n10) {
        if (n10 <= 0) {
            return value;
        }
        long[] jArr = LONG_TEN_POWERS_TABLE;
        if (n10 < jArr.length) {
            return value.multiply(jArr[n10]);
        }
        return value.multiply(bigTenToThe(n10));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigDecimal divideSmallFastPath(long r29, int r31, long r32, int r34, long r35, java.math.MathContext r37) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.divideSmallFastPath(long, int, long, int, long, java.math.MathContext):java.math.BigDecimal");
    }

    private static BigDecimal divide(long xs, int xscale, long ys, int yscale, long preferredScale, MathContext mc2) {
        int yscale2;
        MathContext mathContext;
        BigDecimal quotient;
        int scl;
        int roundingMode;
        int mcp;
        int yscale3;
        long j10;
        int mcp2 = mc2.precision;
        if (xscale <= yscale && yscale < 18 && mcp2 < 18) {
            return divideSmallFastPath(xs, xscale, ys, yscale, preferredScale, mc2);
        }
        if (compareMagnitudeNormalized(xs, xscale, ys, yscale) <= 0) {
            yscale2 = yscale;
        } else {
            yscale2 = yscale - 1;
        }
        int roundingMode2 = mc2.roundingMode.oldMode;
        int scl2 = checkScaleNonZero(((preferredScale + yscale2) - xscale) + mcp2);
        if (checkScaleNonZero((mcp2 + yscale2) - xscale) > 0) {
            int raise = checkScaleNonZero((mcp2 + yscale2) - xscale);
            long scaledXs = longMultiplyPowerTen(xs, raise);
            if (scaledXs == Long.MIN_VALUE) {
                BigInteger rb2 = bigMultiplyPowerTen(xs, raise);
                scl = scl2;
                roundingMode = roundingMode2;
                quotient = divideAndRound(rb2, ys, scl2, roundingMode2, checkScaleNonZero(preferredScale));
                mcp = mcp2;
                yscale3 = yscale2;
                j10 = ys;
            } else {
                scl = scl2;
                roundingMode = roundingMode2;
                mcp = mcp2;
                yscale3 = yscale2;
                j10 = ys;
                quotient = divideAndRound(scaledXs, ys, scl, roundingMode, checkScaleNonZero(preferredScale));
            }
            mathContext = mc2;
        } else {
            int scl3 = yscale2;
            int newScale = checkScaleNonZero(xscale - mcp2);
            if (newScale == scl3) {
                mathContext = mc2;
                quotient = divideAndRound(xs, ys, scl2, roundingMode2, checkScaleNonZero(preferredScale));
            } else {
                mathContext = mc2;
                int raise2 = checkScaleNonZero(newScale - scl3);
                long scaledYs = longMultiplyPowerTen(ys, raise2);
                if (scaledYs == Long.MIN_VALUE) {
                    BigInteger rb3 = bigMultiplyPowerTen(ys, raise2);
                    quotient = divideAndRound(BigInteger.valueOf(xs), rb3, scl2, roundingMode2, checkScaleNonZero(preferredScale));
                } else {
                    quotient = divideAndRound(xs, scaledYs, scl2, roundingMode2, checkScaleNonZero(preferredScale));
                }
            }
        }
        return doRound(quotient, mathContext);
    }

    private static BigDecimal divide(BigInteger xs, int xscale, long ys, int yscale, long preferredScale, MathContext mc2) {
        int yscale2;
        BigDecimal quotient;
        if ((-compareMagnitudeNormalized(ys, yscale, xs, xscale)) <= 0) {
            yscale2 = yscale;
        } else {
            yscale2 = yscale - 1;
        }
        int mcp = mc2.precision;
        int roundingMode = mc2.roundingMode.oldMode;
        int scl = checkScaleNonZero(((preferredScale + yscale2) - xscale) + mcp);
        if (checkScaleNonZero((mcp + yscale2) - xscale) > 0) {
            BigInteger rb2 = bigMultiplyPowerTen(xs, checkScaleNonZero((mcp + yscale2) - xscale));
            quotient = divideAndRound(rb2, ys, scl, roundingMode, checkScaleNonZero(preferredScale));
        } else {
            int newScale = checkScaleNonZero(xscale - mcp);
            if (newScale == yscale2) {
                quotient = divideAndRound(xs, ys, scl, roundingMode, checkScaleNonZero(preferredScale));
            } else {
                int raise = checkScaleNonZero(newScale - yscale2);
                long scaledYs = longMultiplyPowerTen(ys, raise);
                if (scaledYs == Long.MIN_VALUE) {
                    BigInteger rb3 = bigMultiplyPowerTen(ys, raise);
                    quotient = divideAndRound(xs, rb3, scl, roundingMode, checkScaleNonZero(preferredScale));
                } else {
                    quotient = divideAndRound(xs, scaledYs, scl, roundingMode, checkScaleNonZero(preferredScale));
                }
            }
        }
        return doRound(quotient, mc2);
    }

    private static BigDecimal divide(long xs, int xscale, BigInteger ys, int yscale, long preferredScale, MathContext mc2) {
        BigDecimal quotient;
        if (compareMagnitudeNormalized(xs, xscale, ys, yscale) > 0) {
            yscale--;
        }
        int mcp = mc2.precision;
        int roundingMode = mc2.roundingMode.oldMode;
        int scl = checkScaleNonZero(((yscale + preferredScale) - xscale) + mcp);
        if (checkScaleNonZero((mcp + yscale) - xscale) > 0) {
            int raise = checkScaleNonZero((mcp + yscale) - xscale);
            BigInteger rb2 = bigMultiplyPowerTen(xs, raise);
            quotient = divideAndRound(rb2, ys, scl, roundingMode, checkScaleNonZero(preferredScale));
        } else {
            int newScale = checkScaleNonZero(xscale - mcp);
            int raise2 = checkScaleNonZero(newScale - yscale);
            BigInteger rb3 = bigMultiplyPowerTen(ys, raise2);
            quotient = divideAndRound(BigInteger.valueOf(xs), rb3, scl, roundingMode, checkScaleNonZero(preferredScale));
        }
        return doRound(quotient, mc2);
    }

    private static BigDecimal divide(BigInteger xs, int xscale, BigInteger ys, int yscale, long preferredScale, MathContext mc2) {
        BigDecimal quotient;
        if (compareMagnitudeNormalized(xs, xscale, ys, yscale) > 0) {
            yscale--;
        }
        int mcp = mc2.precision;
        int roundingMode = mc2.roundingMode.oldMode;
        int scl = checkScaleNonZero(((yscale + preferredScale) - xscale) + mcp);
        if (checkScaleNonZero((mcp + yscale) - xscale) > 0) {
            int raise = checkScaleNonZero((mcp + yscale) - xscale);
            BigInteger rb2 = bigMultiplyPowerTen(xs, raise);
            quotient = divideAndRound(rb2, ys, scl, roundingMode, checkScaleNonZero(preferredScale));
        } else {
            int newScale = checkScaleNonZero(xscale - mcp);
            int raise2 = checkScaleNonZero(newScale - yscale);
            BigInteger rb3 = bigMultiplyPowerTen(ys, raise2);
            quotient = divideAndRound(xs, rb3, scl, roundingMode, checkScaleNonZero(preferredScale));
        }
        return doRound(quotient, mc2);
    }

    private static BigDecimal multiplyDivideAndRound(long dividend0, long dividend1, long divisor, int scale, int roundingMode, int preferredScale) {
        int qsign = Long.signum(dividend0) * Long.signum(dividend1) * Long.signum(divisor);
        long dividend02 = Math.abs(dividend0);
        long dividend12 = Math.abs(dividend1);
        long divisor2 = Math.abs(divisor);
        long d0_hi = dividend02 >>> 32;
        long d0_lo = dividend02 & 4294967295L;
        long d1_hi = dividend12 >>> 32;
        long d1_lo = dividend12 & 4294967295L;
        long product = d0_lo * d1_lo;
        long d02 = product & 4294967295L;
        long d12 = product >>> 32;
        long product2 = (d0_hi * d1_lo) + d12;
        long d13 = product2 >>> 32;
        long product3 = (d0_lo * d1_hi) + (product2 & 4294967295L);
        long product4 = product3 & 4294967295L;
        long d14 = product3 >>> 32;
        long d22 = d13 + d14;
        long d32 = d22 >>> 32;
        long product5 = (d0_hi * d1_hi) + (d22 & 4294967295L);
        long dividendHi = make64(((product5 >>> 32) + d32) & 4294967295L, product5 & 4294967295L);
        long dividendLo = make64(product4, d02);
        return divideAndRound128(dividendHi, dividendLo, divisor2, qsign, scale, roundingMode, preferredScale);
    }

    private static BigDecimal divideAndRound128(long dividendHi, long dividendLo, long divisor, int sign, int scale, int roundingMode, int preferredScale) {
        long q12;
        long r_tmp;
        long tmp;
        int shift;
        long q13;
        long r_tmp2;
        long q02;
        long tmp2;
        long r_tmp3;
        int i10;
        int i11;
        MutableBigInteger mq;
        if (dividendHi >= divisor) {
            return null;
        }
        int shift2 = Long.numberOfLeadingZeros(divisor);
        long divisor2 = divisor << shift2;
        long v12 = divisor2 >>> 32;
        long v02 = divisor2 & 4294967295L;
        long tmp3 = dividendLo << shift2;
        long divisor3 = tmp3 >>> 32;
        long u02 = tmp3 & 4294967295L;
        long tmp4 = (dividendHi << shift2) | (dividendLo >>> (64 - shift2));
        long u22 = tmp4 & 4294967295L;
        if (v12 == 1) {
            q12 = tmp4;
            r_tmp = 0;
        } else if (tmp4 >= 0) {
            q12 = tmp4 / v12;
            r_tmp = tmp4 - (q12 * v12);
        } else {
            long[] rq = divRemNegativeLong(tmp4, v12);
            q12 = rq[1];
            r_tmp = rq[0];
        }
        while (true) {
            if (q12 < 4294967296L) {
                tmp = tmp4;
                shift = shift2;
                if (!unsignedLongCompare(q12 * v02, make64(r_tmp, divisor3))) {
                    q13 = q12;
                    break;
                }
            } else {
                tmp = tmp4;
                shift = shift2;
            }
            q12--;
            r_tmp += v12;
            if (r_tmp >= 4294967296L) {
                q13 = q12;
                break;
            }
            tmp4 = tmp;
            shift2 = shift;
            u02 = u02;
        }
        long tmp5 = mulsub(u22, divisor3, v12, v02, q13);
        long u12 = tmp5 & 4294967295L;
        if (v12 == 1) {
            q02 = tmp5;
            r_tmp2 = 0;
        } else if (tmp5 >= 0) {
            q02 = tmp5 / v12;
            r_tmp2 = tmp5 - (q02 * v12);
        } else {
            long[] rq2 = divRemNegativeLong(tmp5, v12);
            long q03 = rq2[1];
            r_tmp2 = rq2[0];
            q02 = q03;
        }
        while (true) {
            if (q02 < 4294967296L) {
                tmp2 = tmp5;
                if (!unsignedLongCompare(q02 * v02, make64(r_tmp2, u02))) {
                    r_tmp3 = r_tmp2;
                    break;
                }
            } else {
                tmp2 = tmp5;
            }
            q02--;
            r_tmp2 += v12;
            if (r_tmp2 >= 4294967296L) {
                r_tmp3 = r_tmp2;
                break;
            }
            u02 = u02;
            tmp5 = tmp2;
        }
        if (((int) q13) < 0) {
            MutableBigInteger mq2 = new MutableBigInteger(new int[]{(int) q13, (int) q02});
            if (roundingMode == 1) {
                i10 = scale;
                i11 = preferredScale;
                if (i10 == i11) {
                    return mq2.toBigDecimal(sign, i10);
                }
            } else {
                i10 = scale;
                i11 = preferredScale;
            }
            long r10 = mulsub(u12, u02, v12, v02, q02) >>> shift;
            if (r10 != 0) {
                int i12 = i10;
                if (!needIncrement(divisor2 >>> shift, roundingMode, sign, mq2, r10)) {
                    mq = mq2;
                } else {
                    mq = mq2;
                    mq.add(MutableBigInteger.ONE);
                }
                return mq.toBigDecimal(sign, i12);
            }
            int i13 = i11;
            int i14 = i10;
            if (i13 != i14) {
                BigInteger intVal = mq2.toBigInteger(sign);
                return createAndStripZerosToMatchScale(intVal, i14, i13);
            }
            return mq2.toBigDecimal(sign, i14);
        }
        long u03 = u02;
        long q10 = make64(q13, q02) * sign;
        if (roundingMode == 1 && scale == preferredScale) {
            return valueOf(q10, scale);
        }
        long r11 = mulsub(u12, u03, v12, v02, q02) >>> shift;
        if (r11 != 0) {
            boolean increment = needIncrement(divisor2 >>> shift, roundingMode, sign, q10, r11);
            return valueOf(increment ? sign + q10 : q10, scale);
        }
        if (preferredScale != scale) {
            return createAndStripZerosToMatchScale(q10, scale, preferredScale);
        }
        return valueOf(q10, scale);
    }

    private static BigDecimal roundedTenPower(int qsign, int raise, int scale, int preferredScale) {
        if (scale > preferredScale) {
            int diff = scale - preferredScale;
            if (diff < raise) {
                return scaledTenPow(raise - diff, qsign, preferredScale);
            }
            return valueOf(qsign, scale - raise);
        }
        return scaledTenPow(raise, qsign, scale);
    }

    static BigDecimal scaledTenPow(int n10, int sign, int scale) {
        long[] jArr = LONG_TEN_POWERS_TABLE;
        if (n10 < jArr.length) {
            return valueOf(sign * jArr[n10], scale);
        }
        BigInteger unscaledVal = bigTenToThe(n10);
        if (sign == -1) {
            unscaledVal = unscaledVal.negate();
        }
        return new BigDecimal(unscaledVal, Long.MIN_VALUE, scale, n10 + 1);
    }

    private static long[] divRemNegativeLong(long n10, long d10) {
        long q10 = (n10 >>> 1) / (d10 >>> 1);
        long r10 = n10 - (q10 * d10);
        while (r10 < 0) {
            r10 += d10;
            q10--;
        }
        while (r10 >= d10) {
            r10 -= d10;
            q10++;
        }
        return new long[]{r10, q10};
    }

    private static long make64(long hi, long lo) {
        return (hi << 32) | lo;
    }

    private static long mulsub(long u12, long u02, long v12, long v02, long q02) {
        long tmp = u02 - (q02 * v02);
        return make64(((tmp >>> 32) + u12) - (q02 * v12), 4294967295L & tmp);
    }

    private static boolean unsignedLongCompare(long one, long two) {
        return one + Long.MIN_VALUE > Long.MIN_VALUE + two;
    }

    private static boolean unsignedLongCompareEq(long one, long two) {
        return one + Long.MIN_VALUE >= Long.MIN_VALUE + two;
    }

    private static int compareMagnitudeNormalized(long xs, int xscale, long ys, int yscale) {
        int sdiff = xscale - yscale;
        if (sdiff != 0) {
            if (sdiff < 0) {
                xs = longMultiplyPowerTen(xs, -sdiff);
            } else {
                ys = longMultiplyPowerTen(ys, sdiff);
            }
        }
        if (xs == Long.MIN_VALUE) {
            return 1;
        }
        if (ys != Long.MIN_VALUE) {
            return longCompareMagnitude(xs, ys);
        }
        return -1;
    }

    private static int compareMagnitudeNormalized(long xs, int xscale, BigInteger ys, int yscale) {
        int sdiff;
        if (xs != 0 && (sdiff = xscale - yscale) < 0 && longMultiplyPowerTen(xs, -sdiff) == Long.MIN_VALUE) {
            return bigMultiplyPowerTen(xs, -sdiff).compareMagnitude(ys);
        }
        return -1;
    }

    private static int compareMagnitudeNormalized(BigInteger xs, int xscale, BigInteger ys, int yscale) {
        int sdiff = xscale - yscale;
        if (sdiff < 0) {
            return bigMultiplyPowerTen(xs, -sdiff).compareMagnitude(ys);
        }
        return xs.compareMagnitude(bigMultiplyPowerTen(ys, sdiff));
    }

    private static long multiply(long x10, long y10) {
        long product = x10 * y10;
        long ax = Math.abs(x10);
        long ay = Math.abs(y10);
        if (((ax | ay) >>> 31) == 0 || y10 == 0 || product / y10 == x10) {
            return product;
        }
        return Long.MIN_VALUE;
    }

    private static BigDecimal multiply(long x10, long y10, int scale) {
        long product = multiply(x10, y10);
        if (product != Long.MIN_VALUE) {
            return valueOf(product, scale);
        }
        return new BigDecimal(BigInteger.valueOf(x10).multiply(y10), Long.MIN_VALUE, scale, 0);
    }

    private static BigDecimal multiply(long x10, BigInteger y10, int scale) {
        if (x10 == 0) {
            return zeroValueOf(scale);
        }
        return new BigDecimal(y10.multiply(x10), Long.MIN_VALUE, scale, 0);
    }

    private static BigDecimal multiply(BigInteger x10, BigInteger y10, int scale) {
        return new BigDecimal(x10.multiply(y10), Long.MIN_VALUE, scale, 0);
    }

    private static BigDecimal multiplyAndRound(long x10, long y10, int scale, MathContext mc2) {
        long x11;
        long y11;
        int rsign;
        long product = multiply(x10, y10);
        if (product != Long.MIN_VALUE) {
            return doRound(product, scale, mc2);
        }
        int rsign2 = 1;
        if (x10 >= 0) {
            x11 = x10;
        } else {
            rsign2 = -1;
            x11 = -x10;
        }
        if (y10 >= 0) {
            y11 = y10;
            rsign = rsign2;
        } else {
            y11 = -y10;
            rsign = rsign2 * (-1);
        }
        long m0_hi = x11 >>> 32;
        long m0_lo = x11 & 4294967295L;
        long m1_hi = y11 >>> 32;
        long m1_lo = y11 & 4294967295L;
        long product2 = m0_lo * m1_lo;
        long m02 = product2 & 4294967295L;
        long m12 = product2 >>> 32;
        long product3 = (m0_hi * m1_lo) + m12;
        long m13 = product3 >>> 32;
        long product4 = (m0_lo * m1_hi) + (product3 & 4294967295L);
        long product5 = product4 & 4294967295L;
        long m14 = product4 >>> 32;
        long m22 = m13 + m14;
        long m32 = m22 >>> 32;
        long product6 = (m0_hi * m1_hi) + (m22 & 4294967295L);
        long mHi = make64(((product6 >>> 32) + m32) & 4294967295L, product6 & 4294967295L);
        long mLo = make64(product5, m02);
        BigDecimal res = doRound128(mHi, mLo, rsign, scale, mc2);
        if (res != null) {
            return res;
        }
        return doRound(new BigDecimal(BigInteger.valueOf(x11).multiply(rsign * y11), Long.MIN_VALUE, scale, 0), mc2);
    }

    private static BigDecimal multiplyAndRound(long x10, BigInteger y10, int scale, MathContext mc2) {
        if (x10 == 0) {
            return zeroValueOf(scale);
        }
        return doRound(y10.multiply(x10), scale, mc2);
    }

    private static BigDecimal multiplyAndRound(BigInteger x10, BigInteger y10, int scale, MathContext mc2) {
        return doRound(x10.multiply(y10), scale, mc2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigDecimal doRound128(long r18, long r20, int r22, int r23, java.math.MathContext r24) {
        /*
            r0 = r24
            int r1 = r0.precision
            r2 = 0
            int r3 = precision(r18, r20)
            int r3 = r3 - r1
            r4 = r3
            if (r3 <= 0) goto L31
            long[] r3 = java.math.BigDecimal.LONG_TEN_POWERS_TABLE
            int r5 = r3.length
            if (r4 >= r5) goto L31
            r5 = r23
            long r6 = (long) r5
            long r8 = (long) r4
            long r6 = r6 - r8
            int r5 = checkScaleNonZero(r6)
            r12 = r3[r4]
            java.math.RoundingMode r3 = r0.roundingMode
            int r3 = r3.oldMode
            r8 = r18
            r10 = r20
            r14 = r22
            r15 = r5
            r16 = r3
            r17 = r5
            java.math.BigDecimal r2 = divideAndRound128(r8, r10, r12, r14, r15, r16, r17)
            goto L33
        L31:
            r5 = r23
        L33:
            if (r2 == 0) goto L3a
            java.math.BigDecimal r3 = doRound(r2, r0)
            return r3
        L3a:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.doRound128(long, long, int, int, java.math.MathContext):java.math.BigDecimal");
    }

    private static int precision(long hi, long lo) {
        if (hi == 0) {
            if (lo >= 0) {
                return longDigitLength(lo);
            }
            return unsignedLongCompareEq(lo, LONGLONG_TEN_POWERS_TABLE[0][1]) ? 20 : 19;
        }
        int r10 = (((128 - Long.numberOfLeadingZeros(hi)) + 1) * MetricsProto.MetricsEvent.ACTION_APP_STOP_AND_BACKGROUND_CHECK) >>> 12;
        int idx = r10 - 19;
        long[][] jArr = LONGLONG_TEN_POWERS_TABLE;
        if (idx < jArr.length) {
            long[] jArr2 = jArr[idx];
            if (!longLongCompareMagnitude(hi, lo, jArr2[0], jArr2[1])) {
                return r10 + 1;
            }
        }
        return r10;
    }

    private static boolean longLongCompareMagnitude(long hi0, long lo0, long hi1, long lo1) {
        return hi0 != hi1 ? hi0 < hi1 : lo0 + Long.MIN_VALUE < Long.MIN_VALUE + lo1;
    }

    private static BigDecimal divide(long dividend, int dividendScale, long divisor, int divisorScale, int scale, int roundingMode) {
        int raise;
        int raise2;
        if (checkScale(dividend, scale + divisorScale) > dividendScale) {
            int newScale = scale + divisorScale;
            int raise3 = newScale - dividendScale;
            long[] jArr = LONG_TEN_POWERS_TABLE;
            if (raise3 < jArr.length) {
                long xs = longMultiplyPowerTen(dividend, raise3);
                if (xs != Long.MIN_VALUE) {
                    return divideAndRound(xs, divisor, scale, roundingMode, scale);
                }
                raise2 = raise3;
                BigDecimal q10 = multiplyDivideAndRound(jArr[raise3], dividend, divisor, scale, roundingMode, scale);
                if (q10 != null) {
                    return q10;
                }
            } else {
                raise2 = raise3;
            }
            BigInteger scaledDividend = bigMultiplyPowerTen(dividend, raise2);
            return divideAndRound(scaledDividend, divisor, scale, roundingMode, scale);
        }
        int newScale2 = checkScale(divisor, dividendScale - scale);
        int raise4 = newScale2 - divisorScale;
        if (raise4 >= LONG_TEN_POWERS_TABLE.length) {
            raise = raise4;
        } else {
            long ys = longMultiplyPowerTen(divisor, raise4);
            if (ys == Long.MIN_VALUE) {
                raise = raise4;
            } else {
                return divideAndRound(dividend, ys, scale, roundingMode, scale);
            }
        }
        BigInteger scaledDivisor = bigMultiplyPowerTen(divisor, raise);
        return divideAndRound(BigInteger.valueOf(dividend), scaledDivisor, scale, roundingMode, scale);
    }

    private static BigDecimal divide(BigInteger dividend, int dividendScale, long divisor, int divisorScale, int scale, int roundingMode) {
        if (checkScale(dividend, scale + divisorScale) > dividendScale) {
            int newScale = scale + divisorScale;
            BigInteger scaledDividend = bigMultiplyPowerTen(dividend, newScale - dividendScale);
            return divideAndRound(scaledDividend, divisor, scale, roundingMode, scale);
        }
        int newScale2 = checkScale(divisor, dividendScale - scale);
        int raise = newScale2 - divisorScale;
        if (raise < LONG_TEN_POWERS_TABLE.length) {
            long ys = longMultiplyPowerTen(divisor, raise);
            if (ys != Long.MIN_VALUE) {
                return divideAndRound(dividend, ys, scale, roundingMode, scale);
            }
        }
        BigInteger scaledDivisor = bigMultiplyPowerTen(divisor, raise);
        return divideAndRound(dividend, scaledDivisor, scale, roundingMode, scale);
    }

    private static BigDecimal divide(long dividend, int dividendScale, BigInteger divisor, int divisorScale, int scale, int roundingMode) {
        if (checkScale(dividend, scale + divisorScale) > dividendScale) {
            int newScale = scale + divisorScale;
            int raise = newScale - dividendScale;
            BigInteger scaledDividend = bigMultiplyPowerTen(dividend, raise);
            return divideAndRound(scaledDividend, divisor, scale, roundingMode, scale);
        }
        int newScale2 = checkScale(divisor, dividendScale - scale);
        int raise2 = newScale2 - divisorScale;
        BigInteger scaledDivisor = bigMultiplyPowerTen(divisor, raise2);
        return divideAndRound(BigInteger.valueOf(dividend), scaledDivisor, scale, roundingMode, scale);
    }

    private static BigDecimal divide(BigInteger dividend, int dividendScale, BigInteger divisor, int divisorScale, int scale, int roundingMode) {
        if (checkScale(dividend, scale + divisorScale) > dividendScale) {
            int newScale = scale + divisorScale;
            int raise = newScale - dividendScale;
            BigInteger scaledDividend = bigMultiplyPowerTen(dividend, raise);
            return divideAndRound(scaledDividend, divisor, scale, roundingMode, scale);
        }
        int newScale2 = checkScale(divisor, dividendScale - scale);
        int raise2 = newScale2 - divisorScale;
        BigInteger scaledDivisor = bigMultiplyPowerTen(divisor, raise2);
        return divideAndRound(dividend, scaledDivisor, scale, roundingMode, scale);
    }
}
