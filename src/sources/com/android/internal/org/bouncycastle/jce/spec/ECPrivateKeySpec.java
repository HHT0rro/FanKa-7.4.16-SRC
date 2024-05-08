package com.android.internal.org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECPrivateKeySpec extends ECKeySpec {

    /* renamed from: d, reason: collision with root package name */
    private BigInteger f9261d;

    public ECPrivateKeySpec(BigInteger d10, ECParameterSpec spec) {
        super(spec);
        this.f9261d = d10;
    }

    public BigInteger getD() {
        return this.f9261d;
    }
}
