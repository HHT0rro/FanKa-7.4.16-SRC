package com.alibaba.security.common.utils;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class DESCoderUtils {
    public static final String ALGORITHM = "DES/CBC/PKCS5Padding";
    public static final String SECRETFACTORY_ALGORITHM = "DES";

    public static byte[] decrypt(byte[] bArr, String str) throws Exception {
        Key key = toKey(decryptBASE64(str));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        byte[] bArr2 = new byte[8];
        for (int i10 = 0; i10 < 8 && i10 < str.getBytes().length; i10++) {
            bArr2[i10] = str.getBytes()[i10];
        }
        cipher.init(2, key, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptBASE64(String str) {
        return Base64.decode(str, 0);
    }

    public static byte[] encrypt(byte[] bArr, String str) throws Exception {
        Key key = toKey(decryptBASE64(str));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        byte[] bArr2 = new byte[8];
        for (int i10 = 0; i10 < 8 && i10 < str.getBytes().length; i10++) {
            bArr2[i10] = str.getBytes()[i10];
        }
        cipher.init(1, key, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }

    public static String encryptBASE64(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    @Deprecated
    public static String initKey() throws Exception {
        return initKey(null);
    }

    private static Key toKey(byte[] bArr) throws Exception {
        return SecretKeyFactory.getInstance(SECRETFACTORY_ALGORITHM).generateSecret(new DESKeySpec(bArr));
    }

    public static String initKey(String str) throws Exception {
        return encryptBASE64(SecretKeyFactory.getInstance(SECRETFACTORY_ALGORITHM).generateSecret(new DESKeySpec(str.getBytes())).getEncoded());
    }
}
