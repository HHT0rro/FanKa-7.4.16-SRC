package sa;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import va.c;
import va.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    public static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            f.c("GCM", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            f.c("GCM", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            f.c("GCM", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("GCM", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            f.c("GCM", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!k()) {
            f.c("GCM", "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return i(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e2) {
            f.c("GCM", "GCM encrypt data error" + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            f.c("GCM", "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            f.c("GCM", "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            f.c("GCM", "decrypt 3 iv is null");
            return "";
        }
        if (!k()) {
            f.c("GCM", "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] b4 = c.b(str2);
        byte[] b10 = c.b(str3);
        if (b4.length < 16) {
            f.c("GCM", "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (b10.length < 12) {
            f.c("GCM", "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return d(str, b4, b10);
    }

    public static String d(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            f.c("GCM", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            f.c("GCM", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            f.c("GCM", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            f.c("GCM", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            f.c("GCM", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        if (!k()) {
            f.c("GCM", "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new String(e(c.b(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            f.c("GCM", "GCM decrypt data exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            f.c("GCM", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            f.c("GCM", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("GCM", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            f.c("GCM", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            f.c("GCM", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            f.c("GCM", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!k()) {
            f.c("GCM", "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKeySpec, j(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e2) {
            f.c("GCM", "GCM decrypt data exception: " + e2.getMessage());
            return new byte[0];
        }
    }

    public static String f(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            f.c("GCM", "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            f.c("GCM", "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            f.c("GCM", "encrypt 3 iv is null");
            return "";
        }
        if (!k()) {
            f.c("GCM", "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] b4 = c.b(str2);
        byte[] b10 = c.b(str3);
        if (b4.length < 16) {
            f.c("GCM", "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (b10.length < 12) {
            f.c("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return g(str, b4, b10);
    }

    public static String g(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            f.c("GCM", "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            f.c("GCM", "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            f.c("GCM", "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            f.c("GCM", "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            f.c("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        if (!k()) {
            f.c("GCM", "encrypt 4 build version not higher than 19");
            return "";
        }
        return c.a(a(str, bArr, bArr2));
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        byte[] c4 = va.b.c(12);
        return b(c4, i(bArr, bArr2, c4));
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            f.c("GCM", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            f.c("GCM", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("GCM", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            f.c("GCM", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            f.c("GCM", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            f.c("GCM", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!k()) {
            f.c("GCM", "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, j(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            f.c("GCM", "GCM encrypt data error" + e2.getMessage());
            return new byte[0];
        } catch (GeneralSecurityException e10) {
            f.c("GCM", "GCM encrypt data error" + e10.getMessage());
            return new byte[0];
        }
    }

    public static AlgorithmParameterSpec j(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean k() {
        return true;
    }
}
