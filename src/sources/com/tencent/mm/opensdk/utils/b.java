package com.tencent.mm.opensdk.utils;

import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static final String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i10 = 0;
            for (byte b4 : digest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b4 >>> 4) & 15];
                i10 = i11 + 1;
                cArr2[i11] = cArr[b4 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
