package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X9ECPoint extends ASN1Object {

    /* renamed from: c, reason: collision with root package name */
    private ECCurve f9186c;
    private final ASN1OctetString encoding;

    /* renamed from: p, reason: collision with root package name */
    private ECPoint f9187p;

    public X9ECPoint(ECPoint p10, boolean compressed) {
        this.f9187p = p10.normalize();
        this.encoding = new DEROctetString(p10.getEncoded(compressed));
    }

    public X9ECPoint(ECCurve c4, byte[] encoding) {
        this.f9186c = c4;
        this.encoding = new DEROctetString(Arrays.clone(encoding));
    }

    public X9ECPoint(ECCurve c4, ASN1OctetString s2) {
        this(c4, s2.getOctets());
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public synchronized ECPoint getPoint() {
        if (this.f9187p == null) {
            this.f9187p = this.f9186c.decodePoint(this.encoding.getOctets()).normalize();
        }
        return this.f9187p;
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        return octets[0] == 2 || octets[0] == 3;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
