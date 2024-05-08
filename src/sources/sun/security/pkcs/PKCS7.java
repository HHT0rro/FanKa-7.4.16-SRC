package sun.security.pkcs;

import com.android.internal.midi.MidiConstants;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X500Name;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKCS7 {
    private Principal[] certIssuerNames;
    private X509Certificate[] certificates;
    private ContentInfo contentInfo;
    private ObjectIdentifier contentType;
    private X509CRL[] crls;
    private AlgorithmId[] digestAlgorithmIds;
    private boolean oldStyle;
    private SignerInfo[] signerInfos;
    private BigInteger version;

    public PKCS7(InputStream in) throws ParsingException, IOException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        DataInputStream dis = new DataInputStream(in);
        byte[] data = new byte[dis.available()];
        dis.readFully(data);
        parse(new DerInputStream(data));
    }

    public PKCS7(DerInputStream derin) throws ParsingException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        parse(derin);
    }

    public PKCS7(byte[] bytes) throws ParsingException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        try {
            DerInputStream derin = new DerInputStream(bytes);
            parse(derin);
        } catch (IOException ioe1) {
            ParsingException pe = new ParsingException("Unable to parse the encoded bytes");
            pe.initCause(ioe1);
            throw pe;
        }
    }

    private void parse(DerInputStream derin) throws ParsingException {
        try {
            derin.mark(derin.available());
            parse(derin, false);
        } catch (IOException ioe) {
            try {
                derin.reset();
                parse(derin, true);
                this.oldStyle = true;
            } catch (IOException ioe1) {
                ParsingException pe = new ParsingException(ioe1.getMessage());
                pe.initCause(ioe);
                pe.addSuppressed(ioe1);
                throw pe;
            }
        }
    }

    private void parse(DerInputStream derin, boolean oldStyle) throws IOException {
        ContentInfo contentInfo = new ContentInfo(derin, oldStyle);
        this.contentInfo = contentInfo;
        this.contentType = contentInfo.contentType;
        DerValue content = this.contentInfo.getContent();
        if (this.contentType.equals((Object) ContentInfo.SIGNED_DATA_OID)) {
            parseSignedData(content);
        } else if (this.contentType.equals((Object) ContentInfo.OLD_SIGNED_DATA_OID)) {
            parseOldSignedData(content);
        } else {
            if (this.contentType.equals((Object) ContentInfo.NETSCAPE_CERT_SEQUENCE_OID)) {
                parseNetscapeCertChain(content);
                return;
            }
            throw new ParsingException("content type " + ((Object) this.contentType) + " not supported.");
        }
    }

    public PKCS7(AlgorithmId[] digestAlgorithmIds, ContentInfo contentInfo, X509Certificate[] certificates, X509CRL[] crls, SignerInfo[] signerInfos) {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        this.version = BigInteger.ONE;
        this.digestAlgorithmIds = digestAlgorithmIds;
        this.contentInfo = contentInfo;
        this.certificates = certificates;
        this.crls = crls;
        this.signerInfos = signerInfos;
    }

    public PKCS7(AlgorithmId[] digestAlgorithmIds, ContentInfo contentInfo, X509Certificate[] certificates, SignerInfo[] signerInfos) {
        this(digestAlgorithmIds, contentInfo, certificates, null, signerInfos);
    }

    private void parseNetscapeCertChain(DerValue val) throws ParsingException, IOException {
        DerInputStream dis = new DerInputStream(val.toByteArray());
        DerValue[] contents = dis.getSequence(2, true);
        this.certificates = new X509Certificate[contents.length];
        CertificateFactory certfac = null;
        try {
            certfac = CertificateFactory.getInstance(e.f29912b);
        } catch (CertificateException e2) {
        }
        for (int i10 = 0; i10 < contents.length; i10++) {
            ByteArrayInputStream bais = null;
            try {
                try {
                    byte[] original = contents[i10].getOriginalEncodedForm();
                    if (certfac == null) {
                        this.certificates[i10] = new X509CertImpl(contents[i10], original);
                    } else {
                        ByteArrayInputStream bais2 = new ByteArrayInputStream(original);
                        this.certificates[i10] = new VerbatimX509Certificate((X509Certificate) certfac.generateCertificate(bais2), original);
                        bais2.close();
                        bais = null;
                    }
                } catch (IOException ioe) {
                    ParsingException pe = new ParsingException(ioe.getMessage());
                    pe.initCause(ioe);
                    throw pe;
                } catch (CertificateException ce2) {
                    ParsingException pe2 = new ParsingException(ce2.getMessage());
                    pe2.initCause(ce2);
                    throw pe2;
                }
            } finally {
                if (0 != 0) {
                    bais.close();
                }
            }
        }
    }

    private void parseSignedData(DerValue val) throws ParsingException, IOException {
        DerInputStream dis = val.toDerInputStream();
        this.version = dis.getBigInteger();
        DerValue[] digestAlgorithmIdVals = dis.getSet(1);
        int len = digestAlgorithmIdVals.length;
        this.digestAlgorithmIds = new AlgorithmId[len];
        for (int i10 = 0; i10 < len; i10++) {
            try {
                DerValue oid = digestAlgorithmIdVals[i10];
                this.digestAlgorithmIds[i10] = AlgorithmId.parse(oid);
            } catch (IOException e2) {
                ParsingException pe = new ParsingException("Error parsing digest AlgorithmId IDs: " + e2.getMessage());
                pe.initCause(e2);
                throw pe;
            }
        }
        this.contentInfo = new ContentInfo(dis);
        CertificateFactory certfac = null;
        try {
            certfac = CertificateFactory.getInstance(e.f29912b);
        } catch (CertificateException e10) {
        }
        if (((byte) dis.peekByte()) == -96) {
            DerValue[] certVals = dis.getSet(2, true, true);
            int len2 = certVals.length;
            this.certificates = new X509Certificate[len2];
            int count = 0;
            for (int i11 = 0; i11 < len2; i11++) {
                ByteArrayInputStream bais = null;
                try {
                    try {
                        try {
                            byte tag = certVals[i11].getTag();
                            if (tag == 48) {
                                byte[] original = certVals[i11].getOriginalEncodedForm();
                                if (certfac == null) {
                                    this.certificates[count] = new X509CertImpl(certVals[i11], original);
                                } else {
                                    ByteArrayInputStream bais2 = new ByteArrayInputStream(original);
                                    this.certificates[count] = new VerbatimX509Certificate((X509Certificate) certfac.generateCertificate(bais2), original);
                                    bais2.close();
                                    bais = null;
                                }
                                count++;
                            }
                        } catch (CertificateException ce2) {
                            ParsingException pe2 = new ParsingException(ce2.getMessage());
                            pe2.initCause(ce2);
                            throw pe2;
                        }
                    } catch (IOException ioe) {
                        ParsingException pe3 = new ParsingException(ioe.getMessage());
                        pe3.initCause(ioe);
                        throw pe3;
                    }
                } finally {
                    if (0 != 0) {
                        bais.close();
                    }
                }
            }
            if (count != len2) {
                this.certificates = (X509Certificate[]) Arrays.copyOf(this.certificates, count);
            }
        }
        if (((byte) dis.peekByte()) == -95) {
            DerValue[] crlVals = dis.getSet(1, true);
            int len3 = crlVals.length;
            this.crls = new X509CRL[len3];
            for (int i12 = 0; i12 < len3; i12++) {
                ByteArrayInputStream bais3 = null;
                if (certfac == null) {
                    try {
                        try {
                            this.crls[i12] = new X509CRLImpl(crlVals[i12]);
                        } catch (CRLException e11) {
                            ParsingException pe4 = new ParsingException(e11.getMessage());
                            pe4.initCause(e11);
                            throw pe4;
                        }
                    } finally {
                        if (0 != 0) {
                            bais3.close();
                        }
                    }
                } else {
                    byte[] encoded = crlVals[i12].toByteArray();
                    ByteArrayInputStream bais4 = new ByteArrayInputStream(encoded);
                    this.crls[i12] = (X509CRL) certfac.generateCRL(bais4);
                    bais4.close();
                    bais3 = null;
                }
                if (bais3 != null) {
                    bais3.close();
                }
            }
        }
        DerValue[] signerInfoVals = dis.getSet(1);
        int len4 = signerInfoVals.length;
        this.signerInfos = new SignerInfo[len4];
        for (int i13 = 0; i13 < len4; i13++) {
            DerInputStream in = signerInfoVals[i13].toDerInputStream();
            this.signerInfos[i13] = new SignerInfo(in);
        }
    }

    private void parseOldSignedData(DerValue val) throws ParsingException, IOException {
        DerInputStream dis = val.toDerInputStream();
        this.version = dis.getBigInteger();
        DerValue[] digestAlgorithmIdVals = dis.getSet(1);
        int len = digestAlgorithmIdVals.length;
        this.digestAlgorithmIds = new AlgorithmId[len];
        for (int i10 = 0; i10 < len; i10++) {
            try {
                DerValue oid = digestAlgorithmIdVals[i10];
                this.digestAlgorithmIds[i10] = AlgorithmId.parse(oid);
            } catch (IOException e2) {
                throw new ParsingException("Error parsing digest AlgorithmId IDs");
            }
        }
        this.contentInfo = new ContentInfo(dis, true);
        CertificateFactory certfac = null;
        try {
            certfac = CertificateFactory.getInstance(e.f29912b);
        } catch (CertificateException e10) {
        }
        DerValue[] certVals = dis.getSet(2, false, true);
        int len2 = certVals.length;
        this.certificates = new X509Certificate[len2];
        for (int i11 = 0; i11 < len2; i11++) {
            ByteArrayInputStream bais = null;
            try {
                try {
                    try {
                        byte[] original = certVals[i11].getOriginalEncodedForm();
                        if (certfac == null) {
                            this.certificates[i11] = new X509CertImpl(certVals[i11], original);
                        } else {
                            ByteArrayInputStream bais2 = new ByteArrayInputStream(original);
                            this.certificates[i11] = new VerbatimX509Certificate((X509Certificate) certfac.generateCertificate(bais2), original);
                            bais2.close();
                            bais = null;
                        }
                    } catch (CertificateException ce2) {
                        ParsingException pe = new ParsingException(ce2.getMessage());
                        pe.initCause(ce2);
                        throw pe;
                    }
                } catch (IOException ioe) {
                    ParsingException pe2 = new ParsingException(ioe.getMessage());
                    pe2.initCause(ioe);
                    throw pe2;
                }
            } finally {
                if (0 != 0) {
                    bais.close();
                }
            }
        }
        dis.getSet(0);
        DerValue[] signerInfoVals = dis.getSet(1);
        int len3 = signerInfoVals.length;
        this.signerInfos = new SignerInfo[len3];
        for (int i12 = 0; i12 < len3; i12++) {
            DerInputStream in = signerInfoVals[i12].toDerInputStream();
            this.signerInfos[i12] = new SignerInfo(in, true);
        }
    }

    public void encodeSignedData(OutputStream out) throws IOException {
        DerOutputStream derout = new DerOutputStream();
        encodeSignedData(derout);
        out.write(derout.toByteArray());
    }

    public void encodeSignedData(DerOutputStream out) throws IOException {
        DerOutputStream signedData = new DerOutputStream();
        signedData.putInteger(this.version);
        signedData.putOrderedSetOf((byte) 49, this.digestAlgorithmIds);
        this.contentInfo.encode(signedData);
        X509Certificate[] x509CertificateArr = this.certificates;
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            X509CertImpl[] implCerts = new X509CertImpl[x509CertificateArr.length];
            int i10 = 0;
            while (true) {
                X509Certificate[] x509CertificateArr2 = this.certificates;
                if (i10 >= x509CertificateArr2.length) {
                    break;
                }
                X509Certificate x509Certificate = x509CertificateArr2[i10];
                if (x509Certificate instanceof X509CertImpl) {
                    implCerts[i10] = (X509CertImpl) x509Certificate;
                } else {
                    try {
                        byte[] encoded = x509Certificate.getEncoded();
                        implCerts[i10] = new X509CertImpl(encoded);
                    } catch (CertificateException ce2) {
                        throw new IOException(ce2);
                    }
                }
                i10++;
            }
            signedData.putOrderedSetOf(MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, implCerts);
        }
        X509CRL[] x509crlArr = this.crls;
        if (x509crlArr != null && x509crlArr.length != 0) {
            Set<X509CRLImpl> implCRLs = new HashSet<>(this.crls.length);
            for (X509CRL crl : this.crls) {
                if (crl instanceof X509CRLImpl) {
                    implCRLs.add((X509CRLImpl) crl);
                } else {
                    try {
                        byte[] encoded2 = crl.getEncoded();
                        implCRLs.add(new X509CRLImpl(encoded2));
                    } catch (CRLException ce3) {
                        throw new IOException(ce3);
                    }
                }
            }
            signedData.putOrderedSetOf((byte) -95, (DerEncoder[]) implCRLs.toArray(new X509CRLImpl[implCRLs.size()]));
        }
        signedData.putOrderedSetOf((byte) 49, this.signerInfos);
        DerValue signedDataSeq = new DerValue((byte) 48, signedData.toByteArray());
        ContentInfo block = new ContentInfo(ContentInfo.SIGNED_DATA_OID, signedDataSeq);
        block.encode(out);
    }

    public SignerInfo verify(SignerInfo info, byte[] bytes) throws NoSuchAlgorithmException, SignatureException {
        return info.verify(this, bytes);
    }

    public SignerInfo verify(SignerInfo info, InputStream dataInputStream) throws NoSuchAlgorithmException, SignatureException, IOException {
        return info.verify(this, dataInputStream);
    }

    public SignerInfo[] verify(byte[] bytes) throws NoSuchAlgorithmException, SignatureException {
        Vector<SignerInfo> intResult = new Vector<>();
        int i10 = 0;
        while (true) {
            SignerInfo[] signerInfoArr = this.signerInfos;
            if (i10 >= signerInfoArr.length) {
                break;
            }
            SignerInfo signerInfo = verify(signerInfoArr[i10], bytes);
            if (signerInfo != null) {
                intResult.addElement(signerInfo);
            }
            i10++;
        }
        if (!intResult.isEmpty()) {
            SignerInfo[] result = new SignerInfo[intResult.size()];
            intResult.copyInto(result);
            return result;
        }
        return null;
    }

    public SignerInfo[] verify() throws NoSuchAlgorithmException, SignatureException {
        return verify(null);
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public AlgorithmId[] getDigestAlgorithmIds() {
        return this.digestAlgorithmIds;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public X509Certificate[] getCertificates() {
        X509Certificate[] x509CertificateArr = this.certificates;
        if (x509CertificateArr != null) {
            return (X509Certificate[]) x509CertificateArr.clone();
        }
        return null;
    }

    public X509CRL[] getCRLs() {
        X509CRL[] x509crlArr = this.crls;
        if (x509crlArr != null) {
            return (X509CRL[]) x509crlArr.clone();
        }
        return null;
    }

    public SignerInfo[] getSignerInfos() {
        return this.signerInfos;
    }

    public X509Certificate getCertificate(BigInteger serial, X500Name issuerName) {
        if (this.certificates != null) {
            if (this.certIssuerNames == null) {
                populateCertIssuerNames();
            }
            int i10 = 0;
            while (true) {
                X509Certificate[] x509CertificateArr = this.certificates;
                if (i10 < x509CertificateArr.length) {
                    X509Certificate cert = x509CertificateArr[i10];
                    BigInteger thisSerial = cert.getSerialNumber();
                    if (!serial.equals(thisSerial) || !issuerName.equals(this.certIssuerNames[i10])) {
                        i10++;
                    } else {
                        return cert;
                    }
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    private void populateCertIssuerNames() {
        X509Certificate[] x509CertificateArr = this.certificates;
        if (x509CertificateArr == null) {
            return;
        }
        this.certIssuerNames = new Principal[x509CertificateArr.length];
        int i10 = 0;
        while (true) {
            X509Certificate[] x509CertificateArr2 = this.certificates;
            if (i10 < x509CertificateArr2.length) {
                X509Certificate cert = x509CertificateArr2[i10];
                Principal certIssuerName = cert.getIssuerDN();
                if (!(certIssuerName instanceof X500Name)) {
                    try {
                        X509CertInfo tbsCert = new X509CertInfo(cert.getTBSCertificate());
                        certIssuerName = (Principal) tbsCert.get("issuer.dname");
                    } catch (Exception e2) {
                    }
                }
                this.certIssuerNames[i10] = certIssuerName;
                i10++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        String out = "" + ((Object) this.contentInfo) + "\n";
        if (this.version != null) {
            out = out + "PKCS7 :: version: " + Debug.toHexString(this.version) + "\n";
        }
        if (this.digestAlgorithmIds != null) {
            out = out + "PKCS7 :: digest AlgorithmIds: \n";
            for (int i10 = 0; i10 < this.digestAlgorithmIds.length; i10++) {
                out = out + "\t" + ((Object) this.digestAlgorithmIds[i10]) + "\n";
            }
        }
        if (this.certificates != null) {
            out = out + "PKCS7 :: certificates: \n";
            for (int i11 = 0; i11 < this.certificates.length; i11++) {
                out = out + "\t" + i11 + ".   " + ((Object) this.certificates[i11]) + "\n";
            }
        }
        if (this.crls != null) {
            out = out + "PKCS7 :: crls: \n";
            for (int i12 = 0; i12 < this.crls.length; i12++) {
                out = out + "\t" + i12 + ".   " + ((Object) this.crls[i12]) + "\n";
            }
        }
        if (this.signerInfos != null) {
            out = out + "PKCS7 :: signer infos: \n";
            for (int i13 = 0; i13 < this.signerInfos.length; i13++) {
                out = out + "\t" + i13 + ".  " + ((Object) this.signerInfos[i13]) + "\n";
            }
        }
        return out;
    }

    public boolean isOldStyle() {
        return this.oldStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class VerbatimX509Certificate extends WrappedX509Certificate {
        private byte[] encodedVerbatim;

        public VerbatimX509Certificate(X509Certificate wrapped, byte[] encodedVerbatim) {
            super(wrapped);
            this.encodedVerbatim = encodedVerbatim;
        }

        @Override // sun.security.pkcs.PKCS7.WrappedX509Certificate, java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.encodedVerbatim;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class WrappedX509Certificate extends X509Certificate {
        private final X509Certificate wrapped;

        public WrappedX509Certificate(X509Certificate wrapped) {
            this.wrapped = wrapped;
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.wrapped.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String oid) {
            return this.wrapped.getExtensionValue(oid);
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.wrapped.getNonCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            return this.wrapped.hasUnsupportedCriticalExtension();
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity();
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity(date);
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            return this.wrapped.getVersion();
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.wrapped.getSerialNumber();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.wrapped.getIssuerDN();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.wrapped.getSubjectDN();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.wrapped.getNotBefore();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.wrapped.getNotAfter();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return this.wrapped.getTBSCertificate();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            return this.wrapped.getSignature();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.wrapped.getSigAlgName();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.wrapped.getSigAlgOID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.wrapped.getSigAlgParams();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            return this.wrapped.getIssuerUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            return this.wrapped.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            return this.wrapped.getKeyUsage();
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            return this.wrapped.getBasicConstraints();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.wrapped.getEncoded();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(key);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(key, sigProvider);
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            return this.wrapped.toString();
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.wrapped.getPublicKey();
        }

        @Override // java.security.cert.X509Certificate
        public List<String> getExtendedKeyUsage() throws CertificateParsingException {
            return this.wrapped.getExtendedKeyUsage();
        }

        @Override // java.security.cert.X509Certificate
        public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
            return this.wrapped.getIssuerAlternativeNames();
        }

        @Override // java.security.cert.X509Certificate
        public X500Principal getIssuerX500Principal() {
            return this.wrapped.getIssuerX500Principal();
        }

        @Override // java.security.cert.X509Certificate
        public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
            return this.wrapped.getSubjectAlternativeNames();
        }

        @Override // java.security.cert.X509Certificate
        public X500Principal getSubjectX500Principal() {
            return this.wrapped.getSubjectX500Principal();
        }

        @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
        public void verify(PublicKey key, Provider sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
            this.wrapped.verify(key, sigProvider);
        }
    }
}
