package com.autonavi.base.amap.mapcore;

import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Convert {
    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void convert1bString(byte[] bArr, int i10, ConvertString convertString) {
        try {
            byte b4 = bArr[i10];
            convertString.byteLength = b4;
            convertString.value = new String(bArr, i10 + 1, b4, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void convert2bString(byte[] bArr, int i10, ConvertString convertString) {
        try {
            short s2 = getShort(bArr, i10);
            convertString.byteLength = s2;
            convertString.value = new String(bArr, i10 + 2, s2, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

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

    public static byte[] copyString(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i11);
        return bArr2;
    }

    public static byte[] covertBytes(byte b4) {
        return new byte[]{b4};
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

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b4, int i10) {
        int i11 = 32 - i10;
        return (((b4 << i11) >>> i11) >>> (i10 - 1)) > 0;
    }

    public static byte[] getDouble(double d10) {
        byte[] bArr = new byte[8];
        String hexString = Long.toHexString(Double.doubleToLongBits(d10));
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = i10 * 2;
            bArr[7 - i10] = (byte) Integer.parseInt(hexString.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0);
    }

    public static int getNum(byte b4, int i10, int i11) {
        int i12 = (32 - i11) - 1;
        return ((b4 << i12) >>> i12) >>> i10;
    }

    public static int getNum(short s2, int i10, int i11) {
        int i12 = 32 - i11;
        return ((s2 << i12) >>> i12) >>> (i10 - 1);
    }

    public static short getShort(byte[] bArr, int i10) {
        return (short) (((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 0] & 255) << 0));
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
