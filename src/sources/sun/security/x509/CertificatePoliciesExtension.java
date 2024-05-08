package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificatePoliciesExtension extends Extension implements CertAttrSet<String> {
    public static final String IDENT = "x509.info.extensions.CertificatePolicies";
    public static final String NAME = "CertificatePolicies";
    public static final String POLICIES = "policies";
    private List<PolicyInformation> certPolicies;

    private void encodeThis() throws IOException {
        List<PolicyInformation> list = this.certPolicies;
        if (list == null || list.isEmpty()) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream os = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        for (PolicyInformation info : this.certPolicies) {
            info.encode(tmp);
        }
        os.write((byte) 48, tmp);
        this.extensionValue = os.toByteArray();
    }

    public CertificatePoliciesExtension(List<PolicyInformation> certPolicies) throws IOException {
        this(Boolean.FALSE, certPolicies);
    }

    public CertificatePoliciesExtension(Boolean critical, List<PolicyInformation> certPolicies) throws IOException {
        this.certPolicies = certPolicies;
        this.extensionId = PKIXExtensions.CertificatePolicies_Id;
        this.critical = critical.booleanValue();
        encodeThis();
    }

    public CertificatePoliciesExtension(Boolean critical, Object value) throws IOException {
        this.extensionId = PKIXExtensions.CertificatePolicies_Id;
        this.critical = critical.booleanValue();
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for CertificatePoliciesExtension.");
        }
        this.certPolicies = new ArrayList();
        while (val.data.available() != 0) {
            DerValue seq = val.data.getDerValue();
            PolicyInformation policy = new PolicyInformation(seq);
            this.certPolicies.add(policy);
        }
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        if (this.certPolicies == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append("CertificatePolicies [\n");
        for (PolicyInformation info : this.certPolicies) {
            sb2.append(info.toString());
        }
        sb2.append("]\n");
        return sb2.toString();
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.CertificatePolicies_Id;
            this.critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(POLICIES)) {
            if (!(obj instanceof List)) {
                throw new IOException("Attribute value should be of type List.");
            }
            this.certPolicies = (List) obj;
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:CertificatePoliciesExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public List<PolicyInformation> get(String name) throws IOException {
        if (name.equalsIgnoreCase(POLICIES)) {
            return this.certPolicies;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:CertificatePoliciesExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(POLICIES)) {
            this.certPolicies = null;
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:CertificatePoliciesExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(POLICIES);
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }
}
