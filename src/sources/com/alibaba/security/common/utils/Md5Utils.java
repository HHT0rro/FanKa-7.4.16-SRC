package com.alibaba.security.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Md5Utils {
    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(128);
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private static String digest(byte[] bArr, String str) {
        return bytesToHexString(digest2byte(bArr, str));
    }

    private static byte[] digest2byte(byte[] bArr, String str) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static String md5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String md5Base64(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String md5File(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String replace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                            return replace;
                        } catch (IOException unused) {
                            return null;
                        }
                    }
                } catch (IOException unused2) {
                    fileInputStream.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (IOException unused3) {
                        return null;
                    }
                }
            }
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused4) {
        }
    }

    public static String md5Str(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 16; i10++) {
                sb2.append(String.format("%02x", Byte.valueOf(digest[i10])));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String md5ToHex(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return digest(str.getBytes("utf-8"), "MD5");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String md5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return md5(str.getBytes("UTF-8"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
