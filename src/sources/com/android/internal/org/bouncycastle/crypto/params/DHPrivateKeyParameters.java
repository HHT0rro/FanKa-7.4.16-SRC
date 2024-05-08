package com.android.internal.org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f9216x;

    public DHPrivateKeyParameters(BigInteger x10, DHParameters params) {
        super(true, params);
        this.f9216x = x10;
    }

    public BigInteger getX() {
        return this.f9216x;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.f9216x.hashCode() ^ super.hashCode();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKeyParameters)) {
            return false;
        }
        DHPrivateKeyParameters other = (DHPrivateKeyParameters) obj;
        return other.getX().equals(this.f9216x) && super.equals(obj);
    }
}
