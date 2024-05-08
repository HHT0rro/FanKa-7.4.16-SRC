package com.tencent.bugly.crashreport;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.security.realidentity.build.bh;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Context f39034a;

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c, reason: collision with root package name */
        private CrashHandleCallback f39036c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f39002a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f39003b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i10) {
            this.f39002a = i10;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z10) {
            this.f39003b = z10;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f39036c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f39036c;
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z10);
    }

    public static void closeBugly() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return;
        }
        if (f39034a == null) {
            return;
        }
        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
        if (buglyBroadcastReceiver != null) {
            buglyBroadcastReceiver.unregister(f39034a);
        }
        closeCrashReport();
        com.tencent.bugly.crashreport.biz.b.a(f39034a);
        w a10 = w.a();
        if (a10 != null) {
            a10.b();
        }
    }

    public static void closeCrashReport() {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
        } else {
            c.a().d();
        }
    }

    public static void closeNativeReport() {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
        } else {
            c.a().g();
        }
    }

    public static void enableBugly(boolean z10) {
        b.f39029a = z10;
    }

    public static void enableObtainId(Context context, boolean z10) {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else {
            if (context == null) {
                String str2 = x.f40235a;
                return;
            }
            String str3 = x.f40235a;
            new StringBuilder("Enable identification obtaining? ").append(z10);
            com.tencent.bugly.crashreport.common.info.a.a(context).b(z10);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return new HashSet();
        }
        if (context == null) {
            String str2 = x.f40235a;
            return new HashSet();
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).x();
    }

    public static String getAppChannel() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(f39034a).f39104l;
    }

    public static String getAppID() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(f39034a).f();
    }

    public static String getAppVer() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(f39034a).f39102j;
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            x.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).c();
    }

    public static String getDeviceID(Context context) {
        return com.tencent.bugly.crashreport.common.info.a.a(context).h();
    }

    public static Proxy getHttpProxy() {
        return com.tencent.bugly.proguard.a.b();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return new HashMap();
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(f39034a).B;
    }

    public static String getUserData(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return "unknown";
        }
        if (context == null) {
            String str3 = x.f40235a;
            return "unknown";
        }
        if (z.a(str)) {
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).h(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return -1;
        }
        if (context == null) {
            String str2 = x.f40235a;
            return -1;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).w();
    }

    public static String getUserId() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(f39034a).g();
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return -1;
        }
        if (context == null) {
            String str2 = x.f40235a;
            return -1;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).A();
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f39034a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return false;
        }
        return c.a().b();
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postException(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        if (!b.f39029a) {
            String str4 = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str5 = x.f40235a;
        } else {
            d.a(thread, i10, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || z.a(str) || z.a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            String str3 = x.f40235a;
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String str4 = x.f40235a;
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).c(replace, str2);
        x.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.f39029a) {
            String str3 = x.f40235a;
            return;
        }
        if (context == null) {
            String str4 = x.f40235a;
            return;
        }
        if (str == null) {
            x.d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            x.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            x.d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a a10 = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a10.x().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
            x.c("replace KV %s %s", str, str2);
            return;
        }
        if (a10.w() >= 50) {
            x.d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            x.d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
        x.b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return "unknown";
        }
        if (context == null) {
            String str3 = x.f40235a;
            return "unknown";
        }
        if (z.a(str)) {
            return null;
        }
        x.b("[param] remove user data: %s", str);
        return com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        if (context == null) {
            String str3 = x.f40235a;
            return;
        }
        if (str == null) {
            String str4 = x.f40235a;
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f39104l = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        if (context == null) {
            String str3 = x.f40235a;
            return;
        }
        if (str == null) {
            String str4 = x.f40235a;
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f39095c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        if (context == null) {
            String str3 = x.f40235a;
            return;
        }
        if (str == null) {
            String str4 = x.f40235a;
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f39102j = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        String str3 = x.f40235a;
        new StringBuilder("Set Bugly DB name: ").append(str);
        q.f40185a = str;
    }

    public static void setContext(Context context) {
        f39034a = context;
    }

    public static void setCrashFilter(String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        String str3 = x.f40235a;
        new StringBuilder("Set crash stack filter: ").append(str);
        c.f39250n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        String str3 = x.f40235a;
        new StringBuilder("Set crash stack filter: ").append(str);
        c.f39251o = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).c(str);
        }
    }

    public static void setDeviceModel(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).d(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z10) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        String str2 = x.f40235a;
        new StringBuilder("Should handle native crash in Java profile after handled in native profile: ").append(z10);
        NativeCrashHandler.setShouldHandleInJava(z10);
    }

    public static void setHttpProxy(String str, int i10) {
        com.tencent.bugly.proguard.a.a(str, i10);
    }

    public static void setIsAppForeground(Context context, boolean z10) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z10) {
            x.c("App is in foreground.", new Object[0]);
        } else {
            x.c("App is in background.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(z10);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z10) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z10) {
            x.c("This is a development device.", new Object[0]);
        } else {
            x.c("This is not a development device.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f39118z = z10;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z10) {
        return setJavascriptMonitor(webView, z10, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.f39029a) {
            String str3 = x.f40235a;
        } else {
            if (context == null || z.a(str) || z.a(str2)) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (!z.a(str) && z.c(str)) {
            com.tencent.bugly.crashreport.common.strategy.a.a(str);
            StrategyBean.f39122a = str;
            StrategyBean.f39123b = str;
            return;
        }
        String str2 = x.f40235a;
    }

    public static void setSessionIntervalMills(long j10) {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else {
            com.tencent.bugly.crashreport.biz.b.a(j10);
        }
    }

    public static void setUserId(String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str3 = x.f40235a;
        } else {
            setUserId(f39034a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i10) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        if (context == null) {
            String str2 = x.f40235a;
            return;
        }
        if (i10 <= 0) {
            x.d("setTag args tagId should > 0", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(i10);
        x.b("[param] set user scene tag: %d", Integer.valueOf(i10));
    }

    public static void startCrashReport() {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
        } else {
            c.a().c();
        }
    }

    public static void testANRCrash() {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
        } else {
            x.a("start to create a anr crash for test!", new Object[0]);
            c.a().l();
        }
    }

    public static void testJavaCrash() {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                String str2 = x.f40235a;
                return;
            }
            com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b4 != null) {
                b4.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void uploadUserInfo() {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        com.tencent.bugly.crashreport.biz.a aVar = com.tencent.bugly.crashreport.biz.b.f39069a;
        if (aVar == null) {
            String str2 = x.f40235a;
        } else {
            aVar.b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i10) {
        com.tencent.bugly.proguard.a.a(inetAddress, i10);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z10, boolean z11) {
        if (webView == null) {
            String str = x.f40235a;
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str2) {
                WebView.this.addJavascriptInterface(h5JavaScriptInterface, str2);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final CharSequence getContentDescription() {
                return WebView.this.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final String getUrl() {
                return WebView.this.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void loadUrl(String str2) {
                WebView.this.loadUrl(str2);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void setJavaScriptEnabled(boolean z12) {
                WebSettings settings = WebView.this.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }
        }, z10, z11);
    }

    public static void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        if (!b.f39029a) {
            String str = x.f40235a;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
        } else {
            x.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z10, z11, z12);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z10) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = x.f40235a;
            return;
        }
        if (th == null) {
            x.d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        c.a().a(thread, th, false, (String) null, (byte[]) null, z10);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39034a = context;
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static void postException(int i10, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i10, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return;
        }
        if (context == null) {
            String str3 = x.f40235a;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            x.d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            x.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(context).g())) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
        x.b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.crashreport.biz.b.a();
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.f39029a) {
            String str = x.f40235a;
            return new HashMap();
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).B;
    }

    public static void initCrashReport(Context context, String str, boolean z10) {
        if (context != null) {
            f39034a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z10, null);
        }
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z10) {
        return setJavascriptMonitor(webViewInterface, z10, false);
    }

    public static void initCrashReport(Context context, String str, boolean z10, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39034a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z10, userStrategy);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z10, boolean z11) {
        if (webViewInterface == null) {
            String str = x.f40235a;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        x.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!b.f39029a) {
            String str2 = x.f40235a;
            return false;
        }
        x.c("URL of webview is %s", webViewInterface.getUrl());
        x.a("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            x.a("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z10) {
            x.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
            String a10 = com.tencent.bugly.crashreport.crash.h5.b.a();
            if (a10 == null) {
                x.e("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl(bh.f3176j + a10);
        }
        return true;
    }
}
