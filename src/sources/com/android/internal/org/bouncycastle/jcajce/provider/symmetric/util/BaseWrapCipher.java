package com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util;

import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException;
import com.android.internal.org.bouncycastle.crypto.Wrapper;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithIV;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import com.android.internal.org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.provider.BouncyCastleProvider;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private boolean forWrapping;
    private final JcaJceHelper helper;
    private byte[] iv;
    private int ivSize;
    protected int pbeHash;
    protected int pbeIvSize;
    protected int pbeKeySize;
    protected int pbeType;
    protected Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseWrapCipher() {
        this.availableSpecs = new Class[]{PBEParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new DefaultJcaJceHelper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseWrapCipher(Wrapper wrapEngine) {
        this(wrapEngine, 0);
    }

    protected BaseWrapCipher(Wrapper wrapEngine, int ivSize) {
        this.availableSpecs = new Class[]{PBEParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new DefaultJcaJceHelper();
        this.wrapEngine = wrapEngine;
        this.ivSize = ivSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return Arrays.clone(this.iv);
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int inputLen) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.iv != null) {
            String name = this.wrapEngine.getAlgorithmName();
            if (name.indexOf(47) >= 0) {
                name = name.substring(0, name.indexOf(47));
            }
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(name);
                this.engineParams = createParametersInstance;
                createParametersInstance.init(new IvParameterSpec(this.iv));
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.engineParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AlgorithmParameters createParametersInstance(String algorithm) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(algorithm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String mode) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + mode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String padding) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + padding + " unknown.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int opmode, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters param;
        int i10;
        if (key instanceof BCPBEKey) {
            BCPBEKey k10 = (BCPBEKey) key;
            if (params instanceof PBEParameterSpec) {
                param = PBE.Util.makePBEParameters(k10, params, this.wrapEngine.getAlgorithmName());
            } else {
                CipherParameters param2 = k10.getParam();
                if (param2 != null) {
                    param = k10.getParam();
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            }
        } else {
            param = new KeyParameter(key.getEncoded());
        }
        if (params instanceof IvParameterSpec) {
            IvParameterSpec ivSpec = (IvParameterSpec) params;
            byte[] iv = ivSpec.getIV();
            this.iv = iv;
            param = new ParametersWithIV(param, iv);
        }
        if ((param instanceof KeyParameter) && (i10 = this.ivSize) != 0 && (opmode == 3 || opmode == 1)) {
            byte[] bArr = new byte[i10];
            this.iv = bArr;
            random.nextBytes(bArr);
            param = new ParametersWithIV(param, this.iv);
        }
        if (random != null) {
            param = new ParametersWithRandom(param, random);
        }
        try {
            switch (opmode) {
                case 1:
                    this.wrapEngine.init(true, param);
                    this.wrapStream = new ErasableOutputStream();
                    this.forWrapping = true;
                    return;
                case 2:
                    this.wrapEngine.init(false, param);
                    this.wrapStream = new ErasableOutputStream();
                    this.forWrapping = false;
                    return;
                case 3:
                    this.wrapEngine.init(true, param);
                    this.wrapStream = null;
                    this.forWrapping = true;
                    return;
                case 4:
                    this.wrapEngine.init(false, param);
                    this.wrapStream = null;
                    this.forWrapping = false;
                    return;
                default:
                    throw new InvalidParameterException("Unknown mode parameter passed to init.");
            }
        } catch (Exception e2) {
            throw new InvalidKeyOrParametersException(e2.getMessage(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int opmode, Key key, AlgorithmParameters params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec paramSpec = null;
        if (params != null && (paramSpec = SpecUtil.extractSpec(params, this.availableSpecs)) == null) {
            throw new InvalidAlgorithmParameterException("can't handle parameter " + params.toString());
        }
        this.engineParams = params;
        engineInit(opmode, key, paramSpec, random);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        try {
            engineInit(opmode, key, (AlgorithmParameterSpec) null, random);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyOrParametersException(e2.getMessage(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        erasableOutputStream.write(input, inputOffset, inputLen);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        erasableOutputStream.write(input, inputOffset, inputLen);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        if (input != null) {
            erasableOutputStream.write(input, inputOffset, inputLen);
        }
        try {
            if (this.forWrapping) {
                try {
                    return this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                } catch (Exception e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                }
            }
            try {
                return this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
            } catch (InvalidCipherTextException e10) {
                throw new BadPaddingException(e10.getMessage());
            }
        } finally {
            this.wrapStream.erase();
        }
        this.wrapStream.erase();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:5:0x0007, B:9:0x000c, B:10:0x003d, B:12:0x0042, B:16:0x004d, B:17:0x0055, B:23:0x002a, B:20:0x0020, B:21:0x0029, B:26:0x0057, B:27:0x0060), top: B:4:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #1 {all -> 0x0061, blocks: (B:5:0x0007, B:9:0x000c, B:10:0x003d, B:12:0x0042, B:16:0x004d, B:17:0x0055, B:23:0x002a, B:20:0x0020, B:21:0x0029, B:26:0x0057, B:27:0x0060), top: B:4:0x0007, inners: #0, #2 }] */
    @Override // javax.crypto.CipherSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int engineDoFinal(byte[] r5, int r6, int r7, byte[] r8, int r9) throws javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.ShortBufferException {
        /*
            r4 = this;
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r0 = r4.wrapStream
            if (r0 == 0) goto L68
            r0.write(r5, r6, r7)
            boolean r0 = r4.forWrapping     // Catch: java.lang.Throwable -> L61
            r1 = 0
            if (r0 == 0) goto L2a
            com.android.internal.org.bouncycastle.crypto.Wrapper r0 = r4.wrapEngine     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r2 = r4.wrapStream     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            byte[] r2 = r2.getBuf()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r3 = r4.wrapStream     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            int r3 = r3.size()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            byte[] r0 = r0.wrap(r2, r1, r3)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L61
            goto L3d
        L1f:
            r0 = move-exception
            javax.crypto.IllegalBlockSizeException r1 = new javax.crypto.IllegalBlockSizeException     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r0.getMessage()     // Catch: java.lang.Throwable -> L61
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61
            throw r1     // Catch: java.lang.Throwable -> L61
        L2a:
            com.android.internal.org.bouncycastle.crypto.Wrapper r0 = r4.wrapEngine     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r2 = r4.wrapStream     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
            byte[] r2 = r2.getBuf()     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r3 = r4.wrapStream     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
            int r3 = r3.size()     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
            byte[] r0 = r0.unwrap(r2, r1, r3)     // Catch: com.android.internal.org.bouncycastle.crypto.InvalidCipherTextException -> L56 java.lang.Throwable -> L61
        L3d:
            int r2 = r0.length     // Catch: java.lang.Throwable -> L61
            int r2 = r2 + r9
            int r3 = r8.length     // Catch: java.lang.Throwable -> L61
            if (r2 > r3) goto L4d
            int r2 = r0.length     // Catch: java.lang.Throwable -> L61
            java.lang.System.arraycopy(r0, r1, r8, r9, r2)     // Catch: java.lang.Throwable -> L61
            int r1 = r0.length     // Catch: java.lang.Throwable -> L61
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r2 = r4.wrapStream
            r2.erase()
            return r1
        L4d:
            javax.crypto.ShortBufferException r1 = new javax.crypto.ShortBufferException     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = "output buffer too short for input."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61
            throw r1     // Catch: java.lang.Throwable -> L61
        L56:
            r0 = move-exception
            javax.crypto.BadPaddingException r1 = new javax.crypto.BadPaddingException     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r0.getMessage()     // Catch: java.lang.Throwable -> L61
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61
            throw r1     // Catch: java.lang.Throwable -> L61
        L61:
            r0 = move-exception
            com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$ErasableOutputStream r1 = r4.wrapStream
            r1.erase()
            throw r0
        L68:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "not supported in a wrapping mode"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher.engineDoFinal(byte[], int, int, byte[], int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try {
            Wrapper wrapper = this.wrapEngine;
            if (wrapper == null) {
                return engineDoFinal(encoded, 0, encoded.length);
            }
            return wrapper.wrap(encoded, 0, encoded.length);
        } catch (BadPaddingException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] encoded;
        try {
            Wrapper wrapper = this.wrapEngine;
            if (wrapper == null) {
                encoded = engineDoFinal(wrappedKey, 0, wrappedKey.length);
            } else {
                encoded = wrapper.unwrap(wrappedKey, 0, wrappedKey.length);
            }
            if (wrappedKeyType == 3) {
                return new SecretKeySpec(encoded, wrappedKeyAlgorithm);
            }
            if (wrappedKeyAlgorithm.equals("") && wrappedKeyType == 2) {
                try {
                    PrivateKeyInfo in = PrivateKeyInfo.getInstance(encoded);
                    PrivateKey privKey = BouncyCastleProvider.getPrivateKey(in);
                    if (privKey != null) {
                        return privKey;
                    }
                    throw new InvalidKeyException("algorithm " + ((Object) in.getPrivateKeyAlgorithm().getAlgorithm()) + " not supported");
                } catch (Exception e2) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
            try {
                KeyFactory kf = this.helper.createKeyFactory(wrappedKeyAlgorithm);
                if (wrappedKeyType == 1) {
                    return kf.generatePublic(new X509EncodedKeySpec(encoded));
                }
                if (wrappedKeyType == 2) {
                    return kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
                }
                throw new InvalidKeyException("Unknown key type " + wrappedKeyType);
            } catch (NoSuchProviderException e10) {
                throw new InvalidKeyException("Unknown key type " + e10.getMessage());
            } catch (InvalidKeySpecException e22) {
                throw new InvalidKeyException("Unknown key type " + e22.getMessage());
            }
        } catch (InvalidCipherTextException e11) {
            throw new InvalidKeyException(e11.getMessage());
        } catch (BadPaddingException e12) {
            throw new InvalidKeyException(e12.getMessage());
        } catch (IllegalBlockSizeException e23) {
            throw new InvalidKeyException(e23.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public byte[] getBuf() {
            return this.buf;
        }

        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InvalidKeyOrParametersException(String msg, Throwable cause) {
            super(msg);
            this.cause = cause;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }
}
