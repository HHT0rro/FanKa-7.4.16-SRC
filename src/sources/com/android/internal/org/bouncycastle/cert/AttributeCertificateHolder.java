package com.android.internal.org.bouncycastle.cert;

import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralNames;
import com.android.internal.org.bouncycastle.asn1.x509.Holder;
import com.android.internal.org.bouncycastle.asn1.x509.IssuerSerial;
import com.android.internal.org.bouncycastle.asn1.x509.ObjectDigestInfo;
import com.android.internal.org.bouncycastle.operator.DigestCalculator;
import com.android.internal.org.bouncycastle.operator.DigestCalculatorProvider;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Selector;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AttributeCertificateHolder implements Selector {
    private static DigestCalculatorProvider digestCalculatorProvider;
    final Holder holder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributeCertificateHolder(ASN1Sequence seq) {
        this.holder = Holder.getInstance(seq);
    }

    public AttributeCertificateHolder(X500Name issuerName, BigInteger serialNumber) {
        this.holder = new Holder(new IssuerSerial(generateGeneralNames(issuerName), new ASN1Integer(serialNumber)));
    }

    public AttributeCertificateHolder(X509CertificateHolder cert) {
        this.holder = new Holder(new IssuerSerial(generateGeneralNames(cert.getIssuer()), new ASN1Integer(cert.getSerialNumber())));
    }

    public AttributeCertificateHolder(X500Name principal) {
        this.holder = new Holder(generateGeneralNames(principal));
    }

    public AttributeCertificateHolder(int digestedObjectType, ASN1ObjectIdentifier digestAlgorithm, ASN1ObjectIdentifier otherObjectTypeID, byte[] objectDigest) {
        this.holder = new Holder(new ObjectDigestInfo(digestedObjectType, otherObjectTypeID, new AlgorithmIdentifier(digestAlgorithm), Arrays.clone(objectDigest)));
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
        }
        return -1;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestAlgorithm();
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        if (this.holder.getObjectDigestInfo() != null) {
            new ASN1ObjectIdentifier(this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId());
            return null;
        }
        return null;
    }

    private GeneralNames generateGeneralNames(X500Name principal) {
        return new GeneralNames(new GeneralName(principal));
    }

    private boolean matchesDN(X500Name subject, GeneralNames targets) {
        GeneralName[] names = targets.getNames();
        for (int i10 = 0; i10 != names.length; i10++) {
            GeneralName gn = names[i10];
            if (gn.getTagNo() == 4 && X500Name.getInstance(gn.getName()).equals(subject)) {
                return true;
            }
        }
        return false;
    }

    private X500Name[] getPrincipals(GeneralName[] names) {
        List l10 = new ArrayList(names.length);
        for (int i10 = 0; i10 != names.length; i10++) {
            if (names[i10].getTagNo() == 4) {
                l10.add(X500Name.getInstance(names[i10].getName()));
            }
        }
        int i11 = l10.size();
        return (X500Name[]) l10.toArray(new X500Name[i11]);
    }

    public X500Name[] getEntityNames() {
        if (this.holder.getEntityName() != null) {
            return getPrincipals(this.holder.getEntityName().getNames());
        }
        return null;
    }

    public X500Name[] getIssuer() {
        if (this.holder.getBaseCertificateID() != null) {
            return getPrincipals(this.holder.getBaseCertificateID().getIssuer().getNames());
        }
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.util.Selector
    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.holder.toASN1Primitive());
    }

    @Override // com.android.internal.org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509Cert = (X509CertificateHolder) obj;
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().hasValue(x509Cert.getSerialNumber()) && matchesDN(x509Cert.getIssuer(), this.holder.getBaseCertificateID().getIssuer());
        }
        if (this.holder.getEntityName() != null && matchesDN(x509Cert.getSubject(), this.holder.getEntityName())) {
            return true;
        }
        if (this.holder.getObjectDigestInfo() == null) {
            return false;
        }
        try {
            DigestCalculator digCalc = digestCalculatorProvider.get(this.holder.getObjectDigestInfo().getDigestAlgorithm());
            OutputStream digOut = digCalc.getOutputStream();
            switch (getDigestedObjectType()) {
                case 0:
                    digOut.write(x509Cert.getSubjectPublicKeyInfo().getEncoded());
                    break;
                case 1:
                    digOut.write(x509Cert.getEncoded());
                    break;
            }
            digOut.close();
            Arrays.areEqual(digCalc.getDigest(), getObjectDigest());
            return false;
        } catch (Exception e2) {
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

    public static void setDigestCalculatorProvider(DigestCalculatorProvider digCalcProvider) {
        digestCalculatorProvider = digCalcProvider;
    }
}
