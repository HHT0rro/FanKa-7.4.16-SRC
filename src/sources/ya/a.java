package ya;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import za.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            f.e("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            d.a(str, x509Certificate, false);
            za.d.b();
            return true;
        } catch (SSLException e2) {
            f.d("", "SSLException : " + e2.getMessage());
            return false;
        }
    }
}
