package com.alibaba.security.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AESUtils {
    private static final String ALGORITHM = "AES";
    private static final String CHARSET = "UTF-8";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public static byte[] encrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return bArr;
        } catch (InvalidKeyException e10) {
            e10.printStackTrace();
            return bArr;
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return bArr;
        } catch (BadPaddingException e12) {
            e12.printStackTrace();
            return bArr;
        } catch (IllegalBlockSizeException e13) {
            e13.printStackTrace();
            return bArr;
        } catch (NoSuchPaddingException e14) {
            e14.printStackTrace();
            return bArr;
        }
    }
}
