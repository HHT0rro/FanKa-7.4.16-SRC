package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ce {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return ci.e(c(str));
    }

    public static String b(String str) {
        return ci.f(d(str));
    }

    private static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            dc.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(ci.c("ETUQ1"));
        messageDigest.update(ci.a(str));
        return messageDigest.digest();
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            dc.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return ci.e(a(bArr, ci.c("ETUQ1")));
    }
}
