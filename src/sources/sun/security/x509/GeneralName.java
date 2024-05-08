package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GeneralName {
    private GeneralNameInterface name;

    public GeneralName(GeneralNameInterface name) {
        this.name = null;
        if (name == null) {
            throw new NullPointerException("GeneralName must not be null");
        }
        this.name = name;
    }

    public GeneralName(DerValue encName) throws IOException {
        this(encName, false);
    }

    public GeneralName(DerValue encName, boolean nameConstraint) throws IOException {
        this.name = null;
        short tag = (byte) (encName.tag & 31);
        switch (tag) {
            case 0:
                if (encName.isContextSpecific() && encName.isConstructed()) {
                    encName.resetTag((byte) 48);
                    this.name = new OtherName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of Other-Name");
            case 1:
                if (encName.isContextSpecific() && !encName.isConstructed()) {
                    encName.resetTag((byte) 22);
                    this.name = new RFC822Name(encName);
                    return;
                }
                throw new IOException("Invalid encoding of RFC822 name");
            case 2:
                if (encName.isContextSpecific() && !encName.isConstructed()) {
                    encName.resetTag((byte) 22);
                    this.name = new DNSName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of DNS name");
            case 3:
            default:
                throw new IOException("Unrecognized GeneralName tag, (" + ((int) tag) + ")");
            case 4:
                if (encName.isContextSpecific() && encName.isConstructed()) {
                    this.name = new X500Name(encName.getData());
                    return;
                }
                throw new IOException("Invalid encoding of Directory name");
            case 5:
                if (encName.isContextSpecific() && encName.isConstructed()) {
                    encName.resetTag((byte) 48);
                    this.name = new EDIPartyName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of EDI name");
            case 6:
                if (encName.isContextSpecific() && !encName.isConstructed()) {
                    encName.resetTag((byte) 22);
                    this.name = nameConstraint ? URIName.nameConstraint(encName) : new URIName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of URI");
            case 7:
                if (encName.isContextSpecific() && !encName.isConstructed()) {
                    encName.resetTag((byte) 4);
                    this.name = new IPAddressName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of IP address");
            case 8:
                if (encName.isContextSpecific() && !encName.isConstructed()) {
                    encName.resetTag((byte) 6);
                    this.name = new OIDName(encName);
                    return;
                }
                throw new IOException("Invalid encoding of OID name");
        }
    }

    public int getType() {
        return this.name.getType();
    }

    public GeneralNameInterface getName() {
        return this.name;
    }

    public String toString() {
        return this.name.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeneralName)) {
            return false;
        }
        GeneralNameInterface otherGNI = ((GeneralName) other).name;
        try {
            return this.name.constrains(otherGNI) == 0;
        } catch (UnsupportedOperationException e2) {
            return false;
        }
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        this.name.encode(tmp);
        int nameType = this.name.getType();
        if (nameType == 0 || nameType == 3 || nameType == 5) {
            out.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) nameType), tmp);
        } else if (nameType == 4) {
            out.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) nameType), tmp);
        } else {
            out.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) nameType), tmp);
        }
    }
}
