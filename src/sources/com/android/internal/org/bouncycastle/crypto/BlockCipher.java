package com.android.internal.org.bouncycastle.crypto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException;

    void reset();
}
