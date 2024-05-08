package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private WebView NY;
    private final Map<String, com.kwad.sdk.core.webview.c.a> Vt = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a Vu = new d();
    private boolean Vv;

    public a(WebView webView) {
        this.NY = webView;
        sa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2) {
        if (this.Vv) {
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback is empty");
                return;
            }
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.NY;
            if (webView == null) {
                return;
            }
            bt.a(webView, str, str2);
        }
    }

    private void sa() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new z());
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (!TextUtils.isEmpty(aVar.getKey())) {
            this.Vt.put(aVar.getKey(), aVar);
        } else {
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.webview.c.c cVar;
        com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.Vt.get(bVar.aEC);
            if (aVar == null) {
                aVar = this.Vu;
            }
            WebView webView = this.NY;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aEC, bVar.data);
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(bVar.aED)) {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            a.this.n(bVar.aED, new f(bVar2).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i10, String str2) {
                            a.this.n(bVar.aED, new e(i10, str2).toJson().toString());
                        }
                    };
                } else {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i10, String str2) {
                        }
                    };
                }
                aVar.a(bVar.data, cVar);
                return;
            }
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "bridgeHandler is null");
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "callAdBridge JSONException:" + ((Object) e2));
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.e.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> iterator2 = this.Vt.entrySet().iterator2();
        while (iterator2.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = iterator2.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.Vv = true;
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.getKey())) {
            if (this.Vt.containsKey(aVar.getKey())) {
                com.kwad.sdk.core.e.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
            }
            this.Vt.put(aVar.getKey(), aVar);
            return;
        }
        com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
    }
}
