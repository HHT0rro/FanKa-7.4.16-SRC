package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f39293a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private String f39294b = null;

    /* renamed from: c, reason: collision with root package name */
    private Thread f39295c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f39296d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f39297e = null;

    private H5JavaScriptInterface() {
    }

    private static a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.f39298a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                aVar.f39299b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f39300c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                aVar.f39301d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
                aVar.f39302e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f39303f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    x.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f39305h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f39304g = substring;
                int indexOf2 = substring.indexOf(u.bD);
                if (indexOf2 > 0) {
                    aVar.f39304g = aVar.f39304g.substring(indexOf2 + 1);
                }
                aVar.f39306i = jSONObject.getString("file");
                if (aVar.f39303f == null) {
                    return null;
                }
                long j10 = jSONObject.getLong("lineNumber");
                aVar.f39307j = j10;
                if (j10 < 0) {
                    return null;
                }
                long j11 = jSONObject.getLong("columnNumber");
                aVar.f39308k = j11;
                if (j11 < 0) {
                    return null;
                }
                x.a("H5 crash information is following: ", new Object[0]);
                x.a("[projectRoot]: " + aVar.f39298a, new Object[0]);
                x.a("[context]: " + aVar.f39299b, new Object[0]);
                x.a("[url]: " + aVar.f39300c, new Object[0]);
                x.a("[userAgent]: " + aVar.f39301d, new Object[0]);
                x.a("[language]: " + aVar.f39302e, new Object[0]);
                x.a("[name]: " + aVar.f39303f, new Object[0]);
                x.a("[message]: " + aVar.f39304g, new Object[0]);
                x.a("[stacktrace]: \n" + aVar.f39305h, new Object[0]);
                x.a("[file]: " + aVar.f39306i, new Object[0]);
                x.a("[lineNumber]: " + aVar.f39307j, new Object[0]);
                x.a("[columnNumber]: " + aVar.f39308k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f39293a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f39293a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f39295c = currentThread;
        if (currentThread != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n");
            for (int i10 = 2; i10 < currentThread.getStackTrace().length; i10++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i10];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
            str = sb2.toString();
        }
        h5JavaScriptInterface.f39296d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb3.toString());
        h5JavaScriptInterface.f39297e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        x.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            x.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String a10 = z.a(str.getBytes());
        String str2 = this.f39294b;
        if (str2 != null && str2.equals(a10)) {
            x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f39294b = a10;
        x.d("Handling JS exception ...", new Object[0]);
        a a11 = a(str);
        if (a11 == null) {
            x.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a11.f39298a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a11.f39299b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a11.f39300c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a11.f39301d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a11.f39306i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j10 = a11.f39307j;
        if (j10 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j10));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f39297e);
        linkedHashMap.put("Java Stack", this.f39296d);
        InnerApi.postH5CrashAsync(this.f39295c, a11.f39303f, a11.f39304g, a11.f39305h, linkedHashMap);
    }
}
