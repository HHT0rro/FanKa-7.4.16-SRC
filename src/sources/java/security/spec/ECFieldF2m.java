package java.security.spec;

import java.math.BigInteger;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECFieldF2m implements ECField {
    private int[] ks;

    /* renamed from: m, reason: collision with root package name */
    private int f50405m;
    private BigInteger rp;

    public ECFieldF2m(int m10) {
        if (m10 <= 0) {
            throw new IllegalArgumentException("m is not positive");
        }
        this.f50405m = m10;
        this.ks = null;
        this.rp = null;
    }

    public ECFieldF2m(int m10, BigInteger rp) {
        this.f50405m = m10;
        this.rp = rp;
        if (m10 <= 0) {
            throw new IllegalArgumentException("m is not positive");
        }
        int bitCount = rp.bitCount();
        if (!this.rp.testBit(0) || !this.rp.testBit(m10) || (bitCount != 3 && bitCount != 5)) {
            throw new IllegalArgumentException("rp does not represent a valid reduction polynomial");
        }
        BigInteger temp = this.rp.clearBit(0).clearBit(m10);
        int[] iArr = new int[bitCount - 2];
        this.ks = iArr;
        for (int i10 = iArr.length - 1; i10 >= 0; i10--) {
            int index = temp.getLowestSetBit();
            this.ks[i10] = index;
            temp = temp.clearBit(index);
        }
    }

    public ECFieldF2m(int m10, int[] ks) {
        this.f50405m = m10;
        int[] iArr = (int[]) ks.clone();
        this.ks = iArr;
        if (m10 <= 0) {
            throw new IllegalArgumentException("m is not positive");
        }
        if (iArr.length != 1 && iArr.length != 3) {
            throw new IllegalArgumentException("length of ks is neither 1 nor 3");
        }
        int i10 = 0;
        while (true) {
            int[] iArr2 = this.ks;
            if (i10 < iArr2.length) {
                int i11 = iArr2[i10];
                if (i11 < 1 || i11 > m10 - 1) {
                    break;
                }
                if (i10 == 0 || i11 < iArr2[i10 - 1]) {
                    i10++;
                } else {
                    throw new IllegalArgumentException("values in ks are not in descending order");
                }
            } else {
                BigInteger bigInteger = BigInteger.ONE;
                this.rp = bigInteger;
                this.rp = bigInteger.setBit(m10);
                int j10 = 0;
                while (true) {
                    int[] iArr3 = this.ks;
                    if (j10 < iArr3.length) {
                        this.rp = this.rp.setBit(iArr3[j10]);
                        j10++;
                    } else {
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("ks[" + i10 + "] is out of range");
    }

    @Override // java.security.spec.ECField
    public int getFieldSize() {
        return this.f50405m;
    }

    public int getM() {
        return this.f50405m;
    }

    public BigInteger getReductionPolynomial() {
        return this.rp;
    }

    public int[] getMidTermsOfReductionPolynomial() {
        int[] iArr = this.ks;
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldF2m) {
            return this.f50405m == ((ECFieldF2m) obj).f50405m && Arrays.equals(this.ks, ((ECFieldF2m) obj).ks);
        }
        return false;
    }

    public int hashCode() {
        int value = this.f50405m << 5;
        BigInteger bigInteger = this.rp;
        return value + (bigInteger == null ? 0 : bigInteger.hashCode());
    }
}
