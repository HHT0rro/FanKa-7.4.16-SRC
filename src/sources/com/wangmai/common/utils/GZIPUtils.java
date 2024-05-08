package com.wangmai.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GZIPUtils {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String TAG = "GZIP";

    public static String bytesToHexString(byte[] bArr) {
        try {
            StringBuffer stringBuffer = new StringBuffer(bArr.length);
            for (byte b4 : bArr) {
                String hexString = Integer.toHexString(b4 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString.toUpperCase());
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            DebugLog.release_e("TAG", "bytesToHexString:" + th.toString());
            return "";
        }
    }

    public static byte[] compress(String str) {
        return compress(str, "UTF-8");
    }

    public static byte[] unZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, 8192);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr3, 0, read);
                } else {
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return bArr2;
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e("TAG", "unZip:" + th.toString());
            return bArr2;
        }
    }

    public static String unZipStringToByte(byte[] bArr) {
        try {
            return new String(unZip(bArr), "utf-8");
        } catch (Throwable th) {
            DebugLog.release_e("TAG", "unZipStringToByte:" + th.toString());
            return "";
        }
    }

    public static byte[] zip(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th) {
            DebugLog.release_e("TAG", "zip:" + th.toString());
            return bArr2;
        }
    }

    public static byte[] compress(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "compress:" + th.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }
}
