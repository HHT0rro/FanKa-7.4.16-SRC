package com.android.internal.org.bouncycastle.crypto.modes.gcm;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Pack;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Tables4kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][] T;

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] H) {
        if (this.T == null) {
            this.T = (long[][]) Array.newInstance(Long.TYPE, 256, 2);
        } else if (Arrays.areEqual(this.H, H)) {
            return;
        }
        byte[] clone = Arrays.clone(H);
        this.H = clone;
        GCMUtil.asLongs(clone, this.T[1]);
        long[] jArr = this.T[1];
        GCMUtil.multiplyP7(jArr, jArr);
        for (int n10 = 2; n10 < 256; n10 += 2) {
            long[][] jArr2 = this.T;
            GCMUtil.divideP(jArr2[n10 >> 1], jArr2[n10]);
            long[][] jArr3 = this.T;
            GCMUtil.xor(jArr3[n10], jArr3[1], jArr3[n10 + 1]);
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] x10) {
        long[] t2 = this.T[x10[15] & 255];
        long z02 = t2[0];
        long z1 = t2[1];
        for (int i10 = 14; i10 >= 0; i10--) {
            long[] t10 = this.T[x10[i10] & 255];
            long c4 = z1 << 56;
            z1 = t10[1] ^ ((z1 >>> 8) | (z02 << 56));
            z02 = (((((z02 >>> 8) ^ t10[0]) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        }
        Pack.longToBigEndian(z02, x10, 0);
        Pack.longToBigEndian(z1, x10, 8);
    }
}
