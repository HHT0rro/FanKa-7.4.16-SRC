package com.alibaba.security.common.utils;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BytesUtils {
    public static byte[] decodeBase64String(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 2);
    }

    private static byte hex(char c4) {
        int i10;
        if (c4 <= '9') {
            i10 = c4 - '0';
        } else {
            char c10 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                c10 = 'A';
                if (c4 < 'A' || c4 > 'F') {
                    throw new IllegalArgumentException("hex string format error [" + c4 + "].");
                }
            }
            i10 = (c4 - c10) + 10;
        }
        return (byte) i10;
    }

    public static byte[] hex2bytes(String str) {
        return hex2bytes(str, 0, str.length());
    }

    public static byte[] merge(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return null;
        }
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String toBase64String(byte[] bArr) {
        return bArr == null ? "" : Base64.encodeToString(bArr, 2);
    }

    public static byte[] hex2bytes(String str, int i10, int i11) {
        if ((i11 & 1) == 1) {
            throw new IllegalArgumentException("hex2bytes: ( len & 1 ) == 1.");
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("hex2bytes: offset < 0, offset is " + i10);
        }
        if (i11 >= 0) {
            if (i10 + i11 <= str.length()) {
                int i12 = i11 / 2;
                byte[] bArr = new byte[i12];
                int i13 = 0;
                int i14 = 0;
                while (i13 < i12) {
                    int i15 = i10 + 1;
                    bArr[i14] = (byte) ((hex(str.charAt(i10)) << 4) | hex(str.charAt(i15)));
                    i13++;
                    i14++;
                    i10 = i15 + 1;
                }
                return bArr;
            }
            throw new IndexOutOfBoundsException("hex2bytes: offset + length > array length.");
        }
        throw new IndexOutOfBoundsException("hex2bytes: length < 0, length is " + i11);
    }
}
