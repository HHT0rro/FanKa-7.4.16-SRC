package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.inno.innosdk.pb.InnoMain;
import org.json.JSONObject;

/* compiled from: AAIDRemapRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gb extends gd {

    /* renamed from: a, reason: collision with root package name */
    public String f6031a;

    /* renamed from: b, reason: collision with root package name */
    public String f6032b;

    /* renamed from: c, reason: collision with root package name */
    public String f6033c;

    /* renamed from: d, reason: collision with root package name */
    public String f6034d;

    /* renamed from: e, reason: collision with root package name */
    public String f6035e;

    /* renamed from: f, reason: collision with root package name */
    public String f6036f;

    /* renamed from: g, reason: collision with root package name */
    public String f6037g;

    /* renamed from: h, reason: collision with root package name */
    public String f6038h;

    /* renamed from: i, reason: collision with root package name */
    public String f6039i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f6040j;

    public gb(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f6040j;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", fj.c(this.f6046k));
            jSONObject.put(bk.f9900i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.6");
            String a10 = fz.a();
            this.f6031a = a10;
            jSONObject.put("t1", a10);
            jSONObject.put("old_t1", fw.g(this.f6046k));
            String b4 = fz.b();
            this.f6032b = b4;
            jSONObject.put("t2", b4);
            jSONObject.put("old_t2", fw.h(this.f6046k));
            String c4 = fz.c();
            this.f6033c = c4;
            jSONObject.put("t3", c4);
            jSONObject.put("old_t3", fw.i(this.f6046k));
            String d10 = fz.d();
            this.f6034d = d10;
            jSONObject.put("s1", d10);
            jSONObject.put("old_s1", fw.j(this.f6046k));
            String e2 = fz.e();
            this.f6035e = e2;
            jSONObject.put("s2", e2);
            jSONObject.put("old_s2", fw.k(this.f6046k));
            String f10 = fz.f();
            this.f6036f = f10;
            jSONObject.put("s3", f10);
            jSONObject.put("old_s3", fw.l(this.f6046k));
            String g3 = fz.g();
            this.f6037g = g3;
            jSONObject.put("s4", g3);
            jSONObject.put("old_s4", fw.m(this.f6046k));
            jSONObject.put(Constant.MAP_KEY_UUID, fz.a(this.f6046k));
            jSONObject.put("android_id", fm.g());
            jSONObject.put("hostname", fz.h());
            String t2 = fm.t(this.f6046k);
            this.f6038h = t2;
            jSONObject.put("gaid", t2);
            jSONObject.put("old_gaid", fw.n(this.f6046k));
            String e10 = fm.e(this.f6046k);
            this.f6039i = e10;
            jSONObject.put(InnoMain.INNO_KEY_OAID, e10);
            jSONObject.put("old_oaid", fw.b(this.f6046k));
            jSONObject.put("aaid", fw.c(this.f6046k));
            jSONObject.put("resetToken", fw.f(this.f6046k));
            jSONObject.put("uabc", fw.e(this.f6046k));
            this.f6040j = fz.a(fv.d(jSONObject.toString().getBytes("utf-8")), fv.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f6040j;
    }
}
