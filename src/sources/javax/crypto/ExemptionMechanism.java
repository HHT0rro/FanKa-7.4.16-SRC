package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import sun.security.jca.GetInstance;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ExemptionMechanism {
    private ExemptionMechanismSpi exmechSpi;
    private String mechanism;
    private Provider provider;
    private boolean done = false;
    private boolean initialized = false;
    private Key keyStored = null;

    protected ExemptionMechanism(ExemptionMechanismSpi exmechSpi, Provider provider, String mechanism) {
        this.exmechSpi = exmechSpi;
        this.provider = provider;
        this.mechanism = mechanism;
    }

    public final String getName() {
        return this.mechanism;
    }

    public static final ExemptionMechanism getInstance(String algorithm) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = JceSecurity.getInstance("ExemptionMechanism", ExemptionMechanismSpi.class, algorithm);
        return new ExemptionMechanism((ExemptionMechanismSpi) instance.impl, instance.provider, algorithm);
    }

    public static final ExemptionMechanism getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = JceSecurity.getInstance("ExemptionMechanism", (Class<?>) ExemptionMechanismSpi.class, algorithm, provider);
        return new ExemptionMechanism((ExemptionMechanismSpi) instance.impl, instance.provider, algorithm);
    }

    public static final ExemptionMechanism getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = JceSecurity.getInstance("ExemptionMechanism", (Class<?>) ExemptionMechanismSpi.class, algorithm, provider);
        return new ExemptionMechanism((ExemptionMechanismSpi) instance.impl, instance.provider, algorithm);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final boolean isCryptoAllowed(Key key) throws ExemptionMechanismException {
        if (!this.done || key == null) {
            return false;
        }
        boolean ret = this.keyStored.equals(key);
        return ret;
    }

    public final int getOutputSize(int inputLen) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        if (inputLen < 0) {
            throw new IllegalArgumentException("Input size must be equal to or greater than zero");
        }
        return this.exmechSpi.engineGetOutputSize(inputLen);
    }

    public final void init(Key key) throws InvalidKeyException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key);
        this.initialized = true;
    }

    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key, params);
        this.initialized = true;
    }

    public final void init(Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key, params);
        this.initialized = true;
    }

    public final byte[] genExemptionBlob() throws IllegalStateException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        byte[] blob = this.exmechSpi.engineGenExemptionBlob();
        this.done = true;
        return blob;
    }

    public final int genExemptionBlob(byte[] output) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        int n10 = this.exmechSpi.engineGenExemptionBlob(output, 0);
        this.done = true;
        return n10;
    }

    public final int genExemptionBlob(byte[] output, int outputOffset) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        int n10 = this.exmechSpi.engineGenExemptionBlob(output, outputOffset);
        this.done = true;
        return n10;
    }
}
