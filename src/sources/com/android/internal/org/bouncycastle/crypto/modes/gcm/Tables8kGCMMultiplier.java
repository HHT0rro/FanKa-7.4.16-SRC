package com.android.internal.org.bouncycastle.crypto.modes.gcm;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Pack;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Tables8kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] H) {
        if (this.T == null) {
            this.T = (long[][][]) Array.newInstance(Long.TYPE, 32, 16, 2);
        } else if (Arrays.areEqual(this.H, H)) {
            return;
        }
        this.H = Arrays.clone(H);
        for (int i10 = 0; i10 < 32; i10++) {
            long[][][] jArr = this.T;
            long[][] t2 = jArr[i10];
            if (i10 == 0) {
                GCMUtil.asLongs(this.H, t2[1]);
                GCMUtil.multiplyP3(t2[1], t2[1]);
            } else {
                GCMUtil.multiplyP4(jArr[i10 - 1][1], t2[1]);
            }
            for (int n10 = 2; n10 < 16; n10 += 2) {
                GCMUtil.divideP(t2[n10 >> 1], t2[n10]);
                GCMUtil.xor(t2[n10], t2[1], t2[n10 + 1]);
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] x10) {
        long z02 = 0;
        long z1 = 0;
        for (int i10 = 15; i10 >= 0; i10--) {
            long[][][] jArr = this.T;
            long[] u10 = jArr[i10 + i10 + 1][x10[i10] & 15];
            long[] v2 = jArr[i10 + i10][(x10[i10] & 240) >>> 4];
            z02 ^= u10[0] ^ v2[0];
            z1 ^= u10[1] ^ v2[1];
        }
        Pack.longToBigEndian(z02, x10, 0);
        Pack.longToBigEndian(z1, x10, 8);
    }
}
