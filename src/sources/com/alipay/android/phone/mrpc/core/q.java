package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class q implements Callable<u> {

    /* renamed from: e, reason: collision with root package name */
    private static final HttpRequestRetryHandler f4265e = new ad();

    /* renamed from: a, reason: collision with root package name */
    public l f4266a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4267b;

    /* renamed from: c, reason: collision with root package name */
    public o f4268c;

    /* renamed from: d, reason: collision with root package name */
    public String f4269d;

    /* renamed from: f, reason: collision with root package name */
    private HttpUriRequest f4270f;

    /* renamed from: i, reason: collision with root package name */
    private CookieManager f4273i;

    /* renamed from: j, reason: collision with root package name */
    private AbstractHttpEntity f4274j;

    /* renamed from: k, reason: collision with root package name */
    private HttpHost f4275k;

    /* renamed from: l, reason: collision with root package name */
    private URL f4276l;

    /* renamed from: q, reason: collision with root package name */
    private String f4281q;

    /* renamed from: g, reason: collision with root package name */
    private HttpContext f4271g = new BasicHttpContext();

    /* renamed from: h, reason: collision with root package name */
    private CookieStore f4272h = new BasicCookieStore();

    /* renamed from: m, reason: collision with root package name */
    private int f4277m = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4278n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4279o = false;

    /* renamed from: p, reason: collision with root package name */
    private String f4280p = null;

    public q(l lVar, o oVar) {
        this.f4266a = lVar;
        this.f4267b = lVar.f4243a;
        this.f4268c = oVar;
    }

    private static long a(String[] strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if ("max-age".equalsIgnoreCase(strArr[i10])) {
                int i11 = i10 + 1;
                if (strArr[i11] != null) {
                    try {
                        return Long.parseLong(strArr[i11]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    private static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private u a(HttpResponse httpResponse, int i10, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity != null) {
                return null;
            }
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
        Thread.currentThread().getId();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(entity, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f4279o = false;
            this.f4266a.c(System.currentTimeMillis() - currentTimeMillis);
            this.f4266a.a(byteArray.length);
            p pVar = new p(a(httpResponse), i10, str, byteArray);
            long b4 = b(httpResponse);
            Header contentType = httpResponse.getEntity().getContentType();
            if (contentType != null) {
                HashMap<String, String> a10 = a(contentType.getValue());
                String str4 = a10.get("charset");
                str3 = a10.get("Content-Type");
                str2 = str4;
            } else {
                str2 = null;
            }
            pVar.b(str3);
            pVar.a(str2);
            pVar.a(System.currentTimeMillis());
            pVar.b(b4);
            try {
                byteArrayOutputStream.close();
                return pVar;
            } catch (IOException e2) {
                throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e10) {
                    throw new RuntimeException("ArrayOutputStream close error!", e10.getCause());
                }
            }
            throw th;
        }
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a10 = b.a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a10.read(bArr);
                    if (read == -1 || this.f4268c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    if (this.f4268c.f() != null && contentLength > 0) {
                        this.f4268c.f();
                    }
                }
                outputStream.flush();
            } catch (Exception e2) {
                e2.getCause();
                throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } finally {
            r.a(a10);
        }
    }

    private static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a10 = this.f4268c.a();
        String str = this.f4269d;
        if (str != null) {
            a10 = str;
        }
        if (a10 != null) {
            return new URI(a10);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f4270f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.f4274j == null) {
            byte[] b4 = this.f4268c.b();
            String b10 = this.f4268c.b("gzip");
            if (b4 != null) {
                if (TextUtils.equals(b10, "true")) {
                    this.f4274j = b.a(b4);
                } else {
                    this.f4274j = new ByteArrayEntity(b4);
                }
                this.f4274j.setContentType(this.f4268c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.f4274j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f4270f = httpPost;
        } else {
            this.f4270f = new HttpGet(b());
        }
        return this.f4270f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120 A[Catch: Exception -> 0x0248, NullPointerException -> 0x026a, IOException -> 0x0289, UnknownHostException -> 0x02ae, HttpHostConnectException -> 0x02d5, NoHttpResponseException -> 0x02f9, SocketTimeoutException -> 0x031f, ConnectTimeoutException -> 0x0345, ConnectionPoolTimeoutException -> 0x036a, SSLException -> 0x038f, SSLPeerUnverifiedException -> 0x03b4, SSLHandshakeException -> 0x03d9, URISyntaxException -> 0x03fe, HttpException -> 0x040b, TryCatch #3 {HttpException -> 0x040b, NullPointerException -> 0x026a, SocketTimeoutException -> 0x031f, URISyntaxException -> 0x03fe, UnknownHostException -> 0x02ae, SSLHandshakeException -> 0x03d9, SSLPeerUnverifiedException -> 0x03b4, SSLException -> 0x038f, NoHttpResponseException -> 0x02f9, ConnectionPoolTimeoutException -> 0x036a, ConnectTimeoutException -> 0x0345, HttpHostConnectException -> 0x02d5, IOException -> 0x0289, Exception -> 0x0248, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:11:0x003f, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:18:0x0057, B:20:0x0065, B:22:0x00c9, B:24:0x00cf, B:26:0x00d9, B:28:0x00e2, B:30:0x00ee, B:33:0x00f8, B:36:0x0118, B:38:0x0120, B:39:0x012d, B:41:0x0153, B:42:0x015a, B:44:0x0160, B:45:0x0164, B:47:0x016a, B:50:0x0176, B:53:0x01a5, B:59:0x01c1, B:66:0x01de, B:67:0x01f7, B:70:0x01f8, B:72:0x0200, B:74:0x0206, B:77:0x0212, B:79:0x0216, B:84:0x0226, B:86:0x022e, B:88:0x0238, B:91:0x0100, B:94:0x023c, B:95:0x0247, B:96:0x0017, B:98:0x001b, B:100:0x001f, B:102:0x0025, B:107:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0153 A[Catch: Exception -> 0x0248, NullPointerException -> 0x026a, IOException -> 0x0289, UnknownHostException -> 0x02ae, HttpHostConnectException -> 0x02d5, NoHttpResponseException -> 0x02f9, SocketTimeoutException -> 0x031f, ConnectTimeoutException -> 0x0345, ConnectionPoolTimeoutException -> 0x036a, SSLException -> 0x038f, SSLPeerUnverifiedException -> 0x03b4, SSLHandshakeException -> 0x03d9, URISyntaxException -> 0x03fe, HttpException -> 0x040b, TryCatch #3 {HttpException -> 0x040b, NullPointerException -> 0x026a, SocketTimeoutException -> 0x031f, URISyntaxException -> 0x03fe, UnknownHostException -> 0x02ae, SSLHandshakeException -> 0x03d9, SSLPeerUnverifiedException -> 0x03b4, SSLException -> 0x038f, NoHttpResponseException -> 0x02f9, ConnectionPoolTimeoutException -> 0x036a, ConnectTimeoutException -> 0x0345, HttpHostConnectException -> 0x02d5, IOException -> 0x0289, Exception -> 0x0248, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:11:0x003f, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:18:0x0057, B:20:0x0065, B:22:0x00c9, B:24:0x00cf, B:26:0x00d9, B:28:0x00e2, B:30:0x00ee, B:33:0x00f8, B:36:0x0118, B:38:0x0120, B:39:0x012d, B:41:0x0153, B:42:0x015a, B:44:0x0160, B:45:0x0164, B:47:0x016a, B:50:0x0176, B:53:0x01a5, B:59:0x01c1, B:66:0x01de, B:67:0x01f7, B:70:0x01f8, B:72:0x0200, B:74:0x0206, B:77:0x0212, B:79:0x0216, B:84:0x0226, B:86:0x022e, B:88:0x0238, B:91:0x0100, B:94:0x023c, B:95:0x0247, B:96:0x0017, B:98:0x001b, B:100:0x001f, B:102:0x0025, B:107:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160 A[Catch: Exception -> 0x0248, NullPointerException -> 0x026a, IOException -> 0x0289, UnknownHostException -> 0x02ae, HttpHostConnectException -> 0x02d5, NoHttpResponseException -> 0x02f9, SocketTimeoutException -> 0x031f, ConnectTimeoutException -> 0x0345, ConnectionPoolTimeoutException -> 0x036a, SSLException -> 0x038f, SSLPeerUnverifiedException -> 0x03b4, SSLHandshakeException -> 0x03d9, URISyntaxException -> 0x03fe, HttpException -> 0x040b, TryCatch #3 {HttpException -> 0x040b, NullPointerException -> 0x026a, SocketTimeoutException -> 0x031f, URISyntaxException -> 0x03fe, UnknownHostException -> 0x02ae, SSLHandshakeException -> 0x03d9, SSLPeerUnverifiedException -> 0x03b4, SSLException -> 0x038f, NoHttpResponseException -> 0x02f9, ConnectionPoolTimeoutException -> 0x036a, ConnectTimeoutException -> 0x0345, HttpHostConnectException -> 0x02d5, IOException -> 0x0289, Exception -> 0x0248, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:11:0x003f, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:18:0x0057, B:20:0x0065, B:22:0x00c9, B:24:0x00cf, B:26:0x00d9, B:28:0x00e2, B:30:0x00ee, B:33:0x00f8, B:36:0x0118, B:38:0x0120, B:39:0x012d, B:41:0x0153, B:42:0x015a, B:44:0x0160, B:45:0x0164, B:47:0x016a, B:50:0x0176, B:53:0x01a5, B:59:0x01c1, B:66:0x01de, B:67:0x01f7, B:70:0x01f8, B:72:0x0200, B:74:0x0206, B:77:0x0212, B:79:0x0216, B:84:0x0226, B:86:0x022e, B:88:0x0238, B:91:0x0100, B:94:0x023c, B:95:0x0247, B:96:0x0017, B:98:0x001b, B:100:0x001f, B:102:0x0025, B:107:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100 A[Catch: Exception -> 0x0248, NullPointerException -> 0x026a, IOException -> 0x0289, UnknownHostException -> 0x02ae, HttpHostConnectException -> 0x02d5, NoHttpResponseException -> 0x02f9, SocketTimeoutException -> 0x031f, ConnectTimeoutException -> 0x0345, ConnectionPoolTimeoutException -> 0x036a, SSLException -> 0x038f, SSLPeerUnverifiedException -> 0x03b4, SSLHandshakeException -> 0x03d9, URISyntaxException -> 0x03fe, HttpException -> 0x040b, TryCatch #3 {HttpException -> 0x040b, NullPointerException -> 0x026a, SocketTimeoutException -> 0x031f, URISyntaxException -> 0x03fe, UnknownHostException -> 0x02ae, SSLHandshakeException -> 0x03d9, SSLPeerUnverifiedException -> 0x03b4, SSLException -> 0x038f, NoHttpResponseException -> 0x02f9, ConnectionPoolTimeoutException -> 0x036a, ConnectTimeoutException -> 0x0345, HttpHostConnectException -> 0x02d5, IOException -> 0x0289, Exception -> 0x0248, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:11:0x003f, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:18:0x0057, B:20:0x0065, B:22:0x00c9, B:24:0x00cf, B:26:0x00d9, B:28:0x00e2, B:30:0x00ee, B:33:0x00f8, B:36:0x0118, B:38:0x0120, B:39:0x012d, B:41:0x0153, B:42:0x015a, B:44:0x0160, B:45:0x0164, B:47:0x016a, B:50:0x0176, B:53:0x01a5, B:59:0x01c1, B:66:0x01de, B:67:0x01f7, B:70:0x01f8, B:72:0x0200, B:74:0x0206, B:77:0x0212, B:79:0x0216, B:84:0x0226, B:86:0x022e, B:88:0x0238, B:91:0x0100, B:94:0x023c, B:95:0x0247, B:96:0x0017, B:98:0x001b, B:100:0x001f, B:102:0x0025, B:107:0x002d), top: B:3:0x0006 }] */
    @Override // java.util.concurrent.Callable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.android.phone.mrpc.core.u call() {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f4270f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f4281q)) {
            return this.f4281q;
        }
        String b4 = this.f4268c.b("operationType");
        this.f4281q = b4;
        return b4;
    }

    private int g() {
        URL h10 = h();
        return h10.getPort() == -1 ? h10.getDefaultPort() : h10.getPort();
    }

    private URL h() {
        URL url = this.f4276l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.f4268c.a());
        this.f4276l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.f4273i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.f4273i = cookieManager2;
        return cookieManager2;
    }

    public final o a() {
        return this.f4268c;
    }
}
