package y8;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static String a() {
        byte[] c4 = c(b("com.nearme.mcs"));
        return c4 != null ? new String(c4, Charset.forName("UTF-8")) : "";
    }

    public static byte[] b(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            byte b4 = bArr[i10];
            int i11 = i10 + 1;
            bArr[i10] = bArr[i11];
            bArr[i11] = b4;
        }
        return bArr;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.a(str, a());
            } catch (Exception e2) {
                c.b("desDecrypt-" + e2.getMessage());
            }
        }
        return "";
    }
}
