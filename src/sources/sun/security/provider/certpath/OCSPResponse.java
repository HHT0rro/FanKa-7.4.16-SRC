package sun.security.provider.certpath;

import java.io.IOException;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLReason;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.misc.HexDumpEncoder;
import sun.security.action.GetIntegerAction;
import sun.security.provider.certpath.OCSP;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.Extension;
import sun.security.x509.KeyIdentifier;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class OCSPResponse {
    private static final int CERT_STATUS_GOOD = 0;
    private static final int CERT_STATUS_REVOKED = 1;
    private static final int CERT_STATUS_UNKNOWN = 2;
    private static final int DEFAULT_MAX_CLOCK_SKEW = 900000;
    private static final int KEY_TAG = 2;
    private static final String KP_OCSP_SIGNING_OID = "1.3.6.1.5.5.7.3.9";
    private static final int MAX_CLOCK_SKEW;
    private static final int NAME_TAG = 1;
    private static final ObjectIdentifier OCSP_BASIC_RESPONSE_OID;
    private static final Debug debug;
    private static final boolean dump;
    private static ResponseStatus[] rsvalues = ResponseStatus.values();
    private static CRLReason[] values;
    private List<X509CertImpl> certs;
    private KeyIdentifier responderKeyId;
    private X500Principal responderName;
    private final byte[] responseNonce;
    private final ResponseStatus responseStatus;
    private final AlgorithmId sigAlgId;
    private final byte[] signature;
    private X509CertImpl signerCert = null;
    private final Map<CertId, SingleResponse> singleResponseMap;
    private final byte[] tbsResponseData;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum ResponseStatus {
        SUCCESSFUL,
        MALFORMED_REQUEST,
        INTERNAL_ERROR,
        TRY_LATER,
        UNUSED,
        SIG_REQUIRED,
        UNAUTHORIZED
    }

    static {
        Debug debug2 = Debug.getInstance("certpath");
        debug = debug2;
        dump = debug2 != null && Debug.isOn("ocsp");
        OCSP_BASIC_RESPONSE_OID = ObjectIdentifier.newInternal(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 1, 1});
        MAX_CLOCK_SKEW = initializeClockSkew();
        values = CRLReason.values();
    }

    private static int initializeClockSkew() {
        Integer tmp = (Integer) AccessController.doPrivileged(new GetIntegerAction("com.sun.security.ocsp.clockSkew"));
        if (tmp == null || tmp.intValue() < 0) {
            return DEFAULT_MAX_CLOCK_SKEW;
        }
        return tmp.intValue() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OCSPResponse(byte[] bytes) throws IOException {
        byte[] nonce;
        byte[] nonce2;
        DerValue[] derCerts;
        DerValue der;
        DerInputStream derIn;
        this.responderName = null;
        this.responderKeyId = null;
        if (dump) {
            HexDumpEncoder hexEnc = new HexDumpEncoder();
            debug.println("OCSPResponse bytes...\n\n" + hexEnc.encode(bytes) + "\n");
        }
        DerValue der2 = new DerValue(bytes);
        if (der2.tag != 48) {
            throw new IOException("Bad encoding in OCSP response: expected ASN.1 SEQUENCE tag.");
        }
        DerInputStream derIn2 = der2.getData();
        int status = derIn2.getEnumerated();
        if (status >= 0) {
            ResponseStatus[] responseStatusArr = rsvalues;
            if (status < responseStatusArr.length) {
                ResponseStatus responseStatus = responseStatusArr[status];
                this.responseStatus = responseStatus;
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("OCSP response status: " + ((Object) responseStatus));
                }
                if (responseStatus != ResponseStatus.SUCCESSFUL) {
                    this.singleResponseMap = Collections.emptyMap();
                    this.certs = new ArrayList();
                    this.sigAlgId = null;
                    this.signature = null;
                    this.tbsResponseData = null;
                    this.responseNonce = null;
                    return;
                }
                DerValue der3 = derIn2.getDerValue();
                if (!der3.isContextSpecific((byte) 0)) {
                    throw new IOException("Bad encoding in responseBytes element of OCSP response: expected ASN.1 context specific tag 0.");
                }
                DerValue tmp = der3.data.getDerValue();
                if (tmp.tag != 48) {
                    throw new IOException("Bad encoding in responseBytes element of OCSP response: expected ASN.1 SEQUENCE tag.");
                }
                DerInputStream derIn3 = tmp.data;
                ObjectIdentifier responseType = derIn3.getOID();
                if (responseType.equals((Object) OCSP_BASIC_RESPONSE_OID)) {
                    if (debug2 != null) {
                        debug2.println("OCSP response type: basic");
                    }
                    DerInputStream basicOCSPResponse = new DerInputStream(derIn3.getOctetString());
                    DerValue[] seqTmp = basicOCSPResponse.getSequence(2);
                    if (seqTmp.length < 3) {
                        throw new IOException("Unexpected BasicOCSPResponse value");
                    }
                    DerValue responseData = seqTmp[0];
                    this.tbsResponseData = seqTmp[0].toByteArray();
                    if (responseData.tag != 48) {
                        throw new IOException("Bad encoding in tbsResponseData element of OCSP response: expected ASN.1 SEQUENCE tag.");
                    }
                    DerInputStream seqDerIn = responseData.data;
                    DerValue seq = seqDerIn.getDerValue();
                    if (seq.isContextSpecific((byte) 0) && seq.isConstructed() && seq.isContextSpecific()) {
                        DerValue seq2 = seq.data.getDerValue();
                        seq2.getInteger();
                        if (seq2.data.available() != 0) {
                            throw new IOException("Bad encoding in version  element of OCSP response: bad format");
                        }
                        seq = seqDerIn.getDerValue();
                    }
                    short tag = (byte) (seq.tag & 31);
                    if (tag == 1) {
                        this.responderName = new X500Principal(seq.getData().toByteArray());
                        if (debug2 != null) {
                            debug2.println("Responder's name: " + ((Object) this.responderName));
                        }
                    } else if (tag == 2) {
                        this.responderKeyId = new KeyIdentifier(seq.getData().getOctetString());
                        if (debug2 != null) {
                            debug2.println("Responder's key ID: " + Debug.toString(this.responderKeyId.getIdentifier()));
                        }
                    } else {
                        throw new IOException("Bad encoding in responderID element of OCSP response: expected ASN.1 context specific tag 0 or 1");
                    }
                    DerValue seq3 = seqDerIn.getDerValue();
                    if (debug2 != null) {
                        Date producedAtDate = seq3.getGeneralizedTime();
                        debug2.println("OCSP response produced at: " + ((Object) producedAtDate));
                    }
                    DerValue[] singleResponseDer = seqDerIn.getSequence(1);
                    this.singleResponseMap = new HashMap(singleResponseDer.length);
                    if (debug2 != null) {
                        debug2.println("OCSP number of SingleResponses: " + singleResponseDer.length);
                    }
                    for (DerValue derValue : singleResponseDer) {
                        SingleResponse singleResponse = new SingleResponse(derValue);
                        this.singleResponseMap.put(singleResponse.getCertId(), singleResponse);
                    }
                    byte[] nonce3 = null;
                    if (seqDerIn.available() <= 0) {
                        nonce = null;
                    } else {
                        DerValue seq4 = seqDerIn.getDerValue();
                        if (!seq4.isContextSpecific((byte) 1)) {
                            nonce = null;
                        } else {
                            DerValue[] responseExtDer = seq4.data.getSequence(3);
                            int i10 = 0;
                            while (true) {
                                byte[] nonce4 = nonce3;
                                if (i10 >= responseExtDer.length) {
                                    nonce = nonce4;
                                    break;
                                }
                                DerValue seq5 = seq4;
                                Extension ext = new Extension(responseExtDer[i10]);
                                Debug debug3 = debug;
                                if (debug3 == null) {
                                    der = der3;
                                    derIn = derIn3;
                                } else {
                                    der = der3;
                                    derIn = derIn3;
                                    debug3.println("OCSP extension: " + ((Object) ext));
                                }
                                if (ext.getExtensionId().equals((Object) OCSP.NONCE_EXTENSION_OID)) {
                                    nonce3 = ext.getExtensionValue();
                                } else {
                                    if (ext.isCritical()) {
                                        throw new IOException("Unsupported OCSP critical extension: " + ((Object) ext.getExtensionId()));
                                    }
                                    nonce3 = nonce4;
                                }
                                i10++;
                                seq4 = seq5;
                                der3 = der;
                                derIn3 = derIn;
                            }
                        }
                    }
                    this.responseNonce = nonce;
                    this.sigAlgId = AlgorithmId.parse(seqTmp[1]);
                    this.signature = seqTmp[2].getBitString();
                    if (seqTmp.length <= 3) {
                        this.certs = new ArrayList();
                        return;
                    }
                    DerValue seqCert = seqTmp[3];
                    if (!seqCert.isContextSpecific((byte) 0)) {
                        throw new IOException("Bad encoding in certs element of OCSP response: expected ASN.1 context specific tag 0.");
                    }
                    DerValue[] derCerts2 = seqCert.getData().getSequence(3);
                    this.certs = new ArrayList(derCerts2.length);
                    int i11 = 0;
                    while (i11 < derCerts2.length) {
                        try {
                            X509CertImpl cert = new X509CertImpl(derCerts2[i11].toByteArray());
                            this.certs.add(cert);
                            Debug debug4 = debug;
                            if (debug4 == null) {
                                nonce2 = nonce;
                                derCerts = derCerts2;
                            } else {
                                nonce2 = nonce;
                                try {
                                    derCerts = derCerts2;
                                } catch (CertificateException e2) {
                                    ce = e2;
                                }
                                try {
                                    debug4.println("OCSP response cert #" + (i11 + 1) + ": " + ((Object) cert.getSubjectX500Principal()));
                                } catch (CertificateException e10) {
                                    ce = e10;
                                    throw new IOException("Bad encoding in X509 Certificate", ce);
                                }
                            }
                            i11++;
                            nonce = nonce2;
                            derCerts2 = derCerts;
                        } catch (CertificateException e11) {
                            ce = e11;
                        }
                    }
                    return;
                }
                if (debug2 != null) {
                    debug2.println("OCSP response type: " + ((Object) responseType));
                }
                throw new IOException("Unsupported OCSP response type: " + ((Object) responseType));
            }
        }
        throw new IOException("Unknown OCSPResponse status: " + status);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.security.provider.certpath.OCSPResponse$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus;

        static {
            int[] iArr = new int[ResponseStatus.values().length];
            $SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus = iArr;
            try {
                iArr[ResponseStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus[ResponseStatus.TRY_LATER.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus[ResponseStatus.INTERNAL_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus[ResponseStatus.UNAUTHORIZED.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void verify(List<CertId> certIds, X509Certificate issuerCert, X509Certificate responderCert, Date date, byte[] nonce) throws CertPathValidatorException {
        byte[] bArr;
        Debug debug2;
        switch (AnonymousClass1.$SwitchMap$sun$security$provider$certpath$OCSPResponse$ResponseStatus[this.responseStatus.ordinal()]) {
            case 1:
                for (CertId certId : certIds) {
                    SingleResponse sr = getSingleResponse(certId);
                    if (sr == null) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("No response found for CertId: " + ((Object) certId));
                        }
                        throw new CertPathValidatorException("OCSP response does not include a response for a certificate supplied in the OCSP request");
                    }
                    Debug debug4 = debug;
                    if (debug4 != null) {
                        debug4.println("Status of certificate (with serial number " + ((Object) certId.getSerialNumber()) + ") is: " + ((Object) sr.getCertStatus()));
                    }
                }
                if (this.signerCert == null) {
                    try {
                        this.certs.add(X509CertImpl.toImpl(issuerCert));
                        if (responderCert != null) {
                            this.certs.add(X509CertImpl.toImpl(responderCert));
                        }
                        if (this.responderName != null) {
                            Iterator<X509CertImpl> iterator2 = this.certs.iterator2();
                            while (true) {
                                if (iterator2.hasNext()) {
                                    X509CertImpl cert = iterator2.next();
                                    if (cert.getSubjectX500Principal().equals(this.responderName)) {
                                        this.signerCert = cert;
                                    }
                                }
                            }
                        } else if (this.responderKeyId != null) {
                            Iterator<X509CertImpl> iterator22 = this.certs.iterator2();
                            while (true) {
                                if (iterator22.hasNext()) {
                                    X509CertImpl cert2 = iterator22.next();
                                    KeyIdentifier certKeyId = cert2.getSubjectKeyId();
                                    if (certKeyId != null && this.responderKeyId.equals(certKeyId)) {
                                        this.signerCert = cert2;
                                    } else {
                                        try {
                                            certKeyId = new KeyIdentifier(cert2.getPublicKey());
                                        } catch (IOException e2) {
                                        }
                                        if (this.responderKeyId.equals(certKeyId)) {
                                            this.signerCert = cert2;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (CertificateException ce2) {
                        throw new CertPathValidatorException("Invalid issuer or trusted responder certificate", ce2);
                    }
                }
                X509CertImpl x509CertImpl = this.signerCert;
                if (x509CertImpl != null) {
                    if (x509CertImpl.equals(issuerCert)) {
                        Debug debug5 = debug;
                        if (debug5 != null) {
                            debug5.println("OCSP response is signed by the target's Issuing CA");
                        }
                    } else if (this.signerCert.equals(responderCert)) {
                        Debug debug6 = debug;
                        if (debug6 != null) {
                            debug6.println("OCSP response is signed by a Trusted Responder");
                        }
                    } else if (this.signerCert.getIssuerX500Principal().equals(issuerCert.getSubjectX500Principal())) {
                        try {
                            List<String> keyPurposes = this.signerCert.getExtendedKeyUsage();
                            if (keyPurposes == null || !keyPurposes.contains(KP_OCSP_SIGNING_OID)) {
                                throw new CertPathValidatorException("Responder's certificate not valid for signing OCSP responses");
                            }
                            AlgorithmChecker algChecker = new AlgorithmChecker(new TrustAnchor(issuerCert, null));
                            algChecker.init(false);
                            algChecker.check(this.signerCert, Collections.emptySet());
                            try {
                                if (date == null) {
                                    this.signerCert.checkValidity();
                                } else {
                                    this.signerCert.checkValidity(date);
                                }
                                Extension noCheck = this.signerCert.getExtension(PKIXExtensions.OCSPNoCheck_Id);
                                if (noCheck != null && (debug2 = debug) != null) {
                                    debug2.println("Responder's certificate includes the extension id-pkix-ocsp-nocheck.");
                                }
                                try {
                                    this.signerCert.verify(issuerCert.getPublicKey());
                                    Debug debug7 = debug;
                                    if (debug7 != null) {
                                        debug7.println("OCSP response is signed by an Authorized Responder");
                                    }
                                } catch (GeneralSecurityException e10) {
                                    this.signerCert = null;
                                }
                            } catch (CertificateException e11) {
                                throw new CertPathValidatorException("Responder's certificate not within the validity period", e11);
                            }
                        } catch (CertificateParsingException cpe) {
                            throw new CertPathValidatorException("Responder's certificate not valid for signing OCSP responses", cpe);
                        }
                    } else {
                        throw new CertPathValidatorException("Responder's certificate is not authorized to sign OCSP responses");
                    }
                }
                X509CertImpl x509CertImpl2 = this.signerCert;
                if (x509CertImpl2 != null) {
                    AlgorithmChecker.check(x509CertImpl2.getPublicKey(), this.sigAlgId);
                    if (!verifySignature(this.signerCert)) {
                        throw new CertPathValidatorException("Error verifying OCSP Response's signature");
                    }
                    if (nonce != null && (bArr = this.responseNonce) != null && !Arrays.equals(nonce, bArr)) {
                        throw new CertPathValidatorException("Nonces don't match");
                    }
                    long now = date == null ? System.currentTimeMillis() : date.getTime();
                    int i10 = MAX_CLOCK_SKEW;
                    Date nowPlusSkew = new Date(i10 + now);
                    Date nowMinusSkew = new Date(now - i10);
                    for (SingleResponse sr2 : this.singleResponseMap.values()) {
                        Debug debug8 = debug;
                        if (debug8 != null) {
                            String until = "";
                            if (sr2.nextUpdate != null) {
                                until = " until " + ((Object) sr2.nextUpdate);
                            }
                            debug8.println("OCSP response validity interval is from " + ((Object) sr2.thisUpdate) + until);
                            debug8.println("Checking validity of OCSP response on: " + ((Object) new Date(now)));
                        }
                        if (!nowPlusSkew.before(sr2.thisUpdate)) {
                            if (!nowMinusSkew.after(sr2.nextUpdate != null ? sr2.nextUpdate : sr2.thisUpdate)) {
                            }
                        }
                        throw new CertPathValidatorException("Response is unreliable: its validity interval is out-of-date");
                        break;
                    }
                    return;
                }
                throw new CertPathValidatorException("Unable to verify OCSP Response's signature");
            case 2:
            case 3:
                throw new CertPathValidatorException("OCSP response error: " + ((Object) this.responseStatus), null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
            default:
                throw new CertPathValidatorException("OCSP response error: " + ((Object) this.responseStatus));
        }
    }

    ResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    private boolean verifySignature(X509Certificate cert) throws CertPathValidatorException {
        try {
            Signature respSignature = Signature.getInstance(this.sigAlgId.getName());
            respSignature.initVerify(cert.getPublicKey());
            respSignature.update(this.tbsResponseData);
            if (respSignature.verify(this.signature)) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Verified signature of OCSP Response");
                    return true;
                }
                return true;
            }
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("Error verifying signature of OCSP Response");
                return false;
            }
            return false;
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            throw new CertPathValidatorException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleResponse getSingleResponse(CertId certId) {
        return this.singleResponseMap.get(certId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509Certificate getSignerCertificate() {
        return this.signerCert;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SingleResponse implements OCSP.RevocationStatus {
        private final CertId certId;
        private final OCSP.RevocationStatus.CertStatus certStatus;
        private final Date nextUpdate;
        private final CRLReason revocationReason;
        private final Date revocationTime;
        private final Map<String, java.security.cert.Extension> singleExtensions;
        private final Date thisUpdate;

        private SingleResponse(DerValue der) throws IOException {
            if (der.tag != 48) {
                throw new IOException("Bad ASN.1 encoding in SingleResponse");
            }
            DerInputStream tmp = der.data;
            this.certId = new CertId(tmp.getDerValue().data);
            DerValue derVal = tmp.getDerValue();
            short tag = (byte) (derVal.tag & 31);
            if (tag == 1) {
                this.certStatus = OCSP.RevocationStatus.CertStatus.REVOKED;
                Date generalizedTime = derVal.data.getGeneralizedTime();
                this.revocationTime = generalizedTime;
                if (derVal.data.available() != 0) {
                    DerValue dv = derVal.data.getDerValue();
                    if (((byte) (dv.tag & 31)) == 0) {
                        int reason = dv.data.getEnumerated();
                        if (reason >= 0 && reason < OCSPResponse.values.length) {
                            this.revocationReason = OCSPResponse.values[reason];
                        } else {
                            this.revocationReason = CRLReason.UNSPECIFIED;
                        }
                    } else {
                        this.revocationReason = CRLReason.UNSPECIFIED;
                    }
                } else {
                    this.revocationReason = CRLReason.UNSPECIFIED;
                }
                if (OCSPResponse.debug != null) {
                    OCSPResponse.debug.println("Revocation time: " + ((Object) generalizedTime));
                    OCSPResponse.debug.println("Revocation reason: " + ((Object) this.revocationReason));
                }
            } else {
                this.revocationTime = null;
                this.revocationReason = CRLReason.UNSPECIFIED;
                if (tag == 0) {
                    this.certStatus = OCSP.RevocationStatus.CertStatus.GOOD;
                } else if (tag == 2) {
                    this.certStatus = OCSP.RevocationStatus.CertStatus.UNKNOWN;
                } else {
                    throw new IOException("Invalid certificate status");
                }
            }
            this.thisUpdate = tmp.getGeneralizedTime();
            if (tmp.available() == 0) {
                this.nextUpdate = null;
            } else {
                DerValue derVal2 = tmp.getDerValue();
                if (((byte) (derVal2.tag & 31)) == 0) {
                    this.nextUpdate = derVal2.data.getGeneralizedTime();
                    if (tmp.available() != 0) {
                    }
                } else {
                    this.nextUpdate = null;
                }
            }
            if (tmp.available() > 0) {
                DerValue derVal3 = tmp.getDerValue();
                if (derVal3.isContextSpecific((byte) 1)) {
                    DerValue[] singleExtDer = derVal3.data.getSequence(3);
                    this.singleExtensions = new HashMap(singleExtDer.length);
                    for (DerValue derValue : singleExtDer) {
                        Extension ext = new Extension(derValue);
                        if (OCSPResponse.debug != null) {
                            OCSPResponse.debug.println("OCSP single extension: " + ((Object) ext));
                        }
                        if (ext.isCritical()) {
                            throw new IOException("Unsupported OCSP critical extension: " + ((Object) ext.getExtensionId()));
                        }
                        this.singleExtensions.put(ext.getId(), ext);
                    }
                    return;
                }
                this.singleExtensions = Collections.emptyMap();
                return;
            }
            this.singleExtensions = Collections.emptyMap();
        }

        @Override // sun.security.provider.certpath.OCSP.RevocationStatus
        public OCSP.RevocationStatus.CertStatus getCertStatus() {
            return this.certStatus;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CertId getCertId() {
            return this.certId;
        }

        @Override // sun.security.provider.certpath.OCSP.RevocationStatus
        public Date getRevocationTime() {
            return (Date) this.revocationTime.clone();
        }

        @Override // sun.security.provider.certpath.OCSP.RevocationStatus
        public CRLReason getRevocationReason() {
            return this.revocationReason;
        }

        @Override // sun.security.provider.certpath.OCSP.RevocationStatus
        public Map<String, java.security.cert.Extension> getSingleExtensions() {
            return Collections.unmodifiableMap(this.singleExtensions);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SingleResponse:  \n");
            sb2.append((Object) this.certId);
            sb2.append("\nCertStatus: " + ((Object) this.certStatus) + "\n");
            if (this.certStatus == OCSP.RevocationStatus.CertStatus.REVOKED) {
                sb2.append("revocationTime is " + ((Object) this.revocationTime) + "\n");
                sb2.append("revocationReason is " + ((Object) this.revocationReason) + "\n");
            }
            sb2.append("thisUpdate is " + ((Object) this.thisUpdate) + "\n");
            if (this.nextUpdate != null) {
                sb2.append("nextUpdate is " + ((Object) this.nextUpdate) + "\n");
            }
            return sb2.toString();
        }
    }
}
