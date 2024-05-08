package javax.net.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface X509TrustManager extends TrustManager {
    void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException;

    void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException;

    X509Certificate[] getAcceptedIssuers();
}
