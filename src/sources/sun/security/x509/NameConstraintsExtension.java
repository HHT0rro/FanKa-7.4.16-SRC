package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NameConstraintsExtension extends Extension implements CertAttrSet<String>, Cloneable {
    public static final String EXCLUDED_SUBTREES = "excluded_subtrees";
    public static final String IDENT = "x509.info.extensions.NameConstraints";
    public static final String NAME = "NameConstraints";
    public static final String PERMITTED_SUBTREES = "permitted_subtrees";
    private static final byte TAG_EXCLUDED = 1;
    private static final byte TAG_PERMITTED = 0;
    private GeneralSubtrees excluded;
    private boolean hasMax;
    private boolean hasMin;
    private boolean minMaxValid;
    private GeneralSubtrees permitted;

    private void calcMinMax() throws IOException {
        this.hasMin = false;
        this.hasMax = false;
        if (this.excluded != null) {
            for (int i10 = 0; i10 < this.excluded.size(); i10++) {
                GeneralSubtree subtree = this.excluded.get(i10);
                if (subtree.getMinimum() != 0) {
                    this.hasMin = true;
                }
                if (subtree.getMaximum() != -1) {
                    this.hasMax = true;
                }
            }
        }
        if (this.permitted != null) {
            for (int i11 = 0; i11 < this.permitted.size(); i11++) {
                GeneralSubtree subtree2 = this.permitted.get(i11);
                if (subtree2.getMinimum() != 0) {
                    this.hasMin = true;
                }
                if (subtree2.getMaximum() != -1) {
                    this.hasMax = true;
                }
            }
        }
        this.minMaxValid = true;
    }

    private void encodeThis() throws IOException {
        this.minMaxValid = false;
        if (this.permitted == null && this.excluded == null) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream seq = new DerOutputStream();
        DerOutputStream tagged = new DerOutputStream();
        if (this.permitted != null) {
            DerOutputStream tmp = new DerOutputStream();
            this.permitted.encode(tmp);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), tmp);
        }
        if (this.excluded != null) {
            DerOutputStream tmp2 = new DerOutputStream();
            this.excluded.encode(tmp2);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), tmp2);
        }
        seq.write((byte) 48, tagged);
        this.extensionValue = seq.toByteArray();
    }

    public NameConstraintsExtension(GeneralSubtrees permitted, GeneralSubtrees excluded) throws IOException {
        this.permitted = null;
        this.excluded = null;
        this.minMaxValid = false;
        this.permitted = permitted;
        this.excluded = excluded;
        this.extensionId = PKIXExtensions.NameConstraints_Id;
        this.critical = true;
        encodeThis();
    }

    public NameConstraintsExtension(Boolean critical, Object value) throws IOException {
        this.permitted = null;
        this.excluded = null;
        this.minMaxValid = false;
        this.extensionId = PKIXExtensions.NameConstraints_Id;
        this.critical = critical.booleanValue();
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for NameConstraintsExtension.");
        }
        if (val.data == null) {
            return;
        }
        while (val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            if (opt.isContextSpecific((byte) 0) && opt.isConstructed()) {
                if (this.permitted != null) {
                    throw new IOException("Duplicate permitted GeneralSubtrees in NameConstraintsExtension.");
                }
                opt.resetTag((byte) 48);
                this.permitted = new GeneralSubtrees(opt);
            } else if (opt.isContextSpecific((byte) 1) && opt.isConstructed()) {
                if (this.excluded != null) {
                    throw new IOException("Duplicate excluded GeneralSubtrees in NameConstraintsExtension.");
                }
                opt.resetTag((byte) 48);
                this.excluded = new GeneralSubtrees(opt);
            } else {
                throw new IOException("Invalid encoding of NameConstraintsExtension.");
            }
        }
        this.minMaxValid = false;
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        return super.toString() + "NameConstraints: [" + (this.permitted == null ? "" : "\n    Permitted:" + this.permitted.toString()) + (this.excluded != null ? "\n    Excluded:" + this.excluded.toString() : "") + "   ]\n";
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.NameConstraints_Id;
            this.critical = true;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            if (!(obj instanceof GeneralSubtrees)) {
                throw new IOException("Attribute value should be of type GeneralSubtrees.");
            }
            this.permitted = (GeneralSubtrees) obj;
        } else if (name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            if (!(obj instanceof GeneralSubtrees)) {
                throw new IOException("Attribute value should be of type GeneralSubtrees.");
            }
            this.excluded = (GeneralSubtrees) obj;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public GeneralSubtrees get(String name) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            return this.permitted;
        }
        if (name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            return this.excluded;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            this.permitted = null;
        } else if (name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            this.excluded = null;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
        }
        encodeThis();
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(PERMITTED_SUBTREES);
        elements.addElement(EXCLUDED_SUBTREES);
        return elements.elements();
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return NAME;
    }

    public void merge(NameConstraintsExtension newConstraints) throws IOException {
        GeneralSubtrees newExcluded;
        if (newConstraints == null) {
            return;
        }
        GeneralSubtrees newExcluded2 = newConstraints.get(EXCLUDED_SUBTREES);
        GeneralSubtrees generalSubtrees = this.excluded;
        if (generalSubtrees == null) {
            this.excluded = newExcluded2 != null ? (GeneralSubtrees) newExcluded2.clone() : null;
        } else if (newExcluded2 != null) {
            generalSubtrees.union(newExcluded2);
        }
        GeneralSubtrees newPermitted = newConstraints.get(PERMITTED_SUBTREES);
        GeneralSubtrees generalSubtrees2 = this.permitted;
        if (generalSubtrees2 == null) {
            this.permitted = newPermitted != null ? (GeneralSubtrees) newPermitted.clone() : null;
        } else if (newPermitted != null && (newExcluded = generalSubtrees2.intersect(newPermitted)) != null) {
            GeneralSubtrees generalSubtrees3 = this.excluded;
            if (generalSubtrees3 != null) {
                generalSubtrees3.union(newExcluded);
            } else {
                this.excluded = (GeneralSubtrees) newExcluded.clone();
            }
        }
        GeneralSubtrees generalSubtrees4 = this.permitted;
        if (generalSubtrees4 != null) {
            generalSubtrees4.reduce(this.excluded);
        }
        encodeThis();
    }

    public boolean verify(X509Certificate cert) throws IOException {
        if (cert == null) {
            throw new IOException("Certificate is null");
        }
        if (!this.minMaxValid) {
            calcMinMax();
        }
        if (this.hasMin) {
            throw new IOException("Non-zero minimum BaseDistance in name constraints not supported");
        }
        if (this.hasMax) {
            throw new IOException("Maximum BaseDistance in name constraints not supported");
        }
        X500Principal subjectPrincipal = cert.getSubjectX500Principal();
        X500Name subject = X500Name.asX500Name(subjectPrincipal);
        if (!subject.isEmpty() && !verify(subject)) {
            return false;
        }
        GeneralNames altNames = null;
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            SubjectAlternativeNameExtension altNameExt = certImpl.getSubjectAlternativeNameExtension();
            if (altNameExt != null) {
                altNames = altNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
            }
            if (altNames == null) {
                return verifyRFC822SpecialCase(subject);
            }
            for (int i10 = 0; i10 < altNames.size(); i10++) {
                GeneralNameInterface altGNI = altNames.get(i10).getName();
                if (!verify(altGNI)) {
                    return false;
                }
            }
            return true;
        } catch (CertificateException ce2) {
            throw new IOException("Unable to extract extensions from certificate: " + ce2.getMessage());
        }
    }

    public boolean verify(GeneralNameInterface name) throws IOException {
        GeneralName gn;
        GeneralNameInterface perName;
        GeneralName gn2;
        GeneralNameInterface exName;
        if (name == null) {
            throw new IOException("name is null");
        }
        GeneralSubtrees generalSubtrees = this.excluded;
        if (generalSubtrees != null && generalSubtrees.size() > 0) {
            for (int i10 = 0; i10 < this.excluded.size(); i10++) {
                GeneralSubtree gs = this.excluded.get(i10);
                if (gs != null && (gn2 = gs.getName()) != null && (exName = gn2.getName()) != null) {
                    switch (exName.constrains(name)) {
                        case 0:
                        case 1:
                            return false;
                    }
                }
            }
        }
        GeneralSubtrees generalSubtrees2 = this.permitted;
        if (generalSubtrees2 != null && generalSubtrees2.size() > 0) {
            boolean sameType = false;
            for (int i11 = 0; i11 < this.permitted.size(); i11++) {
                GeneralSubtree gs2 = this.permitted.get(i11);
                if (gs2 != null && (gn = gs2.getName()) != null && (perName = gn.getName()) != null) {
                    switch (perName.constrains(name)) {
                        case 0:
                        case 1:
                            return true;
                        case 2:
                        case 3:
                            sameType = true;
                            break;
                    }
                }
            }
            if (sameType) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyRFC822SpecialCase(X500Name subject) throws IOException {
        String attrValue;
        for (AVA ava : subject.allAvas()) {
            ObjectIdentifier attrOID = ava.getObjectIdentifier();
            if (attrOID.equals((Object) PKCS9Attribute.EMAIL_ADDRESS_OID) && (attrValue = ava.getValueString()) != null) {
                try {
                    RFC822Name emailName = new RFC822Name(attrValue);
                    if (!verify(emailName)) {
                        return false;
                    }
                } catch (IOException e2) {
                }
            }
        }
        return true;
    }

    public Object clone() {
        try {
            NameConstraintsExtension newNCE = (NameConstraintsExtension) super.clone();
            GeneralSubtrees generalSubtrees = this.permitted;
            if (generalSubtrees != null) {
                newNCE.permitted = (GeneralSubtrees) generalSubtrees.clone();
            }
            GeneralSubtrees generalSubtrees2 = this.excluded;
            if (generalSubtrees2 != null) {
                newNCE.excluded = (GeneralSubtrees) generalSubtrees2.clone();
            }
            return newNCE;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("CloneNotSupportedException while cloning NameConstraintsException. This should never happen.");
        }
    }
}
