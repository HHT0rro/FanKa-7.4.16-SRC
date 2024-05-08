package sun.security.provider.certpath;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.security.auth.x500.X500Principal;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;
import sun.security.x509.AccessDescription;
import sun.security.x509.AuthorityInfoAccessExtension;
import sun.security.x509.AuthorityKeyIdentifierExtension;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ForwardBuilder extends Builder {
    private static final Debug debug = Debug.getInstance("certpath");
    private AdaptableX509CertSelector caSelector;
    private X509CertSelector caTargetSelector;
    private X509CertSelector eeSelector;
    private boolean searchAllCertStores;
    TrustAnchor trustAnchor;
    private final Set<TrustAnchor> trustAnchors;
    private final Set<X509Certificate> trustedCerts;
    private final Set<X500Principal> trustedSubjectDNs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardBuilder(PKIX.BuilderParams buildParams, boolean searchAllCertStores) {
        super(buildParams);
        this.searchAllCertStores = true;
        Set<TrustAnchor> trustAnchors = buildParams.trustAnchors();
        this.trustAnchors = trustAnchors;
        this.trustedCerts = new HashSet(trustAnchors.size());
        this.trustedSubjectDNs = new HashSet(trustAnchors.size());
        for (TrustAnchor anchor : trustAnchors) {
            X509Certificate trustedCert = anchor.getTrustedCert();
            if (trustedCert != null) {
                this.trustedCerts.add(trustedCert);
                this.trustedSubjectDNs.add(trustedCert.getSubjectX500Principal());
            } else {
                this.trustedSubjectDNs.add(anchor.getCA());
            }
        }
        this.searchAllCertStores = searchAllCertStores;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.security.provider.certpath.Builder
    public Collection<X509Certificate> getMatchingCerts(State currentState, List<CertStore> certStores) throws CertStoreException, CertificateException, IOException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ForwardBuilder.getMatchingCerts()...");
        }
        ForwardState currState = (ForwardState) currentState;
        Comparator<X509Certificate> comparator = new PKIXCertComparator(this.trustedSubjectDNs, currState.cert);
        Set<X509Certificate> certs = new TreeSet<>(comparator);
        if (currState.isInitial()) {
            getMatchingEECerts(currState, certStores, certs);
        }
        getMatchingCACerts(currState, certStores, certs);
        return certs;
    }

    private void getMatchingEECerts(ForwardState currentState, List<CertStore> certStores, Collection<X509Certificate> eeCerts) throws IOException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ForwardBuilder.getMatchingEECerts()...");
        }
        if (this.eeSelector == null) {
            X509CertSelector x509CertSelector = (X509CertSelector) this.targetCertConstraints.clone();
            this.eeSelector = x509CertSelector;
            x509CertSelector.setCertificateValid(this.buildParams.date());
            if (this.buildParams.explicitPolicyRequired()) {
                this.eeSelector.setPolicy(getMatchingPolicies());
            }
            this.eeSelector.setBasicConstraints(-2);
        }
        addMatchingCerts(this.eeSelector, certStores, eeCerts, this.searchAllCertStores);
    }

    private void getMatchingCACerts(ForwardState currentState, List<CertStore> certStores, Collection<X509Certificate> caCerts) throws IOException {
        X509CertSelector sel;
        AuthorityInfoAccessExtension aiaExt;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ForwardBuilder.getMatchingCACerts()...");
        }
        int initialSize = caCerts.size();
        if (currentState.isInitial()) {
            if (this.targetCertConstraints.getBasicConstraints() == -2) {
                return;
            }
            if (debug2 != null) {
                debug2.println("ForwardBuilder.getMatchingCACerts(): the target is a CA");
            }
            if (this.caTargetSelector == null) {
                this.caTargetSelector = (X509CertSelector) this.targetCertConstraints.clone();
                if (this.buildParams.explicitPolicyRequired()) {
                    this.caTargetSelector.setPolicy(getMatchingPolicies());
                }
            }
            sel = this.caTargetSelector;
        } else {
            X509CertSelector sel2 = this.caSelector;
            if (sel2 == null) {
                this.caSelector = new AdaptableX509CertSelector();
                if (this.buildParams.explicitPolicyRequired()) {
                    this.caSelector.setPolicy(getMatchingPolicies());
                }
            }
            this.caSelector.setSubject(currentState.issuerDN);
            CertPathHelper.setPathToNames(this.caSelector, currentState.subjectNamesTraversed);
            this.caSelector.setValidityPeriod(currentState.cert.getNotBefore(), currentState.cert.getNotAfter());
            sel = this.caSelector;
        }
        sel.setBasicConstraints(-1);
        for (X509Certificate trustedCert : this.trustedCerts) {
            if (sel.match(trustedCert)) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("ForwardBuilder.getMatchingCACerts: found matching trust anchor.\n  SN: " + Debug.toHexString(trustedCert.getSerialNumber()) + "\n  Subject: " + ((Object) trustedCert.getSubjectX500Principal()) + "\n  Issuer: " + ((Object) trustedCert.getIssuerX500Principal()));
                }
                if (caCerts.add(trustedCert) && !this.searchAllCertStores) {
                    return;
                }
            }
        }
        sel.setCertificateValid(this.buildParams.date());
        sel.setBasicConstraints(currentState.traversedCACerts);
        if ((currentState.isInitial() || this.buildParams.maxPathLength() == -1 || this.buildParams.maxPathLength() > currentState.traversedCACerts) && addMatchingCerts(sel, certStores, caCerts, this.searchAllCertStores) && !this.searchAllCertStores) {
            return;
        }
        if (!currentState.isInitial() && Builder.USE_AIA && (aiaExt = currentState.cert.getAuthorityInfoAccessExtension()) != null) {
            getCerts(aiaExt, caCerts);
        }
        Debug debug4 = debug;
        if (debug4 != null) {
            int numCerts = caCerts.size() - initialSize;
            debug4.println("ForwardBuilder.getMatchingCACerts: found " + numCerts + " CA certs");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean getCerts(AuthorityInfoAccessExtension aiaExt, Collection<X509Certificate> collection) {
        List<AccessDescription> adList;
        if (!Builder.USE_AIA || (adList = aiaExt.getAccessDescriptions()) == null || adList.isEmpty()) {
            return false;
        }
        boolean add = false;
        for (AccessDescription ad2 : adList) {
            CertStore cs = URICertStore.getInstance(ad2);
            if (cs != null) {
                try {
                    if (collection.addAll(cs.getCertificates(this.caSelector))) {
                        add = true;
                        if (!this.searchAllCertStores) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                } catch (CertStoreException cse) {
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("exception getting certs from CertStore:");
                        cse.printStackTrace();
                    }
                }
            }
        }
        return add;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class PKIXCertComparator implements Comparator<X509Certificate> {
        static final String METHOD_NME = "PKIXCertComparator.compare()";
        private final X509CertSelector certSkidSelector;
        private final Set<X500Principal> trustedSubjectDNs;

        PKIXCertComparator(Set<X500Principal> trustedSubjectDNs, X509CertImpl previousCert) throws IOException {
            this.trustedSubjectDNs = trustedSubjectDNs;
            this.certSkidSelector = getSelector(previousCert);
        }

        private X509CertSelector getSelector(X509CertImpl previousCert) throws IOException {
            AuthorityKeyIdentifierExtension akidExt;
            byte[] skid;
            if (previousCert != null && (akidExt = previousCert.getAuthorityKeyIdentifierExtension()) != null && (skid = akidExt.getEncodedKeyIdentifier()) != null) {
                X509CertSelector selector = new X509CertSelector();
                selector.setSubjectKeyIdentifier(skid);
                return selector;
            }
            return null;
        }

        @Override // java.util.Comparator
        public int compare(X509Certificate oCert1, X509Certificate oCert2) {
            int distanceTto1;
            int distanceTto2;
            if (oCert1.equals(oCert2)) {
                return 0;
            }
            X509CertSelector x509CertSelector = this.certSkidSelector;
            int i10 = -1;
            if (x509CertSelector != null) {
                if (x509CertSelector.match(oCert1)) {
                    return -1;
                }
                if (this.certSkidSelector.match(oCert2)) {
                    return 1;
                }
            }
            X500Principal cIssuer1 = oCert1.getIssuerX500Principal();
            X500Principal cIssuer2 = oCert2.getIssuerX500Principal();
            X500Name cIssuer1Name = X500Name.asX500Name(cIssuer1);
            X500Name cIssuer2Name = X500Name.asX500Name(cIssuer2);
            if (ForwardBuilder.debug != null) {
                ForwardBuilder.debug.println("PKIXCertComparator.compare() o1 Issuer:  " + ((Object) cIssuer1));
                ForwardBuilder.debug.println("PKIXCertComparator.compare() o2 Issuer:  " + ((Object) cIssuer2));
            }
            if (ForwardBuilder.debug != null) {
                ForwardBuilder.debug.println("PKIXCertComparator.compare() MATCH TRUSTED SUBJECT TEST...");
            }
            boolean m12 = this.trustedSubjectDNs.contains(cIssuer1);
            boolean m22 = this.trustedSubjectDNs.contains(cIssuer2);
            if (ForwardBuilder.debug != null) {
                ForwardBuilder.debug.println("PKIXCertComparator.compare() m1: " + m12);
                ForwardBuilder.debug.println("PKIXCertComparator.compare() m2: " + m22);
            }
            if ((m12 && m22) || m12) {
                return -1;
            }
            if (m22) {
                return 1;
            }
            if (ForwardBuilder.debug != null) {
                ForwardBuilder.debug.println("PKIXCertComparator.compare() NAMING DESCENDANT TEST...");
            }
            for (X500Principal tSubject : this.trustedSubjectDNs) {
                X500Name tSubjectName = X500Name.asX500Name(tSubject);
                int distanceTto12 = Builder.distance(tSubjectName, cIssuer1Name, i10);
                X500Principal cIssuer12 = cIssuer1;
                int distanceTto22 = Builder.distance(tSubjectName, cIssuer2Name, i10);
                if (ForwardBuilder.debug != null) {
                    ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceTto1: " + distanceTto12);
                    ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceTto2: " + distanceTto22);
                }
                if (distanceTto12 > 0 || distanceTto22 > 0) {
                    if (distanceTto12 == distanceTto22) {
                        return -1;
                    }
                    if (distanceTto12 > 0 && distanceTto22 <= 0) {
                        return -1;
                    }
                    if ((distanceTto12 <= 0 && distanceTto22 > 0) || distanceTto12 >= distanceTto22) {
                        return 1;
                    }
                    return -1;
                }
                cIssuer1 = cIssuer12;
                i10 = -1;
            }
            if (ForwardBuilder.debug != null) {
                ForwardBuilder.debug.println("PKIXCertComparator.compare() NAMING ANCESTOR TEST...");
            }
            Iterator<X500Principal> iterator2 = this.trustedSubjectDNs.iterator2();
            do {
                int i11 = Integer.MAX_VALUE;
                if (iterator2.hasNext()) {
                    X500Principal tSubject2 = iterator2.next();
                    X500Name tSubjectName2 = X500Name.asX500Name(tSubject2);
                    distanceTto1 = Builder.distance(tSubjectName2, cIssuer1Name, Integer.MAX_VALUE);
                    distanceTto2 = Builder.distance(tSubjectName2, cIssuer2Name, Integer.MAX_VALUE);
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceTto1: " + distanceTto1);
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceTto2: " + distanceTto2);
                    }
                    if (distanceTto1 < 0) {
                        break;
                    }
                } else {
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() SAME NAMESPACE AS TRUSTED TEST...");
                    }
                    for (X500Principal tSubject3 : this.trustedSubjectDNs) {
                        X500Name tSubjectName3 = X500Name.asX500Name(tSubject3);
                        X500Name tAo1 = tSubjectName3.commonAncestor(cIssuer1Name);
                        X500Name tAo2 = tSubjectName3.commonAncestor(cIssuer2Name);
                        if (ForwardBuilder.debug != null) {
                            ForwardBuilder.debug.println("PKIXCertComparator.compare() tAo1: " + String.valueOf(tAo1));
                            ForwardBuilder.debug.println("PKIXCertComparator.compare() tAo2: " + String.valueOf(tAo2));
                        }
                        if (tAo1 != null || tAo2 != null) {
                            if (tAo1 == null || tAo2 == null) {
                                return tAo1 == null ? 1 : -1;
                            }
                            int hopsTto1 = Builder.hops(tSubjectName3, cIssuer1Name, i11);
                            int hopsTto2 = Builder.hops(tSubjectName3, cIssuer2Name, i11);
                            if (ForwardBuilder.debug != null) {
                                ForwardBuilder.debug.println("PKIXCertComparator.compare() hopsTto1: " + hopsTto1);
                                ForwardBuilder.debug.println("PKIXCertComparator.compare() hopsTto2: " + hopsTto2);
                            }
                            if (hopsTto1 != hopsTto2) {
                                if (hopsTto1 > hopsTto2) {
                                    return 1;
                                }
                                return -1;
                            }
                        }
                        i11 = Integer.MAX_VALUE;
                    }
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() CERT ISSUER/SUBJECT COMPARISON TEST...");
                    }
                    X500Principal cSubject1 = oCert1.getSubjectX500Principal();
                    X500Principal cSubject2 = oCert2.getSubjectX500Principal();
                    X500Name cSubject1Name = X500Name.asX500Name(cSubject1);
                    X500Name cSubject2Name = X500Name.asX500Name(cSubject2);
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() o1 Subject: " + ((Object) cSubject1));
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() o2 Subject: " + ((Object) cSubject2));
                    }
                    int distanceStoI1 = Builder.distance(cSubject1Name, cIssuer1Name, Integer.MAX_VALUE);
                    int distanceStoI2 = Builder.distance(cSubject2Name, cIssuer2Name, Integer.MAX_VALUE);
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceStoI1: " + distanceStoI1);
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() distanceStoI2: " + distanceStoI2);
                    }
                    if (distanceStoI2 > distanceStoI1) {
                        return -1;
                    }
                    if (distanceStoI2 < distanceStoI1) {
                        return 1;
                    }
                    if (ForwardBuilder.debug != null) {
                        ForwardBuilder.debug.println("PKIXCertComparator.compare() no tests matched; RETURN 0");
                        return -1;
                    }
                    return -1;
                }
            } while (distanceTto2 >= 0);
            if (distanceTto1 == distanceTto2) {
                return -1;
            }
            if (distanceTto1 < 0 && distanceTto2 >= 0) {
                return -1;
            }
            if ((distanceTto1 >= 0 && distanceTto2 < 0) || distanceTto1 <= distanceTto2) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.security.provider.certpath.Builder
    public void verifyCert(X509Certificate cert, State currentState, List<X509Certificate> certPathList) throws GeneralSecurityException {
        Set<String> supportedExts;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ForwardBuilder.verifyCert(SN: " + Debug.toHexString(cert.getSerialNumber()) + "\n  Issuer: " + ((Object) cert.getIssuerX500Principal()) + ")\n  Subject: " + ((Object) cert.getSubjectX500Principal()) + ")");
        }
        ForwardState currState = (ForwardState) currentState;
        if (certPathList != null) {
            for (X509Certificate cpListCert : certPathList) {
                if (cert.equals(cpListCert)) {
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("loop detected!!");
                    }
                    throw new CertPathValidatorException("loop detected");
                }
            }
        }
        boolean isTrustedCert = this.trustedCerts.contains(cert);
        if (!isTrustedCert) {
            Set<String> unresCritExts = cert.getCriticalExtensionOIDs();
            if (unresCritExts == null) {
                unresCritExts = Collections.emptySet();
            }
            Iterator<PKIXCertPathChecker> iterator2 = currState.forwardCheckers.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().check(cert, unresCritExts);
            }
            for (PKIXCertPathChecker checker : this.buildParams.certPathCheckers()) {
                if (!checker.isForwardCheckingSupported() && (supportedExts = checker.getSupportedExtensions()) != null) {
                    unresCritExts.removeAll(supportedExts);
                }
            }
            if (!unresCritExts.isEmpty()) {
                unresCritExts.remove(PKIXExtensions.BasicConstraints_Id.toString());
                unresCritExts.remove(PKIXExtensions.NameConstraints_Id.toString());
                unresCritExts.remove(PKIXExtensions.CertificatePolicies_Id.toString());
                unresCritExts.remove(PKIXExtensions.PolicyMappings_Id.toString());
                unresCritExts.remove(PKIXExtensions.PolicyConstraints_Id.toString());
                unresCritExts.remove(PKIXExtensions.InhibitAnyPolicy_Id.toString());
                unresCritExts.remove(PKIXExtensions.SubjectAlternativeName_Id.toString());
                unresCritExts.remove(PKIXExtensions.KeyUsage_Id.toString());
                unresCritExts.remove(PKIXExtensions.ExtendedKeyUsage_Id.toString());
                if (!unresCritExts.isEmpty()) {
                    throw new CertPathValidatorException("Unrecognized critical extension(s)", null, null, -1, PKIXReason.UNRECOGNIZED_CRIT_EXT);
                }
            }
        }
        if (currState.isInitial()) {
            return;
        }
        if (!isTrustedCert) {
            if (cert.getBasicConstraints() == -1) {
                throw new CertificateException("cert is NOT a CA cert");
            }
            KeyChecker.verifyCAKeyUsage(cert);
        }
        if (!currState.keyParamsNeeded()) {
            if (this.buildParams.sigProvider() != null) {
                currState.cert.verify(cert.getPublicKey(), this.buildParams.sigProvider());
            } else {
                currState.cert.verify(cert.getPublicKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.security.provider.certpath.Builder
    public boolean isPathCompleted(X509Certificate cert) {
        List<TrustAnchor> otherAnchors = new ArrayList<>();
        for (TrustAnchor anchor : this.trustAnchors) {
            if (anchor.getTrustedCert() != null) {
                if (cert.equals(anchor.getTrustedCert())) {
                    this.trustAnchor = anchor;
                    return true;
                }
            } else {
                X500Principal principal = anchor.getCA();
                PublicKey publicKey = anchor.getCAPublicKey();
                if (principal != null && publicKey != null && principal.equals(cert.getSubjectX500Principal()) && publicKey.equals(cert.getPublicKey())) {
                    this.trustAnchor = anchor;
                    return true;
                }
                otherAnchors.add(anchor);
            }
        }
        for (TrustAnchor anchor2 : otherAnchors) {
            X500Principal principal2 = anchor2.getCA();
            PublicKey publicKey2 = anchor2.getCAPublicKey();
            if (principal2 != null && principal2.equals(cert.getIssuerX500Principal()) && !PKIX.isDSAPublicKeyWithoutParams(publicKey2)) {
                try {
                    if (this.buildParams.sigProvider() != null) {
                        cert.verify(publicKey2, this.buildParams.sigProvider());
                    } else {
                        cert.verify(publicKey2);
                    }
                    this.trustAnchor = anchor2;
                    return true;
                } catch (InvalidKeyException e2) {
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("ForwardBuilder.isPathCompleted() invalid DSA key found");
                    }
                } catch (GeneralSecurityException e10) {
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("ForwardBuilder.isPathCompleted() unexpected exception");
                        e10.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.security.provider.certpath.Builder
    public void addCertToPath(X509Certificate cert, LinkedList<X509Certificate> certPathList) {
        certPathList.addFirst(cert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.security.provider.certpath.Builder
    public void removeFinalCertFromPath(LinkedList<X509Certificate> certPathList) {
        certPathList.removeFirst();
    }
}
