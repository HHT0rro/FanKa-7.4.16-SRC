package com.alibaba.security.common.utils;

import android.util.Base64;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StringUtils {
    public static String EMPTY = "";
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", t.f36220e, "j", "k", "l", "m", "n", "o", t.f36217b, "q", t.f36226k, t.f36222g, "t", t.f36224i, t.f36218c, IAdInterListener.AdReqParam.WIDTH, LanguageTag.PRIVATEUSE, "y", "z"};

    private static byte charToByte(char c4) {
        return (byte) "0123456789abcdef".indexOf(c4);
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (charToByte(charArray[i11 + 1]) | (charToByte(charArray[i11]) << 4));
        }
        return bArr;
    }

    public static String toBase64String(byte[] bArr) {
        return bArr == null ? "" : Base64.encodeToString(bArr, 2);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 : bArr) {
            if (i10 < 0) {
                i10 += 256;
            }
            String[] strArr = strDigits;
            stringBuffer.append(strArr[i10 / 16]);
            stringBuffer.append(strArr[i10 % 16]);
        }
        return stringBuffer.toString();
    }
}
