package com.android.internal.org.bouncycastle.asn1.cms;

import com.android.internal.org.bouncycastle.asn1.ASN1Choice;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SignerIdentifier extends ASN1Object implements ASN1Choice {

    /* renamed from: id, reason: collision with root package name */
    private ASN1Encodable f9161id;

    public SignerIdentifier(IssuerAndSerialNumber id2) {
        this.f9161id = id2;
    }

    public SignerIdentifier(ASN1OctetString id2) {
        this.f9161id = new DERTaggedObject(false, 0, id2);
    }

    public SignerIdentifier(ASN1Primitive id2) {
        this.f9161id = id2;
    }

    public static SignerIdentifier getInstance(Object o10) {
        if (o10 == null || (o10 instanceof SignerIdentifier)) {
            return (SignerIdentifier) o10;
        }
        if (o10 instanceof IssuerAndSerialNumber) {
            return new SignerIdentifier((IssuerAndSerialNumber) o10);
        }
        if (o10 instanceof ASN1OctetString) {
            return new SignerIdentifier((ASN1OctetString) o10);
        }
        if (o10 instanceof ASN1Primitive) {
            return new SignerIdentifier((ASN1Primitive) o10);
        }
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: " + o10.getClass().getName());
    }

    public boolean isTagged() {
        return this.f9161id instanceof ASN1TaggedObject;
    }

    public ASN1Encodable getId() {
        ASN1Encodable aSN1Encodable = this.f9161id;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            return ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Encodable, false);
        }
        return aSN1Encodable;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f9161id.toASN1Primitive();
    }
}
