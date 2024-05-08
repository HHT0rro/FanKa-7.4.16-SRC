package sun.security.provider.certpath;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CRLReason;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.Extension;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.provider.certpath.OCSP;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;
import sun.security.x509.AccessDescription;
import sun.security.x509.AuthorityInfoAccessExtension;
import sun.security.x509.CRLDistributionPointsExtension;
import sun.security.x509.DistributionPoint;
import sun.security.x509.GeneralName;
import sun.security.x509.GeneralNames;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.X500Name;
import sun.security.x509.X509CRLEntryImpl;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class RevocationChecker extends PKIXRevocationChecker {
    private static final String HEX_DIGITS = "0123456789ABCDEFabcdef";
    private static final long MAX_CLOCK_SKEW = 900000;
    private TrustAnchor anchor;
    private int certIndex;
    private List<CertStore> certStores;
    private boolean crlDP;
    private boolean crlSignFlag;
    private X509Certificate issuerCert;
    private List<Extension> ocspExtensions;
    private Map<X509Certificate, byte[]> ocspResponses;
    private boolean onlyEE;
    private PKIX.ValidatorParams params;
    private PublicKey prevPubKey;
    private X509Certificate responderCert;
    private URI responderURI;
    private boolean softFail;
    private static final Debug debug = Debug.getInstance("certpath");
    private static final boolean[] ALL_REASONS = {true, true, true, true, true, true, true, true, true};
    private static final boolean[] CRL_SIGN_USAGE = {false, false, false, false, false, false, true};
    private LinkedList<CertPathValidatorException> softFailExceptions = new LinkedList<>();
    private Mode mode = Mode.PREFER_OCSP;
    private boolean legacy = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Mode {
        PREFER_OCSP,
        PREFER_CRLS,
        ONLY_CRLS,
        ONLY_OCSP
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class RevocationProperties {
        boolean crlDPEnabled;
        boolean ocspEnabled;
        String ocspIssuer;
        String ocspSerial;
        String ocspSubject;
        String ocspUrl;
        boolean onlyEE;

        private RevocationProperties() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RevocationChecker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RevocationChecker(TrustAnchor anchor, PKIX.ValidatorParams params) throws CertPathValidatorException {
        init(anchor, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0046. Please report as an issue. */
    public void init(TrustAnchor anchor, PKIX.ValidatorParams params) throws CertPathValidatorException {
        X509Certificate x509Certificate;
        RevocationProperties rp = getRevocationProperties();
        URI uri = getOcspResponder();
        this.responderURI = uri == null ? toURI(rp.ocspUrl) : uri;
        X509Certificate cert = getOcspResponderCert();
        if (cert == null) {
            x509Certificate = getResponderCert(rp, params.trustAnchors(), params.certStores());
        } else {
            x509Certificate = cert;
        }
        this.responderCert = x509Certificate;
        Set<PKIXRevocationChecker.Option> options = getOptions();
        for (PKIXRevocationChecker.Option option : options) {
            switch (AnonymousClass2.$SwitchMap$java$security$cert$PKIXRevocationChecker$Option[option.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                default:
                    throw new CertPathValidatorException("Unrecognized revocation parameter option: " + ((Object) option));
            }
        }
        this.softFail = options.contains(PKIXRevocationChecker.Option.SOFT_FAIL);
        if (this.legacy) {
            this.mode = rp.ocspEnabled ? Mode.PREFER_OCSP : Mode.ONLY_CRLS;
            this.onlyEE = rp.onlyEE;
        } else {
            if (options.contains(PKIXRevocationChecker.Option.NO_FALLBACK)) {
                if (options.contains(PKIXRevocationChecker.Option.PREFER_CRLS)) {
                    this.mode = Mode.ONLY_CRLS;
                } else {
                    this.mode = Mode.ONLY_OCSP;
                }
            } else if (options.contains(PKIXRevocationChecker.Option.PREFER_CRLS)) {
                this.mode = Mode.PREFER_CRLS;
            }
            this.onlyEE = options.contains(PKIXRevocationChecker.Option.ONLY_END_ENTITY);
        }
        if (this.legacy) {
            this.crlDP = rp.crlDPEnabled;
        } else {
            this.crlDP = true;
        }
        this.ocspResponses = getOcspResponses();
        this.ocspExtensions = getOcspExtensions();
        this.anchor = anchor;
        this.params = params;
        ArrayList arrayList = new ArrayList(params.certStores());
        this.certStores = arrayList;
        try {
            arrayList.add(CertStore.getInstance("Collection", new CollectionCertStoreParameters(params.certificates())));
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e2) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("RevocationChecker: error creating Collection CertStore: " + ((Object) e2));
            }
        }
    }

    private static URI toURI(String uriString) throws CertPathValidatorException {
        if (uriString != null) {
            try {
                return new URI(uriString);
            } catch (URISyntaxException e2) {
                throw new CertPathValidatorException("cannot parse ocsp.responderURL property", e2);
            }
        }
        return null;
    }

    private static RevocationProperties getRevocationProperties() {
        return (RevocationProperties) AccessController.doPrivileged(new PrivilegedAction<RevocationProperties>() { // from class: sun.security.provider.certpath.RevocationChecker.1
            @Override // java.security.PrivilegedAction
            public RevocationProperties run() {
                RevocationProperties rp = new RevocationProperties();
                String onlyEE = Security.getProperty("com.sun.security.onlyCheckRevocationOfEECert");
                rp.onlyEE = onlyEE != null && onlyEE.equalsIgnoreCase("true");
                String ocspEnabled = Security.getProperty("ocsp.enable");
                rp.ocspEnabled = ocspEnabled != null && ocspEnabled.equalsIgnoreCase("true");
                rp.ocspUrl = Security.getProperty("ocsp.responderURL");
                rp.ocspSubject = Security.getProperty("ocsp.responderCertSubjectName");
                rp.ocspIssuer = Security.getProperty("ocsp.responderCertIssuerName");
                rp.ocspSerial = Security.getProperty("ocsp.responderCertSerialNumber");
                rp.crlDPEnabled = Boolean.getBoolean("com.sun.security.enableCRLDP");
                return rp;
            }
        });
    }

    private static X509Certificate getResponderCert(RevocationProperties rp, Set<TrustAnchor> anchors, List<CertStore> stores) throws CertPathValidatorException {
        if (rp.ocspSubject != null) {
            return getResponderCert(rp.ocspSubject, anchors, stores);
        }
        if (rp.ocspIssuer != null && rp.ocspSerial != null) {
            return getResponderCert(rp.ocspIssuer, rp.ocspSerial, anchors, stores);
        }
        if (rp.ocspIssuer != null || rp.ocspSerial != null) {
            throw new CertPathValidatorException("Must specify both ocsp.responderCertIssuerName and ocsp.responderCertSerialNumber properties");
        }
        return null;
    }

    private static X509Certificate getResponderCert(String subject, Set<TrustAnchor> anchors, List<CertStore> stores) throws CertPathValidatorException {
        X509CertSelector sel = new X509CertSelector();
        try {
            sel.setSubject(new X500Principal(subject));
            return getResponderCert(sel, anchors, stores);
        } catch (IllegalArgumentException e2) {
            throw new CertPathValidatorException("cannot parse ocsp.responderCertSubjectName property", e2);
        }
    }

    private static X509Certificate getResponderCert(String issuer, String serial, Set<TrustAnchor> anchors, List<CertStore> stores) throws CertPathValidatorException {
        X509CertSelector sel = new X509CertSelector();
        try {
            sel.setIssuer(new X500Principal(issuer));
            try {
                sel.setSerialNumber(new BigInteger(stripOutSeparators(serial), 16));
                return getResponderCert(sel, anchors, stores);
            } catch (NumberFormatException e2) {
                throw new CertPathValidatorException("cannot parse ocsp.responderCertSerialNumber property", e2);
            }
        } catch (IllegalArgumentException e10) {
            throw new CertPathValidatorException("cannot parse ocsp.responderCertIssuerName property", e10);
        }
    }

    private static X509Certificate getResponderCert(X509CertSelector sel, Set<TrustAnchor> anchors, List<CertStore> stores) throws CertPathValidatorException {
        Collection<? extends Certificate> certs;
        for (TrustAnchor anchor : anchors) {
            X509Certificate cert = anchor.getTrustedCert();
            if (cert != null && sel.match(cert)) {
                return cert;
            }
        }
        for (CertStore store : stores) {
            try {
                certs = store.getCertificates(sel);
            } catch (CertStoreException e2) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("CertStore exception:" + ((Object) e2));
                }
            }
            if (!certs.isEmpty()) {
                return (X509Certificate) certs.iterator2().next();
            }
            continue;
        }
        throw new CertPathValidatorException("Cannot find the responder's certificate (set using the OCSP security properties).");
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean forward) throws CertPathValidatorException {
        if (forward) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        TrustAnchor trustAnchor = this.anchor;
        if (trustAnchor != null) {
            X509Certificate trustedCert = trustAnchor.getTrustedCert();
            this.issuerCert = trustedCert;
            this.prevPubKey = trustedCert != null ? trustedCert.getPublicKey() : this.anchor.getCAPublicKey();
        }
        this.crlSignFlag = true;
        PKIX.ValidatorParams validatorParams = this.params;
        if (validatorParams != null && validatorParams.certPath() != null) {
            this.certIndex = this.params.certPath().getCertificates().size() - 1;
        } else {
            this.certIndex = -1;
        }
        this.softFailExceptions.clear();
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXRevocationChecker
    public List<CertPathValidatorException> getSoftFailExceptions() {
        return Collections.unmodifiableList(this.softFailExceptions);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate cert, Collection<String> unresolvedCritExts) throws CertPathValidatorException {
        check((X509Certificate) cert, unresolvedCritExts, this.prevPubKey, this.crlSignFlag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0116 -> B:41:0x0070). Please report as a decompilation issue!!! */
    private void check(X509Certificate x509Certificate, Collection<String> collection, PublicKey publicKey, boolean z10) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("RevocationChecker.check: checking cert\n  SN: " + Debug.toHexString(x509Certificate.getSerialNumber()) + "\n  Subject: " + ((Object) x509Certificate.getSubjectX500Principal()) + "\n  Issuer: " + ((Object) x509Certificate.getIssuerX500Principal()));
        }
        try {
            try {
            } catch (CertPathValidatorException e2) {
                if (e2.getReason() == CertPathValidatorException.BasicReason.REVOKED) {
                    throw e2;
                }
                boolean isSoftFailException = isSoftFailException(e2);
                if (isSoftFailException) {
                    if (this.mode == Mode.ONLY_OCSP || this.mode == Mode.ONLY_CRLS) {
                        updateState(x509Certificate);
                        return;
                    }
                } else if (this.mode == Mode.ONLY_OCSP || this.mode == Mode.ONLY_CRLS) {
                    throw e2;
                }
                Debug debug3 = debug;
                String str = "RevocationChecker.check() ";
                if (debug3 != null) {
                    debug3.println("RevocationChecker.check() " + e2.getMessage());
                    debug3.println("RevocationChecker.check() preparing to failover");
                }
                try {
                    switch (AnonymousClass2.$SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode[this.mode.ordinal()]) {
                        case 1:
                            checkCRLs(x509Certificate, collection, null, publicKey, z10);
                            str = str;
                            break;
                        case 2:
                        default:
                            str = str;
                            break;
                        case 3:
                            checkOCSP(x509Certificate, collection);
                            str = str;
                            break;
                    }
                } catch (CertPathValidatorException e10) {
                    Debug debug4 = debug;
                    if (debug4 != null) {
                        debug4.println("RevocationChecker.check() failover failed");
                        debug4.println(str + e10.getMessage());
                    }
                    if (e10.getReason() == CertPathValidatorException.BasicReason.REVOKED) {
                        throw e10;
                    }
                    boolean isSoftFailException2 = isSoftFailException(e10);
                    if (isSoftFailException2 == 0) {
                        e2.addSuppressed(e10);
                        throw e2;
                    }
                    if (!isSoftFailException) {
                        throw e2;
                    }
                    str = isSoftFailException2;
                }
            }
            if (this.onlyEE && x509Certificate.getBasicConstraints() != -1) {
                if (debug2 != null) {
                    debug2.println("Skipping revocation check; cert is not an end entity cert");
                }
                updateState(x509Certificate);
            } else {
                switch (AnonymousClass2.$SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode[this.mode.ordinal()]) {
                    case 1:
                    case 2:
                        checkOCSP(x509Certificate, collection);
                        break;
                    case 3:
                    case 4:
                        checkCRLs(x509Certificate, collection, null, publicKey, z10);
                        break;
                }
                updateState(x509Certificate);
            }
        } catch (Throwable th) {
            updateState(x509Certificate);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.security.provider.certpath.RevocationChecker$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$java$security$cert$PKIXRevocationChecker$Option;
        static final /* synthetic */ int[] $SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode = iArr;
            try {
                iArr[Mode.PREFER_OCSP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode[Mode.ONLY_OCSP.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode[Mode.PREFER_CRLS.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$sun$security$provider$certpath$RevocationChecker$Mode[Mode.ONLY_CRLS.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            int[] iArr2 = new int[PKIXRevocationChecker.Option.values().length];
            $SwitchMap$java$security$cert$PKIXRevocationChecker$Option = iArr2;
            try {
                iArr2[PKIXRevocationChecker.Option.ONLY_END_ENTITY.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$security$cert$PKIXRevocationChecker$Option[PKIXRevocationChecker.Option.PREFER_CRLS.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$security$cert$PKIXRevocationChecker$Option[PKIXRevocationChecker.Option.SOFT_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$security$cert$PKIXRevocationChecker$Option[PKIXRevocationChecker.Option.NO_FALLBACK.ordinal()] = 4;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    private boolean isSoftFailException(CertPathValidatorException e2) {
        if (this.softFail && e2.getReason() == CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS) {
            CertPathValidatorException e22 = new CertPathValidatorException(e2.getMessage(), e2.getCause(), this.params.certPath(), this.certIndex, e2.getReason());
            this.softFailExceptions.addFirst(e22);
            return true;
        }
        return false;
    }

    private void updateState(X509Certificate cert) throws CertPathValidatorException {
        this.issuerCert = cert;
        PublicKey pubKey = cert.getPublicKey();
        if (PKIX.isDSAPublicKeyWithoutParams(pubKey)) {
            pubKey = BasicChecker.makeInheritedParamsKey(pubKey, this.prevPubKey);
        }
        this.prevPubKey = pubKey;
        this.crlSignFlag = certCanSignCrl(cert);
        int i10 = this.certIndex;
        if (i10 > 0) {
            this.certIndex = i10 - 1;
        }
    }

    private void checkCRLs(X509Certificate cert, Collection<String> unresolvedCritExts, Set<X509Certificate> stackedCerts, PublicKey pubKey, boolean signFlag) throws CertPathValidatorException {
        checkCRLs(cert, pubKey, null, signFlag, true, stackedCerts, this.params.trustAnchors());
    }

    private void checkCRLs(X509Certificate cert, PublicKey prevKey, X509Certificate prevCert, boolean signFlag, boolean allowSeparateKey, Set<X509Certificate> stackedCerts, Set<TrustAnchor> anchors) throws CertPathValidatorException {
        boolean[] reasonsMask;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("RevocationChecker.checkCRLs() ---checking revocation status ...");
        }
        if (stackedCerts != null && stackedCerts.contains(cert)) {
            if (debug2 != null) {
                debug2.println("RevocationChecker.checkCRLs() circular dependency");
            }
            throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
        }
        Set<X509CRL> possibleCRLs = new HashSet<>();
        Set<X509CRL> approvedCRLs = new HashSet<>();
        X509CRLSelector sel = new X509CRLSelector();
        sel.setCertificateChecking(cert);
        CertPathHelper.setDateAndTime(sel, this.params.date(), MAX_CLOCK_SKEW);
        CertPathValidatorException networkFailureException = null;
        for (CertStore store : this.certStores) {
            try {
                for (CRL crl : store.getCRLs(sel)) {
                    possibleCRLs.add((X509CRL) crl);
                }
            } catch (CertStoreException e2) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("RevocationChecker.checkCRLs() CertStoreException: " + e2.getMessage());
                }
                if (networkFailureException == null && CertStoreHelper.isCausedByNetworkIssue(store.getType(), e2)) {
                    networkFailureException = new CertPathValidatorException("Unable to determine revocation status due to network error", e2, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                }
            }
        }
        Debug debug4 = debug;
        if (debug4 != null) {
            debug4.println("RevocationChecker.checkCRLs() possible crls.size() = " + possibleCRLs.size());
        }
        boolean[] reasonsMask2 = new boolean[9];
        if (!possibleCRLs.isEmpty()) {
            approvedCRLs.addAll(verifyPossibleCRLs(possibleCRLs, cert, prevKey, signFlag, reasonsMask2, anchors));
        }
        if (debug4 != null) {
            debug4.println("RevocationChecker.checkCRLs() approved crls.size() = " + approvedCRLs.size());
        }
        if (!approvedCRLs.isEmpty() && Arrays.equals(reasonsMask2, ALL_REASONS)) {
            checkApprovedCRLs(cert, approvedCRLs);
            return;
        }
        try {
            if (!this.crlDP) {
                reasonsMask = reasonsMask2;
            } else {
                try {
                    reasonsMask = reasonsMask2;
                    try {
                        approvedCRLs.addAll(DistributionPointFetcher.getCRLs(sel, signFlag, prevKey, prevCert, this.params.sigProvider(), this.certStores, reasonsMask, anchors, null));
                    } catch (CertStoreException e10) {
                        e = e10;
                        if (e instanceof PKIX.CertStoreTypeException) {
                            PKIX.CertStoreTypeException cste = (PKIX.CertStoreTypeException) e;
                            if (CertStoreHelper.isCausedByNetworkIssue(cste.getType(), e)) {
                                throw new CertPathValidatorException("Unable to determine revocation status due to network error", e, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                            }
                        }
                        throw new CertPathValidatorException(e);
                    }
                } catch (CertStoreException e11) {
                    e = e11;
                }
            }
            if (!approvedCRLs.isEmpty() && Arrays.equals(reasonsMask, ALL_REASONS)) {
                checkApprovedCRLs(cert, approvedCRLs);
                return;
            }
            if (!allowSeparateKey) {
                if (networkFailureException != null) {
                    throw networkFailureException;
                }
                throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
            }
            try {
                verifyWithSeparateSigningKey(cert, prevKey, signFlag, stackedCerts);
            } catch (CertPathValidatorException cpve) {
                if (networkFailureException != null) {
                    throw networkFailureException;
                }
                throw cpve;
            }
        } catch (CertStoreException e12) {
            e = e12;
        }
    }

    private void checkApprovedCRLs(X509Certificate cert, Set<X509CRL> approvedCRLs) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            BigInteger sn = cert.getSerialNumber();
            debug2.println("RevocationChecker.checkApprovedCRLs() starting the final sweep...");
            debug2.println("RevocationChecker.checkApprovedCRLs() cert SN: " + sn.toString());
        }
        CRLReason cRLReason = CRLReason.UNSPECIFIED;
        for (X509CRL crl : approvedCRLs) {
            X509CRLEntry e2 = crl.getRevokedCertificate(cert);
            if (e2 != null) {
                try {
                    X509CRLEntryImpl entry = X509CRLEntryImpl.toImpl(e2);
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("RevocationChecker.checkApprovedCRLs() CRL entry: " + entry.toString());
                    }
                    Set<String> unresCritExts = entry.getCriticalExtensionOIDs();
                    if (unresCritExts != null && !unresCritExts.isEmpty()) {
                        unresCritExts.remove(PKIXExtensions.ReasonCode_Id.toString());
                        unresCritExts.remove(PKIXExtensions.CertificateIssuer_Id.toString());
                        if (!unresCritExts.isEmpty()) {
                            throw new CertPathValidatorException("Unrecognized critical extension(s) in revoked CRL entry");
                        }
                    }
                    CRLReason reasonCode = entry.getRevocationReason();
                    if (reasonCode == null) {
                        reasonCode = CRLReason.UNSPECIFIED;
                    }
                    Date revocationDate = entry.getRevocationDate();
                    if (revocationDate.before(this.params.date())) {
                        Throwable t2 = new CertificateRevokedException(revocationDate, reasonCode, crl.getIssuerX500Principal(), entry.getExtensions());
                        throw new CertPathValidatorException(t2.getMessage(), t2, null, -1, CertPathValidatorException.BasicReason.REVOKED);
                    }
                } catch (CRLException ce2) {
                    throw new CertPathValidatorException(ce2);
                }
            }
        }
    }

    private void checkOCSP(X509Certificate cert, Collection<String> unresolvedCritExts) throws CertPathValidatorException {
        IOException e2;
        CertId certId;
        OCSPResponse response;
        try {
            X509CertImpl currCert = X509CertImpl.toImpl(cert);
            try {
                if (this.issuerCert != null) {
                    certId = new CertId(this.issuerCert, currCert.getSerialNumberObject());
                } else {
                    certId = new CertId(this.anchor.getCA(), this.anchor.getCAPublicKey(), currCert.getSerialNumberObject());
                }
                byte[] responseBytes = this.ocspResponses.get(cert);
                if (responseBytes != null) {
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("Found cached OCSP response");
                    }
                    OCSPResponse response2 = new OCSPResponse(responseBytes);
                    byte[] nonce = null;
                    try {
                        for (Extension ext : this.ocspExtensions) {
                            if (ext.getId().equals("1.3.6.1.5.5.7.48.1.2")) {
                                nonce = ext.getValue();
                            }
                        }
                        response2.verify(Collections.singletonList(certId), this.issuerCert, this.responderCert, this.params.date(), nonce);
                        response = response2;
                    } catch (IOException e10) {
                        e2 = e10;
                        throw new CertPathValidatorException("Unable to determine revocation status due to network error", e2, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                    }
                } else {
                    URI responderURI = this.responderURI;
                    if (responderURI == null) {
                        responderURI = OCSP.getResponderURI(currCert);
                    }
                    if (responderURI == null) {
                        throw new CertPathValidatorException("Certificate does not specify OCSP responder", null, null, -1);
                    }
                    response = OCSP.check((List<CertId>) Collections.singletonList(certId), responderURI, this.issuerCert, this.responderCert, (Date) null, this.ocspExtensions);
                }
                OCSP.RevocationStatus rs = response.getSingleResponse(certId);
                OCSP.RevocationStatus.CertStatus certStatus = rs.getCertStatus();
                if (certStatus == OCSP.RevocationStatus.CertStatus.REVOKED) {
                    Date revocationTime = rs.getRevocationTime();
                    if (revocationTime.before(this.params.date())) {
                        Throwable t2 = new CertificateRevokedException(revocationTime, rs.getRevocationReason(), response.getSignerCertificate().getSubjectX500Principal(), rs.getSingleExtensions());
                        throw new CertPathValidatorException(t2.getMessage(), t2, null, -1, CertPathValidatorException.BasicReason.REVOKED);
                    }
                    return;
                }
                if (certStatus == OCSP.RevocationStatus.CertStatus.UNKNOWN) {
                    throw new CertPathValidatorException("Certificate's revocation status is unknown", null, this.params.certPath(), -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                }
            } catch (IOException e11) {
                e2 = e11;
            }
        } catch (CertificateException ce2) {
            throw new CertPathValidatorException(ce2);
        }
    }

    private static String stripOutSeparators(String value) {
        char[] chars = value.toCharArray();
        StringBuilder hexNumber = new StringBuilder();
        for (int i10 = 0; i10 < chars.length; i10++) {
            if (HEX_DIGITS.indexOf(chars[i10]) != -1) {
                hexNumber.append(chars[i10]);
            }
        }
        return hexNumber.toString();
    }

    static boolean certCanSignCrl(X509Certificate cert) {
        boolean[] keyUsage = cert.getKeyUsage();
        if (keyUsage != null) {
            return keyUsage[6];
        }
        return false;
    }

    private Collection<X509CRL> verifyPossibleCRLs(Set<X509CRL> crls, X509Certificate cert, PublicKey prevKey, boolean signFlag, boolean[] reasonsMask, Set<TrustAnchor> anchors) throws CertPathValidatorException {
        List<DistributionPoint> points;
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("RevocationChecker.verifyPossibleCRLs: Checking CRLDPs for " + ((Object) certImpl.getSubjectX500Principal()));
            }
            CRLDistributionPointsExtension ext = certImpl.getCRLDistributionPointsExtension();
            if (ext == null) {
                X500Name certIssuer = (X500Name) certImpl.getIssuerDN();
                DistributionPoint point = new DistributionPoint(new GeneralNames().add(new GeneralName(certIssuer)), (boolean[]) null, (GeneralNames) null);
                List<DistributionPoint> points2 = Collections.singletonList(point);
                points = points2;
            } else {
                List<DistributionPoint> points3 = ext.get(CRLDistributionPointsExtension.POINTS);
                points = points3;
            }
            Set<X509CRL> results = new HashSet<>();
            for (DistributionPoint point2 : points) {
                for (X509CRL crl : crls) {
                    CRLDistributionPointsExtension ext2 = ext;
                    if (DistributionPointFetcher.verifyCRL(certImpl, point2, crl, reasonsMask, signFlag, prevKey, null, this.params.sigProvider(), anchors, this.certStores, this.params.date())) {
                        results.add(crl);
                    }
                    ext = ext2;
                }
                CRLDistributionPointsExtension ext3 = ext;
                try {
                    if (Arrays.equals(reasonsMask, ALL_REASONS)) {
                        break;
                    }
                    ext = ext3;
                } catch (IOException | CRLException | CertificateException e2) {
                    e = e2;
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("Exception while verifying CRL: " + e.getMessage());
                        e.printStackTrace();
                    }
                    return Collections.emptySet();
                }
            }
            return results;
        } catch (IOException | CRLException | CertificateException e10) {
            e = e10;
        }
    }

    private void verifyWithSeparateSigningKey(X509Certificate cert, PublicKey prevKey, boolean signFlag, Set<X509Certificate> stackedCerts) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("RevocationChecker.verifyWithSeparateSigningKey() ---checking revocation status...");
        }
        if (stackedCerts != null && stackedCerts.contains(cert)) {
            if (debug2 != null) {
                debug2.println("RevocationChecker.verifyWithSeparateSigningKey() circular dependency");
            }
            throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
        }
        if (!signFlag) {
            buildToNewKey(cert, null, stackedCerts);
        } else {
            buildToNewKey(cert, prevKey, stackedCerts);
        }
    }

    private void buildToNewKey(X509Certificate currCert, PublicKey prevKey, Set<X509Certificate> stackedCerts) throws CertPathValidatorException {
        PublicKey prevKey2;
        Set<X509Certificate> stackedCerts2;
        CertPathBuilder builder;
        int i10;
        List<? extends Certificate> cpList;
        X509Certificate newCert;
        PublicKey newKey;
        X509Certificate cert;
        List<? extends Certificate> cpList2;
        List<AccessDescription> adList;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("RevocationChecker.buildToNewKey() starting work");
        }
        Set<PublicKey> badKeys = new HashSet<>();
        if (prevKey != null) {
            badKeys.add(prevKey);
        }
        X509CertSelector certSel = new RejectKeySelector(badKeys);
        certSel.setSubject(currCert.getIssuerX500Principal());
        certSel.setKeyUsage(CRL_SIGN_USAGE);
        TrustAnchor trustAnchor = this.anchor;
        Set<TrustAnchor> newAnchors = trustAnchor == null ? this.params.trustAnchors() : Collections.singleton(trustAnchor);
        try {
            PKIXBuilderParameters builderParams = new PKIXBuilderParameters(newAnchors, certSel);
            builderParams.setInitialPolicies(this.params.initialPolicies());
            builderParams.setCertStores(this.certStores);
            builderParams.setExplicitPolicyRequired(this.params.explicitPolicyRequired());
            builderParams.setPolicyMappingInhibited(this.params.policyMappingInhibited());
            builderParams.setAnyPolicyInhibited(this.params.anyPolicyInhibited());
            builderParams.setDate(this.params.date());
            builderParams.setCertPathCheckers(this.params.getPKIXParameters().getCertPathCheckers());
            builderParams.setSigProvider(this.params.sigProvider());
            int i11 = 0;
            builderParams.setRevocationEnabled(false);
            int i12 = 1;
            if (Builder.USE_AIA) {
                X509CertImpl currCertImpl = null;
                try {
                    currCertImpl = X509CertImpl.toImpl(currCert);
                } catch (CertificateException ce2) {
                    if (debug != null) {
                        debug.println("RevocationChecker.buildToNewKey: error decoding cert: " + ((Object) ce2));
                    }
                }
                AuthorityInfoAccessExtension aiaExt = currCertImpl != null ? currCertImpl.getAuthorityInfoAccessExtension() : null;
                if (aiaExt != null && (adList = aiaExt.getAccessDescriptions()) != null) {
                    for (AccessDescription ad2 : adList) {
                        CertStore cs = URICertStore.getInstance(ad2);
                        if (cs != null) {
                            Debug debug3 = debug;
                            if (debug3 != null) {
                                debug3.println("adding AIAext CertStore");
                            }
                            builderParams.addCertStore(cs);
                        }
                    }
                }
            }
            try {
                CertPathBuilder builder2 = CertPathBuilder.getInstance("PKIX");
                Set<X509Certificate> stackedCerts3 = stackedCerts;
                while (true) {
                    try {
                        Debug debug4 = debug;
                        if (debug4 != null) {
                            try {
                                debug4.println("RevocationChecker.buildToNewKey() about to try build ...");
                            } catch (InvalidAlgorithmParameterException e2) {
                                iape = e2;
                                throw new CertPathValidatorException(iape);
                            } catch (CertPathBuilderException e10) {
                                throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                            }
                        }
                        PKIXCertPathBuilderResult cpbr = (PKIXCertPathBuilderResult) builder2.build(builderParams);
                        if (debug4 != null) {
                            debug4.println("RevocationChecker.buildToNewKey() about to check revocation ...");
                        }
                        Set<X509Certificate> stackedCerts4 = stackedCerts3 == null ? new HashSet() : stackedCerts3;
                        try {
                            stackedCerts4.add(currCert);
                            TrustAnchor ta2 = cpbr.getTrustAnchor();
                            PublicKey prevKey22 = ta2.getCAPublicKey();
                            if (prevKey22 == null) {
                                try {
                                    prevKey2 = ta2.getTrustedCert().getPublicKey();
                                } catch (InvalidAlgorithmParameterException e11) {
                                    iape = e11;
                                    throw new CertPathValidatorException(iape);
                                } catch (CertPathBuilderException e12) {
                                    throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                                }
                            } else {
                                prevKey2 = prevKey22;
                            }
                            List<? extends Certificate> cpList3 = cpbr.getCertPath().getCertificates();
                            try {
                                int i13 = cpList3.size() - i12;
                                PublicKey prevKey23 = prevKey2;
                                boolean signFlag = true;
                                while (i13 >= 0) {
                                    try {
                                        cert = (X509Certificate) cpList3.get(i13);
                                        Debug debug5 = debug;
                                        if (debug5 != null) {
                                            try {
                                            } catch (CertPathValidatorException e13) {
                                                stackedCerts2 = stackedCerts4;
                                                builder = builder2;
                                                i10 = i12;
                                            }
                                            try {
                                                debug5.println("RevocationChecker.buildToNewKey() index " + i13 + " checking " + ((Object) cert));
                                            } catch (CertPathValidatorException e14) {
                                                stackedCerts2 = stackedCerts4;
                                                builder = builder2;
                                                i10 = 1;
                                                try {
                                                    badKeys.add(cpbr.getPublicKey());
                                                    i12 = i10;
                                                    builder2 = builder;
                                                    stackedCerts3 = stackedCerts2;
                                                    i11 = 0;
                                                } catch (InvalidAlgorithmParameterException e15) {
                                                    iape = e15;
                                                    throw new CertPathValidatorException(iape);
                                                } catch (CertPathBuilderException e16) {
                                                    throw new CertPathValidatorException("Could not determine revocation status", null, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                                                }
                                            }
                                        }
                                        cpList2 = cpList3;
                                        stackedCerts2 = stackedCerts4;
                                        builder = builder2;
                                        i10 = 1;
                                    } catch (CertPathValidatorException e17) {
                                        stackedCerts2 = stackedCerts4;
                                        builder = builder2;
                                        i10 = i12;
                                    }
                                    try {
                                        checkCRLs(cert, prevKey23, null, signFlag, true, stackedCerts2, newAnchors);
                                        signFlag = certCanSignCrl(cert);
                                        prevKey23 = cert.getPublicKey();
                                        i13--;
                                        cpList3 = cpList2;
                                        i12 = 1;
                                        builder2 = builder;
                                        stackedCerts4 = stackedCerts2;
                                    } catch (CertPathValidatorException e18) {
                                        badKeys.add(cpbr.getPublicKey());
                                        i12 = i10;
                                        builder2 = builder;
                                        stackedCerts3 = stackedCerts2;
                                        i11 = 0;
                                    }
                                }
                                List<? extends Certificate> cpList4 = cpList3;
                                stackedCerts2 = stackedCerts4;
                                builder = builder2;
                                i10 = i12;
                                Debug debug6 = debug;
                                if (debug6 != null) {
                                    debug6.println("RevocationChecker.buildToNewKey() got key " + ((Object) cpbr.getPublicKey()));
                                }
                                PublicKey newKey2 = cpbr.getPublicKey();
                                if (cpList4.isEmpty()) {
                                    cpList = cpList4;
                                    newCert = null;
                                } else {
                                    cpList = cpList4;
                                    newCert = (X509Certificate) cpList.get(i11);
                                }
                                try {
                                    newKey = newKey2;
                                } catch (CertPathValidatorException e19) {
                                    cpve = e19;
                                    newKey = newKey2;
                                }
                                try {
                                    checkCRLs(currCert, newKey2, newCert, true, false, null, this.params.trustAnchors());
                                    return;
                                } catch (CertPathValidatorException e20) {
                                    cpve = e20;
                                    if (cpve.getReason() == CertPathValidatorException.BasicReason.REVOKED) {
                                        throw cpve;
                                    }
                                    badKeys.add(newKey);
                                    i12 = i10;
                                    builder2 = builder;
                                    stackedCerts3 = stackedCerts2;
                                    i11 = 0;
                                }
                            } catch (CertPathValidatorException e21) {
                                stackedCerts2 = stackedCerts4;
                                builder = builder2;
                                i10 = i12;
                            }
                            i12 = i10;
                            builder2 = builder;
                            stackedCerts3 = stackedCerts2;
                            i11 = 0;
                        } catch (InvalidAlgorithmParameterException e22) {
                            iape = e22;
                        } catch (CertPathBuilderException e23) {
                        }
                    } catch (InvalidAlgorithmParameterException e24) {
                        iape = e24;
                    } catch (CertPathBuilderException e25) {
                    }
                }
            } catch (NoSuchAlgorithmException nsae) {
                throw new CertPathValidatorException(nsae);
            }
        } catch (InvalidAlgorithmParameterException iape) {
            throw new RuntimeException(iape);
        }
    }

    @Override // java.security.cert.PKIXRevocationChecker, java.security.cert.PKIXCertPathChecker
    public RevocationChecker clone() {
        RevocationChecker copy = (RevocationChecker) super.clone();
        copy.softFailExceptions = new LinkedList<>(this.softFailExceptions);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class RejectKeySelector extends X509CertSelector {
        private final Set<PublicKey> badKeySet;

        RejectKeySelector(Set<PublicKey> badPublicKeys) {
            this.badKeySet = badPublicKeys;
        }

        @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
        public boolean match(Certificate cert) {
            if (!super.match(cert)) {
                return false;
            }
            if (this.badKeySet.contains(cert.getPublicKey())) {
                if (RevocationChecker.debug != null) {
                    RevocationChecker.debug.println("RejectKeySelector.match: bad key");
                }
                return false;
            }
            if (RevocationChecker.debug != null) {
                RevocationChecker.debug.println("RejectKeySelector.match: returning true");
                return true;
            }
            return true;
        }

        @Override // java.security.cert.X509CertSelector
        public String toString() {
            return "RejectKeySelector: [\n" + super.toString() + ((Object) this.badKeySet) + "]";
        }
    }
}
