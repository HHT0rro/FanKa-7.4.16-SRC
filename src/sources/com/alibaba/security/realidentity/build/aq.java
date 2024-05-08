package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.build.j;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AbsJavaScriptExecuter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class aq {
    public static final String A = "errorCode";
    public static final String B = "localModelPath";
    public static final String C = "auditStatus";
    public static final String D = "clientType";
    public static final String E = "appInfo";
    public static final String F = "deviceInfo";
    public static final String G = "FilterName";
    public static final String H = "imageList";
    public static final String I = "pageName";
    public static final String J = "eventId";
    public static final String K = "photoType";
    public static final String L = "ossUploadToken";
    public static final String M = "key";
    public static final String N = "secret";
    public static final String O = "token";
    public static final String P = "expired";
    public static final String Q = "endPoint";
    public static final String R = "bucket";
    public static final String S = "path";
    public static final String T = "gestureUrl";
    public static final String U = "callBackPhoto_";
    public static final String V = "urlPhoto";
    public static final String W = "photoSource";
    public static final String X = "totalBytesSent";
    public static final String Y = "totalBytesExpectedToSend";
    public static final String Z = "nameCancel";

    /* renamed from: a, reason: collision with root package name */
    public static final String f3100a = "AbsJavaScriptExecuter";

    /* renamed from: aa, reason: collision with root package name */
    public static final String f3101aa = "skinInfo";

    /* renamed from: ab, reason: collision with root package name */
    public static final String f3102ab = "sensorInfo";

    /* renamed from: ac, reason: collision with root package name */
    public static final String f3103ac = "exitInfo";

    /* renamed from: ad, reason: collision with root package name */
    public static final String f3104ad = "INPUT_PARAM_ERROR";

    /* renamed from: ae, reason: collision with root package name */
    public static final String f3105ae = "PARAMS_MISSING";
    public static final String af = "WirelessH5";
    public static final String ag = "NO_PHOTO";
    public static final String ah = "success";
    public static final String ai = "NO_PERMISSION";
    public static final String aj = "NO_SDK_INIT";
    public static ThreadPoolExecutor am = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f3106b = "NO_INFO";

    /* renamed from: c, reason: collision with root package name */
    public static final String f3107c = "UNKNOWN_ERROR";

    /* renamed from: d, reason: collision with root package name */
    public static final String f3108d = "verifyToken";

    /* renamed from: e, reason: collision with root package name */
    public static final String f3109e = "navTitle";

    /* renamed from: f, reason: collision with root package name */
    public static final String f3110f = "clientInfo";

    /* renamed from: g, reason: collision with root package name */
    public static final String f3111g = "errorMsg";

    /* renamed from: h, reason: collision with root package name */
    public static final String f3112h = "message";

    /* renamed from: i, reason: collision with root package name */
    public static final String f3113i = "url";

    /* renamed from: j, reason: collision with root package name */
    public static final String f3114j = "method";

    /* renamed from: k, reason: collision with root package name */
    public static final String f3115k = "params";

    /* renamed from: l, reason: collision with root package name */
    public static final String f3116l = "response";

    /* renamed from: m, reason: collision with root package name */
    public static final String f3117m = "status";

    /* renamed from: n, reason: collision with root package name */
    public static final String f3118n = "code";

    /* renamed from: o, reason: collision with root package name */
    public static final String f3119o = "photoId";

    /* renamed from: p, reason: collision with root package name */
    public static final String f3120p = "wuaToken";

    /* renamed from: q, reason: collision with root package name */
    public static final String f3121q = "rpSdkName";

    /* renamed from: r, reason: collision with root package name */
    public static final String f3122r = "rpSdkVersion";

    /* renamed from: s, reason: collision with root package name */
    public static final String f3123s = "livenessSdkName";

    /* renamed from: t, reason: collision with root package name */
    public static final String f3124t = "livenessSdkVersion";

    /* renamed from: u, reason: collision with root package name */
    public static final String f3125u = "sdkNoUI";

    /* renamed from: v, reason: collision with root package name */
    public static final String f3126v = "takePhotoType";

    /* renamed from: w, reason: collision with root package name */
    public static final String f3127w = "gestureUrlArray";

    /* renamed from: x, reason: collision with root package name */
    public static final String f3128x = "useAlbum";

    /* renamed from: y, reason: collision with root package name */
    public static final String f3129y = "urlArray";

    /* renamed from: z, reason: collision with root package name */
    public static final String f3130z = "typeArray";
    public ay ak;
    public Context al;
    public a an = new a(this);
    private String ao;
    private long ap;

    /* compiled from: AbsJavaScriptExecuter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final aq f3131a;

        public a(aq aqVar) {
            super(Looper.getMainLooper());
            this.f3131a = aqVar;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            this.f3131a.b(message);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.aq.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-js-executor");
            }
        });
        am = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void b(String str) {
        j.a.f3944a.a(TrackLog.createSdkExceptionLog(str, "", ""));
    }

    public abstract String a();

    public final boolean a(Context context, String str, ay ayVar) {
        this.ak = ayVar;
        this.ao = str;
        this.ap = System.currentTimeMillis();
        this.al = context;
        return a(str, ayVar);
    }

    public abstract boolean a(String str, ay ayVar);

    public void b(Message message) {
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public final void a(bf bfVar, boolean z10) {
        if (c()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer("sdk");
            trackLog.setService("webview");
            trackLog.setMethod(a());
            trackLog.setParams(this.ao);
            trackLog.setMsg("");
            trackLog.setRt(System.currentTimeMillis() - this.ap);
            if (bfVar != null) {
                trackLog.setResult(bfVar.a());
            } else {
                trackLog.setResult("result is null");
            }
            trackLog.setCode(z10 ? 0 : -1);
            j.a.f3944a.a(trackLog);
        }
    }

    public final void a(String str) {
        if (c()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer("sdk");
            trackLog.setService("webview");
            trackLog.setMethod(a());
            trackLog.setParams(this.ao);
            trackLog.setMsg("");
            trackLog.setRt(System.currentTimeMillis() - this.ap);
            trackLog.setResult(str);
            trackLog.setCode(0);
            j.a.f3944a.a(trackLog);
        }
    }

    public final void a(Message message) {
        a aVar = this.an;
        if (aVar != null) {
            aVar.sendMessage(message);
        }
    }

    public static void a(String str, String str2) {
        j.a.f3944a.a(TrackLog.createSdkExceptionLog(str, str2, ""));
    }

    public static void a(String str, Exception exc) {
        j.a.f3944a.a(TrackLog.createSdkExceptionLog(str, CommonUtils.getStackTrace(exc), ""));
    }

    public static bf a(ay ayVar) {
        bf bfVar = new bf();
        bfVar.a("errorMsg", f3107c);
        ayVar.a(bfVar);
        return bfVar;
    }

    public static bf a(ay ayVar, String str) {
        bf bfVar = new bf();
        bfVar.a("errorMsg", str);
        ayVar.a(bfVar);
        return bfVar;
    }

    public static void a(TrackLog trackLog) {
        j.a.f3944a.a(trackLog);
    }
}
