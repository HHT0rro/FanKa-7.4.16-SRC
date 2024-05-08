package sa;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import va.c;
import va.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e2) {
            f.c("CBC", "get encryptword exception : " + e2.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e2) {
                f.c("CBC", "mix exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            f.c("CBC", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            f.c("CBC", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("CBC", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            f.c("CBC", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return m(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e2) {
            f.c("CBC", " cbc encrypt data error" + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e2) {
            f.c("CBC", "getIv exception : " + e2.getMessage());
            return "";
        }
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            f.c("CBC", "decrypt 1 key is null");
            return "";
        }
        byte[] b4 = c.b(str2);
        if (b4.length < 16) {
            f.c("CBC", "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return g(str, b4);
    }

    public static String g(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            f.c("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            f.c("CBC", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String e2 = e(str);
        String a10 = a(str);
        if (TextUtils.isEmpty(e2)) {
            f.c("CBC", "decrypt 2 iv is null");
            return "";
        }
        if (TextUtils.isEmpty(a10)) {
            f.c("CBC", "decrypt 2 encrypt content is null");
            return "";
        }
        return h(a10, bArr, c.b(e2));
    }

    public static String h(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            f.c("CBC", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            f.c("CBC", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            f.c("CBC", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            f.c("CBC", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(i(c.b(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            f.c("CBC", " cbc decrypt data error" + e2.getMessage());
            return "";
        }
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            f.c("CBC", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            f.c("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("CBC", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            f.c("CBC", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            f.c("CBC", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            f.c("CBC", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            f.c("CBC", "NullPointerException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e10) {
            f.c("CBC", "InvalidAlgorithmParameterException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e11) {
            f.c("CBC", "InvalidKeyException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e12) {
            f.c("CBC", "NoSuchAlgorithmException: " + e12.getMessage());
            return new byte[0];
        } catch (BadPaddingException e13) {
            f.c("CBC", "BadPaddingException: " + e13.getMessage());
            f.c("CBC", "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e14) {
            f.c("CBC", "IllegalBlockSizeException: " + e14.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e15) {
            f.c("CBC", "NoSuchPaddingException: " + e15.getMessage());
            return new byte[0];
        }
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            f.c("CBC", "encrypt 1 key is null");
            return "";
        }
        byte[] b4 = c.b(str2);
        if (b4.length < 16) {
            f.c("CBC", "encrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return k(str, b4);
    }

    public static String k(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            f.c("CBC", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            f.c("CBC", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            f.c("CBC", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] c4 = va.b.c(16);
        byte[] c10 = c(str, bArr, c4);
        return (c10 == null || c10.length == 0) ? "" : b(c.a(c4), c.a(c10));
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        byte[] c4 = va.b.c(16);
        return d(c4, m(bArr, bArr2, c4));
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            f.c("CBC", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            f.c("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            f.c("CBC", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            f.c("CBC", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            f.c("CBC", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            f.c("CBC", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            f.c("CBC", "NullPointerException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e10) {
            f.c("CBC", "InvalidAlgorithmParameterException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e11) {
            f.c("CBC", "InvalidKeyException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e12) {
            f.c("CBC", "NoSuchAlgorithmException: " + e12.getMessage());
            return new byte[0];
        } catch (BadPaddingException e13) {
            f.c("CBC", "BadPaddingException: " + e13.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e14) {
            f.c("CBC", "IllegalBlockSizeException: " + e14.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e15) {
            f.c("CBC", "NoSuchPaddingException: " + e15.getMessage());
            return new byte[0];
        }
    }
}
