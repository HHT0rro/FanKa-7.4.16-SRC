package sun.security.provider.certpath;

import java.security.cert.PolicyNode;
import java.security.cert.PolicyQualifierInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class PolicyNodeImpl implements PolicyNode {
    private static final String ANY_POLICY = "2.5.29.32.0";
    private boolean isImmutable;
    private HashSet<PolicyNodeImpl> mChildren;
    private boolean mCriticalityIndicator;
    private int mDepth;
    private HashSet<String> mExpectedPolicySet;
    private boolean mOriginalExpectedPolicySet;
    private PolicyNodeImpl mParent;
    private HashSet<PolicyQualifierInfo> mQualifierSet;
    private String mValidPolicy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolicyNodeImpl(PolicyNodeImpl parent, String validPolicy, Set<PolicyQualifierInfo> qualifierSet, boolean criticalityIndicator, Set<String> expectedPolicySet, boolean generatedByPolicyMapping) {
        this.isImmutable = false;
        this.mParent = parent;
        this.mChildren = new HashSet<>();
        if (validPolicy != null) {
            this.mValidPolicy = validPolicy;
        } else {
            this.mValidPolicy = "";
        }
        if (qualifierSet != null) {
            this.mQualifierSet = new HashSet<>(qualifierSet);
        } else {
            this.mQualifierSet = new HashSet<>();
        }
        this.mCriticalityIndicator = criticalityIndicator;
        if (expectedPolicySet != null) {
            this.mExpectedPolicySet = new HashSet<>(expectedPolicySet);
        } else {
            this.mExpectedPolicySet = new HashSet<>();
        }
        this.mOriginalExpectedPolicySet = !generatedByPolicyMapping;
        PolicyNodeImpl policyNodeImpl = this.mParent;
        if (policyNodeImpl != null) {
            this.mDepth = policyNodeImpl.getDepth() + 1;
            this.mParent.addChild(this);
        } else {
            this.mDepth = 0;
        }
    }

    PolicyNodeImpl(PolicyNodeImpl parent, PolicyNodeImpl node) {
        this(parent, node.mValidPolicy, node.mQualifierSet, node.mCriticalityIndicator, node.mExpectedPolicySet, false);
    }

    @Override // java.security.cert.PolicyNode
    public PolicyNode getParent() {
        return this.mParent;
    }

    @Override // java.security.cert.PolicyNode
    public Iterator<PolicyNodeImpl> getChildren() {
        return Collections.unmodifiableSet(this.mChildren).iterator2();
    }

    @Override // java.security.cert.PolicyNode
    public int getDepth() {
        return this.mDepth;
    }

    @Override // java.security.cert.PolicyNode
    public String getValidPolicy() {
        return this.mValidPolicy;
    }

    @Override // java.security.cert.PolicyNode
    public Set<PolicyQualifierInfo> getPolicyQualifiers() {
        return Collections.unmodifiableSet(this.mQualifierSet);
    }

    @Override // java.security.cert.PolicyNode
    public Set<String> getExpectedPolicies() {
        return Collections.unmodifiableSet(this.mExpectedPolicySet);
    }

    @Override // java.security.cert.PolicyNode
    public boolean isCritical() {
        return this.mCriticalityIndicator;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(asString());
        Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
        while (iterator2.hasNext()) {
            PolicyNodeImpl node = iterator2.next();
            buffer.append((Object) node);
        }
        return buffer.toString();
    }

    boolean isImmutable() {
        return this.isImmutable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImmutable() {
        if (this.isImmutable) {
            return;
        }
        Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
        while (iterator2.hasNext()) {
            PolicyNodeImpl node = iterator2.next();
            node.setImmutable();
        }
        this.isImmutable = true;
    }

    private void addChild(PolicyNodeImpl child) {
        if (this.isImmutable) {
            throw new IllegalStateException("PolicyNode is immutable");
        }
        this.mChildren.add(child);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addExpectedPolicy(String expectedPolicy) {
        if (this.isImmutable) {
            throw new IllegalStateException("PolicyNode is immutable");
        }
        if (this.mOriginalExpectedPolicySet) {
            this.mExpectedPolicySet.clear();
            this.mOriginalExpectedPolicySet = false;
        }
        this.mExpectedPolicySet.add(expectedPolicy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prune(int depth) {
        if (this.isImmutable) {
            throw new IllegalStateException("PolicyNode is immutable");
        }
        if (this.mChildren.size() == 0) {
            return;
        }
        Iterator<PolicyNodeImpl> it = this.mChildren.iterator2();
        while (it.hasNext()) {
            PolicyNodeImpl node = it.next();
            node.prune(depth);
            if (node.mChildren.size() == 0 && depth > this.mDepth + 1) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteChild(PolicyNode childNode) {
        if (this.isImmutable) {
            throw new IllegalStateException("PolicyNode is immutable");
        }
        this.mChildren.remove(childNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolicyNodeImpl copyTree() {
        return copyTree(null);
    }

    private PolicyNodeImpl copyTree(PolicyNodeImpl parent) {
        PolicyNodeImpl newNode = new PolicyNodeImpl(parent, this);
        Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
        while (iterator2.hasNext()) {
            PolicyNodeImpl node = iterator2.next();
            node.copyTree(newNode);
        }
        return newNode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<PolicyNodeImpl> getPolicyNodes(int depth) {
        Set<PolicyNodeImpl> set = new HashSet<>();
        getPolicyNodes(depth, set);
        return set;
    }

    private void getPolicyNodes(int depth, Set<PolicyNodeImpl> set) {
        if (this.mDepth == depth) {
            set.add(this);
            return;
        }
        Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
        while (iterator2.hasNext()) {
            PolicyNodeImpl node = iterator2.next();
            node.getPolicyNodes(depth, set);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<PolicyNodeImpl> getPolicyNodesExpected(int depth, String expectedOID, boolean matchAny) {
        if (expectedOID.equals("2.5.29.32.0")) {
            return getPolicyNodes(depth);
        }
        return getPolicyNodesExpectedHelper(depth, expectedOID, matchAny);
    }

    private Set<PolicyNodeImpl> getPolicyNodesExpectedHelper(int depth, String expectedOID, boolean matchAny) {
        HashSet<PolicyNodeImpl> set = new HashSet<>();
        if (this.mDepth < depth) {
            Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
            while (iterator2.hasNext()) {
                PolicyNodeImpl node = iterator2.next();
                set.addAll(node.getPolicyNodesExpectedHelper(depth, expectedOID, matchAny));
            }
        } else if (matchAny) {
            if (this.mExpectedPolicySet.contains("2.5.29.32.0")) {
                set.add(this);
            }
        } else if (this.mExpectedPolicySet.contains(expectedOID)) {
            set.add(this);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<PolicyNodeImpl> getPolicyNodesValid(int depth, String validOID) {
        HashSet<PolicyNodeImpl> set = new HashSet<>();
        if (this.mDepth < depth) {
            Iterator<PolicyNodeImpl> iterator2 = this.mChildren.iterator2();
            while (iterator2.hasNext()) {
                PolicyNodeImpl node = iterator2.next();
                set.addAll(node.getPolicyNodesValid(depth, validOID));
            }
        } else if (this.mValidPolicy.equals(validOID)) {
            set.add(this);
        }
        return set;
    }

    private static String policyToString(String oid) {
        if (oid.equals("2.5.29.32.0")) {
            return "anyPolicy";
        }
        return oid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String asString() {
        if (this.mParent == null) {
            return "anyPolicy  ROOT\n";
        }
        StringBuilder sb2 = new StringBuilder();
        int n10 = getDepth();
        for (int i10 = 0; i10 < n10; i10++) {
            sb2.append("  ");
        }
        sb2.append(policyToString(getValidPolicy()));
        sb2.append("  CRIT: ");
        sb2.append(isCritical());
        sb2.append("  EP: ");
        for (String policy : getExpectedPolicies()) {
            sb2.append(policyToString(policy));
            sb2.append(" ");
        }
        sb2.append(" (");
        sb2.append(getDepth());
        sb2.append(")\n");
        return sb2.toString();
    }
}
