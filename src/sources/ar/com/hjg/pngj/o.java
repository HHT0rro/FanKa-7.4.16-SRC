package ar.com.hjg.pngj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: PngHelperInternal.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f1196a = Logger.getLogger("ar.com.pngj");

    /* renamed from: b, reason: collision with root package name */
    public static String f1197b = CharEncoding.ISO_8859_1;

    /* renamed from: c, reason: collision with root package name */
    public static Charset f1198c = Charset.forName(CharEncoding.ISO_8859_1);

    /* renamed from: d, reason: collision with root package name */
    public static String f1199d = "UTF-8";

    /* renamed from: e, reason: collision with root package name */
    public static Charset f1200e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    public static ThreadLocal<Boolean> f1201f = new a();

    /* compiled from: PngHelperInternal.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends ThreadLocal<Boolean> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static final int a(int i10, int i11, int i12) {
        int i13 = (i10 + i11) - i12;
        int i14 = i13 >= i10 ? i13 - i10 : i10 - i13;
        int i15 = i13 >= i11 ? i13 - i11 : i11 - i13;
        int i16 = i13 >= i12 ? i13 - i12 : i12 - i13;
        return (i14 > i15 || i14 > i16) ? i15 <= i16 ? i11 : i12 : i10;
    }

    public static byte[] b() {
        return new byte[]{-119, 80, 78, 71, 13, 10, Character.CURRENCY_SYMBOL, 10};
    }

    public static double c(int i10) {
        return i10 / 100000.0d;
    }

    public static InputStream d(File file) {
        try {
            return new FileInputStream(file);
        } catch (Exception e2) {
            throw new PngjInputException("Could not open " + ((Object) file), e2);
        }
    }

    public static int e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e2) {
            throw new PngjInputException("error reading byte", e2);
        }
    }

    public static int f(byte[] bArr, int i10) {
        return bArr[i10] & 255;
    }

    public static int g(byte[] bArr, int i10) {
        return (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
    }

    public static int h(InputStream inputStream) {
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
            throw new PngjInputException("error reading Int4", e2);
        }
    }

    public static final int i(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static void j(OutputStream outputStream, byte[] bArr) {
        try {
            outputStream.write(bArr);
        } catch (IOException e2) {
            throw new PngjOutputException(e2);
        }
    }

    public static void k(OutputStream outputStream, byte[] bArr, int i10, int i11) {
        try {
            outputStream.write(bArr, i10, i11);
        } catch (IOException e2) {
            throw new PngjOutputException(e2);
        }
    }

    public static void l(OutputStream outputStream, int i10) {
        byte[] bArr = new byte[4];
        m(i10, bArr, 0);
        j(outputStream, bArr);
    }

    public static void m(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) ((i10 >> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
    }
}
