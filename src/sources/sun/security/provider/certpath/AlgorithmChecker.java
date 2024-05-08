package sun.security.provider.certpath;

import java.math.BigInteger;
import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import sun.security.util.AnchorCertificates;
import sun.security.util.CertConstraintParameters;
import sun.security.util.Debug;
import sun.security.util.DisabledAlgorithmConstraints;
import sun.security.util.KeyUtil;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AlgorithmChecker extends PKIXCertPathChecker {
    private static final DisabledAlgorithmConstraints certPathDefaultConstraints;
    private static final boolean publicCALimits;
    private final AlgorithmConstraints constraints;
    private PublicKey prevPubKey;
    private boolean trustedMatch;
    private final PublicKey trustedPubKey;
    private static final Debug debug = Debug.getInstance("certpath");
    private static final Set<CryptoPrimitive> SIGNATURE_PRIMITIVE_SET = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.SIGNATURE));
    private static final Set<CryptoPrimitive> KU_PRIMITIVE_SET = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.SIGNATURE, CryptoPrimitive.KEY_ENCAPSULATION, CryptoPrimitive.PUBLIC_KEY_ENCRYPTION, CryptoPrimitive.KEY_AGREEMENT));

    static {
        DisabledAlgorithmConstraints disabledAlgorithmConstraints = new DisabledAlgorithmConstraints(DisabledAlgorithmConstraints.PROPERTY_CERTPATH_DISABLED_ALGS);
        certPathDefaultConstraints = disabledAlgorithmConstraints;
        publicCALimits = disabledAlgorithmConstraints.checkProperty("jdkCA");
    }

    public AlgorithmChecker(TrustAnchor anchor) {
        this(anchor, certPathDefaultConstraints);
    }

    public AlgorithmChecker(AlgorithmConstraints constraints) {
        this.trustedMatch = false;
        this.prevPubKey = null;
        this.trustedPubKey = null;
        this.constraints = constraints;
    }

    public AlgorithmChecker(TrustAnchor anchor, AlgorithmConstraints constraints) {
        Debug debug2;
        this.trustedMatch = false;
        if (anchor == null) {
            throw new IllegalArgumentException("The trust anchor cannot be null");
        }
        if (anchor.getTrustedCert() != null) {
            this.trustedPubKey = anchor.getTrustedCert().getPublicKey();
            boolean checkFingerprint = checkFingerprint(anchor.getTrustedCert());
            this.trustedMatch = checkFingerprint;
            if (checkFingerprint && (debug2 = debug) != null) {
                debug2.println("trustedMatch = true");
            }
        } else {
            this.trustedPubKey = anchor.getCAPublicKey();
        }
        this.prevPubKey = this.trustedPubKey;
        this.constraints = constraints;
    }

    private static boolean checkFingerprint(X509Certificate cert) {
        if (!publicCALimits) {
            return false;
        }
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("AlgorithmChecker.contains: " + cert.getSigAlgName());
        }
        return AnchorCertificates.contains(cert);
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean forward) throws CertPathValidatorException {
        if (!forward) {
            PublicKey publicKey = this.trustedPubKey;
            if (publicKey != null) {
                this.prevPubKey = publicKey;
                return;
            } else {
                this.prevPubKey = null;
                return;
            }
        }
        throw new CertPathValidatorException("forward checking not supported");
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate cert, Collection<String> unresolvedCritExts) throws CertPathValidatorException {
        Set<CryptoPrimitive> primitives;
        if (!(cert instanceof X509Certificate) || this.constraints == null) {
            return;
        }
        boolean[] keyUsage = ((X509Certificate) cert).getKeyUsage();
        if (keyUsage != null && keyUsage.length < 9) {
            throw new CertPathValidatorException("incorrect KeyUsage extension", null, null, -1, PKIXReason.INVALID_KEY_USAGE);
        }
        Set<CryptoPrimitive> primitives2 = KU_PRIMITIVE_SET;
        if (keyUsage == null) {
            primitives = primitives2;
        } else {
            Set<CryptoPrimitive> primitives3 = EnumSet.noneOf(CryptoPrimitive.class);
            if (keyUsage[0] || keyUsage[1] || keyUsage[5] || keyUsage[6]) {
                primitives3.add(CryptoPrimitive.SIGNATURE);
            }
            if (keyUsage[2]) {
                primitives3.add(CryptoPrimitive.KEY_ENCAPSULATION);
            }
            if (keyUsage[3]) {
                primitives3.add(CryptoPrimitive.PUBLIC_KEY_ENCRYPTION);
            }
            if (keyUsage[4]) {
                primitives3.add(CryptoPrimitive.KEY_AGREEMENT);
            }
            if (primitives3.isEmpty()) {
                throw new CertPathValidatorException("incorrect KeyUsage extension bits", null, null, -1, PKIXReason.INVALID_KEY_USAGE);
            }
            primitives = primitives3;
        }
        PublicKey currPubKey = cert.getPublicKey();
        AlgorithmConstraints algorithmConstraints = this.constraints;
        if (algorithmConstraints instanceof DisabledAlgorithmConstraints) {
            ((DisabledAlgorithmConstraints) algorithmConstraints).permits(primitives, new CertConstraintParameters((X509Certificate) cert, this.trustedMatch));
            if (this.prevPubKey == null) {
                this.prevPubKey = currPubKey;
                return;
            }
        }
        try {
            X509CertImpl x509Cert = X509CertImpl.toImpl((X509Certificate) cert);
            AlgorithmId algorithmId = (AlgorithmId) x509Cert.get(X509CertImpl.SIG_ALG);
            AlgorithmParameters currSigAlgParams = algorithmId.getParameters();
            String currSigAlg = x509Cert.getSigAlgName();
            AlgorithmConstraints algorithmConstraints2 = this.constraints;
            if (!(algorithmConstraints2 instanceof DisabledAlgorithmConstraints)) {
                if (!algorithmConstraints2.permits(SIGNATURE_PRIMITIVE_SET, currSigAlg, currSigAlgParams)) {
                    throw new CertPathValidatorException("Algorithm constraints check failed on signature algorithm: " + currSigAlg, null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
                }
                if (!this.constraints.permits(primitives, currPubKey)) {
                    throw new CertPathValidatorException("Algorithm constraints check failed on keysize: " + KeyUtil.getKeySize(currPubKey), null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
                }
            }
            PublicKey publicKey = this.prevPubKey;
            if (publicKey != null) {
                if (!this.constraints.permits(SIGNATURE_PRIMITIVE_SET, currSigAlg, publicKey, currSigAlgParams)) {
                    throw new CertPathValidatorException("Algorithm constraints check failed on signature algorithm: " + currSigAlg, null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
                }
                if (PKIX.isDSAPublicKeyWithoutParams(currPubKey)) {
                    PublicKey publicKey2 = this.prevPubKey;
                    if (!(publicKey2 instanceof DSAPublicKey)) {
                        throw new CertPathValidatorException("Input key is not of a appropriate type for inheriting parameters");
                    }
                    DSAParams params = ((DSAPublicKey) publicKey2).getParams();
                    if (params == null) {
                        throw new CertPathValidatorException("Key parameters missing from public key.");
                    }
                    try {
                        BigInteger y10 = ((DSAPublicKey) currPubKey).getY();
                        KeyFactory kf = KeyFactory.getInstance("DSA");
                        DSAPublicKeySpec ks = new DSAPublicKeySpec(y10, params.getP(), params.getQ(), params.getG());
                        currPubKey = kf.generatePublic(ks);
                    } catch (GeneralSecurityException e2) {
                        throw new CertPathValidatorException("Unable to generate key with inherited parameters: " + e2.getMessage(), e2);
                    }
                }
            }
            this.prevPubKey = currPubKey;
        } catch (CertificateException ce2) {
            throw new CertPathValidatorException(ce2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void trySetTrustAnchor(TrustAnchor anchor) {
        Debug debug2;
        if (this.prevPubKey == null) {
            if (anchor == null) {
                throw new IllegalArgumentException("The trust anchor cannot be null");
            }
            if (anchor.getTrustedCert() != null) {
                this.prevPubKey = anchor.getTrustedCert().getPublicKey();
                boolean checkFingerprint = checkFingerprint(anchor.getTrustedCert());
                this.trustedMatch = checkFingerprint;
                if (checkFingerprint && (debug2 = debug) != null) {
                    debug2.println("trustedMatch = true");
                    return;
                }
                return;
            }
            this.prevPubKey = anchor.getCAPublicKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void check(PublicKey key, X509CRL crl) throws CertPathValidatorException {
        try {
            X509CRLImpl x509CRLImpl = X509CRLImpl.toImpl(crl);
            AlgorithmId algorithmId = x509CRLImpl.getSigAlgId();
            check(key, algorithmId);
        } catch (CRLException ce2) {
            throw new CertPathValidatorException(ce2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void check(PublicKey key, AlgorithmId algorithmId) throws CertPathValidatorException {
        String sigAlgName = algorithmId.getName();
        AlgorithmParameters sigAlgParams = algorithmId.getParameters();
        if (!certPathDefaultConstraints.permits(SIGNATURE_PRIMITIVE_SET, sigAlgName, key, sigAlgParams)) {
            throw new CertPathValidatorException("Algorithm constraints check failed on signature algorithm: " + sigAlgName + " is disabled", null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
        }
    }
}
