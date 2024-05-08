package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.PolicyNode;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.security.util.Debug;
import sun.security.x509.CertificatePoliciesExtension;
import sun.security.x509.CertificatePolicyMap;
import sun.security.x509.InhibitAnyPolicyExtension;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.PolicyConstraintsExtension;
import sun.security.x509.PolicyInformation;
import sun.security.x509.PolicyMappingsExtension;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class PolicyChecker extends PKIXCertPathChecker {
    static final String ANY_POLICY = "2.5.29.32.0";
    private static final Debug debug = Debug.getInstance("certpath");
    private final boolean anyPolicyInhibited;
    private int certIndex;
    private final int certPathLen;
    private final boolean expPolicyRequired;
    private int explicitPolicy;
    private int inhibitAnyPolicy;
    private final Set<String> initPolicies;
    private final boolean polMappingInhibited;
    private int policyMapping;
    private final boolean rejectPolicyQualifiers;
    private PolicyNodeImpl rootNode;
    private Set<String> supportedExts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolicyChecker(Set<String> initialPolicies, int certPathLen, boolean expPolicyRequired, boolean polMappingInhibited, boolean anyPolicyInhibited, boolean rejectPolicyQualifiers, PolicyNodeImpl rootNode) {
        if (initialPolicies.isEmpty()) {
            HashSet hashSet = new HashSet(1);
            this.initPolicies = hashSet;
            hashSet.add("2.5.29.32.0");
        } else {
            this.initPolicies = new HashSet(initialPolicies);
        }
        this.certPathLen = certPathLen;
        this.expPolicyRequired = expPolicyRequired;
        this.polMappingInhibited = polMappingInhibited;
        this.anyPolicyInhibited = anyPolicyInhibited;
        this.rejectPolicyQualifiers = rejectPolicyQualifiers;
        this.rootNode = rootNode;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean forward) throws CertPathValidatorException {
        if (forward) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.certIndex = 1;
        this.explicitPolicy = this.expPolicyRequired ? 0 : this.certPathLen + 1;
        this.policyMapping = this.polMappingInhibited ? 0 : this.certPathLen + 1;
        this.inhibitAnyPolicy = this.anyPolicyInhibited ? 0 : this.certPathLen + 1;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        if (this.supportedExts == null) {
            HashSet hashSet = new HashSet(4);
            this.supportedExts = hashSet;
            hashSet.add(PKIXExtensions.CertificatePolicies_Id.toString());
            this.supportedExts.add(PKIXExtensions.PolicyMappings_Id.toString());
            this.supportedExts.add(PKIXExtensions.PolicyConstraints_Id.toString());
            this.supportedExts.add(PKIXExtensions.InhibitAnyPolicy_Id.toString());
            this.supportedExts = Collections.unmodifiableSet(this.supportedExts);
        }
        return this.supportedExts;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate cert, Collection<String> unresCritExts) throws CertPathValidatorException {
        checkPolicy((X509Certificate) cert);
        if (unresCritExts != null && !unresCritExts.isEmpty()) {
            unresCritExts.remove(PKIXExtensions.CertificatePolicies_Id.toString());
            unresCritExts.remove(PKIXExtensions.PolicyMappings_Id.toString());
            unresCritExts.remove(PKIXExtensions.PolicyConstraints_Id.toString());
            unresCritExts.remove(PKIXExtensions.InhibitAnyPolicy_Id.toString());
        }
    }

    private void checkPolicy(X509Certificate currCert) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("PolicyChecker.checkPolicy() ---checking certificate policies...");
            debug2.println("PolicyChecker.checkPolicy() certIndex = " + this.certIndex);
            debug2.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: explicitPolicy = " + this.explicitPolicy);
            debug2.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: policyMapping = " + this.policyMapping);
            debug2.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: inhibitAnyPolicy = " + this.inhibitAnyPolicy);
            debug2.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: policyTree = " + ((Object) this.rootNode));
        }
        try {
            X509CertImpl currCertImpl = X509CertImpl.toImpl(currCert);
            int i10 = this.certIndex;
            boolean finalCert = i10 == this.certPathLen;
            this.rootNode = processPolicies(i10, this.initPolicies, this.explicitPolicy, this.policyMapping, this.inhibitAnyPolicy, this.rejectPolicyQualifiers, this.rootNode, currCertImpl, finalCert);
            if (!finalCert) {
                this.explicitPolicy = mergeExplicitPolicy(this.explicitPolicy, currCertImpl, finalCert);
                this.policyMapping = mergePolicyMapping(this.policyMapping, currCertImpl);
                this.inhibitAnyPolicy = mergeInhibitAnyPolicy(this.inhibitAnyPolicy, currCertImpl);
            }
            this.certIndex++;
            if (debug2 != null) {
                debug2.println("PolicyChecker.checkPolicy() AFTER PROCESSING: explicitPolicy = " + this.explicitPolicy);
                debug2.println("PolicyChecker.checkPolicy() AFTER PROCESSING: policyMapping = " + this.policyMapping);
                debug2.println("PolicyChecker.checkPolicy() AFTER PROCESSING: inhibitAnyPolicy = " + this.inhibitAnyPolicy);
                debug2.println("PolicyChecker.checkPolicy() AFTER PROCESSING: policyTree = " + ((Object) this.rootNode));
                debug2.println("PolicyChecker.checkPolicy() certificate policies verified");
            }
        } catch (CertificateException ce2) {
            throw new CertPathValidatorException(ce2);
        }
    }

    static int mergeExplicitPolicy(int explicitPolicy, X509CertImpl currCert, boolean finalCert) throws CertPathValidatorException {
        if (explicitPolicy > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            explicitPolicy--;
        }
        try {
            PolicyConstraintsExtension polConstExt = currCert.getPolicyConstraintsExtension();
            if (polConstExt == null) {
                return explicitPolicy;
            }
            int require = polConstExt.get(PolicyConstraintsExtension.REQUIRE).intValue();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("PolicyChecker.mergeExplicitPolicy() require Index from cert = " + require);
            }
            if (!finalCert) {
                if (require != -1) {
                    if (explicitPolicy == -1 || require < explicitPolicy) {
                        return require;
                    }
                    return explicitPolicy;
                }
                return explicitPolicy;
            }
            if (require == 0) {
                return require;
            }
            return explicitPolicy;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("PolicyChecker.mergeExplicitPolicy unexpected exception");
                e2.printStackTrace();
            }
            throw new CertPathValidatorException(e2);
        }
    }

    static int mergePolicyMapping(int policyMapping, X509CertImpl currCert) throws CertPathValidatorException {
        if (policyMapping > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            policyMapping--;
        }
        try {
            PolicyConstraintsExtension polConstExt = currCert.getPolicyConstraintsExtension();
            if (polConstExt == null) {
                return policyMapping;
            }
            int inhibit = polConstExt.get(PolicyConstraintsExtension.INHIBIT).intValue();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("PolicyChecker.mergePolicyMapping() inhibit Index from cert = " + inhibit);
            }
            if (inhibit != -1) {
                if (policyMapping == -1 || inhibit < policyMapping) {
                    return inhibit;
                }
                return policyMapping;
            }
            return policyMapping;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("PolicyChecker.mergePolicyMapping unexpected exception");
                e2.printStackTrace();
            }
            throw new CertPathValidatorException(e2);
        }
    }

    static int mergeInhibitAnyPolicy(int inhibitAnyPolicy, X509CertImpl currCert) throws CertPathValidatorException {
        if (inhibitAnyPolicy > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            inhibitAnyPolicy--;
        }
        try {
            InhibitAnyPolicyExtension inhAnyPolExt = (InhibitAnyPolicyExtension) currCert.getExtension(PKIXExtensions.InhibitAnyPolicy_Id);
            if (inhAnyPolExt == null) {
                return inhibitAnyPolicy;
            }
            int skipCerts = inhAnyPolExt.get(InhibitAnyPolicyExtension.SKIP_CERTS).intValue();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("PolicyChecker.mergeInhibitAnyPolicy() skipCerts Index from cert = " + skipCerts);
            }
            if (skipCerts != -1 && skipCerts < inhibitAnyPolicy) {
                return skipCerts;
            }
            return inhibitAnyPolicy;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("PolicyChecker.mergeInhibitAnyPolicy unexpected exception");
                e2.printStackTrace();
            }
            throw new CertPathValidatorException(e2);
        }
    }

    static PolicyNodeImpl processPolicies(int certIndex, Set<String> initPolicies, int explicitPolicy, int policyMapping, int inhibitAnyPolicy, boolean rejectPolicyQualifiers, PolicyNodeImpl origRootNode, X509CertImpl currCert, boolean finalCert) throws CertPathValidatorException {
        PolicyNodeImpl rootNode;
        Set<PolicyQualifierInfo> anyQuals;
        int explicitPolicy2;
        boolean foundAnyPolicy = false;
        Set<PolicyQualifierInfo> anyQuals2 = new HashSet<>();
        if (origRootNode == null) {
            rootNode = null;
        } else {
            PolicyNodeImpl rootNode2 = origRootNode.copyTree();
            rootNode = rootNode2;
        }
        CertificatePoliciesExtension currCertPolicies = currCert.getCertificatePoliciesExtension();
        if (currCertPolicies != null && rootNode != null) {
            boolean policiesCritical = currCertPolicies.isCritical();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("PolicyChecker.processPolicies() policiesCritical = " + policiesCritical);
            }
            try {
                List<PolicyInformation> policyInfo = currCertPolicies.get(CertificatePoliciesExtension.POLICIES);
                if (debug2 != null) {
                    debug2.println("PolicyChecker.processPolicies() rejectPolicyQualifiers = " + rejectPolicyQualifiers);
                }
                boolean foundAnyPolicy2 = false;
                anyQuals = anyQuals2;
                for (PolicyInformation curPolInfo : policyInfo) {
                    String curPolicy = curPolInfo.getPolicyIdentifier().getIdentifier().toString();
                    if (curPolicy.equals("2.5.29.32.0")) {
                        foundAnyPolicy2 = true;
                        anyQuals = curPolInfo.getPolicyQualifiers();
                    } else {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("PolicyChecker.processPolicies() processing policy: " + curPolicy);
                        }
                        Set<PolicyQualifierInfo> pQuals = curPolInfo.getPolicyQualifiers();
                        if (!pQuals.isEmpty() && rejectPolicyQualifiers && policiesCritical) {
                            throw new CertPathValidatorException("critical policy qualifiers present in certificate", null, null, -1, PKIXReason.INVALID_POLICY);
                        }
                        boolean foundMatch = processParents(certIndex, policiesCritical, rejectPolicyQualifiers, rootNode, curPolicy, pQuals, false);
                        if (!foundMatch) {
                            processParents(certIndex, policiesCritical, rejectPolicyQualifiers, rootNode, curPolicy, pQuals, true);
                        }
                    }
                }
                if (foundAnyPolicy2 && (inhibitAnyPolicy > 0 || (!finalCert && X509CertImpl.isSelfIssued(currCert)))) {
                    Debug debug4 = debug;
                    if (debug4 != null) {
                        debug4.println("PolicyChecker.processPolicies() processing policy: 2.5.29.32.0");
                    }
                    processParents(certIndex, policiesCritical, rejectPolicyQualifiers, rootNode, "2.5.29.32.0", anyQuals, true);
                }
                rootNode.prune(certIndex);
                if (!rootNode.getChildren().hasNext()) {
                    rootNode = null;
                }
                foundAnyPolicy = policiesCritical;
            } catch (IOException ioe) {
                throw new CertPathValidatorException("Exception while retrieving policyOIDs", ioe);
            }
        } else if (currCertPolicies != null) {
            anyQuals = anyQuals2;
        } else {
            Debug debug5 = debug;
            if (debug5 != null) {
                debug5.println("PolicyChecker.processPolicies() no policies present in cert");
            }
            rootNode = null;
            anyQuals = anyQuals2;
        }
        if (rootNode != null && !finalCert) {
            rootNode = processPolicyMappings(currCert, certIndex, policyMapping, rootNode, foundAnyPolicy, anyQuals);
        }
        if (rootNode != null && !initPolicies.contains("2.5.29.32.0") && currCertPolicies != null && (rootNode = removeInvalidNodes(rootNode, certIndex, initPolicies, currCertPolicies)) != null && finalCert) {
            rootNode = rewriteLeafNodes(certIndex, initPolicies, rootNode);
        }
        if (!finalCert) {
            explicitPolicy2 = explicitPolicy;
        } else {
            explicitPolicy2 = mergeExplicitPolicy(explicitPolicy, currCert, finalCert);
        }
        if (explicitPolicy2 == 0 && rootNode == null) {
            throw new CertPathValidatorException("non-null policy tree required and policy tree is null", null, null, -1, PKIXReason.INVALID_POLICY);
        }
        return rootNode;
    }

    private static PolicyNodeImpl rewriteLeafNodes(int certIndex, Set<String> initPolicies, PolicyNodeImpl rootNode) {
        Set<PolicyNodeImpl> anyNodes = rootNode.getPolicyNodesValid(certIndex, "2.5.29.32.0");
        if (anyNodes.isEmpty()) {
            return rootNode;
        }
        PolicyNodeImpl anyNode = anyNodes.iterator2().next();
        PolicyNodeImpl parentNode = (PolicyNodeImpl) anyNode.getParent();
        parentNode.deleteChild(anyNode);
        Set<String> initial = new HashSet<>(initPolicies);
        for (PolicyNodeImpl node : rootNode.getPolicyNodes(certIndex)) {
            initial.remove(node.getValidPolicy());
        }
        if (initial.isEmpty()) {
            rootNode.prune(certIndex);
            if (rootNode.getChildren().hasNext()) {
                return rootNode;
            }
            return null;
        }
        boolean anyCritical = anyNode.isCritical();
        Set<PolicyQualifierInfo> anyQualifiers = anyNode.getPolicyQualifiers();
        for (String policy : initial) {
            Set<String> expectedPolicies = Collections.singleton(policy);
            new PolicyNodeImpl(parentNode, policy, anyQualifiers, anyCritical, expectedPolicies, false);
        }
        return rootNode;
    }

    private static boolean processParents(int certIndex, boolean policiesCritical, boolean rejectPolicyQualifiers, PolicyNodeImpl rootNode, String curPolicy, Set<PolicyQualifierInfo> pQuals, boolean matchAny) throws CertPathValidatorException {
        boolean foundMatch = false;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("PolicyChecker.processParents(): matchAny = " + matchAny);
        }
        Set<PolicyNodeImpl> parentNodes = rootNode.getPolicyNodesExpected(certIndex - 1, curPolicy, matchAny);
        for (PolicyNodeImpl curParent : parentNodes) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("PolicyChecker.processParents() found parent:\n" + curParent.asString());
            }
            curParent.getValidPolicy();
            if (curPolicy.equals("2.5.29.32.0")) {
                Set<String> parExpPols = curParent.getExpectedPolicies();
                for (String curParExpPol : parExpPols) {
                    Iterator<PolicyNodeImpl> childIter = curParent.getChildren();
                    while (true) {
                        if (childIter.hasNext()) {
                            PolicyNodeImpl childNode = childIter.next();
                            String childPolicy = childNode.getValidPolicy();
                            if (curParExpPol.equals(childPolicy)) {
                                Debug debug4 = debug;
                                if (debug4 != null) {
                                    debug4.println(childPolicy + " in parent's expected policy set already appears in child node");
                                }
                            }
                        } else {
                            Set<String> expPols = new HashSet<>();
                            expPols.add(curParExpPol);
                            new PolicyNodeImpl(curParent, curParExpPol, pQuals, policiesCritical, expPols, false);
                            break;
                        }
                    }
                }
            } else {
                Set<String> curExpPols = new HashSet<>();
                curExpPols.add(curPolicy);
                new PolicyNodeImpl(curParent, curPolicy, pQuals, policiesCritical, curExpPols, false);
            }
            foundMatch = true;
        }
        return foundMatch;
    }

    private static PolicyNodeImpl processPolicyMappings(X509CertImpl currCert, int certIndex, int policyMapping, PolicyNodeImpl rootNode, boolean policiesCritical, Set<PolicyQualifierInfo> anyQuals) throws CertPathValidatorException {
        PolicyMappingsExtension polMappingsExt = currCert.getPolicyMappingsExtension();
        if (polMappingsExt == null) {
            return rootNode;
        }
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("PolicyChecker.processPolicyMappings() inside policyMapping check");
        }
        try {
            List<CertificatePolicyMap> maps = polMappingsExt.get(PolicyMappingsExtension.MAP);
            boolean childDeleted = false;
            for (CertificatePolicyMap polMap : maps) {
                String issuerDomain = polMap.getIssuerIdentifier().getIdentifier().toString();
                String subjectDomain = polMap.getSubjectIdentifier().getIdentifier().toString();
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("PolicyChecker.processPolicyMappings() issuerDomain = " + issuerDomain);
                    debug3.println("PolicyChecker.processPolicyMappings() subjectDomain = " + subjectDomain);
                }
                if (issuerDomain.equals("2.5.29.32.0")) {
                    throw new CertPathValidatorException("encountered an issuerDomainPolicy of ANY_POLICY", null, null, -1, PKIXReason.INVALID_POLICY);
                }
                if (subjectDomain.equals("2.5.29.32.0")) {
                    throw new CertPathValidatorException("encountered a subjectDomainPolicy of ANY_POLICY", null, null, -1, PKIXReason.INVALID_POLICY);
                }
                Set<PolicyNodeImpl> validNodes = rootNode.getPolicyNodesValid(certIndex, issuerDomain);
                int i10 = -1;
                if (!validNodes.isEmpty()) {
                    for (PolicyNodeImpl curNode : validNodes) {
                        if (policyMapping > 0 || policyMapping == i10) {
                            curNode.addExpectedPolicy(subjectDomain);
                        } else if (policyMapping == 0) {
                            PolicyNodeImpl parentNode = (PolicyNodeImpl) curNode.getParent();
                            Debug debug4 = debug;
                            if (debug4 != null) {
                                debug4.println("PolicyChecker.processPolicyMappings() before deleting: policy tree = " + ((Object) rootNode));
                            }
                            parentNode.deleteChild(curNode);
                            childDeleted = true;
                            if (debug4 != null) {
                                debug4.println("PolicyChecker.processPolicyMappings() after deleting: policy tree = " + ((Object) rootNode));
                            }
                        }
                        i10 = -1;
                    }
                } else if (policyMapping > 0 || policyMapping == -1) {
                    Set<PolicyNodeImpl> validAnyNodes = rootNode.getPolicyNodesValid(certIndex, "2.5.29.32.0");
                    for (PolicyNodeImpl curAnyNode : validAnyNodes) {
                        PolicyNodeImpl curAnyNodeParent = (PolicyNodeImpl) curAnyNode.getParent();
                        Set<String> expPols = new HashSet<>();
                        expPols.add(subjectDomain);
                        new PolicyNodeImpl(curAnyNodeParent, issuerDomain, anyQuals, policiesCritical, expPols, true);
                        subjectDomain = subjectDomain;
                    }
                }
            }
            if (!childDeleted) {
                return rootNode;
            }
            rootNode.prune(certIndex);
            if (rootNode.getChildren().hasNext()) {
                return rootNode;
            }
            Debug debug5 = debug;
            if (debug5 != null) {
                debug5.println("setting rootNode to null");
            }
            return null;
        } catch (IOException e2) {
            Debug debug6 = debug;
            if (debug6 != null) {
                debug6.println("PolicyChecker.processPolicyMappings() mapping exception");
                e2.printStackTrace();
            }
            throw new CertPathValidatorException("Exception while checking mapping", e2);
        }
    }

    private static PolicyNodeImpl removeInvalidNodes(PolicyNodeImpl rootNode, int certIndex, Set<String> initPolicies, CertificatePoliciesExtension currCertPolicies) throws CertPathValidatorException {
        try {
            List<PolicyInformation> policyInfo = currCertPolicies.get(CertificatePoliciesExtension.POLICIES);
            boolean childDeleted = false;
            for (PolicyInformation curPolInfo : policyInfo) {
                String curPolicy = curPolInfo.getPolicyIdentifier().getIdentifier().toString();
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("PolicyChecker.processPolicies() processing policy second time: " + curPolicy);
                }
                Set<PolicyNodeImpl> validNodes = rootNode.getPolicyNodesValid(certIndex, curPolicy);
                for (PolicyNodeImpl curNode : validNodes) {
                    PolicyNodeImpl parentNode = (PolicyNodeImpl) curNode.getParent();
                    if (parentNode.getValidPolicy().equals("2.5.29.32.0") && !initPolicies.contains(curPolicy) && !curPolicy.equals("2.5.29.32.0")) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("PolicyChecker.processPolicies() before deleting: policy tree = " + ((Object) rootNode));
                        }
                        parentNode.deleteChild(curNode);
                        childDeleted = true;
                        if (debug3 != null) {
                            debug3.println("PolicyChecker.processPolicies() after deleting: policy tree = " + ((Object) rootNode));
                        }
                    }
                }
            }
            if (childDeleted) {
                rootNode.prune(certIndex);
                if (!rootNode.getChildren().hasNext()) {
                    return null;
                }
                return rootNode;
            }
            return rootNode;
        } catch (IOException ioe) {
            throw new CertPathValidatorException("Exception while retrieving policyOIDs", ioe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolicyNode getPolicyTree() {
        PolicyNodeImpl policyNodeImpl = this.rootNode;
        if (policyNodeImpl == null) {
            return null;
        }
        PolicyNodeImpl policyTree = policyNodeImpl.copyTree();
        policyTree.setImmutable();
        return policyTree;
    }
}
