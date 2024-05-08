package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.alipay.sdk.widget.WebViewWindow;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j extends g implements WebViewWindow.a, WebViewWindow.b, WebViewWindow.c {

    /* renamed from: b, reason: collision with root package name */
    public static final String f4796b = "alipayjsbridge://";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4797c = "onBack";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4798d = "setTitle";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4799e = "onRefresh";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4800f = "showBackButton";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4801g = "onExit";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4802h = "onLoadJs";

    /* renamed from: i, reason: collision with root package name */
    public static final String f4803i = "callNativeFunc";

    /* renamed from: j, reason: collision with root package name */
    public static final String f4804j = "back";

    /* renamed from: k, reason: collision with root package name */
    public static final String f4805k = "title";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4806l = "refresh";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4807m = "backButton";

    /* renamed from: n, reason: collision with root package name */
    public static final String f4808n = "refreshButton";

    /* renamed from: o, reason: collision with root package name */
    public static final String f4809o = "exit";

    /* renamed from: p, reason: collision with root package name */
    public static final String f4810p = "action";

    /* renamed from: q, reason: collision with root package name */
    public static final String f4811q = "pushWindow";

    /* renamed from: r, reason: collision with root package name */
    public static final String f4812r = "h5JsFuncCallback";

    /* renamed from: s, reason: collision with root package name */
    private static final String f4813s = "sdk_result_code:";

    /* renamed from: t, reason: collision with root package name */
    private boolean f4814t;

    /* renamed from: u, reason: collision with root package name */
    private String f4815u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4816v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4817w;

    /* renamed from: x, reason: collision with root package name */
    private WebViewWindow f4818x;

    /* renamed from: y, reason: collision with root package name */
    private u f4819y;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public abstract class a implements Animation.AnimationListener {
        private a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ a(j jVar, k kVar) {
            this();
        }
    }

    public j(Activity activity) {
        super(activity);
        this.f4814t = true;
        this.f4815u = "GET";
        this.f4816v = false;
        this.f4818x = null;
        this.f4819y = new u();
        c();
    }

    private boolean c() {
        try {
            WebViewWindow webViewWindow = new WebViewWindow(this.f4792a);
            this.f4818x = webViewWindow;
            webViewWindow.setChromeProxy(this);
            this.f4818x.setWebClientProxy(this);
            this.f4818x.setWebEventProxy(this);
            addView(this.f4818x);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void d() {
        if (this.f4814t) {
            this.f4792a.finish();
        } else {
            this.f4818x.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
        }
    }

    private void e() {
        WebView webView = this.f4818x.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        u uVar = this.f4819y;
        if (uVar != null && !uVar.b()) {
            f();
        } else {
            a(false);
        }
    }

    private boolean f() {
        if (this.f4819y.b()) {
            this.f4792a.finish();
        } else {
            this.f4816v = true;
            WebViewWindow webViewWindow = this.f4818x;
            this.f4818x = this.f4819y.a();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new l(this, webViewWindow));
            webViewWindow.setAnimation(translateAnimation);
            removeView(webViewWindow);
            addView(this.f4818x);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4816v) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.f4816v) {
            return true;
        }
        d();
        return true;
    }

    public void a(String str, String str2, boolean z10) {
        this.f4815u = str2;
        this.f4818x.getTitle().setText(str);
        this.f4814t = z10;
    }

    private boolean b(String str, String str2) {
        WebViewWindow webViewWindow = this.f4818x;
        try {
            WebViewWindow webViewWindow2 = new WebViewWindow(this.f4792a);
            this.f4818x = webViewWindow2;
            webViewWindow2.setChromeProxy(this);
            this.f4818x.setWebClientProxy(this);
            this.f4818x.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f4818x.getTitle().setText(str2);
            }
            this.f4816v = true;
            this.f4819y.a(webViewWindow);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new m(this, webViewWindow, str));
            this.f4818x.setAnimation(translateAnimation);
            addView(this.f4818x);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(boolean z10) {
        com.alipay.sdk.app.j.a(z10);
        this.f4792a.finish();
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean c(WebViewWindow webViewWindow, String str) {
        webViewWindow.a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        webViewWindow.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        if ("POST".equals(this.f4815u)) {
            this.f4818x.a(str, (byte[]) null);
        } else {
            this.f4818x.a(str);
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.f4818x.a();
        this.f4819y.c();
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(f4813s)) {
            this.f4792a.runOnUiThread(new k(this));
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public void a(WebViewWindow webViewWindow, String str) {
        if (str.startsWith("http") || webViewWindow.getUrl().endsWith(str)) {
            return;
        }
        this.f4818x.getTitle().setText(str);
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean b(WebViewWindow webViewWindow, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(f4796b)) {
            b(str.substring(17));
            return true;
        }
        if (TextUtils.equals(str, com.alipay.sdk.cons.a.f4530m)) {
            a(false);
            return true;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f4792a.startActivity(intent);
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, th);
                return true;
            }
        }
        this.f4818x.a(str);
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean a(WebViewWindow webViewWindow, int i10, String str, String str2) {
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.f4448r, "onReceivedError:" + str2);
        webViewWindow.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.f4448r, String.valueOf(sslError));
        if (this.f4817w) {
            sslErrorHandler.proceed();
            this.f4817w = false;
            return true;
        }
        this.f4792a.runOnUiThread(new n(this, sslErrorHandler));
        return true;
    }

    private void a(String str, String str2, String str3) {
        JSONObject d10 = com.alipay.sdk.util.n.d(str3);
        if ("title".equals(str) && d10.has("title")) {
            this.f4818x.getTitle().setText(d10.optString("title", ""));
            return;
        }
        if ("refresh".equals(str)) {
            this.f4818x.getWebView().reload();
            return;
        }
        if (f4804j.equals(str)) {
            e();
            return;
        }
        if ("exit".equals(str)) {
            com.alipay.sdk.app.j.a(d10.optString("result", null));
            a(d10.optBoolean("success", false));
            return;
        }
        if (f4807m.equals(str)) {
            this.f4818x.getBackButton().setVisibility(d10.optBoolean("show", true) ? 0 : 4);
            return;
        }
        if (f4808n.equals(str)) {
            this.f4818x.getRefreshButton().setVisibility(d10.optBoolean("show", true) ? 0 : 4);
        } else {
            if (!f4811q.equals(str) || d10.optString("url", null) == null) {
                return;
            }
            b(d10.optString("url"), d10.optString("title", ""));
        }
    }

    private void b(String str) {
        Map<String, String> c4 = com.alipay.sdk.util.n.c(str);
        if (str.startsWith(f4803i)) {
            a(c4.get(com.alipay.sdk.authjs.a.f4497f), c4.get("cbId"), c4.get("data"));
            return;
        }
        if (str.startsWith(f4797c)) {
            e();
            return;
        }
        if (str.startsWith(f4798d) && c4.containsKey("title")) {
            this.f4818x.getTitle().setText(c4.get("title"));
            return;
        }
        if (str.startsWith(f4799e)) {
            this.f4818x.getWebView().reload();
            return;
        }
        if (str.startsWith(f4800f) && c4.containsKey("bshow")) {
            this.f4818x.getBackButton().setVisibility(TextUtils.equals("true", c4.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(f4801g)) {
            com.alipay.sdk.app.j.a(c4.get("result"));
            a(TextUtils.equals("true", c4.get("bsucc")));
        } else if (str.startsWith(f4802h)) {
            this.f4818x.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void a(WebViewWindow webViewWindow) {
        d();
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void b(WebViewWindow webViewWindow) {
        webViewWindow.getWebView().reload();
        webViewWindow.getRefreshButton().setVisibility(4);
    }
}
