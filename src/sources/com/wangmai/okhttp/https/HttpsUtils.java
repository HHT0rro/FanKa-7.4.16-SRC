package com.wangmai.okhttp.https;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpsUtils {
    public static X509TrustManager UnSafeTrustManager = new X509TrustManager() { // from class: com.wangmai.okhttp.https.HttpsUtils.1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };
    public static HostnameVerifier UnSafeHostnameVerifier = new HostnameVerifier() { // from class: com.wangmai.okhttp.https.HttpsUtils.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SSLParams {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static SSLParams getSslSocketFactory() {
        return getSslSocketFactoryBase(null, null, null, new InputStream[0]);
    }

    public static SSLParams getSslSocketFactoryBase(X509TrustManager x509TrustManager, InputStream inputStream, String str, InputStream... inputStreamArr) {
        SSLParams sSLParams = new SSLParams();
        try {
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            if (x509TrustManager == null) {
                if (prepareTrustManager != null) {
                    x509TrustManager = chooseTrustManager(prepareTrustManager);
                } else {
                    x509TrustManager = UnSafeTrustManager;
                }
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(prepareKeyManager, new TrustManager[]{x509TrustManager}, null);
            sSLParams.sSLSocketFactory = sSLContext.getSocketFactory();
            sSLParams.trustManager = x509TrustManager;
            return sSLParams;
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    public static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(e.f29912b);
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    InputStream inputStream = inputStreamArr[i10];
                    int i12 = i11 + 1;
                    keyStore.setCertificateEntry(Integer.toString(i11), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    i10++;
                    i11 = i12;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static SSLParams getSslSocketFactory(X509TrustManager x509TrustManager) {
        return getSslSocketFactoryBase(x509TrustManager, null, null, new InputStream[0]);
    }

    public static SSLParams getSslSocketFactory(InputStream... inputStreamArr) {
        return getSslSocketFactoryBase(null, null, null, inputStreamArr);
    }

    public static SSLParams getSslSocketFactory(InputStream inputStream, String str, InputStream... inputStreamArr) {
        return getSslSocketFactoryBase(null, inputStream, str, inputStreamArr);
    }

    public static SSLParams getSslSocketFactory(InputStream inputStream, String str, X509TrustManager x509TrustManager) {
        return getSslSocketFactoryBase(x509TrustManager, inputStream, str, new InputStream[0]);
    }
}
