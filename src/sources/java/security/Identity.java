package java.security;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "1.2")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Identity implements Principal, Serializable {
    private static final long serialVersionUID = 3609922007826600659L;
    Vector<Certificate> certificates;
    String info;
    private String name;
    private PublicKey publicKey;
    IdentityScope scope;

    /* JADX INFO: Access modifiers changed from: protected */
    public Identity() {
        this("restoring...");
    }

    public Identity(String name, IdentityScope scope) throws KeyManagementException {
        this(name);
        if (scope != null) {
            scope.addIdentity(this);
        }
        this.scope = scope;
    }

    public Identity(String name) {
        this.info = "No further information available.";
        this.name = name;
    }

    @Override // java.security.Principal
    public final String getName() {
        return this.name;
    }

    public final IdentityScope getScope() {
        return this.scope;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(PublicKey key) throws KeyManagementException {
        check("setIdentityPublicKey");
        this.publicKey = key;
        this.certificates = new Vector<>();
    }

    public void setInfo(String info) {
        check("setIdentityInfo");
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public void addCertificate(Certificate certificate) throws KeyManagementException {
        check("addIdentityCertificate");
        if (this.certificates == null) {
            this.certificates = new Vector<>();
        }
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            if (!keyEquals(publicKey, certificate.getPublicKey())) {
                throw new KeyManagementException("public key different from cert public key");
            }
        } else {
            this.publicKey = certificate.getPublicKey();
        }
        this.certificates.addElement(certificate);
    }

    private boolean keyEquals(PublicKey aKey, PublicKey anotherKey) {
        String aKeyFormat = aKey.getFormat();
        String anotherKeyFormat = anotherKey.getFormat();
        if ((anotherKeyFormat == null) ^ (aKeyFormat == null)) {
            return false;
        }
        if (aKeyFormat == null || anotherKeyFormat == null || aKeyFormat.equalsIgnoreCase(anotherKeyFormat)) {
            return Arrays.equals(aKey.getEncoded(), anotherKey.getEncoded());
        }
        return false;
    }

    public void removeCertificate(Certificate certificate) throws KeyManagementException {
        check("removeIdentityCertificate");
        Vector<Certificate> vector = this.certificates;
        if (vector != null) {
            if (certificate == null || !vector.contains(certificate)) {
                throw new KeyManagementException();
            }
            this.certificates.removeElement(certificate);
        }
    }

    public Certificate[] certificates() {
        Vector<Certificate> vector = this.certificates;
        if (vector == null) {
            return new Certificate[0];
        }
        int len = vector.size();
        Certificate[] certs = new Certificate[len];
        this.certificates.copyInto(certs);
        return certs;
    }

    @Override // java.security.Principal
    public final boolean equals(Object identity) {
        if (identity == this) {
            return true;
        }
        if (identity instanceof Identity) {
            Identity i10 = (Identity) identity;
            if (fullName().equals(i10.fullName())) {
                return true;
            }
            return identityEquals(i10);
        }
        return false;
    }

    protected boolean identityEquals(Identity identity) {
        if (!this.name.equalsIgnoreCase(identity.name)) {
            return false;
        }
        PublicKey publicKey = this.publicKey;
        boolean z10 = publicKey == null;
        PublicKey publicKey2 = identity.publicKey;
        if (z10 ^ (publicKey2 == null)) {
            return false;
        }
        return publicKey == null || publicKey2 == null || publicKey.equals(publicKey2);
    }

    String fullName() {
        String parsable = this.name;
        if (this.scope != null) {
            return parsable + "." + this.scope.getName();
        }
        return parsable;
    }

    @Override // java.security.Principal
    public String toString() {
        check("printIdentity");
        String printable = this.name;
        if (this.scope != null) {
            return printable + "[" + this.scope.getName() + "]";
        }
        return printable;
    }

    public String toString(boolean detailed) {
        String out = toString();
        if (detailed) {
            String out2 = ((out + "\n") + printKeys()) + "\n" + printCertificates();
            if (this.info != null) {
                return out2 + "\n\t" + this.info;
            }
            return out2 + "\n\tno additional information available.";
        }
        return out;
    }

    String printKeys() {
        if (this.publicKey != null) {
            return "\tpublic key initialized";
        }
        return "\tno public key";
    }

    String printCertificates() {
        if (this.certificates != null) {
            String out = "\tcertificates: \n";
            int i10 = 1;
            Iterator<Certificate> iterator2 = this.certificates.iterator2();
            while (iterator2.hasNext()) {
                Certificate cert = iterator2.next();
                out = (out + "\tcertificate " + i10 + "\tfor  : " + ((Object) cert.getPrincipal()) + "\n") + "\t\t\tfrom : " + ((Object) cert.getGuarantor()) + "\n";
                i10++;
            }
            return out;
        }
        return "\tno certificates";
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.name.hashCode();
    }

    private static void check(String directive) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }
}
