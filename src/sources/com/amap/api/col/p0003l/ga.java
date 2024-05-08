package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: AAIDManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ga {

    /* renamed from: a, reason: collision with root package name */
    private static ga f6025a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6026b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f6027c;

    /* renamed from: d, reason: collision with root package name */
    private Context f6028d;

    private ga(Context context) {
        this.f6028d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (f6027c) {
                f6027c = false;
                return;
            }
            f6027c = true;
            gb gbVar = new gb(this.f6028d);
            new hw();
            ie a10 = hw.a(gbVar);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(fv.a(fz.a(a10.f6444a, fv.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    fw.f(this.f6028d, gbVar.f6031a);
                    fw.g(this.f6028d, gbVar.f6032b);
                    fw.h(this.f6028d, gbVar.f6033c);
                    fw.i(this.f6028d, gbVar.f6034d);
                    fw.j(this.f6028d, gbVar.f6035e);
                    fw.k(this.f6028d, gbVar.f6036f);
                    fw.l(this.f6028d, gbVar.f6037g);
                    fw.b(this.f6028d, gbVar.f6039i);
                    fw.m(this.f6028d, gbVar.f6038h);
                    fw.a(this.f6028d, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        fw.c(this.f6028d, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        fw.e(this.f6028d, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        fw.d(this.f6028d, optString3);
                    }
                }
            }
            f6027c = false;
        } catch (Throwable unused) {
            f6027c = false;
        }
    }

    public static ga a(Context context) {
        if (f6025a == null) {
            synchronized (ga.class) {
                if (f6025a == null) {
                    f6025a = new ga(context);
                }
            }
        }
        return f6025a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (f6026b) {
                f6026b = false;
                return;
            }
            f6026b = true;
            fy fyVar = new fy(this.f6028d);
            new hw();
            ie a10 = hw.a(fyVar);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(fv.a(fz.a(a10.f6444a, fv.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    fw.f(this.f6028d, fyVar.f5990a);
                    fw.g(this.f6028d, fyVar.f5991b);
                    fw.h(this.f6028d, fyVar.f5992c);
                    fw.i(this.f6028d, fyVar.f5993d);
                    fw.j(this.f6028d, fyVar.f5994e);
                    fw.k(this.f6028d, fyVar.f5995f);
                    fw.l(this.f6028d, fyVar.f5996g);
                    fw.b(this.f6028d, fyVar.f5998i);
                    fw.m(this.f6028d, fyVar.f5997h);
                    fw.a(this.f6028d, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        fw.c(this.f6028d, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        fw.e(this.f6028d, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        fw.d(this.f6028d, optString3);
                    }
                }
            }
            f6026b = false;
        } catch (Throwable unused) {
            f6026b = false;
        }
    }

    public final String a() {
        String str = "";
        try {
            if (fx.f5989d) {
                str = fw.c(this.f6028d);
                long d10 = fw.d(this.f6028d);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    jd.a().a(new je() { // from class: com.amap.api.col.3l.ga.1
                        @Override // com.amap.api.col.p0003l.je
                        public final void runTask() {
                            ga.this.b();
                        }
                    });
                } else if (elapsedRealtime - d10 > fx.f5987b) {
                    jd.a().a(new je() { // from class: com.amap.api.col.3l.ga.2
                        @Override // com.amap.api.col.p0003l.je
                        public final void runTask() {
                            ga.this.c();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
