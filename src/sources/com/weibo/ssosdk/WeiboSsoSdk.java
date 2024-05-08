package com.weibo.ssosdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeiboSsoSdk {

    /* renamed from: e, reason: collision with root package name */
    public static WeiboSsoSdk f46928e;

    /* renamed from: f, reason: collision with root package name */
    public static bc.d f46929f;

    /* renamed from: a, reason: collision with root package name */
    public volatile ReentrantLock f46930a = new ReentrantLock(true);

    /* renamed from: b, reason: collision with root package name */
    public boolean f46931b = true;

    /* renamed from: c, reason: collision with root package name */
    public d f46932c;

    /* renamed from: d, reason: collision with root package name */
    public int f46933d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String k10;
            while (true) {
                try {
                    Thread.sleep(86400000L);
                    if (WeiboSsoSdk.this.f46932c != null && !TextUtils.isEmpty(WeiboSsoSdk.this.f46932c.a())) {
                        k10 = WeiboSsoSdk.this.f46932c.a();
                    } else {
                        k10 = WeiboSsoSdk.this.k();
                    }
                    WeiboSsoSdk.i().l(k10, 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String k10;
            try {
                Thread.sleep(60000L);
                if (WeiboSsoSdk.this.f46931b) {
                    if (WeiboSsoSdk.this.f46932c != null && !TextUtils.isEmpty(WeiboSsoSdk.this.f46932c.a())) {
                        k10 = WeiboSsoSdk.this.f46932c.a();
                    } else {
                        k10 = WeiboSsoSdk.this.k();
                    }
                    WeiboSsoSdk.this.l(k10, 2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.weibo.ssosdk.a f46936b;

        public c(com.weibo.ssosdk.a aVar) {
            this.f46936b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeiboSsoSdk.this.l("", 1);
            } catch (Exception unused) {
            }
            if (WeiboSsoSdk.this.f46932c == null) {
                WeiboSsoSdk.this.f46932c = new d();
            }
            this.f46936b.handler(WeiboSsoSdk.this.f46932c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public String f46938a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f46939b = "";

        public static d c(String str) {
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    dVar.f46938a = jSONObject2.optString("aid", "");
                    dVar.f46939b = jSONObject2.optString("sub", "");
                    return dVar;
                }
                throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (Exception e2) {
                throw e2;
            }
        }

        public final String a() {
            return this.f46938a;
        }

        public final String b() {
            return this.f46939b;
        }
    }

    static {
        System.loadLibrary("sharewind");
    }

    public WeiboSsoSdk() {
        bc.d dVar = f46929f;
        if (dVar != null && dVar.t()) {
            this.f46933d = 0;
            new Thread(new a()).start();
            new Thread(new b()).start();
            return;
        }
        throw new Exception("config error");
    }

    public static synchronized WeiboSsoSdk i() {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (f46928e == null) {
                f46928e = new WeiboSsoSdk();
            }
            weiboSsoSdk = f46928e;
        }
        return weiboSsoSdk;
    }

    public static synchronized boolean j(bc.d dVar) {
        synchronized (WeiboSsoSdk.class) {
            if (dVar == null) {
                return false;
            }
            if (!dVar.t()) {
                return false;
            }
            if (f46929f != null) {
                return false;
            }
            bc.d dVar2 = (bc.d) dVar.clone();
            f46929f = dVar2;
            bc.b.B(dVar2.c());
            return true;
        }
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, int i12);

    public final synchronized void f(String str) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(h(1));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public final String g(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final File h(int i10) {
        return new File(f46929f.c().getFilesDir(), "weibo_sso_sdk_aid".concat(String.valueOf(i10)));
    }

    public final String k() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(h(1));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return str;
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return "";
            }
            try {
                fileInputStream2.close();
                return "";
            } catch (IOException unused4) {
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public final void l(String str, int i10) {
        String str2;
        if (TextUtils.isEmpty(f46929f.a(false))) {
            return;
        }
        if (!this.f46930a.tryLock()) {
            this.f46930a.lock();
            this.f46930a.unlock();
            return;
        }
        boolean k10 = f46929f.k();
        boolean g3 = f46929f.g();
        this.f46931b = false;
        String q10 = bc.b.q(f46929f.c(), k10 ? 1 : 0, g3 ? 1 : 0);
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g10 = g(riseWind(f46929f.a(true), f46929f.c().getPackageName(), str2, q10, f46929f.e(true), f46929f.h(true), f46929f.l(true), f46929f.j(true), f46929f.i(true), f46929f.d(true), i10, this.f46933d, k10 ? 1 : 0));
        this.f46933d++;
        if (g10 != null) {
            try {
                d c4 = d.c(g10);
                if (c4 != null && !TextUtils.isEmpty(c4.a())) {
                    f(c4.a());
                }
                if (i10 == 1) {
                    this.f46932c = c4;
                }
                this.f46930a.unlock();
                return;
            } catch (Exception e2) {
                this.f46930a.unlock();
                throw e2;
            }
        }
        this.f46930a.unlock();
        throw new Exception("network error.");
    }

    public void m(com.weibo.ssosdk.a aVar) {
        d dVar = this.f46932c;
        if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.f46932c.b())) {
            aVar.handler(this.f46932c);
        } else {
            Executors.newSingleThreadExecutor().execute(new c(aVar));
        }
    }
}
