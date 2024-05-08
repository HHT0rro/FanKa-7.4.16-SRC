package fd;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            Key b4 = b(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, b4, new IvParameterSpec(str.getBytes()));
            bArr = cipher.doFinal(str2.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new String(Base64.encode(bArr, 0)).trim();
    }

    public static Key b(String str) throws Exception {
        try {
            return new SecretKeySpec(str.getBytes(), AESEncrypt.ALGORITHM);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
