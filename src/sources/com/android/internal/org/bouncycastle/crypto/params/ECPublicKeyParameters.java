package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.math.ec.ECPoint;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: q, reason: collision with root package name */
    private final ECPoint f9228q;

    public ECPublicKeyParameters(ECPoint q10, ECDomainParameters parameters) {
        super(false, parameters);
        this.f9228q = parameters.validatePublicPoint(q10);
    }

    public ECPoint getQ() {
        return this.f9228q;
    }
}
