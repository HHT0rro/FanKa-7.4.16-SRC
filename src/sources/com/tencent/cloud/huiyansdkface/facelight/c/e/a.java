package com.tencent.cloud.huiyansdkface.facelight.c.e;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.SecureRandomStringUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a {
    public static String a() {
        try {
            String randomNumeric = SecureRandomStringUtils.randomNumeric(10);
            String randomAlphabetic = SecureRandomStringUtils.randomAlphabetic(6);
            int randomNum = SecureRandomStringUtils.randomNum(6);
            return randomAlphabetic.substring(0, randomNum) + randomNumeric + randomAlphabetic.substring(randomNum);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("AESEncryptUtil", "generateKey failed!" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_generate_key_fail", "generateKey failed!" + e2.toString(), null);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM), new IvParameterSpec("ItdzfwvGcrpuLlwz".getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec("ItdzfwvGcrpuLlwz".getBytes()));
        return cipher.doFinal(bArr);
    }
}
