package com.alibaba.security.realidentity.build;

import android.webkit.WebView;

/* compiled from: BridgeUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3167a = "yy://";

    /* renamed from: b, reason: collision with root package name */
    public static final String f3168b = "yy://return/";

    /* renamed from: c, reason: collision with root package name */
    public static final String f3169c = "yy://return/_fetchQueue/";

    /* renamed from: d, reason: collision with root package name */
    public static final String f3170d = "";

    /* renamed from: e, reason: collision with root package name */
    public static final String f3171e = "_";

    /* renamed from: f, reason: collision with root package name */
    public static final String f3172f = "/";

    /* renamed from: g, reason: collision with root package name */
    public static final String f3173g = "JAVA_CB_%s";

    /* renamed from: h, reason: collision with root package name */
    public static final String f3174h = "javascript:WebViewJavaScriptBridge._handleMessageFromNative('%s');";

    /* renamed from: i, reason: collision with root package name */
    public static final String f3175i = "javascript:WebViewJavaScriptBridge._fetchQueue();";

    /* renamed from: j, reason: collision with root package name */
    public static final String f3176j = "javascript:";

    public static String a(String str) {
        return str.replace("javascript:WebViewJavaScriptBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static String b(String str) {
        if (str.startsWith(f3169c)) {
            return str.replace(f3169c, "");
        }
        String[] split = str.replace(f3168b, "").split("/");
        if (split.length < 2) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 1; i10 < split.length; i10++) {
            sb2.append(split[i10]);
        }
        return sb2.toString();
    }

    public static String c(String str) {
        String[] split = str.replace(f3168b, "").split("/");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private static void a(WebView webView, String str) {
        webView.loadUrl(f3176j.concat(String.valueOf(("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);")));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r1.<init>(r4)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r5.<init>(r1)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
        L18:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            if (r2 == 0) goto L29
            java.lang.String r3 = "^\\s*\\/\\/.*"
            boolean r3 = r2.matches(r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            if (r3 != 0) goto L29
            r1.append(r2)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
        L29:
            if (r2 != 0) goto L18
            r5.close()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r4.close()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r4.close()     // Catch: java.io.IOException -> L38
        L38:
            return r5
        L39:
            r5 = move-exception
            goto L3f
        L3b:
            r5 = move-exception
            goto L4a
        L3d:
            r5 = move-exception
            r4 = r0
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L47
            r4.close()     // Catch: java.io.IOException -> L47
        L47:
            return r0
        L48:
            r5 = move-exception
            r0 = r4
        L4a:
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4f
        L4f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.bh.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static void b(WebView webView, String str) {
        webView.loadUrl(f3176j.concat(String.valueOf(a(webView.getContext(), str))));
    }
}
