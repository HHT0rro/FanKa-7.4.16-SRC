package com.kuaishou.weapon.p0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = a(bytes[i11], bytes[i11 + 1]);
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b4 : bArr) {
            stringBuffer.append((char) b4);
        }
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String str2 = "";
        for (int i10 = 0; i10 < str.length(); i10++) {
            String hexString = Integer.toHexString(str.charAt(i10) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a10 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i10 = (i10 + 1) & 255;
            i11 = ((a10[i10] & 255) + i11) & 255;
            byte b4 = a10[i10];
            a10[i10] = a10[i11];
            a10[i11] = b4;
            int i13 = ((a10[i10] & 255) + (a10[i11] & 255)) & 255;
            bArr2[i12] = (byte) (a10[i13] ^ bArr[i12]);
        }
        return bArr2;
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr[i10] = (byte) i10;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            i12 = ((bytes[i11] & 255) + (bArr[i13] & 255) + i12) & 255;
            byte b4 = bArr[i13];
            bArr[i13] = bArr[i12];
            bArr[i12] = b4;
            i11 = (i11 + 1) % bytes.length;
        }
        return bArr;
    }

    private static byte a(byte b4, byte b10) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b4})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b10})).byteValue()));
    }
}
