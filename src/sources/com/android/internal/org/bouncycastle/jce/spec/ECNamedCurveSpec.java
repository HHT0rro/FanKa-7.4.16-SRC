package com.android.internal.org.bouncycastle.jce.spec;

import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.android.internal.org.bouncycastle.math.ec.ECAlgorithms;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.field.FiniteField;
import com.android.internal.org.bouncycastle.math.field.Polynomial;
import com.android.internal.org.bouncycastle.math.field.PolynomialExtensionField;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECNamedCurveSpec extends java.security.spec.ECParameterSpec {
    private String name;

    private static EllipticCurve convertCurve(ECCurve curve, byte[] seed) {
        ECField field = convertField(curve.getField());
        BigInteger a10 = curve.getA().toBigInteger();
        BigInteger b4 = curve.getB().toBigInteger();
        return new EllipticCurve(field, a10, b4, seed);
    }

    private static ECField convertField(FiniteField field) {
        if (ECAlgorithms.isFpField(field)) {
            return new ECFieldFp(field.getCharacteristic());
        }
        Polynomial poly = ((PolynomialExtensionField) field).getMinimalPolynomial();
        int[] exponents = poly.getExponentsPresent();
        int[] ks = Arrays.reverse(Arrays.copyOfRange(exponents, 1, exponents.length - 1));
        return new ECFieldF2m(poly.getDegree(), ks);
    }

    public ECNamedCurveSpec(String name, ECCurve curve, ECPoint g3, BigInteger n10) {
        super(convertCurve(curve, null), EC5Util.convertPoint(g3), n10, 1);
        this.name = name;
    }

    public ECNamedCurveSpec(String name, EllipticCurve curve, java.security.spec.ECPoint g3, BigInteger n10) {
        super(curve, g3, n10, 1);
        this.name = name;
    }

    public ECNamedCurveSpec(String name, ECCurve curve, ECPoint g3, BigInteger n10, BigInteger h10) {
        super(convertCurve(curve, null), EC5Util.convertPoint(g3), n10, h10.intValue());
        this.name = name;
    }

    public ECNamedCurveSpec(String name, EllipticCurve curve, java.security.spec.ECPoint g3, BigInteger n10, BigInteger h10) {
        super(curve, g3, n10, h10.intValue());
        this.name = name;
    }

    public ECNamedCurveSpec(String name, ECCurve curve, ECPoint g3, BigInteger n10, BigInteger h10, byte[] seed) {
        super(convertCurve(curve, seed), EC5Util.convertPoint(g3), n10, h10.intValue());
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
