package com.inno.innosdk.pb;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.inno.innosdk.a.c;
import com.inno.innosdk.b.b;
import com.inno.innosdk.bean.BaseDevice;
import com.inno.innosdk.utils.AppInfomation;
import com.inno.innosdk.utils.NativeUtils;
import com.inno.innosdk.utils.p;
import com.inno.innosdk.utils.q;
import com.inno.innosdk.utils.u.a;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class InnoMain {
    public static final String INNO_KEY_ACCOUNT = "account";
    public static final String INNO_KEY_CID = "cid";
    public static final String INNO_KEY_CONTROLLER = "controller";
    public static final String INNO_KEY_OAID = "oaid";
    public static final String INNO_KEY_PRODUCT = "product";
    public static long ct = System.currentTimeMillis();
    public static IsnewCallback isnewcallback;
    public static Js2native js2native;
    public static SubChannelPaste staticSubChannelPaste;
    public static SubChannelReturn statisSsubChannelReturn;
    public static SubChannelPaste subChannelPaste;
    public static SubChannelReturn subChannelReturn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface CallBack {
        void getOpenid(String str, int i10, String str2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IsnewCallback {
        void getisnew(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface SubChannelPaste {
        String getPaste(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface SubChannelReturn {
        void getResult(String str);
    }

    public static void changeValueMap(Map<String, Object> map) {
        c.a(map);
    }

    public static String checkInfo(Context context) {
        String a10;
        if (context == null) {
            return "";
        }
        try {
            a10 = b.a(context);
        } catch (Throwable th) {
            a.a(th);
        }
        if (com.inno.innosdk.utils.t.a.b(a10)) {
            return a10;
        }
        if (c.f35474b) {
            b.a(c.m(), "checkinfo");
        }
        return "";
    }

    public static void cleanJSReturn() {
        subChannelReturn = null;
    }

    @Deprecated
    public static String getDeviceAc() {
        return "";
    }

    public static String getInnoAid(Context context) {
        return c.a(context);
    }

    public static List<PackageInfo> getInnoApps(Context context) {
        return c.b(context);
    }

    public static String getInnoImei(Context context) {
        return c.c(context);
    }

    public static String getInnoImsi(Context context) {
        return c.d(context);
    }

    public static String getInnoMac(Context context) {
        return c.e(context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(7:12|13|(1:15)|16|17|18|(2:20|21)(6:22|(1:24)|4|5|6|7))|3|4|5|6|7|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
    
        com.inno.innosdk.utils.u.a.a((java.lang.Throwable) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002f, code lost:
    
        if (com.inno.innosdk.utils.t.a.b(r1) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.inno.innosdk.pb.InnoValue getInnoValue(android.content.Context r4) {
        /*
            java.lang.String r0 = ""
            if (r4 != 0) goto L5
            goto L31
        L5:
            android.content.Context r1 = com.inno.innosdk.a.c.k()     // Catch: java.lang.Throwable -> L38
            if (r1 != 0) goto Ld
            com.inno.innosdk.a.c.f35473a = r4     // Catch: java.lang.Throwable -> L38
        Ld:
            java.lang.String r1 = com.inno.innosdk.b.b.a(r4)     // Catch: java.lang.Throwable -> L38
            boolean r2 = com.inno.innosdk.utils.t.a.b(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L1d
            com.inno.innosdk.pb.InnoValue r2 = new com.inno.innosdk.pb.InnoValue     // Catch: java.lang.Throwable -> L33
            r2.<init>(r1, r0)     // Catch: java.lang.Throwable -> L33
            return r2
        L1d:
            java.lang.String r1 = com.inno.innosdk.utils.AppInfomation.v(r4)     // Catch: java.lang.Throwable -> L33
            boolean r2 = com.inno.innosdk.utils.t.a.b(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L3e
            java.lang.String r1 = com.inno.innosdk.utils.AppInfomation.s(r4)     // Catch: java.lang.Throwable -> L33
            boolean r2 = com.inno.innosdk.utils.t.a.b(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L3e
        L31:
            r1 = r0
            goto L3e
        L33:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
            goto L3a
        L38:
            r1 = move-exception
            r2 = r0
        L3a:
            com.inno.innosdk.utils.u.a.a(r1)
            r1 = r2
        L3e:
            java.lang.String r0 = com.inno.innosdk.a.c.f(r4)     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r4 = move-exception
            com.inno.innosdk.utils.u.a.a(r4)
        L47:
            com.inno.innosdk.pb.InnoValue r4 = new com.inno.innosdk.pb.InnoValue
            r4.<init>(r1, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.pb.InnoMain.getInnoValue(android.content.Context):com.inno.innosdk.pb.InnoValue");
    }

    public static int getIsnew(IsnewCallback isnewCallback) {
        isnewcallback = isnewCallback;
        return b.f35514m;
    }

    public static Js2native getJs2native() {
        try {
            if (js2native == null) {
                js2native = new Js2native();
            }
            return js2native;
        } catch (Throwable th) {
            a.a(th);
            return null;
        }
    }

    @Deprecated
    public static String getLocalid(Context context) {
        if (context == null) {
            return "-2";
        }
        try {
            if (c.k() == null) {
                c.f35473a = context;
            }
            return AppInfomation.v(context);
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    @Deprecated
    public static String getOaid(Context context) {
        return "";
    }

    public static Option getOption() {
        return c.p();
    }

    @Deprecated
    public static String getRid(String str) {
        try {
            return "A" + com.inno.innosdk.utils.b.a().b(str);
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    public static Map<String, Object> getValueMap() {
        return c.t();
    }

    public static String getVersion() {
        return BaseDevice.mycv;
    }

    @Deprecated
    public static String getluid(Context context) {
        if (context == null) {
            return "-2";
        }
        try {
            String a10 = q.a(context, "ACluid", "");
            if (!TextUtils.isEmpty(a10) && a10.length() >= 10) {
                return a10;
            }
            String a11 = NativeUtils.a(context);
            q.c(context, "ACluid", a11);
            return a11;
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    public static void initParams(Map<String, Object> map) {
        c.b(map);
    }

    @Deprecated
    public static String loadInfo(Context context) {
        if (context == null) {
            return "-2";
        }
        try {
            if (c.k() == null) {
                c.f35473a = context;
            }
            String checkInfo = checkInfo(context);
            if (com.inno.innosdk.utils.t.a.b(checkInfo)) {
                return checkInfo;
            }
            String v2 = AppInfomation.v(context);
            return com.inno.innosdk.utils.t.a.b(v2) ? v2 : AppInfomation.s(context);
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    @Deprecated
    public static String loadTuid(Context context) {
        if (context == null) {
            return "-2";
        }
        try {
            if (c.k() == null) {
                c.f35473a = context;
            }
            String d10 = b.d();
            if (!com.inno.innosdk.utils.t.a.b(d10)) {
                d10 = AppInfomation.v(context);
            }
            if (!com.inno.innosdk.utils.t.a.b(d10)) {
                d10 = AppInfomation.s(context);
            }
            return !com.inno.innosdk.utils.t.a.b(d10) ? "error" : p.c(d10);
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    public static void reportJSSubChannelInfo() {
        c.b((String) null);
    }

    public static void setExperimentOn(boolean z10) {
        c.a(z10);
    }

    public static void setJSPasteBoardCallback(SubChannelPaste subChannelPaste2) {
        subChannelPaste = subChannelPaste2;
        staticSubChannelPaste = subChannelPaste2;
    }

    public static void setJSReturnCallback(SubChannelReturn subChannelReturn2) {
        subChannelReturn = subChannelReturn2;
        statisSsubChannelReturn = subChannelReturn2;
    }

    public static void setValueMap(String str, Object obj) {
        c.a(str, obj);
    }

    @Deprecated
    public static void start() {
        c.w();
    }

    public static void startInno(Context context, String str, CallBack callBack) {
        startInno(context, str, null, callBack);
    }

    @JavascriptInterface
    public static void startJsSdk(WebView webView) {
        try {
            if (js2native == null) {
                js2native = new Js2native();
            }
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            webView.getSettings().setSavePassword(false);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.getSettings().setJavaScriptEnabled(false);
            webView.addJavascriptInterface(js2native, "js2native");
        } catch (Throwable th) {
            a.a(th);
        }
    }

    @Deprecated
    public static void stop() {
        c.x();
    }

    @Deprecated
    public static void upTouch() {
        c.y();
    }

    public static void uploadMotionEvents(List<MotionEvent> list, String str) {
        c.a(list, str);
    }

    public static void reportJSSubChannelInfo(String str) {
        c.b(str);
    }

    public static void startInno(Context context, String str, Option option) {
        c.a(context, str, option, null, null);
    }

    public static void startInno(Context context, String str, Option option, CallBack callBack) {
        c.a(context, str, option, callBack, null);
    }

    public static void startInno(Context context, String str, Option option, CallBack callBack, InnoCustomController innoCustomController) {
        c.a(context, str, option, callBack, innoCustomController);
    }

    public static void startInno(Context context, String str, String str2, String str3, String str4, Option option, CallBack callBack) {
        c.a(context, str, str2, str3, str4, option, callBack, null);
    }
}
