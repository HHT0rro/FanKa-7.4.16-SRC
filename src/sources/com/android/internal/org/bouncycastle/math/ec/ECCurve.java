package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.ec.endo.ECEndomorphism;
import com.android.internal.org.bouncycastle.math.ec.endo.GLVEndomorphism;
import com.android.internal.org.bouncycastle.math.field.FiniteField;
import com.android.internal.org.bouncycastle.math.field.FiniteFields;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import com.android.internal.org.bouncycastle.util.Integers;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;

    /* renamed from: a, reason: collision with root package name */
    protected ECFieldElement f9263a;

    /* renamed from: b, reason: collision with root package name */
    protected ECFieldElement f9264b;
    protected BigInteger cofactor;
    protected FiniteField field;
    protected BigInteger order;
    protected int coord = 0;
    protected ECEndomorphism endomorphism = null;
    protected ECMultiplier multiplier = null;

    protected abstract ECCurve cloneCurve();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr);

    protected abstract ECPoint decompressPoint(int i10, BigInteger bigInteger);

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public abstract boolean isValidFieldElement(BigInteger bigInteger);

    public abstract ECFieldElement randomFieldElement(SecureRandom secureRandom);

    public abstract ECFieldElement randomFieldElementMult(SecureRandom secureRandom);

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class Config {
        protected int coord;
        protected ECEndomorphism endomorphism;
        protected ECMultiplier multiplier;

        Config(int coord, ECEndomorphism endomorphism, ECMultiplier multiplier) {
            this.coord = coord;
            this.endomorphism = endomorphism;
            this.multiplier = multiplier;
        }

        public Config setCoordinateSystem(int coord) {
            this.coord = coord;
            return this;
        }

        public Config setEndomorphism(ECEndomorphism endomorphism) {
            this.endomorphism = endomorphism;
            return this;
        }

        public Config setMultiplier(ECMultiplier multiplier) {
            this.multiplier = multiplier;
            return this;
        }

        public ECCurve create() {
            if (!ECCurve.this.supportsCoordinateSystem(this.coord)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECCurve c4 = ECCurve.this.cloneCurve();
            if (c4 == ECCurve.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            synchronized (c4) {
                c4.coord = this.coord;
                c4.endomorphism = this.endomorphism;
                c4.multiplier = this.multiplier;
            }
            return c4;
        }
    }

    protected ECCurve(FiniteField field) {
        this.field = field;
    }

    public synchronized Config configure() {
        return new Config(this.coord, this.endomorphism, this.multiplier);
    }

    public ECPoint validatePoint(BigInteger x10, BigInteger y10) {
        ECPoint p10 = createPoint(x10, y10);
        if (!p10.isValid()) {
            throw new IllegalArgumentException("Invalid point coordinates");
        }
        return p10;
    }

    public ECPoint createPoint(BigInteger x10, BigInteger y10) {
        return createRawPoint(fromBigInteger(x10), fromBigInteger(y10));
    }

    protected ECMultiplier createDefaultMultiplier() {
        ECEndomorphism eCEndomorphism = this.endomorphism;
        if (eCEndomorphism instanceof GLVEndomorphism) {
            return new GLVMultiplier(this, (GLVEndomorphism) eCEndomorphism);
        }
        return new WNafL2RMultiplier();
    }

    public boolean supportsCoordinateSystem(int coord) {
        return coord == 0;
    }

    public PreCompInfo getPreCompInfo(ECPoint point, String name) {
        Hashtable table;
        PreCompInfo preCompInfo;
        checkPoint(point);
        synchronized (point) {
            table = point.preCompTable;
        }
        if (table == null) {
            return null;
        }
        synchronized (table) {
            preCompInfo = (PreCompInfo) table.get(name);
        }
        return preCompInfo;
    }

    public PreCompInfo precompute(ECPoint point, String name, PreCompCallback callback) {
        Hashtable table;
        PreCompInfo result;
        checkPoint(point);
        synchronized (point) {
            table = point.preCompTable;
            if (table == null) {
                Hashtable hashtable = new Hashtable(4);
                table = hashtable;
                point.preCompTable = hashtable;
            }
        }
        synchronized (table) {
            PreCompInfo existing = (PreCompInfo) table.get(name);
            result = callback.precompute(existing);
            if (result != existing) {
                table.put(name, result);
            }
        }
        return result;
    }

    public ECPoint importPoint(ECPoint p10) {
        if (this == p10.getCurve()) {
            return p10;
        }
        if (p10.isInfinity()) {
            return getInfinity();
        }
        ECPoint p11 = p10.normalize();
        return createPoint(p11.getXCoord().toBigInteger(), p11.getYCoord().toBigInteger());
    }

    public void normalizeAll(ECPoint[] points) {
        normalizeAll(points, 0, points.length, null);
    }

    public void normalizeAll(ECPoint[] points, int off, int len, ECFieldElement iso) {
        checkPoints(points, off, len);
        switch (getCoordinateSystem()) {
            case 0:
            case 5:
                if (iso != null) {
                    throw new IllegalArgumentException("'iso' not valid for affine coordinates");
                }
                return;
            default:
                ECFieldElement[] zs = new ECFieldElement[len];
                int[] indices = new int[len];
                int count = 0;
                for (int i10 = 0; i10 < len; i10++) {
                    ECPoint p10 = points[off + i10];
                    if (p10 != null && (iso != null || !p10.isNormalized())) {
                        zs[count] = p10.getZCoord(0);
                        indices[count] = off + i10;
                        count++;
                    }
                }
                if (count == 0) {
                    return;
                }
                ECAlgorithms.montgomeryTrick(zs, 0, count, iso);
                for (int j10 = 0; j10 < count; j10++) {
                    int index = indices[j10];
                    points[index] = points[index].normalize(zs[j10]);
                }
                return;
        }
    }

    public FiniteField getField() {
        return this.field;
    }

    public ECFieldElement getA() {
        return this.f9263a;
    }

    public ECFieldElement getB() {
        return this.f9264b;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public ECMultiplier getMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = createDefaultMultiplier();
        }
        return this.multiplier;
    }

    public ECPoint decodePoint(byte[] encoded) {
        ECPoint p10;
        int expectedLength = (getFieldSize() + 7) / 8;
        boolean z10 = false;
        byte type = encoded[0];
        switch (type) {
            case 0:
                if (encoded.length != 1) {
                    throw new IllegalArgumentException("Incorrect length for infinity encoding");
                }
                p10 = getInfinity();
                break;
            case 1:
            case 5:
            default:
                throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(type, 16));
            case 2:
            case 3:
                if (encoded.length != expectedLength + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                int yTilde = type & 1;
                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                p10 = decompressPoint(yTilde, X);
                if (!p10.implIsValid(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
                break;
            case 4:
                if (encoded.length != (expectedLength * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                BigInteger X2 = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                p10 = validatePoint(X2, BigIntegers.fromUnsignedByteArray(encoded, expectedLength + 1, expectedLength));
                break;
            case 6:
            case 7:
                if (encoded.length != (expectedLength * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger X3 = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                BigInteger Y = BigIntegers.fromUnsignedByteArray(encoded, expectedLength + 1, expectedLength);
                boolean testBit = Y.testBit(0);
                if (type == 7) {
                    z10 = true;
                }
                if (testBit != z10) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                p10 = validatePoint(X3, Y);
                break;
        }
        if (type != 0 && p10.isInfinity()) {
            throw new IllegalArgumentException("Invalid infinity encoding");
        }
        return p10;
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
        final int FE_BYTES = (getFieldSize() + 7) >>> 3;
        final byte[] table = new byte[len * FE_BYTES * 2];
        int pos = 0;
        for (int i10 = 0; i10 < len; i10++) {
            ECPoint p10 = points[off + i10];
            byte[] px = p10.getRawXCoord().toBigInteger().toByteArray();
            byte[] py = p10.getRawYCoord().toBigInteger().toByteArray();
            int pyStart = 0;
            int pxStart = px.length > FE_BYTES ? 1 : 0;
            int pxLen = px.length - pxStart;
            if (py.length > FE_BYTES) {
                pyStart = 1;
            }
            int pyLen = py.length - pyStart;
            System.arraycopy((Object) px, pxStart, (Object) table, (pos + FE_BYTES) - pxLen, pxLen);
            int pos2 = pos + FE_BYTES;
            System.arraycopy((Object) py, pyStart, (Object) table, (pos2 + FE_BYTES) - pyLen, pyLen);
            pos = pos2 + FE_BYTES;
        }
        return new AbstractECLookupTable() { // from class: com.android.internal.org.bouncycastle.math.ec.ECCurve.1
            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public int getSize() {
                return len;
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookup(int index) {
                int i11;
                int i12 = FE_BYTES;
                byte[] x10 = new byte[i12];
                byte[] y10 = new byte[i12];
                int pos3 = 0;
                for (int i13 = 0; i13 < len; i13++) {
                    int MASK = ((i13 ^ index) - 1) >> 31;
                    int j10 = 0;
                    while (true) {
                        i11 = FE_BYTES;
                        if (j10 < i11) {
                            byte b4 = x10[j10];
                            byte[] bArr = table;
                            x10[j10] = (byte) (b4 ^ (bArr[pos3 + j10] & MASK));
                            y10[j10] = (byte) ((bArr[(i11 + pos3) + j10] & MASK) ^ y10[j10]);
                            j10++;
                        }
                    }
                    pos3 += i11 * 2;
                }
                return createPoint(x10, y10);
            }

            @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable, com.android.internal.org.bouncycastle.math.ec.ECLookupTable
            public ECPoint lookupVar(int index) {
                int i11 = FE_BYTES;
                byte[] x10 = new byte[i11];
                byte[] y10 = new byte[i11];
                int pos3 = i11 * index * 2;
                int j10 = 0;
                while (true) {
                    int i12 = FE_BYTES;
                    if (j10 < i12) {
                        byte[] bArr = table;
                        x10[j10] = bArr[pos3 + j10];
                        y10[j10] = bArr[i12 + pos3 + j10];
                        j10++;
                    } else {
                        return createPoint(x10, y10);
                    }
                }
            }

            private ECPoint createPoint(byte[] x10, byte[] y10) {
                ECCurve eCCurve = ECCurve.this;
                return eCCurve.createRawPoint(eCCurve.fromBigInteger(new BigInteger(1, x10)), ECCurve.this.fromBigInteger(new BigInteger(1, y10)));
            }
        };
    }

    protected void checkPoint(ECPoint point) {
        if (point == null || this != point.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    protected void checkPoints(ECPoint[] points) {
        checkPoints(points, 0, points.length);
    }

    protected void checkPoints(ECPoint[] points, int off, int len) {
        if (points == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (off < 0 || len < 0 || off > points.length - len) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i10 = 0; i10 < len; i10++) {
            ECPoint point = points[off + i10];
            if (point != null && this != point.getCurve()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    public boolean equals(ECCurve other) {
        return this == other || (other != null && getField().equals(other.getField()) && getA().toBigInteger().equals(other.getA().toBigInteger()) && getB().toBigInteger().equals(other.getB().toBigInteger()));
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ECCurve) && equals((ECCurve) obj));
    }

    public int hashCode() {
        return (getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8)) ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractFp extends ECCurve {
        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractFp(BigInteger q10) {
            super(FiniteFields.getPrimeField(q10));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public boolean isValidFieldElement(BigInteger x10) {
            return x10 != null && x10.signum() >= 0 && x10.compareTo(getField().getCharacteristic()) < 0;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElement(SecureRandom r10) {
            BigInteger p10 = getField().getCharacteristic();
            ECFieldElement fe1 = fromBigInteger(implRandomFieldElement(r10, p10));
            ECFieldElement fe2 = fromBigInteger(implRandomFieldElement(r10, p10));
            return fe1.multiply(fe2);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r10) {
            BigInteger p10 = getField().getCharacteristic();
            ECFieldElement fe1 = fromBigInteger(implRandomFieldElementMult(r10, p10));
            ECFieldElement fe2 = fromBigInteger(implRandomFieldElementMult(r10, p10));
            return fe1.multiply(fe2);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint decompressPoint(int yTilde, BigInteger X1) {
            ECFieldElement x10 = fromBigInteger(X1);
            ECFieldElement rhs = x10.square().add(this.f9263a).multiply(x10).add(this.f9264b);
            ECFieldElement y10 = rhs.sqrt();
            if (y10 == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (y10.testBitZero() != (yTilde == 1)) {
                y10 = y10.negate();
            }
            return createRawPoint(x10, y10);
        }

        private static BigInteger implRandomFieldElement(SecureRandom r10, BigInteger p10) {
            BigInteger x10;
            do {
                x10 = BigIntegers.createRandomBigInteger(p10.bitLength(), r10);
            } while (x10.compareTo(p10) >= 0);
            return x10;
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r10, BigInteger p10) {
            while (true) {
                BigInteger x10 = BigIntegers.createRandomBigInteger(p10.bitLength(), r10);
                if (x10.signum() > 0 && x10.compareTo(p10) < 0) {
                    return x10;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Fp extends AbstractFp {
        private static final int FP_DEFAULT_COORDS = 4;
        ECPoint.Fp infinity;

        /* renamed from: q, reason: collision with root package name */
        BigInteger f9269q;

        /* renamed from: r, reason: collision with root package name */
        BigInteger f9270r;

        public Fp(BigInteger q10, BigInteger a10, BigInteger b4) {
            this(q10, a10, b4, null, null);
        }

        public Fp(BigInteger q10, BigInteger a10, BigInteger b4, BigInteger order, BigInteger cofactor) {
            super(q10);
            this.f9269q = q10;
            this.f9270r = ECFieldElement.Fp.calculateResidue(q10);
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f9263a = fromBigInteger(a10);
            this.f9264b = fromBigInteger(b4);
            this.order = order;
            this.cofactor = cofactor;
            this.coord = 4;
        }

        protected Fp(BigInteger q10, BigInteger r10, ECFieldElement a10, ECFieldElement b4, BigInteger order, BigInteger cofactor) {
            super(q10);
            this.f9269q = q10;
            this.f9270r = r10;
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f9263a = a10;
            this.f9264b = b4;
            this.order = order;
            this.cofactor = cofactor;
            this.coord = 4;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECCurve cloneCurve() {
            return new Fp(this.f9269q, this.f9270r, this.f9263a, this.f9264b, this.order, this.cofactor);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int coord) {
            switch (coord) {
                case 0:
                case 1:
                case 2:
                case 4:
                    return true;
                case 3:
                default:
                    return false;
            }
        }

        public BigInteger getQ() {
            return this.f9269q;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.f9269q.bitLength();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger x10) {
            return new ECFieldElement.Fp(this.f9269q, this.f9270r, x10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10) {
            return new ECPoint.Fp(this, x10, y10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            return new ECPoint.Fp(this, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECPoint importPoint(ECPoint p10) {
            if (this != p10.getCurve() && getCoordinateSystem() == 2 && !p10.isInfinity()) {
                switch (p10.getCurve().getCoordinateSystem()) {
                    case 2:
                    case 3:
                    case 4:
                        return new ECPoint.Fp(this, fromBigInteger(p10.f9276x.toBigInteger()), fromBigInteger(p10.f9277y.toBigInteger()), new ECFieldElement[]{fromBigInteger(p10.zs[0].toBigInteger())});
                }
            }
            return super.importPoint(p10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractF2m extends ECCurve {
        private BigInteger[] si;

        public static BigInteger inverse(int m10, int[] ks, BigInteger x10) {
            return new LongArray(x10).modInverse(m10, ks).toBigInteger();
        }

        private static FiniteField buildField(int m10, int k12, int k22, int k32) {
            if (k12 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (k22 == 0) {
                if (k32 != 0) {
                    throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                }
                return FiniteFields.getBinaryExtensionField(new int[]{0, k12, m10});
            }
            if (k22 <= k12) {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (k32 <= k22) {
                throw new IllegalArgumentException("k3 must be > k2");
            }
            return FiniteFields.getBinaryExtensionField(new int[]{0, k12, k22, k32, m10});
        }

        protected AbstractF2m(int m10, int k12, int k22, int k32) {
            super(buildField(m10, k12, k22, k32));
            this.si = null;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger x10, BigInteger y10) {
            ECFieldElement X = fromBigInteger(x10);
            ECFieldElement Y = fromBigInteger(y10);
            int coord = getCoordinateSystem();
            switch (coord) {
                case 5:
                case 6:
                    if (X.isZero()) {
                        if (!Y.square().equals(getB())) {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        Y = Y.divide(X).add(X);
                        break;
                    }
                    break;
            }
            return createRawPoint(X, Y);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public boolean isValidFieldElement(BigInteger x10) {
            return x10 != null && x10.signum() >= 0 && x10.bitLength() <= getFieldSize();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElement(SecureRandom r10) {
            int m10 = getFieldSize();
            return fromBigInteger(BigIntegers.createRandomBigInteger(m10, r10));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r10) {
            int m10 = getFieldSize();
            ECFieldElement fe1 = fromBigInteger(implRandomFieldElementMult(r10, m10));
            ECFieldElement fe2 = fromBigInteger(implRandomFieldElementMult(r10, m10));
            return fe1.multiply(fe2);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint decompressPoint(int yTilde, BigInteger X1) {
            ECFieldElement x10 = fromBigInteger(X1);
            ECFieldElement y10 = null;
            if (x10.isZero()) {
                y10 = getB().sqrt();
            } else {
                ECFieldElement beta = x10.square().invert().multiply(getB()).add(getA()).add(x10);
                ECFieldElement z10 = solveQuadraticEquation(beta);
                if (z10 != null) {
                    if (z10.testBitZero() != (yTilde == 1)) {
                        z10 = z10.addOne();
                    }
                    switch (getCoordinateSystem()) {
                        case 5:
                        case 6:
                            y10 = z10.add(x10);
                            break;
                        default:
                            y10 = z10.multiply(x10);
                            break;
                    }
                }
            }
            if (y10 == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            return createRawPoint(x10, y10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ECFieldElement solveQuadraticEquation(ECFieldElement beta) {
            ECFieldElement z10;
            ECFieldElement t2;
            ECFieldElement.AbstractF2m betaF2m = (ECFieldElement.AbstractF2m) beta;
            boolean fastTrace = betaF2m.hasFastTrace();
            if (fastTrace && betaF2m.trace() != 0) {
                return null;
            }
            int m10 = getFieldSize();
            if ((m10 & 1) != 0) {
                ECFieldElement r10 = betaF2m.halfTrace();
                if (!fastTrace && !r10.square().add(r10).add(beta).isZero()) {
                    return null;
                }
                return r10;
            }
            if (beta.isZero()) {
                return beta;
            }
            ECFieldElement zeroElement = fromBigInteger(ECConstants.ZERO);
            Random rand = new Random();
            do {
                ECFieldElement t10 = fromBigInteger(new BigInteger(m10, rand));
                z10 = zeroElement;
                ECFieldElement w3 = beta;
                for (int i10 = 1; i10 < m10; i10++) {
                    ECFieldElement w22 = w3.square();
                    z10 = z10.square().add(w22.multiply(t10));
                    w3 = w22.add(beta);
                }
                if (!w3.isZero()) {
                    return null;
                }
                t2 = z10.square().add(z10);
            } while (t2.isZero());
            return z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized BigInteger[] getSi() {
            if (this.si == null) {
                this.si = Tnaf.getSi(this);
            }
            return this.si;
        }

        public boolean isKoblitz() {
            return this.order != null && this.cofactor != null && this.f9264b.isOne() && (this.f9263a.isZero() || this.f9263a.isOne());
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r10, int m10) {
            BigInteger x10;
            do {
                x10 = BigIntegers.createRandomBigInteger(m10, r10);
            } while (x10.signum() <= 0);
            return x10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class F2m extends AbstractF2m {
        private static final int F2M_DEFAULT_COORDS = 6;
        private ECPoint.F2m infinity;

        /* renamed from: k1, reason: collision with root package name */
        private int f9265k1;

        /* renamed from: k2, reason: collision with root package name */
        private int f9266k2;

        /* renamed from: k3, reason: collision with root package name */
        private int f9267k3;

        /* renamed from: m, reason: collision with root package name */
        private int f9268m;

        public F2m(int m10, int k10, BigInteger a10, BigInteger b4) {
            this(m10, k10, 0, 0, a10, b4, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int m10, int k10, BigInteger a10, BigInteger b4, BigInteger order, BigInteger cofactor) {
            this(m10, k10, 0, 0, a10, b4, order, cofactor);
        }

        public F2m(int m10, int k12, int k22, int k32, BigInteger a10, BigInteger b4) {
            this(m10, k12, k22, k32, a10, b4, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int m10, int k12, int k22, int k32, BigInteger a10, BigInteger b4, BigInteger order, BigInteger cofactor) {
            super(m10, k12, k22, k32);
            this.f9268m = m10;
            this.f9265k1 = k12;
            this.f9266k2 = k22;
            this.f9267k3 = k32;
            this.order = order;
            this.cofactor = cofactor;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f9263a = fromBigInteger(a10);
            this.f9264b = fromBigInteger(b4);
            this.coord = 6;
        }

        protected F2m(int m10, int k12, int k22, int k32, ECFieldElement a10, ECFieldElement b4, BigInteger order, BigInteger cofactor) {
            super(m10, k12, k22, k32);
            this.f9268m = m10;
            this.f9265k1 = k12;
            this.f9266k2 = k22;
            this.f9267k3 = k32;
            this.order = order;
            this.cofactor = cofactor;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f9263a = a10;
            this.f9264b = b4;
            this.coord = 6;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECCurve cloneCurve() {
            return new F2m(this.f9268m, this.f9265k1, this.f9266k2, this.f9267k3, this.f9263a, this.f9264b, this.order, this.cofactor);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int coord) {
            switch (coord) {
                case 0:
                case 1:
                case 6:
                    return true;
                default:
                    return false;
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECMultiplier createDefaultMultiplier() {
            if (isKoblitz()) {
                return new WTauNafMultiplier();
            }
            return super.createDefaultMultiplier();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.f9268m;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger x10) {
            return new ECFieldElement.F2m(this.f9268m, this.f9265k1, this.f9266k2, this.f9267k3, x10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10) {
            return new ECPoint.F2m(this, x10, y10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        protected ECPoint createRawPoint(ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            return new ECPoint.F2m(this, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getM() {
            return this.f9268m;
        }

        public boolean isTrinomial() {
            return this.f9266k2 == 0 && this.f9267k3 == 0;
        }

        public int getK1() {
            return this.f9265k1;
        }

        public int getK2() {
            return this.f9266k2;
        }

        public int getK3() {
            return this.f9267k3;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECCurve
        public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
            final int FE_LONGS = (this.f9268m + 63) >>> 6;
            final int[] ks = isTrinomial() ? new int[]{this.f9265k1} : new int[]{this.f9265k1, this.f9266k2, this.f9267k3};
            final long[] table = new long[len * FE_LONGS * 2];
            int pos = 0;
            for (int i10 = 0; i10 < len; i10++) {
                ECPoint p10 = points[off + i10];
                ((ECFieldElement.F2m) p10.getRawXCoord()).f9272x.copyTo(table, pos);
                int pos2 = pos + FE_LONGS;
                ((ECFieldElement.F2m) p10.getRawYCoord()).f9272x.copyTo(table, pos2);
                pos = pos2 + FE_LONGS;
            }
            return new AbstractECLookupTable() { // from class: com.android.internal.org.bouncycastle.math.ec.ECCurve.F2m.1
                @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
                public int getSize() {
                    return len;
                }

                @Override // com.android.internal.org.bouncycastle.math.ec.ECLookupTable
                public ECPoint lookup(int index) {
                    int i11;
                    long[] x10 = Nat.create64(FE_LONGS);
                    long[] y10 = Nat.create64(FE_LONGS);
                    int pos3 = 0;
                    for (int i12 = 0; i12 < len; i12++) {
                        long MASK = ((i12 ^ index) - 1) >> 31;
                        int j10 = 0;
                        while (true) {
                            i11 = FE_LONGS;
                            if (j10 < i11) {
                                long j11 = x10[j10];
                                long[] jArr = table;
                                x10[j10] = j11 ^ (jArr[pos3 + j10] & MASK);
                                y10[j10] = y10[j10] ^ (jArr[(i11 + pos3) + j10] & MASK);
                                j10++;
                            }
                        }
                        pos3 += i11 * 2;
                    }
                    return createPoint(x10, y10);
                }

                @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECLookupTable, com.android.internal.org.bouncycastle.math.ec.ECLookupTable
                public ECPoint lookupVar(int index) {
                    long[] x10 = Nat.create64(FE_LONGS);
                    long[] y10 = Nat.create64(FE_LONGS);
                    int pos3 = FE_LONGS * index * 2;
                    int j10 = 0;
                    while (true) {
                        int i11 = FE_LONGS;
                        if (j10 < i11) {
                            long[] jArr = table;
                            x10[j10] = jArr[pos3 + j10];
                            y10[j10] = jArr[i11 + pos3 + j10];
                            j10++;
                        } else {
                            return createPoint(x10, y10);
                        }
                    }
                }

                private ECPoint createPoint(long[] x10, long[] y10) {
                    ECFieldElement.F2m X = new ECFieldElement.F2m(F2m.this.f9268m, ks, new LongArray(x10));
                    ECFieldElement.F2m Y = new ECFieldElement.F2m(F2m.this.f9268m, ks, new LongArray(y10));
                    return F2m.this.createRawPoint(X, Y);
                }
            };
        }
    }
}
