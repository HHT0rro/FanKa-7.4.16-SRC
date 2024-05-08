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
public class AuthorityKeyIdentifierExtension extends Extension implements CertAttrSet<String> {
    public static final String AUTH_NAME = "auth_name";
    public static final String IDENT = "x509.info.extensions.AuthorityKeyIdentifier";
    public static final String KEY_ID = "key_id";
    public static final String NAME = "AuthorityKeyIdentifier";
    public static final String SERIAL_NUMBER = "serial_number";
    private static final byte TAG_ID = 0;
    private static final byte TAG_NAMES = 1;
    private static final byte TAG_SERIAL_NUM = 2;

    /* renamed from: id, reason: collision with root package name */
    private KeyIdentifier f53744id;
    private GeneralNames names;
    private SerialNumber serialNum;

    private void encodeThis() throws IOException {
        if (this.f53744id == null && this.names == null && this.serialNum == null) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream seq = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        if (this.f53744id != null) {
            DerOutputStream tmp1 = new DerOutputStream();
            this.f53744id.encode(tmp1);
            tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 0), tmp1);
        }
        try {
            if (this.names != null) {
                DerOutputStream tmp12 = new DerOutputStream();
                this.names.encode(tmp12);
                tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), tmp12);
            }
            if (this.serialNum != null) {
                DerOutputStream tmp13 = new DerOutputStream();
                this.serialNum.encode(tmp13);
                tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 2), tmp13);
            }
            seq.write((byte) 48, tmp);
            this.extensionValue = seq.toByteArray();
        } catch (Exception e2) {
            throw new IOException(e2.toString());
        }
    }

    public AuthorityKeyIdentifierExtension(KeyIdentifier kid, GeneralNames name, SerialNumber sn) throws IOException {
        this.f53744id = null;
        this.names = null;
        this.serialNum = null;
        this.f53744id = kid;
        this.names = name;
        this.serialNum = sn;
        this.extensionId = PKIXExtensions.AuthorityKey_Id;
        this.critical = false;
        encodeThis();
    }

    public AuthorityKeyIdentifierExtension(Boolean critical, Object value) throws IOException {
        this.f53744id = null;
        this.names = null;
        this.serialNum = null;
        this.extensionId = PKIXExtensions.AuthorityKey_Id;
        this.critical = critical.booleanValue();
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for AuthorityKeyIdentifierExtension.");
        }
        while (val.data != null && val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            if (opt.isContextSpecific((byte) 0) && !opt.isConstructed()) {
                if (this.f53744id != null) {
                    throw new IOException("Duplicate KeyIdentifier in AuthorityKeyIdentifier.");
                }
                opt.resetTag((byte) 4);
                this.f53744id = new KeyIdentifier(opt);
            } else if (opt.isContextSpecific((byte) 1) && opt.isConstructed()) {
                if (this.names != null) {
                    throw new IOException("Duplicate GeneralNames in AuthorityKeyIdentifier.");
                }
                opt.resetTag((byte) 48);
                this.names = new GeneralNames(opt);
            } else if (opt.isContextSpecific((byte) 2) && !opt.isConstructed()) {
                if (this.serialNum != null) {
                    throw new IOException("Duplicate SerialNumber in AuthorityKeyIdentifier.");
                }
                opt.resetTag((byte) 2);
                this.serialNum = new SerialNumber(opt);
            } else {
                throw new IOException("Invalid encoding of AuthorityKeyIdentifierExtension.");
            }
        }
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        String s2 = super.toString() + "AuthorityKeyIdentifier [\n";
        if (this.f53744id != null) {
            s2 = s2 + this.f53744id.toString();
        }
        if (this.names != null) {
            s2 = s2 + this.names.toString() + "\n";
        }
        if (this.serialNum != null) {
            s2 = s2 + this.serialNum.toString() + "\n";
        }
        return s2 + "]\n";
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.AuthorityKey_Id;
            this.critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            if (!(obj instanceof KeyIdentifier)) {
                throw new IOException("Attribute value should be of type KeyIdentifier.");
            }
            this.f53744id = (KeyIdentifier) obj;
        } else if (name.equalsIgnoreCase(AUTH_NAME)) {
            if (!(obj instanceof GeneralNames)) {
                throw new IOException("Attribute value should be of type GeneralNames.");
            }
            this.names = (GeneralNames) obj;
        } else if (name.equalsIgnoreCase(SERIAL_NUMBER)) {
            if (!(obj instanceof SerialNumber)) {
                throw new IOException("Attribute value should be of type SerialNumber.");
            }
            this.serialNum = (SerialNumber) obj;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Object get(String name) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            return this.f53744id;
        }
        if (name.equalsIgnoreCase(AUTH_NAME)) {
            return this.names;
        }
        if (name.equalsIgnoreCase(SERIAL_NUMBER)) {
            return this.serialNum;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            this.f53744id = null;
        } else if (name.equalsIgnoreCase(AUTH_NAME)) {
            this.names = null;
        } else if (name.equalsIgnoreCase(SERIAL_NUMBER)) {
            this.serialNum = null;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("key_id");
        elements.addElement(AUTH_NAME);
        elements.addElement(SERIAL_NUMBER);
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }

    public byte[] getEncodedKeyIdentifier() throws IOException {
        if (this.f53744id != null) {
            DerOutputStream derOut = new DerOutputStream();
            this.f53744id.encode(derOut);
            return derOut.toByteArray();
        }
        return null;
    }
}
