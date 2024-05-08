package com.amap.api.col.p0003l;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: Base64Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class gm {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f6114a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6115b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f6116c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, -9, -9, -9, -9, -9, -9, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f6117d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f6118e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f6119f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG};

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f6120g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private gm() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, bArr.length);
        } catch (IOException e2) {
            if (!f6114a) {
                throw new AssertionError((Object) e2.getMessage());
            }
            str = null;
        }
        if (f6114a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static byte[] b(byte[] bArr, int i10) throws IOException {
        int i11;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        int i12 = i10 + 0;
        int i13 = 1;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i10)));
        }
        if (i10 == 0) {
            return new byte[0];
        }
        if (i10 >= 4) {
            byte[] bArr2 = f6116c;
            int i14 = (i10 * 3) / 4;
            byte[] bArr3 = new byte[i14];
            byte[] bArr4 = new byte[4];
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i15 < i12) {
                byte b4 = bArr2[bArr[i15] & 255];
                if (b4 < -5) {
                    throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i15] & 255), Integer.valueOf(i15)));
                }
                if (b4 >= -1) {
                    int i18 = i16 + 1;
                    bArr4[i16] = bArr[i15];
                    if (i18 <= 3) {
                        i16 = i18;
                    } else if (i17 >= 0 && (i11 = i17 + 2) < i14) {
                        byte[] bArr5 = f6116c;
                        if (bArr4[2] == 61) {
                            bArr3[i17] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i13]] & 255) << 12)) >>> 16);
                        } else if (bArr4[3] == 61) {
                            int i19 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i13]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                            bArr3[i17] = (byte) (i19 >>> 16);
                            bArr3[i17 + 1] = (byte) (i19 >>> 8);
                            i13 = 2;
                        } else {
                            int i20 = ((bArr5[bArr4[i13]] & 255) << 12) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[2]] & 255) << 6) | (bArr5[bArr4[3]] & 255);
                            bArr3[i17] = (byte) (i20 >> 16);
                            bArr3[i17 + 1] = (byte) (i20 >> 8);
                            bArr3[i11] = (byte) i20;
                            i13 = 3;
                        }
                        i17 += i13;
                        if (bArr[i15] == 61) {
                            break;
                        }
                        i16 = 0;
                    } else {
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i14), Integer.valueOf(i17)));
                    }
                }
                i15++;
                i13 = 1;
            }
            byte[] bArr6 = new byte[i17];
            System.arraycopy((Object) bArr3, 0, (Object) bArr6, 0, i17);
            return bArr6;
        }
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i10)));
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = f6115b;
        int i13 = (i11 > 0 ? (bArr[i10] << 24) >>> 8 : 0) | (i11 > 1 ? (bArr[i10 + 1] << 24) >>> 16 : 0) | (i11 > 2 ? (bArr[i10 + 2] << 24) >>> 24 : 0);
        if (i11 == 1) {
            bArr2[i12] = bArr3[i13 >>> 18];
            bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
            bArr2[i12 + 2] = 61;
            bArr2[i12 + 3] = 61;
            return bArr2;
        }
        if (i11 == 2) {
            bArr2[i12] = bArr3[i13 >>> 18];
            bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
            bArr2[i12 + 2] = bArr3[(i13 >>> 6) & 63];
            bArr2[i12 + 3] = 61;
            return bArr2;
        }
        if (i11 != 3) {
            return bArr2;
        }
        bArr2[i12] = bArr3[i13 >>> 18];
        bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
        bArr2[i12 + 2] = bArr3[(i13 >>> 6) & 63];
        bArr2[i12 + 3] = bArr3[i13 & 63];
        return bArr2;
    }

    private static String a(byte[] bArr, int i10) throws IOException {
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i10 >= 0) {
            if (i10 + 0 <= bArr.length) {
                int i11 = ((i10 / 3) * 4) + (i10 % 3 <= 0 ? 0 : 4);
                byte[] bArr2 = new byte[i11];
                int i12 = i10 - 2;
                int i13 = 0;
                int i14 = 0;
                while (i13 < i12) {
                    a(bArr, i13 + 0, 3, bArr2, i14);
                    i13 += 3;
                    i14 += 4;
                }
                if (i13 < i10) {
                    a(bArr, i13 + 0, i10 - i13, bArr2, i14);
                    i14 += 4;
                }
                if (i14 <= i11 - 1) {
                    byte[] bArr3 = new byte[i14];
                    System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i14);
                    bArr2 = bArr3;
                }
                try {
                    return new String(bArr2, CharEncoding.US_ASCII);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr2);
                }
            }
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i10), Integer.valueOf(bArr.length)));
        }
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i10)));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x0052
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private static byte[] b(java.lang.String r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "Input string was null."
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.String r0 = "US-ASCII"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> Lc
            goto L10
        Lc:
            byte[] r6 = r6.getBytes()
        L10:
            int r0 = r6.length
            byte[] r6 = b(r6, r0)
            int r0 = r6.length
            r1 = 4
            if (r0 < r1) goto L86
            r0 = 0
            r1 = r6[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            r2 = r6[r2]
            int r2 = r2 << 8
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r1 = r1 | r2
            r2 = 35615(0x8b1f, float:4.9907E-41)
            if (r2 != r1) goto L86
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L71
            r3.<init>()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L71
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L68
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L68
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
        L41:
            int r2 = r5.read(r1)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r2 < 0) goto L4b
            r3.write(r1, r0, r2)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            goto L41
        L4b:
            byte[] r6 = r3.toByteArray()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r3.close()     // Catch: java.lang.Exception -> L52
        L52:
            r5.close()     // Catch: java.lang.Exception -> L55
        L55:
            r4.close()     // Catch: java.lang.Exception -> L86
            goto L86
        L59:
            r6 = move-exception
            goto L66
        L5b:
            r0 = move-exception
            goto L6b
        L5d:
            r6 = move-exception
            r5 = r2
            goto L66
        L60:
            r0 = move-exception
            r5 = r2
            goto L6b
        L63:
            r6 = move-exception
            r4 = r2
            r5 = r4
        L66:
            r2 = r3
            goto L7c
        L68:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L6b:
            r2 = r3
            goto L74
        L6d:
            r6 = move-exception
            r4 = r2
            r5 = r4
            goto L7c
        L71:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L74:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            r2.close()     // Catch: java.lang.Exception -> L52
            goto L52
        L7b:
            r6 = move-exception
        L7c:
            r2.close()     // Catch: java.lang.Exception -> L7f
        L7f:
            r5.close()     // Catch: java.lang.Exception -> L82
        L82:
            r4.close()     // Catch: java.lang.Exception -> L85
        L85:
            throw r6
        L86:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.gm.b(java.lang.String):byte[]");
    }
}
