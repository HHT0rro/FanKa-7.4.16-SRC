package com.huawei.appgallery.agd.common.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ByteUtil {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f27375a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f27376b = 0;

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b4 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b4 >>> 4) & 15];
            i10 = i11 + 1;
            cArr2[i11] = cArr[b4 & 15];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cArr2);
        return sb2.toString();
    }

    public static byte[] hexToBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int digit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i10] = (byte) digit;
        }
        return bArr;
    }

    public int getSize() {
        return this.f27376b;
    }

    public String getString() {
        int i10 = this.f27376b;
        if (i10 <= 0) {
            return null;
        }
        try {
            return new String(this.f27375a, 0, i10, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
