package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.util.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class H5PayActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private com.alipay.sdk.widget.g f4360a;

    /* renamed from: b, reason: collision with root package name */
    private String f4361b;

    /* renamed from: c, reason: collision with root package name */
    private String f4362c;

    /* renamed from: d, reason: collision with root package name */
    private String f4363d;

    /* renamed from: e, reason: collision with root package name */
    private String f4364e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4365f;

    /* renamed from: g, reason: collision with root package name */
    private String f4366g;

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.f4378a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.g gVar = this.f4360a;
        if (gVar instanceof com.alipay.sdk.widget.h) {
            gVar.b();
            return;
        }
        if (!gVar.b()) {
            super.onBackPressed();
        }
        j.a(j.c());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url", null);
            this.f4361b = string;
            if (!n.f(string)) {
                finish();
                return;
            }
            this.f4363d = extras.getString("cookie", null);
            this.f4362c = extras.getString("method", null);
            this.f4364e = extras.getString("title", null);
            this.f4366g = extras.getString("version", com.huawei.hms.ads.dynamicloader.b.f29144f);
            this.f4365f = extras.getBoolean("backisexit", false);
            try {
                if ("v2".equals(this.f4366g)) {
                    com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this);
                    setContentView(jVar);
                    jVar.a(this.f4364e, this.f4362c, this.f4365f);
                    jVar.a(this.f4361b);
                    this.f4360a = jVar;
                    return;
                }
                com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this);
                this.f4360a = hVar;
                setContentView(hVar);
                this.f4360a.a(this.f4361b, this.f4363d);
                this.f4360a.a(this.f4361b);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "GetInstalledAppEx", th);
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f4360a.a();
    }
}
