package com.android.internal.org.bouncycastle.crypto.engines;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.OutputLengthException;
import com.android.internal.org.bouncycastle.crypto.StreamCipher;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState = null;

    /* renamed from: x, reason: collision with root package name */
    private int f9205x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f9206y = 0;
    private byte[] workingKey = null;

    @Override // com.android.internal.org.bouncycastle.crypto.StreamCipher
    public void init(boolean forEncryption, CipherParameters params) {
        if (params instanceof KeyParameter) {
            byte[] key = ((KeyParameter) params).getKey();
            this.workingKey = key;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC4 init - " + params.getClass().getName());
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "RC4";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte in) {
        int i10 = (this.f9205x + 1) & 255;
        this.f9205x = i10;
        byte[] bArr = this.engineState;
        int i11 = (bArr[i10] + this.f9206y) & 255;
        this.f9206y = i11;
        byte tmp = bArr[i10];
        bArr[i10] = bArr[i11];
        bArr[i11] = tmp;
        return (byte) (bArr[(bArr[i10] + tmp) & 255] ^ in);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] in, int inOff, int len, byte[] out, int outOff) {
        if (inOff + len > in.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (outOff + len > out.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i10 = 0; i10 < len; i10++) {
            int i11 = (this.f9205x + 1) & 255;
            this.f9205x = i11;
            byte[] bArr = this.engineState;
            int i12 = (bArr[i11] + this.f9206y) & 255;
            this.f9206y = i12;
            byte tmp = bArr[i11];
            bArr[i11] = bArr[i12];
            bArr[i12] = tmp;
            out[i10 + outOff] = (byte) (bArr[(bArr[i11] + tmp) & 255] ^ in[i10 + inOff]);
        }
        return len;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    private void setKey(byte[] keyBytes) {
        this.workingKey = keyBytes;
        this.f9205x = 0;
        this.f9206y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i10 = 0; i10 < 256; i10++) {
            this.engineState[i10] = (byte) i10;
        }
        int i12 = 0;
        int i22 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            int i13 = keyBytes[i12] & 255;
            byte[] bArr = this.engineState;
            i22 = (i13 + bArr[i11] + i22) & 255;
            byte tmp = bArr[i11];
            bArr[i11] = bArr[i22];
            bArr[i22] = tmp;
            i12 = (i12 + 1) % keyBytes.length;
        }
    }
}
