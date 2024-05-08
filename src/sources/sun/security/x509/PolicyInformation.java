package sun.security.x509;

import java.io.IOException;
import java.security.cert.PolicyQualifierInfo;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PolicyInformation {
    public static final String ID = "id";
    public static final String NAME = "PolicyInformation";
    public static final String QUALIFIERS = "qualifiers";
    private CertificatePolicyId policyIdentifier;
    private Set<PolicyQualifierInfo> policyQualifiers;

    public PolicyInformation(CertificatePolicyId policyIdentifier, Set<PolicyQualifierInfo> policyQualifiers) throws IOException {
        if (policyQualifiers == null) {
            throw new NullPointerException("policyQualifiers is null");
        }
        this.policyQualifiers = new LinkedHashSet(policyQualifiers);
        this.policyIdentifier = policyIdentifier;
    }

    public PolicyInformation(DerValue val) throws IOException {
        if (val.tag != 48) {
            throw new IOException("Invalid encoding of PolicyInformation");
        }
        this.policyIdentifier = new CertificatePolicyId(val.data.getDerValue());
        if (val.data.available() != 0) {
            this.policyQualifiers = new LinkedHashSet();
            DerValue opt = val.data.getDerValue();
            if (opt.tag != 48) {
                throw new IOException("Invalid encoding of PolicyInformation");
            }
            if (opt.data.available() == 0) {
                throw new IOException("No data available in policyQualifiers");
            }
            while (opt.data.available() != 0) {
                this.policyQualifiers.add(new PolicyQualifierInfo(opt.data.getDerValue().toByteArray()));
            }
            return;
        }
        this.policyQualifiers = Collections.emptySet();
    }

    public boolean equals(Object other) {
        if (!(other instanceof PolicyInformation)) {
            return false;
        }
        PolicyInformation piOther = (PolicyInformation) other;
        if (this.policyIdentifier.equals(piOther.getPolicyIdentifier())) {
            return this.policyQualifiers.equals(piOther.getPolicyQualifiers());
        }
        return false;
    }

    public int hashCode() {
        int myhash = this.policyIdentifier.hashCode() + 37;
        return (myhash * 37) + this.policyQualifiers.hashCode();
    }

    public CertificatePolicyId getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public Set<PolicyQualifierInfo> getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    public Object get(String name) throws IOException {
        if (name.equalsIgnoreCase("id")) {
            return this.policyIdentifier;
        }
        if (name.equalsIgnoreCase(QUALIFIERS)) {
            return this.policyQualifiers;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by PolicyInformation.");
    }

    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase("id")) {
            if (obj instanceof CertificatePolicyId) {
                this.policyIdentifier = (CertificatePolicyId) obj;
                return;
            }
            throw new IOException("Attribute value must be instance of CertificatePolicyId.");
        }
        if (name.equalsIgnoreCase(QUALIFIERS)) {
            if (this.policyIdentifier == null) {
                throw new IOException("Attribute must have a CertificatePolicyIdentifier value before PolicyQualifierInfo can be set.");
            }
            if (obj instanceof Set) {
                for (Object obj1 : (Set) obj) {
                    if (!(obj1 instanceof PolicyQualifierInfo)) {
                        throw new IOException("Attribute value must be aSet of PolicyQualifierInfo objects.");
                    }
                }
                this.policyQualifiers = (Set) obj;
                return;
            }
            throw new IOException("Attribute value must be of type Set.");
        }
        throw new IOException("Attribute name [" + name + "] not recognized by PolicyInformation");
    }

    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(QUALIFIERS)) {
            this.policyQualifiers = Collections.emptySet();
        } else {
            if (name.equalsIgnoreCase("id")) {
                throw new IOException("Attribute ID may not be deleted from PolicyInformation.");
            }
            throw new IOException("Attribute name [" + name + "] not recognized by PolicyInformation.");
        }
    }

    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("id");
        elements.addElement(QUALIFIERS);
        return elements.elements();
    }

    public String getName() {
        return NAME;
    }

    public String toString() {
        StringBuilder s2 = new StringBuilder("  [" + this.policyIdentifier.toString());
        s2.append(((Object) this.policyQualifiers) + "  ]\n");
        return s2.toString();
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        this.policyIdentifier.encode(tmp);
        if (!this.policyQualifiers.isEmpty()) {
            DerOutputStream tmp2 = new DerOutputStream();
            for (PolicyQualifierInfo pq : this.policyQualifiers) {
                tmp2.write(pq.getEncoded());
            }
            tmp.write((byte) 48, tmp2);
        }
        out.write((byte) 48, tmp);
    }
}
