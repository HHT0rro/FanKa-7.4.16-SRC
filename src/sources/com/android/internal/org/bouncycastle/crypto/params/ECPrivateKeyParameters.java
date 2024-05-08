package com.android.internal.org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* renamed from: d, reason: collision with root package name */
    private final BigInteger f9227d;

    public ECPrivateKeyParameters(BigInteger d10, ECDomainParameters parameters) {
        super(true, parameters);
        this.f9227d = parameters.validatePrivateScalar(d10);
    }

    public BigInteger getD() {
        return this.f9227d;
    }
}
