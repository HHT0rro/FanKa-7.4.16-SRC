package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cm implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static String f10057a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10058b = "remote";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10059c = "proxy";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10060d = "third-mtj";

    /* renamed from: e, reason: collision with root package name */
    private static final String f10061e = "third-cpu";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10062f = "third-cpu-cyber";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10063g = "third-novel";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10064h = "third-aigc";

    /* renamed from: i, reason: collision with root package name */
    private static final String f10065i = "third-aigc-virtual";

    /* renamed from: j, reason: collision with root package name */
    private static final String f10066j = "third-aigc-speech";

    /* renamed from: k, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f10067k = null;

    /* renamed from: l, reason: collision with root package name */
    private static volatile cm f10068l = null;

    /* renamed from: o, reason: collision with root package name */
    private static final String f10069o = "key_crash_source";

    /* renamed from: p, reason: collision with root package name */
    private static final String f10070p = "key_crash_trace";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10071q = "key_crash_ad";

    /* renamed from: m, reason: collision with root package name */
    private Context f10072m;

    /* renamed from: n, reason: collision with root package name */
    private a f10073n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(String str);
    }

    private cm(Context context) {
        this.f10072m = context.getApplicationContext();
        f10067k = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c4;
        ArrayList arrayList = new ArrayList();
        try {
            aa a10 = aa.a();
            if (a10 != null && (c4 = a10.c()) != null) {
                Object remoteParam = c4.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f10072m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f10 = f();
        f10.clear();
        f10.apply();
    }

    public void c() {
        this.f10073n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a10 = a(th);
            if (a10 != null) {
                a(a10, Log.getStackTraceString(th));
                a aVar = this.f10073n;
                if (aVar != null) {
                    aVar.a(a10);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f10067k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bs.a().c(e2);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cm) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static cm a(Context context) {
        if (f10068l == null) {
            synchronized (cm.class) {
                if (f10068l == null) {
                    f10068l = new cm(context);
                }
            }
        }
        return f10068l;
    }

    public void a() {
        bb.a().a((i) new cn(this));
    }

    public void a(a aVar) {
        this.f10073n = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d10 = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (!className.startsWith(x.au) && !className.startsWith(x.av) && !className.startsWith(x.aw)) {
                    if (className.startsWith(x.ax) || className.startsWith(x.ay) || className.startsWith(x.az)) {
                        return f10059c;
                    }
                    if (className.startsWith(x.aA)) {
                        return f10060d;
                    }
                    if (className.startsWith(x.aB)) {
                        return f10061e;
                    }
                    if (className.startsWith(x.aC) || className.startsWith(x.aD)) {
                        return f10062f;
                    }
                    if (className.startsWith(x.aL)) {
                        return f10066j;
                    }
                    if (className.startsWith(x.aH) || className.startsWith(x.aI) || className.startsWith(x.aJ) || className.startsWith(x.aK)) {
                        return f10065i;
                    }
                    if (className.startsWith(x.aG)) {
                        return f10064h;
                    }
                    if (!className.startsWith(x.aE) && !className.startsWith(x.aF)) {
                        if (a(className, d10)) {
                        }
                    } else if (cl.f10055g.booleanValue()) {
                        return f10063g;
                    }
                }
                return f10058b;
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.startsWith(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f10 = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        f10.putString(f10069o, str);
        f10.putString(f10070p, str3 + str2);
        f10.putString(f10071q, f10057a);
        f10.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}
