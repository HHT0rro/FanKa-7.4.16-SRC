package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.security.auth.x500.X500Principal;
import sun.misc.HexDumpEncoder;
import sun.security.provider.X509Factory;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CertImpl extends X509Certificate implements DerEncoder {
    public static final String ALG_ID = "algorithm";
    private static final String AUTH_INFO_ACCESS_OID = "1.3.6.1.5.5.7.1.1";
    private static final String BASIC_CONSTRAINT_OID = "2.5.29.19";
    private static final String DOT = ".";
    private static final String EXTENDED_KEY_USAGE_OID = "2.5.29.37";
    public static final String INFO = "info";
    private static final String ISSUER_ALT_NAME_OID = "2.5.29.18";
    public static final String ISSUER_DN = "x509.info.issuer.dname";
    private static final String KEY_USAGE_OID = "2.5.29.15";
    public static final String NAME = "x509";
    private static final int NUM_STANDARD_KEY_USAGE = 9;
    public static final String PUBLIC_KEY = "x509.info.key.value";
    public static final String SERIAL_ID = "x509.info.serialNumber.number";
    public static final String SIG = "x509.signature";
    public static final String SIGNATURE = "signature";
    public static final String SIGNED_CERT = "signed_cert";
    public static final String SIG_ALG = "x509.algorithm";
    private static final String SUBJECT_ALT_NAME_OID = "2.5.29.17";
    public static final String SUBJECT_DN = "x509.info.subject.dname";
    public static final String VERSION = "x509.info.version.number";
    private static final long serialVersionUID = -3457612960190864406L;
    protected AlgorithmId algId;
    private Set<AccessDescription> authInfoAccess;
    private List<String> extKeyUsage;
    private ConcurrentHashMap<String, String> fingerprints;
    protected X509CertInfo info;
    private Collection<List<?>> issuerAlternativeNames;
    private boolean readOnly;
    protected byte[] signature;
    private byte[] signedCert;
    private Collection<List<?>> subjectAlternativeNames;
    private boolean verificationResult;
    private String verifiedProvider;
    private PublicKey verifiedPublicKey;

    public X509CertImpl() {
        this.readOnly = false;
        this.signedCert = null;
        this.info = null;
        this.algId = null;
        this.signature = null;
        this.fingerprints = new ConcurrentHashMap<>(2);
    }

    public X509CertImpl(byte[] certData) throws CertificateException {
        this.readOnly = false;
        this.signedCert = null;
        this.info = null;
        this.algId = null;
        this.signature = null;
        this.fingerprints = new ConcurrentHashMap<>(2);
        try {
            parse(new DerValue(certData));
        } catch (IOException e2) {
            this.signedCert = null;
            throw new CertificateException("Unable to initialize, " + ((Object) e2), e2);
        }
    }

    public X509CertImpl(X509CertInfo certInfo) {
        this.readOnly = false;
        this.signedCert = null;
        this.info = null;
        this.algId = null;
        this.signature = null;
        this.fingerprints = new ConcurrentHashMap<>(2);
        this.info = certInfo;
    }

    public X509CertImpl(DerValue derVal) throws CertificateException {
        this.readOnly = false;
        this.signedCert = null;
        this.info = null;
        this.algId = null;
        this.signature = null;
        this.fingerprints = new ConcurrentHashMap<>(2);
        try {
            parse(derVal);
        } catch (IOException e2) {
            this.signedCert = null;
            throw new CertificateException("Unable to initialize, " + ((Object) e2), e2);
        }
    }

    public X509CertImpl(DerValue derVal, byte[] encoded) throws CertificateException {
        this.readOnly = false;
        this.signedCert = null;
        this.info = null;
        this.algId = null;
        this.signature = null;
        this.fingerprints = new ConcurrentHashMap<>(2);
        try {
            parse(derVal, encoded);
        } catch (IOException e2) {
            this.signedCert = null;
            throw new CertificateException("Unable to initialize, " + ((Object) e2), e2);
        }
    }

    public void encode(OutputStream out) throws CertificateEncodingException {
        byte[] bArr = this.signedCert;
        if (bArr == null) {
            throw new CertificateEncodingException("Null certificate to encode");
        }
        try {
            out.write((byte[]) bArr.clone());
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        byte[] bArr = this.signedCert;
        if (bArr == null) {
            throw new IOException("Null certificate to encode");
        }
        out.write((byte[]) bArr.clone());
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return (byte[]) getEncodedInternal().clone();
    }

    public byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] bArr = this.signedCert;
        if (bArr == null) {
            throw new CertificateEncodingException("Null certificate to encode");
        }
        return bArr;
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verify(key, "");
    }

    @Override // java.security.cert.Certificate
    public synchronized void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature sigVerf;
        if (sigProvider == null) {
            sigProvider = "";
        }
        PublicKey publicKey = this.verifiedPublicKey;
        if (publicKey != null && publicKey.equals(key) && sigProvider.equals(this.verifiedProvider)) {
            if (!this.verificationResult) {
                throw new SignatureException("Signature does not match.");
            }
            return;
        }
        if (this.signedCert == null) {
            throw new CertificateEncodingException("Uninitialized certificate");
        }
        if (sigProvider.length() == 0) {
            sigVerf = Signature.getInstance(this.algId.getName());
        } else {
            sigVerf = Signature.getInstance(this.algId.getName(), sigProvider);
        }
        sigVerf.initVerify(key);
        byte[] rawCert = this.info.getEncodedInfo();
        sigVerf.update(rawCert, 0, rawCert.length);
        boolean verify = sigVerf.verify(this.signature);
        this.verificationResult = verify;
        this.verifiedPublicKey = key;
        this.verifiedProvider = sigProvider;
        if (!verify) {
            throw new SignatureException("Signature does not match.");
        }
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public synchronized void verify(PublicKey key, Provider sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sigVerf;
        if (this.signedCert == null) {
            throw new CertificateEncodingException("Uninitialized certificate");
        }
        if (sigProvider == null) {
            sigVerf = Signature.getInstance(this.algId.getName());
        } else {
            sigVerf = Signature.getInstance(this.algId.getName(), sigProvider);
        }
        sigVerf.initVerify(key);
        byte[] rawCert = this.info.getEncodedInfo();
        sigVerf.update(rawCert, 0, rawCert.length);
        boolean verify = sigVerf.verify(this.signature);
        this.verificationResult = verify;
        this.verifiedPublicKey = key;
        if (!verify) {
            throw new SignatureException("Signature does not match.");
        }
    }

    public static void verify(X509Certificate cert, PublicKey key, Provider sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        cert.verify(key, sigProvider);
    }

    public void sign(PrivateKey key, String algorithm) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        sign(key, algorithm, null);
    }

    public void sign(PrivateKey key, String algorithm, String provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature sigEngine;
        try {
            if (this.readOnly) {
                throw new CertificateEncodingException("cannot over-write existing certificate");
            }
            if (provider != null && provider.length() != 0) {
                sigEngine = Signature.getInstance(algorithm, provider);
                sigEngine.initSign(key);
                this.algId = AlgorithmId.get(sigEngine.getAlgorithm());
                DerOutputStream out = new DerOutputStream();
                DerOutputStream tmp = new DerOutputStream();
                this.info.encode(tmp);
                byte[] rawCert = tmp.toByteArray();
                this.algId.encode(tmp);
                sigEngine.update(rawCert, 0, rawCert.length);
                byte[] sign = sigEngine.sign();
                this.signature = sign;
                tmp.putBitString(sign);
                out.write((byte) 48, tmp);
                this.signedCert = out.toByteArray();
                this.readOnly = true;
            }
            sigEngine = Signature.getInstance(algorithm);
            sigEngine.initSign(key);
            this.algId = AlgorithmId.get(sigEngine.getAlgorithm());
            DerOutputStream out2 = new DerOutputStream();
            DerOutputStream tmp2 = new DerOutputStream();
            this.info.encode(tmp2);
            byte[] rawCert2 = tmp2.toByteArray();
            this.algId.encode(tmp2);
            sigEngine.update(rawCert2, 0, rawCert2.length);
            byte[] sign2 = sigEngine.sign();
            this.signature = sign2;
            tmp2.putBitString(sign2);
            out2.write((byte) 48, tmp2);
            this.signedCert = out2.toByteArray();
            this.readOnly = true;
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        Date date = new Date();
        checkValidity(date);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        try {
            CertificateValidity interval = (CertificateValidity) this.info.get("validity");
            if (interval == null) {
                throw new CertificateNotYetValidException("Null validity period");
            }
            interval.valid(date);
        } catch (Exception e2) {
            throw new CertificateNotYetValidException("Incorrect validity period");
        }
    }

    public Object get(String name) throws CertificateParsingException {
        X509AttributeName attr = new X509AttributeName(name);
        String id2 = attr.getPrefix();
        if (!id2.equalsIgnoreCase(NAME)) {
            throw new CertificateParsingException("Invalid root of attribute name, expected [x509], received [" + id2 + "]");
        }
        X509AttributeName attr2 = new X509AttributeName(attr.getSuffix());
        String id3 = attr2.getPrefix();
        if (id3.equalsIgnoreCase("info")) {
            if (this.info == null) {
                return null;
            }
            if (attr2.getSuffix() != null) {
                try {
                    return this.info.get(attr2.getSuffix());
                } catch (IOException e2) {
                    throw new CertificateParsingException(e2.toString());
                } catch (CertificateException e10) {
                    throw new CertificateParsingException(e10.toString());
                }
            }
            return this.info;
        }
        if (id3.equalsIgnoreCase("algorithm")) {
            return this.algId;
        }
        if (id3.equalsIgnoreCase("signature")) {
            byte[] bArr = this.signature;
            if (bArr != null) {
                return bArr.clone();
            }
            return null;
        }
        if (id3.equalsIgnoreCase(SIGNED_CERT)) {
            byte[] bArr2 = this.signedCert;
            if (bArr2 != null) {
                return bArr2.clone();
            }
            return null;
        }
        throw new CertificateParsingException("Attribute name not recognized or get() not allowed for the same: " + id3);
    }

    public void set(String name, Object obj) throws CertificateException, IOException {
        if (this.readOnly) {
            throw new CertificateException("cannot over-write existing certificate");
        }
        X509AttributeName attr = new X509AttributeName(name);
        String id2 = attr.getPrefix();
        if (!id2.equalsIgnoreCase(NAME)) {
            throw new CertificateException("Invalid root of attribute name, expected [x509], received " + id2);
        }
        X509AttributeName attr2 = new X509AttributeName(attr.getSuffix());
        String id3 = attr2.getPrefix();
        if (id3.equalsIgnoreCase("info")) {
            if (attr2.getSuffix() == null) {
                if (!(obj instanceof X509CertInfo)) {
                    throw new CertificateException("Attribute value should be of type X509CertInfo.");
                }
                this.info = (X509CertInfo) obj;
                this.signedCert = null;
                return;
            }
            this.info.set(attr2.getSuffix(), obj);
            this.signedCert = null;
            return;
        }
        throw new CertificateException("Attribute name not recognized or set() not allowed for the same: " + id3);
    }

    public void delete(String name) throws CertificateException, IOException {
        if (this.readOnly) {
            throw new CertificateException("cannot over-write existing certificate");
        }
        X509AttributeName attr = new X509AttributeName(name);
        String id2 = attr.getPrefix();
        if (!id2.equalsIgnoreCase(NAME)) {
            throw new CertificateException("Invalid root of attribute name, expected [x509], received " + id2);
        }
        X509AttributeName attr2 = new X509AttributeName(attr.getSuffix());
        String id3 = attr2.getPrefix();
        if (id3.equalsIgnoreCase("info")) {
            if (attr2.getSuffix() != null) {
                this.info = null;
                return;
            } else {
                this.info.delete(attr2.getSuffix());
                return;
            }
        }
        if (id3.equalsIgnoreCase("algorithm")) {
            this.algId = null;
        } else if (id3.equalsIgnoreCase("signature")) {
            this.signature = null;
        } else {
            if (id3.equalsIgnoreCase(SIGNED_CERT)) {
                this.signedCert = null;
                return;
            }
            throw new CertificateException("Attribute name not recognized or delete() not allowed for the same: " + id3);
        }
    }

    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(X509CertInfo.IDENT);
        elements.addElement(SIG_ALG);
        elements.addElement(SIG);
        elements.addElement("x509.signed_cert");
        return elements.elements();
    }

    public String getName() {
        return NAME;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        if (this.info == null || this.algId == null || this.signature == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        sb2.append(this.info.toString() + "\n");
        sb2.append("  Algorithm: [" + this.algId.toString() + "]\n");
        HexDumpEncoder encoder = new HexDumpEncoder();
        sb2.append("  Signature:\n" + encoder.encodeBuffer(this.signature));
        sb2.append("\n]");
        return sb2.toString();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            PublicKey key = (PublicKey) x509CertInfo.get("key.value");
            return key;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return -1;
        }
        try {
            int vers = ((Integer) x509CertInfo.get("version.number")).intValue();
            return vers + 1;
        } catch (Exception e2) {
            return -1;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        SerialNumber ser = getSerialNumberObject();
        if (ser != null) {
            return ser.getNumber();
        }
        return null;
    }

    public SerialNumber getSerialNumberObject() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            SerialNumber ser = (SerialNumber) x509CertInfo.get("serialNumber.number");
            return ser;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            Principal subject = (Principal) x509CertInfo.get("subject.dname");
            return subject;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            X500Principal subject = (X500Principal) x509CertInfo.get("subject.x500principal");
            return subject;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            Principal issuer = (Principal) x509CertInfo.get("issuer.dname");
            return issuer;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            X500Principal issuer = (X500Principal) x509CertInfo.get("issuer.x500principal");
            return issuer;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            Date d10 = (Date) x509CertInfo.get("validity.notBefore");
            return d10;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            Date d10 = (Date) x509CertInfo.get("validity.notAfter");
            return d10;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo != null) {
            return x509CertInfo.getEncodedInfo();
        }
        throw new CertificateEncodingException("Uninitialized certificate");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        byte[] bArr = this.signature;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        AlgorithmId algorithmId = this.algId;
        if (algorithmId == null) {
            return null;
        }
        return algorithmId.getName();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        AlgorithmId algorithmId = this.algId;
        if (algorithmId == null) {
            return null;
        }
        ObjectIdentifier oid = algorithmId.getOID();
        return oid.toString();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        AlgorithmId algorithmId = this.algId;
        if (algorithmId == null) {
            return null;
        }
        try {
            return algorithmId.getEncodedParams();
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            UniqueIdentity id2 = (UniqueIdentity) x509CertInfo.get(X509CertInfo.ISSUER_ID);
            if (id2 == null) {
                return null;
            }
            return id2.getId();
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            UniqueIdentity id2 = (UniqueIdentity) x509CertInfo.get(X509CertInfo.SUBJECT_ID);
            if (id2 == null) {
                return null;
            }
            return id2.getId();
        } catch (Exception e2) {
            return null;
        }
    }

    public KeyIdentifier getAuthKeyId() {
        AuthorityKeyIdentifierExtension aki = getAuthorityKeyIdentifierExtension();
        if (aki != null) {
            try {
                return (KeyIdentifier) aki.get("key_id");
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    public KeyIdentifier getSubjectKeyId() {
        SubjectKeyIdentifierExtension ski = getSubjectKeyIdentifierExtension();
        if (ski != null) {
            try {
                return ski.get("key_id");
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    public AuthorityKeyIdentifierExtension getAuthorityKeyIdentifierExtension() {
        return (AuthorityKeyIdentifierExtension) getExtension(PKIXExtensions.AuthorityKey_Id);
    }

    public BasicConstraintsExtension getBasicConstraintsExtension() {
        return (BasicConstraintsExtension) getExtension(PKIXExtensions.BasicConstraints_Id);
    }

    public CertificatePoliciesExtension getCertificatePoliciesExtension() {
        return (CertificatePoliciesExtension) getExtension(PKIXExtensions.CertificatePolicies_Id);
    }

    public ExtendedKeyUsageExtension getExtendedKeyUsageExtension() {
        return (ExtendedKeyUsageExtension) getExtension(PKIXExtensions.ExtendedKeyUsage_Id);
    }

    public IssuerAlternativeNameExtension getIssuerAlternativeNameExtension() {
        return (IssuerAlternativeNameExtension) getExtension(PKIXExtensions.IssuerAlternativeName_Id);
    }

    public NameConstraintsExtension getNameConstraintsExtension() {
        return (NameConstraintsExtension) getExtension(PKIXExtensions.NameConstraints_Id);
    }

    public PolicyConstraintsExtension getPolicyConstraintsExtension() {
        return (PolicyConstraintsExtension) getExtension(PKIXExtensions.PolicyConstraints_Id);
    }

    public PolicyMappingsExtension getPolicyMappingsExtension() {
        return (PolicyMappingsExtension) getExtension(PKIXExtensions.PolicyMappings_Id);
    }

    public PrivateKeyUsageExtension getPrivateKeyUsageExtension() {
        return (PrivateKeyUsageExtension) getExtension(PKIXExtensions.PrivateKeyUsage_Id);
    }

    public SubjectAlternativeNameExtension getSubjectAlternativeNameExtension() {
        return (SubjectAlternativeNameExtension) getExtension(PKIXExtensions.SubjectAlternativeName_Id);
    }

    public SubjectKeyIdentifierExtension getSubjectKeyIdentifierExtension() {
        return (SubjectKeyIdentifierExtension) getExtension(PKIXExtensions.SubjectKey_Id);
    }

    public CRLDistributionPointsExtension getCRLDistributionPointsExtension() {
        return (CRLDistributionPointsExtension) getExtension(PKIXExtensions.CRLDistributionPoints_Id);
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return false;
        }
        try {
            CertificateExtensions exts = (CertificateExtensions) x509CertInfo.get("extensions");
            if (exts == null) {
                return false;
            }
            return exts.hasUnsupportedCriticalExtension();
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            CertificateExtensions exts = (CertificateExtensions) x509CertInfo.get("extensions");
            if (exts == null) {
                return null;
            }
            Set<String> extSet = new TreeSet<>();
            for (Extension ex : exts.getAllExtensions()) {
                if (ex.isCritical()) {
                    extSet.add(ex.getExtensionId().toString());
                }
            }
            return extSet;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            CertificateExtensions exts = (CertificateExtensions) x509CertInfo.get("extensions");
            if (exts == null) {
                return null;
            }
            Set<String> extSet = new TreeSet<>();
            for (Extension ex : exts.getAllExtensions()) {
                if (!ex.isCritical()) {
                    extSet.add(ex.getExtensionId().toString());
                }
            }
            extSet.addAll(exts.getUnparseableExtensions().h());
            return extSet;
        } catch (Exception e2) {
            return null;
        }
    }

    public Extension getExtension(ObjectIdentifier oid) {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            try {
                CertificateExtensions extensions = (CertificateExtensions) x509CertInfo.get("extensions");
                if (extensions == null) {
                    return null;
                }
                Extension ex = extensions.getExtension(oid.toString());
                if (ex != null) {
                    return ex;
                }
                for (Extension ex2 : extensions.getAllExtensions()) {
                    if (ex2.getExtensionId().equals((Object) oid)) {
                        return ex2;
                    }
                }
                return null;
            } catch (IOException e2) {
                return null;
            }
        } catch (CertificateException e10) {
            return null;
        }
    }

    public Extension getUnparseableExtension(ObjectIdentifier oid) {
        X509CertInfo x509CertInfo = this.info;
        if (x509CertInfo == null) {
            return null;
        }
        try {
            try {
                CertificateExtensions extensions = (CertificateExtensions) x509CertInfo.get("extensions");
                if (extensions == null) {
                    return null;
                }
                return extensions.getUnparseableExtensions().get(oid.toString());
            } catch (CertificateException e2) {
                return null;
            }
        } catch (IOException e10) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        try {
            ObjectIdentifier findOID = new ObjectIdentifier(oid);
            String extAlias = OIDMap.getName(findOID);
            Extension certExt = null;
            CertificateExtensions exts = (CertificateExtensions) this.info.get("extensions");
            if (extAlias == null) {
                if (exts == null) {
                    return null;
                }
                Iterator<Extension> iterator2 = exts.getAllExtensions().iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    Extension ex = iterator2.next();
                    ObjectIdentifier inCertOID = ex.getExtensionId();
                    if (inCertOID.equals((Object) findOID)) {
                        certExt = ex;
                        break;
                    }
                }
            } else {
                try {
                    certExt = (Extension) get(extAlias);
                } catch (CertificateException e2) {
                }
            }
            if (certExt == null) {
                if (exts != null) {
                    certExt = exts.getUnparseableExtensions().get(oid);
                }
                if (certExt == null) {
                    return null;
                }
            }
            byte[] extData = certExt.getExtensionValue();
            if (extData == null) {
                return null;
            }
            DerOutputStream out = new DerOutputStream();
            out.putOctetString(extData);
            return out.toByteArray();
        } catch (Exception e10) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        KeyUsageExtension certExt;
        try {
            String extAlias = OIDMap.getName(PKIXExtensions.KeyUsage_Id);
            if (extAlias == null || (certExt = (KeyUsageExtension) get(extAlias)) == null) {
                return null;
            }
            boolean[] ret = certExt.getBits();
            if (ret.length < 9) {
                boolean[] usageBits = new boolean[9];
                System.arraycopy((Object) ret, 0, (Object) usageBits, 0, ret.length);
                return usageBits;
            }
            return ret;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public synchronized List<String> getExtendedKeyUsage() throws CertificateParsingException {
        List<String> list;
        if (this.readOnly && (list = this.extKeyUsage) != null) {
            return list;
        }
        ExtendedKeyUsageExtension ext = getExtendedKeyUsageExtension();
        if (ext == null) {
            return null;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(ext.getExtendedKeyUsage());
        this.extKeyUsage = unmodifiableList;
        return unmodifiableList;
    }

    public static List<String> getExtendedKeyUsage(X509Certificate cert) throws CertificateParsingException {
        try {
            byte[] ext = cert.getExtensionValue(EXTENDED_KEY_USAGE_OID);
            if (ext == null) {
                return null;
            }
            DerValue val = new DerValue(ext);
            byte[] data = val.getOctetString();
            ExtendedKeyUsageExtension ekuExt = new ExtendedKeyUsageExtension(Boolean.FALSE, data);
            return Collections.unmodifiableList(ekuExt.getExtendedKeyUsage());
        } catch (IOException ioe) {
            throw new CertificateParsingException(ioe);
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraintsExtension certExt;
        try {
            String extAlias = OIDMap.getName(PKIXExtensions.BasicConstraints_Id);
            if (extAlias == null || (certExt = (BasicConstraintsExtension) get(extAlias)) == null || !((Boolean) certExt.get(BasicConstraintsExtension.IS_CA)).booleanValue()) {
                return -1;
            }
            return ((Integer) certExt.get(BasicConstraintsExtension.PATH_LEN)).intValue();
        } catch (Exception e2) {
            return -1;
        }
    }

    private static Collection<List<?>> makeAltNames(GeneralNames names) {
        if (names.isEmpty()) {
            return Collections.emptySet();
        }
        List<List<?>> newNames = new ArrayList<>();
        for (GeneralName gname : names.names()) {
            GeneralNameInterface name = gname.getName();
            List<Object> nameEntry = new ArrayList<>(2);
            nameEntry.add(Integer.valueOf(name.getType()));
            switch (name.getType()) {
                case 1:
                    nameEntry.add(((RFC822Name) name).getName());
                    break;
                case 2:
                    nameEntry.add(((DNSName) name).getName());
                    break;
                case 3:
                case 5:
                default:
                    DerOutputStream derOut = new DerOutputStream();
                    try {
                        name.encode(derOut);
                        nameEntry.add(derOut.toByteArray());
                        break;
                    } catch (IOException ioe) {
                        throw new RuntimeException("name cannot be encoded", ioe);
                    }
                case 4:
                    nameEntry.add(((X500Name) name).getRFC2253Name());
                    break;
                case 6:
                    nameEntry.add(((URIName) name).getName());
                    break;
                case 7:
                    try {
                        nameEntry.add(((IPAddressName) name).getName());
                        break;
                    } catch (IOException ioe2) {
                        throw new RuntimeException("IPAddress cannot be parsed", ioe2);
                    }
                case 8:
                    nameEntry.add(((OIDName) name).getOID().toString());
                    break;
            }
            newNames.add(Collections.unmodifiableList(nameEntry));
        }
        return Collections.unmodifiableCollection(newNames);
    }

    private static Collection<List<?>> cloneAltNames(Collection<List<?>> altNames) {
        boolean mustClone = false;
        Iterator<List<?>> iterator2 = altNames.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().get(1) instanceof byte[]) {
                mustClone = true;
            }
        }
        if (mustClone) {
            List<List<?>> namesCopy = new ArrayList<>();
            for (List<?> nameEntry : altNames) {
                Object nameObject = nameEntry.get(1);
                if (nameObject instanceof byte[]) {
                    List<Object> nameEntryCopy = new ArrayList<>(nameEntry);
                    nameEntryCopy.set(1, ((byte[]) nameObject).clone());
                    namesCopy.add(Collections.unmodifiableList(nameEntryCopy));
                } else {
                    namesCopy.add(nameEntry);
                }
            }
            return Collections.unmodifiableCollection(namesCopy);
        }
        return altNames;
    }

    @Override // java.security.cert.X509Certificate
    public synchronized Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> collection;
        if (this.readOnly && (collection = this.subjectAlternativeNames) != null) {
            return cloneAltNames(collection);
        }
        SubjectAlternativeNameExtension subjectAltNameExt = getSubjectAlternativeNameExtension();
        if (subjectAltNameExt == null) {
            return null;
        }
        try {
            GeneralNames names = subjectAltNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
            Collection<List<?>> makeAltNames = makeAltNames(names);
            this.subjectAlternativeNames = makeAltNames;
            return makeAltNames;
        } catch (IOException e2) {
            return Collections.emptySet();
        }
    }

    public static Collection<List<?>> getSubjectAlternativeNames(X509Certificate cert) throws CertificateParsingException {
        try {
            byte[] ext = cert.getExtensionValue(SUBJECT_ALT_NAME_OID);
            if (ext == null) {
                return null;
            }
            DerValue val = new DerValue(ext);
            byte[] data = val.getOctetString();
            SubjectAlternativeNameExtension subjectAltNameExt = new SubjectAlternativeNameExtension(Boolean.FALSE, data);
            try {
                GeneralNames names = subjectAltNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
                return makeAltNames(names);
            } catch (IOException e2) {
                return Collections.emptySet();
            }
        } catch (IOException ioe) {
            throw new CertificateParsingException(ioe);
        }
    }

    @Override // java.security.cert.X509Certificate
    public synchronized Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> collection;
        if (this.readOnly && (collection = this.issuerAlternativeNames) != null) {
            return cloneAltNames(collection);
        }
        IssuerAlternativeNameExtension issuerAltNameExt = getIssuerAlternativeNameExtension();
        if (issuerAltNameExt == null) {
            return null;
        }
        try {
            GeneralNames names = issuerAltNameExt.get(IssuerAlternativeNameExtension.ISSUER_NAME);
            Collection<List<?>> makeAltNames = makeAltNames(names);
            this.issuerAlternativeNames = makeAltNames;
            return makeAltNames;
        } catch (IOException e2) {
            return Collections.emptySet();
        }
    }

    public static Collection<List<?>> getIssuerAlternativeNames(X509Certificate cert) throws CertificateParsingException {
        try {
            byte[] ext = cert.getExtensionValue(ISSUER_ALT_NAME_OID);
            if (ext == null) {
                return null;
            }
            DerValue val = new DerValue(ext);
            byte[] data = val.getOctetString();
            IssuerAlternativeNameExtension issuerAltNameExt = new IssuerAlternativeNameExtension(Boolean.FALSE, data);
            try {
                GeneralNames names = issuerAltNameExt.get(IssuerAlternativeNameExtension.ISSUER_NAME);
                return makeAltNames(names);
            } catch (IOException e2) {
                return Collections.emptySet();
            }
        } catch (IOException ioe) {
            throw new CertificateParsingException(ioe);
        }
    }

    public AuthorityInfoAccessExtension getAuthorityInfoAccessExtension() {
        return (AuthorityInfoAccessExtension) getExtension(PKIXExtensions.AuthInfoAccess_Id);
    }

    private void parse(DerValue val) throws CertificateException, IOException {
        parse(val, null);
    }

    private void parse(DerValue val, byte[] originalEncodedForm) throws CertificateException, IOException {
        if (this.readOnly) {
            throw new CertificateParsingException("cannot over-write existing certificate");
        }
        if (val.data == null || val.tag != 48) {
            throw new CertificateParsingException("invalid DER-encoded certificate data");
        }
        this.signedCert = originalEncodedForm != null ? originalEncodedForm : val.toByteArray();
        DerValue[] seq = {val.data.getDerValue(), val.data.getDerValue(), val.data.getDerValue()};
        if (val.data.available() != 0) {
            throw new CertificateParsingException("signed overrun, bytes = " + val.data.available());
        }
        if (seq[0].tag != 48) {
            throw new CertificateParsingException("signed fields invalid");
        }
        this.algId = AlgorithmId.parse(seq[1]);
        this.signature = seq[2].getBitString();
        if (seq[1].data.available() != 0) {
            throw new CertificateParsingException("algid field overrun");
        }
        if (seq[2].data.available() != 0) {
            throw new CertificateParsingException("signed fields overrun");
        }
        X509CertInfo x509CertInfo = new X509CertInfo(seq[0]);
        this.info = x509CertInfo;
        AlgorithmId infoSigAlg = (AlgorithmId) x509CertInfo.get("algorithmID.algorithm");
        if (!this.algId.equals(infoSigAlg)) {
            throw new CertificateException("Signature algorithm mismatch");
        }
        this.readOnly = true;
    }

    private static X500Principal getX500Principal(X509Certificate cert, boolean getIssuer) throws Exception {
        byte[] encoded = cert.getEncoded();
        DerInputStream derIn = new DerInputStream(encoded);
        DerValue tbsCert = derIn.getSequence(3)[0];
        DerInputStream tbsIn = tbsCert.data;
        DerValue tmp = tbsIn.getDerValue();
        if (tmp.isContextSpecific((byte) 0)) {
            tbsIn.getDerValue();
        }
        tbsIn.getDerValue();
        DerValue tmp2 = tbsIn.getDerValue();
        if (!getIssuer) {
            tbsIn.getDerValue();
            tmp2 = tbsIn.getDerValue();
        }
        byte[] principalBytes = tmp2.toByteArray();
        return new X500Principal(principalBytes);
    }

    public static X500Principal getSubjectX500Principal(X509Certificate cert) {
        try {
            return getX500Principal(cert, false);
        } catch (Exception e2) {
            throw new RuntimeException("Could not parse subject", e2);
        }
    }

    public static X500Principal getIssuerX500Principal(X509Certificate cert) {
        try {
            return getX500Principal(cert, true);
        } catch (Exception e2) {
            throw new RuntimeException("Could not parse issuer", e2);
        }
    }

    public static byte[] getEncodedInternal(Certificate cert) throws CertificateEncodingException {
        if (cert instanceof X509CertImpl) {
            return ((X509CertImpl) cert).getEncodedInternal();
        }
        return cert.getEncoded();
    }

    public static X509CertImpl toImpl(X509Certificate cert) throws CertificateException {
        if (cert instanceof X509CertImpl) {
            return (X509CertImpl) cert;
        }
        return X509Factory.intern(cert);
    }

    public static boolean isSelfIssued(X509Certificate cert) {
        X500Principal subject = cert.getSubjectX500Principal();
        X500Principal issuer = cert.getIssuerX500Principal();
        return subject.equals(issuer);
    }

    public static boolean isSelfSigned(X509Certificate cert, String sigProvider) {
        if (isSelfIssued(cert)) {
            try {
                if (sigProvider == null) {
                    cert.verify(cert.getPublicKey());
                    return true;
                }
                cert.verify(cert.getPublicKey(), sigProvider);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public static String getFingerprint(String algorithm, X509Certificate cert) {
        try {
            byte[] encCertInfo = cert.getEncoded();
            MessageDigest md2 = MessageDigest.getInstance(algorithm);
            byte[] digest = md2.digest(encCertInfo);
            StringBuffer buf = new StringBuffer();
            for (byte b4 : digest) {
                byte2hex(b4, buf);
            }
            String fingerPrint = buf.toString();
            return fingerPrint;
        } catch (NoSuchAlgorithmException | CertificateEncodingException e2) {
            return "";
        }
    }

    private String getFingerprint(String algorithm, final Debug debug) {
        return this.fingerprints.computeIfAbsent(algorithm, new Function() { // from class: sun.security.x509.X509CertImpl$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String lambda$getFingerprint$0;
                lambda$getFingerprint$0 = X509CertImpl.this.lambda$getFingerprint$0(debug, (String) obj);
                return lambda$getFingerprint$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getFingerprint$0(Debug debug, String x10) {
        try {
            return getFingerprintInternal(x10, getEncodedInternal(), debug);
        } catch (CertificateEncodingException e2) {
            if (debug != null) {
                debug.println("Cannot encode certificate: " + ((Object) e2));
                return null;
            }
            return null;
        }
    }

    private static String getFingerprintInternal(String algorithm, byte[] encodedCert, Debug debug) {
        try {
            MessageDigest md2 = MessageDigest.getInstance(algorithm);
            byte[] digest = md2.digest(encodedCert);
            return HexFormat.of().withUpperCase().formatHex(digest);
        } catch (NoSuchAlgorithmException e2) {
            if (debug != null) {
                debug.println("Cannot create " + algorithm + " MessageDigest: " + ((Object) e2));
                return null;
            }
            return null;
        }
    }

    public static String getFingerprint(String algorithm, X509Certificate cert, Debug debug) {
        if (cert instanceof X509CertImpl) {
            return ((X509CertImpl) cert).getFingerprint(algorithm, debug);
        }
        try {
            return getFingerprintInternal(algorithm, cert.getEncoded(), debug);
        } catch (CertificateEncodingException e2) {
            if (debug != null) {
                debug.println("Cannot encode certificate: " + ((Object) e2));
                return null;
            }
            return null;
        }
    }

    private static void byte2hex(byte b4, StringBuffer buf) {
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int high = (b4 & 240) >> 4;
        int low = b4 & 15;
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }
}
