package com.android.internal.org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GLVTypeBParameters {
    protected final BigInteger beta;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeBParameters(BigInteger beta, BigInteger lambda, BigInteger[] v12, BigInteger[] v2, BigInteger g12, BigInteger g22, int bits) {
        this.beta = beta;
        this.lambda = lambda;
        this.splitParams = new ScalarSplitParameters(v12, v2, g12, g22, bits);
    }

    public GLVTypeBParameters(BigInteger beta, BigInteger lambda, ScalarSplitParameters splitParams) {
        this.beta = beta;
        this.lambda = lambda;
        this.splitParams = splitParams;
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }

    public BigInteger getV1A() {
        return getSplitParams().getV1A();
    }

    public BigInteger getV1B() {
        return getSplitParams().getV1B();
    }

    public BigInteger getV2A() {
        return getSplitParams().getV2A();
    }

    public BigInteger getV2B() {
        return getSplitParams().getV2B();
    }

    public BigInteger getG1() {
        return getSplitParams().getG1();
    }

    public BigInteger getG2() {
        return getSplitParams().getG2();
    }

    public int getBits() {
        return getSplitParams().getBits();
    }
}
