package javax.crypto.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DHPrivateKey extends DHKey, PrivateKey {
    public static final long serialVersionUID = 2211791113380396553L;

    BigInteger getX();
}
