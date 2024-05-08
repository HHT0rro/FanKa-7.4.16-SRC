package com.danlan.android.security.obfuscator;

import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StringFogImpl {
    private static final String CHARSET_NAME_UTF_8 = "UTF-8";

    private static byte[] xor(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            if (i11 >= length2) {
                i11 = 0;
            }
            bArr[i10] = (byte) (bArr[i10] ^ str.charAt(i11));
            i10++;
            i11++;
        }
        return bArr;
    }

    public String decrypt(String str, String str2) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new String(xor(Base64.decode(str, 2), str2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(xor(Base64.decode(str, 2), str2));
        }
    }

    public boolean overflow(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
