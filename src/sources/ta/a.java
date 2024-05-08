package ta;

import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import va.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f53789a = "PBKDF2";

    public static byte[] a(char[] cArr, byte[] bArr, int i10, int i11, boolean z10) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i10, i11);
            if (z10) {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            f.c(f53789a, "pbkdf exception : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] b(char[] cArr, byte[] bArr, int i10, int i11) {
        return a(cArr, bArr, i10, i11, false);
    }

    public static byte[] c(char[] cArr, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT < 26) {
            f.c(f53789a, "system version not high than 26");
            return bArr2;
        }
        return a(cArr, bArr, i10, i11, true);
    }
}
