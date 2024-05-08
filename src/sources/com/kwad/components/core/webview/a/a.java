package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private com.kwad.components.core.e.d.c Kz;
    private WebView NY;
    private KsAppDownloadListener VG;
    private int VH = -100;
    private int VI = 0;
    private boolean Vv;
    private com.kwad.sdk.core.webview.b cO;
    private AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0480a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.NY = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.cO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str) {
        try {
            C0480a c0480a = new C0480a();
            c0480a.parseJson(new JSONObject(str));
            if (p(c0480a.url, c0480a.packageName)) {
                return;
            }
            if (this.Kz == null) {
                o(c0480a.url, c0480a.packageName);
            }
            a.C0461a ar2 = new a.C0461a(this.cO.NY.getContext()).ao(true).ap(false).aq(this.mAdTemplate).ar(false);
            if (this.Kz.s(ar2)) {
                return;
            }
            this.Kz.d(this.VG);
            this.Kz.r(ar2);
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    private void n(String str, String str2) {
        WebView webView;
        if (this.Vv || TextUtils.isEmpty(str) || (webView = this.NY) == null) {
            return;
        }
        bt.a(webView, str, str2);
    }

    private synchronized void o(String str, String str2) {
        this.Kz = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.VG == null) {
            KsAppDownloadListener sm = sm();
            this.VG = sm;
            this.Kz.b(sm);
        }
    }

    private static boolean p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener sm() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.p(4, i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                if (i10 == 0) {
                    a.this.p(1, 0);
                } else {
                    a.this.p(2, i10);
                }
            }
        };
    }

    public final void destroy() {
        this.Vv = true;
        com.kwad.components.core.e.d.c cVar = this.Kz;
        if (cVar != null) {
            cVar.c(this.VG);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.Kz == null) {
            o(str, str2);
        }
        return this.Kz.nW();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.Kz == null) {
            o(str, str2);
        }
        return this.VI;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aG(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i10, int i11) {
        this.VI = i11;
        if (this.VH != i10) {
            this.VH = i10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            n("onDownLoadStatusCallback", sb2.toString());
        }
    }
}
