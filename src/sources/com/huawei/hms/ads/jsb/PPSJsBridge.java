package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.annotations.OuterVisible;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.ads.jsb.inner.impl.JsBridgeImpl;
import com.huawei.hms.ads.jsbridge.b;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

@OuterVisible
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSJsBridge extends com.huawei.hms.ads.jsbridge.a {

    /* renamed from: a, reason: collision with root package name */
    private static JsbConfig f29330a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<WebView> f29331b;

    /* renamed from: c, reason: collision with root package name */
    private IWebView f29332c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f29333d;

    @OuterVisible
    public PPSJsBridge(WebView webView) {
        if (webView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(webView);
        a();
        webView.addJavascriptInterface(this, "_HwJSBridge");
    }

    @OuterVisible
    public PPSJsBridge(IWebView iWebView) {
        if (iWebView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(iWebView);
        a();
        iWebView.addJavascriptInterface(this, "_HwJSBridge");
    }

    private void a() {
        JsBridgeImpl.initConfig(b(), f29330a);
    }

    private void a(final String str) {
        com.huawei.hms.ads.jsbridge.a.a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (PPSJsBridge.this.f29333d) {
                    if (PPSJsBridge.this.f29332c != null) {
                        PPSJsBridge.this.f29332c.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.1
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str2) {
                            }
                        });
                        return;
                    }
                } else if (PPSJsBridge.this.f29331b != null && PPSJsBridge.this.f29331b.get() != 0) {
                    ((WebView) PPSJsBridge.this.f29331b.get()).evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.2
                        @Override // android.webkit.ValueCallback
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str2) {
                        }
                    });
                    return;
                }
                b.b("please register a webView object to jsb.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z10, boolean z11, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z11) {
            str4 = String.format(Locale.ENGLISH, "if(%s){%s(%s)};", str, str, str2);
            if (z10) {
                str4 = str4 + "delete window." + str;
            }
        } else {
            if (str3 == null) {
                str3 = "";
            }
            str4 = "var iframeEles=document.querySelectorAll('iframe');if(iframeEles && iframeEles.length>0){for (let index = 0; index < iframeEles.length; index++) {var iframe = iframeEles[index];if (iframe &&iframe.contentWindow) {iframe.contentWindow.postMessage({ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z10 + ",uuid:'" + str3 + "'},'*');}}}";
        }
        a(str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context b() {
        if (this.f29333d) {
            IWebView iWebView = this.f29332c;
            if (iWebView != null) {
                Context context = iWebView.getContext();
                if (context == null) {
                    b.b("custom webView context is null.");
                }
                return context;
            }
        } else {
            WeakReference<WebView> weakReference = this.f29331b;
            if (weakReference != null && weakReference.get() != null) {
                return this.f29331b.get().getContext();
            }
        }
        b.b("the webview context is null.");
        return null;
    }

    private void b(WebView webView) {
        this.f29331b = new WeakReference<>(webView);
    }

    private void b(IWebView iWebView) {
        this.f29333d = true;
        this.f29332c = iWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        if (this.f29333d) {
            IWebView iWebView = this.f29332c;
            if (iWebView != null) {
                return a(iWebView);
            }
            return null;
        }
        WeakReference<WebView> weakReference = this.f29331b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return a(this.f29331b.get());
    }

    @OuterVisible
    public static void init(JsbConfig jsbConfig) {
        f29330a = jsbConfig;
    }

    @OuterVisible
    public void destroy() {
        WeakReference<WebView> weakReference = this.f29331b;
        if (weakReference != null) {
            weakReference.clear();
        }
        IWebView iWebView = this.f29332c;
        if (iWebView != null) {
            iWebView.removeJavascriptInterface("_HwJSBridge");
            this.f29332c = null;
        }
    }

    @JavascriptInterface
    public String invoke(String str, String str2) {
        WeakReference<WebView> weakReference = this.f29331b;
        if (weakReference != null && weakReference.get() != null) {
            return JsBridgeImpl.invoke(this.f29331b.get().getContext(), str, str2);
        }
        b.b("this webView is destroyed");
        return null;
    }

    @JavascriptInterface
    public void invokeAsync(final String str, final String str2, final String str3) {
        final JSONObject jSONObject = new JSONObject();
        com.huawei.hms.ads.jsbridge.a.a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str2;
                final boolean z10 = true;
                final String str5 = null;
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    z10 = jSONObject2.optBoolean("top", true);
                    str5 = jSONObject2.optString(Constant.MAP_KEY_UUID);
                    jSONObject2.put("url", PPSJsBridge.this.c());
                    str4 = jSONObject2.toString();
                } catch (Throwable unused) {
                    b.b("jsb response data error.");
                }
                Context b4 = PPSJsBridge.this.b();
                if (b4 == null) {
                    b.b("invoke method param context is null.");
                }
                JsBridgeImpl.invoke(b4, str, str4, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str6, CallResult<String> callResult) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(callResult.getData());
                            boolean optBoolean = jSONObject3.optBoolean("complete", true);
                            jSONObject.put("code", callResult.getCode());
                            jSONObject.put("data", jSONObject3);
                            jSONObject.put("msg", callResult.getMsg());
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            PPSJsBridge.this.a(str3, jSONObject.toString(), optBoolean, z10, str5);
                        } catch (Throwable unused2) {
                            b.b("jsb response data error.");
                        }
                    }
                }, String.class);
            }
        });
    }
}
