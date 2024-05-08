package sun.security.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.CertificateExtensions;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKCS9Attribute implements DerEncoder {
    private static final Class<?> BYTE_ARRAY_CLASS;
    public static final ObjectIdentifier CHALLENGE_PASSWORD_OID;
    public static final String CHALLENGE_PASSWORD_STR = "ChallengePassword";
    public static final ObjectIdentifier CONTENT_TYPE_OID;
    public static final String CONTENT_TYPE_STR = "ContentType";
    public static final ObjectIdentifier COUNTERSIGNATURE_OID;
    public static final String COUNTERSIGNATURE_STR = "Countersignature";
    public static final ObjectIdentifier EMAIL_ADDRESS_OID;
    public static final String EMAIL_ADDRESS_STR = "EmailAddress";
    public static final ObjectIdentifier EXTENDED_CERTIFICATE_ATTRIBUTES_OID;
    public static final String EXTENDED_CERTIFICATE_ATTRIBUTES_STR = "ExtendedCertificateAttributes";
    public static final ObjectIdentifier EXTENSION_REQUEST_OID;
    public static final String EXTENSION_REQUEST_STR = "ExtensionRequest";
    public static final ObjectIdentifier ISSUER_SERIALNUMBER_OID;
    public static final String ISSUER_SERIALNUMBER_STR = "IssuerAndSerialNumber";
    public static final ObjectIdentifier MESSAGE_DIGEST_OID;
    public static final String MESSAGE_DIGEST_STR = "MessageDigest";
    private static final Hashtable<String, ObjectIdentifier> NAME_OID_TABLE;
    private static final Hashtable<ObjectIdentifier, String> OID_NAME_TABLE;
    private static final Byte[][] PKCS9_VALUE_TAGS;
    private static final String RSA_PROPRIETARY_STR = "RSAProprietary";
    public static final ObjectIdentifier SIGNATURE_TIMESTAMP_TOKEN_OID;
    public static final String SIGNATURE_TIMESTAMP_TOKEN_STR = "SignatureTimestampToken";
    public static final ObjectIdentifier SIGNING_CERTIFICATE_OID;
    public static final String SIGNING_CERTIFICATE_STR = "SigningCertificate";
    public static final ObjectIdentifier SIGNING_TIME_OID;
    public static final String SIGNING_TIME_STR = "SigningTime";
    private static final boolean[] SINGLE_VALUED;
    public static final ObjectIdentifier SMIME_CAPABILITY_OID;
    public static final String SMIME_CAPABILITY_STR = "SMIMECapability";
    private static final String SMIME_SIGNING_DESC_STR = "SMIMESigningDesc";
    public static final ObjectIdentifier UNSTRUCTURED_ADDRESS_OID;
    public static final String UNSTRUCTURED_ADDRESS_STR = "UnstructuredAddress";
    public static final ObjectIdentifier UNSTRUCTURED_NAME_OID;
    public static final String UNSTRUCTURED_NAME_STR = "UnstructuredName";
    private static final Class<?>[] VALUE_CLASSES;
    private int index;
    private ObjectIdentifier oid;
    private Object value;
    private static final Debug debug = Debug.getInstance("jar");
    static final ObjectIdentifier[] PKCS9_OIDS = new ObjectIdentifier[18];

    static {
        int i10 = 1;
        while (true) {
            ObjectIdentifier[] objectIdentifierArr = PKCS9_OIDS;
            if (i10 < objectIdentifierArr.length - 2) {
                objectIdentifierArr[i10] = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 9, i10});
                i10++;
            } else {
                int i11 = objectIdentifierArr.length;
                objectIdentifierArr[i11 - 2] = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 9, 16, 2, 12});
                objectIdentifierArr[objectIdentifierArr.length - 1] = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 9, 16, 2, 14});
                try {
                    Class<?> cls = Class.forName("[B");
                    BYTE_ARRAY_CLASS = cls;
                    EMAIL_ADDRESS_OID = objectIdentifierArr[1];
                    UNSTRUCTURED_NAME_OID = objectIdentifierArr[2];
                    CONTENT_TYPE_OID = objectIdentifierArr[3];
                    MESSAGE_DIGEST_OID = objectIdentifierArr[4];
                    SIGNING_TIME_OID = objectIdentifierArr[5];
                    COUNTERSIGNATURE_OID = objectIdentifierArr[6];
                    CHALLENGE_PASSWORD_OID = objectIdentifierArr[7];
                    UNSTRUCTURED_ADDRESS_OID = objectIdentifierArr[8];
                    EXTENDED_CERTIFICATE_ATTRIBUTES_OID = objectIdentifierArr[9];
                    ISSUER_SERIALNUMBER_OID = objectIdentifierArr[10];
                    EXTENSION_REQUEST_OID = objectIdentifierArr[14];
                    SMIME_CAPABILITY_OID = objectIdentifierArr[15];
                    SIGNING_CERTIFICATE_OID = objectIdentifierArr[16];
                    SIGNATURE_TIMESTAMP_TOKEN_OID = objectIdentifierArr[17];
                    Hashtable<String, ObjectIdentifier> hashtable = new Hashtable<>(18);
                    NAME_OID_TABLE = hashtable;
                    hashtable.put("emailaddress", objectIdentifierArr[1]);
                    hashtable.put("unstructuredname", objectIdentifierArr[2]);
                    hashtable.put("contenttype", objectIdentifierArr[3]);
                    hashtable.put("messagedigest", objectIdentifierArr[4]);
                    hashtable.put("signingtime", objectIdentifierArr[5]);
                    hashtable.put("countersignature", objectIdentifierArr[6]);
                    hashtable.put("challengepassword", objectIdentifierArr[7]);
                    hashtable.put("unstructuredaddress", objectIdentifierArr[8]);
                    hashtable.put("extendedcertificateattributes", objectIdentifierArr[9]);
                    hashtable.put("issuerandserialnumber", objectIdentifierArr[10]);
                    hashtable.put("rsaproprietary", objectIdentifierArr[11]);
                    hashtable.put("rsaproprietary", objectIdentifierArr[12]);
                    hashtable.put("signingdescription", objectIdentifierArr[13]);
                    hashtable.put("extensionrequest", objectIdentifierArr[14]);
                    hashtable.put("smimecapability", objectIdentifierArr[15]);
                    hashtable.put("signingcertificate", objectIdentifierArr[16]);
                    hashtable.put("signaturetimestamptoken", objectIdentifierArr[17]);
                    Hashtable<ObjectIdentifier, String> hashtable2 = new Hashtable<>(16);
                    OID_NAME_TABLE = hashtable2;
                    hashtable2.put(objectIdentifierArr[1], EMAIL_ADDRESS_STR);
                    hashtable2.put(objectIdentifierArr[2], UNSTRUCTURED_NAME_STR);
                    hashtable2.put(objectIdentifierArr[3], CONTENT_TYPE_STR);
                    hashtable2.put(objectIdentifierArr[4], MESSAGE_DIGEST_STR);
                    hashtable2.put(objectIdentifierArr[5], SIGNING_TIME_STR);
                    hashtable2.put(objectIdentifierArr[6], COUNTERSIGNATURE_STR);
                    hashtable2.put(objectIdentifierArr[7], CHALLENGE_PASSWORD_STR);
                    hashtable2.put(objectIdentifierArr[8], UNSTRUCTURED_ADDRESS_STR);
                    hashtable2.put(objectIdentifierArr[9], EXTENDED_CERTIFICATE_ATTRIBUTES_STR);
                    hashtable2.put(objectIdentifierArr[10], ISSUER_SERIALNUMBER_STR);
                    hashtable2.put(objectIdentifierArr[11], RSA_PROPRIETARY_STR);
                    hashtable2.put(objectIdentifierArr[12], RSA_PROPRIETARY_STR);
                    hashtable2.put(objectIdentifierArr[13], SMIME_SIGNING_DESC_STR);
                    hashtable2.put(objectIdentifierArr[14], EXTENSION_REQUEST_STR);
                    hashtable2.put(objectIdentifierArr[15], SMIME_CAPABILITY_STR);
                    hashtable2.put(objectIdentifierArr[16], SIGNING_CERTIFICATE_STR);
                    hashtable2.put(objectIdentifierArr[17], SIGNATURE_TIMESTAMP_TOKEN_STR);
                    PKCS9_VALUE_TAGS = new Byte[][]{null, new Byte[]{new Byte((byte) 22)}, new Byte[]{new Byte((byte) 22), new Byte((byte) 19)}, new Byte[]{new Byte((byte) 6)}, new Byte[]{new Byte((byte) 4)}, new Byte[]{new Byte((byte) 23)}, new Byte[]{new Byte((byte) 48)}, new Byte[]{new Byte((byte) 19), new Byte((byte) 20)}, new Byte[]{new Byte((byte) 19), new Byte((byte) 20)}, new Byte[]{new Byte((byte) 49)}, new Byte[]{new Byte((byte) 48)}, null, null, null, new Byte[]{new Byte((byte) 48)}, new Byte[]{new Byte((byte) 48)}, new Byte[]{new Byte((byte) 48)}, new Byte[]{new Byte((byte) 48)}};
                    Class<?>[] clsArr = new Class[18];
                    VALUE_CLASSES = clsArr;
                    try {
                        Class<?> str = Class.forName("[Ljava.lang.String;");
                        clsArr[0] = null;
                        clsArr[1] = str;
                        clsArr[2] = str;
                        clsArr[3] = Class.forName("sun.security.util.ObjectIdentifier");
                        clsArr[4] = cls;
                        clsArr[5] = Class.forName("java.util.Date");
                        clsArr[6] = Class.forName("[Lsun.security.pkcs.SignerInfo;");
                        clsArr[7] = Class.forName("java.lang.String");
                        clsArr[8] = str;
                        clsArr[9] = null;
                        clsArr[10] = null;
                        clsArr[11] = null;
                        clsArr[12] = null;
                        clsArr[13] = null;
                        clsArr[14] = Class.forName("sun.security.x509.CertificateExtensions");
                        clsArr[15] = null;
                        clsArr[16] = null;
                        clsArr[17] = cls;
                        SINGLE_VALUED = new boolean[]{false, false, false, true, true, true, false, true, false, false, true, false, false, false, true, true, true, true};
                        return;
                    } catch (ClassNotFoundException e2) {
                        throw new ExceptionInInitializerError(e2.toString());
                    }
                } catch (ClassNotFoundException e10) {
                    throw new ExceptionInInitializerError(e10.toString());
                }
            }
        }
    }

    public PKCS9Attribute(ObjectIdentifier oid, Object value) throws IllegalArgumentException {
        init(oid, value);
    }

    public PKCS9Attribute(String name, Object value) throws IllegalArgumentException {
        ObjectIdentifier oid = getOID(name);
        if (oid == null) {
            throw new IllegalArgumentException("Unrecognized attribute name " + name + " constructing PKCS9Attribute.");
        }
        init(oid, value);
    }

    private void init(ObjectIdentifier oid, Object value) throws IllegalArgumentException {
        this.oid = oid;
        int indexOf = indexOf(oid, PKCS9_OIDS, 1);
        this.index = indexOf;
        Class<?> clazz = indexOf == -1 ? BYTE_ARRAY_CLASS : VALUE_CLASSES[indexOf];
        if (!clazz.isInstance(value)) {
            throw new IllegalArgumentException("Wrong value class  for attribute " + ((Object) oid) + " constructing PKCS9Attribute; was " + value.getClass().toString() + ", should be " + clazz.toString());
        }
        this.value = value;
    }

    public PKCS9Attribute(DerValue derVal) throws IOException {
        DerInputStream derIn = new DerInputStream(derVal.toByteArray());
        DerValue[] val = derIn.getSequence(2);
        if (derIn.available() == 0) {
            if (val.length != 2) {
                throw new IOException("PKCS9Attribute doesn't have two components");
            }
            this.oid = val[0].getOID();
            byte[] content = val[1].toByteArray();
            DerValue[] elems = new DerInputStream(content).getSet(1);
            int indexOf = indexOf(this.oid, PKCS9_OIDS, 1);
            this.index = indexOf;
            if (indexOf == -1) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Unsupported signer attribute: " + ((Object) this.oid));
                }
                this.value = content;
                return;
            }
            if (SINGLE_VALUED[indexOf] && elems.length > 1) {
                throwSingleValuedException();
            }
            for (DerValue derValue : elems) {
                Byte tag = new Byte(derValue.tag);
                if (indexOf(tag, PKCS9_VALUE_TAGS[this.index], 0) == -1) {
                    throwTagException(tag);
                }
            }
            int i10 = this.index;
            switch (i10) {
                case 1:
                case 2:
                case 8:
                    String[] values = new String[elems.length];
                    for (int i11 = 0; i11 < elems.length; i11++) {
                        values[i11] = elems[i11].getAsString();
                    }
                    this.value = values;
                    return;
                case 3:
                    this.value = elems[0].getOID();
                    return;
                case 4:
                    this.value = elems[0].getOctetString();
                    return;
                case 5:
                    this.value = new DerInputStream(elems[0].toByteArray()).getUTCTime();
                    return;
                case 6:
                    SignerInfo[] values2 = new SignerInfo[elems.length];
                    for (int i12 = 0; i12 < elems.length; i12++) {
                        values2[i12] = new SignerInfo(elems[i12].toDerInputStream());
                    }
                    this.value = values2;
                    return;
                case 7:
                    this.value = elems[0].getAsString();
                    return;
                case 9:
                    throw new IOException("PKCS9 extended-certificate attribute not supported.");
                case 10:
                    throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
                case 11:
                case 12:
                    throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
                case 13:
                    throw new IOException("PKCS9 attribute #13 not supported.");
                case 14:
                    this.value = new CertificateExtensions(new DerInputStream(elems[0].toByteArray()));
                    return;
                case 15:
                    throw new IOException("PKCS9 SMIMECapability attribute not supported.");
                case 16:
                    this.value = new SigningCertificateInfo(elems[0].toByteArray());
                    return;
                case 17:
                    this.value = elems[0].toByteArray();
                    return;
                default:
                    return;
            }
        }
        throw new IOException("Excess data parsing PKCS9Attribute");
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream temp = new DerOutputStream();
        temp.putOID(this.oid);
        switch (this.index) {
            case -1:
                temp.write((byte[]) this.value);
                break;
            case 1:
            case 2:
                String[] values = (String[]) this.value;
                DerOutputStream[] temps = new DerOutputStream[values.length];
                for (int i10 = 0; i10 < values.length; i10++) {
                    temps[i10] = new DerOutputStream();
                    temps[i10].putIA5String(values[i10]);
                }
                temp.putOrderedSetOf((byte) 49, temps);
                break;
            case 3:
                DerOutputStream temp2 = new DerOutputStream();
                temp2.putOID((ObjectIdentifier) this.value);
                temp.write((byte) 49, temp2.toByteArray());
                break;
            case 4:
                DerOutputStream temp22 = new DerOutputStream();
                temp22.putOctetString((byte[]) this.value);
                temp.write((byte) 49, temp22.toByteArray());
                break;
            case 5:
                DerOutputStream temp23 = new DerOutputStream();
                temp23.putUTCTime((Date) this.value);
                temp.write((byte) 49, temp23.toByteArray());
                break;
            case 6:
                temp.putOrderedSetOf((byte) 49, (DerEncoder[]) this.value);
                break;
            case 7:
                DerOutputStream temp24 = new DerOutputStream();
                temp24.putPrintableString((String) this.value);
                temp.write((byte) 49, temp24.toByteArray());
                break;
            case 8:
                String[] values2 = (String[]) this.value;
                DerOutputStream[] temps2 = new DerOutputStream[values2.length];
                for (int i11 = 0; i11 < values2.length; i11++) {
                    temps2[i11] = new DerOutputStream();
                    temps2[i11].putPrintableString(values2[i11]);
                }
                temp.putOrderedSetOf((byte) 49, temps2);
                break;
            case 9:
                throw new IOException("PKCS9 extended-certificate attribute not supported.");
            case 10:
                throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
            case 11:
            case 12:
                throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
            case 13:
                throw new IOException("PKCS9 attribute #13 not supported.");
            case 14:
                DerOutputStream temp25 = new DerOutputStream();
                CertificateExtensions exts = (CertificateExtensions) this.value;
                try {
                    exts.encode(temp25, true);
                    temp.write((byte) 49, temp25.toByteArray());
                    break;
                } catch (CertificateException ex) {
                    throw new IOException(ex.toString());
                }
            case 15:
                throw new IOException("PKCS9 attribute #15 not supported.");
            case 16:
                throw new IOException("PKCS9 SigningCertificate attribute not supported.");
            case 17:
                temp.write((byte) 49, (byte[]) this.value);
                break;
        }
        DerOutputStream derOut = new DerOutputStream();
        derOut.write((byte) 48, temp.toByteArray());
        out.write(derOut.toByteArray());
    }

    public boolean isKnown() {
        return this.index != -1;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isSingleValued() {
        int i10 = this.index;
        return i10 == -1 || SINGLE_VALUED[i10];
    }

    public ObjectIdentifier getOID() {
        return this.oid;
    }

    public String getName() {
        int i10 = this.index;
        if (i10 == -1) {
            return this.oid.toString();
        }
        return OID_NAME_TABLE.get(PKCS9_OIDS[i10]);
    }

    public static ObjectIdentifier getOID(String name) {
        return NAME_OID_TABLE.get(name.toLowerCase(Locale.ENGLISH));
    }

    public static String getName(ObjectIdentifier oid) {
        return OID_NAME_TABLE.get(oid);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer(100);
        buf.append("[");
        int i10 = this.index;
        if (i10 == -1) {
            buf.append(this.oid.toString());
        } else {
            buf.append(OID_NAME_TABLE.get(PKCS9_OIDS[i10]));
        }
        buf.append(": ");
        int i11 = this.index;
        if (i11 == -1 || SINGLE_VALUED[i11]) {
            Object obj = this.value;
            if (obj instanceof byte[]) {
                HexDumpEncoder hexDump = new HexDumpEncoder();
                buf.append(hexDump.encodeBuffer((byte[]) this.value));
            } else {
                buf.append(obj.toString());
            }
            buf.append("]");
            return buf.toString();
        }
        boolean first = true;
        Object[] values = (Object[]) this.value;
        for (Object obj2 : values) {
            if (first) {
                first = false;
            } else {
                buf.append(", ");
            }
            buf.append(obj2.toString());
        }
        return buf.toString();
    }

    static int indexOf(Object obj, Object[] a10, int start) {
        for (int i10 = start; i10 < a10.length; i10++) {
            if (obj.equals(a10[i10])) {
                return i10;
            }
        }
        return -1;
    }

    private void throwSingleValuedException() throws IOException {
        throw new IOException("Single-value attribute " + ((Object) this.oid) + " (" + getName() + ") has multiple values.");
    }

    private void throwTagException(Byte tag) throws IOException {
        Byte[] expectedTags = PKCS9_VALUE_TAGS[this.index];
        StringBuffer msg = new StringBuffer(100);
        msg.append("Value of attribute ");
        msg.append(this.oid.toString());
        msg.append(" (");
        msg.append(getName());
        msg.append(") has wrong tag: ");
        msg.append(tag.toString());
        msg.append(".  Expected tags: ");
        msg.append(expectedTags[0].toString());
        for (int i10 = 1; i10 < expectedTags.length; i10++) {
            msg.append(", ");
            msg.append(expectedTags[i10].toString());
        }
        msg.append(".");
        throw new IOException(msg.toString());
    }
}
