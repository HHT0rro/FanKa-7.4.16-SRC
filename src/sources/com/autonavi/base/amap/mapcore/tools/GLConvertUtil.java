package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i10) {
        long j10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            j10 += (bArr[i11 + i10] & 255) << (i11 * 8);
        }
        return Double.longBitsToDouble(j10);
    }

    public static byte[] convertInt(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public static byte[] convertShort(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0);
    }

    public static int getInt2(byte[] bArr, int i10) {
        return ((bArr[i10 + 0] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + ((bArr[i10 + 3] & 255) << 0);
    }

    public static long getLong(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) + ((bArr[i10 + 6] & 255) << 48) + ((bArr[i10 + 5] & 255) << 40) + ((bArr[i10 + 4] & 255) << 32) + ((bArr[i10 + 3] & 255) << 24) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0);
    }

    public static short getShort(byte[] bArr, int i10) {
        return (short) (((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0));
    }

    public static short getShort2(byte[] bArr, int i10) {
        return (short) (((bArr[i10 + 0] & 255) << 8) + ((bArr[i10 + 1] & 255) << 0));
    }

    public static String getString(byte[] bArr, int i10, int i11) {
        try {
            return new String(bArr, i10, i11, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i11);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i10) {
        return ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        byte[] bArr3 = new byte[i12];
        System.arraycopy((Object) bArr, i10, (Object) bArr3, 0, i12);
        System.arraycopy((Object) bArr3, 0, (Object) bArr2, i11, i12);
    }

    public static void writeInt(byte[] bArr, int i10, int i11) {
        System.arraycopy((Object) convertInt(i11), 0, (Object) bArr, i10, 4);
    }

    public static void writeShort(byte[] bArr, int i10, short s2) {
        System.arraycopy((Object) convertShort(s2), 0, (Object) bArr, i10, 2);
    }
}
