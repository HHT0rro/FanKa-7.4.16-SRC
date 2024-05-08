package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BasicConstraintsExtension extends Extension implements CertAttrSet<String> {
    public static final String IDENT = "x509.info.extensions.BasicConstraints";
    public static final String IS_CA = "is_ca";
    public static final String NAME = "BasicConstraints";
    public static final String PATH_LEN = "path_len";

    /* renamed from: ca, reason: collision with root package name */
    private boolean f53745ca;
    private int pathLen;

    private void encodeThis() throws IOException {
        DerOutputStream out = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        boolean z10 = this.f53745ca;
        if (z10) {
            tmp.putBoolean(z10);
            int i10 = this.pathLen;
            if (i10 >= 0) {
                tmp.putInteger(i10);
            }
        }
        out.write((byte) 48, tmp);
        this.extensionValue = out.toByteArray();
    }

    public BasicConstraintsExtension(boolean ca2, int len) throws IOException {
        this(Boolean.valueOf(ca2), ca2, len);
    }

    public BasicConstraintsExtension(Boolean critical, boolean ca2, int len) throws IOException {
        this.f53745ca = false;
        this.pathLen = -1;
        this.f53745ca = ca2;
        this.pathLen = len;
        this.extensionId = PKIXExtensions.BasicConstraints_Id;
        this.critical = critical.booleanValue();
        encodeThis();
    }

    public BasicConstraintsExtension(Boolean critical, Object value) throws IOException {
        this.f53745ca = false;
        this.pathLen = -1;
        this.extensionId = PKIXExtensions.BasicConstraints_Id;
        this.critical = critical.booleanValue();
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding of BasicConstraints");
        }
        if (val.data == null || val.data.available() == 0) {
            return;
        }
        DerValue opt = val.data.getDerValue();
        if (opt.tag != 1) {
            return;
        }
        this.f53745ca = opt.getBoolean();
        if (val.data.available() == 0) {
            this.pathLen = Integer.MAX_VALUE;
            return;
        }
        DerValue opt2 = val.data.getDerValue();
        if (opt2.tag != 2) {
            throw new IOException("Invalid encoding of BasicConstraints");
        }
        this.pathLen = opt2.getInteger();
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        String s2;
        String s10 = (super.toString() + "BasicConstraints:[\n") + (this.f53745ca ? "  CA:true" : "  CA:false") + "\n";
        if (this.pathLen >= 0) {
            s2 = s10 + "  PathLen:" + this.pathLen + "\n";
        } else {
            s2 = s10 + "  PathLen: undefined\n";
        }
        return s2 + "]\n";
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.BasicConstraints_Id;
            if (this.f53745ca) {
                this.critical = true;
            } else {
                this.critical = false;
            }
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(IS_CA)) {
            if (!(obj instanceof Boolean)) {
                throw new IOException("Attribute value should be of type Boolean.");
            }
            this.f53745ca = ((Boolean) obj).booleanValue();
        } else if (name.equalsIgnoreCase(PATH_LEN)) {
            if (!(obj instanceof Integer)) {
                throw new IOException("Attribute value should be of type Integer.");
            }
            this.pathLen = ((Integer) obj).intValue();
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:BasicConstraints.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Object get(String name) throws IOException {
        if (name.equalsIgnoreCase(IS_CA)) {
            return Boolean.valueOf(this.f53745ca);
        }
        if (name.equalsIgnoreCase(PATH_LEN)) {
            return Integer.valueOf(this.pathLen);
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:BasicConstraints.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(IS_CA)) {
            this.f53745ca = false;
        } else if (name.equalsIgnoreCase(PATH_LEN)) {
            this.pathLen = -1;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:BasicConstraints.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(IS_CA);
        elements.addElement(PATH_LEN);
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }
}
