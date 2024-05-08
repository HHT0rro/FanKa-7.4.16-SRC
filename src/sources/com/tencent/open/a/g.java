package com.tencent.open.a;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static g f45166a;

    /* renamed from: e, reason: collision with root package name */
    public HandlerThread f45170e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f45171f;

    /* renamed from: b, reason: collision with root package name */
    public Random f45167b = new Random();

    /* renamed from: d, reason: collision with root package name */
    public List<Serializable> f45169d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c, reason: collision with root package name */
    public List<Serializable> f45168c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    public Executor f45172g = j.b();

    /* renamed from: h, reason: collision with root package name */
    public Executor f45173h = j.b();

    private g() {
        this.f45170e = null;
        if (this.f45170e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f45170e = handlerThread;
            handlerThread.start();
        }
        if (!this.f45170e.isAlive() || this.f45170e.getLooper() == null) {
            return;
        }
        this.f45171f = new Handler(this.f45170e.getLooper()) { // from class: com.tencent.open.a.g.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    g.this.b();
                } else if (i10 == 1001) {
                    g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f45166a == null) {
                f45166a = new g();
            }
            gVar = f45166a;
        }
        return gVar;
    }

    public void b() {
        this.f45173h.execute(new Runnable() { // from class: com.tencent.open.a.g.4
            /* JADX WARN: Removed duplicated region for block: B:21:0x00a5 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x0008, B:7:0x0011, B:10:0x0023, B:21:0x00a5, B:22:0x00b0, B:28:0x0094, B:30:0x0099, B:36:0x009e, B:14:0x003b, B:16:0x008a), top: B:2:0x0008, inners: #1, #2, #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[EDGE_INSN: B:33:0x00a3->B:20:0x00a3 BREAK  A[LOOP:0: B:12:0x0039->B:34:?], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:34:? A[LOOP:0: B:12:0x0039->B:34:?, LOOP_END, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r14 = this;
                    java.lang.String r0 = "report_cgi"
                    java.lang.String r1 = "https://wspeed.qq.com/w.cgi"
                    java.lang.String r2 = "-->doReportCgi, doupload exception"
                    java.lang.String r3 = "openSDK_LOG.ReportManager"
                    com.tencent.open.a.g r4 = com.tencent.open.a.g.this     // Catch: java.lang.Exception -> Lb8
                    android.os.Bundle r4 = r4.c()     // Catch: java.lang.Exception -> Lb8
                    if (r4 != 0) goto L11
                    return
                L11:
                    android.content.Context r5 = com.tencent.open.utils.f.a()     // Catch: java.lang.Exception -> Lb8
                    r6 = 0
                    com.tencent.open.utils.g r5 = com.tencent.open.utils.g.a(r5, r6)     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r7 = "Common_HttpRetryCount"
                    int r5 = r5.a(r7)     // Catch: java.lang.Exception -> Lb8
                    if (r5 != 0) goto L23
                    r5 = 3
                L23:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb8
                    r7.<init>()     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r8 = "-->doReportCgi, retryCount: "
                    r7.append(r8)     // Catch: java.lang.Exception -> Lb8
                    r7.append(r5)     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lb8
                    com.tencent.open.log.SLog.d(r3, r7)     // Catch: java.lang.Exception -> Lb8
                    r7 = 0
                    r8 = 0
                L39:
                    r9 = 1
                    int r8 = r8 + r9
                    android.content.Context r10 = com.tencent.open.utils.f.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.<init>(r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "Accept-Encoding"
                    java.lang.String r13 = "gzip"
                    r11.addHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "Content-Type"
                    java.lang.String r13 = "application/x-www-form-urlencoded"
                    r11.setHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    byte[] r12 = com.tencent.open.utils.l.i(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r13.<init>(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.setEntity(r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    int r10 = r10.getStatusCode()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.<init>()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "-->doReportCgi, statusCode: "
                    r11.append(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.append(r10)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    com.tencent.open.log.SLog.d(r3, r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11 = 200(0xc8, float:2.8E-43)
                    if (r10 != r11) goto La3
                    com.tencent.open.a.f r10 = com.tencent.open.a.f.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r10.b(r0)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r7 = 1
                    goto La3
                L93:
                    r1 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r1)     // Catch: java.lang.Exception -> Lb8
                    goto La3
                L98:
                    r9 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
                    goto La1
                L9d:
                    r9 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
                La1:
                    if (r8 < r5) goto L39
                La3:
                    if (r7 != 0) goto Lb0
                    com.tencent.open.a.f r1 = com.tencent.open.a.f.a()     // Catch: java.lang.Exception -> Lb8
                    com.tencent.open.a.g r2 = com.tencent.open.a.g.this     // Catch: java.lang.Exception -> Lb8
                    java.util.List<java.io.Serializable> r2 = r2.f45168c     // Catch: java.lang.Exception -> Lb8
                    r1.a(r0, r2)     // Catch: java.lang.Exception -> Lb8
                Lb0:
                    com.tencent.open.a.g r0 = com.tencent.open.a.g.this     // Catch: java.lang.Exception -> Lb8
                    java.util.List<java.io.Serializable> r0 = r0.f45168c     // Catch: java.lang.Exception -> Lb8
                    r0.clear()     // Catch: java.lang.Exception -> Lb8
                    goto Lbe
                Lb8:
                    r0 = move-exception
                    java.lang.String r1 = "-->doReportCgi, doupload exception out."
                    com.tencent.open.log.SLog.e(r3, r1, r0)
                Lbe:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass4.run():void");
            }
        });
    }

    public Bundle c() {
        if (this.f45168c.size() == 0) {
            return null;
        }
        b bVar = (b) this.f45168c.get(0);
        if (bVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f45160a.get("appid");
        List<Serializable> a10 = f.a().a("report_cgi");
        if (a10 != null) {
            this.f45168c.addAll(a10);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f45168c.size());
        if (this.f45168c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString(com.alipay.sdk.packet.e.f4642n, Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i10 = 0; i10 < this.f45168c.size(); i10++) {
                b bVar2 = (b) this.f45168c.get(i10);
                bundle.putString(i10 + "_1", bVar2.f45160a.get("apn"));
                bundle.putString(i10 + "_2", bVar2.f45160a.get("frequency"));
                bundle.putString(i10 + "_3", bVar2.f45160a.get("commandid"));
                bundle.putString(i10 + "_4", bVar2.f45160a.get("resultCode"));
                bundle.putString(i10 + "_5", bVar2.f45160a.get("timeCost"));
                bundle.putString(i10 + "_6", bVar2.f45160a.get("reqSize"));
                bundle.putString(i10 + "_7", bVar2.f45160a.get("rspSize"));
                bundle.putString(i10 + "_8", bVar2.f45160a.get("detail"));
                bundle.putString(i10 + "_9", bVar2.f45160a.get("uin"));
                bundle.putString(i10 + "_10", c.e(com.tencent.open.utils.f.a()) + "&" + bVar2.f45160a.get(aq.F));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e2);
            return null;
        }
    }

    public Bundle d() {
        List<Serializable> a10 = f.a().a("report_via");
        if (a10 != null) {
            this.f45169d.addAll(a10);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f45169d.size());
        if (this.f45169d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f45169d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.f45160a.h()) {
                try {
                    String str2 = bVar.f45160a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e10) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e10);
            return null;
        }
    }

    public void e() {
        this.f45172g.execute(new Runnable() { // from class: com.tencent.open.a.g.5
            @Override // java.lang.Runnable
            public void run() {
                int i10;
                try {
                    Bundle d10 = g.this.d();
                    if (d10 == null) {
                        return;
                    }
                    SLog.v("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d10.toString());
                    int a10 = e.a();
                    int i11 = 0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z10 = false;
                    int i12 = 0;
                    long j10 = 0;
                    long j11 = 0;
                    do {
                        int i13 = i11 + 1;
                        try {
                            try {
                                try {
                                    l.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.f.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d10);
                                    try {
                                        i10 = l.d(openUrl2.f45327a).getInt("ret");
                                    } catch (JSONException unused) {
                                        i10 = -4;
                                    }
                                    if (i10 == 0 || !TextUtils.isEmpty(openUrl2.f45327a)) {
                                        i13 = a10;
                                        z10 = true;
                                    }
                                    j10 = openUrl2.f45328b;
                                    j11 = openUrl2.f45329c;
                                    i11 = i13;
                                } catch (HttpUtils.HttpStatusException e2) {
                                    try {
                                        i12 = Integer.parseInt(e2.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                    } catch (Exception unused2) {
                                    }
                                } catch (HttpUtils.NetworkUnavailableException unused3) {
                                    g.this.f45169d.clear();
                                    SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                    return;
                                } catch (ConnectTimeoutException unused4) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i11 = i13;
                                    i12 = -7;
                                    j10 = 0;
                                    j11 = 0;
                                } catch (Exception unused5) {
                                    i11 = a10;
                                    i12 = -6;
                                    j10 = 0;
                                    j11 = 0;
                                }
                            } catch (SocketTimeoutException unused6) {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                i11 = i13;
                                i12 = -8;
                                j10 = 0;
                                j11 = 0;
                            } catch (IOException e10) {
                                i12 = HttpUtils.getErrorCodeFromException(e10);
                                i11 = i13;
                                j10 = 0;
                                j11 = 0;
                            }
                        } catch (JSONException unused7) {
                            i11 = i13;
                            i12 = -4;
                            j10 = 0;
                            j11 = 0;
                        }
                    } while (i11 < a10);
                    g.this.a("mapp_apptrace_sdk", elapsedRealtime, j10, j11, i12, null, false);
                    if (z10) {
                        f.a().b("report_via");
                    } else {
                        f.a().a("report_via", g.this.f45169d);
                    }
                    g.this.f45169d.clear();
                    SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z10);
                } catch (Exception e11) {
                    SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e11);
                }
            }
        });
    }

    public void a(final Bundle bundle, String str, final boolean z10) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z10) {
            this.f45172g.execute(new Runnable() { // from class: com.tencent.open.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String k10 = l.k(c.b(com.tencent.open.utils.f.a()));
                        String k11 = l.k(c.c(com.tencent.open.utils.f.a()));
                        String k12 = l.k(c.a());
                        String k13 = l.k(c.d(com.tencent.open.utils.f.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", k10);
                        bundle2.putString("imsi", k11);
                        bundle2.putString("android_id", k13);
                        bundle2.putString("mac", k12);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.f.a()));
                        bundle2.putString(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, c.b());
                        bundle2.putString("resolution", c.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.f.a()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString(HiAnalyticsConstant.BI_KEY_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", l.d(com.tencent.open.utils.f.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString("qq_ver", l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.f.b());
                        bundle2.putString("app_ver", l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        g.this.f45169d.add(new b(bundle2));
                        int size = g.this.f45169d.size();
                        int a10 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a10 == 0) {
                            a10 = 10000;
                        }
                        if (!g.this.a("report_via", size) && !z10) {
                            if (g.this.f45171f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            g.this.f45171f.sendMessageDelayed(obtain, a10);
                            return;
                        }
                        g.this.e();
                        g.this.f45171f.removeMessages(1001);
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    public void a(String str, long j10, long j11, long j12, int i10) {
        a(str, j10, j11, j12, i10, "", false);
    }

    public void a(final String str, final long j10, final long j11, final long j12, final int i10, final String str2, final boolean z10) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j10 + " | reqSize:" + j11 + " | rspSize: " + j12 + " | responseCode: " + i10 + " | detail: " + str2);
        if (a("report_cgi", "" + i10) || z10) {
            this.f45173h.execute(new Runnable() { // from class: com.tencent.open.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
                        Bundle bundle = new Bundle();
                        String a10 = a.a(com.tencent.open.utils.f.a());
                        bundle.putString("apn", a10);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("network=");
                        sb2.append(a10);
                        sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                        sb2.append("sdcard=");
                        int i11 = 1;
                        sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                        sb2.append("wifi=");
                        sb2.append(a.e(com.tencent.open.utils.f.a()));
                        bundle.putString(aq.F, sb2.toString());
                        int a11 = 100 / g.this.a(i10);
                        if (a11 > 0) {
                            i11 = a11 > 100 ? 100 : a11;
                        }
                        bundle.putString("frequency", i11 + "");
                        bundle.putString("reqSize", j11 + "");
                        bundle.putString("resultCode", i10 + "");
                        bundle.putString("rspSize", j12 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        g.this.f45168c.add(new b(bundle));
                        int size = g.this.f45168c.size();
                        int a12 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a12 == 0) {
                            a12 = 10000;
                        }
                        if (!g.this.a("report_cgi", size) && !z10) {
                            if (!g.this.f45171f.hasMessages(1000)) {
                                Message obtain = Message.obtain();
                                obtain.what = 1000;
                                g.this.f45171f.sendMessageDelayed(obtain, a12);
                            }
                        }
                        g.this.b();
                        g.this.f45171f.removeMessages(1000);
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    public boolean a(String str, String str2) {
        int a10;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i10 = 100;
        if (str.equals("report_cgi")) {
            try {
                a10 = a(Integer.parseInt(str2));
                if (this.f45167b.nextInt(100) < a10) {
                    z10 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a10 = e.a(str2);
                if (this.f45167b.nextInt(100) < a10) {
                    i10 = a10;
                    z10 = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
            return z10;
        }
        i10 = a10;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.f.a()
            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.f.a()
            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.a(java.lang.String, int):boolean");
    }

    public int a(int i10) {
        if (i10 == 0) {
            int a10 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a10 == 0) {
                return 10;
            }
            return a10;
        }
        int a11 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a11 == 0) {
            return 100;
        }
        return a11;
    }

    public void a(final String str, final String str2, final Bundle bundle, final boolean z10) {
        j.a(new Runnable() { // from class: com.tencent.open.a.g.6
            /* JADX WARN: Removed duplicated region for block: B:33:0x0135 A[Catch: Exception -> 0x0158, TRY_ENTER, TryCatch #5 {Exception -> 0x0158, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000e, B:11:0x0015, B:13:0x003e, B:14:0x0042, B:16:0x0050, B:17:0x0086, B:33:0x0135, B:35:0x013b, B:39:0x00d4, B:62:0x0118, B:68:0x0151, B:75:0x014e, B:110:0x0064, B:112:0x0072, B:113:0x0152, B:70:0x0143, B:72:0x0149), top: B:2:0x0004, inners: #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x013b A[Catch: Exception -> 0x0158, TRY_LEAVE, TryCatch #5 {Exception -> 0x0158, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000e, B:11:0x0015, B:13:0x003e, B:14:0x0042, B:16:0x0050, B:17:0x0086, B:33:0x0135, B:35:0x013b, B:39:0x00d4, B:62:0x0118, B:68:0x0151, B:75:0x014e, B:110:0x0064, B:112:0x0072, B:113:0x0152, B:70:0x0143, B:72:0x0149), top: B:2:0x0004, inners: #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 351
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass6.run():void");
            }
        });
    }
}
