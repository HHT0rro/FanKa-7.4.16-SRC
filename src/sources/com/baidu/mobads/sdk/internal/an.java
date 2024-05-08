package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9795a = "OAdURLConnection";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9796b = "POST";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9797c = "GET";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9798d = "application/json";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9799e = "text/plain";

    /* renamed from: f, reason: collision with root package name */
    private HttpURLConnection f9800f;

    /* renamed from: g, reason: collision with root package name */
    private bs f9801g;

    /* renamed from: h, reason: collision with root package name */
    private b f9802h;

    /* renamed from: i, reason: collision with root package name */
    private c f9803i;

    /* renamed from: j, reason: collision with root package name */
    private String f9804j;

    /* renamed from: k, reason: collision with root package name */
    private String f9805k;

    /* renamed from: l, reason: collision with root package name */
    private String f9806l;

    /* renamed from: m, reason: collision with root package name */
    private String f9807m;

    /* renamed from: n, reason: collision with root package name */
    private int f9808n;

    /* renamed from: o, reason: collision with root package name */
    private int f9809o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9810p;

    /* renamed from: q, reason: collision with root package name */
    private Uri.Builder f9811q;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends i {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.internal.i
        public Object i() {
            an.this.e();
            an.this.f();
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(String str, int i10);

        void a(String str, String str2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i10);
    }

    public an(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(this.f9804j) || !cp.a().f(this.f9804j)) {
            return;
        }
        try {
            HttpURLConnection a10 = cp.a().a(new URL(this.f9804j));
            this.f9800f = a10;
            a10.setConnectTimeout(this.f9808n);
            if (Integer.parseInt(bk.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f9800f.setRequestMethod(this.f9805k);
            this.f9800f.setUseCaches(this.f9810p);
            if (!TextUtils.isEmpty(this.f9806l)) {
                this.f9800f.setRequestProperty("User-Agent", this.f9806l);
            }
            this.f9800f.setRequestProperty("Content-type", this.f9807m);
            this.f9800f.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
            this.f9800f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f9805k.equals("POST")) {
                this.f9800f.setDoInput(true);
                this.f9800f.setDoOutput(true);
                Uri.Builder builder = this.f9811q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f9800f);
                }
            }
        } catch (Exception e2) {
            b bVar = this.f9802h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f9803i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f9800f.connect();
                this.f9801g.a(f9795a, this.f9800f.getRequestMethod() + " connect code :" + this.f9800f.getResponseCode());
                int responseCode = this.f9800f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f9800f.setInstanceFollowRedirects(false);
                    HttpURLConnection a10 = a(this.f9800f);
                    this.f9800f = a10;
                    responseCode = a10.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f9802h;
                    if (bVar != null) {
                        bVar.a(this.f9800f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f9803i;
                    if (cVar != null) {
                        cVar.a(this.f9800f.getResponseMessage(), responseCode);
                    }
                } else {
                    String g3 = cp.a().g(this.f9804j);
                    b bVar2 = this.f9802h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g3);
                    }
                    c cVar2 = this.f9803i;
                    if (cVar2 != null) {
                        cVar2.a(this.f9800f.getInputStream(), g3);
                    }
                }
                httpURLConnection = this.f9800f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                b bVar3 = this.f9802h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                c cVar3 = this.f9803i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f9800f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f9800f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f9800f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f9800f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                aw.h(f9795a).f(e2.toString());
            }
        }
    }

    public an(String str, String str2) {
        this.f9801g = bs.a();
        this.f9802h = null;
        this.f9803i = null;
        this.f9807m = f9799e;
        this.f9808n = 10000;
        this.f9809o = 10000;
        this.f9810p = false;
        this.f9811q = null;
        this.f9804j = str;
        this.f9805k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f9800f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f9800f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c4 = c();
                HttpURLConnection httpURLConnection3 = this.f9800f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c4;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f9800f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            bb.a().a((i) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i10) {
        this.f9809o = i10;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f9800f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f9800f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f9802h = bVar;
    }

    public void a(c cVar) {
        this.f9803i = cVar;
    }

    public void a(int i10) {
        this.f9808n = i10;
    }

    public void a(Uri.Builder builder) {
        this.f9811q = builder;
    }

    public void a(String str) {
        this.f9807m = str;
    }
}
