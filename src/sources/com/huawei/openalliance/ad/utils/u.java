package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class u {
    private static final String Code = "";
    private static final String V = "HexUtil";

    public static String Code(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static byte[] Code(String str) {
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i10 = 0; i10 < length; i10++) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("0x");
                int i11 = i10 * 2;
                sb3.append(new String(new byte[]{bytes[i11]}, "UTF-8"));
                bArr[i10] = (byte) (((byte) (Byte.decode(sb3.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i11 + 1]}, "UTF-8")).byteValue());
            }
        } catch (NumberFormatException e2) {
            e = e2;
            sb2 = new StringBuilder();
            sb2.append("hex string 2 byte: ");
            sb2.append(e.getClass().getSimpleName());
            gl.Z(V, sb2.toString());
            return bArr;
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            sb2.append("hex string 2 byte: ");
            sb2.append(e.getClass().getSimpleName());
            gl.Z(V, sb2.toString());
            return bArr;
        }
        return bArr;
    }
}
