package com.inno.innosdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpsUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35609a = new String[0];

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35610b = {"innotechx.cer", "1sappcom.cer"};

    /* renamed from: c, reason: collision with root package name */
    public static String[] f35611c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<String, Certificate> f35612d = new ConcurrentHashMap<>();

    /* compiled from: HttpsUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements HostnameVerifier {
        public b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !Arrays.asList(j.f35611c).contains(str);
        }
    }

    /* compiled from: HttpsUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements X509TrustManager {
        public c() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                x509CertificateArr[0].checkValidity();
            } catch (Exception unused) {
                throw new CertificateException("Certificate not valid or trusted.");
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr != null) {
                if (com.inno.innosdk.a.c.f35473a != null) {
                    for (String str2 : j.f35610b) {
                        if (j.b(str2, x509CertificateArr, str)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("checkServerCertificateTrusted success,certName:");
                            sb2.append(str2);
                            return;
                        }
                    }
                    throw new CertificateException("check server's Certificate failed");
                }
                throw new CertificateException("checkServerTrusted: X509Certificate context is null");
            }
            throw new IllegalArgumentException("Check Server x509Certificates is null");
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static b c() {
        return new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097 A[Catch: all -> 0x0070, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:7:0x0012, B:10:0x0019, B:12:0x0023, B:37:0x0047, B:39:0x005a, B:42:0x0062, B:43:0x0078, B:51:0x0097, B:59:0x00ab, B:76:0x0075), top: B:6:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r7, java.security.cert.X509Certificate[] r8, java.lang.String r9) {
        /*
            java.lang.String r9 = ""
            com.inno.innosdk.pb.Option r0 = com.inno.innosdk.a.c.p()
            boolean r0 = r0.isHttpsVerify()
            r1 = 1
            if (r0 != 0) goto Le
            return r1
        Le:
            r0 = 0
            android.content.Context r2 = com.inno.innosdk.a.c.f35473a
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L70
            if (r4 == 0) goto L19
            return r3
        L19:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.security.cert.Certificate> r4 = com.inno.innosdk.utils.j.f35612d     // Catch: java.lang.Throwable -> L70
            java.lang.Object r4 = r4.get(r7)     // Catch: java.lang.Throwable -> L70
            java.security.cert.Certificate r4 = (java.security.cert.Certificate) r4     // Catch: java.lang.Throwable -> L70
            if (r4 != 0) goto L45
            java.lang.String r4 = "X.509"
            java.security.cert.CertificateFactory r4 = java.security.cert.CertificateFactory.getInstance(r4)     // Catch: java.lang.Throwable -> L70
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L70
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L70
            java.io.InputStream r2 = r2.open(r7)     // Catch: java.lang.Throwable -> L70
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L70
            java.security.cert.Certificate r4 = r4.generateCertificate(r5)     // Catch: java.lang.Throwable -> L41
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.security.cert.Certificate> r0 = com.inno.innosdk.utils.j.f35612d     // Catch: java.lang.Throwable -> L41
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L41
            r0 = r5
            goto L45
        L41:
            r7 = move-exception
            r0 = r5
            goto Lc5
        L45:
            r7 = 16
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.security.PublicKey r5 = r4.getPublicKey()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            byte[] r5 = r5.getEncoded()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r2.<init>(r1, r5)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r2 = r2.toString(r7)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.security.Principal r5 = r4.getSubjectDN()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L70
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L70
            java.security.Principal r4 = r4.getIssuerDN()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L70
            java.lang.String r9 = r4.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L70
            goto L78
        L6b:
            r4 = move-exception
            goto L75
        L6d:
            r4 = move-exception
            r5 = r9
            goto L75
        L70:
            r7 = move-exception
            goto Lc5
        L72:
            r4 = move-exception
            r2 = r9
            r5 = r2
        L75:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L70
        L78:
            r8 = r8[r3]     // Catch: java.lang.Throwable -> L70
            java.security.PublicKey r4 = r8.getPublicKey()     // Catch: java.lang.Throwable -> L70
            java.math.BigInteger r6 = new java.math.BigInteger     // Catch: java.lang.Throwable -> L70
            byte[] r4 = r4.getEncoded()     // Catch: java.lang.Throwable -> L70
            r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L70
            java.lang.String r7 = r6.toString(r7)     // Catch: java.lang.Throwable -> L70
            boolean r7 = r2.equals(r7)     // Catch: java.lang.Throwable -> L70
            if (r7 != 0) goto L97
            if (r0 == 0) goto L96
            r0.close()     // Catch: java.lang.Throwable -> L96
        L96:
            return r3
        L97:
            java.security.Principal r7 = r8.getSubjectDN()     // Catch: java.lang.Throwable -> L70
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L70
            boolean r7 = r5.equals(r7)     // Catch: java.lang.Throwable -> L70
            if (r7 != 0) goto Lab
            if (r0 == 0) goto Laa
            r0.close()     // Catch: java.lang.Throwable -> Laa
        Laa:
            return r3
        Lab:
            java.security.Principal r7 = r8.getIssuerDN()     // Catch: java.lang.Throwable -> L70
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L70
            boolean r7 = r9.equals(r7)     // Catch: java.lang.Throwable -> L70
            if (r7 != 0) goto Lbf
            if (r0 == 0) goto Lbe
            r0.close()     // Catch: java.lang.Throwable -> Lbe
        Lbe:
            return r3
        Lbf:
            if (r0 == 0) goto Lc4
            r0.close()     // Catch: java.lang.Throwable -> Lc4
        Lc4:
            return r1
        Lc5:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto Lcd
            r0.close()     // Catch: java.lang.Throwable -> Lcd
        Lcd:
            return r3
        Lce:
            r7 = move-exception
            if (r0 == 0) goto Ld4
            r0.close()     // Catch: java.lang.Throwable -> Ld4
        Ld4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.j.b(java.lang.String, java.security.cert.X509Certificate[], java.lang.String):boolean");
    }

    public static void a(Context context) {
        try {
            InputStream[] a10 = a(context, f35609a);
            HttpsURLConnection.setDefaultSSLSocketFactory(a(a10, (InputStream) null, (String) null));
            if (a10 == null) {
                HttpsURLConnection.setDefaultHostnameVerifier(c());
            }
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        }
    }

    public static InputStream[] a(Context context, String... strArr) {
        if (context != null && strArr != null && strArr.length > 0) {
            try {
                InputStream[] inputStreamArr = new InputStream[strArr.length];
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    inputStreamArr[i10] = context.getAssets().open(strArr[i10]);
                }
                return inputStreamArr;
            } catch (IOException e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        }
        return null;
    }

    public static SSLSocketFactory a(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        try {
            TrustManager[] a10 = a(inputStreamArr);
            KeyManager[] a11 = a(inputStream, str);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (a10 == null || a10.length <= 0) {
                a10 = new TrustManager[]{new c()};
            }
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextInt();
            sSLContext.init(a11, a10, secureRandom);
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static TrustManager[] a(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b);
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    InputStream inputStream = inputStreamArr[i10];
                    keyStore.setCertificateEntry(Integer.toString(i11), certificateFactory.generateCertificate(inputStream));
                    com.inno.innosdk.utils.t.a.a((Closeable) inputStream);
                    i10++;
                    i11++;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        }
        return null;
    }

    public static KeyManager[] a(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        }
        return null;
    }
}
