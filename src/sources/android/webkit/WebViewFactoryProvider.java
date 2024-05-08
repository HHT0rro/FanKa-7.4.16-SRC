package android.webkit;

import android.annotation.SystemApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WebViewFactoryProvider {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Statics {
        void clearClientCertPreferences(Runnable runnable);

        void enableSlowWholeDocumentDraw();

        String findAddress(String str);

        void freeMemoryForTests();

        String getDefaultUserAgent(Context context);

        Uri getSafeBrowsingPrivacyPolicyUrl();

        void initSafeBrowsing(Context context, ValueCallback<Boolean> valueCallback);

        Uri[] parseFileChooserResult(int i10, Intent intent);

        void setSafeBrowsingWhitelist(List<String> list, ValueCallback<Boolean> valueCallback);

        void setWebContentsDebuggingEnabled(boolean z10);
    }

    WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess);

    CookieManager getCookieManager();

    GeolocationPermissions getGeolocationPermissions();

    ServiceWorkerController getServiceWorkerController();

    Statics getStatics();

    TokenBindingService getTokenBindingService();

    TracingController getTracingController();

    WebIconDatabase getWebIconDatabase();

    WebStorage getWebStorage();

    ClassLoader getWebViewClassLoader();

    WebViewDatabase getWebViewDatabase(Context context);

    default PacProcessor getPacProcessor() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default PacProcessor createPacProcessor() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
