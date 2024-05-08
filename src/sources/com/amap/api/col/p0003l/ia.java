package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.hw;
import com.amap.api.col.p0003l.id;
import com.amap.api.maps.AMapException;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.openalliance.ad.constant.u;
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
public final class ia {

    /* renamed from: k, reason: collision with root package name */
    private static SoftReference<SSLContext> f6347k;

    /* renamed from: t, reason: collision with root package name */
    private static SoftReference<ib> f6348t;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6349a;

    /* renamed from: b, reason: collision with root package name */
    private SSLContext f6350b;

    /* renamed from: c, reason: collision with root package name */
    private Proxy f6351c;

    /* renamed from: g, reason: collision with root package name */
    private String f6355g;

    /* renamed from: h, reason: collision with root package name */
    private hw.a f6356h;

    /* renamed from: i, reason: collision with root package name */
    private d f6357i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6359l;

    /* renamed from: m, reason: collision with root package name */
    private String f6360m;

    /* renamed from: n, reason: collision with root package name */
    private String f6361n;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f6352d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f6353e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f6354f = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f6358j = "";

    /* renamed from: o, reason: collision with root package name */
    private boolean f6362o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6363p = false;

    /* renamed from: q, reason: collision with root package name */
    private String f6364q = "";

    /* renamed from: r, reason: collision with root package name */
    private String f6365r = "";

    /* renamed from: s, reason: collision with root package name */
    private String f6366s = "";

    /* renamed from: u, reason: collision with root package name */
    private f f6367u = new f();

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements Cloneable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f6368a;

        /* renamed from: b, reason: collision with root package name */
        public String f6369b;

        /* renamed from: c, reason: collision with root package name */
        public String f6370c;

        /* renamed from: d, reason: collision with root package name */
        public String f6371d;

        /* renamed from: e, reason: collision with root package name */
        public String f6372e;

        /* renamed from: f, reason: collision with root package name */
        public int f6373f;

        /* renamed from: g, reason: collision with root package name */
        public int f6374g;

        /* renamed from: h, reason: collision with root package name */
        public int f6375h;

        /* renamed from: i, reason: collision with root package name */
        public long f6376i;

        /* renamed from: j, reason: collision with root package name */
        public volatile AtomicInteger f6377j = new AtomicInteger(1);

        public a(c cVar) {
            this.f6369b = cVar.f6382c;
            this.f6370c = cVar.f6384e;
            this.f6372e = cVar.f6383d;
            this.f6373f = cVar.f6392m;
            this.f6374g = cVar.f6393n;
            this.f6375h = cVar.f6381b.a();
            this.f6371d = cVar.f6380a;
            this.f6376i = cVar.f6385f;
            if (this.f6373f == 10) {
                this.f6368a = 0;
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
                String str5 = this.f6373f + "#";
                if (!TextUtils.isEmpty(this.f6372e)) {
                    str = str5 + this.f6372e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f6375h + "#") + ((Object) this.f6377j) + "#";
                if (!TextUtils.isEmpty(this.f6369b)) {
                    str2 = str6 + this.f6369b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f6373f == 1) {
                    str3 = str2 + this.f6371d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f6373f == 1) {
                    str4 = str3 + this.f6376i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String b4 = fn.b(hs.a(((str4 + this.f6370c + "#") + this.f6374g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                ia.b();
                return b4;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f6368a - ((a) obj).f6368a;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f6378a;

        /* renamed from: b, reason: collision with root package name */
        public int f6379b = this.f6379b;

        /* renamed from: b, reason: collision with root package name */
        public int f6379b = this.f6379b;

        public b(HttpURLConnection httpURLConnection) {
            this.f6378a = httpURLConnection;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public String f6380a = "";

        /* renamed from: b, reason: collision with root package name */
        public id.b f6381b = id.b.FIRST_NONDEGRADE;

        /* renamed from: c, reason: collision with root package name */
        public String f6382c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f6383d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f6384e = "";

        /* renamed from: f, reason: collision with root package name */
        public long f6385f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f6386g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f6387h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f6388i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f6389j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f6390k = "-";

        /* renamed from: l, reason: collision with root package name */
        public String f6391l = "-";

        /* renamed from: m, reason: collision with root package name */
        public int f6392m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f6393n = 0;

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
            if (TextUtils.isEmpty(this.f6382c)) {
                str = "-#";
            } else {
                str = this.f6382c + "#";
            }
            if (!TextUtils.isEmpty(this.f6383d)) {
                str2 = str + this.f6383d + "#";
            } else {
                str2 = str + "-#";
            }
            String b4 = fn.b(hs.a(((((str2 + this.f6381b.a() + "#") + this.f6387h + "#") + this.f6389j + "#") + this.f6385f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            ia.b();
            return b4;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f6380a + "', degradeType=" + ((Object) this.f6381b) + ", serverIp='" + this.f6382c + "', path='" + this.f6383d + "', hostname='" + this.f6384e + "', totalTime=" + this.f6385f + ", DNSTime=" + this.f6386g + ", connectionTime=" + this.f6387h + ", writeTime=" + this.f6388i + ", readTime=" + this.f6389j + ", serverTime='" + this.f6390k + "', datasize='" + this.f6391l + "', errorcode=" + this.f6392m + ", errorcodeSub=" + this.f6393n + '}';
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public long f6398a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f6399b = 0;

        /* renamed from: c, reason: collision with root package name */
        public c f6400c = new c();

        /* renamed from: d, reason: collision with root package name */
        public a f6401d;

        /* renamed from: e, reason: collision with root package name */
        public c f6402e;

        /* renamed from: f, reason: collision with root package name */
        public String f6403f;

        /* renamed from: g, reason: collision with root package name */
        public URL f6404g;

        public f() {
        }

        public final void a(id idVar, URL url) {
            this.f6404g = url;
            this.f6400c.f6383d = url.getPath();
            this.f6400c.f6384e = url.getHost();
            if (!TextUtils.isEmpty(ia.this.f6361n) && idVar.getDegradeType().b()) {
                c cVar = this.f6400c;
                cVar.f6382c = cVar.f6384e.replace("[", "").replace("]", "");
                this.f6400c.f6384e = ia.this.f6361n;
            }
            if (idVar.getDegradeType().b()) {
                idVar.setNon_degrade_final_Host(this.f6400c.f6384e);
            }
            if (idVar.getDegradeType().d()) {
                this.f6403f = idVar.getNon_degrade_final_Host();
            }
        }

        public final void b() {
            this.f6400c.f6388i = SystemClock.elapsedRealtime() - this.f6399b;
        }

        public final void c() {
            this.f6400c.f6389j = SystemClock.elapsedRealtime() - this.f6399b;
        }

        public final void d() {
            c clone = this.f6400c.clone();
            if (this.f6400c.f6385f > fk.f5775e) {
                clone.f6392m = 1;
            }
            fk.a(clone);
        }

        public final void b(int i10) {
            this.f6400c.f6393n = i10;
        }

        public final void a() {
            this.f6400c.f6387h = SystemClock.elapsedRealtime() - this.f6399b;
        }

        public final void a(ie ieVar) {
            c clone;
            try {
                this.f6400c.f6385f = SystemClock.elapsedRealtime() - this.f6398a;
                if (ieVar != null) {
                    ieVar.f6449f = this.f6400c.f6381b.c();
                }
                if (this.f6400c.f6381b.b()) {
                    c cVar = this.f6400c;
                    if (cVar.f6385f > 10000) {
                        fk.a(false, cVar.f6384e);
                    }
                }
                if (this.f6400c.f6381b.d()) {
                    fk.a(false, this.f6403f);
                }
                boolean a10 = ia.this.a(this.f6400c.f6384e);
                if (a10) {
                    fk.c(this.f6400c);
                    fk.a(true, this.f6401d);
                    c cVar2 = this.f6400c;
                    if (cVar2.f6385f > fk.f5775e && (clone = cVar2.clone()) != null) {
                        clone.f6392m = 1;
                        fk.b(clone);
                        clone.toString();
                        ia.b();
                    }
                }
                fk.a(this.f6404g.toString(), this.f6400c.f6381b.c(), false, a10);
                this.f6400c.toString();
                ia.b();
            } catch (Throwable unused) {
            }
        }

        public final void a(int i10) {
            "----errorcode-----".concat(String.valueOf(i10));
            ia.b();
            try {
                this.f6400c.f6385f = SystemClock.elapsedRealtime() - this.f6398a;
                c cVar = this.f6400c;
                cVar.f6392m = i10;
                if (cVar.f6381b.e()) {
                    fk.a(false, this.f6400c.f6384e);
                }
                boolean a10 = ia.this.a(this.f6400c.f6384e);
                if (a10) {
                    if (ia.this.f6363p && !TextUtils.isEmpty(ia.this.f6361n) && this.f6400c.f6381b.b()) {
                        fk.d();
                    }
                    if (this.f6400c.f6381b.c()) {
                        fk.a(this.f6400c.f6381b.c(), this.f6400c.f6384e);
                    }
                    fk.c(this.f6402e);
                    fk.a(false, this.f6401d);
                    fk.b(this.f6400c);
                }
                fk.a(this.f6404g.toString(), this.f6400c.f6381b.c(), true, a10);
                this.f6400c.toString();
                ia.b();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j10) {
            this.f6400c.f6391l = new DecimalFormat("0.00").format(((float) j10) / 1024.0f);
        }
    }

    public ia() {
        fk.e();
        try {
            this.f6355g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            gv.a(th, "ht", "ic");
        }
    }

    public static void b() {
    }

    private void d(id idVar) throws fi {
        this.f6357i = new d((byte) 0);
        this.f6363p = idVar.isIPV6Request();
        this.f6351c = idVar.getProxy();
        this.f6356h = idVar.getUrlConnectionImpl();
        this.f6359l = idVar.isBinary();
        this.f6358j = idVar.parseSdkNameFromRequest();
        this.f6349a = fo.a().a(idVar.isHttps());
        String b4 = idVar.getDegradeType().b() ? idVar.b() : idVar.a();
        this.f6360m = b4;
        this.f6360m = hz.a(b4, this.f6358j);
        this.f6361n = idVar.getIPDNSName();
        if ("loc".equals(this.f6358j)) {
            String a10 = idVar.a();
            String b10 = idVar.b();
            if (!TextUtils.isEmpty(a10)) {
                try {
                    this.f6365r = new URL(a10).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(b10)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.f6361n)) {
                    this.f6364q = this.f6361n;
                } else {
                    this.f6364q = new URL(b10).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final ie c(id idVar) throws fi {
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        ?? r72 = 0;
        r72 = 0;
        try {
            try {
                d(idVar);
                ie b4 = hz.b(this.f6360m, this.f6358j);
                if (b4 != null) {
                    this.f6367u.d();
                    return b4;
                }
                b a10 = a(idVar, true, true);
                HttpURLConnection httpURLConnection = a10.f6378a;
                try {
                    this.f6367u.f6399b = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.f6367u.a();
                    byte[] entityBytes = idVar.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        Map<String, String> params = idVar.getParams();
                        HashMap<String, String> hashMap = hw.f6313e;
                        if (hashMap != null) {
                            if (params != null) {
                                params.putAll(hashMap);
                            } else {
                                params = hashMap;
                            }
                        }
                        String a11 = a(params);
                        if (!TextUtils.isEmpty(a11)) {
                            entityBytes = fv.a(a11);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.f6367u.f6399b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                        }
                        try {
                            dataOutputStream.write(entityBytes);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f6367u.b();
                        } catch (Throwable th3) {
                            th = th3;
                            r72 = dataOutputStream;
                            if (r72 != 0) {
                                r72.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f6367u.b();
                            throw th;
                        }
                    }
                    ie a12 = a(a10, idVar.isIgnoreGZip());
                    this.f6367u.a(a12);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        gv.a(th4, "ht", "mPt");
                    }
                    this.f6367u.d();
                    return a12;
                } catch (fi e2) {
                    e = e2;
                    if (!e.i() && e.g() != 10) {
                        this.f6367u.a(e.g());
                    }
                    gv.a(e, "ht", "mPt");
                    throw e;
                } catch (ConnectException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f6367u.b(a(e));
                    this.f6367u.a(6);
                    throw new fi(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.f6367u.a(8);
                    throw new fi("url异常 - MalformedURLException");
                } catch (SocketException e12) {
                    e = e12;
                    e.printStackTrace();
                    this.f6367u.b(a(e));
                    this.f6367u.a(6);
                    throw new fi(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e13) {
                    e = e13;
                    e.printStackTrace();
                    this.f6367u.b(a(e));
                    this.f6367u.a(2);
                    throw new fi("socket 连接超时 - SocketTimeoutException");
                } catch (ConnectTimeoutException e14) {
                    e = e14;
                    e.printStackTrace();
                    this.f6367u.b(a(e));
                    this.f6367u.a(2);
                    throw new fi("IO 操作异常 - IOException");
                } catch (InterruptedIOException unused) {
                    this.f6367u.b(7101);
                    this.f6367u.a(7);
                    throw new fi(AMapException.ERROR_UNKNOWN);
                } catch (UnknownHostException e15) {
                    e = e15;
                    e.printStackTrace();
                    this.f6367u.a(5);
                    throw new fi("未知主机 - UnKnowHostException");
                } catch (SSLException e16) {
                    e = e16;
                    e.printStackTrace();
                    this.f6367u.b(a(e));
                    this.f6367u.a(4);
                    throw new fi("IO 操作异常 - IOException");
                } catch (IOException e17) {
                    e = e17;
                    e.printStackTrace();
                    this.f6367u.a(7);
                    throw new fi("IO 操作异常 - IOException");
                } catch (Throwable th5) {
                    th = th5;
                    gv.a(th, "ht", "mPt");
                    this.f6367u.a(9);
                    throw new fi(AMapException.ERROR_UNKNOWN);
                }
            } catch (fi e18) {
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
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            if (0 != 0) {
                try {
                    r72.disconnect();
                } catch (Throwable th8) {
                    gv.a(th8, "ht", "mPt");
                }
            }
            this.f6367u.d();
            throw th7;
        }
    }

    public final void b(long j10) {
        this.f6353e = j10;
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Vector<e> f6394a;

        /* renamed from: b, reason: collision with root package name */
        private volatile e f6395b;

        private d() {
            this.f6394a = new Vector<>();
            this.f6395b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f6395b;
            }
            byte b4 = 0;
            for (int i10 = 0; i10 < this.f6394a.size(); i10++) {
                e eVar = this.f6394a.get(i10);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b4);
            eVar2.b(str);
            this.f6394a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b4) {
            this();
        }
    }

    public final void a() {
        this.f6352d = true;
    }

    public final ie b(id idVar) throws fi {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        d(idVar);
                                        String a10 = a(this.f6360m, idVar.getParams());
                                        this.f6360m = a10;
                                        ie b4 = hz.b(a10, this.f6358j);
                                        if (b4 != null) {
                                            this.f6367u.d();
                                            return b4;
                                        }
                                        b a11 = a(idVar, false, true);
                                        httpURLConnection = a11.f6378a;
                                        this.f6367u.f6399b = SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.f6367u.a();
                                        ie a12 = a(a11, idVar.isIgnoreGZip());
                                        this.f6367u.a(a12);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th) {
                                            gv.a(th, "ht", "mgr");
                                        }
                                        this.f6367u.d();
                                        return a12;
                                    } catch (ConnectTimeoutException e2) {
                                        e2.printStackTrace();
                                        this.f6367u.b(a(e2));
                                        this.f6367u.a(2);
                                        throw new fi("IO 操作异常 - IOException");
                                    } catch (InterruptedIOException unused) {
                                        this.f6367u.b(7101);
                                        this.f6367u.a(7);
                                        throw new fi(AMapException.ERROR_UNKNOWN);
                                    }
                                } catch (MalformedURLException unused2) {
                                    this.f6367u.a(8);
                                    throw new fi("url异常 - MalformedURLException");
                                } catch (UnknownHostException unused3) {
                                    this.f6367u.a(9);
                                    throw new fi("未知主机 - UnKnowHostException");
                                }
                            } catch (fi e10) {
                                if (!e10.i() && e10.g() != 10) {
                                    this.f6367u.a(e10.f());
                                }
                                throw e10;
                            } catch (SSLException e11) {
                                e11.printStackTrace();
                                this.f6367u.b(a(e11));
                                this.f6367u.a(4);
                                throw new fi("IO 操作异常 - IOException");
                            }
                        } catch (ConnectException e12) {
                            this.f6367u.b(a(e12));
                            this.f6367u.a(6);
                            throw new fi(AMapException.ERROR_CONNECTION);
                        } catch (SocketTimeoutException e13) {
                            this.f6367u.b(a(e13));
                            this.f6367u.a(2);
                            throw new fi("socket 连接超时 - SocketTimeoutException");
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        this.f6367u.a(9);
                        throw new fi(AMapException.ERROR_UNKNOWN);
                    }
                } catch (IOException unused4) {
                    this.f6367u.a(7);
                    throw new fi("IO 操作异常 - IOException");
                }
            } catch (SocketException e14) {
                this.f6367u.b(a(e14));
                this.f6367u.a(6);
                throw new fi(AMapException.ERROR_SOCKET);
            }
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    gv.a(th4, "ht", "mgr");
                }
            }
            this.f6367u.d();
            throw th3;
        }
    }

    public final void a(long j10) {
        this.f6354f = j10;
    }

    /* compiled from: HttpUrlUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class e implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private String f6396a;

        /* renamed from: b, reason: collision with root package name */
        private String f6397b;

        private e() {
        }

        public /* synthetic */ e(byte b4) {
            this();
        }

        public final void a(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f6396a) && str.contains(u.bD) && (split = str.split(u.bD)) != null && split.length > 0) {
                this.f6396a = split[0];
            } else {
                this.f6396a = str;
            }
        }

        public final void b(String str) {
            this.f6397b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f6396a)) {
                return this.f6396a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f6397b)) {
                return defaultHostnameVerifier.verify(this.f6397b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        public final String a() {
            return this.f6397b;
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = hw.f6313e;
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

    /* JADX WARN: Can't wrap try/catch for region: R(17:(3:6|7|8)|(3:494|495|(15:497|11|13|14|(4:444|445|446|447)(1:16)|17|18|19|(1:21)(1:421)|22|(1:24)|25|(4:27|28|29|(2:31|32))(13:309|310|311|312|(6:319|320|(4:322|323|324|(1:326)(1:333))(1:392)|(2:328|329)(2:331|332)|330|313)|394|334|(1:336)(1:358)|337|(2:350|351)|339|340|(2:342|343))|37|38))|10|11|13|14|(0)(0)|17|18|19|(0)(0)|22|(0)|25|(0)(0)|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x02b8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x02b9, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0312, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0313, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x02f4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x02f5, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x02e0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x02e1, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x02d6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x02d7, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x02fe, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x02ff, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x02cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x02cd, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x02ea, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x02eb, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0308, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0309, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x02c2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x02c3, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x02ae, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x02af, code lost:
    
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0321, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0322, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x0345, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0346, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0339, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x033a, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x0333, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0334, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x034b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x034c, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x032d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x032e, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0357, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0358, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x033f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x0340, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x0351, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x0352, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0327, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0328, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x031c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x031d, code lost:
    
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x051a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x050f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0493 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0471 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0466 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0455 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0433 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0428 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0417 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x059c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0591 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0580 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x055b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0550 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x053f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0148 A[Catch: all -> 0x00cc, fi -> 0x00cf, IOException -> 0x00d2, InterruptedIOException -> 0x00d5, SocketTimeoutException -> 0x00d8, SocketException -> 0x00db, UnknownHostException -> 0x00de, MalformedURLException -> 0x00e1, ConnectTimeoutException -> 0x00e4, SSLException -> 0x00e7, ConnectException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #52 {fi -> 0x00cf, ConnectException -> 0x00ea, MalformedURLException -> 0x00e1, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, UnknownHostException -> 0x00de, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, IOException -> 0x00d2, all -> 0x00cc, blocks: (B:447:0x00bc, B:27:0x0148), top: B:446:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x037f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x036e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0192 A[Catch: all -> 0x02ae, fi -> 0x02b8, IOException -> 0x02c2, InterruptedIOException -> 0x02cc, SocketTimeoutException -> 0x02d6, SocketException -> 0x02e0, UnknownHostException -> 0x02ea, MalformedURLException -> 0x02f4, ConnectTimeoutException -> 0x02fe, SSLException -> 0x0308, ConnectException -> 0x0312, TRY_ENTER, TRY_LEAVE, TryCatch #53 {fi -> 0x02b8, ConnectException -> 0x0312, MalformedURLException -> 0x02f4, SocketException -> 0x02e0, SocketTimeoutException -> 0x02d6, ConnectTimeoutException -> 0x02fe, InterruptedIOException -> 0x02cc, UnknownHostException -> 0x02ea, SSLException -> 0x0308, IOException -> 0x02c2, all -> 0x02ae, blocks: (B:18:0x0130, B:309:0x0192), top: B:17:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x05da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x05cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x05be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.amap.api.col.p0003l.id r20, com.amap.api.col.3l.hy.a r21) {
        /*
            Method dump skipped, instructions count: 1554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ia.a(com.amap.api.col.3l.id, com.amap.api.col.3l.hy$a):void");
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

    private ib c() {
        try {
            SoftReference<ib> softReference = f6348t;
            if (softReference == null || softReference.get() == null) {
                f6348t = new SoftReference<>(new ib(fk.f5773c, this.f6350b));
            }
            ib ibVar = f6347k != null ? f6348t.get() : null;
            return ibVar == null ? new ib(fk.f5773c, this.f6350b) : ibVar;
        } catch (Throwable th) {
            gy.b(th, "ht", "gsf");
            return null;
        }
    }

    public final Map<String, String> a(id idVar) throws fi {
        int i10;
        HttpURLConnection httpURLConnection;
        String headerFieldKey;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                d(idVar);
                this.f6360m = a(this.f6360m, idVar.getParams());
                httpURLConnection = a(idVar, false, false).f6378a;
            } catch (fi e2) {
                e = e2;
            } catch (ConnectException e10) {
                e = e10;
            } catch (MalformedURLException unused) {
            } catch (SocketException e11) {
                e = e11;
            } catch (SocketTimeoutException e12) {
                e = e12;
            } catch (InterruptedIOException unused2) {
            } catch (UnknownHostException unused3) {
            } catch (SSLException e13) {
                e = e13;
            } catch (ConnectTimeoutException e14) {
                e = e14;
            } catch (IOException unused4) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f6367u.f6399b = SystemClock.elapsedRealtime();
                httpURLConnection.connect();
                this.f6367u.a();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 400) {
                    HashMap hashMap = new HashMap();
                    for (i10 = 0; i10 < 50 && (headerFieldKey = httpURLConnection.getHeaderFieldKey(i10)) != null; i10++) {
                        hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection.getHeaderField(headerFieldKey));
                    }
                    this.f6367u.a((ie) null);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th2) {
                        gv.a(th2, "hth", "mgr");
                    }
                    this.f6367u.d();
                    return hashMap;
                }
                this.f6367u.b(responseCode);
                this.f6367u.a(10);
                fi fiVar = new fi("http读取header失败");
                fiVar.a(responseCode);
                throw fiVar;
            } catch (fi e15) {
                e = e15;
                this.f6367u.a(e.g());
                throw e;
            } catch (ConnectException e16) {
                e = e16;
                this.f6367u.b(a(e));
                this.f6367u.a(6);
                throw new fi(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException unused5) {
                this.f6367u.a(8);
                throw new fi("url异常 - MalformedURLException");
            } catch (SocketTimeoutException e17) {
                e = e17;
                this.f6367u.b(a(e));
                this.f6367u.a(2);
                throw new fi("socket 连接超时 - SocketTimeoutException");
            } catch (UnknownHostException unused6) {
                this.f6367u.a(9);
                throw new fi("未知主机 - UnKnowHostException");
            } catch (SSLException e18) {
                e = e18;
                e.printStackTrace();
                this.f6367u.b(a(e));
                this.f6367u.a(4);
                throw new fi("IO 操作异常 - IOException");
            } catch (ConnectTimeoutException e19) {
                e = e19;
                e.printStackTrace();
                this.f6367u.b(a(e));
                this.f6367u.a(2);
                throw new fi("IO 操作异常 - IOException");
            } catch (InterruptedIOException unused7) {
                this.f6367u.b(7101);
                this.f6367u.a(7);
                throw new fi(AMapException.ERROR_UNKNOWN);
            } catch (SocketException e20) {
                e = e20;
                this.f6367u.b(a(e));
                this.f6367u.a(6);
                throw new fi(AMapException.ERROR_SOCKET);
            } catch (IOException unused8) {
                this.f6367u.a(7);
                throw new fi("IO 操作异常 - IOException");
            } catch (Throwable th3) {
                th = th3;
                this.f6367u.a(9);
                th.printStackTrace();
                throw new fi(AMapException.ERROR_UNKNOWN);
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Throwable th5) {
                    gv.a(th5, "hth", "mgr");
                }
            }
            this.f6367u.d();
            throw th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144 A[Catch: all -> 0x01b2, TryCatch #0 {all -> 0x01b2, blocks: (B:32:0x00cd, B:35:0x00e5, B:37:0x00e8, B:39:0x00ec, B:41:0x00f2, B:44:0x00fb, B:47:0x0107, B:49:0x010a, B:53:0x0110, B:54:0x013e, B:56:0x0144, B:58:0x014e, B:59:0x015f, B:61:0x0187, B:63:0x01a8, B:64:0x01ab, B:51:0x0126, B:69:0x012a, B:71:0x012d, B:75:0x0133, B:73:0x013a), top: B:31:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.3l.ia.b a(com.amap.api.col.p0003l.id r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.col.p0003l.fi {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ia.a(com.amap.api.col.3l.id, boolean, boolean):com.amap.api.col.3l.ia$b");
    }

    private static String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x017a A[Catch: all -> 0x01c7, IOException -> 0x01cd, SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, IOException -> 0x01cd, all -> 0x01c7, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:32:0x00a8, B:148:0x017a, B:149:0x01c6), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[Catch: all -> 0x01c7, IOException -> 0x01cd, SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, IOException -> 0x01cd, all -> 0x01c7, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:32:0x00a8, B:148:0x017a, B:149:0x01c6), top: B:2:0x0009 }] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003l.ie a(com.amap.api.col.3l.ia.b r17, boolean r18) throws com.amap.api.col.p0003l.fi, java.io.IOException {
        /*
            Method dump skipped, instructions count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ia.a(com.amap.api.col.3l.ia$b, boolean):com.amap.api.col.3l.ie");
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
            long r7 = com.amap.api.col.p0003l.fk.a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f6358j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.p0003l.fk.a(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ia.a(java.util.Map, boolean):boolean");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z10) {
        c g3;
        if (map != null) {
            try {
                for (String str : map.h()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                gv.a(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = hw.f6312d;
        if (hashMap != null) {
            for (String str2 : hashMap.h()) {
                httpURLConnection.addRequestProperty(str2, hw.f6312d.get(str2));
            }
        }
        String str3 = "";
        if (z10 && !this.f6360m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f6358j) && fk.d(this.f6358j)) {
            this.f6362o = true;
            fk.g f10 = fk.f(this.f6358j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(f10.f5831a));
            httpURLConnection.addRequestProperty("lct-info", f10.f5832b);
            httpURLConnection.addRequestProperty("aks", fk.c(fk.a(this.f6358j)));
            httpURLConnection.addRequestProperty("lct-args", a(fk.b(this.f6358j) != null ? fk.b(this.f6358j).b() : "", this.f6358j));
        }
        httpURLConnection.addRequestProperty("csid", this.f6355g);
        if (a(this.f6367u.f6400c.f6384e)) {
            f fVar = this.f6367u;
            if (!TextUtils.isEmpty(fVar.f6400c.f6382c)) {
                str3 = fn.b(hs.a(fVar.f6400c.f6382c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.f6400c.f6382c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (fk.f5780j && (g3 = fk.g()) != null) {
                httpURLConnection.addRequestProperty("nls", g3.b());
                this.f6367u.f6402e = g3;
            }
            a f11 = fk.f();
            if (f11 != null) {
                httpURLConnection.addRequestProperty("nlf", f11.b());
                this.f6367u.f6401d = f11;
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
        if (this.f6359l) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f6361n) && (this.f6361n.contains("rest") || this.f6361n.contains("apilocate"))) || b(str);
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
        Context context = fk.f5773c;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? fv.a(context) : "");
    }
}
