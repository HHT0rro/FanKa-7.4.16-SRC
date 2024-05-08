package com.android.internal.org.bouncycastle.asn1.x500;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.x500.style.BCStyle;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X500NameBuilder {
    private Vector rdns;
    private X500NameStyle template;

    public X500NameBuilder() {
        this(BCStyle.INSTANCE);
    }

    public X500NameBuilder(X500NameStyle template) {
        this.rdns = new Vector();
        this.template = template;
    }

    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        addRDN(oid, this.template.stringToValue(oid, value));
        return this;
    }

    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        this.rdns.addElement(new RDN(oid, value));
        return this;
    }

    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        this.rdns.addElement(new RDN(attrTAndV));
        return this;
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        ASN1Encodable[] vals = new ASN1Encodable[values.length];
        for (int i10 = 0; i10 != vals.length; i10++) {
            vals[i10] = this.template.stringToValue(oids[i10], values[i10]);
        }
        return addMultiValuedRDN(oids, vals);
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
        for (int i10 = 0; i10 != oids.length; i10++) {
            avs[i10] = new AttributeTypeAndValue(oids[i10], values[i10]);
        }
        return addMultiValuedRDN(avs);
    }

    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        this.rdns.addElement(new RDN(attrTAndVs));
        return this;
    }

    public X500Name build() {
        RDN[] vals = new RDN[this.rdns.size()];
        for (int i10 = 0; i10 != vals.length; i10++) {
            vals[i10] = (RDN) this.rdns.elementAt(i10);
        }
        return new X500Name(this.template, vals);
    }
}
