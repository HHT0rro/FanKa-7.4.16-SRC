package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class IValue extends ASN1Object {
    private final BigInteger value;

    private IValue(ASN1Integer value) {
        int i10 = BigIntegers.intValueExact(value.getValue());
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException("value out of range");
        }
        this.value = value.getValue();
    }

    public static IValue getInstance(Object src) {
        if (src instanceof IValue) {
            return (IValue) src;
        }
        if (src != null) {
            return new IValue(ASN1Integer.getInstance(src));
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.value);
    }
}
