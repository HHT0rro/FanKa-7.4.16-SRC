package java.security.interfaces;

import java.security.PrivateKey;
import java.util.Optional;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface XECPrivateKey extends XECKey, PrivateKey {
    Optional<byte[]> getScalar();
}