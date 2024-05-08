package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import com.android.internal.org.bouncycastle.util.Integers;
import java.math.BigInteger;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ECFieldElement implements ECConstants {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractFp extends ECFieldElement {
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
        return multiply(b4).subtract(x10.multiply(y10));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
        return multiply(b4).add(x10.multiply(y10));
    }

    public ECFieldElement squareMinusProduct(ECFieldElement x10, ECFieldElement y10) {
        return square().subtract(x10.multiply(y10));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement x10, ECFieldElement y10) {
        return square().add(x10.multiply(y10));
    }

    public ECFieldElement squarePow(int pow) {
        ECFieldElement r10 = this;
        for (int i10 = 0; i10 < pow; i10++) {
            r10 = r10.square();
        }
        return r10;
    }

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public String toString() {
        return toBigInteger().toString(16);
    }

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Fp extends AbstractFp {

        /* renamed from: q, reason: collision with root package name */
        BigInteger f9273q;

        /* renamed from: r, reason: collision with root package name */
        BigInteger f9274r;

        /* renamed from: x, reason: collision with root package name */
        BigInteger f9275x;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BigInteger calculateResidue(BigInteger p10) {
            int bitLength = p10.bitLength();
            if (bitLength >= 96) {
                BigInteger firstWord = p10.shiftRight(bitLength - 64);
                if (firstWord.longValue() == -1) {
                    return ONE.shiftLeft(bitLength).subtract(p10);
                }
                return null;
            }
            return null;
        }

        public Fp(BigInteger q10, BigInteger x10) {
            this(q10, calculateResidue(q10), x10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Fp(BigInteger q10, BigInteger r10, BigInteger x10) {
            if (x10 == null || x10.signum() < 0 || x10.compareTo(q10) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f9273q = q10;
            this.f9274r = r10;
            this.f9275x = x10;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f9275x;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.f9273q.bitLength();
        }

        public BigInteger getQ() {
            return this.f9273q;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement b4) {
            return new Fp(this.f9273q, this.f9274r, modAdd(this.f9275x, b4.toBigInteger()));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger x22 = this.f9275x.add(ECConstants.ONE);
            if (x22.compareTo(this.f9273q) == 0) {
                x22 = ECConstants.ZERO;
            }
            return new Fp(this.f9273q, this.f9274r, x22);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement b4) {
            return new Fp(this.f9273q, this.f9274r, modSubtract(this.f9275x, b4.toBigInteger()));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement b4) {
            return new Fp(this.f9273q, this.f9274r, modMult(this.f9275x, b4.toBigInteger()));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
            BigInteger ax = this.f9275x;
            BigInteger bx = b4.toBigInteger();
            BigInteger xx = x10.toBigInteger();
            BigInteger yx = y10.toBigInteger();
            BigInteger ab2 = ax.multiply(bx);
            BigInteger xy = xx.multiply(yx);
            return new Fp(this.f9273q, this.f9274r, modReduce(ab2.subtract(xy)));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
            BigInteger ax = this.f9275x;
            BigInteger bx = b4.toBigInteger();
            BigInteger xx = x10.toBigInteger();
            BigInteger yx = y10.toBigInteger();
            BigInteger ab2 = ax.multiply(bx);
            BigInteger xy = xx.multiply(yx);
            return new Fp(this.f9273q, this.f9274r, modReduce(ab2.add(xy)));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement b4) {
            return new Fp(this.f9273q, this.f9274r, modMult(this.f9275x, modInverse(b4.toBigInteger())));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.f9275x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f9273q;
            return new Fp(bigInteger, this.f9274r, bigInteger.subtract(this.f9275x));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.f9273q;
            BigInteger bigInteger2 = this.f9274r;
            BigInteger bigInteger3 = this.f9275x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement x10, ECFieldElement y10) {
            BigInteger ax = this.f9275x;
            BigInteger xx = x10.toBigInteger();
            BigInteger yx = y10.toBigInteger();
            BigInteger aa2 = ax.multiply(ax);
            BigInteger xy = xx.multiply(yx);
            return new Fp(this.f9273q, this.f9274r, modReduce(aa2.subtract(xy)));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement x10, ECFieldElement y10) {
            BigInteger ax = this.f9275x;
            BigInteger xx = x10.toBigInteger();
            BigInteger yx = y10.toBigInteger();
            BigInteger aa2 = ax.multiply(ax);
            BigInteger xy = xx.multiply(yx);
            return new Fp(this.f9273q, this.f9274r, modReduce(aa2.add(xy)));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.f9273q, this.f9274r, modInverse(this.f9275x));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f9273q.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f9273q.testBit(1)) {
                BigInteger e2 = this.f9273q.shiftRight(2).add(ECConstants.ONE);
                BigInteger bigInteger = this.f9273q;
                return checkSqrt(new Fp(bigInteger, this.f9274r, this.f9275x.modPow(e2, bigInteger)));
            }
            BigInteger e10 = this.f9273q;
            if (e10.testBit(2)) {
                BigInteger t12 = this.f9275x.modPow(this.f9273q.shiftRight(3), this.f9273q);
                BigInteger t2 = modMult(t12, this.f9275x);
                BigInteger t32 = modMult(t2, t12);
                if (t32.equals(ECConstants.ONE)) {
                    return checkSqrt(new Fp(this.f9273q, this.f9274r, t2));
                }
                BigInteger t42 = ECConstants.TWO.modPow(this.f9273q.shiftRight(2), this.f9273q);
                BigInteger y10 = modMult(t2, t42);
                return checkSqrt(new Fp(this.f9273q, this.f9274r, y10));
            }
            BigInteger legendreExponent = this.f9273q.shiftRight(1);
            if (!this.f9275x.modPow(legendreExponent, this.f9273q).equals(ECConstants.ONE)) {
                return null;
            }
            BigInteger X = this.f9275x;
            BigInteger fourX = modDouble(modDouble(X));
            BigInteger k10 = legendreExponent.add(ECConstants.ONE);
            BigInteger qMinusOne = this.f9273q.subtract(ECConstants.ONE);
            Random rand = new Random();
            while (true) {
                BigInteger P = new BigInteger(this.f9273q.bitLength(), rand);
                if (P.compareTo(this.f9273q) < 0 && modReduce(P.multiply(P).subtract(fourX)).modPow(legendreExponent, this.f9273q).equals(qMinusOne)) {
                    BigInteger[] result = lucasSequence(P, X, k10);
                    BigInteger U = result[0];
                    BigInteger V = result[1];
                    if (modMult(V, V).equals(fourX)) {
                        return new Fp(this.f9273q, this.f9274r, modHalfAbs(V));
                    }
                    if (!U.equals(ECConstants.ONE) && !U.equals(qMinusOne)) {
                        return null;
                    }
                }
            }
        }

        private ECFieldElement checkSqrt(ECFieldElement z10) {
            if (z10.square().equals(this)) {
                return z10;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger P, BigInteger Q, BigInteger k10) {
            int n10 = k10.bitLength();
            int s2 = k10.getLowestSetBit();
            BigInteger Uh = ECConstants.ONE;
            BigInteger Vl = ECConstants.TWO;
            BigInteger Vh = P;
            BigInteger Ql = ECConstants.ONE;
            BigInteger Qh = ECConstants.ONE;
            for (int j10 = n10 - 1; j10 >= s2 + 1; j10--) {
                Ql = modMult(Ql, Qh);
                if (k10.testBit(j10)) {
                    Qh = modMult(Ql, Q);
                    Uh = modMult(Uh, Vh);
                    Vl = modReduce(Vh.multiply(Vl).subtract(P.multiply(Ql)));
                    Vh = modReduce(Vh.multiply(Vh).subtract(Qh.shiftLeft(1)));
                } else {
                    Qh = Ql;
                    Uh = modReduce(Uh.multiply(Vl).subtract(Ql));
                    Vh = modReduce(Vh.multiply(Vl).subtract(P.multiply(Ql)));
                    Vl = modReduce(Vl.multiply(Vl).subtract(Ql.shiftLeft(1)));
                }
            }
            BigInteger Ql2 = modMult(Ql, Qh);
            BigInteger Qh2 = modMult(Ql2, Q);
            BigInteger Uh2 = modReduce(Uh.multiply(Vl).subtract(Ql2));
            BigInteger Vl2 = modReduce(Vh.multiply(Vl).subtract(P.multiply(Ql2)));
            BigInteger Ql3 = modMult(Ql2, Qh2);
            for (int j11 = 1; j11 <= s2; j11++) {
                Uh2 = modMult(Uh2, Vl2);
                Vl2 = modReduce(Vl2.multiply(Vl2).subtract(Ql3.shiftLeft(1)));
                Ql3 = modMult(Ql3, Ql3);
            }
            return new BigInteger[]{Uh2, Vl2};
        }

        protected BigInteger modAdd(BigInteger x12, BigInteger x22) {
            BigInteger x32 = x12.add(x22);
            if (x32.compareTo(this.f9273q) >= 0) {
                return x32.subtract(this.f9273q);
            }
            return x32;
        }

        protected BigInteger modDouble(BigInteger x10) {
            BigInteger _2x = x10.shiftLeft(1);
            if (_2x.compareTo(this.f9273q) >= 0) {
                return _2x.subtract(this.f9273q);
            }
            return _2x;
        }

        protected BigInteger modHalf(BigInteger x10) {
            if (x10.testBit(0)) {
                x10 = this.f9273q.add(x10);
            }
            return x10.shiftRight(1);
        }

        protected BigInteger modHalfAbs(BigInteger x10) {
            if (x10.testBit(0)) {
                x10 = this.f9273q.subtract(x10);
            }
            return x10.shiftRight(1);
        }

        protected BigInteger modInverse(BigInteger x10) {
            return BigIntegers.modOddInverse(this.f9273q, x10);
        }

        protected BigInteger modMult(BigInteger x12, BigInteger x22) {
            return modReduce(x12.multiply(x22));
        }

        protected BigInteger modReduce(BigInteger x10) {
            if (this.f9274r != null) {
                boolean negative = x10.signum() < 0;
                if (negative) {
                    x10 = x10.abs();
                }
                int qLen = this.f9273q.bitLength();
                boolean rIsOne = this.f9274r.equals(ECConstants.ONE);
                while (x10.bitLength() > qLen + 1) {
                    BigInteger u10 = x10.shiftRight(qLen);
                    BigInteger v2 = x10.subtract(u10.shiftLeft(qLen));
                    if (!rIsOne) {
                        u10 = u10.multiply(this.f9274r);
                    }
                    x10 = u10.add(v2);
                }
                while (x10.compareTo(this.f9273q) >= 0) {
                    x10 = x10.subtract(this.f9273q);
                }
                if (negative && x10.signum() != 0) {
                    return this.f9273q.subtract(x10);
                }
                return x10;
            }
            return x10.mod(this.f9273q);
        }

        protected BigInteger modSubtract(BigInteger x12, BigInteger x22) {
            BigInteger x32 = x12.subtract(x22);
            if (x32.signum() < 0) {
                return x32.add(this.f9273q);
            }
            return x32;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Fp)) {
                return false;
            }
            Fp o10 = (Fp) other;
            return this.f9273q.equals(o10.f9273q) && this.f9275x.equals(o10.f9275x);
        }

        public int hashCode() {
            return this.f9273q.hashCode() ^ this.f9275x.hashCode();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractF2m extends ECFieldElement {
        public ECFieldElement halfTrace() {
            int m10 = getFieldSize();
            if ((m10 & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int n10 = (m10 + 1) >>> 1;
            int k10 = 31 - Integers.numberOfLeadingZeros(n10);
            int nk = 1;
            ECFieldElement ht = this;
            while (k10 > 0) {
                ht = ht.squarePow(nk << 1).add(ht);
                k10--;
                nk = n10 >>> k10;
                if ((nk & 1) != 0) {
                    ht = ht.squarePow(2).add(this);
                }
            }
            return ht;
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int m10 = getFieldSize();
            int k10 = 31 - Integers.numberOfLeadingZeros(m10);
            int mk = 1;
            ECFieldElement tr = this;
            while (k10 > 0) {
                tr = tr.squarePow(mk).add(tr);
                k10--;
                mk = m10 >>> k10;
                if ((mk & 1) != 0) {
                    tr = tr.square().add(this);
                }
            }
            if (tr.isZero()) {
                return 0;
            }
            if (tr.isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class F2m extends AbstractF2m {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        private int[] ks;

        /* renamed from: m, reason: collision with root package name */
        private int f9271m;
        private int representation;

        /* renamed from: x, reason: collision with root package name */
        LongArray f9272x;

        public F2m(int m10, int k12, int k22, int k32, BigInteger x10) {
            if (x10 == null || x10.signum() < 0 || x10.bitLength() > m10) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (k22 == 0 && k32 == 0) {
                this.representation = 2;
                this.ks = new int[]{k12};
            } else {
                if (k22 >= k32) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (k22 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.representation = 3;
                this.ks = new int[]{k12, k22, k32};
            }
            this.f9271m = m10;
            this.f9272x = new LongArray(x10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public F2m(int m10, int[] ks, LongArray x10) {
            this.f9271m = m10;
            this.representation = ks.length == 1 ? 2 : 3;
            this.ks = ks;
            this.f9272x = x10;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.f9272x.degree();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.f9272x.isOne();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.f9272x.isZero();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            return this.f9272x.testBitZero();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f9272x.toBigInteger();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.f9271m;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement b4) {
            LongArray iarrClone = (LongArray) this.f9272x.clone();
            F2m bF2m = (F2m) b4;
            iarrClone.addShiftedByWords(bF2m.f9272x, 0);
            return new F2m(this.f9271m, this.ks, iarrClone);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.f9271m, this.ks, this.f9272x.addOne());
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement b4) {
            return add(b4);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement b4) {
            int i10 = this.f9271m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f9272x.modMultiply(((F2m) b4).f9272x, i10, iArr));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
            return multiplyPlusProduct(b4, x10, y10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement b4, ECFieldElement x10, ECFieldElement y10) {
            LongArray ax = this.f9272x;
            LongArray bx = ((F2m) b4).f9272x;
            LongArray xx = ((F2m) x10).f9272x;
            LongArray yx = ((F2m) y10).f9272x;
            LongArray ab2 = ax.multiply(bx, this.f9271m, this.ks);
            LongArray xy = xx.multiply(yx, this.f9271m, this.ks);
            if (ab2 == ax || ab2 == bx) {
                ab2 = (LongArray) ab2.clone();
            }
            ab2.addShiftedByWords(xy, 0);
            ab2.reduce(this.f9271m, this.ks);
            return new F2m(this.f9271m, this.ks, ab2);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement b4) {
            ECFieldElement bInv = b4.invert();
            return multiply(bInv);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int i10 = this.f9271m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f9272x.modSquare(i10, iArr));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement x10, ECFieldElement y10) {
            return squarePlusProduct(x10, y10);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement x10, ECFieldElement y10) {
            LongArray ax = this.f9272x;
            LongArray xx = ((F2m) x10).f9272x;
            LongArray yx = ((F2m) y10).f9272x;
            LongArray aa2 = ax.square(this.f9271m, this.ks);
            LongArray xy = xx.multiply(yx, this.f9271m, this.ks);
            if (aa2 == ax) {
                aa2 = (LongArray) aa2.clone();
            }
            aa2.addShiftedByWords(xy, 0);
            aa2.reduce(this.f9271m, this.ks);
            return new F2m(this.f9271m, this.ks, aa2);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePow(int pow) {
            if (pow < 1) {
                return this;
            }
            int i10 = this.f9271m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f9272x.modSquareN(pow, i10, iArr));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int i10 = this.f9271m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f9272x.modInverse(i10, iArr));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            return (this.f9272x.isZero() || this.f9272x.isOne()) ? this : squarePow(this.f9271m - 1);
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int getM() {
            return this.f9271m;
        }

        public int getK1() {
            return this.ks[0];
        }

        public int getK2() {
            int[] iArr = this.ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public boolean equals(Object anObject) {
            if (anObject == this) {
                return true;
            }
            if (!(anObject instanceof F2m)) {
                return false;
            }
            F2m b4 = (F2m) anObject;
            return this.f9271m == b4.f9271m && this.representation == b4.representation && Arrays.areEqual(this.ks, b4.ks) && this.f9272x.equals(b4.f9272x);
        }

        public int hashCode() {
            return (this.f9272x.hashCode() ^ this.f9271m) ^ Arrays.hashCode(this.ks);
        }
    }
}
