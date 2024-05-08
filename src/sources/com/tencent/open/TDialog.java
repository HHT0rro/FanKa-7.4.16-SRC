package com.tencent.open;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
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
public class TDialog extends b {

    /* renamed from: c, reason: collision with root package name */
    public static final FrameLayout.LayoutParams f45133c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    public static Toast f45134d = null;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<ProgressDialog> f45135f;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f45136e;

    /* renamed from: g, reason: collision with root package name */
    private String f45137g;

    /* renamed from: h, reason: collision with root package name */
    private OnTimeListener f45138h;

    /* renamed from: i, reason: collision with root package name */
    private IUiListener f45139i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f45140j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.b.b f45141k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f45142l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f45143m;

    /* renamed from: n, reason: collision with root package name */
    private QQToken f45144n;

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f45141k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            TDialog.this.f45138h.onError(new UiError(i10, str, str2));
            if (TDialog.this.f45136e != null && TDialog.this.f45136e.get() != 0) {
                Toast.makeText((Context) TDialog.this.f45136e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) TDialog.this.f45136e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f45138h.onComplete(l.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f45138h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                if (str.startsWith(Constants.DOWNLOAD_URI)) {
                    parse = Uri.parse(Uri.decode(str.substring(11)));
                } else {
                    parse = Uri.parse(Uri.decode(str));
                }
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                if (TDialog.this.f45136e != null && TDialog.this.f45136e.get() != 0) {
                    ((Context) TDialog.this.f45136e.get()).startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f45142l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CardEventType.CLICK_ACTION_CANCEL);
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f45142l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f45142l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f45142l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        public String f45148a;

        /* renamed from: b, reason: collision with root package name */
        public String f45149b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f45150c;

        /* renamed from: d, reason: collision with root package name */
        private String f45151d;

        /* renamed from: e, reason: collision with root package name */
        private IUiListener f45152e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f45150c = new WeakReference<>(context);
            this.f45151d = str;
            this.f45148a = str2;
            this.f45149b = str3;
            this.f45152e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f45152e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f45152e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f45151d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f45148a, false);
            IUiListener iUiListener = this.f45152e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f45152e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f45148a;
            } else {
                str = this.f45148a;
            }
            g a10 = g.a();
            a10.a(this.f45151d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f45152e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f45152e = null;
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
    public class THandler extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private OnTimeListener f45154b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f45154b = onTimeListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f45154b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f45154b.onCancel();
                return;
            }
            if (i10 != 3) {
                if (i10 != 5 || TDialog.this.f45136e == null || TDialog.this.f45136e.get() == 0) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f45136e.get(), (String) message.obj);
                return;
            }
            if (TDialog.this.f45136e == null || TDialog.this.f45136e.get() == 0) {
                return;
            }
            TDialog.c((Context) TDialog.this.f45136e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f45143m = false;
        this.f45144n = null;
        this.f45136e = new WeakReference<>(context);
        this.f45137g = str2;
        this.f45138h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f45142l = new THandler(this.f45138h, context.getMainLooper());
        this.f45139i = iUiListener;
        this.f45144n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f45138h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d10 = l.d(str);
            int i10 = d10.getInt("type");
            String string = d10.getString("msg");
            if (i10 == 0) {
                Toast toast = f45134d;
                if (toast == null) {
                    f45134d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f45134d.setText(string);
                    f45134d.setDuration(0);
                }
                f45134d.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f45134d;
                if (toast2 == null) {
                    f45134d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f45134d.setText(string);
                    f45134d.setDuration(1);
                }
                f45134d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d10 = l.d(str);
            int i10 = d10.getInt("action");
            String string = d10.getString("msg");
            if (i10 == 1) {
                WeakReference<ProgressDialog> weakReference = f45135f;
                if (weakReference != null && weakReference.get() != null) {
                    f45135f.get().setMessage(string);
                    if (!f45135f.get().isShowing()) {
                        f45135f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f45135f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i10 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f45135f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f45135f.get().isShowing()) {
                    f45135f.get().dismiss();
                    f45135f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f45136e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f45136e.get());
        this.f45141k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f45136e.get());
        this.f45140j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f45140j.addView(this.f45141k);
        setContentView(this.f45140j);
    }

    private void b() {
        this.f45141k.setVerticalScrollBarEnabled(false);
        this.f45141k.setHorizontalScrollBarEnabled(false);
        this.f45141k.setWebViewClient(new FbWebViewClient());
        this.f45141k.setWebChromeClient(this.f45194b);
        this.f45141k.clearFormData();
        WebSettings settings = this.f45141k.getSettings();
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
        WeakReference<Context> weakReference = this.f45136e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f45136e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f45193a.a(new JsListener(), "sdk_js_if");
        this.f45141k.loadUrl(this.f45137g);
        this.f45141k.setLayoutParams(f45133c);
        this.f45141k.setVisibility(4);
        this.f45141k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f45193a.a(this.f45141k, str);
        } catch (Exception unused) {
        }
    }
}
