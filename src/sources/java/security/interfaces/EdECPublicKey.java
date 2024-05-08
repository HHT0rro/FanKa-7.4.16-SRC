package java.security.interfaces;

import java.security.PublicKey;
import java.security.spec.EdECPoint;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface EdECPublicKey extends EdECKey, PublicKey {
    EdECPoint getPoint();
}
