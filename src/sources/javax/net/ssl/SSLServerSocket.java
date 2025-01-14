package javax.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SSLServerSocket extends ServerSocket {
    public abstract boolean getEnableSessionCreation();

    public abstract String[] getEnabledCipherSuites();

    public abstract String[] getEnabledProtocols();

    public abstract boolean getNeedClientAuth();

    public abstract String[] getSupportedCipherSuites();

    public abstract String[] getSupportedProtocols();

    public abstract boolean getUseClientMode();

    public abstract boolean getWantClientAuth();

    public abstract void setEnableSessionCreation(boolean z10);

    public abstract void setEnabledCipherSuites(String[] strArr);

    public abstract void setEnabledProtocols(String[] strArr);

    public abstract void setNeedClientAuth(boolean z10);

    public abstract void setUseClientMode(boolean z10);

    public abstract void setWantClientAuth(boolean z10);

    protected SSLServerSocket() throws IOException {
    }

    protected SSLServerSocket(int port) throws IOException {
        super(port);
    }

    protected SSLServerSocket(int port, int backlog) throws IOException {
        super(port, backlog);
    }

    protected SSLServerSocket(int port, int backlog, InetAddress address) throws IOException {
        super(port, backlog, address);
    }

    public SSLParameters getSSLParameters() {
        SSLParameters parameters = new SSLParameters();
        parameters.setCipherSuites(getEnabledCipherSuites());
        parameters.setProtocols(getEnabledProtocols());
        if (getNeedClientAuth()) {
            parameters.setNeedClientAuth(true);
        } else if (getWantClientAuth()) {
            parameters.setWantClientAuth(true);
        }
        return parameters;
    }

    public void setSSLParameters(SSLParameters params) {
        String[] s2 = params.getCipherSuites();
        if (s2 != null) {
            setEnabledCipherSuites(s2);
        }
        String[] s10 = params.getProtocols();
        if (s10 != null) {
            setEnabledProtocols(s10);
        }
        if (params.getNeedClientAuth()) {
            setNeedClientAuth(true);
        } else if (params.getWantClientAuth()) {
            setWantClientAuth(true);
        } else {
            setWantClientAuth(false);
        }
    }

    @Override // java.net.ServerSocket
    public String toString() {
        return "SSL" + super.toString();
    }
}
