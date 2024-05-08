package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.web.b.b;
import com.sina.weibo.sdk.web.b.c;
import com.sina.weibo.sdk.web.b.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WebActivity extends Activity implements a {
    private LinearLayout ak;
    private TextView al;
    private TextView am;
    private WebView an;
    private ProgressBar ao;
    private b ap;
    private com.sina.weibo.sdk.web.a.b aq;

    /* renamed from: ar, reason: collision with root package name */
    private String f38370ar;

    public static /* synthetic */ void d(WebActivity webActivity) {
        webActivity.ak.setVisibility(8);
        webActivity.an.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://service.weibo.com/share/mobilesdk.php") || str.startsWith("https://open.weibo.cn/oauth2/authorize?");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        TextView textView = new TextView(this);
        this.al = textView;
        textView.setText("关闭");
        this.al.setTextSize(17.0f);
        this.al.setTextColor(-32256);
        this.al.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebActivity.this.aq.u();
            }
        });
        TextView textView2 = new TextView(this);
        this.am = textView2;
        textView2.setTextSize(18.0f);
        this.am.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.al.setPadding(e.a(10, this), 0, e.a(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.al, layoutParams);
        relativeLayout2.addView(this.am, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, e.a(55, this)));
        this.an = new WebView(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = e.a(55, this);
        relativeLayout.addView(this.an, layoutParams3);
        this.ao = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams4.topMargin = e.a(55, this);
        relativeLayout.addView(this.ao, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams5.topMargin = e.a(55, this);
        relativeLayout.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this);
        this.ak = linearLayout;
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.ak.addView(imageView);
        TextView textView3 = new TextView(this);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = e.a(18, this);
        layoutParams6.bottomMargin = e.a(20, this);
        this.ak.addView(textView3, layoutParams6);
        textView3.setText("网络出错啦，请点击按钮重新加载");
        Button button = new Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(e.a(142, this), e.a(46, this));
        layoutParams7.gravity = 17;
        this.ak.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        button.setText("重新加载");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WebActivity.d(WebActivity.this);
                WebActivity.this.an.reload();
            }
        });
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.ak, layoutParams8);
        this.ak.setVisibility(8);
        this.an.setWebChromeClient(new WebChromeClient() { // from class: com.sina.weibo.sdk.web.WebActivity.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                WebActivity.this.ao.setProgress(i10);
                if (i10 == 100) {
                    WebActivity.this.ao.setVisibility(4);
                } else {
                    WebActivity.this.ao.setVisibility(0);
                }
            }

            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        setContentView(relativeLayout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra == 1) {
            this.f38370ar = "微博分享";
            this.ap = new d(this);
            this.aq = new com.sina.weibo.sdk.web.a.d(this, this, this.ap);
        } else if (intExtra == 2) {
            this.f38370ar = "微博登录";
            this.ap = new com.sina.weibo.sdk.web.b.a();
            this.aq = new com.sina.weibo.sdk.web.a.a(this, this, this.ap);
        } else if (intExtra == 3) {
            this.ap = new c();
            this.aq = new com.sina.weibo.sdk.web.a.c(this, this.ap);
        }
        this.an.setWebViewClient(this.aq);
        this.ap.readFromBundle(extras);
        WebSettings settings = this.an.getSettings();
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(e.s());
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        this.an.requestFocus();
        this.an.setScrollBarStyle(0);
        a(this.an, "searchBoxJavaBridge_");
        a(this.an, "accessibility");
        a(this.an, "accessibilityTraversal");
        settings.setMixedContentMode(2);
        if (this.ap.x()) {
            this.ap.a(new b.a() { // from class: com.sina.weibo.sdk.web.WebActivity.1
                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onComplete() {
                    String url = WebActivity.this.ap.getUrl();
                    if (TextUtils.isEmpty(url) || !WebActivity.k(url)) {
                        return;
                    }
                    WebActivity.this.an.loadUrl(url);
                }

                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onError(String str) {
                    WebActivity.this.aq.q(str);
                }
            });
        } else {
            String url = this.ap.getUrl();
            if (!TextUtils.isEmpty(url) && k(url)) {
                this.an.loadUrl(url);
            }
        }
        TextView textView4 = this.am;
        if (textView4 != null) {
            textView4.setText(this.f38370ar);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (this.aq.w()) {
                return true;
            }
            if (this.an.canGoBack()) {
                this.an.goBack();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void t() {
        this.ak.setVisibility(0);
        this.an.setVisibility(8);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void u() {
        finish();
    }

    private static void a(WebView webView, String str) {
        try {
            WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
