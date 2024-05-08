package com.huawei.hms.scankit.p;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: HiAnalyticsLogExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a4 {

    /* renamed from: h, reason: collision with root package name */
    private static volatile a4 f30692h = new a4();

    /* renamed from: i, reason: collision with root package name */
    private static String[] f30693i = {"AD", "AL", "AN", "AT", "AU", "AX", "BA", "BE", "BG", "BQ", "CA", "CH", "CW", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GG", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", "NO", "NZ", "PL", "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", "UA", "UM", "US", "VA", "VC", "XK", "YK"};

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f30696c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f30697d;

    /* renamed from: a, reason: collision with root package name */
    private Timer f30694a = new Timer();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f30695b = true;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f30698e = false;

    /* renamed from: f, reason: collision with root package name */
    private final Lock f30699f = new ReentrantLock();

    /* renamed from: g, reason: collision with root package name */
    private List<b> f30700g = new ArrayList(5);

    /* compiled from: HiAnalyticsLogExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a4.this.d();
        }
    }

    /* compiled from: HiAnalyticsLogExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private String f30702a;

        /* renamed from: b, reason: collision with root package name */
        private LinkedHashMap<String, String> f30703b;

        public /* synthetic */ b(a4 a4Var, String str, LinkedHashMap linkedHashMap, a aVar) {
            this(str, linkedHashMap);
        }

        private b(String str, LinkedHashMap<String, String> linkedHashMap) {
            this.f30702a = str;
            this.f30703b = linkedHashMap;
        }
    }

    /* compiled from: HiAnalyticsLogExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c extends TimerTask {
        private c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                a4.this.f30695b = true;
                HmsHiAnalyticsUtils.onReport();
            } catch (Exception e2) {
                o4.b("ScanHiAnalytics", e2.getMessage());
            }
        }

        public /* synthetic */ c(a4 a4Var, a aVar) {
            this();
        }
    }

    private a4() {
    }

    public static a4 b() {
        return f30692h;
    }

    private void c(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!this.f30698e) {
            HmsHiAnalyticsUtils.onEvent(0, str, linkedHashMap);
            HmsHiAnalyticsUtils.onEvent(1, str, linkedHashMap);
        }
        if (this.f30695b) {
            this.f30695b = false;
            this.f30694a.schedule(new c(this, null), com.huawei.openalliance.ad.ipc.c.Code);
        }
        o4.d("ScanHiAnalytics", str + " " + linkedHashMap.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f30699f.tryLock() || this.f30696c) {
            return;
        }
        try {
            Context context = DynamicModuleInitializer.getContext();
            if (context == null) {
                return;
            }
            String a10 = a(context);
            if (a10 != null && !a10.isEmpty()) {
                HmsHiAnalyticsUtils.init(context, false, false, false, a10, context.getPackageName());
                HmsHiAnalyticsUtils.enableLog();
                a();
            }
        } finally {
            this.f30699f.unlock();
        }
    }

    public void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f30696c) {
            c(str, linkedHashMap);
        } else {
            a(str, linkedHashMap);
            c();
        }
    }

    private synchronized void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f30696c) {
            c(str, linkedHashMap);
        } else {
            if (this.f30700g.size() >= 100) {
                return;
            }
            this.f30700g.add(new b(this, str, linkedHashMap, null));
        }
    }

    private synchronized void a() {
        this.f30696c = true;
        for (b bVar : this.f30700g) {
            c(bVar.f30702a, bVar.f30703b);
        }
        this.f30700g = null;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f30697d > 6000) {
            this.f30697d = currentTimeMillis;
            new a("ScanHiAnalytics").start();
        }
    }

    private String a(Context context) {
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            String a10 = new a1(context, false).a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getCollectURL:localCountryCode ");
            sb2.append(a10);
            if (a10 != null && !a10.isEmpty() && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(a10)) {
                grsBaseInfo.setSerCountry(a10.toUpperCase(Locale.ENGLISH));
            }
            if (Arrays.asList(f30693i).contains(a10)) {
                this.f30698e = true;
            }
            GrsClient grsClient = new GrsClient(context, grsBaseInfo);
            String synGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOTNEW");
            if (TextUtils.isEmpty(synGetGrsUrl)) {
                synGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOT");
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("grs get url success: ");
            sb3.append(synGetGrsUrl);
            sb3.append("  countryCode = ");
            sb3.append(grsBaseInfo.getSerCountry());
            return synGetGrsUrl;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }
}
