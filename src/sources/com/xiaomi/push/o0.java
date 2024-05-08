package com.xiaomi.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o0 {
    public static String a(byte b4) {
        int i10 = (b4 & Byte.MAX_VALUE) + (b4 < 0 ? 128 : 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10 < 16 ? "0" : "");
        sb2.append(Integer.toHexString(i10).toLowerCase());
        return sb2.toString();
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b4 : messageDigest.digest()) {
                stringBuffer.append(a(b4));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String c(String str) {
        return b(str).subSequence(8, 24).toString();
    }
}
