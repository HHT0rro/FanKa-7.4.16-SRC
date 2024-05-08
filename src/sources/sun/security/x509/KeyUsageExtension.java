package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyUsageExtension extends Extension implements CertAttrSet<String> {
    public static final String CRL_SIGN = "crl_sign";
    public static final String DATA_ENCIPHERMENT = "data_encipherment";
    public static final String DECIPHER_ONLY = "decipher_only";
    public static final String DIGITAL_SIGNATURE = "digital_signature";
    public static final String ENCIPHER_ONLY = "encipher_only";
    public static final String IDENT = "x509.info.extensions.KeyUsage";
    public static final String KEY_AGREEMENT = "key_agreement";
    public static final String KEY_CERTSIGN = "key_certsign";
    public static final String KEY_ENCIPHERMENT = "key_encipherment";
    public static final String NAME = "KeyUsage";
    public static final String NON_REPUDIATION = "non_repudiation";
    private boolean[] bitString;

    private void encodeThis() throws IOException {
        DerOutputStream os = new DerOutputStream();
        os.putTruncatedUnalignedBitString(new BitArray(this.bitString));
        this.extensionValue = os.toByteArray();
    }

    private boolean isSet(int position) {
        boolean[] zArr = this.bitString;
        return position < zArr.length && zArr[position];
    }

    private void set(int position, boolean val) {
        boolean[] zArr = this.bitString;
        if (position >= zArr.length) {
            boolean[] tmp = new boolean[position + 1];
            System.arraycopy((Object) zArr, 0, (Object) tmp, 0, zArr.length);
            this.bitString = tmp;
        }
        this.bitString[position] = val;
    }

    public KeyUsageExtension(byte[] bitString) throws IOException {
        this.bitString = new BitArray(bitString.length * 8, bitString).toBooleanArray();
        this.extensionId = PKIXExtensions.KeyUsage_Id;
        this.critical = true;
        encodeThis();
    }

    public KeyUsageExtension(boolean[] bitString) throws IOException {
        this.bitString = bitString;
        this.extensionId = PKIXExtensions.KeyUsage_Id;
        this.critical = true;
        encodeThis();
    }

    public KeyUsageExtension(BitArray bitString) throws IOException {
        this.bitString = bitString.toBooleanArray();
        this.extensionId = PKIXExtensions.KeyUsage_Id;
        this.critical = true;
        encodeThis();
    }

    public KeyUsageExtension(Boolean critical, Object value) throws IOException {
        this.extensionId = PKIXExtensions.KeyUsage_Id;
        this.critical = critical.booleanValue();
        byte[] extValue = (byte[]) value;
        if (extValue[0] == 4) {
            this.extensionValue = new DerValue(extValue).getOctetString();
        } else {
            this.extensionValue = extValue;
        }
        DerValue val = new DerValue(this.extensionValue);
        this.bitString = val.getUnalignedBitString().toBooleanArray();
    }

    public KeyUsageExtension() {
        this.extensionId = PKIXExtensions.KeyUsage_Id;
        this.critical = true;
        this.bitString = new boolean[0];
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (!(obj instanceof Boolean)) {
            throw new IOException("Attribute must be of type Boolean.");
        }
        boolean val = ((Boolean) obj).booleanValue();
        if (name.equalsIgnoreCase(DIGITAL_SIGNATURE)) {
            set(0, val);
        } else if (name.equalsIgnoreCase(NON_REPUDIATION)) {
            set(1, val);
        } else if (name.equalsIgnoreCase(KEY_ENCIPHERMENT)) {
            set(2, val);
        } else if (name.equalsIgnoreCase(DATA_ENCIPHERMENT)) {
            set(3, val);
        } else if (name.equalsIgnoreCase(KEY_AGREEMENT)) {
            set(4, val);
        } else if (name.equalsIgnoreCase(KEY_CERTSIGN)) {
            set(5, val);
        } else if (name.equalsIgnoreCase(CRL_SIGN)) {
            set(6, val);
        } else if (name.equalsIgnoreCase(ENCIPHER_ONLY)) {
            set(7, val);
        } else if (name.equalsIgnoreCase(DECIPHER_ONLY)) {
            set(8, val);
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:KeyUsage.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Boolean get(String name) throws IOException {
        if (name.equalsIgnoreCase(DIGITAL_SIGNATURE)) {
            return Boolean.valueOf(isSet(0));
        }
        if (name.equalsIgnoreCase(NON_REPUDIATION)) {
            return Boolean.valueOf(isSet(1));
        }
        if (name.equalsIgnoreCase(KEY_ENCIPHERMENT)) {
            return Boolean.valueOf(isSet(2));
        }
        if (name.equalsIgnoreCase(DATA_ENCIPHERMENT)) {
            return Boolean.valueOf(isSet(3));
        }
        if (name.equalsIgnoreCase(KEY_AGREEMENT)) {
            return Boolean.valueOf(isSet(4));
        }
        if (name.equalsIgnoreCase(KEY_CERTSIGN)) {
            return Boolean.valueOf(isSet(5));
        }
        if (name.equalsIgnoreCase(CRL_SIGN)) {
            return Boolean.valueOf(isSet(6));
        }
        if (name.equalsIgnoreCase(ENCIPHER_ONLY)) {
            return Boolean.valueOf(isSet(7));
        }
        if (name.equalsIgnoreCase(DECIPHER_ONLY)) {
            return Boolean.valueOf(isSet(8));
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:KeyUsage.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(DIGITAL_SIGNATURE)) {
            set(0, false);
        } else if (name.equalsIgnoreCase(NON_REPUDIATION)) {
            set(1, false);
        } else if (name.equalsIgnoreCase(KEY_ENCIPHERMENT)) {
            set(2, false);
        } else if (name.equalsIgnoreCase(DATA_ENCIPHERMENT)) {
            set(3, false);
        } else if (name.equalsIgnoreCase(KEY_AGREEMENT)) {
            set(4, false);
        } else if (name.equalsIgnoreCase(KEY_CERTSIGN)) {
            set(5, false);
        } else if (name.equalsIgnoreCase(CRL_SIGN)) {
            set(6, false);
        } else if (name.equalsIgnoreCase(ENCIPHER_ONLY)) {
            set(7, false);
        } else if (name.equalsIgnoreCase(DECIPHER_ONLY)) {
            set(8, false);
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:KeyUsage.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("KeyUsage [\n");
        if (isSet(0)) {
            sb2.append("  DigitalSignature\n");
        }
        if (isSet(1)) {
            sb2.append("  Non_repudiation\n");
        }
        if (isSet(2)) {
            sb2.append("  Key_Encipherment\n");
        }
        if (isSet(3)) {
            sb2.append("  Data_Encipherment\n");
        }
        if (isSet(4)) {
            sb2.append("  Key_Agreement\n");
        }
        if (isSet(5)) {
            sb2.append("  Key_CertSign\n");
        }
        if (isSet(6)) {
            sb2.append("  Crl_Sign\n");
        }
        if (isSet(7)) {
            sb2.append("  Encipher_Only\n");
        }
        if (isSet(8)) {
            sb2.append("  Decipher_Only\n");
        }
        sb2.append("]\n");
        return sb2.toString();
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.KeyUsage_Id;
            this.critical = true;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(DIGITAL_SIGNATURE);
        elements.addElement(NON_REPUDIATION);
        elements.addElement(KEY_ENCIPHERMENT);
        elements.addElement(DATA_ENCIPHERMENT);
        elements.addElement(KEY_AGREEMENT);
        elements.addElement(KEY_CERTSIGN);
        elements.addElement(CRL_SIGN);
        elements.addElement(ENCIPHER_ONLY);
        elements.addElement(DECIPHER_ONLY);
        return elements.elements();
    }

    public boolean[] getBits() {
        return (boolean[]) this.bitString.clone();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }
}
