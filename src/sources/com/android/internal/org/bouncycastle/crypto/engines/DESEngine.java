package com.android.internal.org.bouncycastle.crypto.engines;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.security.common.utils.DESCoderUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.OutputLengthException;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DESEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private int[] workingKey = null;
    private static final short[] bytebit = {128, 64, 32, 16, 8, 4, 2, 1};
    private static final int[] bigbyte = {8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    private static final byte[] pc1 = {56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, Character.MATH_SYMBOL, 17, 9, 1, 58, 50, ExifInterface.START_CODE, 34, Character.CURRENCY_SYMBOL, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, Character.INITIAL_QUOTE_PUNCTUATION, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3};
    private static final byte[] totrot = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, Character.MATH_SYMBOL, 27, 28};
    private static final byte[] pc2 = {13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, Character.MATH_SYMBOL, 7, 15, 6, Character.CURRENCY_SYMBOL, 19, 12, 1, 40, 51, 30, 36, 46, 54, Character.INITIAL_QUOTE_PUNCTUATION, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31};
    private static final int[] SP1 = {16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, 65540, 16777220, 16777220, 65540, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, 65540, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, 65540, 66560, 0, 16842756};
    private static final int[] SP2 = {-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};
    private static final int[] SP3 = {MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS, 134348800, 131592, 8, 134348808, 131584};
    private static final int[] SP4 = {8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};
    private static final int[] SP5 = {256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};
    private static final int[] SP6 = {536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
    private static final int[] SP7 = {2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
    private static final int[] SP8 = {268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void init(boolean encrypting, CipherParameters params) {
        if (params instanceof KeyParameter) {
            if (((KeyParameter) params).getKey().length > 8) {
                throw new IllegalArgumentException("DES key too long - should be 8 bytes");
            }
            this.workingKey = generateWorkingKey(encrypting, ((KeyParameter) params).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to DES init - " + params.getClass().getName());
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return DESCoderUtils.SECRETFACTORY_ALGORITHM;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] in, int inOff, byte[] out, int outOff) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("DES engine not initialised");
        }
        if (inOff + 8 > in.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (outOff + 8 > out.length) {
            throw new OutputLengthException("output buffer too short");
        }
        desFunc(iArr, in, inOff, out, outOff);
        return 8;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateWorkingKey(boolean encrypting, byte[] key) {
        int m10;
        int[] newKey = new int[32];
        boolean[] pc1m = new boolean[56];
        boolean[] pcr = new boolean[56];
        int j10 = 0;
        while (true) {
            boolean z10 = false;
            if (j10 >= 56) {
                break;
            }
            int l10 = pc1[j10];
            if ((key[l10 >>> 3] & bytebit[l10 & 7]) != 0) {
                z10 = true;
            }
            pc1m[j10] = z10;
            j10++;
        }
        for (int i10 = 0; i10 < 16; i10++) {
            if (encrypting) {
                m10 = i10 << 1;
            } else {
                int m11 = 15 - i10;
                m10 = m11 << 1;
            }
            int n10 = m10 + 1;
            newKey[n10] = 0;
            newKey[m10] = 0;
            for (int j11 = 0; j11 < 28; j11++) {
                int l11 = totrot[i10] + j11;
                if (l11 < 28) {
                    pcr[j11] = pc1m[l11];
                } else {
                    pcr[j11] = pc1m[l11 - 28];
                }
            }
            for (int j12 = 28; j12 < 56; j12++) {
                int l12 = totrot[i10] + j12;
                if (l12 < 56) {
                    pcr[j12] = pc1m[l12];
                } else {
                    pcr[j12] = pc1m[l12 - 28];
                }
            }
            for (int j13 = 0; j13 < 24; j13++) {
                byte[] bArr = pc2;
                if (pcr[bArr[j13]]) {
                    newKey[m10] = newKey[m10] | bigbyte[j13];
                }
                if (pcr[bArr[j13 + 24]]) {
                    newKey[n10] = newKey[n10] | bigbyte[j13];
                }
            }
        }
        for (int i11 = 0; i11 != 32; i11 += 2) {
            int i12 = newKey[i11];
            int i22 = newKey[i11 + 1];
            newKey[i11] = ((16515072 & i22) >>> 10) | ((i12 & 16515072) << 6) | ((i12 & 4032) << 10) | ((i22 & 4032) >>> 6);
            newKey[i11 + 1] = ((258048 & i22) >>> 4) | ((i12 & 258048) << 12) | ((i12 & 63) << 16) | (i22 & 63);
        }
        return newKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void desFunc(int[] wKey, byte[] in, int inOff, byte[] out, int outOff) {
        int left = Pack.bigEndianToInt(in, inOff);
        int right = Pack.bigEndianToInt(in, inOff + 4);
        int work = ((left >>> 4) ^ right) & 252645135;
        int right2 = right ^ work;
        int left2 = left ^ (work << 4);
        int work2 = ((left2 >>> 16) ^ right2) & 65535;
        int right3 = right2 ^ work2;
        int left3 = left2 ^ (work2 << 16);
        int work3 = ((right3 >>> 2) ^ left3) & 858993459;
        int left4 = left3 ^ work3;
        int right4 = right3 ^ (work3 << 2);
        int work4 = ((right4 >>> 8) ^ left4) & 16711935;
        int left5 = left4 ^ work4;
        int right5 = right4 ^ (work4 << 8);
        int right6 = (right5 << 1) | (right5 >>> 31);
        int work5 = (left5 ^ right6) & (-1431655766);
        int left6 = left5 ^ work5;
        int right7 = right6 ^ work5;
        int left7 = (left6 << 1) | (left6 >>> 31);
        for (int round = 0; round < 8; round++) {
            int work6 = ((right7 << 28) | (right7 >>> 4)) ^ wKey[(round * 4) + 0];
            int[] iArr = SP7;
            int fval = iArr[work6 & 63];
            int[] iArr2 = SP5;
            int fval2 = fval | iArr2[(work6 >>> 8) & 63];
            int[] iArr3 = SP3;
            int fval3 = fval2 | iArr3[(work6 >>> 16) & 63];
            int[] iArr4 = SP1;
            int fval4 = fval3 | iArr4[(work6 >>> 24) & 63];
            int work7 = right7 ^ wKey[(round * 4) + 1];
            int[] iArr5 = SP8;
            int fval5 = fval4 | iArr5[work7 & 63];
            int[] iArr6 = SP6;
            int fval6 = fval5 | iArr6[(work7 >>> 8) & 63];
            int[] iArr7 = SP4;
            int fval7 = fval6 | iArr7[(work7 >>> 16) & 63];
            int[] iArr8 = SP2;
            left7 ^= fval7 | iArr8[(work7 >>> 24) & 63];
            int work8 = ((left7 << 28) | (left7 >>> 4)) ^ wKey[(round * 4) + 2];
            int fval8 = iArr[work8 & 63];
            int fval9 = work8 >>> 8;
            int fval10 = fval8 | iArr2[fval9 & 63] | iArr3[(work8 >>> 16) & 63] | iArr4[(work8 >>> 24) & 63];
            int work9 = left7 ^ wKey[(round * 4) + 3];
            right7 ^= (((fval10 | iArr5[work9 & 63]) | iArr6[(work9 >>> 8) & 63]) | iArr7[(work9 >>> 16) & 63]) | iArr8[(work9 >>> 24) & 63];
        }
        int round2 = right7 << 31;
        int right8 = round2 | (right7 >>> 1);
        int work10 = (left7 ^ right8) & (-1431655766);
        int left8 = left7 ^ work10;
        int right9 = right8 ^ work10;
        int left9 = (left8 << 31) | (left8 >>> 1);
        int work11 = ((left9 >>> 8) ^ right9) & 16711935;
        int right10 = right9 ^ work11;
        int left10 = left9 ^ (work11 << 8);
        int work12 = ((left10 >>> 2) ^ right10) & 858993459;
        int right11 = right10 ^ work12;
        int left11 = left10 ^ (work12 << 2);
        int work13 = ((right11 >>> 16) ^ left11) & 65535;
        int left12 = left11 ^ work13;
        int right12 = right11 ^ (work13 << 16);
        int work14 = ((right12 >>> 4) ^ left12) & 252645135;
        Pack.intToBigEndian(right12 ^ (work14 << 4), out, outOff);
        Pack.intToBigEndian(left12 ^ work14, out, outOff + 4);
    }
}
