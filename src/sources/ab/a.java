package ab;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    public static void a(WebSettings webSettings) {
        webSettings.setAllowContentAccess(false);
    }

    public static void b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    public static void c(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void d(WebSettings webSettings) {
        webSettings.setMixedContentMode(1);
    }

    public static void e(WebSettings webSettings) {
    }

    public static void f(WebView webView) {
        WebSettings settings = webView.getSettings();
        b(settings);
        g(webView);
        e(settings);
        c(settings);
        d(settings);
        a(settings);
    }

    public static void g(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }
}
