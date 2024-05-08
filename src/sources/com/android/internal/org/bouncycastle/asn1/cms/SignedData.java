package com.android.internal.org.bouncycastle.asn1.cms;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.BERSequence;
import com.android.internal.org.bouncycastle.asn1.BERSet;
import com.android.internal.org.bouncycastle.asn1.BERTaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SignedData extends ASN1Object {
    private static final ASN1Integer VERSION_1 = new ASN1Integer(1);
    private static final ASN1Integer VERSION_3 = new ASN1Integer(3);
    private static final ASN1Integer VERSION_4 = new ASN1Integer(4);
    private static final ASN1Integer VERSION_5 = new ASN1Integer(5);
    private ASN1Set certificates;
    private boolean certsBer;
    private ContentInfo contentInfo;
    private ASN1Set crls;
    private boolean crlsBer;
    private ASN1Set digestAlgorithms;
    private ASN1Set signerInfos;
    private ASN1Integer version;

    public static SignedData getInstance(Object o10) {
        if (o10 instanceof SignedData) {
            return (SignedData) o10;
        }
        if (o10 != null) {
            return new SignedData(ASN1Sequence.getInstance(o10));
        }
        return null;
    }

    public SignedData(ASN1Set digestAlgorithms, ContentInfo contentInfo, ASN1Set certificates, ASN1Set crls, ASN1Set signerInfos) {
        this.version = calculateVersion(contentInfo.getContentType(), certificates, crls, signerInfos);
        this.digestAlgorithms = digestAlgorithms;
        this.contentInfo = contentInfo;
        this.certificates = certificates;
        this.crls = crls;
        this.signerInfos = signerInfos;
        this.crlsBer = crls instanceof BERSet;
        this.certsBer = certificates instanceof BERSet;
    }

    private ASN1Integer calculateVersion(ASN1ObjectIdentifier contentOid, ASN1Set certs, ASN1Set crls, ASN1Set signerInfs) {
        boolean otherCert = false;
        boolean otherCrl = false;
        boolean attrCertV1Found = false;
        boolean attrCertV2Found = false;
        if (certs != null) {
            Enumeration en = certs.getObjects();
            while (en.hasMoreElements()) {
                Object obj = en.nextElement();
                if (obj instanceof ASN1TaggedObject) {
                    ASN1TaggedObject tagged = ASN1TaggedObject.getInstance(obj);
                    if (tagged.getTagNo() == 1) {
                        attrCertV1Found = true;
                    } else if (tagged.getTagNo() == 2) {
                        attrCertV2Found = true;
                    } else if (tagged.getTagNo() == 3) {
                        otherCert = true;
                    }
                }
            }
        }
        if (otherCert) {
            return new ASN1Integer(5L);
        }
        if (crls != null) {
            Enumeration en2 = crls.getObjects();
            while (en2.hasMoreElements()) {
                if (en2.nextElement() instanceof ASN1TaggedObject) {
                    otherCrl = true;
                }
            }
        }
        if (otherCrl) {
            return VERSION_5;
        }
        if (attrCertV2Found) {
            return VERSION_4;
        }
        if (attrCertV1Found) {
            return VERSION_3;
        }
        if (checkForVersion3(signerInfs)) {
            return VERSION_3;
        }
        if (!CMSObjectIdentifiers.data.equals((ASN1Primitive) contentOid)) {
            return VERSION_3;
        }
        return VERSION_1;
    }

    private boolean checkForVersion3(ASN1Set signerInfs) {
        Enumeration e2 = signerInfs.getObjects();
        while (e2.hasMoreElements()) {
            SignerInfo s2 = SignerInfo.getInstance(e2.nextElement());
            if (s2.getVersion().intValueExact() == 3) {
                return true;
            }
        }
        return false;
    }

    private SignedData(ASN1Sequence seq) {
        Enumeration e2 = seq.getObjects();
        this.version = ASN1Integer.getInstance(e2.nextElement());
        this.digestAlgorithms = (ASN1Set) e2.nextElement();
        this.contentInfo = ContentInfo.getInstance(e2.nextElement());
        while (e2.hasMoreElements()) {
            ASN1Primitive o10 = (ASN1Primitive) e2.nextElement();
            if (o10 instanceof ASN1TaggedObject) {
                ASN1TaggedObject tagged = (ASN1TaggedObject) o10;
                switch (tagged.getTagNo()) {
                    case 0:
                        this.certsBer = tagged instanceof BERTaggedObject;
                        this.certificates = ASN1Set.getInstance(tagged, false);
                        break;
                    case 1:
                        this.crlsBer = tagged instanceof BERTaggedObject;
                        this.crls = ASN1Set.getInstance(tagged, false);
                        break;
                    default:
                        throw new IllegalArgumentException("unknown tag value " + tagged.getTagNo());
                }
            } else {
                this.signerInfos = (ASN1Set) o10;
            }
        }
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public ContentInfo getEncapContentInfo() {
        return this.contentInfo;
    }

    public ASN1Set getCertificates() {
        return this.certificates;
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(6);
        v2.add(this.version);
        v2.add(this.digestAlgorithms);
        v2.add(this.contentInfo);
        ASN1Set aSN1Set = this.certificates;
        if (aSN1Set != null) {
            if (this.certsBer) {
                v2.add(new BERTaggedObject(false, 0, aSN1Set));
            } else {
                v2.add(new DERTaggedObject(false, 0, aSN1Set));
            }
        }
        ASN1Set aSN1Set2 = this.crls;
        if (aSN1Set2 != null) {
            if (this.crlsBer) {
                v2.add(new BERTaggedObject(false, 1, aSN1Set2));
            } else {
                v2.add(new DERTaggedObject(false, 1, aSN1Set2));
            }
        }
        v2.add(this.signerInfos);
        return new BERSequence(v2);
    }
}
