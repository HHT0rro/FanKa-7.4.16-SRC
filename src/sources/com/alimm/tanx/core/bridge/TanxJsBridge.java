package com.alimm.tanx.core.bridge;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.build.bh;
import com.alimm.tanx.core.ad.base.BaseWebViewUtil;
import com.alimm.tanx.core.bridge.TanxJsBridge;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxJsBridge implements NotConfused {
    public static final String TAG = "TanxJsBridge";
    public Context context;
    public final WebView webView;
    public Integer uniqueId = 0;
    public HashMap<String, Callback> responseCallbacks = new HashMap<>();
    public HashMap<String, JsHandler> messageHandlers = new HashMap<>();

    public TanxJsBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.addJavascriptInterface(this, "normal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(String str, boolean z10, AbstractMap abstractMap) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("responseId", str);
        hashMap.put("responseData", abstractMap);
        hashMap.put("success", Boolean.valueOf(z10));
        dispatch(hashMap);
    }

    private void dispatch(HashMap<String, Object> hashMap) {
        boolean z10 = true;
        final String format = String.format("MamaBridge.handleMessageFromNative('%s');", new JSONObject(hashMap).toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace(StringUtils.CR, "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029"));
        try {
            try {
                if (!BaseWebViewUtil.tanxc_if(this.webView)) {
                    this.webView.post(new Runnable() { // from class: v.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            TanxJsBridge.this.dexa(format);
                        }
                    });
                } else {
                    LogUtils.e(TAG, "webView已经回收，无法分发数据，终止！！！！");
                    z10 = false;
                }
                if (z10) {
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, e2);
            }
        } finally {
            LogUtils.e(TAG, "jsBridge dispatch failed");
        }
    }

    private void flush(String str) {
        Callback callback;
        if (str == null) {
            System.out.println("Javascript give data is null");
            return;
        }
        HashMap hashMap = (HashMap) JSON.parseObject(str, HashMap.class);
        final String str2 = (String) hashMap.get("callbackId");
        if (str2 != null) {
            callback = new Callback() { // from class: v.a
                @Override // com.alimm.tanx.core.bridge.Callback
                public final void call(boolean z10, AbstractMap abstractMap) {
                    TanxJsBridge.this.dexa(str2, z10, abstractMap);
                }
            };
        } else {
            callback = new Callback() { // from class: v.b
                @Override // com.alimm.tanx.core.bridge.Callback
                public final void call(boolean z10, AbstractMap abstractMap) {
                    LogUtils.d(TanxJsBridge.TAG, "callbackID is empty");
                }
            };
        }
        LogUtils.d(TAG, str);
        String str3 = (String) hashMap.get("handlerName");
        JSONObject jSONObject = (JSONObject) hashMap.get("data");
        JsHandler jsHandler = this.messageHandlers.get(str3);
        if (jsHandler == null) {
            LogUtils.d(TAG, "jsHandler is null");
            callback.call(false, null);
            return;
        }
        try {
            HashMap hashMap2 = new HashMap();
            if (jSONObject != null) {
                for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            jsHandler.handler(hashMap2, callback);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String getFromAssets(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void call(String str, HashMap<String, String> hashMap, Callback callback) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("handlerName", str);
        if (hashMap != null) {
            hashMap2.put("data", hashMap);
        }
        if (callback != null) {
            this.uniqueId = Integer.valueOf(this.uniqueId.intValue() + 1);
            String str2 = "native_cb_" + ((Object) this.uniqueId);
            this.responseCallbacks.put(str2, callback);
            hashMap2.put("callbackId", str2);
        }
        dispatch(hashMap2);
    }

    public void injectJavascript() {
        String fromAssets = getFromAssets(this.context, "mama.js");
        this.webView.loadUrl(bh.f3176j + fromAssets);
    }

    public void postEvent(String str, Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("eventName", str);
        hashMap.put("eventData", map);
        dispatch(hashMap);
    }

    @JavascriptInterface
    public void postMessage(String str) {
        flush(str);
    }

    public void ready() {
        this.webView.loadUrl("javascript:onMamaBridgeReady()");
    }

    public void register(String str, JsHandler jsHandler) {
        this.messageHandlers.put(str, jsHandler);
    }

    public void remove(String str) {
        this.messageHandlers.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(String str) {
        this.webView.evaluateJavascript(str, null);
    }
}
