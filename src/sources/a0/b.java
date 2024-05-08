package a0;

import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {
    public static String a(String str) {
        try {
            if (z.a.d(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(String.format("%02x", Byte.valueOf(b4)));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
