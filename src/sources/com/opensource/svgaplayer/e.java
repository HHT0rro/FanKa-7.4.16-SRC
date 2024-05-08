package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import yd.n;

/* compiled from: SVGADynamicEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public HashMap<String, Boolean> f37973a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public HashMap<String, Bitmap> f37974b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public HashMap<String, String> f37975c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public HashMap<String, TextPaint> f37976d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public HashMap<String, StaticLayout> f37977e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public HashMap<String, BoringLayout> f37978f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f37979g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public HashMap<String, int[]> f37980h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public HashMap<String, com.opensource.svgaplayer.a> f37981i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public HashMap<String, n<Canvas, Integer, Integer, Integer, Boolean>> f37982j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    public boolean f37983k;

    /* compiled from: SVGADynamicEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f37985c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Handler f37986d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f37987e;

        /* compiled from: SVGADynamicEntity.kt */
        @kotlin.d
        /* renamed from: com.opensource.svgaplayer.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static final class RunnableC0567a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bitmap f37988b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f37989c;

            public RunnableC0567a(Bitmap bitmap, a aVar) {
                this.f37988b = bitmap;
                this.f37989c = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a aVar = this.f37989c;
                e.this.l(this.f37988b, aVar.f37987e);
            }
        }

        public a(String str, Handler handler, String str2) {
            this.f37985c = str;
            this.f37986d = handler;
            this.f37987e = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            URLConnection openConnection = new URL(this.f37985c).openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                openConnection = null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            if (httpURLConnection == null) {
                return;
            }
            try {
                try {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                        if (decodeStream != null) {
                            this.f37986d.post(new RunnableC0567a(decodeStream, this));
                        }
                        kotlin.io.b.a(inputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            kotlin.io.b.a(inputStream, th);
                            throw th2;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    p pVar = p.f51048a;
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
            } catch (Throwable th3) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
                throw th3;
            }
        }
    }

    @NotNull
    public final HashMap<String, BoringLayout> a() {
        return this.f37978f;
    }

    @NotNull
    public final HashMap<String, Function2<Canvas, Integer, Boolean>> b() {
        return this.f37979g;
    }

    @NotNull
    public final HashMap<String, n<Canvas, Integer, Integer, Integer, Boolean>> c() {
        return this.f37982j;
    }

    @NotNull
    public final HashMap<String, Boolean> d() {
        return this.f37973a;
    }

    @NotNull
    public final HashMap<String, com.opensource.svgaplayer.a> e() {
        return this.f37981i;
    }

    @NotNull
    public final HashMap<String, Bitmap> f() {
        return this.f37974b;
    }

    @NotNull
    public final HashMap<String, StaticLayout> g() {
        return this.f37977e;
    }

    @NotNull
    public final HashMap<String, String> h() {
        return this.f37975c;
    }

    @NotNull
    public final HashMap<String, TextPaint> i() {
        return this.f37976d;
    }

    @NotNull
    public final HashMap<String, int[]> j() {
        return this.f37980h;
    }

    public final boolean k() {
        return this.f37983k;
    }

    public final void l(@NotNull Bitmap bitmap, @NotNull String forKey) {
        s.j(bitmap, "bitmap");
        s.j(forKey, "forKey");
        this.f37974b.put(forKey, bitmap);
    }

    public final void m(@NotNull String url, @NotNull String forKey) {
        s.j(url, "url");
        s.j(forKey, "forKey");
        SVGAParser.f37905h.a().execute(new a(url, new Handler(), forKey));
    }

    public final void n(@NotNull StaticLayout layoutText, @NotNull String forKey) {
        s.j(layoutText, "layoutText");
        s.j(forKey, "forKey");
        this.f37983k = true;
        this.f37977e.put(forKey, layoutText);
    }

    public final void o(boolean z10) {
        this.f37983k = z10;
    }
}
