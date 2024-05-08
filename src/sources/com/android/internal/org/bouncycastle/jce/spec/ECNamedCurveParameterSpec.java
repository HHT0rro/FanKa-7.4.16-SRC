package com.android.internal.org.bouncycastle.jce.spec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECNamedCurveParameterSpec extends ECParameterSpec {
    private String name;

    public ECNamedCurveParameterSpec(String name, ECCurve curve, ECPoint G, BigInteger n10) {
        super(curve, G, n10);
        this.name = name;
    }

    public ECNamedCurveParameterSpec(String name, ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10) {
        super(curve, G, n10, h10);
        this.name = name;
    }

    public ECNamedCurveParameterSpec(String name, ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10, byte[] seed) {
        super(curve, G, n10, h10, seed);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
