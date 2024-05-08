package com.android.internal.org.bouncycastle.crypto.modes;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface AEADCipher {
    int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException;

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i10);

    int getUpdateOutputSize(int i10);

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    void processAADByte(byte b4);

    void processAADBytes(byte[] bArr, int i10, int i11);

    int processByte(byte b4, byte[] bArr, int i10) throws DataLengthException;

    int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

    void reset();
}
