package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Enumerated;
import com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1OutputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x500.style.RFC4519Style;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.CRLDistPoint;
import com.android.internal.org.bouncycastle.asn1.x509.DistributionPoint;
import com.android.internal.org.bouncycastle.asn1.x509.DistributionPointName;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralNames;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.jcajce.PKIXCRLStore;
import com.android.internal.org.bouncycastle.jcajce.PKIXCRLStoreSelector;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertStore;
import com.android.internal.org.bouncycastle.jcajce.PKIXCertStoreSelector;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.android.internal.org.bouncycastle.jcajce.PKIXExtendedParameters;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import com.android.internal.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.android.internal.org.bouncycastle.util.Properties;
import com.android.internal.org.bouncycastle.x509.X509AttributeCertificate;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.ReasonFlags;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class CertPathValidatorUtilities {
    protected static final String ANY_POLICY = "2.5.29.32.0";
    protected static final int CRL_SIGN = 6;
    protected static final int KEY_CERT_SIGN = 5;
    protected static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    protected static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    protected static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    protected static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    protected static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    protected static final String KEY_USAGE = Extension.keyUsage.getId();
    protected static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    protected static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    protected static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    protected static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    protected static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    protected static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    protected static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    protected static final String CRL_NUMBER = Extension.cRLNumber.getId();
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", ReasonFlags.SUPERSEDED, "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    CertPathValidatorUtilities() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection findTargets(PKIXExtendedBuilderParameters paramsPKIX) throws CertPathBuilderException {
        PKIXExtendedParameters baseParams = paramsPKIX.getBaseParameters();
        PKIXCertStoreSelector certSelect = baseParams.getTargetConstraints();
        LinkedHashSet targets = new LinkedHashSet();
        try {
            findCertificates(targets, certSelect, baseParams.getCertificateStores());
            findCertificates(targets, certSelect, baseParams.getCertStores());
            if (!targets.isEmpty()) {
                return targets;
            }
            Certificate target = certSelect.getCertificate();
            if (target == null) {
                throw new CertPathBuilderException("No certificate found matching targetConstraints.");
            }
            return Collections.singleton(target);
        } catch (AnnotatedException e2) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e2);
        }
    }

    protected static TrustAnchor findTrustAnchor(X509Certificate cert, Set trustAnchors) throws AnnotatedException {
        return findTrustAnchor(cert, trustAnchors, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static TrustAnchor findTrustAnchor(X509Certificate cert, Set trustAnchors, String sigProvider) throws AnnotatedException {
        TrustAnchor trust = null;
        PublicKey trustPublicKey = null;
        Exception invalidKeyEx = null;
        X509CertSelector certSelectX509 = new X509CertSelector();
        X500Principal certIssuerPrincipal = cert.getIssuerX500Principal();
        certSelectX509.setSubject(certIssuerPrincipal);
        X500Name certIssuerName = null;
        Iterator iter = trustAnchors.iterator2();
        while (iter.hasNext() && trust == null) {
            trust = (TrustAnchor) iter.next();
            if (trust.getTrustedCert() != null) {
                if (certSelectX509.match(trust.getTrustedCert())) {
                    trustPublicKey = trust.getTrustedCert().getPublicKey();
                } else {
                    trust = null;
                }
            } else if (trust.getCA() != null && trust.getCAName() != null && trust.getCAPublicKey() != null) {
                if (certIssuerName == null) {
                    certIssuerName = X500Name.getInstance(certIssuerPrincipal.getEncoded());
                }
                try {
                    X500Name caName = X500Name.getInstance(trust.getCA().getEncoded());
                    if (certIssuerName.equals(caName)) {
                        trustPublicKey = trust.getCAPublicKey();
                    } else {
                        trust = null;
                    }
                } catch (IllegalArgumentException e2) {
                    trust = null;
                }
            } else {
                trust = null;
            }
            if (trustPublicKey != null) {
                try {
                    verifyX509Certificate(cert, trustPublicKey, sigProvider);
                } catch (Exception ex) {
                    invalidKeyEx = ex;
                    trust = null;
                    trustPublicKey = null;
                }
            }
        }
        if (trust == null && invalidKeyEx != null) {
            throw new AnnotatedException("TrustAnchor found but certificate validation failed.", invalidKeyEx);
        }
        return trust;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIssuerTrustAnchor(X509Certificate cert, Set trustAnchors, String sigProvider) throws AnnotatedException {
        try {
            return findTrustAnchor(cert, trustAnchors, sigProvider) != null;
        } catch (Exception e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PKIXCertStore> getAdditionalStoresFromAltNames(byte[] issuerAlternativeName, Map<GeneralName, PKIXCertStore> altNameCertStoreMap) throws CertificateParsingException {
        if (issuerAlternativeName == null) {
            return Collections.EMPTY_LIST;
        }
        GeneralNames issuerAltName = GeneralNames.getInstance(ASN1OctetString.getInstance(issuerAlternativeName).getOctets());
        GeneralName[] names = issuerAltName.getNames();
        List<PKIXCertStore> stores = new ArrayList<>();
        for (int i10 = 0; i10 != names.length; i10++) {
            GeneralName altName = names[i10];
            PKIXCertStore altStore = altNameCertStoreMap.get(altName);
            if (altStore != null) {
                stores.add(altStore);
            }
        }
        return stores;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date getValidityDate(PKIXExtendedParameters paramsPKIX, Date currentDate) {
        Date validityDate = paramsPKIX.getValidityDate();
        return validityDate == null ? currentDate : validityDate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isSelfIssued(X509Certificate cert) {
        return cert.getSubjectDN().equals(cert.getIssuerDN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ASN1Primitive getExtensionValue(X509Extension ext, String oid) throws AnnotatedException {
        byte[] bytes = ext.getExtensionValue(oid);
        if (bytes == null) {
            return null;
        }
        return getObject(oid, bytes);
    }

    private static ASN1Primitive getObject(String oid, byte[] ext) throws AnnotatedException {
        try {
            ASN1OctetString octs = ASN1OctetString.getInstance(ext);
            return ASN1Primitive.fromByteArray(octs.getOctets());
        } catch (Exception e2) {
            throw new AnnotatedException("exception processing extension " + oid, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey key) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(key.getEncoded()).getAlgorithm();
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Set getQualifierSet(ASN1Sequence qualifiers) throws CertPathValidatorException {
        Set pq = new HashSet();
        if (qualifiers == null) {
            return pq;
        }
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = ASN1OutputStream.create(bOut);
        Enumeration e2 = qualifiers.getObjects();
        while (e2.hasMoreElements()) {
            try {
                aOut.writeObject((ASN1Encodable) e2.nextElement());
                pq.add(new PolicyQualifierInfo(bOut.toByteArray()));
                bOut.reset();
            } catch (IOException ex) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", ex);
            }
        }
        return pq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PKIXPolicyNode removePolicyNode(PKIXPolicyNode validPolicyTree, List[] policyNodes, PKIXPolicyNode _node) {
        PKIXPolicyNode _parent = (PKIXPolicyNode) _node.getParent();
        if (validPolicyTree == null) {
            return null;
        }
        if (_parent == null) {
            for (int j10 = 0; j10 < policyNodes.length; j10++) {
                policyNodes[j10] = new ArrayList();
            }
            return null;
        }
        _parent.removeChild(_node);
        removePolicyNodeRecurse(policyNodes, _node);
        return validPolicyTree;
    }

    private static void removePolicyNodeRecurse(List[] policyNodes, PKIXPolicyNode _node) {
        policyNodes[_node.getDepth()].remove(_node);
        if (_node.hasChildren()) {
            Iterator _iter = _node.getChildren();
            while (_iter.hasNext()) {
                PKIXPolicyNode _child = (PKIXPolicyNode) _iter.next();
                removePolicyNodeRecurse(policyNodes, _child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean processCertD1i(int index, List[] policyNodes, ASN1ObjectIdentifier pOid, Set pq) {
        List policyNodeVec = policyNodes[index - 1];
        for (int j10 = 0; j10 < policyNodeVec.size(); j10++) {
            PKIXPolicyNode node = (PKIXPolicyNode) policyNodeVec.get(j10);
            Set expectedPolicies = node.getExpectedPolicies();
            if (expectedPolicies.contains(pOid.getId())) {
                Set childExpectedPolicies = new HashSet();
                childExpectedPolicies.add(pOid.getId());
                PKIXPolicyNode child = new PKIXPolicyNode(new ArrayList(), index, childExpectedPolicies, node, pq, pOid.getId(), false);
                node.addChild(child);
                policyNodes[index].add(child);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processCertD1ii(int index, List[] policyNodes, ASN1ObjectIdentifier _poid, Set _pq) {
        List policyNodeVec = policyNodes[index - 1];
        for (int j10 = 0; j10 < policyNodeVec.size(); j10++) {
            PKIXPolicyNode _node = (PKIXPolicyNode) policyNodeVec.get(j10);
            if ("2.5.29.32.0".equals(_node.getValidPolicy())) {
                Set _childExpectedPolicies = new HashSet();
                _childExpectedPolicies.add(_poid.getId());
                PKIXPolicyNode _child = new PKIXPolicyNode(new ArrayList(), index, _childExpectedPolicies, _node, _pq, _poid.getId(), false);
                _node.addChild(_child);
                policyNodes[index].add(_child);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static void prepareNextCertB1(int r20, java.util.List[] r21, java.lang.String r22, java.util.Map r23, java.security.cert.X509Certificate r24) throws com.android.internal.org.bouncycastle.jce.provider.AnnotatedException, java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jce.provider.CertPathValidatorUtilities.prepareNextCertB1(int, java.util.List[], java.lang.String, java.util.Map, java.security.cert.X509Certificate):void");
    }

    protected static PKIXPolicyNode prepareNextCertB2(int i10, List[] policyNodes, String id_p, PKIXPolicyNode validPolicyTree) {
        int l10;
        Iterator nodes_i = policyNodes[i10].iterator2();
        while (nodes_i.hasNext()) {
            PKIXPolicyNode node = (PKIXPolicyNode) nodes_i.next();
            if (node.getValidPolicy().equals(id_p)) {
                PKIXPolicyNode p_node = (PKIXPolicyNode) node.getParent();
                p_node.removeChild(node);
                nodes_i.remove();
                for (int k10 = i10 - 1; k10 >= 0; k10--) {
                    List nodes = policyNodes[k10];
                    while (l10 < nodes.size()) {
                        PKIXPolicyNode node2 = (PKIXPolicyNode) nodes.get(l10);
                        l10 = (node2.hasChildren() || (validPolicyTree = removePolicyNode(validPolicyTree, policyNodes, node2)) != null) ? l10 + 1 : 0;
                    }
                }
            }
        }
        return validPolicyTree;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isAnyPolicy(Set policySet) {
        return policySet == null || policySet.contains("2.5.29.32.0") || policySet.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void findCertificates(LinkedHashSet certs, PKIXCertStoreSelector certSelect, List certStores) throws AnnotatedException {
        for (Object obj : certStores) {
            CertStore certStore = (CertStore) obj;
            try {
                certs.addAll(PKIXCertStoreSelector.getCertificates(certSelect, certStore));
            } catch (CertStoreException e2) {
                throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PKIXCRLStore> getAdditionalStoresFromCRLDistributionPoint(CRLDistPoint crldp, Map<GeneralName, PKIXCRLStore> namedCRLStoreMap, Date validDate, JcaJceHelper helper) throws AnnotatedException {
        if (crldp == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            DistributionPoint[] dps = crldp.getDistributionPoints();
            List<PKIXCRLStore> stores = new ArrayList<>();
            for (DistributionPoint distributionPoint : dps) {
                DistributionPointName dpn = distributionPoint.getDistributionPoint();
                if (dpn != null && dpn.getType() == 0) {
                    for (GeneralName generalName : GeneralNames.getInstance(dpn.getName()).getNames()) {
                        PKIXCRLStore store = namedCRLStoreMap.get(generalName);
                        if (store != null) {
                            stores.add(store);
                        }
                    }
                }
            }
            if (stores.isEmpty() && Properties.isOverrideSet("com.android.internal.org.bouncycastle.x509.enableCRLDP")) {
                try {
                    helper.createCertificateFactory(e.f29912b);
                    for (int i10 = 0; i10 < dps.length; i10++) {
                        DistributionPointName dpn2 = dps[i10].getDistributionPoint();
                        if (dpn2 != null && dpn2.getType() == 0) {
                            GeneralName[] genNames = GeneralNames.getInstance(dpn2.getName()).getNames();
                            for (int j10 = 0; j10 < genNames.length; j10++) {
                                GeneralName name = genNames[i10];
                                if (name.getTagNo() == 6) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    throw new AnnotatedException("cannot create certificate factory: " + e2.getMessage(), e2);
                }
            }
            return stores;
        } catch (Exception e10) {
            throw new AnnotatedException("Distribution points could not be read.", e10);
        }
    }

    protected static void getCRLIssuersFromDistributionPoint(DistributionPoint dp, Collection issuerPrincipals, X509CRLSelector selector) throws AnnotatedException {
        List issuers = new ArrayList();
        if (dp.getCRLIssuer() != null) {
            GeneralName[] genNames = dp.getCRLIssuer().getNames();
            for (int j10 = 0; j10 < genNames.length; j10++) {
                if (genNames[j10].getTagNo() == 4) {
                    try {
                        issuers.add(X500Name.getInstance(genNames[j10].getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e2) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e2);
                    }
                }
            }
        } else {
            if (dp.getDistributionPoint() == null) {
                throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
            }
            Iterator it = issuerPrincipals.iterator2();
            while (it.hasNext()) {
                issuers.add(it.next());
            }
        }
        Iterator it2 = issuers.iterator2();
        while (it2.hasNext()) {
            try {
                selector.addIssuerName(((X500Name) it2.next()).getEncoded());
            } catch (IOException ex) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", ex);
            }
        }
    }

    private static BigInteger getSerialNumber(Object cert) {
        return ((X509Certificate) cert).getSerialNumber();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void getCertStatus(Date validDate, X509CRL crl, Object cert, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry crl_entry;
        int reasonCodeValue;
        X500Name certIssuer;
        try {
            boolean isIndirect = X509CRLObject.isIndirectCRL(crl);
            if (isIndirect) {
                crl_entry = crl.getRevokedCertificate(getSerialNumber(cert));
                if (crl_entry == null) {
                    return;
                }
                X500Principal certificateIssuer = crl_entry.getCertificateIssuer();
                if (certificateIssuer == null) {
                    certIssuer = PrincipalUtils.getIssuerPrincipal(crl);
                } else {
                    certIssuer = PrincipalUtils.getX500Name(certificateIssuer);
                }
                if (!PrincipalUtils.getEncodedIssuerPrincipal(cert).equals(certIssuer)) {
                    return;
                }
            } else if (!PrincipalUtils.getEncodedIssuerPrincipal(cert).equals(PrincipalUtils.getIssuerPrincipal(crl)) || (crl_entry = crl.getRevokedCertificate(getSerialNumber(cert))) == null) {
                return;
            }
            ASN1Enumerated reasonCode = null;
            if (crl_entry.hasExtensions()) {
                if (crl_entry.hasUnsupportedCriticalExtension()) {
                    throw new AnnotatedException("CRL entry has unsupported critical extensions.");
                }
                try {
                    reasonCode = ASN1Enumerated.getInstance(getExtensionValue(crl_entry, Extension.reasonCode.getId()));
                } catch (Exception e2) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e2);
                }
            }
            if (reasonCode == null) {
                reasonCodeValue = 0;
            } else {
                reasonCodeValue = reasonCode.intValueExact();
            }
            if (validDate.getTime() >= crl_entry.getRevocationDate().getTime() || reasonCodeValue == 0 || reasonCodeValue == 1 || reasonCodeValue == 2 || reasonCodeValue == 10) {
                certStatus.setCertStatus(reasonCodeValue);
                certStatus.setRevocationDate(crl_entry.getRevocationDate());
            }
        } catch (CRLException exception) {
            throw new AnnotatedException("Failed check for indirect CRL.", exception);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static Set getDeltaCRLs(Date validityDate, X509CRL completeCRL, List<CertStore> certStores, List<PKIXCRLStore> pkixCrlStores, JcaJceHelper helper) throws AnnotatedException {
        CertificateFactory certFact;
        X509CRLSelector baseDeltaSelect;
        X509CRLSelector baseDeltaSelect2 = new X509CRLSelector();
        try {
            baseDeltaSelect2.addIssuerName(PrincipalUtils.getIssuerPrincipal(completeCRL).getEncoded());
            BigInteger completeCRLNumber = null;
            try {
                ASN1Primitive derObject = getExtensionValue(completeCRL, CRL_NUMBER);
                if (derObject != null) {
                    try {
                        completeCRLNumber = ASN1Integer.getInstance(derObject).getPositiveValue();
                    } catch (Exception e2) {
                        e = e2;
                        throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e);
                    }
                }
                try {
                    byte[] idp = completeCRL.getExtensionValue(ISSUING_DISTRIBUTION_POINT);
                    baseDeltaSelect2.setMinCRLNumber(completeCRLNumber == null ? null : completeCRLNumber.add(BigInteger.valueOf(1L)));
                    PKIXCRLStoreSelector.Builder selBuilder = new PKIXCRLStoreSelector.Builder(baseDeltaSelect2);
                    selBuilder.setIssuingDistributionPoint(idp);
                    selBuilder.setIssuingDistributionPointEnabled(true);
                    selBuilder.setMaxBaseCRLNumber(completeCRLNumber);
                    PKIXCRLStoreSelector deltaSelect = selBuilder.build();
                    Set<X509CRL> temp = PKIXCRLUtil.findCRLs(deltaSelect, validityDate, certStores, pkixCrlStores);
                    if (temp.isEmpty() && Properties.isOverrideSet("com.android.internal.org.bouncycastle.x509.enableCRLDP")) {
                        try {
                            CertificateFactory certFact2 = helper.createCertificateFactory(e.f29912b);
                            CRLDistPoint id2 = CRLDistPoint.getInstance(idp);
                            DistributionPoint[] dps = id2.getDistributionPoints();
                            int i10 = 0;
                            while (i10 < dps.length) {
                                DistributionPointName dpn = dps[i10].getDistributionPoint();
                                if (dpn == null || dpn.getType() != 0) {
                                    certFact = certFact2;
                                    baseDeltaSelect = baseDeltaSelect2;
                                } else {
                                    certFact = certFact2;
                                    GeneralName[] genNames = GeneralNames.getInstance(dpn.getName()).getNames();
                                    int j10 = 0;
                                    while (true) {
                                        baseDeltaSelect = baseDeltaSelect2;
                                        if (j10 < genNames.length) {
                                            GeneralName name = genNames[i10];
                                            GeneralName[] genNames2 = genNames;
                                            if (name.getTagNo() == 6) {
                                                break;
                                            }
                                            j10++;
                                            baseDeltaSelect2 = baseDeltaSelect;
                                            genNames = genNames2;
                                        }
                                    }
                                }
                                i10++;
                                baseDeltaSelect2 = baseDeltaSelect;
                                certFact2 = certFact;
                            }
                        } catch (Exception e10) {
                            throw new AnnotatedException("cannot create certificate factory: " + e10.getMessage(), e10);
                        }
                    }
                    Set result = new HashSet();
                    for (X509CRL crl : temp) {
                        if (isDeltaCRL(crl)) {
                            result.add(crl);
                        }
                    }
                    return result;
                } catch (Exception e11) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e11);
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (IOException e13) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e13);
        }
    }

    private static boolean isDeltaCRL(X509CRL crl) {
        Set critical = crl.getCriticalExtensionOIDs();
        if (critical == null) {
            return false;
        }
        return critical.contains(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Set getCompleteCRLs(PKIXCertRevocationCheckerParameters params, DistributionPoint dp, Object cert, PKIXExtendedParameters paramsPKIX, Date validityDate) throws AnnotatedException, RecoverableCertPathValidatorException {
        X509CRLSelector baseCrlSelect = new X509CRLSelector();
        try {
            Set issuers = new HashSet();
            issuers.add(PrincipalUtils.getEncodedIssuerPrincipal(cert));
            getCRLIssuersFromDistributionPoint(dp, issuers, baseCrlSelect);
            if (cert instanceof X509Certificate) {
                baseCrlSelect.setCertificateChecking((X509Certificate) cert);
            }
            PKIXCRLStoreSelector crlSelect = new PKIXCRLStoreSelector.Builder(baseCrlSelect).setCompleteCRLEnabled(true).build();
            Set crls = PKIXCRLUtil.findCRLs(crlSelect, validityDate, paramsPKIX.getCertStores(), paramsPKIX.getCRLStores());
            checkCRLsNotEmpty(params, crls, cert);
            return crls;
        } catch (AnnotatedException e2) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date getValidCertDateFromValidityModel(Date validityDate, int validityModel, CertPath certPath, int index) throws AnnotatedException {
        if (1 != validityModel || index <= 0) {
            return validityDate;
        }
        X509Certificate issuedCert = (X509Certificate) certPath.getCertificates().get(index - 1);
        if (index - 1 == 0) {
            ASN1GeneralizedTime dateOfCertgen = null;
            try {
                byte[] extBytes = ((X509Certificate) certPath.getCertificates().get(index - 1)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
                if (extBytes != null) {
                    dateOfCertgen = ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extBytes));
                }
                if (dateOfCertgen != null) {
                    try {
                        return dateOfCertgen.getDate();
                    } catch (ParseException e2) {
                        throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e2);
                    }
                }
            } catch (IOException e10) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            } catch (IllegalArgumentException e11) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            }
        }
        return issuedCert.getNotBefore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PublicKey getNextWorkingKey(List certs, int index, JcaJceHelper helper) throws CertPathValidatorException {
        Certificate cert = (Certificate) certs.get(index);
        PublicKey pubKey = cert.getPublicKey();
        if (!(pubKey instanceof DSAPublicKey)) {
            return pubKey;
        }
        DSAPublicKey dsaPubKey = (DSAPublicKey) pubKey;
        if (dsaPubKey.getParams() != null) {
            return dsaPubKey;
        }
        for (int i10 = index + 1; i10 < certs.size(); i10++) {
            X509Certificate parentCert = (X509Certificate) certs.get(i10);
            PublicKey pubKey2 = parentCert.getPublicKey();
            if (!(pubKey2 instanceof DSAPublicKey)) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            DSAPublicKey prevDSAPubKey = (DSAPublicKey) pubKey2;
            if (prevDSAPubKey.getParams() != null) {
                DSAParams dsaParams = prevDSAPubKey.getParams();
                DSAPublicKeySpec dsaPubKeySpec = new DSAPublicKeySpec(dsaPubKey.getY(), dsaParams.getP(), dsaParams.getQ(), dsaParams.getG());
                try {
                    KeyFactory keyFactory = helper.createKeyFactory("DSA");
                    return keyFactory.generatePublic(dsaPubKeySpec);
                } catch (Exception exception) {
                    throw new RuntimeException(exception.getMessage());
                }
            }
        }
        throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection findIssuerCerts(X509Certificate cert, List<CertStore> certStores, List<PKIXCertStore> pkixCertStores) throws AnnotatedException {
        X509CertSelector selector = new X509CertSelector();
        try {
            selector.setSubject(PrincipalUtils.getIssuerPrincipal(cert).getEncoded());
            try {
                byte[] akiExtensionValue = cert.getExtensionValue(AUTHORITY_KEY_IDENTIFIER);
                if (akiExtensionValue != null) {
                    ASN1OctetString aki = ASN1OctetString.getInstance(akiExtensionValue);
                    byte[] authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(aki.getOctets()).getKeyIdentifier();
                    if (authorityKeyIdentifier != null) {
                        selector.setSubjectKeyIdentifier(new DEROctetString(authorityKeyIdentifier).getEncoded());
                    }
                }
            } catch (Exception e2) {
            }
            PKIXCertStoreSelector certSelect = new PKIXCertStoreSelector.Builder(selector).build();
            LinkedHashSet certs = new LinkedHashSet();
            try {
                findCertificates(certs, certSelect, certStores);
                findCertificates(certs, certSelect, pkixCertStores);
                return certs;
            } catch (AnnotatedException e10) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e10);
            }
        } catch (Exception e11) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void verifyX509Certificate(X509Certificate cert, PublicKey publicKey, String sigProvider) throws GeneralSecurityException {
        if (sigProvider == null) {
            cert.verify(publicKey);
        } else {
            cert.verify(publicKey, sigProvider);
        }
    }

    static void checkCRLsNotEmpty(PKIXCertRevocationCheckerParameters params, Set crls, Object cert) throws RecoverableCertPathValidatorException {
        if (crls.isEmpty()) {
            if (cert instanceof X509AttributeCertificate) {
                X509AttributeCertificate aCert = (X509AttributeCertificate) cert;
                throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + ((Object) aCert.getIssuer().getPrincipals()[0]) + "\"", null, params.getCertPath(), params.getIndex());
            }
            X509Certificate xCert = (X509Certificate) cert;
            throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + RFC4519Style.INSTANCE.toString(PrincipalUtils.getIssuerPrincipal(xCert)) + "\"", null, params.getCertPath(), params.getIndex());
        }
    }
}
