package com.android.internal.org.bouncycastle.crypto.modes.gcm;

import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x, reason: collision with root package name */
    private long[] f9209x;

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] x10) {
        this.f9209x = GCMUtil.asLongs(x10);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long pow, byte[] output) {
        long[] y10 = GCMUtil.oneAsLongs();
        if (pow > 0) {
            long[] powX = Arrays.clone(this.f9209x);
            do {
                if ((1 & pow) != 0) {
                    GCMUtil.multiply(y10, powX);
                }
                GCMUtil.square(powX, powX);
                pow >>>= 1;
            } while (pow > 0);
        }
        GCMUtil.asBytes(y10, output);
    }
}
