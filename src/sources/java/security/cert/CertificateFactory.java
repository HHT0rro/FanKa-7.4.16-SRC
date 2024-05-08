package java.security.cert;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificateFactory {
    private CertificateFactorySpi certFacSpi;
    private Provider provider;
    private String type;

    protected CertificateFactory(CertificateFactorySpi certFacSpi, Provider provider, String type) {
        this.certFacSpi = certFacSpi;
        this.provider = provider;
        this.type = type;
    }

    public static final CertificateFactory getInstance(String type) throws CertificateException {
        try {
            GetInstance.Instance instance = GetInstance.getInstance("CertificateFactory", (Class<?>) CertificateFactorySpi.class, type);
            return new CertificateFactory((CertificateFactorySpi) instance.impl, instance.provider, type);
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(type + " not found", e2);
        }
    }

    public static final CertificateFactory getInstance(String type, String provider) throws CertificateException, NoSuchProviderException {
        try {
            Providers.checkBouncyCastleDeprecation(provider, "CertificateFactory", type);
            GetInstance.Instance instance = GetInstance.getInstance("CertificateFactory", (Class<?>) CertificateFactorySpi.class, type, provider);
            return new CertificateFactory((CertificateFactorySpi) instance.impl, instance.provider, type);
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(type + " not found", e2);
        }
    }

    public static final CertificateFactory getInstance(String type, Provider provider) throws CertificateException {
        try {
            Providers.checkBouncyCastleDeprecation(provider, "CertificateFactory", type);
            GetInstance.Instance instance = GetInstance.getInstance("CertificateFactory", (Class<?>) CertificateFactorySpi.class, type, provider);
            return new CertificateFactory((CertificateFactorySpi) instance.impl, instance.provider, type);
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(type + " not found", e2);
        }
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        return this.certFacSpi.engineGenerateCertificate(inStream);
    }

    public final Iterator<String> getCertPathEncodings() {
        return this.certFacSpi.engineGetCertPathEncodings();
    }

    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        return this.certFacSpi.engineGenerateCertPath(inStream);
    }

    public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        return this.certFacSpi.engineGenerateCertPath(inStream, encoding);
    }

    public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        return this.certFacSpi.engineGenerateCertPath(certificates);
    }

    public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        return this.certFacSpi.engineGenerateCertificates(inStream);
    }

    public final CRL generateCRL(InputStream inStream) throws CRLException {
        return this.certFacSpi.engineGenerateCRL(inStream);
    }

    public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        return this.certFacSpi.engineGenerateCRLs(inStream);
    }
}
