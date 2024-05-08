package com.mobile.auth.gatewayauth.utils.security;

import androidx.exifinterface.media.ExifInterface;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.util.Locale;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f37402a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f37403b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, -1, -1, -1, -1, -1, -1, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] bArr) {
        String str;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                int i12 = bArr[i10] & 255;
                if (i11 == length) {
                    stringBuffer.append(f37402a[i12 >>> 2]);
                    stringBuffer.append(f37402a[(i12 & 3) << 4]);
                    str = "==";
                } else {
                    int i13 = i11 + 1;
                    int i14 = bArr[i11] & 255;
                    if (i13 == length) {
                        stringBuffer.append(f37402a[i12 >>> 2]);
                        stringBuffer.append(f37402a[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                        stringBuffer.append(f37402a[(i14 & 15) << 2]);
                        str = "=";
                    } else {
                        int i15 = i13 + 1;
                        int i16 = bArr[i13] & 255;
                        stringBuffer.append(f37402a[i12 >>> 2]);
                        stringBuffer.append(f37402a[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                        stringBuffer.append(f37402a[((i14 & 15) << 2) | ((i16 & 192) >>> 6)]);
                        stringBuffer.append(f37402a[i16 & 63]);
                        i10 = i15;
                    }
                }
                stringBuffer.append(str);
                break;
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
    
        if (r2 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
    
        r1.write(r2 | ((r5 & 3) << 6));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r8) {
        /*
            byte[] r8 = r8.getBytes()     // Catch: java.lang.Throwable -> L8c
            int r0 = r8.length     // Catch: java.lang.Throwable -> L8c
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L8c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8c
            r2 = 0
        Lb:
            if (r2 >= r0) goto L87
        Ld:
            byte[] r3 = com.mobile.auth.gatewayauth.utils.security.a.f37403b     // Catch: java.lang.Throwable -> L8c
            int r4 = r2 + 1
            r2 = r8[r2]     // Catch: java.lang.Throwable -> L8c
            r2 = r3[r2]     // Catch: java.lang.Throwable -> L8c
            r3 = -1
            if (r4 >= r0) goto L1d
            if (r2 == r3) goto L1b
            goto L1d
        L1b:
            r2 = r4
            goto Ld
        L1d:
            if (r2 != r3) goto L21
            goto L87
        L21:
            byte[] r5 = com.mobile.auth.gatewayauth.utils.security.a.f37403b     // Catch: java.lang.Throwable -> L8c
            int r6 = r4 + 1
            r4 = r8[r4]     // Catch: java.lang.Throwable -> L8c
            r4 = r5[r4]     // Catch: java.lang.Throwable -> L8c
            if (r6 >= r0) goto L30
            if (r4 == r3) goto L2e
            goto L30
        L2e:
            r4 = r6
            goto L21
        L30:
            if (r4 != r3) goto L33
            goto L87
        L33:
            int r2 = r2 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r2 = r2 | r5
            r1.write(r2)     // Catch: java.lang.Throwable -> L8c
        L3d:
            int r2 = r6 + 1
            r5 = r8[r6]     // Catch: java.lang.Throwable -> L8c
            r6 = 61
            if (r5 != r6) goto L4a
            byte[] r8 = r1.toByteArray()     // Catch: java.lang.Throwable -> L8c
            return r8
        L4a:
            byte[] r7 = com.mobile.auth.gatewayauth.utils.security.a.f37403b     // Catch: java.lang.Throwable -> L8c
            r5 = r7[r5]     // Catch: java.lang.Throwable -> L8c
            if (r2 >= r0) goto L55
            if (r5 == r3) goto L53
            goto L55
        L53:
            r6 = r2
            goto L3d
        L55:
            if (r5 != r3) goto L58
            goto L87
        L58:
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r1.write(r4)     // Catch: java.lang.Throwable -> L8c
        L64:
            int r4 = r2 + 1
            r2 = r8[r2]     // Catch: java.lang.Throwable -> L8c
            if (r2 != r6) goto L6f
            byte[] r8 = r1.toByteArray()     // Catch: java.lang.Throwable -> L8c
            return r8
        L6f:
            byte[] r7 = com.mobile.auth.gatewayauth.utils.security.a.f37403b     // Catch: java.lang.Throwable -> L8c
            r2 = r7[r2]     // Catch: java.lang.Throwable -> L8c
            if (r4 >= r0) goto L7a
            if (r2 == r3) goto L78
            goto L7a
        L78:
            r2 = r4
            goto L64
        L7a:
            if (r2 != r3) goto L7d
            goto L87
        L7d:
            r3 = r5 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            r1.write(r2)     // Catch: java.lang.Throwable -> L8c
            r2 = r4
            goto Lb
        L87:
            byte[] r8 = r1.toByteArray()     // Catch: java.lang.Throwable -> L8c
            return r8
        L8c:
            r8 = move-exception
            r0 = 0
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r8)     // Catch: java.lang.Throwable -> L92
            return r0
        L92:
            r8 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.utils.security.a.a(java.lang.String):byte[]");
    }
}
