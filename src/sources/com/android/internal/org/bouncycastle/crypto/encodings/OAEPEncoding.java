package com.android.internal.org.bouncycastle.crypto.encodings;

import com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException;
import com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactory;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher cipher) {
        this(cipher, AndroidDigestFactory.getSHA1(), null);
    }

    public OAEPEncoding(AsymmetricBlockCipher cipher, Digest hash) {
        this(cipher, hash, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher cipher, Digest hash, byte[] encodingParams) {
        this(cipher, hash, hash, encodingParams);
    }

    public OAEPEncoding(AsymmetricBlockCipher cipher, Digest hash, Digest mgf1Hash, byte[] encodingParams) {
        this.engine = cipher;
        this.mgf1Hash = mgf1Hash;
        this.defHash = new byte[hash.getDigestSize()];
        hash.reset();
        if (encodingParams != null) {
            hash.update(encodingParams, 0, encodingParams.length);
        }
        hash.doFinal(this.defHash, 0);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean forEncryption, CipherParameters param) {
        if (param instanceof ParametersWithRandom) {
            ParametersWithRandom rParam = (ParametersWithRandom) param;
            this.random = rParam.getRandom();
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        this.engine.init(forEncryption, param);
        this.forEncryption = forEncryption;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int baseBlockSize = this.engine.getInputBlockSize();
        if (this.forEncryption) {
            return (baseBlockSize - 1) - (this.defHash.length * 2);
        }
        return baseBlockSize;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int baseBlockSize = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return baseBlockSize;
        }
        return (baseBlockSize - 1) - (this.defHash.length * 2);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] in, int inOff, int inLen) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(in, inOff, inLen);
        }
        return decodeBlock(in, inOff, inLen);
    }

    public byte[] encodeBlock(byte[] in, int inOff, int inLen) throws InvalidCipherTextException {
        if (inLen > getInputBlockSize()) {
            throw new DataLengthException("input data too long");
        }
        byte[] block = new byte[getInputBlockSize() + 1 + (this.defHash.length * 2)];
        System.arraycopy((Object) in, inOff, (Object) block, block.length - inLen, inLen);
        block[(block.length - inLen) - 1] = 1;
        byte[] bArr = this.defHash;
        System.arraycopy((Object) bArr, 0, (Object) block, bArr.length, bArr.length);
        byte[] seed = new byte[this.defHash.length];
        this.random.nextBytes(seed);
        byte[] mask = maskGeneratorFunction1(seed, 0, seed.length, block.length - this.defHash.length);
        for (int i10 = this.defHash.length; i10 != block.length; i10++) {
            block[i10] = (byte) (block[i10] ^ mask[i10 - this.defHash.length]);
        }
        System.arraycopy((Object) seed, 0, (Object) block, 0, this.defHash.length);
        byte[] bArr2 = this.defHash;
        byte[] mask2 = maskGeneratorFunction1(block, bArr2.length, block.length - bArr2.length, bArr2.length);
        for (int i11 = 0; i11 != this.defHash.length; i11++) {
            block[i11] = (byte) (block[i11] ^ mask2[i11]);
        }
        return this.engine.processBlock(block, 0, block.length);
    }

    public byte[] decodeBlock(byte[] in, int inOff, int inLen) throws InvalidCipherTextException {
        byte[] bArr;
        byte[] bArr2;
        byte[] data = this.engine.processBlock(in, inOff, inLen);
        byte[] block = new byte[this.engine.getOutputBlockSize()];
        boolean wrongData = block.length < (this.defHash.length * 2) + 1;
        if (data.length <= block.length) {
            System.arraycopy((Object) data, 0, (Object) block, block.length - data.length, data.length);
        } else {
            System.arraycopy((Object) data, 0, (Object) block, 0, block.length);
            wrongData = true;
        }
        byte[] bArr3 = this.defHash;
        byte[] mask = maskGeneratorFunction1(block, bArr3.length, block.length - bArr3.length, bArr3.length);
        int i10 = 0;
        while (true) {
            bArr = this.defHash;
            if (i10 == bArr.length) {
                break;
            }
            block[i10] = (byte) (block[i10] ^ mask[i10]);
            i10++;
        }
        int i11 = bArr.length;
        byte[] mask2 = maskGeneratorFunction1(block, 0, i11, block.length - bArr.length);
        for (int i12 = this.defHash.length; i12 != block.length; i12++) {
            block[i12] = (byte) (block[i12] ^ mask2[i12 - this.defHash.length]);
        }
        boolean defHashWrong = false;
        int i13 = 0;
        while (true) {
            bArr2 = this.defHash;
            if (i13 == bArr2.length) {
                break;
            }
            if (bArr2[i13] != block[bArr2.length + i13]) {
                defHashWrong = true;
            }
            i13++;
        }
        int start = block.length;
        for (int index = bArr2.length * 2; index != block.length; index++) {
            if ((block[index] != 0) & (start == block.length)) {
                start = index;
            }
        }
        int index2 = block.length;
        boolean dataStartWrong = (start > index2 - 1) | (block[start] != 1);
        int start2 = start + 1;
        if (defHashWrong | wrongData | dataStartWrong) {
            Arrays.fill(block, (byte) 0);
            throw new InvalidCipherTextException("data wrong");
        }
        byte[] output = new byte[block.length - start2];
        System.arraycopy((Object) block, start2, (Object) output, 0, output.length);
        Arrays.fill(block, (byte) 0);
        return output;
    }

    private void ItoOSP(int i10, byte[] sp) {
        sp[0] = (byte) (i10 >>> 24);
        sp[1] = (byte) (i10 >>> 16);
        sp[2] = (byte) (i10 >>> 8);
        sp[3] = (byte) (i10 >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] Z, int zOff, int zLen, int length) {
        byte[] mask = new byte[length];
        byte[] hashBuf = new byte[this.mgf1Hash.getDigestSize()];
        byte[] C = new byte[4];
        int counter = 0;
        this.mgf1Hash.reset();
        while (counter < length / hashBuf.length) {
            ItoOSP(counter, C);
            this.mgf1Hash.update(Z, zOff, zLen);
            this.mgf1Hash.update(C, 0, C.length);
            this.mgf1Hash.doFinal(hashBuf, 0);
            System.arraycopy((Object) hashBuf, 0, (Object) mask, hashBuf.length * counter, hashBuf.length);
            counter++;
        }
        if (hashBuf.length * counter < length) {
            ItoOSP(counter, C);
            this.mgf1Hash.update(Z, zOff, zLen);
            this.mgf1Hash.update(C, 0, C.length);
            this.mgf1Hash.doFinal(hashBuf, 0);
            System.arraycopy((Object) hashBuf, 0, (Object) mask, hashBuf.length * counter, mask.length - (hashBuf.length * counter));
        }
        return mask;
    }
}
