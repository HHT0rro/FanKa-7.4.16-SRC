package com.cupidapp.live.base.web;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.security.realidentity.build.bh;
import com.cupidapp.live.base.activity.g;
import com.cupidapp.live.base.activity.h;
import com.cupidapp.live.base.activity.i;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.LoadType;
import com.cupidapp.live.base.web.b;
import com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper;
import com.cupidapp.live.base.web.helper.WebUrlWhiteListHelper;
import j1.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKWebView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWebView extends WebView implements LifecycleObserver, com.cupidapp.live.base.activity.b, g {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f13022l = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.web.b f13023b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public c f13024c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b.a f13025d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13026e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13027f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f13028g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f13029h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public b f13030i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Long f13031j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13032k;

    /* compiled from: FKWebView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context b(Context context) {
            if (!(Build.VERSION.SDK_INT < 23)) {
                return context;
            }
            Context createConfigurationContext = context.createConfigurationContext(new Configuration());
            s.h(createConfigurationContext, "context.createConfigurat…nContext(Configuration())");
            return createConfigurationContext;
        }
    }

    /* compiled from: FKWebView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(boolean z10);
    }

    /* compiled from: FKWebView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        void s0(@Nullable String str);
    }

    /* compiled from: FKWebView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f13034b;

        public d(j jVar) {
            this.f13034b = jVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            Long l10;
            super.onPageFinished(webView, str);
            if (!FKWebView.this.f13027f) {
                b bVar = FKWebView.this.f13030i;
                if (bVar != null) {
                    bVar.a(true);
                }
                if (FKWebView.this.f13031j != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Long l11 = FKWebView.this.f13031j;
                    s.f(l11);
                    l10 = Long.valueOf(currentTimeMillis - l11.longValue());
                } else {
                    l10 = null;
                }
                p pVar = p.f50243a;
                String trackId = FKWebView.this.getTrackId();
                s.h(trackId, "trackId");
                p.b(pVar, trackId, FKWebView.this.f13029h, str, LoadType.LOAD_COMPLETE, null, l10, 16, null);
            }
            FKWebView.this.f13027f = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
            FKWebView.this.getMH5CallNativeHelper().c();
            super.onPageStarted(webView, str, bitmap);
            c cVar = FKWebView.this.f13024c;
            if (cVar != null) {
                cVar.s0(str);
            }
            p pVar = p.f50243a;
            String trackId = FKWebView.this.getTrackId();
            s.h(trackId, "trackId");
            p.b(pVar, trackId, FKWebView.this.f13029h, str, LoadType.START_LOAD, null, null, 48, null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            CharSequence description;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            FKWebView.this.f13027f = true;
            b bVar = FKWebView.this.f13030i;
            if (bVar != null) {
                bVar.a(false);
            }
            Long l10 = null;
            String obj = (Build.VERSION.SDK_INT < 23 || webResourceError == null || (description = webResourceError.getDescription()) == null) ? null : description.toString();
            if (FKWebView.this.f13031j != null) {
                long currentTimeMillis = System.currentTimeMillis();
                Long l11 = FKWebView.this.f13031j;
                s.f(l11);
                l10 = Long.valueOf(currentTimeMillis - l11.longValue());
            }
            p pVar = p.f50243a;
            String trackId = FKWebView.this.getTrackId();
            s.h(trackId, "trackId");
            pVar.a(trackId, FKWebView.this.f13029h, FKWebView.this.getUrl(), LoadType.LOAD_FAIL, obj, l10);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
            WebView.HitTestResult hitTestResult = webView != null ? webView.getHitTestResult() : null;
            if (hitTestResult != null && hitTestResult.getType() != 0) {
                p pVar = p.f50243a;
                String trackId = FKWebView.this.getTrackId();
                s.h(trackId, "trackId");
                p.b(pVar, trackId, FKWebView.this.f13029h, str, LoadType.START_LOAD, null, null, 48, null);
            } else if (s.d(Uri.parse(str).getScheme(), "finka2020")) {
                p pVar2 = p.f50243a;
                String trackId2 = FKWebView.this.getTrackId();
                s.h(trackId2, "trackId");
                p.b(pVar2, trackId2, FKWebView.this.f13029h, str, LoadType.START_LOAD, null, null, 48, null);
            } else {
                p pVar3 = p.f50243a;
                String trackId3 = FKWebView.this.getTrackId();
                s.h(trackId3, "trackId");
                p.b(pVar3, trackId3, FKWebView.this.f13029h, str, LoadType.REDIRECT, null, null, 48, null);
            }
            if (!FKWebView.this.o(str)) {
                return false;
            }
            FKWebView.this.z(this.f13034b, str);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebView(@NotNull Context context) {
        super(f13022l.b(context));
        s.i(context, "context");
        this.f13032k = new LinkedHashMap();
        this.f13026e = kotlin.c.b(FKWebView$trackId$2.INSTANCE);
        this.f13028g = kotlin.c.b(FKWebView$mH5CallNativeHelper$2.INSTANCE);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FKH5CallNativeHelper getMH5CallNativeHelper() {
        return (FKH5CallNativeHelper) this.f13028g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTrackId() {
        return (String) this.f13026e.getValue();
    }

    public static /* synthetic */ void w(FKWebView fKWebView, Activity activity, Lifecycle lifecycle, h hVar, i iVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            hVar = null;
        }
        if ((i10 & 8) != 0) {
            iVar = null;
        }
        fKWebView.v(activity, lifecycle, hVar, iVar);
    }

    public static final void y(String str) {
        com.cupidapp.live.base.utils.j.f12332a.a("onNativeCallH5", "resultString = " + str);
    }

    public final boolean A(String str) {
        if (str == null) {
            return false;
        }
        return kotlin.text.p.D(str, "https://", true) || kotlin.text.p.D(str, "http://", true) || kotlin.text.p.D(str, "finka2020://", true);
    }

    @Override // com.cupidapp.live.base.activity.g
    public boolean a() {
        if (!canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    @NotNull
    public final FKH5CallNativeHelper getH5CallNativeHelper() {
        return getMH5CallNativeHelper();
    }

    @Nullable
    public final b.a getLoadProgressListener() {
        return this.f13025d;
    }

    public final String m(String str) {
        if (A(str)) {
            return str;
        }
        return "http://" + str;
    }

    public final boolean o(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return ((kotlin.text.p.D(str, "https://", true) || kotlin.text.p.D(str, "http://", true)) && WebUrlWhiteListHelper.f13094a.d(str)) || kotlin.text.p.D(str, "finka2020://", true) || p(str);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onActivityDestroy() {
        setLoadProgressListener(null);
        this.f13024c = null;
        setWebChromeClient(null);
        com.cupidapp.live.base.web.b bVar = this.f13023b;
        if (bVar != null) {
            bVar.h(null);
        }
        this.f13023b = null;
        destroy();
        removeAllViews();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onActivityPause() {
        b.a d10;
        com.cupidapp.live.base.web.b bVar = this.f13023b;
        if (bVar != null) {
            bVar.f();
        }
        com.cupidapp.live.base.web.b bVar2 = this.f13023b;
        if (bVar2 != null && (d10 = bVar2.d()) != null) {
            d10.a(this, 0, false);
        }
        setWebChromeClient(null);
        onPause();
        pauseTimers();
        com.cupidapp.live.base.web.bridge.b.f13062a.f(this, "onPause");
        setLayerType(1, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        com.cupidapp.live.base.web.b bVar = this.f13023b;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onActivityResume() {
        setLayerType(2, null);
        com.cupidapp.live.base.web.bridge.b.f13062a.f(this, "onResume");
        setWebChromeClient(this.f13023b);
        onResume();
        resumeTimers();
    }

    public final boolean p(String str) {
        return kotlin.text.p.F(str, "alipays://platformapi/startapp?", false, 2, null) || kotlin.text.p.F(str, "alipay://platformapi/startapp?", false, 2, null) || kotlin.text.p.F(str, com.alipay.sdk.cons.a.f4527j, false, 2, null) || kotlin.text.p.F(str, "alipay://platformapi/startApp?", false, 2, null) || kotlin.text.p.F(str, "weixin://wap/pay?", false, 2, null) || kotlin.text.p.F(str, "weixin://biz", false, 2, null) || kotlin.text.p.F(str, "amapuri://route/plan/?", false, 2, null) || kotlin.text.p.F(str, "baidumap://map/direction?", false, 2, null);
    }

    public final void q(@Nullable j jVar) {
        if (jVar == null) {
            return;
        }
        setWebViewClient(new d(jVar));
    }

    public final void r(Activity activity) {
        if (activity != null) {
            com.cupidapp.live.base.web.b bVar = new com.cupidapp.live.base.web.b(activity, null, 2, 0 == true ? 1 : 0);
            this.f13023b = bVar;
            bVar.b(this);
            setWebChromeClient(this.f13023b);
        }
    }

    public final Map<String, String> s(String str) {
        if (WebUrlWhiteListHelper.f13094a.d(str)) {
            return NetworkClient.f11868a.o();
        }
        return new LinkedHashMap();
    }

    public final void setLoadProgressListener(@Nullable b.a aVar) {
        this.f13025d = aVar;
        com.cupidapp.live.base.web.b bVar = this.f13023b;
        if (bVar == null) {
            return;
        }
        bVar.h(aVar);
    }

    public final void setWebLoadStateListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f13030i = listener;
    }

    public final void setWebTitleBarConfigListener(@NotNull c listener) {
        s.i(listener, "listener");
        this.f13024c = listener;
    }

    public final void t() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setNeedInitialFocus(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setTextZoom(100);
        getSettings().setMixedContentMode(2);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " Finka0a/7.4.16");
        getSettings().setCacheMode(-1);
        addJavascriptInterface(getMH5CallNativeHelper(), "AndroidAPP");
    }

    public final void u(@Nullable String str) {
        this.f13031j = Long.valueOf(System.currentTimeMillis());
        com.cupidapp.live.base.utils.j.f12332a.a("AppWebView", "loadUrlWithHeader_url:" + str);
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.f13029h == null) {
            this.f13029h = str;
        }
        String m10 = m(str);
        loadUrl(m10, s(m10));
    }

    public final void v(@Nullable Activity activity, @NotNull Lifecycle lifecycle, @Nullable h hVar, @Nullable i iVar) {
        s.i(lifecycle, "lifecycle");
        r(activity);
        lifecycle.addObserver(this);
        if (hVar != null) {
            hVar.a(this);
        }
        if (iVar != null) {
            iVar.a(this);
        }
    }

    public final void x(@Nullable String str) {
        try {
            com.cupidapp.live.base.utils.j.f12332a.a("onNativeCallH5", "method:nativeCall  json:" + str);
            evaluateJavascript(bh.f3176j + "nativeCall('" + str + "')", new ValueCallback() { // from class: com.cupidapp.live.base.web.d
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    FKWebView.y((String) obj);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void z(j jVar, String str) {
        if (A(str)) {
            if (jVar.d(str, getUrl())) {
                return;
            }
            u(str);
        } else {
            try {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(f13022l.b(context), attributeSet);
        s.i(context, "context");
        this.f13032k = new LinkedHashMap();
        this.f13026e = kotlin.c.b(FKWebView$trackId$2.INSTANCE);
        this.f13028g = kotlin.c.b(FKWebView$mH5CallNativeHelper$2.INSTANCE);
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(f13022l.b(context), attributeSet, i10);
        s.i(context, "context");
        this.f13032k = new LinkedHashMap();
        this.f13026e = kotlin.c.b(FKWebView$trackId$2.INSTANCE);
        this.f13028g = kotlin.c.b(FKWebView$mH5CallNativeHelper$2.INSTANCE);
        t();
    }
}
