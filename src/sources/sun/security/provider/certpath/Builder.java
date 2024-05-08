package sun.security.provider.certpath;

import com.android.internal.org.bouncycastle.jce.provider.RFC3280CertPathUtilities;
import java.io.IOException;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import sun.security.action.GetBooleanAction;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;
import sun.security.x509.GeneralNameInterface;
import sun.security.x509.GeneralNames;
import sun.security.x509.GeneralSubtrees;
import sun.security.x509.NameConstraintsExtension;
import sun.security.x509.SubjectAlternativeNameExtension;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Builder {
    final PKIX.BuilderParams buildParams;
    private Set<String> matchingPolicies;
    final X509CertSelector targetCertConstraints;
    private static final Debug debug = Debug.getInstance("certpath");
    static final boolean USE_AIA = ((Boolean) AccessController.doPrivileged(new GetBooleanAction("com.sun.security.enableAIAcaIssuers"))).booleanValue();

    abstract void addCertToPath(X509Certificate x509Certificate, LinkedList<X509Certificate> linkedList);

    abstract Collection<X509Certificate> getMatchingCerts(State state, List<CertStore> list) throws CertStoreException, CertificateException, IOException;

    abstract boolean isPathCompleted(X509Certificate x509Certificate);

    abstract void removeFinalCertFromPath(LinkedList<X509Certificate> linkedList);

    abstract void verifyCert(X509Certificate x509Certificate, State state, List<X509Certificate> list) throws GeneralSecurityException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Builder(PKIX.BuilderParams buildParams) {
        this.buildParams = buildParams;
        this.targetCertConstraints = (X509CertSelector) buildParams.targetCertConstraints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int distance(GeneralNameInterface base, GeneralNameInterface test, int incomparable) {
        switch (base.constrains(test)) {
            case -1:
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Builder.distance(): Names are different types");
                }
                return incomparable;
            case 0:
                return 0;
            case 1:
            case 2:
                return test.subtreeDepth() - base.subtreeDepth();
            case 3:
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("Builder.distance(): Names are same type but in different subtrees");
                }
                return incomparable;
            default:
                return incomparable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hops(GeneralNameInterface base, GeneralNameInterface test, int incomparable) {
        int baseRtest = base.constrains(test);
        switch (baseRtest) {
            case -1:
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Builder.hops(): Names are different types");
                }
                return incomparable;
            case 0:
                return 0;
            case 1:
                return test.subtreeDepth() - base.subtreeDepth();
            case 2:
                return test.subtreeDepth() - base.subtreeDepth();
            case 3:
                if (base.getType() != 4) {
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("Builder.hops(): hopDistance not implemented for this name type");
                    }
                    return incomparable;
                }
                X500Name baseName = (X500Name) base;
                X500Name testName = (X500Name) test;
                X500Name commonName = baseName.commonAncestor(testName);
                if (commonName == null) {
                    Debug debug4 = debug;
                    if (debug4 != null) {
                        debug4.println("Builder.hops(): Names are in different namespaces");
                    }
                    return incomparable;
                }
                int commonDistance = commonName.subtreeDepth();
                int baseDistance = baseName.subtreeDepth();
                int testDistance = testName.subtreeDepth();
                return (baseDistance + testDistance) - (commonDistance * 2);
            default:
                return incomparable;
        }
    }

    static int targetDistance(NameConstraintsExtension constraints, X509Certificate cert, GeneralNameInterface target) throws IOException {
        GeneralNames altNames;
        if (constraints != null && !constraints.verify(cert)) {
            throw new IOException("certificate does not satisfy existing name constraints");
        }
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            X500Name subject = X500Name.asX500Name(certImpl.getSubjectX500Principal());
            if (subject.equals(target)) {
                return 0;
            }
            SubjectAlternativeNameExtension altNameExt = certImpl.getSubjectAlternativeNameExtension();
            if (altNameExt != null && (altNames = altNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME)) != null) {
                int n10 = altNames.size();
                for (int j10 = 0; j10 < n10; j10++) {
                    GeneralNameInterface altName = altNames.get(j10).getName();
                    if (altName.equals(target)) {
                        return 0;
                    }
                }
            }
            NameConstraintsExtension ncExt = certImpl.getNameConstraintsExtension();
            if (ncExt == null) {
                return -1;
            }
            if (constraints != null) {
                constraints.merge(ncExt);
            } else {
                constraints = (NameConstraintsExtension) ncExt.clone();
            }
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Builder.targetDistance() merged constraints: " + String.valueOf(constraints));
            }
            GeneralSubtrees permitted = constraints.get(NameConstraintsExtension.PERMITTED_SUBTREES);
            GeneralSubtrees excluded = constraints.get(NameConstraintsExtension.EXCLUDED_SUBTREES);
            if (permitted != null) {
                permitted.reduce(excluded);
            }
            if (debug2 != null) {
                debug2.println("Builder.targetDistance() reduced constraints: " + ((Object) permitted));
            }
            if (!constraints.verify(target)) {
                throw new IOException("New certificate not allowed to sign certificate for target");
            }
            if (permitted == null) {
                return -1;
            }
            int n11 = permitted.size();
            for (int i10 = 0; i10 < n11; i10++) {
                GeneralNameInterface perName = permitted.get(i10).getName().getName();
                int distance = distance(perName, target, -1);
                if (distance >= 0) {
                    return distance + 1;
                }
            }
            return -1;
        } catch (CertificateException e2) {
            throw new IOException("Invalid certificate", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> getMatchingPolicies() {
        if (this.matchingPolicies != null) {
            Set<String> initialPolicies = this.buildParams.initialPolicies();
            if (!initialPolicies.isEmpty() && !initialPolicies.contains(RFC3280CertPathUtilities.ANY_POLICY) && this.buildParams.policyMappingInhibited()) {
                HashSet hashSet = new HashSet(initialPolicies);
                this.matchingPolicies = hashSet;
                hashSet.add(RFC3280CertPathUtilities.ANY_POLICY);
            } else {
                this.matchingPolicies = Collections.emptySet();
            }
        }
        return this.matchingPolicies;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean addMatchingCerts(X509CertSelector selector, Collection<CertStore> certStores, Collection<X509Certificate> resultCerts, boolean checkAll) {
        X509Certificate targetCert = selector.getCertificate();
        if (targetCert != null) {
            if (selector.match(targetCert) && !X509CertImpl.isSelfSigned(targetCert, this.buildParams.sigProvider())) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Builder.addMatchingCerts: adding target cert\n  SN: " + Debug.toHexString(targetCert.getSerialNumber()) + "\n  Subject: " + ((Object) targetCert.getSubjectX500Principal()) + "\n  Issuer: " + ((Object) targetCert.getIssuerX500Principal()));
                }
                return resultCerts.add(targetCert);
            }
            return false;
        }
        boolean add = false;
        for (CertStore store : certStores) {
            try {
                Collection<? extends Certificate> certs = store.getCertificates(selector);
                for (Certificate cert : certs) {
                    if (!X509CertImpl.isSelfSigned((X509Certificate) cert, this.buildParams.sigProvider()) && resultCerts.add((X509Certificate) cert)) {
                        add = true;
                    }
                }
                if (!checkAll && add) {
                    return true;
                }
            } catch (CertStoreException cse) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("Builder.addMatchingCerts, non-fatal exception retrieving certs: " + ((Object) cse));
                    cse.printStackTrace();
                }
            }
        }
        return add;
    }
}
