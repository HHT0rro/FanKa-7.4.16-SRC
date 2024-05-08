package com.mobile.auth.b;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36684a = "e";

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f36685b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            if (bArr.length == 0) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < bArr.length; i10++) {
                char[] cArr = f36685b;
                sb2.append(cArr[(bArr[i10] >> 4) & 15]);
                sb2.append(cArr[bArr[i10] & 15]);
            }
            return sb2.toString();
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

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        try {
            char[] charArray = str.toCharArray();
            int length = charArray.length / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                int digit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
                if (digit > 127) {
                    digit -= 256;
                }
                bArr[i10] = (byte) digit;
            }
            return bArr;
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

    public static byte[] b(String str) {
        try {
            byte[] bArr = new byte[0];
            try {
                return str.getBytes("UTF-8");
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36684a, "getBytes error", th);
                return bArr;
            }
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
                return null;
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
                return null;
            }
        }
    }
}
