package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.zip.ZipUtils;
import jdk.internal.math.DoubleConsts;
import okhttp3.internal.connection.RealConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RyuDouble {
    private static final int[][] POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) int.class, 326, 4);
    private static final int[][] POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) int.class, 291, 4);

    static {
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger subtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger subtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i10 = 0;
        while (i10 < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i10);
            int bitLength = pow.bitLength();
            int i11 = i10 == 0 ? 1 : (int) ((((i10 * 23219280) + 10000000) - 1) / 10000000);
            if (i11 == bitLength) {
                if (i10 < POW5_SPLIT.length) {
                    for (int i12 = 0; i12 < 4; i12++) {
                        POW5_SPLIT[i10][i12] = pow.shiftRight((bitLength - 121) + ((3 - i12) * 31)).and(subtract).intValue();
                    }
                }
                if (i10 < POW5_INV_SPLIT.length) {
                    BigInteger bigInteger2 = BigInteger.ONE;
                    BigInteger add = bigInteger2.shiftLeft(bitLength + 121).divide(pow).add(bigInteger2);
                    for (int i13 = 0; i13 < 4; i13++) {
                        if (i13 == 0) {
                            POW5_INV_SPLIT[i10][i13] = add.shiftRight((3 - i13) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i10][i13] = add.shiftRight((3 - i13) * 31).and(subtract2).intValue();
                        }
                    }
                }
                i10++;
            } else {
                throw new IllegalStateException(bitLength + " != " + i11);
            }
        }
    }

    public static String toString(double d10) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d10, cArr, 0));
    }

    public static int toString(double d10, char[] cArr, int i10) {
        int i11;
        boolean z10;
        boolean z11;
        long j10;
        long j11;
        int i12;
        long j12;
        boolean z12;
        boolean z13;
        long j13;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z14;
        int i18;
        int i19;
        int i20;
        int i21;
        if (!Double.isNaN(d10)) {
            if (d10 == Double.POSITIVE_INFINITY) {
                int i22 = i10 + 1;
                cArr[i10] = 'I';
                int i23 = i22 + 1;
                cArr[i22] = 'n';
                int i24 = i23 + 1;
                cArr[i23] = 'f';
                int i25 = i24 + 1;
                cArr[i24] = 'i';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'i';
                int i28 = i27 + 1;
                cArr[i27] = 't';
                i17 = i28 + 1;
                cArr[i28] = 'y';
            } else if (d10 == Double.NEGATIVE_INFINITY) {
                int i29 = i10 + 1;
                cArr[i10] = '-';
                int i30 = i29 + 1;
                cArr[i29] = 'I';
                int i31 = i30 + 1;
                cArr[i30] = 'n';
                int i32 = i31 + 1;
                cArr[i31] = 'f';
                int i33 = i32 + 1;
                cArr[i32] = 'i';
                int i34 = i33 + 1;
                cArr[i33] = 'n';
                int i35 = i34 + 1;
                cArr[i34] = 'i';
                int i36 = i35 + 1;
                cArr[i35] = 't';
                i21 = i36 + 1;
                cArr[i36] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d10);
                if (doubleToLongBits == 0) {
                    int i37 = i10 + 1;
                    cArr[i10] = '0';
                    int i38 = i37 + 1;
                    cArr[i37] = '.';
                    i21 = i38 + 1;
                    cArr[i38] = '0';
                } else if (doubleToLongBits == Long.MIN_VALUE) {
                    int i39 = i10 + 1;
                    cArr[i10] = '-';
                    int i40 = i39 + 1;
                    cArr[i39] = '0';
                    int i41 = i40 + 1;
                    cArr[i40] = '.';
                    i17 = i41 + 1;
                    cArr[i41] = '0';
                } else {
                    int i42 = (int) ((doubleToLongBits >>> 52) & 2047);
                    long j14 = doubleToLongBits & DoubleConsts.SIGNIF_BIT_MASK;
                    if (i42 == 0) {
                        i11 = DoubleConsts.MIN_SUB_EXPONENT;
                    } else {
                        i11 = (i42 - 1023) - 52;
                        j14 |= 4503599627370496L;
                    }
                    boolean z15 = doubleToLongBits < 0;
                    boolean z16 = (j14 & 1) == 0;
                    long j15 = 4 * j14;
                    long j16 = j15 + 2;
                    int i43 = (j14 != 4503599627370496L || i42 <= 1) ? 1 : 0;
                    long j17 = (j15 - 1) - i43;
                    int i44 = i11 - 2;
                    int i45 = 3;
                    if (i44 >= 0) {
                        int max = Math.max(0, ((int) ((i44 * 3010299) / 10000000)) - 1);
                        int i46 = ((((-i44) + max) + (((max == 0 ? 1 : (int) ((((max * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                        if (i46 >= 0) {
                            int[] iArr = POW5_INV_SPLIT[max];
                            long j18 = j15 >>> 31;
                            long j19 = j15 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            z10 = z15;
                            long j20 = iArr[0] * j19;
                            long j21 = iArr[1] * j18;
                            long j22 = iArr[1] * j19;
                            boolean z17 = z16;
                            long j23 = ((((((((((((j19 * iArr[3]) >>> 31) + (iArr[2] * j19)) + (j18 * iArr[3])) >>> 31) + j22) + (iArr[2] * j18)) >>> 31) + j20) + j21) >>> 21) + ((iArr[0] * j18) << 10)) >>> i46;
                            long j24 = j16 >>> 31;
                            long j25 = j16 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            long j26 = iArr[0] * j25;
                            long j27 = iArr[1] * j24;
                            long j28 = iArr[1] * j25;
                            z11 = z17;
                            long j29 = ((((((((((((j25 * iArr[3]) >>> 31) + (iArr[2] * j25)) + (j24 * iArr[3])) >>> 31) + j28) + (iArr[2] * j24)) >>> 31) + j26) + j27) >>> 21) + ((iArr[0] * j24) << 10)) >>> i46;
                            long j30 = j17 >>> 31;
                            long j31 = j17 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            long j32 = iArr[0] * j31;
                            long j33 = iArr[1] * j30;
                            long j34 = iArr[1] * j31;
                            j12 = j29;
                            j11 = ((((((((((((j31 * iArr[3]) >>> 31) + (iArr[2] * j31)) + (j30 * iArr[3])) >>> 31) + j34) + (iArr[2] * j30)) >>> 31) + j32) + j33) >>> 21) + ((iArr[0] * j30) << 10)) >>> i46;
                            if (max <= 21) {
                                long j35 = j15 % 5;
                                if (j35 == 0) {
                                    if (j35 != 0) {
                                        i20 = 0;
                                    } else if (j15 % 25 != 0) {
                                        i20 = 1;
                                    } else if (j15 % 125 != 0) {
                                        i20 = 2;
                                    } else if (j15 % 625 != 0) {
                                        i20 = 3;
                                    } else {
                                        long j36 = j15 / 625;
                                        i20 = 4;
                                        for (long j37 = 0; j36 > j37 && j36 % 5 == j37; j37 = 0) {
                                            j36 /= 5;
                                            i20++;
                                        }
                                    }
                                    z13 = i20 >= max;
                                    z14 = false;
                                    j10 = j23;
                                    z12 = z14;
                                    i12 = max;
                                } else if (z11) {
                                    if (j17 % 5 != 0) {
                                        i19 = 0;
                                    } else if (j17 % 25 != 0) {
                                        i19 = 1;
                                    } else if (j17 % 125 != 0) {
                                        i19 = 2;
                                    } else if (j17 % 625 != 0) {
                                        i19 = 3;
                                    } else {
                                        long j38 = j17 / 625;
                                        i19 = 4;
                                        for (long j39 = 0; j38 > j39 && j38 % 5 == j39; j39 = 0) {
                                            j38 /= 5;
                                            i19++;
                                        }
                                    }
                                    if (i19 >= max) {
                                        z14 = true;
                                        z13 = false;
                                        j10 = j23;
                                        z12 = z14;
                                        i12 = max;
                                    }
                                } else {
                                    if (j16 % 5 != 0) {
                                        i18 = 0;
                                    } else if (j16 % 25 != 0) {
                                        i18 = 1;
                                    } else if (j16 % 125 != 0) {
                                        i18 = 2;
                                    } else if (j16 % 625 != 0) {
                                        i18 = 3;
                                    } else {
                                        long j40 = j16 / 625;
                                        i18 = 4;
                                        for (long j41 = 0; j40 > j41 && j40 % 5 == j41; j41 = 0) {
                                            j40 /= 5;
                                            i18++;
                                        }
                                    }
                                    if (i18 >= max) {
                                        j12--;
                                    }
                                }
                            }
                            z14 = false;
                            z13 = false;
                            j10 = j23;
                            z12 = z14;
                            i12 = max;
                        } else {
                            throw new IllegalArgumentException("" + i46);
                        }
                    } else {
                        z10 = z15;
                        z11 = z16;
                        int i47 = -i44;
                        int max2 = Math.max(0, ((int) ((i47 * 6989700) / 10000000)) - 1);
                        int i48 = i47 - max2;
                        int i49 = ((max2 - ((i48 == 0 ? 1 : (int) ((((i48 * 23219280) + 10000000) - 1) / 10000000)) - 121)) - 93) - 21;
                        if (i49 >= 0) {
                            int[] iArr2 = POW5_SPLIT[i48];
                            long j42 = j15 >>> 31;
                            long j43 = j15 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            long j44 = iArr2[0] * j43;
                            long j45 = iArr2[1] * j42;
                            int i50 = i43;
                            long j46 = iArr2[1] * j43;
                            long j47 = ((((((((((((j43 * iArr2[3]) >>> 31) + (iArr2[2] * j43)) + (j42 * iArr2[3])) >>> 31) + j46) + (iArr2[2] * j42)) >>> 31) + j44) + j45) >>> 21) + ((iArr2[0] * j42) << 10)) >>> i49;
                            long j48 = j16 >>> 31;
                            long j49 = j16 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            long j50 = iArr2[0] * j49;
                            long j51 = iArr2[1] * j48;
                            j10 = j47;
                            long j52 = iArr2[1] * j49;
                            long j53 = ((((((((((((j49 * iArr2[3]) >>> 31) + (iArr2[2] * j49)) + (j48 * iArr2[3])) >>> 31) + j52) + (iArr2[2] * j48)) >>> 31) + j50) + j51) >>> 21) + ((iArr2[0] * j48) << 10)) >>> i49;
                            long j54 = j17 >>> 31;
                            long j55 = j17 & ZipUtils.UPPER_UNIXTIME_BOUND;
                            long j56 = iArr2[0] * j55;
                            long j57 = iArr2[1] * j54;
                            long j58 = iArr2[1] * j55;
                            j11 = ((((((((((((j55 * iArr2[3]) >>> 31) + (iArr2[2] * j55)) + (j54 * iArr2[3])) >>> 31) + j58) + (iArr2[2] * j54)) >>> 31) + j56) + j57) >>> 21) + ((iArr2[0] * j54) << 10)) >>> i49;
                            i12 = max2 + i44;
                            if (max2 <= 1) {
                                if (z11) {
                                    j12 = j53;
                                    z12 = i50 == 1;
                                } else {
                                    j12 = j53 - 1;
                                    z12 = false;
                                }
                                z13 = true;
                            } else if (max2 < 63) {
                                z13 = (j15 & ((1 << (max2 - 1)) - 1)) == 0;
                                j12 = j53;
                                z12 = false;
                            } else {
                                j12 = j53;
                                z12 = false;
                                z13 = false;
                            }
                        } else {
                            throw new IllegalArgumentException("" + i49);
                        }
                    }
                    if (j12 >= 1000000000000000000L) {
                        i45 = 19;
                    } else if (j12 >= 100000000000000000L) {
                        i45 = 18;
                    } else if (j12 >= 10000000000000000L) {
                        i45 = 17;
                    } else if (j12 >= 1000000000000000L) {
                        i45 = 16;
                    } else if (j12 >= 100000000000000L) {
                        i45 = 15;
                    } else if (j12 >= 10000000000000L) {
                        i45 = 14;
                    } else if (j12 >= 1000000000000L) {
                        i45 = 13;
                    } else if (j12 >= 100000000000L) {
                        i45 = 12;
                    } else if (j12 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                        i45 = 11;
                    } else if (j12 >= 1000000000) {
                        i45 = 10;
                    } else if (j12 >= 100000000) {
                        i45 = 9;
                    } else if (j12 >= 10000000) {
                        i45 = 8;
                    } else if (j12 >= 1000000) {
                        i45 = 7;
                    } else if (j12 >= 100000) {
                        i45 = 6;
                    } else if (j12 >= 10000) {
                        i45 = 5;
                    } else if (j12 >= 1000) {
                        i45 = 4;
                    } else if (j12 < 100) {
                        i45 = j12 >= 10 ? 2 : 1;
                    }
                    int i51 = (i12 + i45) - 1;
                    boolean z18 = i51 < -3 || i51 >= 7;
                    if (z12 || z13) {
                        boolean z19 = z13;
                        int i52 = 0;
                        int i53 = 0;
                        while (true) {
                            long j59 = j12 / 10;
                            long j60 = j11 / 10;
                            if (j59 <= j60 || (j12 < 100 && z18)) {
                                break;
                            }
                            z12 &= j11 % 10 == 0;
                            z19 &= i52 == 0;
                            i52 = (int) (j10 % 10);
                            j10 /= 10;
                            i53++;
                            j12 = j59;
                            j11 = j60;
                        }
                        if (z12 && z11) {
                            while (j11 % 10 == 0 && (j12 >= 100 || !z18)) {
                                z19 &= i52 == 0;
                                i52 = (int) (j10 % 10);
                                j12 /= 10;
                                j10 /= 10;
                                j11 /= 10;
                                i53++;
                            }
                        }
                        if (z19 && i52 == 5 && j10 % 2 == 0) {
                            i52 = 4;
                        }
                        j13 = j10 + (((j10 != j11 || (z12 && z11)) && i52 < 5) ? 0 : 1);
                        i13 = i53;
                    } else {
                        i13 = 0;
                        int i54 = 0;
                        while (true) {
                            long j61 = j12 / 10;
                            long j62 = j11 / 10;
                            if (j61 <= j62 || (j12 < 100 && z18)) {
                                break;
                            }
                            i54 = (int) (j10 % 10);
                            j10 /= 10;
                            i13++;
                            j12 = j61;
                            j11 = j62;
                        }
                        j13 = j10 + ((j10 == j11 || i54 >= 5) ? 1 : 0);
                    }
                    int i55 = i45 - i13;
                    if (z10) {
                        i14 = i10 + 1;
                        cArr[i10] = '-';
                    } else {
                        i14 = i10;
                    }
                    if (!z18) {
                        char c4 = '0';
                        if (i51 < 0) {
                            int i56 = i14 + 1;
                            cArr[i14] = '0';
                            int i57 = i56 + 1;
                            cArr[i56] = '.';
                            int i58 = -1;
                            while (i58 > i51) {
                                cArr[i57] = c4;
                                i58--;
                                i57++;
                                c4 = '0';
                            }
                            i15 = i57;
                            for (int i59 = 0; i59 < i55; i59++) {
                                cArr[((i57 + i55) - i59) - 1] = (char) ((j13 % 10) + 48);
                                j13 /= 10;
                                i15++;
                            }
                        } else {
                            int i60 = i51 + 1;
                            if (i60 >= i55) {
                                for (int i61 = 0; i61 < i55; i61++) {
                                    cArr[((i14 + i55) - i61) - 1] = (char) ((j13 % 10) + 48);
                                    j13 /= 10;
                                }
                                int i62 = i14 + i55;
                                while (i55 < i60) {
                                    cArr[i62] = '0';
                                    i55++;
                                    i62++;
                                }
                                int i63 = i62 + 1;
                                cArr[i62] = '.';
                                i15 = i63 + 1;
                                cArr[i63] = '0';
                            } else {
                                int i64 = i14 + 1;
                                for (int i65 = 0; i65 < i55; i65++) {
                                    if ((i55 - i65) - 1 == i51) {
                                        cArr[((i64 + i55) - i65) - 1] = '.';
                                        i64--;
                                    }
                                    cArr[((i64 + i55) - i65) - 1] = (char) ((j13 % 10) + 48);
                                    j13 /= 10;
                                }
                                i15 = i14 + i55 + 1;
                            }
                        }
                        return i15 - i10;
                    }
                    for (int i66 = 0; i66 < i55 - 1; i66++) {
                        int i67 = (int) (j13 % 10);
                        j13 /= 10;
                        cArr[(i14 + i55) - i66] = (char) (i67 + 48);
                    }
                    cArr[i14] = (char) ((j13 % 10) + 48);
                    cArr[i14 + 1] = '.';
                    int i68 = i14 + i55 + 1;
                    if (i55 == 1) {
                        cArr[i68] = '0';
                        i68++;
                    }
                    int i69 = i68 + 1;
                    cArr[i68] = 'E';
                    if (i51 < 0) {
                        cArr[i69] = '-';
                        i51 = -i51;
                        i69++;
                    }
                    if (i51 >= 100) {
                        int i70 = i69 + 1;
                        i16 = 48;
                        cArr[i69] = (char) ((i51 / 100) + 48);
                        i51 %= 100;
                        i69 = i70 + 1;
                        cArr[i70] = (char) ((i51 / 10) + 48);
                    } else {
                        i16 = 48;
                        if (i51 >= 10) {
                            cArr[i69] = (char) ((i51 / 10) + 48);
                            i69++;
                        }
                    }
                    i17 = i69 + 1;
                    cArr[i69] = (char) ((i51 % 10) + i16);
                }
            }
            return i17 - i10;
        }
        int i71 = i10 + 1;
        cArr[i10] = 'N';
        int i72 = i71 + 1;
        cArr[i71] = 'a';
        i21 = i72 + 1;
        cArr[i72] = 'N';
        return i21 - i10;
    }
}
