package com.kwad.sdk.core.a;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        public static final b auS = new b(false, null, -1, true);
        public static final b auT = new b(true, null, -1, false);
        private static final char[] auU = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] auV = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean auQ;
        private final byte[] auW = null;
        private final int auX = -1;
        private final boolean auY;

        private b(boolean z10, byte[] bArr, int i10, boolean z11) {
            this.auQ = z10;
            this.auY = z11;
        }

        private int b(byte[] bArr, int i10, int i11, byte[] bArr2) {
            char[] cArr = this.auQ ? auV : auU;
            int i12 = ((i11 + 0) / 3) * 3;
            int i13 = i12 + 0;
            int i14 = this.auX;
            if (i14 > 0 && i12 > (i14 / 4) * 3) {
                i12 = (i14 / 4) * 3;
            }
            int i15 = 0;
            int i16 = 0;
            while (i15 < i13) {
                int min = Math.min(i15 + i12, i13);
                int i17 = i15;
                int i18 = i16;
                while (i17 < min) {
                    int i19 = i17 + 1;
                    int i20 = i19 + 1;
                    int i21 = ((bArr[i17] & 255) << 16) | ((bArr[i19] & 255) << 8);
                    int i22 = i20 + 1;
                    int i23 = i21 | (bArr[i20] & 255);
                    int i24 = i18 + 1;
                    bArr2[i18] = (byte) cArr[(i23 >>> 18) & 63];
                    int i25 = i24 + 1;
                    bArr2[i24] = (byte) cArr[(i23 >>> 12) & 63];
                    int i26 = i25 + 1;
                    bArr2[i25] = (byte) cArr[(i23 >>> 6) & 63];
                    i18 = i26 + 1;
                    bArr2[i26] = (byte) cArr[i23 & 63];
                    i17 = i22;
                }
                int i27 = ((min - i15) / 3) * 4;
                i16 += i27;
                if (i27 == this.auX && min < i11) {
                    byte[] bArr3 = this.auW;
                    int length = bArr3.length;
                    int i28 = 0;
                    while (i28 < length) {
                        bArr2[i16] = bArr3[i28];
                        i28++;
                        i16++;
                    }
                }
                i15 = min;
            }
            if (i15 >= i11) {
                return i16;
            }
            int i29 = i15 + 1;
            int i30 = bArr[i15] & 255;
            int i31 = i16 + 1;
            bArr2[i16] = (byte) cArr[i30 >> 2];
            if (i29 == i11) {
                int i32 = i31 + 1;
                bArr2[i31] = (byte) cArr[(i30 << 4) & 63];
                if (!this.auY) {
                    return i32;
                }
                int i33 = i32 + 1;
                bArr2[i32] = 61;
                int i34 = i33 + 1;
                bArr2[i33] = 61;
                return i34;
            }
            int i35 = bArr[i29] & 255;
            int i36 = i31 + 1;
            bArr2[i31] = (byte) cArr[((i30 << 4) & 63) | (i35 >> 4)];
            int i37 = i36 + 1;
            bArr2[i36] = (byte) cArr[(i35 << 2) & 63];
            if (!this.auY) {
                return i37;
            }
            int i38 = i37 + 1;
            bArr2[i37] = 61;
            return i38;
        }

        private final int dd(int i10) {
            int i11;
            if (this.auY) {
                i11 = ((i10 + 2) / 3) * 4;
            } else {
                int i12 = i10 % 3;
                i11 = ((i10 / 3) * 4) + (i12 == 0 ? 0 : i12 + 1);
            }
            int i13 = this.auX;
            return i13 > 0 ? i11 + (((i11 - 1) / i13) * this.auW.length) : i11;
        }

        public final byte[] encode(byte[] bArr) {
            int dd2 = dd(bArr.length);
            byte[] bArr2 = new byte[dd2];
            int b4 = b(bArr, 0, bArr.length, bArr2);
            return b4 != dd2 ? Arrays.copyOf(bArr2, b4) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static b Ds() {
        return b.auS;
    }

    public static b Dt() {
        return b.auT;
    }

    public static a Du() {
        return a.auM;
    }

    public static a Dv() {
        return a.auN;
    }

    public static String dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(Ds().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String dI(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(Du().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final int[] auO;
        private final boolean auQ;
        private final boolean auR = false;
        public static final a auM = new a(false, false);
        public static final a auN = new a(true, false);
        private static final int[] auP = new int[256];

        static {
            int[] iArr = new int[256];
            auO = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < b.auU.length; i10++) {
                auO[b.auU[i10]] = i10;
            }
            auO[61] = -2;
            Arrays.fill(auP, -1);
            for (int i11 = 0; i11 < b.auV.length; i11++) {
                auP[b.auV[i11]] = i11;
            }
            auP[61] = -2;
        }

        private a(boolean z10, boolean z11) {
            this.auQ = z10;
        }

        private int a(byte[] bArr, int i10, int i11) {
            int i12;
            int[] iArr = this.auQ ? auP : auO;
            int i13 = i11 + 0;
            int i14 = 0;
            if (i13 == 0) {
                return 0;
            }
            if (i13 < 2) {
                if (this.auR && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.auR) {
                int i15 = 0;
                while (true) {
                    if (i10 >= i11) {
                        break;
                    }
                    int i16 = i10 + 1;
                    int i17 = bArr[i10] & 255;
                    if (i17 == 61) {
                        i13 -= (i11 - i16) + 1;
                        break;
                    }
                    if (iArr[i17] == -1) {
                        i15++;
                    }
                    i10 = i16;
                }
                i13 -= i15;
            } else if (bArr[i11 - 1] == 61) {
                i14 = bArr[i11 - 2] == 61 ? 2 : 1;
            }
            if (i14 == 0 && (i12 = i13 & 3) != 0) {
                i14 = 4 - i12;
            }
            return (((i13 + 3) / 4) * 3) - i14;
        }

        public final byte[] decode(byte[] bArr) {
            int a10 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a10];
            int a11 = a(bArr, 0, bArr.length, bArr2);
            return a11 != a10 ? Arrays.copyOf(bArr2, a11) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
        
            if (r11[r8] == 61) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r4 != 18) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        
            if (r4 != 6) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
        
            if (r12 >= r13) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        
            if (r10.auR == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
        
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
        
            if (r0[r11[r12]] >= 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00c0, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
        
            if (r4 != 0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        
            if (r4 == 12) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
                Method dump skipped, instructions count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.a.c.a.a(byte[], int, int, byte[]):int");
        }
    }
}
