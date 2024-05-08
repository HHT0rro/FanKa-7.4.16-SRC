package javax.net.ssl;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class TrustManagerFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract TrustManager[] engineGetTrustManagers();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(KeyStore keyStore) throws KeyStoreException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException;
}
