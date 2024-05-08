package com.alibaba.security.realidentity.jsbridge.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.bg;
import com.alibaba.security.realidentity.build.bh;
import com.alibaba.security.realidentity.build.bi;
import com.alibaba.security.realidentity.build.bj;
import com.alibaba.security.realidentity.build.bk;
import com.alibaba.security.realidentity.build.bl;
import com.alibaba.security.realidentity.build.bm;
import com.alibaba.security.realidentity.build.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BridgeWebView extends WebView implements bm {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4034a = "WebViewJavaScriptBridge.js";

    /* renamed from: b, reason: collision with root package name */
    public Map<String, bj> f4035b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, bg> f4036c;

    /* renamed from: d, reason: collision with root package name */
    public bg f4037d;

    /* renamed from: e, reason: collision with root package name */
    private final String f4038e;

    /* renamed from: f, reason: collision with root package name */
    private List<bl> f4039f;

    /* renamed from: g, reason: collision with root package name */
    private long f4040g;

    /* renamed from: com.alibaba.security.realidentity.jsbridge.core.BridgeWebView$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 implements bj {
        public AnonymousClass2() {
        }

        @Override // com.alibaba.security.realidentity.build.bj
        public final void a(String str) {
            bj bjVar;
            bg bgVar;
            try {
                List<bl> a10 = bl.a(str);
                if (a10.size() == 0) {
                    return;
                }
                for (int i10 = 0; i10 < a10.size(); i10++) {
                    bl blVar = a10.get(i10);
                    String str2 = blVar.f3192b;
                    if (!TextUtils.isEmpty(str2)) {
                        BridgeWebView.this.f4035b.get(str2).a(blVar.f3193c);
                        BridgeWebView.this.f4035b.remove(str2);
                    } else {
                        final String str3 = blVar.f3191a;
                        if (!TextUtils.isEmpty(str3)) {
                            bjVar = new bj() { // from class: com.alibaba.security.realidentity.jsbridge.core.BridgeWebView.2.1
                                @Override // com.alibaba.security.realidentity.build.bj
                                public final void a(String str4) {
                                    bl blVar2 = new bl();
                                    blVar2.f3192b = str3;
                                    blVar2.f3193c = str4;
                                    BridgeWebView.this.b(blVar2);
                                }
                            };
                        } else {
                            bjVar = new bj() { // from class: com.alibaba.security.realidentity.jsbridge.core.BridgeWebView.2.2
                                @Override // com.alibaba.security.realidentity.build.bj
                                public final void a(String str4) {
                                }
                            };
                        }
                        if (!TextUtils.isEmpty(blVar.f3195e)) {
                            bgVar = BridgeWebView.this.f4036c.get(blVar.f3195e);
                        } else {
                            bgVar = BridgeWebView.this.f4037d;
                        }
                        if (bgVar != null) {
                            bgVar.a(blVar.f3194d, bjVar);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                j.a.f3944a.a(TrackLog.createSimpleSdk("BridgeWebView", "toArrayList", str));
            }
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4038e = "BridgeWebView";
        this.f4035b = new HashMap();
        this.f4036c = new HashMap();
        this.f4039f = new ArrayList();
        this.f4040g = 0L;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bl blVar) {
        List<bl> list = this.f4039f;
        if (list != null) {
            list.add(blVar);
        } else {
            a(blVar);
        }
    }

    @Override // com.alibaba.security.realidentity.build.bm
    public final void c(String str) {
        a(null, str, null);
    }

    public List<bl> getStartupMessage() {
        return this.f4039f;
    }

    @JavascriptInterface
    public void returnData(String str) {
        a(str);
    }

    public void setDefaultHandler(bg bgVar) {
        this.f4037d = bgVar;
    }

    public void setStartupMessage(List<bl> list) {
        this.f4039f = list;
    }

    private void a(Context context) {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(a());
        addJavascriptInterface(this, "androidJS");
        getSettings().setJavaScriptEnabled(true);
        this.f4037d = new bk(context, this);
    }

    private void b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(bh.f3175i, new AnonymousClass2());
        }
    }

    private void b(String str, String str2, bj bjVar) {
        a(str, str2, bjVar);
    }

    @Override // com.alibaba.security.realidentity.build.bm
    public final void b(String str) {
        a(null, str, null);
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4038e = "BridgeWebView";
        this.f4035b = new HashMap();
        this.f4036c = new HashMap();
        this.f4039f = new ArrayList();
        this.f4040g = 0L;
        a(context);
    }

    private bi a() {
        return new bi(this);
    }

    public final void a(String str) {
        String c4 = bh.c(str);
        bj bjVar = this.f4035b.get(c4);
        String b4 = bh.b(str);
        if (bjVar != null) {
            bjVar.a(b4);
            this.f4035b.remove(c4);
        }
    }

    public BridgeWebView(Context context) {
        super(context);
        this.f4038e = "BridgeWebView";
        this.f4035b = new HashMap();
        this.f4036c = new HashMap();
        this.f4039f = new ArrayList();
        this.f4040g = 0L;
        a(context);
    }

    public final void a(String str, String str2, bj bjVar) {
        bl blVar = new bl();
        if (!TextUtils.isEmpty(str2)) {
            blVar.f3194d = str2;
        }
        if (bjVar != null) {
            StringBuilder sb2 = new StringBuilder();
            long j10 = this.f4040g + 1;
            this.f4040g = j10;
            sb2.append(j10);
            sb2.append("_");
            sb2.append(SystemClock.currentThreadTimeMillis());
            String format = String.format(bh.f3173g, sb2.toString());
            this.f4035b.put(format, bjVar);
            blVar.f3191a = format;
        }
        if (!TextUtils.isEmpty(str)) {
            blVar.f3195e = str;
        }
        b(blVar);
    }

    public final void a(bl blVar) {
        final String format = String.format(bh.f3174h, blVar.a().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\""));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(format);
        } else {
            post(new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.core.BridgeWebView.1
                @Override // java.lang.Runnable
                public final void run() {
                    BridgeWebView.this.loadUrl(format);
                }
            });
        }
    }

    public final void a(String str, bj bjVar) {
        loadUrl(str);
        this.f4035b.put(bh.a(str), bjVar);
    }

    private void a(String str, bg bgVar) {
        if (bgVar != null) {
            this.f4036c.put(str, bgVar);
        }
    }
}
