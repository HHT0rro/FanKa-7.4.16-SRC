package com.inno.innosdk.utils;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: ToTuid.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p {
    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        for (int i10 = 2; i10 < 15; i10 += 2) {
            byte b4 = bytes[i10];
            int i11 = 32 - i10;
            bytes[i10] = bytes[i11];
            bytes[i11] = b4;
            int i12 = i10 + 1;
            byte b10 = bytes[i12];
            int i13 = i11 + 1;
            bytes[i12] = bytes[i13];
            bytes[i13] = b10;
        }
        byte[] b11 = b(new String(bytes, "utf-8"));
        if (b11 == null) {
            return null;
        }
        try {
            return new byte[]{b11[1], b11[2], b11[3], b11[6], b11[7], b11[8], b11[10], b11[11], b11[13], b11[14], b11[16], b11[17], b11[18], b11[20], b11[21], b11[23]};
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] b(String str) {
        try {
            return Base64.decode(str, 8);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        if (str.length() < 24) {
            return "";
        }
        int length = str.length();
        byte[] bArr = null;
        if (length != 24) {
            if (length != 32) {
                if (length != 34) {
                    if (!str.startsWith("AC") || str.length() <= 35) {
                        return "";
                    }
                    bArr = new byte[16];
                    byte[] b4 = b(str);
                    if (b4 != null) {
                        System.arraycopy((Object) b4, 2, (Object) bArr, 0, 16);
                    }
                } else if (str.startsWith("a")) {
                    try {
                        bArr = new byte[16];
                        byte[] b10 = b(str);
                        if (b10 != null) {
                            System.arraycopy((Object) b10, 1, (Object) bArr, 0, 16);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else if (str.startsWith(ExifInterface.GPS_DIRECTION_TRUE)) {
                try {
                    bArr = a(str);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } else if (str.startsWith("R")) {
            try {
                bArr = new byte[16];
                byte[] b11 = b(str);
                if (b11 != null) {
                    System.arraycopy((Object) b11, 1, (Object) bArr, 0, 16);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        return bArr != null ? a(bArr) : "";
    }

    public static String a(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 11);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
