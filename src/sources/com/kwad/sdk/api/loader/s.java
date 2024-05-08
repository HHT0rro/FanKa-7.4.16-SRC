package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class s {
    private static final char[] ani = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String getFileMD5(File file) {
        Throwable th;
        DigestInputStream digestInputStream;
        Exception e2;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
        } catch (Exception e10) {
            e2 = e10;
            digestInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            digestInputStream = null;
            b(digestInputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder(digest.length * 2);
                for (byte b4 : digest) {
                    int i10 = b4 & 255;
                    if (i10 < 16) {
                        sb2.append("0");
                    }
                    sb2.append(Integer.toHexString(i10));
                }
                String sb3 = sb2.toString();
                b(digestInputStream);
                return sb3;
            } catch (Throwable th3) {
                th = th3;
                b(digestInputStream);
                throw th;
            }
        } catch (Exception e11) {
            e2 = e11;
            e2.printStackTrace();
            b(digestInputStream);
            return "";
        }
    }
}
