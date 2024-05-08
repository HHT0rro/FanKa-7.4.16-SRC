package com.wangmai.common.utils;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AesUtil {
    public static final String TAG = "WM_AesUtil";
    public static String encodingFormat = "utf-8";
    public static String ivParameter = "";
    public static String sKey = "";

    public static String decrypt(String str, String str2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String md5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes("ASCII"), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes()));
            String str3 = new String(cipher.doFinal(parseHexStr2Byte(str)), encodingFormat);
            DebugLog.release_w(TAG, "解密耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            return str3;
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "decrypt exception:" + th.toString());
            return "";
        }
    }

    public static String decryptByte(byte[] bArr, String str) {
        try {
            String md5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes("ASCII"), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes()));
            return new String(cipher.doFinal(bArr), encodingFormat);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "decryptByte exception:" + th.toString());
            return "";
        }
    }

    public static byte[] decryptToByte(byte[] bArr, String str) {
        try {
            String md5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes("ASCII"), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes("ASCII")));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "decryptToByte exception:" + th.toString());
            return new byte[0];
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            String md5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), AESEncrypt.ALGORITHM), new IvParameterSpec(ivParameter.getBytes()));
            return parseByte2HexStr(cipher.doFinal(str.getBytes(encodingFormat)));
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "encrypt exception:" + th.toString());
            return "";
        }
    }

    public static byte[] encryptByt(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            String md5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), AESEncrypt.ALGORITHM), new IvParameterSpec(ivParameter.getBytes()));
            return cipher.doFinal(str.getBytes(encodingFormat));
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "encryptByt-str exception:" + th.toString());
            return bArr;
        }
    }

    public static String md5Decode(String str) {
        try {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                StringBuilder sb2 = new StringBuilder(digest.length * 2);
                for (byte b4 : digest) {
                    int i10 = b4 & 255;
                    if (i10 < 16) {
                        sb2.append("0");
                    }
                    sb2.append(Integer.toHexString(i10));
                }
                return sb2.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UnsupportedEncodingException", e2);
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException("NoSuchAlgorithmException", e10);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "md5 hash error:" + th.toString());
            return "";
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr != null) {
            for (byte b4 : bArr) {
                String hexString = Integer.toHexString(b4 & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                stringBuffer.append(hexString.toUpperCase());
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i10 = 0; i10 < str.length() / 2; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            bArr[i10] = (byte) ((Integer.parseInt(str.substring(i11, i12), 16) * 16) + Integer.parseInt(str.substring(i12, i11 + 2), 16));
        }
        return bArr;
    }

    public static byte[] encryptByt(byte[] bArr, String str) {
        try {
            String md5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(md5Decode) && md5Decode.length() > 16) {
                sKey = md5Decode.substring(0, 16);
                ivParameter = md5Decode.substring(16, md5Decode.length());
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), AESEncrypt.ALGORITHM), new IvParameterSpec(ivParameter.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "encryptByt-byte exception:" + th.toString());
            return new byte[0];
        }
    }
}
