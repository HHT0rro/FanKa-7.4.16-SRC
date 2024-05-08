package com.tencent.bugly.idasc.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.idasc.crashreport.CrashReport;
import com.tencent.bugly.idasc.crashreport.inner.InnerApi;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.ap;
import com.tencent.bugly.idasc.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f39444a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private String f39445b = null;

    /* renamed from: c, reason: collision with root package name */
    private Thread f39446c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f39447d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f39448e = null;

    private H5JavaScriptInterface() {
    }

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string2 = jSONObject.getString("projectRoot");
                bbVar.f39725a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                bbVar.f39726b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                bbVar.f39727c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                bbVar.f39728d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
                bbVar.f39729e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                bbVar.f39730f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f39732h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                bbVar.f39731g = substring;
                int indexOf2 = substring.indexOf(u.bD);
                if (indexOf2 > 0) {
                    bbVar.f39731g = bbVar.f39731g.substring(indexOf2 + 1);
                }
                bbVar.f39733i = jSONObject.getString("file");
                if (bbVar.f39730f == null) {
                    return null;
                }
                long j10 = jSONObject.getLong("lineNumber");
                bbVar.f39734j = j10;
                if (j10 < 0) {
                    return null;
                }
                long j11 = jSONObject.getLong("columnNumber");
                bbVar.f39735k = j11;
                if (j11 < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.f39725a, new Object[0]);
                al.a("[context]: " + bbVar.f39726b, new Object[0]);
                al.a("[url]: " + bbVar.f39727c, new Object[0]);
                al.a("[userAgent]: " + bbVar.f39728d, new Object[0]);
                al.a("[language]: " + bbVar.f39729e, new Object[0]);
                al.a("[name]: " + bbVar.f39730f, new Object[0]);
                al.a("[message]: " + bbVar.f39731g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f39732h, new Object[0]);
                al.a("[file]: " + bbVar.f39733i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f39734j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f39735k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String str = null;
        if (aVar == null || f39444a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f39444a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f39446c = currentThread;
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
        h5JavaScriptInterface.f39447d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) aVar.c());
        hashMap.put("[WebView] ContentDescription", sb3.toString());
        h5JavaScriptInterface.f39448e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c4 = ap.c(str.getBytes());
        String str2 = this.f39445b;
        if (str2 != null && str2.equals(c4)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f39445b = c4;
        al.d("Handling JS exception ...", new Object[0]);
        bb a10 = a(str);
        if (a10 == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a10.f39725a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a10.f39726b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a10.f39727c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a10.f39728d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a10.f39733i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j10 = a10.f39734j;
        if (j10 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j10));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f39448e);
        linkedHashMap.put("Java Stack", this.f39447d);
        InnerApi.postH5CrashAsync(this.f39446c, a10.f39730f, a10.f39731g, a10.f39732h, linkedHashMap);
    }
}
