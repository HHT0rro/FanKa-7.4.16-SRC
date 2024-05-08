package com.android.internal.org.bouncycastle.math.field;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class FiniteFields {
    static final FiniteField GF_2 = new PrimeField(BigInteger.valueOf(2));
    static final FiniteField GF_3 = new PrimeField(BigInteger.valueOf(3));

    public static PolynomialExtensionField getBinaryExtensionField(int[] exponents) {
        if (exponents[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i10 = 1; i10 < exponents.length; i10++) {
            if (exponents[i10] <= exponents[i10 - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(exponents));
    }

    public static FiniteField getPrimeField(BigInteger characteristic) {
        int bitLength = characteristic.bitLength();
        if (characteristic.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            switch (characteristic.intValue()) {
                case 2:
                    return GF_2;
                case 3:
                    return GF_3;
            }
        }
        return new PrimeField(characteristic);
    }
}
