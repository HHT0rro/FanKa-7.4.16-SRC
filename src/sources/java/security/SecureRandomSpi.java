package java.security;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SecureRandomSpi implements Serializable {
    private static final long serialVersionUID = -2991854161009191830L;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGenerateSeed(int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineNextBytes(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetSeed(byte[] bArr);
}
