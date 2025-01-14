package sun.security.x509;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificateIssuerName implements CertAttrSet<String> {
    public static final String DN_NAME = "dname";
    public static final String DN_PRINCIPAL = "x500principal";
    public static final String IDENT = "x509.info.issuer";
    public static final String NAME = "issuer";
    private X500Name dnName;
    private X500Principal dnPrincipal;

    public CertificateIssuerName(X500Name name) {
        this.dnName = name;
    }

    public CertificateIssuerName(DerInputStream in) throws IOException {
        this.dnName = new X500Name(in);
    }

    public CertificateIssuerName(InputStream in) throws IOException {
        DerValue derVal = new DerValue(in);
        this.dnName = new X500Name(derVal);
    }

    @Override // sun.security.x509.CertAttrSet
    public String toString() {
        X500Name x500Name = this.dnName;
        return x500Name == null ? "" : x500Name.toString();
    }

    @Override // sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        this.dnName.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (!(obj instanceof X500Name)) {
            throw new IOException("Attribute must be of type X500Name.");
        }
        if (name.equalsIgnoreCase("dname")) {
            this.dnName = (X500Name) obj;
            this.dnPrincipal = null;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuerName.");
    }

    @Override // sun.security.x509.CertAttrSet
    public Object get(String name) throws IOException {
        X500Name x500Name;
        if (name.equalsIgnoreCase("dname")) {
            return this.dnName;
        }
        if (name.equalsIgnoreCase("x500principal")) {
            if (this.dnPrincipal == null && (x500Name = this.dnName) != null) {
                this.dnPrincipal = x500Name.asX500Principal();
            }
            return this.dnPrincipal;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuerName.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase("dname")) {
            this.dnName = null;
            this.dnPrincipal = null;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuerName.");
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("dname");
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return "issuer";
    }
}
