package javax.crypto;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Mac implements Cloneable {
    private static int warnCount = 10;
    private final String algorithm;
    private boolean initialized;
    private final Object lock;
    private Provider provider;
    private MacSpi spi;

    protected Mac(MacSpi macSpi, Provider provider, String algorithm) {
        this.initialized = false;
        this.spi = macSpi;
        this.provider = provider;
        this.algorithm = algorithm;
        this.lock = null;
    }

    private Mac(String algorithm) {
        this.initialized = false;
        this.algorithm = algorithm;
        this.lock = new Object();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public static final Mac getInstance(String algorithm) throws NoSuchAlgorithmException {
        List<Provider.Service> services = GetInstance.getServices("Mac", algorithm);
        for (Provider.Service s2 : services) {
            if (JceSecurity.canUseProvider(s2.getProvider())) {
                return new Mac(algorithm);
            }
        }
        throw new NoSuchAlgorithmException("Algorithm " + algorithm + " not available");
    }

    public static final Mac getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Providers.checkBouncyCastleDeprecation(provider, "Mac", algorithm);
        GetInstance.Instance instance = JceSecurity.getInstance("Mac", (Class<?>) MacSpi.class, algorithm, provider);
        return new Mac((MacSpi) instance.impl, instance.provider, algorithm);
    }

    public static final Mac getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Providers.checkBouncyCastleDeprecation(provider, "Mac", algorithm);
        GetInstance.Instance instance = JceSecurity.getInstance("Mac", (Class<?>) MacSpi.class, algorithm, provider);
        return new Mac((MacSpi) instance.impl, instance.provider, algorithm);
    }

    void chooseFirstProvider() {
        Object obj;
        if (this.spi != null || (obj = this.lock) == null) {
            return;
        }
        synchronized (obj) {
            if (this.spi != null) {
                return;
            }
            Exception lastException = null;
            for (Provider.Service s2 : GetInstance.getServices("Mac", this.algorithm)) {
                if (JceSecurity.canUseProvider(s2.getProvider())) {
                    try {
                        Object obj2 = s2.newInstance(null);
                        if (obj2 instanceof MacSpi) {
                            this.spi = (MacSpi) obj2;
                            this.provider = s2.getProvider();
                            return;
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        lastException = e2;
                    }
                }
            }
            ProviderException e10 = new ProviderException("Could not construct MacSpi instance");
            if (lastException == null) {
                throw e10;
            }
            e10.initCause(lastException);
            throw e10;
        }
    }

    private void chooseProvider(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        synchronized (this.lock) {
            MacSpi macSpi = this.spi;
            if (macSpi != null && (key == null || this.lock == null)) {
                macSpi.engineInit(key, params);
                return;
            }
            Exception lastException = null;
            for (Provider.Service s2 : GetInstance.getServices("Mac", this.algorithm)) {
                if (s2.supportsParameter(key) && JceSecurity.canUseProvider(s2.getProvider())) {
                    try {
                        MacSpi spi = (MacSpi) s2.newInstance(null);
                        spi.engineInit(key, params);
                        this.provider = s2.getProvider();
                        this.spi = spi;
                        return;
                    } catch (Exception e2) {
                        if (lastException == null) {
                            lastException = e2;
                        }
                    }
                }
            }
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
        chooseFirstProvider();
        return this.provider;
    }

    public final int getMacLength() {
        chooseFirstProvider();
        return this.spi.engineGetMacLength();
    }

    public final void init(Key key) throws InvalidKeyException {
        try {
            MacSpi macSpi = this.spi;
            if (macSpi != null && (key == null || this.lock == null)) {
                macSpi.engineInit(key, null);
            } else {
                chooseProvider(key, null);
            }
            this.initialized = true;
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException("init() failed", e2);
        }
    }

    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        MacSpi macSpi = this.spi;
        if (macSpi != null && (key == null || this.lock == null)) {
            macSpi.engineInit(key, params);
        } else {
            chooseProvider(key, params);
        }
        this.initialized = true;
    }

    public final void update(byte input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        this.spi.engineUpdate(input);
    }

    public final void update(byte[] input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        if (input != null) {
            this.spi.engineUpdate(input, 0, input.length);
        }
    }

    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        if (input != null) {
            if (offset < 0 || len > input.length - offset || len < 0) {
                throw new IllegalArgumentException("Bad arguments");
            }
            this.spi.engineUpdate(input, offset, len);
        }
    }

    public final void update(ByteBuffer input) {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        if (input == null) {
            throw new IllegalArgumentException("Buffer must not be null");
        }
        this.spi.engineUpdate(input);
    }

    public final byte[] doFinal() throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        byte[] mac = this.spi.engineDoFinal();
        this.spi.engineReset();
        return mac;
    }

    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        int macLen = getMacLength();
        if (output == null || output.length - outOffset < macLen) {
            throw new ShortBufferException("Cannot store MAC in output buffer");
        }
        byte[] mac = doFinal();
        System.arraycopy((Object) mac, 0, (Object) output, outOffset, macLen);
    }

    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        update(input);
        return doFinal();
    }

    public final void reset() {
        chooseFirstProvider();
        this.spi.engineReset();
    }

    public final Object clone() throws CloneNotSupportedException {
        chooseFirstProvider();
        Mac that = (Mac) super.clone();
        that.spi = (MacSpi) this.spi.clone();
        return that;
    }

    public MacSpi getCurrentSpi() {
        return this.spi;
    }
}
