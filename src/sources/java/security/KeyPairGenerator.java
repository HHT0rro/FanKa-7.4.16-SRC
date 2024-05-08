package java.security;

import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import sun.security.jca.GetInstance;
import sun.security.jca.JCAUtil;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {
    private final String algorithm;
    Provider provider;

    /* JADX INFO: Access modifiers changed from: protected */
    public KeyPairGenerator(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    private static KeyPairGenerator getInstance(GetInstance.Instance instance, String algorithm) {
        KeyPairGenerator kpg;
        if (instance.impl instanceof KeyPairGenerator) {
            kpg = (KeyPairGenerator) instance.impl;
        } else {
            KeyPairGeneratorSpi spi = (KeyPairGeneratorSpi) instance.impl;
            kpg = new Delegate(spi, algorithm);
        }
        kpg.provider = instance.provider;
        return kpg;
    }

    public static KeyPairGenerator getInstance(String algorithm) throws NoSuchAlgorithmException {
        Objects.requireNonNull(algorithm, "null algorithm name");
        List<Provider.Service> list = GetInstance.getServices("KeyPairGenerator", algorithm);
        Iterator<Provider.Service> t2 = list.iterator2();
        if (!t2.hasNext()) {
            throw new NoSuchAlgorithmException(algorithm + " KeyPairGenerator not available");
        }
        NoSuchAlgorithmException failure = null;
        do {
            Provider.Service s2 = t2.next();
            try {
                GetInstance.Instance instance = GetInstance.getInstance(s2, KeyPairGeneratorSpi.class);
                if (instance.impl instanceof KeyPairGenerator) {
                    return getInstance(instance, algorithm);
                }
                return new Delegate(instance, t2, algorithm);
            } catch (NoSuchAlgorithmException e2) {
                if (failure == null) {
                    failure = e2;
                }
            }
        } while (t2.hasNext());
        throw failure;
    }

    public static KeyPairGenerator getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Objects.requireNonNull(algorithm, "null algorithm name");
        Providers.checkBouncyCastleDeprecation(provider, "KeyPairGenerator", algorithm);
        GetInstance.Instance instance = GetInstance.getInstance("KeyPairGenerator", (Class<?>) KeyPairGeneratorSpi.class, algorithm, provider);
        return getInstance(instance, algorithm);
    }

    public static KeyPairGenerator getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Objects.requireNonNull(algorithm, "null algorithm name");
        Providers.checkBouncyCastleDeprecation(provider, "KeyPairGenerator", algorithm);
        GetInstance.Instance instance = GetInstance.getInstance("KeyPairGenerator", (Class<?>) KeyPairGeneratorSpi.class, algorithm, provider);
        return getInstance(instance, algorithm);
    }

    public final Provider getProvider() {
        disableFailover();
        return this.provider;
    }

    void disableFailover() {
    }

    public void initialize(int keysize) {
        initialize(keysize, JCAUtil.getSecureRandom());
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int keysize, SecureRandom random) {
    }

    public void initialize(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        initialize(params, JCAUtil.getSecureRandom());
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
    }

    public final KeyPair genKeyPair() {
        return generateKeyPair();
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Delegate extends KeyPairGenerator {
        private static final int I_NONE = 1;
        private static final int I_PARAMS = 3;
        private static final int I_SIZE = 2;
        private int initKeySize;
        private AlgorithmParameterSpec initParams;
        private SecureRandom initRandom;
        private int initType;
        private final Object lock;
        private Iterator<Provider.Service> serviceIterator;
        private volatile KeyPairGeneratorSpi spi;

        Delegate(KeyPairGeneratorSpi spi, String algorithm) {
            super(algorithm);
            this.lock = new Object();
            this.spi = spi;
        }

        Delegate(GetInstance.Instance instance, Iterator<Provider.Service> serviceIterator, String algorithm) {
            super(algorithm);
            this.lock = new Object();
            this.spi = (KeyPairGeneratorSpi) instance.impl;
            this.provider = instance.provider;
            this.serviceIterator = serviceIterator;
            this.initType = 1;
        }

        private KeyPairGeneratorSpi nextSpi(KeyPairGeneratorSpi oldSpi, boolean reinit) {
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
                        Object inst = s2.newInstance(null);
                        if ((inst instanceof KeyPairGeneratorSpi) && !(inst instanceof KeyPairGenerator)) {
                            KeyPairGeneratorSpi spi = (KeyPairGeneratorSpi) inst;
                            if (reinit) {
                                int i10 = this.initType;
                                if (i10 == 2) {
                                    spi.initialize(this.initKeySize, this.initRandom);
                                } else if (i10 == 3) {
                                    spi.initialize(this.initParams, this.initRandom);
                                } else if (i10 != 1) {
                                    throw new AssertionError((Object) ("KeyPairGenerator initType: " + this.initType));
                                }
                            }
                            this.provider = s2.getProvider();
                            this.spi = spi;
                            return spi;
                        }
                    } catch (Exception e2) {
                    }
                }
                disableFailover();
                return null;
            }
        }

        @Override // java.security.KeyPairGenerator
        void disableFailover() {
            this.serviceIterator = null;
            this.initType = 0;
            this.initParams = null;
            this.initRandom = null;
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int keysize, SecureRandom random) {
            if (this.serviceIterator == null) {
                this.spi.initialize(keysize, random);
                return;
            }
            RuntimeException failure = null;
            KeyPairGeneratorSpi mySpi = this.spi;
            do {
                try {
                    mySpi.initialize(keysize, random);
                    this.initType = 2;
                    this.initKeySize = keysize;
                    this.initParams = null;
                    this.initRandom = random;
                    return;
                } catch (RuntimeException e2) {
                    if (failure == null) {
                        failure = e2;
                    }
                    mySpi = nextSpi(mySpi, false);
                }
            } while (mySpi != null);
            throw failure;
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
            if (this.serviceIterator == null) {
                this.spi.initialize(params, random);
                return;
            }
            Exception failure = null;
            KeyPairGeneratorSpi mySpi = this.spi;
            do {
                try {
                    mySpi.initialize(params, random);
                    this.initType = 3;
                    this.initKeySize = 0;
                    this.initParams = params;
                    this.initRandom = random;
                    return;
                } catch (Exception e2) {
                    if (failure == null) {
                        failure = e2;
                    }
                    mySpi = nextSpi(mySpi, false);
                }
            } while (mySpi != null);
            if (failure instanceof RuntimeException) {
                throw ((RuntimeException) failure);
            }
            throw ((InvalidAlgorithmParameterException) failure);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (this.serviceIterator == null) {
                return this.spi.generateKeyPair();
            }
            RuntimeException failure = null;
            KeyPairGeneratorSpi mySpi = this.spi;
            do {
                try {
                    return mySpi.generateKeyPair();
                } catch (RuntimeException e2) {
                    if (failure == null) {
                        failure = e2;
                    }
                    mySpi = nextSpi(mySpi, true);
                }
            } while (mySpi != null);
            throw failure;
        }
    }
}
