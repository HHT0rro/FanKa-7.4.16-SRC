package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.app.i;
import com.alipay.sdk.util.n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AuthActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4466a = "params";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4467b = "redirectUri";

    /* renamed from: c, reason: collision with root package name */
    private WebView f4468c;

    /* renamed from: d, reason: collision with root package name */
    private String f4469d;

    /* renamed from: e, reason: collision with root package name */
    private com.alipay.sdk.widget.a f4470e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f4471f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4472g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4473h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AuthActivity> f4474a;

        public /* synthetic */ a(AuthActivity authActivity, com.alipay.sdk.auth.a aVar) {
            this(authActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthActivity authActivity = this.f4474a.get();
            if (authActivity != null) {
                authActivity.b();
            }
        }

        private a(AuthActivity authActivity) {
            this.f4474a = new WeakReference<>(authActivity);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message)) {
                return super.onConsoleMessage(consoleMessage);
            }
            String replaceFirst = message.startsWith("h5container.message: ") ? message.replaceFirst("h5container.message: ", "") : null;
            if (!TextUtils.isEmpty(replaceFirst)) {
                AuthActivity.this.b(replaceFirst);
                return super.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public /* synthetic */ b(AuthActivity authActivity, com.alipay.sdk.auth.a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AuthActivity.this.b();
            AuthActivity.this.f4471f.removeCallbacksAndMessages(null);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthActivity.this.a();
            AuthActivity.this.f4471f.postDelayed(new a(AuthActivity.this, null), 30000L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            AuthActivity.this.f4473h = true;
            super.onReceivedError(webView, i10, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (AuthActivity.this.f4472g) {
                sslErrorHandler.proceed();
                AuthActivity.this.f4472g = false;
            } else {
                AuthActivity.this.runOnUiThread(new d(this, sslErrorHandler));
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.toLowerCase().startsWith(com.alipay.sdk.cons.a.f4527j.toLowerCase()) && !str.toLowerCase().startsWith(com.alipay.sdk.cons.a.f4528k.toLowerCase())) {
                if (AuthActivity.this.a(str)) {
                    webView.stopLoading();
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                n.a a10 = n.a(AuthActivity.this, i.f4411a);
                if (a10 != null && !a10.a() && !a10.b()) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst(com.alipay.sdk.cons.a.f4528k, com.alipay.sdk.cons.a.f4527j);
                    }
                    AuthActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        public /* synthetic */ c(AuthActivity authActivity, com.alipay.sdk.auth.a aVar) {
            this();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f4468c.canGoBack()) {
            if (this.f4473h) {
                g.a(this, this.f4469d + "?resultCode=150");
                finish();
                return;
            }
            return;
        }
        g.a(this, this.f4469d + "?resultCode=150");
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            try {
                this.f4469d = extras.getString(f4467b);
                String string = extras.getString("params");
                if (!n.f(string)) {
                    finish();
                    return;
                }
                super.requestWindowFeature(1);
                this.f4471f = new Handler(getMainLooper());
                LinearLayout linearLayout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                linearLayout.setOrientation(1);
                setContentView(linearLayout, layoutParams);
                WebView webView = new WebView(this);
                this.f4468c = webView;
                layoutParams.weight = 1.0f;
                webView.setVisibility(0);
                linearLayout.addView(this.f4468c, layoutParams);
                WebSettings settings = this.f4468c.getSettings();
                settings.setUserAgentString(settings.getUserAgentString() + n.c(getApplicationContext()));
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                settings.setSupportMultipleWindows(true);
                settings.setJavaScriptEnabled(true);
                settings.setSavePassword(false);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                settings.setAllowFileAccess(false);
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                settings.setAllowContentAccess(false);
                settings.setTextSize(WebSettings.TextSize.NORMAL);
                this.f4468c.setVerticalScrollbarOverlay(true);
                com.alipay.sdk.auth.a aVar = null;
                this.f4468c.setWebViewClient(new c(this, aVar));
                this.f4468c.setWebChromeClient(new b(this, aVar));
                this.f4468c.setDownloadListener(new com.alipay.sdk.auth.a(this));
                this.f4468c.loadUrl(string);
                try {
                    Method method = this.f4468c.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                    if (method != null) {
                        method.invoke(this.f4468c.getSettings(), Boolean.TRUE);
                    }
                } catch (Exception unused) {
                }
                try {
                    try {
                        this.f4468c.removeJavascriptInterface("searchBoxJavaBridge_");
                        this.f4468c.removeJavascriptInterface("accessibility");
                        this.f4468c.removeJavascriptInterface("accessibilityTraversal");
                    } catch (Throwable unused2) {
                        this.f4468c.getSettings().setCacheMode(1);
                    }
                } catch (Throwable unused3) {
                    Method method2 = this.f4468c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                    if (method2 != null) {
                        method2.invoke(this.f4468c, "searchBoxJavaBridge_");
                        method2.invoke(this.f4468c, "accessibility");
                        method2.invoke(this.f4468c, "accessibilityTraversal");
                    }
                    this.f4468c.getSettings().setCacheMode(1);
                }
            } catch (Exception unused4) {
                finish();
            }
        } catch (Exception unused5) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f4468c;
        if (webView != null) {
            webView.removeAllViews();
            try {
                this.f4468c.destroy();
            } catch (Throwable unused) {
            }
            this.f4468c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        new com.alipay.sdk.authjs.d(getApplicationContext(), new com.alipay.sdk.auth.b(this)).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, this.f4469d)) {
                str = str + "?resultCode=150";
            }
            g.a(this, str);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.alipay.sdk.widget.a aVar = this.f4470e;
        if (aVar != null) {
            aVar.c();
        }
        this.f4470e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.authjs.a aVar) {
        if (this.f4468c == null || aVar == null) {
            return;
        }
        try {
            runOnUiThread(new com.alipay.sdk.auth.c(this, String.format("AlipayJSBridge._invokeJS(%s)", aVar.g())));
        } catch (JSONException e2) {
            com.alipay.sdk.util.c.a("msp", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (this.f4470e == null) {
                this.f4470e = new com.alipay.sdk.widget.a(this, com.alipay.sdk.widget.a.f4775a);
            }
            this.f4470e.b();
        } catch (Exception unused) {
            this.f4470e = null;
        }
    }
}
