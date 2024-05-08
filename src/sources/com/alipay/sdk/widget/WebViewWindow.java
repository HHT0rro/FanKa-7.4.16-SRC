package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class WebViewWindow extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private static Handler f4764f = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private ImageView f4765a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4766b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f4767c;

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f4768d;

    /* renamed from: e, reason: collision with root package name */
    private WebView f4769e;

    /* renamed from: g, reason: collision with root package name */
    private a f4770g;

    /* renamed from: h, reason: collision with root package name */
    private b f4771h;

    /* renamed from: i, reason: collision with root package name */
    private c f4772i;

    /* renamed from: j, reason: collision with root package name */
    private View.OnClickListener f4773j;

    /* renamed from: k, reason: collision with root package name */
    private final float f4774k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(WebViewWindow webViewWindow, String str);

        boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        boolean a(WebViewWindow webViewWindow, int i10, String str, String str2);

        boolean a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(WebViewWindow webViewWindow, String str);

        boolean c(WebViewWindow webViewWindow, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface c {
        void a(WebViewWindow webViewWindow);

        void b(WebViewWindow webViewWindow);
    }

    public WebViewWindow(Context context) {
        this(context, null);
    }

    public ImageView getBackButton() {
        return this.f4765a;
    }

    public ProgressBar getProgressbar() {
        return this.f4768d;
    }

    public ImageView getRefreshButton() {
        return this.f4767c;
    }

    public TextView getTitle() {
        return this.f4766b;
    }

    public String getUrl() {
        return this.f4769e.getUrl();
    }

    public WebView getWebView() {
        return this.f4769e;
    }

    public void setChromeProxy(a aVar) {
        this.f4770g = aVar;
        if (aVar == null) {
            this.f4769e.setWebChromeClient(null);
        } else {
            this.f4769e.setWebChromeClient(new s(this));
        }
    }

    public void setWebClientProxy(b bVar) {
        this.f4771h = bVar;
        if (bVar == null) {
            this.f4769e.setWebViewClient(null);
        } else {
            this.f4769e.setWebViewClient(new t(this));
        }
    }

    public void setWebEventProxy(c cVar) {
        this.f4772i = cVar;
    }

    public WebViewWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4773j = new q(this);
        this.f4774k = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        this.f4765a = imageView;
        imageView.setOnClickListener(this.f4773j);
        this.f4765a.setScaleType(ImageView.ScaleType.CENTER);
        this.f4765a.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f4743a, context));
        this.f4765a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f4765a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f4766b = textView;
        textView.setTextColor(-15658735);
        this.f4766b.setTextSize(17.0f);
        this.f4766b.setMaxLines(1);
        this.f4766b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f4766b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f4767c = imageView2;
        imageView2.setOnClickListener(this.f4773j);
        this.f4767c.setScaleType(ImageView.ScaleType.CENTER);
        this.f4767c.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f4744b, context));
        this.f4767c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f4767c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void c(Context context) {
        WebView webView = new WebView(context);
        this.f4769e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.f4769e, context);
        WebSettings settings = this.f4769e.getSettings();
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        try {
            this.f4769e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f4769e.removeJavascriptInterface("accessibility");
            this.f4769e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        addView(this.f4769e, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16973855);
        this.f4768d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.f4768d.setMax(100);
        this.f4768d.setBackgroundColor(-218103809);
        addView(this.f4768d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + " AlipaySDK(" + context.getPackageName() + "/" + com.alipay.sdk.util.n.i(context) + "/15.6.2)");
    }

    public void a(String str) {
        this.f4769e.loadUrl(str);
    }

    public void a(String str, byte[] bArr) {
        this.f4769e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.f4769e.removeAllViews();
        this.f4769e.setWebViewClient(null);
        this.f4769e.setWebChromeClient(null);
        this.f4769e.destroy();
    }

    private int a(int i10) {
        return (int) (i10 * this.f4774k);
    }
}
