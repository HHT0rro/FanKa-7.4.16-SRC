package java.security;

import dalvik.system.VMRuntime;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyFactory {
    private static final Debug debug = Debug.getInstance("jca", "KeyFactory");
    private final String algorithm;
    private final Object lock = new Object();
    private Provider provider;
    private Iterator<Provider.Service> serviceIterator;
    private volatile KeyFactorySpi spi;

    protected KeyFactory(KeyFactorySpi keyFacSpi, Provider provider, String algorithm) {
        this.spi = keyFacSpi;
        this.provider = provider;
        this.algorithm = algorithm;
    }

    private KeyFactory(String algorithm) throws NoSuchAlgorithmException {
        this.algorithm = algorithm;
        List<Provider.Service> list = GetInstance.getServices("KeyFactory", algorithm);
        this.serviceIterator = list.iterator2();
        if (nextSpi(null) == null) {
            throw new NoSuchAlgorithmException(algorithm + " KeyFactory not available");
        }
    }

    public static KeyFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        return new KeyFactory(algorithm);
    }

    public static KeyFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        Providers.checkBouncyCastleDeprecation(provider, "KeyFactory", algorithm);
        GetInstance.Instance instance = GetInstance.getInstance("KeyFactory", (Class<?>) KeyFactorySpi.class, algorithm, provider);
        return new KeyFactory((KeyFactorySpi) instance.impl, instance.provider, algorithm);
    }

    public static KeyFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        Providers.checkBouncyCastleDeprecation(provider, "KeyFactory", algorithm);
        GetInstance.Instance instance = GetInstance.getInstance("KeyFactory", (Class<?>) KeyFactorySpi.class, algorithm, provider);
        return new KeyFactory((KeyFactorySpi) instance.impl, instance.provider, algorithm);
    }

    public final Provider getProvider() {
        Provider provider;
        synchronized (this.lock) {
            this.serviceIterator = null;
            provider = this.provider;
        }
        return provider;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    private KeyFactorySpi nextSpi(KeyFactorySpi oldSpi) {
        Object obj;
        synchronized (this.lock) {
            if (oldSpi != null) {
                if (oldSpi != this.spi) {
                    return this.spi;
                }
            }
            if (this.serviceIterator == null) {
                return null;
            }
            while (this.serviceIterator.hasNext()) {
                Provider.Service s2 = this.serviceIterator.next();
                try {
                    obj = s2.newInstance(null);
                } catch (NoSuchAlgorithmException e2) {
                }
                if (obj instanceof KeyFactorySpi) {
                    KeyFactorySpi spi = (KeyFactorySpi) obj;
                    this.provider = s2.getProvider();
                    this.spi = spi;
                    return spi;
                }
            }
            this.serviceIterator = null;
            return null;
        }
    }

    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (this.serviceIterator == null) {
            return this.spi.engineGeneratePublic(keySpec);
        }
        Exception failure = null;
        KeyFactorySpi mySpi = this.spi;
        do {
            try {
                return mySpi.engineGeneratePublic(keySpec);
            } catch (Exception e2) {
                if (failure == null) {
                    failure = e2;
                }
                mySpi = nextSpi(mySpi);
            }
        } while (mySpi != null);
        if (failure instanceof RuntimeException) {
            throw ((RuntimeException) failure);
        }
        if (failure instanceof InvalidKeySpecException) {
            throw ((InvalidKeySpecException) failure);
        }
        throw new InvalidKeySpecException("Could not generate public key", failure);
    }

    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (this.serviceIterator == null) {
            return this.spi.engineGeneratePrivate(keySpec);
        }
        Exception failure = null;
        KeyFactorySpi mySpi = this.spi;
        do {
            try {
                return mySpi.engineGeneratePrivate(keySpec);
            } catch (Exception e2) {
                if (failure == null) {
                    failure = e2;
                }
                mySpi = nextSpi(mySpi);
            }
        } while (mySpi != null);
        if (failure instanceof RuntimeException) {
            throw ((RuntimeException) failure);
        }
        if (failure instanceof InvalidKeySpecException) {
            throw ((InvalidKeySpecException) failure);
        }
        throw new InvalidKeySpecException("Could not generate private key", failure);
    }

    public final <T extends KeySpec> T getKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException {
        if (this.serviceIterator == null) {
            return (T) this.spi.engineGetKeySpec(key, cls);
        }
        Exception exc = null;
        KeyFactorySpi keyFactorySpi = this.spi;
        do {
            try {
                return (T) keyFactorySpi.engineGetKeySpec(key, cls);
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
                keyFactorySpi = nextSpi(keyFactorySpi);
            }
        } while (keyFactorySpi != null);
        if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        }
        if (exc instanceof InvalidKeySpecException) {
            throw ((InvalidKeySpecException) exc);
        }
        throw new InvalidKeySpecException("Could not get key spec", exc);
    }

    public final Key translateKey(Key key) throws InvalidKeyException {
        if (this.serviceIterator == null) {
            return this.spi.engineTranslateKey(key);
        }
        Exception failure = null;
        KeyFactorySpi mySpi = this.spi;
        do {
            try {
                return mySpi.engineTranslateKey(key);
            } catch (Exception e2) {
                if (failure == null) {
                    failure = e2;
                }
                mySpi = nextSpi(mySpi);
            }
        } while (mySpi != null);
        if (failure instanceof RuntimeException) {
            throw ((RuntimeException) failure);
        }
        if (failure instanceof InvalidKeyException) {
            throw ((InvalidKeyException) failure);
        }
        throw new InvalidKeyException("Could not translate key", failure);
    }
}
