package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKIXParameters implements CertPathParameters {
    private List<PKIXCertPathChecker> certPathCheckers;
    private CertSelector certSelector;
    private List<CertStore> certStores;
    private Date date;
    private String sigProvider;
    private Set<String> unmodInitialPolicies;
    private Set<TrustAnchor> unmodTrustAnchors;
    private boolean revocationEnabled = true;
    private boolean explicitPolicyRequired = false;
    private boolean policyMappingInhibited = false;
    private boolean anyPolicyInhibited = false;
    private boolean policyQualifiersRejected = true;

    public PKIXParameters(Set<TrustAnchor> trustAnchors) throws InvalidAlgorithmParameterException {
        setTrustAnchors(trustAnchors);
        this.unmodInitialPolicies = Collections.emptySet();
        this.certPathCheckers = new ArrayList();
        this.certStores = new ArrayList();
    }

    public PKIXParameters(KeyStore keystore) throws KeyStoreException, InvalidAlgorithmParameterException {
        if (keystore == null) {
            throw new NullPointerException("the keystore parameter must be non-null");
        }
        Set<TrustAnchor> hashSet = new HashSet<>();
        Enumeration<String> aliases = keystore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            if (keystore.isCertificateEntry(alias)) {
                Certificate cert = keystore.getCertificate(alias);
                if (cert instanceof X509Certificate) {
                    hashSet.add(new TrustAnchor((X509Certificate) cert, null));
                }
            }
        }
        setTrustAnchors(hashSet);
        this.unmodInitialPolicies = Collections.emptySet();
        this.certPathCheckers = new ArrayList();
        this.certStores = new ArrayList();
    }

    public Set<TrustAnchor> getTrustAnchors() {
        return this.unmodTrustAnchors;
    }

    public void setTrustAnchors(Set<TrustAnchor> trustAnchors) throws InvalidAlgorithmParameterException {
        if (trustAnchors == null) {
            throw new NullPointerException("the trustAnchors parameters must be non-null");
        }
        if (trustAnchors.isEmpty()) {
            throw new InvalidAlgorithmParameterException("the trustAnchors parameter must be non-empty");
        }
        Iterator<TrustAnchor> i10 = trustAnchors.iterator2();
        while (i10.hasNext()) {
            if (!(i10.next() instanceof TrustAnchor)) {
                throw new ClassCastException("all elements of set must be of type java.security.cert.TrustAnchor");
            }
        }
        this.unmodTrustAnchors = Collections.unmodifiableSet(new HashSet(trustAnchors));
    }

    public Set<String> getInitialPolicies() {
        return this.unmodInitialPolicies;
    }

    public void setInitialPolicies(Set<String> initialPolicies) {
        if (initialPolicies != null) {
            Iterator<String> i10 = initialPolicies.iterator2();
            while (i10.hasNext()) {
                if (!(i10.next() instanceof String)) {
                    throw new ClassCastException("all elements of set must be of type java.lang.String");
                }
            }
            this.unmodInitialPolicies = Collections.unmodifiableSet(new HashSet(initialPolicies));
            return;
        }
        this.unmodInitialPolicies = Collections.emptySet();
    }

    public void setCertStores(List<CertStore> stores) {
        if (stores == null) {
            this.certStores = new ArrayList();
            return;
        }
        Iterator<CertStore> i10 = stores.iterator2();
        while (i10.hasNext()) {
            if (!(i10.next() instanceof CertStore)) {
                throw new ClassCastException("all elements of list must be of type java.security.cert.CertStore");
            }
        }
        this.certStores = new ArrayList(stores);
    }

    public void addCertStore(CertStore store) {
        if (store != null) {
            this.certStores.add(store);
        }
    }

    public List<CertStore> getCertStores() {
        return Collections.unmodifiableList(new ArrayList(this.certStores));
    }

    public void setRevocationEnabled(boolean val) {
        this.revocationEnabled = val;
    }

    public boolean isRevocationEnabled() {
        return this.revocationEnabled;
    }

    public void setExplicitPolicyRequired(boolean val) {
        this.explicitPolicyRequired = val;
    }

    public boolean isExplicitPolicyRequired() {
        return this.explicitPolicyRequired;
    }

    public void setPolicyMappingInhibited(boolean val) {
        this.policyMappingInhibited = val;
    }

    public boolean isPolicyMappingInhibited() {
        return this.policyMappingInhibited;
    }

    public void setAnyPolicyInhibited(boolean val) {
        this.anyPolicyInhibited = val;
    }

    public boolean isAnyPolicyInhibited() {
        return this.anyPolicyInhibited;
    }

    public void setPolicyQualifiersRejected(boolean qualifiersRejected) {
        this.policyQualifiersRejected = qualifiersRejected;
    }

    public boolean getPolicyQualifiersRejected() {
        return this.policyQualifiersRejected;
    }

    public Date getDate() {
        Date date = this.date;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = (Date) date.clone();
        }
    }

    public void setCertPathCheckers(List<PKIXCertPathChecker> checkers) {
        if (checkers != null) {
            List<PKIXCertPathChecker> tmpList = new ArrayList<>();
            for (PKIXCertPathChecker checker : checkers) {
                tmpList.add((PKIXCertPathChecker) checker.clone());
            }
            this.certPathCheckers = tmpList;
            return;
        }
        this.certPathCheckers = new ArrayList();
    }

    public List<PKIXCertPathChecker> getCertPathCheckers() {
        List<PKIXCertPathChecker> tmpList = new ArrayList<>();
        for (PKIXCertPathChecker ck : this.certPathCheckers) {
            tmpList.add((PKIXCertPathChecker) ck.clone());
        }
        return Collections.unmodifiableList(tmpList);
    }

    public void addCertPathChecker(PKIXCertPathChecker checker) {
        if (checker != null) {
            this.certPathCheckers.add((PKIXCertPathChecker) checker.clone());
        }
    }

    public String getSigProvider() {
        return this.sigProvider;
    }

    public void setSigProvider(String sigProvider) {
        this.sigProvider = sigProvider;
    }

    public CertSelector getTargetCertConstraints() {
        CertSelector certSelector = this.certSelector;
        if (certSelector != null) {
            return (CertSelector) certSelector.clone();
        }
        return null;
    }

    public void setTargetCertConstraints(CertSelector selector) {
        if (selector != null) {
            this.certSelector = (CertSelector) selector.clone();
        } else {
            this.certSelector = null;
        }
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        try {
            PKIXParameters copy = (PKIXParameters) super.clone();
            if (this.certStores != null) {
                copy.certStores = new ArrayList(this.certStores);
            }
            if (this.certPathCheckers != null) {
                copy.certPathCheckers = new ArrayList(this.certPathCheckers.size());
                for (PKIXCertPathChecker checker : this.certPathCheckers) {
                    copy.certPathCheckers.add((PKIXCertPathChecker) checker.clone());
                }
            }
            return copy;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        if (this.unmodTrustAnchors != null) {
            sb2.append("  Trust Anchors: " + this.unmodTrustAnchors.toString() + "\n");
        }
        Set<String> set = this.unmodInitialPolicies;
        if (set != null) {
            if (set.isEmpty()) {
                sb2.append("  Initial Policy OIDs: any\n");
            } else {
                sb2.append("  Initial Policy OIDs: [" + this.unmodInitialPolicies.toString() + "]\n");
            }
        }
        sb2.append("  Validity Date: " + String.valueOf(this.date) + "\n");
        sb2.append("  Signature Provider: " + String.valueOf(this.sigProvider) + "\n");
        sb2.append("  Default Revocation Enabled: " + this.revocationEnabled + "\n");
        sb2.append("  Explicit Policy Required: " + this.explicitPolicyRequired + "\n");
        sb2.append("  Policy Mapping Inhibited: " + this.policyMappingInhibited + "\n");
        sb2.append("  Any Policy Inhibited: " + this.anyPolicyInhibited + "\n");
        sb2.append("  Policy Qualifiers Rejected: " + this.policyQualifiersRejected + "\n");
        sb2.append("  Target Cert Constraints: " + String.valueOf(this.certSelector) + "\n");
        if (this.certPathCheckers != null) {
            sb2.append("  Certification Path Checkers: [" + this.certPathCheckers.toString() + "]\n");
        }
        if (this.certStores != null) {
            sb2.append("  CertStores: [" + this.certStores.toString() + "]\n");
        }
        sb2.append("]");
        return sb2.toString();
    }
}
