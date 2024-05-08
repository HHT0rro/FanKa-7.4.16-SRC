package javax.net.ssl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class HttpsURLConnection extends HttpURLConnection {
    private static final String OK_HOSTNAME_VERIFIER_CLASS = "com.android.okhttp.internal.tls.OkHostnameVerifier";
    private static SSLSocketFactory defaultSSLSocketFactory = null;
    protected HostnameVerifier hostnameVerifier;
    private SSLSocketFactory sslSocketFactory;

    public abstract String getCipherSuite();

    public abstract Certificate[] getLocalCertificates();

    public abstract Certificate[] getServerCertificates() throws SSLPeerUnverifiedException;

    protected HttpsURLConnection(URL url) {
        super(url);
        this.hostnameVerifier = NoPreloadHolder.defaultHostnameVerifier;
        this.sslSocketFactory = getDefaultSSLSocketFactory();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Certificate[] certs = getServerCertificates();
        return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    public Principal getLocalPrincipal() {
        Certificate[] certs = getLocalCertificates();
        if (certs != null) {
            return ((X509Certificate) certs[0]).getSubjectX500Principal();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NoPreloadHolder {
        public static HostnameVerifier defaultHostnameVerifier;

        private NoPreloadHolder() {
        }

        static {
            try {
                defaultHostnameVerifier = (HostnameVerifier) Class.forName(HttpsURLConnection.OK_HOSTNAME_VERIFIER_CLASS).getField("INSTANCE").get(null);
            } catch (Exception e2) {
                throw new AssertionError("Failed to obtain okhttp HostnameVerifier", e2);
            }
        }
    }

    public static void setDefaultHostnameVerifier(HostnameVerifier v2) {
        if (v2 == null) {
            throw new IllegalArgumentException("no default HostnameVerifier specified");
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SSLPermission("setHostnameVerifier"));
        }
        NoPreloadHolder.defaultHostnameVerifier = v2;
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        return NoPreloadHolder.defaultHostnameVerifier;
    }

    public void setHostnameVerifier(HostnameVerifier v2) {
        if (v2 == null) {
            throw new IllegalArgumentException("no HostnameVerifier specified");
        }
        this.hostnameVerifier = v2;
    }

    public static HostnameVerifier getStrictHostnameVerifier() {
        try {
            return (HostnameVerifier) Class.forName(OK_HOSTNAME_VERIFIER_CLASS).getMethod("strictInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public static void setDefaultSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("no default SSLSocketFactory specified");
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkSetFactory();
        }
        defaultSSLSocketFactory = sf;
    }

    public static SSLSocketFactory getDefaultSSLSocketFactory() {
        if (defaultSSLSocketFactory == null) {
            defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
        return defaultSSLSocketFactory;
    }

    public void setSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("no SSLSocketFactory specified");
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkSetFactory();
        }
        this.sslSocketFactory = sf;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.sslSocketFactory;
    }
}
