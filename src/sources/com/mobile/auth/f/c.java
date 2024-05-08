package com.mobile.auth.f;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.f.b;
import com.mobile.auth.n.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private static c f36797a;

    /* renamed from: b, reason: collision with root package name */
    private a f36798b;

    /* renamed from: c, reason: collision with root package name */
    private a f36799c;

    /* renamed from: d, reason: collision with root package name */
    private b f36800d;

    /* renamed from: e, reason: collision with root package name */
    private Context f36801e;

    private c(Context context) {
        this.f36801e = context;
        b();
    }

    public static c a(Context context) {
        if (f36797a == null) {
            synchronized (c.class) {
                if (f36797a == null) {
                    f36797a = new c(context);
                }
            }
        }
        return f36797a;
    }

    private void b() {
        String b4 = k.b("sdk_config_version", "");
        if (TextUtils.isEmpty(b4) || !BuildConfig.CMCC_SDK_VERSION.equals(b4)) {
            b a10 = b.a(true);
            this.f36800d = a10;
            this.f36798b = a10.a();
            if (!TextUtils.isEmpty(b4)) {
                c();
            }
        } else {
            b a11 = b.a(false);
            this.f36800d = a11;
            this.f36798b = a11.b();
        }
        this.f36800d.a(this);
        this.f36799c = this.f36800d.a();
    }

    private void c() {
        com.mobile.auth.n.c.b("UmcConfigManager", "delete localConfig");
        this.f36800d.c();
    }

    public a a() {
        try {
            return this.f36798b.clone();
        } catch (CloneNotSupportedException unused) {
            return this.f36799c;
        }
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        this.f36800d.a(aVar);
    }

    @Override // com.mobile.auth.f.b.a
    public void a(a aVar) {
        this.f36798b = aVar;
    }
}
