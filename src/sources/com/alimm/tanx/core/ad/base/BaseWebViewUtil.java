package com.alimm.tanx.core.ad.base;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.bridge.TanxJsBridge;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.bean.UtItemH5Bean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.SharedPreferencesHelper;
import com.alimm.tanx.core.utils.SysUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.web.WebCacheManager;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst;
import com.alimm.tanx.core.web.webview.AdWebView;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.qq.e.comm.constants.Constants;
import java.util.AbstractMap;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseWebViewUtil {
    public BaseWebInterface tanxc_byte;
    public TanxCountDownTimer tanxc_case;
    public AdWebView tanxc_do;
    public LinearLayout tanxc_for;
    public WebView tanxc_if;
    public BidInfo tanxc_int;
    public AdInterface tanxc_long;
    public TanxJsBridge tanxc_new;
    public TanxAdSlot tanxc_try;
    public int tanxc_char = 0;
    public volatile boolean tanxc_else = false;
    public boolean tanxc_goto = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface AdInterface {
        void adClose();

        void adSkip(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface BaseWebInterface {
        void adClose();

        void adSkip(boolean z10);

        void h5NotifyDrawSuccess();

        void webDrawStatus(boolean z10);

        void webError(int i10, String str);
    }

    public static /* synthetic */ int tanxc_byte(BaseWebViewUtil baseWebViewUtil) {
        int i10 = baseWebViewUtil.tanxc_char;
        baseWebViewUtil.tanxc_char = i10 + 1;
        return i10;
    }

    private boolean tanxc_case() {
        BidInfo bidInfo = this.tanxc_int;
        if (bidInfo == null || bidInfo.getTemplateConf() == null || this.tanxc_int.getTemplateConf().getWebStartTime2Long() == null || this.tanxc_int.getTemplateConf().getWebEndTime2Long() == null) {
            return true;
        }
        return this.tanxc_int.getTemplateConf().getWebStartTime2Long().longValue() <= System.currentTimeMillis() && this.tanxc_int.getTemplateConf().getWebEndTime2Long().longValue() >= System.currentTimeMillis();
    }

    public abstract boolean tanxc_do();

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_byte() {
        try {
            LogUtils.d("BaseWebViewUtil", "cancelTimerDog  loadingError :" + this.tanxc_goto + " startTimerSwitch:" + this.tanxc_else);
            TanxCountDownTimer tanxCountDownTimer = this.tanxc_case;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.tanxc_case = null;
            }
            this.tanxc_else = false;
        } catch (Exception e2) {
            LogUtils.e("timerCancel", e2);
        }
    }

    private void tanxc_for(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + AndroidUtils.getUserAgentSuffix());
        webView.setOverScrollMode(2);
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.2
            @Override // android.webkit.WebChromeClient
            @Nullable
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView2, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i10) {
                super.onProgressChanged(webView2, i10);
                LogUtils.d("BaseWebViewUtil", "onProgressChanged:" + i10);
            }
        });
        webView.setWebViewClient(new WebViewClient() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.3
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "onLoadResource");
                super.onLoadResource(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                LogUtils.d("BaseWebViewUtil", "onPageFinished");
                if (BaseWebViewUtil.this.tanxc_byte != null) {
                    BaseWebViewUtil.this.tanxc_byte.webDrawStatus(!BaseWebViewUtil.this.tanxc_goto);
                }
                if (!BaseWebViewUtil.this.tanxc_goto) {
                    BaseWebViewUtil.this.tanxc_byte();
                    BaseWebViewUtil.this.tanxc_if.setVisibility(0);
                }
                BaseWebViewUtil.this.tanxc_new.injectJavascript();
                BaseWebViewUtil.this.tanxc_new.ready();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                LogUtils.d("BaseWebViewUtil", "onPageStarted");
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                LogUtils.d("BaseWebViewUtil", "onReceivedError:" + webResourceError.getErrorCode());
                BaseWebViewUtil.this.tanxc_do(webView2, webResourceRequest, webResourceError.getErrorCode(), webResourceError.getDescription().toString());
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                BaseWebViewUtil.this.tanxc_do(webView2, webResourceRequest, webResourceResponse.getStatusCode(), "");
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                LogUtils.d("BaseWebViewUtil", "onReceivedHttpError:" + webResourceResponse.getStatusCode());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (SharedPreferencesHelper.getInstance().getHttpsBoolean()) {
                    sslErrorHandler.proceed();
                } else {
                    super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                    sslErrorHandler.cancel();
                }
            }

            @Override // android.webkit.WebViewClient
            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, webResourceRequest.getUrl().toString());
                return true;
            }

            @Override // android.webkit.WebViewClient
            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest2");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading2");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, str);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_new() {
        char c4;
        try {
            LogUtils.d("BaseWebViewUtil", TrackConstants.Method.LOAD);
            this.tanxc_goto = false;
            if (tanxc_if(this.tanxc_if)) {
                LogUtils.e("BaseWebViewUtil", "webView已经回收，无法load，终止！！！！");
                return;
            }
            String string = SharedPreferencesHelper.getInstance().getString(SharedPreferencesHelper.REWARD_URL);
            if (!TextUtils.isEmpty(string) && TanxCoreSdk.getConfig().isDebugMode()) {
                if (SysUtils.isValidUrl(string)) {
                    LogUtils.d("BaseWebViewUtil", "load testUrl:" + string);
                    tanxc_try();
                    WebViewCacheInterceptorInst.getInstance().enableForce(true);
                    WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(string));
                    if (this.tanxc_if.getParent() == null) {
                        View view = new View(this.tanxc_for.getContext());
                        view.setLayoutParams(new ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                        this.tanxc_for.addView(view);
                        this.tanxc_for.addView(this.tanxc_if, new ViewGroup.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                BaseWebInterface baseWebInterface = this.tanxc_byte;
                if (baseWebInterface != null) {
                    baseWebInterface.webDrawStatus(false);
                    return;
                }
                return;
            }
            BidInfo bidInfo = this.tanxc_int;
            if (bidInfo == null || bidInfo.getTemplateConf() == null) {
                return;
            }
            String renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
            if (!TextUtils.isEmpty(this.tanxc_int.getTemplateConf().getPidStyleId())) {
                String pidStyleId = this.tanxc_int.getTemplateConf().getPidStyleId();
                switch (pidStyleId.hashCode()) {
                    case 1448635041:
                        if (pidStyleId.equals("100002")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448635042:
                        if (pidStyleId.equals("100003")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448635075:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_TABLE_SCREEN_ID)) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448635076:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID)) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448635077:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_NEW_REWARD_ID)) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448635101:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_SPLASH_WEB_ID)) {
                            c4 = 6;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1448636000:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID)) {
                            c4 = 5;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                switch (c4) {
                    case 0:
                        renderUrl = renderUrl + "?pidStyleId=" + this.tanxc_int.getTemplateConf().getPidStyleId();
                        break;
                    case 1:
                    case 2:
                    case 3:
                        renderUrl = this.tanxc_int.getClickThroughUrl();
                        break;
                    case 4:
                        renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
                        break;
                    case 5:
                    case 6:
                        renderUrl = this.tanxc_int.getTemplateConf().getWebUrl();
                        break;
                }
            } else {
                LogUtils.e("BaseWebViewUtil", "load()  getPidStyleId == null ");
            }
            LogUtils.d("BaseWebViewUtil", "load h5:" + renderUrl);
            if (SysUtils.isValidUrl(renderUrl)) {
                String replaceAll = renderUrl.replaceAll("\\\\", "");
                tanxc_try();
                WebViewCacheInterceptorInst.getInstance().enableForce(true);
                WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(replaceAll));
                if (this.tanxc_if.getParent() == null) {
                    View view2 = new View(this.tanxc_for.getContext());
                    view2.setLayoutParams(new ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                    this.tanxc_for.addView(view2);
                    this.tanxc_for.addView(this.tanxc_if, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                return;
            }
            BaseWebInterface baseWebInterface2 = this.tanxc_byte;
            if (baseWebInterface2 != null) {
                baseWebInterface2.webDrawStatus(false);
            }
        } catch (Exception e2) {
            LogUtils.e("BaseWebViewUtil", "load()   " + LogUtils.getStackTraceMessage(e2));
        }
    }

    private void tanxc_try() {
        LogUtils.d("BaseWebViewUtil", "startTimerDog - startSwitch:" + this.tanxc_else);
        try {
            if (this.tanxc_else) {
                return;
            }
            TanxCountDownTimer tanxCountDownTimer = new TanxCountDownTimer(5000L, 1000L) { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.12
                @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                public void onFinish() {
                    LogUtils.d("BaseWebViewUtil", "startTimer - onFinish");
                    BaseWebViewUtil.this.tanxc_else = false;
                    BaseWebViewUtil.tanxc_byte(BaseWebViewUtil.this);
                    BaseWebViewUtil.this.tanxc_new();
                }

                @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                public void onTick(long j10) {
                    LogUtils.d("BaseWebViewUtil", "startTimer" + Math.round(((float) j10) / 1000.0f) + "");
                }
            };
            this.tanxc_case = tanxCountDownTimer;
            if (this.tanxc_char <= 5) {
                tanxCountDownTimer.start();
                this.tanxc_else = true;
            } else {
                LogUtils.d("BaseWebViewUtil", "startTimer不在启动：nowTryLoadCount:" + this.tanxc_char);
            }
        } catch (Exception e2) {
            LogUtils.e("BaseWebViewUtil", "startTimer", e2);
        }
    }

    public void tanxc_if() {
        tanxc_byte();
        AdWebView adWebView = this.tanxc_do;
        if (adWebView != null) {
            adWebView.destroy();
        }
    }

    public void tanxc_int() {
        if (this.tanxc_goto) {
            tanxc_new();
        }
    }

    public static boolean tanxc_if(WebView webView) {
        if (webView != null) {
            try {
                if (webView.getContext() instanceof MutableContextWrapper) {
                    MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) webView.getContext();
                    if ((mutableContextWrapper.getBaseContext() instanceof Activity) && !((Activity) mutableContextWrapper.getBaseContext()).isDestroyed()) {
                        return false;
                    }
                } else if ((webView.getContext() instanceof Activity) && !((Activity) webView.getContext()).isDestroyed()) {
                    return false;
                }
            } catch (Exception e2) {
                LogUtils.e("BaseWebViewUtil", e2);
            }
        }
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, BaseWebInterface baseWebInterface) {
        LogUtils.d("BaseWebViewUtil", "init");
        this.tanxc_for = linearLayout;
        this.tanxc_int = bidInfo;
        this.tanxc_byte = baseWebInterface;
        this.tanxc_try = tanxAdSlot;
        if (tanxc_case()) {
            AdWebView adWebView = WebCacheManager.getInstance().getAdWebView();
            this.tanxc_do = adWebView;
            WebView webView = adWebView.getWebView(linearLayout.getContext());
            this.tanxc_if = webView;
            webView.setBackgroundColor(0);
            tanxc_do(this.tanxc_if);
            tanxc_for(this.tanxc_if);
            tanxc_new();
        }
    }

    public void tanxc_for() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_case;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_case = null;
        }
    }

    public void tanxc_do(AdInterface adInterface) {
        this.tanxc_long = adInterface;
    }

    public void tanxc_do(WebView webView) {
        TanxJsBridge tanxJsBridge = new TanxJsBridge(webView.getContext(), webView);
        this.tanxc_new = tanxJsBridge;
        tanxJsBridge.register("Core.getSdkInfo", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.1
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "Core.getSDKInfo");
                HashMap hashMap = new HashMap();
                hashMap.put("version", SdkConstant.getSdkVersion());
                callback.call(true, hashMap);
            }
        });
        this.tanxc_new.register("WebAd.notifyWebDidMount", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "WebAd.notifyWebDidMount");
                if (BaseWebViewUtil.this.tanxc_byte != null) {
                    LogUtils.d("BaseWebViewUtil", "baseWebInterface!=null");
                    BaseWebViewUtil.this.tanxc_byte.h5NotifyDrawSuccess();
                }
            }
        });
        this.tanxc_new.register("WebAd.track", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.5
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                BaseWebViewUtil.this.tanxc_do(abstractMap, callback);
            }
        });
        this.tanxc_new.register("WebAd.getAd", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.6
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = null;
                try {
                    LogUtils.d("BaseWebViewUtil", "RewardVideo.getAd");
                    if (BaseWebViewUtil.this.tanxc_int == null || TextUtils.isEmpty(BaseWebViewUtil.this.tanxc_int.getRawJsonStr())) {
                        e = null;
                    } else {
                        e = null;
                        jSONObject = JSON.parseObject(BaseWebViewUtil.this.tanxc_int.getRawJsonStr());
                    }
                } catch (Exception e2) {
                    e = e2;
                    LogUtils.e("BaseWebViewUtil", e);
                }
                if (jSONObject != null) {
                    hashMap.put("ad", jSONObject);
                } else {
                    hashMap.put("code", -1);
                    String stackTraceMessage = LogUtils.getStackTraceMessage(e);
                    if (BaseWebViewUtil.this.tanxc_int != null) {
                        stackTraceMessage = stackTraceMessage + "  \n bidInfo:" + BaseWebViewUtil.this.tanxc_int.getRawJsonStr();
                    }
                    hashMap.put("msg", stackTraceMessage);
                }
                callback.call(true, hashMap);
            }
        });
        this.tanxc_new.register("Core.getNetType", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.7
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "Core.getNetType");
                HashMap hashMap = new HashMap();
                hashMap.put("netType", NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getMsg());
                LogUtils.d("BaseWebViewUtil", JSON.toJSONString(hashMap));
                callback.call(true, hashMap);
            }
        });
        this.tanxc_new.register("WebAd.notifyClose", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.8
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "RewardVideo.notifyClose");
                if (BaseWebViewUtil.this.tanxc_long != null) {
                    BaseWebViewUtil.this.tanxc_long.adClose();
                }
                BaseWebViewUtil.this.tanxc_byte.adClose();
                callback.call(true, null);
            }
        });
        this.tanxc_new.register("WebAd.notifyAdSkip", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.9
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "RewardVideo.notifyAdSkip");
                Boolean bool = (Boolean) abstractMap.get("needClose");
                if (bool == null) {
                    bool = Boolean.TRUE;
                }
                if (BaseWebViewUtil.this.tanxc_long != null) {
                    BaseWebViewUtil.this.tanxc_long.adSkip(bool.booleanValue());
                }
                BaseWebViewUtil.this.tanxc_byte.adSkip(bool.booleanValue());
                callback.call(true, null);
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.10
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("BaseWebViewUtil", "Reward.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                BaseWebViewUtil.this.tanxc_byte.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
        this.tanxc_new.register("WebAd.submitFeedback", new JsHandler() { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil.11
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("BaseWebViewUtil", "RewardVideo.submitFeedback");
                    InteractionUpload.getInstance().uploadInteraction(BaseWebViewUtil.this.tanxc_int.getEventTrack(), (String) abstractMap.get("interactType"), (String) abstractMap.get("interactDesc"));
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("BaseWebViewUtil", e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(WebView webView, WebResourceRequest webResourceRequest, int i10, String str) {
        try {
            String uri = webResourceRequest.getUrl().toString();
            LogUtils.d("BaseWebViewUtil", "loadError URL:" + uri);
            if (SysUtils.checkUrlSuffixAndValid(uri)) {
                this.tanxc_goto = true;
                webView.setVisibility(8);
            }
            LogUtils.e("BaseWebViewUtil", "loadError errorCode:" + i10 + " errorMsg:" + str + " url:" + uri);
        } catch (Exception e2) {
            LogUtils.e("BaseWebViewUtil", "loadError:", e2);
        }
    }

    private int tanxc_do(Context context) {
        if (!tanxc_do() || context == null) {
            return 0;
        }
        return SysUtils.getStatusBarHeight2WebView(context);
    }

    private String tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(SymbolValues.QUESTION_EN_SYMBOL)) {
            return (str + "&sdkVersion=" + SdkConstant.getSdkVersion()).trim();
        }
        return (str + "?sdkVersion=" + SdkConstant.getSdkVersion()).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(AbstractMap<String, Object> abstractMap, Callback callback) {
        try {
            LogUtils.d("BaseWebViewUtil", "RewardVideo.track");
            JSONObject jSONObject = (JSONObject) abstractMap.get("event");
            UtItemH5Bean utItemH5Bean = (UtItemH5Bean) JSON.parseObject(jSONObject != null ? jSONObject.toJSONString() : "", UtItemH5Bean.class);
            Boolean bool = (Boolean) abstractMap.get("needTemplateId");
            Boolean bool2 = (Boolean) abstractMap.get("needCreativeId");
            Boolean bool3 = (Boolean) abstractMap.get("needOpenType");
            Boolean bool4 = (Boolean) abstractMap.get("needClickUrl");
            if (utItemH5Bean != null) {
                TanxAdSlot tanxAdSlot = this.tanxc_try;
                if (tanxAdSlot != null) {
                    utItemH5Bean.pid = tanxAdSlot.getPid();
                    utItemH5Bean.reqId = this.tanxc_try.getReqId();
                }
                if (TextUtils.isEmpty(utItemH5Bean.page)) {
                    utItemH5Bean.page = utItemH5Bean.arg1;
                }
                if (this.tanxc_int != null) {
                    if (utItemH5Bean.args == null) {
                        utItemH5Bean.args = new HashMap();
                    }
                    if (bool == null || bool.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.templateId, this.tanxc_int.getTemplateId());
                    }
                    if (bool2 == null || bool2.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.creativeId, this.tanxc_int.getCreativeId());
                    }
                    if (bool3 != null && bool3.booleanValue()) {
                        utItemH5Bean.args.put("openType", Integer.valueOf(this.tanxc_int.getOpenType()));
                    }
                    if (bool4 != null && bool4.booleanValue()) {
                        utItemH5Bean.args.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, this.tanxc_int.getDeepLinkUrl());
                    }
                }
                TanxBaseUt.h5Ut(utItemH5Bean);
            } else {
                LogUtils.e("BaseWebViewUtil", "Core.track  接收到H5埋点对象为空");
            }
            callback.call(true, null);
        } catch (Exception e2) {
            LogUtils.e("BaseWebViewUtil", e2);
        }
    }
}
