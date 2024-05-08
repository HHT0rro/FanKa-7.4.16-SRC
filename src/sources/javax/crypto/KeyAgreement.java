package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyAgreement {
    private static final int I_NO_PARAMS = 1;
    private static final int I_PARAMS = 2;
    private static int warnCount = 10;
    private final String algorithm;
    private final Object lock;
    private Provider provider;
    private KeyAgreementSpi spi;

    protected KeyAgreement(KeyAgreementSpi keyAgreeSpi, Provider provider, String algorithm) {
        this.spi = keyAgreeSpi;
        this.provider = provider;
        this.algorithm = algorithm;
        this.lock = null;
    }

    private KeyAgreement(String algorithm) {
        this.algorithm = algorithm;
        this.lock = new Object();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public static final KeyAgreement getInstance(String algorithm) throws NoSuchAlgorithmException {
        List<Provider.Service> services = GetInstance.getServices("KeyAgreement", algorithm);
        for (Provider.Service s2 : services) {
            if (JceSecurity.canUseProvider(s2.getProvider())) {
                return new KeyAgreement(algorithm);
            }
        }
        throw new NoSuchAlgorithmException("Algorithm " + algorithm + " not available");
    }

    public static final KeyAgreement getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Providers.checkBouncyCastleDeprecation(provider, "KeyAgreement", algorithm);
        GetInstance.Instance instance = JceSecurity.getInstance("KeyAgreement", (Class<?>) KeyAgreementSpi.class, algorithm, provider);
        return new KeyAgreement((KeyAgreementSpi) instance.impl, instance.provider, algorithm);
    }

    public static final KeyAgreement getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Providers.checkBouncyCastleDeprecation(provider, "KeyAgreement", algorithm);
        GetInstance.Instance instance = JceSecurity.getInstance("KeyAgreement", (Class<?>) KeyAgreementSpi.class, algorithm, provider);
        return new KeyAgreement((KeyAgreementSpi) instance.impl, instance.provider, algorithm);
    }

    void chooseFirstProvider() {
        if (this.spi != null) {
            return;
        }
        synchronized (this.lock) {
            if (this.spi != null) {
                return;
            }
            Exception lastException = null;
            for (Provider.Service s2 : GetInstance.getServices("KeyAgreement", this.algorithm)) {
                if (JceSecurity.canUseProvider(s2.getProvider())) {
                    try {
                        Object obj = s2.newInstance(null);
                        if (obj instanceof KeyAgreementSpi) {
                            this.spi = (KeyAgreementSpi) obj;
                            this.provider = s2.getProvider();
                            return;
                        }
                    } catch (Exception e2) {
                        lastException = e2;
                    }
                }
            }
            ProviderException e10 = new ProviderException("Could not construct KeyAgreementSpi instance");
            if (lastException == null) {
                throw e10;
            }
            e10.initCause(lastException);
            throw e10;
        }
    }

    private void implInit(KeyAgreementSpi spi, int type, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (type == 1) {
            spi.engineInit(key, random);
        } else {
            spi.engineInit(key, params, random);
        }
    }

    private void chooseProvider(int initType, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        synchronized (this.lock) {
            KeyAgreementSpi keyAgreementSpi = this.spi;
            if (keyAgreementSpi != null && key == null) {
                implInit(keyAgreementSpi, initType, key, params, random);
                return;
            }
            Exception lastException = null;
            for (Provider.Service s2 : GetInstance.getServices("KeyAgreement", this.algorithm)) {
                if (s2.supportsParameter(key) && JceSecurity.canUseProvider(s2.getProvider())) {
                    try {
                        KeyAgreementSpi spi = (KeyAgreementSpi) s2.newInstance(null);
                        implInit(spi, initType, key, params, random);
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

    public final void init(Key key) throws InvalidKeyException {
        init(key, JceSecurity.RANDOM);
    }

    public final void init(Key key, SecureRandom random) throws InvalidKeyException {
        KeyAgreementSpi keyAgreementSpi = this.spi;
        if (keyAgreementSpi != null && (key == null || this.lock == null)) {
            keyAgreementSpi.engineInit(key, random);
            return;
        }
        try {
            chooseProvider(1, key, null, random);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2);
        }
    }

    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        init(key, params, JceSecurity.RANDOM);
    }

    private String getProviderName() {
        Provider provider = this.provider;
        return provider == null ? "(no provider)" : provider.getName();
    }

    public final void init(Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        KeyAgreementSpi keyAgreementSpi = this.spi;
        if (keyAgreementSpi != null) {
            keyAgreementSpi.engineInit(key, params, random);
        } else {
            chooseProvider(2, key, params, random);
        }
    }

    public final Key doPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        chooseFirstProvider();
        return this.spi.engineDoPhase(key, lastPhase);
    }

    public final byte[] generateSecret() throws IllegalStateException {
        chooseFirstProvider();
        return this.spi.engineGenerateSecret();
    }

    public final int generateSecret(byte[] sharedSecret, int offset) throws IllegalStateException, ShortBufferException {
        chooseFirstProvider();
        return this.spi.engineGenerateSecret(sharedSecret, offset);
    }

    public final SecretKey generateSecret(String algorithm) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        chooseFirstProvider();
        return this.spi.engineGenerateSecret(algorithm);
    }
}
