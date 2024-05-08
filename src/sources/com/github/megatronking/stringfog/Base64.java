package com.github.megatronking.stringfog;

import java.io.ObjectStreamConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i10);

        public abstract boolean process(byte[] bArr, int i10, int i11, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Decoder extends Coder {
        public static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int EQUALS = -2;
        public static final int SKIP = -1;
        public final int[] alphabet;
        public int state;
        public int value;

        @Override // com.github.megatronking.stringfog.Base64.Coder
        public int maxOutputSize(int i10) {
            return ((i10 * 3) / 4) + 10;
        }

        @Override // com.github.megatronking.stringfog.Base64.Coder
        public boolean process(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.state;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i15 = i14;
            int i16 = 0;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i15 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i16 + 2] = (byte) i15;
                        bArr2[i16 + 1] = (byte) (i15 >> 8);
                        bArr2[i16] = (byte) (i15 >> 16);
                        i16 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                int i20 = i18 + 1;
                int i21 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 == 1) {
                        if (i21 < 0) {
                            if (i21 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i21 |= i15 << 6;
                    } else if (i17 == 2) {
                        if (i21 < 0) {
                            if (i21 == -2) {
                                bArr2[i16] = (byte) (i15 >> 4);
                                i16++;
                                i17 = 4;
                            } else if (i21 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i21 |= i15 << 6;
                    } else if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 == 5 && i21 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i21 == -2) {
                            i17++;
                        } else if (i21 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        int i22 = i21 | (i15 << 6);
                        bArr2[i16 + 2] = (byte) i22;
                        bArr2[i16 + 1] = (byte) (i22 >> 8);
                        bArr2[i16] = (byte) (i22 >> 16);
                        i16 += 3;
                        i15 = i22;
                        i17 = 0;
                    } else if (i21 == -2) {
                        bArr2[i16 + 1] = (byte) (i15 >> 2);
                        bArr2[i16] = (byte) (i15 >> 10);
                        i16 += 2;
                        i17 = 5;
                    } else if (i21 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i17++;
                    i15 = i21;
                } else {
                    if (i21 < 0) {
                        if (i21 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i17++;
                    i15 = i21;
                }
                i18 = i20;
            }
            if (!z10) {
                this.state = i17;
                this.value = i15;
                this.op = i16;
                return true;
            }
            if (i17 != 1) {
                if (i17 == 2) {
                    bArr2[i16] = (byte) (i15 >> 4);
                    i16++;
                } else if (i17 == 3) {
                    int i23 = i16 + 1;
                    bArr2[i16] = (byte) (i15 >> 10);
                    i16 = i23 + 1;
                    bArr2[i23] = (byte) (i15 >> 2);
                } else if (i17 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i17;
                this.op = i16;
                return true;
            }
            this.state = 6;
            return false;
        }

        public Decoder(int i10, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i10 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Encoder extends Coder {
        public static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        public final byte[] alphabet;
        public int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        public final byte[] tail;
        public int tailLen;

        @Override // com.github.megatronking.stringfog.Base64.Coder
        public int maxOutputSize(int i10) {
            return ((i10 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00e8 A[SYNTHETIC] */
        @Override // com.github.megatronking.stringfog.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.megatronking.stringfog.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }

        public Encoder(int i10, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.do_newline = z10;
            this.do_cr = (i10 & 4) != 0;
            this.alphabet = (i10 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z10 ? 19 : -1;
        }
    }

    public static byte[] decode(String str, int i10) {
        return decode(str.getBytes(), i10);
    }

    public static byte[] encode(String str, int i10) {
        return encode(str.getBytes(), i10);
    }

    public static byte[] decode(byte[] bArr, int i10) {
        return decode(bArr, 0, bArr.length, i10);
    }

    public static byte[] encode(byte[] bArr, int i10) {
        return encode(bArr, 0, bArr.length, i10);
    }

    public static byte[] decode(byte[] bArr, int i10, int i11, int i12) {
        Decoder decoder = new Decoder(i12, new byte[(i11 * 3) / 4]);
        if (decoder.process(bArr, i10, i11, true)) {
            int i13 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] encode(byte[] bArr, int i10, int i11, int i12) {
        Encoder encoder = new Encoder(i12, null);
        int i13 = (i11 / 3) * 4;
        if (encoder.do_padding) {
            if (i11 % 3 > 0) {
                i13 += 4;
            }
        } else {
            int i14 = i11 % 3;
            if (i14 != 0) {
                if (i14 == 1) {
                    i13 += 2;
                } else if (i14 == 2) {
                    i13 += 3;
                }
            }
        }
        if (encoder.do_newline && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i13];
        encoder.process(bArr, i10, i11, true);
        return encoder.output;
    }
}
