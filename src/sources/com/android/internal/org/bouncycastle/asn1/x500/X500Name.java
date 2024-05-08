package com.android.internal.org.bouncycastle.asn1.x500;

import com.android.internal.org.bouncycastle.asn1.ASN1Choice;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x500.style.BCStyle;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X500Name extends ASN1Object implements ASN1Choice {
    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private DERSequence rdnSeq;
    private RDN[] rdns;
    private X500NameStyle style;

    public X500Name(X500NameStyle style, X500Name name) {
        this.style = style;
        this.rdns = name.rdns;
        this.rdnSeq = name.rdnSeq;
    }

    public static X500Name getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, true));
    }

    public static X500Name getInstance(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj != null) {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static X500Name getInstance(X500NameStyle style, Object obj) {
        if (obj instanceof X500Name) {
            return new X500Name(style, (X500Name) obj);
        }
        if (obj != null) {
            return new X500Name(style, ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private X500Name(ASN1Sequence seq) {
        this(defaultStyle, seq);
    }

    private X500Name(X500NameStyle style, ASN1Sequence seq) {
        this.style = style;
        this.rdns = new RDN[seq.size()];
        boolean inPlace = true;
        int index = 0;
        Enumeration e2 = seq.getObjects();
        while (e2.hasMoreElements()) {
            Object element = e2.nextElement();
            RDN rdn = RDN.getInstance(element);
            inPlace &= rdn == element;
            this.rdns[index] = rdn;
            index++;
        }
        if (inPlace) {
            this.rdnSeq = DERSequence.convert(seq);
        } else {
            this.rdnSeq = new DERSequence(this.rdns);
        }
    }

    public X500Name(RDN[] rDNs) {
        this(defaultStyle, rDNs);
    }

    public X500Name(X500NameStyle style, RDN[] rDNs) {
        this.style = style;
        RDN[] rdnArr = (RDN[]) rDNs.clone();
        this.rdns = rdnArr;
        this.rdnSeq = new DERSequence(rdnArr);
    }

    public X500Name(String dirName) {
        this(defaultStyle, dirName);
    }

    public X500Name(X500NameStyle style, String dirName) {
        this(style.fromString(dirName));
        this.style = style;
    }

    public RDN[] getRDNs() {
        return (RDN[]) this.rdns.clone();
    }

    public ASN1ObjectIdentifier[] getAttributeTypes() {
        int count = this.rdns.length;
        int totalSize = 0;
        for (int i10 = 0; i10 < count; i10++) {
            RDN rdn = this.rdns[i10];
            totalSize += rdn.size();
        }
        ASN1ObjectIdentifier[] oids = new ASN1ObjectIdentifier[totalSize];
        int oidsOff = 0;
        for (int i11 = 0; i11 < count; i11++) {
            RDN rdn2 = this.rdns[i11];
            oidsOff += rdn2.collectAttributeTypes(oids, oidsOff);
        }
        return oids;
    }

    public RDN[] getRDNs(ASN1ObjectIdentifier attributeType) {
        RDN[] res = new RDN[this.rdns.length];
        int count = 0;
        int i10 = 0;
        while (true) {
            RDN[] rdnArr = this.rdns;
            if (i10 == rdnArr.length) {
                break;
            }
            RDN rdn = rdnArr[i10];
            if (rdn.containsAttributeType(attributeType)) {
                res[count] = rdn;
                count++;
            }
            i10++;
        }
        int i11 = res.length;
        if (count < i11) {
            RDN[] tmp = new RDN[count];
            System.arraycopy(res, 0, tmp, 0, tmp.length);
            return tmp;
        }
        return res;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.rdnSeq;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated) {
            return this.hashCodeValue;
        }
        this.isHashCodeCalculated = true;
        int calculateHashCode = this.style.calculateHashCode(this);
        this.hashCodeValue = calculateHashCode;
        return calculateHashCode;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Primitive derO = ((ASN1Encodable) obj).toASN1Primitive();
        if (toASN1Primitive().equals(derO)) {
            return true;
        }
        try {
            return this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((ASN1Encodable) obj).toASN1Primitive())));
        } catch (Exception e2) {
            return false;
        }
    }

    public String toString() {
        return this.style.toString(this);
    }

    public static void setDefaultStyle(X500NameStyle style) {
        if (style == null) {
            throw new NullPointerException("cannot set style to null");
        }
        defaultStyle = style;
    }

    public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }
}
