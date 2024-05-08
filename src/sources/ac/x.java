package ac;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x {
    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        if (bArr == null || bArr.length != 16) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10410);
        }
        if (bArr3 == null) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10400);
        }
        if (bArr2 == null) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10411);
        }
        int length = bArr3.length;
        if (i10 == 1) {
            if (length <= 0) {
                throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10408);
            }
        } else if (length <= 0 || bArr3.length % 16 != 0) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10409);
        }
        if (bArr2.length != 16) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10411);
        }
        new SecretKeySpec(bArr, "SM4");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        try {
            Cipher cipher = Cipher.getInstance("SM4/CBC/PKCS5Padding", "BC");
            cipher.init(i10, new SecretKeySpec(bArr, "SM4"), ivParameterSpec);
            return cipher.doFinal(bArr3);
        } catch (Exception e2) {
            if (i10 == 1) {
                throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10204, e2);
            }
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10205, e2);
        }
    }
}
