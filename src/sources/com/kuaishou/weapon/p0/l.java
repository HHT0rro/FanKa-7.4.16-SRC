package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static TrustManager[] f36138a = {new X509TrustManager() { // from class: com.kuaishou.weapon.p0.l.1
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                l.b(x509CertificateArr);
            } catch (Throwable unused) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};

    /* renamed from: b, reason: collision with root package name */
    public static SSLSocketFactory f36139b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f36140c = "gzip";

    /* renamed from: d, reason: collision with root package name */
    private static final int f36141d = 1024;

    /* renamed from: f, reason: collision with root package name */
    private static volatile l f36142f;

    /* renamed from: g, reason: collision with root package name */
    private static Context f36143g;

    /* renamed from: e, reason: collision with root package name */
    private boolean f36144e = false;

    private l(Context context) {
        f36143g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            try {
                if (x509CertificateArr.length == 0) {
                    return;
                }
                String name = x509CertificateArr[0].getIssuerX500Principal().getName();
                if (Pattern.compile(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*", 2).matcher(name).matches()) {
                    return;
                }
                a(name);
            } catch (Throwable unused) {
            }
        }
    }

    public static l a(Context context) {
        if (f36142f == null) {
            synchronized (l.class) {
                if (f36142f == null) {
                    f36142f = new l(context);
                }
            }
        }
        return f36142f;
    }

    public void b(m mVar, j jVar) {
        a(mVar, jVar, "POST");
    }

    public void a(m mVar, j jVar) {
        a(mVar, jVar, "GET");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    public HttpURLConnection a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(str);
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection2);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpsURLConnection.setRequestMethod(str2);
                httpsURLConnection.setAllowUserInteraction(true);
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setChunkedStreamingMode(0);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (!str2.equalsIgnoreCase("post")) {
                    return httpsURLConnection;
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setUseCaches(false);
                return httpsURLConnection;
            } catch (Exception unused) {
                return httpsURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(String str) {
        try {
            new h(f36143g).c(df.f36074m, str, true);
        } catch (Exception unused) {
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            try {
                if (f36139b == null) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, f36138a, new SecureRandom());
                    f36139b = sSLContext.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = f36139b;
                if (sSLSocketFactory != null) {
                    httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00f5 A[Catch: Exception -> 0x00fd, TryCatch #4 {Exception -> 0x00fd, blocks: (B:79:0x00f0, B:72:0x00f5, B:74:0x00fa), top: B:78:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fa A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fd, blocks: (B:79:0x00f0, B:72:0x00f5, B:74:0x00fa), top: B:78:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kuaishou.weapon.p0.m r10, com.kuaishou.weapon.p0.j r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e0 A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e3, blocks: (B:65:0x00db, B:60:0x00e0), top: B:64:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.kuaishou.weapon.p0.m r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m):java.lang.String");
    }

    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = a(str, "GET");
            try {
                inputStream = a(httpURLConnection);
                boolean a10 = a(inputStream, file);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a10;
            } catch (Throwable unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            }
        } catch (Throwable unused4) {
            httpURLConnection = null;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        try {
            if (f36140c.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.f36144e = true;
            } else {
                this.f36144e = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f36144e) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable unused2) {
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused4) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
            }
            return false;
        }
    }

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }
}
