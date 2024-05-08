package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat224;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP224R1Curve extends ECCurve.AbstractFp {
    private static final int SECP224R1_DEFAULT_COORDS = 2;
    protected SecP224R1Point infinity;

    /* renamed from: q, reason: collision with root package name */
    public static final BigInteger f9286q = SecP224R1FieldElement.Q;
    private static final ECFieldElement[] SECP224R1_AFFINE_ZS = {new SecP224R1FieldElement(ECConstants.ONE)};

    public SecP224R1Curve() {
        super(f9286q);
        this.infinity = new SecP224R1Point(this, null, null);
        this.f9263a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f9264b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.cofactor = BigInteger.valueOf(1L);
        this.coord = 2;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    protected ECCurve cloneCurve() {
        return new SecP224R1Curve();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int coord) {
        switch (coord) {
            case 2:
                return true;
            default:
                return false;
        }
    }

    public BigInteger getQ() {
        return f9286q;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f9286q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger x10) {
        return new SecP224R1FieldElement(x10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10) {
        return new SecP224R1Point(this, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        return new SecP224R1Point(this, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
        final int[] table = new int[len * 7 * 2];
        int pos = 0;
        for (int i10 = 0; i10 < len; i10++) {
            ECPoint p10 = points[off + i10];
            Nat224.copy(((SecP224R1FieldElement) p10.getRawXCoord()).f9287x, 0, table, pos);
            int pos2 = pos + 7;
            Nat224.copy(((SecP224R1FieldElement) p10.getRawYCoord()).f9287x, 0, table, pos2);
            pos = pos2 + 7;
        }
        return new AbstractECLookupTable() { // from class: com.android.internal.org.bouncycastle.math.ec.custom.sec.SecP224R1Curve.1
            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public int getSize() {
                return len;
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookup(int index) {
                int[] x10 = Nat224.create();
                int[] y10 = Nat224.create();
                int pos3 = 0;
                for (int i11 = 0; i11 < len; i11++) {
                    int MASK = ((i11 ^ index) - 1) >> 31;
                    for (int j10 = 0; j10 < 7; j10++) {
                        int i12 = x10[j10];
                        int[] iArr = table;
                        x10[j10] = i12 ^ (iArr[pos3 + j10] & MASK);
                        y10[j10] = y10[j10] ^ (iArr[(pos3 + 7) + j10] & MASK);
                    }
                    pos3 += 14;
                }
                return createPoint(x10, y10);
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable, com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookupVar(int index) {
                int[] x10 = Nat224.create();
                int[] y10 = Nat224.create();
                int pos3 = index * 7 * 2;
                for (int j10 = 0; j10 < 7; j10++) {
                    int[] iArr = table;
                    x10[j10] = iArr[pos3 + j10];
                    y10[j10] = iArr[pos3 + 7 + j10];
                }
                return createPoint(x10, y10);
            }

            private ECPoint createPoint(int[] x10, int[] y10) {
                return SecP224R1Curve.this.createRawPoint(new SecP224R1FieldElement(x10), new SecP224R1FieldElement(y10), SecP224R1Curve.SECP224R1_AFFINE_ZS);
            }
        };
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r10) {
        int[] x10 = Nat224.create();
        SecP224R1Field.random(r10, x10);
        return new SecP224R1FieldElement(x10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r10) {
        int[] x10 = Nat224.create();
        SecP224R1Field.randomMult(r10, x10);
        return new SecP224R1FieldElement(x10);
    }
}
