package com.android.internal.org.bouncycastle.crypto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Digest {
    int doFinal(byte[] bArr, int i10);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte b4);

    void update(byte[] bArr, int i10, int i11);
}
