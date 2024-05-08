package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface RSAPrivateKey extends PrivateKey, RSAKey {
    public static final long serialVersionUID = 5187144804936595022L;

    BigInteger getPrivateExponent();
}
