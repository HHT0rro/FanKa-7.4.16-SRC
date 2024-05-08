package b9;

import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k {
    public static SecretKey a(e eVar) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (eVar == null || !eVar.a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("build aes key, iterationCount:");
        sb2.append(eVar.g());
        return new SecretKeySpec(SecretKeyFactory.getInstance(eVar.f()).generateSecret(new PBEKeySpec(a.c(e(a.b(eVar.b()), a.b(eVar.c()), a.b(eVar.d()))).toCharArray(), a.b(eVar.e()), eVar.g(), eVar.h() * 8)).getEncoded(), AESEncrypt.ALGORITHM);
    }

    public static byte[] b(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    public static byte[] c(byte[] bArr, int i10) {
        Objects.requireNonNull(bArr, "bytes must not be null.");
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (i10 < 0) {
                bArr[i11] = (byte) (bArr[i11] << (-i10));
            } else {
                bArr[i11] = (byte) (bArr[i11] >> i10);
            }
        }
        return bArr;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return d(c(d(c(bArr, -4), bArr2), 6), bArr3);
    }
}
