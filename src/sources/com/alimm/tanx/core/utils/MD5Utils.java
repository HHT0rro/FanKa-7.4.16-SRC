package com.alimm.tanx.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MD5Utils implements NotConfused {
    public static final String ALGORIGTHM_MD5 = "MD5";
    public static final String EMPTY_CONTENT_MD5 = "d41d8cd98f00b204e9800998ecf8427e";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void appendHexPair(byte b4, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c4 = cArr[(b4 & 240) >> 4];
        char c10 = cArr[b4 & 15];
        stringBuffer.append(c4);
        stringBuffer.append(c10);
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static String getFileMD5String(File file) throws IOException {
        MessageDigest mD5Digest = getMD5Digest();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                mD5Digest.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return bytesToHex(mD5Digest.digest());
            }
        }
    }

    public static String getFilePathMD5String(String str) {
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static MessageDigest getMD5Digest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String getMD5String(String str) {
        return str == null ? "" : getMD5String(str.getBytes());
    }

    public static String bytesToHex(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11 * 2);
        int i12 = i11 + i10;
        while (i10 < i12) {
            appendHexPair(bArr[i10], stringBuffer);
            i10++;
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(byte[] bArr) {
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr);
        return bytesToHex(mD5Digest.digest());
    }

    public static String getMD5String(byte[] bArr, int i10, int i11) {
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr, i10, i11);
        return bytesToHex(mD5Digest.digest());
    }
}
