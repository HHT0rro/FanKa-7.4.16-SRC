package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CertStoreSpi {
    public abstract Collection<? extends CRL> engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException;

    public abstract Collection<? extends Certificate> engineGetCertificates(CertSelector certSelector) throws CertStoreException;

    public CertStoreSpi(CertStoreParameters params) throws InvalidAlgorithmParameterException {
    }
}
