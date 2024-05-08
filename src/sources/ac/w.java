package ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
