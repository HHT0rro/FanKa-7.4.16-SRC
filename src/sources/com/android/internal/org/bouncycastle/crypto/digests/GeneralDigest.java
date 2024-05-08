package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.crypto.ExtendedDigest;
import com.android.internal.org.bouncycastle.util.Memoable;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private static final int BYTE_LENGTH = 64;
    private long byteCount;
    private final byte[] xBuf;
    private int xBufOff;

    protected abstract void processBlock();

    protected abstract void processLength(long j10);

    protected abstract void processWord(byte[] bArr, int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneralDigest() {
        this.xBuf = new byte[4];
        this.xBufOff = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneralDigest(GeneralDigest t2) {
        this.xBuf = new byte[4];
        copyIn(t2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneralDigest(byte[] encodedState) {
        byte[] bArr = new byte[4];
        this.xBuf = bArr;
        System.arraycopy((Object) encodedState, 0, (Object) bArr, 0, bArr.length);
        this.xBufOff = Pack.bigEndianToInt(encodedState, 4);
        this.byteCount = Pack.bigEndianToLong(encodedState, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyIn(GeneralDigest t2) {
        byte[] bArr = t2.xBuf;
        System.arraycopy((Object) bArr, 0, (Object) this.xBuf, 0, bArr.length);
        this.xBufOff = t2.xBufOff;
        this.byteCount = t2.byteCount;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void update(byte in) {
        byte[] bArr = this.xBuf;
        int i10 = this.xBufOff;
        int i11 = i10 + 1;
        this.xBufOff = i11;
        bArr[i10] = in;
        if (i11 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount++;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void update(byte[] in, int inOff, int len) {
        int len2 = Math.max(0, len);
        int i10 = 0;
        if (this.xBufOff != 0) {
            while (true) {
                if (i10 >= len2) {
                    break;
                }
                byte[] bArr = this.xBuf;
                int i11 = this.xBufOff;
                int i12 = i11 + 1;
                this.xBufOff = i12;
                int i13 = i10 + 1;
                bArr[i11] = in[i10 + inOff];
                if (i12 != 4) {
                    i10 = i13;
                } else {
                    processWord(bArr, 0);
                    this.xBufOff = 0;
                    i10 = i13;
                    break;
                }
            }
        }
        int limit = ((len2 - i10) & (-4)) + i10;
        while (i10 < limit) {
            processWord(in, inOff + i10);
            i10 += 4;
        }
        while (i10 < len2) {
            byte[] bArr2 = this.xBuf;
            int i14 = this.xBufOff;
            this.xBufOff = i14 + 1;
            bArr2[i14] = in[i10 + inOff];
            i10++;
        }
        this.byteCount += len2;
    }

    public void finish() {
        long bitLength = this.byteCount << 3;
        update(Byte.MIN_VALUE);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        processLength(bitLength);
        processBlock();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount = 0L;
        this.xBufOff = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateState(byte[] state) {
        System.arraycopy((Object) this.xBuf, 0, (Object) state, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, state, 4);
        Pack.longToBigEndian(this.byteCount, state, 8);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }
}
