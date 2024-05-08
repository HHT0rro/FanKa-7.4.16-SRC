package com.android.internal.org.bouncycastle.crypto.params;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    /* JADX INFO: Access modifiers changed from: protected */
    public DHKeyParameters(boolean isPrivate, DHParameters params) {
        super(isPrivate);
        this.params = params;
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dhKey = (DHKeyParameters) obj;
        DHParameters dHParameters = this.params;
        if (dHParameters == null) {
            return dhKey.getParameters() == null;
        }
        return dHParameters.equals(dhKey.getParameters());
    }

    public int hashCode() {
        int i10 = !isPrivate() ? 1 : 0;
        DHParameters dHParameters = this.params;
        if (dHParameters != null) {
            return i10 ^ dHParameters.hashCode();
        }
        return i10;
    }
}
