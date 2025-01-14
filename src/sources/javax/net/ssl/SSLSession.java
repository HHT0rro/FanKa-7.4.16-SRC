package javax.net.ssl;

import java.security.Principal;
import java.security.cert.Certificate;
import javax.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SSLSession {
    int getApplicationBufferSize();

    String getCipherSuite();

    long getCreationTime();

    byte[] getId();

    long getLastAccessedTime();

    Certificate[] getLocalCertificates();

    Principal getLocalPrincipal();

    int getPacketBufferSize();

    X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException;

    Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException;

    String getPeerHost();

    int getPeerPort();

    Principal getPeerPrincipal() throws SSLPeerUnverifiedException;

    String getProtocol();

    SSLSessionContext getSessionContext();

    Object getValue(String str);

    String[] getValueNames();

    void invalidate();

    boolean isValid();

    void putValue(String str, Object obj);

    void removeValue(String str);
}
