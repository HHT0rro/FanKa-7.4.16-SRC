package com.alibaba.security.realidentity.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.UIUtils;
import com.alibaba.security.common.utils.statusbar.StatusBarUtil;
import com.alibaba.security.realidentity.R;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.build.ap;
import com.alibaba.security.realidentity.build.b;
import com.alibaba.security.realidentity.build.d;
import com.alibaba.security.realidentity.build.f;
import com.alibaba.security.realidentity.build.h;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.view.RPTopBar;
import com.alipay.sdk.util.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPWebViewActivity extends RPBaseActivity {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2968b = "RPWebViewActivity";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2969c = "(function() {if(typeof(_windvane_backControl)!=='undefined') return _windvane_backControl(); else return 'false';})()";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2970d = "(function() {if(typeof(window.WebViewJavaScriptBridge)!=='undefined') return 'true'; else return 'false';})()";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2971e = "wvBackClickEvent";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2972f = "rpOnBack";

    /* renamed from: g, reason: collision with root package name */
    private f f2974g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f2975h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2978k;

    /* renamed from: l, reason: collision with root package name */
    private String f2979l;

    /* renamed from: m, reason: collision with root package name */
    private String f2980m;

    /* renamed from: i, reason: collision with root package name */
    private String f2976i = "";

    /* renamed from: j, reason: collision with root package name */
    private boolean f2977j = false;

    /* renamed from: a, reason: collision with root package name */
    public ValueCallback<String> f2973a = new ValueCallback<String>() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.3
        private void a(String str) {
            if (RPTrack.getLastStepTrackMsg() == null) {
                RPTrack.setLastStepTrackMsg(RPWebViewActivity.d(RPWebViewActivity.this));
            }
            if (str == null || !"true".equals(str.replace("\"", "").replace("'", ""))) {
                if (RPWebViewActivity.this.f2974g.i()) {
                    RPWebViewActivity.this.f2974g.h();
                    return;
                }
                b bVar = j.a.f3944a.f3899i;
                if (bVar != null) {
                    bVar.onFinish(RPResult.AUDIT_NOT, "-10500", "执行H5方法失败");
                }
                RPWebViewActivity.this.finish();
                return;
            }
            RPWebViewActivity.this.f2974g.a(j.a.f3944a.e() ? RPWebViewActivity.f2971e : RPWebViewActivity.f2972f);
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            String str2 = str;
            if (RPTrack.getLastStepTrackMsg() == null) {
                RPTrack.setLastStepTrackMsg(RPWebViewActivity.d(RPWebViewActivity.this));
            }
            if (str2 == null || !"true".equals(str2.replace("\"", "").replace("'", ""))) {
                if (RPWebViewActivity.this.f2974g.i()) {
                    RPWebViewActivity.this.f2974g.h();
                    return;
                }
                b bVar = j.a.f3944a.f3899i;
                if (bVar != null) {
                    bVar.onFinish(RPResult.AUDIT_NOT, "-10500", "执行H5方法失败");
                }
                RPWebViewActivity.this.finish();
                return;
            }
            RPWebViewActivity.this.f2974g.a(j.a.f3944a.e() ? RPWebViewActivity.f2971e : RPWebViewActivity.f2972f);
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class LastExitTrackParams implements Serializable {
        private String url;

        private LastExitTrackParams() {
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static /* synthetic */ boolean c(RPWebViewActivity rPWebViewActivity) {
        rPWebViewActivity.f2978k = true;
        return true;
    }

    private static void d() {
        j unused = j.a.f3944a;
        RPTrack.uploadNow();
    }

    private LastExitTrackMsg e() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        LastExitTrackParams lastExitTrackParams = new LastExitTrackParams();
        lastExitTrackParams.setUrl(this.f2974g.d());
        lastExitTrackMsg.setParams(JsonUtils.toJSON(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private LastExitTrackParams f() {
        LastExitTrackParams lastExitTrackParams = new LastExitTrackParams();
        lastExitTrackParams.setUrl(this.f2974g.d());
        return lastExitTrackParams;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.rp_alrealidentity_activity_rph5);
        RPTopBar rPTopBar = (RPTopBar) findViewById(R.id.topBar);
        rPTopBar.setTitle(getString(R.string.title_rp_h5));
        String stringExtra = getIntent().getStringExtra("url");
        this.f2980m = getIntent().getStringExtra("token");
        this.f2975h = (FrameLayout) findViewById(R.id.browser_fragment_layout);
        f a10 = l.a.f3948a.a(this);
        this.f2974g = a10;
        if (a10 == null) {
            finish();
            return;
        }
        View b4 = a10.b();
        if (b4 == null) {
            finish();
            return;
        }
        this.f2974g.e();
        this.f2974g.j();
        rPTopBar.getIvLeftParent().setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RPWebViewActivity.this.f2974g.a(j.a.f3944a.e() ? RPWebViewActivity.f2969c : RPWebViewActivity.f2970d, RPWebViewActivity.this.f2973a);
            }
        });
        this.f2975h.addView(b4);
        String f10 = this.f2974g.f();
        if (TextUtils.isEmpty(f10)) {
            HashMap hashMap = new HashMap();
            hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog("WebView UserAgent is NULL", JsonUtils.toJSON(hashMap), "WebView UserAgent is NULL");
            createSdkExceptionLog.setCode(-1);
            j unused = j.a.f3944a;
            j.a(this.f2980m, createSdkExceptionLog);
        }
        this.f2976i = f10;
        this.f2974g.c(f10 + " " + a.f2995a + "/" + VersionKey.RP_SDK_VERSION);
        this.f2978k = false;
        this.f2974g.a(new h() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.2
            @Override // com.alibaba.security.realidentity.build.h
            public final void a(String str) {
                RPWebViewActivity.this.f2979l = str;
            }

            @Override // com.alibaba.security.realidentity.build.h
            public final void b(String str) {
                if (RPWebViewActivity.this.f2978k || RPWebViewActivity.this.f2974g.a() != 100) {
                    return;
                }
                RPWebViewActivity.a(RPWebViewActivity.this, "onPageFinished", str, "", "", true);
            }

            @Override // com.alibaba.security.realidentity.build.h
            public final void a(final int i10, final String str, final String str2) {
                RPWebViewActivity.c(RPWebViewActivity.this);
                new ap(new ap.a() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.2.1
                    @Override // com.alibaba.security.realidentity.build.ap.a
                    public final void a(Map<String, Boolean> map) {
                        RPWebViewActivity.a(RPWebViewActivity.this, "onReceivedError: " + str, str2, i10, str, map);
                    }
                }).execute(str2);
            }

            @Override // com.alibaba.security.realidentity.build.h
            public final void a(Object obj, Object obj2) {
                RPWebViewActivity rPWebViewActivity = RPWebViewActivity.this;
                RPWebViewActivity.a(rPWebViewActivity, "onReceivedHttpError", rPWebViewActivity.f2974g.c(), JsonUtils.toJSON(obj), JsonUtils.toJSON(obj2), false);
            }

            @Override // com.alibaba.security.realidentity.build.h
            public final void a() {
                RPWebViewActivity rPWebViewActivity = RPWebViewActivity.this;
                RPWebViewActivity.a(rPWebViewActivity, "onReceivedSslError", rPWebViewActivity.f2974g.c(), (String) null, (String) null, false);
            }
        });
        this.f2974g.b(stringExtra);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap2.put("ua", this.f2974g.f());
        TrackLog createSdkWebViewEnterLog = TrackLog.createSdkWebViewEnterLog(JsonUtils.toJSON(hashMap2));
        j unused2 = j.a.f3944a;
        j.a(this.f2980m, createSdkWebViewEnterLog);
        d.a().a("RPPage", "ViewEnter", null, null, null, null);
        UIUtils.setForceDarkAllowed(getWindow().getDecorView(), false);
        RPTrack.setLastStepTrackMsg(null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            f fVar = this.f2974g;
            if (fVar != null) {
                fVar.c(this.f2976i);
                this.f2974g.g();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
            hashMap.put("ua", this.f2974g.f());
            TrackLog createSdkWebViewExitLog = TrackLog.createSdkWebViewExitLog();
            createSdkWebViewExitLog.setParams(JsonUtils.toJSON(hashMap));
            j unused = j.a.f3944a;
            j.a(this.f2980m, createSdkWebViewExitLog);
            j unused2 = j.a.f3944a;
            RPTrack.uploadNow();
        } catch (Throwable th) {
            RPLogging.e(f2968b, th.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.f2974g.a(j.a.f3944a.e() ? f2969c : f2970d, this.f2973a);
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        f fVar = this.f2974g;
        if (fVar != null) {
            fVar.k();
        }
        StatusBarUtil.setStatusBarLightMode(this, -1);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f2977j) {
            return;
        }
        b bVar = j.a.f3944a.f3899i;
        if (bVar != null) {
            bVar.onStart();
        }
        this.f2977j = true;
    }

    private void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("ua", this.f2974g.f());
        TrackLog createSdkWebViewExitLog = TrackLog.createSdkWebViewExitLog();
        createSdkWebViewExitLog.setParams(JsonUtils.toJSON(hashMap));
        j unused = j.a.f3944a;
        j.a(this.f2980m, createSdkWebViewExitLog);
    }

    private void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog("WebView UserAgent is NULL", JsonUtils.toJSON(hashMap), "WebView UserAgent is NULL");
        createSdkExceptionLog.setCode(-1);
        j unused = j.a.f3944a;
        j.a(this.f2980m, createSdkExceptionLog);
    }

    private void a(String str, String str2, String str3, String str4, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("url", str2);
        hashMap.put("ua", this.f2974g.f());
        hashMap.put("request", str3);
        hashMap.put("error", str4);
        TrackLog createSdkWebViewLoadLog = TrackLog.createSdkWebViewLoadLog(str, JsonUtils.toJSON(hashMap), "{\"success\": " + z10 + i.f4738d);
        j unused = j.a.f3944a;
        j.a(this.f2980m, createSdkWebViewLoadLog);
    }

    public static /* synthetic */ LastExitTrackMsg d(RPWebViewActivity rPWebViewActivity) {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        LastExitTrackParams lastExitTrackParams = new LastExitTrackParams();
        lastExitTrackParams.setUrl(rPWebViewActivity.f2974g.d());
        lastExitTrackMsg.setParams(JsonUtils.toJSON(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private void a(String str, String str2, int i10, String str3, Map<String, Boolean> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("url", str2);
        hashMap.put("ips", map);
        hashMap.put("errorCode", String.valueOf(i10));
        hashMap.put("ua", this.f2974g.f());
        hashMap.put("description", str3);
        TrackLog createSdkWebViewErrorLog = TrackLog.createSdkWebViewErrorLog(str, JsonUtils.toJSON(hashMap), "{\"success\": false}");
        createSdkWebViewErrorLog.setCode(-1);
        j unused = j.a.f3944a;
        j.a(this.f2980m, createSdkWebViewErrorLog);
    }

    private void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("ua", this.f2974g.f());
        TrackLog createSdkWebViewEnterLog = TrackLog.createSdkWebViewEnterLog(JsonUtils.toJSON(hashMap));
        j unused = j.a.f3944a;
        j.a(this.f2980m, createSdkWebViewEnterLog);
    }

    private void a(String str) {
        ((RPTopBar) findViewById(R.id.topBar)).setTitle(str);
    }

    public static /* synthetic */ void a(RPWebViewActivity rPWebViewActivity, String str, String str2, String str3, String str4, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("url", str2);
        hashMap.put("ua", rPWebViewActivity.f2974g.f());
        hashMap.put("request", str3);
        hashMap.put("error", str4);
        TrackLog createSdkWebViewLoadLog = TrackLog.createSdkWebViewLoadLog(str, JsonUtils.toJSON(hashMap), "{\"success\": " + z10 + i.f4738d);
        j unused = j.a.f3944a;
        j.a(rPWebViewActivity.f2980m, createSdkWebViewLoadLog);
    }

    public static /* synthetic */ void a(RPWebViewActivity rPWebViewActivity, String str, String str2, int i10, String str3, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(j.a.f3944a.e()));
        hashMap.put("url", str2);
        hashMap.put("ips", map);
        hashMap.put("errorCode", String.valueOf(i10));
        hashMap.put("ua", rPWebViewActivity.f2974g.f());
        hashMap.put("description", str3);
        TrackLog createSdkWebViewErrorLog = TrackLog.createSdkWebViewErrorLog(str, JsonUtils.toJSON(hashMap), "{\"success\": false}");
        createSdkWebViewErrorLog.setCode(-1);
        j unused = j.a.f3944a;
        j.a(rPWebViewActivity.f2980m, createSdkWebViewErrorLog);
    }
}
