package com.android.internal.org.bouncycastle.crypto.modes.gcm;

import com.android.internal.org.bouncycastle.util.Arrays;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Tables1kGCMExponentiator implements GCMExponentiator {
    private Vector lookupPowX2;

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] x10) {
        long[] y10 = GCMUtil.asLongs(x10);
        Vector vector = this.lookupPowX2;
        if (vector != null && Arrays.areEqual(y10, (long[]) vector.elementAt(0))) {
            return;
        }
        Vector vector2 = new Vector(8);
        this.lookupPowX2 = vector2;
        vector2.addElement(y10);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long pow, byte[] output) {
        long[] y10 = GCMUtil.oneAsLongs();
        int bit = 0;
        while (pow > 0) {
            if ((1 & pow) != 0) {
                ensureAvailable(bit);
                GCMUtil.multiply(y10, (long[]) this.lookupPowX2.elementAt(bit));
            }
            bit++;
            pow >>>= 1;
        }
        GCMUtil.asBytes(y10, output);
    }

    private void ensureAvailable(int bit) {
        int count = this.lookupPowX2.size();
        if (count <= bit) {
            long[] tmp = (long[]) this.lookupPowX2.elementAt(count - 1);
            do {
                tmp = Arrays.clone(tmp);
                GCMUtil.square(tmp, tmp);
                this.lookupPowX2.addElement(tmp);
                count++;
            } while (count <= bit);
        }
    }
}
