package sun.security.x509;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.security.auth.x500.X500Principal;
import sun.misc.HexDumpEncoder;
import sun.security.provider.X509Factory;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CRLImpl extends X509CRL implements DerEncoder {
    private static final long YR_2050 = 2524636800000L;
    private static final boolean isExplicit = true;
    private CRLExtensions extensions;
    private AlgorithmId infoSigAlgId;
    private X500Name issuer;
    private X500Principal issuerPrincipal;
    private Date nextUpdate;
    private boolean readOnly;
    private List<X509CRLEntry> revokedList;
    private Map<X509IssuerSerial, X509CRLEntry> revokedMap;
    private AlgorithmId sigAlgId;
    private byte[] signature;
    private byte[] signedCRL;
    private byte[] tbsCertList;
    private Date thisUpdate;
    private String verifiedProvider;
    private PublicKey verifiedPublicKey;
    private int version;

    private X509CRLImpl() {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
    }

    public X509CRLImpl(byte[] crlData) throws CRLException {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
        try {
            parse(new DerValue(crlData));
        } catch (IOException e2) {
            this.signedCRL = null;
            throw new CRLException("Parsing error: " + e2.getMessage());
        }
    }

    public X509CRLImpl(DerValue val) throws CRLException {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
        try {
            parse(val);
        } catch (IOException e2) {
            this.signedCRL = null;
            throw new CRLException("Parsing error: " + e2.getMessage());
        }
    }

    public X509CRLImpl(InputStream inStrm) throws CRLException {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
        try {
            parse(new DerValue(inStrm));
        } catch (IOException e2) {
            this.signedCRL = null;
            throw new CRLException("Parsing error: " + e2.getMessage());
        }
    }

    public X509CRLImpl(X500Name issuer, Date thisDate, Date nextDate) {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
        this.issuer = issuer;
        this.thisUpdate = thisDate;
        this.nextUpdate = nextDate;
    }

    public X509CRLImpl(X500Name issuer, Date thisDate, Date nextDate, X509CRLEntry[] badCerts) throws CRLException {
        this.signedCRL = null;
        this.signature = null;
        this.tbsCertList = null;
        this.sigAlgId = null;
        this.issuer = null;
        this.issuerPrincipal = null;
        this.thisUpdate = null;
        this.nextUpdate = null;
        this.revokedMap = new TreeMap();
        this.revokedList = new LinkedList();
        this.extensions = null;
        this.readOnly = false;
        this.issuer = issuer;
        this.thisUpdate = thisDate;
        this.nextUpdate = nextDate;
        if (badCerts != null) {
            X500Principal crlIssuer = getIssuerX500Principal();
            X500Principal badCertIssuer = crlIssuer;
            for (X509CRLEntry x509CRLEntry : badCerts) {
                X509CRLEntryImpl badCert = (X509CRLEntryImpl) x509CRLEntry;
                try {
                    badCertIssuer = getCertIssuer(badCert, badCertIssuer);
                    badCert.setCertificateIssuer(crlIssuer, badCertIssuer);
                    X509IssuerSerial issuerSerial = new X509IssuerSerial(badCertIssuer, badCert.getSerialNumber());
                    this.revokedMap.put(issuerSerial, badCert);
                    this.revokedList.add(badCert);
                    if (badCert.hasExtensions()) {
                        this.version = 1;
                    }
                } catch (IOException ioe) {
                    throw new CRLException(ioe);
                }
            }
        }
    }

    public X509CRLImpl(X500Name issuer, Date thisDate, Date nextDate, X509CRLEntry[] badCerts, CRLExtensions crlExts) throws CRLException {
        this(issuer, thisDate, nextDate, badCerts);
        if (crlExts != null) {
            this.extensions = crlExts;
            this.version = 1;
        }
    }

    public byte[] getEncodedInternal() throws CRLException {
        byte[] bArr = this.signedCRL;
        if (bArr == null) {
            throw new CRLException("Null CRL to encode");
        }
        return bArr;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        return (byte[]) getEncodedInternal().clone();
    }

    public void encodeInfo(OutputStream out) throws CRLException {
        try {
            DerOutputStream tmp = new DerOutputStream();
            DerOutputStream rCerts = new DerOutputStream();
            DerOutputStream seq = new DerOutputStream();
            int i10 = this.version;
            if (i10 != 0) {
                tmp.putInteger(i10);
            }
            this.infoSigAlgId.encode(tmp);
            if (this.version == 0 && this.issuer.toString() == null) {
                throw new CRLException("Null Issuer DN not allowed in v1 CRL");
            }
            this.issuer.encode(tmp);
            if (this.thisUpdate.getTime() < YR_2050) {
                tmp.putUTCTime(this.thisUpdate);
            } else {
                tmp.putGeneralizedTime(this.thisUpdate);
            }
            Date date = this.nextUpdate;
            if (date != null) {
                if (date.getTime() < YR_2050) {
                    tmp.putUTCTime(this.nextUpdate);
                } else {
                    tmp.putGeneralizedTime(this.nextUpdate);
                }
            }
            if (!this.revokedList.isEmpty()) {
                for (X509CRLEntry entry : this.revokedList) {
                    ((X509CRLEntryImpl) entry).encode(rCerts);
                }
                tmp.write((byte) 48, rCerts);
            }
            CRLExtensions cRLExtensions = this.extensions;
            if (cRLExtensions != null) {
                cRLExtensions.encode(tmp, true);
            }
            seq.write((byte) 48, tmp);
            byte[] byteArray = seq.toByteArray();
            this.tbsCertList = byteArray;
            out.write(byteArray);
        } catch (IOException e2) {
            throw new CRLException("Encoding error: " + e2.getMessage());
        }
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey key) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verify(key, "");
    }

    @Override // java.security.cert.X509CRL
    public synchronized void verify(PublicKey key, String sigProvider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature sigVerf;
        if (sigProvider == null) {
            sigProvider = "";
        }
        PublicKey publicKey = this.verifiedPublicKey;
        if (publicKey != null && publicKey.equals(key) && sigProvider.equals(this.verifiedProvider)) {
            return;
        }
        if (this.signedCRL == null) {
            throw new CRLException("Uninitialized CRL");
        }
        if (sigProvider.length() == 0) {
            sigVerf = Signature.getInstance(this.sigAlgId.getName());
        } else {
            sigVerf = Signature.getInstance(this.sigAlgId.getName(), sigProvider);
        }
        sigVerf.initVerify(key);
        byte[] bArr = this.tbsCertList;
        if (bArr == null) {
            throw new CRLException("Uninitialized CRL");
        }
        sigVerf.update(bArr, 0, bArr.length);
        if (!sigVerf.verify(this.signature)) {
            throw new SignatureException("Signature does not match.");
        }
        this.verifiedPublicKey = key;
        this.verifiedProvider = sigProvider;
    }

    @Override // java.security.cert.X509CRL
    public synchronized void verify(PublicKey key, Provider sigProvider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sigVerf;
        if (this.signedCRL == null) {
            throw new CRLException("Uninitialized CRL");
        }
        if (sigProvider == null) {
            sigVerf = Signature.getInstance(this.sigAlgId.getName());
        } else {
            sigVerf = Signature.getInstance(this.sigAlgId.getName(), sigProvider);
        }
        sigVerf.initVerify(key);
        byte[] bArr = this.tbsCertList;
        if (bArr == null) {
            throw new CRLException("Uninitialized CRL");
        }
        sigVerf.update(bArr, 0, bArr.length);
        if (!sigVerf.verify(this.signature)) {
            throw new SignatureException("Signature does not match.");
        }
        this.verifiedPublicKey = key;
    }

    public void sign(PrivateKey key, String algorithm) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        sign(key, algorithm, null);
    }

    public void sign(PrivateKey key, String algorithm, String provider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature sigEngine;
        try {
            if (this.readOnly) {
                throw new CRLException("cannot over-write existing CRL");
            }
            if (provider != null && provider.length() != 0) {
                sigEngine = Signature.getInstance(algorithm, provider);
                sigEngine.initSign(key);
                AlgorithmId algorithmId = AlgorithmId.get(sigEngine.getAlgorithm());
                this.sigAlgId = algorithmId;
                this.infoSigAlgId = algorithmId;
                DerOutputStream out = new DerOutputStream();
                DerOutputStream tmp = new DerOutputStream();
                encodeInfo(tmp);
                this.sigAlgId.encode(tmp);
                byte[] bArr = this.tbsCertList;
                sigEngine.update(bArr, 0, bArr.length);
                byte[] sign = sigEngine.sign();
                this.signature = sign;
                tmp.putBitString(sign);
                out.write((byte) 48, tmp);
                this.signedCRL = out.toByteArray();
                this.readOnly = true;
            }
            sigEngine = Signature.getInstance(algorithm);
            sigEngine.initSign(key);
            AlgorithmId algorithmId2 = AlgorithmId.get(sigEngine.getAlgorithm());
            this.sigAlgId = algorithmId2;
            this.infoSigAlgId = algorithmId2;
            DerOutputStream out2 = new DerOutputStream();
            DerOutputStream tmp2 = new DerOutputStream();
            encodeInfo(tmp2);
            this.sigAlgId.encode(tmp2);
            byte[] bArr2 = this.tbsCertList;
            sigEngine.update(bArr2, 0, bArr2.length);
            byte[] sign2 = sigEngine.sign();
            this.signature = sign2;
            tmp2.putBitString(sign2);
            out2.write((byte) 48, tmp2);
            this.signedCRL = out2.toByteArray();
            this.readOnly = true;
        } catch (IOException e2) {
            throw new CRLException("Error while encoding data: " + e2.getMessage());
        }
    }

    @Override // java.security.cert.CRL
    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        sb2.append("X.509 CRL v" + (this.version + 1) + "\n");
        if (this.sigAlgId != null) {
            sb2.append("Signature Algorithm: " + this.sigAlgId.toString() + ", OID=" + this.sigAlgId.getOID().toString() + "\n");
        }
        if (this.issuer != null) {
            sb2.append("Issuer: " + this.issuer.toString() + "\n");
        }
        if (this.thisUpdate != null) {
            sb2.append("\nThis Update: " + this.thisUpdate.toString() + "\n");
        }
        if (this.nextUpdate != null) {
            sb2.append("Next Update: " + this.nextUpdate.toString() + "\n");
        }
        if (this.revokedList.isEmpty()) {
            sb2.append("\nNO certificates have been revoked\n");
        } else {
            sb2.append("\nRevoked Certificates: " + this.revokedList.size());
            int i10 = 1;
            for (X509CRLEntry entry : this.revokedList) {
                sb2.append("\n[" + i10 + "] " + entry.toString());
                i10++;
            }
        }
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions != null) {
            Collection<Extension> allExts = cRLExtensions.getAllExtensions();
            Object[] objs = allExts.toArray();
            sb2.append("\nCRL Extensions: " + objs.length);
            for (int i11 = 0; i11 < objs.length; i11++) {
                sb2.append("\n[" + (i11 + 1) + "]: ");
                Extension ext = (Extension) objs[i11];
                try {
                    if (OIDMap.getClass(ext.getExtensionId()) == null) {
                        sb2.append(ext.toString());
                        byte[] extValue = ext.getExtensionValue();
                        if (extValue != null) {
                            DerOutputStream out = new DerOutputStream();
                            out.putOctetString(extValue);
                            byte[] extValue2 = out.toByteArray();
                            HexDumpEncoder enc = new HexDumpEncoder();
                            sb2.append("Extension unknown: DER encoded OCTET string =\n" + enc.encodeBuffer(extValue2) + "\n");
                        }
                    } else {
                        sb2.append(ext.toString());
                    }
                } catch (Exception e2) {
                    sb2.append(", Error parsing this extension");
                }
            }
        }
        if (this.signature != null) {
            HexDumpEncoder encoder = new HexDumpEncoder();
            sb2.append("\nSignature:\n" + encoder.encodeBuffer(this.signature) + "\n");
        } else {
            sb2.append("NOT signed yet\n");
        }
        return sb2.toString();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate cert) {
        if (this.revokedMap.isEmpty() || !(cert instanceof X509Certificate)) {
            return false;
        }
        X509Certificate xcert = (X509Certificate) cert;
        X509IssuerSerial issuerSerial = new X509IssuerSerial(xcert);
        return this.revokedMap.containsKey(issuerSerial);
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.version + 1;
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return this.issuer;
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        if (this.issuerPrincipal == null) {
            this.issuerPrincipal = this.issuer.asX500Principal();
        }
        return this.issuerPrincipal;
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return new Date(this.thisUpdate.getTime());
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        if (this.nextUpdate == null) {
            return null;
        }
        return new Date(this.nextUpdate.getTime());
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger serialNumber) {
        if (this.revokedMap.isEmpty()) {
            return null;
        }
        X509IssuerSerial issuerSerial = new X509IssuerSerial(getIssuerX500Principal(), serialNumber);
        return this.revokedMap.get(issuerSerial);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(X509Certificate cert) {
        if (this.revokedMap.isEmpty()) {
            return null;
        }
        X509IssuerSerial issuerSerial = new X509IssuerSerial(cert);
        return this.revokedMap.get(issuerSerial);
    }

    @Override // java.security.cert.X509CRL
    public Set<X509CRLEntry> getRevokedCertificates() {
        if (this.revokedList.isEmpty()) {
            return null;
        }
        return new TreeSet(this.revokedList);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        byte[] bArr = this.tbsCertList;
        if (bArr == null) {
            throw new CRLException("Uninitialized CRL");
        }
        return (byte[]) bArr.clone();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        byte[] bArr = this.signature;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        AlgorithmId algorithmId = this.sigAlgId;
        if (algorithmId == null) {
            return null;
        }
        return algorithmId.getName();
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        AlgorithmId algorithmId = this.sigAlgId;
        if (algorithmId == null) {
            return null;
        }
        ObjectIdentifier oid = algorithmId.getOID();
        return oid.toString();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        AlgorithmId algorithmId = this.sigAlgId;
        if (algorithmId == null) {
            return null;
        }
        try {
            return algorithmId.getEncodedParams();
        } catch (IOException e2) {
            return null;
        }
    }

    public AlgorithmId getSigAlgId() {
        return this.sigAlgId;
    }

    public KeyIdentifier getAuthKeyId() throws IOException {
        AuthorityKeyIdentifierExtension aki = getAuthKeyIdExtension();
        if (aki != null) {
            KeyIdentifier keyId = (KeyIdentifier) aki.get("key_id");
            return keyId;
        }
        return null;
    }

    public AuthorityKeyIdentifierExtension getAuthKeyIdExtension() throws IOException {
        Object obj = getExtension(PKIXExtensions.AuthorityKey_Id);
        return (AuthorityKeyIdentifierExtension) obj;
    }

    public CRLNumberExtension getCRLNumberExtension() throws IOException {
        Object obj = getExtension(PKIXExtensions.CRLNumber_Id);
        return (CRLNumberExtension) obj;
    }

    public BigInteger getCRLNumber() throws IOException {
        CRLNumberExtension numExt = getCRLNumberExtension();
        if (numExt != null) {
            BigInteger num = numExt.get("value");
            return num;
        }
        return null;
    }

    public DeltaCRLIndicatorExtension getDeltaCRLIndicatorExtension() throws IOException {
        Object obj = getExtension(PKIXExtensions.DeltaCRLIndicator_Id);
        return (DeltaCRLIndicatorExtension) obj;
    }

    public BigInteger getBaseCRLNumber() throws IOException {
        DeltaCRLIndicatorExtension dciExt = getDeltaCRLIndicatorExtension();
        if (dciExt != null) {
            BigInteger num = dciExt.get("value");
            return num;
        }
        return null;
    }

    public IssuerAlternativeNameExtension getIssuerAltNameExtension() throws IOException {
        Object obj = getExtension(PKIXExtensions.IssuerAlternativeName_Id);
        return (IssuerAlternativeNameExtension) obj;
    }

    public IssuingDistributionPointExtension getIssuingDistributionPointExtension() throws IOException {
        Object obj = getExtension(PKIXExtensions.IssuingDistributionPoint_Id);
        return (IssuingDistributionPointExtension) obj;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions == null) {
            return false;
        }
        return cRLExtensions.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        if (this.extensions == null) {
            return null;
        }
        Set<String> extSet = new TreeSet<>();
        for (Extension ex : this.extensions.getAllExtensions()) {
            if (ex.isCritical()) {
                extSet.add(ex.getExtensionId().toString());
            }
        }
        return extSet;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        if (this.extensions == null) {
            return null;
        }
        Set<String> extSet = new TreeSet<>();
        for (Extension ex : this.extensions.getAllExtensions()) {
            if (!ex.isCritical()) {
                extSet.add(ex.getExtensionId().toString());
            }
        }
        return extSet;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        byte[] extData;
        if (this.extensions == null) {
            return null;
        }
        try {
            String extAlias = OIDMap.getName(new ObjectIdentifier(oid));
            Extension crlExt = null;
            if (extAlias == null) {
                ObjectIdentifier findOID = new ObjectIdentifier(oid);
                Enumeration<Extension> e2 = this.extensions.getElements();
                while (true) {
                    if (!e2.hasMoreElements()) {
                        break;
                    }
                    Extension ex = e2.nextElement();
                    ObjectIdentifier inCertOID = ex.getExtensionId();
                    if (inCertOID.equals((Object) findOID)) {
                        crlExt = ex;
                        break;
                    }
                }
            } else {
                crlExt = this.extensions.get(extAlias);
            }
            if (crlExt == null || (extData = crlExt.getExtensionValue()) == null) {
                return null;
            }
            DerOutputStream out = new DerOutputStream();
            out.putOctetString(extData);
            return out.toByteArray();
        } catch (Exception e10) {
            return null;
        }
    }

    public Object getExtension(ObjectIdentifier oid) {
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions == null) {
            return null;
        }
        return cRLExtensions.get(OIDMap.getName(oid));
    }

    private void parse(DerValue val) throws CRLException, IOException {
        if (this.readOnly) {
            throw new CRLException("cannot over-write existing CRL");
        }
        if (val.getData() == null || val.tag != 48) {
            throw new CRLException("Invalid DER-encoded CRL data");
        }
        this.signedCRL = val.toByteArray();
        DerValue[] seq = {val.data.getDerValue(), val.data.getDerValue(), val.data.getDerValue()};
        if (val.data.available() != 0) {
            throw new CRLException("signed overrun, bytes = " + val.data.available());
        }
        if (seq[0].tag != 48) {
            throw new CRLException("signed CRL fields invalid");
        }
        this.sigAlgId = AlgorithmId.parse(seq[1]);
        this.signature = seq[2].getBitString();
        if (seq[1].data.available() != 0) {
            throw new CRLException("AlgorithmId field overrun");
        }
        if (seq[2].data.available() != 0) {
            throw new CRLException("Signature field overrun");
        }
        this.tbsCertList = seq[0].toByteArray();
        DerInputStream derStrm = seq[0].data;
        this.version = 0;
        if (((byte) derStrm.peekByte()) == 2) {
            int integer = derStrm.getInteger();
            this.version = integer;
            if (integer != 1) {
                throw new CRLException("Invalid version");
            }
        }
        AlgorithmId tmpId = AlgorithmId.parse(derStrm.getDerValue());
        if (!tmpId.equals(this.sigAlgId)) {
            throw new CRLException("Signature algorithm mismatch");
        }
        this.infoSigAlgId = tmpId;
        X500Name x500Name = new X500Name(derStrm);
        this.issuer = x500Name;
        if (x500Name.isEmpty()) {
            throw new CRLException("Empty issuer DN not allowed in X509CRLs");
        }
        byte nextByte = (byte) derStrm.peekByte();
        if (nextByte == 23) {
            this.thisUpdate = derStrm.getUTCTime();
        } else if (nextByte == 24) {
            this.thisUpdate = derStrm.getGeneralizedTime();
        } else {
            throw new CRLException("Invalid encoding for thisUpdate (tag=" + ((int) nextByte) + ")");
        }
        if (derStrm.available() == 0) {
            return;
        }
        byte nextByte2 = (byte) derStrm.peekByte();
        if (nextByte2 == 23) {
            this.nextUpdate = derStrm.getUTCTime();
        } else if (nextByte2 == 24) {
            this.nextUpdate = derStrm.getGeneralizedTime();
        }
        if (derStrm.available() == 0) {
            return;
        }
        byte nextByte3 = (byte) derStrm.peekByte();
        if (nextByte3 == 48 && (nextByte3 & 192) != 128) {
            DerValue[] badCerts = derStrm.getSequence(4);
            X500Principal crlIssuer = getIssuerX500Principal();
            X500Principal badCertIssuer = crlIssuer;
            for (DerValue derValue : badCerts) {
                X509CRLEntryImpl entry = new X509CRLEntryImpl(derValue);
                badCertIssuer = getCertIssuer(entry, badCertIssuer);
                entry.setCertificateIssuer(crlIssuer, badCertIssuer);
                X509IssuerSerial issuerSerial = new X509IssuerSerial(badCertIssuer, entry.getSerialNumber());
                this.revokedMap.put(issuerSerial, entry);
                this.revokedList.add(entry);
            }
        }
        if (derStrm.available() == 0) {
            return;
        }
        DerValue tmp = derStrm.getDerValue();
        if (tmp.isConstructed() && tmp.isContextSpecific((byte) 0)) {
            this.extensions = new CRLExtensions(tmp.data);
        }
        this.readOnly = true;
    }

    public static X500Principal getIssuerX500Principal(X509CRL crl) {
        try {
            byte[] encoded = crl.getEncoded();
            DerInputStream derIn = new DerInputStream(encoded);
            DerValue tbsCert = derIn.getSequence(3)[0];
            DerInputStream tbsIn = tbsCert.data;
            byte nextByte = (byte) tbsIn.peekByte();
            if (nextByte == 2) {
                tbsIn.getDerValue();
            }
            tbsIn.getDerValue();
            DerValue tmp = tbsIn.getDerValue();
            byte[] principalBytes = tmp.toByteArray();
            return new X500Principal(principalBytes);
        } catch (Exception e2) {
            throw new RuntimeException("Could not parse issuer", e2);
        }
    }

    public static byte[] getEncodedInternal(X509CRL crl) throws CRLException {
        if (crl instanceof X509CRLImpl) {
            return ((X509CRLImpl) crl).getEncodedInternal();
        }
        return crl.getEncoded();
    }

    public static X509CRLImpl toImpl(X509CRL crl) throws CRLException {
        if (crl instanceof X509CRLImpl) {
            return (X509CRLImpl) crl;
        }
        return X509Factory.intern(crl);
    }

    private X500Principal getCertIssuer(X509CRLEntryImpl entry, X500Principal prevCertIssuer) throws IOException {
        CertificateIssuerExtension ciExt = entry.getCertificateIssuerExtension();
        if (ciExt != null) {
            GeneralNames names = ciExt.get("issuer");
            X500Name issuerDN = (X500Name) names.get(0).getName();
            return issuerDN.asX500Principal();
        }
        return prevCertIssuer;
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        byte[] bArr = this.signedCRL;
        if (bArr == null) {
            throw new IOException("Null CRL to encode");
        }
        out.write((byte[]) bArr.clone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class X509IssuerSerial implements Comparable<X509IssuerSerial> {
        volatile int hashcode;
        final X500Principal issuer;
        final BigInteger serial;

        X509IssuerSerial(X500Principal issuer, BigInteger serial) {
            this.hashcode = 0;
            this.issuer = issuer;
            this.serial = serial;
        }

        X509IssuerSerial(X509Certificate cert) {
            this(cert.getIssuerX500Principal(), cert.getSerialNumber());
        }

        X500Principal getIssuer() {
            return this.issuer;
        }

        BigInteger getSerial() {
            return this.serial;
        }

        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof X509IssuerSerial)) {
                return false;
            }
            X509IssuerSerial other = (X509IssuerSerial) o10;
            return this.serial.equals(other.getSerial()) && this.issuer.equals(other.getIssuer());
        }

        public int hashCode() {
            if (this.hashcode == 0) {
                int result = (17 * 37) + this.issuer.hashCode();
                this.hashcode = (result * 37) + this.serial.hashCode();
            }
            int result2 = this.hashcode;
            return result2;
        }

        @Override // java.lang.Comparable
        public int compareTo(X509IssuerSerial another) {
            int cissuer = this.issuer.toString().compareTo(another.issuer.toString());
            return cissuer != 0 ? cissuer : this.serial.compareTo(another.serial);
        }
    }
}
