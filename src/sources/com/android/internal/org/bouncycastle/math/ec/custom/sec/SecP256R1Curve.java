package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECLookupTable;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat256;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP256R1Curve extends ECCurve.AbstractFp {
    private static final int SECP256R1_DEFAULT_COORDS = 2;
    protected SecP256R1Point infinity;

    /* renamed from: q, reason: collision with root package name */
    public static final BigInteger f9290q = SecP256R1FieldElement.Q;
    private static final ECFieldElement[] SECP256R1_AFFINE_ZS = {new SecP256R1FieldElement(ECConstants.ONE)};

    public SecP256R1Curve() {
        super(f9290q);
        this.infinity = new SecP256R1Point(this, null, null);
        this.f9263a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f9264b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.cofactor = BigInteger.valueOf(1L);
        this.coord = 2;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    protected ECCurve cloneCurve() {
        return new SecP256R1Curve();
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
        return f9290q;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return f9290q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger x10) {
        return new SecP256R1FieldElement(x10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10) {
        return new SecP256R1Point(this, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        return new SecP256R1Point(this, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
        final int[] table = new int[len * 8 * 2];
        int pos = 0;
        for (int i10 = 0; i10 < len; i10++) {
            ECPoint p10 = points[off + i10];
            Nat256.copy(((SecP256R1FieldElement) p10.getRawXCoord()).f9291x, 0, table, pos);
            int pos2 = pos + 8;
            Nat256.copy(((SecP256R1FieldElement) p10.getRawYCoord()).f9291x, 0, table, pos2);
            pos = pos2 + 8;
        }
        return new AbstractECLookupTable() { // from class: com.android.internal.org.bouncycastle.math.ec.custom.sec.SecP256R1Curve.1
            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public int getSize() {
                return len;
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookup(int index) {
                int[] x10 = Nat256.create();
                int[] y10 = Nat256.create();
                int pos3 = 0;
                for (int i11 = 0; i11 < len; i11++) {
                    int MASK = ((i11 ^ index) - 1) >> 31;
                    for (int j10 = 0; j10 < 8; j10++) {
                        int i12 = x10[j10];
                        int[] iArr = table;
                        x10[j10] = i12 ^ (iArr[pos3 + j10] & MASK);
                        y10[j10] = y10[j10] ^ (iArr[(pos3 + 8) + j10] & MASK);
                    }
                    pos3 += 16;
                }
                return createPoint(x10, y10);
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable, com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookupVar(int index) {
                int[] x10 = Nat256.create();
                int[] y10 = Nat256.create();
                int pos3 = index * 8 * 2;
                for (int j10 = 0; j10 < 8; j10++) {
                    int[] iArr = table;
                    x10[j10] = iArr[pos3 + j10];
                    y10[j10] = iArr[pos3 + 8 + j10];
                }
                return createPoint(x10, y10);
            }

            private ECPoint createPoint(int[] x10, int[] y10) {
                return SecP256R1Curve.this.createRawPoint(new SecP256R1FieldElement(x10), new SecP256R1FieldElement(y10), SecP256R1Curve.SECP256R1_AFFINE_ZS);
            }
        };
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElement(SecureRandom r10) {
        int[] x10 = Nat256.create();
        SecP256R1Field.random(r10, x10);
        return new SecP256R1FieldElement(x10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve.AbstractFp, com.android.internal.org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r10) {
        int[] x10 = Nat256.create();
        SecP256R1Field.randomMult(r10, x10);
        return new SecP256R1FieldElement(x10);
    }
}
