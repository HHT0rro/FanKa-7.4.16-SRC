package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.CipherKeyGenerator;
import com.android.internal.org.bouncycastle.crypto.KeyGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.DESParameters;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DESKeyGenerator extends CipherKeyGenerator {
    @Override // com.android.internal.org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters param) {
        super.init(param);
        if (this.strength == 0 || this.strength == 7) {
            this.strength = 8;
        } else if (this.strength != 8) {
            throw new IllegalArgumentException("DES key must be 64 bits long.");
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] newKey = new byte[8];
        do {
            this.random.nextBytes(newKey);
            DESParameters.setOddParity(newKey);
        } while (DESParameters.isWeakKey(newKey, 0));
        return newKey;
    }
}
