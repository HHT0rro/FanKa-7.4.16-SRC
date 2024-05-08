package java.security.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface RSAPublicKey extends PublicKey, RSAKey {
    public static final long serialVersionUID = -8727434096241101194L;

    BigInteger getPublicExponent();
}
