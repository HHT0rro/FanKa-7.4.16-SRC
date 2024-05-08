package com.android.internal.org.bouncycastle.crypto.params;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] key) {
        super(key);
        if (isWeakKey(key, 0, key.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isWeakKey(byte[] key, int offset, int length) {
        for (int i10 = offset; i10 < length; i10 += 8) {
            if (DESParameters.isWeakKey(key, i10)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWeakKey(byte[] key, int offset) {
        return isWeakKey(key, offset, key.length - offset);
    }

    public static boolean isRealEDEKey(byte[] key, int offset) {
        return key.length == 16 ? isReal2Key(key, offset) : isReal3Key(key, offset);
    }

    public static boolean isReal2Key(byte[] key, int offset) {
        boolean isValid = false;
        for (int i10 = offset; i10 != offset + 8; i10++) {
            if (key[i10] != key[i10 + 8]) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static boolean isReal3Key(byte[] key, int offset) {
        boolean diff12 = false;
        boolean diff13 = false;
        boolean diff23 = false;
        int i10 = offset;
        while (true) {
            boolean z10 = false;
            if (i10 == offset + 8) {
                break;
            }
            diff12 |= key[i10] != key[i10 + 8];
            diff13 |= key[i10] != key[i10 + 16];
            if (key[i10 + 8] != key[i10 + 16]) {
                z10 = true;
            }
            diff23 |= z10;
            i10++;
        }
        return diff12 && diff13 && diff23;
    }
}
