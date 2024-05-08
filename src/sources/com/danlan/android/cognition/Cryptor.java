package com.danlan.android.cognition;

import android.text.TextUtils;
import android.util.Base64;
import com.danlan.android.cognition.common.ByteTransformUtils;
import com.danlan.android.security.AesCryptor;
import java.io.ObjectStreamConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Cryptor {
    public static final String ENC_KEY = StringFog.decrypt("RRcWR0UXQBUXGh1BQEYVQhhBQkdHF0cRRxRHFENAHEUXQkZAREBGREJHRRcRGxAWRUISEBZHEhIWFRdBGBIQFREWEEUZEh0SFRQUR0URExNFRkcUREARQkBGRUAZEkIQGREUF0caQBgVQhEQExZAEkUXFRQVGkIXQhRBG0IXRhEYR0dBQhdHFxUbR0ARQBNHRRoWRhAWEERDQRYRFEISEhFBFRFEQBFDFBJFFxhHQUNCExQSGUYdRBhGQEBAR0ETQBsUFkIVFRARFkIWFkUUR0UTFRIQEhMQGBpFFxIXQEIRERAVEEJFFRcSRxdAQh0ZEBVFEkRBRxEUFBcUEUVCERgURkBHQEVDEhdHERcXHUQVQEJFEhNCQkNCHEcUGx0VQ0ASEUVBFUJCFhIbF0IVFkcRRxZAEB1HERdCGxlAEEIWEhAUERVAQBMSRkISExAWEUIcGxMRERgQQBwUGEAdRBkWQBARRRRH");
    public static final String DEC_KEY = StringFog.decrypt("EBATRxRHFRMYFB1BEEUSEhESRxoRGkJHFhITGxMbHBZCEkBBFhtFEBUWFBQVFUVAGBVCGxlAFBRCG0ESRBcVRBVAHRsYFxJAQkUcEkMTHBEXEB1HFEUREhcbFkASExcYR0AcEhhFERRDFxcaRRocFhVFHBRARUcVEBMTExAVHREURRZBFhoRERkSRRUTFEBFRBdCQBkaExVCGhZBGUJAFEVBHBQUEEdFERBBRxFBExlCRhBCRxZAFhEWExASEEUTR0cTE0JGRkcTRxFAREBHGEIRFxIYEhJHExUTQUUXEEIUFxcaFxsVEUBHEBBDQR1CQhtCRUUQQhESQEERRUUTExcTFBIXEBYYFRcQExQSQhQSFEYVRBBHF0BGR0JAFhZHGREVQhkVFUMQQRcXRBFFQBhCQUAREEIXERsTRUIaQkNCQRcSQhpCRRdCFhIURhVEEkFBERMUFRURRhEbEBcUQBdBHUISExcU");
    public static final String APPKEY = StringFog.decrypt("RUUUQQ==").toLowerCase();

    private static void appendHex(StringBuffer stringBuffer, byte b4) {
        stringBuffer.append(StringFog.decrypt("ERIWEBUWEhYZGmVhYmdhZw==").charAt((b4 >> 4) & 15));
        stringBuffer.append(StringFog.decrypt("ERIWEBUWEhYZGmVhYmdhZw==").charAt(b4 & 15));
    }

    private static byte[] createIV() {
        Random random = new Random();
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) (random.nextInt(256) - 128);
        }
        return bArr;
    }

    public static String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 2);
        String lowerCase = ByteTransformUtils.byte2HexStr(decode, 0, decode.length).toLowerCase();
        String str2 = APPKEY;
        if (lowerCase.startsWith(str2)) {
            lowerCase = lowerCase.substring(str2.length());
        }
        int parseInt = Integer.parseInt(str2.substring(0, 1), 16);
        int i10 = parseInt + 32;
        return new String(AesCryptor.aesDecryptByteArry(toByte(lowerCase.substring(0, parseInt) + lowerCase.substring(i10)), DEC_KEY, ByteTransformUtils.hexStr2Bytes(lowerCase.substring(parseInt, i10))));
    }

    public static String decrypt2(String str) {
        String decrypt = StringFog.decrypt("GXVpSm1CFk9SVUplExZVRQ==");
        byte[] bArr = {57, 48, ObjectStreamConstants.TC_OBJECT, 100, 97, 102, 106, 107, 100, 107, 106, 100, 107, 106, 101, 107};
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decrypt.getBytes(StandardCharsets.UTF_8), 0, decrypt.getBytes(StandardCharsets.UTF_8).length, StringFog.decrypt("YGZ3"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher cipher = Cipher.getInstance(StringFog.decrypt("YGZ3DGJhZw5xaGdwFHNFRUVKSkQ="));
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 2)), StringFog.decrypt("VFdCDhk="));
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str) {
        byte[] createIV = createIV();
        String str2 = "";
        try {
            String hex = toHex(AesCryptor.aesEncryptByteArry(str.getBytes(StringFog.decrypt("VFdCDhk=")), ENC_KEY, createIV));
            String hex2 = toHex(createIV);
            String str3 = APPKEY;
            int parseInt = Integer.parseInt(str3.substring(0, 1), 16);
            str2 = str3 + hex.substring(0, parseInt) + hex2 + hex.substring(parseInt);
            return Base64.encodeToString(ByteTransformUtils.hexStr2Bytes(str2), 2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String encrypt2(String str) {
        String decrypt = StringFog.decrypt("GXVpSm1CFk9SVUplExZVRQ==");
        byte[] bArr = {57, 48, ObjectStreamConstants.TC_OBJECT, 100, 97, 102, 106, 107, 100, 107, 106, 100, 107, 106, 101, 107};
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decrypt.getBytes(StandardCharsets.UTF_8), 0, decrypt.getBytes(StandardCharsets.UTF_8).length, StringFog.decrypt("YGZ3"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher cipher = Cipher.getInstance(StringFog.decrypt("YGZ3DGJhZw5xaGdwFHNFRUVKSkQ="));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = Integer.valueOf(str.substring(i11, i11 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            appendHex(stringBuffer, b4);
        }
        return stringBuffer.toString();
    }
}
