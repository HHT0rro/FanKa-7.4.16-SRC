package com.android.internal.org.bouncycastle.crypto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Wrapper {
    String getAlgorithmName();

    void init(boolean z10, CipherParameters cipherParameters);

    byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException;

    byte[] wrap(byte[] bArr, int i10, int i11);
}
