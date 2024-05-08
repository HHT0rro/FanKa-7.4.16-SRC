package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ECPrivateKey extends PrivateKey, ECKey {
    public static final long serialVersionUID = -7896394956925609184L;

    BigInteger getS();
}
