package com.android.internal.org.bouncycastle.asn1.x500;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERSet;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RDN extends ASN1Object {
    private ASN1Set values;

    private RDN(ASN1Set values) {
        this.values = values;
    }

    public static RDN getInstance(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        if (obj != null) {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public RDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        ASN1EncodableVector v2 = new ASN1EncodableVector(2);
        v2.add(oid);
        v2.add(value);
        this.values = new DERSet(new DERSequence(v2));
    }

    public RDN(AttributeTypeAndValue attrTAndV) {
        this.values = new DERSet(attrTAndV);
    }

    public RDN(AttributeTypeAndValue[] aAndVs) {
        this.values = new DERSet(aAndVs);
    }

    public boolean isMultiValued() {
        return this.values.size() > 1;
    }

    public int size() {
        return this.values.size();
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[this.values.size()];
        for (int i10 = 0; i10 != tmp.length; i10++) {
            tmp[i10] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i10));
        }
        return tmp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int collectAttributeTypes(ASN1ObjectIdentifier[] oids, int oidsOff) {
        int count = this.values.size();
        for (int i10 = 0; i10 < count; i10++) {
            AttributeTypeAndValue attr = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i10));
            oids[oidsOff + i10] = attr.getType();
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean containsAttributeType(ASN1ObjectIdentifier attributeType) {
        int count = this.values.size();
        for (int i10 = 0; i10 < count; i10++) {
            AttributeTypeAndValue attr = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i10));
            if (attr.getType().equals((ASN1Primitive) attributeType)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
