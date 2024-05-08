package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import sun.misc.HexDumpEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CertInfo implements CertAttrSet<String> {
    public static final String ALGORITHM_ID = "algorithmID";
    private static final int ATTR_ALGORITHM = 3;
    private static final int ATTR_EXTENSIONS = 10;
    private static final int ATTR_ISSUER = 4;
    private static final int ATTR_ISSUER_ID = 8;
    private static final int ATTR_KEY = 7;
    private static final int ATTR_SERIAL = 2;
    private static final int ATTR_SUBJECT = 6;
    private static final int ATTR_SUBJECT_ID = 9;
    private static final int ATTR_VALIDITY = 5;
    private static final int ATTR_VERSION = 1;
    public static final String DN_NAME = "dname";
    public static final String EXTENSIONS = "extensions";
    public static final String IDENT = "x509.info";
    public static final String ISSUER = "issuer";
    public static final String ISSUER_ID = "issuerID";
    public static final String KEY = "key";
    public static final String NAME = "info";
    public static final String SERIAL_NUMBER = "serialNumber";
    public static final String SUBJECT = "subject";
    public static final String SUBJECT_ID = "subjectID";
    public static final String VALIDITY = "validity";
    public static final String VERSION = "version";
    private static final Map<String, Integer> map;
    protected CertificateVersion version = new CertificateVersion();
    protected CertificateSerialNumber serialNum = null;
    protected CertificateAlgorithmId algId = null;
    protected X500Name issuer = null;
    protected X500Name subject = null;
    protected CertificateValidity interval = null;
    protected CertificateX509Key pubKey = null;
    protected UniqueIdentity issuerUniqueId = null;
    protected UniqueIdentity subjectUniqueId = null;
    protected CertificateExtensions extensions = null;
    private byte[] rawCertInfo = null;

    static {
        HashMap hashMap = new HashMap();
        map = hashMap;
        hashMap.put("version", 1);
        hashMap.put("serialNumber", 2);
        hashMap.put("algorithmID", 3);
        hashMap.put("issuer", 4);
        hashMap.put("validity", 5);
        hashMap.put("subject", 6);
        hashMap.put("key", 7);
        hashMap.put(ISSUER_ID, 8);
        hashMap.put(SUBJECT_ID, 9);
        hashMap.put("extensions", 10);
    }

    public X509CertInfo() {
    }

    public X509CertInfo(byte[] cert) throws CertificateParsingException {
        try {
            DerValue in = new DerValue(cert);
            parse(in);
        } catch (IOException e2) {
            throw new CertificateParsingException(e2);
        }
    }

    public X509CertInfo(DerValue derVal) throws CertificateParsingException {
        try {
            parse(derVal);
        } catch (IOException e2) {
            throw new CertificateParsingException(e2);
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws CertificateException, IOException {
        if (this.rawCertInfo == null) {
            DerOutputStream tmp = new DerOutputStream();
            emit(tmp);
            this.rawCertInfo = tmp.toByteArray();
        }
        out.write((byte[]) this.rawCertInfo.clone());
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("version");
        elements.addElement("serialNumber");
        elements.addElement("algorithmID");
        elements.addElement("issuer");
        elements.addElement("validity");
        elements.addElement("subject");
        elements.addElement("key");
        elements.addElement(ISSUER_ID);
        elements.addElement(SUBJECT_ID);
        elements.addElement("extensions");
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return "info";
    }

    public byte[] getEncodedInfo() throws CertificateEncodingException {
        try {
            if (this.rawCertInfo == null) {
                DerOutputStream tmp = new DerOutputStream();
                emit(tmp);
                this.rawCertInfo = tmp.toByteArray();
            }
            return (byte[]) this.rawCertInfo.clone();
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        } catch (CertificateException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    public boolean equals(Object other) {
        if (other instanceof X509CertInfo) {
            return equals((X509CertInfo) other);
        }
        return false;
    }

    public boolean equals(X509CertInfo other) {
        byte[] bArr;
        if (this == other) {
            return true;
        }
        byte[] bArr2 = this.rawCertInfo;
        if (bArr2 == null || (bArr = other.rawCertInfo) == null || bArr2.length != bArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr3 = this.rawCertInfo;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr3[i10] != other.rawCertInfo[i10]) {
                return false;
            }
            i10++;
        }
    }

    public int hashCode() {
        int retval = 0;
        int i10 = 1;
        while (true) {
            byte[] bArr = this.rawCertInfo;
            if (i10 < bArr.length) {
                retval += bArr[i10] * i10;
                i10++;
            } else {
                return retval;
            }
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public String toString() {
        if (this.subject == null || this.pubKey == null || this.interval == null || this.issuer == null || this.algId == null || this.serialNum == null) {
            throw new NullPointerException("X.509 cert is incomplete");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        sb2.append("  " + this.version.toString() + "\n");
        sb2.append("  Subject: " + this.subject.toString() + "\n");
        sb2.append("  Signature Algorithm: " + this.algId.toString() + "\n");
        sb2.append("  Key:  " + this.pubKey.toString() + "\n");
        sb2.append("  " + this.interval.toString() + "\n");
        sb2.append("  Issuer: " + this.issuer.toString() + "\n");
        sb2.append("  " + this.serialNum.toString() + "\n");
        if (this.issuerUniqueId != null) {
            sb2.append("  Issuer Id:\n" + this.issuerUniqueId.toString() + "\n");
        }
        if (this.subjectUniqueId != null) {
            sb2.append("  Subject Id:\n" + this.subjectUniqueId.toString() + "\n");
        }
        CertificateExtensions certificateExtensions = this.extensions;
        if (certificateExtensions != null) {
            Collection<Extension> allExts = certificateExtensions.getAllExtensions();
            Extension[] exts = (Extension[]) allExts.toArray(new Extension[0]);
            sb2.append("\nCertificate Extensions: " + exts.length);
            for (int i10 = 0; i10 < exts.length; i10++) {
                sb2.append("\n[" + (i10 + 1) + "]: ");
                Extension ext = exts[i10];
                try {
                    if (OIDMap.getClass(ext.getExtensionId()) == null) {
                        sb2.append(ext.toString());
                        byte[] extValue = ext.getExtensionValue();
                        if (extValue != null) {
                            DerOutputStream out = new DerOutputStream();
                            out.putOctetString(extValue);
                            byte[] extValue2 = out.toByteArray();
                            HexDumpEncoder enc = new HexDumpEncoder();
                            sb2.append("Extension unknown: DER encoded OCTET string =\n" + enc.encodeBuffer(extValue2) + "\n");
                        }
                    } else {
                        sb2.append(ext.toString());
                    }
                } catch (Exception e2) {
                    sb2.append(", Error parsing this extension");
                }
            }
            Map<String, Extension> invalid = this.extensions.getUnparseableExtensions();
            if (!invalid.isEmpty()) {
                sb2.append("\nUnparseable certificate extensions: " + invalid.size());
                int i11 = 1;
                for (Extension ext2 : invalid.values()) {
                    sb2.append("\n[" + i11 + "]: ");
                    sb2.append((Object) ext2);
                    i11++;
                }
            }
        }
        sb2.append("\n]");
        return sb2.toString();
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object val) throws CertificateException, IOException {
        X509AttributeName attrName = new X509AttributeName(name);
        int attr = attributeMap(attrName.getPrefix());
        if (attr == 0) {
            throw new CertificateException("Attribute name not recognized: " + name);
        }
        this.rawCertInfo = null;
        String suffix = attrName.getSuffix();
        switch (attr) {
            case 1:
                if (suffix == null) {
                    setVersion(val);
                    return;
                } else {
                    this.version.set(suffix, val);
                    return;
                }
            case 2:
                if (suffix == null) {
                    setSerialNumber(val);
                    return;
                } else {
                    this.serialNum.set(suffix, val);
                    return;
                }
            case 3:
                if (suffix == null) {
                    setAlgorithmId(val);
                    return;
                } else {
                    this.algId.set(suffix, val);
                    return;
                }
            case 4:
                setIssuer(val);
                return;
            case 5:
                if (suffix == null) {
                    setValidity(val);
                    return;
                } else {
                    this.interval.set(suffix, val);
                    return;
                }
            case 6:
                setSubject(val);
                return;
            case 7:
                if (suffix == null) {
                    setKey(val);
                    return;
                } else {
                    this.pubKey.set(suffix, val);
                    return;
                }
            case 8:
                setIssuerUniqueId(val);
                return;
            case 9:
                setSubjectUniqueId(val);
                return;
            case 10:
                if (suffix == null) {
                    setExtensions(val);
                    return;
                }
                if (this.extensions == null) {
                    this.extensions = new CertificateExtensions();
                }
                this.extensions.set(suffix, val);
                return;
            default:
                return;
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws CertificateException, IOException {
        X509AttributeName attrName = new X509AttributeName(name);
        int attr = attributeMap(attrName.getPrefix());
        if (attr == 0) {
            throw new CertificateException("Attribute name not recognized: " + name);
        }
        this.rawCertInfo = null;
        String suffix = attrName.getSuffix();
        switch (attr) {
            case 1:
                if (suffix == null) {
                    this.version = null;
                    return;
                } else {
                    this.version.delete(suffix);
                    return;
                }
            case 2:
                if (suffix == null) {
                    this.serialNum = null;
                    return;
                } else {
                    this.serialNum.delete(suffix);
                    return;
                }
            case 3:
                if (suffix == null) {
                    this.algId = null;
                    return;
                } else {
                    this.algId.delete(suffix);
                    return;
                }
            case 4:
                this.issuer = null;
                return;
            case 5:
                if (suffix == null) {
                    this.interval = null;
                    return;
                } else {
                    this.interval.delete(suffix);
                    return;
                }
            case 6:
                this.subject = null;
                return;
            case 7:
                if (suffix == null) {
                    this.pubKey = null;
                    return;
                } else {
                    this.pubKey.delete(suffix);
                    return;
                }
            case 8:
                this.issuerUniqueId = null;
                return;
            case 9:
                this.subjectUniqueId = null;
                return;
            case 10:
                if (suffix == null) {
                    this.extensions = null;
                    return;
                }
                CertificateExtensions certificateExtensions = this.extensions;
                if (certificateExtensions != null) {
                    certificateExtensions.delete(suffix);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public Object get(String name) throws CertificateException, IOException {
        X509AttributeName attrName = new X509AttributeName(name);
        int attr = attributeMap(attrName.getPrefix());
        if (attr == 0) {
            throw new CertificateParsingException("Attribute name not recognized: " + name);
        }
        String suffix = attrName.getSuffix();
        switch (attr) {
            case 1:
                if (suffix == null) {
                    return this.version;
                }
                return this.version.get(suffix);
            case 2:
                if (suffix == null) {
                    return this.serialNum;
                }
                return this.serialNum.get(suffix);
            case 3:
                if (suffix == null) {
                    return this.algId;
                }
                return this.algId.get(suffix);
            case 4:
                if (suffix == null) {
                    return this.issuer;
                }
                return getX500Name(suffix, true);
            case 5:
                if (suffix == null) {
                    return this.interval;
                }
                return this.interval.get(suffix);
            case 6:
                if (suffix == null) {
                    return this.subject;
                }
                return getX500Name(suffix, false);
            case 7:
                if (suffix == null) {
                    return this.pubKey;
                }
                return this.pubKey.get(suffix);
            case 8:
                return this.issuerUniqueId;
            case 9:
                return this.subjectUniqueId;
            case 10:
                if (suffix == null) {
                    return this.extensions;
                }
                CertificateExtensions certificateExtensions = this.extensions;
                if (certificateExtensions == null) {
                    return null;
                }
                return certificateExtensions.get(suffix);
            default:
                return null;
        }
    }

    private Object getX500Name(String name, boolean getIssuer) throws IOException {
        if (name.equalsIgnoreCase("dname")) {
            return getIssuer ? this.issuer : this.subject;
        }
        if (name.equalsIgnoreCase("x500principal")) {
            return getIssuer ? this.issuer.asX500Principal() : this.subject.asX500Principal();
        }
        throw new IOException("Attribute name not recognized.");
    }

    private void parse(DerValue val) throws CertificateParsingException, IOException {
        if (val.tag != 48) {
            throw new CertificateParsingException("signed fields invalid");
        }
        this.rawCertInfo = val.toByteArray();
        DerInputStream in = val.data;
        DerValue tmp = in.getDerValue();
        if (tmp.isContextSpecific((byte) 0)) {
            this.version = new CertificateVersion(tmp);
            tmp = in.getDerValue();
        }
        this.serialNum = new CertificateSerialNumber(tmp);
        this.algId = new CertificateAlgorithmId(in);
        X500Name x500Name = new X500Name(in);
        this.issuer = x500Name;
        if (x500Name.isEmpty()) {
            throw new CertificateParsingException("Empty issuer DN not allowed in X509Certificates");
        }
        this.interval = new CertificateValidity(in);
        this.subject = new X500Name(in);
        if (this.version.compare(0) == 0 && this.subject.isEmpty()) {
            throw new CertificateParsingException("Empty subject DN not allowed in v1 certificate");
        }
        this.pubKey = new CertificateX509Key(in);
        if (in.available() != 0) {
            if (this.version.compare(0) == 0) {
                throw new CertificateParsingException("no more data allowed for version 1 certificate");
            }
            DerValue tmp2 = in.getDerValue();
            if (tmp2.isContextSpecific((byte) 1)) {
                this.issuerUniqueId = new UniqueIdentity(tmp2);
                if (in.available() == 0) {
                    return;
                } else {
                    tmp2 = in.getDerValue();
                }
            }
            if (tmp2.isContextSpecific((byte) 2)) {
                this.subjectUniqueId = new UniqueIdentity(tmp2);
                if (in.available() == 0) {
                    return;
                } else {
                    tmp2 = in.getDerValue();
                }
            }
            if (this.version.compare(2) != 0) {
                throw new CertificateParsingException("Extensions not allowed in v2 certificate");
            }
            if (tmp2.isConstructed() && tmp2.isContextSpecific((byte) 3)) {
                this.extensions = new CertificateExtensions(tmp2.data);
            }
            verifyCert(this.subject, this.extensions);
        }
    }

    private void verifyCert(X500Name subject, CertificateExtensions extensions) throws CertificateParsingException, IOException {
        if (subject.isEmpty()) {
            if (extensions == null) {
                throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and certificate has no extensions");
            }
            try {
                SubjectAlternativeNameExtension subjectAltNameExt = (SubjectAlternativeNameExtension) extensions.get(SubjectAlternativeNameExtension.NAME);
                GeneralNames names = subjectAltNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
                if (names == null || names.isEmpty()) {
                    throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and SubjectAlternativeName extension is empty");
                }
                if (!subjectAltNameExt.isCritical()) {
                    throw new CertificateParsingException("X.509 Certificate is incomplete: SubjectAlternativeName extension MUST be marked critical when subject field is empty");
                }
            } catch (IOException e2) {
                throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and SubjectAlternativeName extension is absent");
            }
        }
    }

    private void emit(DerOutputStream out) throws CertificateException, IOException {
        DerOutputStream tmp = new DerOutputStream();
        this.version.encode(tmp);
        this.serialNum.encode(tmp);
        this.algId.encode(tmp);
        if (this.version.compare(0) == 0 && this.issuer.toString() == null) {
            throw new CertificateParsingException("Null issuer DN not allowed in v1 certificate");
        }
        this.issuer.encode(tmp);
        this.interval.encode(tmp);
        if (this.version.compare(0) == 0 && this.subject.toString() == null) {
            throw new CertificateParsingException("Null subject DN not allowed in v1 certificate");
        }
        this.subject.encode(tmp);
        this.pubKey.encode(tmp);
        UniqueIdentity uniqueIdentity = this.issuerUniqueId;
        if (uniqueIdentity != null) {
            uniqueIdentity.encode(tmp, DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1));
        }
        UniqueIdentity uniqueIdentity2 = this.subjectUniqueId;
        if (uniqueIdentity2 != null) {
            uniqueIdentity2.encode(tmp, DerValue.createTag(Byte.MIN_VALUE, false, (byte) 2));
        }
        CertificateExtensions certificateExtensions = this.extensions;
        if (certificateExtensions != null) {
            certificateExtensions.encode(tmp);
        }
        out.write((byte) 48, tmp);
    }

    private int attributeMap(String name) {
        Integer num = map.get(name);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private void setVersion(Object val) throws CertificateException {
        if (!(val instanceof CertificateVersion)) {
            throw new CertificateException("Version class type invalid.");
        }
        this.version = (CertificateVersion) val;
    }

    private void setSerialNumber(Object val) throws CertificateException {
        if (!(val instanceof CertificateSerialNumber)) {
            throw new CertificateException("SerialNumber class type invalid.");
        }
        this.serialNum = (CertificateSerialNumber) val;
    }

    private void setAlgorithmId(Object val) throws CertificateException {
        if (!(val instanceof CertificateAlgorithmId)) {
            throw new CertificateException("AlgorithmId class type invalid.");
        }
        this.algId = (CertificateAlgorithmId) val;
    }

    private void setIssuer(Object val) throws CertificateException {
        if (!(val instanceof X500Name)) {
            throw new CertificateException("Issuer class type invalid.");
        }
        this.issuer = (X500Name) val;
    }

    private void setValidity(Object val) throws CertificateException {
        if (!(val instanceof CertificateValidity)) {
            throw new CertificateException("CertificateValidity class type invalid.");
        }
        this.interval = (CertificateValidity) val;
    }

    private void setSubject(Object val) throws CertificateException {
        if (!(val instanceof X500Name)) {
            throw new CertificateException("Subject class type invalid.");
        }
        this.subject = (X500Name) val;
    }

    private void setKey(Object val) throws CertificateException {
        if (!(val instanceof CertificateX509Key)) {
            throw new CertificateException("Key class type invalid.");
        }
        this.pubKey = (CertificateX509Key) val;
    }

    private void setIssuerUniqueId(Object val) throws CertificateException {
        if (this.version.compare(1) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(val instanceof UniqueIdentity)) {
            throw new CertificateException("IssuerUniqueId class type invalid.");
        }
        this.issuerUniqueId = (UniqueIdentity) val;
    }

    private void setSubjectUniqueId(Object val) throws CertificateException {
        if (this.version.compare(1) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(val instanceof UniqueIdentity)) {
            throw new CertificateException("SubjectUniqueId class type invalid.");
        }
        this.subjectUniqueId = (UniqueIdentity) val;
    }

    private void setExtensions(Object val) throws CertificateException {
        if (this.version.compare(2) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(val instanceof CertificateExtensions)) {
            throw new CertificateException("Extensions class type invalid.");
        }
        this.extensions = (CertificateExtensions) val;
    }
}
