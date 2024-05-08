package java.security;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface AlgorithmConstraints {
    boolean permits(Set<CryptoPrimitive> set, String str, AlgorithmParameters algorithmParameters);

    boolean permits(Set<CryptoPrimitive> set, String str, Key key, AlgorithmParameters algorithmParameters);

    boolean permits(Set<CryptoPrimitive> set, Key key);
}
