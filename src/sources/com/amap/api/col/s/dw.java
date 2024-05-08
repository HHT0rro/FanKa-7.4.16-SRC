package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.bx;
import com.amap.api.col.s.dt;
import com.amap.api.col.s.dz;
import com.amap.api.maps.AMapException;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketOptions;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: HttpUrlUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dw {

    /* renamed from: k, reason: collision with root package name */
    private static SoftReference<SSLContext> f7763k;

    /* renamed from: t, reason: collision with root package name */
    private static SoftReference<dx> f7764t;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7765a;

    /* renamed from: b, reason: collision with root package name */
    private SSLContext f7766b;

    /* renamed from: c, reason: collision with root package name */
    private Proxy f7767c;

    /* renamed from: g, reason: collision with root package name */
    private String f7771g;

    /* renamed from: h, reason: collision with root package name */
    private dt.a f7772h;

    /* renamed from: i, reason: collision with root package name */
    private d f7773i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7775l;

    /* renamed from: m, reason: collision with root package name */
    private String f7776m;

    /* renamed from: n, reason: collision with root package name */
    private String f7777n;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f7768d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f7769e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f7770f = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f7774j = "";

    /* renamed from: o, reason: collision with root package name */
    private boolean f7778o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7779p = false;

    /* renamed from: q, reason: collision with root package name */
    private String f7780q = "";

    /* renamed from: r, reason: collision with root package name */
    private String f7781r = "";

    /* renamed from: s, reason: collision with root package name */
    private String f7782s = "";

    /* renamed from: u, reason: collision with root package name */
    private f f7783u = new f();

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements Cloneable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f7784a;

        /* renamed from: b, reason: collision with root package name */
        public String f7785b;

        /* renamed from: c, reason: collision with root package name */
        public String f7786c;

        /* renamed from: d, reason: collision with root package name */
        public String f7787d;

        /* renamed from: e, reason: collision with root package name */
        public String f7788e;

        /* renamed from: f, reason: collision with root package name */
        public int f7789f;

        /* renamed from: g, reason: collision with root package name */
        public int f7790g;

        /* renamed from: h, reason: collision with root package name */
        public int f7791h;

        /* renamed from: i, reason: collision with root package name */
        public long f7792i;

        /* renamed from: j, reason: collision with root package name */
        public volatile AtomicInteger f7793j = new AtomicInteger(1);

        public a(c cVar) {
            this.f7785b = cVar.f7798c;
            this.f7786c = cVar.f7800e;
            this.f7788e = cVar.f7799d;
            this.f7789f = cVar.f7808m;
            this.f7790g = cVar.f7809n;
            this.f7791h = cVar.f7797b.a();
            this.f7787d = cVar.f7796a;
            this.f7792i = cVar.f7801f;
            if (this.f7789f == 10) {
                this.f7784a = 0;
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f7789f + "#";
                if (!TextUtils.isEmpty(this.f7788e)) {
                    str = str5 + this.f7788e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f7791h + "#") + ((Object) this.f7793j) + "#";
                if (!TextUtils.isEmpty(this.f7785b)) {
                    str2 = str6 + this.f7785b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f7789f == 1) {
                    str3 = str2 + this.f7787d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f7789f == 1) {
                    str4 = str3 + this.f7792i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String b4 = cb.b(dp.a(((str4 + this.f7786c + "#") + this.f7790g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                dw.a();
                return b4;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f7784a - ((a) obj).f7784a;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f7794a;

        /* renamed from: b, reason: collision with root package name */
        public int f7795b = this.f7795b;

        /* renamed from: b, reason: collision with root package name */
        public int f7795b = this.f7795b;

        public b(HttpURLConnection httpURLConnection) {
            this.f7794a = httpURLConnection;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public String f7796a = "";

        /* renamed from: b, reason: collision with root package name */
        public dz.b f7797b = dz.b.FIRST_NONDEGRADE;

        /* renamed from: c, reason: collision with root package name */
        public String f7798c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f7799d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f7800e = "";

        /* renamed from: f, reason: collision with root package name */
        public long f7801f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f7802g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f7803h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f7804i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f7805j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f7806k = "-";

        /* renamed from: l, reason: collision with root package name */
        public String f7807l = "-";

        /* renamed from: m, reason: collision with root package name */
        public int f7808m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f7809n = 0;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f7798c)) {
                str = "-#";
            } else {
                str = this.f7798c + "#";
            }
            if (!TextUtils.isEmpty(this.f7799d)) {
                str2 = str + this.f7799d + "#";
            } else {
                str2 = str + "-#";
            }
            String b4 = cb.b(dp.a(((((str2 + this.f7797b.a() + "#") + this.f7803h + "#") + this.f7805j + "#") + this.f7801f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            dw.a();
            return b4;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f7796a + "', degradeType=" + ((Object) this.f7797b) + ", serverIp='" + this.f7798c + "', path='" + this.f7799d + "', hostname='" + this.f7800e + "', totalTime=" + this.f7801f + ", DNSTime=" + this.f7802g + ", connectionTime=" + this.f7803h + ", writeTime=" + this.f7804i + ", readTime=" + this.f7805j + ", serverTime='" + this.f7806k + "', datasize='" + this.f7807l + "', errorcode=" + this.f7808m + ", errorcodeSub=" + this.f7809n + '}';
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public long f7814a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f7815b = 0;

        /* renamed from: c, reason: collision with root package name */
        public c f7816c = new c();

        /* renamed from: d, reason: collision with root package name */
        public a f7817d;

        /* renamed from: e, reason: collision with root package name */
        public c f7818e;

        /* renamed from: f, reason: collision with root package name */
        public String f7819f;

        /* renamed from: g, reason: collision with root package name */
        public URL f7820g;

        public f() {
        }

        public final void a(dz dzVar, URL url) {
            this.f7820g = url;
            this.f7816c.f7799d = url.getPath();
            this.f7816c.f7800e = url.getHost();
            if (!TextUtils.isEmpty(dw.this.f7777n) && dzVar.t().b()) {
                c cVar = this.f7816c;
                cVar.f7798c = cVar.f7800e.replace("[", "").replace("]", "");
                this.f7816c.f7800e = dw.this.f7777n;
            }
            if (dzVar.t().b()) {
                dzVar.d(this.f7816c.f7800e);
            }
            if (dzVar.t().d()) {
                this.f7819f = dzVar.w();
            }
        }

        public final void b() {
            this.f7816c.f7804i = SystemClock.elapsedRealtime() - this.f7815b;
        }

        public final void c() {
            this.f7816c.f7805j = SystemClock.elapsedRealtime() - this.f7815b;
        }

        public final void d() {
            c clone = this.f7816c.clone();
            if (this.f7816c.f7801f > bx.f7326e) {
                clone.f7808m = 1;
            }
            bx.a(clone);
        }

        public final void b(int i10) {
            this.f7816c.f7809n = i10;
        }

        public final void a() {
            this.f7816c.f7803h = SystemClock.elapsedRealtime() - this.f7815b;
        }

        public final void a(ea eaVar) {
            c clone;
            try {
                this.f7816c.f7801f = SystemClock.elapsedRealtime() - this.f7814a;
                if (eaVar != null) {
                    eaVar.f7871f = this.f7816c.f7797b.c();
                }
                if (this.f7816c.f7797b.b()) {
                    c cVar = this.f7816c;
                    if (cVar.f7801f > 10000) {
                        bx.a(false, cVar.f7800e);
                    }
                }
                if (this.f7816c.f7797b.d()) {
                    bx.a(false, this.f7819f);
                }
                boolean a10 = dw.this.a(this.f7816c.f7800e);
                if (a10) {
                    bx.c(this.f7816c);
                    bx.a(true, this.f7817d);
                    c cVar2 = this.f7816c;
                    if (cVar2.f7801f > bx.f7326e && (clone = cVar2.clone()) != null) {
                        clone.f7808m = 1;
                        bx.b(clone);
                        clone.toString();
                        dw.a();
                    }
                }
                bx.a(this.f7820g.toString(), this.f7816c.f7797b.c(), false, a10);
                this.f7816c.toString();
                dw.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(int i10) {
            "----errorcode-----".concat(String.valueOf(i10));
            dw.a();
            try {
                this.f7816c.f7801f = SystemClock.elapsedRealtime() - this.f7814a;
                c cVar = this.f7816c;
                cVar.f7808m = i10;
                if (cVar.f7797b.e()) {
                    bx.a(false, this.f7816c.f7800e);
                }
                boolean a10 = dw.this.a(this.f7816c.f7800e);
                if (a10) {
                    if (dw.this.f7779p && !TextUtils.isEmpty(dw.this.f7777n) && this.f7816c.f7797b.b()) {
                        bx.c();
                    }
                    if (this.f7816c.f7797b.c()) {
                        bx.a(this.f7816c.f7797b.c(), this.f7816c.f7800e);
                    }
                    bx.c(this.f7818e);
                    bx.a(false, this.f7817d);
                    bx.b(this.f7816c);
                }
                bx.a(this.f7820g.toString(), this.f7816c.f7797b.c(), true, a10);
                this.f7816c.toString();
                dw.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j10) {
            this.f7816c.f7807l = new DecimalFormat("0.00").format(((float) j10) / 1024.0f);
        }
    }

    public dw() {
        bx.d();
        try {
            this.f7771g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            dc.a(th, "ht", "ic");
        }
    }

    public static void a() {
    }

    private void c(dz dzVar) throws bv {
        this.f7773i = new d((byte) 0);
        this.f7779p = dzVar.x();
        this.f7767c = dzVar.n();
        this.f7772h = dzVar.s();
        this.f7775l = dzVar.p();
        this.f7774j = dzVar.y();
        this.f7765a = cc.a().b(dzVar.r());
        String l10 = dzVar.t().b() ? dzVar.l() : dzVar.k();
        this.f7776m = l10;
        this.f7776m = dv.a(l10, this.f7774j);
        this.f7777n = dzVar.i();
        if ("loc".equals(this.f7774j)) {
            String k10 = dzVar.k();
            String l11 = dzVar.l();
            if (!TextUtils.isEmpty(k10)) {
                try {
                    this.f7781r = new URL(k10).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(l11)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.f7777n)) {
                    this.f7780q = this.f7777n;
                } else {
                    this.f7780q = new URL(l11).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final ea b(dz dzVar) throws bv {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                c(dzVar);
                ea b4 = dv.b(this.f7776m, this.f7774j);
                if (b4 != null) {
                    this.f7783u.d();
                    return b4;
                }
                b a10 = a(dzVar, true);
                HttpURLConnection httpURLConnection2 = a10.f7794a;
                try {
                    this.f7783u.f7815b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f7783u.a();
                    byte[] h10 = dzVar.h();
                    if (h10 == null || h10.length == 0) {
                        Map<String, String> f10 = dzVar.f();
                        HashMap<String, String> hashMap = dt.f7745e;
                        if (hashMap != null) {
                            if (f10 != null) {
                                f10.putAll(hashMap);
                            } else {
                                f10 = hashMap;
                            }
                        }
                        String a11 = a(f10);
                        if (!TextUtils.isEmpty(a11)) {
                            h10 = ci.a(a11);
                        }
                    }
                    if (h10 != null && h10.length > 0) {
                        try {
                            this.f7783u.f7815b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                            } catch (Throwable th2) {
                                dataOutputStream = null;
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            dataOutputStream = null;
                            th = th3;
                            outputStream = null;
                        }
                        try {
                            dataOutputStream.write(h10);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f7783u.b();
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f7783u.b();
                            throw th;
                        }
                    }
                    ea a12 = a(a10);
                    this.f7783u.a(a12);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        dc.a(th5, "ht", "mPt");
                    }
                    this.f7783u.d();
                    return a12;
                } catch (bv e2) {
                    e = e2;
                    if (!e.i() && e.g() != 10) {
                        this.f7783u.a(e.g());
                    }
                    dc.a(e, "ht", "mPt");
                    throw e;
                } catch (ConnectException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f7783u.b(a(e));
                    this.f7783u.a(6);
                    throw new bv(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.f7783u.a(8);
                    throw new bv("url异常 - MalformedURLException");
                } catch (SocketException e12) {
                    e = e12;
                    e.printStackTrace();
                    this.f7783u.b(a(e));
                    this.f7783u.a(6);
                    throw new bv(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e13) {
                    e = e13;
                    e.printStackTrace();
                    this.f7783u.b(a(e));
                    this.f7783u.a(2);
                    throw new bv("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused) {
                    this.f7783u.b(7101);
                    this.f7783u.a(7);
                    throw new bv(AMapException.ERROR_UNKNOWN);
                } catch (UnknownHostException e14) {
                    e = e14;
                    e.printStackTrace();
                    this.f7783u.a(5);
                    throw new bv("未知主机 - UnKnowHostException");
                } catch (SSLException e15) {
                    e = e15;
                    e.printStackTrace();
                    this.f7783u.b(a(e));
                    this.f7783u.a(4);
                    throw new bv("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e16) {
                    e = e16;
                    e.printStackTrace();
                    this.f7783u.b(a(e));
                    this.f7783u.a(2);
                    throw new bv("IO 操作异常 - IOException");
                } catch (IOException e17) {
                    e = e17;
                    e.printStackTrace();
                    this.f7783u.a(7);
                    throw new bv("IO 操作异常 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    dc.a(th, "ht", "mPt");
                    this.f7783u.a(9);
                    throw new bv(AMapException.ERROR_UNKNOWN);
                }
            } catch (bv e18) {
                e = e18;
            } catch (InterruptedIOException unused2) {
            } catch (ConnectException e19) {
                e = e19;
            } catch (MalformedURLException e20) {
                e = e20;
            } catch (SocketException e21) {
                e = e21;
            } catch (SocketTimeoutException e22) {
                e = e22;
            } catch (UnknownHostException e23) {
                e = e23;
            } catch (SSLException e24) {
                e = e24;
            } catch (ConnectTimeoutException e25) {
                e = e25;
            } catch (IOException e26) {
                e = e26;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    dc.a(th9, "ht", "mPt");
                }
            }
            this.f7783u.d();
            throw th8;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Vector<e> f7810a;

        /* renamed from: b, reason: collision with root package name */
        private volatile e f7811b;

        private d() {
            this.f7810a = new Vector<>();
            this.f7811b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f7811b;
            }
            byte b4 = 0;
            for (int i10 = 0; i10 < this.f7810a.size(); i10++) {
                e eVar = this.f7810a.get(i10);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b4);
            eVar2.b(str);
            this.f7810a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b4) {
            this();
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = dt.f7745e;
        if (hashMap != null) {
            if (map != null) {
                map.putAll(hashMap);
            } else {
                map = hashMap;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf(SymbolValues.QUESTION_EN_SYMBOL);
        if (indexOf >= 0) {
            HashMap hashMap2 = new HashMap();
            String substring = str.substring(indexOf);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!substring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                    hashMap2.put(key, value);
                }
            }
            map = hashMap2;
        }
        if (map.size() == 0) {
            return str;
        }
        String a10 = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith(SymbolValues.QUESTION_EN_SYMBOL) && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append(SymbolValues.QUESTION_EN_SYMBOL);
        }
        if (a10 != null) {
            stringBuffer.append(a10);
        }
        return stringBuffer.toString();
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class e implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private String f7812a;

        /* renamed from: b, reason: collision with root package name */
        private String f7813b;

        private e() {
        }

        public /* synthetic */ e(byte b4) {
            this();
        }

        public final void a(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f7812a) && str.contains(com.huawei.openalliance.ad.constant.u.bD) && (split = str.split(com.huawei.openalliance.ad.constant.u.bD)) != null && split.length > 0) {
                this.f7812a = split[0];
            } else {
                this.f7812a = str;
            }
        }

        public final void b(String str) {
            this.f7813b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f7812a)) {
                return this.f7812a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f7813b)) {
                return defaultHostnameVerifier.verify(this.f7813b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        public final String a() {
            return this.f7813b;
        }
    }

    public final ea a(dz dzVar) throws bv {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            c(dzVar);
                                            String a10 = a(this.f7776m, dzVar.f());
                                            this.f7776m = a10;
                                            ea b4 = dv.b(a10, this.f7774j);
                                            if (b4 != null) {
                                                this.f7783u.d();
                                                return b4;
                                            }
                                            b a11 = a(dzVar, false);
                                            httpURLConnection = a11.f7794a;
                                            this.f7783u.f7815b = SystemClock.elapsedRealtime();
                                            httpURLConnection.connect();
                                            this.f7783u.a();
                                            ea a12 = a(a11);
                                            this.f7783u.a(a12);
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Throwable th) {
                                                dc.a(th, "ht", "mgr");
                                            }
                                            this.f7783u.d();
                                            return a12;
                                        } catch (InterruptedIOException unused) {
                                            this.f7783u.b(7101);
                                            this.f7783u.a(7);
                                            throw new bv(AMapException.ERROR_UNKNOWN);
                                        } catch (SSLException e2) {
                                            e2.printStackTrace();
                                            this.f7783u.b(a(e2));
                                            this.f7783u.a(4);
                                            throw new bv("IO 操作异常 - IOException");
                                        }
                                    } catch (ConnectException e10) {
                                        this.f7783u.b(a(e10));
                                        this.f7783u.a(6);
                                        throw new bv(AMapException.ERROR_CONNECTION);
                                    } catch (UnknownHostException unused2) {
                                        this.f7783u.a(9);
                                        throw new bv("未知主机 - UnKnowHostException");
                                    }
                                } catch (SocketTimeoutException e11) {
                                    this.f7783u.b(a(e11));
                                    this.f7783u.a(2);
                                    throw new bv("socket 连接超时 - SocketTimeoutException");
                                } catch (ConnectTimeoutException e12) {
                                    e12.printStackTrace();
                                    this.f7783u.b(a(e12));
                                    this.f7783u.a(2);
                                    throw new bv("IO 操作异常 - IOException");
                                }
                            } catch (bv e13) {
                                if (!e13.i() && e13.g() != 10) {
                                    this.f7783u.a(e13.f());
                                }
                                throw e13;
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            this.f7783u.a(9);
                            throw new bv(AMapException.ERROR_UNKNOWN);
                        }
                    } catch (IOException unused3) {
                        this.f7783u.a(7);
                        throw new bv("IO 操作异常 - IOException");
                    }
                } catch (MalformedURLException unused4) {
                    this.f7783u.a(8);
                    throw new bv("url异常 - MalformedURLException");
                }
            } catch (SocketException e14) {
                this.f7783u.b(a(e14));
                this.f7783u.a(6);
                throw new bv(AMapException.ERROR_SOCKET);
            }
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    dc.a(th4, "ht", "mgr");
                }
            }
            this.f7783u.d();
            throw th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:32:0x00cb, B:35:0x00e3, B:37:0x00e6, B:39:0x00ea, B:41:0x00f0, B:44:0x00f9, B:47:0x0105, B:49:0x0108, B:53:0x010e, B:54:0x013c, B:56:0x0142, B:58:0x014c, B:59:0x015d, B:61:0x0185, B:63:0x01a6, B:64:0x01a9, B:51:0x0124, B:69:0x0128, B:71:0x012b, B:75:0x0131, B:73:0x0138), top: B:31:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.dw.b a(com.amap.api.col.s.dz r15, boolean r16) throws java.io.IOException, com.amap.api.col.s.bv {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dw.a(com.amap.api.col.s.dz, boolean):com.amap.api.col.s.dw$b");
    }

    private dx b() {
        try {
            SoftReference<dx> softReference = f7764t;
            if (softReference == null || softReference.get() == null) {
                f7764t = new SoftReference<>(new dx(bx.f7324c, this.f7766b));
            }
            dx dxVar = f7763k != null ? f7764t.get() : null;
            return dxVar == null ? new dx(bx.f7324c, this.f7766b) : dxVar;
        } catch (Throwable th) {
            df.c(th, "ht", "gsf");
            return null;
        }
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x016d A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:32:0x00a4, B:146:0x016d, B:147:0x01b9), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:32:0x00a4, B:146:0x016d, B:147:0x01b9), top: B:2:0x0007 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.ea a(com.amap.api.col.s.dw.b r15) throws com.amap.api.col.s.bv, java.io.IOException {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dw.a(com.amap.api.col.s.dw$b):com.amap.api.col.s.ea");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "#"
            java.lang.String r1 = "lct"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "sc"
            java.lang.Object r4 = r7.get(r4)     // Catch: java.lang.Throwable -> L62
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L3c
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L62
            if (r5 <= 0) goto L3c
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L62
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L3c
            boolean r5 = r4.contains(r0)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L2a
        L28:
            r0 = 1
            goto L3d
        L2a:
            java.lang.String[] r0 = r4.split(r0)     // Catch: java.lang.Throwable -> L62
            int r4 = r0.length     // Catch: java.lang.Throwable -> L62
            if (r4 <= r2) goto L3c
            java.lang.String r4 = "1"
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L62
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L3c
            goto L28
        L3c:
            r0 = 0
        L3d:
            if (r0 != 0) goto L40
            return r3
        L40:
            if (r8 == 0) goto L63
            boolean r8 = r7.containsKey(r1)     // Catch: java.lang.Throwable -> L62
            if (r8 == 0) goto L62
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Throwable -> L62
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L62
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L62
            if (r8 <= 0) goto L62
            long r7 = com.amap.api.col.s.bx.a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f7774j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.s.bx.a(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dw.a(java.util.Map, boolean):boolean");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        c f10;
        if (map != null) {
            try {
                for (String str : map.h()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                dc.a(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = dt.f7744d;
        if (hashMap != null) {
            for (String str2 : hashMap.h()) {
                httpURLConnection.addRequestProperty(str2, dt.f7744d.get(str2));
            }
        }
        String str3 = "";
        if (!this.f7776m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f7774j) && bx.d(this.f7774j)) {
            this.f7778o = true;
            bx.g f11 = bx.f(this.f7774j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(f11.f7382a));
            httpURLConnection.addRequestProperty("lct-info", f11.f7383b);
            httpURLConnection.addRequestProperty("aks", bx.c(bx.a(this.f7774j)));
            httpURLConnection.addRequestProperty("lct-args", a(bx.b(this.f7774j) != null ? bx.b(this.f7774j).c() : "", this.f7774j));
        }
        httpURLConnection.addRequestProperty("csid", this.f7771g);
        if (a(this.f7783u.f7816c.f7800e)) {
            f fVar = this.f7783u;
            if (!TextUtils.isEmpty(fVar.f7816c.f7798c)) {
                str3 = cb.b(dp.a(fVar.f7816c.f7798c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.f7816c.f7798c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (bx.f7331j && (f10 = bx.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f10.b());
                this.f7783u.f7818e = f10;
            }
            a e2 = bx.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.f7783u.f7817d = e2;
            }
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(URLEncoder.encode(key));
            sb2.append("=");
            sb2.append(URLEncoder.encode(value));
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (this.f7775l) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f7777n) && (this.f7777n.contains("rest") || this.f7777n.contains("apilocate"))) || b(str);
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return SocketOptions.SO_TIMEOUT;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    private static String a(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = bx.f7324c;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? ci.a(context) : "");
    }
}
