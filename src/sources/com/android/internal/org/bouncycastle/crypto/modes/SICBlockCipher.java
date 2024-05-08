package com.android.internal.org.bouncycastle.crypto.modes;

import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.SkippingStreamCipher;
import com.android.internal.org.bouncycastle.crypto.StreamBlockCipher;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithIV;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher c4) {
        super(c4);
        this.cipher = c4;
        int blockSize = c4.getBlockSize();
        this.blockSize = blockSize;
        this.IV = new byte[blockSize];
        this.counter = new byte[blockSize];
        this.counterOut = new byte[blockSize];
        this.byteCount = 0;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void init(boolean forEncryption, CipherParameters params) throws IllegalArgumentException {
        if (params instanceof ParametersWithIV) {
            ParametersWithIV ivParam = (ParametersWithIV) params;
            byte[] clone = Arrays.clone(ivParam.getIV());
            this.IV = clone;
            int i10 = this.blockSize;
            if (i10 < clone.length) {
                throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.blockSize + " bytes.");
            }
            int maxCounterSize = 8 > i10 / 2 ? i10 / 2 : 8;
            if (i10 - clone.length > maxCounterSize) {
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - maxCounterSize) + " bytes.");
            }
            if (ivParam.getParameters() != null) {
                this.cipher.init(true, ivParam.getParameters());
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] in, int inOff, byte[] out, int outOff) throws DataLengthException, IllegalStateException {
        processBytes(in, inOff, this.blockSize, out, outOff);
        return this.blockSize;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.StreamBlockCipher
    protected byte calculateByte(byte in) throws DataLengthException, IllegalStateException {
        int i10 = this.byteCount;
        if (i10 == 0) {
            this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i11 = this.byteCount;
            this.byteCount = i11 + 1;
            return (byte) (bArr[i11] ^ in);
        }
        byte[] bArr2 = this.counterOut;
        int i12 = i10 + 1;
        this.byteCount = i12;
        byte rv = (byte) (bArr2[i10] ^ in);
        if (i12 == this.counter.length) {
            this.byteCount = 0;
            incrementCounterAt(0);
            checkCounter();
        }
        return rv;
    }

    private void checkCounter() {
        if (this.IV.length < this.blockSize) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.IV;
                if (i10 != bArr.length) {
                    if (this.counter[i10] == bArr[i10]) {
                        i10++;
                    } else {
                        throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void incrementCounterAt(int pos) {
        byte b4;
        int i10 = this.counter.length - pos;
        do {
            i10--;
            if (i10 >= 0) {
                byte[] bArr = this.counter;
                b4 = (byte) (bArr[i10] + 1);
                bArr[i10] = b4;
            } else {
                return;
            }
        } while (b4 == 0);
    }

    private void incrementCounter(int offSet) {
        byte[] bArr = this.counter;
        byte old = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + offSet);
        if (old != 0 && bArr[bArr.length - 1] < old) {
            incrementCounterAt(1);
        }
    }

    private void decrementCounterAt(int pos) {
        byte b4;
        int i10 = this.counter.length - pos;
        do {
            i10--;
            if (i10 >= 0) {
                b4 = (byte) (r2[i10] - 1);
                this.counter[i10] = b4;
            } else {
                return;
            }
        } while (b4 == -1);
    }

    private void adjustCounter(long n10) {
        if (n10 >= 0) {
            long numBlocks = (this.byteCount + n10) / this.blockSize;
            long rem = numBlocks;
            if (rem > 255) {
                for (int i10 = 5; i10 >= 1; i10--) {
                    long diff = 1 << (i10 * 8);
                    while (rem >= diff) {
                        incrementCounterAt(i10);
                        rem -= diff;
                    }
                }
            }
            int i11 = (int) rem;
            incrementCounter(i11);
            this.byteCount = (int) ((this.byteCount + n10) - (this.blockSize * numBlocks));
            return;
        }
        long numBlocks2 = ((-n10) - this.byteCount) / this.blockSize;
        long rem2 = numBlocks2;
        if (rem2 > 255) {
            for (int i12 = 5; i12 >= 1; i12--) {
                long diff2 = 1 << (i12 * 8);
                while (rem2 > diff2) {
                    decrementCounterAt(i12);
                    rem2 -= diff2;
                }
            }
        }
        for (long i13 = 0; i13 != rem2; i13++) {
            decrementCounterAt(0);
        }
        int gap = (int) (this.byteCount + n10 + (this.blockSize * numBlocks2));
        if (gap >= 0) {
            this.byteCount = 0;
        } else {
            decrementCounterAt(0);
            this.byteCount = this.blockSize + gap;
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.counter, (byte) 0);
        byte[] bArr = this.IV;
        System.arraycopy((Object) bArr, 0, (Object) this.counter, 0, bArr.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.SkippingCipher
    public long skip(long numberOfBytes) {
        adjustCounter(numberOfBytes);
        checkCounter();
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return numberOfBytes;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.SkippingCipher
    public long seekTo(long position) {
        reset();
        return skip(position);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.SkippingCipher
    public long getPosition() {
        int v2;
        byte[] bArr = this.counter;
        byte[] res = new byte[bArr.length];
        System.arraycopy((Object) bArr, 0, (Object) res, 0, res.length);
        for (int i10 = res.length - 1; i10 >= 1; i10--) {
            byte[] bArr2 = this.IV;
            if (i10 < bArr2.length) {
                v2 = (res[i10] & 255) - (bArr2[i10] & 255);
            } else {
                v2 = res[i10] & 255;
            }
            if (v2 < 0) {
                int i11 = i10 - 1;
                res[i11] = (byte) (res[i11] - 1);
                v2 += 256;
            }
            res[i10] = (byte) v2;
        }
        int i12 = res.length;
        return (Pack.bigEndianToLong(res, i12 - 8) * this.blockSize) + this.byteCount;
    }
}
