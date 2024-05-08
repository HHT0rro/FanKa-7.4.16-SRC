package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.LogUtils;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PreloadWebView {
    public static final int CACHED_WEB_VIEW_MAX_NUM = 3;
    public static final Stack<WeakReference<WebView>> mCachedWebViewStack = new Stack<>();
    public Handler mainHandler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Holder {
        public static final PreloadWebView INSTANCE = new PreloadWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WeakReference<WebView> createWebView() {
        WebView webView = new WebView(new MutableContextWrapper(TanxCoreSdk.getApplication()));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        return new WeakReference<>(webView);
    }

    public static String getHtml() {
        return "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/article/css/android.css\">\n</head>\n<body class=\"font_m\"><header></header><article></article><footer></footer><script type=\"text/javascript\" src=\"file:///android_asset/article/js/lib.js\"></script><script type=\"text/javascript\" src=\"file:///android_asset/article/js/android.js\" ></script>\n</body>\n</html>\n";
    }

    public static PreloadWebView getInstance() {
        return Holder.INSTANCE;
    }

    private void initSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        CookieManager.getInstance();
        settings.setMixedContentMode(2);
    }

    public static void loadBaseHtml(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushCachedWebViewStack() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.2
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                LogUtils.d("PreloadWebView", "-->queueIdle");
                PreloadWebView.mCachedWebViewStack.push(PreloadWebView.this.createWebView());
                return false;
            }
        });
    }

    public void destroy() {
        Stack<WeakReference<WebView>> stack = mCachedWebViewStack;
        if (stack != null) {
            stack.clear();
        }
    }

    public WebView getWebView(Context context) {
        WebView webView;
        Stack<WeakReference<WebView>> stack = mCachedWebViewStack;
        if (stack != null && !stack.isEmpty() && (webView = stack.pop().get()) != null) {
            ((MutableContextWrapper) webView.getContext()).setBaseContext(context);
        } else {
            WeakReference<WebView> createWebView = createWebView();
            ((MutableContextWrapper) createWebView.get().getContext()).setBaseContext(context);
            webView = createWebView.get();
        }
        initSettings(webView);
        return webView;
    }

    public void preload() {
        LogUtils.d("webview preload", new String[0]);
        if (mCachedWebViewStack.size() < 3) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                pushCachedWebViewStack();
                return;
            }
            if (this.mainHandler == null) {
                this.mainHandler = new Handler(Looper.getMainLooper());
            }
            this.mainHandler.post(new Runnable() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    PreloadWebView.this.pushCachedWebViewStack();
                }
            });
        }
    }

    public PreloadWebView() {
    }
}
