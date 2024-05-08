package com.alibaba.fastjson.util;

import jdk.internal.math.FloatConsts;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f10) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f10, cArr, 0));
    }

    public static int toString(float f10, char[] cArr, int i10) {
        int i11;
        boolean z10;
        int i12;
        int i13;
        boolean z11;
        int i14;
        boolean z12;
        int i15;
        int i16;
        boolean z13;
        int i17;
        int i18;
        int i19;
        int i20;
        if (Float.isNaN(f10)) {
            int i21 = i10 + 1;
            cArr[i10] = 'N';
            int i22 = i21 + 1;
            cArr[i21] = 'a';
            i20 = i22 + 1;
            cArr[i22] = 'N';
        } else {
            if (f10 == Float.POSITIVE_INFINITY) {
                int i23 = i10 + 1;
                cArr[i10] = 'I';
                int i24 = i23 + 1;
                cArr[i23] = 'n';
                int i25 = i24 + 1;
                cArr[i24] = 'f';
                int i26 = i25 + 1;
                cArr[i25] = 'i';
                int i27 = i26 + 1;
                cArr[i26] = 'n';
                int i28 = i27 + 1;
                cArr[i27] = 'i';
                int i29 = i28 + 1;
                cArr[i28] = 't';
                cArr[i29] = 'y';
                return (i29 + 1) - i10;
            }
            if (f10 == Float.NEGATIVE_INFINITY) {
                int i30 = i10 + 1;
                cArr[i10] = '-';
                int i31 = i30 + 1;
                cArr[i30] = 'I';
                int i32 = i31 + 1;
                cArr[i31] = 'n';
                int i33 = i32 + 1;
                cArr[i32] = 'f';
                int i34 = i33 + 1;
                cArr[i33] = 'i';
                int i35 = i34 + 1;
                cArr[i34] = 'n';
                int i36 = i35 + 1;
                cArr[i35] = 'i';
                int i37 = i36 + 1;
                cArr[i36] = 't';
                i20 = i37 + 1;
                cArr[i37] = 'y';
            } else {
                int floatToIntBits = Float.floatToIntBits(f10);
                if (floatToIntBits != 0) {
                    if (floatToIntBits == Integer.MIN_VALUE) {
                        int i38 = i10 + 1;
                        cArr[i10] = '-';
                        int i39 = i38 + 1;
                        cArr[i38] = '0';
                        int i40 = i39 + 1;
                        cArr[i39] = '.';
                        cArr[i40] = '0';
                        return (i40 + 1) - i10;
                    }
                    int i41 = (floatToIntBits >> 23) & 255;
                    int i42 = 8388607 & floatToIntBits;
                    if (i41 == 0) {
                        i11 = FloatConsts.MIN_SUB_EXPONENT;
                    } else {
                        i11 = (i41 - 127) - 23;
                        i42 |= 8388608;
                    }
                    boolean z14 = floatToIntBits < 0;
                    boolean z15 = (i42 & 1) == 0;
                    int i43 = i42 * 4;
                    int i44 = i43 + 2;
                    int i45 = i43 - ((((long) i42) != 8388608 || i41 <= 1) ? 2 : 1);
                    int i46 = i11 - 2;
                    if (i46 >= 0) {
                        i16 = (int) ((i46 * 3010299) / 10000000);
                        int i47 = i16 == 0 ? 1 : (int) ((((i16 * 23219280) + 10000000) - 1) / 10000000);
                        int[][] iArr = POW5_INV_SPLIT;
                        long j10 = iArr[i16][0];
                        z10 = z15;
                        long j11 = iArr[i16][1];
                        long j12 = i43;
                        int i48 = (((i47 + 59) - 1) + ((-i46) + i16)) - 31;
                        i14 = (int) (((j12 * j10) + ((j12 * j11) >> 31)) >> i48);
                        long j13 = i44;
                        i12 = (int) (((j13 * j10) + ((j13 * j11) >> 31)) >> i48);
                        long j14 = i45;
                        i15 = (int) (((j10 * j14) + ((j14 * j11) >> 31)) >> i48);
                        if (i16 == 0 || (i12 - 1) / 10 > i15 / 10) {
                            i13 = 0;
                        } else {
                            i13 = (int) ((((iArr[r7][0] * j12) + ((iArr[r7][1] * j12) >> 31)) >> (((r1 - 1) + (((i16 - 1 == 0 ? 1 : (int) ((((r7 * 23219280) + 10000000) - 1) / 10000000)) + 59) - 1)) - 31)) % 10);
                        }
                        int i49 = i44;
                        int i50 = 0;
                        while (i49 > 0 && i49 % 5 == 0) {
                            i49 /= 5;
                            i50++;
                        }
                        int i51 = 0;
                        while (i43 > 0 && i43 % 5 == 0) {
                            i43 /= 5;
                            i51++;
                        }
                        int i52 = 0;
                        while (i45 > 0 && i45 % 5 == 0) {
                            i45 /= 5;
                            i52++;
                        }
                        z11 = i50 >= i16;
                        z13 = i51 >= i16;
                        z12 = i52 >= i16;
                    } else {
                        z10 = z15;
                        int i53 = -i46;
                        int i54 = (int) ((i53 * 6989700) / 10000000);
                        int i55 = i53 - i54;
                        int[][] iArr2 = POW5_SPLIT;
                        long j15 = iArr2[i55][0];
                        long j16 = iArr2[i55][1];
                        int i56 = (i54 - ((i55 == 0 ? 1 : (int) ((((i55 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31;
                        long j17 = i43;
                        int i57 = (int) (((j17 * j15) + ((j17 * j16) >> 31)) >> i56);
                        long j18 = i44;
                        i12 = (int) (((j18 * j15) + ((j18 * j16) >> 31)) >> i56);
                        long j19 = i45;
                        int i58 = (int) (((j15 * j19) + ((j19 * j16) >> 31)) >> i56);
                        if (i54 == 0 || (i12 - 1) / 10 > i58 / 10) {
                            i13 = 0;
                        } else {
                            i13 = (int) ((((iArr2[r1][0] * j17) + ((iArr2[r1][1] * j17) >> 31)) >> (((i54 - 1) - ((i55 + 1 == 0 ? 1 : (int) ((((r1 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31)) % 10);
                        }
                        int i59 = i54 + i46;
                        boolean z16 = 1 >= i54;
                        boolean z17 = i54 < 23 && (((1 << (i54 + (-1))) - 1) & i43) == 0;
                        boolean z18 = (i45 % 2 == 1 ? 0 : 1) >= i54;
                        z11 = z16;
                        i14 = i57;
                        z12 = z18;
                        i15 = i58;
                        i16 = i59;
                        z13 = z17;
                    }
                    int i60 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    int i61 = 10;
                    while (i61 > 0 && i12 < i60) {
                        i60 /= 10;
                        i61--;
                    }
                    int i62 = (i16 + i61) - 1;
                    boolean z19 = i62 < -3 || i62 >= 7;
                    if (z11 && !z10) {
                        i12--;
                    }
                    int i63 = 0;
                    while (true) {
                        int i64 = i12 / 10;
                        int i65 = i15 / 10;
                        if (i64 <= i65 || (i12 < 100 && z19)) {
                            break;
                        }
                        z12 &= i15 % 10 == 0;
                        i13 = i14 % 10;
                        i14 /= 10;
                        i63++;
                        i12 = i64;
                        i15 = i65;
                    }
                    if (z12 && z10) {
                        while (i15 % 10 == 0 && (i12 >= 100 || !z19)) {
                            i12 /= 10;
                            i13 = i14 % 10;
                            i14 /= 10;
                            i15 /= 10;
                            i63++;
                        }
                    }
                    if (z13 && i13 == 5 && i14 % 2 == 0) {
                        i13 = 4;
                    }
                    int i66 = i14 + (((i14 != i15 || (z12 && z10)) && i13 < 5) ? 0 : 1);
                    int i67 = i61 - i63;
                    if (z14) {
                        i17 = i10 + 1;
                        cArr[i10] = '-';
                    } else {
                        i17 = i10;
                    }
                    if (z19) {
                        for (int i68 = 0; i68 < i67 - 1; i68++) {
                            int i69 = i66 % 10;
                            i66 /= 10;
                            cArr[(i17 + i67) - i68] = (char) (i69 + 48);
                        }
                        cArr[i17] = (char) ((i66 % 10) + 48);
                        cArr[i17 + 1] = '.';
                        int i70 = i17 + i67 + 1;
                        if (i67 == 1) {
                            cArr[i70] = '0';
                            i70++;
                        }
                        int i71 = i70 + 1;
                        cArr[i70] = 'E';
                        if (i62 < 0) {
                            cArr[i71] = '-';
                            i62 = -i62;
                            i71++;
                        }
                        if (i62 >= 10) {
                            i19 = 48;
                            cArr[i71] = (char) ((i62 / 10) + 48);
                            i71++;
                        } else {
                            i19 = 48;
                        }
                        i18 = i71 + 1;
                        cArr[i71] = (char) ((i62 % 10) + i19);
                    } else {
                        int i72 = 48;
                        if (i62 < 0) {
                            int i73 = i17 + 1;
                            cArr[i17] = '0';
                            int i74 = i73 + 1;
                            cArr[i73] = '.';
                            int i75 = -1;
                            while (i75 > i62) {
                                cArr[i74] = '0';
                                i75--;
                                i74++;
                            }
                            int i76 = i74;
                            int i77 = 0;
                            while (i77 < i67) {
                                cArr[((i74 + i67) - i77) - 1] = (char) ((i66 % 10) + i72);
                                i66 /= 10;
                                i76++;
                                i77++;
                                i72 = 48;
                            }
                            i18 = i76;
                        } else {
                            int i78 = i62 + 1;
                            if (i78 >= i67) {
                                for (int i79 = 0; i79 < i67; i79++) {
                                    cArr[((i17 + i67) - i79) - 1] = (char) ((i66 % 10) + 48);
                                    i66 /= 10;
                                }
                                int i80 = i17 + i67;
                                while (i67 < i78) {
                                    cArr[i80] = '0';
                                    i67++;
                                    i80++;
                                }
                                int i81 = i80 + 1;
                                cArr[i80] = '.';
                                i18 = i81 + 1;
                                cArr[i81] = '0';
                            } else {
                                int i82 = i17 + 1;
                                for (int i83 = 0; i83 < i67; i83++) {
                                    if ((i67 - i83) - 1 == i62) {
                                        cArr[((i82 + i67) - i83) - 1] = '.';
                                        i82--;
                                    }
                                    cArr[((i82 + i67) - i83) - 1] = (char) ((i66 % 10) + 48);
                                    i66 /= 10;
                                }
                                i18 = i17 + i67 + 1;
                            }
                        }
                    }
                    return i18 - i10;
                }
                int i84 = i10 + 1;
                cArr[i10] = '0';
                int i85 = i84 + 1;
                cArr[i84] = '.';
                i20 = i85 + 1;
                cArr[i85] = '0';
            }
        }
        return i20 - i10;
    }
}
