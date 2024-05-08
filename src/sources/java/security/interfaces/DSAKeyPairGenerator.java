package java.security.interfaces;

import java.security.InvalidParameterException;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DSAKeyPairGenerator {
    void initialize(int i10, boolean z10, SecureRandom secureRandom) throws InvalidParameterException;

    void initialize(DSAParams dSAParams, SecureRandom secureRandom) throws InvalidParameterException;
}
