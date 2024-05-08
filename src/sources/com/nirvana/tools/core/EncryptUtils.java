package com.nirvana.tools.core;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EncryptUtils {
    private static final String CipherMode = "AES/CBC/PKCS7Padding";
    public static final String IV_PARAMETER_SPEC = "0000000000000000";

    private static IvParameterSpec createIV(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = " ";
        }
        try {
            bArr = stringBuffer.substring(0, 16).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new IvParameterSpec(bArr);
    }

    private static SecretKeySpec createKey(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
    }

    public static String decrypt(String str, String str2) {
        try {
            return decryptBase642String(str, str2, "0000000000000000");
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    public static byte[] decryptBase642Byte(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = Base64.decode(str, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return decryptByte2Byte(bArr, str2, str3);
    }

    public static String decryptBase642String(String str, String str2, String str3) {
        return decryptByte2String(Base64.decode(str, 0), str2, str3);
    }

    public static byte[] decryptByte2Byte(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec createKey = createKey(str);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(2, createKey, createIV(str2));
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String decryptByte2String(byte[] bArr, String str, String str2) {
        return new String(decryptByte2Byte(bArr, str, str2));
    }

    public static byte[] decryptString2Byte(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return decryptByte2Byte(bArr, str2, str3);
    }

    public static String encrypt(String str, String str2) {
        try {
            return encryptString2Base64(str, str2, "0000000000000000");
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    public static String encryptByte2Base64(byte[] bArr, String str, String str2) {
        return new String(Base64.encode(encryptByte2Byte(bArr, str, str2), 0));
    }

    public static byte[] encryptByte2Byte(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec createKey = createKey(str);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(1, createKey, createIV(str2));
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encryptByte2String(byte[] bArr, String str, String str2) {
        return new String(encryptByte2Byte(bArr, str, str2));
    }

    public static String encryptString2Base64(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new String(Base64.encode(encryptByte2Byte(bArr, str2, str3), 0));
    }

    public static byte[] encryptString2Byte(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return encryptByte2Byte(bArr, str2, str3);
    }

    public static String encryptString2String(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new String(encryptByte2Byte(bArr, str2, str3));
    }
}
