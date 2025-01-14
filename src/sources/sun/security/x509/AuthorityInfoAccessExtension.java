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
public class AuthorityInfoAccessExtension extends Extension implements CertAttrSet<String> {
    public static final String DESCRIPTIONS = "descriptions";
    public static final String IDENT = "x509.info.extensions.AuthorityInfoAccess";
    public static final String NAME = "AuthorityInfoAccess";
    private List<AccessDescription> accessDescriptions;

    public AuthorityInfoAccessExtension(List<AccessDescription> accessDescriptions) throws IOException {
        this.extensionId = PKIXExtensions.AuthInfoAccess_Id;
        this.critical = false;
        this.accessDescriptions = accessDescriptions;
        encodeThis();
    }

    public AuthorityInfoAccessExtension(Boolean critical, Object value) throws IOException {
        this.extensionId = PKIXExtensions.AuthInfoAccess_Id;
        this.critical = critical.booleanValue();
        if (!(value instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for AuthorityInfoAccessExtension.");
        }
        this.accessDescriptions = new ArrayList();
        while (val.data.available() != 0) {
            DerValue seq = val.data.getDerValue();
            AccessDescription accessDescription = new AccessDescription(seq);
            this.accessDescriptions.add(accessDescription);
        }
    }

    public List<AccessDescription> getAccessDescriptions() {
        return this.accessDescriptions;
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.AuthInfoAccess_Id;
            this.critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase("descriptions")) {
            if (!(obj instanceof List)) {
                throw new IOException("Attribute value should be of type List.");
            }
            this.accessDescriptions = (List) obj;
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:AuthorityInfoAccessExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public List<AccessDescription> get(String name) throws IOException {
        if (name.equalsIgnoreCase("descriptions")) {
            return this.accessDescriptions;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:AuthorityInfoAccessExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase("descriptions")) {
            this.accessDescriptions = new ArrayList();
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:AuthorityInfoAccessExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("descriptions");
        return elements.elements();
    }

    private void encodeThis() throws IOException {
        if (this.accessDescriptions.isEmpty()) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream ads = new DerOutputStream();
        for (AccessDescription accessDescription : this.accessDescriptions) {
            accessDescription.encode(ads);
        }
        DerOutputStream seq = new DerOutputStream();
        seq.write((byte) 48, ads);
        this.extensionValue = seq.toByteArray();
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        return super.toString() + "AuthorityInfoAccess [\n  " + ((Object) this.accessDescriptions) + "\n]\n";
    }
}
