package com.tencent.cloud.huiyansdkface.okhttp3.internal.tls;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class CertificateChainCleaner {
    public static CertificateChainCleaner get(X509TrustManager x509TrustManager) {
        return Platform.get().buildCertificateChainCleaner(x509TrustManager);
    }

    public static CertificateChainCleaner get(X509Certificate... x509CertificateArr) {
        return new BasicCertificateChainCleaner(new BasicTrustRootIndex(x509CertificateArr));
    }

    public abstract List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
