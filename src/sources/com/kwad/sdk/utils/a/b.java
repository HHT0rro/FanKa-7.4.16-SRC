package com.kwad.sdk.utils.a;

import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aRn;
    public byte[] aRo;
    public int position;

    public b(int i10) {
        this(new byte[i10], 0);
    }

    private int C(int i10, int i11) {
        while ((i11 & (-128)) != 0) {
            this.aRo[i10] = (byte) ((i11 & 127) | 128);
            i11 >>>= 7;
            i10++;
        }
        int i12 = i10 + 1;
        this.aRo[i10] = (byte) i11;
        return i12;
    }

    public static int eg(int i10) {
        if ((i10 >> 7) == 0) {
            return 1;
        }
        if ((i10 >> 14) == 0) {
            return 2;
        }
        if ((i10 >> 21) == 0) {
            return 3;
        }
        return (i10 >> 28) == 0 ? 4 : 5;
    }

    private char[] ei(int i10) {
        char[] cArr = this.aRn;
        if (cArr == null) {
            if (i10 <= 256) {
                this.aRn = new char[256];
            } else {
                this.aRn = new char[2048];
            }
        } else if (cArr.length < i10) {
            this.aRn = new char[2048];
        }
        return this.aRn;
    }

    private String ej(int i10) {
        if (i10 > 2048) {
            return new String(this.aRo, this.position, i10, UTF_8);
        }
        char[] ei = ei(i10);
        byte[] bArr = this.aRo;
        int i11 = this.position;
        int i12 = i10 + i11;
        int i13 = 0;
        while (i11 < i12) {
            int i14 = i11 + 1;
            byte b4 = bArr[i11];
            if (b4 > 0) {
                ei[i13] = (char) (b4 ^ 1);
                i11 = i14;
                i13++;
            } else if (b4 < -32) {
                ei[i13] = (char) (((b4 & 31) << 6) | (bArr[i14] & Utf8.REPLACEMENT_BYTE));
                i11 = i14 + 1;
                i13++;
            } else if (b4 < -16) {
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                ei[i13] = (char) (((b4 & 15) << 12) | ((bArr[i14] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i15] & Utf8.REPLACEMENT_BYTE));
                i11 = i16;
                i13++;
            } else {
                int i17 = i14 + 1;
                int i18 = i17 + 1;
                int i19 = i18 + 1;
                int i20 = ((b4 & 7) << 18) | ((bArr[i14] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i17] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i18] & Utf8.REPLACEMENT_BYTE);
                int i21 = i13 + 1;
                ei[i13] = (char) ((i20 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i13 = i21 + 1;
                ei[i21] = (char) ((i20 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i11 = i19;
            }
        }
        if (i11 <= i12) {
            return new String(ei, 0, i13);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String ek(int i10) {
        if (i10 > 2048) {
            return new String(this.aRo, this.position, i10, UTF_8);
        }
        char[] ei = ei(i10);
        byte[] bArr = this.aRo;
        int i11 = this.position;
        int i12 = i10 + i11;
        int i13 = 0;
        while (i11 < i12) {
            int i14 = i11 + 1;
            byte b4 = bArr[i11];
            if (b4 > 0) {
                ei[i13] = (char) b4;
                i11 = i14;
                i13++;
            } else if (b4 < -32) {
                ei[i13] = (char) (((b4 & 31) << 6) | (bArr[i14] & Utf8.REPLACEMENT_BYTE));
                i11 = i14 + 1;
                i13++;
            } else if (b4 < -16) {
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                ei[i13] = (char) (((b4 & 15) << 12) | ((bArr[i14] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i15] & Utf8.REPLACEMENT_BYTE));
                i11 = i16;
                i13++;
            } else {
                int i17 = i14 + 1;
                int i18 = i17 + 1;
                int i19 = i18 + 1;
                int i20 = ((b4 & 7) << 18) | ((bArr[i14] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i17] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i18] & Utf8.REPLACEMENT_BYTE);
                int i21 = i13 + 1;
                ei[i13] = (char) ((i20 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i13 = i21 + 1;
                ei[i21] = (char) ((i20 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i11 = i19;
            }
        }
        if (i11 <= i12) {
            return new String(ei, 0, i13);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i10) {
        byte[] bArr = this.aRo;
        long j10 = bArr[i10] & 255;
        int i11 = i10 + 1 + 1 + 1;
        long j11 = j10 | ((bArr[r1] & 255) << 8) | ((bArr[r9] & 255) << 16);
        long j12 = j11 | ((bArr[i11] & 255) << 24);
        long j13 = j12 | ((bArr[r9] & 255) << 32);
        int i12 = i11 + 1 + 1 + 1;
        return j13 | ((bArr[r3] & 255) << 40) | ((255 & bArr[i12]) << 48) | (bArr[i12 + 1] << 56);
    }

    public static int he(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                i11++;
            } else if (charAt < 2048) {
                i11 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i11 += 3;
            } else {
                i10 = i12 + 1;
                i11 += 4;
            }
            i10 = i12;
        }
        return i11;
    }

    private void hf(String str) {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                bArr[i10] = (byte) (charAt ^ 1);
                i11 = i12;
                i10++;
            } else if (charAt < 2048) {
                int i13 = i10 + 1;
                bArr[i10] = (byte) ((charAt >>> 6) | 192);
                i10 = i13 + 1;
                bArr[i13] = (byte) ((charAt & '?') | 128);
                i11 = i12;
            } else if (charAt >= 55296 && charAt <= 57343) {
                int i14 = i12 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i12)) - 56613888;
                int i15 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 >>> 18) | 240);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i10 = i17 + 1;
                bArr[i17] = (byte) ((charAt2 & 63) | 128);
                i11 = i14;
            } else {
                int i18 = i10 + 1;
                bArr[i10] = (byte) ((charAt >>> '\f') | 224);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i19] = (byte) ((charAt & '?') | 128);
                i11 = i12;
                i10 = i19 + 1;
            }
        }
        this.position = i10;
    }

    public static byte[] hg(String str) {
        byte[] bArr = new byte[he(str)];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                bArr[i11] = (byte) (charAt ^ 1);
                i10 = i12;
                i11++;
            } else if (charAt < 2048) {
                int i13 = i11 + 1;
                bArr[i11] = (byte) ((charAt >>> 6) | 192);
                i11 = i13 + 1;
                bArr[i13] = (byte) ((charAt & '?') | 128);
                i10 = i12;
            } else if (charAt >= 55296 && charAt <= 57343) {
                int i14 = i12 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i12)) - 56613888;
                int i15 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 >>> 18) | 240);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i11 = i17 + 1;
                bArr[i17] = (byte) ((charAt2 & 63) | 128);
                i10 = i14;
            } else {
                int i18 = i11 + 1;
                bArr[i11] = (byte) ((charAt >>> '\f') | 224);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i19] = (byte) ((charAt & '?') | 128);
                i10 = i12;
                i11 = i19 + 1;
            }
        }
        return bArr;
    }

    public static String j(byte[] bArr, int i10) {
        char[] cArr = new char[bArr.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i11 + 1;
            byte b4 = bArr[i11];
            if (b4 > 0) {
                cArr[i12] = (char) (b4 ^ 1);
                i11 = i13;
                i12++;
            } else if (b4 < -32) {
                cArr[i12] = (char) (((b4 & 31) << 6) | (bArr[i13] & Utf8.REPLACEMENT_BYTE));
                i11 = i13 + 1;
                i12++;
            } else if (b4 < -16) {
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                cArr[i12] = (char) (((b4 & 15) << 12) | ((bArr[i13] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i14] & Utf8.REPLACEMENT_BYTE));
                i11 = i15;
                i12++;
            } else {
                int i16 = i13 + 1;
                int i17 = i16 + 1;
                int i18 = i17 + 1;
                int i19 = ((b4 & 7) << 18) | ((bArr[i13] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i16] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i17] & Utf8.REPLACEMENT_BYTE);
                int i20 = i12 + 1;
                cArr[i12] = (char) ((i19 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i12 = i20 + 1;
                cArr[i20] = (char) ((i19 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i11 = i18;
            }
        }
        if (i11 <= i10) {
            return new String(cArr, 0, i12);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public final void B(int i10, int i11) {
        byte[] bArr = this.aRo;
        int i12 = i10 + 1;
        bArr[i10] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >> 8);
        bArr[i13] = (byte) (i11 >> 16);
        bArr[i13 + 1] = (byte) (i11 >> 24);
    }

    public final long D(int i10, int i11) {
        long j10 = 0;
        if (i11 <= 0) {
            return 0L;
        }
        int i12 = i11 >> 3;
        int i13 = i11 & 7;
        int i14 = 0;
        int i15 = i10;
        for (int i16 = 0; i16 < i12; i16++) {
            j10 ^= getLong(i15);
            i15 += 8;
        }
        while (i14 < (i13 << 3)) {
            j10 ^= (this.aRo[i15] & 255) << i14;
            i14 += 8;
            i15++;
        }
        int i17 = (i10 & 7) << 3;
        return (j10 >>> (64 - i17)) | (j10 << i17);
    }

    public final int Nt() {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        byte b4 = bArr[i10];
        if ((b4 >> 7) == 0) {
            return b4;
        }
        int i12 = b4 & Byte.MAX_VALUE;
        int i13 = i11 + 1;
        this.position = i13;
        int i14 = i12 | (bArr[i11] << 7);
        if ((i14 >> 14) == 0) {
            return i14;
        }
        int i15 = i13 + 1;
        this.position = i15;
        int i16 = (i14 & 16383) | (bArr[i13] << 14);
        if ((i16 >> 21) == 0) {
            return i16;
        }
        int i17 = i15 + 1;
        this.position = i17;
        int i18 = (i16 & 2097151) | (bArr[i15] << 21);
        if ((i18 >> 28) == 0) {
            return i18;
        }
        this.position = i17 + 1;
        return (bArr[i17] << 28) | (i18 & 268435455);
    }

    public final void a(short s2) {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        bArr[i10] = (byte) s2;
        this.position = i11 + 1;
        bArr[i11] = (byte) (s2 >> 8);
    }

    public final void aH(long j10) {
        f(this.position, j10);
        this.position += 8;
    }

    public final void e(byte b4) {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        this.position = i10 + 1;
        bArr[i10] = b4;
    }

    public final void ee(int i10) {
        byte[] bArr = this.aRo;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        bArr[i11] = (byte) i10;
        int i13 = i12 + 1;
        this.position = i13;
        bArr[i12] = (byte) (i10 >> 8);
        int i14 = i13 + 1;
        this.position = i14;
        bArr[i13] = (byte) (i10 >> 16);
        this.position = i14 + 1;
        bArr[i14] = (byte) (i10 >> 24);
    }

    public final void ef(int i10) {
        this.position = C(this.position, i10);
    }

    public final String eh(int i10) {
        if (i10 < 0) {
            return null;
        }
        if (i10 == 0) {
            return "";
        }
        String ek = ek(i10);
        this.position += i10;
        return ek;
    }

    public final void f(int i10, long j10) {
        byte[] bArr = this.aRo;
        int i11 = i10 + 1;
        bArr[i10] = (byte) j10;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j10 >> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j10 >> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j10 >> 24);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j10 >> 32);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (j10 >> 40);
        bArr[i16] = (byte) (j10 >> 48);
        bArr[i16 + 1] = (byte) (j10 >> 56);
    }

    public final byte get() {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        this.position = i10 + 1;
        return bArr[i10];
    }

    public final byte[] getBytes(int i10) {
        byte[] bArr = new byte[i10];
        System.arraycopy((Object) this.aRo, this.position, (Object) bArr, 0, i10);
        this.position += i10;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        this.position = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        int i15 = i13 + 1;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.position = i15 + 1;
        return (bArr[i15] << 24) | i16;
    }

    public final short getShort() {
        byte[] bArr = this.aRo;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i11 + 1;
        return (short) ((bArr[i11] << 8) | i12);
    }

    public final String getString(int i10) {
        if (i10 < 0) {
            return null;
        }
        if (i10 == 0) {
            return "";
        }
        String ej = ej(i10);
        this.position += i10;
        return ej;
    }

    public final void hd(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hf(str);
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy((Object) bArr, 0, (Object) this.aRo, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j10 = getLong(this.position);
        this.position += 8;
        return j10;
    }

    public b(byte[] bArr, int i10) {
        this.aRn = null;
        this.aRo = bArr;
        this.position = i10;
    }
}
