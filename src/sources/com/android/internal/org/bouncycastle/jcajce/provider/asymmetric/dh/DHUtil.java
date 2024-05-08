package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.dh;

import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Fingerprint;
import com.android.internal.org.bouncycastle.util.Strings;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class DHUtil {
    DHUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String privateKeyToString(String algorithm, BigInteger x10, DHParameters dhParams) {
        StringBuffer buf = new StringBuffer();
        String nl = Strings.lineSeparator();
        BigInteger y10 = dhParams.getG().modPow(x10, dhParams.getP());
        buf.append(algorithm);
        buf.append(" Private Key [").append(generateKeyFingerprint(y10, dhParams)).append("]").append(nl);
        buf.append("              Y: ").append(y10.toString(16)).append(nl);
        return buf.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String publicKeyToString(String algorithm, BigInteger y10, DHParameters dhParams) {
        StringBuffer buf = new StringBuffer();
        String nl = Strings.lineSeparator();
        buf.append(algorithm);
        buf.append(" Public Key [").append(generateKeyFingerprint(y10, dhParams)).append("]").append(nl);
        buf.append("             Y: ").append(y10.toString(16)).append(nl);
        return buf.toString();
    }

    private static String generateKeyFingerprint(BigInteger y10, DHParameters dhParams) {
        return new Fingerprint(Arrays.concatenate(y10.toByteArray(), dhParams.getP().toByteArray(), dhParams.getG().toByteArray())).toString();
    }
}
