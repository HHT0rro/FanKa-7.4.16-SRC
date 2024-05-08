package com.android.internal.org.bouncycastle.jcajce.provider.keystore.pkcs12;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.DERBMPString;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERSet;
import com.android.internal.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import com.android.internal.org.bouncycastle.asn1.pkcs.CertBag;
import com.android.internal.org.bouncycastle.asn1.pkcs.ContentInfo;
import com.android.internal.org.bouncycastle.asn1.pkcs.EncryptedData;
import com.android.internal.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.pkcs.MacData;
import com.android.internal.org.bouncycastle.asn1.pkcs.PBES2Parameters;
import com.android.internal.org.bouncycastle.asn1.pkcs.PBKDF2Params;
import com.android.internal.org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import com.android.internal.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.pkcs.Pfx;
import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.pkcs.SafeBag;
import com.android.internal.org.bouncycastle.asn1.util.ASN1Dump;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.DigestInfo;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactory;
import com.android.internal.org.bouncycastle.jcajce.PKCS12Key;
import com.android.internal.org.bouncycastle.jcajce.PKCS12StoreParameter;
import com.android.internal.org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import com.android.internal.org.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.android.internal.org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.interfaces.BCKeyStore;
import com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.android.internal.org.bouncycastle.jce.provider.BouncyCastleProvider;
import com.android.internal.org.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Integers;
import com.android.internal.org.bouncycastle.util.Properties;
import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import com.huawei.hms.feature.dynamic.f.e;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 51200;
    static final int NULL = 0;
    static final String PKCS12_MAX_IT_COUNT_PROPERTY = "com.android.internal.org.bouncycastle.pkcs12.max_it_count";
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs;
    private ASN1ObjectIdentifier keyAlgorithm;
    private IgnoresCaseHashtable keys;
    private final JcaJceHelper helper = new DefaultJcaJceHelper();
    private final JcaJceHelper selfHelper = new BCJcaJceHelper();
    private Hashtable localIds = new Hashtable();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();
    protected SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private AlgorithmIdentifier macAlgorithm = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    private int itCount = AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE;
    private int saltLength = 20;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class CertId {

        /* renamed from: id, reason: collision with root package name */
        byte[] f9246id;

        CertId(PublicKey key) {
            this.f9246id = PKCS12KeyStoreSpi.this.createSubjectKeyId(key).getKeyIdentifier();
        }

        CertId(byte[] id2) {
            this.f9246id = id2;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f9246id);
        }

        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof CertId)) {
                return false;
            }
            CertId cId = (CertId) o10;
            return Arrays.areEqual(this.f9246id, cId.f9246id);
        }
    }

    public PKCS12KeyStoreSpi(JcaJceHelper helper, ASN1ObjectIdentifier keyAlgorithm, ASN1ObjectIdentifier certAlgorithm) {
        this.keys = new IgnoresCaseHashtable();
        this.certs = new IgnoresCaseHashtable();
        this.keyAlgorithm = keyAlgorithm;
        this.certAlgorithm = certAlgorithm;
        try {
            this.certFact = helper.createCertificateFactory(e.f29912b);
        } catch (Exception e2) {
            throw new IllegalArgumentException("can't create cert factory - " + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey pubKey) {
        try {
            SubjectPublicKeyInfo info = SubjectPublicKeyInfo.getInstance(pubKey.getEncoded());
            return new SubjectKeyIdentifier(getDigest(info));
        } catch (Exception e2) {
            throw new RuntimeException("error creating key");
        }
    }

    private static byte[] getDigest(SubjectPublicKeyInfo spki) {
        Digest digest = AndroidDigestFactory.getSHA1();
        byte[] resBuf = new byte[digest.getDigestSize()];
        byte[] bytes = spki.getPublicKeyData().getBytes();
        digest.update(bytes, 0, bytes.length);
        digest.doFinal(resBuf, 0);
        return resBuf;
    }

    @Override // com.android.internal.org.bouncycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom rand) {
        this.random = rand;
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable tab = new Hashtable();
        Enumeration e2 = this.certs.keys();
        while (e2.hasMoreElements()) {
            tab.put(e2.nextElement(), "cert");
        }
        Enumeration e10 = this.keys.keys();
        while (e10.hasMoreElements()) {
            String a10 = (String) e10.nextElement();
            if (tab.get(a10) == null) {
                tab.put(a10, "key");
            }
        }
        return tab.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String alias) {
        return (this.certs.get(alias) == null && this.keys.get(alias) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String alias) throws KeyStoreException {
        Key k10 = (Key) this.keys.remove(alias);
        Certificate c4 = (Certificate) this.certs.remove(alias);
        if (c4 != null) {
            this.chainCerts.remove(new CertId(c4.getPublicKey()));
        }
        if (k10 != null) {
            String id2 = (String) this.localIds.remove(alias);
            if (id2 != null) {
                c4 = (Certificate) this.keyCerts.remove(id2);
            }
            if (c4 != null) {
                this.chainCerts.remove(new CertId(c4.getPublicKey()));
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String alias) {
        if (alias == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate c4 = (Certificate) this.certs.get(alias);
        if (c4 == null) {
            String id2 = (String) this.localIds.get(alias);
            if (id2 != null) {
                return (Certificate) this.keyCerts.get(id2);
            }
            return (Certificate) this.keyCerts.get(alias);
        }
        return c4;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate cert) {
        Enumeration c4 = this.certs.elements();
        Enumeration k10 = this.certs.keys();
        while (c4.hasMoreElements()) {
            Certificate tc2 = (Certificate) c4.nextElement();
            String ta2 = (String) k10.nextElement();
            if (tc2.equals(cert)) {
                return ta2;
            }
        }
        Enumeration c10 = this.keyCerts.elements();
        Enumeration k11 = this.keyCerts.keys();
        while (c10.hasMoreElements()) {
            Certificate tc3 = (Certificate) c10.nextElement();
            String ta3 = (String) k11.nextElement();
            if (tc3.equals(cert)) {
                return ta3;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String alias) {
        Certificate c4;
        if (alias == null) {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        if (!engineIsKeyEntry(alias) || (c4 = engineGetCertificate(alias)) == null) {
            return null;
        }
        Vector cs = new Vector();
        while (c4 != null) {
            X509Certificate x509c = (X509Certificate) c4;
            Certificate nextC = null;
            byte[] akiBytes = x509c.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (akiBytes != null) {
                ASN1OctetString akiValue = ASN1OctetString.getInstance(akiBytes);
                AuthorityKeyIdentifier aki = AuthorityKeyIdentifier.getInstance(akiValue.getOctets());
                byte[] keyID = aki.getKeyIdentifier();
                if (keyID != null) {
                    nextC = (Certificate) this.chainCerts.get(new CertId(keyID));
                }
            }
            if (nextC == null) {
                Principal i10 = x509c.getIssuerDN();
                Principal s2 = x509c.getSubjectDN();
                if (!i10.equals(s2)) {
                    Enumeration e2 = this.chainCerts.keys();
                    while (true) {
                        if (!e2.hasMoreElements()) {
                            break;
                        }
                        X509Certificate crt = (X509Certificate) this.chainCerts.get(e2.nextElement());
                        Principal sub = crt.getSubjectDN();
                        if (sub.equals(i10)) {
                            try {
                                x509c.verify(crt.getPublicKey());
                                nextC = crt;
                                break;
                            } catch (Exception e10) {
                            }
                        }
                    }
                }
            }
            if (cs.contains(c4)) {
                c4 = null;
            } else {
                cs.addElement(c4);
                if (nextC != c4) {
                    c4 = nextC;
                } else {
                    c4 = null;
                }
            }
        }
        Certificate[] certChain = new Certificate[cs.size()];
        for (int i11 = 0; i11 != certChain.length; i11++) {
            certChain[i11] = (Certificate) cs.elementAt(i11);
        }
        return certChain;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String alias) {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        if (this.keys.get(alias) == null && this.certs.get(alias) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String alias, char[] password) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (alias == null) {
            throw new IllegalArgumentException("null alias passed to getKey.");
        }
        return (Key) this.keys.get(alias);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String alias) {
        return this.certs.get(alias) != null && this.keys.get(alias) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String alias) {
        return this.keys.get(alias) != null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        if (this.keys.get(alias) != null) {
            throw new KeyStoreException("There is a key entry with the name " + alias + ".");
        }
        this.certs.put(alias, cert);
        this.chainCerts.put(new CertId(cert.getPublicKey()), cert);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String alias, Key key, char[] password, Certificate[] chain) throws KeyStoreException {
        if (!(key instanceof PrivateKey)) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if ((key instanceof PrivateKey) && chain == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.keys.get(alias) != null) {
            engineDeleteEntry(alias);
        }
        this.keys.put(alias, key);
        if (chain != null) {
            this.certs.put(alias, chain[0]);
            for (int i10 = 0; i10 != chain.length; i10++) {
                this.chainCerts.put(new CertId(chain[i10].getPublicKey()), chain[i10]);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable tab = new Hashtable();
        Enumeration e2 = this.certs.keys();
        while (e2.hasMoreElements()) {
            tab.put(e2.nextElement(), "cert");
        }
        Enumeration e10 = this.keys.keys();
        while (e10.hasMoreElements()) {
            String a10 = (String) e10.nextElement();
            if (tab.get(a10) == null) {
                tab.put(a10, "key");
            }
        }
        return tab.size();
    }

    protected PrivateKey unwrapKey(AlgorithmIdentifier algId, byte[] data, char[] password, boolean wrongPKCS12Zero) throws IOException {
        ASN1ObjectIdentifier algorithm = algId.getAlgorithm();
        try {
            if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams pbeParams = PKCS12PBEParams.getInstance(algId.getParameters());
                PBEParameterSpec defParams = new PBEParameterSpec(pbeParams.getIV(), validateIterationCount(pbeParams.getIterations()));
                Cipher cipher = this.helper.createCipher(algorithm.getId());
                PKCS12Key key = new PKCS12Key(password, wrongPKCS12Zero);
                cipher.init(4, key, defParams);
                return (PrivateKey) cipher.unwrap(data, "", 2);
            }
            if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                return (PrivateKey) createCipher(4, password, algId).unwrap(data, "", 2);
            }
            throw new IOException("exception unwrapping private key - cannot recognise: " + ((Object) algorithm));
        } catch (Exception e2) {
            throw new IOException("exception unwrapping private key - " + e2.toString());
        }
    }

    protected byte[] wrapKey(String algorithm, Key key, PKCS12PBEParams pbeParams, char[] password) throws IOException {
        PBEKeySpec pbeSpec = new PBEKeySpec(password);
        try {
            SecretKeyFactory keyFact = this.helper.createSecretKeyFactory(algorithm);
            PBEParameterSpec defParams = new PBEParameterSpec(pbeParams.getIV(), pbeParams.getIterations().intValue());
            Cipher cipher = this.helper.createCipher(algorithm);
            cipher.init(3, keyFact.generateSecret(pbeSpec), defParams);
            byte[] out = cipher.wrap(key);
            return out;
        } catch (Exception e2) {
            throw new IOException("exception encrypting data - " + e2.toString());
        }
    }

    protected byte[] cryptData(boolean forEncryption, AlgorithmIdentifier algId, char[] password, boolean wrongPKCS12Zero, byte[] data) throws IOException {
        ASN1ObjectIdentifier algorithm = algId.getAlgorithm();
        int mode = forEncryption ? 1 : 2;
        if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            PKCS12PBEParams pbeParams = PKCS12PBEParams.getInstance(algId.getParameters());
            try {
                PBEParameterSpec defParams = new PBEParameterSpec(pbeParams.getIV(), pbeParams.getIterations().intValue());
                PKCS12Key key = new PKCS12Key(password, wrongPKCS12Zero);
                Cipher cipher = this.helper.createCipher(algorithm.getId());
                cipher.init(mode, key, defParams);
                return cipher.doFinal(data);
            } catch (Exception e2) {
                throw new IOException("exception decrypting data - " + e2.toString());
            }
        }
        if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
            try {
                return createCipher(mode, password, algId).doFinal(data);
            } catch (Exception e10) {
                throw new IOException("exception decrypting data - " + e10.toString());
            }
        }
        throw new IOException("unknown PBE algorithm: " + ((Object) algorithm));
    }

    private Cipher createCipher(int mode, char[] password, AlgorithmIdentifier algId) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException {
        SecretKey key;
        PBES2Parameters alg = PBES2Parameters.getInstance(algId.getParameters());
        PBKDF2Params func = PBKDF2Params.getInstance(alg.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier encScheme = AlgorithmIdentifier.getInstance(alg.getEncryptionScheme());
        SecretKeyFactory keyFact = this.selfHelper.createSecretKeyFactory(alg.getKeyDerivationFunc().getAlgorithm().getId());
        if (func.isDefaultPrf()) {
            key = keyFact.generateSecret(new PBEKeySpec(password, func.getSalt(), validateIterationCount(func.getIterationCount()), keySizeProvider.getKeySize(encScheme)));
        } else {
            key = keyFact.generateSecret(new PBKDF2KeySpec(password, func.getSalt(), validateIterationCount(func.getIterationCount()), keySizeProvider.getKeySize(encScheme), func.getPrf()));
        }
        Cipher cipher = this.selfHelper.createCipher(alg.getEncryptionScheme().getAlgorithm().getId());
        ASN1Encodable encParams = alg.getEncryptionScheme().getParameters();
        if (encParams instanceof ASN1OctetString) {
            cipher.init(mode, key, new IvParameterSpec(ASN1OctetString.getInstance(encParams).getOctets()));
        }
        return cipher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream stream, char[] password) throws IOException {
        Vector chain;
        boolean wrongPKCS12Zero;
        String str;
        String str2;
        String str3;
        SafeBag b4;
        ASN1OctetString content;
        int head;
        ASN1InputStream bIn;
        Pfx bag;
        int head2;
        ContentInfo[] c4;
        String str4;
        String str5;
        boolean wrongPKCS12Zero2;
        EncryptedData d10;
        byte[] octets;
        ASN1Sequence seq;
        String str6;
        boolean wrongPKCS12Zero3;
        ASN1Sequence seq2;
        String str7;
        int head3;
        ASN1InputStream bIn2;
        Pfx bag2;
        Pfx bag3;
        char[] cArr = password;
        if (stream == null) {
            return;
        }
        BufferedInputStream bufIn = new BufferedInputStream(stream);
        bufIn.mark(10);
        int head4 = bufIn.read();
        if (head4 != 48) {
            throw new IOException("stream does not represent a PKCS12 key store");
        }
        bufIn.reset();
        ASN1InputStream bIn3 = new ASN1InputStream(bufIn);
        try {
            Pfx bag4 = Pfx.getInstance(bIn3.readObject());
            ContentInfo info = bag4.getAuthSafe();
            Vector chain2 = new Vector();
            boolean unmarkedKey = false;
            boolean wrongPKCS12Zero4 = false;
            if (bag4.getMacData() == null) {
                chain = chain2;
                wrongPKCS12Zero = false;
            } else {
                if (cArr == null) {
                    throw new NullPointerException("no password supplied when one expected");
                }
                MacData mData = bag4.getMacData();
                DigestInfo dInfo = mData.getMac();
                this.macAlgorithm = dInfo.getAlgorithmId();
                byte[] salt = mData.getSalt();
                this.itCount = validateIterationCount(mData.getIterationCount());
                this.saltLength = salt.length;
                byte[] data = ((ASN1OctetString) info.getContent()).getOctets();
                try {
                    chain = chain2;
                    try {
                        byte[] res = calculatePbeMac(this.macAlgorithm.getAlgorithm(), salt, this.itCount, password, false, data);
                        byte[] dig = dInfo.getDigest();
                        if (!Arrays.constantTimeAreEqual(res, dig)) {
                            try {
                                if (cArr.length > 0) {
                                    throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                                }
                                byte[] res2 = calculatePbeMac(this.macAlgorithm.getAlgorithm(), salt, this.itCount, password, true, data);
                                if (!Arrays.constantTimeAreEqual(res2, dig)) {
                                    throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                                }
                                wrongPKCS12Zero4 = true;
                            } catch (IOException e2) {
                                throw e2;
                            } catch (Exception e10) {
                                e = e10;
                                throw new IOException("error constructing MAC: " + e.toString());
                            }
                        }
                        wrongPKCS12Zero = wrongPKCS12Zero4;
                    } catch (IOException e11) {
                        throw e11;
                    } catch (Exception e12) {
                        e = e12;
                    }
                } catch (IOException e13) {
                    throw e13;
                } catch (Exception e14) {
                    e = e14;
                }
            }
            this.keys = new IgnoresCaseHashtable();
            this.localIds = new Hashtable();
            String str8 = "unmarked";
            String str9 = "attempt to add existing attribute with different value";
            if (!info.getContentType().equals((ASN1Primitive) data)) {
                str = "attempt to add existing attribute with different value";
                str2 = "unmarked";
            } else {
                ASN1OctetString content2 = ASN1OctetString.getInstance(info.getContent());
                AuthenticatedSafe authSafe = AuthenticatedSafe.getInstance(content2.getOctets());
                ContentInfo[] c10 = authSafe.getContentInfo();
                int i10 = 0;
                while (i10 != c10.length) {
                    if (c10[i10].getContentType().equals((ASN1Primitive) data)) {
                        ASN1OctetString authSafeContent = ASN1OctetString.getInstance(c10[i10].getContent());
                        ASN1Sequence seq3 = ASN1Sequence.getInstance(authSafeContent.getOctets());
                        int j10 = 0;
                        while (true) {
                            content = content2;
                            if (j10 != seq3.size()) {
                                SafeBag b10 = SafeBag.getInstance(seq3.getObjectAt(j10));
                                ASN1OctetString authSafeContent2 = authSafeContent;
                                ASN1Sequence seq4 = seq3;
                                if (b10.getBagId().equals((ASN1Primitive) pkcs8ShroudedKeyBag)) {
                                    EncryptedPrivateKeyInfo eIn = EncryptedPrivateKeyInfo.getInstance(b10.getBagValue());
                                    head3 = head4;
                                    PrivateKey privKey = unwrapKey(eIn.getEncryptionAlgorithm(), eIn.getEncryptedData(), cArr, wrongPKCS12Zero);
                                    String alias = null;
                                    ASN1OctetString localId = null;
                                    if (b10.getBagAttributes() != null) {
                                        Enumeration e15 = b10.getBagAttributes().getObjects();
                                        while (e15.hasMoreElements()) {
                                            EncryptedPrivateKeyInfo eIn2 = eIn;
                                            ASN1Sequence sq = (ASN1Sequence) e15.nextElement();
                                            String alias2 = alias;
                                            ASN1ObjectIdentifier aOid = (ASN1ObjectIdentifier) sq.getObjectAt(0);
                                            ASN1InputStream bIn4 = bIn3;
                                            ASN1Set attrSet = (ASN1Set) sq.getObjectAt(1);
                                            ASN1Primitive attr = null;
                                            if (attrSet.size() > 0) {
                                                bag3 = bag4;
                                                ASN1Primitive attr2 = (ASN1Primitive) attrSet.getObjectAt(0);
                                                if (privKey instanceof PKCS12BagAttributeCarrier) {
                                                    PKCS12BagAttributeCarrier bagAttr = (PKCS12BagAttributeCarrier) privKey;
                                                    ASN1Encodable existing = bagAttr.getBagAttribute(aOid);
                                                    if (existing == null) {
                                                        bagAttr.setBagAttribute(aOid, attr2);
                                                    } else if (!existing.toASN1Primitive().equals(attr2)) {
                                                        throw new IOException(str9);
                                                    }
                                                }
                                                attr = attr2;
                                            } else {
                                                bag3 = bag4;
                                            }
                                            if (aOid.equals((ASN1Primitive) pkcs_9_at_friendlyName)) {
                                                String alias3 = ((DERBMPString) attr).getString();
                                                this.keys.put(alias3, privKey);
                                                alias = alias3;
                                            } else if (!aOid.equals((ASN1Primitive) pkcs_9_at_localKeyId)) {
                                                alias = alias2;
                                            } else {
                                                localId = (ASN1OctetString) attr;
                                                alias = alias2;
                                            }
                                            bIn3 = bIn4;
                                            eIn = eIn2;
                                            bag4 = bag3;
                                        }
                                        bIn2 = bIn3;
                                        bag2 = bag4;
                                    } else {
                                        bIn2 = bIn3;
                                        bag2 = bag4;
                                    }
                                    if (localId != null) {
                                        String name = new String(Hex.encode(localId.getOctets()));
                                        if (alias == null) {
                                            this.keys.put(name, privKey);
                                        } else {
                                            this.localIds.put(alias, name);
                                        }
                                    } else {
                                        unmarkedKey = true;
                                        this.keys.put(str8, privKey);
                                    }
                                } else {
                                    head3 = head4;
                                    bIn2 = bIn3;
                                    bag2 = bag4;
                                    if (b10.getBagId().equals((ASN1Primitive) certBag)) {
                                        chain.addElement(b10);
                                    } else {
                                        System.out.println("extra in data " + ((Object) b10.getBagId()));
                                        System.out.println(ASN1Dump.dumpAsString(b10));
                                    }
                                }
                                j10++;
                                bIn3 = bIn2;
                                content2 = content;
                                authSafeContent = authSafeContent2;
                                seq3 = seq4;
                                head4 = head3;
                                bag4 = bag2;
                            } else {
                                head = head4;
                                bIn = bIn3;
                                bag = bag4;
                                head2 = i10;
                                c4 = c10;
                                str4 = str9;
                                str5 = str8;
                                wrongPKCS12Zero2 = wrongPKCS12Zero;
                                break;
                            }
                        }
                    } else {
                        content = content2;
                        head = head4;
                        bIn = bIn3;
                        bag = bag4;
                        if (c10[i10].getContentType().equals((ASN1Primitive) encryptedData)) {
                            EncryptedData d11 = EncryptedData.getInstance(c10[i10].getContent());
                            head2 = i10;
                            c4 = c10;
                            int i11 = 0;
                            String str10 = str9;
                            str5 = str8;
                            byte[] octets2 = cryptData(false, d11.getEncryptionAlgorithm(), password, wrongPKCS12Zero, d11.getContent().getOctets());
                            ASN1Sequence seq5 = ASN1Sequence.getInstance(octets2);
                            int j11 = 0;
                            while (j11 != seq5.size()) {
                                SafeBag b11 = SafeBag.getInstance(seq5.getObjectAt(j11));
                                if (b11.getBagId().equals((ASN1Primitive) certBag)) {
                                    chain.addElement(b11);
                                    d10 = d11;
                                    octets = octets2;
                                    seq = seq5;
                                    wrongPKCS12Zero3 = wrongPKCS12Zero;
                                    str6 = str10;
                                } else if (b11.getBagId().equals((ASN1Primitive) pkcs8ShroudedKeyBag)) {
                                    EncryptedPrivateKeyInfo eIn3 = EncryptedPrivateKeyInfo.getInstance(b11.getBagValue());
                                    PrivateKey privKey2 = unwrapKey(eIn3.getEncryptionAlgorithm(), eIn3.getEncryptedData(), cArr, wrongPKCS12Zero);
                                    PKCS12BagAttributeCarrier bagAttr2 = (PKCS12BagAttributeCarrier) privKey2;
                                    ASN1OctetString localId2 = null;
                                    Enumeration e16 = b11.getBagAttributes().getObjects();
                                    String alias4 = null;
                                    while (e16.hasMoreElements()) {
                                        EncryptedData d12 = d11;
                                        ASN1Sequence sq2 = (ASN1Sequence) e16.nextElement();
                                        ASN1ObjectIdentifier aOid2 = (ASN1ObjectIdentifier) sq2.getObjectAt(i11);
                                        byte[] octets3 = octets2;
                                        ASN1Set attrSet2 = (ASN1Set) sq2.getObjectAt(1);
                                        ASN1Encodable existing2 = null;
                                        if (attrSet2.size() > 0) {
                                            ASN1Primitive attr3 = (ASN1Primitive) attrSet2.getObjectAt(0);
                                            ASN1Encodable existing3 = bagAttr2.getBagAttribute(aOid2);
                                            if (existing3 == null) {
                                                seq2 = seq5;
                                                str7 = str10;
                                                bagAttr2.setBagAttribute(aOid2, attr3);
                                            } else {
                                                if (!existing3.toASN1Primitive().equals(attr3)) {
                                                    throw new IOException(str10);
                                                }
                                                seq2 = seq5;
                                                str7 = str10;
                                            }
                                            existing2 = attr3;
                                        } else {
                                            seq2 = seq5;
                                            str7 = str10;
                                        }
                                        if (aOid2.equals((ASN1Primitive) pkcs_9_at_friendlyName)) {
                                            String alias5 = ((DERBMPString) existing2).getString();
                                            this.keys.put(alias5, privKey2);
                                            alias4 = alias5;
                                        } else if (aOid2.equals((ASN1Primitive) pkcs_9_at_localKeyId)) {
                                            localId2 = (ASN1OctetString) existing2;
                                        }
                                        str10 = str7;
                                        octets2 = octets3;
                                        d11 = d12;
                                        seq5 = seq2;
                                        i11 = 0;
                                    }
                                    d10 = d11;
                                    octets = octets2;
                                    seq = seq5;
                                    str6 = str10;
                                    String name2 = new String(Hex.encode(localId2.getOctets()));
                                    String alias6 = alias4;
                                    if (alias6 == null) {
                                        this.keys.put(name2, privKey2);
                                    } else {
                                        this.localIds.put(alias6, name2);
                                    }
                                    wrongPKCS12Zero3 = wrongPKCS12Zero;
                                } else {
                                    d10 = d11;
                                    octets = octets2;
                                    seq = seq5;
                                    str6 = str10;
                                    if (b11.getBagId().equals((ASN1Primitive) keyBag)) {
                                        PrivateKeyInfo kInfo = PrivateKeyInfo.getInstance(b11.getBagValue());
                                        PrivateKey privKey3 = BouncyCastleProvider.getPrivateKey(kInfo);
                                        PKCS12BagAttributeCarrier bagAttr3 = (PKCS12BagAttributeCarrier) privKey3;
                                        String alias7 = null;
                                        ASN1OctetString localId3 = null;
                                        Enumeration e17 = b11.getBagAttributes().getObjects();
                                        while (e17.hasMoreElements()) {
                                            PrivateKeyInfo kInfo2 = kInfo;
                                            ASN1Sequence sq3 = ASN1Sequence.getInstance(e17.nextElement());
                                            boolean wrongPKCS12Zero5 = wrongPKCS12Zero;
                                            ASN1ObjectIdentifier aOid3 = ASN1ObjectIdentifier.getInstance(sq3.getObjectAt(0));
                                            ASN1Set attrSet3 = ASN1Set.getInstance(sq3.getObjectAt(1));
                                            if (attrSet3.size() > 0) {
                                                ASN1Primitive attr4 = (ASN1Primitive) attrSet3.getObjectAt(0);
                                                ASN1Encodable existing4 = bagAttr3.getBagAttribute(aOid3);
                                                if (existing4 == null) {
                                                    bagAttr3.setBagAttribute(aOid3, attr4);
                                                } else if (!existing4.toASN1Primitive().equals(attr4)) {
                                                    throw new IOException(str6);
                                                }
                                                if (aOid3.equals((ASN1Primitive) pkcs_9_at_friendlyName)) {
                                                    alias7 = ((DERBMPString) attr4).getString();
                                                    this.keys.put(alias7, privKey3);
                                                } else if (aOid3.equals((ASN1Primitive) pkcs_9_at_localKeyId)) {
                                                    localId3 = (ASN1OctetString) attr4;
                                                }
                                            }
                                            wrongPKCS12Zero = wrongPKCS12Zero5;
                                            kInfo = kInfo2;
                                        }
                                        wrongPKCS12Zero3 = wrongPKCS12Zero;
                                        String name3 = new String(Hex.encode(localId3.getOctets()));
                                        if (alias7 == null) {
                                            this.keys.put(name3, privKey3);
                                        } else {
                                            this.localIds.put(alias7, name3);
                                        }
                                    } else {
                                        wrongPKCS12Zero3 = wrongPKCS12Zero;
                                        System.out.println("extra in encryptedData " + ((Object) b11.getBagId()));
                                        System.out.println(ASN1Dump.dumpAsString(b11));
                                    }
                                }
                                j11++;
                                cArr = password;
                                str10 = str6;
                                octets2 = octets;
                                wrongPKCS12Zero = wrongPKCS12Zero3;
                                d11 = d10;
                                seq5 = seq;
                                i11 = 0;
                            }
                            wrongPKCS12Zero2 = wrongPKCS12Zero;
                            str4 = str10;
                        } else {
                            head2 = i10;
                            c4 = c10;
                            str4 = str9;
                            str5 = str8;
                            wrongPKCS12Zero2 = wrongPKCS12Zero;
                            System.out.println("extra " + c4[head2].getContentType().getId());
                            System.out.println("extra " + ASN1Dump.dumpAsString(c4[head2].getContent()));
                        }
                    }
                    i10 = head2 + 1;
                    cArr = password;
                    str9 = str4;
                    c10 = c4;
                    bIn3 = bIn;
                    content2 = content;
                    wrongPKCS12Zero = wrongPKCS12Zero2;
                    head4 = head;
                    bag4 = bag;
                    str8 = str5;
                }
                str2 = str8;
                str = str9;
            }
            this.certs = new IgnoresCaseHashtable();
            this.chainCerts = new Hashtable();
            this.keyCerts = new Hashtable();
            int i12 = 0;
            while (i12 != chain.size()) {
                SafeBag b12 = (SafeBag) chain.elementAt(i12);
                CertBag cb2 = CertBag.getInstance(b12.getBagValue());
                if (!cb2.getCertId().equals((ASN1Primitive) x509Certificate)) {
                    throw new RuntimeException("Unsupported certificate type: " + ((Object) cb2.getCertId()));
                }
                try {
                    ByteArrayInputStream cIn = new ByteArrayInputStream(((ASN1OctetString) cb2.getCertValue()).getOctets());
                    Certificate generateCertificate = this.certFact.generateCertificate(cIn);
                    ASN1OctetString localId4 = null;
                    String alias8 = null;
                    if (b12.getBagAttributes() != null) {
                        Enumeration e18 = b12.getBagAttributes().getObjects();
                        while (e18.hasMoreElements()) {
                            ASN1Sequence sq4 = ASN1Sequence.getInstance(e18.nextElement());
                            ASN1ObjectIdentifier oid = ASN1ObjectIdentifier.getInstance(sq4.getObjectAt(0));
                            ASN1Set attrSet4 = ASN1Set.getInstance(sq4.getObjectAt(1));
                            if (attrSet4.size() <= 0) {
                                b4 = b12;
                            } else {
                                ASN1Primitive attr5 = (ASN1Primitive) attrSet4.getObjectAt(0);
                                if (!(generateCertificate instanceof PKCS12BagAttributeCarrier)) {
                                    b4 = b12;
                                } else {
                                    PKCS12BagAttributeCarrier bagAttr4 = (PKCS12BagAttributeCarrier) generateCertificate;
                                    ASN1Encodable existing5 = bagAttr4.getBagAttribute(oid);
                                    if (existing5 != null) {
                                        b4 = b12;
                                        if (!existing5.toASN1Primitive().equals(attr5)) {
                                            throw new IOException(str);
                                        }
                                    } else {
                                        b4 = b12;
                                        bagAttr4.setBagAttribute(oid, attr5);
                                    }
                                }
                                if (oid.equals((ASN1Primitive) pkcs_9_at_friendlyName)) {
                                    alias8 = ((DERBMPString) attr5).getString();
                                } else if (oid.equals((ASN1Primitive) pkcs_9_at_localKeyId)) {
                                    localId4 = (ASN1OctetString) attr5;
                                }
                            }
                            b12 = b4;
                        }
                    }
                    this.chainCerts.put(new CertId(generateCertificate.getPublicKey()), generateCertificate);
                    if (unmarkedKey) {
                        if (!this.keyCerts.isEmpty()) {
                            str3 = str2;
                        } else {
                            String name4 = new String(Hex.encode(createSubjectKeyId(generateCertificate.getPublicKey()).getKeyIdentifier()));
                            this.keyCerts.put(name4, generateCertificate);
                            IgnoresCaseHashtable ignoresCaseHashtable = this.keys;
                            str3 = str2;
                            ignoresCaseHashtable.put(name4, ignoresCaseHashtable.remove(str3));
                        }
                    } else {
                        str3 = str2;
                        if (localId4 != null) {
                            this.keyCerts.put(new String(Hex.encode(localId4.getOctets())), generateCertificate);
                        }
                        if (alias8 != null) {
                            this.certs.put(alias8, generateCertificate);
                        }
                    }
                    i12++;
                    str2 = str3;
                } catch (Exception e19) {
                    throw new RuntimeException(e19.toString());
                }
            }
        } catch (Exception e20) {
            throw new IOException(e20.getMessage());
        }
    }

    private int validateIterationCount(BigInteger i10) {
        int count = i10.intValue();
        if (count < 0) {
            throw new IllegalStateException("negative iteration count found");
        }
        BigInteger maxValue = Properties.asBigInteger(PKCS12_MAX_IT_COUNT_PROPERTY);
        if (maxValue != null && maxValue.intValue() < count) {
            throw new IllegalStateException("iteration count " + count + " greater than " + maxValue.intValue());
        }
        return count;
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        PKCS12StoreParameter bcParam;
        char[] password;
        if (param == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        if (!(param instanceof PKCS12StoreParameter) && !(param instanceof JDKPKCS12StoreParameter)) {
            throw new IllegalArgumentException("No support for 'param' of type " + param.getClass().getName());
        }
        if (param instanceof PKCS12StoreParameter) {
            bcParam = (PKCS12StoreParameter) param;
        } else {
            bcParam = new PKCS12StoreParameter(((JDKPKCS12StoreParameter) param).getOutputStream(), param.getProtectionParameter(), ((JDKPKCS12StoreParameter) param).isUseDEREncoding());
        }
        KeyStore.ProtectionParameter protParam = param.getProtectionParameter();
        if (protParam == null) {
            password = null;
        } else if (protParam instanceof KeyStore.PasswordProtection) {
            password = ((KeyStore.PasswordProtection) protParam).getPassword();
        } else {
            throw new IllegalArgumentException("No support for protection parameter of type " + protParam.getClass().getName());
        }
        doStore(bcParam.getOutputStream(), password, bcParam.isForDEREncoding());
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream stream, char[] password) throws IOException {
        doStore(stream, password, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e8 A[Catch: CertificateEncodingException -> 0x01cb, TRY_ENTER, TRY_LEAVE, TryCatch #13 {CertificateEncodingException -> 0x01cb, blocks: (B:47:0x01bd, B:52:0x01e8), top: B:46:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ff A[Catch: CertificateEncodingException -> 0x0240, TRY_LEAVE, TryCatch #4 {CertificateEncodingException -> 0x0240, blocks: (B:50:0x01e0, B:54:0x01f5, B:55:0x01f9, B:57:0x01ff, B:82:0x01d4), top: B:53:0x01f5 }] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.security.cert.Certificate, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.security.cert.Certificate, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Hashtable] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Hashtable] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.Set] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doStore(java.io.OutputStream r32, char[] r33, boolean r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.doStore(java.io.OutputStream, char[], boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SafeBag createSafeBag(String certId, Certificate certificate) throws CertificateEncodingException {
        CertBag cBag = new CertBag(x509Certificate, new DEROctetString(certificate.getEncoded()));
        ASN1EncodableVector fName = new ASN1EncodableVector();
        boolean cAttrSet = false;
        if (certificate instanceof PKCS12BagAttributeCarrier) {
            PKCS12BagAttributeCarrier bagAttrs = (PKCS12BagAttributeCarrier) certificate;
            DERBMPString nm = (DERBMPString) bagAttrs.getBagAttribute(pkcs_9_at_friendlyName);
            if ((nm == null || !nm.getString().equals(certId)) && certId != null) {
                bagAttrs.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(certId));
            }
            Enumeration e2 = bagAttrs.getBagAttributeKeys();
            while (e2.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                if (!oid.equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                    ASN1EncodableVector fSeq = new ASN1EncodableVector();
                    fSeq.add(oid);
                    fSeq.add(new DERSet(bagAttrs.getBagAttribute(oid)));
                    fName.add(new DERSequence(fSeq));
                    cAttrSet = true;
                }
            }
        }
        if (!cAttrSet) {
            ASN1EncodableVector fSeq2 = new ASN1EncodableVector();
            fSeq2.add(pkcs_9_at_friendlyName);
            fSeq2.add(new DERSet(new DERBMPString(certId)));
            fName.add(new DERSequence(fSeq2));
        }
        return new SafeBag(certBag, cBag.toASN1Primitive(), new DERSet(fName));
    }

    private Set getUsedCertificateSet() {
        Set usedSet = new HashSet();
        Enumeration en = this.keys.keys();
        while (en.hasMoreElements()) {
            String alias = (String) en.nextElement();
            Certificate[] certs = engineGetCertificateChain(alias);
            for (int i10 = 0; i10 != certs.length; i10++) {
                usedSet.add(certs[i10]);
            }
        }
        Enumeration en2 = this.certs.keys();
        while (en2.hasMoreElements()) {
            String alias2 = (String) en2.nextElement();
            Certificate cert = engineGetCertificate(alias2);
            usedSet.add(cert);
        }
        return usedSet;
    }

    private byte[] calculatePbeMac(ASN1ObjectIdentifier oid, byte[] salt, int itCount, char[] password, boolean wrongPkcs12Zero, byte[] data) throws Exception {
        PBEParameterSpec defParams = new PBEParameterSpec(salt, itCount);
        Mac mac = this.selfHelper.createMac(oid.getId());
        mac.init(new PKCS12Key(password, wrongPkcs12Zero), defParams);
        mac.update(data);
        return mac.doFinal();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new DefaultJcaJceHelper(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public void put(String key, Object value) {
            String lower = key == null ? null : Strings.toLowerCase(key);
            String k10 = (String) this.keys.get(lower);
            if (k10 != null) {
                this.orig.remove(k10);
            }
            this.keys.put(lower, key);
            this.orig.put(key, value);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public Object remove(String alias) {
            String k10 = (String) this.keys.remove(alias == null ? null : Strings.toLowerCase(alias));
            if (k10 == null) {
                return null;
            }
            return this.orig.remove(k10);
        }

        public Object get(String alias) {
            String k10 = (String) this.keys.get(alias == null ? null : Strings.toLowerCase(alias));
            if (k10 == null) {
                return null;
            }
            return this.orig.get(k10);
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public int size() {
            return this.orig.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        DefaultSecretKeyProvider() {
            Map keySizes = new HashMap();
            keySizes.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            keySizes.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
            keySizes.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            keySizes.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
            keySizes.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(keySizes);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer keySize = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (keySize != null) {
                return keySize.intValue();
            }
            return -1;
        }
    }
}
