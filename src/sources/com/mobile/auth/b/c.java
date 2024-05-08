package com.mobile.auth.b;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36678a = "c";

    /* renamed from: b, reason: collision with root package name */
    private final int[] f36679b = {1732584193, -271733879, -1732584194, 271733878, -1009589776};

    /* renamed from: c, reason: collision with root package name */
    private int[] f36680c = new int[5];

    /* renamed from: d, reason: collision with root package name */
    private int[] f36681d = new int[80];

    private int a(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    private int a(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int a(byte[] bArr, int i10) {
        try {
            return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    private void a() {
        for (int i10 = 16; i10 <= 79; i10++) {
            try {
                int[] iArr = this.f36681d;
                iArr[i10] = a(((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16], 1);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return;
                }
            }
        }
        int[] iArr2 = new int[5];
        for (int i11 = 0; i11 < 5; i11++) {
            iArr2[i11] = this.f36680c[i11];
        }
        for (int i12 = 0; i12 <= 19; i12++) {
            int a10 = a(iArr2[0], 5) + a(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.f36681d[i12] + 1518500249;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a10;
        }
        for (int i13 = 20; i13 <= 39; i13++) {
            int a11 = a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.f36681d[i13] + 1859775393;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a11;
        }
        for (int i14 = 40; i14 <= 59; i14++) {
            int a12 = (((a(iArr2[0], 5) + c(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.f36681d[i14]) - 1894007588;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a12;
        }
        for (int i15 = 60; i15 <= 79; i15++) {
            int a13 = (((a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.f36681d[i15]) - 899497514;
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a13;
        }
        for (int i16 = 0; i16 < 5; i16++) {
            int[] iArr3 = this.f36680c;
            iArr3[i16] = iArr3[i16] + iArr2[i16];
        }
        int i17 = 0;
        while (true) {
            int[] iArr4 = this.f36681d;
            if (i17 >= iArr4.length) {
                return;
            }
            iArr4[i17] = 0;
            i17++;
        }
    }

    private void a(int i10, byte[] bArr, int i11) {
        try {
            bArr[i11] = (byte) (i10 >>> 24);
            bArr[i11 + 1] = (byte) (i10 >>> 16);
            bArr[i11 + 2] = (byte) (i10 >>> 8);
            bArr[i11 + 3] = (byte) i10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static byte[] a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                com.mobile.auth.a.a.a(f36678a, "when getHmacSHA1,the key is null");
                return null;
            }
            try {
                byte[] bArr = new byte[64];
                byte[] bArr2 = new byte[64];
                byte[] bArr3 = new byte[64];
                int length = str2.length();
                c cVar = new c();
                if (str2.length() > 64) {
                    byte[] a10 = cVar.a(e.b(str2));
                    length = a10.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        bArr3[i10] = a10[i10];
                    }
                } else {
                    byte[] b4 = e.b(str2);
                    for (int i11 = 0; i11 < b4.length; i11++) {
                        bArr3[i11] = b4[i11];
                    }
                }
                while (length < 64) {
                    bArr3[length] = 0;
                    length++;
                }
                for (int i12 = 0; i12 < 64; i12++) {
                    bArr[i12] = (byte) (bArr3[i12] ^ 54);
                    bArr2[i12] = (byte) (bArr3[i12] ^ 92);
                }
                return cVar.a(a(bArr2, cVar.a(a(bArr, e.b(str)))));
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36678a, "getHmacSHA1 error", th);
                return null;
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

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr3[i10] = bArr[i10];
            }
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                bArr3[bArr.length + i11] = bArr2[i11];
            }
            return bArr3;
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

    private int b(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public static String b(byte[] bArr) {
        try {
            StringBuilder sb2 = new StringBuilder("");
            if (bArr != null && bArr.length > 0) {
                for (byte b4 : bArr) {
                    String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.CHINA);
                    if (upperCase.length() < 2) {
                        sb2.append(0);
                    }
                    sb2.append(upperCase);
                }
                return sb2.toString();
            }
            return null;
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

    private int c(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    private int c(byte[] bArr) {
        try {
            int[] iArr = this.f36679b;
            System.arraycopy((Object) iArr, 0, (Object) this.f36680c, 0, iArr.length);
            byte[] d10 = d(bArr);
            int length = d10.length / 64;
            for (int i10 = 0; i10 < length; i10++) {
                for (int i11 = 0; i11 < 16; i11++) {
                    this.f36681d[i11] = a(d10, (i10 * 64) + (i11 * 4));
                }
                a();
            }
            return 20;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    private byte[] d(byte[] bArr) {
        int i10;
        int i11;
        try {
            int length = bArr.length;
            int i12 = length % 64;
            if (i12 < 56) {
                i10 = 55 - i12;
                i11 = (length - i12) + 64;
            } else if (i12 == 56) {
                i11 = length + 8 + 64;
                i10 = 63;
            } else {
                i10 = (63 - i12) + 56;
                i11 = ((length + 64) - i12) + 64;
            }
            byte[] bArr2 = new byte[i11];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, length);
            int i13 = length + 1;
            bArr2[length] = Byte.MIN_VALUE;
            int i14 = 0;
            while (i14 < i10) {
                bArr2[i13] = 0;
                i14++;
                i13++;
            }
            long j10 = length * 8;
            byte b4 = (byte) (j10 & 255);
            byte b10 = (byte) ((j10 >> 8) & 255);
            byte b11 = (byte) ((j10 >> 16) & 255);
            byte b12 = (byte) ((j10 >> 24) & 255);
            byte b13 = (byte) ((j10 >> 32) & 255);
            byte b14 = (byte) ((j10 >> 40) & 255);
            byte b15 = (byte) (255 & (j10 >> 48));
            byte b16 = (byte) (j10 >> 56);
            int i15 = i13 + 1;
            bArr2[i13] = b16;
            int i16 = i15 + 1;
            bArr2[i15] = b15;
            int i17 = i16 + 1;
            bArr2[i16] = b14;
            int i18 = i17 + 1;
            bArr2[i17] = b13;
            int i19 = i18 + 1;
            bArr2[i18] = b12;
            int i20 = i19 + 1;
            bArr2[i19] = b11;
            bArr2[i20] = b10;
            bArr2[i20 + 1] = b4;
            return bArr2;
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

    public byte[] a(byte[] bArr) {
        try {
            c(bArr);
            byte[] bArr2 = new byte[20];
            int i10 = 0;
            while (true) {
                int[] iArr = this.f36680c;
                if (i10 >= iArr.length) {
                    return bArr2;
                }
                a(iArr[i10], bArr2, i10 * 4);
                i10++;
            }
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
}
