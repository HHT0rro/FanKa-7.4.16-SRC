package com.android.internal.org.bouncycastle.crypto.params;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RC2Parameters extends KeyParameter {
    private int bits;

    public RC2Parameters(byte[] key) {
        this(key, key.length > 128 ? 1024 : key.length * 8);
    }

    public RC2Parameters(byte[] key, int bits) {
        super(key);
        this.bits = bits;
    }

    public int getEffectiveKeyBits() {
        return this.bits;
    }
}
