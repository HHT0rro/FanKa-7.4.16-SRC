package com.android.internal.org.bouncycastle.crypto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

    void reset();

    byte returnByte(byte b4);
}
