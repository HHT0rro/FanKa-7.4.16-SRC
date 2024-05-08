package com.huawei.hianalytics.core.crypto;

import android.util.Pair;
import com.huawei.hianalytics.core.log.HiLog;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AesCipher {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f28735a = Charset.forName("UTF-8");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AesLen {
        public static final int AES_128_C_BC_IV_LEN = 32;
        public static final int AES_128_C_BC_KEY_LEN = 16;
        public static final int AES_GCM_IV_LEN = 12;
        public static final int ROOTKEY_COMPONET_LEN = 128;
    }

    public static String decryptCbc(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null) {
            byte[] hexString2ByteArray = HexUtil.hexString2ByteArray(str2);
            if (hexString2ByteArray.length < 16) {
                HiLog.e("AesCipher", "key length is not right");
                return "";
            }
            Pair<byte[], String> splitIvAndMsg = splitIvAndMsg(str);
            return new String(sa.a.i(HexUtil.hexString2ByteArray((String) splitIvAndMsg.second), hexString2ByteArray, (byte[]) splitIvAndMsg.first), f28735a);
        }
        HiLog.e("AesCipher", "cbc decrypt param is not right");
        return "";
    }

    public static String encryptCbc(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null) {
            byte[] hexString2ByteArray = HexUtil.hexString2ByteArray(str2);
            if (hexString2ByteArray.length < 16) {
                HiLog.e("AesCipher", "key length is not right");
                return "";
            }
            return HexUtil.byteArray2HexString(sa.a.l(str.getBytes(f28735a), hexString2ByteArray));
        }
        HiLog.e("AesCipher", "cbc encrypt param is not right");
        return "";
    }

    public static String getEncryptWord(String str) {
        return (str == null || str.length() < 24) ? "" : str.substring(24);
    }

    public static String getGCMIv(String str) {
        if (str != null && str.length() >= 24) {
            return str.substring(0, 24);
        }
        HiLog.e("AesCipher", "IV is invalid.");
        return "";
    }

    public static Pair<byte[], String> splitIvAndMsg(String str) {
        if (str != null && str.length() >= 32) {
            String substring = str.substring(0, 32);
            return new Pair<>(HexUtil.hexString2ByteArray(substring), str.substring(32));
        }
        return new Pair<>(new byte[0], str);
    }

    public static String encryptCbc(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0 && str != null) {
            byte[] hexString2ByteArray = HexUtil.hexString2ByteArray(str);
            if (hexString2ByteArray.length < 16) {
                HiLog.e("AesCipher", "key length is not right");
                return "";
            }
            return HexUtil.byteArray2HexString(sa.a.l(bArr, hexString2ByteArray));
        }
        HiLog.e("AesCipher", "cbc encrypt(byte) param is not right");
        return "";
    }
}
