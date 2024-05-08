package sun.security.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKCS9Attributes {
    private final Hashtable<ObjectIdentifier, PKCS9Attribute> attributes;
    private final byte[] derEncoding;
    private boolean ignoreUnsupportedAttributes;
    private final Hashtable<ObjectIdentifier, ObjectIdentifier> permittedAttributes;

    public PKCS9Attributes(ObjectIdentifier[] permittedAttributes, DerInputStream in) throws IOException {
        this.attributes = new Hashtable<>(3);
        this.ignoreUnsupportedAttributes = false;
        if (permittedAttributes != null) {
            this.permittedAttributes = new Hashtable<>(permittedAttributes.length);
            for (int i10 = 0; i10 < permittedAttributes.length; i10++) {
                this.permittedAttributes.put(permittedAttributes[i10], permittedAttributes[i10]);
            }
        } else {
            this.permittedAttributes = null;
        }
        this.derEncoding = decode(in);
    }

    public PKCS9Attributes(DerInputStream in) throws IOException {
        this(in, false);
    }

    public PKCS9Attributes(DerInputStream in, boolean ignoreUnsupportedAttributes) throws IOException {
        this.attributes = new Hashtable<>(3);
        this.ignoreUnsupportedAttributes = false;
        this.ignoreUnsupportedAttributes = ignoreUnsupportedAttributes;
        this.derEncoding = decode(in);
        this.permittedAttributes = null;
    }

    public PKCS9Attributes(PKCS9Attribute[] attribs) throws IllegalArgumentException, IOException {
        this.attributes = new Hashtable<>(3);
        this.ignoreUnsupportedAttributes = false;
        for (int i10 = 0; i10 < attribs.length; i10++) {
            ObjectIdentifier oid = attribs[i10].getOID();
            if (this.attributes.containsKey(oid)) {
                throw new IllegalArgumentException("PKCSAttribute " + ((Object) attribs[i10].getOID()) + " duplicated while constructing PKCS9Attributes.");
            }
            this.attributes.put(oid, attribs[i10]);
        }
        this.derEncoding = generateDerEncoding();
        this.permittedAttributes = null;
    }

    private byte[] decode(DerInputStream in) throws IOException {
        PKCS9Attribute attrib;
        ObjectIdentifier oid;
        DerValue val = in.getDerValue();
        byte[] derEncoding = val.toByteArray();
        derEncoding[0] = 49;
        DerInputStream derIn = new DerInputStream(derEncoding);
        DerValue[] derVals = derIn.getSet(3, true);
        boolean reuseEncoding = true;
        for (DerValue derValue : derVals) {
            try {
                attrib = new PKCS9Attribute(derValue);
                oid = attrib.getOID();
            } catch (ParsingException e2) {
                if (this.ignoreUnsupportedAttributes) {
                    reuseEncoding = false;
                } else {
                    throw e2;
                }
            }
            if (this.attributes.get(oid) != null) {
                throw new IOException("Duplicate PKCS9 attribute: " + ((Object) oid));
            }
            Hashtable<ObjectIdentifier, ObjectIdentifier> hashtable = this.permittedAttributes;
            if (hashtable != null && !hashtable.containsKey(oid)) {
                throw new IOException("Attribute " + ((Object) oid) + " not permitted in this attribute set");
            }
            this.attributes.put(oid, attrib);
        }
        return reuseEncoding ? derEncoding : generateDerEncoding();
    }

    public void encode(byte tag, OutputStream out) throws IOException {
        out.write(tag);
        byte[] bArr = this.derEncoding;
        out.write(bArr, 1, bArr.length - 1);
    }

    private byte[] generateDerEncoding() throws IOException {
        DerOutputStream out = new DerOutputStream();
        Object[] attribVals = this.attributes.values().toArray();
        out.putOrderedSetOf((byte) 49, castToDerEncoder(attribVals));
        return out.toByteArray();
    }

    public byte[] getDerEncoding() throws IOException {
        return (byte[]) this.derEncoding.clone();
    }

    public PKCS9Attribute getAttribute(ObjectIdentifier oid) {
        return this.attributes.get(oid);
    }

    public PKCS9Attribute getAttribute(String name) {
        return this.attributes.get(PKCS9Attribute.getOID(name));
    }

    public PKCS9Attribute[] getAttributes() {
        PKCS9Attribute[] attribs = new PKCS9Attribute[this.attributes.size()];
        int j10 = 0;
        for (int i10 = 1; i10 < PKCS9Attribute.PKCS9_OIDS.length && j10 < attribs.length; i10++) {
            if (PKCS9Attribute.PKCS9_OIDS[i10] != null) {
                attribs[j10] = getAttribute(PKCS9Attribute.PKCS9_OIDS[i10]);
                if (attribs[j10] != null) {
                    j10++;
                }
            }
        }
        return attribs;
    }

    public Object getAttributeValue(ObjectIdentifier oid) throws IOException {
        try {
            Object value = getAttribute(oid).getValue();
            return value;
        } catch (NullPointerException e2) {
            throw new IOException("No value found for attribute " + ((Object) oid));
        }
    }

    public Object getAttributeValue(String name) throws IOException {
        ObjectIdentifier oid = PKCS9Attribute.getOID(name);
        if (oid == null) {
            throw new IOException("Attribute name " + name + " not recognized or not supported.");
        }
        return getAttributeValue(oid);
    }

    public String toString() {
        PKCS9Attribute value;
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("PKCS9 Attributes: [\n\t");
        boolean first = true;
        for (int i10 = 1; i10 < PKCS9Attribute.PKCS9_OIDS.length; i10++) {
            if (PKCS9Attribute.PKCS9_OIDS[i10] != null && (value = getAttribute(PKCS9Attribute.PKCS9_OIDS[i10])) != null) {
                if (first) {
                    first = false;
                } else {
                    sb2.append(";\n\t");
                }
                sb2.append((Object) value);
            }
        }
        sb2.append("\n\t] (end PKCS9 Attributes)");
        return sb2.toString();
    }

    static DerEncoder[] castToDerEncoder(Object[] objs) {
        DerEncoder[] encoders = new DerEncoder[objs.length];
        for (int i10 = 0; i10 < encoders.length; i10++) {
            encoders[i10] = (DerEncoder) objs[i10];
        }
        return encoders;
    }
}
