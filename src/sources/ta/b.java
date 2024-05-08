package ta;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import va.c;
import va.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f53790a = "SHA";

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f53791b = {"SHA-256", "SHA-384", "SHA-512"};

    public static boolean a(String str) {
        for (String str2 : f53791b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        return c(str, "SHA-256");
    }

    public static String c(String str, String str2) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!a(str2)) {
                f.c(f53790a, "algorithm is not safe or legal");
                return "";
            }
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                f.c(f53790a, "Error in generate SHA UnsupportedEncodingException");
            }
            return c.a(d(bArr, str2));
        }
        f.c(f53790a, "content or algorithm is null.");
        return "";
    }

    public static byte[] d(byte[] bArr, String str) {
        if (bArr != null && !TextUtils.isEmpty(str)) {
            if (!a(str)) {
                f.c(f53790a, "algorithm is not safe or legal");
                return new byte[0];
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                f.c(f53790a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
        f.c(f53790a, "content or algorithm is null.");
        return new byte[0];
    }
}
