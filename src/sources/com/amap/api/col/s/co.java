package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.inno.innosdk.pb.InnoMain;
import org.json.JSONObject;

/* compiled from: AAIDRemapRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class co extends cq {

    /* renamed from: a, reason: collision with root package name */
    public String f7561a;

    /* renamed from: b, reason: collision with root package name */
    public String f7562b;

    /* renamed from: c, reason: collision with root package name */
    public String f7563c;

    /* renamed from: d, reason: collision with root package name */
    public String f7564d;

    /* renamed from: e, reason: collision with root package name */
    public String f7565e;

    /* renamed from: f, reason: collision with root package name */
    public String f7566f;

    /* renamed from: g, reason: collision with root package name */
    public String f7567g;

    /* renamed from: h, reason: collision with root package name */
    public String f7568h;

    /* renamed from: i, reason: collision with root package name */
    public String f7569i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f7570j;

    public co(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        byte[] bArr = this.f7570j;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", bw.c(this.f7576k));
            jSONObject.put(com.baidu.mobads.sdk.internal.bk.f9900i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a10 = cm.a();
            this.f7561a = a10;
            jSONObject.put("t1", a10);
            jSONObject.put("old_t1", cj.g(this.f7576k));
            String b4 = cm.b();
            this.f7562b = b4;
            jSONObject.put("t2", b4);
            jSONObject.put("old_t2", cj.h(this.f7576k));
            String c4 = cm.c();
            this.f7563c = c4;
            jSONObject.put("t3", c4);
            jSONObject.put("old_t3", cj.i(this.f7576k));
            String d10 = cm.d();
            this.f7564d = d10;
            jSONObject.put("s1", d10);
            jSONObject.put("old_s1", cj.j(this.f7576k));
            String e2 = cm.e();
            this.f7565e = e2;
            jSONObject.put("s2", e2);
            jSONObject.put("old_s2", cj.k(this.f7576k));
            String f10 = cm.f();
            this.f7566f = f10;
            jSONObject.put("s3", f10);
            jSONObject.put("old_s3", cj.l(this.f7576k));
            String g3 = cm.g();
            this.f7567g = g3;
            jSONObject.put("s4", g3);
            jSONObject.put("old_s4", cj.m(this.f7576k));
            jSONObject.put(Constant.MAP_KEY_UUID, cm.a(this.f7576k));
            jSONObject.put("android_id", ca.g());
            jSONObject.put("hostname", cm.h());
            String o10 = ca.o(this.f7576k);
            this.f7568h = o10;
            jSONObject.put("gaid", o10);
            jSONObject.put("old_gaid", cj.n(this.f7576k));
            String e10 = ca.e(this.f7576k);
            this.f7569i = e10;
            jSONObject.put(InnoMain.INNO_KEY_OAID, e10);
            jSONObject.put("old_oaid", cj.b(this.f7576k));
            jSONObject.put("aaid", cj.c(this.f7576k));
            jSONObject.put("resetToken", cj.f(this.f7576k));
            jSONObject.put("uabc", cj.e(this.f7576k));
            this.f7570j = cm.a(ci.d(jSONObject.toString().getBytes("utf-8")), ci.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f7570j;
    }
}
