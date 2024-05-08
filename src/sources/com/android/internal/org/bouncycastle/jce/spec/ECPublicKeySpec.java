package com.android.internal.org.bouncycastle.jce.spec;

import com.android.internal.org.bouncycastle.math.ec.ECPoint;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q, reason: collision with root package name */
    private ECPoint f9262q;

    public ECPublicKeySpec(ECPoint q10, ECParameterSpec spec) {
        super(spec);
        if (q10.getCurve() != null) {
            this.f9262q = q10.normalize();
        } else {
            this.f9262q = q10;
        }
    }

    public ECPoint getQ() {
        return this.f9262q;
    }
}
