package com.alipay.sdk.encrypt;

import com.alibaba.security.common.utils.DESCoderUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {
    public static String a(String str, String str2) {
        return a(1, str, str2);
    }

    public static String b(String str, String str2) {
        return a(2, str, str2);
    }

    public static String a(int i10, String str, String str2) {
        byte[] bytes;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), DESCoderUtils.SECRETFACTORY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DESCoderUtils.SECRETFACTORY_ALGORITHM);
            cipher.init(i10, secretKeySpec);
            if (i10 == 2) {
                bytes = a.a(str);
            } else {
                bytes = str.getBytes("UTF-8");
            }
            byte[] doFinal = cipher.doFinal(bytes);
            if (i10 == 2) {
                return new String(doFinal);
            }
            return a.a(doFinal);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            return null;
        }
    }
}
