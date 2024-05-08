package com.danlan.android.cognition.common;

import com.danlan.android.cognition.StringFog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HashUtil {
    public static String md5(byte[] bArr) {
        int i10;
        StringBuffer stringBuffer = new StringBuffer();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(StringFog.decrypt("bGcR"));
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (int i11 = 0; i11 < digest.length; i11++) {
                if (Integer.toHexString(digest[i11] & 255).length() == 1) {
                    stringBuffer.append(StringFog.decrypt("EQ=="));
                    i10 = digest[i11] & 255;
                } else {
                    i10 = digest[i11] & 255;
                }
                stringBuffer.append(Integer.toHexString(i10));
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return messageDigest != null ? stringBuffer.toString() : "";
    }
}
