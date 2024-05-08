package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.util.Integers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHPublicKeyParameters extends DHKeyParameters {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    /* renamed from: y, reason: collision with root package name */
    private BigInteger f9217y;

    public DHPublicKeyParameters(BigInteger y10, DHParameters params) {
        super(false, params);
        this.f9217y = validate(y10, params);
    }

    private BigInteger validate(BigInteger y10, DHParameters dhParams) {
        if (y10 == null) {
            throw new NullPointerException("y value cannot be null");
        }
        BigInteger p10 = dhParams.getP();
        BigInteger bigInteger = TWO;
        if (y10.compareTo(bigInteger) < 0 || y10.compareTo(p10.subtract(bigInteger)) > 0) {
            throw new IllegalArgumentException("invalid DH public key");
        }
        BigInteger q10 = dhParams.getQ();
        if (q10 == null) {
            return y10;
        }
        if (p10.testBit(0) && p10.bitLength() - 1 == q10.bitLength() && p10.shiftRight(1).equals(q10)) {
            if (1 == legendre(y10, p10)) {
                return y10;
            }
        } else if (ONE.equals(y10.modPow(q10, p10))) {
            return y10;
        }
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
    }

    public BigInteger getY() {
        return this.f9217y;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.f9217y.hashCode() ^ super.hashCode();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKeyParameters)) {
            return false;
        }
        DHPublicKeyParameters other = (DHPublicKeyParameters) obj;
        return other.getY().equals(this.f9217y) && super.equals(obj);
    }

    private static int legendre(BigInteger a10, BigInteger b4) {
        int bitLength = b4.bitLength();
        int[] A = Nat.fromBigInteger(bitLength, a10);
        int[] B = Nat.fromBigInteger(bitLength, b4);
        int r10 = 0;
        int len = B.length;
        while (true) {
            if (A[0] == 0) {
                Nat.shiftDownWord(len, A, 0);
            } else {
                int shift = Integers.numberOfTrailingZeros(A[0]);
                if (shift > 0) {
                    Nat.shiftDownBits(len, A, shift, 0);
                    int bits = B[0];
                    r10 ^= ((bits >>> 1) ^ bits) & (shift << 1);
                }
                int cmp = Nat.compare(len, A, B);
                if (cmp == 0) {
                    break;
                }
                if (cmp < 0) {
                    r10 ^= B[0] & A[0];
                    int[] t2 = A;
                    A = B;
                    B = t2;
                }
                while (A[len - 1] == 0) {
                    len--;
                }
                Nat.sub(len, A, B, A);
            }
        }
        if (Nat.isOne(len, B)) {
            return 1 - (r10 & 2);
        }
        return 0;
    }
}
