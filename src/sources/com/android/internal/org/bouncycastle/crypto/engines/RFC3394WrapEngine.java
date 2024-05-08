package com.android.internal.org.bouncycastle.crypto.engines;

import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException;
import com.android.internal.org.bouncycastle.crypto.Wrapper;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithIV;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RFC3394WrapEngine implements Wrapper {
    private BlockCipher engine;
    private boolean forWrapping;
    private byte[] iv;
    private KeyParameter param;
    private boolean wrapCipherMode;

    public RFC3394WrapEngine(BlockCipher engine) {
        this(engine, false);
    }

    public RFC3394WrapEngine(BlockCipher engine, boolean useReverseDirection) {
        this.iv = new byte[]{-90, -90, -90, -90, -90, -90, -90, -90};
        this.engine = engine;
        this.wrapCipherMode = !useReverseDirection;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Wrapper
    public void init(boolean forWrapping, CipherParameters param) {
        this.forWrapping = forWrapping;
        if (param instanceof ParametersWithRandom) {
            param = ((ParametersWithRandom) param).getParameters();
        }
        if (param instanceof KeyParameter) {
            this.param = (KeyParameter) param;
        } else if (param instanceof ParametersWithIV) {
            this.iv = ((ParametersWithIV) param).getIV();
            this.param = (KeyParameter) ((ParametersWithIV) param).getParameters();
            if (this.iv.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] in, int inOff, int inLen) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        int n10 = inLen / 8;
        if (n10 * 8 != inLen) {
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        byte[] bArr = this.iv;
        byte[] block = new byte[bArr.length + inLen];
        byte[] buf = new byte[bArr.length + 8];
        System.arraycopy((Object) bArr, 0, (Object) block, 0, bArr.length);
        System.arraycopy((Object) in, inOff, (Object) block, this.iv.length, inLen);
        this.engine.init(this.wrapCipherMode, this.param);
        for (int j10 = 0; j10 != 6; j10++) {
            for (int i10 = 1; i10 <= n10; i10++) {
                System.arraycopy((Object) block, 0, (Object) buf, 0, this.iv.length);
                System.arraycopy((Object) block, i10 * 8, (Object) buf, this.iv.length, 8);
                this.engine.processBlock(buf, 0, buf, 0);
                int t2 = (n10 * j10) + i10;
                int k10 = 1;
                while (t2 != 0) {
                    byte v2 = (byte) t2;
                    int length = this.iv.length - k10;
                    buf[length] = (byte) (buf[length] ^ v2);
                    t2 >>>= 8;
                    k10++;
                }
                System.arraycopy((Object) buf, 0, (Object) block, 0, 8);
                System.arraycopy((Object) buf, 8, (Object) block, i10 * 8, 8);
            }
        }
        return block;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] in, int inOff, int inLen) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int n10 = inLen / 8;
        if (n10 * 8 != inLen) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        byte[] bArr = this.iv;
        byte[] block = new byte[inLen - bArr.length];
        byte[] a10 = new byte[bArr.length];
        int i10 = 8;
        byte[] buf = new byte[bArr.length + 8];
        System.arraycopy((Object) in, inOff, (Object) a10, 0, bArr.length);
        byte[] bArr2 = this.iv;
        System.arraycopy((Object) in, bArr2.length + inOff, (Object) block, 0, inLen - bArr2.length);
        int i11 = 1;
        this.engine.init(!this.wrapCipherMode, this.param);
        int n11 = n10 - 1;
        int j10 = 5;
        while (j10 >= 0) {
            int i12 = n11;
            while (i12 >= i11) {
                System.arraycopy((Object) a10, 0, (Object) buf, 0, this.iv.length);
                System.arraycopy((Object) block, (i12 - 1) * i10, (Object) buf, this.iv.length, i10);
                int t2 = (n11 * j10) + i12;
                int k10 = 1;
                while (t2 != 0) {
                    byte v2 = (byte) t2;
                    int length = this.iv.length - k10;
                    buf[length] = (byte) (buf[length] ^ v2);
                    t2 >>>= 8;
                    k10++;
                }
                this.engine.processBlock(buf, 0, buf, 0);
                i10 = 8;
                System.arraycopy((Object) buf, 0, (Object) a10, 0, 8);
                System.arraycopy((Object) buf, 8, (Object) block, (i12 - 1) * 8, 8);
                i12--;
                i11 = 1;
            }
            j10--;
            i11 = 1;
        }
        if (!Arrays.constantTimeAreEqual(a10, this.iv)) {
            throw new InvalidCipherTextException("checksum failed");
        }
        return block;
    }
}
