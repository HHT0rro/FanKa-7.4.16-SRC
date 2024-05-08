package com.danlan.android.cognition.common;

import com.danlan.android.cognition.StringFog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ByteTransformUtils {
    public static String byte2HexStr(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i10 < i11) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(StringFog.decrypt("EQ=="));
            }
            stringBuffer.append(hexString);
            i10++;
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static byte[] hexStr2Bytes(String str) {
        int length = str.length() / 2;
        System.out.println(length);
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            bArr[i10] = uniteBytes(str.substring(i11, i12), str.substring(i12, i12 + 1));
        }
        return bArr;
    }

    private static byte uniteBytes(String str, String str2) {
        return (byte) (((byte) (Byte.decode(StringFog.decrypt("EVs=") + str).byteValue() << 4)) | Byte.decode(StringFog.decrypt("EVs=") + str2).byteValue());
    }
}
