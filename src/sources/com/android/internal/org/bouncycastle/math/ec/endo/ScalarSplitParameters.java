package com.android.internal.org.bouncycastle.math.ec.endo;

import com.huawei.hms.ads.dynamicloader.b;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ScalarSplitParameters {
    protected final int bits;

    /* renamed from: g1, reason: collision with root package name */
    protected final BigInteger f9297g1;

    /* renamed from: g2, reason: collision with root package name */
    protected final BigInteger f9298g2;
    protected final BigInteger v1A;
    protected final BigInteger v1B;
    protected final BigInteger v2A;
    protected final BigInteger v2B;

    private static void checkVector(BigInteger[] v2, String name) {
        if (v2 == null || v2.length != 2 || v2[0] == null || v2[1] == null) {
            throw new IllegalArgumentException("'" + name + "' must consist of exactly 2 (non-null) values");
        }
    }

    public ScalarSplitParameters(BigInteger[] v12, BigInteger[] v2, BigInteger g12, BigInteger g22, int bits) {
        checkVector(v12, b.f29144f);
        checkVector(v2, "v2");
        this.v1A = v12[0];
        this.v1B = v12[1];
        this.v2A = v2[0];
        this.v2B = v2[1];
        this.f9297g1 = g12;
        this.f9298g2 = g22;
        this.bits = bits;
    }

    public BigInteger getV1A() {
        return this.v1A;
    }

    public BigInteger getV1B() {
        return this.v1B;
    }

    public BigInteger getV2A() {
        return this.v2A;
    }

    public BigInteger getV2B() {
        return this.v2B;
    }

    public BigInteger getG1() {
        return this.f9297g1;
    }

    public BigInteger getG2() {
        return this.f9298g2;
    }

    public int getBits() {
        return this.bits;
    }
}
