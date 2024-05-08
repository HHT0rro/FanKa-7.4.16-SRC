package java.net;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SecureCacheResponse extends CacheResponse {
    public abstract String getCipherSuite();

    public abstract List<Certificate> getLocalCertificateChain();

    public abstract Principal getLocalPrincipal();

    public abstract Principal getPeerPrincipal() throws SSLPeerUnverifiedException;

    public abstract List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException;
}
