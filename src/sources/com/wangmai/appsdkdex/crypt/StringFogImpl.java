package com.wangmai.appsdkdex.crypt;

import com.github.megatronking.stringfog.IStringFog;
import com.github.megatronking.stringfog.annotation.StringFogIgnore;

@StringFogIgnore
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class StringFogImpl implements IStringFog {
    public String decode(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (int i10 = 0; i10 < bytes.length; i10++) {
                bytes[i10] = (byte) (bytes[i10] - 1);
            }
            return new String(bytes, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String decrypt(String str, String str2) {
        return decode(str);
    }

    public String encode(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (int i10 = 0; i10 < bytes.length; i10++) {
                bytes[i10] = (byte) (bytes[i10] + 1);
            }
            return new String(bytes, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String encrypt(String str, String str2) {
        return encode(str);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public boolean overflow(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
