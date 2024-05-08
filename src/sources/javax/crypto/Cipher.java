package javax.crypto;

import com.alibaba.security.common.utils.DESCoderUtils;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Cipher {
    private static final String ATTRIBUTE_MODES = "SupportedModes";
    private static final String ATTRIBUTE_PADDINGS = "SupportedPaddings";
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    private static final String KEY_USAGE_EXTENSION_OID = "2.5.29.15";
    public static final int PRIVATE_KEY = 2;
    public static final int PUBLIC_KEY = 1;
    public static final int SECRET_KEY = 3;
    public static final int UNWRAP_MODE = 4;
    public static final int WRAP_MODE = 3;
    private ExemptionMechanism exmech;
    private boolean initialized = false;
    private int opmode = 0;
    private Provider provider;
    private CipherSpi spi;
    private final SpiAndProviderUpdater spiAndProviderUpdater;
    private final String[] tokenizedTransformation;
    private final String transformation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum InitType {
        KEY,
        ALGORITHM_PARAMS,
        ALGORITHM_PARAM_SPEC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum NeedToSet {
        NONE,
        MODE,
        PADDING,
        BOTH
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cipher(CipherSpi cipherSpi, Provider provider, String transformation) {
        if (cipherSpi == null) {
            throw new NullPointerException("cipherSpi == null");
        }
        if (!(cipherSpi instanceof NullCipherSpi) && provider == null) {
            throw new NullPointerException("provider == null");
        }
        this.spi = cipherSpi;
        this.provider = provider;
        this.transformation = transformation;
        this.tokenizedTransformation = null;
        this.spiAndProviderUpdater = new SpiAndProviderUpdater(provider, cipherSpi);
    }

    private Cipher(CipherSpi cipherSpi, Provider provider, String transformation, String[] tokenizedTransformation) {
        this.spi = cipherSpi;
        this.provider = provider;
        this.transformation = transformation;
        this.tokenizedTransformation = tokenizedTransformation;
        this.spiAndProviderUpdater = new SpiAndProviderUpdater(provider, cipherSpi);
    }

    private static String[] tokenizeTransformation(String transformation) throws NoSuchAlgorithmException {
        int count;
        if (transformation == null || transformation.isEmpty()) {
            throw new NoSuchAlgorithmException("No transformation given");
        }
        String[] parts = new String[3];
        int count2 = 0;
        StringTokenizer parser = new StringTokenizer(transformation, "/");
        while (parser.hasMoreTokens() && count2 < 3) {
            try {
                count = count2 + 1;
            } catch (NoSuchElementException e2) {
            }
            try {
                parts[count2] = parser.nextToken().trim();
                count2 = count;
            } catch (NoSuchElementException e10) {
                throw new NoSuchAlgorithmException("Invalid transformation format:" + transformation);
            }
        }
        if (count2 == 0 || count2 == 2 || parser.hasMoreTokens()) {
            throw new NoSuchAlgorithmException("Invalid transformation format:" + transformation);
        }
        if (parts[0] == null || parts[0].length() == 0) {
            throw new NoSuchAlgorithmException("Invalid transformation:algorithm not specified-" + transformation);
        }
        return parts;
    }

    public static final Cipher getInstance(String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return createCipher(transformation, null);
    }

    public static final Cipher getInstance(String transformation, String provider) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
        if (provider == null || provider.length() == 0) {
            throw new IllegalArgumentException("Missing provider");
        }
        Provider p10 = Security.getProvider(provider);
        if (p10 == null) {
            throw new NoSuchProviderException("No such provider: " + provider);
        }
        return getInstance(transformation, p10);
    }

    public static final Cipher getInstance(String transformation, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider == null) {
            throw new IllegalArgumentException("Missing provider");
        }
        return createCipher(transformation, provider);
    }

    static final Cipher createCipher(String transformation, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        Providers.checkBouncyCastleDeprecation(provider, "Cipher", transformation);
        String[] tokenizedTransformation = tokenizeTransformation(transformation);
        try {
            CipherSpiAndProvider cipherSpiAndProvider = tryCombinations(null, provider, tokenizedTransformation);
            if (cipherSpiAndProvider == null) {
                if (provider == null) {
                    throw new NoSuchAlgorithmException("No provider found for " + transformation);
                }
                throw new NoSuchAlgorithmException("Provider " + provider.getName() + " does not provide " + transformation);
            }
            return new Cipher(null, provider, transformation, tokenizedTransformation);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
            throw new IllegalStateException("Key/Algorithm excepton despite not passing one", e2);
        }
    }

    void updateProviderIfNeeded() {
        try {
            this.spiAndProviderUpdater.updateAndGetSpiAndProvider(null, this.spi, this.provider);
        } catch (Exception lastException) {
            ProviderException e2 = new ProviderException("Could not construct CipherSpi instance");
            e2.initCause(lastException);
            throw e2;
        }
    }

    private void chooseProvider(InitType initType, int opmode, Key key, AlgorithmParameterSpec paramSpec, AlgorithmParameters params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            InitParams initParams = new InitParams(initType, opmode, key, random, paramSpec, params);
            this.spiAndProviderUpdater.updateAndGetSpiAndProvider(initParams, this.spi, this.provider);
        } catch (Exception lastException) {
            if (lastException instanceof InvalidKeyException) {
                throw ((InvalidKeyException) lastException);
            }
            if (lastException instanceof InvalidAlgorithmParameterException) {
                throw ((InvalidAlgorithmParameterException) lastException);
            }
            if (lastException instanceof RuntimeException) {
                throw ((RuntimeException) lastException);
            }
            String kName = key != null ? key.getClass().getName() : "(null)";
            throw new InvalidKeyException("No installed provider supports this key: " + kName, lastException);
        }
    }

    public final Provider getProvider() {
        updateProviderIfNeeded();
        return this.provider;
    }

    public final String getAlgorithm() {
        return this.transformation;
    }

    public final int getBlockSize() {
        updateProviderIfNeeded();
        return this.spi.engineGetBlockSize();
    }

    public final int getOutputSize(int inputLen) {
        if (!this.initialized && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (inputLen < 0) {
            throw new IllegalArgumentException("Input size must be equal to or greater than zero");
        }
        updateProviderIfNeeded();
        return this.spi.engineGetOutputSize(inputLen);
    }

    public final byte[] getIV() {
        updateProviderIfNeeded();
        return this.spi.engineGetIV();
    }

    public final AlgorithmParameters getParameters() {
        updateProviderIfNeeded();
        return this.spi.engineGetParameters();
    }

    public final ExemptionMechanism getExemptionMechanism() {
        updateProviderIfNeeded();
        return this.exmech;
    }

    private static void checkOpmode(int opmode) {
        if (opmode < 1 || opmode > 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
    }

    private static String getOpmodeString(int opmode) {
        switch (opmode) {
            case 1:
                return "encryption";
            case 2:
                return "decryption";
            case 3:
                return "key wrapping";
            case 4:
                return "key unwrapping";
            default:
                return "";
        }
    }

    public final void init(int opmode, Key key) throws InvalidKeyException {
        init(opmode, key, JceSecurity.RANDOM);
    }

    public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        this.initialized = false;
        checkOpmode(opmode);
        try {
            chooseProvider(InitType.KEY, opmode, key, null, null, random);
            this.initialized = true;
            this.opmode = opmode;
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2);
        }
    }

    public final void init(int opmode, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        init(opmode, key, params, JceSecurity.RANDOM);
    }

    public final void init(int opmode, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.initialized = false;
        checkOpmode(opmode);
        chooseProvider(InitType.ALGORITHM_PARAM_SPEC, opmode, key, params, null, random);
        this.initialized = true;
        this.opmode = opmode;
    }

    public final void init(int opmode, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        init(opmode, key, params, JceSecurity.RANDOM);
    }

    public final void init(int opmode, Key key, AlgorithmParameters params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.initialized = false;
        checkOpmode(opmode);
        chooseProvider(InitType.ALGORITHM_PARAMS, opmode, key, null, params, random);
        this.initialized = true;
        this.opmode = opmode;
    }

    public final void init(int opmode, Certificate certificate) throws InvalidKeyException {
        init(opmode, certificate, JceSecurity.RANDOM);
    }

    public final void init(int opmode, Certificate certificate, SecureRandom random) throws InvalidKeyException {
        X509Certificate cert;
        Set<String> critSet;
        boolean[] keyUsageInfo;
        this.initialized = false;
        checkOpmode(opmode);
        if ((certificate instanceof X509Certificate) && (critSet = (cert = (X509Certificate) certificate).getCriticalExtensionOIDs()) != null && !critSet.isEmpty() && critSet.contains(KEY_USAGE_EXTENSION_OID) && (keyUsageInfo = cert.getKeyUsage()) != null && ((opmode == 1 && keyUsageInfo.length > 3 && !keyUsageInfo[3]) || (opmode == 3 && keyUsageInfo.length > 2 && !keyUsageInfo[2]))) {
            throw new InvalidKeyException("Wrong key usage");
        }
        PublicKey publicKey = certificate == null ? null : certificate.getPublicKey();
        try {
            chooseProvider(InitType.KEY, opmode, publicKey, null, null, random);
            this.initialized = true;
            this.opmode = opmode;
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2);
        }
    }

    private void checkCipherState() {
        if (!(this instanceof NullCipher)) {
            if (!this.initialized) {
                throw new IllegalStateException("Cipher not initialized");
            }
            int i10 = this.opmode;
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("Cipher not initialized for encryption/decryption");
            }
        }
    }

    public final byte[] update(byte[] input) {
        checkCipherState();
        if (input == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        updateProviderIfNeeded();
        if (input.length == 0) {
            return null;
        }
        return this.spi.engineUpdate(input, 0, input.length);
    }

    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return null;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen);
    }

    public final int update(byte[] input, int inputOffset, int inputLen, byte[] output) throws ShortBufferException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return 0;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen, output, 0);
    }

    public final int update(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0 || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return 0;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen, output, outputOffset);
    }

    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        checkCipherState();
        if (input == null || output == null) {
            throw new IllegalArgumentException("Buffers must not be null");
        }
        if (input == output) {
            throw new IllegalArgumentException("Input and output buffers must not be the same object, consider using buffer.duplicate()");
        }
        if (output.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        updateProviderIfNeeded();
        return this.spi.engineUpdate(input, output);
    }

    public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(null, 0, 0);
    }

    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        checkCipherState();
        if (output == null || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(null, 0, 0, output, outputOffset);
    }

    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, 0, input.length);
    }

    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen);
    }

    public final int doFinal(byte[] input, int inputOffset, int inputLen, byte[] output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen, output, 0);
    }

    public final int doFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0 || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen, output, outputOffset);
    }

    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || output == null) {
            throw new IllegalArgumentException("Buffers must not be null");
        }
        if (input == output) {
            throw new IllegalArgumentException("Input and output buffers must not be the same object, consider using buffer.duplicate()");
        }
        if (output.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, output);
    }

    public final byte[] wrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (!(this instanceof NullCipher)) {
            if (!this.initialized) {
                throw new IllegalStateException("Cipher not initialized");
            }
            if (this.opmode != 3) {
                throw new IllegalStateException("Cipher not initialized for wrapping keys");
            }
        }
        updateProviderIfNeeded();
        return this.spi.engineWrap(key);
    }

    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        if (!(this instanceof NullCipher)) {
            if (!this.initialized) {
                throw new IllegalStateException("Cipher not initialized");
            }
            if (this.opmode != 4) {
                throw new IllegalStateException("Cipher not initialized for unwrapping keys");
            }
        }
        if (wrappedKeyType != 3 && wrappedKeyType != 2 && wrappedKeyType != 1) {
            throw new InvalidParameterException("Invalid key type");
        }
        updateProviderIfNeeded();
        return this.spi.engineUnwrap(wrappedKey, wrappedKeyAlgorithm, wrappedKeyType);
    }

    private AlgorithmParameterSpec getAlgorithmParameterSpec(AlgorithmParameters params) throws InvalidParameterSpecException {
        if (params == null) {
            return null;
        }
        String alg = params.getAlgorithm().toUpperCase(Locale.ENGLISH);
        if (alg.equalsIgnoreCase("RC2")) {
            return params.getParameterSpec(RC2ParameterSpec.class);
        }
        if (alg.equalsIgnoreCase("RC5")) {
            return params.getParameterSpec(RC5ParameterSpec.class);
        }
        if (alg.startsWith("PBE")) {
            return params.getParameterSpec(PBEParameterSpec.class);
        }
        if (!alg.startsWith(DESCoderUtils.SECRETFACTORY_ALGORITHM)) {
            return null;
        }
        return params.getParameterSpec(IvParameterSpec.class);
    }

    public static final int getMaxAllowedKeyLength(String transformation) throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException("transformation == null");
        }
        tokenizeTransformation(transformation);
        return Integer.MAX_VALUE;
    }

    public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(String transformation) throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException("transformation == null");
        }
        tokenizeTransformation(transformation);
        return null;
    }

    public final void updateAAD(byte[] src) {
        if (src == null) {
            throw new IllegalArgumentException("src buffer is null");
        }
        updateAAD(src, 0, src.length);
    }

    public final void updateAAD(byte[] src, int offset, int len) {
        checkCipherState();
        if (src == null || offset < 0 || len < 0 || len + offset > src.length) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (len == 0) {
            return;
        }
        this.spi.engineUpdateAAD(src, offset, len);
    }

    public final void updateAAD(ByteBuffer src) {
        checkCipherState();
        if (src == null) {
            throw new IllegalArgumentException("src ByteBuffer is null");
        }
        updateProviderIfNeeded();
        if (src.remaining() == 0) {
            return;
        }
        this.spi.engineUpdateAAD(src);
    }

    public CipherSpi getCurrentSpi() {
        return this.spi;
    }

    static boolean matchAttribute(Provider.Service service, String attr, String value) {
        String pattern;
        if (value == null || (pattern = service.getAttribute(attr)) == null) {
            return true;
        }
        String valueUc = value.toUpperCase(Locale.US);
        return valueUc.matches(pattern.toUpperCase(Locale.US));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Transform {
        private final String name;
        private final NeedToSet needToSet;

        public Transform(String name, NeedToSet needToSet) {
            this.name = name;
            this.needToSet = needToSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class InitParams {
        final InitType initType;
        final Key key;
        final int opmode;
        final AlgorithmParameters params;
        final SecureRandom random;
        final AlgorithmParameterSpec spec;

        InitParams(InitType initType, int opmode, Key key, SecureRandom random, AlgorithmParameterSpec spec, AlgorithmParameters params) {
            this.initType = initType;
            this.opmode = opmode;
            this.key = key;
            this.random = random;
            this.spec = spec;
            this.params = params;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class SpiAndProviderUpdater {
        private final Object initSpiLock = new Object();
        private final Provider specifiedProvider;
        private final CipherSpi specifiedSpi;

        SpiAndProviderUpdater(Provider specifiedProvider, CipherSpi specifiedSpi) {
            this.specifiedProvider = specifiedProvider;
            this.specifiedSpi = specifiedSpi;
        }

        void setCipherSpiImplAndProvider(CipherSpi cipherSpi, Provider provider) {
            Cipher.this.spi = cipherSpi;
            Cipher.this.provider = provider;
        }

        CipherSpiAndProvider updateAndGetSpiAndProvider(InitParams initParams, CipherSpi spiImpl, Provider provider) throws InvalidKeyException, InvalidAlgorithmParameterException {
            CipherSpi cipherSpi = this.specifiedSpi;
            if (cipherSpi != null) {
                return new CipherSpiAndProvider(cipherSpi, provider);
            }
            synchronized (this.initSpiLock) {
                if (spiImpl != null && initParams == null) {
                    return new CipherSpiAndProvider(spiImpl, provider);
                }
                CipherSpiAndProvider sap = Cipher.tryCombinations(initParams, this.specifiedProvider, Cipher.this.tokenizedTransformation);
                if (sap == null) {
                    throw new ProviderException("No provider found for " + Arrays.toString(Cipher.this.tokenizedTransformation));
                }
                setCipherSpiImplAndProvider(sap.cipherSpi, sap.provider);
                return new CipherSpiAndProvider(sap.cipherSpi, sap.provider);
            }
        }

        CipherSpiAndProvider updateAndGetSpiAndProvider(CipherSpi spiImpl, Provider provider) {
            try {
                return updateAndGetSpiAndProvider(null, spiImpl, provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new ProviderException("Exception thrown when params == null", e2);
            }
        }

        CipherSpi getCurrentSpi(CipherSpi spiImpl) {
            CipherSpi cipherSpi = this.specifiedSpi;
            if (cipherSpi != null) {
                return cipherSpi;
            }
            synchronized (this.initSpiLock) {
            }
            return spiImpl;
        }
    }

    static CipherSpiAndProvider tryCombinations(InitParams initParams, Provider provider, String[] tokenizedTransformation) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transforms = new ArrayList<>();
        if (tokenizedTransformation[1] != null && tokenizedTransformation[2] != null) {
            transforms.add(new Transform(tokenizedTransformation[0] + "/" + tokenizedTransformation[1] + "/" + tokenizedTransformation[2], NeedToSet.NONE));
        }
        if (tokenizedTransformation[1] != null) {
            transforms.add(new Transform(tokenizedTransformation[0] + "/" + tokenizedTransformation[1], NeedToSet.PADDING));
        }
        if (tokenizedTransformation[2] != null) {
            transforms.add(new Transform(tokenizedTransformation[0] + "//" + tokenizedTransformation[2], NeedToSet.MODE));
        }
        transforms.add(new Transform(tokenizedTransformation[0], NeedToSet.BOTH));
        Exception cause = null;
        if (provider != null) {
            Iterator<Transform> iterator2 = transforms.iterator2();
            while (iterator2.hasNext()) {
                Transform transform = iterator2.next();
                Provider.Service service = provider.getService("Cipher", transform.name);
                if (service != null) {
                    return tryTransformWithProvider(initParams, tokenizedTransformation, transform.needToSet, service);
                }
            }
        } else {
            for (Provider prov : Security.getProviders()) {
                Iterator<Transform> iterator22 = transforms.iterator2();
                while (iterator22.hasNext()) {
                    Transform transform2 = iterator22.next();
                    Provider.Service service2 = prov.getService("Cipher", transform2.name);
                    if (service2 != null && (initParams == null || initParams.key == null || service2.supportsParameter(initParams.key))) {
                        try {
                            CipherSpiAndProvider sap = tryTransformWithProvider(initParams, tokenizedTransformation, transform2.needToSet, service2);
                            if (sap != null) {
                                return sap;
                            }
                        } catch (Exception e2) {
                            if (cause == null) {
                                cause = e2;
                            }
                        }
                    }
                }
            }
        }
        if (cause instanceof InvalidKeyException) {
            throw ((InvalidKeyException) cause);
        }
        if (cause instanceof InvalidAlgorithmParameterException) {
            throw ((InvalidAlgorithmParameterException) cause);
        }
        if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        }
        if (cause != null) {
            throw new InvalidKeyException("No provider can be initialized with given key", cause);
        }
        if (initParams == null || initParams.key == null) {
            return null;
        }
        throw new InvalidKeyException("No provider offers " + Arrays.toString(tokenizedTransformation) + " for " + initParams.key.getAlgorithm() + " key of class " + initParams.key.getClass().getName() + " and export format " + initParams.key.getFormat());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CipherSpiAndProvider {
        CipherSpi cipherSpi;
        Provider provider;

        CipherSpiAndProvider(CipherSpi cipherSpi, Provider provider) {
            this.cipherSpi = cipherSpi;
            this.provider = provider;
        }
    }

    static CipherSpiAndProvider tryTransformWithProvider(InitParams initParams, String[] tokenizedTransformation, NeedToSet type, Provider.Service service) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            if (matchAttribute(service, ATTRIBUTE_MODES, tokenizedTransformation[1]) && matchAttribute(service, ATTRIBUTE_PADDINGS, tokenizedTransformation[2])) {
                CipherSpiAndProvider sap = new CipherSpiAndProvider((CipherSpi) service.newInstance(null), service.getProvider());
                if (sap.cipherSpi != null && sap.provider != null) {
                    CipherSpi spi = sap.cipherSpi;
                    if ((type == NeedToSet.MODE || type == NeedToSet.BOTH) && tokenizedTransformation[1] != null) {
                        spi.engineSetMode(tokenizedTransformation[1]);
                    }
                    if ((type == NeedToSet.PADDING || type == NeedToSet.BOTH) && tokenizedTransformation[2] != null) {
                        spi.engineSetPadding(tokenizedTransformation[2]);
                    }
                    if (initParams != null) {
                        switch (AnonymousClass1.$SwitchMap$javax$crypto$Cipher$InitType[initParams.initType.ordinal()]) {
                            case 1:
                                spi.engineInit(initParams.opmode, initParams.key, initParams.params, initParams.random);
                                break;
                            case 2:
                                spi.engineInit(initParams.opmode, initParams.key, initParams.spec, initParams.random);
                                break;
                            case 3:
                                spi.engineInit(initParams.opmode, initParams.key, initParams.random);
                                break;
                            default:
                                throw new AssertionError((Object) "This should never be reached");
                        }
                    }
                    return new CipherSpiAndProvider(spi, sap.provider);
                }
                return null;
            }
            return null;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: javax.crypto.Cipher$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$crypto$Cipher$InitType;

        static {
            int[] iArr = new int[InitType.values().length];
            $SwitchMap$javax$crypto$Cipher$InitType = iArr;
            try {
                iArr[InitType.ALGORITHM_PARAMS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$crypto$Cipher$InitType[InitType.ALGORITHM_PARAM_SPEC.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$javax$crypto$Cipher$InitType[InitType.KEY.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }
}
