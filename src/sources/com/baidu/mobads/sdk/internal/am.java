package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.v;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class am extends Observable implements v, Runnable {

    /* renamed from: i, reason: collision with root package name */
    public static final int f9781i = 10240;

    /* renamed from: j, reason: collision with root package name */
    public static final int f9782j = 10240;

    /* renamed from: k, reason: collision with root package name */
    public static final String f9783k = ".tmp";

    /* renamed from: m, reason: collision with root package name */
    private static final String f9784m = "FileDownloader";

    /* renamed from: a, reason: collision with root package name */
    public Context f9785a;

    /* renamed from: b, reason: collision with root package name */
    public URL f9786b;

    /* renamed from: c, reason: collision with root package name */
    public String f9787c;

    /* renamed from: d, reason: collision with root package name */
    public String f9788d;

    /* renamed from: e, reason: collision with root package name */
    public int f9789e;

    /* renamed from: f, reason: collision with root package name */
    public v.a f9790f;

    /* renamed from: g, reason: collision with root package name */
    public int f9791g;

    /* renamed from: h, reason: collision with root package name */
    public int f9792h;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f9793l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9794n;

    public am(Context context, URL url, String str, String str2, boolean z10) {
        this.f9785a = context;
        this.f9786b = url;
        this.f9787c = str;
        this.f9794n = z10;
        if (str2 != null && str2.trim().length() > 0) {
            this.f9788d = str2;
        } else {
            String file = url.getFile();
            this.f9788d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f9789e = -1;
        this.f9790f = v.a.DOWNLOADING;
        this.f9791g = 0;
        this.f9792h = 0;
    }

    private void s() {
        a(v.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a() {
        a(v.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a(boolean z10) {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String e() {
        return this.f9786b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String g() {
        return this.f9787c + this.f9788d;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public int j() {
        return this.f9789e;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public float k() {
        return Math.abs((this.f9791g / this.f9789e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public v.a l() {
        return this.f9790f;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.f9793l;
    }

    public void p() {
        bb.a().a(this);
    }

    public void q() {
        setChanged();
        notifyObservers();
    }

    public void r() {
        bq.a(this.f9787c + this.f9788d + ".tmp", this.f9787c + this.f9788d);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.am.run():void");
    }

    public void a(v.a aVar) {
        this.f9790f = aVar;
        q();
    }

    public void a(int i10, float f10) {
        this.f9791g += i10;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.f9786b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
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
}
