package sun.security.pkcs;

import com.android.internal.midi.MidiConstants;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.CryptoPrimitive;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import sun.misc.HexDumpEncoder;
import sun.security.timestamp.TimestampToken;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.DisabledAlgorithmConstraints;
import sun.security.util.KeyUtil;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.KeyUsageExtension;
import sun.security.x509.X500Name;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SignerInfo implements DerEncoder {
    PKCS9Attributes authenticatedAttributes;
    BigInteger certificateSerialNumber;
    AlgorithmId digestAlgorithmId;
    AlgorithmId digestEncryptionAlgorithmId;
    byte[] encryptedDigest;
    private boolean hasTimestamp;
    X500Name issuerName;
    Timestamp timestamp;
    PKCS9Attributes unauthenticatedAttributes;
    BigInteger version;
    private static final Set<CryptoPrimitive> DIGEST_PRIMITIVE_SET = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.MESSAGE_DIGEST));
    private static final Set<CryptoPrimitive> SIG_PRIMITIVE_SET = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.SIGNATURE));
    private static final DisabledAlgorithmConstraints JAR_DISABLED_CHECK = new DisabledAlgorithmConstraints(DisabledAlgorithmConstraints.PROPERTY_JAR_DISABLED_ALGS);

    public SignerInfo() {
        this.hasTimestamp = true;
    }

    public SignerInfo(X500Name issuerName, BigInteger serial, AlgorithmId digestAlgorithmId, AlgorithmId digestEncryptionAlgorithmId, byte[] encryptedDigest) {
        this.hasTimestamp = true;
        this.version = BigInteger.ONE;
        this.issuerName = issuerName;
        this.certificateSerialNumber = serial;
        this.digestAlgorithmId = digestAlgorithmId;
        this.digestEncryptionAlgorithmId = digestEncryptionAlgorithmId;
        this.encryptedDigest = encryptedDigest;
    }

    public SignerInfo(X500Name issuerName, BigInteger serial, AlgorithmId digestAlgorithmId, PKCS9Attributes authenticatedAttributes, AlgorithmId digestEncryptionAlgorithmId, byte[] encryptedDigest, PKCS9Attributes unauthenticatedAttributes) {
        this.hasTimestamp = true;
        this.version = BigInteger.ONE;
        this.issuerName = issuerName;
        this.certificateSerialNumber = serial;
        this.digestAlgorithmId = digestAlgorithmId;
        this.authenticatedAttributes = authenticatedAttributes;
        this.digestEncryptionAlgorithmId = digestEncryptionAlgorithmId;
        this.encryptedDigest = encryptedDigest;
        this.unauthenticatedAttributes = unauthenticatedAttributes;
    }

    public SignerInfo(DerInputStream derin) throws IOException, ParsingException {
        this(derin, false);
    }

    public SignerInfo(DerInputStream derin, boolean oldStyle) throws IOException, ParsingException {
        this.hasTimestamp = true;
        this.version = derin.getBigInteger();
        DerValue[] issuerAndSerialNumber = derin.getSequence(2);
        byte[] issuerBytes = issuerAndSerialNumber[0].toByteArray();
        this.issuerName = new X500Name(new DerValue((byte) 48, issuerBytes));
        this.certificateSerialNumber = issuerAndSerialNumber[1].getBigInteger();
        DerValue tmp = derin.getDerValue();
        this.digestAlgorithmId = AlgorithmId.parse(tmp);
        if (oldStyle) {
            derin.getSet(0);
        } else if (((byte) derin.peekByte()) == -96) {
            this.authenticatedAttributes = new PKCS9Attributes(derin);
        }
        DerValue tmp2 = derin.getDerValue();
        this.digestEncryptionAlgorithmId = AlgorithmId.parse(tmp2);
        this.encryptedDigest = derin.getOctetString();
        if (oldStyle) {
            derin.getSet(0);
        } else if (derin.available() != 0 && ((byte) derin.peekByte()) == -95) {
            this.unauthenticatedAttributes = new PKCS9Attributes(derin, true);
        }
        if (derin.available() != 0) {
            throw new ParsingException("extra data at the end");
        }
    }

    public void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream seq = new DerOutputStream();
        seq.putInteger(this.version);
        DerOutputStream issuerAndSerialNumber = new DerOutputStream();
        this.issuerName.encode(issuerAndSerialNumber);
        issuerAndSerialNumber.putInteger(this.certificateSerialNumber);
        seq.write((byte) 48, issuerAndSerialNumber);
        this.digestAlgorithmId.encode(seq);
        PKCS9Attributes pKCS9Attributes = this.authenticatedAttributes;
        if (pKCS9Attributes != null) {
            pKCS9Attributes.encode(MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, seq);
        }
        this.digestEncryptionAlgorithmId.encode(seq);
        seq.putOctetString(this.encryptedDigest);
        PKCS9Attributes pKCS9Attributes2 = this.unauthenticatedAttributes;
        if (pKCS9Attributes2 != null) {
            pKCS9Attributes2.encode((byte) -95, seq);
        }
        DerOutputStream tmp = new DerOutputStream();
        tmp.write((byte) 48, seq);
        out.write(tmp.toByteArray());
    }

    public X509Certificate getCertificate(PKCS7 block) throws IOException {
        return block.getCertificate(this.certificateSerialNumber, this.issuerName);
    }

    public ArrayList<X509Certificate> getCertificateChain(PKCS7 block) throws IOException {
        boolean match;
        X509Certificate userCert = block.getCertificate(this.certificateSerialNumber, this.issuerName);
        if (userCert == null) {
            return null;
        }
        ArrayList<X509Certificate> certList = new ArrayList<>();
        certList.add(userCert);
        X509Certificate[] pkcsCerts = block.getCertificates();
        if (pkcsCerts == null || userCert.getSubjectDN().equals(userCert.getIssuerDN())) {
            return certList;
        }
        Principal issuer = userCert.getIssuerDN();
        int start = 0;
        do {
            match = false;
            int i10 = start;
            while (true) {
                if (i10 >= pkcsCerts.length) {
                    break;
                }
                if (issuer.equals(pkcsCerts[i10].getSubjectDN())) {
                    certList.add(pkcsCerts[i10]);
                    if (pkcsCerts[i10].getSubjectDN().equals(pkcsCerts[i10].getIssuerDN())) {
                        start = pkcsCerts.length;
                    } else {
                        issuer = pkcsCerts[i10].getIssuerDN();
                        X509Certificate tmpCert = pkcsCerts[start];
                        pkcsCerts[start] = pkcsCerts[i10];
                        pkcsCerts[i10] = tmpCert;
                        start++;
                    }
                    match = true;
                } else {
                    i10++;
                }
            }
        } while (match);
        return certList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignerInfo verify(PKCS7 block, byte[] data) throws NoSuchAlgorithmException, SignatureException {
        try {
            return verify(block, new ByteArrayInputStream(data));
        } catch (IOException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignerInfo verify(PKCS7 block, InputStream inputStream) throws NoSuchAlgorithmException, SignatureException, IOException {
        ContentInfo content;
        InputStream inputStream2;
        byte[] messageDigest;
        InputStream dataSigned;
        try {
            content = block.getContentInfo();
            if (inputStream != null) {
                inputStream2 = inputStream;
            } else {
                inputStream2 = new ByteArrayInputStream(content.getContentBytes());
            }
        } catch (IOException e2) {
            e = e2;
        } catch (InvalidKeyException e10) {
            e = e10;
        }
        try {
            try {
                String digestAlgname = getDigestAlgorithmId().getName();
                PKCS9Attributes pKCS9Attributes = this.authenticatedAttributes;
                if (pKCS9Attributes == null) {
                    dataSigned = inputStream2;
                } else {
                    ObjectIdentifier contentType = (ObjectIdentifier) pKCS9Attributes.getAttributeValue(PKCS9Attribute.CONTENT_TYPE_OID);
                    if (contentType == null || !contentType.equals((Object) content.contentType) || (messageDigest = (byte[]) this.authenticatedAttributes.getAttributeValue(PKCS9Attribute.MESSAGE_DIGEST_OID)) == null) {
                        return null;
                    }
                    if (!JAR_DISABLED_CHECK.permits(DIGEST_PRIMITIVE_SET, digestAlgname, null)) {
                        throw new SignatureException("Digest check failed. Disabled algorithm used: " + digestAlgname);
                    }
                    MessageDigest md2 = MessageDigest.getInstance(digestAlgname);
                    byte[] buffer = new byte[4096];
                    while (true) {
                        int read = inputStream2.read(buffer);
                        if (read == -1) {
                            break;
                        }
                        md2.update(buffer, 0, read);
                    }
                    byte[] computedMessageDigest = md2.digest();
                    if (messageDigest.length != computedMessageDigest.length) {
                        return null;
                    }
                    for (int i10 = 0; i10 < messageDigest.length; i10++) {
                        if (messageDigest[i10] != computedMessageDigest[i10]) {
                            return null;
                        }
                    }
                    dataSigned = new ByteArrayInputStream(this.authenticatedAttributes.getDerEncoding());
                }
                String encryptionAlgname = getDigestEncryptionAlgorithmId().getName();
                String tmp = AlgorithmId.getEncAlgFromSigAlg(encryptionAlgname);
                if (tmp != null) {
                    encryptionAlgname = tmp;
                }
                String algname = AlgorithmId.makeSigAlg(digestAlgname, encryptionAlgname);
                DisabledAlgorithmConstraints disabledAlgorithmConstraints = JAR_DISABLED_CHECK;
                Set<CryptoPrimitive> set = SIG_PRIMITIVE_SET;
                if (!disabledAlgorithmConstraints.permits(set, algname, null)) {
                    throw new SignatureException("Signature check failed. Disabled algorithm used: " + algname);
                }
                X509Certificate cert = getCertificate(block);
                if (cert == null) {
                    return null;
                }
                PublicKey key = cert.getPublicKey();
                if (!disabledAlgorithmConstraints.permits(set, key)) {
                    throw new SignatureException("Public key check failed. Disabled key used: " + KeyUtil.getKeySize(key) + " bit " + key.getAlgorithm());
                }
                if (cert.hasUnsupportedCriticalExtension()) {
                    throw new SignatureException("Certificate has unsupported critical extension(s)");
                }
                boolean[] keyUsageBits = cert.getKeyUsage();
                if (keyUsageBits != null) {
                    try {
                        KeyUsageExtension keyUsage = new KeyUsageExtension(keyUsageBits);
                        boolean digSigAllowed = keyUsage.get(KeyUsageExtension.DIGITAL_SIGNATURE).booleanValue();
                        boolean nonRepuAllowed = keyUsage.get(KeyUsageExtension.NON_REPUDIATION).booleanValue();
                        if (!digSigAllowed && !nonRepuAllowed) {
                            throw new SignatureException("Key usage restricted: cannot be used for digital signatures");
                        }
                    } catch (IOException e11) {
                        throw new SignatureException("Failed to parse keyUsage extension");
                    }
                }
                Signature sig = Signature.getInstance(algname);
                sig.initVerify(key);
                byte[] buffer2 = new byte[4096];
                while (true) {
                    int read2 = dataSigned.read(buffer2);
                    if (read2 == -1) {
                        break;
                    }
                    sig.update(buffer2, 0, read2);
                }
                if (sig.verify(this.encryptedDigest)) {
                    return this;
                }
                return null;
            } catch (InvalidKeyException e12) {
                e = e12;
                throw new SignatureException("InvalidKey: " + e.getMessage());
            }
        } catch (IOException e13) {
            e = e13;
            throw new SignatureException("IO error verifying signature:\n" + e.getMessage());
        }
    }

    SignerInfo verify(PKCS7 block) throws NoSuchAlgorithmException, SignatureException {
        return verify(block, (byte[]) null);
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public X500Name getIssuerName() {
        return this.issuerName;
    }

    public BigInteger getCertificateSerialNumber() {
        return this.certificateSerialNumber;
    }

    public AlgorithmId getDigestAlgorithmId() {
        return this.digestAlgorithmId;
    }

    public PKCS9Attributes getAuthenticatedAttributes() {
        return this.authenticatedAttributes;
    }

    public AlgorithmId getDigestEncryptionAlgorithmId() {
        return this.digestEncryptionAlgorithmId;
    }

    public byte[] getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public PKCS9Attributes getUnauthenticatedAttributes() {
        return this.unauthenticatedAttributes;
    }

    public PKCS7 getTsToken() throws IOException {
        PKCS9Attribute tsTokenAttr;
        PKCS9Attributes pKCS9Attributes = this.unauthenticatedAttributes;
        if (pKCS9Attributes == null || (tsTokenAttr = pKCS9Attributes.getAttribute(PKCS9Attribute.SIGNATURE_TIMESTAMP_TOKEN_OID)) == null) {
            return null;
        }
        return new PKCS7((byte[]) tsTokenAttr.getValue());
    }

    public Timestamp getTimestamp() throws IOException, NoSuchAlgorithmException, SignatureException, CertificateException {
        Timestamp timestamp = this.timestamp;
        if (timestamp != null || !this.hasTimestamp) {
            return timestamp;
        }
        PKCS7 tsToken = getTsToken();
        if (tsToken == null) {
            this.hasTimestamp = false;
            return null;
        }
        byte[] encTsTokenInfo = tsToken.getContentInfo().getData();
        SignerInfo[] tsa = tsToken.verify(encTsTokenInfo);
        ArrayList<X509Certificate> chain = tsa[0].getCertificateChain(tsToken);
        CertificateFactory cf = CertificateFactory.getInstance(e.f29912b);
        CertPath tsaChain = cf.generateCertPath(chain);
        TimestampToken tsTokenInfo = new TimestampToken(encTsTokenInfo);
        verifyTimestamp(tsTokenInfo);
        Timestamp timestamp2 = new Timestamp(tsTokenInfo.getDate(), tsaChain);
        this.timestamp = timestamp2;
        return timestamp2;
    }

    private void verifyTimestamp(TimestampToken token) throws NoSuchAlgorithmException, SignatureException {
        String digestAlgname = token.getHashAlgorithm().getName();
        if (!JAR_DISABLED_CHECK.permits(DIGEST_PRIMITIVE_SET, digestAlgname, null)) {
            throw new SignatureException("Timestamp token digest check failed. Disabled algorithm used: " + digestAlgname);
        }
        MessageDigest md2 = MessageDigest.getInstance(digestAlgname);
        if (!Arrays.equals(token.getHashedMessage(), md2.digest(this.encryptedDigest))) {
            throw new SignatureException("Signature timestamp (#" + ((Object) token.getSerialNumber()) + ") generated on " + ((Object) token.getDate()) + " is inapplicable");
        }
    }

    public String toString() {
        HexDumpEncoder hexDump = new HexDumpEncoder();
        String out = ((("Signer Info for (issuer): " + ((Object) this.issuerName) + "\n") + "\tversion: " + Debug.toHexString(this.version) + "\n") + "\tcertificateSerialNumber: " + Debug.toHexString(this.certificateSerialNumber) + "\n") + "\tdigestAlgorithmId: " + ((Object) this.digestAlgorithmId) + "\n";
        if (this.authenticatedAttributes != null) {
            out = out + "\tauthenticatedAttributes: " + ((Object) this.authenticatedAttributes) + "\n";
        }
        String out2 = (out + "\tdigestEncryptionAlgorithmId: " + ((Object) this.digestEncryptionAlgorithmId) + "\n") + "\tencryptedDigest: \n" + hexDump.encodeBuffer(this.encryptedDigest) + "\n";
        if (this.unauthenticatedAttributes != null) {
            return out2 + "\tunauthenticatedAttributes: " + ((Object) this.unauthenticatedAttributes) + "\n";
        }
        return out2;
    }
}
