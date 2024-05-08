package javax.crypto.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DHPublicKey extends DHKey, PublicKey {
    public static final long serialVersionUID = -6628103563352519193L;

    BigInteger getY();
}
