package java.security.cert;

import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import java.util.Objects;
import sun.security.jca.GetInstance;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertStore {
    private static final String CERTSTORE_TYPE = "certstore.type";
    private CertStoreParameters params;
    private Provider provider;
    private CertStoreSpi storeSpi;
    private String type;

    /* JADX INFO: Access modifiers changed from: protected */
    public CertStore(CertStoreSpi storeSpi, Provider provider, String type, CertStoreParameters params) {
        this.storeSpi = storeSpi;
        this.provider = provider;
        this.type = type;
        if (params != null) {
            this.params = (CertStoreParameters) params.clone();
        }
    }

    public final Collection<? extends Certificate> getCertificates(CertSelector selector) throws CertStoreException {
        return this.storeSpi.engineGetCertificates(selector);
    }

    public final Collection<? extends CRL> getCRLs(CRLSelector selector) throws CertStoreException {
        return this.storeSpi.engineGetCRLs(selector);
    }

    public static CertStore getInstance(String type, CertStoreParameters params) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        Objects.requireNonNull(type, "null type name");
        try {
            GetInstance.Instance instance = GetInstance.getInstance("CertStore", (Class<?>) CertStoreSpi.class, type, params);
            return new CertStore((CertStoreSpi) instance.impl, instance.provider, type, params);
        } catch (NoSuchAlgorithmException e2) {
            return handleException(e2);
        }
    }

    private static CertStore handleException(NoSuchAlgorithmException e2) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Throwable cause = e2.getCause();
        if (cause instanceof InvalidAlgorithmParameterException) {
            throw ((InvalidAlgorithmParameterException) cause);
        }
        throw e2;
    }

    public static CertStore getInstance(String type, CertStoreParameters params, String provider) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        Objects.requireNonNull(type, "null type name");
        try {
            GetInstance.Instance instance = GetInstance.getInstance("CertStore", (Class<?>) CertStoreSpi.class, type, params, provider);
            return new CertStore((CertStoreSpi) instance.impl, instance.provider, type, params);
        } catch (NoSuchAlgorithmException e2) {
            return handleException(e2);
        }
    }

    public static CertStore getInstance(String type, CertStoreParameters params, Provider provider) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Objects.requireNonNull(type, "null type name");
        try {
            GetInstance.Instance instance = GetInstance.getInstance("CertStore", (Class<?>) CertStoreSpi.class, type, params, provider);
            return new CertStore((CertStoreSpi) instance.impl, instance.provider, type, params);
        } catch (NoSuchAlgorithmException e2) {
            return handleException(e2);
        }
    }

    public final CertStoreParameters getCertStoreParameters() {
        CertStoreParameters certStoreParameters = this.params;
        if (certStoreParameters == null) {
            return null;
        }
        return (CertStoreParameters) certStoreParameters.clone();
    }

    public final String getType() {
        return this.type;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public static final String getDefaultType() {
        String cstype = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.security.cert.CertStore.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty(CertStore.CERTSTORE_TYPE);
            }
        });
        if (cstype == null) {
            return "LDAP";
        }
        return cstype;
    }
}
