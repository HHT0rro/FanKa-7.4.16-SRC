package com.android.internal.org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f9223x;

    public DSAPrivateKeyParameters(BigInteger x10, DSAParameters params) {
        super(true, params);
        this.f9223x = x10;
    }

    public BigInteger getX() {
        return this.f9223x;
    }
}
