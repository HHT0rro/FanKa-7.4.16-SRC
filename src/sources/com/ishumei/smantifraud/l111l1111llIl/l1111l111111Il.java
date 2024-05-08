package com.ishumei.smantifraud.l111l1111llIl;

import com.alibaba.security.common.utils.DESCoderUtils;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l1111l111111Il {
    public static String l1111l111111Il(String str, byte[] bArr, int i10) {
        try {
            return new String(l111l11111lIl(str, bArr, i10), "utf-8");
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    public static byte[] l111l11111lIl(String str, byte[] bArr, int i10) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes("utf-8"), DESCoderUtils.SECRETFACTORY_ALGORITHM));
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] bArr2 = new byte[i10];
            System.arraycopy((Object) doFinal, 0, (Object) bArr2, 0, i10);
            return bArr2;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }
}
