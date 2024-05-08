package com.android.internal.org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GLVTypeAParameters {

    /* renamed from: i, reason: collision with root package name */
    protected final BigInteger f9296i;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeAParameters(BigInteger i10, BigInteger lambda, ScalarSplitParameters splitParams) {
        this.f9296i = i10;
        this.lambda = lambda;
        this.splitParams = splitParams;
    }

    public BigInteger getI() {
        return this.f9296i;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
