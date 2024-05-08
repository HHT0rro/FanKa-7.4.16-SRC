package java.security;

import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.regex.Pattern;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PKCS12Attribute implements KeyStore.Entry.Attribute {
    private static final Pattern COLON_SEPARATED_HEX_PAIRS = Pattern.compile("^[0-9a-fA-F]{2}(:[0-9a-fA-F]{2})+$");
    private final byte[] encoded;
    private int hashValue = -1;
    private String name;
    private String value;

    public PKCS12Attribute(String name, String value) {
        String[] values;
        if (name == null || value == null) {
            throw new NullPointerException();
        }
        try {
            ObjectIdentifier type = new ObjectIdentifier(name);
            this.name = name;
            int length = value.length();
            if (length > 1 && value.charAt(0) == '[' && value.charAt(length - 1) == ']') {
                values = value.substring(1, length - 1).split(", ");
            } else {
                values = new String[]{value};
            }
            this.value = value;
            try {
                this.encoded = encode(type, values);
            } catch (IOException e2) {
                throw new IllegalArgumentException("Incorrect format: value", e2);
            }
        } catch (IOException e10) {
            throw new IllegalArgumentException("Incorrect format: name", e10);
        }
    }

    public PKCS12Attribute(byte[] encoded) {
        if (encoded == null) {
            throw new NullPointerException();
        }
        this.encoded = (byte[]) encoded.clone();
        try {
            parse(encoded);
        } catch (IOException e2) {
            throw new IllegalArgumentException("Incorrect format: encoded", e2);
        }
    }

    @Override // java.security.KeyStore.Entry.Attribute
    public String getName() {
        return this.name;
    }

    @Override // java.security.KeyStore.Entry.Attribute
    public String getValue() {
        return this.value;
    }

    public byte[] getEncoded() {
        return (byte[]) this.encoded.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PKCS12Attribute)) {
            return false;
        }
        return Arrays.equals(this.encoded, ((PKCS12Attribute) obj).encoded);
    }

    public int hashCode() {
        int h10 = this.hashValue;
        if (h10 == -1) {
            int h11 = Arrays.hashCode(this.encoded);
            this.hashValue = h11;
            return h11;
        }
        return h10;
    }

    public String toString() {
        return this.name + "=" + this.value;
    }

    private byte[] encode(ObjectIdentifier type, String[] values) throws IOException {
        DerOutputStream attribute = new DerOutputStream();
        attribute.putOID(type);
        DerOutputStream attrContent = new DerOutputStream();
        for (String value : values) {
            if (COLON_SEPARATED_HEX_PAIRS.matcher(value).matches()) {
                byte[] bytes = new BigInteger(value.replace(u.bD, ""), 16).toByteArray();
                if (bytes[0] == 0) {
                    bytes = Arrays.copyOfRange(bytes, 1, bytes.length);
                }
                attrContent.putOctetString(bytes);
            } else {
                attrContent.putUTF8String(value);
            }
        }
        attribute.write((byte) 49, attrContent);
        DerOutputStream attributeValue = new DerOutputStream();
        attributeValue.write((byte) 48, attribute);
        return attributeValue.toByteArray();
    }

    private void parse(byte[] encoded) throws IOException {
        DerInputStream attributeValue = new DerInputStream(encoded);
        DerValue[] attrSeq = attributeValue.getSequence(2);
        if (attrSeq.length != 2) {
            throw new IOException("Invalid length for PKCS12Attribute");
        }
        ObjectIdentifier type = attrSeq[0].getOID();
        DerInputStream attrContent = new DerInputStream(attrSeq[1].toByteArray());
        DerValue[] attrValueSet = attrContent.getSet(1);
        String[] values = new String[attrValueSet.length];
        for (int i10 = 0; i10 < attrValueSet.length; i10++) {
            if (attrValueSet[i10].tag == 4) {
                values[i10] = Debug.toString(attrValueSet[i10].getOctetString());
            } else {
                String printableString = attrValueSet[i10].getAsString();
                if (printableString != null) {
                    values[i10] = printableString;
                } else if (attrValueSet[i10].tag == 6) {
                    values[i10] = attrValueSet[i10].getOID().toString();
                } else if (attrValueSet[i10].tag == 24) {
                    values[i10] = attrValueSet[i10].getGeneralizedTime().toString();
                } else if (attrValueSet[i10].tag != 23) {
                    if (attrValueSet[i10].tag == 2) {
                        values[i10] = attrValueSet[i10].getBigInteger().toString();
                    } else if (attrValueSet[i10].tag == 1) {
                        values[i10] = String.valueOf(attrValueSet[i10].getBoolean());
                    } else {
                        values[i10] = Debug.toString(attrValueSet[i10].getDataBytes());
                    }
                } else {
                    values[i10] = attrValueSet[i10].getUTCTime().toString();
                }
            }
        }
        this.name = type.toString();
        this.value = values.length == 1 ? values[0] : Arrays.toString(values);
    }
}
