package xa;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import za.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    public List<X509TrustManager> f54606a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public X509Certificate[] f54607b;

    public e(InputStream inputStream, String str) throws IllegalArgumentException {
        a(inputStream, str);
    }

    public final void a(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (int i10 = 0; i10 < trustManagers.length; i10++) {
                        if (trustManagers[i10] instanceof X509TrustManager) {
                            this.f54606a.add((X509TrustManager) trustManagers[i10]);
                        }
                    }
                    za.e.b(inputStream);
                } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                    f.d("SX509TM", "loadInputStream: exception : " + e2.getMessage());
                }
                f.b("SX509TM", "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            } finally {
                za.e.b(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }

    public void b(X509Certificate[] x509CertificateArr) {
        this.f54607b = x509CertificateArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        f.e("SX509TM", "checkClientTrusted: ");
        Iterator<X509TrustManager> iterator2 = this.f54606a.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                f.d("SX509TM", "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        b(x509CertificateArr);
        f.e("SX509TM", "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            f.b("SX509TM", "server ca chain: getSubjectDN is :" + ((Object) x509Certificate.getSubjectDN()));
            f.b("SX509TM", "IssuerDN :" + ((Object) x509Certificate.getIssuerDN()));
            f.b("SX509TM", "SerialNumber : " + ((Object) x509Certificate.getSerialNumber()));
        }
        int size = this.f54606a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                f.e("SX509TM", "check server i=" + i10);
                X509TrustManager x509TrustManager = this.f54606a.get(i10);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    f.e("SX509TM", "client root ca size=" + acceptedIssuers.length);
                    for (X509Certificate x509Certificate2 : acceptedIssuers) {
                        f.b("SX509TM", "client root ca getIssuerDN :" + ((Object) x509Certificate2.getIssuerDN()));
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                f.e("SX509TM", "checkServerTrusted end, " + ((Object) x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN()));
                return;
            } catch (CertificateException e2) {
                f.d("SX509TM", "checkServerTrusted error :" + e2.getMessage() + " , time : " + i10);
                if (i10 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        f.d("SX509TM", "root ca issuer : " + ((Object) x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN()));
                    }
                    throw e2;
                }
            }
        }
        f.b("SX509TM", "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> iterator2 = this.f54606a.iterator2();
            while (iterator2.hasNext()) {
                arrayList.addAll(Arrays.asList(iterator2.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            f.d("SX509TM", "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }
}
