package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.alibaba.security.realidentity.build.cc;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.internal.by;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aEo = new ConcurrentHashMap();
    private static final Map<String, String> aEp = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z10) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e2);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z10, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.aEw)) {
            b(z10, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.eX(bVar2.aEs)) {
            b(z10, "mimetype为: " + bVar2.aEs + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVar2.aEs + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream gr = q.gr(bVar2.aEw);
        if (gr == null) {
            b(z10, "getResource [" + str + "] inputStream is null");
            StringBuilder sb2 = new StringBuilder("inputStream is null,本地加载路径：");
            sb2.append(bVar2.aEw);
            aVar.msg = sb2.toString();
            return null;
        }
        return a(gr, bVar2);
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ad(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aEp.put(str, str2);
    }

    private static void b(boolean z10, String str) {
        if (z10) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b eP(String str) {
        return aEo.get(String.valueOf(str.hashCode()));
    }

    private static String eQ(String str) {
        return aEp.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aEs;
        HashMap hashMap = new HashMap();
        hashMap.put(cc.B, bVar.aEv.aEq);
        hashMap.put("Access-Control-Allow-Credentials", "true");
        hashMap.put("Timing-Allow-Origin", bVar.aEv.aEr);
        hashMap.put(e.f4632d, str);
        hashMap.put("Date", bVar.aEv.aEt);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aEs, "", bVar.status, by.f9988k, hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String eQ = eQ(bVar.aHX);
            com.kwad.sdk.core.webview.b.a.b eP = !TextUtils.isEmpty(eQ) ? eP(ac(eQ, str)) : null;
            if (eP != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return eP;
            }
            String I = com.kwad.sdk.core.webview.b.c.a.I(context, bVar.aHY);
            if (I == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(I);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + I;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String b4 = h.b(inputStreamReader);
                if (TextUtils.isEmpty(b4)) {
                    aVar.msg = "获取配置文件失败 mainfest文件不存在";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b4);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    bVar2.aEx = host;
                    bVar2.aEw = com.kwad.sdk.core.webview.b.c.a.H(context, bVar.aHY) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.aEs)) {
                        bVar2.aEs = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aEw);
                    }
                    a(next, bVar2);
                    eQ = host;
                }
                ad(bVar.aHX, eQ);
                com.kwad.sdk.core.webview.b.a.b eP2 = eP(ac(eQ, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return eP2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aEo.put(String.valueOf(str.hashCode()), bVar);
    }
}
