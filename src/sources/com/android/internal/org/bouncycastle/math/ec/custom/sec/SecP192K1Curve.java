package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat192;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP192K1Curve extends ECCurve.AbstractFp {
    private static final int SECP192K1_DEFAULT_COORDS = 2;
    protected SecP192K1Point infinity;

    /* renamed from: q, reason: collision with root package name */
    public static final BigInteger f9280q = SecP192K1FieldElement.Q;
    private static final ECFieldElement[] SECP192K1_AFFINE_ZS = {new SecP192K1FieldElement(ECConstants.ONE)};

    public SecP192K1Curve() {
        super(f9280q);
        this.infinity = new SecP192K1Point(this, null, null);
        this.f9263a = fromBigInteger(ECConstants.ZERO);
        this.f9264b = fromBigInteger(BigInteger.valueOf(3L));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.cofactor = BigInteger.valueOf(1L);
        this.coord = 2;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    protected ECCurve cloneCurve() {
        return new SecP192K1Curve();
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
        return f9280q;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f9280q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger x10) {
        return new SecP192K1FieldElement(x10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10) {
        return new SecP192K1Point(this, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        return new SecP192K1Point(this, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
        final int[] table = new int[len * 6 * 2];
        int pos = 0;
        for (int i10 = 0; i10 < len; i10++) {
            ECPoint p10 = points[off + i10];
            Nat192.copy(((SecP192K1FieldElement) p10.getRawXCoord()).f9281x, 0, table, pos);
            int pos2 = pos + 6;
            Nat192.copy(((SecP192K1FieldElement) p10.getRawYCoord()).f9281x, 0, table, pos2);
            pos = pos2 + 6;
        }
        return new AbstractECLookupTable() { // from class: com.android.internal.org.bouncycastle.math.ec.custom.sec.SecP192K1Curve.1
            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public int getSize() {
                return len;
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookup(int index) {
                int[] x10 = Nat192.create();
                int[] y10 = Nat192.create();
                int pos3 = 0;
                for (int i11 = 0; i11 < len; i11++) {
                    int MASK = ((i11 ^ index) - 1) >> 31;
                    for (int j10 = 0; j10 < 6; j10++) {
                        int i12 = x10[j10];
                        int[] iArr = table;
                        x10[j10] = i12 ^ (iArr[pos3 + j10] & MASK);
                        y10[j10] = y10[j10] ^ (iArr[(pos3 + 6) + j10] & MASK);
                    }
                    pos3 += 12;
                }
                return createPoint(x10, y10);
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable, com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookupVar(int index) {
                int[] x10 = Nat192.create();
                int[] y10 = Nat192.create();
                int pos3 = index * 6 * 2;
                for (int j10 = 0; j10 < 6; j10++) {
                    int[] iArr = table;
                    x10[j10] = iArr[pos3 + j10];
                    y10[j10] = iArr[pos3 + 6 + j10];
                }
                return createPoint(x10, y10);
            }

            private ECPoint createPoint(int[] x10, int[] y10) {
                return SecP192K1Curve.this.createRawPoint(new SecP192K1FieldElement(x10), new SecP192K1FieldElement(y10), SecP192K1Curve.SECP192K1_AFFINE_ZS);
            }
        };
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r10) {
        int[] x10 = Nat192.create();
        SecP192K1Field.random(r10, x10);
        return new SecP192K1FieldElement(x10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r10) {
        int[] x10 = Nat192.create();
        SecP192K1Field.randomMult(r10, x10);
        return new SecP192K1FieldElement(x10);
    }
}
