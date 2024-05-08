package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.math.ec.ECAlgorithms;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.field.PolynomialExtensionField;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private ECCurve curve;
    private X9FieldID fieldID;

    /* renamed from: g, reason: collision with root package name */
    private X9ECPoint f9183g;

    /* renamed from: h, reason: collision with root package name */
    private BigInteger f9184h;

    /* renamed from: n, reason: collision with root package name */
    private BigInteger f9185n;
    private byte[] seed;

    private X9ECParameters(ASN1Sequence seq) {
        if (!(seq.getObjectAt(0) instanceof ASN1Integer) || !((ASN1Integer) seq.getObjectAt(0)).hasValue(ONE)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        this.f9185n = ((ASN1Integer) seq.getObjectAt(4)).getValue();
        if (seq.size() == 6) {
            this.f9184h = ((ASN1Integer) seq.getObjectAt(5)).getValue();
        }
        X9Curve x9c = new X9Curve(X9FieldID.getInstance(seq.getObjectAt(1)), this.f9185n, this.f9184h, ASN1Sequence.getInstance(seq.getObjectAt(2)));
        this.curve = x9c.getCurve();
        Object p10 = seq.getObjectAt(3);
        if (p10 instanceof X9ECPoint) {
            this.f9183g = (X9ECPoint) p10;
        } else {
            this.f9183g = new X9ECPoint(this.curve, (ASN1OctetString) p10);
        }
        this.seed = x9c.getSeed();
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X9ECParameters(ECCurve curve, X9ECPoint g3, BigInteger n10) {
        this(curve, g3, n10, null, null);
    }

    public X9ECParameters(ECCurve curve, X9ECPoint g3, BigInteger n10, BigInteger h10) {
        this(curve, g3, n10, h10, null);
    }

    public X9ECParameters(ECCurve curve, X9ECPoint g3, BigInteger n10, BigInteger h10, byte[] seed) {
        this.curve = curve;
        this.f9183g = g3;
        this.f9185n = n10;
        this.f9184h = h10;
        this.seed = Arrays.clone(seed);
        if (ECAlgorithms.isFpCurve(curve)) {
            this.fieldID = new X9FieldID(curve.getField().getCharacteristic());
            return;
        }
        if (ECAlgorithms.isF2mCurve(curve)) {
            PolynomialExtensionField field = (PolynomialExtensionField) curve.getField();
            int[] exponents = field.getMinimalPolynomial().getExponentsPresent();
            if (exponents.length == 3) {
                this.fieldID = new X9FieldID(exponents[2], exponents[1]);
                return;
            } else {
                if (exponents.length == 5) {
                    this.fieldID = new X9FieldID(exponents[4], exponents[1], exponents[2], exponents[3]);
                    return;
                }
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        }
        throw new IllegalArgumentException("'curve' is of an unsupported type");
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f9183g.getPoint();
    }

    public BigInteger getN() {
        return this.f9185n;
    }

    public BigInteger getH() {
        return this.f9184h;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public boolean hasSeed() {
        return this.seed != null;
    }

    public X9Curve getCurveEntry() {
        return new X9Curve(this.curve, this.seed);
    }

    public X9FieldID getFieldIDEntry() {
        return this.fieldID;
    }

    public X9ECPoint getBaseEntry() {
        return this.f9183g;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(6);
        v2.add(new ASN1Integer(ONE));
        v2.add(this.fieldID);
        v2.add(new X9Curve(this.curve, this.seed));
        v2.add(this.f9183g);
        v2.add(new ASN1Integer(this.f9185n));
        BigInteger bigInteger = this.f9184h;
        if (bigInteger != null) {
            v2.add(new ASN1Integer(bigInteger));
        }
        return new DERSequence(v2);
    }
}
