package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fq {
    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(fv.c("ETUQ1"));
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            gv.a(th, "MD5", "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    gv.a(e2, "MD5", "gfm");
                                }
                            }
                        }
                    }
                }
                String e10 = fv.e(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                    gv.a(e11, "MD5", "gfm");
                }
                return e10;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return fv.e(d(str));
    }

    public static String c(String str) {
        return fv.f(e(str));
    }

    private static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            gv.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(fv.c("ETUQ1"));
        messageDigest.update(fv.a(str));
        return messageDigest.digest();
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            gv.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return fv.e(a(bArr, fv.c("ETUQ1")));
    }
}
