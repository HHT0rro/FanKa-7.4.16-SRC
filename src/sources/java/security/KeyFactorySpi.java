package java.security;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class KeyFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Key engineTranslateKey(Key key) throws InvalidKeyException;
}
