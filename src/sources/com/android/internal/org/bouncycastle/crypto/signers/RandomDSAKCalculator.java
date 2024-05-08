package com.android.internal.org.bouncycastle.crypto.signers;

import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RandomDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f9233q;
    private SecureRandom random;

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAKCalculator
    public boolean isDeterministic() {
        return false;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger n10, SecureRandom random) {
        this.f9233q = n10;
        this.random = random;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger n10, BigInteger d10, byte[] message) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAKCalculator
    public BigInteger nextK() {
        int qBitLength = this.f9233q.bitLength();
        while (true) {
            BigInteger k10 = BigIntegers.createRandomBigInteger(qBitLength, this.random);
            if (!k10.equals(ZERO) && k10.compareTo(this.f9233q) < 0) {
                return k10;
            }
        }
    }
}
