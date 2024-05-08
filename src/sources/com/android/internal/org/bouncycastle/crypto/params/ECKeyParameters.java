package com.android.internal.org.bouncycastle.crypto.params;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    /* JADX INFO: Access modifiers changed from: protected */
    public ECKeyParameters(boolean isPrivate, ECDomainParameters parameters) {
        super(isPrivate);
        if (parameters == null) {
            throw new NullPointerException("'parameters' cannot be null");
        }
        this.parameters = parameters;
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
