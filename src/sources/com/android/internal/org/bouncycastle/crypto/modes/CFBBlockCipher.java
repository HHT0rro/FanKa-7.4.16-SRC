package com.android.internal.org.bouncycastle.crypto.modes;

import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.StreamBlockCipher;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithIV;
import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private int blockSize;
    private int byteCount;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;
    private boolean encrypting;
    private byte[] inBuf;

    public CFBBlockCipher(BlockCipher cipher, int bitBlockSize) {
        super(cipher);
        this.cipher = null;
        if (bitBlockSize > cipher.getBlockSize() * 8 || bitBlockSize < 8 || bitBlockSize % 8 != 0) {
            throw new IllegalArgumentException("CFB" + bitBlockSize + " not supported");
        }
        this.cipher = cipher;
        this.blockSize = bitBlockSize / 8;
        this.IV = new byte[cipher.getBlockSize()];
        this.cfbV = new byte[cipher.getBlockSize()];
        this.cfbOutV = new byte[cipher.getBlockSize()];
        this.inBuf = new byte[this.blockSize];
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void init(boolean encrypting, CipherParameters params) throws IllegalArgumentException {
        this.encrypting = encrypting;
        if (params instanceof ParametersWithIV) {
            ParametersWithIV ivParam = (ParametersWithIV) params;
            byte[] iv = ivParam.getIV();
            int length = iv.length;
            byte[] bArr = this.IV;
            if (length < bArr.length) {
                System.arraycopy((Object) iv, 0, (Object) bArr, bArr.length - iv.length, iv.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.IV;
                    if (i10 >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i10] = 0;
                    i10++;
                }
            } else {
                System.arraycopy((Object) iv, 0, (Object) bArr, 0, bArr.length);
            }
            reset();
            if (ivParam.getParameters() != null) {
                this.cipher.init(true, ivParam.getParameters());
                return;
            }
            return;
        }
        reset();
        if (params != null) {
            this.cipher.init(true, params);
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamBlockCipher
    protected byte calculateByte(byte in) throws DataLengthException, IllegalStateException {
        return this.encrypting ? encryptByte(in) : decryptByte(in);
    }

    private byte encryptByte(byte in) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.cfbOutV;
        int i10 = this.byteCount;
        byte rv = (byte) (bArr[i10] ^ in);
        byte[] bArr2 = this.inBuf;
        int i11 = i10 + 1;
        this.byteCount = i11;
        bArr2[i10] = rv;
        int i12 = this.blockSize;
        if (i11 == i12) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy((Object) bArr3, i12, (Object) bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i13 = this.blockSize;
            System.arraycopy((Object) bArr4, 0, (Object) bArr5, length - i13, i13);
        }
        return rv;
    }

    private byte decryptByte(byte in) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.inBuf;
        int i10 = this.byteCount;
        bArr[i10] = in;
        byte[] bArr2 = this.cfbOutV;
        int i11 = i10 + 1;
        this.byteCount = i11;
        byte rv = (byte) (bArr2[i10] ^ in);
        int i12 = this.blockSize;
        if (i11 == i12) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy((Object) bArr3, i12, (Object) bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i13 = this.blockSize;
            System.arraycopy((Object) bArr4, 0, (Object) bArr5, length - i13, i13);
        }
        return rv;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] in, int inOff, byte[] out, int outOff) throws DataLengthException, IllegalStateException {
        processBytes(in, inOff, this.blockSize, out, outOff);
        return this.blockSize;
    }

    public int encryptBlock(byte[] in, int inOff, byte[] out, int outOff) throws DataLengthException, IllegalStateException {
        processBytes(in, inOff, this.blockSize, out, outOff);
        return this.blockSize;
    }

    public int decryptBlock(byte[] in, int inOff, byte[] out, int outOff) throws DataLengthException, IllegalStateException {
        processBytes(in, inOff, this.blockSize, out, outOff);
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.cfbV);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy((Object) bArr, 0, (Object) this.cfbV, 0, bArr.length);
        Arrays.fill(this.inBuf, (byte) 0);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
