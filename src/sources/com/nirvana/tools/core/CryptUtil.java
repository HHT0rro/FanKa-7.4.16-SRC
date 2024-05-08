package com.nirvana.tools.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CryptUtil {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] defaultIV = {48, 48, 48, 48, 48, 48, 48, 48};
    private static final String desAlgorithm = "DESede/CBC/NoPadding";
    private static final String desKeyAlgorithm = "DESede";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Base64 {
        private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, -1, -1, -1, -1, -1, -1, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

        private Base64() {
        }

        public static byte[] decode(String str) {
            int i10;
            byte b4;
            int i11;
            byte b10;
            int i12;
            byte b11;
            int i13;
            byte b12;
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            int i14 = 0;
            while (i14 < length) {
                while (true) {
                    i10 = i14 + 1;
                    b4 = base64DecodeChars[bytes[i14]];
                    if (i10 >= length || b4 != -1) {
                        break;
                    }
                    i14 = i10;
                }
                if (b4 == -1) {
                    break;
                }
                while (true) {
                    i11 = i10 + 1;
                    b10 = base64DecodeChars[bytes[i10]];
                    if (i11 >= length || b10 != -1) {
                        break;
                    }
                    i10 = i11;
                }
                if (b10 == -1) {
                    break;
                }
                byteArrayOutputStream.write((b4 << 2) | ((b10 & 48) >>> 4));
                while (true) {
                    i12 = i11 + 1;
                    byte b13 = bytes[i11];
                    if (b13 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    b11 = base64DecodeChars[b13];
                    if (i12 >= length || b11 != -1) {
                        break;
                    }
                    i11 = i12;
                }
                if (b11 == -1) {
                    break;
                }
                byteArrayOutputStream.write(((b10 & 15) << 4) | ((b11 & 60) >>> 2));
                while (true) {
                    i13 = i12 + 1;
                    byte b14 = bytes[i12];
                    if (b14 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    b12 = base64DecodeChars[b14];
                    if (i13 >= length || b12 != -1) {
                        break;
                    }
                    i12 = i13;
                }
                if (b12 == -1) {
                    break;
                }
                byteArrayOutputStream.write(b12 | ((b11 & 3) << 6));
                i14 = i13;
            }
            return byteArrayOutputStream.toByteArray();
        }

        public static String encode(byte[] bArr) {
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                int i12 = bArr[i10] & 255;
                if (i11 == length) {
                    stringBuffer.append(base64EncodeChars[i12 >>> 2]);
                    stringBuffer.append(base64EncodeChars[(i12 & 3) << 4]);
                    str = "==";
                } else {
                    int i13 = i11 + 1;
                    int i14 = bArr[i11] & 255;
                    if (i13 == length) {
                        stringBuffer.append(base64EncodeChars[i12 >>> 2]);
                        stringBuffer.append(base64EncodeChars[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                        stringBuffer.append(base64EncodeChars[(i14 & 15) << 2]);
                        str = "=";
                    } else {
                        int i15 = i13 + 1;
                        int i16 = bArr[i13] & 255;
                        stringBuffer.append(base64EncodeChars[i12 >>> 2]);
                        stringBuffer.append(base64EncodeChars[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                        stringBuffer.append(base64EncodeChars[((i14 & 15) << 2) | ((i16 & 192) >>> 6)]);
                        stringBuffer.append(base64EncodeChars[i16 & 63]);
                        i10 = i15;
                    }
                }
                stringBuffer.append(str);
                break;
            }
            return stringBuffer.toString();
        }
    }

    private static IvParameterSpec IvGenerator(byte[] bArr) {
        return new IvParameterSpec(bArr);
    }

    private static SecretKey KeyGenerator(String str) throws Exception {
        return new SecretKeySpec(md5Hex(str).substring(0, 24).getBytes("UTF-8"), desKeyAlgorithm);
    }

    public static byte[] cryptBy3Des(String str, int i10, byte[] bArr, byte[] bArr2) throws Exception {
        SecretKey KeyGenerator = KeyGenerator(str);
        IvParameterSpec IvGenerator = bArr == null ? IvGenerator(defaultIV) : IvGenerator(bArr);
        Cipher cipher = Cipher.getInstance(desAlgorithm);
        cipher.init(i10, KeyGenerator, IvGenerator);
        return cipher.doFinal(bArr2);
    }

    public static byte[] decryptBy3Des(byte[] bArr, String str) throws Exception {
        return cryptBy3Des(str, 2, null, bArr);
    }

    public static String decryptBy3DesAndBase64(String str, String str2) throws Exception {
        return decryptBy3DesAndBase64(str, str2, "UTF-8");
    }

    public static String decryptBy3DesAndBase64(String str, String str2, String str3) throws Exception {
        return new String(decryptBy3Des(Base64.decode(str), str2), str3).trim();
    }

    public static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i10 + 1;
            char[] cArr2 = DIGITS;
            cArr[i10] = cArr2[(bArr[i11] & 240) >>> 4];
            i10 = i12 + 1;
            cArr[i12] = cArr2[bArr[i11] & 15];
        }
        return cArr;
    }

    public static byte[] encryptBy3Des(byte[] bArr, String str) throws Exception {
        return cryptBy3Des(str, 1, null, bArr);
    }

    public static String encryptBy3DesAndBase64(String str, String str2) throws Exception {
        return encryptBy3DesAndBase64(str, str2, "UTF-8");
    }

    public static String encryptBy3DesAndBase64(String str, String str2, String str3) throws Exception {
        int length = str.getBytes(str3).length % 8;
        if (length != 0) {
            int i10 = 8 - length;
            StringBuffer stringBuffer = new StringBuffer(str);
            for (int i11 = 0; i11 < i10; i11++) {
                stringBuffer.append(' ');
            }
            str = new String(stringBuffer);
        }
        return Base64.encode(encryptBy3Des(str.getBytes(str3), str2)).replaceAll("[\\n\\r]", "");
    }

    public static String md5Hex(String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes("UTF-8"));
        return new String(encodeHex(messageDigest.digest()));
    }
}
