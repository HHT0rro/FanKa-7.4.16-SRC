package org.apache.commons.lang3;

import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Conversion {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean[] TTTT = {true, true, true, true};
    private static final boolean[] FTTT = {false, true, true, true};
    private static final boolean[] TFTT = {true, false, true, true};
    private static final boolean[] FFTT = {false, false, true, true};
    private static final boolean[] TTFT = {true, true, false, true};
    private static final boolean[] FTFT = {false, true, false, true};
    private static final boolean[] TFFT = {true, false, false, true};
    private static final boolean[] FFFT = {false, false, false, true};
    private static final boolean[] TTTF = {true, true, true, false};
    private static final boolean[] FTTF = {false, true, true, false};
    private static final boolean[] TFTF = {true, false, true, false};
    private static final boolean[] FFTF = {false, false, true, false};
    private static final boolean[] TTFF = {true, true, false, false};
    private static final boolean[] FTFF = {false, true, false, false};
    private static final boolean[] TFFF = {true, false, false, false};
    private static final boolean[] FFFF = {false, false, false, false};

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i10, byte b4, int i11, int i12) {
        if ((zArr.length == 0 && i10 == 0) || i12 == 0) {
            return b4;
        }
        if ((i12 - 1) + i11 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 + i11;
            b4 = (byte) ((b4 & (~(1 << i14))) | ((zArr[i13 + i10] ? 1 : 0) << i14));
        }
        return b4;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i10, int i11, int i12, int i13) {
        if ((zArr.length == 0 && i10 == 0) || i13 == 0) {
            return i11;
        }
        if ((i13 - 1) + i12 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = i14 + i12;
            i11 = (i11 & (~(1 << i15))) | ((zArr[i14 + i10] ? 1 : 0) << i15);
        }
        return i11;
    }

    public static long binaryToLong(boolean[] zArr, int i10, long j10, int i11, int i12) {
        if ((zArr.length == 0 && i10 == 0) || i12 == 0) {
            return j10;
        }
        if ((i12 - 1) + i11 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 + i11;
            j10 = (j10 & (~(1 << i14))) | ((zArr[i13 + i10] ? 1L : 0L) << i14);
        }
        return j10;
    }

    public static short binaryToShort(boolean[] zArr, int i10, short s2, int i11, int i12) {
        if ((zArr.length == 0 && i10 == 0) || i12 == 0) {
            return s2;
        }
        if ((i12 - 1) + i11 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 + i11;
            s2 = (short) ((s2 & (~(1 << i14))) | ((zArr[i13 + i10] ? 1 : 0) << i14));
        }
        return s2;
    }

    public static int byteArrayToInt(byte[] bArr, int i10, int i11, int i12, int i13) {
        if ((bArr.length == 0 && i10 == 0) || i13 == 0) {
            return i11;
        }
        if (((i13 - 1) * 8) + i12 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = (i14 * 8) + i12;
            i11 = (i11 & (~(255 << i15))) | ((bArr[i14 + i10] & 255) << i15);
        }
        return i11;
    }

    public static long byteArrayToLong(byte[] bArr, int i10, long j10, int i11, int i12) {
        if ((bArr.length == 0 && i10 == 0) || i12 == 0) {
            return j10;
        }
        if (((i12 - 1) * 8) + i11 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 8) + i11;
            j10 = (j10 & (~(255 << i14))) | ((bArr[i13 + i10] & 255) << i14);
        }
        return j10;
    }

    public static short byteArrayToShort(byte[] bArr, int i10, short s2, int i11, int i12) {
        if ((bArr.length == 0 && i10 == 0) || i12 == 0) {
            return s2;
        }
        if (((i12 - 1) * 8) + i11 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 8) + i11;
            s2 = (short) ((s2 & (~(255 << i14))) | ((bArr[i13 + i10] & 255) << i14));
        }
        return s2;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i10) {
        if (bArr.length - i10 >= 16) {
            return new UUID(byteArrayToLong(bArr, i10, 0L, 0, 8), byteArrayToLong(bArr, i10 + 8, 0L, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b4, int i10, boolean[] zArr, int i11, int i12) {
        if (i12 == 0) {
            return zArr;
        }
        if ((i12 - 1) + i10 >= 8) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i11 + i13;
            boolean z10 = true;
            if (((b4 >> (i13 + i10)) & 1) == 0) {
                z10 = false;
            }
            zArr[i14] = z10;
        }
        return zArr;
    }

    public static String byteToHex(byte b4, int i10, String str, int i11, int i12) {
        if (i12 == 0) {
            return str;
        }
        if (((i12 - 1) * 4) + i10 < 8) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = (b4 >> ((i13 * 4) + i10)) & 15;
                int i15 = i11 + i13;
                if (i15 == length) {
                    length++;
                    sb2.append(intToHexDigit(i14));
                } else {
                    sb2.setCharAt(i15, intToHexDigit(i14));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean[] hexDigitMsb0ToBinary(char r3) {
        /*
            switch(r3) {
                case 48: goto Lac;
                case 49: goto La3;
                case 50: goto L9a;
                case 51: goto L91;
                case 52: goto L88;
                case 53: goto L7f;
                case 54: goto L76;
                case 55: goto L6d;
                case 56: goto L64;
                case 57: goto L5b;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L52;
                case 66: goto L49;
                case 67: goto L40;
                case 68: goto L37;
                case 69: goto L2e;
                case 70: goto L25;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L52;
                case 98: goto L49;
                case 99: goto L40;
                case 100: goto L37;
                case 101: goto L2e;
                case 102: goto L25;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L25:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2e:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L37:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L40:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L49:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L52:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L5b:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L64:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6d:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L76:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7f:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L88:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L91:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L9a:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La3:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        Lac:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitMsb0ToBinary(char):boolean[]");
    }

    public static int hexDigitMsb0ToInt(char c4) {
        switch (c4) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c4) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c4) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c4 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean[] hexDigitToBinary(char r3) {
        /*
            switch(r3) {
                case 48: goto Lac;
                case 49: goto La3;
                case 50: goto L9a;
                case 51: goto L91;
                case 52: goto L88;
                case 53: goto L7f;
                case 54: goto L76;
                case 55: goto L6d;
                case 56: goto L64;
                case 57: goto L5b;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L52;
                case 66: goto L49;
                case 67: goto L40;
                case 68: goto L37;
                case 69: goto L2e;
                case 70: goto L25;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L52;
                case 98: goto L49;
                case 99: goto L40;
                case 100: goto L37;
                case 101: goto L2e;
                case 102: goto L25;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L25:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2e:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L37:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L40:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L49:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L52:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L5b:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L64:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6d:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L76:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7f:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L88:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L91:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L9a:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La3:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        Lac:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitToBinary(char):boolean[]");
    }

    public static int hexDigitToInt(char c4) {
        int digit = Character.digit(c4, 16);
        if (digit >= 0) {
            return digit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c4 + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i10, byte b4, int i11, int i12) {
        if (i12 == 0) {
            return b4;
        }
        if (((i12 - 1) * 4) + i11 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 4) + i11;
            b4 = (byte) ((b4 & (~(15 << i14))) | ((hexDigitToInt(str.charAt(i13 + i10)) & 15) << i14));
        }
        return b4;
    }

    public static int hexToInt(String str, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            return i11;
        }
        if (((i13 - 1) * 4) + i12 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = (i14 * 4) + i12;
            i11 = (i11 & (~(15 << i15))) | ((hexDigitToInt(str.charAt(i14 + i10)) & 15) << i15);
        }
        return i11;
    }

    public static long hexToLong(String str, int i10, long j10, int i11, int i12) {
        if (i12 == 0) {
            return j10;
        }
        if (((i12 - 1) * 4) + i11 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 4) + i11;
            j10 = (j10 & (~(15 << i14))) | ((hexDigitToInt(str.charAt(i13 + i10)) & 15) << i14);
        }
        return j10;
    }

    public static short hexToShort(String str, int i10, short s2, int i11, int i12) {
        if (i12 == 0) {
            return s2;
        }
        if (((i12 - 1) * 4) + i11 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 4) + i11;
            s2 = (short) ((s2 & (~(15 << i14))) | ((hexDigitToInt(str.charAt(i13 + i10)) & 15) << i14));
        }
        return s2;
    }

    public static long intArrayToLong(int[] iArr, int i10, long j10, int i11, int i12) {
        if ((iArr.length == 0 && i10 == 0) || i12 == 0) {
            return j10;
        }
        if (((i12 - 1) * 32) + i11 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 32) + i11;
            j10 = (j10 & (~(4294967295 << i14))) | ((iArr[i13 + i10] & 4294967295L) << i14);
        }
        return j10;
    }

    public static boolean[] intToBinary(int i10, int i11, boolean[] zArr, int i12, int i13) {
        if (i13 == 0) {
            return zArr;
        }
        if ((i13 - 1) + i11 >= 32) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = i12 + i14;
            boolean z10 = true;
            if (((i10 >> (i14 + i11)) & 1) == 0) {
                z10 = false;
            }
            zArr[i15] = z10;
        }
        return zArr;
    }

    public static byte[] intToByteArray(int i10, int i11, byte[] bArr, int i12, int i13) {
        if (i13 == 0) {
            return bArr;
        }
        if (((i13 - 1) * 8) + i11 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            bArr[i12 + i14] = (byte) ((i10 >> ((i14 * 8) + i11)) & 255);
        }
        return bArr;
    }

    public static String intToHex(int i10, int i11, String str, int i12, int i13) {
        if (i13 == 0) {
            return str;
        }
        if (((i13 - 1) * 4) + i11 < 32) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i10 >> ((i14 * 4) + i11)) & 15;
                int i16 = i12 + i14;
                if (i16 == length) {
                    length++;
                    sb2.append(intToHexDigit(i15));
                } else {
                    sb2.setCharAt(i16, intToHexDigit(i15));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
    }

    public static char intToHexDigit(int i10) {
        char forDigit = Character.forDigit(i10, 16);
        if (forDigit != 0) {
            return forDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i10);
    }

    public static char intToHexDigitMsb0(int i10) {
        switch (i10) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i10);
        }
    }

    public static short[] intToShortArray(int i10, int i11, short[] sArr, int i12, int i13) {
        if (i13 == 0) {
            return sArr;
        }
        if (((i13 - 1) * 16) + i11 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            sArr[i12 + i14] = (short) ((i10 >> ((i14 * 16) + i11)) & 65535);
        }
        return sArr;
    }

    public static boolean[] longToBinary(long j10, int i10, boolean[] zArr, int i11, int i12) {
        if (i12 == 0) {
            return zArr;
        }
        if ((i12 - 1) + i10 >= 64) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            zArr[i11 + i13] = (1 & (j10 >> (i13 + i10))) != 0;
        }
        return zArr;
    }

    public static byte[] longToByteArray(long j10, int i10, byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return bArr;
        }
        if (((i12 - 1) * 8) + i10 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i11 + i13] = (byte) (255 & (j10 >> ((i13 * 8) + i10)));
        }
        return bArr;
    }

    public static String longToHex(long j10, int i10, String str, int i11, int i12) {
        if (i12 == 0) {
            return str;
        }
        if (((i12 - 1) * 4) + i10 < 64) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = (int) ((j10 >> ((i13 * 4) + i10)) & 15);
                int i15 = i11 + i13;
                if (i15 == length) {
                    length++;
                    sb2.append(intToHexDigit(i14));
                } else {
                    sb2.setCharAt(i15, intToHexDigit(i14));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
    }

    public static int[] longToIntArray(long j10, int i10, int[] iArr, int i11, int i12) {
        if (i12 == 0) {
            return iArr;
        }
        if (((i12 - 1) * 32) + i10 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = (int) ((-1) & (j10 >> ((i13 * 32) + i10)));
        }
        return iArr;
    }

    public static short[] longToShortArray(long j10, int i10, short[] sArr, int i11, int i12) {
        if (i12 == 0) {
            return sArr;
        }
        if (((i12 - 1) * 16) + i10 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            sArr[i11 + i13] = (short) (65535 & (j10 >> ((i13 * 16) + i10)));
        }
        return sArr;
    }

    public static int shortArrayToInt(short[] sArr, int i10, int i11, int i12, int i13) {
        if ((sArr.length == 0 && i10 == 0) || i13 == 0) {
            return i11;
        }
        if (((i13 - 1) * 16) + i12 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = (i14 * 16) + i12;
            i11 = (i11 & (~(65535 << i15))) | ((sArr[i14 + i10] & 65535) << i15);
        }
        return i11;
    }

    public static long shortArrayToLong(short[] sArr, int i10, long j10, int i11, int i12) {
        if ((sArr.length == 0 && i10 == 0) || i12 == 0) {
            return j10;
        }
        if (((i12 - 1) * 16) + i11 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = (i13 * 16) + i11;
            j10 = (j10 & (~(65535 << i14))) | ((sArr[i13 + i10] & 65535) << i14);
        }
        return j10;
    }

    public static boolean[] shortToBinary(short s2, int i10, boolean[] zArr, int i11, int i12) {
        if (i12 == 0) {
            return zArr;
        }
        if ((i12 - 1) + i10 >= 16) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i11 + i13;
            boolean z10 = true;
            if (((s2 >> (i13 + i10)) & 1) == 0) {
                z10 = false;
            }
            zArr[i14] = z10;
        }
        return zArr;
    }

    public static byte[] shortToByteArray(short s2, int i10, byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return bArr;
        }
        if (((i12 - 1) * 8) + i10 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i11 + i13] = (byte) ((s2 >> ((i13 * 8) + i10)) & 255);
        }
        return bArr;
    }

    public static String shortToHex(short s2, int i10, String str, int i11, int i12) {
        if (i12 == 0) {
            return str;
        }
        if (((i12 - 1) * 4) + i10 < 16) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = (s2 >> ((i13 * 4) + i10)) & 15;
                int i15 = i11 + i13;
                if (i15 == length) {
                    length++;
                    sb2.append(intToHexDigit(i14));
                } else {
                    sb2.setCharAt(i15, intToHexDigit(i14));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return bArr;
        }
        if (i11 <= 16) {
            longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i10, i11 > 8 ? 8 : i11);
            if (i11 >= 8) {
                longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i10 + 8, i11 - 8);
            }
            return bArr;
        }
        throw new IllegalArgumentException("nBytes is greater than 16");
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i10) {
        if (zArr.length != 0) {
            int length = ((zArr.length - 1) - i10) + 1;
            int min = Math.min(4, length);
            boolean[] zArr2 = new boolean[4];
            System.arraycopy((Object) zArr, length - min, (Object) zArr2, 4 - min, min);
            return zArr2[0] ? zArr2[1] ? zArr2[2] ? zArr2[3] ? 'f' : 'e' : zArr2[3] ? 'd' : 'c' : zArr2[2] ? zArr2[3] ? 'b' : 'a' : zArr2[3] ? '9' : '8' : zArr2[1] ? zArr2[2] ? zArr2[3] ? '7' : '6' : zArr2[3] ? '5' : '4' : zArr2[2] ? zArr2[3] ? '3' : '2' : zArr2[3] ? '1' : '0';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static char binaryToHexDigit(boolean[] zArr, int i10) {
        if (zArr.length != 0) {
            int i11 = i10 + 3;
            if (zArr.length > i11 && zArr[i11]) {
                int i12 = i10 + 2;
                if (zArr.length <= i12 || !zArr[i12]) {
                    int i13 = i10 + 1;
                    return (zArr.length <= i13 || !zArr[i13]) ? zArr[i10] ? '9' : '8' : zArr[i10] ? 'b' : 'a';
                }
                int i14 = i10 + 1;
                return (zArr.length <= i14 || !zArr[i14]) ? zArr[i10] ? 'd' : 'c' : zArr[i10] ? 'f' : 'e';
            }
            int i15 = i10 + 2;
            if (zArr.length <= i15 || !zArr[i15]) {
                int i16 = i10 + 1;
                return (zArr.length <= i16 || !zArr[i16]) ? zArr[i10] ? '1' : '0' : zArr[i10] ? '3' : '2';
            }
            int i17 = i10 + 1;
            return (zArr.length <= i17 || !zArr[i17]) ? zArr[i10] ? '5' : '4' : zArr[i10] ? '7' : '6';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i10) {
        if (zArr.length <= 8) {
            if (zArr.length - i10 >= 4) {
                return zArr[i10 + 3] ? zArr[i10 + 2] ? zArr[i10 + 1] ? zArr[i10] ? 'f' : '7' : zArr[i10] ? 'b' : '3' : zArr[i10 + 1] ? zArr[i10] ? 'd' : '5' : zArr[i10] ? '9' : '1' : zArr[i10 + 2] ? zArr[i10 + 1] ? zArr[i10] ? 'e' : '6' : zArr[i10] ? 'a' : '2' : zArr[i10 + 1] ? zArr[i10] ? 'c' : '4' : zArr[i10] ? '8' : '0';
            }
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i10);
        }
        throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
    }
}
