package com.kwad.sdk.core.a;

import com.alicom.tools.networking.RSA;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private static byte[] a(byte[] bArr, byte[] bArr2, int i10) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance(RSA.AES_ALGORITHM);
            cipher.init(i10, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.finish();
                    gZIPOutputStream.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream2);
            throw th;
        }
    }

    public static byte[] f(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                e(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] g(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                f(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        return a(str.getBytes(UTF_8), bArr, 2);
    }

    private static void f(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream2);
            throw th;
        }
    }
}
