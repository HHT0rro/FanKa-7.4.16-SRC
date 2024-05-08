package sun.security.provider.certpath;

import com.huawei.hms.feature.dynamic.f.e;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKIX {
    private static final Debug debug = Debug.getInstance("certpath");

    private PKIX() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDSAPublicKeyWithoutParams(PublicKey publicKey) {
        return (publicKey instanceof DSAPublicKey) && ((DSAPublicKey) publicKey).getParams() == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ValidatorParams checkParams(CertPath cp, CertPathParameters params) throws InvalidAlgorithmParameterException {
        if (!(params instanceof PKIXParameters)) {
            throw new InvalidAlgorithmParameterException("inappropriate params, must be an instance of PKIXParameters");
        }
        return new ValidatorParams(cp, (PKIXParameters) params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BuilderParams checkBuilderParams(CertPathParameters params) throws InvalidAlgorithmParameterException {
        if (!(params instanceof PKIXBuilderParameters)) {
            throw new InvalidAlgorithmParameterException("inappropriate params, must be an instance of PKIXBuilderParameters");
        }
        return new BuilderParams((PKIXBuilderParameters) params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ValidatorParams {
        private Set<TrustAnchor> anchors;
        private CertPath certPath;
        private List<X509Certificate> certs;
        private List<PKIXCertPathChecker> checkers;
        private CertSelector constraints;
        private Date date;
        private boolean gotConstraints;
        private boolean gotDate;
        private final PKIXParameters params;
        private Set<String> policies;
        private List<CertStore> stores;

        ValidatorParams(CertPath cp, PKIXParameters params) throws InvalidAlgorithmParameterException {
            this(params);
            if (!cp.getType().equals(e.f29912b) && !cp.getType().equals("X509")) {
                throw new InvalidAlgorithmParameterException("inappropriate CertPath type specified, must be X.509 or X509");
            }
            this.certPath = cp;
        }

        ValidatorParams(PKIXParameters params) throws InvalidAlgorithmParameterException {
            Set<TrustAnchor> trustAnchors = params.getTrustAnchors();
            this.anchors = trustAnchors;
            for (TrustAnchor anchor : trustAnchors) {
                if (anchor.getNameConstraints() != null) {
                    throw new InvalidAlgorithmParameterException("name constraints in trust anchor not supported");
                }
            }
            this.params = params;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CertPath certPath() {
            return this.certPath;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCertPath(CertPath cp) {
            this.certPath = cp;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<X509Certificate> certificates() {
            if (this.certs == null) {
                if (this.certPath == null) {
                    this.certs = Collections.emptyList();
                } else {
                    List<X509Certificate> xc2 = new ArrayList<>(this.certPath.getCertificates());
                    Collections.reverse(xc2);
                    this.certs = xc2;
                }
            }
            return this.certs;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<PKIXCertPathChecker> certPathCheckers() {
            if (this.checkers == null) {
                this.checkers = this.params.getCertPathCheckers();
            }
            return this.checkers;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<CertStore> certStores() {
            if (this.stores == null) {
                this.stores = this.params.getCertStores();
            }
            return this.stores;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date date() {
            if (!this.gotDate) {
                Date date = this.params.getDate();
                this.date = date;
                if (date == null) {
                    this.date = new Date();
                }
                this.gotDate = true;
            }
            return this.date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set<String> initialPolicies() {
            if (this.policies == null) {
                this.policies = this.params.getInitialPolicies();
            }
            return this.policies;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CertSelector targetCertConstraints() {
            if (!this.gotConstraints) {
                this.constraints = this.params.getTargetCertConstraints();
                this.gotConstraints = true;
            }
            return this.constraints;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set<TrustAnchor> trustAnchors() {
            return this.anchors;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean revocationEnabled() {
            return this.params.isRevocationEnabled();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean policyMappingInhibited() {
            return this.params.isPolicyMappingInhibited();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean explicitPolicyRequired() {
            return this.params.isExplicitPolicyRequired();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean policyQualifiersRejected() {
            return this.params.getPolicyQualifiersRejected();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String sigProvider() {
            return this.params.getSigProvider();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean anyPolicyInhibited() {
            return this.params.isAnyPolicyInhibited();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PKIXParameters getPKIXParameters() {
            return this.params;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class BuilderParams extends ValidatorParams {
        private PKIXBuilderParameters params;
        private List<CertStore> stores;
        private X500Principal targetSubject;

        BuilderParams(PKIXBuilderParameters params) throws InvalidAlgorithmParameterException {
            super(params);
            checkParams(params);
        }

        private void checkParams(PKIXBuilderParameters params) throws InvalidAlgorithmParameterException {
            CertSelector sel = targetCertConstraints();
            if (!(sel instanceof X509CertSelector)) {
                throw new InvalidAlgorithmParameterException("the targetCertConstraints parameter must be an X509CertSelector");
            }
            this.params = params;
            this.targetSubject = getTargetSubject(certStores(), (X509CertSelector) targetCertConstraints());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sun.security.provider.certpath.PKIX.ValidatorParams
        public List<CertStore> certStores() {
            if (this.stores == null) {
                ArrayList arrayList = new ArrayList(this.params.getCertStores());
                this.stores = arrayList;
                Collections.sort(arrayList, new CertStoreComparator());
            }
            return this.stores;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int maxPathLength() {
            return this.params.getMaxPathLength();
        }

        PKIXBuilderParameters params() {
            return this.params;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public X500Principal targetSubject() {
            return this.targetSubject;
        }

        private static X500Principal getTargetSubject(List<CertStore> stores, X509CertSelector sel) throws InvalidAlgorithmParameterException {
            Collection<? extends Certificate> certs;
            X500Principal subject = sel.getSubject();
            if (subject != null) {
                return subject;
            }
            X509Certificate cert = sel.getCertificate();
            if (cert != null) {
                subject = cert.getSubjectX500Principal();
            }
            if (subject != null) {
                return subject;
            }
            Iterator<CertStore> iterator2 = stores.iterator2();
            while (iterator2.hasNext()) {
                CertStore store = iterator2.next();
                try {
                    certs = store.getCertificates(sel);
                } catch (CertStoreException e2) {
                    if (PKIX.debug != null) {
                        PKIX.debug.println("BuilderParams.getTargetSubjectDN: non-fatal exception retrieving certs: " + ((Object) e2));
                        e2.printStackTrace();
                    }
                }
                if (!certs.isEmpty()) {
                    X509Certificate xc2 = (X509Certificate) certs.iterator2().next();
                    return xc2.getSubjectX500Principal();
                }
                continue;
            }
            throw new InvalidAlgorithmParameterException("Could not determine unique target subject");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CertStoreTypeException extends CertStoreException {
        private static final long serialVersionUID = 7463352639238322556L;
        private final String type;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CertStoreTypeException(String type, CertStoreException cse) {
            super(cse.getMessage(), cse.getCause());
            this.type = type;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CertStoreComparator implements Comparator<CertStore> {
        private CertStoreComparator() {
        }

        @Override // java.util.Comparator
        public int compare(CertStore store1, CertStore store2) {
            if (store1.getType().equals("Collection") || (store1.getCertStoreParameters() instanceof CollectionCertStoreParameters)) {
                return -1;
            }
            return 1;
        }
    }
}
