package sun.security.provider.certpath;

import com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathChecker;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXReason;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PKIXCertPathValidator extends CertPathValidatorSpi {
    private static final Debug debug = Debug.getInstance("certpath");

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathChecker engineGetRevocationChecker() {
        return new RevocationChecker();
    }

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath cp, CertPathParameters params) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIX.ValidatorParams valParams = PKIX.checkParams(cp, params);
        return validate(valParams);
    }

    private static PKIXCertPathValidatorResult validate(PKIX.ValidatorParams params) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("PKIXCertPathValidator.engineValidate()...");
        }
        AdaptableX509CertSelector selector = null;
        List<X509Certificate> certList = params.certificates();
        if (!certList.isEmpty()) {
            selector = new AdaptableX509CertSelector();
            X509Certificate firstCert = certList.get(0);
            selector.setSubject(firstCert.getIssuerX500Principal());
            try {
                X509CertImpl firstCertImpl = X509CertImpl.toImpl(firstCert);
                selector.setSkiAndSerialNumber(firstCertImpl.getAuthorityKeyIdentifierExtension());
            } catch (IOException | CertificateException e2) {
            }
        }
        CertPathValidatorException lastException = null;
        Iterator<TrustAnchor> iterator2 = params.trustAnchors().iterator2();
        while (iterator2.hasNext()) {
            TrustAnchor anchor = iterator2.next();
            X509Certificate trustedCert = anchor.getTrustedCert();
            if (trustedCert != null) {
                if (selector != null && !selector.match(trustedCert)) {
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("NO - don't try this trustedCert");
                    }
                } else {
                    Debug debug4 = debug;
                    if (debug4 != null) {
                        debug4.println("YES - try this trustedCert");
                        debug4.println("anchor.getTrustedCert().getSubjectX500Principal() = " + ((Object) trustedCert.getSubjectX500Principal()));
                    }
                }
            } else {
                Debug debug5 = debug;
                if (debug5 != null) {
                    debug5.println("PKIXCertPathValidator.engineValidate(): anchor.getTrustedCert() == null");
                }
            }
            try {
                return validate(anchor, params);
            } catch (CertPathValidatorException cpe) {
                lastException = cpe;
            }
        }
        if (lastException != null) {
            throw lastException;
        }
        throw new CertPathValidatorException("Path does not chain with any of the trust anchors", null, null, -1, PKIXReason.NO_TRUST_ANCHOR);
    }

    private static PKIXCertPathValidatorResult validate(TrustAnchor anchor, PKIX.ValidatorParams params) throws CertPathValidatorException {
        int certPathLen = params.certificates().size();
        List<PKIXCertPathChecker> certPathCheckers = new ArrayList<>();
        certPathCheckers.add(new AlgorithmChecker(anchor));
        certPathCheckers.add(new KeyChecker(certPathLen, params.targetCertConstraints()));
        certPathCheckers.add(new ConstraintsChecker(certPathLen));
        PolicyNodeImpl rootNode = new PolicyNodeImpl(null, RFC3280CertPathUtilities.ANY_POLICY, null, false, Collections.singleton(RFC3280CertPathUtilities.ANY_POLICY), false);
        PolicyChecker pc2 = new PolicyChecker(params.initialPolicies(), certPathLen, params.explicitPolicyRequired(), params.policyMappingInhibited(), params.anyPolicyInhibited(), params.policyQualifiersRejected(), rootNode);
        certPathCheckers.add(pc2);
        BasicChecker bc2 = new BasicChecker(anchor, params.date(), params.sigProvider(), false);
        certPathCheckers.add(bc2);
        boolean revCheckerAdded = false;
        List<PKIXCertPathChecker> checkers = params.certPathCheckers();
        for (PKIXCertPathChecker checker : checkers) {
            if (checker instanceof PKIXRevocationChecker) {
                if (revCheckerAdded) {
                    throw new CertPathValidatorException("Only one PKIXRevocationChecker can be specified");
                }
                revCheckerAdded = true;
                if (checker instanceof RevocationChecker) {
                    ((RevocationChecker) checker).init(anchor, params);
                }
            }
        }
        if (params.revocationEnabled() && !revCheckerAdded) {
            certPathCheckers.add(new RevocationChecker(anchor, params));
        }
        certPathCheckers.addAll(checkers);
        PKIXMasterCertPathValidator.validate(params.certPath(), params.certificates(), certPathCheckers);
        return new PKIXCertPathValidatorResult(anchor, pc2.getPolicyTree(), bc2.getPublicKey());
    }
}
