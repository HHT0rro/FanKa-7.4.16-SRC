package java.security;

import dalvik.system.VMRuntime;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Objects;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AlgorithmParameters {
    private String algorithm;
    private boolean initialized = false;
    private AlgorithmParametersSpi paramSpi;
    private Provider provider;

    protected AlgorithmParameters(AlgorithmParametersSpi paramSpi, Provider provider, String algorithm) {
        this.paramSpi = paramSpi;
        this.provider = provider;
        this.algorithm = algorithm;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public static AlgorithmParameters getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        try {
            Object[] objs = Security.getImpl(algorithm, "AlgorithmParameters", (String) null);
            return new AlgorithmParameters((AlgorithmParametersSpi) objs[0], (Provider) objs[1], algorithm);
        } catch (NoSuchProviderException e2) {
            throw new NoSuchAlgorithmException(algorithm + " not found");
        }
    }

    public static AlgorithmParameters getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("missing provider");
        }
        Providers.checkBouncyCastleDeprecation(provider, "AlgorithmParameters", algorithm);
        Object[] objs = Security.getImpl(algorithm, "AlgorithmParameters", provider);
        return new AlgorithmParameters((AlgorithmParametersSpi) objs[0], (Provider) objs[1], algorithm);
    }

    public static AlgorithmParameters getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(algorithm, "null algorithm name");
        }
        if (provider == null) {
            throw new IllegalArgumentException("missing provider");
        }
        Providers.checkBouncyCastleDeprecation(provider, "AlgorithmParameters", algorithm);
        Object[] objs = Security.getImpl(algorithm, "AlgorithmParameters", provider);
        return new AlgorithmParameters((AlgorithmParametersSpi) objs[0], (Provider) objs[1], algorithm);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
        if (this.initialized) {
            throw new InvalidParameterSpecException("already initialized");
        }
        this.paramSpi.engineInit(paramSpec);
        this.initialized = true;
    }

    public final void init(byte[] params) throws IOException {
        if (this.initialized) {
            throw new IOException("already initialized");
        }
        this.paramSpi.engineInit(params);
        this.initialized = true;
    }

    public final void init(byte[] params, String format) throws IOException {
        if (this.initialized) {
            throw new IOException("already initialized");
        }
        this.paramSpi.engineInit(params, format);
        this.initialized = true;
    }

    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (!this.initialized) {
            throw new InvalidParameterSpecException("not initialized");
        }
        return (T) this.paramSpi.engineGetParameterSpec(cls);
    }

    public final byte[] getEncoded() throws IOException {
        if (!this.initialized) {
            throw new IOException("not initialized");
        }
        return this.paramSpi.engineGetEncoded();
    }

    public final byte[] getEncoded(String format) throws IOException {
        if (!this.initialized) {
            throw new IOException("not initialized");
        }
        return this.paramSpi.engineGetEncoded(format);
    }

    public final String toString() {
        if (!this.initialized) {
            return null;
        }
        return this.paramSpi.engineToString();
    }
}
