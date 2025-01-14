package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IssuingDistributionPointExtension extends Extension implements CertAttrSet<String> {
    public static final String IDENT = "x509.info.extensions.IssuingDistributionPoint";
    public static final String INDIRECT_CRL = "indirect_crl";
    public static final String NAME = "IssuingDistributionPoint";
    public static final String ONLY_ATTRIBUTE_CERTS = "only_attribute_certs";
    public static final String ONLY_CA_CERTS = "only_ca_certs";
    public static final String ONLY_USER_CERTS = "only_user_certs";
    public static final String POINT = "point";
    public static final String REASONS = "reasons";
    private static final byte TAG_DISTRIBUTION_POINT = 0;
    private static final byte TAG_INDIRECT_CRL = 4;
    private static final byte TAG_ONLY_ATTRIBUTE_CERTS = 5;
    private static final byte TAG_ONLY_CA_CERTS = 2;
    private static final byte TAG_ONLY_SOME_REASONS = 3;
    private static final byte TAG_ONLY_USER_CERTS = 1;
    private DistributionPointName distributionPoint;
    private boolean hasOnlyAttributeCerts;
    private boolean hasOnlyCACerts;
    private boolean hasOnlyUserCerts;
    private boolean isIndirectCRL;
    private ReasonFlags revocationReasons;

    public IssuingDistributionPointExtension(DistributionPointName distributionPoint, ReasonFlags revocationReasons, boolean hasOnlyUserCerts, boolean hasOnlyCACerts, boolean hasOnlyAttributeCerts, boolean isIndirectCRL) throws IOException {
        this.distributionPoint = null;
        this.revocationReasons = null;
        this.hasOnlyUserCerts = false;
        this.hasOnlyCACerts = false;
        this.hasOnlyAttributeCerts = false;
        this.isIndirectCRL = false;
        if ((hasOnlyUserCerts && (hasOnlyCACerts || hasOnlyAttributeCerts)) || ((hasOnlyCACerts && (hasOnlyUserCerts || hasOnlyAttributeCerts)) || (hasOnlyAttributeCerts && (hasOnlyUserCerts || hasOnlyCACerts)))) {
            throw new IllegalArgumentException("Only one of hasOnlyUserCerts, hasOnlyCACerts, hasOnlyAttributeCerts may be set to true");
        }
        this.extensionId = PKIXExtensions.IssuingDistributionPoint_Id;
        this.critical = true;
        this.distributionPoint = distributionPoint;
        this.revocationReasons = revocationReasons;
        this.hasOnlyUserCerts = hasOnlyUserCerts;
        this.hasOnlyCACerts = hasOnlyCACerts;
        this.hasOnlyAttributeCerts = hasOnlyAttributeCerts;
        this.isIndirectCRL = isIndirectCRL;
        encodeThis();
    }

    public IssuingDistributionPointExtension(Boolean critical, Object value) throws IOException {
        this.distributionPoint = null;
        this.revocationReasons = null;
        this.hasOnlyUserCerts = false;
        this.hasOnlyCACerts = false;
        this.hasOnlyAttributeCerts = false;
        this.isIndirectCRL = false;
        this.extensionId = PKIXExtensions.IssuingDistributionPoint_Id;
        this.critical = critical.booleanValue();
        if (!(value instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for IssuingDistributionPointExtension.");
        }
        if (val.data == null || val.data.available() == 0) {
            return;
        }
        DerInputStream in = val.data;
        while (in != null && in.available() != 0) {
            DerValue opt = in.getDerValue();
            if (opt.isContextSpecific((byte) 0) && opt.isConstructed()) {
                this.distributionPoint = new DistributionPointName(opt.data.getDerValue());
            } else if (opt.isContextSpecific((byte) 1) && !opt.isConstructed()) {
                opt.resetTag((byte) 1);
                this.hasOnlyUserCerts = opt.getBoolean();
            } else if (opt.isContextSpecific((byte) 2) && !opt.isConstructed()) {
                opt.resetTag((byte) 1);
                this.hasOnlyCACerts = opt.getBoolean();
            } else if (opt.isContextSpecific((byte) 3) && !opt.isConstructed()) {
                this.revocationReasons = new ReasonFlags(opt);
            } else if (opt.isContextSpecific((byte) 4) && !opt.isConstructed()) {
                opt.resetTag((byte) 1);
                this.isIndirectCRL = opt.getBoolean();
            } else if (opt.isContextSpecific((byte) 5) && !opt.isConstructed()) {
                opt.resetTag((byte) 1);
                this.hasOnlyAttributeCerts = opt.getBoolean();
            } else {
                throw new IOException("Invalid encoding of IssuingDistributionPoint");
            }
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.IssuingDistributionPoint_Id;
            this.critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(POINT)) {
            if (!(obj instanceof DistributionPointName)) {
                throw new IOException("Attribute value should be of type DistributionPointName.");
            }
            this.distributionPoint = (DistributionPointName) obj;
        } else if (name.equalsIgnoreCase(REASONS)) {
            if (!(obj instanceof ReasonFlags)) {
                throw new IOException("Attribute value should be of type ReasonFlags.");
            }
            this.revocationReasons = (ReasonFlags) obj;
        } else if (name.equalsIgnoreCase(INDIRECT_CRL)) {
            if (!(obj instanceof Boolean)) {
                throw new IOException("Attribute value should be of type Boolean.");
            }
            this.isIndirectCRL = ((Boolean) obj).booleanValue();
        } else if (name.equalsIgnoreCase(ONLY_USER_CERTS)) {
            if (!(obj instanceof Boolean)) {
                throw new IOException("Attribute value should be of type Boolean.");
            }
            this.hasOnlyUserCerts = ((Boolean) obj).booleanValue();
        } else if (name.equalsIgnoreCase(ONLY_CA_CERTS)) {
            if (!(obj instanceof Boolean)) {
                throw new IOException("Attribute value should be of type Boolean.");
            }
            this.hasOnlyCACerts = ((Boolean) obj).booleanValue();
        } else if (name.equalsIgnoreCase(ONLY_ATTRIBUTE_CERTS)) {
            if (!(obj instanceof Boolean)) {
                throw new IOException("Attribute value should be of type Boolean.");
            }
            this.hasOnlyAttributeCerts = ((Boolean) obj).booleanValue();
        } else {
            throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:IssuingDistributionPointExtension.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Object get(String name) throws IOException {
        if (name.equalsIgnoreCase(POINT)) {
            return this.distributionPoint;
        }
        if (name.equalsIgnoreCase(INDIRECT_CRL)) {
            return Boolean.valueOf(this.isIndirectCRL);
        }
        if (name.equalsIgnoreCase(REASONS)) {
            return this.revocationReasons;
        }
        if (name.equalsIgnoreCase(ONLY_USER_CERTS)) {
            return Boolean.valueOf(this.hasOnlyUserCerts);
        }
        if (name.equalsIgnoreCase(ONLY_CA_CERTS)) {
            return Boolean.valueOf(this.hasOnlyCACerts);
        }
        if (name.equalsIgnoreCase(ONLY_ATTRIBUTE_CERTS)) {
            return Boolean.valueOf(this.hasOnlyAttributeCerts);
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:IssuingDistributionPointExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(POINT)) {
            this.distributionPoint = null;
        } else if (name.equalsIgnoreCase(INDIRECT_CRL)) {
            this.isIndirectCRL = false;
        } else if (name.equalsIgnoreCase(REASONS)) {
            this.revocationReasons = null;
        } else if (name.equalsIgnoreCase(ONLY_USER_CERTS)) {
            this.hasOnlyUserCerts = false;
        } else if (name.equalsIgnoreCase(ONLY_CA_CERTS)) {
            this.hasOnlyCACerts = false;
        } else if (name.equalsIgnoreCase(ONLY_ATTRIBUTE_CERTS)) {
            this.hasOnlyAttributeCerts = false;
        } else {
            throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:IssuingDistributionPointExtension.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(POINT);
        elements.addElement(REASONS);
        elements.addElement(ONLY_USER_CERTS);
        elements.addElement(ONLY_CA_CERTS);
        elements.addElement(ONLY_ATTRIBUTE_CERTS);
        elements.addElement(INDIRECT_CRL);
        return elements.elements();
    }

    private void encodeThis() throws IOException {
        if (this.distributionPoint == null && this.revocationReasons == null && !this.hasOnlyUserCerts && !this.hasOnlyCACerts && !this.hasOnlyAttributeCerts && !this.isIndirectCRL) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream tagged = new DerOutputStream();
        if (this.distributionPoint != null) {
            DerOutputStream tmp = new DerOutputStream();
            this.distributionPoint.encode(tmp);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), tmp);
        }
        if (this.hasOnlyUserCerts) {
            DerOutputStream tmp2 = new DerOutputStream();
            tmp2.putBoolean(this.hasOnlyUserCerts);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1), tmp2);
        }
        if (this.hasOnlyCACerts) {
            DerOutputStream tmp3 = new DerOutputStream();
            tmp3.putBoolean(this.hasOnlyCACerts);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 2), tmp3);
        }
        if (this.revocationReasons != null) {
            DerOutputStream tmp4 = new DerOutputStream();
            this.revocationReasons.encode(tmp4);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 3), tmp4);
        }
        if (this.isIndirectCRL) {
            DerOutputStream tmp5 = new DerOutputStream();
            tmp5.putBoolean(this.isIndirectCRL);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 4), tmp5);
        }
        if (this.hasOnlyAttributeCerts) {
            DerOutputStream tmp6 = new DerOutputStream();
            tmp6.putBoolean(this.hasOnlyAttributeCerts);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 5), tmp6);
        }
        DerOutputStream seq = new DerOutputStream();
        seq.write((byte) 48, tagged);
        this.extensionValue = seq.toByteArray();
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append("IssuingDistributionPoint [\n  ");
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            sb2.append((Object) distributionPointName);
        }
        ReasonFlags reasonFlags = this.revocationReasons;
        if (reasonFlags != null) {
            sb2.append((Object) reasonFlags);
        }
        if (this.hasOnlyUserCerts) {
            str = "  Only contains user certs: true";
        } else {
            str = "  Only contains user certs: false";
        }
        sb2.append(str).append("\n");
        if (this.hasOnlyCACerts) {
            str2 = "  Only contains CA certs: true";
        } else {
            str2 = "  Only contains CA certs: false";
        }
        sb2.append(str2).append("\n");
        if (this.hasOnlyAttributeCerts) {
            str3 = "  Only contains attribute certs: true";
        } else {
            str3 = "  Only contains attribute certs: false";
        }
        sb2.append(str3).append("\n");
        if (this.isIndirectCRL) {
            str4 = "  Indirect CRL: true";
        } else {
            str4 = "  Indirect CRL: false";
        }
        sb2.append(str4).append("\n");
        sb2.append("]\n");
        return sb2.toString();
    }
}
