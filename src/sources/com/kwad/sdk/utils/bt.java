package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bt {
    public static void a(WebView webView, String str, String str2) {
        a(webView, com.alibaba.security.realidentity.build.bh.f3176j + str + "(" + JSONObject.quote(str2) + ")", (ValueCallback<String>) null);
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private static void a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        final ValueCallback valueCallback2 = null;
        runOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.bt.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    WebView.this.evaluateJavascript(str, valueCallback2);
                } catch (Exception unused) {
                }
            }
        });
    }
}
