package com.alimm.tanx.core.web.cache;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface WebViewRequestInterceptor {
    void clearCache();

    void enableForce(boolean z10);

    InputStream getCacheFile(String str);

    File getCachePath();

    void initAssetsData();

    WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest);

    WebResourceResponse interceptRequest(String str);

    void loadUrl(WebView webView, String str);

    void loadUrl(WebView webView, String str, Map<String, String> map);

    void loadUrl(String str, String str2);

    void loadUrl(String str, Map<String, String> map, String str2);
}
