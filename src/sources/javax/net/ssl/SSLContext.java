package javax.net.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import sun.security.jca.GetInstance;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SSLContext {
    private static SSLContext defaultContext;
    private final SSLContextSpi contextSpi;
    private final String protocol;
    private final Provider provider;

    protected SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        this.contextSpi = contextSpi;
        this.provider = provider;
        this.protocol = protocol;
    }

    public static synchronized SSLContext getDefault() throws NoSuchAlgorithmException {
        SSLContext sSLContext;
        synchronized (SSLContext.class) {
            if (defaultContext == null) {
                defaultContext = getInstance("Default");
            }
            sSLContext = defaultContext;
        }
        return sSLContext;
    }

    public static synchronized void setDefault(SSLContext context) {
        synchronized (SSLContext.class) {
            if (context == null) {
                throw new NullPointerException();
            }
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(new SSLPermission("setDefaultSSLContext"));
            }
            defaultContext = context;
        }
    }

    public static SSLContext getInstance(String protocol) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SSLContext", (Class<?>) SSLContextSpi.class, protocol);
        return new SSLContext((SSLContextSpi) instance.impl, instance.provider, protocol);
    }

    public static SSLContext getInstance(String protocol, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = GetInstance.getInstance("SSLContext", (Class<?>) SSLContextSpi.class, protocol, provider);
        return new SSLContext((SSLContextSpi) instance.impl, instance.provider, protocol);
    }

    public static SSLContext getInstance(String protocol, Provider provider) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SSLContext", (Class<?>) SSLContextSpi.class, protocol, provider);
        return new SSLContext((SSLContextSpi) instance.impl, instance.provider, protocol);
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom random) throws KeyManagementException {
        this.contextSpi.engineInit(km, tm, random);
    }

    public final SSLSocketFactory getSocketFactory() {
        return this.contextSpi.engineGetSocketFactory();
    }

    public final SSLServerSocketFactory getServerSocketFactory() {
        return this.contextSpi.engineGetServerSocketFactory();
    }

    public final SSLEngine createSSLEngine() {
        try {
            return this.contextSpi.engineCreateSSLEngine();
        } catch (AbstractMethodError e2) {
            UnsupportedOperationException unsup = new UnsupportedOperationException("Provider: " + ((Object) getProvider()) + " doesn't support this operation");
            unsup.initCause(e2);
            throw unsup;
        }
    }

    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        try {
            return this.contextSpi.engineCreateSSLEngine(peerHost, peerPort);
        } catch (AbstractMethodError e2) {
            UnsupportedOperationException unsup = new UnsupportedOperationException("Provider: " + ((Object) getProvider()) + " does not support this operation");
            unsup.initCause(e2);
            throw unsup;
        }
    }

    public final SSLSessionContext getServerSessionContext() {
        return this.contextSpi.engineGetServerSessionContext();
    }

    public final SSLSessionContext getClientSessionContext() {
        return this.contextSpi.engineGetClientSessionContext();
    }

    public final SSLParameters getDefaultSSLParameters() {
        return this.contextSpi.engineGetDefaultSSLParameters();
    }

    public final SSLParameters getSupportedSSLParameters() {
        return this.contextSpi.engineGetSupportedSSLParameters();
    }
}
