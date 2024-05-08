package com.android.internal.org.bouncycastle.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralNames;
import com.android.internal.org.bouncycastle.asn1.x509.Holder;
import com.android.internal.org.bouncycastle.asn1.x509.IssuerSerial;
import com.android.internal.org.bouncycastle.asn1.x509.ObjectDigestInfo;
import com.android.internal.org.bouncycastle.jce.PrincipalUtil;
import com.android.internal.org.bouncycastle.jce.X509Principal;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Selector;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AttributeCertificateHolder implements CertSelector, Selector {
    final Holder holder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributeCertificateHolder(ASN1Sequence seq) {
        this.holder = Holder.getInstance(seq);
    }

    public AttributeCertificateHolder(X509Principal issuerName, BigInteger serialNumber) {
        this.holder = new Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence(new GeneralName(issuerName))), new ASN1Integer(serialNumber)));
    }

    public AttributeCertificateHolder(X500Principal issuerName, BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
    }

    public AttributeCertificateHolder(X509Certificate cert) throws CertificateParsingException {
        try {
            X509Principal name = PrincipalUtil.getIssuerX509Principal(cert);
            this.holder = new Holder(new IssuerSerial(generateGeneralNames(name), new ASN1Integer(cert.getSerialNumber())));
        } catch (Exception e2) {
            throw new CertificateParsingException(e2.getMessage());
        }
    }

    public AttributeCertificateHolder(X509Principal principal) {
        this.holder = new Holder(generateGeneralNames(principal));
    }

    public AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
    }

    public AttributeCertificateHolder(int digestedObjectType, String digestAlgorithm, String otherObjectTypeID, byte[] objectDigest) {
        this.holder = new Holder(new ObjectDigestInfo(digestedObjectType, new ASN1ObjectIdentifier(otherObjectTypeID), new AlgorithmIdentifier(new ASN1ObjectIdentifier(digestAlgorithm)), Arrays.clone(objectDigest)));
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
        }
        return -1;
    }

    public String getDigestAlgorithm() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestAlgorithm().getAlgorithm().getId();
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public String getOtherObjectTypeID() {
        if (this.holder.getObjectDigestInfo() != null) {
            this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
            return null;
        }
        return null;
    }

    private GeneralNames generateGeneralNames(X509Principal principal) {
        return GeneralNames.getInstance(new DERSequence(new GeneralName(principal)));
    }

    private boolean matchesDN(X509Principal subject, GeneralNames targets) {
        GeneralName[] names = targets.getNames();
        for (int i10 = 0; i10 != names.length; i10++) {
            GeneralName gn = names[i10];
            if (gn.getTagNo() == 4) {
                try {
                    if (new X509Principal(gn.getName().toASN1Primitive().getEncoded()).equals(subject)) {
                        return true;
                    }
                } catch (IOException e2) {
                }
            }
        }
        return false;
    }

    private Object[] getNames(GeneralName[] names) {
        List l10 = new ArrayList(names.length);
        for (int i10 = 0; i10 != names.length; i10++) {
            if (names[i10].getTagNo() == 4) {
                try {
                    l10.add(new X500Principal(names[i10].getName().toASN1Primitive().getEncoded()));
                } catch (IOException e2) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        int i11 = l10.size();
        return l10.toArray(new Object[i11]);
    }

    private Principal[] getPrincipals(GeneralNames names) {
        Object[] p10 = getNames(names.getNames());
        List l10 = new ArrayList();
        for (int i10 = 0; i10 != p10.length; i10++) {
            if (p10[i10] instanceof Principal) {
                l10.add(p10[i10]);
            }
        }
        int i11 = l10.size();
        return (Principal[]) l10.toArray(new Principal[i11]);
    }

    public Principal[] getEntityNames() {
        if (this.holder.getEntityName() != null) {
            return getPrincipals(this.holder.getEntityName());
        }
        return null;
    }

    public Principal[] getIssuer() {
        if (this.holder.getBaseCertificateID() != null) {
            return getPrincipals(this.holder.getBaseCertificateID().getIssuer());
        }
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    @Override // java.security.cert.CertSelector, com.android.internal.org.bouncycastle.util.Selector
    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.holder.toASN1Primitive());
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate cert) {
        if (!(cert instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Cert = (X509Certificate) cert;
        try {
            if (this.holder.getBaseCertificateID() != null) {
                return this.holder.getBaseCertificateID().getSerial().hasValue(x509Cert.getSerialNumber()) && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), this.holder.getBaseCertificateID().getIssuer());
            }
            if (this.holder.getEntityName() != null && matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert), this.holder.getEntityName())) {
                return true;
            }
            if (this.holder.getObjectDigestInfo() == null) {
                return false;
            }
            try {
                MessageDigest md2 = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
                switch (getDigestedObjectType()) {
                    case 0:
                        md2.update(cert.getPublicKey().getEncoded());
                        break;
                    case 1:
                        md2.update(cert.getEncoded());
                        break;
                }
                Arrays.areEqual(md2.digest(), getObjectDigest());
                return false;
            } catch (Exception e2) {
                return false;
            }
        } catch (CertificateEncodingException e10) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        AttributeCertificateHolder other = (AttributeCertificateHolder) obj;
        return this.holder.equals(other.holder);
    }

    public int hashCode() {
        return this.holder.hashCode();
    }

    @Override // com.android.internal.org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        return match((Certificate) obj);
    }
}
