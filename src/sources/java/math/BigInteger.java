package java.math;

import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.os.PowerProfile;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.zip.ZipUtils;
import jdk.internal.math.DoubleConsts;
import jdk.internal.math.FloatConsts;
import libcore.math.NativeBN;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.io.FileUtils;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BigInteger extends Number implements Comparable<BigInteger> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BORINGSSL_DIV_OFFSET = 20;
    private static final int BORINGSSL_DIV_THRESHOLD = 40;
    static final int BURNIKEL_ZIEGLER_OFFSET = 40;
    static final int BURNIKEL_ZIEGLER_THRESHOLD = 80;
    private static final int DEFAULT_PRIME_CERTAINTY = 100;
    private static final int KARATSUBA_SQUARE_THRESHOLD = 128;
    private static final int KARATSUBA_THRESHOLD = 80;
    static final long LONG_MASK = 4294967295L;
    private static final int MAX_CONSTANT = 16;
    private static final int MAX_MAG_LENGTH = 67108864;
    private static final int MONTGOMERY_INTRINSIC_THRESHOLD = 512;
    private static final int MULTIPLY_SQUARE_THRESHOLD = 20;
    private static final BigInteger NEGATIVE_ONE;
    private static int NUM_ZEROS = 0;
    public static final BigInteger ONE;
    private static final int PRIME_SEARCH_BIT_LENGTH_LIMIT = 500000000;
    private static final int SCHOENHAGE_BASE_CONVERSION_THRESHOLD = 20;
    private static final int SMALL_PRIME_THRESHOLD = 95;
    public static final BigInteger TEN;
    private static final int TOOM_COOK_SQUARE_THRESHOLD = 216;
    private static final int TOOM_COOK_THRESHOLD = 240;
    public static final BigInteger TWO;
    public static final BigInteger ZERO;
    private static final String ZEROS;
    static int[] bnExpModThreshTable = null;
    private static int[] digitsPerInt = null;
    private static int[] digitsPerLong = null;
    private static int[] intRadix = null;
    private static final double[] logCache;
    private static BigInteger[] longRadix = null;
    private static volatile BigInteger[][] powerCache = null;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -8287574255936472291L;
    private int bitCountPlusOne;
    private int bitLengthPlusOne;
    private int firstNonzeroIntNumPlusTwo;
    private int lowestSetBitPlusTwo;
    final int[] mag;
    final int signum;
    private static long[] bitsPerDigit = {0, 0, 1024, 1624, 2048, 2378, 2648, 2875, 3072, 3247, 3402, 3543, 3672, 3790, 3899, 4001, 4096, 4186, 4271, 4350, 4426, 4498, 4567, 4633, 4696, 4756, 4814, 4870, 4923, 4975, 5025, 5074, 5120, 5166, 5210, 5253, 5295};
    private static final BigInteger SMALL_PRIME_PRODUCT = valueOf(152125131763605L);
    private static final BigInteger[] posConst = new BigInteger[17];
    private static final BigInteger[] negConst = new BigInteger[17];
    private static final double LOG_TWO = Math.log(2.0d);

    static {
        for (int i10 = 1; i10 <= 16; i10++) {
            int[] magnitude = {i10};
            posConst[i10] = new BigInteger(magnitude, 1);
            negConst[i10] = new BigInteger(magnitude, -1);
        }
        powerCache = new BigInteger[37];
        logCache = new double[37];
        for (int i11 = 2; i11 <= 36; i11++) {
            powerCache[i11] = new BigInteger[]{valueOf(i11)};
            logCache[i11] = Math.log(i11);
        }
        ZERO = new BigInteger(new int[0], 0);
        ONE = valueOf(1L);
        TWO = valueOf(2L);
        NEGATIVE_ONE = valueOf(-1L);
        TEN = valueOf(10L);
        bnExpModThreshTable = new int[]{7, 25, 81, 241, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_READ_PHONE_STATE, 1793, Integer.MAX_VALUE};
        NUM_ZEROS = 63;
        ZEROS = "0".repeat(63);
        digitsPerLong = new int[]{0, 0, 62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12};
        longRadix = new BigInteger[]{null, null, valueOf(4611686018427387904L), valueOf(4052555153018976267L), valueOf(4611686018427387904L), valueOf(7450580596923828125L), valueOf(4738381338321616896L), valueOf(3909821048582988049L), valueOf(FileUtils.ONE_EB), valueOf(1350851717672992089L), valueOf(1000000000000000000L), valueOf(5559917313492231481L), valueOf(2218611106740436992L), valueOf(8650415919381337933L), valueOf(2177953337809371136L), valueOf(6568408355712890625L), valueOf(FileUtils.ONE_EB), valueOf(2862423051509815793L), valueOf(6746640616477458432L), valueOf(799006685782884121L), valueOf(1638400000000000000L), valueOf(3243919932521508681L), valueOf(6221821273427820544L), valueOf(504036361936467383L), valueOf(876488338465357824L), valueOf(1490116119384765625L), valueOf(2481152873203736576L), valueOf(4052555153018976267L), valueOf(6502111422497947648L), valueOf(353814783205469041L), valueOf(531441000000000000L), valueOf(787662783788549761L), valueOf(FileUtils.ONE_EB), valueOf(1667889514952984961L), valueOf(2386420683693101056L), valueOf(3379220508056640625L), valueOf(4738381338321616896L)};
        digitsPerInt = new int[]{0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};
        intRadix = new int[]{0, 0, 1073741824, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176};
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("signum", Integer.TYPE), new ObjectStreamField("magnitude", byte[].class), new ObjectStreamField("bitCount", Integer.TYPE), new ObjectStreamField("bitLength", Integer.TYPE), new ObjectStreamField("firstNonzeroByteNum", Integer.TYPE), new ObjectStreamField("lowestSetBit", Integer.TYPE)};
    }

    public BigInteger(byte[] val, int off, int len) {
        if (val.length == 0) {
            throw new NumberFormatException("Zero length BigInteger");
        }
        Objects.checkFromIndexSize(off, len, val.length);
        if (val[off] < 0) {
            this.mag = makePositive(val, off, len);
            this.signum = -1;
        } else {
            int[] stripLeadingZeroBytes = stripLeadingZeroBytes(val, off, len);
            this.mag = stripLeadingZeroBytes;
            this.signum = stripLeadingZeroBytes.length == 0 ? 0 : 1;
        }
        if (this.mag.length >= 67108864) {
            checkRange();
        }
    }

    public BigInteger(byte[] val) {
        this(val, 0, val.length);
    }

    private BigInteger(int[] val) {
        if (val.length == 0) {
            throw new NumberFormatException("Zero length BigInteger");
        }
        if (val[0] < 0) {
            this.mag = makePositive(val);
            this.signum = -1;
        } else {
            int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(val);
            this.mag = trustedStripLeadingZeroInts;
            this.signum = trustedStripLeadingZeroInts.length != 0 ? 1 : 0;
        }
        if (this.mag.length >= 67108864) {
            checkRange();
        }
    }

    public BigInteger(int signum, byte[] magnitude, int off, int len) {
        if (signum < -1 || signum > 1) {
            throw new NumberFormatException("Invalid signum value");
        }
        Objects.checkFromIndexSize(off, len, magnitude.length);
        int[] stripLeadingZeroBytes = stripLeadingZeroBytes(magnitude, off, len);
        this.mag = stripLeadingZeroBytes;
        if (stripLeadingZeroBytes.length == 0) {
            this.signum = 0;
        } else {
            if (signum == 0) {
                throw new NumberFormatException("signum-magnitude mismatch");
            }
            this.signum = signum;
        }
        if (stripLeadingZeroBytes.length >= 67108864) {
            checkRange();
        }
    }

    public BigInteger(int signum, byte[] magnitude) {
        this(signum, magnitude, 0, magnitude.length);
    }

    private BigInteger(int signum, int[] magnitude) {
        int[] stripLeadingZeroInts = stripLeadingZeroInts(magnitude);
        this.mag = stripLeadingZeroInts;
        if (signum < -1 || signum > 1) {
            throw new NumberFormatException("Invalid signum value");
        }
        if (stripLeadingZeroInts.length == 0) {
            this.signum = 0;
        } else {
            if (signum == 0) {
                throw new NumberFormatException("signum-magnitude mismatch");
            }
            this.signum = signum;
        }
        if (stripLeadingZeroInts.length >= 67108864) {
            checkRange();
        }
    }

    public BigInteger(String val, int radix) {
        int cursor = 0;
        int len = val.length();
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException("Radix out of range");
        }
        if (len == 0) {
            throw new NumberFormatException("Zero length BigInteger");
        }
        int sign = 1;
        int index1 = val.lastIndexOf(45);
        int index2 = val.lastIndexOf(43);
        if (index1 >= 0) {
            if (index1 != 0 || index2 >= 0) {
                throw new NumberFormatException("Illegal embedded sign character");
            }
            sign = -1;
            cursor = 1;
        } else if (index2 >= 0) {
            if (index2 != 0) {
                throw new NumberFormatException("Illegal embedded sign character");
            }
            cursor = 1;
        }
        if (cursor == len) {
            throw new NumberFormatException("Zero length BigInteger");
        }
        while (cursor < len && Character.digit(val.charAt(cursor), radix) == 0) {
            cursor++;
        }
        if (cursor == len) {
            this.signum = 0;
            this.mag = ZERO.mag;
            return;
        }
        int numDigits = len - cursor;
        this.signum = sign;
        long numBits = ((numDigits * bitsPerDigit[radix]) >>> 10) + 1;
        if (numBits + 31 >= PowerProfile.SUBSYSTEM_MODEM) {
            reportOverflow();
        }
        int numWords = ((int) (31 + numBits)) >>> 5;
        int[] magnitude = new int[numWords];
        int[] iArr = digitsPerInt;
        int firstGroupLen = numDigits % iArr[radix];
        int i10 = cursor + (firstGroupLen == 0 ? iArr[radix] : firstGroupLen);
        int groupVal = i10;
        String group = val.substring(cursor, i10);
        magnitude[numWords - 1] = Integer.parseInt(group, radix);
        if (magnitude[numWords - 1] < 0) {
            throw new NumberFormatException("Illegal digit");
        }
        int superRadix = intRadix[radix];
        while (groupVal < len) {
            int len2 = len;
            int len3 = groupVal + digitsPerInt[radix];
            String group2 = val.substring(groupVal, len3);
            int groupVal2 = Integer.parseInt(group2, radix);
            if (groupVal2 < 0) {
                throw new NumberFormatException("Illegal digit");
            }
            destructiveMulAdd(magnitude, superRadix, groupVal2);
            groupVal = len3;
            len = len2;
        }
        int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(magnitude);
        this.mag = trustedStripLeadingZeroInts;
        if (trustedStripLeadingZeroInts.length >= 67108864) {
            checkRange();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger(char[] val, int sign, int len) {
        int numWords;
        int cursor = 0;
        while (cursor < len && Character.digit(val[cursor], 10) == 0) {
            cursor++;
        }
        if (cursor == len) {
            this.signum = 0;
            this.mag = ZERO.mag;
            return;
        }
        int numDigits = len - cursor;
        this.signum = sign;
        if (len >= 10) {
            long numBits = ((numDigits * bitsPerDigit[10]) >>> 10) + 1;
            if (numBits + 31 >= PowerProfile.SUBSYSTEM_MODEM) {
                reportOverflow();
            }
            numWords = ((int) (31 + numBits)) >>> 5;
        } else {
            numWords = 1;
        }
        int[] magnitude = new int[numWords];
        int[] iArr = digitsPerInt;
        int firstGroupLen = numDigits % iArr[10];
        int i10 = cursor + (firstGroupLen == 0 ? iArr[10] : firstGroupLen);
        int cursor2 = i10;
        magnitude[numWords - 1] = parseInt(val, cursor, i10);
        while (cursor2 < len) {
            int cursor3 = digitsPerInt[10] + cursor2;
            int groupVal = parseInt(val, cursor2, cursor3);
            destructiveMulAdd(magnitude, intRadix[10], groupVal);
            cursor2 = cursor3;
        }
        int[] trustedStripLeadingZeroInts = trustedStripLeadingZeroInts(magnitude);
        this.mag = trustedStripLeadingZeroInts;
        if (trustedStripLeadingZeroInts.length >= 67108864) {
            checkRange();
        }
    }

    private int parseInt(char[] source, int start, int end) {
        int start2 = start + 1;
        int result = Character.digit(source[start], 10);
        if (result == -1) {
            throw new NumberFormatException(new String(source));
        }
        for (int index = start2; index < end; index++) {
            int nextVal = Character.digit(source[index], 10);
            if (nextVal == -1) {
                throw new NumberFormatException(new String(source));
            }
            result = (result * 10) + nextVal;
        }
        return result;
    }

    private static void destructiveMulAdd(int[] x10, int y10, int z10) {
        long ylong = y10 & 4294967295L;
        long zlong = z10 & 4294967295L;
        int len = x10.length;
        long product = 0;
        long carry = 0;
        for (int i10 = len - 1; i10 >= 0; i10--) {
            long product2 = x10[i10];
            product = ((product2 & 4294967295L) * ylong) + carry;
            x10[i10] = (int) product;
            carry = product >>> 32;
        }
        long sum = (x10[len - 1] & 4294967295L) + zlong;
        x10[len - 1] = (int) sum;
        long carry2 = sum >>> 32;
        int i11 = len - 2;
        while (i11 >= 0) {
            long sum2 = (x10[i11] & 4294967295L) + carry2;
            x10[i11] = (int) sum2;
            carry2 = sum2 >>> 32;
            i11--;
            ylong = ylong;
        }
    }

    public BigInteger(String val) {
        this(val, 10);
    }

    public BigInteger(int numBits, Random rnd) {
        byte[] magnitude = randomBits(numBits, rnd);
        try {
            int[] stripLeadingZeroBytes = stripLeadingZeroBytes(magnitude, 0, magnitude.length);
            this.mag = stripLeadingZeroBytes;
            if (stripLeadingZeroBytes.length == 0) {
                this.signum = 0;
            } else {
                this.signum = 1;
            }
            if (stripLeadingZeroBytes.length >= 67108864) {
                checkRange();
            }
        } finally {
            Arrays.fill(magnitude, (byte) 0);
        }
    }

    private static byte[] randomBits(int numBits, Random rnd) {
        if (numBits < 0) {
            throw new IllegalArgumentException("numBits must be non-negative");
        }
        int numBytes = (int) ((numBits + 7) / 8);
        byte[] randomBits = new byte[numBytes];
        if (numBytes > 0) {
            rnd.nextBytes(randomBits);
            int excessBits = (numBytes * 8) - numBits;
            randomBits[0] = (byte) (randomBits[0] & ((1 << (8 - excessBits)) - 1));
        }
        return randomBits;
    }

    public BigInteger(int bitLength, int certainty, Random rnd) {
        BigInteger prime;
        if (bitLength < 2) {
            throw new ArithmeticException("bitLength < 2");
        }
        if (bitLength < 95) {
            prime = smallPrime(bitLength, certainty, rnd);
        } else {
            prime = largePrime(bitLength, certainty, rnd);
        }
        this.signum = 1;
        this.mag = prime.mag;
    }

    public static BigInteger probablePrime(int bitLength, Random rnd) {
        if (bitLength < 2) {
            throw new ArithmeticException("bitLength < 2");
        }
        if (bitLength < 95) {
            return smallPrime(bitLength, 100, rnd);
        }
        return largePrime(bitLength, 100, rnd);
    }

    private static BigInteger smallPrime(int bitLength, int certainty, Random rnd) {
        int magLen = (bitLength + 31) >>> 5;
        int[] temp = new int[magLen];
        int highBit = 1 << ((bitLength + 31) & 31);
        int highMask = (highBit << 1) - 1;
        while (true) {
            for (int i10 = 0; i10 < magLen; i10++) {
                temp[i10] = rnd.nextInt();
            }
            temp[0] = (temp[0] & highMask) | highBit;
            if (bitLength > 2) {
                int i11 = magLen - 1;
                temp[i11] = temp[i11] | 1;
            }
            BigInteger p10 = new BigInteger(temp, 1);
            if (bitLength > 6) {
                long r10 = p10.remainder(SMALL_PRIME_PRODUCT).longValue();
                if (r10 % 3 != 0 && r10 % 5 != 0 && r10 % 7 != 0 && r10 % 11 != 0 && r10 % 13 != 0 && r10 % 17 != 0 && r10 % 19 != 0 && r10 % 23 != 0 && r10 % 29 != 0 && r10 % 31 != 0 && r10 % 37 != 0 && r10 % 41 != 0) {
                }
            }
            if (bitLength < 4) {
                return p10;
            }
            if (p10.primeToCertainty(certainty, rnd)) {
                return p10;
            }
        }
    }

    private static BigInteger largePrime(int bitLength, int certainty, Random rnd) {
        BigInteger p10 = new BigInteger(bitLength, rnd).setBit(bitLength - 1);
        int[] iArr = p10.mag;
        int length = iArr.length - 1;
        iArr[length] = iArr[length] & (-2);
        int searchLen = getPrimeSearchLen(bitLength);
        BitSieve searchSieve = new BitSieve(p10, searchLen);
        BigInteger candidate = searchSieve.retrieve(p10, certainty, rnd);
        while (true) {
            if (candidate == null || candidate.bitLength() != bitLength) {
                p10 = p10.add(valueOf(searchLen * 2));
                if (p10.bitLength() != bitLength) {
                    p10 = new BigInteger(bitLength, rnd).setBit(bitLength - 1);
                }
                int[] iArr2 = p10.mag;
                int length2 = iArr2.length - 1;
                iArr2[length2] = iArr2[length2] & (-2);
                BitSieve searchSieve2 = new BitSieve(p10, searchLen);
                candidate = searchSieve2.retrieve(p10, certainty, rnd);
            } else {
                return candidate;
            }
        }
    }

    public BigInteger nextProbablePrime() {
        int i10 = this.signum;
        if (i10 < 0) {
            throw new ArithmeticException("start < 0: " + ((Object) this));
        }
        if (i10 != 0) {
            BigInteger bigInteger = ONE;
            if (!equals(bigInteger)) {
                BigInteger result = add(bigInteger);
                if (result.bitLength() < 95) {
                    if (!result.testBit(0)) {
                        result = result.add(bigInteger);
                    }
                    while (true) {
                        if (result.bitLength() > 6) {
                            long r10 = result.remainder(SMALL_PRIME_PRODUCT).longValue();
                            if (r10 % 3 == 0 || r10 % 5 == 0 || r10 % 7 == 0 || r10 % 11 == 0 || r10 % 13 == 0 || r10 % 17 == 0 || r10 % 19 == 0 || r10 % 23 == 0 || r10 % 29 == 0 || r10 % 31 == 0 || r10 % 37 == 0 || r10 % 41 == 0) {
                                result = result.add(TWO);
                            }
                        }
                        if (result.bitLength() < 4) {
                            return result;
                        }
                        if (result.primeToCertainty(100, null)) {
                            return result;
                        }
                        result = result.add(TWO);
                    }
                } else {
                    if (result.testBit(0)) {
                        result = result.subtract(bigInteger);
                    }
                    int searchLen = getPrimeSearchLen(result.bitLength());
                    while (true) {
                        BitSieve searchSieve = new BitSieve(result, searchLen);
                        BigInteger candidate = searchSieve.retrieve(result, 100, null);
                        if (candidate != null) {
                            return candidate;
                        }
                        result = result.add(valueOf(searchLen * 2));
                    }
                }
            }
        }
        return TWO;
    }

    private static int getPrimeSearchLen(int bitLength) {
        if (bitLength > 500000001) {
            throw new ArithmeticException("Prime search implementation restriction on bitLength");
        }
        return (bitLength / 20) * 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean primeToCertainty(int certainty, Random random) {
        int rounds;
        int n10 = (Math.min(certainty, AccessibilityNodeInfo.ROOT_ITEM_ID) + 1) / 2;
        int sizeInBits = bitLength();
        if (sizeInBits < 100) {
            int rounds2 = n10 < 50 ? n10 : 50;
            return passesMillerRabin(rounds2, random);
        }
        if (sizeInBits < 256) {
            rounds = 27;
        } else if (sizeInBits < 512) {
            rounds = 15;
        } else if (sizeInBits < 768) {
            rounds = 8;
        } else if (sizeInBits < 1024) {
            rounds = 4;
        } else {
            rounds = 2;
        }
        return passesMillerRabin(n10 < rounds ? n10 : rounds, random) && passesLucasLehmer();
    }

    private boolean passesLucasLehmer() {
        BigInteger thisPlusOne = add(ONE);
        int d10 = 5;
        while (jacobiSymbol(d10, this) != -1) {
            d10 = d10 < 0 ? Math.abs(d10) + 2 : -(d10 + 2);
        }
        BigInteger u10 = lucasLehmerSequence(d10, thisPlusOne, this);
        return u10.mod(this).equals(ZERO);
    }

    private static int jacobiSymbol(int p10, BigInteger n10) {
        if (p10 == 0) {
            return 0;
        }
        int j10 = 1;
        int[] iArr = n10.mag;
        int u10 = iArr[iArr.length - 1];
        if (p10 < 0) {
            p10 = -p10;
            int n82 = u10 & 7;
            if (n82 == 3 || n82 == 7) {
                j10 = -1;
            }
        }
        while ((p10 & 3) == 0) {
            p10 >>= 2;
        }
        if ((p10 & 1) == 0) {
            p10 >>= 1;
            if ((((u10 >> 1) ^ u10) & 2) != 0) {
                j10 = -j10;
            }
        }
        if (p10 == 1) {
            return j10;
        }
        if ((p10 & u10 & 2) != 0) {
            j10 = -j10;
        }
        int u11 = n10.mod(valueOf(p10)).intValue();
        while (u11 != 0) {
            while ((u11 & 3) == 0) {
                u11 >>= 2;
            }
            if ((u11 & 1) == 0) {
                u11 >>= 1;
                if ((((p10 >> 1) ^ p10) & 2) != 0) {
                    j10 = -j10;
                }
            }
            if (u11 == 1) {
                return j10;
            }
            int t2 = u11;
            int u12 = p10;
            p10 = t2;
            if ((u12 & p10 & 2) != 0) {
                j10 = -j10;
            }
            u11 = u12 % p10;
        }
        return 0;
    }

    private static BigInteger lucasLehmerSequence(int z10, BigInteger k10, BigInteger n10) {
        BigInteger d10 = valueOf(z10);
        BigInteger u10 = ONE;
        BigInteger v2 = ONE;
        for (int i10 = k10.bitLength() - 2; i10 >= 0; i10--) {
            BigInteger u22 = u10.multiply(v2).mod(n10);
            BigInteger v22 = v2.square().add(d10.multiply(u10.square())).mod(n10);
            if (v22.testBit(0)) {
                v22 = v22.subtract(n10);
            }
            u10 = u22;
            v2 = v22.shiftRight(1);
            if (k10.testBit(i10)) {
                BigInteger u23 = u10.add(v2).mod(n10);
                if (u23.testBit(0)) {
                    u23 = u23.subtract(n10);
                }
                BigInteger u24 = u23.shiftRight(1);
                BigInteger v23 = v2.add(d10.multiply(u10)).mod(n10);
                if (v23.testBit(0)) {
                    v23 = v23.subtract(n10);
                }
                u10 = u24;
                v2 = v23.shiftRight(1);
            }
        }
        return u10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean passesMillerRabin(int r9, java.util.Random r10) {
        /*
            r8 = this;
            java.math.BigInteger r0 = java.math.BigInteger.ONE
            java.math.BigInteger r0 = r8.subtract(r0)
            r1 = r0
            int r2 = r1.getLowestSetBit()
            java.math.BigInteger r1 = r1.shiftRight(r2)
            if (r10 != 0) goto L15
            java.util.concurrent.ThreadLocalRandom r10 = java.util.concurrent.ThreadLocalRandom.current()
        L15:
            r3 = 0
        L16:
            if (r3 >= r9) goto L5e
        L18:
            java.math.BigInteger r4 = new java.math.BigInteger
            int r5 = r8.bitLength()
            r4.<init>(r5, r10)
            java.math.BigInteger r5 = java.math.BigInteger.ONE
            int r5 = r4.compareTo(r5)
            if (r5 <= 0) goto L18
            int r5 = r4.compareTo(r8)
            if (r5 >= 0) goto L18
            r5 = 0
            java.math.BigInteger r6 = r4.modPow(r1, r8)
        L34:
            if (r5 != 0) goto L3e
            java.math.BigInteger r7 = java.math.BigInteger.ONE
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L5b
        L3e:
            boolean r7 = r6.equals(r0)
            if (r7 != 0) goto L5b
            if (r5 <= 0) goto L4e
            java.math.BigInteger r7 = java.math.BigInteger.ONE
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L52
        L4e:
            int r5 = r5 + 1
            if (r5 != r2) goto L54
        L52:
            r7 = 0
            return r7
        L54:
            java.math.BigInteger r7 = java.math.BigInteger.TWO
            java.math.BigInteger r6 = r6.modPow(r7, r8)
            goto L34
        L5b:
            int r3 = r3 + 1
            goto L16
        L5e:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigInteger.passesMillerRabin(int, java.util.Random):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger(int[] magnitude, int signum) {
        this.signum = magnitude.length == 0 ? 0 : signum;
        this.mag = magnitude;
        if (magnitude.length >= 67108864) {
            checkRange();
        }
    }

    private BigInteger(byte[] magnitude, int signum) {
        this.signum = magnitude.length == 0 ? 0 : signum;
        int[] stripLeadingZeroBytes = stripLeadingZeroBytes(magnitude, 0, magnitude.length);
        this.mag = stripLeadingZeroBytes;
        if (stripLeadingZeroBytes.length >= 67108864) {
            checkRange();
        }
    }

    private void checkRange() {
        int[] iArr = this.mag;
        if (iArr.length > 67108864 || (iArr.length == 67108864 && iArr[0] < 0)) {
            reportOverflow();
        }
    }

    private static void reportOverflow() {
        throw new ArithmeticException("BigInteger would overflow supported range");
    }

    public static BigInteger valueOf(long val) {
        if (val == 0) {
            return ZERO;
        }
        if (val > 0 && val <= 16) {
            return posConst[(int) val];
        }
        if (val < 0 && val >= -16) {
            return negConst[(int) (-val)];
        }
        return new BigInteger(val);
    }

    private BigInteger(long val) {
        if (val < 0) {
            val = -val;
            this.signum = -1;
        } else {
            this.signum = 1;
        }
        int highWord = (int) (val >>> 32);
        if (highWord == 0) {
            this.mag = r1;
            int[] iArr = {(int) val};
        } else {
            this.mag = r3;
            int[] iArr2 = {highWord, (int) val};
        }
    }

    private static BigInteger valueOf(int[] val) {
        return val[0] > 0 ? new BigInteger(val, 1) : new BigInteger(val);
    }

    public BigInteger add(BigInteger val) {
        int i10 = val.signum;
        if (i10 == 0) {
            return this;
        }
        int i11 = this.signum;
        if (i11 == 0) {
            return val;
        }
        if (i10 == i11) {
            return new BigInteger(add(this.mag, val.mag), this.signum);
        }
        int cmp = compareMagnitude(val);
        if (cmp == 0) {
            return ZERO;
        }
        int[] resultMag = cmp > 0 ? subtract(this.mag, val.mag) : subtract(val.mag, this.mag);
        return new BigInteger(trustedStripLeadingZeroInts(resultMag), cmp == this.signum ? 1 : -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger add(long val) {
        if (val == 0) {
            return this;
        }
        if (this.signum == 0) {
            return valueOf(val);
        }
        if (Long.signum(val) == this.signum) {
            return new BigInteger(add(this.mag, Math.abs(val)), this.signum);
        }
        int cmp = compareMagnitude(val);
        if (cmp == 0) {
            return ZERO;
        }
        int[] resultMag = cmp > 0 ? subtract(this.mag, Math.abs(val)) : subtract(Math.abs(val), this.mag);
        return new BigInteger(trustedStripLeadingZeroInts(resultMag), cmp == this.signum ? 1 : -1);
    }

    private static int[] add(int[] x10, long val) {
        int[] result;
        int xIndex;
        long sum;
        int xIndex2 = x10.length;
        int highWord = (int) (val >>> 32);
        if (highWord == 0) {
            result = new int[xIndex2];
            xIndex = xIndex2 - 1;
            sum = (4294967295L & x10[xIndex]) + val;
            result[xIndex] = (int) sum;
        } else {
            if (xIndex2 == 1) {
                long sum2 = val + (4294967295L & x10[0]);
                return new int[]{(int) (sum2 >>> 32), (int) sum2};
            }
            result = new int[xIndex2];
            int xIndex3 = xIndex2 - 1;
            long sum3 = (x10[xIndex3] & 4294967295L) + (val & 4294967295L);
            result[xIndex3] = (int) sum3;
            xIndex = xIndex3 - 1;
            sum = (sum3 >>> 32) + (x10[xIndex] & 4294967295L) + (4294967295L & highWord);
            result[xIndex] = (int) sum;
        }
        boolean carry = (sum >>> 32) != 0;
        while (xIndex > 0 && carry) {
            xIndex--;
            int i10 = x10[xIndex] + 1;
            result[xIndex] = i10;
            carry = i10 == 0;
        }
        while (xIndex > 0) {
            xIndex--;
            result[xIndex] = x10[xIndex];
        }
        if (carry) {
            int[] bigger = new int[result.length + 1];
            System.arraycopy((Object) result, 0, (Object) bigger, 1, result.length);
            bigger[0] = 1;
            return bigger;
        }
        return result;
    }

    private static int[] add(int[] x10, int[] y10) {
        long sum;
        if (x10.length < y10.length) {
            x10 = y10;
            y10 = x10;
        }
        int xIndex = x10.length;
        int yIndex = y10.length;
        int[] result = new int[xIndex];
        long sum2 = 0;
        if (yIndex == 1) {
            xIndex--;
            sum = (x10[xIndex] & 4294967295L) + (4294967295L & y10[0]);
            result[xIndex] = (int) sum;
        } else {
            while (yIndex > 0) {
                xIndex--;
                yIndex--;
                sum2 = (x10[xIndex] & 4294967295L) + (y10[yIndex] & 4294967295L) + (sum2 >>> 32);
                result[xIndex] = (int) sum2;
            }
            sum = sum2;
        }
        boolean carry = (sum >>> 32) != 0;
        while (xIndex > 0 && carry) {
            xIndex--;
            int i10 = x10[xIndex] + 1;
            result[xIndex] = i10;
            carry = i10 == 0;
        }
        while (xIndex > 0) {
            xIndex--;
            result[xIndex] = x10[xIndex];
        }
        if (carry) {
            int[] bigger = new int[result.length + 1];
            System.arraycopy((Object) result, 0, (Object) bigger, 1, result.length);
            bigger[0] = 1;
            return bigger;
        }
        return result;
    }

    private static int[] subtract(long val, int[] little) {
        int highWord = (int) (val >>> 32);
        if (highWord == 0) {
            return new int[]{(int) (val - (4294967295L & little[0]))};
        }
        int[] result = new int[2];
        if (little.length == 1) {
            long difference = (((int) val) & 4294967295L) - (4294967295L & little[0]);
            result[1] = (int) difference;
            boolean borrow = (difference >> 32) != 0;
            if (borrow) {
                result[0] = highWord - 1;
            } else {
                result[0] = highWord;
            }
            return result;
        }
        long difference2 = (((int) val) & 4294967295L) - (little[1] & 4294967295L);
        result[1] = (int) difference2;
        result[0] = (int) (((highWord & 4294967295L) - (4294967295L & little[0])) + (difference2 >> 32));
        return result;
    }

    private static int[] subtract(int[] big, long val) {
        int bigIndex;
        long difference;
        int highWord = (int) (val >>> 32);
        int bigIndex2 = big.length;
        int[] result = new int[bigIndex2];
        if (highWord == 0) {
            bigIndex = bigIndex2 - 1;
            difference = (4294967295L & big[bigIndex]) - val;
            result[bigIndex] = (int) difference;
        } else {
            int bigIndex3 = bigIndex2 - 1;
            long difference2 = (big[bigIndex3] & 4294967295L) - (val & 4294967295L);
            result[bigIndex3] = (int) difference2;
            bigIndex = bigIndex3 - 1;
            difference = (difference2 >> 32) + ((big[bigIndex] & 4294967295L) - (4294967295L & highWord));
            result[bigIndex] = (int) difference;
        }
        boolean borrow = (difference >> 32) != 0;
        while (bigIndex > 0 && borrow) {
            bigIndex--;
            int i10 = big[bigIndex] - 1;
            result[bigIndex] = i10;
            borrow = i10 == -1;
        }
        while (bigIndex > 0) {
            bigIndex--;
            result[bigIndex] = big[bigIndex];
        }
        return result;
    }

    public BigInteger subtract(BigInteger val) {
        int i10 = val.signum;
        if (i10 == 0) {
            return this;
        }
        int i11 = this.signum;
        if (i11 == 0) {
            return val.negate();
        }
        if (i10 != i11) {
            return new BigInteger(add(this.mag, val.mag), this.signum);
        }
        int cmp = compareMagnitude(val);
        if (cmp == 0) {
            return ZERO;
        }
        int[] resultMag = cmp > 0 ? subtract(this.mag, val.mag) : subtract(val.mag, this.mag);
        return new BigInteger(trustedStripLeadingZeroInts(resultMag), cmp == this.signum ? 1 : -1);
    }

    private static int[] subtract(int[] big, int[] little) {
        int bigIndex = big.length;
        int[] result = new int[bigIndex];
        int littleIndex = little.length;
        long difference = 0;
        while (littleIndex > 0) {
            bigIndex--;
            littleIndex--;
            difference = ((big[bigIndex] & 4294967295L) - (4294967295L & little[littleIndex])) + (difference >> 32);
            result[bigIndex] = (int) difference;
        }
        boolean borrow = (difference >> 32) != 0;
        while (bigIndex > 0 && borrow) {
            bigIndex--;
            int i10 = big[bigIndex] - 1;
            result[bigIndex] = i10;
            borrow = i10 == -1;
        }
        while (bigIndex > 0) {
            bigIndex--;
            result[bigIndex] = big[bigIndex];
        }
        return result;
    }

    public BigInteger multiply(BigInteger val) {
        return multiply(val, false);
    }

    private BigInteger multiply(BigInteger val, boolean isRecursion) {
        int i10;
        int i11 = val.signum;
        if (i11 == 0 || (i10 = this.signum) == 0) {
            return ZERO;
        }
        int[] iArr = this.mag;
        int xlen = iArr.length;
        if (val == this && xlen > 20 && xlen < 50) {
            return square();
        }
        int[] iArr2 = val.mag;
        int ylen = iArr2.length;
        int resultSign = i10 == i11 ? 1 : -1;
        if (xlen < 50 || ylen < 50) {
            if (iArr2.length != 1) {
                if (iArr.length == 1) {
                    return multiplyByInt(iArr2, iArr[0], resultSign);
                }
                int[] result = multiplyToLen(iArr, xlen, iArr2, ylen, null);
                return new BigInteger(trustedStripLeadingZeroInts(result), resultSign);
            }
            return multiplyByInt(iArr, iArr2[0], resultSign);
        }
        long xBN = 0;
        long yBN = 0;
        long resultBN = 0;
        try {
            long xBN2 = bigEndInts2NewBN(iArr, false);
            try {
                long yBN2 = bigEndInts2NewBN(val.mag, false);
                try {
                    resultBN = NativeBN.BN_new();
                    NativeBN.BN_mul(resultBN, xBN2, yBN2);
                    BigInteger bigInteger = new BigInteger(resultSign, bn2BigEndInts(resultBN));
                    NativeBN.BN_free(xBN2);
                    NativeBN.BN_free(yBN2);
                    NativeBN.BN_free(resultBN);
                    return bigInteger;
                } catch (Throwable th) {
                    th = th;
                    xBN = xBN2;
                    yBN = yBN2;
                    NativeBN.BN_free(xBN);
                    NativeBN.BN_free(yBN);
                    NativeBN.BN_free(resultBN);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                xBN = xBN2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static BigInteger multiplyByInt(int[] x10, int y10, int sign) {
        if (Integer.bitCount(y10) == 1) {
            return new BigInteger(shiftLeft(x10, Integer.numberOfTrailingZeros(y10)), sign);
        }
        int xlen = x10.length;
        long carry = 0;
        long j10 = 4294967295L;
        long yl = y10 & 4294967295L;
        long highDigitsBound = ((x10[0] & 4294967295L) + 1) * yl;
        int rlen = (highDigitsBound >>> 32) == 0 ? xlen : xlen + 1;
        int[] rmag = new int[rlen];
        int rindex = rlen - 1;
        int i10 = xlen - 1;
        int rindex2 = rindex;
        while (i10 >= 0) {
            long highDigitsBound2 = highDigitsBound;
            long product = ((x10[i10] & j10) * yl) + carry;
            rmag[rindex2] = (int) product;
            carry = product >>> 32;
            i10--;
            rindex2--;
            highDigitsBound = highDigitsBound2;
            j10 = 4294967295L;
        }
        if (rindex2 != -1) {
            if (carry == 0) {
                rmag = Arrays.copyOfRange(rmag, 1, rmag.length);
            } else {
                rmag[0] = (int) carry;
            }
        }
        return new BigInteger(rmag, sign);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger multiply(long v2) {
        int rsign;
        long v10 = v2;
        if (v10 == 0 || (rsign = this.signum) == 0) {
            return ZERO;
        }
        if (v10 == Long.MIN_VALUE) {
            return multiply(valueOf(v2));
        }
        if (v10 <= 0) {
            rsign = -rsign;
        }
        if (v10 < 0) {
            v10 = -v10;
        }
        long dh = v10 >>> 32;
        long dl = v10 & 4294967295L;
        int xlen = this.mag.length;
        int[] value = this.mag;
        int[] rmag = new int[dh == 0 ? xlen + 1 : xlen + 2];
        int rstart = rmag.length - 1;
        int i10 = xlen - 1;
        int rsign2 = rsign;
        long carry = 0;
        while (i10 >= 0) {
            long product = ((value[i10] & 4294967295L) * dl) + carry;
            rmag[rstart] = (int) product;
            carry = product >>> 32;
            i10--;
            rstart--;
            v10 = v10;
        }
        rmag[rstart] = (int) carry;
        if (dh != 0) {
            int rstart2 = rmag.length - 2;
            int i11 = xlen - 1;
            carry = 0;
            while (i11 >= 0) {
                long product2 = ((value[i11] & 4294967295L) * dh) + (rmag[rstart2] & 4294967295L) + carry;
                rmag[rstart2] = (int) product2;
                carry = product2 >>> 32;
                i11--;
                rstart2--;
                dh = dh;
            }
            rmag[0] = (int) carry;
        }
        if (carry == 0) {
            rmag = Arrays.copyOfRange(rmag, 1, rmag.length);
        }
        return new BigInteger(rmag, rsign2);
    }

    private static int[] multiplyToLen(int[] x10, int xlen, int[] y10, int ylen, int[] z10) {
        multiplyToLenCheck(x10, xlen);
        multiplyToLenCheck(y10, ylen);
        return implMultiplyToLen(x10, xlen, y10, ylen, z10);
    }

    private static int[] implMultiplyToLen(int[] x10, int xlen, int[] y10, int ylen, int[] z10) {
        int[] z11 = z10;
        int xstart = xlen - 1;
        int ystart = ylen - 1;
        if (z11 == null || z11.length < xlen + ylen) {
            z11 = new int[xlen + ylen];
        }
        long carry = 0;
        int j10 = ystart;
        int k10 = ystart + 1 + xstart;
        while (j10 >= 0) {
            long product = ((y10[j10] & 4294967295L) * (4294967295L & x10[xstart])) + carry;
            z11[k10] = (int) product;
            carry = product >>> 32;
            j10--;
            k10--;
        }
        int j11 = (int) carry;
        z11[xstart] = j11;
        for (int i10 = xstart - 1; i10 >= 0; i10--) {
            long carry2 = 0;
            int j12 = ystart;
            int k11 = ystart + 1 + i10;
            while (j12 >= 0) {
                long product2 = ((y10[j12] & 4294967295L) * (x10[i10] & 4294967295L)) + (z11[k11] & 4294967295L) + carry2;
                z11[k11] = (int) product2;
                carry2 = product2 >>> 32;
                j12--;
                k11--;
            }
            int j13 = (int) carry2;
            z11[i10] = j13;
        }
        return z11;
    }

    private static void multiplyToLenCheck(int[] array, int length) {
        if (length <= 0) {
            return;
        }
        Objects.requireNonNull(array);
        if (length > array.length) {
            throw new ArrayIndexOutOfBoundsException(length - 1);
        }
    }

    private static BigInteger multiplyKaratsuba(BigInteger x10, BigInteger y10) {
        int xlen = x10.mag.length;
        int ylen = y10.mag.length;
        int half = (Math.max(xlen, ylen) + 1) / 2;
        BigInteger xl = x10.getLower(half);
        BigInteger xh = x10.getUpper(half);
        BigInteger yl = y10.getLower(half);
        BigInteger yh = y10.getUpper(half);
        BigInteger p12 = xh.multiply(yh);
        BigInteger p22 = xl.multiply(yl);
        BigInteger p32 = xh.add(xl).multiply(yh.add(yl));
        BigInteger result = p12.shiftLeft(half * 32).add(p32.subtract(p12).subtract(p22)).shiftLeft(half * 32).add(p22);
        if (x10.signum != y10.signum) {
            return result.negate();
        }
        return result;
    }

    private static BigInteger multiplyToomCook3(BigInteger a10, BigInteger b4) {
        int alen = a10.mag.length;
        int blen = b4.mag.length;
        int largest = Math.max(alen, blen);
        int k10 = (largest + 2) / 3;
        int r10 = largest - (k10 * 2);
        BigInteger a22 = a10.getToomSlice(k10, r10, 0, largest);
        BigInteger a12 = a10.getToomSlice(k10, r10, 1, largest);
        BigInteger a02 = a10.getToomSlice(k10, r10, 2, largest);
        BigInteger b22 = b4.getToomSlice(k10, r10, 0, largest);
        BigInteger b12 = b4.getToomSlice(k10, r10, 1, largest);
        BigInteger b02 = b4.getToomSlice(k10, r10, 2, largest);
        BigInteger v02 = a02.multiply(b02, true);
        BigInteger da1 = a22.add(a02);
        BigInteger db1 = b22.add(b02);
        BigInteger vm1 = da1.subtract(a12).multiply(db1.subtract(b12), true);
        BigInteger da12 = da1.add(a12);
        BigInteger db12 = db1.add(b12);
        BigInteger v12 = da12.multiply(db12, true);
        BigInteger v2 = da12.add(a22).shiftLeft(1).subtract(a02).multiply(db12.add(b22).shiftLeft(1).subtract(b02), true);
        BigInteger vinf = a22.multiply(b22, true);
        BigInteger t2 = v2.subtract(vm1).exactDivideBy3();
        BigInteger v22 = v12.subtract(vm1);
        BigInteger tm1 = v22.shiftRight(1);
        BigInteger t12 = v12.subtract(v02);
        BigInteger t22 = t2.subtract(t12).shiftRight(1);
        BigInteger t13 = t12.subtract(tm1).subtract(vinf);
        BigInteger t23 = t22.subtract(vinf.shiftLeft(1));
        int ss = k10 * 32;
        BigInteger result = vinf.shiftLeft(ss).add(t23).shiftLeft(ss).add(t13).shiftLeft(ss).add(tm1.subtract(t23)).shiftLeft(ss).add(v02);
        if (a10.signum != b4.signum) {
            return result.negate();
        }
        return result;
    }

    private BigInteger getToomSlice(int lowerSize, int upperSize, int slice, int fullsize) {
        int start;
        int end;
        int[] iArr = this.mag;
        int len = iArr.length;
        int offset = fullsize - len;
        if (slice == 0) {
            start = 0 - offset;
            end = (upperSize - 1) - offset;
        } else {
            start = (((slice - 1) * lowerSize) + upperSize) - offset;
            end = (start + lowerSize) - 1;
        }
        if (start < 0) {
            start = 0;
        }
        if (end >= 0) {
            int sliceSize = (end - start) + 1;
            if (sliceSize <= 0) {
                return ZERO;
            }
            if (start == 0 && sliceSize >= len) {
                return abs();
            }
            int[] intSlice = new int[sliceSize];
            System.arraycopy((Object) iArr, start, (Object) intSlice, 0, sliceSize);
            return new BigInteger(trustedStripLeadingZeroInts(intSlice), 1);
        }
        return ZERO;
    }

    private BigInteger exactDivideBy3() {
        int len = this.mag.length;
        int[] result = new int[len];
        long borrow = 0;
        for (int i10 = len - 1; i10 >= 0; i10--) {
            long x10 = this.mag[i10] & 4294967295L;
            long w3 = x10 - borrow;
            if (borrow > x10) {
                borrow = 1;
            } else {
                borrow = 0;
            }
            long q10 = 4294967295L & (w3 * 2863311531L);
            result[i10] = (int) q10;
            if (q10 >= 1431655766) {
                borrow++;
                if (q10 >= 2863311531L) {
                    borrow++;
                }
            }
        }
        return new BigInteger(trustedStripLeadingZeroInts(result), this.signum);
    }

    private BigInteger getLower(int n10) {
        int[] iArr = this.mag;
        int len = iArr.length;
        if (len <= n10) {
            return abs();
        }
        int[] lowerInts = new int[n10];
        System.arraycopy((Object) iArr, len - n10, (Object) lowerInts, 0, n10);
        return new BigInteger(trustedStripLeadingZeroInts(lowerInts), 1);
    }

    private BigInteger getUpper(int n10) {
        int[] iArr = this.mag;
        int len = iArr.length;
        if (len <= n10) {
            return ZERO;
        }
        int upperLen = len - n10;
        int[] upperInts = new int[upperLen];
        System.arraycopy((Object) iArr, 0, (Object) upperInts, 0, upperLen);
        return new BigInteger(trustedStripLeadingZeroInts(upperInts), 1);
    }

    private BigInteger square() {
        return square(false);
    }

    private BigInteger square(boolean isRecursion) {
        if (this.signum == 0) {
            return ZERO;
        }
        int[] iArr = this.mag;
        int len = iArr.length;
        if (len < 128) {
            int[] z10 = squareToLen(iArr, len, null);
            return new BigInteger(trustedStripLeadingZeroInts(z10), 1);
        }
        if (len < 216) {
            return squareKaratsuba();
        }
        if (!isRecursion && bitLength(iArr, iArr.length) > 1073741824) {
            reportOverflow();
        }
        return squareToomCook3();
    }

    private static final int[] squareToLen(int[] x10, int len, int[] z10) {
        int zlen = len << 1;
        if (z10 == null || z10.length < zlen) {
            z10 = new int[zlen];
        }
        implSquareToLenChecks(x10, len, z10, zlen);
        return implSquareToLen(x10, len, z10, zlen);
    }

    private static void implSquareToLenChecks(int[] x10, int len, int[] z10, int zlen) throws RuntimeException {
        if (len < 1) {
            throw new IllegalArgumentException("invalid input length: " + len);
        }
        if (len > x10.length) {
            throw new IllegalArgumentException("input length out of bound: " + len + " > " + x10.length);
        }
        if (len * 2 > z10.length) {
            throw new IllegalArgumentException("input length out of bound: " + (len * 2) + " > " + z10.length);
        }
        if (zlen < 1) {
            throw new IllegalArgumentException("invalid input length: " + zlen);
        }
        if (zlen > z10.length) {
            throw new IllegalArgumentException("input length out of bound: " + len + " > " + z10.length);
        }
    }

    private static final int[] implSquareToLen(int[] x10, int len, int[] z10, int zlen) {
        int lastProductLowWord = 0;
        int i10 = 0;
        for (int j10 = 0; j10 < len; j10++) {
            long piece = x10[j10] & 4294967295L;
            long product = piece * piece;
            int i11 = i10 + 1;
            z10[i10] = (lastProductLowWord << 31) | ((int) (product >>> 33));
            i10 = i11 + 1;
            z10[i11] = (int) (product >>> 1);
            lastProductLowWord = (int) product;
        }
        int i12 = len;
        int offset = 1;
        while (i12 > 0) {
            int t2 = x10[i12 - 1];
            addOne(z10, offset - 1, i12, mulAdd(z10, x10, offset, i12 - 1, t2));
            i12--;
            offset += 2;
        }
        primitiveLeftShift(z10, zlen, 1);
        int i13 = zlen - 1;
        z10[i13] = z10[i13] | (1 & x10[len - 1]);
        return z10;
    }

    private BigInteger squareKaratsuba() {
        int half = (this.mag.length + 1) / 2;
        BigInteger xl = getLower(half);
        BigInteger xh = getUpper(half);
        BigInteger xhs = xh.square();
        BigInteger xls = xl.square();
        return xhs.shiftLeft(half * 32).add(xl.add(xh).square().subtract(xhs.add(xls))).shiftLeft(half * 32).add(xls);
    }

    private BigInteger squareToomCook3() {
        int len = this.mag.length;
        int k10 = (len + 2) / 3;
        int r10 = len - (k10 * 2);
        BigInteger a22 = getToomSlice(k10, r10, 0, len);
        BigInteger a12 = getToomSlice(k10, r10, 1, len);
        BigInteger a02 = getToomSlice(k10, r10, 2, len);
        BigInteger v02 = a02.square(true);
        BigInteger da1 = a22.add(a02);
        BigInteger vm1 = da1.subtract(a12).square(true);
        BigInteger da12 = da1.add(a12);
        BigInteger v12 = da12.square(true);
        BigInteger vinf = a22.square(true);
        BigInteger v2 = da12.add(a22).shiftLeft(1).subtract(a02).square(true);
        BigInteger t2 = v2.subtract(vm1).exactDivideBy3();
        BigInteger tm1 = v12.subtract(vm1).shiftRight(1);
        BigInteger t12 = v12.subtract(v02);
        BigInteger t22 = t2.subtract(t12).shiftRight(1);
        BigInteger t23 = t12.subtract(tm1);
        BigInteger t13 = t23.subtract(vinf);
        BigInteger t24 = t22.subtract(vinf.shiftLeft(1));
        int ss = k10 * 32;
        return vinf.shiftLeft(ss).add(t24).shiftLeft(ss).add(t13).shiftLeft(ss).add(tm1.subtract(t24)).shiftLeft(ss).add(v02);
    }

    public BigInteger divide(BigInteger val) {
        int[] iArr = this.mag;
        if (iArr.length < 40 || iArr.length - val.mag.length < 20) {
            return divideKnuth(val);
        }
        return divideAndRemainder(val)[0];
    }

    private BigInteger divideKnuth(BigInteger val) {
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger a10 = new MutableBigInteger(this.mag);
        MutableBigInteger b4 = new MutableBigInteger(val.mag);
        a10.divideKnuth(b4, q10, false);
        return q10.toBigInteger(this.signum * val.signum);
    }

    public BigInteger[] divideAndRemainder(BigInteger val) {
        int[] iArr = val.mag;
        if (iArr.length >= 40) {
            int[] iArr2 = this.mag;
            if (iArr2.length >= 20 && iArr2.length - iArr.length >= 20) {
                int quotSign = this.signum == val.signum ? 1 : -1;
                long xBN = 0;
                long yBN = 0;
                long quotBN = 0;
                long remBN = 0;
                try {
                    long xBN2 = bigEndInts2NewBN(iArr2, false);
                    try {
                        long yBN2 = bigEndInts2NewBN(val.mag, false);
                        try {
                            quotBN = NativeBN.BN_new();
                            remBN = NativeBN.BN_new();
                            NativeBN.BN_div(quotBN, remBN, xBN2, yBN2);
                            BigInteger quotient = new BigInteger(quotSign, bn2BigEndInts(quotBN));
                            BigInteger remainder = new BigInteger(this.signum, bn2BigEndInts(remBN));
                            BigInteger[] result = {quotient, remainder};
                            NativeBN.BN_free(xBN2);
                            NativeBN.BN_free(yBN2);
                            NativeBN.BN_free(quotBN);
                            NativeBN.BN_free(remBN);
                            return result;
                        } catch (Throwable th) {
                            th = th;
                            xBN = xBN2;
                            yBN = yBN2;
                            NativeBN.BN_free(xBN);
                            NativeBN.BN_free(yBN);
                            NativeBN.BN_free(quotBN);
                            NativeBN.BN_free(remBN);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        xBN = xBN2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return divideAndRemainderKnuth(val);
    }

    private BigInteger[] divideAndRemainderKnuth(BigInteger val) {
        BigInteger[] result = new BigInteger[2];
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger a10 = new MutableBigInteger(this.mag);
        MutableBigInteger b4 = new MutableBigInteger(val.mag);
        MutableBigInteger r10 = a10.divideKnuth(b4, q10);
        result[0] = q10.toBigInteger(this.signum == val.signum ? 1 : -1);
        result[1] = r10.toBigInteger(this.signum);
        return result;
    }

    public BigInteger remainder(BigInteger val) {
        int[] iArr = val.mag;
        if (iArr.length < 40 || this.mag.length - iArr.length < 40) {
            return remainderKnuth(val);
        }
        return divideAndRemainder(val)[1];
    }

    private BigInteger remainderKnuth(BigInteger val) {
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger a10 = new MutableBigInteger(this.mag);
        MutableBigInteger b4 = new MutableBigInteger(val.mag);
        return a10.divideKnuth(b4, q10).toBigInteger(this.signum);
    }

    private BigInteger divideBurnikelZiegler(BigInteger val) {
        return divideAndRemainderBurnikelZiegler(val)[0];
    }

    private BigInteger remainderBurnikelZiegler(BigInteger val) {
        return divideAndRemainderBurnikelZiegler(val)[1];
    }

    private BigInteger[] divideAndRemainderBurnikelZiegler(BigInteger val) {
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger r10 = new MutableBigInteger(this).divideAndRemainderBurnikelZiegler(new MutableBigInteger(val), q10);
        BigInteger qBigInt = q10.isZero() ? ZERO : q10.toBigInteger(this.signum * val.signum);
        BigInteger rBigInt = r10.isZero() ? ZERO : r10.toBigInteger(this.signum);
        return new BigInteger[]{qBigInt, rBigInt};
    }

    public BigInteger pow(int exponent) {
        int remainingBits;
        if (exponent < 0) {
            throw new ArithmeticException("Negative exponent");
        }
        if (this.signum == 0) {
            return exponent == 0 ? ONE : this;
        }
        BigInteger partToSquare = abs();
        int powersOfTwo = partToSquare.getLowestSetBit();
        long bitsToShiftLong = powersOfTwo * exponent;
        if (bitsToShiftLong > ZipUtils.UPPER_UNIXTIME_BOUND) {
            reportOverflow();
        }
        int bitsToShift = (int) bitsToShiftLong;
        if (powersOfTwo > 0) {
            partToSquare = partToSquare.shiftRight(powersOfTwo);
            remainingBits = partToSquare.bitLength();
            if (remainingBits == 1) {
                if (this.signum < 0 && (exponent & 1) == 1) {
                    return NEGATIVE_ONE.shiftLeft(bitsToShift);
                }
                return ONE.shiftLeft(bitsToShift);
            }
        } else {
            remainingBits = partToSquare.bitLength();
            if (remainingBits == 1) {
                if (this.signum < 0 && (exponent & 1) == 1) {
                    return NEGATIVE_ONE;
                }
                return ONE;
            }
        }
        long scaleFactor = remainingBits * exponent;
        if (partToSquare.mag.length != 1 || scaleFactor > 62) {
            BigInteger partToSquare2 = partToSquare;
            if ((bitLength() * exponent) / 32 > 67108864) {
                reportOverflow();
            }
            BigInteger answer = ONE;
            int workingExponent = exponent;
            BigInteger answer2 = answer;
            BigInteger partToSquare3 = partToSquare2;
            while (workingExponent != 0) {
                if ((workingExponent & 1) == 1) {
                    answer2 = answer2.multiply(partToSquare3);
                }
                int i10 = workingExponent >>> 1;
                workingExponent = i10;
                if (i10 != 0) {
                    partToSquare3 = partToSquare3.square();
                }
            }
            if (powersOfTwo > 0) {
                answer2 = answer2.shiftLeft(bitsToShift);
            }
            if (this.signum < 0 && (exponent & 1) == 1) {
                return answer2.negate();
            }
            return answer2;
        }
        int newSign = (this.signum >= 0 || (exponent & 1) != 1) ? 1 : -1;
        long result = 1;
        long baseToPow2 = r11[0] & 4294967295L;
        int workingExponent2 = exponent;
        while (workingExponent2 != 0) {
            BigInteger partToSquare4 = partToSquare;
            if ((workingExponent2 & 1) == 1) {
                result *= baseToPow2;
            }
            int i11 = workingExponent2 >>> 1;
            workingExponent2 = i11;
            if (i11 == 0) {
                partToSquare = partToSquare4;
            } else {
                baseToPow2 *= baseToPow2;
                partToSquare = partToSquare4;
            }
        }
        if (powersOfTwo <= 0) {
            return valueOf(newSign * result);
        }
        if (bitsToShift + scaleFactor <= 62) {
            return valueOf((result << bitsToShift) * newSign);
        }
        return valueOf(newSign * result).shiftLeft(bitsToShift);
    }

    public BigInteger sqrt() {
        if (this.signum < 0) {
            throw new ArithmeticException("Negative BigInteger");
        }
        return new MutableBigInteger(this.mag).sqrt().toBigInteger();
    }

    public BigInteger[] sqrtAndRemainder() {
        BigInteger s2 = sqrt();
        BigInteger r10 = subtract(s2.square());
        return new BigInteger[]{s2, r10};
    }

    public BigInteger gcd(BigInteger val) {
        if (val.signum == 0) {
            return abs();
        }
        if (this.signum == 0) {
            return val.abs();
        }
        MutableBigInteger a10 = new MutableBigInteger(this);
        MutableBigInteger b4 = new MutableBigInteger(val);
        MutableBigInteger result = a10.hybridGCD(b4);
        return result.toBigInteger(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int bitLengthForInt(int n10) {
        return 32 - Integer.numberOfLeadingZeros(n10);
    }

    private static int[] leftShift(int[] a10, int len, int n10) {
        int nInts = n10 >>> 5;
        int nBits = n10 & 31;
        int bitsInHighWord = bitLengthForInt(a10[0]);
        if (n10 <= 32 - bitsInHighWord) {
            primitiveLeftShift(a10, len, nBits);
            return a10;
        }
        if (nBits <= 32 - bitsInHighWord) {
            int[] result = new int[nInts + len];
            System.arraycopy((Object) a10, 0, (Object) result, 0, len);
            primitiveLeftShift(result, result.length, nBits);
            return result;
        }
        int[] result2 = new int[nInts + len + 1];
        System.arraycopy((Object) a10, 0, (Object) result2, 0, len);
        primitiveRightShift(result2, result2.length, 32 - nBits);
        return result2;
    }

    static void primitiveRightShift(int[] a10, int len, int n10) {
        Objects.checkFromToIndex(0, len, a10.length);
        shiftRightImplWorker(a10, a10, 1, n10, len - 1);
        a10[0] = a10[0] >>> n10;
    }

    static void primitiveLeftShift(int[] a10, int len, int n10) {
        if (len == 0 || n10 == 0) {
            return;
        }
        Objects.checkFromToIndex(0, len, a10.length);
        shiftLeftImplWorker(a10, a10, 0, n10, len - 1);
        int i10 = len - 1;
        a10[i10] = a10[i10] << n10;
    }

    private static int bitLength(int[] val, int len) {
        if (len == 0) {
            return 0;
        }
        return ((len - 1) << 5) + bitLengthForInt(val[0]);
    }

    public BigInteger abs() {
        return this.signum >= 0 ? this : negate();
    }

    public BigInteger negate() {
        return new BigInteger(this.mag, -this.signum);
    }

    public int signum() {
        return this.signum;
    }

    public BigInteger mod(BigInteger m10) {
        if (m10.signum <= 0) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        BigInteger result = remainder(m10);
        return result.signum >= 0 ? result : result.add(m10);
    }

    private static int[] reverse(int[] arg) {
        int len = arg.length;
        int[] result = new int[len];
        for (int i10 = 0; i10 < len; i10++) {
            result[i10] = arg[(len - i10) - 1];
        }
        return result;
    }

    private static long bigEndInts2NewBN(int[] beArray, boolean neg) {
        int[] leArray = reverse(beArray);
        long resultBN = NativeBN.BN_new();
        NativeBN.litEndInts2bn(leArray, leArray.length, neg, resultBN);
        return resultBN;
    }

    private int[] bn2BigEndInts(long bn) {
        return reverse(NativeBN.bn2litEndInts(bn));
    }

    public BigInteger modPow(BigInteger exponent, BigInteger m10) {
        BigInteger exponent2;
        BigInteger mod;
        BigInteger base2;
        BigInteger result;
        if (m10.signum <= 0) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        if (exponent.signum == 0) {
            BigInteger bigInteger = ONE;
            return m10.equals(bigInteger) ? ZERO : bigInteger;
        }
        BigInteger bigInteger2 = ONE;
        if (equals(bigInteger2)) {
            return m10.equals(bigInteger2) ? ZERO : bigInteger2;
        }
        BigInteger bigInteger3 = ZERO;
        if (!equals(bigInteger3) || exponent.signum < 0) {
            if (equals(negConst[1]) && !exponent.testBit(0)) {
                return m10.equals(bigInteger2) ? bigInteger3 : bigInteger2;
            }
            boolean z10 = exponent.signum < 0;
            boolean invertResult = z10;
            if (!z10) {
                exponent2 = exponent;
            } else {
                exponent2 = exponent.negate();
            }
            if (this.signum < 0 || compareTo(m10) >= 0) {
                mod = mod(m10);
            } else {
                mod = this;
            }
            BigInteger base = mod;
            if (m10.mag.length >= 3) {
                long resultBN = 0;
                long expBN = 0;
                long modBN = 0;
                long resultBN2 = 0;
                try {
                    long baseBN = bigEndInts2NewBN(base.mag, false);
                    try {
                        long expBN2 = bigEndInts2NewBN(exponent2.mag, false);
                        try {
                            long modBN2 = bigEndInts2NewBN(m10.mag, false);
                            try {
                                long resultBN3 = NativeBN.BN_new();
                                try {
                                    NativeBN.BN_mod_exp(resultBN3, baseBN, expBN2, modBN2);
                                    BigInteger result2 = new BigInteger(1, bn2BigEndInts(resultBN3));
                                    BigInteger modInverse = invertResult ? result2.modInverse(m10) : result2;
                                    NativeBN.BN_free(baseBN);
                                    NativeBN.BN_free(expBN2);
                                    NativeBN.BN_free(modBN2);
                                    NativeBN.BN_free(resultBN3);
                                    return modInverse;
                                } catch (Throwable th) {
                                    th = th;
                                    resultBN2 = resultBN3;
                                    resultBN = baseBN;
                                    expBN = expBN2;
                                    modBN = modBN2;
                                    NativeBN.BN_free(resultBN);
                                    NativeBN.BN_free(expBN);
                                    NativeBN.BN_free(modBN);
                                    NativeBN.BN_free(resultBN2);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                resultBN = baseBN;
                                expBN = expBN2;
                                modBN = modBN2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            resultBN = baseBN;
                            expBN = expBN2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        resultBN = baseBN;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } else {
                if (m10.testBit(0)) {
                    result = base.oddModPow(exponent2, m10);
                } else {
                    int p10 = m10.getLowestSetBit();
                    BigInteger m12 = m10.shiftRight(p10);
                    BigInteger m22 = bigInteger2.shiftLeft(p10);
                    if (this.signum < 0 || compareTo(m12) >= 0) {
                        base2 = mod(m12);
                    } else {
                        base2 = this;
                    }
                    if (!m12.equals(bigInteger2)) {
                        bigInteger3 = base2.oddModPow(exponent2, m12);
                    }
                    BigInteger a12 = bigInteger3;
                    BigInteger a22 = base.modPow2(exponent2, p10);
                    BigInteger y1 = m22.modInverse(m12);
                    BigInteger y22 = m12.modInverse(m22);
                    if (m10.mag.length < 33554432) {
                        result = a12.multiply(m22).multiply(y1).add(a22.multiply(m12).multiply(y22)).mod(m10);
                    } else {
                        MutableBigInteger t12 = new MutableBigInteger();
                        new MutableBigInteger(a12.multiply(m22)).multiply(new MutableBigInteger(y1), t12);
                        MutableBigInteger t2 = new MutableBigInteger();
                        new MutableBigInteger(a22.multiply(m12)).multiply(new MutableBigInteger(y22), t2);
                        t12.add(t2);
                        MutableBigInteger q10 = new MutableBigInteger();
                        result = t12.divide(new MutableBigInteger(m10), q10).toBigInteger();
                    }
                }
                return invertResult ? result.modInverse(m10) : result;
            }
        } else {
            return bigInteger3;
        }
    }

    private static int[] montgomeryMultiply(int[] a10, int[] b4, int[] n10, int len, long inv, int[] product) {
        implMontgomeryMultiplyChecks(a10, b4, n10, len, product);
        if (len > 512) {
            return montReduce(multiplyToLen(a10, len, b4, len, product), n10, len, (int) inv);
        }
        return implMontgomeryMultiply(a10, b4, n10, len, inv, materialize(product, len));
    }

    private static int[] montgomerySquare(int[] a10, int[] n10, int len, long inv, int[] product) {
        implMontgomeryMultiplyChecks(a10, a10, n10, len, product);
        if (len > 512) {
            return montReduce(squareToLen(a10, len, product), n10, len, (int) inv);
        }
        return implMontgomerySquare(a10, n10, len, inv, materialize(product, len));
    }

    private static void implMontgomeryMultiplyChecks(int[] a10, int[] b4, int[] n10, int len, int[] product) throws RuntimeException {
        if (len % 2 != 0) {
            throw new IllegalArgumentException("input array length must be even: " + len);
        }
        if (len < 1) {
            throw new IllegalArgumentException("invalid input length: " + len);
        }
        if (len > a10.length || len > b4.length || len > n10.length || (product != null && len > product.length)) {
            throw new IllegalArgumentException("input array length out of bound: " + len);
        }
    }

    private static int[] materialize(int[] z10, int len) {
        if (z10 == null || z10.length < len) {
            return new int[len];
        }
        return z10;
    }

    private static int[] implMontgomeryMultiply(int[] a10, int[] b4, int[] n10, int len, long inv, int[] product) {
        return montReduce(multiplyToLen(a10, len, b4, len, product), n10, len, (int) inv);
    }

    private static int[] implMontgomerySquare(int[] a10, int[] n10, int len, long inv, int[] product) {
        return montReduce(squareToLen(a10, len, product), n10, len, (int) inv);
    }

    private BigInteger oddModPow(BigInteger y10, BigInteger z10) {
        int[] a10;
        int[] b4;
        int[] mult;
        int[] mult2;
        int bitpos;
        int elen;
        int eIndex;
        int buf;
        int[] mult3;
        int multpos;
        int ebits;
        int[] b10;
        if (y10.equals(ONE)) {
            return this;
        }
        if (this.signum == 0) {
            return ZERO;
        }
        int[] base = (int[]) this.mag.clone();
        int[] exp = y10.mag;
        int[] mod = z10.mag;
        int modLen = mod.length;
        if ((modLen & 1) != 0) {
            int[] x10 = new int[modLen + 1];
            System.arraycopy((Object) mod, 0, (Object) x10, 1, modLen);
            mod = x10;
            modLen++;
        }
        int wbits = 0;
        int ebits2 = bitLength(exp, exp.length);
        if (ebits2 != 17 || exp[0] != 65537) {
            while (ebits2 > bnExpModThreshTable[wbits]) {
                wbits++;
            }
        }
        int tblmask = 1 << wbits;
        int[][] table = new int[tblmask];
        for (int i10 = 0; i10 < tblmask; i10++) {
            table[i10] = new int[modLen];
        }
        int i11 = modLen - 1;
        long n02 = ((mod[modLen - 2] & 4294967295L) << 32) + (mod[i11] & 4294967295L);
        long inv = -MutableBigInteger.inverseMod64(n02);
        int[] a11 = leftShift(base, base.length, modLen << 5);
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger a22 = new MutableBigInteger(a11);
        MutableBigInteger b22 = new MutableBigInteger(mod);
        b22.normalize();
        MutableBigInteger r10 = a22.divide(b22, q10);
        table[0] = r10.toIntArray();
        if (table[0].length < modLen) {
            int offset = modLen - table[0].length;
            int[] base2 = new int[modLen];
            System.arraycopy((Object) table[0], 0, (Object) base2, offset, table[0].length);
            table[0] = base2;
        }
        int[] b11 = montgomerySquare(table[0], mod, modLen, inv, null);
        int[] t2 = Arrays.copyOf(b11, modLen);
        int i12 = 1;
        while (i12 < tblmask) {
            int i13 = i12;
            table[i13] = montgomeryMultiply(t2, table[i12 - 1], mod, modLen, inv, null);
            i12 = i13 + 1;
        }
        int bitpos2 = 1 << ((ebits2 - 1) & 31);
        int buf2 = 0;
        int elen2 = exp.length;
        int eIndex2 = 0;
        for (int i14 = 0; i14 <= wbits; i14++) {
            buf2 = (buf2 << 1) | ((exp[eIndex2] & bitpos2) != 0 ? 1 : 0);
            bitpos2 >>>= 1;
            if (bitpos2 == 0) {
                eIndex2++;
                bitpos2 = Integer.MIN_VALUE;
                elen2--;
            }
        }
        int ebits3 = ebits2 - 1;
        int multpos2 = ebits3 - wbits;
        while ((buf2 & 1) == 0) {
            buf2 >>>= 1;
            multpos2++;
        }
        int[] mult4 = table[buf2 >>> 1];
        int buf3 = 0;
        if (multpos2 == ebits3) {
            a10 = b11;
            b4 = a11;
            mult = null;
            mult2 = mult4;
        } else {
            a10 = b11;
            b4 = a11;
            mult = 1;
            mult2 = mult4;
        }
        while (true) {
            int ebits4 = ebits3 - 1;
            int buf4 = buf3 << 1;
            if (elen2 == 0) {
                bitpos = bitpos2;
                elen = elen2;
                eIndex = eIndex2;
            } else {
                buf4 |= (exp[eIndex2] & bitpos2) != 0 ? 1 : 0;
                int bitpos3 = bitpos2 >>> 1;
                if (bitpos3 != 0) {
                    bitpos = bitpos3;
                    elen = elen2;
                    eIndex = eIndex2;
                } else {
                    bitpos = Integer.MIN_VALUE;
                    elen = elen2 - 1;
                    eIndex = eIndex2 + 1;
                }
            }
            int bitpos4 = buf4 & tblmask;
            if (bitpos4 == 0) {
                buf = buf4;
                mult3 = mult2;
            } else {
                int multpos3 = ebits4 - wbits;
                while ((buf4 & 1) == 0) {
                    buf4 >>>= 1;
                    multpos3++;
                }
                int[] mult5 = table[buf4 >>> 1];
                multpos2 = multpos3;
                buf = 0;
                mult3 = mult5;
            }
            if (ebits4 != multpos2) {
                multpos = multpos2;
                ebits = ebits4;
                b10 = a10;
            } else if (mult != null) {
                mult = null;
                multpos = multpos2;
                ebits = ebits4;
                b10 = (int[]) mult3.clone();
            } else {
                multpos = multpos2;
                ebits = ebits4;
                int[] a12 = montgomeryMultiply(a10, mult3, mod, modLen, inv, b4);
                b4 = a10;
                b10 = a12;
            }
            if (ebits == 0) {
                int[] t22 = new int[modLen * 2];
                System.arraycopy((Object) b10, 0, (Object) t22, modLen, modLen);
                return new BigInteger(1, Arrays.copyOf(montReduce(t22, mod, modLen, (int) inv), modLen));
            }
            if (mult == null) {
                int[] t10 = b10;
                int[] a13 = montgomerySquare(t10, mod, modLen, inv, b4);
                b4 = b10;
                a10 = a13;
                bitpos2 = bitpos;
                elen2 = elen;
                eIndex2 = eIndex;
                buf3 = buf;
                mult2 = mult3;
                ebits3 = ebits;
                multpos2 = multpos;
            } else {
                a10 = b10;
                bitpos2 = bitpos;
                elen2 = elen;
                eIndex2 = eIndex;
                buf3 = buf;
                mult2 = mult3;
                ebits3 = ebits;
                multpos2 = multpos;
            }
        }
    }

    private static int[] montReduce(int[] n10, int[] mod, int mlen, int inv) {
        int c4 = 0;
        int len = mlen;
        int offset = 0;
        do {
            int nEnd = n10[(n10.length - 1) - offset];
            int carry = mulAdd(n10, mod, offset, mlen, inv * nEnd);
            c4 += addOne(n10, offset, mlen, carry);
            offset++;
            len--;
        } while (len > 0);
        while (c4 > 0) {
            c4 += subN(n10, mod, mlen);
        }
        while (intArrayCmpToLen(n10, mod, mlen) >= 0) {
            subN(n10, mod, mlen);
        }
        return n10;
    }

    private static int intArrayCmpToLen(int[] arg1, int[] arg2, int len) {
        for (int i10 = 0; i10 < len; i10++) {
            long b12 = arg1[i10] & 4294967295L;
            long b22 = 4294967295L & arg2[i10];
            if (b12 < b22) {
                return -1;
            }
            if (b12 > b22) {
                return 1;
            }
        }
        return 0;
    }

    private static int subN(int[] a10, int[] b4, int len) {
        long sum = 0;
        while (true) {
            len--;
            if (len >= 0) {
                sum = ((a10[len] & 4294967295L) - (4294967295L & b4[len])) + (sum >> 32);
                a10[len] = (int) sum;
            } else {
                return (int) (sum >> 32);
            }
        }
    }

    static int mulAdd(int[] out, int[] in, int offset, int len, int k10) {
        implMulAddCheck(out, in, offset, len, k10);
        return implMulAdd(out, in, offset, len, k10);
    }

    private static void implMulAddCheck(int[] out, int[] in, int offset, int len, int k10) {
        if (len > in.length) {
            throw new IllegalArgumentException("input length is out of bound: " + len + " > " + in.length);
        }
        if (offset < 0) {
            throw new IllegalArgumentException("input offset is invalid: " + offset);
        }
        if (offset > out.length - 1) {
            throw new IllegalArgumentException("input offset is out of bound: " + offset + " > " + (out.length - 1));
        }
        if (len > out.length - offset) {
            throw new IllegalArgumentException("input len is out of bound: " + len + " > " + (out.length - offset));
        }
    }

    private static int implMulAdd(int[] out, int[] in, int offset, int len, int k10) {
        long kLong = k10 & 4294967295L;
        long carry = 0;
        int offset2 = (out.length - offset) - 1;
        int j10 = len - 1;
        while (j10 >= 0) {
            long product = ((in[j10] & 4294967295L) * kLong) + (out[offset2] & 4294967295L) + carry;
            out[offset2] = (int) product;
            carry = product >>> 32;
            j10--;
            offset2--;
        }
        int j11 = (int) carry;
        return j11;
    }

    static int addOne(int[] a10, int offset, int mlen, int carry) {
        int offset2 = ((a10.length - 1) - mlen) - offset;
        long t2 = (a10[offset2] & 4294967295L) + (4294967295L & carry);
        a10[offset2] = (int) t2;
        if ((t2 >>> 32) == 0) {
            return 0;
        }
        do {
            mlen--;
            if (mlen < 0 || offset2 - 1 < 0) {
                return 1;
            }
            a10[offset2] = a10[offset2] + 1;
        } while (a10[offset2] == 0);
        return 0;
    }

    private BigInteger modPow2(BigInteger exponent, int p10) {
        BigInteger result = ONE;
        BigInteger baseToPow2 = mod2(p10);
        int expOffset = 0;
        int limit = exponent.bitLength();
        if (testBit(0)) {
            limit = p10 + (-1) < limit ? p10 - 1 : limit;
        }
        while (expOffset < limit) {
            if (exponent.testBit(expOffset)) {
                result = result.multiply(baseToPow2).mod2(p10);
            }
            expOffset++;
            if (expOffset < limit) {
                baseToPow2 = baseToPow2.square().mod2(p10);
            }
        }
        return result;
    }

    private BigInteger mod2(int p10) {
        if (bitLength() <= p10) {
            return this;
        }
        int numInts = (p10 + 31) >>> 5;
        int[] mag = new int[numInts];
        int[] iArr = this.mag;
        System.arraycopy((Object) iArr, iArr.length - numInts, (Object) mag, 0, numInts);
        int excessBits = (numInts << 5) - p10;
        mag[0] = (int) (mag[0] & ((1 << (32 - excessBits)) - 1));
        return mag[0] == 0 ? new BigInteger(1, mag) : new BigInteger(mag, 1);
    }

    public BigInteger modInverse(BigInteger m10) {
        if (m10.signum != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        BigInteger bigInteger = ONE;
        if (m10.equals(bigInteger)) {
            return ZERO;
        }
        BigInteger modVal = this;
        if (this.signum < 0 || compareMagnitude(m10) >= 0) {
            modVal = mod(m10);
        }
        if (modVal.equals(bigInteger)) {
            return bigInteger;
        }
        MutableBigInteger a10 = new MutableBigInteger(modVal);
        MutableBigInteger b4 = new MutableBigInteger(m10);
        MutableBigInteger result = a10.mutableModInverse(b4);
        return result.toBigInteger(1);
    }

    public BigInteger shiftLeft(int n10) {
        if (this.signum == 0) {
            return ZERO;
        }
        if (n10 > 0) {
            return new BigInteger(shiftLeft(this.mag, n10), this.signum);
        }
        if (n10 == 0) {
            return this;
        }
        return shiftRightImpl(-n10);
    }

    private static int[] shiftLeft(int[] mag, int n10) {
        int[] newMag;
        int nInts = n10 >>> 5;
        int nBits = n10 & 31;
        int magLen = mag.length;
        if (nBits == 0) {
            int[] newMag2 = new int[magLen + nInts];
            System.arraycopy((Object) mag, 0, (Object) newMag2, 0, magLen);
            return newMag2;
        }
        int i10 = 0;
        int nBits2 = 32 - nBits;
        int highBits = mag[0] >>> nBits2;
        if (highBits != 0) {
            newMag = new int[magLen + nInts + 1];
            int i11 = 0 + 1;
            newMag[0] = highBits;
            i10 = i11;
        } else {
            int i12 = magLen + nInts;
            newMag = new int[i12];
        }
        int numIter = magLen - 1;
        Objects.checkFromToIndex(0, numIter + 1, mag.length);
        Objects.checkFromToIndex(i10, numIter + i10 + 1, newMag.length);
        shiftLeftImplWorker(newMag, mag, i10, nBits, numIter);
        newMag[numIter + i10] = mag[numIter] << nBits;
        return newMag;
    }

    private static void shiftLeftImplWorker(int[] newArr, int[] oldArr, int newIdx, int shiftCount, int numIter) {
        int shiftCountRight = 32 - shiftCount;
        int oldIdx = 0;
        while (oldIdx < numIter) {
            int oldIdx2 = oldIdx + 1;
            newArr[newIdx] = (oldArr[oldIdx] << shiftCount) | (oldArr[oldIdx2] >>> shiftCountRight);
            newIdx++;
            oldIdx = oldIdx2;
        }
    }

    public BigInteger shiftRight(int n10) {
        if (this.signum == 0) {
            return ZERO;
        }
        if (n10 > 0) {
            return shiftRightImpl(n10);
        }
        if (n10 == 0) {
            return this;
        }
        return new BigInteger(shiftLeft(this.mag, -n10), this.signum);
    }

    private BigInteger shiftRightImpl(int n10) {
        int[] newMag;
        int[] newMag2;
        boolean z10;
        int nInts = n10 >>> 5;
        int nBits = n10 & 31;
        int[] iArr = this.mag;
        int magLen = iArr.length;
        boolean z11 = true;
        if (nInts >= magLen) {
            return this.signum >= 0 ? ZERO : negConst[1];
        }
        if (nBits == 0) {
            int newMagLen = magLen - nInts;
            newMag2 = Arrays.copyOf(iArr, newMagLen);
        } else {
            int i10 = 0;
            int highBits = iArr[0] >>> nBits;
            if (highBits != 0) {
                newMag = new int[magLen - nInts];
                int i11 = 0 + 1;
                newMag[0] = highBits;
                i10 = i11;
            } else {
                int i12 = magLen - nInts;
                newMag = new int[i12 - 1];
            }
            int numIter = (magLen - nInts) - 1;
            Objects.checkFromToIndex(0, numIter + 1, iArr.length);
            Objects.checkFromToIndex(i10, numIter + i10, newMag.length);
            shiftRightImplWorker(newMag, this.mag, i10, nBits, numIter);
            newMag2 = newMag;
        }
        if (this.signum < 0) {
            boolean onesLost = false;
            int j10 = magLen - nInts;
            for (int i13 = magLen - 1; i13 >= j10 && !onesLost; i13--) {
                if (this.mag[i13] != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                onesLost = z10;
            }
            if (!onesLost && nBits != 0) {
                if ((this.mag[(magLen - nInts) - 1] << (32 - nBits)) == 0) {
                    z11 = false;
                }
                onesLost = z11;
            }
            if (onesLost) {
                newMag2 = javaIncrement(newMag2);
            }
        }
        return new BigInteger(newMag2, this.signum);
    }

    private static void shiftRightImplWorker(int[] newArr, int[] oldArr, int newIdx, int shiftCount, int numIter) {
        int shiftCountLeft = 32 - shiftCount;
        int idx = numIter;
        int nidx = newIdx == 0 ? numIter - 1 : numIter;
        while (nidx >= newIdx) {
            int idx2 = idx - 1;
            newArr[nidx] = (oldArr[idx] >>> shiftCount) | (oldArr[idx2] << shiftCountLeft);
            nidx--;
            idx = idx2;
        }
    }

    int[] javaIncrement(int[] val) {
        int lastSum = 0;
        for (int i10 = val.length - 1; i10 >= 0 && lastSum == 0; i10--) {
            int i11 = val[i10] + 1;
            val[i10] = i11;
            lastSum = i11;
        }
        if (lastSum == 0) {
            int[] val2 = new int[val.length + 1];
            val2[0] = 1;
            return val2;
        }
        return val;
    }

    public BigInteger and(BigInteger val) {
        int[] result = new int[Math.max(intLength(), val.intLength())];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = getInt((result.length - i10) - 1) & val.getInt((result.length - i10) - 1);
        }
        return valueOf(result);
    }

    public BigInteger or(BigInteger val) {
        int[] result = new int[Math.max(intLength(), val.intLength())];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = getInt((result.length - i10) - 1) | val.getInt((result.length - i10) - 1);
        }
        return valueOf(result);
    }

    public BigInteger xor(BigInteger val) {
        int[] result = new int[Math.max(intLength(), val.intLength())];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = getInt((result.length - i10) - 1) ^ val.getInt((result.length - i10) - 1);
        }
        return valueOf(result);
    }

    public BigInteger not() {
        int[] result = new int[intLength()];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = ~getInt((result.length - i10) - 1);
        }
        return valueOf(result);
    }

    public BigInteger andNot(BigInteger val) {
        int[] result = new int[Math.max(intLength(), val.intLength())];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = getInt((result.length - i10) - 1) & (~val.getInt((result.length - i10) - 1));
        }
        return valueOf(result);
    }

    public boolean testBit(int n10) {
        if (n10 >= 0) {
            return (getInt(n10 >>> 5) & (1 << (n10 & 31))) != 0;
        }
        throw new ArithmeticException("Negative bit address");
    }

    public BigInteger setBit(int n10) {
        if (n10 < 0) {
            throw new ArithmeticException("Negative bit address");
        }
        int intNum = n10 >>> 5;
        int[] result = new int[Math.max(intLength(), intNum + 2)];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[(result.length - i10) - 1] = getInt(i10);
        }
        int i11 = result.length;
        int i12 = (i11 - intNum) - 1;
        result[i12] = result[i12] | (1 << (n10 & 31));
        return valueOf(result);
    }

    public BigInteger clearBit(int n10) {
        if (n10 < 0) {
            throw new ArithmeticException("Negative bit address");
        }
        int intNum = n10 >>> 5;
        int[] result = new int[Math.max(intLength(), ((n10 + 1) >>> 5) + 1)];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[(result.length - i10) - 1] = getInt(i10);
        }
        int i11 = result.length;
        int i12 = (i11 - intNum) - 1;
        result[i12] = (~(1 << (n10 & 31))) & result[i12];
        return valueOf(result);
    }

    public BigInteger flipBit(int n10) {
        if (n10 < 0) {
            throw new ArithmeticException("Negative bit address");
        }
        int intNum = n10 >>> 5;
        int[] result = new int[Math.max(intLength(), intNum + 2)];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[(result.length - i10) - 1] = getInt(i10);
        }
        int i11 = result.length;
        int i12 = (i11 - intNum) - 1;
        result[i12] = result[i12] ^ (1 << (n10 & 31));
        return valueOf(result);
    }

    public int getLowestSetBit() {
        int b4;
        int lsb = this.lowestSetBitPlusTwo - 2;
        if (lsb == -2) {
            if (this.signum == 0) {
                lsb = 0 - 1;
            } else {
                int i10 = 0;
                while (true) {
                    b4 = getInt(i10);
                    if (b4 != 0) {
                        break;
                    }
                    i10++;
                }
                lsb = 0 + (i10 << 5) + Integer.numberOfTrailingZeros(b4);
            }
            int i11 = lsb + 2;
            this.lowestSetBitPlusTwo = i11;
        }
        return lsb;
    }

    public int bitLength() {
        int n10 = this.bitLengthPlusOne - 1;
        if (n10 == -1) {
            int[] m10 = this.mag;
            int len = m10.length;
            if (len == 0) {
                n10 = 0;
            } else {
                int magBitLength = ((len - 1) << 5) + bitLengthForInt(this.mag[0]);
                if (this.signum < 0) {
                    boolean pow2 = Integer.bitCount(this.mag[0]) == 1;
                    for (int i10 = 1; i10 < len && pow2; i10++) {
                        pow2 = this.mag[i10] == 0;
                    }
                    n10 = pow2 ? magBitLength - 1 : magBitLength;
                } else {
                    n10 = magBitLength;
                }
            }
            this.bitLengthPlusOne = n10 + 1;
        }
        return n10;
    }

    public int bitCount() {
        int[] iArr;
        int bc2 = this.bitCountPlusOne - 1;
        if (bc2 == -1) {
            bc2 = 0;
            int i10 = 0;
            while (true) {
                iArr = this.mag;
                if (i10 >= iArr.length) {
                    break;
                }
                bc2 += Integer.bitCount(iArr[i10]);
                i10++;
            }
            int i11 = this.signum;
            if (i11 < 0) {
                int magTrailingZeroCount = 0;
                int j10 = iArr.length;
                while (true) {
                    j10--;
                    if (this.mag[j10] != 0) {
                        break;
                    }
                    magTrailingZeroCount += 32;
                }
                bc2 += (magTrailingZeroCount + Integer.numberOfTrailingZeros(r3)) - 1;
            }
            int magTrailingZeroCount2 = bc2 + 1;
            this.bitCountPlusOne = magTrailingZeroCount2;
        }
        return bc2;
    }

    public boolean isProbablePrime(int certainty) {
        if (certainty <= 0) {
            return true;
        }
        BigInteger w3 = abs();
        if (w3.equals(TWO)) {
            return true;
        }
        if (!w3.testBit(0) || w3.equals(ONE)) {
            return false;
        }
        return w3.primeToCertainty(certainty, null);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigInteger val) {
        int i10 = this.signum;
        int i11 = val.signum;
        if (i10 != i11) {
            return i10 > i11 ? 1 : -1;
        }
        switch (i10) {
            case -1:
                return val.compareMagnitude(this);
            case 0:
            default:
                return 0;
            case 1:
                return compareMagnitude(val);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int compareMagnitude(BigInteger val) {
        int[] m12 = this.mag;
        int len1 = m12.length;
        int[] m22 = val.mag;
        int len2 = m22.length;
        if (len1 < len2) {
            return -1;
        }
        if (len1 > len2) {
            return 1;
        }
        for (int i10 = 0; i10 < len1; i10++) {
            int a10 = m12[i10];
            int b4 = m22[i10];
            if (a10 != b4) {
                return (((long) a10) & 4294967295L) < (((long) b4) & 4294967295L) ? -1 : 1;
            }
        }
        return 0;
    }

    final int compareMagnitude(long val) {
        long val2 = val;
        int[] m12 = this.mag;
        int len = m12.length;
        if (len > 2) {
            return 1;
        }
        if (val2 < 0) {
            val2 = -val2;
        }
        int highWord = (int) (val2 >>> 32);
        if (highWord != 0) {
            if (len < 2) {
                return -1;
            }
            int a10 = m12[0];
            if (a10 != highWord) {
                return (((long) a10) & 4294967295L) < (4294967295L & ((long) highWord)) ? -1 : 1;
            }
            int a11 = m12[1];
            int b4 = (int) val2;
            if (a11 != b4) {
                return (((long) a11) & 4294967295L) < (4294967295L & ((long) b4)) ? -1 : 1;
            }
            return 0;
        }
        if (len < 1) {
            return -1;
        }
        if (len > 1) {
            return 1;
        }
        int a12 = m12[0];
        int b10 = (int) val2;
        if (a12 != b10) {
            return (((long) a12) & 4294967295L) < (((long) b10) & 4294967295L) ? -1 : 1;
        }
        return 0;
    }

    public boolean equals(Object x10) {
        if (x10 == this) {
            return true;
        }
        if (!(x10 instanceof BigInteger)) {
            return false;
        }
        BigInteger xInt = (BigInteger) x10;
        if (xInt.signum != this.signum) {
            return false;
        }
        int[] m10 = this.mag;
        int len = m10.length;
        int[] xm = xInt.mag;
        if (len != xm.length) {
            return false;
        }
        for (int i10 = 0; i10 < len; i10++) {
            if (xm[i10] != m10[i10]) {
                return false;
            }
        }
        return true;
    }

    public BigInteger min(BigInteger val) {
        return compareTo(val) < 0 ? this : val;
    }

    public BigInteger max(BigInteger val) {
        return compareTo(val) > 0 ? this : val;
    }

    public int hashCode() {
        int hashCode = 0;
        int i10 = 0;
        while (true) {
            if (i10 < this.mag.length) {
                hashCode = (int) ((hashCode * 31) + (r2[i10] & 4294967295L));
                i10++;
            } else {
                int i11 = this.signum;
                return i11 * hashCode;
            }
        }
    }

    public String toString(int radix) {
        if (this.signum == 0) {
            return "0";
        }
        if (radix < 2 || radix > 36) {
            radix = 10;
        }
        BigInteger abs = abs();
        int b4 = abs.bitLength();
        int numChars = ((int) (Math.floor((b4 * LOG_TWO) / logCache[radix]) + 1.0d)) + (this.signum < 0 ? 1 : 0);
        StringBuilder sb2 = new StringBuilder(numChars);
        if (this.signum < 0) {
            sb2.append('-');
        }
        toString(abs, sb2, radix, 0);
        return sb2.toString();
    }

    private static void padWithZeros(StringBuilder buf, int numZeros) {
        while (numZeros >= NUM_ZEROS) {
            buf.append(ZEROS);
            numZeros -= NUM_ZEROS;
        }
        if (numZeros > 0) {
            buf.append((CharSequence) ZEROS, 0, numZeros);
        }
    }

    private void smallToString(int radix, StringBuilder buf, int digits) {
        if (this.signum == 0) {
            padWithZeros(buf, digits);
            return;
        }
        int maxNumDigitGroups = ((this.mag.length * 4) + 6) / 7;
        long[] digitGroups = new long[maxNumDigitGroups];
        BigInteger tmp = this;
        int numGroups = 0;
        while (tmp.signum != 0) {
            BigInteger d10 = longRadix[radix];
            MutableBigInteger q10 = new MutableBigInteger();
            MutableBigInteger a10 = new MutableBigInteger(tmp.mag);
            MutableBigInteger b4 = new MutableBigInteger(d10.mag);
            MutableBigInteger r10 = a10.divide(b4, q10);
            BigInteger q22 = q10.toBigInteger(tmp.signum * d10.signum);
            BigInteger r22 = r10.toBigInteger(tmp.signum * d10.signum);
            digitGroups[numGroups] = r22.longValue();
            tmp = q22;
            numGroups++;
        }
        String s2 = Long.toString(digitGroups[numGroups - 1], radix);
        padWithZeros(buf, digits - (s2.length() + ((numGroups - 1) * digitsPerLong[radix])));
        buf.append(s2);
        for (int i10 = numGroups - 2; i10 >= 0; i10--) {
            String s10 = Long.toString(digitGroups[i10], radix);
            int numLeadingZeros = digitsPerLong[radix] - s10.length();
            if (numLeadingZeros != 0) {
                buf.append((CharSequence) ZEROS, 0, numLeadingZeros);
            }
            buf.append(s10);
        }
    }

    private static void toString(BigInteger u10, StringBuilder sb2, int radix, int digits) {
        if (u10.mag.length <= 20) {
            u10.smallToString(radix, sb2, digits);
            return;
        }
        int b4 = u10.bitLength();
        double d10 = LOG_TWO;
        int n10 = (int) Math.round((Math.log((b4 * d10) / logCache[radix]) / d10) - 1.0d);
        BigInteger v2 = getRadixConversionCache(radix, n10);
        BigInteger[] results = u10.divideAndRemainder(v2);
        int expectedDigits = 1 << n10;
        toString(results[0], sb2, radix, digits - expectedDigits);
        toString(results[1], sb2, radix, expectedDigits);
    }

    private static BigInteger getRadixConversionCache(int radix, int exponent) {
        BigInteger[] cacheLine = powerCache[radix];
        if (exponent < cacheLine.length) {
            return cacheLine[exponent];
        }
        int oldLength = cacheLine.length;
        BigInteger[] cacheLine2 = (BigInteger[]) Arrays.copyOf(cacheLine, exponent + 1);
        for (int i10 = oldLength; i10 <= exponent; i10++) {
            cacheLine2[i10] = cacheLine2[i10 - 1].pow(2);
        }
        BigInteger[][] pc2 = powerCache;
        if (exponent >= pc2[radix].length) {
            BigInteger[][] pc3 = (BigInteger[][]) pc2.clone();
            pc3[radix] = cacheLine2;
            powerCache = pc3;
        }
        return cacheLine2[exponent];
    }

    public String toString() {
        return toString(10);
    }

    public byte[] toByteArray() {
        int byteLen = (bitLength() / 8) + 1;
        byte[] byteArray = new byte[byteLen];
        int bytesCopied = 4;
        int nextInt = 0;
        int intIndex = 0;
        for (int i10 = byteLen - 1; i10 >= 0; i10--) {
            if (bytesCopied == 4) {
                nextInt = getInt(intIndex);
                bytesCopied = 1;
                intIndex++;
            } else {
                nextInt >>>= 8;
                bytesCopied++;
            }
            byteArray[i10] = (byte) nextInt;
        }
        return byteArray;
    }

    @Override // java.lang.Number
    public int intValue() {
        int result = getInt(0);
        return result;
    }

    @Override // java.lang.Number
    public long longValue() {
        long result = 0;
        for (int i10 = 1; i10 >= 0; i10--) {
            result = (result << 32) + (getInt(i10) & 4294967295L);
        }
        return result;
    }

    @Override // java.lang.Number
    public float floatValue() {
        int twiceSignifFloor;
        if (this.signum == 0) {
            return 0.0f;
        }
        int[] iArr = this.mag;
        boolean increment = true;
        int exponent = (((iArr.length - 1) << 5) + bitLengthForInt(iArr[0])) - 1;
        if (exponent < 63) {
            return (float) longValue();
        }
        if (exponent > 127) {
            return this.signum > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        int shift = exponent - 24;
        int nBits = shift & 31;
        int nBits2 = 32 - nBits;
        if (nBits == 0) {
            twiceSignifFloor = this.mag[0];
        } else {
            int[] iArr2 = this.mag;
            int i10 = iArr2[0];
            int twiceSignifFloor2 = i10 >>> nBits;
            if (twiceSignifFloor2 != 0) {
                twiceSignifFloor = twiceSignifFloor2;
            } else {
                twiceSignifFloor = (iArr2[1] >>> nBits) | (i10 << nBits2);
            }
        }
        int signifFloor = (twiceSignifFloor >> 1) & FloatConsts.SIGNIF_BIT_MASK;
        if ((twiceSignifFloor & 1) == 0 || ((signifFloor & 1) == 0 && abs().getLowestSetBit() >= shift)) {
            increment = false;
        }
        int signifRounded = increment ? signifFloor + 1 : signifFloor;
        int bits = (exponent + 127) << 23;
        return Float.intBitsToFloat((bits + signifRounded) | (this.signum & Integer.MIN_VALUE));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        int lowBits;
        int lowBits2;
        if (this.signum == 0) {
            return 0.0d;
        }
        int[] iArr = this.mag;
        boolean increment = true;
        int exponent = (((iArr.length - 1) << 5) + bitLengthForInt(iArr[0])) - 1;
        if (exponent < 63) {
            return longValue();
        }
        if (exponent > 1023) {
            return this.signum > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        int shift = exponent - 53;
        int nBits = shift & 31;
        int nBits2 = 32 - nBits;
        if (nBits == 0) {
            int[] iArr2 = this.mag;
            lowBits = iArr2[0];
            lowBits2 = iArr2[1];
        } else {
            int[] iArr3 = this.mag;
            int i10 = iArr3[0];
            int highBits = i10 >>> nBits;
            int i11 = iArr3[1];
            lowBits = (i10 << nBits2) | (i11 >>> nBits);
            if (highBits != 0) {
                lowBits2 = lowBits;
                lowBits = highBits;
            } else {
                lowBits2 = (iArr3[2] >>> nBits) | (i11 << nBits2);
            }
        }
        long twiceSignifFloor = ((lowBits & 4294967295L) << 32) | (4294967295L & lowBits2);
        long signifFloor = (twiceSignifFloor >> 1) & DoubleConsts.SIGNIF_BIT_MASK;
        if ((twiceSignifFloor & 1) == 0 || ((signifFloor & 1) == 0 && abs().getLowestSetBit() >= shift)) {
            increment = false;
        }
        long signifRounded = increment ? 1 + signifFloor : signifFloor;
        long bits = (exponent + 1023) << 52;
        return Double.longBitsToDouble((bits + signifRounded) | (this.signum & Long.MIN_VALUE));
    }

    private static int[] stripLeadingZeroInts(int[] val) {
        int vlen = val.length;
        int keep = 0;
        while (keep < vlen && val[keep] == 0) {
            keep++;
        }
        return Arrays.copyOfRange(val, keep, vlen);
    }

    private static int[] trustedStripLeadingZeroInts(int[] val) {
        int vlen = val.length;
        int keep = 0;
        while (keep < vlen && val[keep] == 0) {
            keep++;
        }
        return keep == 0 ? val : Arrays.copyOfRange(val, keep, vlen);
    }

    private static int[] stripLeadingZeroBytes(byte[] a10, int off, int len) {
        int indexBound = off + len;
        int keep = off;
        while (keep < indexBound && a10[keep] == 0) {
            keep++;
        }
        int intLength = ((indexBound - keep) + 3) >>> 2;
        int[] result = new int[intLength];
        int b4 = indexBound - 1;
        int i10 = intLength - 1;
        while (i10 >= 0) {
            int b10 = b4 - 1;
            result[i10] = a10[b4] & 255;
            int bytesRemaining = (b10 - keep) + 1;
            int bytesToTransfer = Math.min(3, bytesRemaining);
            int j10 = 8;
            while (j10 <= (bytesToTransfer << 3)) {
                result[i10] = ((a10[b10] & 255) << j10) | result[i10];
                j10 += 8;
                b10--;
            }
            i10--;
            b4 = b10;
        }
        return result;
    }

    private static int[] makePositive(byte[] a10, int off, int len) {
        int indexBound = off + len;
        int keep = off;
        while (keep < indexBound && a10[keep] == -1) {
            keep++;
        }
        int k10 = keep;
        while (k10 < indexBound && a10[k10] == 0) {
            k10++;
        }
        int extraByte = k10 == indexBound ? 1 : 0;
        int intLength = (((indexBound - keep) + extraByte) + 3) >>> 2;
        int[] result = new int[intLength];
        int b4 = indexBound - 1;
        int i10 = intLength - 1;
        while (i10 >= 0) {
            int b10 = b4 - 1;
            result[i10] = a10[b4] & 255;
            int numBytesToTransfer = Math.min(3, (b10 - keep) + 1);
            if (numBytesToTransfer < 0) {
                numBytesToTransfer = 0;
            }
            int j10 = 8;
            while (j10 <= numBytesToTransfer * 8) {
                result[i10] = ((a10[b10] & 255) << j10) | result[i10];
                j10 += 8;
                b10--;
            }
            int j11 = 3 - numBytesToTransfer;
            int mask = (-1) >>> (j11 * 8);
            result[i10] = (~result[i10]) & mask;
            i10--;
            b4 = b10;
        }
        for (int i11 = result.length - 1; i11 >= 0; i11--) {
            result[i11] = (int) ((result[i11] & 4294967295L) + 1);
            if (result[i11] != 0) {
                break;
            }
        }
        return result;
    }

    private static int[] makePositive(int[] a10) {
        int keep = 0;
        while (keep < a10.length && a10[keep] == -1) {
            keep++;
        }
        int j10 = keep;
        while (j10 < a10.length && a10[j10] == 0) {
            j10++;
        }
        int extraInt = j10 == a10.length ? 1 : 0;
        int[] result = new int[(a10.length - keep) + extraInt];
        for (int i10 = keep; i10 < a10.length; i10++) {
            result[(i10 - keep) + extraInt] = ~a10[i10];
        }
        int i11 = result.length;
        int i12 = i11 - 1;
        while (true) {
            int i13 = result[i12] + 1;
            result[i12] = i13;
            if (i13 != 0) {
                return result;
            }
            i12--;
        }
    }

    private int intLength() {
        return (bitLength() >>> 5) + 1;
    }

    private int signBit() {
        return this.signum < 0 ? 1 : 0;
    }

    private int signInt() {
        return this.signum < 0 ? -1 : 0;
    }

    private int getInt(int n10) {
        if (n10 < 0) {
            return 0;
        }
        int[] iArr = this.mag;
        if (n10 >= iArr.length) {
            return signInt();
        }
        int magInt = iArr[(iArr.length - n10) - 1];
        return this.signum >= 0 ? magInt : n10 <= firstNonzeroIntNum() ? -magInt : ~magInt;
    }

    private int firstNonzeroIntNum() {
        int fn = this.firstNonzeroIntNumPlusTwo - 2;
        if (fn == -2) {
            int mlen = this.mag.length;
            int i10 = mlen - 1;
            while (i10 >= 0 && this.mag[i10] == 0) {
                i10--;
            }
            int fn2 = (mlen - i10) - 1;
            this.firstNonzeroIntNumPlusTwo = fn2 + 2;
            return fn2;
        }
        return fn;
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        int sign = fields.get("signum", -2);
        if (sign >= -1) {
            if (sign <= 1) {
                byte[] magnitude = (byte[]) ((byte[]) fields.get("magnitude", (Object) null)).clone();
                int[] mag = stripLeadingZeroBytes(magnitude, 0, magnitude.length);
                if ((mag.length == 0) != (sign == 0)) {
                    String message = "BigInteger: signum-magnitude mismatch";
                    if (fields.defaulted("magnitude")) {
                        message = "BigInteger: Magnitude not present in stream";
                    }
                    throw new StreamCorruptedException(message);
                }
                if (mag.length > 67108864 || (mag.length == 67108864 && mag[0] < 0)) {
                    throw new StreamCorruptedException("BigInteger: Out of the supported range");
                }
                UnsafeHolder.putSignAndMag(this, sign, mag);
                return;
            }
        }
        String message2 = "BigInteger: Invalid signum value";
        if (fields.defaulted("signum")) {
            message2 = "BigInteger: Signum not present in stream";
        }
        throw new StreamCorruptedException(message2);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialized BigInteger objects need data");
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class UnsafeHolder {
        private static final long magOffset;
        private static final long signumOffset;
        private static final Unsafe unsafe;

        private UnsafeHolder() {
        }

        static {
            try {
                Unsafe unsafe2 = Unsafe.getUnsafe();
                unsafe = unsafe2;
                signumOffset = unsafe2.objectFieldOffset(BigInteger.class.getDeclaredField("signum"));
                magOffset = unsafe2.objectFieldOffset(BigInteger.class.getDeclaredField("mag"));
            } catch (Exception ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        static void putSignAndMag(BigInteger bi, int sign, int[] magnitude) {
            Unsafe unsafe2 = unsafe;
            unsafe2.putIntVolatile(bi, signumOffset, sign);
            unsafe2.putObjectVolatile(bi, magOffset, magnitude);
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        ObjectOutputStream.PutField fields = s2.putFields();
        fields.put("signum", this.signum);
        fields.put("magnitude", magSerializedForm());
        s2.writeFields();
    }

    private byte[] magSerializedForm() {
        int[] iArr = this.mag;
        int len = iArr.length;
        int bitLen = len != 0 ? ((len - 1) << 5) + bitLengthForInt(iArr[0]) : 0;
        int byteLen = (bitLen + 7) >>> 3;
        byte[] result = new byte[byteLen];
        int bytesCopied = 4;
        int nextInt = len - 1;
        int nextInt2 = 0;
        for (int i10 = byteLen - 1; i10 >= 0; i10--) {
            if (bytesCopied == 4) {
                int intIndex = nextInt - 1;
                bytesCopied = 1;
                nextInt2 = this.mag[nextInt];
                nextInt = intIndex;
            } else {
                nextInt2 >>>= 8;
                bytesCopied++;
            }
            result[i10] = (byte) nextInt2;
        }
        return result;
    }

    public long longValueExact() {
        if (this.mag.length <= 2 && bitLength() <= 63) {
            return longValue();
        }
        throw new ArithmeticException("BigInteger out of long range");
    }

    public int intValueExact() {
        if (this.mag.length <= 1 && bitLength() <= 31) {
            return intValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public short shortValueExact() {
        int value;
        if (this.mag.length <= 1 && bitLength() <= 31 && (value = intValue()) >= -32768 && value <= 32767) {
            return shortValue();
        }
        throw new ArithmeticException("BigInteger out of short range");
    }

    public byte byteValueExact() {
        int value;
        if (this.mag.length <= 1 && bitLength() <= 31 && (value = intValue()) >= -128 && value <= 127) {
            return byteValue();
        }
        throw new ArithmeticException("BigInteger out of byte range");
    }
}
