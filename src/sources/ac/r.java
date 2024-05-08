package ac;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {
    public static String a() {
        try {
            String replace = UUID.randomUUID().toString().replace("-", "");
            return (TextUtils.isEmpty(replace) || replace.length() < 32) ? i.g().substring(0, 32) : replace;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return e(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str, String str2, String str3) {
        try {
            return d(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    throw new Exception("encrypt key is null");
                }
                if (str2.length() != 16) {
                    throw new Exception("encrypt key length error");
                }
                if (str3.length() != 16) {
                    throw new Exception(" iv encrypt key length error");
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), AESEncrypt.ALGORITHM), new IvParameterSpec(str3.getBytes("utf-8")));
                return s.b(cipher.doFinal(str.getBytes("utf-8")));
            }
            return null;
        } catch (Exception e2) {
            throw new Exception("Encrypt error", e2);
        }
    }

    public static String e(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    throw new Exception("decrypt key is null");
                }
                if (str2.length() != 16) {
                    throw new Exception("decrypt key length error");
                }
                if (str3.length() != 16) {
                    throw new Exception(" iv decrypt key length error");
                }
                byte[] c4 = s.c(str);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), AESEncrypt.ALGORITHM), new IvParameterSpec(str3.getBytes("utf-8")));
                return new String(cipher.doFinal(c4), "utf-8");
            }
            return null;
        } catch (Exception e2) {
            throw new Exception("decrypt error", e2);
        }
    }
}
