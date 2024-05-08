package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertificate;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedParameters;
import com.android.internal.org.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.android.internal.org.bouncycastle.x509.ExtendedPKIXParameters;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi() {
        this(false);
    }

    public PKIXCertPathValidatorSpi(boolean isForCRLCheck) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = isForCRLCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class NoPreloadHolder {
        private static final CertBlocklist blocklist = new CertBlocklist();

        private NoPreloadHolder() {
        }
    }

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters params) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters paramsPKIX;
        List certs;
        CertPath certPath2;
        int explicitPolicy;
        int inhibitAnyPolicy;
        int policyMapping;
        CertPath certPath3;
        X500Name workingIssuerName;
        PublicKey workingPublicKey;
        ProvCrlRevocationChecker revocationChecker;
        Set criticalExtensions;
        PKIXNameConstraintValidator nameConstraintValidator;
        int inhibitAnyPolicy2;
        int policyMapping2;
        int maxPathLength;
        List[] policyNodes;
        List pathCheckers;
        PublicKey workingPublicKey2;
        PKIXPolicyNode validPolicyTree;
        Set criticalExtensions2;
        PKIXCertPathValidatorSpi pKIXCertPathValidatorSpi = this;
        CertPath certPath4 = certPath;
        if (params instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder paramsPKIXBldr = new PKIXExtendedParameters.Builder((PKIXParameters) params);
            if (params instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extPKIX = (ExtendedPKIXParameters) params;
                paramsPKIXBldr.setUseDeltasEnabled(extPKIX.isUseDeltasEnabled());
                paramsPKIXBldr.setValidityModel(extPKIX.getValidityModel());
            }
            PKIXExtendedParameters paramsPKIX2 = paramsPKIXBldr.build();
            paramsPKIX = paramsPKIX2;
        } else if (params instanceof PKIXExtendedBuilderParameters) {
            paramsPKIX = ((PKIXExtendedBuilderParameters) params).getBaseParameters();
        } else {
            if (!(params instanceof PKIXExtendedParameters)) {
                throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
            }
            paramsPKIX = (PKIXExtendedParameters) params;
        }
        if (paramsPKIX.getTrustAnchors() == null) {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        List certs2 = certPath.getCertificates();
        int i10 = certs2.size();
        if (certs2.isEmpty()) {
            throw new CertPathValidatorException("Certification path is empty.", null, certPath4, -1);
        }
        X509Certificate cert = (X509Certificate) certs2.get(0);
        if (cert != null) {
            BigInteger serial = cert.getSerialNumber();
            if (NoPreloadHolder.blocklist.isSerialNumberBlockListed(serial)) {
                String message = "Certificate revocation of serial 0x" + serial.toString(16);
                System.out.println(message);
                AnnotatedException e2 = new AnnotatedException(message);
                throw new CertPathValidatorException(e2.getMessage(), e2, certPath4, 0);
            }
        }
        Date currentDate = new Date();
        Date validityDate = CertPathValidatorUtilities.getValidityDate(paramsPKIX, currentDate);
        Set userInitialPolicySet = paramsPKIX.getInitialPolicies();
        try {
            TrustAnchor trust = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certs2.get(certs2.size() - 1), paramsPKIX.getTrustAnchors(), paramsPKIX.getSigProvider());
            if (trust != null) {
                checkCertificate(trust.getTrustedCert());
                PKIXExtendedParameters paramsPKIX3 = new PKIXExtendedParameters.Builder(paramsPKIX).setTrustAnchor(trust).build();
                List[] policyNodes2 = new ArrayList[i10 + 1];
                for (int j10 = 0; j10 < policyNodes2.length; j10++) {
                    policyNodes2[j10] = new ArrayList();
                }
                Set policySet = new HashSet();
                policySet.add(RFC3280CertPathUtilities.ANY_POLICY);
                PKIXPolicyNode validPolicyTree2 = new PKIXPolicyNode(new ArrayList(), 0, policySet, null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                policyNodes2[0].add(validPolicyTree2);
                PKIXNameConstraintValidator nameConstraintValidator2 = new PKIXNameConstraintValidator();
                Set acceptablePolicies = new HashSet();
                PKIXNameConstraintValidator nameConstraintValidator3 = nameConstraintValidator2;
                if (paramsPKIX3.isExplicitPolicyRequired()) {
                    explicitPolicy = 0;
                } else {
                    explicitPolicy = i10 + 1;
                }
                if (paramsPKIX3.isAnyPolicyInhibited()) {
                    inhibitAnyPolicy = 0;
                } else {
                    inhibitAnyPolicy = i10 + 1;
                }
                if (paramsPKIX3.isPolicyMappingInhibited()) {
                    policyMapping = 0;
                } else {
                    policyMapping = i10 + 1;
                }
                X509Certificate sign = trust.getTrustedCert();
                if (sign != null) {
                    try {
                        workingIssuerName = PrincipalUtils.getSubjectPrincipal(sign);
                        workingPublicKey = sign.getPublicKey();
                    } catch (RuntimeException e10) {
                        ex = e10;
                        certPath3 = certPath4;
                        throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", ex, certPath3, -1);
                    }
                } else {
                    try {
                        workingIssuerName = PrincipalUtils.getCA(trust);
                        workingPublicKey = trust.getCAPublicKey();
                    } catch (RuntimeException e11) {
                        ex = e11;
                        certPath3 = certPath4;
                        throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", ex, certPath3, -1);
                    }
                }
                try {
                    AlgorithmIdentifier workingAlgId = CertPathValidatorUtilities.getAlgorithmIdentifier(workingPublicKey);
                    workingAlgId.getAlgorithm();
                    workingAlgId.getParameters();
                    if (paramsPKIX3.getTargetConstraints() != null && !paramsPKIX3.getTargetConstraints().match((Certificate) certs2.get(0))) {
                        throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath4, 0);
                    }
                    List pathCheckers2 = paramsPKIX3.getCertPathCheckers();
                    Iterator certIter = pathCheckers2.iterator2();
                    while (certIter.hasNext()) {
                        ((PKIXCertPathChecker) certIter.next()).init(false);
                    }
                    if (paramsPKIX3.isRevocationEnabled()) {
                        revocationChecker = new ProvCrlRevocationChecker(pKIXCertPathValidatorSpi.helper);
                    } else {
                        revocationChecker = null;
                    }
                    X509Certificate cert2 = null;
                    int policyMapping3 = policyMapping;
                    int maxPathLength2 = i10;
                    int index = certs2.size() - 1;
                    Set acceptablePolicies2 = acceptablePolicies;
                    int explicitPolicy2 = explicitPolicy;
                    PublicKey workingPublicKey3 = workingPublicKey;
                    X500Name workingIssuerName2 = workingIssuerName;
                    X509Certificate sign2 = sign;
                    PKIXPolicyNode validPolicyTree3 = validPolicyTree2;
                    int inhibitAnyPolicy3 = inhibitAnyPolicy;
                    while (index >= 0) {
                        if (NoPreloadHolder.blocklist.isPublicKeyBlockListed(workingPublicKey3)) {
                            CertPath certPath5 = certPath4;
                            String message2 = "Certificate revocation of public key " + ((Object) workingPublicKey3);
                            System.out.println(message2);
                            AnnotatedException e12 = new AnnotatedException(message2);
                            throw new CertPathValidatorException(e12.getMessage(), e12, certPath5, index);
                        }
                        int i11 = i10 - index;
                        X509Certificate cert3 = (X509Certificate) certs2.get(index);
                        int inhibitAnyPolicy4 = inhibitAnyPolicy3;
                        boolean verificationAlreadyPerformed = index == certs2.size() + (-1);
                        try {
                            checkCertificate(cert3);
                            int explicitPolicy3 = explicitPolicy2;
                            int index2 = index;
                            Set policySet2 = policySet;
                            List[] policyNodes3 = policyNodes2;
                            TrustAnchor trust2 = trust;
                            List pathCheckers3 = pathCheckers2;
                            Date currentDate2 = currentDate;
                            RFC3280CertPathUtilities.processCertA(certPath, paramsPKIX3, validityDate, revocationChecker, index2, workingPublicKey3, verificationAlreadyPerformed, workingIssuerName2, sign2);
                            PKIXNameConstraintValidator nameConstraintValidator4 = nameConstraintValidator3;
                            RFC3280CertPathUtilities.processCertBC(certPath4, index2, nameConstraintValidator4, pKIXCertPathValidatorSpi.isForCRLCheck);
                            int n10 = i10;
                            List certs3 = certs2;
                            CertPath certPath6 = certPath4;
                            PublicKey workingPublicKey4 = workingPublicKey3;
                            Set acceptablePolicies3 = acceptablePolicies2;
                            PKIXPolicyNode validPolicyTree4 = RFC3280CertPathUtilities.processCertE(certPath6, index2, RFC3280CertPathUtilities.processCertD(certPath, index2, acceptablePolicies3, validPolicyTree3, policyNodes3, inhibitAnyPolicy4, pKIXCertPathValidatorSpi.isForCRLCheck));
                            RFC3280CertPathUtilities.processCertF(certPath6, index2, validPolicyTree4, explicitPolicy3);
                            if (i11 == n10) {
                                nameConstraintValidator = nameConstraintValidator4;
                                inhibitAnyPolicy2 = inhibitAnyPolicy4;
                                policyMapping2 = policyMapping3;
                                maxPathLength = maxPathLength2;
                                policyNodes = policyNodes3;
                                pathCheckers = pathCheckers3;
                            } else {
                                if (cert3 != null && cert3.getVersion() == 1) {
                                    if (i11 == 1 && cert3.equals(trust2.getTrustedCert())) {
                                        nameConstraintValidator = nameConstraintValidator4;
                                        inhibitAnyPolicy2 = inhibitAnyPolicy4;
                                        policyMapping2 = policyMapping3;
                                        maxPathLength = maxPathLength2;
                                        policyNodes = policyNodes3;
                                        pathCheckers = pathCheckers3;
                                    } else {
                                        throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath6, index2);
                                    }
                                }
                                RFC3280CertPathUtilities.prepareNextCertA(certPath6, index2);
                                int policyMapping4 = policyMapping3;
                                policyNodes = policyNodes3;
                                PKIXPolicyNode validPolicyTree5 = RFC3280CertPathUtilities.prepareCertB(certPath6, index2, policyNodes, validPolicyTree4, policyMapping4);
                                RFC3280CertPathUtilities.prepareNextCertG(certPath6, index2, nameConstraintValidator4);
                                int explicitPolicy4 = RFC3280CertPathUtilities.prepareNextCertH1(certPath6, index2, explicitPolicy3);
                                int policyMapping5 = RFC3280CertPathUtilities.prepareNextCertH2(certPath6, index2, policyMapping4);
                                int inhibitAnyPolicy5 = RFC3280CertPathUtilities.prepareNextCertH3(certPath6, index2, inhibitAnyPolicy4);
                                int explicitPolicy5 = RFC3280CertPathUtilities.prepareNextCertI1(certPath6, index2, explicitPolicy4);
                                int policyMapping6 = RFC3280CertPathUtilities.prepareNextCertI2(certPath6, index2, policyMapping5);
                                int inhibitAnyPolicy6 = RFC3280CertPathUtilities.prepareNextCertJ(certPath6, index2, inhibitAnyPolicy5);
                                RFC3280CertPathUtilities.prepareNextCertK(certPath6, index2);
                                nameConstraintValidator = nameConstraintValidator4;
                                int maxPathLength3 = RFC3280CertPathUtilities.prepareNextCertM(certPath6, index2, RFC3280CertPathUtilities.prepareNextCertL(certPath6, index2, maxPathLength2));
                                RFC3280CertPathUtilities.prepareNextCertN(certPath6, index2);
                                Set criticalExtensions3 = cert3.getCriticalExtensionOIDs();
                                if (criticalExtensions3 != null) {
                                    validPolicyTree = validPolicyTree5;
                                    Set criticalExtensions4 = new HashSet(criticalExtensions3);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    criticalExtensions4.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    criticalExtensions2 = criticalExtensions4;
                                } else {
                                    validPolicyTree = validPolicyTree5;
                                    criticalExtensions2 = new HashSet();
                                }
                                pathCheckers = pathCheckers3;
                                RFC3280CertPathUtilities.prepareNextCertO(certPath6, index2, criticalExtensions2, pathCheckers);
                                sign2 = cert3;
                                workingIssuerName2 = PrincipalUtils.getSubjectPrincipal(sign2);
                                try {
                                    try {
                                        workingPublicKey2 = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), index2, pKIXCertPathValidatorSpi.helper);
                                        AlgorithmIdentifier workingAlgId2 = CertPathValidatorUtilities.getAlgorithmIdentifier(workingPublicKey2);
                                        workingAlgId2.getAlgorithm();
                                        workingAlgId2.getParameters();
                                        inhibitAnyPolicy3 = inhibitAnyPolicy6;
                                        policyMapping3 = policyMapping6;
                                        maxPathLength2 = maxPathLength3;
                                        explicitPolicy2 = explicitPolicy5;
                                        validPolicyTree3 = validPolicyTree;
                                        int maxPathLength4 = index2 - 1;
                                        certPath4 = certPath6;
                                        i10 = n10;
                                        pathCheckers2 = pathCheckers;
                                        policyNodes2 = policyNodes;
                                        certs2 = certs3;
                                        policySet = policySet2;
                                        trust = trust2;
                                        currentDate = currentDate2;
                                        nameConstraintValidator3 = nameConstraintValidator;
                                        acceptablePolicies2 = acceptablePolicies3;
                                        workingPublicKey3 = workingPublicKey2;
                                        cert2 = cert3;
                                        index = maxPathLength4;
                                        pKIXCertPathValidatorSpi = this;
                                    } catch (CertPathValidatorException e13) {
                                        e = e13;
                                        throw new CertPathValidatorException("Next working key could not be retrieved.", e, certPath6, index2);
                                    }
                                } catch (CertPathValidatorException e14) {
                                    e = e14;
                                }
                            }
                            maxPathLength2 = maxPathLength;
                            validPolicyTree3 = validPolicyTree4;
                            explicitPolicy2 = explicitPolicy3;
                            workingPublicKey2 = workingPublicKey4;
                            inhibitAnyPolicy3 = inhibitAnyPolicy2;
                            policyMapping3 = policyMapping2;
                            int maxPathLength42 = index2 - 1;
                            certPath4 = certPath6;
                            i10 = n10;
                            pathCheckers2 = pathCheckers;
                            policyNodes2 = policyNodes;
                            certs2 = certs3;
                            policySet = policySet2;
                            trust = trust2;
                            currentDate = currentDate2;
                            nameConstraintValidator3 = nameConstraintValidator;
                            acceptablePolicies2 = acceptablePolicies3;
                            workingPublicKey3 = workingPublicKey2;
                            cert2 = cert3;
                            index = maxPathLength42;
                            pKIXCertPathValidatorSpi = this;
                        } catch (AnnotatedException e15) {
                            throw new CertPathValidatorException(e15.getMessage(), e15.getUnderlyingException(), certPath4, index);
                        }
                    }
                    int index3 = index;
                    TrustAnchor trust3 = trust;
                    CertPath certPath7 = certPath4;
                    List pathCheckers4 = pathCheckers2;
                    List[] policyNodes4 = policyNodes2;
                    Set acceptablePolicies4 = acceptablePolicies2;
                    int explicitPolicy6 = RFC3280CertPathUtilities.wrapupCertB(certPath7, index3 + 1, RFC3280CertPathUtilities.wrapupCertA(explicitPolicy2, cert2));
                    Set criticalExtensions5 = cert2.getCriticalExtensionOIDs();
                    if (criticalExtensions5 != null) {
                        Set criticalExtensions6 = new HashSet(criticalExtensions5);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.KEY_USAGE);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                        criticalExtensions6.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                        criticalExtensions6.remove(Extension.extendedKeyUsage.getId());
                        criticalExtensions = criticalExtensions6;
                    } else {
                        criticalExtensions = new HashSet();
                    }
                    RFC3280CertPathUtilities.wrapupCertF(certPath7, index3 + 1, pathCheckers4, criticalExtensions);
                    PKIXPolicyNode intersection = RFC3280CertPathUtilities.wrapupCertG(certPath, paramsPKIX3, userInitialPolicySet, index3 + 1, policyNodes4, validPolicyTree3, acceptablePolicies4);
                    if (explicitPolicy6 > 0 || intersection != null) {
                        return new PKIXCertPathValidatorResult(trust3, intersection, cert2.getPublicKey());
                    }
                    throw new CertPathValidatorException("Path processing failed on policy.", null, certPath7, index3);
                } catch (CertPathValidatorException e16) {
                    throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e16, certPath4, -1);
                }
            }
            certs = certs2;
            certPath2 = certPath4;
            try {
                throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath2, -1);
            } catch (AnnotatedException e17) {
                e = e17;
                throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, certs.size() - 1);
            }
        } catch (AnnotatedException e18) {
            e = e18;
            certs = certs2;
            certPath2 = certPath4;
        }
    }

    static void checkCertificate(X509Certificate cert) throws AnnotatedException {
        try {
            TBSCertificate.getInstance(cert.getTBSCertificate());
        } catch (IllegalArgumentException e2) {
            throw new AnnotatedException(e2.getMessage());
        } catch (CertificateEncodingException e10) {
            throw new AnnotatedException("unable to process TBSCertificate", e10);
        }
    }
}
