package com.tencent.connect.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.security.realidentity.build.bh;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private String f42449a;

    /* renamed from: b, reason: collision with root package name */
    private b f42450b;

    /* renamed from: c, reason: collision with root package name */
    private IUiListener f42451c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f42452d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f42453e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f42454f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f42455g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f42456h;

    /* renamed from: i, reason: collision with root package name */
    private Button f42457i;

    /* renamed from: j, reason: collision with root package name */
    private String f42458j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.b.c f42459k;

    /* renamed from: l, reason: collision with root package name */
    private Context f42460l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.open.web.security.b f42461m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f42462n;

    /* renamed from: o, reason: collision with root package name */
    private int f42463o;

    /* renamed from: p, reason: collision with root package name */
    private String f42464p;

    /* renamed from: q, reason: collision with root package name */
    private String f42465q;

    /* renamed from: r, reason: collision with root package name */
    private long f42466r;

    /* renamed from: s, reason: collision with root package name */
    private long f42467s;

    /* renamed from: t, reason: collision with root package name */
    private HashMap<String, Runnable> f42468t;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class C0630a extends WebViewClient {
        private C0630a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f42455g.setVisibility(8);
            if (a.this.f42459k != null) {
                a.this.f42459k.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f42452d.removeCallbacks((Runnable) a.this.f42468t.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f42455g.setVisibility(0);
            a.this.f42466r = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f42464p)) {
                a.this.f42452d.removeCallbacks((Runnable) a.this.f42468t.remove(a.this.f42464p));
            }
            a.this.f42464p = str;
            a aVar = a.this;
            d dVar = new d(aVar.f42464p);
            a.this.f42468t.put(str, dVar);
            a.this.f42452d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i10 + " | description: " + str);
            if (!l.b(a.this.f42460l)) {
                a.this.f42450b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.f42464p.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                a.this.f42450b.onError(new UiError(i10, str, str2));
                a.this.dismiss();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f42466r;
            if (a.this.f42463o >= 1 || elapsedRealtime >= a.this.f42467s) {
                a.this.f42459k.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f42452d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f42459k.loadUrl(a.this.f42464p);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            } else {
                str = "The SSL certificate is invalid,do you countinue?";
                str2 = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a.this.f42460l);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    sslErrorHandler.cancel();
                    a.this.dismiss();
                }
            });
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c4 = l.c(str);
                a aVar = a.this;
                aVar.f42462n = aVar.f();
                if (!a.this.f42462n) {
                    if (c4.optString("fail_cb", null) != null) {
                        a.this.a(c4.optString("fail_cb"), "");
                    } else if (c4.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(a.this.f42449a);
                        String str2 = a.this.f42449a;
                        String str3 = SymbolValues.QUESTION_EN_SYMBOL;
                        if (str2.indexOf(SymbolValues.QUESTION_EN_SYMBOL) > -1) {
                            str3 = "&";
                        }
                        sb2.append(str3);
                        aVar2.f42449a = sb2.toString();
                        a.this.f42449a = a.this.f42449a + "browser_error=1";
                        a.this.f42459k.loadUrl(a.this.f42449a);
                    } else {
                        String optString = c4.optString("redir", null);
                        if (optString != null) {
                            a.this.f42459k.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f42450b.onComplete(l.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f42450b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.f42455g.setVisibility(8);
                        a.this.f42459k.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.f42455g.setVisibility(0);
                    }
                    return true;
                }
                if (!str.startsWith("auth://onLoginSubmit")) {
                    if (a.this.f42461m.a(a.this.f42459k, str)) {
                        return true;
                    }
                    SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                }
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (!pathSegments2.isEmpty()) {
                        a.this.f42465q = pathSegments2.get(0);
                    }
                } catch (Exception unused2) {
                }
                return true;
            }
            try {
                if (str.startsWith(Constants.DOWNLOAD_URI)) {
                    parse = Uri.parse(Uri.decode(str.substring(11)));
                } else {
                    parse = Uri.parse(Uri.decode(str));
                }
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                a.this.f42460l.startActivity(intent);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        public String f42479a;

        /* renamed from: b, reason: collision with root package name */
        public String f42480b;

        /* renamed from: d, reason: collision with root package name */
        private String f42482d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f42483e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f42482d = str;
            this.f42479a = str2;
            this.f42480b = str3;
            this.f42483e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f42483e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f42483e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f42482d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f42479a, false);
            IUiListener iUiListener = this.f42483e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f42483e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f42479a;
            } else {
                str = this.f42479a;
            }
            g.a().a(this.f42482d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f42483e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f42483e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(l.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private b f42485b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f42485b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                this.f42485b.a((String) message.obj);
            } else if (i10 == 2) {
                this.f42485b.onCancel();
            } else {
                if (i10 != 3) {
                    return;
                }
                a.b(a.this.f42460l, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f42486a;

        public d(String str) {
            this.f42486a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f42486a + " | mRetryUrl: " + a.this.f42464p);
            if (this.f42486a.equals(a.this.f42464p)) {
                a.this.f42450b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.f42464p));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f42462n = false;
        this.f42466r = 0L;
        this.f42467s = 30000L;
        this.f42460l = context;
        this.f42449a = str2;
        this.f42450b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f42452d = new c(this.f42450b, context.getMainLooper());
        this.f42451c = iUiListener;
        this.f42458j = str;
        this.f42461m = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i10 = aVar.f42463o;
        aVar.f42463o = i10 + 1;
        return i10;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f42468t.clear();
        this.f42452d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f42460l;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        com.tencent.open.b.c cVar = this.f42459k;
        if (cVar != null) {
            cVar.destroy();
            this.f42459k = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f42462n) {
            this.f42450b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        b();
        e();
        this.f42468t = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    private void e() {
        this.f42459k.setVerticalScrollBarEnabled(false);
        this.f42459k.setHorizontalScrollBarEnabled(false);
        this.f42459k.setWebViewClient(new C0630a());
        this.f42459k.setWebChromeClient(new WebChromeClient());
        this.f42459k.clearFormData();
        this.f42459k.clearSslPreferences();
        this.f42459k.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f42459k.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f42459k.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f42460l.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f42449a);
        String str = this.f42449a;
        this.f42464p = str;
        this.f42459k.loadUrl(str);
        this.f42459k.setVisibility(4);
        this.f42459k.getSettings().setSavePassword(false);
        this.f42461m.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.tencent.connect.auth.b a10 = com.tencent.connect.auth.b.a();
        String c4 = a10.c();
        b.a aVar = new b.a();
        aVar.f42493a = this.f42451c;
        aVar.f42494b = this;
        aVar.f42495c = c4;
        String a11 = a10.a(aVar);
        String str = this.f42449a;
        String substring = str.substring(0, str.indexOf(SymbolValues.QUESTION_EN_SYMBOL));
        Bundle b4 = l.b(this.f42449a);
        b4.putString("token_key", c4);
        b4.putString("serial", a11);
        b4.putString("browser", "1");
        String str2 = substring + SymbolValues.QUESTION_EN_SYMBOL + HttpUtils.encodeUrl(b4);
        this.f42449a = str2;
        return l.a(this.f42460l, str2);
    }

    private void b() {
        d();
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.c cVar = new com.tencent.open.b.c(this.f42460l);
        this.f42459k = cVar;
        cVar.setLayerType(1, null);
        this.f42459k.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f42460l);
        this.f42453e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f42453e.addView(this.f42459k);
        this.f42453e.addView(this.f42455g);
        String string = l.b(this.f42449a).getString("style");
        if (string != null && "qr".equals(string)) {
            this.f42453e.addView(this.f42457i);
        }
        setContentView(this.f42453e);
    }

    private void c() {
        Button button = new Button(this.f42460l);
        this.f42457i = button;
        button.setBackgroundDrawable(l.a("h5_qr_back.png", this.f42460l));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.tencent.connect.avatar.a.a(this.f42460l, 20.0f);
        layoutParams.topMargin = com.tencent.connect.avatar.a.a(this.f42460l, 10.0f);
        this.f42457i.setLayoutParams(layoutParams);
        this.f42457i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f42462n || a.this.f42450b == null) {
                    return;
                }
                a.this.f42450b.onCancel();
            }
        });
    }

    private void d() {
        TextView textView;
        this.f42456h = new ProgressBar(this.f42460l);
        this.f42456h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f42454f = new LinearLayout(this.f42460l);
        if (this.f42458j.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f42460l);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f42454f.setLayoutParams(layoutParams2);
        this.f42454f.addView(this.f42456h);
        if (textView != null) {
            this.f42454f.addView(textView);
        }
        this.f42455g = new FrameLayout(this.f42460l);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f42455g.setLayoutParams(layoutParams3);
        this.f42455g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f42455g.addView(this.f42454f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f42465q) && this.f42465q.length() >= 4) {
            String str2 = this.f42465q;
            String substring = str2.substring(str2.length() - 4);
            sb2.append("_u_");
            sb2.append(substring);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f42449a;
        String str2 = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf(SymbolValues.QUESTION_EN_SYMBOL) + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    public void a(String str, String str2) {
        this.f42459k.loadUrl(bh.f3176j + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d10 = l.d(str);
            int i10 = d10.getInt("type");
            Toast.makeText(context.getApplicationContext(), d10.getString("msg"), i10).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
