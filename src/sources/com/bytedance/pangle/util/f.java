package com.bytedance.pangle.util;

import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f10994a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        int length;
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                if (digest == null || (length = digest.length) <= 0) {
                    return null;
                }
                char[] cArr = new char[length << 1];
                int i10 = 0;
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = i10 + 1;
                    char[] cArr2 = f10994a;
                    cArr[i10] = cArr2[(digest[i11] >>> 4) & 15];
                    i10 = i12 + 1;
                    cArr[i12] = cArr2[digest[i11] & 15];
                }
                return new String(cArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
