package com.kwad.sdk.pngencrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n {
    public static Charset aLC = Charset.forName(CharEncoding.ISO_8859_1);
    public static Charset aLD = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> aLE = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        private static Boolean Ke() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Boolean initialValue() {
            return Ke();
        }
    };

    public static byte[] Kd() {
        return new byte[]{-119, 80, 78, 71, 13, 10, Character.CURRENCY_SYMBOL, 10};
    }

    public static final int b(int i10, int i11, int i12) {
        int i13 = (i10 + i11) - i12;
        int i14 = i13 >= i10 ? i13 - i10 : i10 - i13;
        int i15 = i13 >= i11 ? i13 - i11 : i11 - i13;
        int i16 = i13 >= i12 ? i13 - i12 : i12 - i13;
        return (i14 > i15 || i14 > i16) ? i15 <= i16 ? i11 : i12 : i10;
    }

    public static int e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return -1;
        }
    }

    public static int f(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                return -1;
            }
            return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return -1;
        }
    }

    public static final int g(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static int e(byte[] bArr, int i10) {
        return bArr[i10] & 255;
    }

    public static int f(byte[] bArr, int i10) {
        return (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
    }
}
