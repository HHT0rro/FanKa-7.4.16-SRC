package com.tencent.bugly.idasc.crashreport;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.security.realidentity.build.bh;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.CrashModule;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.ac;
import com.tencent.bugly.idasc.proguard.ak;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.an;
import com.tencent.bugly.idasc.proguard.ap;
import com.tencent.bugly.idasc.proguard.aq;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.au;
import com.tencent.bugly.idasc.proguard.bc;
import com.tencent.bugly.idasc.proguard.p;
import com.tencent.bugly.idasc.proguard.r;
import com.tencent.bugly.idasc.proguard.s;
import com.tencent.bugly.idasc.proguard.w;
import com.tencent.bugly.idasc.proguard.x;
import com.tencent.bugly.idasc.proguard.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Context f39360a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c, reason: collision with root package name */
        public CrashHandleCallback f39362c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f39333a;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f39334b;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f39362c;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public synchronized void setCallBackType(int i10) {
            this.f39333a = i10;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z10) {
            this.f39334b = z10;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f39362c = crashHandleCallback;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static void closeBugly() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
            return;
        }
        if (f39360a == null) {
            return;
        }
        aq a10 = aq.a();
        if (a10 != null) {
            a10.b(f39360a);
        }
        closeCrashReport();
        s.a(f39360a);
        ak a11 = ak.a();
        if (a11 != null) {
            a11.b();
        }
    }

    public static void closeCrashReport() {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().c();
        } else {
            String str2 = al.f39569b;
        }
    }

    public static void closeNativeReport() {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().d();
        } else {
            String str2 = al.f39569b;
        }
    }

    public static void enableBugly(boolean z10) {
        p.f39906a = z10;
    }

    public static void enableObtainId(Context context, boolean z10) {
        setCollectPrivacyInfo(context, z10);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return new HashSet();
        }
        if (context != null) {
            return aa.a(context).w();
        }
        String str2 = al.f39569b;
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39360a).f39489s;
        }
        String str2 = al.f39569b;
        return "unknown";
    }

    public static String getAppID() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39360a).e();
        }
        String str2 = al.f39569b;
        return "unknown";
    }

    public static String getAppVer() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39360a).f39485o;
        }
        String str2 = al.f39569b;
        return "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return aa.a(context).f39478h;
        }
        al.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Context getContext() {
        return f39360a;
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static Proxy getHttpProxy() {
        return an.f39573a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39360a).K;
        }
        String str2 = al.f39569b;
        return null;
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return new HashMap();
        }
        if (context != null) {
            return aa.a(context).K;
        }
        al.d("Context should not be null.", new Object[0]);
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return "unknown";
        }
        if (context == null) {
            String str3 = al.f39569b;
            return "unknown";
        }
        if (ap.b(str)) {
            return null;
        }
        return aa.a(context).g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return -1;
        }
        if (context != null) {
            return aa.a(context).v();
        }
        String str2 = al.f39569b;
        return -1;
    }

    public static String getUserId() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39360a).f();
        }
        String str2 = al.f39569b;
        return "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return -1;
        }
        if (context != null) {
            return aa.a(context).z();
        }
        String str2 = al.f39569b;
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f39360a = context;
        p.a(CrashModule.getInstance());
        p.a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39360a = context;
        p.a(CrashModule.getInstance());
        p.a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z10) {
        initCrashReport(context, str, z10, null);
    }

    public static void initCrashReport(Context context, String str, boolean z10, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39360a = context;
        p.a(CrashModule.getInstance());
        p.a(context, str, z10, userStrategy);
    }

    public static boolean isLastSessionCrash() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
            return false;
        }
        at a10 = at.a();
        Boolean bool = a10.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str3 = aa.b().f39474d;
        List<y> a11 = w.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a11 == null || a11.size() <= 0) {
            a10.A = Boolean.FALSE;
            return false;
        }
        for (y yVar : a11) {
            if (str3.equals(yVar.f39986c)) {
                a10.A = Boolean.TRUE;
                arrayList.add(yVar);
            }
        }
        if (arrayList.size() > 0) {
            w.a().a(arrayList);
        }
        return true;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z10) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
            return;
        }
        if (th == null) {
            al.d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        final at a10 = at.a();
        a10.f39655w.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.3

            /* renamed from: b */
            public final /* synthetic */ Thread f39662b;

            /* renamed from: c */
            public final /* synthetic */ Throwable f39663c;

            /* renamed from: g */
            public final /* synthetic */ boolean f39667g;

            /* renamed from: a */
            public final /* synthetic */ boolean f39661a = false;

            /* renamed from: d */
            public final /* synthetic */ String f39664d = null;

            /* renamed from: e */
            public final /* synthetic */ byte[] f39665e = null;

            /* renamed from: f */
            public final /* synthetic */ boolean f39666f = true;

            public AnonymousClass3(final Thread thread2, final Throwable th2, final boolean z102) {
                r2 = thread2;
                r3 = th2;
                r4 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    al.c("post a throwable %b", Boolean.valueOf(this.f39661a));
                    at.this.f39652t.a(r2, r3, false, this.f39664d, this.f39665e, this.f39666f);
                    if (r4) {
                        al.a("clear user datas", new Object[0]);
                        aa.a(at.this.f39650c).u();
                    }
                } catch (Throwable th2) {
                    if (!al.b(th2)) {
                        th2.printStackTrace();
                    }
                    al.e("java catch error: %s", r3.toString());
                }
            }
        });
    }

    public static void postException(int i10, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i10, str, str2, str3, map);
    }

    public static void postException(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f39906a) {
            String str4 = al.f39569b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            au.a(thread, i10, str, str2, str3, map);
        } else {
            String str5 = al.f39569b;
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            String str3 = al.f39569b;
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String str4 = al.f39569b;
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        aa.a(context).b(replace, str2);
        al.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!p.f39906a) {
            String str3 = al.f39569b;
            return;
        }
        if (context == null) {
            String str4 = al.f39569b;
            return;
        }
        if (str == null) {
            al.d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            al.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            al.d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        aa a10 = aa.a(context);
        if (a10.w().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            aa.a(context).a(str, str2);
            al.c("replace KV %s %s", str, str2);
            return;
        }
        if (a10.v() >= 50) {
            al.d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            al.d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        aa.a(context).a(str, str2);
        al.b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return "unknown";
        }
        if (context == null) {
            String str3 = al.f39569b;
            return "unknown";
        }
        if (ap.b(str)) {
            return null;
        }
        al.b("[param] remove user data: %s", str);
        return aa.a(context).f(str);
    }

    public static void setAllThreadStackEnable(Context context, boolean z10, boolean z11) {
        aa a10 = aa.a(context);
        a10.Q = z10;
        a10.R = z11;
    }

    public static void setAppChannel(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        if (context == null) {
            String str3 = al.f39569b;
            return;
        }
        if (str == null) {
            String str4 = al.f39569b;
            return;
        }
        aa.a(context).f39489s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        if (context == null) {
            String str3 = al.f39569b;
            return;
        }
        if (str == null) {
            String str4 = al.f39569b;
            return;
        }
        aa.a(context).f39473c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        if (context == null) {
            String str3 = al.f39569b;
            return;
        }
        if (str == null) {
            String str4 = al.f39569b;
            return;
        }
        aa.a(context).f39485o = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        String str3 = al.f39569b;
        "Set Bugly DB name: ".concat(String.valueOf(str));
        x.f39980a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z10) {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else {
            if (context == null) {
                String str2 = al.f39569b;
                return;
            }
            String str3 = al.f39569b;
            "setCollectPrivacyInfo: ".concat(String.valueOf(z10));
            aa.a(context).f39484n = z10;
        }
    }

    public static void setContext(Context context) {
        f39360a = context;
    }

    public static void setCrashFilter(String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        String str3 = al.f39569b;
        "Set crash stack filter: ".concat(String.valueOf(str));
        at.f39648q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        String str3 = al.f39569b;
        "Set crash stack filter: ".concat(String.valueOf(str));
        at.f39649r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        if (context == null) {
            String str3 = al.f39569b;
            return;
        }
        String str4 = al.f39569b;
        if (str == null) {
            return;
        }
        "user set tombstone path: ".concat(str);
        NativeCrashHandler.setDumpFilePath(str);
    }

    public static void setHandleNativeCrashInJava(boolean z10) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        String str2 = al.f39569b;
        "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z10));
        NativeCrashHandler.setShouldHandleInJava(z10);
    }

    public static void setHttpProxy(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            an.f39573a = null;
        } else {
            an.f39573a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10));
        }
    }

    public static void setHttpProxy(InetAddress inetAddress, int i10) {
        if (inetAddress == null) {
            an.f39573a = null;
        } else {
            an.f39573a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i10));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z10) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z10) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return;
        }
        Object[] objArr = new Object[0];
        if (z10) {
            al.c("This is a development device.", objArr);
        } else {
            al.c("This is not a development device.", objArr);
        }
        aa.a(context).I = z10;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z10) {
        return setJavascriptMonitor(webView, z10, false);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z10, boolean z11) {
        if (webView == null) {
            String str = al.f39569b;
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a() { // from class: com.tencent.bugly.idasc.crashreport.CrashReport.1
            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final String a() {
                return WebView.this.getUrl();
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str2) {
                WebView.this.addJavascriptInterface(h5JavaScriptInterface, str2);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void a(String str2) {
                WebView.this.loadUrl(str2);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void b() {
                WebSettings settings = WebView.this.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final CharSequence c() {
                return WebView.this.getContentDescription();
            }
        }, z10, z11);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z10) {
        return setJavascriptMonitor(aVar, z10, false);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z10, boolean z11) {
        if (aVar == null) {
            String str = al.f39569b;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        al.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return false;
        }
        al.c("URL of webview is %s", aVar.a());
        al.a("Enable the javascript needed by webview monitor.", new Object[0]);
        aVar.b();
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(aVar);
        if (h5JavaScriptInterface != null) {
            al.a("Add a secure javascript interface to the webview.", new Object[0]);
            aVar.a(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z10) {
            al.a("Inject bugly.js(v%s) to the webview.", bc.b());
            String a10 = bc.a();
            if (a10 == null) {
                al.e("Failed to inject Bugly.js.", bc.b());
                return false;
            }
            aVar.a(bh.f3176j.concat(a10));
        }
        return true;
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.f39906a) {
            String str3 = al.f39569b;
            return;
        }
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        aa a10 = aa.a(context);
        if (str == null || str2 == null) {
            return;
        }
        synchronized (a10.T) {
            a10.K.put(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (ap.b(str) || !ap.d(str)) {
            String str2 = al.f39569b;
            return;
        }
        ac.a(str);
        StrategyBean.f39385a = str;
        StrategyBean.f39386b = str;
    }

    public static void setSessionIntervalMills(long j10) {
        if (p.f39906a) {
            s.a(j10);
        } else {
            String str = al.f39569b;
        }
    }

    public static void setUserId(Context context, String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
            return;
        }
        if (context == null) {
            String str3 = al.f39569b;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            al.d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            al.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(aa.a(context).f())) {
            return;
        }
        aa a10 = aa.a(context);
        synchronized (a10.V) {
            a10.f39482l = str;
        }
        al.b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            s.a();
        }
    }

    public static void setUserId(String str) {
        if (!p.f39906a) {
            String str2 = al.f39569b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f39360a, str);
        } else {
            String str3 = al.f39569b;
        }
    }

    public static void setUserSceneTag(Context context, int i10) {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        if (context == null) {
            String str2 = al.f39569b;
            return;
        }
        if (i10 <= 0) {
            al.d("setTag args tagId should > 0", new Object[0]);
        }
        aa a10 = aa.a(context);
        synchronized (a10.U) {
            int i11 = a10.f39493w;
            if (i11 != i10) {
                a10.f39493w = i10;
                al.a("user scene tag %d changed to tag %d", Integer.valueOf(i11), Integer.valueOf(a10.f39493w));
            }
        }
        al.b("[param] set user scene tag: %d", Integer.valueOf(i10));
    }

    public static void startCrashReport() {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().b();
        } else {
            String str2 = al.f39569b;
        }
    }

    public static void testANRCrash() {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
        } else {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i10;
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
            return;
        }
        aa b4 = aa.b();
        if (b4 != null && (i10 = b4.f39494x) != 24096) {
            b4.f39494x = 24096;
            al.a("server scene tag %d changed to tag %d", Integer.valueOf(i10), Integer.valueOf(b4.f39494x));
        }
        throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        if (!p.f39906a) {
            String str = al.f39569b;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39569b;
        } else {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z10, z11, z12);
        }
    }

    public static void uploadUserInfo() {
        if (!p.f39906a) {
            String str = al.f39569b;
            return;
        }
        r rVar = s.f39927b;
        if (rVar == null) {
            String str2 = al.f39569b;
        } else {
            rVar.b();
        }
    }
}
