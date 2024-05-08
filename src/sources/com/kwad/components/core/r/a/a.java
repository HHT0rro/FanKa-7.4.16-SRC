package com.kwad.components.core.r.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.components.core.l.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> SH = new ConcurrentHashMap();
    private static final AtomicInteger SI = new AtomicInteger(1);
    private StyleTemplate SA;
    private String SB;
    private boolean SC;
    private l SD;
    private k SE;
    private com.kwad.components.core.r.b.b SF;
    private int SG;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public static void a(int i10, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = SH;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i10));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i10), map);
        }
        map.put(str, obj);
    }

    private static void aK(int i10) {
        Map<String, Object> map = SH.get(Integer.valueOf(i10));
        if (map != null) {
            map.clear();
        }
    }

    private Object ay(String str) {
        return m(this.SG, str);
    }

    private static Object m(int i10, String str) {
        Map<String, Object> map = SH.get(Integer.valueOf(i10));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.b
    /* renamed from: qQ, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.d(this.mAdResultData);
        bVar.SA = this.SA;
        bVar.mRootContainer = this.mRootContainer;
        bVar.SD = this.SD;
        bVar.SE = this.SE;
        return bVar;
    }

    public static int qR() {
        return SI.incrementAndGet();
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        this.SG = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) ay("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.SA = styleTemplate;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (kVar != null) {
            this.SE = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d10 = f.mE().d(intExtra, true);
        this.mAdResultData = d10;
        return intExtra <= 0 || d10 != null;
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.SC = getIntent().getBooleanExtra("show_navigationBar", true);
        this.SB = getIntent().getStringExtra("title");
        this.SD = (l) ay("native_intent");
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.SC && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0450a() { // from class: com.kwad.components.core.r.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0450a
            public final void u(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0450a
            public final void v(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.SB));
        this.mTitleBarHelper.ah(false);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.r.b.b bVar = this.SF;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        if (this.SA != null) {
            return new com.kwad.components.core.r.b.a();
        }
        if (this.SF == null) {
            this.SF = new com.kwad.components.core.r.b.b();
        }
        return this.SF;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            aK(this.SG);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
