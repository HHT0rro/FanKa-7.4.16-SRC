package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.ExtendedDigest;
import com.android.internal.org.bouncycastle.crypto.PBEParametersGenerator;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* renamed from: u, reason: collision with root package name */
    private int f9207u;

    /* renamed from: v, reason: collision with root package name */
    private int f9208v;

    public PKCS12ParametersGenerator(Digest digest) {
        this.digest = digest;
        if (digest instanceof ExtendedDigest) {
            this.f9207u = digest.getDigestSize();
            this.f9208v = ((ExtendedDigest) digest).getByteLength();
            return;
        }
        throw new IllegalArgumentException("Digest " + digest.getAlgorithmName() + " unsupported");
    }

    private void adjust(byte[] a10, int aOff, byte[] b4) {
        int x10 = (b4[b4.length - 1] & 255) + (a10[(b4.length + aOff) - 1] & 255) + 1;
        a10[(b4.length + aOff) - 1] = (byte) x10;
        int x11 = x10 >>> 8;
        for (int i10 = b4.length - 2; i10 >= 0; i10--) {
            int x12 = x11 + (b4[i10] & 255) + (a10[aOff + i10] & 255);
            a10[aOff + i10] = (byte) x12;
            x11 = x12 >>> 8;
        }
    }

    private byte[] generateDerivedKey(int idByte, int n10) {
        byte[] S;
        byte[] P;
        byte[] D = new byte[this.f9208v];
        byte[] dKey = new byte[n10];
        for (int i10 = 0; i10 != D.length; i10++) {
            D[i10] = (byte) idByte;
        }
        if (this.salt != null && this.salt.length != 0) {
            int i11 = this.f9208v;
            int length = this.salt.length;
            S = new byte[i11 * (((length + r8) - 1) / this.f9208v)];
            for (int i12 = 0; i12 != S.length; i12++) {
                S[i12] = this.salt[i12 % this.salt.length];
            }
        } else {
            S = new byte[0];
        }
        if (this.password != null && this.password.length != 0) {
            int i13 = this.f9208v;
            int length2 = this.password.length;
            P = new byte[i13 * (((length2 + r9) - 1) / this.f9208v)];
            for (int i14 = 0; i14 != P.length; i14++) {
                P[i14] = this.password[i14 % this.password.length];
            }
        } else {
            P = new byte[0];
        }
        byte[] I = new byte[S.length + P.length];
        System.arraycopy((Object) S, 0, (Object) I, 0, S.length);
        System.arraycopy((Object) P, 0, (Object) I, S.length, P.length);
        byte[] B = new byte[this.f9208v];
        int i15 = this.f9207u;
        int c4 = ((n10 + i15) - 1) / i15;
        byte[] A = new byte[i15];
        for (int i16 = 1; i16 <= c4; i16++) {
            this.digest.update(D, 0, D.length);
            this.digest.update(I, 0, I.length);
            this.digest.doFinal(A, 0);
            for (int j10 = 1; j10 < this.iterationCount; j10++) {
                this.digest.update(A, 0, A.length);
                this.digest.doFinal(A, 0);
            }
            for (int j11 = 0; j11 != B.length; j11++) {
                B[j11] = A[j11 % A.length];
            }
            int j12 = 0;
            while (true) {
                int length3 = I.length;
                int i17 = this.f9208v;
                if (j12 == length3 / i17) {
                    break;
                }
                adjust(I, i17 * j12, B);
                j12++;
            }
            if (i16 == c4) {
                int i18 = this.f9207u;
                System.arraycopy((Object) A, 0, (Object) dKey, (i16 - 1) * i18, dKey.length - ((i16 - 1) * i18));
            } else {
                System.arraycopy((Object) A, 0, (Object) dKey, (i16 - 1) * this.f9207u, A.length);
            }
        }
        return dKey;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int keySize) {
        int keySize2 = keySize / 8;
        byte[] dKey = generateDerivedKey(1, keySize2);
        return new KeyParameter(dKey, 0, keySize2);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int keySize, int ivSize) {
        int keySize2 = keySize / 8;
        int ivSize2 = ivSize / 8;
        byte[] dKey = generateDerivedKey(1, keySize2);
        byte[] iv = generateDerivedKey(2, ivSize2);
        return new ParametersWithIV(new KeyParameter(dKey, 0, keySize2), iv, 0, ivSize2);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int keySize) {
        int keySize2 = keySize / 8;
        byte[] dKey = generateDerivedKey(3, keySize2);
        return new KeyParameter(dKey, 0, keySize2);
    }
}
