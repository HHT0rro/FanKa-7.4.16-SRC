package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1String;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x500.RDN;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x500.style.BCStyle;
import com.android.internal.org.bouncycastle.asn1.x509.BasicConstraints;
import com.android.internal.org.bouncycastle.asn1.x509.CRLDistPoint;
import com.android.internal.org.bouncycastle.asn1.x509.DistributionPoint;
import com.android.internal.org.bouncycastle.asn1.x509.DistributionPointName;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralNames;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralSubtree;
import com.android.internal.org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import com.android.internal.org.bouncycastle.asn1.x509.NameConstraints;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertStoreSelector;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.google.android.material.datepicker.UtcDates;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import sun.security.x509.ReasonFlags;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RFC3280CertPathUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    protected static final int CRL_SIGN = 6;
    protected static final int KEY_CERT_SIGN = 5;
    private static final Class revChkClass = ClassUtil.loadClass(RFC3280CertPathUtilities.class, "java.security.cert.PKIXRevocationChecker");
    public static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    public static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    public static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    public static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    public static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    public static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    public static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    public static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    public static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    public static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    public static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    public static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    public static final String KEY_USAGE = Extension.keyUsage.getId();
    public static final String CRL_NUMBER = Extension.cRLNumber.getId();
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", ReasonFlags.SUPERSEDED, "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    RFC3280CertPathUtilities() {
    }

    protected static void processCRLB2(DistributionPoint dp, Object cert, X509CRL crl) throws AnnotatedException {
        try {
            IssuingDistributionPoint idp = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(crl, ISSUING_DISTRIBUTION_POINT));
            if (idp != null) {
                if (idp.getDistributionPoint() != null) {
                    DistributionPointName dpName = IssuingDistributionPoint.getInstance(idp).getDistributionPoint();
                    List names = new ArrayList();
                    if (dpName.getType() == 0) {
                        for (GeneralName generalName : GeneralNames.getInstance(dpName.getName()).getNames()) {
                            names.add(generalName);
                        }
                    }
                    if (dpName.getType() == 1) {
                        ASN1EncodableVector vec = new ASN1EncodableVector();
                        try {
                            Enumeration e2 = ASN1Sequence.getInstance(PrincipalUtils.getIssuerPrincipal(crl)).getObjects();
                            while (e2.hasMoreElements()) {
                                vec.add((ASN1Encodable) e2.nextElement());
                            }
                            vec.add(dpName.getName());
                            names.add(new GeneralName(X500Name.getInstance(new DERSequence(vec))));
                        } catch (Exception e10) {
                            throw new AnnotatedException("Could not read CRL issuer.", e10);
                        }
                    }
                    boolean matches = false;
                    if (dp.getDistributionPoint() != null) {
                        DistributionPointName dpName2 = dp.getDistributionPoint();
                        GeneralName[] genNames = null;
                        if (dpName2.getType() == 0) {
                            genNames = GeneralNames.getInstance(dpName2.getName()).getNames();
                        }
                        if (dpName2.getType() == 1) {
                            if (dp.getCRLIssuer() != null) {
                                genNames = dp.getCRLIssuer().getNames();
                            } else {
                                GeneralName[] genNames2 = new GeneralName[1];
                                try {
                                    genNames2[0] = new GeneralName(PrincipalUtils.getEncodedIssuerPrincipal(cert));
                                    genNames = genNames2;
                                } catch (Exception e11) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e11);
                                }
                            }
                            for (int j10 = 0; j10 < genNames.length; j10++) {
                                Enumeration e12 = ASN1Sequence.getInstance(genNames[j10].getName().toASN1Primitive()).getObjects();
                                ASN1EncodableVector vec2 = new ASN1EncodableVector();
                                while (e12.hasMoreElements()) {
                                    vec2.add((ASN1Encodable) e12.nextElement());
                                }
                                vec2.add(dpName2.getName());
                                genNames[j10] = new GeneralName(X500Name.getInstance(new DERSequence(vec2)));
                            }
                        }
                        if (genNames != null) {
                            int j11 = 0;
                            while (true) {
                                if (j11 >= genNames.length) {
                                    break;
                                }
                                if (!names.contains(genNames[j11])) {
                                    j11++;
                                } else {
                                    matches = true;
                                    break;
                                }
                            }
                        }
                        if (!matches) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        if (dp.getCRLIssuer() == null) {
                            throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                        }
                        GeneralName[] genNames3 = dp.getCRLIssuer().getNames();
                        int j12 = 0;
                        while (true) {
                            if (j12 >= genNames3.length) {
                                break;
                            }
                            if (!names.contains(genNames3[j12])) {
                                j12++;
                            } else {
                                matches = true;
                                break;
                            }
                        }
                        if (!matches) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    }
                }
                try {
                    BasicConstraints bc2 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension) cert, BASIC_CONSTRAINTS));
                    if (cert instanceof X509Certificate) {
                        if (idp.onlyContainsUserCerts() && bc2 != null && bc2.isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        }
                        if (idp.onlyContainsCACerts() && (bc2 == null || !bc2.isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (idp.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e13) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e13);
                }
            }
        } catch (Exception e14) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e14);
        }
    }

    protected static void processCRLB1(DistributionPoint dp, Object cert, X509CRL crl) throws AnnotatedException {
        ASN1Primitive idp = CertPathValidatorUtilities.getExtensionValue(crl, ISSUING_DISTRIBUTION_POINT);
        boolean isIndirect = false;
        if (idp != null && IssuingDistributionPoint.getInstance(idp).isIndirectCRL()) {
            isIndirect = true;
        }
        try {
            byte[] issuerBytes = PrincipalUtils.getIssuerPrincipal(crl).getEncoded();
            boolean matchIssuer = false;
            if (dp.getCRLIssuer() != null) {
                GeneralName[] genNames = dp.getCRLIssuer().getNames();
                for (int j10 = 0; j10 < genNames.length; j10++) {
                    if (genNames[j10].getTagNo() == 4) {
                        try {
                            if (Arrays.areEqual(genNames[j10].getName().toASN1Primitive().getEncoded(), issuerBytes)) {
                                matchIssuer = true;
                            }
                        } catch (IOException e2) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e2);
                        }
                    }
                }
                if (matchIssuer && !isIndirect) {
                    throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
                }
                if (!matchIssuer) {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
                }
            } else if (PrincipalUtils.getIssuerPrincipal(crl).equals(PrincipalUtils.getEncodedIssuerPrincipal(cert))) {
                matchIssuer = true;
            }
            if (!matchIssuer) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (IOException e10) {
            throw new AnnotatedException("Exception encoding CRL issuer: " + e10.getMessage(), e10);
        }
    }

    protected static ReasonsMask processCRLD(X509CRL crl, DistributionPoint dp) throws AnnotatedException {
        ReasonsMask reasonsMask;
        ReasonsMask reasonsMask2;
        try {
            IssuingDistributionPoint idp = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(crl, ISSUING_DISTRIBUTION_POINT));
            if (idp != null && idp.getOnlySomeReasons() != null && dp.getReasons() != null) {
                return new ReasonsMask(dp.getReasons()).intersect(new ReasonsMask(idp.getOnlySomeReasons()));
            }
            if ((idp == null || idp.getOnlySomeReasons() == null) && dp.getReasons() == null) {
                return ReasonsMask.allReasons;
            }
            if (dp.getReasons() == null) {
                reasonsMask = ReasonsMask.allReasons;
            } else {
                reasonsMask = new ReasonsMask(dp.getReasons());
            }
            if (idp == null) {
                reasonsMask2 = ReasonsMask.allReasons;
            } else {
                reasonsMask2 = new ReasonsMask(idp.getOnlySomeReasons());
            }
            return reasonsMask.intersect(reasonsMask2);
        } catch (Exception e2) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e2);
        }
    }

    protected static Set processCRLF(X509CRL crl, Object cert, X509Certificate defaultCRLSignCert, PublicKey defaultCRLSignKey, PKIXExtendedParameters paramsPKIX, List certPathCerts, JcaJceHelper helper) throws AnnotatedException {
        List certs;
        X509Certificate x509Certificate = defaultCRLSignCert;
        X509CertSelector certSelector = new X509CertSelector();
        try {
            byte[] issuerPrincipal = PrincipalUtils.getIssuerPrincipal(crl).getEncoded();
            certSelector.setSubject(issuerPrincipal);
            PKIXCertStoreSelector selector = new PKIXCertStoreSelector.Builder(certSelector).build();
            LinkedHashSet coll = new LinkedHashSet();
            try {
                CertPathValidatorUtilities.findCertificates(coll, selector, paramsPKIX.getCertificateStores());
                CertPathValidatorUtilities.findCertificates(coll, selector, paramsPKIX.getCertStores());
                coll.add(x509Certificate);
                Iterator cert_it = coll.iterator2();
                List validCerts = new ArrayList();
                List validKeys = new ArrayList();
                while (cert_it.hasNext()) {
                    X509Certificate signingCert = (X509Certificate) cert_it.next();
                    if (signingCert.equals(x509Certificate)) {
                        validCerts.add(signingCert);
                        validKeys.add(defaultCRLSignKey);
                    } else {
                        try {
                            CertPathBuilderSpi builder = new PKIXCertPathBuilderSpi(true);
                            X509CertSelector tmpCertSelector = new X509CertSelector();
                            tmpCertSelector.setCertificate(signingCert);
                            try {
                                PKIXExtendedParameters.Builder paramsBuilder = new PKIXExtendedParameters.Builder(paramsPKIX).setTargetConstraints(new PKIXCertStoreSelector.Builder(tmpCertSelector).build());
                                try {
                                    if (certPathCerts.contains(signingCert)) {
                                        paramsBuilder.setRevocationEnabled(false);
                                    } else {
                                        paramsBuilder.setRevocationEnabled(true);
                                    }
                                    PKIXExtendedBuilderParameters extParams = new PKIXExtendedBuilderParameters.Builder(paramsBuilder.build()).build();
                                    certs = builder.engineBuild(extParams).getCertPath().getCertificates();
                                    validCerts.add(signingCert);
                                } catch (CertPathBuilderException e2) {
                                    e = e2;
                                    throw new AnnotatedException("CertPath for CRL signer failed to validate.", e);
                                } catch (CertPathValidatorException e10) {
                                    e = e10;
                                    throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e);
                                } catch (Exception e11) {
                                    e = e11;
                                    throw new AnnotatedException(e.getMessage());
                                }
                                try {
                                    validKeys.add(CertPathValidatorUtilities.getNextWorkingKey(certs, 0, helper));
                                    x509Certificate = defaultCRLSignCert;
                                } catch (CertPathBuilderException e12) {
                                    e = e12;
                                    throw new AnnotatedException("CertPath for CRL signer failed to validate.", e);
                                } catch (CertPathValidatorException e13) {
                                    e = e13;
                                    throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e);
                                } catch (Exception e14) {
                                    e = e14;
                                    throw new AnnotatedException(e.getMessage());
                                }
                            } catch (CertPathBuilderException e15) {
                                e = e15;
                                throw new AnnotatedException("CertPath for CRL signer failed to validate.", e);
                            } catch (CertPathValidatorException e16) {
                                e = e16;
                                throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e);
                            } catch (Exception e17) {
                                e = e17;
                                throw new AnnotatedException(e.getMessage());
                            }
                        } catch (CertPathBuilderException e18) {
                            e = e18;
                        } catch (CertPathValidatorException e19) {
                            e = e19;
                        } catch (Exception e20) {
                            e = e20;
                        }
                    }
                }
                Set checkKeys = new HashSet();
                AnnotatedException lastException = null;
                for (int i10 = 0; i10 < validCerts.size(); i10++) {
                    X509Certificate signCert = (X509Certificate) validCerts.get(i10);
                    boolean[] keyUsage = signCert.getKeyUsage();
                    if (keyUsage == null || (keyUsage.length > 6 && keyUsage[6])) {
                        checkKeys.add(validKeys.get(i10));
                    } else {
                        lastException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (checkKeys.isEmpty() && lastException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                }
                if (!checkKeys.isEmpty() || lastException == null) {
                    return checkKeys;
                }
                throw lastException;
            } catch (AnnotatedException e21) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e21);
            }
        } catch (IOException e22) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e22);
        }
    }

    protected static PublicKey processCRLG(X509CRL crl, Set keys) throws AnnotatedException {
        Exception lastException = null;
        Iterator it = keys.iterator2();
        while (it.hasNext()) {
            PublicKey key = (PublicKey) it.next();
            try {
                crl.verify(key);
                return key;
            } catch (Exception e2) {
                lastException = e2;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", lastException);
    }

    protected static X509CRL processCRLH(Set deltacrls, PublicKey key) throws AnnotatedException {
        Exception lastException = null;
        Iterator it = deltacrls.iterator2();
        while (it.hasNext()) {
            X509CRL crl = (X509CRL) it.next();
            try {
                crl.verify(key);
                return crl;
            } catch (Exception e2) {
                lastException = e2;
            }
        }
        if (lastException != null) {
            throw new AnnotatedException("Cannot verify delta CRL.", lastException);
        }
        return null;
    }

    protected static void processCRLC(X509CRL deltaCRL, X509CRL completeCRL, PKIXExtendedParameters pkixParams) throws AnnotatedException {
        if (deltaCRL == null) {
            return;
        }
        if (deltaCRL.hasUnsupportedCriticalExtension()) {
            throw new AnnotatedException("delta CRL has unsupported critical extensions");
        }
        try {
            String str = ISSUING_DISTRIBUTION_POINT;
            IssuingDistributionPoint completeidp = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(completeCRL, str));
            if (pkixParams.isUseDeltasEnabled()) {
                if (!PrincipalUtils.getIssuerPrincipal(deltaCRL).equals(PrincipalUtils.getIssuerPrincipal(completeCRL))) {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
                try {
                    IssuingDistributionPoint deltaidp = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(deltaCRL, str));
                    boolean match = false;
                    if (completeidp == null) {
                        if (deltaidp == null) {
                            match = true;
                        }
                    } else if (completeidp.equals(deltaidp)) {
                        match = true;
                    }
                    if (!match) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                    }
                    try {
                        String str2 = AUTHORITY_KEY_IDENTIFIER;
                        ASN1Primitive completeKeyIdentifier = CertPathValidatorUtilities.getExtensionValue(completeCRL, str2);
                        try {
                            ASN1Primitive deltaKeyIdentifier = CertPathValidatorUtilities.getExtensionValue(deltaCRL, str2);
                            if (completeKeyIdentifier == null) {
                                throw new AnnotatedException("CRL authority key identifier is null.");
                            }
                            if (deltaKeyIdentifier == null) {
                                throw new AnnotatedException("Delta CRL authority key identifier is null.");
                            }
                            if (!completeKeyIdentifier.equals(deltaKeyIdentifier)) {
                                throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                            }
                        } catch (AnnotatedException e2) {
                            throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e2);
                        }
                    } catch (AnnotatedException e10) {
                        throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e10);
                    }
                } catch (Exception e11) {
                    throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e11);
                }
            }
        } catch (Exception e12) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e12);
        }
    }

    protected static void processCRLI(Date validDate, X509CRL deltacrl, Object cert, CertStatus certStatus, PKIXExtendedParameters pkixParams) throws AnnotatedException {
        if (pkixParams.isUseDeltasEnabled() && deltacrl != null) {
            CertPathValidatorUtilities.getCertStatus(validDate, deltacrl, cert, certStatus);
        }
    }

    protected static void processCRLJ(Date validDate, X509CRL completecrl, Object cert, CertStatus certStatus) throws AnnotatedException {
        if (certStatus.getCertStatus() == 11) {
            CertPathValidatorUtilities.getCertStatus(validDate, completecrl, cert, certStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
    
        r0 = (com.android.internal.org.bouncycastle.asn1.ASN1Sequence) com.android.internal.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r5, com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        r23 = r0.getObjects();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
    
        if (r23.hasMoreElements() == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f6, code lost:
    
        r0 = com.android.internal.org.bouncycastle.asn1.x509.PolicyInformation.getInstance(r23.nextElement());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010c, code lost:
    
        if (com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.ANY_POLICY.equals(r0.getPolicyIdentifier().getId()) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010f, code lost:
    
        r0 = com.android.internal.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getQualifierSet(r0.getPolicyQualifiers());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if (r5.getCriticalExtensionOIDs() == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:
    
        r8 = r5.getCriticalExtensionOIDs().contains(com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
        r24 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0143, code lost:
    
        r10 = (com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode) r21.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0152, code lost:
    
        if (com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.ANY_POLICY.equals(r10.getValidPolicy()) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0154, code lost:
    
        r28 = r12;
        r29 = r13;
        r30 = r14;
        r25 = new com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode(new java.util.ArrayList(), r15, (java.util.Set) r13.get(r11), r10, r0, r11, r24);
        r10.addChild(r25);
        r33[r15].add(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0187, code lost:
    
        r28 = r12;
        r29 = r13;
        r30 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
    
        r24 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0119, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0121, code lost:
    
        throw new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", r0, r31, r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0123, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012b, code lost:
    
        throw new java.security.cert.CertPathValidatorException("Policy information could not be decoded.", r0, r31, r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a1, code lost:
    
        throw new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException("Certificate policies extension could not be decoded.", r0, r31, r32);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode prepareCertB(java.security.cert.CertPath r31, int r32, java.util.List[] r33, com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode r34, int r35) throws java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareCertB(java.security.cert.CertPath, int, java.util.List[], com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode, int):com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertA(CertPath certPath, int index) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            ASN1Sequence pm = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, POLICY_MAPPINGS));
            if (pm != null) {
                for (int j10 = 0; j10 < pm.size(); j10++) {
                    try {
                        ASN1Sequence mapping = ASN1Sequence.getInstance(pm.getObjectAt(j10));
                        ASN1ObjectIdentifier issuerDomainPolicy = ASN1ObjectIdentifier.getInstance(mapping.getObjectAt(0));
                        ASN1ObjectIdentifier subjectDomainPolicy = ASN1ObjectIdentifier.getInstance(mapping.getObjectAt(1));
                        if (ANY_POLICY.equals(issuerDomainPolicy.getId())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certPath, index);
                        }
                        if (ANY_POLICY.equals(subjectDomainPolicy.getId())) {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy", null, certPath, index);
                        }
                    } catch (Exception e2) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e2, certPath, index);
                    }
                }
            }
        } catch (AnnotatedException ex) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", ex, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processCertF(CertPath certPath, int index, PKIXPolicyNode validPolicyTree, int explicitPolicy) throws CertPathValidatorException {
        if (explicitPolicy <= 0 && validPolicyTree == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PKIXPolicyNode processCertE(CertPath certPath, int index, PKIXPolicyNode validPolicyTree) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            ASN1Sequence certPolicies = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, CERTIFICATE_POLICIES));
            if (certPolicies == null) {
                return null;
            }
            return validPolicyTree;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e2, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processCertBC(CertPath certPath, int index, PKIXNameConstraintValidator nameConstraintValidator, boolean isForCRLCheck) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        int n10 = certs.size();
        int i10 = n10 - index;
        if (!CertPathValidatorUtilities.isSelfIssued(cert) || (i10 >= n10 && !isForCRLCheck)) {
            X500Name principal = PrincipalUtils.getSubjectPrincipal(cert);
            try {
                ASN1Sequence dns = ASN1Sequence.getInstance(principal);
                try {
                    nameConstraintValidator.checkPermittedDN(dns);
                    nameConstraintValidator.checkExcludedDN(dns);
                    try {
                        GeneralNames altName = GeneralNames.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, SUBJECT_ALTERNATIVE_NAME));
                        RDN[] emails = X500Name.getInstance(dns).getRDNs(BCStyle.EmailAddress);
                        for (int eI = 0; eI != emails.length; eI++) {
                            String email = ((ASN1String) emails[eI].getFirst().getValue()).getString();
                            GeneralName emailAsGeneralName = new GeneralName(1, email);
                            try {
                                nameConstraintValidator.checkPermitted(emailAsGeneralName);
                                nameConstraintValidator.checkExcluded(emailAsGeneralName);
                            } catch (PKIXNameConstraintValidatorException ex) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", ex, certPath, index);
                            }
                        }
                        if (altName != null) {
                            try {
                                GeneralName[] genNames = altName.getNames();
                                for (int j10 = 0; j10 < genNames.length; j10++) {
                                    try {
                                        nameConstraintValidator.checkPermitted(genNames[j10]);
                                        nameConstraintValidator.checkExcluded(genNames[j10]);
                                    } catch (PKIXNameConstraintValidatorException e2) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e2, certPath, index);
                                    }
                                }
                            } catch (Exception e10) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e10, certPath, index);
                            }
                        }
                    } catch (Exception e11) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e11, certPath, index);
                    }
                } catch (PKIXNameConstraintValidatorException e12) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", e12, certPath, index);
                }
            } catch (Exception e13) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e13, certPath, index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:101:0x012f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode processCertD(java.security.cert.CertPath r32, int r33, java.util.Set r34, com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode r35, java.util.List[] r36, int r37, boolean r38) throws java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.processCertD(java.security.cert.CertPath, int, java.util.Set, com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode, java.util.List[], int, boolean):com.android.internal.org.bouncycastle.jce.provider.PKIXPolicyNode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processCertA(CertPath certPath, PKIXExtendedParameters paramsPKIX, Date validityDate, PKIXCertRevocationChecker revocationChecker, int index, PublicKey workingPublicKey, boolean verificationAlreadyPerformed, X500Name workingIssuerName, X509Certificate sign) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        if (!verificationAlreadyPerformed) {
            try {
                try {
                    CertPathValidatorUtilities.verifyX509Certificate(cert, workingPublicKey, paramsPKIX.getSigProvider());
                } catch (GeneralSecurityException e2) {
                    e = e2;
                    throw new ExtCertPathValidatorException("Could not validate certificate signature.", e, certPath, index);
                }
            } catch (GeneralSecurityException e10) {
                e = e10;
            }
        }
        try {
            try {
                Date validCertDate = CertPathValidatorUtilities.getValidCertDateFromValidityModel(validityDate, paramsPKIX.getValidityModel(), certPath, index);
                try {
                    cert.checkValidity(validCertDate);
                    if (revocationChecker != null) {
                        revocationChecker.initialize(new PKIXCertRevocationCheckerParameters(paramsPKIX, validCertDate, certPath, index, sign, workingPublicKey));
                        revocationChecker.check(cert);
                    }
                    X500Name issuer = PrincipalUtils.getIssuerPrincipal(cert);
                    if (!issuer.equals(workingIssuerName)) {
                        throw new ExtCertPathValidatorException("IssuerName(" + ((Object) issuer) + ") does not match SubjectName(" + ((Object) workingIssuerName) + ") of signing certificate.", null, certPath, index);
                    }
                } catch (CertificateExpiredException e11) {
                    throw new ExtCertPathValidatorException("Could not validate certificate: " + e11.getMessage(), e11, certPath, index);
                } catch (CertificateNotYetValidException e12) {
                    throw new ExtCertPathValidatorException("Could not validate certificate: " + e12.getMessage(), e12, certPath, index);
                }
            } catch (AnnotatedException e13) {
                e = e13;
                throw new ExtCertPathValidatorException("Could not validate time of certificate.", e, certPath, index);
            }
        } catch (AnnotatedException e14) {
            e = e14;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        r5 = com.android.internal.org.bouncycastle.asn1.ASN1Integer.getInstance(r4, false).intValueExact();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r5 >= r9) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int prepareNextCertI1(java.security.cert.CertPath r7, int r8, int r9) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r7.getCertificates()
            java.lang.Object r1 = r0.get(r8)
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1
            r2 = 0
            java.lang.String r3 = com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.POLICY_CONSTRAINTS     // Catch: java.lang.Exception -> L49
            com.android.internal.org.bouncycastle.asn1.ASN1Primitive r3 = com.android.internal.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r1, r3)     // Catch: java.lang.Exception -> L49
            com.android.internal.org.bouncycastle.asn1.ASN1Sequence r3 = com.android.internal.org.bouncycastle.asn1.ASN1Sequence.getInstance(r3)     // Catch: java.lang.Exception -> L49
            r2 = r3
            if (r2 == 0) goto L48
            java.util.Enumeration r3 = r2.getObjects()
        L1d:
            boolean r4 = r3.hasMoreElements()
            if (r4 == 0) goto L48
            java.lang.Object r4 = r3.nextElement()     // Catch: java.lang.IllegalArgumentException -> L3f
            com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject r4 = com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject.getInstance(r4)     // Catch: java.lang.IllegalArgumentException -> L3f
            int r5 = r4.getTagNo()     // Catch: java.lang.IllegalArgumentException -> L3f
            if (r5 != 0) goto L3e
            r5 = 0
            com.android.internal.org.bouncycastle.asn1.ASN1Integer r5 = com.android.internal.org.bouncycastle.asn1.ASN1Integer.getInstance(r4, r5)     // Catch: java.lang.IllegalArgumentException -> L3f
            int r5 = r5.intValueExact()     // Catch: java.lang.IllegalArgumentException -> L3f
            if (r5 >= r9) goto L3d
            return r5
        L3d:
            goto L48
        L3e:
            goto L1d
        L3f:
            r4 = move-exception
            com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException r5 = new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r6 = "Policy constraints extension contents cannot be decoded."
            r5.<init>(r6, r4, r7, r8)
            throw r5
        L48:
            return r9
        L49:
            r3 = move-exception
            com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException r4 = new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r5 = "Policy constraints extension cannot be decoded."
            r4.<init>(r5, r3, r7, r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertI1(java.security.cert.CertPath, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r5 = com.android.internal.org.bouncycastle.asn1.ASN1Integer.getInstance(r4, false).intValueExact();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r5 >= r9) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int prepareNextCertI2(java.security.cert.CertPath r7, int r8, int r9) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r7.getCertificates()
            java.lang.Object r1 = r0.get(r8)
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1
            r2 = 0
            java.lang.String r3 = com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.POLICY_CONSTRAINTS     // Catch: java.lang.Exception -> L4a
            com.android.internal.org.bouncycastle.asn1.ASN1Primitive r3 = com.android.internal.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r1, r3)     // Catch: java.lang.Exception -> L4a
            com.android.internal.org.bouncycastle.asn1.ASN1Sequence r3 = com.android.internal.org.bouncycastle.asn1.ASN1Sequence.getInstance(r3)     // Catch: java.lang.Exception -> L4a
            r2 = r3
            if (r2 == 0) goto L49
            java.util.Enumeration r3 = r2.getObjects()
        L1d:
            boolean r4 = r3.hasMoreElements()
            if (r4 == 0) goto L49
            java.lang.Object r4 = r3.nextElement()     // Catch: java.lang.IllegalArgumentException -> L40
            com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject r4 = com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject.getInstance(r4)     // Catch: java.lang.IllegalArgumentException -> L40
            int r5 = r4.getTagNo()     // Catch: java.lang.IllegalArgumentException -> L40
            r6 = 1
            if (r5 != r6) goto L3f
            r5 = 0
            com.android.internal.org.bouncycastle.asn1.ASN1Integer r5 = com.android.internal.org.bouncycastle.asn1.ASN1Integer.getInstance(r4, r5)     // Catch: java.lang.IllegalArgumentException -> L40
            int r5 = r5.intValueExact()     // Catch: java.lang.IllegalArgumentException -> L40
            if (r5 >= r9) goto L3e
            return r5
        L3e:
            goto L49
        L3f:
            goto L1d
        L40:
            r4 = move-exception
            com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException r5 = new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r6 = "Policy constraints extension contents cannot be decoded."
            r5.<init>(r6, r4, r7, r8)
            throw r5
        L49:
            return r9
        L4a:
            r3 = move-exception
            com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException r4 = new com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r5 = "Policy constraints extension cannot be decoded."
            r4.<init>(r5, r3, r7, r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertI2(java.security.cert.CertPath, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertG(CertPath certPath, int index, PKIXNameConstraintValidator nameConstraintValidator) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        NameConstraints nc2 = null;
        try {
            ASN1Sequence ncSeq = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, NAME_CONSTRAINTS));
            if (ncSeq != null) {
                nc2 = NameConstraints.getInstance(ncSeq);
            }
            if (nc2 != null) {
                GeneralSubtree[] permitted = nc2.getPermittedSubtrees();
                if (permitted != null) {
                    try {
                        nameConstraintValidator.intersectPermittedSubtree(permitted);
                    } catch (Exception ex) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", ex, certPath, index);
                    }
                }
                GeneralSubtree[] excluded = nc2.getExcludedSubtrees();
                if (excluded != null) {
                    for (int i10 = 0; i10 != excluded.length; i10++) {
                        try {
                            nameConstraintValidator.addExcludedSubtree(excluded[i10]);
                        } catch (Exception ex2) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", ex2, certPath, index);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e2, certPath, index);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x002d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkCRL(com.android.internal.org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters r22, com.android.internal.org.bouncycastle.asn1.x509.DistributionPoint r23, com.android.internal.org.bouncycastle.jcajce.PKIXExtendedParameters r24, java.util.Date r25, java.util.Date r26, java.security.cert.X509Certificate r27, java.security.cert.X509Certificate r28, java.security.PublicKey r29, com.android.internal.org.bouncycastle.jce.provider.CertStatus r30, com.android.internal.org.bouncycastle.jce.provider.ReasonsMask r31, java.util.List r32, com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper r33) throws com.android.internal.org.bouncycastle.jce.provider.AnnotatedException, com.android.internal.org.bouncycastle.jce.provider.RecoverableCertPathValidatorException {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.checkCRL(com.android.internal.org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters, com.android.internal.org.bouncycastle.asn1.x509.DistributionPoint, com.android.internal.org.bouncycastle.jcajce.PKIXExtendedParameters, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.security.PublicKey, com.android.internal.org.bouncycastle.jce.provider.CertStatus, com.android.internal.org.bouncycastle.jce.provider.ReasonsMask, java.util.List, com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkCRLs(PKIXCertRevocationCheckerParameters params, PKIXExtendedParameters paramsPKIX, Date currentDate, Date validityDate, X509Certificate cert, X509Certificate sign, PublicKey workingPublicKey, List certPathCerts, JcaJceHelper helper) throws AnnotatedException, RecoverableCertPathValidatorException {
        int i10;
        CertStatus certStatus;
        CertStatus certStatus2;
        CRLDistPoint crldp;
        DistributionPoint[] dps;
        int i11;
        CertStatus certStatus3;
        PKIXExtendedParameters.Builder paramsBldr;
        AnnotatedException lastException = null;
        try {
            CRLDistPoint crldp2 = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, CRL_DISTRIBUTION_POINTS));
            PKIXExtendedParameters.Builder paramsBldr2 = new PKIXExtendedParameters.Builder(paramsPKIX);
            try {
                List extras = CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(crldp2, paramsPKIX.getNamedCRLStoreMap(), validityDate, helper);
                Iterator it = extras.iterator2();
                while (it.hasNext()) {
                    try {
                        paramsBldr2.addCRLStore(it.next());
                    } catch (AnnotatedException e2) {
                        e = e2;
                        throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", e);
                    }
                }
                CertStatus certStatus4 = new CertStatus();
                ReasonsMask reasonsMask = new ReasonsMask();
                PKIXExtendedParameters finalParams = paramsBldr2.build();
                boolean validCrlFound = false;
                int i12 = 11;
                if (crldp2 == null) {
                    i10 = 11;
                    certStatus = certStatus4;
                } else {
                    try {
                        DistributionPoint[] dps2 = crldp2.getDistributionPoints();
                        if (dps2 != null) {
                            AnnotatedException lastException2 = null;
                            boolean validCrlFound2 = false;
                            int i13 = 0;
                            while (i13 < dps2.length && certStatus4.getCertStatus() == i12 && !reasonsMask.isAllReasons()) {
                                try {
                                    dps = dps2;
                                    crldp = crldp2;
                                    i11 = i12;
                                    certStatus3 = certStatus4;
                                    paramsBldr = paramsBldr2;
                                    try {
                                        checkCRL(params, dps2[i13], finalParams, currentDate, validityDate, cert, sign, workingPublicKey, certStatus3, reasonsMask, certPathCerts, helper);
                                        validCrlFound2 = true;
                                    } catch (AnnotatedException e10) {
                                        e = e10;
                                        lastException2 = e;
                                        i13++;
                                        i12 = i11;
                                        dps2 = dps;
                                        crldp2 = crldp;
                                        certStatus4 = certStatus3;
                                        paramsBldr2 = paramsBldr;
                                    }
                                } catch (AnnotatedException e11) {
                                    e = e11;
                                    crldp = crldp2;
                                    dps = dps2;
                                    i11 = i12;
                                    certStatus3 = certStatus4;
                                    paramsBldr = paramsBldr2;
                                }
                                i13++;
                                i12 = i11;
                                dps2 = dps;
                                crldp2 = crldp;
                                certStatus4 = certStatus3;
                                paramsBldr2 = paramsBldr;
                            }
                            i10 = i12;
                            certStatus = certStatus4;
                            lastException = lastException2;
                            validCrlFound = validCrlFound2;
                        } else {
                            i10 = 11;
                            certStatus = certStatus4;
                        }
                    } catch (Exception e12) {
                        throw new AnnotatedException("Distribution points could not be read.", e12);
                    }
                }
                if (certStatus.getCertStatus() == i10 && !reasonsMask.isAllReasons()) {
                    try {
                        try {
                            X500Name issuer = PrincipalUtils.getIssuerPrincipal(cert);
                            DistributionPoint dp = new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, issuer))), null, null);
                            PKIXExtendedParameters paramsPKIXClone = (PKIXExtendedParameters) paramsPKIX.clone();
                            checkCRL(params, dp, paramsPKIXClone, currentDate, validityDate, cert, sign, workingPublicKey, certStatus, reasonsMask, certPathCerts, helper);
                            validCrlFound = true;
                        } catch (AnnotatedException e13) {
                            lastException = e13;
                        }
                    } catch (RuntimeException e14) {
                        throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", e14);
                    }
                }
                if (!validCrlFound) {
                    if (lastException instanceof AnnotatedException) {
                        throw lastException;
                    }
                    throw new AnnotatedException("No valid CRL found.", lastException);
                }
                if (certStatus.getCertStatus() != i10) {
                    CertStatus certStatus5 = certStatus;
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
                    df.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
                    String message = "Certificate revocation after " + df.format(certStatus5.getRevocationDate());
                    throw new AnnotatedException(message + ", reason: " + crlReasons[certStatus5.getCertStatus()]);
                }
                if (reasonsMask.isAllReasons() || certStatus.getCertStatus() != i10) {
                    certStatus2 = certStatus;
                } else {
                    certStatus2 = certStatus;
                    certStatus2.setCertStatus(12);
                }
                if (certStatus2.getCertStatus() == 12) {
                    throw new AnnotatedException("Certificate status could not be determined.");
                }
            } catch (AnnotatedException e15) {
                e = e15;
            }
        } catch (Exception e16) {
            throw new AnnotatedException("CRL distribution point extension could not be read.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertJ(CertPath certPath, int index, int inhibitAnyPolicy) throws CertPathValidatorException {
        int _inhibitAnyPolicy;
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            ASN1Integer iap = ASN1Integer.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, INHIBIT_ANY_POLICY));
            if (iap != null && (_inhibitAnyPolicy = iap.intValueExact()) < inhibitAnyPolicy) {
                return _inhibitAnyPolicy;
            }
            return inhibitAnyPolicy;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e2, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertK(CertPath certPath, int index) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            BasicConstraints bc2 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, BASIC_CONSTRAINTS));
            if (bc2 != null) {
                if (!bc2.isCA()) {
                    throw new CertPathValidatorException("Not a CA certificate", null, certPath, index);
                }
                return;
            }
            throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints", null, certPath, index);
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertL(CertPath certPath, int index, int maxPathLength) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        if (!CertPathValidatorUtilities.isSelfIssued(cert)) {
            if (maxPathLength <= 0) {
                throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, index);
            }
            return maxPathLength - 1;
        }
        return maxPathLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertM(CertPath certPath, int index, int maxPathLength) throws CertPathValidatorException {
        BigInteger _pathLengthConstraint;
        int _plc;
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            BasicConstraints bc2 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, BASIC_CONSTRAINTS));
            if (bc2 != null && (_pathLengthConstraint = bc2.getPathLenConstraint()) != null && (_plc = _pathLengthConstraint.intValue()) < maxPathLength) {
                return _plc;
            }
            return maxPathLength;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertN(CertPath certPath, int index) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        boolean[] keyUsage = cert.getKeyUsage();
        if (keyUsage != null) {
            if (keyUsage.length <= 5 || !keyUsage[5]) {
                throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertO(CertPath certPath, int index, Set criticalExtensions, List pathCheckers) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        Iterator tmpIter = pathCheckers.iterator2();
        while (tmpIter.hasNext()) {
            try {
                ((PKIXCertPathChecker) tmpIter.next()).check(cert, criticalExtensions);
            } catch (CertPathValidatorException e2) {
                throw new CertPathValidatorException(e2.getMessage(), e2.getCause(), certPath, index);
            }
        }
        if (!criticalExtensions.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + ((Object) criticalExtensions), null, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertH1(CertPath certPath, int index, int explicitPolicy) {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        if (!CertPathValidatorUtilities.isSelfIssued(cert) && explicitPolicy != 0) {
            return explicitPolicy - 1;
        }
        return explicitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertH2(CertPath certPath, int index, int policyMapping) {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        if (!CertPathValidatorUtilities.isSelfIssued(cert) && policyMapping != 0) {
            return policyMapping - 1;
        }
        return policyMapping;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int prepareNextCertH3(CertPath certPath, int index, int inhibitAnyPolicy) {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        if (!CertPathValidatorUtilities.isSelfIssued(cert) && inhibitAnyPolicy != 0) {
            return inhibitAnyPolicy - 1;
        }
        return inhibitAnyPolicy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int wrapupCertA(int explicitPolicy, X509Certificate cert) {
        if (!CertPathValidatorUtilities.isSelfIssued(cert) && explicitPolicy != 0) {
            return explicitPolicy - 1;
        }
        return explicitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int wrapupCertB(CertPath certPath, int index, int explicitPolicy) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        try {
            ASN1Sequence pc2 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(cert, POLICY_CONSTRAINTS));
            if (pc2 != null) {
                Enumeration policyConstraints = pc2.getObjects();
                while (policyConstraints.hasMoreElements()) {
                    ASN1TaggedObject constraint = (ASN1TaggedObject) policyConstraints.nextElement();
                    switch (constraint.getTagNo()) {
                        case 0:
                            try {
                                int tmpInt = ASN1Integer.getInstance(constraint, false).intValueExact();
                                if (tmpInt != 0) {
                                    break;
                                } else {
                                    return 0;
                                }
                            } catch (Exception e2) {
                                throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e2, certPath, index);
                            }
                    }
                }
            }
            return explicitPolicy;
        } catch (AnnotatedException e10) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e10, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void wrapupCertF(CertPath certPath, int index, List pathCheckers, Set criticalExtensions) throws CertPathValidatorException {
        List certs = certPath.getCertificates();
        X509Certificate cert = (X509Certificate) certs.get(index);
        Iterator tmpIter = pathCheckers.iterator2();
        while (tmpIter.hasNext()) {
            try {
                ((PKIXCertPathChecker) tmpIter.next()).check(cert, criticalExtensions);
            } catch (CertPathValidatorException e2) {
                throw new ExtCertPathValidatorException(e2.getMessage(), e2, certPath, index);
            } catch (Exception e10) {
                throw new CertPathValidatorException("Additional certificate path checker failed.", e10, certPath, index);
            }
        }
        if (!criticalExtensions.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + ((Object) criticalExtensions), null, certPath, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PKIXPolicyNode wrapupCertG(CertPath certPath, PKIXExtendedParameters paramsPKIX, Set userInitialPolicySet, int index, List[] policyNodes, PKIXPolicyNode validPolicyTree, Set acceptablePolicies) throws CertPathValidatorException {
        PKIXPolicyNode validPolicyTree2;
        int n10 = certPath.getCertificates().size();
        if (validPolicyTree == null) {
            if (paramsPKIX.isExplicitPolicyRequired()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, index);
            }
            return null;
        }
        if (CertPathValidatorUtilities.isAnyPolicy(userInitialPolicySet)) {
            if (paramsPKIX.isExplicitPolicyRequired()) {
                if (acceptablePolicies.isEmpty()) {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, index);
                }
                Set _validPolicyNodeSet = new HashSet();
                for (List _nodeDepth : policyNodes) {
                    for (int k10 = 0; k10 < _nodeDepth.size(); k10++) {
                        PKIXPolicyNode _node = (PKIXPolicyNode) _nodeDepth.get(k10);
                        if (ANY_POLICY.equals(_node.getValidPolicy())) {
                            Iterator _iter = _node.getChildren();
                            while (_iter.hasNext()) {
                                _validPolicyNodeSet.add(_iter.next());
                            }
                        }
                    }
                }
                Iterator _vpnsIter = _validPolicyNodeSet.iterator2();
                while (_vpnsIter.hasNext()) {
                    String _validPolicy = ((PKIXPolicyNode) _vpnsIter.next()).getValidPolicy();
                    acceptablePolicies.contains(_validPolicy);
                }
                if (validPolicyTree != null) {
                    validPolicyTree2 = validPolicyTree;
                    for (int j10 = n10 - 1; j10 >= 0; j10--) {
                        List nodes = policyNodes[j10];
                        for (int k11 = 0; k11 < nodes.size(); k11++) {
                            PKIXPolicyNode node = (PKIXPolicyNode) nodes.get(k11);
                            if (!node.hasChildren()) {
                                validPolicyTree2 = CertPathValidatorUtilities.removePolicyNode(validPolicyTree2, policyNodes, node);
                            }
                        }
                    }
                    PKIXPolicyNode intersection = validPolicyTree2;
                    return intersection;
                }
            }
            validPolicyTree2 = validPolicyTree;
            PKIXPolicyNode intersection2 = validPolicyTree2;
            return intersection2;
        }
        Set<PKIXPolicyNode> _validPolicyNodeSet2 = new HashSet();
        for (List _nodeDepth2 : policyNodes) {
            for (int k12 = 0; k12 < _nodeDepth2.size(); k12++) {
                PKIXPolicyNode _node2 = (PKIXPolicyNode) _nodeDepth2.get(k12);
                if (ANY_POLICY.equals(_node2.getValidPolicy())) {
                    Iterator _iter2 = _node2.getChildren();
                    while (_iter2.hasNext()) {
                        PKIXPolicyNode _c_node = (PKIXPolicyNode) _iter2.next();
                        if (!ANY_POLICY.equals(_c_node.getValidPolicy())) {
                            _validPolicyNodeSet2.add(_c_node);
                        }
                    }
                }
            }
        }
        PKIXPolicyNode validPolicyTree3 = validPolicyTree;
        for (PKIXPolicyNode _node3 : _validPolicyNodeSet2) {
            String _validPolicy2 = _node3.getValidPolicy();
            if (!userInitialPolicySet.contains(_validPolicy2)) {
                validPolicyTree3 = CertPathValidatorUtilities.removePolicyNode(validPolicyTree3, policyNodes, _node3);
            }
        }
        if (validPolicyTree3 != null) {
            for (int j11 = n10 - 1; j11 >= 0; j11--) {
                List nodes2 = policyNodes[j11];
                for (int k13 = 0; k13 < nodes2.size(); k13++) {
                    PKIXPolicyNode node2 = (PKIXPolicyNode) nodes2.get(k13);
                    if (!node2.hasChildren()) {
                        validPolicyTree3 = CertPathValidatorUtilities.removePolicyNode(validPolicyTree3, policyNodes, node2);
                    }
                }
            }
        }
        PKIXPolicyNode intersection3 = validPolicyTree3;
        return intersection3;
    }
}
