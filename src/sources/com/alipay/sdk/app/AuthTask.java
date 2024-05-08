package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AuthTask {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4357a = com.alipay.sdk.util.e.class;

    /* renamed from: b, reason: collision with root package name */
    private Activity f4358b;

    /* renamed from: c, reason: collision with root package name */
    private com.alipay.sdk.widget.a f4359c;

    public AuthTask(Activity activity) {
        this.f4358b = activity;
        com.alipay.sdk.sys.b.a().a(this.f4358b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f4359c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f4777c);
    }

    private void b() {
        com.alipay.sdk.widget.a aVar = this.f4359c;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.widget.a aVar = this.f4359c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public synchronized String auth(String str, boolean z10) {
        String c4;
        Activity activity;
        if (z10) {
            b();
        }
        com.alipay.sdk.sys.b.a().a(this.f4358b, com.alipay.sdk.data.c.b());
        c4 = j.c();
        i.a("");
        try {
            try {
                c4 = a(this.f4358b, str);
                com.alipay.sdk.data.a.g().a(this.f4358b);
                c();
                activity = this.f4358b;
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
                com.alipay.sdk.data.a.g().a(this.f4358b);
                c();
                activity = this.f4358b;
            }
            com.alipay.sdk.app.statistic.a.b(activity, str);
        } finally {
        }
        return c4;
    }

    public synchronized Map<String, String> authV2(String str, boolean z10) {
        return l.a(auth(str, z10));
    }

    private e.a a() {
        return new a(this);
    }

    private String a(Activity activity, String str) {
        String a10 = new com.alipay.sdk.sys.a(this.f4358b).a(str);
        List<a.C0096a> f10 = com.alipay.sdk.data.a.g().f();
        if (!com.alipay.sdk.data.a.g().f4580p || f10 == null) {
            f10 = i.f4411a;
        }
        if (n.b(this.f4358b, f10)) {
            String a11 = new com.alipay.sdk.util.e(activity, a()).a(a10);
            if (!TextUtils.equals(a11, com.alipay.sdk.util.e.f4721a) && !TextUtils.equals(a11, com.alipay.sdk.util.e.f4722b)) {
                return TextUtils.isEmpty(a11) ? j.c() : a11;
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.M, "");
            return b(activity, a10);
        }
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.N, "");
        return b(activity, a10);
    }

    private String b(Activity activity, String str) {
        k kVar;
        b();
        try {
            try {
                try {
                    List<com.alipay.sdk.protocol.b> a10 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(activity, str).c().optJSONObject(com.alipay.sdk.cons.c.f4552c).optJSONObject(com.alipay.sdk.cons.c.f4553d));
                    c();
                    for (int i10 = 0; i10 < a10.size(); i10++) {
                        if (a10.get(i10).b() == com.alipay.sdk.protocol.a.WapPay) {
                            String a11 = a(a10.get(i10));
                            c();
                            return a11;
                        }
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4450t, th);
                }
                c();
                kVar = null;
            } catch (IOException e2) {
                k b4 = k.b(k.NETWORK_ERROR.a());
                com.alipay.sdk.app.statistic.a.a("net", e2);
                c();
                kVar = b4;
            }
            if (kVar == null) {
                kVar = k.b(k.FAILED.a());
            }
            return j.a(kVar.a(), kVar.b(), "");
        } catch (Throwable th2) {
            c();
            throw th2;
        }
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        String[] c4 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c4[0]);
        Intent intent = new Intent(this.f4358b, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        this.f4358b.startActivity(intent);
        Object obj = f4357a;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return j.c();
            }
        }
        String a10 = j.a();
        return TextUtils.isEmpty(a10) ? j.c() : a10;
    }
}
