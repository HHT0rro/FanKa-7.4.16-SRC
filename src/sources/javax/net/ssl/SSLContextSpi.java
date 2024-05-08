package javax.net.ssl;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SSLContextSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLEngine engineCreateSSLEngine();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLEngine engineCreateSSLEngine(String str, int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSessionContext engineGetClientSessionContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSessionContext engineGetServerSessionContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLServerSocketFactory engineGetServerSocketFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSocketFactory engineGetSocketFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException;

    private SSLSocket getDefaultSocket() {
        try {
            SSLSocketFactory factory = engineGetSocketFactory();
            return (SSLSocket) factory.createSocket();
        } catch (IOException e2) {
            throw new UnsupportedOperationException("Could not obtain parameters", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLParameters engineGetDefaultSSLParameters() {
        SSLSocket socket = getDefaultSocket();
        return socket.getSSLParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLParameters engineGetSupportedSSLParameters() {
        SSLSocket socket = getDefaultSocket();
        SSLParameters params = new SSLParameters();
        params.setCipherSuites(socket.getSupportedCipherSuites());
        params.setProtocols(socket.getSupportedProtocols());
        return params;
    }
}
