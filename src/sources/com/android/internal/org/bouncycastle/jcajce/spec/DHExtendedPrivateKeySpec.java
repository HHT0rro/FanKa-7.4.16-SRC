package com.android.internal.org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHExtendedPrivateKeySpec extends DHPrivateKeySpec {
    private final DHParameterSpec params;

    public DHExtendedPrivateKeySpec(BigInteger x10, DHParameterSpec params) {
        super(x10, params.getP(), params.getG());
        this.params = params;
    }

    public DHParameterSpec getParams() {
        return this.params;
    }
}
