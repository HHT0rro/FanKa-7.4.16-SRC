package com.mobile.auth.q;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.PnsLoggerHandler;
import com.mobile.auth.gatewayauth.manager.d;
import com.mobile.auth.gatewayauth.model.ConfigRule;
import com.mobile.auth.gatewayauth.model.pns_vendor_query.LimitedInfo;
import com.mobile.auth.gatewayauth.model.pns_vendor_query.UploadRB;
import com.mobile.auth.gatewayauth.utils.i;
import com.mobile.auth.x.b;
import com.mobile.auth.x.c;
import com.nirvana.tools.logger.ACMLogger;
import com.nirvana.tools.logger.ACMMonitor;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.model.ACMMonitorRecord;
import com.nirvana.tools.logger.utils.ConsoleLogUtils;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f37542a;

    /* renamed from: b, reason: collision with root package name */
    private ACMLogger f37543b;

    /* renamed from: c, reason: collision with root package name */
    private ACMMonitor f37544c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f37545d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f37546e;

    /* renamed from: f, reason: collision with root package name */
    private com.mobile.auth.x.a f37547f;

    /* renamed from: g, reason: collision with root package name */
    private com.mobile.auth.x.a f37548g;

    /* renamed from: h, reason: collision with root package name */
    private d f37549h;

    /* renamed from: i, reason: collision with root package name */
    private HandlerThread f37550i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f37551j;

    /* renamed from: k, reason: collision with root package name */
    private volatile PnsLoggerHandler f37552k;

    /* renamed from: l, reason: collision with root package name */
    private List<ACMMonitorRecord> f37553l;

    private a() {
        this.f37545d = false;
        this.f37546e = false;
        this.f37550i = null;
        this.f37551j = null;
        this.f37553l = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("PnsLoggerThread");
        this.f37550i = handlerThread;
        handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.mobile.auth.q.a.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
            }
        });
        this.f37550i.start();
        this.f37551j = new Handler(this.f37550i.getLooper());
    }

    public a(final Context context) {
        this();
        this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(a.this, new c());
                    b bVar = new b();
                    a.a(a.this).a(bVar);
                    a.b(a.this, new com.mobile.auth.x.d());
                    a.b(a.this).a(bVar);
                    a.a(a.this, new ACMLogger(context, a.a(a.this)));
                    a.a(a.this, new ACMMonitor(context, a.b(a.this)));
                    a.c(a.this).setUploadType(1);
                    a.c(a.this).setMaxUploadRetry(1L);
                    a.c(a.this).setMaxUploadSize(100);
                    a.c(a.this).setRetryCount(0);
                    ConsoleLogUtils.setLoggerEnable(true);
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }
        });
    }

    public static a a(Context context) {
        try {
            if (f37542a == null) {
                synchronized (a.class) {
                    if (f37542a == null && context != null) {
                        f37542a = new a(context);
                    }
                }
            }
            return f37542a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.x.a a(a aVar) {
        try {
            return aVar.f37547f;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.x.a a(a aVar, com.mobile.auth.x.a aVar2) {
        try {
            aVar.f37547f = aVar2;
            return aVar2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ ACMLogger a(a aVar, ACMLogger aCMLogger) {
        try {
            aVar.f37543b = aCMLogger;
            return aCMLogger;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ ACMMonitor a(a aVar, ACMMonitor aCMMonitor) {
        try {
            aVar.f37544c = aCMMonitor;
            return aCMMonitor;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ String a(a aVar, String[] strArr) {
        try {
            return aVar.f(strArr);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ List a(a aVar, List list) {
        try {
            aVar.f37553l = list;
            return list;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        try {
            aVar.f37546e = z10;
            return z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.x.a b(a aVar) {
        try {
            return aVar.f37548g;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.x.a b(a aVar, com.mobile.auth.x.a aVar2) {
        try {
            aVar.f37548g = aVar2;
            return aVar2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        try {
            aVar.f37545d = z10;
            return z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ ACMMonitor c(a aVar) {
        try {
            return aVar.f37544c;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ PnsLoggerHandler d(a aVar) {
        try {
            return aVar.f37552k;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ boolean e(a aVar) {
        try {
            return aVar.f37545d;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ ACMLogger f(a aVar) {
        try {
            return aVar.f37543b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private String f(String... strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    if (strArr.length == 1) {
                        return strArr[0];
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : strArr) {
                        sb2.append(str);
                    }
                    return sb2.toString();
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
        return null;
    }

    public static /* synthetic */ List g(a aVar) {
        try {
            return aVar.f37553l;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void a(PnsLoggerHandler pnsLoggerHandler) {
        try {
            this.f37552k = pnsLoggerHandler;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(d dVar) {
        try {
            this.f37549h = dVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(final ConfigRule configRule) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.3
                /* JADX WARN: Removed duplicated region for block: B:22:0x00eb A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:3:0x0002, B:5:0x0006, B:10:0x000e, B:12:0x004e, B:13:0x0057, B:14:0x00bf, B:16:0x00cb, B:19:0x00d8, B:20:0x00e3, B:22:0x00eb, B:23:0x0110, B:26:0x00fe, B:27:0x00de, B:28:0x005b, B:30:0x0061, B:33:0x0068, B:34:0x0078, B:36:0x007e, B:38:0x0090, B:40:0x0096, B:41:0x009b, B:44:0x00a7, B:47:0x00ad, B:53:0x00b5), top: B:2:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00fe A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:3:0x0002, B:5:0x0006, B:10:0x000e, B:12:0x004e, B:13:0x0057, B:14:0x00bf, B:16:0x00cb, B:19:0x00d8, B:20:0x00e3, B:22:0x00eb, B:23:0x0110, B:26:0x00fe, B:27:0x00de, B:28:0x005b, B:30:0x0061, B:33:0x0068, B:34:0x0078, B:36:0x007e, B:38:0x0090, B:40:0x0096, B:41:0x009b, B:44:0x00a7, B:47:0x00ad, B:53:0x00b5), top: B:2:0x0002 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 302
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.q.a.AnonymousClass3.run():void");
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(final UploadRB uploadRB) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UploadRB uploadRB2 = uploadRB;
                        if (uploadRB2 != null && uploadRB2.getAlibaba_aliqin_psc_info_upload_response() != null && uploadRB.getAlibaba_aliqin_psc_info_upload_response().getResult() != null && uploadRB.getAlibaba_aliqin_psc_info_upload_response().getResult().getModule() != null && uploadRB.getAlibaba_aliqin_psc_info_upload_response().getResult().getModule().getLimited_info() != null) {
                            LimitedInfo limited_info = uploadRB.getAlibaba_aliqin_psc_info_upload_response().getResult().getModule().getLimited_info();
                            ACMLimitConfig build = ACMLimitConfig.newACMLimitConfig().isLimited("true".equals(limited_info.getIs_limited())).limitCount(limited_info.getLimit_count()).limitHours(limited_info.getLimit_time_hour()).build();
                            a.c(a.this).setLimitConfig(build);
                            a.f(a.this).setLimitConfig(build);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(final String str, final int i10) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PnsLoggerHandler d10 = a.d(a.this);
                        if (d10 != null) {
                            d10.monitor(str);
                        }
                        a.this.b("CacheMonitor:", str, "\n Urgency ", String.valueOf(i10));
                        if (a.e(a.this)) {
                            return;
                        }
                        if (a.g(a.this) == null) {
                            a.a(a.this, new ArrayList());
                        }
                        ACMMonitorRecord aCMMonitorRecord = new ACMMonitorRecord(i10);
                        aCMMonitorRecord.setContent(str);
                        a.g(a.this).add(aCMMonitorRecord);
                        if (a.g(a.this).size() >= 5) {
                            a.c(a.this).monitorRecords(a.g(a.this));
                            a.g(a.this).clear();
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(final String... strArr) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String a10 = a.a(a.this, strArr);
                        PnsLoggerHandler d10 = a.d(a.this);
                        if (d10 != null) {
                            d10.info(a10);
                        }
                        i.d(a10);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean a() {
        try {
            return this.f37546e;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void b() {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (a.e(a.this)) {
                            return;
                        }
                        if (a.g(a.this) != null && a.g(a.this).size() > 0) {
                            a.c(a.this).monitorRecords(a.g(a.this));
                            a.g(a.this).clear();
                            a.this.b("CacheMonitor:", "uploadMonitor and clear");
                        }
                        a.c(a.this).uploadManual();
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void b(final String... strArr) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String a10 = a.a(a.this, strArr);
                        PnsLoggerHandler d10 = a.d(a.this);
                        if (d10 != null) {
                            d10.debug(a10);
                        }
                        i.a(a10);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void c() {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (a.e(a.this)) {
                            return;
                        }
                        if (a.g(a.this) != null && a.g(a.this).size() > 0) {
                            a.c(a.this).monitorRecords(a.g(a.this));
                            a.g(a.this).clear();
                            a.this.b("CacheMonitor:", "uploadFailedMonitor and clear");
                        }
                        a.c(a.this).uploadFailed();
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void c(final String... strArr) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String a10 = a.a(a.this, strArr);
                        PnsLoggerHandler d10 = a.d(a.this);
                        if (d10 != null) {
                            d10.warning(a10);
                        }
                        i.b(a10);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void d() {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.b("deleteMonitor:", "delete unupload Monitor");
                        a.c(a.this).deleteRecordsByFlag(2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void d(final String... strArr) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        i.b(a.a(a.this, strArr));
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void e(final String... strArr) {
        try {
            this.f37551j.post(new Runnable() { // from class: com.mobile.auth.q.a.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String a10 = a.a(a.this, strArr);
                        PnsLoggerHandler d10 = a.d(a.this);
                        if (d10 != null) {
                            d10.error(a10);
                        }
                        i.c(a10);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
