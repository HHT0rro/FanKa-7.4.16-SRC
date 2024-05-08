package com.android.internal.org.bouncycastle.jce.provider;

import com.alibaba.security.common.utils.DESCoderUtils;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import com.android.internal.org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import com.android.internal.org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.IOException;
import java.security.AccessController;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    private static final String ASYMMETRIC_PACKAGE = "com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.";
    private static final String DIGEST_PACKAGE = "com.android.internal.org.bouncycastle.jcajce.provider.digest.";
    private static final String KEYSTORE_PACKAGE = "com.android.internal.org.bouncycastle.jcajce.provider.keystore.";
    public static final String PROVIDER_NAME = "BC";
    private static final String SYMMETRIC_PACKAGE = "com.android.internal.org.bouncycastle.jcajce.provider.symmetric.";
    private final Provider privateProvider;
    private static String info = "BouncyCastle Security Provider v1.68";
    public static final ProviderConfiguration CONFIGURATION = new BouncyCastleProviderConfiguration();
    private static final Map keyInfoConverters = new HashMap();
    private static final Class revChkClass = ClassUtil.loadClass(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");
    private static final String[] SYMMETRIC_GENERIC = {"PBEPBKDF2", "PBEPKCS12", "PBES2AlgorithmParameters"};
    private static final String[] SYMMETRIC_MACS = new String[0];
    private static final String[] SYMMETRIC_CIPHERS = {AESEncrypt.ALGORITHM, "ARC4", "Blowfish", DESCoderUtils.SECRETFACTORY_ALGORITHM, "DESede", "RC2", "Twofish"};
    private static final String[] ASYMMETRIC_GENERIC = {"X509"};
    private static final String[] ASYMMETRIC_CIPHERS = {"DSA", "DH", "EC", "RSA"};
    private static final String[] DIGESTS = {"MD5", "SHA1", "SHA224", "SHA256", "SHA384", "SHA512"};
    private static final String[] KEYSTORES = {"BC", "BCFKS", "PKCS12"};

    public BouncyCastleProvider() {
        super("BC", 1.68d, info);
        this.privateProvider = new PrivateProvider();
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.android.internal.org.bouncycastle.jce.provider.BouncyCastleProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                BouncyCastleProvider.this.setup();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        loadAlgorithms(DIGEST_PACKAGE, DIGESTS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_GENERIC);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_MACS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_CIPHERS);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_GENERIC);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_CIPHERS);
        loadAlgorithms(KEYSTORE_PACKAGE, KEYSTORES);
        put("CertPathValidator.PKIX", "com.android.internal.org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "com.android.internal.org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "com.android.internal.org.bouncycastle.jce.provider.CertStoreCollectionSpi");
    }

    private void loadAlgorithms(String packageName, String[] names) {
        for (int i10 = 0; i10 != names.length; i10++) {
            Class clazz = ClassUtil.loadClass(BouncyCastleProvider.class, packageName + names[i10] + "$Mappings");
            if (clazz != null) {
                try {
                    ((AlgorithmProvider) clazz.newInstance()).configure(this);
                } catch (Exception e2) {
                    throw new InternalError("cannot create instance of " + packageName + names[i10] + "$Mappings : " + ((Object) e2));
                }
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String parameterName, Object parameter) {
        ProviderConfiguration providerConfiguration = CONFIGURATION;
        synchronized (providerConfiguration) {
            ((BouncyCastleProviderConfiguration) providerConfiguration).setParameter(parameterName, parameter);
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String type, String name) {
        return containsKey(new StringBuilder().append(type).append(".").append(name).toString()) || containsKey(new StringBuilder().append("Alg.Alias.").append(type).append(".").append(name).toString());
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String key, String value) {
        if (containsKey(key)) {
            throw new IllegalStateException("duplicate provider key (" + key + ") found");
        }
        put(key, value);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String type, ASN1ObjectIdentifier oid, String className) {
        addAlgorithm(type + "." + ((Object) oid), className);
        addAlgorithm(type + ".OID." + ((Object) oid), className);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier oid, AsymmetricKeyInfoConverter keyInfoConverter) {
        Map map = keyInfoConverters;
        synchronized (map) {
            map.put(oid, keyInfoConverter);
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier oid) {
        return (AsymmetricKeyInfoConverter) keyInfoConverters.get(oid);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAttributes(String key, Map<String, String> attributeMap) {
        for (String attributeName : attributeMap.h()) {
            String attributeKey = key + " " + attributeName;
            if (containsKey(attributeKey)) {
                throw new IllegalStateException("duplicate provider attribute key (" + attributeKey + ") found");
            }
            put(attributeKey, attributeMap.get(attributeName));
        }
    }

    private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier algorithm) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        Map map = keyInfoConverters;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(algorithm);
        }
        return asymmetricKeyInfoConverter;
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo publicKeyInfo) throws IOException {
        try {
            return KeyFactory.getInstance(publicKeyInfo.getAlgorithmId().getAlgorithm().getId()).generatePublic(new X509EncodedKeySpec(publicKeyInfo.getEncoded()));
        } catch (NoSuchAlgorithmException e2) {
            return null;
        } catch (InvalidKeySpecException ex) {
            throw new IOException(ex);
        }
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        try {
            return KeyFactory.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm().getId()).generatePrivate(new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded()));
        } catch (NoSuchAlgorithmException e2) {
            return null;
        } catch (InvalidKeySpecException ex) {
            throw new IOException(ex);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static final class PrivateProvider extends Provider {
        public PrivateProvider() {
            super("BCPrivate", 1.0d, "Android BC private use only");
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addPrivateAlgorithm(String key, String value) {
        if (this.privateProvider.containsKey(key)) {
            throw new IllegalStateException("duplicate provider key (" + key + ") found");
        }
        this.privateProvider.put(key, value);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addPrivateAlgorithm(String type, ASN1ObjectIdentifier oid, String className) {
        addPrivateAlgorithm(type + "." + ((Object) oid), className);
    }

    public Provider getPrivateProvider() {
        return this.privateProvider;
    }
}
