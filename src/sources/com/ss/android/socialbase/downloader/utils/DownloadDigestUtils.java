package com.ss.android.socialbase.downloader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadDigestUtils {
    public static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] hexStringToBytes(String str) throws IllegalArgumentException {
        if (str != null && str.length() % 2 != 1) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length / 2];
            for (int i10 = 0; i10 < length; i10 += 2) {
                bArr[i10 / 2] = (byte) ((Character.digit(charArray[i10], 16) << 4) + Character.digit(charArray[i10 + 1], 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
    }

    public static String md5Hex(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                DownloadUtils.safeClose(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String hexString = toHexString(messageDigest.digest());
                        DownloadUtils.safeClose(fileInputStream);
                        return hexString;
                    }
                }
            } catch (Exception unused) {
                DownloadUtils.safeClose(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                DownloadUtils.safeClose(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String toHexString(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i10 >= 0 && i10 + i11 <= bArr.length) {
            int i12 = i11 * 2;
            char[] cArr = new char[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = bArr[i14 + i10] & 255;
                int i16 = i13 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i13] = cArr2[i15 >> 4];
                i13 = i16 + 1;
                cArr[i16] = cArr2[i15 & 15];
            }
            return new String(cArr, 0, i12);
        }
        throw new IndexOutOfBoundsException();
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String md5Hex(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String md5Hex(byte[] bArr, int i10, int i11) {
        if (bArr != null && i10 >= 0 && i11 > 0) {
            try {
                if (i10 + i11 <= bArr.length) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr, i10, i11);
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
