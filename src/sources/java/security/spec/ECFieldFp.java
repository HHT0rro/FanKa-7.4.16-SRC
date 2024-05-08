package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECFieldFp implements ECField {

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50406p;

    public ECFieldFp(BigInteger p10) {
        if (p10.signum() != 1) {
            throw new IllegalArgumentException("p is not positive");
        }
        this.f50406p = p10;
    }

    @Override // java.security.spec.ECField
    public int getFieldSize() {
        return this.f50406p.bitLength();
    }

    public BigInteger getP() {
        return this.f50406p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldFp) {
            return this.f50406p.equals(((ECFieldFp) obj).f50406p);
        }
        return false;
    }

    public int hashCode() {
        return this.f50406p.hashCode();
    }
}
