package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.io.ObjectStreamConstants;
import okio.Utf8;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f10246a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, ObjectStreamConstants.TC_CLASSDESC, 53, 102, ObjectStreamConstants.TC_BLOCKDATA, 105, 72, 82, 78, ObjectStreamConstants.TC_RESET, 103, 109, ObjectStreamConstants.TC_ARRAY, 112, 85, 84, 73, 88, ObjectStreamConstants.TC_ENDBLOCKDATA, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, ObjectStreamConstants.TC_OBJECT, 107, ObjectStreamConstants.TC_BLOCKDATALONG, 49, 89, 100, ObjectStreamConstants.TC_CLASS, 76, 51, 52, 108, 101, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_REFERENCE, 83, 79};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f10247b = new byte[128];

    static {
        int i10 = 0;
        while (true) {
            byte[] bArr = f10246a;
            if (i10 >= bArr.length) {
                return;
            }
            f10247b[bArr[i10]] = (byte) i10;
            i10++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] c(String str) {
        byte[] bArr;
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length() - 4) {
            byte[] bArr2 = f10247b;
            byte b4 = bArr2[str.charAt(i10)];
            byte b10 = bArr2[str.charAt(i10 + 1)];
            byte b11 = bArr2[str.charAt(i10 + 2)];
            byte b12 = bArr2[str.charAt(i10 + 3)];
            bArr[i11] = (byte) ((b4 << 2) | (b10 >> 4));
            bArr[i11 + 1] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr[i11 + 2] = (byte) (b12 | (b11 << 6));
            i10 += 4;
            i11 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte[] bArr3 = f10247b;
            bArr[bArr.length - 1] = (byte) ((bArr3[str.charAt(str.length() - 3)] >> 4) | (bArr3[str.charAt(str.length() - 4)] << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte[] bArr4 = f10247b;
            byte b13 = bArr4[str.charAt(str.length() - 4)];
            byte b14 = bArr4[str.charAt(str.length() - 3)];
            byte b15 = bArr4[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b13 << 2) | (b14 >> 4));
            bArr[bArr.length - 1] = (byte) ((b15 >> 2) | (b14 << 4));
        } else {
            byte[] bArr5 = f10247b;
            byte b16 = bArr5[str.charAt(str.length() - 4)];
            byte b17 = bArr5[str.charAt(str.length() - 3)];
            byte b18 = bArr5[str.charAt(str.length() - 2)];
            byte b19 = bArr5[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b16 << 2) | (b17 >> 4));
            bArr[bArr.length - 2] = (byte) ((b17 << 4) | (b18 >> 2));
            bArr[bArr.length - 1] = (byte) (b19 | (b18 << 6));
        }
        return bArr;
    }

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!a((byte) str.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i10 = 0;
        int i11 = 0;
        while (i10 < bytes.length) {
            byte[] bArr2 = f10246a;
            bArr[i11] = bArr2[(bytes[i10] & 252) >> 2];
            int i12 = i10 + 1;
            bArr[i11 + 1] = bArr2[((bytes[i10] & 3) << 4) + ((bytes[i12] & 240) >> 4)];
            int i13 = (bytes[i12] & 15) << 2;
            int i14 = i10 + 2;
            bArr[i11 + 2] = bArr2[i13 + ((bytes[i14] & 192) >> 6)];
            bArr[i11 + 3] = bArr2[bytes[i14] & Utf8.REPLACEMENT_BYTE];
            i10 += 3;
            i11 += 4;
        }
        return new String(bArr);
    }

    private static boolean a(byte b4) {
        if (b4 == 36) {
            return true;
        }
        return b4 >= 0 && b4 < 128 && f10247b[b4] != -1;
    }
}
