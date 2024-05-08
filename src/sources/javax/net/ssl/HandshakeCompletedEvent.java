package javax.net.ssl;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HandshakeCompletedEvent extends EventObject {
    private static final long serialVersionUID = 7914963744257769778L;
    private transient SSLSession session;

    public HandshakeCompletedEvent(SSLSocket sock, SSLSession s2) {
        super(sock);
        this.session = s2;
    }

    public SSLSession getSession() {
        return this.session;
    }

    public String getCipherSuite() {
        return this.session.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.session.getLocalCertificates();
    }

    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return this.session.getPeerCertificates();
    }

    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return this.session.getPeerCertificateChain();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        try {
            Principal principal = this.session.getPeerPrincipal();
            return principal;
        } catch (AbstractMethodError e2) {
            Certificate[] certs = getPeerCertificates();
            Principal principal2 = ((java.security.cert.X509Certificate) certs[0]).getSubjectX500Principal();
            return principal2;
        }
    }

    public Principal getLocalPrincipal() {
        try {
            Principal principal = this.session.getLocalPrincipal();
            return principal;
        } catch (AbstractMethodError e2) {
            Certificate[] certs = getLocalCertificates();
            if (certs == null) {
                return null;
            }
            Principal principal2 = ((java.security.cert.X509Certificate) certs[0]).getSubjectX500Principal();
            return principal2;
        }
    }

    public SSLSocket getSocket() {
        return (SSLSocket) getSource();
    }
}
