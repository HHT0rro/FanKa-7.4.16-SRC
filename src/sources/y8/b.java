package y8;

import android.util.Base64;
import com.alibaba.security.common.utils.DESCoderUtils;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b {
    public static String a(String str, String str2) {
        Cipher cipher = Cipher.getInstance(DESCoderUtils.SECRETFACTORY_ALGORITHM);
        cipher.init(2, b(str2));
        return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    public static Key b(String str) {
        return SecretKeyFactory.getInstance(DESCoderUtils.SECRETFACTORY_ALGORITHM).generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }
}
