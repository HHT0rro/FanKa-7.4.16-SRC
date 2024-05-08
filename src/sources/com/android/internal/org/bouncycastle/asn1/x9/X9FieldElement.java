package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f, reason: collision with root package name */
    protected ECFieldElement f9188f;

    public X9FieldElement(ECFieldElement f10) {
        this.f9188f = f10;
    }

    public X9FieldElement(BigInteger p10, ASN1OctetString s2) {
        this(new ECFieldElement.Fp(p10, new BigInteger(1, s2.getOctets())));
    }

    public X9FieldElement(int m10, int k12, int k22, int k32, ASN1OctetString s2) {
        this(new ECFieldElement.F2m(m10, k12, k22, k32, new BigInteger(1, s2.getOctets())));
    }

    public ECFieldElement getValue() {
        return this.f9188f;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int byteCount = converter.getByteLength(this.f9188f);
        byte[] paddedBigInteger = converter.integerToBytes(this.f9188f.toBigInteger(), byteCount);
        return new DEROctetString(paddedBigInteger);
    }
}
