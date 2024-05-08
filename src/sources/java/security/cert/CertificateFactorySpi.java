package java.security.cert;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CertificateFactorySpi {
    public abstract CRL engineGenerateCRL(InputStream inputStream) throws CRLException;

    public abstract Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException;

    public abstract Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException;

    public abstract Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException;

    public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public Iterator<String> engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }
}
