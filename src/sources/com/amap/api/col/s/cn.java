package com.amap.api.col.s;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: AAIDManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    private static cn f7555a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7556b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7557c;

    /* renamed from: d, reason: collision with root package name */
    private Context f7558d;

    private cn(Context context) {
        this.f7558d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (f7557c) {
                f7557c = false;
                return;
            }
            f7557c = true;
            co coVar = new co(this.f7558d);
            new dt();
            ea a10 = dt.a(coVar);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(ci.a(cm.a(a10.f7866a, ci.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    cj.f(this.f7558d, coVar.f7561a);
                    cj.g(this.f7558d, coVar.f7562b);
                    cj.h(this.f7558d, coVar.f7563c);
                    cj.i(this.f7558d, coVar.f7564d);
                    cj.j(this.f7558d, coVar.f7565e);
                    cj.k(this.f7558d, coVar.f7566f);
                    cj.l(this.f7558d, coVar.f7567g);
                    cj.b(this.f7558d, coVar.f7569i);
                    cj.m(this.f7558d, coVar.f7568h);
                    cj.a(this.f7558d, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        cj.c(this.f7558d, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        cj.e(this.f7558d, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        cj.d(this.f7558d, optString3);
                    }
                }
            }
            f7557c = false;
        } catch (Throwable unused) {
            f7557c = false;
        }
    }

    public static cn a(Context context) {
        if (f7555a == null) {
            synchronized (cn.class) {
                if (f7555a == null) {
                    f7555a = new cn(context);
                }
            }
        }
        return f7555a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (f7556b) {
                f7556b = false;
                return;
            }
            f7556b = true;
            cl clVar = new cl(this.f7558d);
            new dt();
            ea a10 = dt.a(clVar);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(ci.a(cm.a(a10.f7866a, ci.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    cj.f(this.f7558d, clVar.f7545a);
                    cj.g(this.f7558d, clVar.f7546b);
                    cj.h(this.f7558d, clVar.f7547c);
                    cj.i(this.f7558d, clVar.f7548d);
                    cj.j(this.f7558d, clVar.f7549e);
                    cj.k(this.f7558d, clVar.f7550f);
                    cj.l(this.f7558d, clVar.f7551g);
                    cj.b(this.f7558d, clVar.f7553i);
                    cj.m(this.f7558d, clVar.f7552h);
                    cj.a(this.f7558d, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        cj.c(this.f7558d, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        cj.e(this.f7558d, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        cj.d(this.f7558d, optString3);
                    }
                }
            }
            f7556b = false;
        } catch (Throwable unused) {
            f7556b = false;
        }
    }

    public final String a() {
        String str = "";
        try {
            if (ck.f7544d) {
                str = cj.c(this.f7558d);
                long d10 = cj.d(this.f7558d);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    ex.a().b(new ey() { // from class: com.amap.api.col.s.cn.1
                        @Override // com.amap.api.col.s.ey
                        public final void a() {
                            cn.this.b();
                        }
                    });
                } else if (elapsedRealtime - d10 > ck.f7542b) {
                    ex.a().b(new ey() { // from class: com.amap.api.col.s.cn.2
                        @Override // com.amap.api.col.s.ey
                        public final void a() {
                            cn.this.c();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
