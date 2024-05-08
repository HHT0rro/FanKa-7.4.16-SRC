package com.tencent.open;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.b.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0650a {

    /* renamed from: c, reason: collision with root package name */
    public static Toast f45203c;

    /* renamed from: d, reason: collision with root package name */
    private String f45204d;

    /* renamed from: e, reason: collision with root package name */
    private IUiListener f45205e;

    /* renamed from: f, reason: collision with root package name */
    private C0651c f45206f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f45207g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.open.b.a f45208h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.open.b.b f45209i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f45210j;

    /* renamed from: k, reason: collision with root package name */
    private int f45211k;

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f45209i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            c.this.f45206f.onError(new UiError(i10, str, str2));
            if (c.this.f45210j != null && c.this.f45210j.get() != 0) {
                Toast.makeText((Context) c.this.f45210j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) c.this.f45210j.get(), "auth://tauth.qq.com/"))) {
                c.this.f45206f.onComplete(l.c(str));
                c.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f45206f.onCancel();
                c.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            c.this.dismiss();
            return true;
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b extends a.b {
        private b() {
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0651c extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        public String f45214a;

        /* renamed from: b, reason: collision with root package name */
        public String f45215b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f45216c;

        /* renamed from: d, reason: collision with root package name */
        private String f45217d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f45218e;

        public C0651c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f45216c = new WeakReference<>(context);
            this.f45217d = str;
            this.f45214a = str2;
            this.f45215b = str3;
            this.f45218e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f45218e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f45218e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f45217d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f45214a, false);
            IUiListener iUiListener = this.f45218e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f45218e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f45214a;
            } else {
                str = this.f45214a;
            }
            g a10 = g.a();
            a10.a(this.f45217d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f45218e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f45218e = null;
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
    public class d extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private C0651c f45220b;

        public d(C0651c c0651c, Looper looper) {
            super(looper);
            this.f45220b = c0651c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f45220b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f45220b.onCancel();
                return;
            }
            if (i10 != 3) {
                if (i10 != 5 || c.this.f45210j == null || c.this.f45210j.get() == 0) {
                    return;
                }
                c.d((Context) c.this.f45210j.get(), (String) message.obj);
                return;
            }
            if (c.this.f45210j == null || c.this.f45210j.get() == 0) {
                return;
            }
            c.c((Context) c.this.f45210j.get(), (String) message.obj);
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f45210j = new WeakReference<>(context);
        this.f45204d = str2;
        this.f45206f = new C0651c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f45207g = new d(this.f45206f, context.getMainLooper());
        this.f45205e = iUiListener;
        this.f45211k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f45211k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d10 = l.d(str);
            d10.getInt("action");
            d10.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    private void c() {
        this.f45209i.setVerticalScrollBarEnabled(false);
        this.f45209i.setHorizontalScrollBarEnabled(false);
        this.f45209i.setWebViewClient(new a());
        this.f45209i.setWebChromeClient(this.f45194b);
        this.f45209i.clearFormData();
        WebSettings settings = this.f45209i.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f45210j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f45210j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f45193a.a(new b(), "sdk_js_if");
        this.f45209i.clearView();
        this.f45209i.loadUrl(this.f45204d);
        this.f45209i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.f45210j.get());
        this.f45208h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f45208h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f45210j.get());
        this.f45209i = bVar;
        bVar.setBackgroundColor(0);
        this.f45209i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f45209i, 1, new Paint());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45211k);
        layoutParams.addRule(13, -1);
        this.f45209i.setLayoutParams(layoutParams);
        this.f45208h.addView(this.f45209i);
        this.f45208h.a(this);
        setContentView(this.f45208h);
    }

    @Override // com.tencent.open.b.a.InterfaceC0650a
    public void a(int i10) {
        WeakReference<Context> weakReference = this.f45210j;
        if (weakReference != null && weakReference.get() != null) {
            if (i10 < this.f45211k && 2 == this.f45210j.get().getResources().getConfiguration().orientation) {
                this.f45209i.getLayoutParams().height = i10;
            } else {
                this.f45209i.getLayoutParams().height = this.f45211k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.b.a.InterfaceC0650a
    public void a() {
        this.f45209i.getLayoutParams().height = this.f45211k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f45193a.a(this.f45209i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d10 = l.d(str);
            int i10 = d10.getInt("type");
            String string = d10.getString("msg");
            if (i10 == 0) {
                Toast toast = f45203c;
                if (toast == null) {
                    f45203c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f45203c.setText(string);
                    f45203c.setDuration(0);
                }
                f45203c.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f45203c;
                if (toast2 == null) {
                    f45203c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f45203c.setText(string);
                    f45203c.setDuration(1);
                }
                f45203c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
