package com.huawei.hms.ads.uiengineloader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class z {
    public static String a(byte[] bArr) {
        if (bArr == null) {
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
}
